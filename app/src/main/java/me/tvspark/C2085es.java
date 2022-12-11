package me.tvspark;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import com.google.android.material.shape.MaterialShapeDrawable;
import me.tvspark.C2416nq;

/* renamed from: me.tvspark.es */
/* loaded from: classes4.dex */
public class C2085es extends ConstraintLayout {
    public MaterialShapeDrawable Wwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwww;
    public final Runnable Wwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.es$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C2085es.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public C2085es(@NonNull Context context) {
        this(context, null);
    }

    public C2085es(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C2085es(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(com.google.android.material.R$layout.material_radial_view_group, this);
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        this.Wwwwwwwwwwwwwwwwwwwwww = materialShapeDrawable;
        C2342lq c2342lq = new C2342lq(0.5f);
        C2416nq c2416nq = materialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (c2416nq != null) {
            C2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2416nq);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2342lq;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2342lq;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = c2342lq;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww = c2342lq;
            materialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            materialShapeDrawable.invalidateSelf();
            this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ColorStateList.valueOf(-1));
            ViewCompat.setBackground(this, this.Wwwwwwwwwwwwwwwwwwwwww);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.google.android.material.R$styleable.RadialViewGroup, i, 0);
            this.Wwwwwwwwwwwwwwwwwwwwwww = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R$styleable.RadialViewGroup_materialCircleRadius, 0);
            this.Wwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            obtainStyledAttributes.recycle();
            return;
        }
        throw null;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int childCount = getChildCount();
        int i = 1;
        for (int i2 = 0; i2 < childCount; i2++) {
            if ("skip".equals(getChildAt(i2).getTag())) {
                i++;
            }
        }
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this);
        float f = 0.0f;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getId() != com.google.android.material.R$id.circle_center && !"skip".equals(childAt.getTag())) {
                constraintSet.constrainCircle(childAt.getId(), com.google.android.material.R$id.circle_center, this.Wwwwwwwwwwwwwwwwwwwwwww, f);
                f = (360.0f / (childCount - i)) + f;
            }
        }
        constraintSet.applyTo(this);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (view.getId() == -1) {
            view.setId(ViewCompat.generateViewId());
        }
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            handler.post(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            handler.post(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int i) {
        this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ColorStateList.valueOf(i));
    }
}
