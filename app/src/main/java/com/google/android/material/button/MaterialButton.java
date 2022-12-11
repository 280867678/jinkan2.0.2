package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.annotation.AbstractC0047Px;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import me.tvspark.AbstractC2570rq;
import me.tvspark.C1955bq;
import me.tvspark.C1957bs;
import me.tvspark.C2415np;
import me.tvspark.C2416nq;
import me.tvspark.C2487pn;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public class MaterialButton extends AppCompatButton implements Checkable, AbstractC2570rq {
    public int Wwwwwwwwwwww;
    public boolean Wwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwww;
    @AbstractC0047Px
    public int Wwwwwwwwwwwwwww;
    @AbstractC0047Px
    public int Wwwwwwwwwwwwwwww;
    @AbstractC0047Px
    public int Wwwwwwwwwwwwwwwww;
    @AbstractC0047Px
    public int Wwwwwwwwwwwwwwwwww;
    @Nullable
    public Drawable Wwwwwwwwwwwwwwwwwww;
    @Nullable
    public ColorStateList Wwwwwwwwwwwwwwwwwwww;
    @Nullable
    public PorterDuff.Mode Wwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwww;
    @NonNull
    public final LinkedHashSet<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwww;
    @NonNull
    public final C2487pn Wwwwwwwwwwwwwwwwwwwwwwww;
    public static final int[] Wwwwwwwwwww = {16842911};
    public static final int[] Wwwwwwwwww = {16842912};
    public static final int Wwwwwwwww = R$style.Widget_MaterialComponents_Button;

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbsSavedState {
        public static final Parcelable.Creator<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> CREATOR = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        public boolean Wwwwwwwwwwwwwwwwwwwwwwww;

        /* loaded from: classes3.dex */
        public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable.ClassLoaderCreator<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> {
            @Override // android.os.Parcelable.Creator
            @NonNull
            public Object createFromParcel(@NonNull Parcel parcel) {
                return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            public Object[] newArray(int i) {
                return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parcel, classLoader);
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.class.getClassLoader();
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwww = parcel.readInt() != 1 ? false : true;
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwwwwwww ? 1 : 0);
        }
    }

    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MaterialButton materialButton, boolean z);
    }

    public MaterialButton(@NonNull Context context) {
        this(context, null);
    }

    public MaterialButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialButtonStyle);
    }

    public MaterialButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(C1957bs.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, attributeSet, i, Wwwwwwwww), attributeSet, i);
        this.Wwwwwwwwwwwwwwwwwwwwwww = new LinkedHashSet<>();
        boolean z = false;
        this.Wwwwwwwwwwwwww = false;
        this.Wwwwwwwwwwwww = false;
        Context context2 = getContext();
        TypedArray Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2415np.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context2, attributeSet, R$styleable.MaterialButton, i, Wwwwwwwww, new int[0]);
        this.Wwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimensionPixelSize(R$styleable.MaterialButton_iconPadding, 0);
        this.Wwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getInt(R$styleable.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.Wwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext(), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, R$styleable.MaterialButton_iconTint);
        this.Wwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext(), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, R$styleable.MaterialButton_icon);
        this.Wwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getInteger(R$styleable.MaterialButton_iconGravity, 1);
        this.Wwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimensionPixelSize(R$styleable.MaterialButton_iconSize, 0);
        C2487pn c2487pn = new C2487pn(this, C2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context2, attributeSet, i, Wwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        this.Wwwwwwwwwwwwwwwwwwwwwwww = c2487pn;
        if (c2487pn != null) {
            c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetLeft, 0);
            c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetRight, 0);
            c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetTop, 0);
            c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetBottom, 0);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.hasValue(R$styleable.MaterialButton_cornerRadius)) {
                int dimensionPixelSize = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimensionPixelSize(R$styleable.MaterialButton_cornerRadius, -1);
                c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = dimensionPixelSize;
                c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dimensionPixelSize));
                c2487pn.Wwwwwwwwwwwwwwwwwww = true;
            }
            c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimensionPixelSize(R$styleable.MaterialButton_strokeWidth, 0);
            c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getInt(R$styleable.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
            c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getContext(), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, R$styleable.MaterialButton_backgroundTint);
            c2487pn.Wwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getContext(), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, R$styleable.MaterialButton_strokeColor);
            c2487pn.Wwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getContext(), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, R$styleable.MaterialButton_rippleColor);
            c2487pn.Wwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getBoolean(R$styleable.MaterialButton_android_checkable, false);
            c2487pn.Wwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getDimensionPixelSize(R$styleable.MaterialButton_elevation, 0);
            int paddingStart = ViewCompat.getPaddingStart(c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            int paddingTop = c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getPaddingTop();
            int paddingEnd = ViewCompat.getPaddingEnd(c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            int paddingBottom = c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getPaddingBottom();
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.hasValue(R$styleable.MaterialButton_android_background)) {
                c2487pn.Wwwwwwwwwwwwwwwwwwww = true;
                c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setSupportBackgroundTintList(c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwww);
                c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setSupportBackgroundTintMode(c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwww);
            } else {
                c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            ViewCompat.setPaddingRelative(c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, paddingStart + c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, paddingTop + c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, paddingEnd + c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, paddingBottom + c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.recycle();
            setCompoundDrawablePadding(this.Wwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwww != null ? true : z);
            return;
        }
        throw null;
    }

    @NonNull
    private String getA11yClassName() {
        return (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() ? CompoundButton.class : Button.class).getName();
    }

    private int getTextHeight() {
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(charSequence, 0, charSequence.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextWidth() {
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        return Math.min((int) paint.measureText(charSequence), getLayout().getEllipsizedWidth());
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            TextViewCompat.setCompoundDrawablesRelative(this, this.Wwwwwwwwwwwwwwwwwww, null, null, null);
        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            TextViewCompat.setCompoundDrawablesRelative(this, null, null, this.Wwwwwwwwwwwwwwwwwww, null);
        } else if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
        } else {
            TextViewCompat.setCompoundDrawablesRelative(this, null, this.Wwwwwwwwwwwwwwwwwww, null, null);
        }
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        C2487pn c2487pn = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        return c2487pn != null && !c2487pn.Wwwwwwwwwwwwwwwwwwww;
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i = this.Wwwwwwwwwwww;
        return i == 16 || i == 32;
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i = this.Wwwwwwwwwwww;
        return i == 1 || i == 2;
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i = this.Wwwwwwwwwwww;
        return i == 3 || i == 4;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        Drawable drawable = this.Wwwwwwwwwwwwwwwwwww;
        if (drawable != null) {
            Drawable mutate = DrawableCompat.wrap(drawable).mutate();
            this.Wwwwwwwwwwwwwwwwwww = mutate;
            DrawableCompat.setTintList(mutate, this.Wwwwwwwwwwwwwwwwwwww);
            PorterDuff.Mode mode = this.Wwwwwwwwwwwwwwwwwwwww;
            if (mode != null) {
                DrawableCompat.setTintMode(this.Wwwwwwwwwwwwwwwwwww, mode);
            }
            int i = this.Wwwwwwwwwwwwwwwwww;
            if (i == 0) {
                i = this.Wwwwwwwwwwwwwwwwwww.getIntrinsicWidth();
            }
            int i2 = this.Wwwwwwwwwwwwwwwwww;
            if (i2 == 0) {
                i2 = this.Wwwwwwwwwwwwwwwwwww.getIntrinsicHeight();
            }
            Drawable drawable2 = this.Wwwwwwwwwwwwwwwwwww;
            int i3 = this.Wwwwwwwwwwwwwwwww;
            int i4 = this.Wwwwwwwwwwwwwwww;
            drawable2.setBounds(i3, i4, i + i3, i2 + i4);
        }
        if (z) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return;
        }
        Drawable[] compoundDrawablesRelative = TextViewCompat.getCompoundDrawablesRelative(this);
        boolean z2 = false;
        Drawable drawable3 = compoundDrawablesRelative[0];
        Drawable drawable4 = compoundDrawablesRelative[1];
        Drawable drawable5 = compoundDrawablesRelative[2];
        if ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && drawable3 != this.Wwwwwwwwwwwwwwwwwww) || ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && drawable5 != this.Wwwwwwwwwwwwwwwwwww) || (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && drawable4 != this.Wwwwwwwwwwwwwwwwwww))) {
            z2 = true;
        }
        if (!z2) {
            return;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        C2487pn c2487pn = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        return c2487pn != null && c2487pn.Wwwwwwwwwwwwwwwwww;
    }

    @Override // android.view.View
    @Nullable
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    @Nullable
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    @AbstractC0047Px
    public int getCornerRadius() {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.Wwwwwwwwwwwwwwwwwww;
    }

    public int getIconGravity() {
        return this.Wwwwwwwwwwww;
    }

    @AbstractC0047Px
    public int getIconPadding() {
        return this.Wwwwwwwwwwwwwww;
    }

    @AbstractC0047Px
    public int getIconSize() {
        return this.Wwwwwwwwwwwwwwwwww;
    }

    public ColorStateList getIconTint() {
        return this.Wwwwwwwwwwwwwwwwwwww;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.Wwwwwwwwwwwwwwwwwwwww;
    }

    @Dimension
    public int getInsetBottom() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Dimension
    public int getInsetTop() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Nullable
    public ColorStateList getRippleColor() {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
        }
        return null;
    }

    @Override // me.tvspark.AbstractC2570rq
    @NonNull
    public C2416nq getShapeAppearanceModel() {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
        }
        return null;
    }

    @AbstractC0047Px
    public int getStrokeWidth() {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ColorStateList getSupportBackgroundTintList() {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return super.getSupportBackgroundTintMode();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.Wwwwwwwwwwwwww;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((View) this, this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }
    }

    @Override // android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            Button.mergeDrawableStates(onCreateDrawableState, Wwwwwwwwwww);
        }
        if (this.Wwwwwwwwwwwwww) {
            Button.mergeDrawableStates(onCreateDrawableState, Wwwwwwwwww);
        }
        return onCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(this.Wwwwwwwwwwwwww);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        accessibilityNodeInfo.setChecked(this.Wwwwwwwwwwwwww);
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        C2487pn c2487pn;
        super.onLayout(z, i, i2, i3, i4);
        if (Build.VERSION.SDK_INT != 21 || (c2487pn = this.Wwwwwwwwwwwwwwwwwwwwwwww) == null) {
            return;
        }
        int i5 = i4 - i2;
        int i6 = i3 - i;
        Drawable drawable = c2487pn.Wwwwwwwwwwwwwwwwwwwwww;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i6 - c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i5 - c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) parcelable;
        super.onRestoreInstanceState(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getSuperState());
        setChecked(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // android.widget.TextView, android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(super.onSaveInstanceState());
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwww;
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    @Override // android.view.View
    public void setBackground(@NonNull Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int i) {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            C2487pn c2487pn = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == null) {
                return;
            }
            c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().setTint(i);
            return;
        }
        super.setBackgroundColor(i);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(@NonNull Drawable drawable) {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            if (drawable != getBackground()) {
                C2487pn c2487pn = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                c2487pn.Wwwwwwwwwwwwwwwwwwww = true;
                c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setSupportBackgroundTintList(c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwww);
                c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setSupportBackgroundTintMode(c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwww);
            } else {
                getBackground().setState(drawable.getState());
                return;
            }
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(@DrawableRes int i) {
        setBackgroundDrawable(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z) {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww = z;
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() || !isEnabled() || this.Wwwwwwwwwwwwww == z) {
            return;
        }
        this.Wwwwwwwwwwwwww = z;
        refreshDrawableState();
        if (this.Wwwwwwwwwwwww) {
            return;
        }
        this.Wwwwwwwwwwwww = true;
        Iterator<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> it = this.Wwwwwwwwwwwwwwwwwwwwwww.iterator();
        while (it.hasNext()) {
            it.next().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, this.Wwwwwwwwwwwwww);
        }
        this.Wwwwwwwwwwwww = false;
    }

    public void setCornerRadius(@AbstractC0047Px int i) {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            C2487pn c2487pn = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (c2487pn.Wwwwwwwwwwwwwwwwwww && c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwwww == i) {
                return;
            }
            c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            c2487pn.Wwwwwwwwwwwwwwwwwww = true;
            c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i));
        }
    }

    public void setCornerRadiusResource(@DimenRes int i) {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            setCornerRadius(getResources().getDimensionPixelSize(i));
        }
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f) {
        super.setElevation(f);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            MaterialShapeDrawable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            MaterialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww == f) {
                return;
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww = f;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public void setIcon(@Nullable Drawable drawable) {
        if (this.Wwwwwwwwwwwwwwwwwww != drawable) {
            this.Wwwwwwwwwwwwwwwwwww = drawable;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i) {
        if (this.Wwwwwwwwwwww != i) {
            this.Wwwwwwwwwwww = i;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(@AbstractC0047Px int i) {
        if (this.Wwwwwwwwwwwwwww != i) {
            this.Wwwwwwwwwwwwwww = i;
            setCompoundDrawablePadding(i);
        }
    }

    public void setIconResource(@DrawableRes int i) {
        setIcon(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setIconSize(@AbstractC0047Px int i) {
        if (i >= 0) {
            if (this.Wwwwwwwwwwwwwwwwww == i) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwww = i;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
            return;
        }
        throw new IllegalArgumentException("iconSize cannot be less than 0");
    }

    public void setIconTint(@Nullable ColorStateList colorStateList) {
        if (this.Wwwwwwwwwwwwwwwwwwww != colorStateList) {
            this.Wwwwwwwwwwwwwwwwwwww = colorStateList;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.Wwwwwwwwwwwwwwwwwwwww != mode) {
            this.Wwwwwwwwwwwwwwwwwwwww = mode;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
        }
    }

    public void setIconTintResource(@ColorRes int i) {
        setIconTint(AppCompatResources.getColorStateList(getContext(), i));
    }

    public void setInsetBottom(@Dimension int i) {
        C2487pn c2487pn = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i);
    }

    public void setInsetTop(@Dimension int i) {
        C2487pn c2487pn = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(@Nullable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            MaterialButtonToggleGroup.this.invalidate();
        }
        super.setPressed(z);
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            C2487pn c2487pn = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (c2487pn.Wwwwwwwwwwwwwwwwwwwwwww == colorStateList) {
                return;
            }
            c2487pn.Wwwwwwwwwwwwwwwwwwwwwww = colorStateList;
            if (!(c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getBackground() instanceof RippleDrawable)) {
                return;
            }
            ((RippleDrawable) c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getBackground()).setColor(C1955bq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(colorStateList));
        }
    }

    public void setRippleColorResource(@ColorRes int i) {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            setRippleColor(AppCompatResources.getColorStateList(getContext(), i));
        }
    }

    @Override // me.tvspark.AbstractC2570rq
    public void setShapeAppearanceModel(@NonNull C2416nq c2416nq) {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2416nq);
            return;
        }
        throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
    }

    public void setShouldDrawSurfaceColorStroke(boolean z) {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            C2487pn c2487pn = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            c2487pn.Wwwwwwwwwwwwwwwwwwwww = z;
            c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            C2487pn c2487pn = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (c2487pn.Wwwwwwwwwwwwwwwwwwwwwwww == colorStateList) {
                return;
            }
            c2487pn.Wwwwwwwwwwwwwwwwwwwwwwww = colorStateList;
            c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public void setStrokeColorResource(@ColorRes int i) {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            setStrokeColor(AppCompatResources.getColorStateList(getContext(), i));
        }
    }

    public void setStrokeWidth(@AbstractC0047Px int i) {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            C2487pn c2487pn = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwww == i) {
                return;
            }
            c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public void setStrokeWidthResource(@DimenRes int i) {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            C2487pn c2487pn = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwww == colorStateList) {
                return;
            }
            c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwww = colorStateList;
            if (c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == null) {
                return;
            }
            DrawableCompat.setTintList(c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwww);
            return;
        }
        super.setSupportBackgroundTintList(colorStateList);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            C2487pn c2487pn = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwww == mode) {
                return;
            }
            c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwww = mode;
            if (c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == null || c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                return;
            }
            DrawableCompat.setTintMode(c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), c2487pn.Wwwwwwwwwwwwwwwwwwwwwwwwww);
            return;
        }
        super.setSupportBackgroundTintMode(mode);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.Wwwwwwwwwwwwww);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        if (this.Wwwwwwwwwwwwwwwwwww == null || getLayout() == null) {
            return;
        }
        if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                return;
            }
            this.Wwwwwwwwwwwwwwwww = 0;
            if (this.Wwwwwwwwwwww == 16) {
                this.Wwwwwwwwwwwwwwww = 0;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
                return;
            }
            int i3 = this.Wwwwwwwwwwwwwwwwww;
            if (i3 == 0) {
                i3 = this.Wwwwwwwwwwwwwwwwwww.getIntrinsicHeight();
            }
            int textHeight = (((((i2 - getTextHeight()) - getPaddingTop()) - i3) - this.Wwwwwwwwwwwwwww) - getPaddingBottom()) / 2;
            if (this.Wwwwwwwwwwwwwwww == textHeight) {
                return;
            }
            this.Wwwwwwwwwwwwwwww = textHeight;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
        }
        this.Wwwwwwwwwwwwwwww = 0;
        int i4 = this.Wwwwwwwwwwww;
        boolean z = true;
        if (i4 == 1 || i4 == 3) {
            this.Wwwwwwwwwwwwwwwww = 0;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
            return;
        }
        int i5 = this.Wwwwwwwwwwwwwwwwww;
        if (i5 == 0) {
            i5 = this.Wwwwwwwwwwwwwwwwwww.getIntrinsicWidth();
        }
        int textWidth = (((((i - getTextWidth()) - ViewCompat.getPaddingEnd(this)) - i5) - this.Wwwwwwwwwwwwwww) - ViewCompat.getPaddingStart(this)) / 2;
        boolean z2 = ViewCompat.getLayoutDirection(this) == 1;
        if (this.Wwwwwwwwwwww != 4) {
            z = false;
        }
        if (z2 != z) {
            textWidth = -textWidth;
        }
        if (this.Wwwwwwwwwwwwwwwww == textWidth) {
            return;
        }
        this.Wwwwwwwwwwwwwwwww = textWidth;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
    }
}
