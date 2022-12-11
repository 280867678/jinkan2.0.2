package me.tvspark;

import android.view.View;
import com.google.android.material.tabs.TabLayout;

/* renamed from: me.tvspark.jr */
/* loaded from: classes4.dex */
public class View$OnLayoutChangeListenerC2269jr implements View.OnLayoutChangeListener {
    public final /* synthetic */ TabLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public View$OnLayoutChangeListenerC2269jr(TabLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwww, View view) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = view;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getVisibility() == 0) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }
}
