package fr.revivemc;

import fr.revivemc.commands.BreadListener;
import fr.revivemc.commands.PlayeriaCom;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import static fr.revivemc.commands.BreadListener.nmbrPain;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.print("Le plugin a démarré avec succès");
        getCommand("playeria").setExecutor(new PlayeriaCom());
        getServer().getPluginManager().registerEvents(new BreadListener(this), this);
    }

    @Override
    public void onDisable() {
        try {
            save();
        } catch (IOException e) {
            getLogger().severe("Erreur lors de la sauvegarde du fichier data.yml !");
            e.printStackTrace();
        }
    }

    public void save() throws IOException {
        /*--------------------  SAUVEGARDE  --------------------- */

        File path = getDataFolder();
        File file = new File(path,"data.yml");

        // Sécurité au cas où
        path.mkdirs();
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        // Sauvegarde
        YamlConfiguration data = YamlConfiguration.loadConfiguration(file);

        for (Map.Entry<UUID, Integer> entry : nmbrPain.entrySet()) {

            UUID uuid = entry.getKey();
            int score = entry.getValue();

            data.set("bread." + uuid, score);
        }
        data.save(file);
    }
}
