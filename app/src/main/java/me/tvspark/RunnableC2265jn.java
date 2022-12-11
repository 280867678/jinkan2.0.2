package me.tvspark;

import androidx.appcompat.widget.ActionMenuView;
import com.google.android.material.bottomappbar.BottomAppBar;

/* renamed from: me.tvspark.jn */
/* loaded from: classes4.dex */
public class RunnableC2265jn implements Runnable {
    public final /* synthetic */ BottomAppBar Wwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ boolean Wwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ ActionMenuView Wwwwwwwwwwwwwwwwwwwwwwww;

    public RunnableC2265jn(BottomAppBar bottomAppBar, ActionMenuView actionMenuView, int i, boolean z) {
        this.Wwwwwwwwwwwwwwwwwwwww = bottomAppBar;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = actionMenuView;
        this.Wwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwww = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        ActionMenuView actionMenuView = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        actionMenuView.setTranslationX(this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(actionMenuView, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww));
    }
}
