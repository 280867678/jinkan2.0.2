package me.tvspark;

import android.view.View;
import androidx.core.view.ViewCompat;

/* renamed from: me.tvspark.an */
/* loaded from: classes4.dex */
public class C1915an {
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwww = true;

    public C1915an(View view) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = view;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        View view = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        ViewCompat.offsetTopAndBottom(view, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - (view.getTop() - this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        View view2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        ViewCompat.offsetLeftAndRight(view2, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww - (view2.getLeft() - this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww || this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == i) {
            return false;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return true;
    }
}
