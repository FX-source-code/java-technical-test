package fr.revivemc.ui;

import fr.revivemc.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;


public class PlayeriaScoreboard {

    private final Main plugin;

    public PlayeriaScoreboard(Main plugin) {
        this.plugin = plugin;
    }

    public void update(Player player) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = manager.getNewScoreboard();

        Objective objective = scoreboard.registerNewObjective("playeriaSc", "dummy");

        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName("    §b§lPlayeria    ");


        objective.getScore("-------------------").setScore(4);
        objective.getScore("Pseudo : §f" + player.getName()).setScore(3);
        objective.getScore("Vie : §c" + (int) player.getHealth() + " ❤").setScore(2);
        objective.getScore("Pains : " + plugin.getPain().getOrDefault(player.getUniqueId(), 0)).setScore(1);

        player.setScoreboard(scoreboard);
    }
}
