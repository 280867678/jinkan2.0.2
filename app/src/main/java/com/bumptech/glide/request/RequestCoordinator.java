package com.bumptech.glide.request;

import me.tvspark.AbstractC2464p0;

/* loaded from: classes3.dex */
public interface RequestCoordinator {

    /* loaded from: classes3.dex */
    public enum RequestState {
        RUNNING(false),
        PAUSED(false),
        CLEARED(false),
        SUCCESS(true),
        FAILED(true);
        
        public final boolean isComplete;

        RequestState(boolean z) {
            this.isComplete = z;
        }

        public boolean isComplete() {
            return this.isComplete;
        }
    }

    boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2464p0 abstractC2464p0);

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2464p0 abstractC2464p0);

    boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2464p0 abstractC2464p0);

    boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2464p0 abstractC2464p0);

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2464p0 abstractC2464p0);

    boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    RequestCoordinator getRoot();
}
