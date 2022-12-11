package org.litepal.crud.async;

import org.litepal.crud.callback.CountCallback;

/* loaded from: classes5.dex */
public class CountExecutor extends AsyncExecutor {

    /* renamed from: cb */
    public CountCallback f4662cb;

    public CountCallback getListener() {
        return this.f4662cb;
    }

    public void listen(CountCallback countCallback) {
        this.f4662cb = countCallback;
        execute();
    }
}
