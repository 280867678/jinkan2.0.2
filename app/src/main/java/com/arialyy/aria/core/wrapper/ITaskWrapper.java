package com.arialyy.aria.core.wrapper;

import com.arialyy.aria.core.inf.IEntity;

/* loaded from: classes3.dex */
public interface ITaskWrapper {
    public static final int DG_HTTP = 2;
    public static final int D_FTP = 3;
    public static final int D_FTP_DIR = 4;
    public static final int D_HTTP = 1;
    public static final int D_SFTP = 12;
    public static final int D_TCP = 9;
    public static final int ERROR = 0;
    public static final int M3U8_LIVE = 8;
    public static final int M3U8_VOD = 7;
    public static final int U_FTP = 6;
    public static final int U_HTTP = 5;
    public static final int U_SFTP = 13;
    public static final int U_TCP = 10;
    public static final int U_TCP_PEER = 11;

    /* renamed from: getEntity */
    IEntity mo4442getEntity();

    String getKey();

    int getRequestType();
}
