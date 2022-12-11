package com.tencent.smtt.sdk;

import android.content.Context;
import com.stub.StubApp;
import com.tencent.smtt.export.external.DexLoader;

/* loaded from: classes4.dex */
public class TbsMediaFactory {

    /* renamed from: a */
    public Context f1917a;

    /* renamed from: b */
    public C1414v f1918b = null;

    /* renamed from: c */
    public DexLoader f1919c = null;

    public TbsMediaFactory(Context context) {
        this.f1917a = null;
        this.f1917a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        m2749a();
    }

    /* renamed from: a */
    private void m2749a() {
        if (this.f1917a == null) {
            return;
        }
        if (this.f1918b == null) {
            C1363g.m2597a(true).m2599a(this.f1917a, false, false);
            C1414v m2601a = C1363g.m2597a(true).m2601a();
            this.f1918b = m2601a;
            if (m2601a != null) {
                this.f1919c = m2601a.m2302b();
            }
        }
        if (this.f1918b != null && this.f1919c != null) {
            return;
        }
        throw new RuntimeException("tbs core dex(s) load failure !!!");
    }

    public TbsMediaPlayer createPlayer() {
        DexLoader dexLoader;
        if (this.f1918b == null || (dexLoader = this.f1919c) == null) {
            throw new RuntimeException("tbs core dex(s) did not loaded !!!");
        }
        return new TbsMediaPlayer(new C1390q(dexLoader, this.f1917a));
    }
}
