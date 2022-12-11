package me.tvspark;

import android.content.Context;
import android.util.SparseArray;
import me.tvspark.AbstractC2863zj;
import me.tvspark.C2072ef;

/* renamed from: me.tvspark.pe */
/* loaded from: classes4.dex */
public final class C2478pe implements AbstractC1981cf {
    public final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final SparseArray<AbstractC1981cf> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2478pe(Context context, AbstractC2323l7 abstractC2323l7) {
        C2114fk c2114fk = new C2114fk(context);
        SparseArray<AbstractC1981cf> sparseArray = new SparseArray<>();
        try {
            sparseArray.put(0, (AbstractC1981cf) Class.forName("com.google.android.exoplayer2.source.dash.DashMediaSource$Factory").asSubclass(AbstractC1981cf.class).getConstructor(AbstractC2863zj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.class).newInstance(c2114fk));
        } catch (Exception unused) {
        }
        try {
            sparseArray.put(1, (AbstractC1981cf) Class.forName("com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource$Factory").asSubclass(AbstractC1981cf.class).getConstructor(AbstractC2863zj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.class).newInstance(c2114fk));
        } catch (Exception unused2) {
        }
        try {
            sparseArray.put(2, (AbstractC1981cf) Class.forName("com.google.android.exoplayer2.source.hls.HlsMediaSource$Factory").asSubclass(AbstractC1981cf.class).getConstructor(AbstractC2863zj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.class).newInstance(c2114fk));
        } catch (Exception unused3) {
        }
        sparseArray.put(3, new C2072ef.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2114fk, abstractC2323l7));
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = sparseArray;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new int[sparseArray.size()];
        for (int i = 0; i < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size(); i++) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i] = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.keyAt(i);
        }
    }
}
