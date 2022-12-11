package me.tvspark;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.tencent.smtt.sdk.TbsListener;
import java.io.IOException;
import me.tvspark.AbstractC2327lb;
import me.tvspark.AbstractC2625t7;

/* renamed from: me.tvspark.eb */
/* loaded from: classes4.dex */
public final class C2068eb implements AbstractC2175h7 {
    public boolean Wwwwwwwwwwwwwwwwwwwwwwww;
    public AbstractC2249j7 Wwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public C1977cb Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2337ll Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2337ll(0);
    public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2078el(4096);
    public final SparseArray<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new SparseArray<>();
    public final C2031db Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2031db();

    /* renamed from: me.tvspark.eb$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public long Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final C2041dl Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2041dl(new byte[64]);
        public final C2337ll Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final AbstractC2554ra Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2554ra abstractC2554ra, C2337ll c2337ll) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2554ra;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2337ll;
        }
    }

    static {
        C2141ga c2141ga = C2141ga.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public static /* synthetic */ AbstractC2175h7[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return new AbstractC2175h7[]{new C2068eb()};
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x01f2  */
    @Override // me.tvspark.AbstractC2175h7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7, C2588s7 c2588s7) throws IOException {
        AbstractC2554ra c2591sa;
        int i;
        int Wwwwwwwwwwwwwwwww;
        AbstractC2249j7 abstractC2249j7;
        AbstractC2625t7 wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwww);
        long length = abstractC2212i7.getLength();
        int i2 = (length > (-1L) ? 1 : (length == (-1L) ? 0 : -1));
        long j = -9223372036854775807L;
        if (i2 != 0) {
            C2031db c2031db = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (!c2031db.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                if (!c2031db.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    long length2 = abstractC2212i7.getLength();
                    int min = (int) Math.min(20000L, length2);
                    long j2 = length2 - min;
                    if (abstractC2212i7.getPosition() == j2) {
                        c2031db.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(min);
                        abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2031db.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, min);
                        C2078el c2078el = c2031db.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        int i3 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        int i4 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 4;
                        while (true) {
                            if (i4 < i3) {
                                break;
                            }
                            if (c2031db.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i4) == 442) {
                                c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4 + 4);
                                long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2031db.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el);
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != -9223372036854775807L) {
                                    j = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                                    break;
                                }
                            }
                            i4--;
                        }
                        c2031db.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
                        c2031db.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                        return 0;
                    }
                    c2588s7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j2;
                } else {
                    if (c2031db.Wwwwwwwwwwwwwwwwwwwwwwwwwwww != -9223372036854775807L) {
                        if (!c2031db.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                            int min2 = (int) Math.min(20000L, abstractC2212i7.getLength());
                            long j3 = 0;
                            if (abstractC2212i7.getPosition() == j3) {
                                c2031db.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(min2);
                                abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2031db.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, min2);
                                C2078el c2078el2 = c2031db.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                int i5 = c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                int i6 = c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                while (true) {
                                    if (i5 >= i6 - 3) {
                                        break;
                                    }
                                    if (c2031db.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i5) == 442) {
                                        c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i5 + 4);
                                        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = C2031db.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el2);
                                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != -9223372036854775807L) {
                                            j = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                                            break;
                                        }
                                    }
                                    i5++;
                                }
                                c2031db.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
                                c2031db.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                                return 0;
                            }
                            c2588s7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j3;
                        } else {
                            long j4 = c2031db.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            if (j4 != -9223372036854775807L) {
                                c2031db.Wwwwwwwwwwwwwwwwwwwwwwwwwww = c2031db.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2031db.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) - c2031db.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j4);
                            }
                        }
                    }
                    c2031db.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7);
                    return 0;
                }
                return 1;
            }
        }
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = true;
            C2031db c2031db2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            long j5 = c2031db2.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (j5 != -9223372036854775807L) {
                C1977cb c1977cb = new C1977cb(c2031db2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, j5, length);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwww = c1977cb;
                abstractC2249j7 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c1977cb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            } else {
                abstractC2249j7 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new AbstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j5, 0L);
            }
            abstractC2249j7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        C1977cb c1977cb2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        if (c1977cb2 == null || !c1977cb2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = i2 != 0 ? length - abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() : -1L;
            if ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 != -1 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 < 4) || !abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 4, true)) {
                return -1;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 441) {
                return -1;
            }
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 442) {
                abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 10);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(9);
                Wwwwwwwwwwwwwwwww = (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww() & 7) + 14;
                i = 0;
            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 443) {
                if (((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & InputDeviceCompat.SOURCE_ANY) >> 8) != 1) {
                    abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                    return 0;
                }
                int i7 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 255;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i7);
                if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                        AbstractC2554ra abstractC2554ra = null;
                        if (i7 == 189) {
                            c2591sa = new C2252ja(null);
                        } else if ((i7 & TbsListener.ErrorCode.EXCEED_INCR_UPDATE) == 192) {
                            c2591sa = new C2817ya(null);
                        } else {
                            if ((i7 & TbsListener.ErrorCode.TPATCH_VERSION_FAILED) == 224) {
                                c2591sa = new C2591sa(null);
                                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                                abstractC2554ra = c2591sa;
                                this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2212i7.getPosition();
                            }
                            if (abstractC2554ra != null) {
                                abstractC2554ra.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwww, new AbstractC2327lb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Integer.MIN_VALUE, i7, 256));
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2554ra, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(i7, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            }
                        }
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                        abstractC2554ra = c2591sa;
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2212i7.getPosition();
                        if (abstractC2554ra != null) {
                        }
                    }
                    if (abstractC2212i7.getPosition() > ((!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww || !this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) ? 1048576L : this.Wwwwwwwwwwwwwwwwwwwwwwwwwww + 8192)) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                        this.Wwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    }
                }
                abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 2);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                int Wwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww() + 6;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                    abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwww2);
                    return 0;
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwww2);
                abstractC2212i7.readFully(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, Wwwwwwwwwwwwwwwww2);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(6);
                C2078el c2078el3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 3);
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(6);
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5;
                c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5);
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww = 0L;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                    long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3) << 30) | (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(15) << 15) | wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(15);
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                    if (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww && wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(15);
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 | (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3) << 30) | (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(15) << 15));
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                    }
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6);
                }
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww, 4);
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el3);
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                C2078el c2078el4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                c2078el4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length);
                return 0;
            } else {
                i = 0;
                abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 2);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                Wwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww() + 6;
            }
            abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwww);
            return i;
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7, c2588s7);
    }

    @Override // me.tvspark.AbstractC2175h7
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2249j7 abstractC2249j7) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwww = abstractC2249j7;
    }

    @Override // me.tvspark.AbstractC2175h7
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7) throws IOException {
        byte[] bArr = new byte[14];
        abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, 0, 14);
        if (442 == (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) && (bArr[4] & 196) == 68 && (bArr[6] & 4) == 4 && (bArr[8] & 4) == 4 && (bArr[9] & 1) == 1 && (bArr[12] & 3) == 3) {
            abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr[13] & 7);
            abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, 0, 3);
            return 1 == ((((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)) | (bArr[2] & 255));
        }
        return false;
    }

    @Override // me.tvspark.AbstractC2175h7
    public void release() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0021, code lost:
        if (r7 != r9) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003c A[LOOP:0: B:13:0x0034->B:15:0x003c, LOOP_END] */
    @Override // me.tvspark.AbstractC2175h7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2) {
        C1977cb c1977cb;
        int i;
        if (!(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == -9223372036854775807L)) {
            long j3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (j3 != 0) {
            }
            c1977cb = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
            if (c1977cb != null) {
                c1977cb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2);
            }
            for (i = 0; i < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size(); i++) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww valueAt = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.valueAt(i);
                valueAt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
                valueAt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -9223372036854775807L;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2);
        c1977cb = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        if (c1977cb != null) {
        }
        while (i < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size()) {
        }
    }
}
