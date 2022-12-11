package me.tvspark;

import android.util.Pair;
import me.tvspark.AbstractC2209i4;

/* renamed from: me.tvspark.v2 */
/* loaded from: classes4.dex */
public abstract class AbstractC2695v2 extends AbstractC2209i4 {
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC2257jf Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public AbstractC2695v2(boolean z, AbstractC2257jf abstractC2257jf) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2257jf;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2257jf.getLength();
    }

    public static Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
        return ((Pair) obj).first;
    }

    public static Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
        return ((Pair) obj).second;
    }

    public static Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, Object obj2) {
        return Pair.create(obj, obj2);
    }

    @Override // me.tvspark.AbstractC2209i4
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0) {
            return -1;
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            z = false;
        }
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z ? this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1;
        do {
            C2810y3 c2810y3 = (C2810y3) this;
            if (!c2810y3.Wwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                return c2810y3.Wwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z) + c2810y3.Wwwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww];
            } else if (z) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                continue;
            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > 0) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww--;
                continue;
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
                continue;
            }
        } while (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != -1);
        return -1;
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, boolean z) {
        if (z) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        }
        if (i >= this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1) {
            return -1;
        }
        return i + 1;
    }

    @Override // me.tvspark.AbstractC2209i4
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0) {
            return -1;
        }
        int i = 0;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            z = false;
        }
        if (z) {
            i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        do {
            C2810y3 c2810y3 = (C2810y3) this;
            if (!c2810y3.Wwwwwwwwwwwwwwwwwwwwwwwwww[i].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                return c2810y3.Wwwwwwwwwwwwwwwwwwwwwwwwww[i].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z) + c2810y3.Wwwwwwwwwwwwwwwwwwwwwwwwwww[i];
            }
            i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, z);
        } while (i != -1);
        return -1;
    }

    @Override // me.tvspark.AbstractC2209i4
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (!(obj instanceof Pair)) {
            return -1;
        }
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        Object obj3 = pair.second;
        C2810y3 c2810y3 = (C2810y3) this;
        Integer num = c2810y3.Wwwwwwwwwwwwwwwwwwwwwwww.get(obj2);
        int intValue = num == null ? -1 : num.intValue();
        if (intValue != -1 && (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2810y3.Wwwwwwwwwwwwwwwwwwwwwwwwww[intValue].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj3)) != -1) {
            return c2810y3.Wwwwwwwwwwwwwwwwwwwwwwwwwwww[intValue] + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return -1;
    }

    @Override // me.tvspark.AbstractC2209i4
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, boolean z) {
        int i3 = 0;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (i2 == 1) {
                i2 = 2;
            }
            z = false;
        }
        C2810y3 c2810y3 = (C2810y3) this;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2810y3.Wwwwwwwwwwwwwwwwwwwwwwwwwww, i + 1, false, false);
        int i4 = c2810y3.Wwwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww];
        AbstractC2209i4 abstractC2209i4 = c2810y3.Wwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww];
        int i5 = i - i4;
        if (i2 != 2) {
            i3 = i2;
        }
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = abstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i5, i3, z);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != -1) {
            return i4 + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        }
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, z);
        while (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != -1 && c2810y3.Wwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, z);
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != -1) {
            return c2810y3.Wwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z) + c2810y3.Wwwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3];
        } else if (i2 != 2) {
            return -1;
        } else {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
        }
    }

    @Override // me.tvspark.AbstractC2209i4
    public final AbstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, AbstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, boolean z) {
        C2810y3 c2810y3 = (C2810y3) this;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2810y3.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, i + 1, false, false);
        int i2 = c2810y3.Wwwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww];
        c2810y3.Wwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i - c2810y3.Wwwwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww], wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, z);
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i2;
        if (z) {
            Object obj = c2810y3.Wwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww];
            Object obj2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj2);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Pair.create(obj, obj2);
        }
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC2209i4
    public final AbstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, AbstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        Object obj3 = pair.second;
        C2810y3 c2810y3 = (C2810y3) this;
        Integer num = c2810y3.Wwwwwwwwwwwwwwwwwwwwwwww.get(obj2);
        int intValue = num == null ? -1 : num.intValue();
        int i = c2810y3.Wwwwwwwwwwwwwwwwwwwwwwwwwww[intValue];
        c2810y3.Wwwwwwwwwwwwwwwwwwwwwwwwww[intValue].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj3, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = obj;
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC2209i4
    public final Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        C2810y3 c2810y3 = (C2810y3) this;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2810y3.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, i + 1, false, false);
        return Pair.create(c2810y3.Wwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww], c2810y3.Wwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i - c2810y3.Wwwwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww]));
    }

    @Override // me.tvspark.AbstractC2209i4
    public final AbstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, AbstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, long j) {
        C2810y3 c2810y3 = (C2810y3) this;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2810y3.Wwwwwwwwwwwwwwwwwwwwwwwwwww, i + 1, false, false);
        int i2 = c2810y3.Wwwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww];
        int i3 = c2810y3.Wwwwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww];
        c2810y3.Wwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i - i2, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, j);
        Object obj = c2810y3.Wwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww];
        if (!AbstractC2209i4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww.equals(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
            obj = Pair.create(obj, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = obj;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww += i3;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww += i3;
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}
