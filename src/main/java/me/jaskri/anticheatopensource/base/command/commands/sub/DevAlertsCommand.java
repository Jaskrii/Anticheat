package me.jaskri.anticheatopensource.base.command.commands.sub;


import me.jaskri.anticheatopensource.Anticheat;
import me.jaskri.anticheatopensource.base.user.User;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class DevAlertsCommand {

    public void execute(String[] args, String s, CommandSender commandSender) {
        User user = Anticheat.getInstance().getUserManager().getUser(((Player) commandSender));
        if (user != null) {
            if (user.isDevAlerts()) {
                user.setDevAlerts(false);
                commandSender.sendMessage(ChatColor.RED + "[DEV] > " + ChatColor.WHITE + "Alerts have been toggled off!");
            } else {
                user.setDevAlerts(true);
                commandSender.sendMessage(ChatColor.RED + "[DEV] > " + ChatColor.WHITE + "Alerts have been toggled on!");
            }
        }
    }
}
