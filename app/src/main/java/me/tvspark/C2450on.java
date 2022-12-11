package me.tvspark;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* renamed from: me.tvspark.on */
/* loaded from: classes4.dex */
public class C2450on implements AccessibilityViewCommand {
    public final /* synthetic */ BottomSheetBehavior Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2450on(BottomSheetBehavior bottomSheetBehavior, int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bottomSheetBehavior;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
    }

    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
    public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        return true;
    }
}
