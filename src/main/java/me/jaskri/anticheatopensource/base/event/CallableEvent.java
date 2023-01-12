package me.jaskri.anticheatopensource.base.event;

import me.jaskri.anticheatopensource.base.user.User;

public interface CallableEvent {
    void onPacket(PacketEvent event);
    void setupTimers(User user);
    void onConnection(User user);
}
