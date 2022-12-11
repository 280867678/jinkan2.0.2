package com.google.common.util.concurrent;

import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import me.tvspark.C2579rz;

/* loaded from: classes3.dex */
public enum FuturesGetChecked$GetCheckedTypeValidatorHolder$WeakSetValidator {
    INSTANCE;
    
    public static final Set<WeakReference<Class<? extends Exception>>> validClasses = new CopyOnWriteArraySet();

    public void validateClass(Class<? extends Exception> cls) {
        for (WeakReference<Class<? extends Exception>> weakReference : validClasses) {
            if (cls.equals(weakReference.get())) {
                return;
            }
        }
        C2579rz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls);
        if (validClasses.size() > 1000) {
            validClasses.clear();
        }
        validClasses.add(new WeakReference<>(cls));
    }
}
