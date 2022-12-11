package me.tvspark;

/* loaded from: classes4.dex */
public class cd0<T> {
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Object[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Object[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> extends g70<T> {
        @Override // me.tvspark.g70
        boolean test(T t);
    }

    public cd0(int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        Object[] objArr = new Object[i + 1];
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = objArr;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = objArr;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T t) {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i2 == i) {
            Object[] objArr = new Object[i + 1];
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i] = objArr;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = objArr;
            i2 = 0;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i2] = t;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2 + 1;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<? super T> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        for (Object[] objArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww; objArr != null; objArr = objArr[i]) {
            for (int i2 = 0; i2 < i; i2++) {
                Object obj = objArr[i2];
                if (obj != null && !wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.test(obj)) {
                }
            }
        }
    }
}
