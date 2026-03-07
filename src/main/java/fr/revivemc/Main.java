package fr.revivemc;

import fr.revivemc.listeners.BreadListener;
import fr.revivemc.commands.PlayeriaCom;
import fr.revivemc.listeners.ConnectListener;
import fr.revivemc.listeners.CreeperListener;
import fr.revivemc.listeners.HealthListener;
import fr.revivemc.ui.PlayeriaScoreboard;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import static fr.revivemc.listeners.BreadListener.nmbrPain;
import static fr.revivemc.listeners.CreeperListener.nmbrCreeper;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Le plugin a démarré avec succès");

        PlayeriaScoreboard scoreboard = new PlayeriaScoreboard(this);

        for (Player player : Bukkit.getOnlinePlayers()) {
            scoreboard.update(player);
        }

        getCommand("playeria").setExecutor(new PlayeriaCom(this, scoreboard));
        getServer().getPluginManager().registerEvents(new BreadListener(this, scoreboard), this);
        getServer().getPluginManager().registerEvents(new ConnectListener(scoreboard), this);
        getServer().getPluginManager().registerEvents(new HealthListener(this, scoreboard), this);
        getServer().getPluginManager().registerEvents(new CreeperListener(scoreboard), this);

        try {
            readAndWrite();
        } catch (IOException e) {
            getLogger().severe("Erreur lors de la lecture du fichier data.yml !");
            e.printStackTrace();
        }
        new BukkitRunnable() {

            @Override
            public void run() {
                try {
                    save();
                    getLogger().info("Auto-save effectué.");
                } catch (IOException e) {
                    getLogger().severe("Erreur lors de l'auto-save !");
                    e.printStackTrace();
                }
            }

        }.runTaskTimer(this, 0L,6000L );
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

    public void createDataFile() {

        File path = getDataFolder();
        File file = new File(path,"data.yml");

        path.mkdirs();
        try {
            file.createNewFile();
        } catch (IOException e) {
            getLogger().severe("Erreur lors de la création du fichier data.yml !");
            e.printStackTrace();
        }
    }

    public void save() throws IOException {

        File path = getDataFolder();
        File file = new File(path,"data.yml");

        // Sécurité au cas où
        if (!file.exists()) {
            createDataFile();
        }
        // Sauvegarde
        YamlConfiguration data = YamlConfiguration.loadConfiguration(file);

        data.set("bread", null);
        data.set("creeper", null);
        for (Map.Entry<UUID, Integer> entry : nmbrPain.entrySet()) {

            UUID uuid = entry.getKey();
            int score = entry.getValue();

            data.set("bread." + uuid, score);
        }
        for (Map.Entry<UUID, Integer> entry : nmbrCreeper.entrySet()) {

            UUID uuid = entry.getKey();
            int score = entry.getValue();

            data.set("creeper." + uuid, score);
        }
        data.save(file);
    }

    public void readAndWrite() throws IOException {

        File path = getDataFolder();
        File file = new File(path,"data.yml");

        // --- Si le fichier n'existe pas → sauvegarder puis lire ---
        if (!file.exists()) {
            createDataFile();
        }

        // --- Lire le fichier YML ---
        YamlConfiguration data = YamlConfiguration.loadConfiguration(file);
        nmbrPain.clear();
        nmbrCreeper.clear();

        if (data.getConfigurationSection("bread") != null) {

            Set<String> key = data.getConfigurationSection("bread").getKeys(false);

            for (String element : key) {
                int score = data.getInt("bread." + element);
                UUID uuid = UUID.fromString(element);
                nmbrPain.put(uuid, score);
            }
        }
        if (data.getConfigurationSection("creeper") != null) {

            Set<String> key = data.getConfigurationSection("creeper").getKeys(false);

            for (String element : key) {
                int score = data.getInt("creeper." + element);
                UUID uuid = UUID.fromString(element);
                nmbrCreeper.put(uuid, score);
            }
        }
    }

    public Map<UUID, Integer> getPain() {
        return nmbrPain;
    }

    public Map<UUID, Integer> getCreeper() {
        return nmbrCreeper;
    }
}
