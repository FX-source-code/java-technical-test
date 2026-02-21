package fr.revivemc;

import fr.revivemc.commands.BreadListener;
import fr.revivemc.commands.PlayeriaCom;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.print("Le plugin a démarré avec succès");
        getCommand("playeria").setExecutor(new PlayeriaCom());
        getServer().getPluginManager().registerEvents(new BreadListener(this), this);

        //----------  SAUVEGARDE  ----------
        File path = getDataFolder();
        File file = new File(path,"data.yml");

        path.mkdirs();
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public void onDisable() {}

}
