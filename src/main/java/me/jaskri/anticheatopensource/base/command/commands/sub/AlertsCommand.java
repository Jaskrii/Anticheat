package me.jaskri.anticheatopensource.base.command.commands.sub;


import me.jaskri.anticheatopensource.Anticheat;
import me.jaskri.anticheatopensource.base.user.User;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class AlertsCommand {

    public void execute(String[] args, String s, CommandSender commandSender) {
        User user = Anticheat.getInstance().getUserManager().getUser(((Player) commandSender));
        if (user != null) {
            if (user.isAlerts()) {
                user.setAlerts(false);
                commandSender.sendMessage(ChatColor.RED + "Alerts have been toggled off!");
            } else {
                user.setAlerts(true);
                commandSender.sendMessage(ChatColor.GREEN + "Alerts have been toggled on!");
            }
        }
    }
}
