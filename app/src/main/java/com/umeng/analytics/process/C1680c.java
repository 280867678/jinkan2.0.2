package com.umeng.analytics.process;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.umeng.analytics.process.c */
/* loaded from: classes4.dex */
public class C1680c {

    /* renamed from: a */
    public static C1680c f3700a;

    /* renamed from: b */
    public ConcurrentHashMap<String, C1681a> f3701b = new ConcurrentHashMap<>();

    /* renamed from: c */
    public Context f3702c;

    /* renamed from: com.umeng.analytics.process.c$a */
    /* loaded from: classes4.dex */
    public static class C1681a {

        /* renamed from: a */
        public AtomicInteger f3703a = new AtomicInteger();

        /* renamed from: b */
        public SQLiteOpenHelper f3704b;

        /* renamed from: c */
        public SQLiteDatabase f3705c;

        /* renamed from: a */
        public static C1681a m838a(Context context, String str) {
            Context appContext = UMGlobalContext.getAppContext(context);
            C1681a c1681a = new C1681a();
            c1681a.f3704b = C1679b.m846a(appContext, str);
            return c1681a;
        }

        /* renamed from: a */
        public synchronized SQLiteDatabase m839a() {
            if (this.f3703a.incrementAndGet() == 1) {
                this.f3705c = this.f3704b.getWritableDatabase();
            }
            return this.f3705c;
        }

        /* renamed from: b */
        public synchronized void m837b() {
            try {
                if (this.f3703a.decrementAndGet() == 0) {
                    this.f3705c.close();
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public static C1680c m843a(Context context) {
        if (f3700a == null) {
            synchronized (C1680c.class) {
                if (f3700a == null) {
                    f3700a = new C1680c();
                }
            }
        }
        C1680c c1680c = f3700a;
        c1680c.f3702c = context;
        return c1680c;
    }

    /* renamed from: c */
    private C1681a m840c(String str) {
        if (this.f3701b.get(str) == null) {
            C1681a m838a = C1681a.m838a(this.f3702c, str);
            this.f3701b.put(str, m838a);
            return m838a;
        }
        return this.f3701b.get(str);
    }

    /* renamed from: a */
    public synchronized SQLiteDatabase m842a(String str) {
        return m840c(str).m839a();
    }

    /* renamed from: b */
    public synchronized void m841b(String str) {
        m840c(str).m837b();
    }
}
