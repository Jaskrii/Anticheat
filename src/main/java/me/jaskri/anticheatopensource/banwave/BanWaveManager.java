package me.jaskri.anticheatopensource.banwave;

import me.jaskri.anticheatopensource.Anticheat;
import me.jaskri.anticheatopensource.base.check.api.Check;
import me.jaskri.anticheatopensource.base.user.User;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BanWaveManager {
    public List<User> playerBanList = new ArrayList<>();

    public void addPlayer(User player) {
        playerBanList.add(player);
    }

    public void removePlayer(User player) {
        playerBanList.remove(player);
    }

    public void commenceBanWave(CommandSender commandSender) {

        if (playerBanList.size() < 1) {
            commandSender.sendMessage("No players are on the banwave!");
        } else {
            commandSender.sendMessage("Banwave will commence in 8 seconds...");
        }

        Anticheat.getInstance().getExecutorService().scheduleAtFixedRate(() -> {
            Check check = new Check();

            playerBanList.forEach(player -> {
               check.punishPlayer(player);
               removePlayer(player);
            });


        }, 8, 1, TimeUnit.SECONDS);
    }

    public void stopBanwave() {
        playerBanList.forEach(this::removePlayer);
    }
}
