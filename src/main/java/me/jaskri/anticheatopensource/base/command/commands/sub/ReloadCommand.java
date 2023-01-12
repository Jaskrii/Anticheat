package me.jaskri.anticheatopensource.base.command.commands.sub;


import me.jaskri.anticheatopensource.Anticheat;
import me.jaskri.anticheatopensource.base.check.impl.CachedCheckManager;
import me.jaskri.anticheatopensource.base.user.User;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class ReloadCommand {

    public void execute(String[] args, String s, CommandSender commandSender) {

        Anticheat.getInstance().getUserManager().getUserMap().forEach((uuid, user) -> {

            user.getPlayer().sendMessage("\n" + Anticheat.getInstance().getConfigValues().getPrefix()
                    + ChatColor.GOLD + " Reloading... \n");

            Anticheat.getInstance().getCheckManager().reloadAnticheat();

            user.getPlayer().sendMessage("\n" + Anticheat.getInstance().getConfigValues().getPrefix()
                    + ChatColor.GREEN + " Reloaded! \n");
        });
    }
}
