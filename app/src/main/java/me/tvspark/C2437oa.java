package me.tvspark;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import me.tvspark.AbstractC2327lb;
import me.tvspark.C2245j3;

/* renamed from: me.tvspark.oa */
/* loaded from: classes4.dex */
public final class C2437oa implements AbstractC2327lb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    public final List<C2245j3> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2437oa(int i) {
        ImmutableList m3919of = ImmutableList.m3919of();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = m3919of;
    }

    public C2437oa(int i, List<C2245j3> list) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = list;
    }

    @Override // me.tvspark.AbstractC2327lb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public SparseArray<AbstractC2327lb> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return new SparseArray<>();
    }

    @Override // me.tvspark.AbstractC2327lb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    @Nullable
    public AbstractC2327lb Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, AbstractC2327lb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        if (i != 2) {
            if (i == 3 || i == 4) {
                return new C1940bb(new C2817ya(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
            }
            if (i == 21) {
                return new C1940bb(new C2743wa());
            }
            if (i == 27) {
                if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4)) {
                    return new C1940bb(new C2665ua(new C2179hb(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8)));
                }
                return null;
            } else if (i == 36) {
                return new C1940bb(new C2703va(new C2179hb(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww))));
            } else {
                if (i == 89) {
                    return new C1940bb(new C2517qa(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                }
                if (i != 138) {
                    if (i == 172) {
                        return new C1940bb(new C2326la(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                    }
                    if (i == 257) {
                        return new C2142gb(new C1903ab("application/vnd.dvb.ait"));
                    }
                    if (i != 129) {
                        if (i != 130) {
                            if (i == 134) {
                                if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16)) {
                                    return new C2142gb(new C1903ab("application/x-scte35"));
                                }
                                return null;
                            } else if (i != 135) {
                                switch (i) {
                                    case 15:
                                        if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2)) {
                                            return new C1940bb(new C2400na(false, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                                        }
                                        return null;
                                    case 16:
                                        return new C1940bb(new C2628ta(new C2364mb(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww))));
                                    case 17:
                                        if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2)) {
                                            return new C1940bb(new C2780xa(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                                        }
                                        return null;
                                    default:
                                        return null;
                                }
                            }
                        } else if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(64)) {
                            return null;
                        }
                    }
                    return new C1940bb(new C2252ja(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                }
                return new C1940bb(new C2474pa(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
            }
        }
        return new C1940bb(new C2591sa(new C2364mb(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww))));
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return (i & this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v4 */
    public final List<C2245j3> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2327lb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        String str;
        int i;
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(32)) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        C2078el c2078el = new C2078el(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        ArrayList arrayList = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        while (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() > 0) {
            int Wwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
            int Wwwwwwwwwwwwwwwwwwwwww2 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + c2078el.Wwwwwwwwwwwwwwwwwwwwww();
            if (Wwwwwwwwwwwwwwwwwwwwww == 134) {
                arrayList = new ArrayList();
                int Wwwwwwwwwwwwwwwwwwwwww3 = c2078el.Wwwwwwwwwwwwwwwwwwwwww() & 31;
                for (int i2 = 0; i2 < Wwwwwwwwwwwwwwwwwwwwww3; i2++) {
                    String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
                    int Wwwwwwwwwwwwwwwwwwwwww4 = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
                    boolean z = (Wwwwwwwwwwwwwwwwwwwwww4 & 128) != 0;
                    if (z) {
                        i = Wwwwwwwwwwwwwwwwwwwwww4 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i = 1;
                    }
                    byte Wwwwwwwwwwwwwwwwwwwwww5 = (byte) c2078el.Wwwwwwwwwwwwwwwwwwwwww();
                    c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                    List<byte[]> list = null;
                    if (z) {
                        list = Collections.singletonList((Wwwwwwwwwwwwwwwwwwwwww5 & 64) != 0 ? new byte[]{1} : new byte[]{0});
                    }
                    C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwww = str;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwww = i;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwww = list;
                    arrayList.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                }
            }
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwww2);
            arrayList = arrayList;
        }
        return arrayList;
    }
}
