package org.fourthline.cling.support.renderingcontrol.lastchange;

import me.tvspark.outline;
import org.fourthline.cling.support.model.Channel;

/* loaded from: classes5.dex */
public class ChannelMute {
    public Channel channel;
    public Boolean mute;

    public ChannelMute(Channel channel, Boolean bool) {
        this.channel = channel;
        this.mute = bool;
    }

    public Channel getChannel() {
        return this.channel;
    }

    public Boolean getMute() {
        return this.mute;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Mute: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getMute());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" (");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getChannel());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
