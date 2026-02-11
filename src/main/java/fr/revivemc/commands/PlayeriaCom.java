package fr.revivemc.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class PlayeriaCom implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
//        if (args[1].equals("help")) {
//            commandSender.sendMessage("La liste des commandes disponibles : \n - help");
//        }
//        else {
//            commandSender.sendMessage("§4Mauvaise commande. \n Liste des commandes disponibles avec /playeria : \n - /playeria help");
//        }
        commandSender.sendMessage("BRUH \n s");
        return false;
    }
}
