package org.litepal.crud.async;

import org.litepal.crud.callback.FindMultiCallback;

/* loaded from: classes5.dex */
public class FindMultiExecutor<T> extends AsyncExecutor {

    /* renamed from: cb */
    public FindMultiCallback<T> f4664cb;

    public FindMultiCallback<T> getListener() {
        return this.f4664cb;
    }

    public void listen(FindMultiCallback<T> findMultiCallback) {
        this.f4664cb = findMultiCallback;
        execute();
    }
}
