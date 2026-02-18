package fr.revivemc.commands;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;



public class BreadListener implements Listener {

    public static int nmbr_pain = 0;

    @EventHandler
    public void onPickup(PlayerPickupItemEvent event) {

        if (event.getItem().getItemStack().getType() == Material.BREAD) {
            nmbr_pain += event.getItem().getItemStack().getAmount();


        }

    }
}
