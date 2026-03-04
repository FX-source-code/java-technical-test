package fr.revivemc.listeners;

import fr.revivemc.ui.PlayeriaScoreboard;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class HealthListener implements Listener {

    private final PlayeriaScoreboard scoreboard;
    private final JavaPlugin plugin;

    public HealthListener(JavaPlugin plugin, PlayeriaScoreboard scoreboard) {
        this.scoreboard = scoreboard;
        this.plugin = plugin;
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Bukkit.getScheduler().runTask(plugin, () -> scoreboard.update((Player) event.getEntity()));
        }
    }

    @EventHandler
    public void onHeal(EntityRegainHealthEvent event) {
        if (event.getEntity() instanceof Player) {
            Bukkit.getScheduler().runTask(plugin, () -> scoreboard.update((Player) event.getEntity()));
        }
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        Bukkit.getScheduler().runTask(plugin, () -> scoreboard.update(event.getPlayer()));
    }
}
