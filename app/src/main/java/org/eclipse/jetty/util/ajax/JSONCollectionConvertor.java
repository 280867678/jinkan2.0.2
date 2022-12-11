package org.eclipse.jetty.util.ajax;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import org.eclipse.jetty.util.Loader;
import org.eclipse.jetty.util.ajax.JSON;
import org.litepal.parser.LitePalParser;

/* loaded from: classes5.dex */
public class JSONCollectionConvertor implements JSON.Convertor {
    @Override // org.eclipse.jetty.util.ajax.JSON.Convertor
    public Object fromJSON(Map map) {
        try {
            Collection collection = (Collection) Loader.loadClass(getClass(), (String) map.get("class")).newInstance();
            Collections.addAll(collection, (Object[]) map.get(LitePalParser.NODE_LIST));
            return collection;
        } catch (Exception e) {
            if (!(e instanceof RuntimeException)) {
                throw new RuntimeException(e);
            }
            throw ((RuntimeException) e);
        }
    }

    @Override // org.eclipse.jetty.util.ajax.JSON.Convertor
    public void toJSON(Object obj, JSON.Output output) {
        output.addClass(obj.getClass());
        output.add(LitePalParser.NODE_LIST, ((Collection) obj).toArray());
    }
}
