package org.litepal.crud.async;

import org.litepal.crud.callback.AverageCallback;

/* loaded from: classes5.dex */
public class AverageExecutor extends AsyncExecutor {

    /* renamed from: cb */
    public AverageCallback f4661cb;

    public AverageCallback getListener() {
        return this.f4661cb;
    }

    public void listen(AverageCallback averageCallback) {
        this.f4661cb = averageCallback;
        execute();
    }
}
