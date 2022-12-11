package com.qihoo.util;

import android.app.ZygotePreload;
import android.content.pm.ApplicationInfo;
import android.os.Build;

/* loaded from: classes.dex */
public class AppZygotePreload implements ZygotePreload {
    @Override // android.app.ZygotePreload
    public void doPreload(ApplicationInfo applicationInfo) {
        if (Build.VERSION.SDK_INT >= 29) {
            System.loadLibrary("jg_mc");
        }
    }
}
