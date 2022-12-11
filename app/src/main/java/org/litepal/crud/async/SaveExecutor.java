package org.litepal.crud.async;

import org.litepal.crud.callback.SaveCallback;

/* loaded from: classes5.dex */
public class SaveExecutor extends AsyncExecutor {

    /* renamed from: cb */
    public SaveCallback f4665cb;

    public SaveCallback getListener() {
        return this.f4665cb;
    }

    public void listen(SaveCallback saveCallback) {
        this.f4665cb = saveCallback;
        execute();
    }
}
