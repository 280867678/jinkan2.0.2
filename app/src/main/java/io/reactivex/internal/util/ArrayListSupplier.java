package io.reactivex.internal.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import me.tvspark.f70;

/* loaded from: classes4.dex */
public enum ArrayListSupplier implements Callable<List<Object>>, f70<Object, List<Object>> {
    INSTANCE;

    public static <T> Callable<List<T>> asCallable() {
        return INSTANCE;
    }

    public static <T, O> f70<O, List<T>> asFunction() {
        return INSTANCE;
    }

    @Override // me.tvspark.f70
    public List<Object> apply(Object obj) throws Exception {
        return new ArrayList();
    }

    @Override // java.util.concurrent.Callable
    public List<Object> call() throws Exception {
        return new ArrayList();
    }
}
