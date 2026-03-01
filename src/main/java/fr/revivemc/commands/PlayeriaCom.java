package fr.revivemc.commands;

import fr.revivemc.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.io.IOException;

import static org.bukkit.Bukkit.getLogger;

public class PlayeriaCom implements CommandExecutor {

    private final Main plugin;

    public PlayeriaCom(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (args.length != 0) {
            switch (args[0]) {
                case "help":
                    commandSender.sendMessage("La liste des commandes disponibles : \n - help\n - bread : voir le nombre de pains craftés\n - clear : reset le compteur de pains à 0");
                    break;
                case "save":
                    try {
                        plugin.save();
                        commandSender.sendMessage("§2Sauvegarde réussie");
                        getLogger().info("Sauvegarde par le joueur.");
                    } catch (IOException e) {
                        commandSender.sendMessage("§4Erreur lors de la sauvegarde du fichier data.yml, voir les logs pour plus de détail !");

                        getLogger().severe("Erreur lors de la sauvegarde du fichier data.yml !");
                        e.printStackTrace();
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
