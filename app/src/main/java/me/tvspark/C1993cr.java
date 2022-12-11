package me.tvspark;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* renamed from: me.tvspark.cr */
/* loaded from: classes4.dex */
public class C1993cr implements BaseTransientBottomBar.Wwwwwwwwwwwwwwwwwwwwwwwwwwww {
    public final /* synthetic */ BaseTransientBottomBar Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C1993cr(BaseTransientBottomBar baseTransientBottomBar) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = baseTransientBottomBar;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(View view) {
        WindowInsets rootWindowInsets;
        if (Build.VERSION.SDK_INT < 29 || (rootWindowInsets = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getRootWindowInsets()) == null) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww = rootWindowInsets.getMandatorySystemGestureInsets().bottom;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }
}
