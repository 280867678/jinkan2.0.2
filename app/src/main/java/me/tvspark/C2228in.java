package me.tvspark;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.appcompat.widget.ActionMenuView;
import com.google.android.material.bottomappbar.BottomAppBar;

/* renamed from: me.tvspark.in */
/* loaded from: classes4.dex */
public class C2228in extends AnimatorListenerAdapter {
    public final /* synthetic */ BottomAppBar Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ ActionMenuView Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2228in(BottomAppBar bottomAppBar, ActionMenuView actionMenuView, int i, boolean z) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bottomAppBar;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = actionMenuView;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            boolean z = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww != 0;
            BottomAppBar bottomAppBar = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i = bottomAppBar.Wwwwwwwwwwwwwwwww;
            if (i != 0) {
                bottomAppBar.Wwwwwwwwwwwwwwwww = 0;
                bottomAppBar.getMenu().clear();
                bottomAppBar.inflateMenu(i);
            }
            BottomAppBar bottomAppBar2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            ActionMenuView actionMenuView = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            boolean z2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (bottomAppBar2 == null) {
                throw null;
            }
            RunnableC2265jn runnableC2265jn = new RunnableC2265jn(bottomAppBar2, actionMenuView, i2, z2);
            if (z) {
                actionMenuView.post(runnableC2265jn);
            } else {
                runnableC2265jn.run();
            }
        }
    }
}
