package org.simpleframework.xml.convert;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.util.ConcurrentCache;

/* loaded from: classes5.dex */
public class ScannerBuilder extends ConcurrentCache<Scanner> {

    /* loaded from: classes5.dex */
    public static class Entry extends ConcurrentCache<Annotation> implements Scanner {
        public final Class root;

        public Entry(Class cls) {
            this.root = cls;
        }

        private <T extends Annotation> T find(Class<T> cls) {
            for (Class cls2 = this.root; cls2 != null; cls2 = cls2.getSuperclass()) {
                T t = (T) cls2.getAnnotation(cls);
                if (t != null) {
                    return t;
                }
            }
            return null;
        }

        @Override // org.simpleframework.xml.convert.Scanner
        public <T extends Annotation> T scan(Class<T> cls) {
            if (!contains(cls)) {
                Annotation find = find(cls);
                if (cls != null && find != null) {
                    put(cls, find);
                }
            }
            return (T) get(cls);
        }
    }

    public Scanner build(Class<?> cls) {
        Scanner scanner = get(cls);
        if (scanner == null) {
            Entry entry = new Entry(cls);
            put(cls, entry);
            return entry;
        }
        return scanner;
    }
}
