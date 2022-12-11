package com.umeng.analytics.pro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.stub.StubApp;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.umeng.analytics.pro.g */
/* loaded from: classes4.dex */
public class C1632g {

    /* renamed from: b */
    public static SQLiteOpenHelper f3431b;

    /* renamed from: d */
    public static Context f3432d;

    /* renamed from: a */
    public AtomicInteger f3433a;

    /* renamed from: c */
    public SQLiteDatabase f3434c;

    /* renamed from: com.umeng.analytics.pro.g$a */
    /* loaded from: classes4.dex */
    public static class C1634a {

        /* renamed from: a */
        public static final C1632g f3435a = new C1632g();
    }

    public C1632g() {
        this.f3433a = new AtomicInteger();
    }

    /* renamed from: a */
    public static C1632g m1069a(Context context) {
        if (f3432d == null && context != null) {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            f3432d = origApplicationContext;
            f3431b = C1629f.m1080a(origApplicationContext);
        }
        return C1634a.f3435a;
    }

    /* renamed from: a */
    public synchronized SQLiteDatabase m1070a() {
        if (this.f3433a.incrementAndGet() == 1) {
            this.f3434c = f3431b.getWritableDatabase();
        }
        return this.f3434c;
    }

    /* renamed from: b */
    public synchronized void m1068b() {
        try {
            if (this.f3433a.decrementAndGet() == 0) {
                this.f3434c.close();
            }
        } catch (Throwable unused) {
        }
    }
}
