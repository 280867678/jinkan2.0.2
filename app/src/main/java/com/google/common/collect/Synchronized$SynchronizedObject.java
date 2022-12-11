package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class Synchronized$SynchronizedObject implements Serializable {
    public static final long serialVersionUID = 0;
    public final Object delegate;
    public final Object mutex;

    public Synchronized$SynchronizedObject(Object obj, Object obj2) {
        if (obj != null) {
            this.delegate = obj;
            this.mutex = obj2 == null ? this : obj2;
            return;
        }
        throw null;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.mutex) {
            objectOutputStream.defaultWriteObject();
        }
    }

    /* renamed from: delegate */
    public Object mo4780delegate() {
        return this.delegate;
    }

    public String toString() {
        String obj;
        synchronized (this.mutex) {
            obj = this.delegate.toString();
        }
        return obj;
    }
}
