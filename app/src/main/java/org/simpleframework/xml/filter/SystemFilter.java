package org.simpleframework.xml.filter;

/* loaded from: classes5.dex */
public class SystemFilter implements Filter {
    public Filter filter;

    public SystemFilter() {
        this(null);
    }

    public SystemFilter(Filter filter) {
        this.filter = filter;
    }

    @Override // org.simpleframework.xml.filter.Filter
    public String replace(String str) {
        String property = System.getProperty(str);
        if (property != null) {
            return property;
        }
        Filter filter = this.filter;
        if (filter == null) {
            return null;
        }
        return filter.replace(str);
    }
}
