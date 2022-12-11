package com.arialyy.aria.core.inf;

/* loaded from: classes3.dex */
public interface IReceiver {
    void destroy();

    String getKey();

    String getTargetName();

    String getType();

    void register();

    void unRegister();
}
