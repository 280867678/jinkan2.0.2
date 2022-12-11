package me.tvspark;

import java.util.EventListener;
import javax.servlet.http.HttpSessionEvent;

/* loaded from: classes4.dex */
public interface je0 extends EventListener {
    void sessionCreated(HttpSessionEvent httpSessionEvent);

    void sessionDestroyed(HttpSessionEvent httpSessionEvent);
}
