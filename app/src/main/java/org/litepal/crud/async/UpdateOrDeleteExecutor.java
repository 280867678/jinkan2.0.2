package org.litepal.crud.async;

import org.litepal.crud.callback.UpdateOrDeleteCallback;

/* loaded from: classes5.dex */
public class UpdateOrDeleteExecutor extends AsyncExecutor {

    /* renamed from: cb */
    public UpdateOrDeleteCallback f4666cb;

    public UpdateOrDeleteCallback getListener() {
        return this.f4666cb;
    }

    public void listen(UpdateOrDeleteCallback updateOrDeleteCallback) {
        this.f4666cb = updateOrDeleteCallback;
        execute();
    }
}
