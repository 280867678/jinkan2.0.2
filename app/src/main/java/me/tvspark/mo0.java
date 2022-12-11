package me.tvspark;

import java.util.List;
import me.tvspark.utils.cast.utils.VMLog;
import org.fourthline.cling.model.meta.Service;
import org.fourthline.cling.support.avtransport.lastchange.AVTransportLastChangeParser;
import org.fourthline.cling.support.lastchange.EventedValue;
import org.fourthline.cling.support.lastchange.LastChangeParser;

/* loaded from: classes4.dex */
public abstract class mo0 extends no0 {
    public mo0(Service service) {
        super(service);
        getClass().getSimpleName();
    }

    @Override // me.tvspark.no0
    public LastChangeParser Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return new AVTransportLastChangeParser();
    }

    @Override // me.tvspark.no0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<EventedValue> list) {
        qo0 qo0Var = new qo0();
        EventedValue eventedValue = list.get(0);
        String name = eventedValue.getName();
        VMLog.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("AVTransportCallback onReceived: %s, %s, %d", name, eventedValue.getValue().toString(), Integer.valueOf(list.size()));
        if ("TransportState".equals(name)) {
            qo0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = eventedValue.getValue().toString();
        } else if ("CurrentMediaDuration".equals(name)) {
            qo0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = eventedValue.getValue().toString();
        } else if (!"RelativeTimePosition".equals(name) && "AbsoluteTimePosition".equals(name)) {
            qo0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = eventedValue.getValue().toString();
        }
        vo0 vo0Var = new vo0();
        vo0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = qo0Var;
        o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(vo0Var);
    }
}
