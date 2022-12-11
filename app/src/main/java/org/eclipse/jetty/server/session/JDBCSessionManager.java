package org.eclipse.jetty.server.session;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import javax.servlet.http.HttpSessionEvent;
import me.tvspark.ae0;
import me.tvspark.je0;
import me.tvspark.outline;
import org.eclipse.jetty.server.SessionIdManager;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes4.dex */
public class JDBCSessionManager extends AbstractSessionManager {
    public static final Logger LOG = Log.getLogger(JDBCSessionManager.class);
    public JDBCSessionIdManager _jdbcSessionIdMgr = null;
    public long _saveIntervalSec = 60;
    public ConcurrentHashMap<String, AbstractSession> _sessions;

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

    /* loaded from: classes4.dex */
    public class Session extends AbstractSession {
        public static final long serialVersionUID = 5208464051134226143L;
        public String _canonicalContext;
        public long _cookieSet;
        public boolean _dirty = false;
        public long _expiryTime;
        public String _lastNode;
        public long _lastSaved;
        public String _rowId;
        public String _virtualHost;

        public Session(String str, String str2, long j, long j2) {
            super(JDBCSessionManager.this, j, j2, str);
            this._rowId = str2;
        }

        public Session(ae0 ae0Var) {
            super(JDBCSessionManager.this, ae0Var);
            int maxInactiveInterval = getMaxInactiveInterval();
            this._expiryTime = maxInactiveInterval <= 0 ? 0L : System.currentTimeMillis() + (maxInactiveInterval * 1000);
            this._virtualHost = JDBCSessionManager.getVirtualHost(JDBCSessionManager.this._context);
            this._canonicalContext = JDBCSessionManager.canonicalize(JDBCSessionManager.this._context.getContextPath());
            this._lastNode = JDBCSessionManager.this.getSessionIdManager().getWorkerName();
        }

        @Override // org.eclipse.jetty.server.session.AbstractSession
        public boolean access(long j) {
            synchronized (this) {
                if (super.access(j)) {
                    int maxInactiveInterval = getMaxInactiveInterval();
                    this._expiryTime = maxInactiveInterval <= 0 ? 0L : j + (maxInactiveInterval * 1000);
                    return true;
                }
                return false;
            }
        }

        @Override // org.eclipse.jetty.server.session.AbstractSession
        public void complete() {
            synchronized (this) {
                super.complete();
                try {
                    if (isValid()) {
                        if (this._dirty) {
                            willPassivate();
                            JDBCSessionManager.this.updateSession(this);
                            didActivate();
                        } else if (getAccessed() - this._lastSaved >= JDBCSessionManager.this.getSaveInterval() * 1000) {
                            JDBCSessionManager.this.updateSessionAccessTime(this);
                        }
                    }
                } catch (Exception e) {
                    Logger logger = AbstractSession.LOG;
                    logger.warn("Problem persisting changed session data id=" + getId(), e);
                }
                this._dirty = false;
            }
        }

        @Override // org.eclipse.jetty.server.session.AbstractSession
        public void cookieSet() {
            this._cookieSet = getAccessed();
        }

        public synchronized String getCanonicalContext() {
            return this._canonicalContext;
        }

        public synchronized long getCookieSet() {
            return this._cookieSet;
        }

        public synchronized long getExpiryTime() {
            return this._expiryTime;
        }

        public synchronized String getLastNode() {
            return this._lastNode;
        }

        public synchronized long getLastSaved() {
            return this._lastSaved;
        }

        public synchronized String getRowId() {
            return this._rowId;
        }

        public synchronized String getVirtualHost() {
            return this._virtualHost;
        }

        @Override // org.eclipse.jetty.server.session.AbstractSession, me.tvspark.ee0
        public void removeAttribute(String str) {
            super.removeAttribute(str);
            this._dirty = true;
        }

        @Override // org.eclipse.jetty.server.session.AbstractSession, me.tvspark.ee0
        public void setAttribute(String str, Object obj) {
            super.setAttribute(str, obj);
            this._dirty = true;
        }

        public synchronized void setCanonicalContext(String str) {
            this._canonicalContext = str;
        }

        public void setCookieSet(long j) {
            this._cookieSet = j;
        }

        public synchronized void setExpiryTime(long j) {
            this._expiryTime = j;
        }

        public synchronized void setLastNode(String str) {
            this._lastNode = str;
        }

        public synchronized void setLastSaved(long j) {
            this._lastSaved = j;
        }

        public synchronized void setRowId(String str) {
            this._rowId = str;
        }

        public synchronized void setVirtualHost(String str) {
            this._virtualHost = str;
        }

        @Override // org.eclipse.jetty.server.session.AbstractSession
        public void timeout() throws IllegalStateException {
            if (AbstractSession.LOG.isDebugEnabled()) {
                Logger logger = AbstractSession.LOG;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Timing out session id=");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getClusterId());
                logger.debug(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), new Object[0]);
            }
            super.timeout();
        }

        @Override // org.eclipse.jetty.server.session.AbstractSession
        public String toString() {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Session rowId=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._rowId);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(",id=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getId());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(",lastNode=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._lastNode);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(",created=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getCreationTime());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(",accessed=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getAccessed());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(",lastAccessed=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getLastAccessedTime());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(",cookieSet=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._cookieSet);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(",lastSaved=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._lastSaved);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(",expiry=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._expiryTime);
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
    }

    private String calculateRowId(Session session) {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(canonicalize(this._context.getContextPath()), "_");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getVirtualHost(this._context));
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), "_");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(session.getId());
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
    }

    public static String canonicalize(String str) {
        return str == null ? "" : str.replace('/', '_').replace('.', '_').replace('\\', '_');
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Connection getConnection() throws SQLException {
        return ((JDBCSessionIdManager) getSessionIdManager()).getConnection();
    }

    public static String getVirtualHost(ContextHandler.Context context) {
        String[] virtualHosts;
        return (context == null || (virtualHosts = context.getContextHandler().getVirtualHosts()) == null || virtualHosts.length == 0 || virtualHosts[0] == null) ? StringUtil.ALL_INTERFACES : virtualHosts[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSessionAccessTime(Session session) throws Exception {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            connection.setAutoCommit(true);
            preparedStatement = connection.prepareStatement(this._jdbcSessionIdMgr._updateSessionAccessTime);
            preparedStatement.setString(1, getSessionIdManager().getWorkerName());
            preparedStatement.setLong(2, session.getAccessed());
            preparedStatement.setLong(3, session.getLastAccessedTime());
            preparedStatement.setLong(4, currentTimeMillis);
            preparedStatement.setLong(5, session.getExpiryTime());
            preparedStatement.setString(6, session.getRowId());
            preparedStatement.executeUpdate();
            session.setLastSaved(currentTimeMillis);
            preparedStatement.close();
            if (LOG.isDebugEnabled()) {
                Logger logger = LOG;
                logger.debug("Updated access time session id=" + session.getId(), new Object[0]);
            }
            try {
                preparedStatement.close();
            } catch (Exception e) {
                LOG.warn(e);
            }
            connection.close();
        } catch (Throwable th) {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (Exception e2) {
                    LOG.warn(e2);
                }
            }
            if (connection != null) {
                connection.close();
            }
            throw th;
        }
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionManager
    public void addSession(AbstractSession abstractSession) {
        if (abstractSession == null) {
            return;
        }
        synchronized (this) {
            this._sessions.put(abstractSession.getClusterId(), abstractSession);
        }
        try {
            synchronized (abstractSession) {
                abstractSession.willPassivate();
                storeSession((Session) abstractSession);
                abstractSession.didActivate();
            }
        } catch (Exception e) {
            Logger logger = LOG;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unable to store new session id=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(abstractSession.getId());
            logger.warn(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), e);
        }
    }

    public void cacheInvalidate(Session session) {
    }

    public void deleteSession(Session session) throws Exception {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            connection.setAutoCommit(true);
            preparedStatement = connection.prepareStatement(this._jdbcSessionIdMgr._deleteSession);
            preparedStatement.setString(1, session.getRowId());
            preparedStatement.executeUpdate();
            if (LOG.isDebugEnabled()) {
                Logger logger = LOG;
                logger.debug("Deleted Session " + session, new Object[0]);
            }
            try {
                preparedStatement.close();
            } catch (Exception e) {
                LOG.warn(e);
            }
            connection.close();
        } catch (Throwable th) {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (Exception e2) {
                    LOG.warn(e2);
                }
            }
            if (connection != null) {
                connection.close();
            }
            throw th;
        }
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionManager, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        SessionIdManager sessionIdManager = this._sessionIdManager;
        if (sessionIdManager != null) {
            this._jdbcSessionIdMgr = (JDBCSessionIdManager) sessionIdManager;
            this._sessions = new ConcurrentHashMap<>();
            super.doStart();
            return;
        }
        throw new IllegalStateException("No session id manager defined");
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionManager, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        this._sessions.clear();
        this._sessions = null;
        super.doStop();
    }

    public void expire(List<?> list) {
        if (isStopping() || isStopped()) {
            return;
        }
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        ListIterator<?> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            try {
                String str = (String) listIterator.next();
                if (LOG.isDebugEnabled()) {
                    Logger logger = LOG;
                    logger.debug("Expiring session id " + str, new Object[0]);
                }
                Session session = (Session) this._sessions.get(str);
                if (session != null) {
                    session.timeout();
                    listIterator.remove();
                } else if (LOG.isDebugEnabled()) {
                    Logger logger2 = LOG;
                    logger2.debug("Unrecognized session id=" + str, new Object[0]);
                }
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    public long getSaveInterval() {
        return this._saveIntervalSec;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0158 A[Catch: all -> 0x0230, TRY_ENTER, TryCatch #0 {, blocks: (B:4:0x0009, B:7:0x001c, B:10:0x0045, B:11:0x0041, B:12:0x005e, B:16:0x00c8, B:17:0x00f5, B:20:0x0158, B:24:0x016d, B:25:0x0215, B:28:0x017c, B:30:0x0184, B:33:0x018d, B:34:0x019b, B:36:0x01a3, B:37:0x01d7, B:39:0x01e7, B:43:0x01ef, B:44:0x0205, B:46:0x0207, B:47:0x00fa, B:49:0x0108, B:50:0x0136, B:53:0x0218, B:54:0x022e), top: B:3:0x0009, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0207 A[Catch: all -> 0x0230, TryCatch #0 {, blocks: (B:4:0x0009, B:7:0x001c, B:10:0x0045, B:11:0x0041, B:12:0x005e, B:16:0x00c8, B:17:0x00f5, B:20:0x0158, B:24:0x016d, B:25:0x0215, B:28:0x017c, B:30:0x0184, B:33:0x018d, B:34:0x019b, B:36:0x01a3, B:37:0x01d7, B:39:0x01e7, B:43:0x01ef, B:44:0x0205, B:46:0x0207, B:47:0x00fa, B:49:0x0108, B:50:0x0136, B:53:0x0218, B:54:0x022e), top: B:3:0x0009, inners: #1, #2 }] */
    @Override // org.eclipse.jetty.server.session.AbstractSessionManager
    /* renamed from: getSession  reason: collision with other method in class */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Session mo5191getSession(String str) {
        Session session;
        String canonicalize;
        String virtualHost;
        Session session2 = (Session) this._sessions.get(str);
        synchronized (this) {
            long currentTimeMillis = System.currentTimeMillis();
            if (LOG.isDebugEnabled()) {
                if (session2 == null) {
                    Logger logger = LOG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("getSession(");
                    sb.append(str);
                    sb.append("): not in session map,");
                    sb.append(" now=");
                    sb.append(currentTimeMillis);
                    sb.append(" lastSaved=");
                    sb.append(session2 == null ? 0L : session2._lastSaved);
                    sb.append(" interval=");
                    sb.append(this._saveIntervalSec * 1000);
                    logger.debug(sb.toString(), new Object[0]);
                } else {
                    LOG.debug("getSession(" + str + "): in session map,  now=" + currentTimeMillis + " lastSaved=" + session2._lastSaved + " interval=" + (this._saveIntervalSec * 1000) + " lastNode=" + session2._lastNode + " thisNode=" + getSessionIdManager().getWorkerName() + " difference=" + (currentTimeMillis - session2._lastSaved), new Object[0]);
                }
            }
            try {
                if (session2 == null) {
                    LOG.debug("getSession(" + str + "): no session in session map. Reloading session data from db.", new Object[0]);
                    canonicalize = canonicalize(this._context.getContextPath());
                    virtualHost = getVirtualHost(this._context);
                } else if (currentTimeMillis - session2._lastSaved >= this._saveIntervalSec * 1000) {
                    LOG.debug("getSession(" + str + "): stale session. Reloading session data from db.", new Object[0]);
                    canonicalize = canonicalize(this._context.getContextPath());
                    virtualHost = getVirtualHost(this._context);
                } else {
                    LOG.debug("getSession(" + str + "): session in session map", new Object[0]);
                    session = session2;
                    if (session == null) {
                        try {
                            if (session.getLastNode().equals(getSessionIdManager().getWorkerName()) && session2 != null) {
                                LOG.debug("getSession({}): Session not stale {}", str, session2);
                            }
                            if (session._expiryTime > 0 && session._expiryTime <= currentTimeMillis) {
                                LOG.debug("getSession ({}): Session has expired", str);
                                session2 = null;
                            }
                            updateSessionNode(session);
                            session.didActivate();
                        } catch (Exception e) {
                            LOG.warn("Unable to update freshly loaded session " + str, e);
                            return null;
                        }
                        if (LOG.isDebugEnabled()) {
                            LOG.debug("getSession(" + str + "): lastNode=" + session.getLastNode() + " thisNode=" + getSessionIdManager().getWorkerName(), new Object[0]);
                        }
                        session.setLastNode(getSessionIdManager().getWorkerName());
                        this._sessions.put(str, session);
                    } else {
                        LOG.debug("getSession({}): No session in database matching id={}", str, str);
                    }
                    session2 = session;
                }
                session = loadSession(str, canonicalize, virtualHost);
                if (session == null) {
                }
                session2 = session;
            } catch (Exception e2) {
                LOG.warn("Unable to load session " + str, e2);
                return null;
            }
        }
        return session2;
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionManager
    public int getSessions() {
        int size;
        synchronized (this) {
            size = this._sessions.size();
        }
        return size;
    }

    public void invalidateSession(String str) {
        Session session;
        synchronized (this) {
            session = (Session) this._sessions.get(str);
        }
        if (session != null) {
            session.invalidate();
        }
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionManager
    public void invalidateSessions() {
    }

    public Session loadSession(final String str, final String str2, final String str3) throws Exception {
        final AtomicReference atomicReference = new AtomicReference();
        final AtomicReference atomicReference2 = new AtomicReference();
        Runnable runnable = new Runnable() { // from class: org.eclipse.jetty.server.session.JDBCSessionManager.1
            /* JADX WARN: Removed duplicated region for block: B:43:0x0127 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:48:0x0119 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                PreparedStatement preparedStatement;
                Throwable th;
                Connection connection;
                Exception e;
                Session session = null;
                try {
                    try {
                        connection = JDBCSessionManager.this.getConnection();
                    } catch (Exception e2) {
                        JDBCSessionManager.LOG.warn(e2);
                        return;
                    }
                } catch (Exception e3) {
                    preparedStatement = null;
                    e = e3;
                    connection = null;
                } catch (Throwable th2) {
                    preparedStatement = null;
                    th = th2;
                    connection = null;
                }
                try {
                    preparedStatement = JDBCSessionManager.this._jdbcSessionIdMgr._dbAdaptor.getLoadStatement(connection, str, str2, str3);
                    try {
                        try {
                            ResultSet executeQuery = preparedStatement.executeQuery();
                            if (executeQuery.next()) {
                                session = new Session(str, executeQuery.getString(JDBCSessionManager.this._jdbcSessionIdMgr._sessionTableRowId), executeQuery.getLong("createTime"), executeQuery.getLong("accessTime"));
                                session.setCookieSet(executeQuery.getLong("cookieTime"));
                                session.setLastAccessedTime(executeQuery.getLong("lastAccessTime"));
                                session.setLastNode(executeQuery.getString("lastNode"));
                                session.setLastSaved(executeQuery.getLong("lastSavedTime"));
                                session.setExpiryTime(executeQuery.getLong("expiryTime"));
                                session.setCanonicalContext(executeQuery.getString("contextPath"));
                                session.setVirtualHost(executeQuery.getString("virtualHost"));
                                ClassLoadingObjectInputStream classLoadingObjectInputStream = new ClassLoadingObjectInputStream(((JDBCSessionIdManager) JDBCSessionManager.this.getSessionIdManager())._dbAdaptor.getBlobInputStream(executeQuery, "map"));
                                session.addAttributes((Map) classLoadingObjectInputStream.readObject());
                                classLoadingObjectInputStream.close();
                                if (JDBCSessionManager.LOG.isDebugEnabled()) {
                                    JDBCSessionManager.LOG.debug("LOADED session " + session, new Object[0]);
                                }
                            }
                            atomicReference.set(session);
                            try {
                                preparedStatement.close();
                            } catch (Exception e4) {
                                JDBCSessionManager.LOG.warn(e4);
                            }
                        } catch (Exception e5) {
                            e = e5;
                            atomicReference2.set(e);
                            if (preparedStatement != null) {
                                try {
                                    preparedStatement.close();
                                } catch (Exception e6) {
                                    JDBCSessionManager.LOG.warn(e6);
                                }
                            }
                            if (connection == null) {
                                return;
                            }
                            connection.close();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (preparedStatement != null) {
                            try {
                                preparedStatement.close();
                            } catch (Exception e7) {
                                JDBCSessionManager.LOG.warn(e7);
                            }
                        }
                        if (connection != null) {
                            try {
                                connection.close();
                            } catch (Exception e8) {
                                JDBCSessionManager.LOG.warn(e8);
                            }
                        }
                        throw th;
                    }
                } catch (Exception e9) {
                    preparedStatement = null;
                    e = e9;
                } catch (Throwable th4) {
                    preparedStatement = null;
                    th = th4;
                    if (preparedStatement != null) {
                    }
                    if (connection != null) {
                    }
                    throw th;
                }
                if (connection != null) {
                    connection.close();
                }
            }
        };
        ContextHandler.Context context = this._context;
        if (context == null) {
            runnable.run();
        } else {
            context.getContextHandler().handle(runnable);
        }
        if (atomicReference2.get() == null) {
            return (Session) atomicReference.get();
        }
        this._jdbcSessionIdMgr.removeSession(str);
        throw ((Exception) atomicReference2.get());
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionManager
    public AbstractSession newSession(ae0 ae0Var) {
        return new Session(ae0Var);
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionManager
    public void removeSession(AbstractSession abstractSession, boolean z) {
        boolean z2;
        synchronized (this) {
            if (mo5191getSession(abstractSession.getClusterId()) != null) {
                z2 = true;
                removeSession(abstractSession.getClusterId());
            } else {
                z2 = false;
            }
        }
        if (z2) {
            this._sessionIdManager.removeSession(abstractSession);
            if (z) {
                this._sessionIdManager.invalidateAll(abstractSession.getClusterId());
            }
            if (z && !this._sessionListeners.isEmpty()) {
                HttpSessionEvent httpSessionEvent = new HttpSessionEvent(abstractSession);
                for (je0 je0Var : this._sessionListeners) {
                    je0Var.sessionDestroyed(httpSessionEvent);
                }
            }
            if (z) {
                return;
            }
            abstractSession.willPassivate();
        }
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionManager
    public boolean removeSession(String str) {
        boolean z;
        synchronized (this) {
            Session session = (Session) this._sessions.remove(str);
            if (session != null) {
                try {
                    deleteSession(session);
                } catch (Exception e) {
                    Logger logger = LOG;
                    logger.warn("Problem deleting session id=" + str, e);
                }
            }
            z = session != null;
        }
        return z;
    }

    public void setSaveInterval(long j) {
        this._saveIntervalSec = j;
    }

    public void storeSession(Session session) throws Exception {
        if (session == null) {
            return;
        }
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String calculateRowId = calculateRowId(session);
            long currentTimeMillis = System.currentTimeMillis();
            connection.setAutoCommit(true);
            preparedStatement = connection.prepareStatement(this._jdbcSessionIdMgr._insertSession);
            preparedStatement.setString(1, calculateRowId);
            preparedStatement.setString(2, session.getId());
            preparedStatement.setString(3, session.getCanonicalContext());
            preparedStatement.setString(4, session.getVirtualHost());
            preparedStatement.setString(5, getSessionIdManager().getWorkerName());
            preparedStatement.setLong(6, session.getAccessed());
            preparedStatement.setLong(7, session.getLastAccessedTime());
            preparedStatement.setLong(8, session.getCreationTime());
            preparedStatement.setLong(9, session.getCookieSet());
            preparedStatement.setLong(10, currentTimeMillis);
            preparedStatement.setLong(11, session.getExpiryTime());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ObjectOutputStream(byteArrayOutputStream).writeObject(session.getAttributeMap());
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            preparedStatement.setBinaryStream(12, (InputStream) new ByteArrayInputStream(byteArray), byteArray.length);
            preparedStatement.executeUpdate();
            session.setRowId(calculateRowId);
            session.setLastSaved(currentTimeMillis);
            if (LOG.isDebugEnabled()) {
                Logger logger = LOG;
                logger.debug("Stored session " + session, new Object[0]);
            }
            try {
                preparedStatement.close();
            } catch (Exception e) {
                LOG.warn(e);
            }
            connection.close();
        } catch (Throwable th) {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (Exception e2) {
                    LOG.warn(e2);
                }
            }
            if (connection != null) {
                connection.close();
            }
            throw th;
        }
    }

    public void updateSession(Session session) throws Exception {
        if (session == null) {
            return;
        }
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            connection.setAutoCommit(true);
            preparedStatement = connection.prepareStatement(this._jdbcSessionIdMgr._updateSession);
            preparedStatement.setString(1, getSessionIdManager().getWorkerName());
            preparedStatement.setLong(2, session.getAccessed());
            preparedStatement.setLong(3, session.getLastAccessedTime());
            preparedStatement.setLong(4, currentTimeMillis);
            preparedStatement.setLong(5, session.getExpiryTime());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ObjectOutputStream(byteArrayOutputStream).writeObject(session.getAttributeMap());
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            preparedStatement.setBinaryStream(6, (InputStream) new ByteArrayInputStream(byteArray), byteArray.length);
            preparedStatement.setString(7, session.getRowId());
            preparedStatement.executeUpdate();
            session.setLastSaved(currentTimeMillis);
            if (LOG.isDebugEnabled()) {
                Logger logger = LOG;
                logger.debug("Updated session " + session, new Object[0]);
            }
            try {
                preparedStatement.close();
            } catch (Exception e) {
                LOG.warn(e);
            }
            connection.close();
        } catch (Throwable th) {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (Exception e2) {
                    LOG.warn(e2);
                }
            }
            if (connection != null) {
                connection.close();
            }
            throw th;
        }
    }

    public void updateSessionNode(Session session) throws Exception {
        String workerName = getSessionIdManager().getWorkerName();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            connection.setAutoCommit(true);
            preparedStatement = connection.prepareStatement(this._jdbcSessionIdMgr._updateSessionNode);
            preparedStatement.setString(1, workerName);
            preparedStatement.setString(2, session.getRowId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            if (LOG.isDebugEnabled()) {
                Logger logger = LOG;
                logger.debug("Updated last node for session id=" + session.getId() + ", lastNode = " + workerName, new Object[0]);
            }
            try {
                preparedStatement.close();
            } catch (Exception e) {
                LOG.warn(e);
            }
            connection.close();
        } catch (Throwable th) {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (Exception e2) {
                    LOG.warn(e2);
                }
            }
            if (connection != null) {
                connection.close();
            }
            throw th;
        }
    }
}
