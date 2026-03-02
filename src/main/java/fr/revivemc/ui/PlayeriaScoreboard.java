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
        objective.setDisplayName(" §b§lPlayeria");

        Score pain = objective.getScore("Pains : " + plugin.getPain().getOrDefault(player.getUniqueId(), 0));
        pain.setScore(1);

        player.setScoreboard(scoreboard);
    }
}
