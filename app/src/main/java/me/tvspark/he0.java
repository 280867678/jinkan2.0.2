package me.tvspark;

import java.util.EventListener;
import javax.servlet.http.HttpSessionBindingEvent;

/* loaded from: classes4.dex */
public interface he0 extends EventListener {
    void valueBound(HttpSessionBindingEvent httpSessionBindingEvent);

    void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent);
}
