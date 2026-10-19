package com.enderdevelopment.plugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getLogger().info("UsefulPlugin has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("UsefulPlugin has been disabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        Player player = (Player) sender;

        if (command.getName().equalsIgnoreCase("useful")) {
            if (args.length == 0) {
                player.sendMessage("/useful debugstick - Gives a debug stick.");
                player.sendMessage("/useful nightvision - Gives night vision.");
                player.sendMessage("/useful barrier - Gives a barrier block.");
                player.sendMessage("/useful light - Gives a light block.");
                return true;
            }

            switch (args[0].toLowerCase()) {
                case "debugstick":
                    if (getConfig().getBoolean("debugstick.enabled")) {
                        player.getInventory().addItem(new ItemStack(Material.DEBUG_STICK));
                        player.sendMessage("You have received a debug stick.");
                    } else {
                        player.sendMessage("Debug stick is disabled.");
                    }
                    break;
                case "nightvision":
                    if (getConfig().getBoolean("nightvision.enabled")) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 0, false, false));
                        player.sendMessage("You have received night vision.");
                    } else {
                        player.sendMessage("Night vision is disabled.");
                    }
                    break;
                case "barrier":
                    if (getConfig().getBoolean("barrier.enabled")) {
                        player.getInventory().addItem(new ItemStack(Material.BARRIER));
                        player.sendMessage("You have received a barrier block.");
                    } else {
                        player.sendMessage("Barrier block is disabled.");
                    }
                    break;
                case "light":
                    if (getConfig().getBoolean("light.enabled")) {
                        player.getInventory().addItem(new ItemStack(Material.LIGHT));
                        player.sendMessage("You have received a light block.");
                    } else {
                        player.sendMessage("Light block is disabled.");
                    }
                    break;
                default:
                    player.sendMessage("Unknown command. Use /useful for help.");
                    break;
            }
            return true;
        }
        return false;
    }
}