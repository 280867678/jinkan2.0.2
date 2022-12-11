package org.apache.commons.lang3.concurrent;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import me.tvspark.outline;

/* loaded from: classes4.dex */
public class MultiBackgroundInitializer extends BackgroundInitializer<MultiBackgroundInitializerResults> {
    public final Map<String, BackgroundInitializer<?>> childInitializers = new HashMap();

    /* loaded from: classes4.dex */
    public static class MultiBackgroundInitializerResults {
        public final Map<String, ConcurrentException> exceptions;
        public final Map<String, BackgroundInitializer<?>> initializers;
        public final Map<String, Object> resultObjects;

        public MultiBackgroundInitializerResults(Map<String, BackgroundInitializer<?>> map, Map<String, Object> map2, Map<String, ConcurrentException> map3) {
            this.initializers = map;
            this.resultObjects = map2;
            this.exceptions = map3;
        }

        private BackgroundInitializer<?> checkName(String str) {
            BackgroundInitializer<?> backgroundInitializer = this.initializers.get(str);
            if (backgroundInitializer != null) {
                return backgroundInitializer;
            }
            throw new NoSuchElementException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("No child initializer with name ", str));
        }

        public ConcurrentException getException(String str) {
            checkName(str);
            return this.exceptions.get(str);
        }

        public BackgroundInitializer<?> getInitializer(String str) {
            return checkName(str);
        }

        public Object getResultObject(String str) {
            checkName(str);
            return this.resultObjects.get(str);
        }

        public Set<String> initializerNames() {
            return Collections.unmodifiableSet(this.initializers.keySet());
        }

        public boolean isException(String str) {
            checkName(str);
            return this.exceptions.containsKey(str);
        }

        public boolean isSuccessful() {
            return this.exceptions.isEmpty();
        }
    }

    public MultiBackgroundInitializer() {
    }

    public MultiBackgroundInitializer(ExecutorService executorService) {
        super(executorService);
    }

    public void addInitializer(String str, BackgroundInitializer<?> backgroundInitializer) {
        if (str != null) {
            if (backgroundInitializer == null) {
                throw new IllegalArgumentException("Child initializer must not be null!");
            }
            synchronized (this) {
                if (isStarted()) {
                    throw new IllegalStateException("addInitializer() must not be called after start()!");
                }
                this.childInitializers.put(str, backgroundInitializer);
            }
            return;
        }
        throw new IllegalArgumentException("Name of child initializer must not be null!");
    }

    @Override // org.apache.commons.lang3.concurrent.BackgroundInitializer
    public int getTaskCount() {
        int i = 1;
        for (BackgroundInitializer<?> backgroundInitializer : this.childInitializers.values()) {
            i += backgroundInitializer.getTaskCount();
        }
        return i;
    }

    @Override // org.apache.commons.lang3.concurrent.BackgroundInitializer
    public MultiBackgroundInitializerResults initialize() throws Exception {
        HashMap hashMap;
        synchronized (this) {
            hashMap = new HashMap(this.childInitializers);
        }
        ExecutorService activeExecutor = getActiveExecutor();
        for (BackgroundInitializer backgroundInitializer : hashMap.values()) {
            if (backgroundInitializer.getExternalExecutor() == null) {
                backgroundInitializer.setExternalExecutor(activeExecutor);
            }
            backgroundInitializer.start();
        }
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        for (Map.Entry entry : hashMap.entrySet()) {
            try {
                hashMap2.put(entry.getKey(), ((BackgroundInitializer) entry.getValue()).get());
            } catch (ConcurrentException e) {
                hashMap3.put(entry.getKey(), e);
            }
        }
        return new MultiBackgroundInitializerResults(hashMap, hashMap2, hashMap3);
    }
}
