package me.tvspark;

import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.androidkun.xtablayout.XTabLayout;

/* loaded from: classes4.dex */
public class Kkkkkkkkkkkkkkkkkk implements Runnable {
    public final /* synthetic */ XTabLayout Wwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ XTabLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwww;

    public Kkkkkkkkkkkkkkkkkk(XTabLayout xTabLayout, XTabLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = xTabLayout;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // java.lang.Runnable
    public void run() {
        int width = this.Wwwwwwwwwwwwwwwwwwwwwwww.getWidth();
        String charSequence = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww.getText().toString();
        if (!TextUtils.isEmpty(charSequence)) {
            Paint paint = new Paint();
            paint.setTextSize(this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwww);
            Rect rect = new Rect();
            paint.getTextBounds(charSequence, 0, charSequence.length(), rect);
            if (width - rect.width() >= this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(20)) {
                return;
            }
            int width2 = rect.width() + this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(20);
            ViewGroup.LayoutParams layoutParams = this.Wwwwwwwwwwwwwwwwwwwwwwww.getLayoutParams();
            layoutParams.width = width2;
            this.Wwwwwwwwwwwwwwwwwwwwwwww.setLayoutParams(layoutParams);
        }
    }
}
