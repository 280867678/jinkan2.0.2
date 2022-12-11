package me.tvspark;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: me.tvspark.no */
/* loaded from: classes4.dex */
public class C2414no extends LinearLayoutManager {

    /* renamed from: me.tvspark.no$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends LinearSmoothScroller {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2414no c2414no, Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }
    }

    public C2414no(Context context, int i, boolean z) {
        super(context, i, z);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, recyclerView.getContext());
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setTargetPosition(i);
        startSmoothScroll(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }
}
