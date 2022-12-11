package com.arialyy.aria.core.inf;

/* loaded from: classes3.dex */
public interface ITargetHandler {
    public static final int D_FTP = 4;
    public static final int D_HTTP = 1;
    public static final int GROUP_FTP_DIR = 6;
    public static final int GROUP_HTTP = 5;
    public static final int U_FTP = 3;
    public static final int U_HTTP = 2;

    void add();

    void cancel();

    void cancel(boolean z);

    void reStart();

    void reTry();

    void resume();

    void save();

    void start();

    void stop();
}
