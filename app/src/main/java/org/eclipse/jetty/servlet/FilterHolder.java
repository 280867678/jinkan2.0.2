package org.eclipse.jetty.servlet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletException;
import org.eclipse.jetty.servlet.Holder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.util.TypeUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes5.dex */
public class FilterHolder extends Holder<Filter> {
    public static final Logger LOG = Log.getLogger(FilterHolder.class);
    public transient Config _config;
    public transient Filter _filter;
    public transient FilterRegistration.Dynamic _registration;

    /* loaded from: classes5.dex */
    public class Config extends Holder<Filter>.HolderConfig implements FilterConfig {
        public Config() {
            super();
        }

        @Override // javax.servlet.FilterConfig
        public String getFilterName() {
            return FilterHolder.this._name;
        }
    }

    /* loaded from: classes5.dex */
    public class Registration extends Holder<Filter>.HolderRegistration implements FilterRegistration.Dynamic {
        public Registration() {
            super();
        }

        @Override // javax.servlet.FilterRegistration
        public void addMappingForServletNames(EnumSet<DispatcherType> enumSet, boolean z, String... strArr) {
            FilterHolder.this.illegalStateIfContextStarted();
            FilterMapping filterMapping = new FilterMapping();
            filterMapping.setFilterHolder(FilterHolder.this);
            filterMapping.setServletNames(strArr);
            filterMapping.setDispatcherTypes(enumSet);
            ServletHandler servletHandler = FilterHolder.this._servletHandler;
            if (z) {
                servletHandler.addFilterMapping(filterMapping);
            } else {
                servletHandler.prependFilterMapping(filterMapping);
            }
        }

        @Override // javax.servlet.FilterRegistration
        public void addMappingForUrlPatterns(EnumSet<DispatcherType> enumSet, boolean z, String... strArr) {
            FilterHolder.this.illegalStateIfContextStarted();
            FilterMapping filterMapping = new FilterMapping();
            filterMapping.setFilterHolder(FilterHolder.this);
            filterMapping.setPathSpecs(strArr);
            filterMapping.setDispatcherTypes(enumSet);
            ServletHandler servletHandler = FilterHolder.this._servletHandler;
            if (z) {
                servletHandler.addFilterMapping(filterMapping);
            } else {
                servletHandler.prependFilterMapping(filterMapping);
            }
        }

        @Override // javax.servlet.FilterRegistration
        public Collection<String> getServletNameMappings() {
            String[] servletNames;
            FilterMapping[] filterMappings = FilterHolder.this._servletHandler.getFilterMappings();
            ArrayList arrayList = new ArrayList();
            for (FilterMapping filterMapping : filterMappings) {
                if (filterMapping.getFilterHolder() == FilterHolder.this && (servletNames = filterMapping.getServletNames()) != null && servletNames.length > 0) {
                    arrayList.addAll(Arrays.asList(servletNames));
                }
            }
            return arrayList;
        }

        @Override // javax.servlet.FilterRegistration
        public Collection<String> getUrlPatternMappings() {
            FilterMapping[] filterMappings = FilterHolder.this._servletHandler.getFilterMappings();
            ArrayList arrayList = new ArrayList();
            for (FilterMapping filterMapping : filterMappings) {
                if (filterMapping.getFilterHolder() == FilterHolder.this) {
                    arrayList.addAll(TypeUtil.asList(filterMapping.getPathSpecs()));
                }
            }
            return arrayList;
        }
    }

    public FilterHolder() {
        this(Holder.Source.EMBEDDED);
    }

    public FilterHolder(Class<? extends Filter> cls) {
        this(Holder.Source.EMBEDDED);
        setHeldClass(cls);
    }

    public FilterHolder(Filter filter) {
        this(Holder.Source.EMBEDDED);
        setFilter(filter);
    }

    public FilterHolder(Holder.Source source) {
        super(source);
    }

    @Override // org.eclipse.jetty.servlet.Holder
    public void destroyInstance(Object obj) throws Exception {
        if (obj == null) {
            return;
        }
        Filter filter = (Filter) obj;
        filter.destroy();
        getServletHandler().destroyFilter(filter);
    }

    @Override // org.eclipse.jetty.servlet.Holder, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        super.doStart();
        if (!Filter.class.isAssignableFrom(this._class)) {
            String str = this._class + " is not a javax.servlet.Filter";
            super.stop();
            throw new IllegalStateException(str);
        }
        if (this._filter == null) {
            try {
                this._filter = ((ServletContextHandler.Context) this._servletHandler.getServletContext()).createFilter(getHeldClass());
            } catch (ServletException e) {
                Throwable rootCause = e.getRootCause();
                if (rootCause instanceof InstantiationException) {
                    throw ((InstantiationException) rootCause);
                }
                if (!(rootCause instanceof IllegalAccessException)) {
                    throw e;
                }
                throw ((IllegalAccessException) rootCause);
            }
        }
        Config config = new Config();
        this._config = config;
        this._filter.init(config);
    }

    @Override // org.eclipse.jetty.servlet.Holder, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        Filter filter = this._filter;
        if (filter != null) {
            try {
                destroyInstance(filter);
            } catch (Exception e) {
                LOG.warn(e);
            }
        }
        if (!this._extInstance) {
            this._filter = null;
        }
        this._config = null;
        super.doStop();
    }

    public Filter getFilter() {
        return this._filter;
    }

    public FilterRegistration.Dynamic getRegistration() {
        if (this._registration == null) {
            this._registration = new Registration();
        }
        return this._registration;
    }

    public synchronized void setFilter(Filter filter) {
        this._filter = filter;
        this._extInstance = true;
        setHeldClass(filter.getClass());
        if (getName() == null) {
            setName(filter.getClass().getName());
        }
    }

    @Override // org.eclipse.jetty.servlet.Holder
    public String toString() {
        return getName();
    }
}
