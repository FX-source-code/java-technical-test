package fr.revivemc.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class PlayeriaCom implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (args.length != 0) {
            switch (args[0]) {
                case "help":
                    commandSender.sendMessage("La liste des commandes disponibles : \n - help\n - bread : voir le nombre de pains craftés\n - clear : reset le compteur de pains à 0");
                    break;
                case "bread":
                    commandSender.sendMessage("Il y a " + BreadListener.nmbrPain + " de pain récolté(s)");
                    break;
                case "clear":
                    BreadListener.nmbrPain = 0;
                    commandSender.sendMessage("Il y a maintenant " + BreadListener.nmbrPain + " de pain récolté(s)");
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
