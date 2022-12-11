package org.simpleframework.xml.filter;

/* loaded from: classes5.dex */
public class EnvironmentFilter implements Filter {
    public Filter filter;

    public EnvironmentFilter() {
        this(null);
    }

    public EnvironmentFilter(Filter filter) {
        this.filter = filter;
    }

    @Override // org.simpleframework.xml.filter.Filter
    public String replace(String str) {
        String str2 = System.getenv(str);
        if (str2 != null) {
            return str2;
        }
        Filter filter = this.filter;
        if (filter == null) {
            return null;
        }
        return filter.replace(str);
    }
}
