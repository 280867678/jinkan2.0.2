package org.eclipse.jetty.server.session;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import me.tvspark.ae0;
import me.tvspark.outline;
import org.eclipse.jetty.server.AsyncContinuation;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.util.C3009IO;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes4.dex */
public class HashSessionManager extends AbstractSessionManager {
    public static int __id;
    public static final Logger __log = SessionHandler.LOG;
    public TimerTask _saveTask;
    public File _storeDir;
    public TimerTask _task;
    public Timer _timer;
    public final ConcurrentMap<String, HashedSession> _sessions = new ConcurrentHashMap();
    public boolean _timerStop = false;
    public long _scavengePeriodMs = AsyncContinuation.DEFAULT_TIMEOUT;
    public long _savePeriodMs = 0;
    public long _idleSavePeriodMs = 0;
    public boolean _lazyLoad = false;
    public volatile boolean _sessionsLoaded = false;
    public boolean _deleteUnrestorableSessions = false;

    /* loaded from: classes4.dex */
    public class ClassLoadingObjectInputStream extends ObjectInputStream {
        public ClassLoadingObjectInputStream() throws IOException {
        }

        public ClassLoadingObjectInputStream(InputStream inputStream) throws IOException {
            super(inputStream);
        }

        @Override // java.io.ObjectInputStream
        public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
            try {
                return Class.forName(objectStreamClass.getName(), false, Thread.currentThread().getContextClassLoader());
            } catch (ClassNotFoundException unused) {
                return super.resolveClass(objectStreamClass);
            }
        }
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionManager
    public void addSession(AbstractSession abstractSession) {
        if (isRunning()) {
            this._sessions.put(abstractSession.getClusterId(), (HashedSession) abstractSession);
        }
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionManager, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        super.doStart();
        this._timerStop = false;
        ContextHandler.Context currentContext = ContextHandler.getCurrentContext();
        if (currentContext != null) {
            this._timer = (Timer) currentContext.getAttribute("org.eclipse.jetty.server.session.timer");
        }
        if (this._timer == null) {
            this._timerStop = true;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("HashSessionScavenger-");
            int i = __id;
            __id = i + 1;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(i);
            this._timer = new Timer(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), true);
        }
        setScavengePeriod(getScavengePeriod());
        File file = this._storeDir;
        if (file != null) {
            if (!file.exists()) {
                this._storeDir.mkdirs();
            }
            if (!this._lazyLoad) {
                restoreSessions();
            }
        }
        setSavePeriod(getSavePeriod());
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionManager, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        synchronized (this) {
            if (this._saveTask != null) {
                this._saveTask.cancel();
            }
            this._saveTask = null;
            if (this._task != null) {
                this._task.cancel();
            }
            this._task = null;
            if (this._timer != null && this._timerStop) {
                this._timer.cancel();
            }
            this._timer = null;
        }
        super.doStop();
        this._sessions.clear();
    }

    public int getIdleSavePeriod() {
        long j = this._idleSavePeriodMs;
        if (j <= 0) {
            return 0;
        }
        return (int) (j / 1000);
    }

    public int getSavePeriod() {
        long j = this._savePeriodMs;
        if (j <= 0) {
            return 0;
        }
        return (int) (j / 1000);
    }

    public int getScavengePeriod() {
        return (int) (this._scavengePeriodMs / 1000);
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionManager
    /* renamed from: getSession */
    public AbstractSession mo5191getSession(String str) {
        if (this._lazyLoad && !this._sessionsLoaded) {
            try {
                restoreSessions();
            } catch (Exception e) {
                __log.warn(e);
            }
        }
        ConcurrentMap<String, HashedSession> concurrentMap = this._sessions;
        if (concurrentMap == null) {
            return null;
        }
        HashedSession hashedSession = concurrentMap.get(str);
        if (hashedSession == null && this._lazyLoad) {
            hashedSession = restoreSession(str);
        }
        if (hashedSession == null) {
            return null;
        }
        if (this._idleSavePeriodMs != 0) {
            hashedSession.deIdle();
        }
        return hashedSession;
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionManager
    public int getSessions() {
        int sessions = super.getSessions();
        if (__log.isDebugEnabled() && this._sessions.size() != sessions) {
            Logger logger = __log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("sessions: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._sessions.size());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("!=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(sessions);
            logger.warn(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), new Object[0]);
        }
        return sessions;
    }

    public File getStoreDirectory() {
        return this._storeDir;
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionManager
    public void invalidateSessions() throws Exception {
        File file;
        ArrayList arrayList = new ArrayList(this._sessions.values());
        int i = 100;
        while (arrayList.size() > 0) {
            int i2 = i - 1;
            if (i <= 0) {
                return;
            }
            if (!isStopping() || (file = this._storeDir) == null || !file.exists() || !this._storeDir.canWrite()) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((HashedSession) it.next()).invalidate();
                }
            } else {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    HashedSession hashedSession = (HashedSession) it2.next();
                    hashedSession.save(false);
                    removeSession((AbstractSession) hashedSession, false);
                }
            }
            arrayList = new ArrayList(this._sessions.values());
            i = i2;
        }
    }

    public boolean isDeleteUnrestorableSessions() {
        return this._deleteUnrestorableSessions;
    }

    public boolean isLazyLoad() {
        return this._lazyLoad;
    }

    public AbstractSession newSession(long j, long j2, String str) {
        return new HashedSession(this, j, j2, str);
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionManager
    public AbstractSession newSession(ae0 ae0Var) {
        return new HashedSession(this, ae0Var);
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionManager
    public boolean removeSession(String str) {
        return this._sessions.remove(str) != null;
    }

    public HashedSession restoreSession(InputStream inputStream, HashedSession hashedSession) throws Exception {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        try {
            String readUTF = dataInputStream.readUTF();
            dataInputStream.readUTF();
            long readLong = dataInputStream.readLong();
            long readLong2 = dataInputStream.readLong();
            int readInt = dataInputStream.readInt();
            if (hashedSession == null) {
                hashedSession = (HashedSession) newSession(readLong, readLong2, readUTF);
            }
            hashedSession.setRequests(readInt);
            int readInt2 = dataInputStream.readInt();
            if (readInt2 > 0) {
                ClassLoadingObjectInputStream classLoadingObjectInputStream = new ClassLoadingObjectInputStream(dataInputStream);
                for (int i = 0; i < readInt2; i++) {
                    hashedSession.setAttribute(classLoadingObjectInputStream.readUTF(), classLoadingObjectInputStream.readObject());
                }
                C3009IO.close((InputStream) classLoadingObjectInputStream);
            }
            return hashedSession;
        } finally {
            C3009IO.close((InputStream) dataInputStream);
        }
    }

    public synchronized HashedSession restoreSession(String str) {
        InputStream inputStream;
        Logger logger;
        String str2;
        File file = new File(this._storeDir, str);
        InputStream inputStream2 = null;
        try {
        } catch (Exception e) {
            e = e;
            inputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        if (!file.exists()) {
            file.delete();
            return null;
        }
        inputStream = new FileInputStream(file);
        try {
            HashedSession restoreSession = restoreSession(inputStream, null);
            addSession(restoreSession, false);
            restoreSession.didActivate();
            C3009IO.close(inputStream);
            file.delete();
            return restoreSession;
        } catch (Exception e2) {
            e = e2;
            if (inputStream != null) {
                C3009IO.close(inputStream);
            }
            if (!isDeleteUnrestorableSessions() || !file.exists() || !file.getParentFile().equals(this._storeDir)) {
                logger = __log;
                str2 = "Problem restoring session " + str;
            } else {
                file.delete();
                logger = __log;
                str2 = "Deleting file for unrestorable session " + str;
            }
            logger.warn(str2, e);
            return null;
        } catch (Throwable th2) {
            th = th2;
            inputStream2 = inputStream;
            if (inputStream2 != null) {
                C3009IO.close(inputStream2);
            }
            file.delete();
            throw th;
        }
    }

    public void restoreSessions() throws Exception {
        this._sessionsLoaded = true;
        File file = this._storeDir;
        if (file == null || !file.exists()) {
            return;
        }
        if (!this._storeDir.canRead()) {
            Logger logger = __log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unable to restore Sessions: Cannot read from Session storage directory ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._storeDir.getAbsolutePath());
            logger.warn(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), new Object[0]);
            return;
        }
        String[] list = this._storeDir.list();
        for (int i = 0; list != null && i < list.length; i++) {
            restoreSession(list[i]);
        }
    }

    public void saveSessions(boolean z) throws Exception {
        File file = this._storeDir;
        if (file == null || !file.exists()) {
            return;
        }
        if (this._storeDir.canWrite()) {
            for (HashedSession hashedSession : this._sessions.values()) {
                hashedSession.save(true);
            }
            return;
        }
        Logger logger = __log;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unable to save Sessions: Session persistence storage directory ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._storeDir.getAbsolutePath());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" is not writeable");
        logger.warn(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), new Object[0]);
    }

    public void scavenge() {
        long currentTimeMillis;
        if (isStopping() || isStopped()) {
            return;
        }
        Thread currentThread = Thread.currentThread();
        ClassLoader contextClassLoader = currentThread.getContextClassLoader();
        try {
            if (this._loader != null) {
                currentThread.setContextClassLoader(this._loader);
            }
            currentTimeMillis = System.currentTimeMillis();
        } finally {
            currentThread.setContextClassLoader(contextClassLoader);
        }
        for (HashedSession hashedSession : this._sessions.values()) {
            long maxInactiveInterval = hashedSession.getMaxInactiveInterval() * 1000;
            if (maxInactiveInterval > 0 && hashedSession.getAccessed() + maxInactiveInterval < currentTimeMillis) {
                try {
                    hashedSession.timeout();
                } catch (Exception e) {
                    __log.warn("Problem scavenging sessions", e);
                }
            } else if (this._idleSavePeriodMs > 0 && hashedSession.getAccessed() + this._idleSavePeriodMs < currentTimeMillis) {
                try {
                    hashedSession.idle();
                } catch (Exception e2) {
                    Logger logger = __log;
                    logger.warn("Problem idling session " + hashedSession.getId(), e2);
                }
            }
            currentThread.setContextClassLoader(contextClassLoader);
        }
    }

    public void setDeleteUnrestorableSessions(boolean z) {
        this._deleteUnrestorableSessions = z;
    }

    public void setIdleSavePeriod(int i) {
        this._idleSavePeriodMs = i * 1000;
    }

    public void setLazyLoad(boolean z) {
        this._lazyLoad = z;
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionManager, org.eclipse.jetty.server.SessionManager
    public void setMaxInactiveInterval(int i) {
        super.setMaxInactiveInterval(i);
        int i2 = this._dftMaxIdleSecs;
        if (i2 <= 0 || this._scavengePeriodMs <= i2 * 1000) {
            return;
        }
        setScavengePeriod((i2 + 9) / 10);
    }

    public void setSavePeriod(int i) {
        long j = i * 1000;
        if (j < 0) {
            j = 0;
        }
        this._savePeriodMs = j;
        if (this._timer != null) {
            synchronized (this) {
                if (this._saveTask != null) {
                    this._saveTask.cancel();
                }
                if (this._savePeriodMs > 0 && this._storeDir != null) {
                    TimerTask timerTask = new TimerTask() { // from class: org.eclipse.jetty.server.session.HashSessionManager.1
                        @Override // java.util.TimerTask, java.lang.Runnable
                        public void run() {
                            try {
                                HashSessionManager.this.saveSessions(true);
                            } catch (Exception e) {
                                HashSessionManager.__log.warn(e);
                            }
                        }
                    };
                    this._saveTask = timerTask;
                    this._timer.schedule(timerTask, this._savePeriodMs, this._savePeriodMs);
                }
            }
        }
    }

    public void setScavengePeriod(int i) {
        if (i == 0) {
            i = 60;
        }
        long j = this._scavengePeriodMs;
        long j2 = 1000;
        long j3 = i * 1000;
        if (j3 > 60000) {
            j3 = 60000;
        }
        if (j3 >= 1000) {
            j2 = j3;
        }
        this._scavengePeriodMs = j2;
        if (this._timer != null) {
            if (j2 == j && this._task != null) {
                return;
            }
            synchronized (this) {
                if (this._task != null) {
                    this._task.cancel();
                }
                TimerTask timerTask = new TimerTask() { // from class: org.eclipse.jetty.server.session.HashSessionManager.2
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        HashSessionManager.this.scavenge();
                    }
                };
                this._task = timerTask;
                this._timer.schedule(timerTask, this._scavengePeriodMs, this._scavengePeriodMs);
            }
        }
    }

    public void setStoreDirectory(File file) throws IOException {
        this._storeDir = file.getCanonicalFile();
    }
}
