package me.jaskri.anticheatopensource.base.command.commands.sub;


import me.jaskri.anticheatopensource.Anticheat;
import me.jaskri.anticheatopensource.base.user.User;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class BanWaveCommand {

    public void execute(String[] args, String s, CommandSender commandSender) {
        if (args.length >= 2) {
            User user = Anticheat.getInstance().getUserManager().getUser(((Player) commandSender));
            if (user != null) {

                if (args[1].equalsIgnoreCase("enable")) {
                    Anticheat.getInstance().getConfigValues().setJudgementDay(true);
                    commandSender.sendMessage("Enabled Banwave!");
                } else if (args[1].equalsIgnoreCase("disable")) {
                    Anticheat.getInstance().getConfigValues().setJudgementDay(false);
                    commandSender.sendMessage("Disabled Banwave!");
                }

                if (args[1].equalsIgnoreCase("start")
                        && Anticheat.getInstance().getConfigValues().isJudgementDay()) {
                    Anticheat.getInstance().getBanWaveManager().commenceBanWave(commandSender);
                } else if (args[1].equalsIgnoreCase("stop")
                        && Anticheat.getInstance().getConfigValues().isJudgementDay()) {
                    commandSender.sendMessage("Banwave Should Have Stopped!");
                    Anticheat.getInstance().getBanWaveManager().stopBanwave();
                }
            }
        }
    }
}
