package me.tvspark;

import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* renamed from: me.tvspark.er */
/* loaded from: classes4.dex */
public class C2084er implements SwipeDismissBehavior.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    public final /* synthetic */ BaseTransientBottomBar Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2084er(BaseTransientBottomBar baseTransientBottomBar) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = baseTransientBottomBar;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull View view) {
        if (view.getParent() != null) {
            view.setVisibility(8);
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
    }
}
