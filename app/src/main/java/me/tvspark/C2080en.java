package me.tvspark;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import com.google.android.material.behavior.SwipeDismissBehavior;

/* renamed from: me.tvspark.en */
/* loaded from: classes4.dex */
public class C2080en implements AccessibilityViewCommand {
    public final /* synthetic */ SwipeDismissBehavior Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2080en(SwipeDismissBehavior swipeDismissBehavior) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = swipeDismissBehavior;
    }

    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
    public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
        boolean z = false;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view)) {
            boolean z2 = ViewCompat.getLayoutDirection(view) == 1;
            if ((this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0 && z2) || (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 1 && !z2)) {
                z = true;
            }
            int width = view.getWidth();
            if (z) {
                width = -width;
            }
            ViewCompat.offsetLeftAndRight(view, width);
            view.setAlpha(0.0f);
            SwipeDismissBehavior.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                ((C2084er) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view);
            }
            return true;
        }
        return false;
    }
}
