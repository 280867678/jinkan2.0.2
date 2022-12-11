package org.simpleframework.xml.filter;

import java.util.Map;

/* loaded from: classes5.dex */
public class MapFilter implements Filter {
    public Filter filter;
    public Map map;

    public MapFilter(Map map) {
        this(map, null);
    }

    public MapFilter(Map map, Filter filter) {
        this.filter = filter;
        this.map = map;
    }

    @Override // org.simpleframework.xml.filter.Filter
    public String replace(String str) {
        Map map = this.map;
        Object obj = map != null ? map.get(str) : null;
        if (obj != null) {
            return obj.toString();
        }
        Filter filter = this.filter;
        if (filter == null) {
            return null;
        }
        return filter.replace(str);
    }
}
