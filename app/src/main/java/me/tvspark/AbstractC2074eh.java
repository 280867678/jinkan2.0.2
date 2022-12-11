package me.tvspark;

import androidx.annotation.Nullable;
import java.util.List;

/* renamed from: me.tvspark.eh */
/* loaded from: classes4.dex */
public abstract class AbstractC2074eh extends AbstractC2775x5 implements AbstractC1909ah {
    public long Wwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public AbstractC1909ah Wwwwwwwwwwwwwwwwwwwwwwww;

    @Override // me.tvspark.AbstractC1909ah
    public List<C2786xg> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        AbstractC1909ah abstractC1909ah = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1909ah);
        return abstractC1909ah.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j - this.Wwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.AbstractC1909ah
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        AbstractC1909ah abstractC1909ah = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1909ah);
        return abstractC1909ah.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC1909ah
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        AbstractC1909ah abstractC1909ah = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1909ah);
        return abstractC1909ah.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j - this.Wwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.AbstractC1909ah
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        AbstractC1909ah abstractC1909ah = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1909ah);
        return abstractC1909ah.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i) + this.Wwwwwwwwwwwwwwwwwwwwwww;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, AbstractC1909ah abstractC1909ah, long j2) {
        this.timeUs = j;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = abstractC1909ah;
        if (j2 != Long.MAX_VALUE) {
            j = j2;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwww = j;
    }

    @Override // me.tvspark.AbstractC2586s5
    public void clear() {
        super.clear();
        this.Wwwwwwwwwwwwwwwwwwwwwwww = null;
    }
}
