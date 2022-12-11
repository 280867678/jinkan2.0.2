package org.eclipse.jetty.server.session;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import me.tvspark.ae0;
import me.tvspark.fe0;
import me.tvspark.he0;
import me.tvspark.ie0;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.jetty.server.session.AbstractSessionManager;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes4.dex */
public abstract class AbstractSession implements AbstractSessionManager.SessionIf {
    public static final Logger LOG = SessionHandler.LOG;
    public long _accessed;
    public final Map<String, Object> _attributes;
    public final String _clusterId;
    public long _cookieSet;
    public final long _created;
    public boolean _doInvalidate;
    public boolean _idChanged;
    public boolean _invalid;
    public long _lastAccessed;
    public final AbstractSessionManager _manager;
    public long _maxIdleMs;
    public boolean _newSession;
    public final String _nodeId;
    public int _requests;

    public AbstractSession(AbstractSessionManager abstractSessionManager, long j, long j2, String str) {
        this._attributes = new HashMap();
        this._manager = abstractSessionManager;
        this._created = j;
        this._clusterId = str;
        this._nodeId = abstractSessionManager._sessionIdManager.getNodeId(str, null);
        this._accessed = j2;
        this._lastAccessed = j2;
        this._requests = 1;
        int i = this._manager._dftMaxIdleSecs;
        this._maxIdleMs = i > 0 ? i * 1000 : -1L;
        if (LOG.isDebugEnabled()) {
            Logger logger = LOG;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("new session ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._nodeId);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(StringUtils.SPACE);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._clusterId);
            logger.debug(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), new Object[0]);
        }
    }

    public AbstractSession(AbstractSessionManager abstractSessionManager, ae0 ae0Var) {
        this._attributes = new HashMap();
        this._manager = abstractSessionManager;
        this._newSession = true;
        long currentTimeMillis = System.currentTimeMillis();
        this._created = currentTimeMillis;
        String newSessionId = this._manager._sessionIdManager.newSessionId(ae0Var, currentTimeMillis);
        this._clusterId = newSessionId;
        this._nodeId = this._manager._sessionIdManager.getNodeId(newSessionId, ae0Var);
        long j = this._created;
        this._accessed = j;
        this._lastAccessed = j;
        this._requests = 1;
        int i = this._manager._dftMaxIdleSecs;
        this._maxIdleMs = i > 0 ? i * 1000 : -1L;
        if (LOG.isDebugEnabled()) {
            Logger logger = LOG;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("new session & id ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._nodeId);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(StringUtils.SPACE);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._clusterId);
            logger.debug(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), new Object[0]);
        }
    }

    public boolean access(long j) {
        synchronized (this) {
            if (this._invalid) {
                return false;
            }
            this._newSession = false;
            long j2 = this._accessed;
            this._lastAccessed = j2;
            this._accessed = j;
            if (this._maxIdleMs <= 0 || j2 <= 0 || j2 + this._maxIdleMs >= j) {
                this._requests++;
                return true;
            }
            invalidate();
            return false;
        }
    }

    public void addAttributes(Map<String, Object> map) {
        this._attributes.putAll(map);
    }

    public void bindValue(String str, Object obj) {
        if (obj == null || !(obj instanceof he0)) {
            return;
        }
        ((he0) obj).valueBound(new HttpSessionBindingEvent(this, str));
    }

    public void checkValid() throws IllegalStateException {
        if (!this._invalid) {
            return;
        }
        throw new IllegalStateException();
    }

    public void clearAttributes() {
        ArrayList arrayList;
        Object doPutOrRemove;
        while (true) {
            Map<String, Object> map = this._attributes;
            if (map == null || map.size() <= 0) {
                break;
            }
            synchronized (this) {
                arrayList = new ArrayList(this._attributes.keySet());
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                synchronized (this) {
                    doPutOrRemove = doPutOrRemove(str, null);
                }
                unbindValue(str, doPutOrRemove);
                this._manager.doSessionAttributeListeners(this, str, doPutOrRemove, null);
            }
        }
        Map<String, Object> map2 = this._attributes;
        if (map2 != null) {
            map2.clear();
        }
    }

    public void complete() {
        synchronized (this) {
            int i = this._requests - 1;
            this._requests = i;
            if (this._doInvalidate && i <= 0) {
                doInvalidate();
            }
        }
    }

    public void cookieSet() {
        synchronized (this) {
            this._cookieSet = this._accessed;
        }
    }

    public void didActivate() {
        synchronized (this) {
            HttpSessionEvent httpSessionEvent = new HttpSessionEvent(this);
            for (Object obj : this._attributes.values()) {
                if (obj instanceof fe0) {
                    ((fe0) obj).sessionDidActivate(httpSessionEvent);
                }
            }
        }
    }

    public Object doGet(String str) {
        return this._attributes.get(str);
    }

    public void doInvalidate() throws IllegalStateException {
        try {
            LOG.debug("invalidate {}", this._clusterId);
            if (isValid()) {
                clearAttributes();
            }
            synchronized (this) {
                this._invalid = true;
            }
        } catch (Throwable th) {
            synchronized (this) {
                this._invalid = true;
                throw th;
            }
        }
    }

    public Object doPutOrRemove(String str, Object obj) {
        return obj == null ? this._attributes.remove(str) : this._attributes.put(str, obj);
    }

    public long getAccessed() {
        long j;
        synchronized (this) {
            j = this._accessed;
        }
        return j;
    }

    @Override // me.tvspark.ee0
    public Object getAttribute(String str) {
        Object obj;
        synchronized (this) {
            checkValid();
            obj = this._attributes.get(str);
        }
        return obj;
    }

    public Map<String, Object> getAttributeMap() {
        return this._attributes;
    }

    @Override // me.tvspark.ee0
    public Enumeration<String> getAttributeNames() {
        Enumeration<String> enumeration;
        synchronized (this) {
            checkValid();
            enumeration = Collections.enumeration(this._attributes == null ? Collections.EMPTY_LIST : new ArrayList(this._attributes.keySet()));
        }
        return enumeration;
    }

    public int getAttributes() {
        int size;
        synchronized (this) {
            checkValid();
            size = this._attributes.size();
        }
        return size;
    }

    public String getClusterId() {
        return this._clusterId;
    }

    public long getCookieSetTime() {
        return this._cookieSet;
    }

    public long getCreationTime() throws IllegalStateException {
        return this._created;
    }

    @Override // me.tvspark.ee0
    public String getId() throws IllegalStateException {
        return this._manager._nodeIdInSessionId ? this._nodeId : this._clusterId;
    }

    public long getLastAccessedTime() throws IllegalStateException {
        checkValid();
        return this._lastAccessed;
    }

    public int getMaxInactiveInterval() {
        return (int) (this._maxIdleMs / 1000);
    }

    public Set<String> getNames() {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this._attributes.keySet());
        }
        return hashSet;
    }

    public String getNodeId() {
        return this._nodeId;
    }

    public int getRequests() {
        int i;
        synchronized (this) {
            i = this._requests;
        }
        return i;
    }

    public ServletContext getServletContext() {
        return this._manager._context;
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionManager.SessionIf
    public AbstractSession getSession() {
        return this;
    }

    @Deprecated
    public ie0 getSessionContext() throws IllegalStateException {
        checkValid();
        return AbstractSessionManager.__nullSessionContext;
    }

    @Deprecated
    public Object getValue(String str) throws IllegalStateException {
        return getAttribute(str);
    }

    @Deprecated
    public String[] getValueNames() throws IllegalStateException {
        synchronized (this) {
            checkValid();
            if (this._attributes == null) {
                return new String[0];
            }
            return (String[]) this._attributes.keySet().toArray(new String[this._attributes.size()]);
        }
    }

    @Override // me.tvspark.ee0
    public void invalidate() throws IllegalStateException {
        this._manager.removeSession(this, true);
        doInvalidate();
    }

    public boolean isIdChanged() {
        return this._idChanged;
    }

    public boolean isNew() throws IllegalStateException {
        checkValid();
        return this._newSession;
    }

    public boolean isValid() {
        return !this._invalid;
    }

    @Deprecated
    public void putValue(String str, Object obj) throws IllegalStateException {
        setAttribute(str, obj);
    }

    @Override // me.tvspark.ee0
    public void removeAttribute(String str) {
        setAttribute(str, null);
    }

    @Deprecated
    public void removeValue(String str) throws IllegalStateException {
        removeAttribute(str);
    }

    @Override // me.tvspark.ee0
    public void setAttribute(String str, Object obj) {
        Object doPutOrRemove;
        synchronized (this) {
            checkValid();
            doPutOrRemove = doPutOrRemove(str, obj);
        }
        if (obj == null || !obj.equals(doPutOrRemove)) {
            if (doPutOrRemove != null) {
                unbindValue(str, doPutOrRemove);
            }
            if (obj != null) {
                bindValue(str, obj);
            }
            this._manager.doSessionAttributeListeners(this, str, doPutOrRemove, obj);
        }
    }

    public void setIdChanged(boolean z) {
        this._idChanged = z;
    }

    public void setLastAccessedTime(long j) {
        this._lastAccessed = j;
    }

    public void setMaxInactiveInterval(int i) {
        this._maxIdleMs = i * 1000;
    }

    public void setRequests(int i) {
        synchronized (this) {
            this._requests = i;
        }
    }

    public void timeout() throws IllegalStateException {
        boolean z = true;
        this._manager.removeSession(this, true);
        synchronized (this) {
            if (!this._invalid) {
                if (this._requests > 0) {
                    this._doInvalidate = true;
                }
            }
            z = false;
        }
        if (z) {
            doInvalidate();
        }
    }

    public String toString() {
        return getClass().getName() + ":" + getId() + "@" + hashCode();
    }

    public void unbindValue(String str, Object obj) {
        if (obj == null || !(obj instanceof he0)) {
            return;
        }
        ((he0) obj).valueUnbound(new HttpSessionBindingEvent(this, str));
    }

    public void willPassivate() {
        synchronized (this) {
            HttpSessionEvent httpSessionEvent = new HttpSessionEvent(this);
            for (Object obj : this._attributes.values()) {
                if (obj instanceof fe0) {
                    ((fe0) obj).sessionWillPassivate(httpSessionEvent);
                }
            }
        }
    }
}
