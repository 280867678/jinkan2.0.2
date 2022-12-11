package me.tvspark;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public class ed0 {
    public int Wwwwwwwwwwwwwwwwwwww;
    public volatile int Wwwwwwwwwwwwwwwwwwwww;
    public Object[] Wwwwwwwwwwwwwwwwwwwwww;
    public Object[] Wwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwww;

    public ed0(int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = i;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
        if (this.Wwwwwwwwwwwwwwwwwwwww == 0) {
            Object[] objArr = new Object[this.Wwwwwwwwwwwwwwwwwwwwwwww + 1];
            this.Wwwwwwwwwwwwwwwwwwwwwww = objArr;
            this.Wwwwwwwwwwwwwwwwwwwwww = objArr;
            objArr[0] = obj;
            this.Wwwwwwwwwwwwwwwwwwww = 1;
            this.Wwwwwwwwwwwwwwwwwwwww = 1;
            return;
        }
        int i = this.Wwwwwwwwwwwwwwwwwwww;
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (i == i2) {
            Object[] objArr2 = new Object[i2 + 1];
            objArr2[0] = obj;
            this.Wwwwwwwwwwwwwwwwwwwwww[i2] = objArr2;
            this.Wwwwwwwwwwwwwwwwwwwwww = objArr2;
            this.Wwwwwwwwwwwwwwwwwwww = 1;
        } else {
            this.Wwwwwwwwwwwwwwwwwwwwww[i] = obj;
            this.Wwwwwwwwwwwwwwwwwwww = i + 1;
        }
        this.Wwwwwwwwwwwwwwwwwwwww++;
    }

    public String toString() {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = this.Wwwwwwwwwwwwwwwwwwwww;
        ArrayList arrayList = new ArrayList(i2 + 1);
        Object[] objArr = this.Wwwwwwwwwwwwwwwwwwwwwww;
        int i3 = 0;
        while (true) {
            int i4 = 0;
            while (i3 < i2) {
                arrayList.add(objArr[i4]);
                i3++;
                i4++;
                if (i4 == i) {
                    break;
                }
            }
            return arrayList.toString();
            objArr = objArr[i];
        }
    }
}
