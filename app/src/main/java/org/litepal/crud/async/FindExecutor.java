package org.litepal.crud.async;

import org.litepal.crud.callback.FindCallback;

/* loaded from: classes5.dex */
public class FindExecutor<T> extends AsyncExecutor {

    /* renamed from: cb */
    public FindCallback<T> f4663cb;

    public FindCallback<T> getListener() {
        return this.f4663cb;
    }

    public void listen(FindCallback<T> findCallback) {
        this.f4663cb = findCallback;
        execute();
    }
}
