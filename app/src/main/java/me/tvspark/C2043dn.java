package me.tvspark;

import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* renamed from: me.tvspark.dn */
/* loaded from: classes4.dex */
public class C2043dn {
    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull C1989cn c1989cn, @NonNull View view, @Nullable FrameLayout frameLayout) {
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        c1989cn.setBounds(rect);
        c1989cn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view, frameLayout);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable C1989cn c1989cn, @NonNull View view) {
        if (c1989cn == null) {
            return;
        }
        if (c1989cn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != null) {
            c1989cn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().setForeground(null);
        } else {
            view.getOverlay().remove(c1989cn);
        }
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull C1989cn c1989cn, @NonNull View view, @Nullable FrameLayout frameLayout) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c1989cn, view, frameLayout);
        if (c1989cn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != null) {
            c1989cn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().setForeground(c1989cn);
        } else {
            view.getOverlay().add(c1989cn);
        }
    }
}
