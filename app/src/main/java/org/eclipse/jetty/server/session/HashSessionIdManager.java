package org.eclipse.jetty.server.session;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import me.tvspark.ae0;
import me.tvspark.ee0;

/* loaded from: classes4.dex */
public class HashSessionIdManager extends AbstractSessionIdManager {
    public final Map<String, Set<WeakReference<ee0>>> _sessions = new HashMap();

    public HashSessionIdManager() {
    }

    public HashSessionIdManager(Random random) {
        super(random);
    }

    @Override // org.eclipse.jetty.server.SessionIdManager
    public void addSession(ee0 ee0Var) {
        String clusterId = getClusterId(ee0Var.getId());
        WeakReference<ee0> weakReference = new WeakReference<>(ee0Var);
        synchronized (this) {
            Set<WeakReference<ee0>> set = this._sessions.get(clusterId);
            if (set == null) {
                set = new HashSet<>();
                this._sessions.put(clusterId, set);
            }
            set.add(weakReference);
        }
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionIdManager, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        super.doStart();
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionIdManager, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        this._sessions.clear();
        super.doStop();
    }

    @Override // org.eclipse.jetty.server.SessionIdManager
    public String getClusterId(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf > 0 ? str.substring(0, lastIndexOf) : str;
    }

    @Override // org.eclipse.jetty.server.SessionIdManager
    public String getNodeId(String str, ae0 ae0Var) {
        String str2 = ae0Var == null ? null : (String) ae0Var.getAttribute("org.eclipse.jetty.ajp.JVMRoute");
        if (str2 != null) {
            return str + '.' + str2;
        } else if (this._workerName == null) {
            return str;
        } else {
            return str + '.' + this._workerName;
        }
    }

    public Collection<ee0> getSession(String str) {
        ArrayList arrayList = new ArrayList();
        Set<WeakReference<ee0>> set = this._sessions.get(str);
        if (set != null) {
            for (WeakReference<ee0> weakReference : set) {
                ee0 ee0Var = weakReference.get();
                if (ee0Var != null) {
                    arrayList.add(ee0Var);
                }
            }
        }
        return arrayList;
    }

    public Collection<String> getSessions() {
        return Collections.unmodifiableCollection(this._sessions.keySet());
    }

    @Override // org.eclipse.jetty.server.SessionIdManager
    public boolean idInUse(String str) {
        boolean containsKey;
        synchronized (this) {
            containsKey = this._sessions.containsKey(str);
        }
        return containsKey;
    }

    @Override // org.eclipse.jetty.server.SessionIdManager
    public void invalidateAll(String str) {
        Set<WeakReference<ee0>> remove;
        synchronized (this) {
            remove = this._sessions.remove(str);
        }
        if (remove != null) {
            for (WeakReference<ee0> weakReference : remove) {
                AbstractSession abstractSession = (AbstractSession) weakReference.get();
                if (abstractSession != null && abstractSession.isValid()) {
                    abstractSession.invalidate();
                }
            }
            remove.clear();
        }
    }

    @Override // org.eclipse.jetty.server.SessionIdManager
    public void removeSession(ee0 ee0Var) {
        String clusterId = getClusterId(ee0Var.getId());
        synchronized (this) {
            Set<WeakReference<ee0>> set = this._sessions.get(clusterId);
            if (set != null) {
                Iterator<WeakReference<ee0>> it = set.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ee0 ee0Var2 = it.next().get();
                    if (ee0Var2 == null) {
                        it.remove();
                    } else if (ee0Var2 == ee0Var) {
                        it.remove();
                        break;
                    }
                }
                if (set.isEmpty()) {
                    this._sessions.remove(clusterId);
                }
            }
        }
    }
}
