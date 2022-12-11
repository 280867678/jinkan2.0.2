package org.fourthline.cling.support.renderingcontrol.lastchange;

import me.tvspark.outline;
import org.fourthline.cling.support.model.Channel;

/* loaded from: classes5.dex */
public class ChannelVolumeDB {
    public Channel channel;
    public Integer volumeDB;

    public ChannelVolumeDB(Channel channel, Integer num) {
        this.channel = channel;
        this.volumeDB = num;
    }

    public Channel getChannel() {
        return this.channel;
    }

    public Integer getVolumeDB() {
        return this.volumeDB;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("VolumeDB: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getVolumeDB());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" (");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getChannel());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
