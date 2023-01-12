package me.jaskri.anticheatopensource.base.event;

import lombok.AllArgsConstructor;
import me.jaskri.anticheatopensource.Anticheat;
import me.jaskri.anticheatopensource.base.check.api.Check;
import me.jaskri.anticheatopensource.base.user.User;
import me.jaskri.anticheatopensource.util.TimeUtils;

import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class EventManager {
    private final User user;

    public void processProcessors(PacketEvent packetEvent) {
        this.user.getProcessorManager().getProcessors().forEach(processor ->
                processor.onPacket(packetEvent));
    }

    public void processChecks(PacketEvent packetEvent) {
        this.user.getCheckManager().getCheckList().stream().filter(Check::isEnabled).forEach(check ->
                check.onPacket(packetEvent));
    }

    public void processTime() {
        Anticheat.getInstance().getTimeService().scheduleAtFixedRate(() ->
                Anticheat.getInstance().currentDate = TimeUtils.GetDate(),
                50L, 50L, TimeUnit.MILLISECONDS);

    }
}
