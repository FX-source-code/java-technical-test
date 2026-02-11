package fr.revivemc;

import fr.revivemc.commands.PlayeriaCom;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.print("Le plugin a démarré avec succès");
        getCommand("playeria").setExecutor(new PlayeriaCom());
    }

    @Override
    public void onDisable() {}

}
