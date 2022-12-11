package org.simpleframework.xml.transform;

import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

/* loaded from: classes5.dex */
public class RegistryMatcher implements Matcher {
    public final Cache<Transform> transforms = new ConcurrentCache();
    public final Cache<Class> types = new ConcurrentCache();

    private Transform create(Class cls) throws Exception {
        Class fetch = this.types.fetch(cls);
        if (fetch != null) {
            return create(cls, fetch);
        }
        return null;
    }

    private Transform create(Class cls, Class cls2) throws Exception {
        Transform transform = (Transform) cls2.newInstance();
        if (transform != null) {
            this.transforms.cache(cls, transform);
        }
        return transform;
    }

    public void bind(Class cls, Class cls2) {
        this.types.cache(cls, cls2);
    }

    public void bind(Class cls, Transform transform) {
        this.transforms.cache(cls, transform);
    }

    @Override // org.simpleframework.xml.transform.Matcher
    public Transform match(Class cls) throws Exception {
        Transform fetch = this.transforms.fetch(cls);
        return fetch == null ? create(cls) : fetch;
    }
}
