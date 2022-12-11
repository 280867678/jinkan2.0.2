package me.tvspark;

import java.util.Collections;
import java.util.List;
import me.tvspark.AbstractC2327lb;
import me.tvspark.C2245j3;

/* renamed from: me.tvspark.qa */
/* loaded from: classes4.dex */
public final class C2517qa implements AbstractC2554ra {
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC2740w7[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final List<AbstractC2327lb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2517qa(List<AbstractC2327lb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> list) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = list;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new AbstractC2740w7[list.size()];
    }

    @Override // me.tvspark.AbstractC2554ra
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            for (AbstractC2740w7 abstractC2740w7 : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                abstractC2740w7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, 1, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, null);
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        }
    }

    @Override // me.tvspark.AbstractC2554ra
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
    }

    @Override // me.tvspark.AbstractC2554ra
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, int i) {
        if ((i & 4) == 0) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 2;
    }

    @Override // me.tvspark.AbstractC2554ra
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el) {
        AbstractC2740w7[] abstractC2740w7Arr;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 2 && !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el, 32)) {
                return;
            }
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 1 && !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el, 0)) {
                return;
            }
            int i = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            for (AbstractC2740w7 abstractC2740w7 : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
                abstractC2740w7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww += Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, int i) {
        if (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == 0) {
            return false;
        }
        if (c2078el.Wwwwwwwwwwwwwwwwwwwwww() != i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww--;
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC2554ra
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2249j7 abstractC2249j7, AbstractC2327lb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        for (int i = 0; i < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length; i++) {
            AbstractC2327lb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2249j7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), 3);
            C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = "application/dvbsubs";
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww = Collections.singletonList(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i] = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
    }
}
