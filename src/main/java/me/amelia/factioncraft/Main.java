package me.amelia.factioncraft;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {}

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onCraftItem(CraftItemEvent event) {
        Player player = (Player) event.getWhoClicked();

        ItemStack itemStack = event.getRecipe().getResult();

        if (itemStack.equals(new ItemStack(Material.HOPPER, itemStack.getAmount())) || itemStack.equals(new ItemStack(Material.GOLDEN_APPLE, itemStack.getAmount(), (byte) 1))) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', String.format("&6You cannot craft &e%s&6.", itemStack.getType().name())));

            event.setCancelled(true);
        }
    }
}