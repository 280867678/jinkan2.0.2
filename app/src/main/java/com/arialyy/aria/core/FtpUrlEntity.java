package com.arialyy.aria.core;

import java.net.InetAddress;

/* loaded from: classes3.dex */
public class FtpUrlEntity implements Cloneable {
    public String account;
    public String hostName;
    public IdEntity idEntity;
    public String password;
    public String port;
    public String remotePath;
    public String scheme;
    public String url;
    public String user;
    public InetAddress validAddr;
    public boolean isFtps = false;
    public boolean needLogin = false;
    public String protocol = "TLS";
    public boolean isImplicit = true;

    /* renamed from: clone */
    public FtpUrlEntity m4405clone() {
        try {
            return (FtpUrlEntity) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
