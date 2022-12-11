package me.tvspark;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* renamed from: me.tvspark.zm */
/* loaded from: classes4.dex */
public class C2866zm<V extends View> extends CoordinatorLayout.Behavior<V> {
    public C1915an Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;

    public C2866zm() {
    }

    public C2866zm(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        C1915an c1915an = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (c1915an != null) {
            return c1915an.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return 0;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i) {
        coordinatorLayout.onLayoutChild(v, i);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(coordinatorLayout, v, i);
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C1915an(v);
        }
        C1915an c1915an = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        c1915an.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c1915an.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getTop();
        c1915an.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c1915an.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getLeft();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i2 != 0) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        }
        int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i3 != 0) {
            C1915an c1915an2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (c1915an2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww && c1915an2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww != i3) {
                c1915an2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
                c1915an2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
            return true;
        }
        return true;
    }
}
