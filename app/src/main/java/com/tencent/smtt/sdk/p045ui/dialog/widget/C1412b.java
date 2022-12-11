package com.tencent.smtt.sdk.p045ui.dialog.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.StateListDrawable;
import android.widget.Button;
import androidx.core.view.ViewCompat;

/* renamed from: com.tencent.smtt.sdk.ui.dialog.widget.b */
/* loaded from: classes4.dex */
public class C1412b extends Button {

    /* renamed from: a */
    public int f2313a;

    /* renamed from: b */
    public int f2314b;

    /* renamed from: c */
    public float f2315c;

    /* renamed from: d */
    public float f2316d;

    /* renamed from: e */
    public float f2317e;

    /* renamed from: f */
    public float f2318f;

    /* renamed from: g */
    public C1413c f2319g;

    /* renamed from: h */
    public C1413c f2320h;

    /* renamed from: i */
    public C1413c f2321i;

    public C1412b(Context context, float f, float f2, float f3, float f4, int i) {
        super(context);
        this.f2319g = null;
        this.f2320h = null;
        this.f2321i = null;
        this.f2315c = f;
        this.f2316d = f2;
        this.f2317e = f3;
        this.f2318f = f4;
        this.f2313a = i;
        this.f2314b = Color.parseColor("#D0D0D0");
        m2308a();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C1412b(Context context, int i, int i2) {
        this(context, r5, r5, r5, r5, i2);
        float f = i;
    }

    /* renamed from: a */
    public void m2308a() {
        C1413c c1413c = new C1413c(this.f2313a, this.f2315c, this.f2316d, this.f2317e, this.f2318f);
        this.f2319g = c1413c;
        c1413c.m2307a(getWidth(), getHeight());
        C1413c c1413c2 = new C1413c(1342177280 | (this.f2313a & ViewCompat.MEASURED_SIZE_MASK), this.f2315c, this.f2316d, this.f2317e, this.f2318f);
        this.f2320h = c1413c2;
        c1413c2.m2307a(getWidth(), getHeight());
        C1413c c1413c3 = new C1413c(this.f2314b, this.f2315c, this.f2316d, this.f2317e, this.f2318f);
        this.f2321i = c1413c3;
        c1413c3.m2307a(getWidth(), getHeight());
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842910, -16842919}, this.f2319g);
        stateListDrawable.addState(new int[]{16842910, 16842919}, this.f2320h);
        stateListDrawable.addState(new int[]{-16842910}, this.f2321i);
        setBackgroundDrawable(stateListDrawable);
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        C1413c c1413c = this.f2319g;
        if (c1413c != null) {
            c1413c.m2307a(i3 - i, i4 - i2);
        }
        C1413c c1413c2 = this.f2320h;
        if (c1413c2 != null) {
            c1413c2.m2307a(i3 - i, i4 - i2);
        }
        C1413c c1413c3 = this.f2321i;
        if (c1413c3 != null) {
            c1413c3.m2307a(i3 - i, i4 - i2);
        }
    }
}
