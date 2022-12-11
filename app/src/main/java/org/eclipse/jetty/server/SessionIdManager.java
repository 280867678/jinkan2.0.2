package org.eclipse.jetty.server;

import me.tvspark.ae0;
import me.tvspark.ee0;
import org.eclipse.jetty.util.component.LifeCycle;

/* loaded from: classes4.dex */
public interface SessionIdManager extends LifeCycle {
    void addSession(ee0 ee0Var);

    String getClusterId(String str);

    String getNodeId(String str, ae0 ae0Var);

    String getWorkerName();

    boolean idInUse(String str);

    void invalidateAll(String str);

    String newSessionId(ae0 ae0Var, long j);

    void removeSession(ee0 ee0Var);
}
