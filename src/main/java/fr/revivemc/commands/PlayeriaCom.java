package fr.revivemc.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class PlayeriaCom implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        try {
            if (args[0].equals("help")) {
                commandSender.sendMessage("La liste des commandes disponibles : \n - help");
            } else {
                commandSender.sendMessage("§4Mauvaise commande. \nListe des commandes disponibles avec /playeria : \n - /playeria help");
            }
        } catch (Exception e){
            commandSender.sendMessage("§4Commande mal exécutée. \nFaite /playeria help pour plus d'info");
        }
        return false;
    }
}
