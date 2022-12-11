package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.shape.MaterialShapeDrawable;
import me.tvspark.C1957bs;
import me.tvspark.C2415np;
import me.tvspark.C2605so;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public class MaterialToolbar extends Toolbar {
    public static final int Wwwwwwwwwwwwwwwwwwwwwww = R$style.Widget_MaterialComponents_Toolbar;
    @Nullable
    public Integer Wwwwwwwwwwwwwwwwwwwwwwww;

    public MaterialToolbar(@NonNull Context context) {
        this(context, null);
    }

    public MaterialToolbar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.toolbarStyle);
    }

    public MaterialToolbar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(C1957bs.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, attributeSet, i, Wwwwwwwwwwwwwwwwwwwwwww), attributeSet, i);
        Context context2 = getContext();
        int i2 = 0;
        TypedArray Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2415np.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context2, attributeSet, R$styleable.MaterialToolbar, i, Wwwwwwwwwwwwwwwwwwwwwww, new int[0]);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hasValue(R$styleable.MaterialToolbar_navigationIconTint)) {
            setNavigationIconTint(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getColor(R$styleable.MaterialToolbar_navigationIconTint, -1));
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.recycle();
        Drawable background = getBackground();
        if (background == null || (background instanceof ColorDrawable)) {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
            materialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ColorStateList.valueOf(background != null ? ((ColorDrawable) background).getColor() : i2));
            materialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2605so(context2);
            materialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwww();
            materialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ViewCompat.getElevation(this));
            ViewCompat.setBackground(this, materialShapeDrawable);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof MaterialShapeDrawable) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((View) this, (MaterialShapeDrawable) background);
        }
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f) {
        super.setElevation(f);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, f);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(@Nullable Drawable drawable) {
        if (drawable != null && this.Wwwwwwwwwwwwwwwwwwwwwwww != null) {
            drawable = DrawableCompat.wrap(drawable);
            DrawableCompat.setTint(drawable, this.Wwwwwwwwwwwwwwwwwwwwwwww.intValue());
        }
        super.setNavigationIcon(drawable);
    }

    public void setNavigationIconTint(@ColorInt int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = Integer.valueOf(i);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }
}
