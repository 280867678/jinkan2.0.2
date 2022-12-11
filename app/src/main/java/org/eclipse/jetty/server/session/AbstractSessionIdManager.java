package org.eclipse.jetty.server.session;

import java.security.SecureRandom;
import java.util.Random;
import me.tvspark.ae0;
import org.eclipse.jetty.server.SessionIdManager;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes4.dex */
public abstract class AbstractSessionIdManager extends AbstractLifeCycle implements SessionIdManager {
    public static final Logger LOG = Log.getLogger(AbstractSessionIdManager.class);
    public static final String __NEW_SESSION_ID = "org.eclipse.jetty.server.newSessionId";
    public Random _random;
    public long _reseed = 100000;
    public boolean _weakRandom;
    public String _workerName;

    public AbstractSessionIdManager() {
    }

    public AbstractSessionIdManager(Random random) {
        this._random = random;
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        initRandom();
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
    }

    public Random getRandom() {
        return this._random;
    }

    public long getReseed() {
        return this._reseed;
    }

    @Override // org.eclipse.jetty.server.SessionIdManager
    public String getWorkerName() {
        return this._workerName;
    }

    public void initRandom() {
        Random random = this._random;
        if (random != null) {
            random.setSeed(((random.nextLong() ^ System.currentTimeMillis()) ^ hashCode()) ^ Runtime.getRuntime().freeMemory());
            return;
        }
        try {
            this._random = new SecureRandom();
        } catch (Exception e) {
            LOG.warn("Could not generate SecureRandom for session-id randomness", e);
            this._random = new Random();
            this._weakRandom = true;
        }
    }

    @Override // org.eclipse.jetty.server.SessionIdManager
    public String newSessionId(ae0 ae0Var, long j) {
        synchronized (this) {
            if (ae0Var != null) {
                try {
                    String requestedSessionId = ae0Var.getRequestedSessionId();
                    if (requestedSessionId != null) {
                        String clusterId = getClusterId(requestedSessionId);
                        if (idInUse(clusterId)) {
                            return clusterId;
                        }
                    }
                    String str = (String) ae0Var.getAttribute(__NEW_SESSION_ID);
                    if (str != null && idInUse(str)) {
                        return str;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            String str2 = null;
            while (true) {
                if (str2 != null && str2.length() != 0 && !idInUse(str2)) {
                    ae0Var.setAttribute(__NEW_SESSION_ID, str2);
                    return str2;
                }
                long hashCode = this._weakRandom ? ((hashCode() ^ Runtime.getRuntime().freeMemory()) ^ this._random.nextInt()) ^ (ae0Var.hashCode() << 32) : this._random.nextLong();
                if (hashCode < 0) {
                    hashCode = -hashCode;
                }
                if (this._reseed > 0 && hashCode % this._reseed == 1) {
                    LOG.debug("Reseeding {}", this);
                    if (this._random instanceof SecureRandom) {
                        SecureRandom secureRandom = (SecureRandom) this._random;
                        secureRandom.setSeed(secureRandom.generateSeed(8));
                    } else {
                        this._random.setSeed(((this._random.nextLong() ^ System.currentTimeMillis()) ^ ae0Var.hashCode()) ^ Runtime.getRuntime().freeMemory());
                    }
                }
                long hashCode2 = this._weakRandom ? (ae0Var.hashCode() << 32) ^ ((hashCode() ^ Runtime.getRuntime().freeMemory()) ^ this._random.nextInt()) : this._random.nextLong();
                if (hashCode2 < 0) {
                    hashCode2 = -hashCode2;
                }
                str2 = Long.toString(hashCode, 36) + Long.toString(hashCode2, 36);
                if (this._workerName != null) {
                    str2 = this._workerName + str2;
                }
            }
        }
    }

    public synchronized void setRandom(Random random) {
        this._random = random;
        this._weakRandom = false;
    }

    public void setReseed(long j) {
        this._reseed = j;
    }

    public void setWorkerName(String str) {
        if (!str.contains(".")) {
            this._workerName = str;
            return;
        }
        throw new IllegalArgumentException("Name cannot contain '.'");
    }
}
