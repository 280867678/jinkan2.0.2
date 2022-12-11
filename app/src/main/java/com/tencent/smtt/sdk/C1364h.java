package com.tencent.smtt.sdk;

import android.database.sqlite.SQLiteException;
import java.lang.Thread;

/* renamed from: com.tencent.smtt.sdk.h */
/* loaded from: classes4.dex */
public class C1364h implements Thread.UncaughtExceptionHandler {
    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (th instanceof SQLiteException) {
            return;
        }
        throw new RuntimeException(th);
    }
}
