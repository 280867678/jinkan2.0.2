package me.tvspark;

/* loaded from: classes4.dex */
public final class fd0<T> {
    public T[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0.75f;

    public fd0() {
        int Wwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwww(16);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwww - 1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (int) (0.75f * Wwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (T[]) new Object[Wwwwwwwwwwwwwwwwwwwwwwwww];
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        int i2 = i * (-1640531527);
        return i2 ^ (i2 >>> 16);
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, T[] tArr, int i2) {
        int i3;
        T t;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww--;
        while (true) {
            int i4 = i + 1;
            while (true) {
                i3 = i4 & i2;
                t = tArr[i3];
                if (t == null) {
                    tArr[i] = null;
                    return true;
                }
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t.hashCode()) & i2;
                if (i > i3) {
                    if (i >= Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > i3) {
                        break;
                    }
                    i4 = i3 + 1;
                } else if (i < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww <= i3) {
                    i4 = i3 + 1;
                }
            }
            tArr[i] = t;
            i = i3;
        }
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T t) {
        T t2;
        T[] tArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t.hashCode()) & i;
        T t3 = tArr[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww];
        if (t3 != null) {
            if (t3.equals(t)) {
                return false;
            }
            do {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1) & i;
                t2 = tArr[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww];
                if (t2 == null) {
                }
            } while (!t2.equals(t));
            return false;
        }
        tArr[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww] = t;
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        if (i2 >= this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            T[] tArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int length = tArr2.length;
            int i3 = length << 1;
            int i4 = i3 - 1;
            T[] tArr3 = (T[]) new Object[i3];
            while (true) {
                int i5 = i2 - 1;
                if (i2 == 0) {
                    break;
                }
                do {
                    length--;
                } while (tArr2[length] == null);
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(tArr2[length].hashCode()) & i4;
                if (tArr3[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2] != null) {
                    do {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 + 1) & i4;
                    } while (tArr3[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2] != null);
                }
                tArr3[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2] = tArr2[length];
                i2 = i5;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i4;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (int) (i3 * this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = tArr3;
        }
        return true;
    }
}
