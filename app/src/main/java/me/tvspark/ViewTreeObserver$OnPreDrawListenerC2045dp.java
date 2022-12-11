package me.tvspark;

import android.view.ViewTreeObserver;

/* renamed from: me.tvspark.dp */
/* loaded from: classes4.dex */
public class ViewTreeObserver$OnPreDrawListenerC2045dp implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ C1954bp Wwwwwwwwwwwwwwwwwwwwwwww;

    public ViewTreeObserver$OnPreDrawListenerC2045dp(C1954bp c1954bp) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = c1954bp;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        C1954bp c1954bp = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        float rotation = c1954bp.Wwwwwwwwww.getRotation();
        if (c1954bp.Wwwwwwwwwwwwwwwww != rotation) {
            c1954bp.Wwwwwwwwwwwwwwwww = rotation;
            c1954bp.Wwwwwwwwwwwwwwwwwwwwwww();
            return true;
        }
        return true;
    }
}
