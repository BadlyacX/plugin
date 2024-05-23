package org.badlyac.TpCommand;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TpCommand implements CommandExecutor, TabCompleter {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("rtp")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "This command can only be used by players.");
                return true;
            }

            Player player = (Player) sender;

            if (args.length == 1) {
                // /tp <target>
                Player target = Bukkit.getPlayer(args[0]);
                if (target != null) {
                    player.teleport(target);
                    player.sendMessage(ChatColor.GREEN + "Teleported to " + target.getName());
                } else {
                    player.sendMessage(ChatColor.RED + "Player not found.");
                }
                return true;
            } else if (args.length == 2) {
                // /tp <target> <destination>
                Player target = Bukkit.getPlayer(args[0]);
                Player destination = Bukkit.getPlayer(args[1]);
                if (target != null && destination != null) {
                    target.teleport(destination);
                    player.sendMessage(ChatColor.GREEN + "Teleported " + target.getName() + " to " + destination.getName());
                } else {
                    player.sendMessage(ChatColor.RED + "Player not found.");
                }
                return true;
            } else if (args.length == 3) {
                // /tp <x> <y> <z>
                try {
                    double x = Double.parseDouble(args[0]);
                    double y = Double.parseDouble(args[1]);
                    double z = Double.parseDouble(args[2]);
                    Location location = new Location(player.getWorld(), x, y, z);
                    player.teleport(location);
                    player.sendMessage(ChatColor.GREEN + "Teleported to " + x + ", " + y + ", " + z);
                } catch (NumberFormatException e) {
                    player.sendMessage(ChatColor.RED + "Invalid coordinates.");
                }
                return true;
            } else {
                player.sendMessage(ChatColor.YELLOW + "Usage: /rtp <target> [destination] or /tp <x> <y> <z>");
                return false;
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();
        if (command.getName().equalsIgnoreCase("rtp")) {
            if (args.length == 1 || args.length == 2) {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    completions.add(player.getName());
                }
            }
        }
        return completions;
    }
}
