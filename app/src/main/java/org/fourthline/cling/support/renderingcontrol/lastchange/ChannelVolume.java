package org.fourthline.cling.support.renderingcontrol.lastchange;

import me.tvspark.outline;
import org.fourthline.cling.support.model.Channel;

/* loaded from: classes5.dex */
public class ChannelVolume {
    public Channel channel;
    public Integer volume;

    public ChannelVolume(Channel channel, Integer num) {
        this.channel = channel;
        this.volume = num;
    }

    public Channel getChannel() {
        return this.channel;
    }

    public Integer getVolume() {
        return this.volume;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Volume: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getVolume());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" (");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getChannel());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
