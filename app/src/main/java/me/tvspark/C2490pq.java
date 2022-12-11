package me.tvspark;

import android.graphics.Canvas;
import android.graphics.Matrix;
import java.util.List;
import me.tvspark.C2533qq;

/* renamed from: me.tvspark.pq */
/* loaded from: classes4.dex */
public class C2490pq extends C2533qq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    public final /* synthetic */ Matrix Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ List Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2490pq(C2533qq c2533qq, List list, Matrix matrix) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = list;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = matrix;
    }

    @Override // me.tvspark.C2533qq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Matrix matrix, C1992cq c1992cq, int i, Canvas canvas) {
        for (C2533qq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c1992cq, i, canvas);
        }
    }
}
