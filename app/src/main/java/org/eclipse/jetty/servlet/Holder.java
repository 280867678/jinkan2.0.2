package org.eclipse.jetty.servlet;

import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.servlet.Registration;
import javax.servlet.ServletContext;
import javax.servlet.UnavailableException;
import me.tvspark.outline;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.util.Loader;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.component.AggregateLifeCycle;
import org.eclipse.jetty.util.component.Dumpable;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes5.dex */
public class Holder<T> extends AbstractLifeCycle implements Dumpable {
    public static final Logger LOG = Log.getLogger(Holder.class);
    public boolean _asyncSupported;
    public transient Class<? extends T> _class;
    public String _className;
    public String _displayName;
    public boolean _extInstance;
    public final Map<String, String> _initParams = new HashMap(3);
    public String _name;
    public ServletHandler _servletHandler;
    public final Source _source;

    /* renamed from: org.eclipse.jetty.servlet.Holder$1 */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class C30071 {
        public static final /* synthetic */ int[] $SwitchMap$org$eclipse$jetty$servlet$Holder$Source;

        static {
            int[] iArr = new int[Source.values().length];
            $SwitchMap$org$eclipse$jetty$servlet$Holder$Source = iArr;
            try {
                Source source = Source.JAVAX_API;
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = $SwitchMap$org$eclipse$jetty$servlet$Holder$Source;
                Source source2 = Source.DESCRIPTOR;
                iArr2[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = $SwitchMap$org$eclipse$jetty$servlet$Holder$Source;
                Source source3 = Source.ANNOTATION;
                iArr3[3] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class HolderConfig {
        public HolderConfig() {
        }

        public String getInitParameter(String str) {
            return Holder.this.getInitParameter(str);
        }

        public Enumeration getInitParameterNames() {
            return Holder.this.getInitParameterNames();
        }

        public ServletContext getServletContext() {
            return Holder.this._servletHandler.getServletContext();
        }
    }

    /* loaded from: classes5.dex */
    public class HolderRegistration implements Registration.Dynamic {
        public HolderRegistration() {
        }

        @Override // javax.servlet.Registration
        public String getClassName() {
            return Holder.this.getClassName();
        }

        @Override // javax.servlet.Registration
        public String getInitParameter(String str) {
            return Holder.this.getInitParameter(str);
        }

        @Override // javax.servlet.Registration
        public Map<String, String> getInitParameters() {
            return Holder.this.getInitParameters();
        }

        @Override // javax.servlet.Registration
        public String getName() {
            return Holder.this.getName();
        }

        @Override // javax.servlet.Registration.Dynamic
        public void setAsyncSupported(boolean z) {
            Holder.this.illegalStateIfContextStarted();
            Holder.this.setAsyncSupported(z);
        }

        public void setDescription(String str) {
            if (Holder.LOG.isDebugEnabled()) {
                Logger logger = Holder.LOG;
                logger.debug(this + " is " + str, new Object[0]);
            }
        }

        @Override // javax.servlet.Registration
        public boolean setInitParameter(String str, String str2) {
            Holder.this.illegalStateIfContextStarted();
            if (str != null) {
                if (str2 == null) {
                    throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("non-null value required for init parameter ", str));
                }
                if (Holder.this.getInitParameter(str) != null) {
                    return false;
                }
                Holder.this.setInitParameter(str, str2);
                return true;
            }
            throw new IllegalArgumentException("init parameter name required");
        }

        @Override // javax.servlet.Registration
        public Set<String> setInitParameters(Map<String, String> map) {
            Holder.this.illegalStateIfContextStarted();
            HashSet hashSet = null;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey() == null) {
                    throw new IllegalArgumentException("init parameter name required");
                }
                if (entry.getValue() == null) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("non-null value required for init parameter ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(entry.getKey());
                    throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                } else if (Holder.this.getInitParameter(entry.getKey()) != null) {
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(entry.getKey());
                }
            }
            if (hashSet != null) {
                return hashSet;
            }
            Holder.this.getInitParameters().putAll(map);
            return Collections.emptySet();
        }
    }

    /* loaded from: classes5.dex */
    public enum Source {
        EMBEDDED,
        JAVAX_API,
        DESCRIPTOR,
        ANNOTATION
    }

    public Holder(Source source) {
        this._source = source;
        int ordinal = source.ordinal();
        if (ordinal == 1 || ordinal == 2 || ordinal == 3) {
            this._asyncSupported = false;
        } else {
            this._asyncSupported = true;
        }
    }

    public void destroyInstance(Object obj) throws Exception {
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        String str;
        if (this._class == null && ((str = this._className) == null || str.equals(""))) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("No class for Servlet or Filter for ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._name);
            throw new UnavailableException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        } else if (this._class != null) {
        } else {
            try {
                this._class = Loader.loadClass(Holder.class, this._className);
                if (!LOG.isDebugEnabled()) {
                    return;
                }
                LOG.debug("Holding {}", this._class);
            } catch (Exception e) {
                LOG.warn(e);
                throw new UnavailableException(e.getMessage());
            }
        }
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        if (!this._extInstance) {
            this._class = null;
        }
    }

    @Override // org.eclipse.jetty.util.component.Dumpable
    public String dump() {
        return AggregateLifeCycle.dump(this);
    }

    @Override // org.eclipse.jetty.util.component.Dumpable
    public void dump(Appendable appendable, String str) throws IOException {
        appendable.append(this._name).append("==").append(this._className).append(" - ").append(AbstractLifeCycle.getState(this)).append("\n");
        AggregateLifeCycle.dump(appendable, str, this._initParams.entrySet());
    }

    public String getClassName() {
        return this._className;
    }

    public String getDisplayName() {
        return this._displayName;
    }

    public Class<? extends T> getHeldClass() {
        return this._class;
    }

    public String getInitParameter(String str) {
        Map<String, String> map = this._initParams;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public Enumeration getInitParameterNames() {
        Map<String, String> map = this._initParams;
        return Collections.enumeration(map == null ? Collections.EMPTY_LIST : map.keySet());
    }

    public Map<String, String> getInitParameters() {
        return this._initParams;
    }

    public String getName() {
        return this._name;
    }

    public ServletHandler getServletHandler() {
        return this._servletHandler;
    }

    public Source getSource() {
        return this._source;
    }

    public void illegalStateIfContextStarted() {
        ContextHandler.Context context;
        ServletHandler servletHandler = this._servletHandler;
        if (servletHandler == null || (context = (ContextHandler.Context) servletHandler.getServletContext()) == null || !context.getContextHandler().isStarted()) {
            return;
        }
        throw new IllegalStateException("Started");
    }

    public boolean isAsyncSupported() {
        return this._asyncSupported;
    }

    public boolean isInstance() {
        return this._extInstance;
    }

    public void setAsyncSupported(boolean z) {
        this._asyncSupported = z;
    }

    public void setClassName(String str) {
        this._className = str;
        this._class = null;
        if (this._name == null) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "-");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Integer.toHexString(hashCode()));
            this._name = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
    }

    public void setDisplayName(String str) {
        this._displayName = str;
    }

    public void setHeldClass(Class<? extends T> cls) {
        this._class = cls;
        if (cls != null) {
            this._className = cls.getName();
            if (this._name != null) {
                return;
            }
            this._name = cls.getName() + "-" + Integer.toHexString(hashCode());
        }
    }

    public void setInitParameter(String str, String str2) {
        this._initParams.put(str, str2);
    }

    public void setInitParameters(Map<String, String> map) {
        this._initParams.clear();
        this._initParams.putAll(map);
    }

    public void setName(String str) {
        this._name = str;
    }

    public void setServletHandler(ServletHandler servletHandler) {
        this._servletHandler = servletHandler;
    }

    public String toString() {
        return this._name;
    }
}
