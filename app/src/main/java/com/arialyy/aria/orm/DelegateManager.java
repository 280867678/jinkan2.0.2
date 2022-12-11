package com.arialyy.aria.orm;

import android.util.SparseArray;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes3.dex */
public class DelegateManager {
    public static volatile DelegateManager INSTANCE;
    public final String TAG = "ModuleFactory";
    public SparseArray<AbsDelegate> mDelegates = new SparseArray<>();

    public static DelegateManager getInstance() {
        if (INSTANCE == null) {
            synchronized (DelegateManager.class) {
                INSTANCE = new DelegateManager();
            }
        }
        return INSTANCE;
    }

    public <M extends AbsDelegate> M getDelegate(Class<M> cls) {
        M newInstance;
        M m = (M) this.mDelegates.get(cls.hashCode());
        if (m == null) {
            try {
                Constructor<M> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                newInstance = declaredConstructor.newInstance(new Object[0]);
            } catch (IllegalAccessException e) {
                e = e;
            } catch (InstantiationException e2) {
                e = e2;
            } catch (NoSuchMethodException e3) {
                e = e3;
            } catch (InvocationTargetException e4) {
                e = e4;
            }
            try {
                this.mDelegates.put(cls.hashCode(), newInstance);
                return newInstance;
            } catch (IllegalAccessException e5) {
                e = e5;
                m = newInstance;
                e.printStackTrace();
                return m;
            } catch (InstantiationException e6) {
                e = e6;
                m = newInstance;
                e.printStackTrace();
                return m;
            } catch (NoSuchMethodException e7) {
                e = e7;
                m = newInstance;
                e.printStackTrace();
                return m;
            } catch (InvocationTargetException e8) {
                e = e8;
                m = newInstance;
                e.printStackTrace();
                return m;
            }
        }
        return m;
    }
}
