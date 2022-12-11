package me.tvspark;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import me.tvspark.vn0;
import me.tvspark.widget.dialog.DialogDesc;

/* loaded from: classes4.dex */
public class fu0 implements vn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    public final /* synthetic */ DialogDesc Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public fu0(DialogDesc dialogDesc) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = dialogDesc;
    }

    @Override // me.tvspark.vn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.ivMask2.setBackgroundColor(i);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.ivMask1.setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor("#00FFFFFF"), i}));
    }

    @Override // me.tvspark.vn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bitmap bitmap) {
    }
}
