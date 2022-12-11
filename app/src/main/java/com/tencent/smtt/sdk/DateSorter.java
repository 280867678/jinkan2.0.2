package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.export.external.interfaces.IX5DateSorter;

/* loaded from: classes4.dex */
public class DateSorter {
    public static int DAY_COUNT = 5;

    /* renamed from: a */
    public android.webkit.DateSorter f1710a;

    /* renamed from: b */
    public IX5DateSorter f1711b;

    static {
        m2852a();
    }

    public DateSorter(Context context) {
        C1416x m2294a = C1416x.m2294a();
        if (m2294a == null || !m2294a.m2291b()) {
            this.f1710a = new android.webkit.DateSorter(context);
        } else {
            this.f1711b = m2294a.m2289c().m2248h(context);
        }
    }

    /* renamed from: a */
    public static boolean m2852a() {
        C1416x m2294a = C1416x.m2294a();
        return m2294a != null && m2294a.m2291b();
    }

    public long getBoundary(int i) {
        C1416x m2294a = C1416x.m2294a();
        return (m2294a == null || !m2294a.m2291b()) ? this.f1710a.getBoundary(i) : this.f1711b.getBoundary(i);
    }

    public int getIndex(long j) {
        C1416x m2294a = C1416x.m2294a();
        return (m2294a == null || !m2294a.m2291b()) ? this.f1710a.getIndex(j) : this.f1711b.getIndex(j);
    }

    public String getLabel(int i) {
        C1416x m2294a = C1416x.m2294a();
        return (m2294a == null || !m2294a.m2291b()) ? this.f1710a.getLabel(i) : this.f1711b.getLabel(i);
    }
}
