package me.jaskri.anticheatopensource.base.check.impl;

import lombok.Getter;
import me.jaskri.anticheatopensource.Anticheat;
import me.jaskri.anticheatopensource.base.check.api.Check;
import me.jaskri.anticheatopensource.base.user.User;
import me.jaskri.anticheatopensource.Anticheat;
import me.jaskri.anticheatopensource.base.check.api.Check;
import me.jaskri.anticheatopensource.base.user.User;
import me.jaskri.anticheatopensource.checks.combat.aimassist.*;
import me.jaskri.anticheatopensource.checks.combat.autoclicker.*;
import me.jaskri.anticheatopensource.checks.combat.killaura.*;
import me.jaskri.anticheatopensource.checks.misc.badpackets.*;
import me.jaskri.anticheatopensource.checks.combat.velocity.*;
import me.jaskri.anticheatopensource.checks.misc.pingspoof.*;
import me.jaskri.anticheatopensource.checks.misc.scaffold.*;
import me.jaskri.anticheatopensource.checks.misc.timer.*;
import me.jaskri.anticheatopensource.checks.movement.flight.*;
import me.jaskri.anticheatopensource.checks.movement.speed.*;
import me.jaskri.anticheatopensource.checks.movement.step.*;
import me.jaskri.anticheat.util.file.ChecksFile;
import org.bukkit.Bukkit;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Getter
public class CheckManager {
    private final List<Check> checkList = new LinkedList<>();

    public void setupChecks(User user) {
        this.checkList.addAll(Anticheat.getInstance().getCheckManager().cloneChecks());
        this.checkList.forEach(check -> check.setupTimers(user));
    }
}