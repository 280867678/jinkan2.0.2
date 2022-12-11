package me.tvspark;

import android.view.View;
import android.view.ViewGroup;
import me.tvspark.view.activity.TbsPlayerActivity;

/* loaded from: classes4.dex */
public class ct0 implements View.OnLayoutChangeListener {
    public final /* synthetic */ TbsPlayerActivity Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public ct0(TbsPlayerActivity tbsPlayerActivity) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = tbsPlayerActivity;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        TbsPlayerActivity tbsPlayerActivity = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        tbsPlayerActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ViewGroup) tbsPlayerActivity.getWindow().getDecorView());
    }
}
