package me.tvspark;

import java.util.List;
import me.tvspark.utils.cast.utils.VMLog;
import org.fourthline.cling.model.meta.Service;
import org.fourthline.cling.support.lastchange.EventedValue;
import org.fourthline.cling.support.lastchange.LastChangeParser;
import org.fourthline.cling.support.model.Channel;
import org.fourthline.cling.support.renderingcontrol.lastchange.ChannelMute;
import org.fourthline.cling.support.renderingcontrol.lastchange.ChannelVolume;
import org.fourthline.cling.support.renderingcontrol.lastchange.RenderingControlLastChangeParser;

/* loaded from: classes4.dex */
public abstract class po0 extends no0 {
    public po0(Service service) {
        super(service);
        getClass().getSimpleName();
    }

    @Override // me.tvspark.no0
    public LastChangeParser Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return new RenderingControlLastChangeParser();
    }

    @Override // me.tvspark.no0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<EventedValue> list) {
        to0 to0Var = new to0();
        for (EventedValue eventedValue : list) {
            if ("Mute".equals(eventedValue.getName())) {
                Object value = eventedValue.getValue();
                if (value instanceof ChannelMute) {
                    ChannelMute channelMute = (ChannelMute) value;
                    if (Channel.Master.equals(channelMute.getChannel())) {
                        to0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = channelMute.getMute().booleanValue();
                    }
                }
            }
            if ("Volume".equals(eventedValue.getName())) {
                Object value2 = eventedValue.getValue();
                if (value2 instanceof ChannelVolume) {
                    ChannelVolume channelVolume = (ChannelVolume) value2;
                    if (Channel.Master.equals(channelVolume.getChannel())) {
                        to0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = channelVolume.getVolume().intValue();
                    }
                }
            }
            if ("PresetNameList".equals(eventedValue.getName())) {
                eventedValue.getValue().toString();
            }
        }
        VMLog.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("RenderingControlCallback onReceived:%b, %d", Boolean.valueOf(to0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), Integer.valueOf(to0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        VMLog.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("RenderingControlCallback received: mute:%b, volume:%d", Boolean.valueOf(to0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), Integer.valueOf(to0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        vo0 vo0Var = new vo0();
        vo0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = to0Var;
        o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(vo0Var);
    }
}
