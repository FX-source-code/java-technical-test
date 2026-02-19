package fr.revivemc.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;


public class BreadListener implements Listener {


    private final JavaPlugin pluginInstance;
    public BreadListener(JavaPlugin pluginInstance){
        this.pluginInstance = pluginInstance;
    }


    public static int nmbrPain = 0;

    @EventHandler
    public void onCraft(CraftItemEvent event) {
        if (event.getWhoClicked() instanceof Player) {

            Player player = (Player) event.getWhoClicked();

            if (event.getCurrentItem() != null && event.getCurrentItem().getType() == Material.BREAD) {
                // Shift click traité séparément
                if (event.isShiftClick()) {
                    int nmbrPainAvant = 0;

                    for (ItemStack item : player.getInventory().getContents()) {
                        if (item != null) {
                            if (item.getType() == Material.BREAD) {
                                nmbrPainAvant += item.getAmount();
                            }
                        }
                    }

                    final int finalPainAvant = nmbrPainAvant;

                    // fait le craft puis compte les objets dans l'inv après
                    Bukkit.getScheduler().runTask(pluginInstance, () -> {

                        int nmbrPainApres = 0;

                        for (ItemStack item : player.getInventory().getContents()) {
                            if (item != null) {
                                if (item.getType() == Material.BREAD) {
                                    nmbrPainApres += item.getAmount();
                                }
                            }
                        }
                        nmbrPain += nmbrPainApres - finalPainAvant;

                    });

                } else {
                    nmbrPain += event.getCurrentItem().getAmount();
                }
            }
        }
    }
}