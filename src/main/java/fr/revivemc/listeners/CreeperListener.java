package fr.revivemc.listeners;

import fr.revivemc.ui.PlayeriaScoreboard;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.HashMap;
import java.util.UUID;

public class CreeperListener implements Listener {

    public static HashMap<UUID, Integer> nmbrCreeper = new HashMap<>();
    private final PlayeriaScoreboard scoreboard;

    public CreeperListener(PlayeriaScoreboard scoreboard) {
        this.scoreboard = scoreboard;
    }

    @EventHandler
    public void onCreeperKill(EntityDeathEvent event) {
        if (event.getEntity() instanceof Creeper) {

            Creeper creeper = (Creeper) event.getEntity();
            Player player = creeper.getKiller();

            if (creeper.getKiller() != null) {
                int ancienScore = nmbrCreeper.getOrDefault(player.getUniqueId(), 0);
                nmbrCreeper.put(player.getUniqueId(), ancienScore + 1);
                scoreboard.update(player);
            }
        }
    }
}
