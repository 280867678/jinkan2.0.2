package com.arialyy.compiler;

/* loaded from: classes3.dex */
public enum EntityInfo {
    NORMAL("com.arialyy.aria.core.common", "AbsNormalEntity"),
    DOWNLOAD("com.arialyy.aria.core.download", "DownloadEntity"),
    UPLOAD("com.arialyy.aria.core.upload", "UploadEntity");
    
    public String className;
    public String pkg;

    EntityInfo(String str, String str2) {
        this.pkg = str;
        this.className = str2;
    }

    public String getClassName() {
        return this.className;
    }

    public String getPkg() {
        return this.pkg;
    }
}
