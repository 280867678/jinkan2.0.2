package org.eclipse.jetty.security;

import me.tvspark.ae0;
import me.tvspark.ce0;

/* loaded from: classes4.dex */
public interface CrossContextPsuedoSession<T> {
    void clear(ae0 ae0Var);

    T fetch(ae0 ae0Var);

    void store(T t, ce0 ce0Var);
}
