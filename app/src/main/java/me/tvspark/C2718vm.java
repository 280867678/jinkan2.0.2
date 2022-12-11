package me.tvspark;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import com.google.android.material.appbar.AppBarLayout;

/* renamed from: me.tvspark.vm */
/* loaded from: classes4.dex */
public class C2718vm implements AccessibilityViewCommand {
    public final /* synthetic */ boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ AppBarLayout Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2718vm(AppBarLayout.BaseBehavior baseBehavior, AppBarLayout appBarLayout, boolean z) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = appBarLayout;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
    }

    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
    public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setExpanded(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        return true;
    }
}
