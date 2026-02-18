package fr.revivemc.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class PlayeriaCom implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        BreadListener breadCount = new BreadListener();

        try {
            if (args[0].equals("help")) {
                commandSender.sendMessage("La liste des commandes disponibles : \n - help");
            }
            else if (args[0].equals("bread")){
                commandSender.sendMessage("Il y a " + breadCount.nmbr_pain + " de pain récolté(s)");
            } else if (args[0].equals("clear")) {
                breadCount.nmbr_pain = 0;
                commandSender.sendMessage("Il y a maintenant " + breadCount.nmbr_pain + " de pain récolté(s)");
            } else {
                commandSender.sendMessage("§4Mauvaise commande. \nListe des commandes disponibles avec /playeria : \n - /playeria help");
            }
        }
        catch (Exception e){
            commandSender.sendMessage("§4Commande mal exécutée. \nFaite /playeria help pour plus d'info");
        }
        return false;
    }
}
