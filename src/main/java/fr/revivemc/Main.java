package fr.revivemc;

import fr.revivemc.commands.BreadListener;
import fr.revivemc.commands.PlayeriaCom;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.print("Le plugin a démarré avec succès");
        getCommand("playeria").setExecutor(new PlayeriaCom());
        getServer().getPluginManager().registerEvents(new BreadListener(this), this);
    }

    @Override
    public void onDisable() {}

}
