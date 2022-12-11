package org.simpleframework.xml.core;

import org.simpleframework.xml.filter.Filter;

/* loaded from: classes5.dex */
public class TemplateFilter implements Filter {
    public Context context;
    public Filter filter;

    public TemplateFilter(Context context, Filter filter) {
        this.context = context;
        this.filter = filter;
    }

    @Override // org.simpleframework.xml.filter.Filter
    public String replace(String str) {
        Object attribute = this.context.getAttribute(str);
        return attribute != null ? attribute.toString() : this.filter.replace(str);
    }
}
