package org.fourthline.cling.support.renderingcontrol.lastchange;

import me.tvspark.outline;
import org.fourthline.cling.support.model.Channel;

/* loaded from: classes5.dex */
public class ChannelLoudness {
    public Channel channel;
    public Boolean loudness;

    public ChannelLoudness(Channel channel, Boolean bool) {
        this.channel = channel;
        this.loudness = bool;
    }

    public Channel getChannel() {
        return this.channel;
    }

    public Boolean getLoudness() {
        return this.loudness;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Loudness: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getLoudness());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" (");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getChannel());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
