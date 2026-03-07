package fr.revivemc.commands;

import fr.revivemc.Main;
import fr.revivemc.ui.PlayeriaScoreboard;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

import static fr.revivemc.listeners.BreadListener.nmbrPain;
import static fr.revivemc.listeners.CreeperListener.nmbrCreeper;
import static org.bukkit.Bukkit.getLogger;

public class PlayeriaCom implements CommandExecutor {

    private final Main plugin;
    private final PlayeriaScoreboard scoreboard;

    public PlayeriaCom(Main plugin, PlayeriaScoreboard scoreboard) {
        this.plugin = plugin;
        this.scoreboard = scoreboard;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (args.length != 0) {
            switch (args[0]) {
                case "help":
                    commandSender.sendMessage("§6===== Playeria Commands =====");
                    commandSender.sendMessage("§e/playeria help §7- affiche les commandes");
                    commandSender.sendMessage("§e/playeria save §7- sauvegarde les données");
                    commandSender.sendMessage("§e/playeria clear bread §7- reset le compteur de pains pour tous les joueurs");
                    commandSender.sendMessage("§e/playeria clear creeper §7- reset le compteur de creepers pour tous les joueurs");
                    commandSender.sendMessage("§e/playeria clear all §7- reset le compteur de creepers et de pains pour tous les joueurs");
                    break;
                case "save":
                    try {
                        plugin.save();
                        commandSender.sendMessage("§2Sauvegarde réussie");
                        if (commandSender instanceof Player) {
                            getLogger().info("Sauvegarde demandée par " + commandSender.getName());
                        }
                    } catch (IOException e) {
                        commandSender.sendMessage("§4Erreur lors de la sauvegarde du fichier data.yml, voir les logs pour plus de détail !");

                        getLogger().severe("Erreur lors de la sauvegarde du fichier data.yml !");
                        e.printStackTrace();
                    }
                    break;
                case "clear" :
                    if (args.length >= 2)  {
                        switch (args[1]){
                            case "bread" :
                                nmbrPain.clear();
                                for (Player player : Bukkit.getOnlinePlayers()) {
                                    scoreboard.update(player);
                                }
                                commandSender.sendMessage("§2Le compteur de pains a été reset pour tous les joueurs !");

                                break;
                            case "creeper" :
                                nmbrCreeper.clear();
                                for (Player player : Bukkit.getOnlinePlayers()) {
                                    scoreboard.update(player);
                                }
                                commandSender.sendMessage("§2Le compteur de creepers a été reset pour tous les joueurs !");
                                break;
                            case "all":
                                nmbrPain.clear();
                                nmbrCreeper.clear();
                                for (Player player : Bukkit.getOnlinePlayers()) {
                                    scoreboard.update(player);
                                }
                                commandSender.sendMessage("§2Toutes les stats ont été reset pour tous les joueurs !");
                                break;
                            default:
                                commandSender.sendMessage("§4Mauvaise commande. \nListe des commandes disponibles avec /playeria : \n - /playeria help");
                                break;
                        }
                    } else {
                        commandSender.sendMessage("§4Commande mal exécutée. \nFaite /playeria help pour plus d'info");
                    }
                    break;
                default:
                    commandSender.sendMessage("§4Mauvaise commande. \nListe des commandes disponibles avec /playeria : \n - /playeria help");
                    break;
            }
        } else {
            commandSender.sendMessage("§4Commande mal exécutée. \nFaite /playeria help pour plus d'info");
        }
        return true;
    }
}
