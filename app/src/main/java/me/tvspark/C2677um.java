package me.tvspark;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import com.google.android.material.appbar.AppBarLayout;

/* renamed from: me.tvspark.um */
/* loaded from: classes4.dex */
public class C2677um implements AccessibilityViewCommand {
    public final /* synthetic */ AppBarLayout.BaseBehavior Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ AppBarLayout Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ CoordinatorLayout Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2677um(AppBarLayout.BaseBehavior baseBehavior, CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = baseBehavior;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = coordinatorLayout;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = appBarLayout;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = view;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
    }

    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
    public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, new int[]{0, 0});
        return true;
    }
}
