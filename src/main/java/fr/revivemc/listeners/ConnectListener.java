package fr.revivemc.listeners;

import fr.revivemc.ui.PlayeriaScoreboard;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

public class ConnectListener implements Listener {

    private final PlayeriaScoreboard scoreboard;

    public ConnectListener(PlayeriaScoreboard scoreboard) {
        this.scoreboard = scoreboard;
    }

    @EventHandler
    public void onConnection(PlayerJoinEvent event) {
        scoreboard.update(event.getPlayer());
    }
}
