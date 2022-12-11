package me.tvspark;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.common.collect.ImmutableList;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import me.tvspark.C2221ig;
import me.tvspark.C2245j3;
import me.tvspark.C2254jc;
import me.tvspark.C2560rg;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* renamed from: me.tvspark.eg */
/* loaded from: classes4.dex */
public final class C2073eg extends AbstractC2559rf {
    public static final AtomicInteger Kkkkkkkkkkkkkkkkkkkkkkk = new AtomicInteger();
    public boolean Kkkkkkkkkkkkkkkkkkkkkkkk;
    public ImmutableList<Integer> Kkkkkkkkkkkkkkkkkkkkkkkkk;
    public boolean Kkkkkkkkkkkkkkkkkkkkkkkkkk;
    public volatile boolean Www;
    public boolean Wwww;
    public int Wwwww;
    public C2221ig Wwwwww;
    public AbstractC2110fg Wwwwwww;
    public final boolean Wwwwwwww;
    public final boolean Wwwwwwwww;
    public final C2078el Wwwwwwwwww;
    public final C2218id Wwwwwwwwwww;
    @Nullable
    public final C2322l6 Wwwwwwwwwwww;
    @Nullable
    public final List<C2245j3> Wwwwwwwwwwwww;
    public final AbstractC1982cg Wwwwwwwwwwwwww;
    public final C2337ll Wwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwww;
    @Nullable
    public final AbstractC2110fg Wwwwwwwwwwwwwwwwww;
    @Nullable
    public final C1949bk Wwwwwwwwwwwwwwwwwww;
    @Nullable
    public final AbstractC2863zj Wwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwww;
    public final Uri Wwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwww;

    public C2073eg(AbstractC1982cg abstractC1982cg, AbstractC2863zj abstractC2863zj, C1949bk c1949bk, C2245j3 c2245j3, boolean z, @Nullable AbstractC2863zj abstractC2863zj2, @Nullable C1949bk c1949bk2, boolean z2, Uri uri, @Nullable List<C2245j3> list, int i, @Nullable Object obj, long j, long j2, long j3, int i2, boolean z3, boolean z4, C2337ll c2337ll, @Nullable C2322l6 c2322l6, @Nullable AbstractC2110fg abstractC2110fg, C2218id c2218id, C2078el c2078el, boolean z5) {
        super(abstractC2863zj, c1949bk, c2245j3, i, obj, j, j2, j3);
        this.Wwwwwwwww = z;
        this.Wwwwwwwwwwwwwwwwwwwwwww = i2;
        this.Wwwwwwwwwwwwwwwwwww = c1949bk2;
        this.Wwwwwwwwwwwwwwwwwwww = abstractC2863zj2;
        this.Wwww = c1949bk2 != null;
        this.Wwwwwwww = z2;
        this.Wwwwwwwwwwwwwwwwwwwwww = uri;
        this.Wwwwwwwwwwwwwwwww = z4;
        this.Wwwwwwwwwwwwwww = c2337ll;
        this.Wwwwwwwwwwwwwwww = z3;
        this.Wwwwwwwwwwwwww = abstractC1982cg;
        this.Wwwwwwwwwwwww = list;
        this.Wwwwwwwwwwww = c2322l6;
        this.Wwwwwwwwwwwwwwwwww = abstractC2110fg;
        this.Wwwwwwwwwww = c2218id;
        this.Wwwwwwwwww = c2078el;
        this.Wwwwwwwwwwwwwwwwwwwww = z5;
        this.Kkkkkkkkkkkkkkkkkkkkkkkkk = ImmutableList.m3919of();
        this.Wwwwwwwwwwwwwwwwwwwwwwww = Kkkkkkkkkkkkkkkkkkkkkkk.getAndIncrement();
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00be, code lost:
        if (r21 >= r49.Wwwwwwwwwwwwwwwwwwwwwwwwwww) goto L52;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C2073eg Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC1982cg abstractC1982cg, AbstractC2863zj abstractC2863zj, C2245j3 c2245j3, long j, C2560rg c2560rg, int i, Uri uri, @Nullable List<C2245j3> list, int i2, @Nullable Object obj, boolean z, C2295kg c2295kg, @Nullable C2073eg c2073eg, @Nullable byte[] bArr, @Nullable byte[] bArr2) {
        byte[] bArr3;
        AbstractC2863zj abstractC2863zj2;
        C1949bk c1949bk;
        boolean z2;
        C2218id c2218id;
        C2078el c2078el;
        AbstractC2110fg abstractC2110fg;
        boolean z3;
        C2218id c2218id2;
        boolean z4;
        byte[] bArr4;
        C2748wf c2748wf = abstractC2863zj;
        C2560rg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2560rg.Wwwwwwwwwwwwwwwwwwww.get(i);
        C1949bk c1949bk2 = new C1949bk(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2560rg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwww);
        boolean z5 = bArr != null;
        if (z5) {
            String str = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
            bArr3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
        } else {
            bArr3 = null;
        }
        if (bArr == null) {
            abstractC2863zj2 = c2748wf;
        } else if (bArr3 != null) {
            abstractC2863zj2 = new C2748wf(c2748wf, bArr, bArr3);
        } else {
            throw null;
        }
        C2560rg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
            boolean z6 = bArr2 != null;
            if (z6) {
                String str2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwww;
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2);
                bArr4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2);
            } else {
                bArr4 = null;
            }
            boolean z7 = z6;
            C1949bk c1949bk3 = new C1949bk(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2560rg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwww), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwww);
            if (bArr2 != null) {
                if (bArr4 != null) {
                    c2748wf = new C2748wf(c2748wf, bArr2, bArr4);
                } else {
                    throw null;
                }
            }
            z2 = z7;
            c1949bk = c1949bk3;
        } else {
            c2748wf = null;
            c1949bk = null;
            z2 = false;
        }
        long j2 = j + wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww;
        long j3 = j2 + wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww;
        int i3 = c2560rg.Wwwwwwwwwwwwwwwwwwwwwwwwwww + wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww;
        if (c2073eg != null) {
            boolean z8 = uri.equals(c2073eg.Wwwwwwwwwwwwwwwwwwwwww) && c2073eg.Kkkkkkkkkkkkkkkkkkkkkkkkkk;
            C2218id c2218id3 = c2073eg.Wwwwwwwwwww;
            C2078el c2078el2 = c2073eg.Wwwwwwwwww;
            if (!z8) {
                if (c2560rg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    c2218id2 = c2218id3;
                } else {
                    c2218id2 = c2218id3;
                }
                z4 = false;
                c2218id = c2218id2;
                z3 = !z4;
                abstractC2110fg = (z8 || c2073eg.Kkkkkkkkkkkkkkkkkkkkkkkk || c2073eg.Wwwwwwwwwwwwwwwwwwwwwww != i3) ? null : c2073eg.Wwwwwww;
                c2078el = c2078el2;
            } else {
                c2218id2 = c2218id3;
            }
            z4 = true;
            c2218id = c2218id2;
            z3 = !z4;
            abstractC2110fg = (z8 || c2073eg.Kkkkkkkkkkkkkkkkkkkkkkkk || c2073eg.Wwwwwwwwwwwwwwwwwwwwwww != i3) ? null : c2073eg.Wwwwwww;
            c2078el = c2078el2;
        } else {
            c2218id = new C2218id();
            c2078el = new C2078el(10);
            abstractC2110fg = null;
            z3 = false;
        }
        long j4 = c2560rg.Wwwwwwwwwwwwwwwwwwwwwwwwww + i;
        boolean z9 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwww;
        C2337ll c2337ll = c2295kg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i3);
        if (c2337ll == null) {
            c2337ll = new C2337ll(Long.MAX_VALUE);
            c2295kg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(i3, c2337ll);
        }
        return new C2073eg(abstractC1982cg, abstractC2863zj2, c1949bk2, c2245j3, z5, c2748wf, c1949bk, z2, uri, list, i2, obj, j2, j3, j4, i3, z9, z, c2337ll, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww, abstractC2110fg, c2218id, c2078el, z3);
    }

    public static byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(str).startsWith("0x")) {
            str = str.substring(2);
        }
        byte[] byteArray = new BigInteger(str, 16).toByteArray();
        byte[] bArr = new byte[16];
        int length = byteArray.length > 16 ? byteArray.length - 16 : 0;
        System.arraycopy(byteArray, length, bArr, (16 - byteArray.length) + length, byteArray.length - length);
        return bArr;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Www = true;
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!this.Wwwwwwwwwwwwwwwwwwwww);
        if (i >= this.Kkkkkkkkkkkkkkkkkkkkkkkkk.size()) {
            return 0;
        }
        return this.Kkkkkkkkkkkkkkkkkkkkkkkkk.get(i).intValue();
    }

    @RequiresNonNull({"output"})
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2863zj abstractC2863zj, C1949bk c1949bk, boolean z) throws IOException {
        C1949bk c1949bk2;
        boolean z2;
        boolean z3;
        int i = this.Wwwww;
        if (z) {
            z2 = i != 0;
            c1949bk2 = c1949bk;
        } else {
            long j = i;
            long j2 = c1949bk.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            long j3 = -1;
            if (j2 != -1) {
                j3 = j2 - j;
            }
            long j4 = j3;
            c1949bk2 = (j == 0 && c1949bk.Wwwwwwwwwwwwwwwwwwwwwwwwwwww == j4) ? c1949bk : new C1949bk(c1949bk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c1949bk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c1949bk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c1949bk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c1949bk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c1949bk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww + j, j4, c1949bk.Wwwwwwwwwwwwwwwwwwwwwwwwwww, c1949bk.Wwwwwwwwwwwwwwwwwwwwwwwwww, c1949bk.Wwwwwwwwwwwwwwwwwwwwwwwww);
            z2 = false;
        }
        try {
            C2064e7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2863zj, c1949bk2);
            if (z2) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwww);
            }
            while (!this.Www) {
                if (((C2785xf) this.Wwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, C2785xf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) == 0) {
                    z3 = true;
                    continue;
                } else {
                    z3 = false;
                    continue;
                }
                if (!z3) {
                    break;
                }
            }
            this.Wwwww = (int) (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getPosition() - c1949bk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            try {
                abstractC2863zj.close();
            } catch (IOException unused) {
            }
        } catch (Throwable th) {
            if (abstractC2863zj != null) {
                try {
                    abstractC2863zj.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws IOException {
        AbstractC2110fg abstractC2110fg;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwww);
        if (this.Wwwwwww == null && (abstractC2110fg = this.Wwwwwwwwwwwwwwwwww) != null) {
            AbstractC2175h7 abstractC2175h7 = ((C2785xf) abstractC2110fg).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if ((abstractC2175h7 instanceof C2290kb) || (abstractC2175h7 instanceof C2251j9)) {
                this.Wwwwwww = this.Wwwwwwwwwwwwwwwwww;
                this.Wwww = false;
            }
        }
        if (this.Wwww) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwww);
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwww, this.Wwwwwwww);
            this.Wwwww = 0;
            this.Wwww = false;
        }
        if (!this.Www) {
            if (!this.Wwwwwwwwwwwwwwww) {
                if (!this.Wwwwwwwwwwwwwwwww) {
                    try {
                        this.Wwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    } catch (InterruptedException unused) {
                        throw new InterruptedIOException();
                    }
                } else {
                    C2337ll c2337ll = this.Wwwwwwwwwwwwwww;
                    if (c2337ll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == Long.MAX_VALUE) {
                        c2337ll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    }
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwww);
            }
            this.Kkkkkkkkkkkkkkkkkkkkkkkkkk = !this.Www;
        }
    }

    @EnsuresNonNull({"extractor"})
    @RequiresNonNull({"output"})
    public final C2064e7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2863zj abstractC2863zj, C1949bk c1949bk) throws IOException {
        long j;
        long j2;
        C2785xf c2785xf;
        C2859zf c2859zf;
        AbstractC2175h7 c2215ia;
        boolean z;
        AbstractC2175h7 c2251j9;
        boolean z2;
        List<C2245j3> emptyList;
        C2221ig c2221ig;
        long j3;
        AbstractC2175h7 c2815y8;
        C2064e7 c2064e7 = new C2064e7(abstractC2863zj, c1949bk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, abstractC2863zj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c1949bk));
        int i = 1;
        if (this.Wwwwwww == null) {
            c2064e7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            int i2 = 8;
            try {
                c2064e7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 10);
                this.Wwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(10);
                if (this.Wwwwwwwwww.Wwwwwwwwwwwwwwwwwwww() == 4801587) {
                    this.Wwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
                    int Wwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww();
                    int i3 = Wwwwwwwwwwwwwwwwwwwwwww + 10;
                    C2078el c2078el = this.Wwwwwwwwww;
                    byte[] bArr = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (i3 > bArr.length) {
                        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
                        System.arraycopy(bArr, 0, this.Wwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 10);
                    }
                    c2064e7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 10, Wwwwwwwwwwwwwwwwwwwwwww);
                    C2254jc Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwww);
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                        int length = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.length;
                        for (int i4 = 0; i4 < length; i4++) {
                            C2254jc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww[i4];
                            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof C2366md) {
                                C2366md c2366md = (C2366md) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                if ("com.apple.streaming.transportStreamTimestamp".equals(c2366md.Wwwwwwwwwwwwwwwwwwwwwww)) {
                                    System.arraycopy(c2366md.Wwwwwwwwwwwwwwwwwwwwww, 0, this.Wwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 8);
                                    this.Wwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                                    j = this.Wwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww() & 8589934591L;
                                    break;
                                }
                            }
                        }
                    }
                }
            } catch (EOFException unused) {
            }
            j = -9223372036854775807L;
            c2064e7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
            AbstractC2110fg abstractC2110fg = this.Wwwwwwwwwwwwwwwwww;
            if (abstractC2110fg != null) {
                C2785xf c2785xf2 = (C2785xf) abstractC2110fg;
                AbstractC2175h7 abstractC2175h7 = c2785xf2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!((abstractC2175h7 instanceof C2290kb) || (abstractC2175h7 instanceof C2251j9)));
                AbstractC2175h7 abstractC2175h72 = c2785xf2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (abstractC2175h72 instanceof C2332lg) {
                    c2815y8 = new C2332lg(c2785xf2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww, c2785xf2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                } else if (abstractC2175h72 instanceof C2363ma) {
                    c2815y8 = new C2363ma(0);
                } else if (abstractC2175h72 instanceof C2215ia) {
                    c2815y8 = new C2215ia();
                } else if (abstractC2175h72 instanceof C2289ka) {
                    c2815y8 = new C2289ka();
                } else if (!(abstractC2175h72 instanceof C2815y8)) {
                    String simpleName = c2785xf2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getClass().getSimpleName();
                    throw new IllegalStateException(simpleName.length() != 0 ? "Unexpected extractor type for recreation: ".concat(simpleName) : new String("Unexpected extractor type for recreation: "));
                } else {
                    c2815y8 = new C2815y8(0, -9223372036854775807L);
                }
                c2785xf = new C2785xf(c2815y8, c2785xf2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2785xf2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                j2 = 0;
            } else {
                AbstractC1982cg abstractC1982cg = this.Wwwwwwwwwwwwww;
                Uri uri = c1949bk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                C2245j3 c2245j3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                List<C2245j3> list = this.Wwwwwwwwwwwww;
                C2337ll c2337ll = this.Wwwwwwwwwwwwwww;
                Map<String, List<String>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2863zj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                C2859zf c2859zf2 = (C2859zf) abstractC1982cg;
                if (c2859zf2 != null) {
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3.Wwwwwwwwwwwww);
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uri);
                    ArrayList arrayList = new ArrayList(C2859zf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length);
                    C2859zf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, arrayList);
                    C2859zf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, arrayList);
                    C2859zf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, arrayList);
                    for (int i5 : C2859zf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        C2859zf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i5, arrayList);
                    }
                    c2064e7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    int i6 = 0;
                    AbstractC2175h7 abstractC2175h73 = null;
                    while (true) {
                        if (i6 >= arrayList.size()) {
                            j2 = 0;
                            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2175h73);
                            c2785xf = new C2785xf(abstractC2175h73, c2245j3, c2337ll);
                            break;
                        }
                        int intValue = ((Integer) arrayList.get(i6)).intValue();
                        if (intValue == 0) {
                            c2859zf = c2859zf2;
                            j2 = 0;
                            c2215ia = new C2215ia();
                        } else if (intValue == i) {
                            c2859zf = c2859zf2;
                            j2 = 0;
                            c2215ia = new C2289ka();
                        } else if (intValue == 2) {
                            c2859zf = c2859zf2;
                            j2 = 0;
                            c2215ia = new C2363ma(0);
                        } else if (intValue != 7) {
                            if (intValue == i2) {
                                c2859zf = c2859zf2;
                                C2254jc c2254jc = c2245j3.Wwwwwwwwwwwwwww;
                                if (c2254jc != null) {
                                    int i7 = 0;
                                    while (true) {
                                        C2254jc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr = c2254jc.Wwwwwwwwwwwwwwwwwwwwwwww;
                                        if (i7 >= wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr.length) {
                                            break;
                                        }
                                        C2254jc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr[i7];
                                        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 instanceof C2258jg) {
                                            z2 = !((C2258jg) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2).Wwwwwwwwwwwwwwwwwwwwww.isEmpty();
                                            break;
                                        }
                                        i7++;
                                    }
                                }
                                z2 = false;
                                c2251j9 = new C2251j9(z2 ? 4 : 0, c2337ll, null, list != null ? list : Collections.emptyList());
                            } else if (intValue == 11) {
                                int i8 = c2859zf2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                boolean z3 = c2859zf2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                int i9 = i8 | 16;
                                if (list != null) {
                                    i9 |= 32;
                                    emptyList = list;
                                } else if (z3) {
                                    C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwww = "application/cea-608";
                                    emptyList = Collections.singletonList(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                                } else {
                                    emptyList = Collections.emptyList();
                                }
                                String str = c2245j3.Wwwwwwwwwwwwwwww;
                                if (!TextUtils.isEmpty(str)) {
                                    c2859zf = c2859zf2;
                                    if (!"audio/mp4a-latm".equals(C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str))) {
                                        i9 |= 2;
                                    }
                                    if (!"video/avc".equals(C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(str))) {
                                        i9 |= 4;
                                    }
                                } else {
                                    c2859zf = c2859zf2;
                                }
                                c2251j9 = new C2290kb(2, c2337ll, new C2437oa(i9, emptyList), 112800);
                            } else if (intValue != 13) {
                                c2859zf = c2859zf2;
                                c2215ia = null;
                                j2 = 0;
                            } else {
                                c2251j9 = new C2332lg(c2245j3.Wwwwwwwwwwwwwwwwwwwwww, c2337ll);
                                c2859zf = c2859zf2;
                            }
                            c2215ia = c2251j9;
                            j2 = 0;
                        } else {
                            c2859zf = c2859zf2;
                            j2 = 0;
                            c2215ia = new C2815y8(0, 0L);
                        }
                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2215ia);
                        try {
                            z = c2215ia.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2064e7);
                            c2064e7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        } catch (EOFException unused2) {
                            c2064e7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            z = false;
                        } catch (Throwable th) {
                            c2064e7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            throw th;
                        }
                        if (z) {
                            c2785xf = new C2785xf(c2215ia, c2245j3, c2337ll);
                            break;
                        }
                        if (intValue == 11) {
                            abstractC2175h73 = c2215ia;
                        }
                        i6++;
                        c2859zf2 = c2859zf;
                        i2 = 8;
                        i = 1;
                    }
                } else {
                    throw null;
                }
            }
            this.Wwwwwww = c2785xf;
            AbstractC2175h7 abstractC2175h74 = c2785xf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if ((abstractC2175h74 instanceof C2363ma) || (abstractC2175h74 instanceof C2215ia) || (abstractC2175h74 instanceof C2289ka) || (abstractC2175h74 instanceof C2815y8)) {
                c2221ig = this.Wwwwww;
                j3 = j != -9223372036854775807L ? this.Wwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j) : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            } else {
                c2221ig = this.Wwwwww;
                j3 = j2;
            }
            c2221ig.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j3);
            this.Wwwwww.Kkkkkkkkkkkkkkkkkkkkkkkkkk.clear();
            ((C2785xf) this.Wwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwww);
        }
        C2221ig c2221ig2 = this.Wwwwww;
        C2322l6 c2322l6 = this.Wwwwwwwwwwww;
        if (!C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2221ig2.Illllllllllllllllllllllllllll, c2322l6)) {
            c2221ig2.Illllllllllllllllllllllllllll = c2322l6;
            int i10 = 0;
            while (true) {
                C2221ig.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr = c2221ig2.Wwww;
                if (i10 >= wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr.length) {
                    break;
                }
                if (c2221ig2.Kkkkkkkkk[i10]) {
                    C2221ig.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr[i10];
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkkkkkkkkkkkkkkk = c2322l6;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwww = true;
                }
                i10++;
            }
        }
        return c2064e7;
    }
}
