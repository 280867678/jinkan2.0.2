package me.tvspark;

import java.util.EventListener;
import javax.servlet.http.HttpSessionEvent;

/* loaded from: classes4.dex */
public interface fe0 extends EventListener {
    void sessionDidActivate(HttpSessionEvent httpSessionEvent);

    void sessionWillPassivate(HttpSessionEvent httpSessionEvent);
}
