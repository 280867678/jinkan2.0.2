package me.tvspark;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;

/* renamed from: me.tvspark.pp */
/* loaded from: classes4.dex */
public final class C2489pp implements OnApplyWindowInsetsListener {
    public final /* synthetic */ C2606sp Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ AbstractC2569rp Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2489pp(AbstractC2569rp abstractC2569rp, C2606sp c2606sp) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2569rp;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2606sp;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        AbstractC2569rp abstractC2569rp = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        C2606sp c2606sp = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i = c2606sp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = c2606sp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i3 = c2606sp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i4 = c2606sp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        C2413nn c2413nn = (C2413nn) abstractC2569rp;
        c2413nn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = windowInsetsCompat.getMandatorySystemGestureInsets().bottom;
        c2413nn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
        return windowInsetsCompat;
    }
}
