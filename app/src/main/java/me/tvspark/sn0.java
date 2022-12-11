package me.tvspark;

import android.content.Context;
import android.graphics.Point;
import android.view.WindowManager;
import com.umeng.analytics.pro.C1615d;

/* loaded from: classes4.dex */
public final class sn0 {
    public static final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, C1615d.f3292R);
        Object systemService = context.getSystemService("window");
        if (systemService != null) {
            Point point = new Point();
            ((WindowManager) systemService).getDefaultDisplay().getSize(point);
            return point.x;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    }
}
