package org.apache.http.config;

import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;

@Contract(threading = ThreadingBehavior.SAFE)
/* loaded from: classes4.dex */
public final class Registry<I> implements Lookup<I> {
    public final Map<String, I> map;

    public Registry(Map<String, I> map) {
        this.map = new ConcurrentHashMap(map);
    }

    @Override // org.apache.http.config.Lookup
    public I lookup(String str) {
        if (str == null) {
            return null;
        }
        return this.map.get(str.toLowerCase(Locale.ROOT));
    }

    public String toString() {
        return this.map.toString();
    }
}
