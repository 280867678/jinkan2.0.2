package org.simpleframework.xml.core;

import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.LimitedCache;

/* loaded from: classes5.dex */
public class ExpressionBuilder {
    public final Cache<Expression> cache = new LimitedCache();
    public final Format format;
    public final Class type;

    public ExpressionBuilder(Detail detail, Support support) {
        this.format = support.getFormat();
        this.type = detail.getType();
    }

    private Expression create(String str) throws Exception {
        PathParser pathParser = new PathParser(str, new ClassType(this.type), this.format);
        Cache<Expression> cache = this.cache;
        if (cache != null) {
            cache.cache(str, pathParser);
        }
        return pathParser;
    }

    public Expression build(String str) throws Exception {
        Expression fetch = this.cache.fetch(str);
        return fetch == null ? create(str) : fetch;
    }
}
