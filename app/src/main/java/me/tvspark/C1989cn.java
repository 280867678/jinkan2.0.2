package me.tvspark;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.PluralsRes;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.core.view.ViewCompat;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import me.tvspark.C2341lp;
import org.slf4j.Marker;

/* renamed from: me.tvspark.cn */
/* loaded from: classes4.dex */
public class C1989cn extends Drawable implements C2341lp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    @Nullable
    public WeakReference<FrameLayout> Wwwwwwwww;
    @Nullable
    public WeakReference<View> Wwwwwwwwww;
    public float Wwwwwwwwwww;
    public float Wwwwwwwwwwww;
    public float Wwwwwwwwwwwww;
    public int Wwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwwww;
    @NonNull
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwww;
    public final float Wwwwwwwwwwwwwwwwww;
    public final float Wwwwwwwwwwwwwwwwwww;
    public final float Wwwwwwwwwwwwwwwwwwww;
    @NonNull
    public final C2341lp Wwwwwwwwwwwwwwwwwwwwww;
    @NonNull
    public final WeakReference<Context> Wwwwwwwwwwwwwwwwwwwwwwww;
    @StyleRes
    public static final int Wwwwwwww = com.google.android.material.R$style.Widget_MaterialComponents_Badge;
    @AttrRes
    public static final int Wwwwwww = com.google.android.material.R$attr.badgeStyle;
    @NonNull
    public final Rect Wwwwwwwwwwwwwwwwwwwww = new Rect();
    @NonNull
    public final MaterialShapeDrawable Wwwwwwwwwwwwwwwwwwwwwww = new MaterialShapeDrawable();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* renamed from: me.tvspark.cn$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable {
        public static final Parcelable.Creator<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> CREATOR = new C3472Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        @Dimension(unit = 1)
        public int Wwwwwwwwwwwww;
        @Dimension(unit = 1)
        public int Wwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwww;
        @StringRes
        public int Wwwwwwwwwwwwwwwww;
        @PluralsRes
        public int Wwwwwwwwwwwwwwwwww;
        @Nullable
        public CharSequence Wwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwww;
        @ColorInt
        public int Wwwwwwwwwwwwwwwwwwwwwww;
        @ColorInt
        public int Wwwwwwwwwwwwwwwwwwwwwwww;

        /* renamed from: me.tvspark.cn$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C3472Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable.Creator<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> {
            @Override // android.os.Parcelable.Creator
            @NonNull
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww createFromParcel(@NonNull Parcel parcel) {
                return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parcel);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] newArray(int i) {
                return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i];
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Context context) {
            this.Wwwwwwwwwwwwwwwwwwwwww = 255;
            this.Wwwwwwwwwwwwwwwwwwwww = -1;
            int i = com.google.android.material.R$style.TextAppearance_MaterialComponents_Badge;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, com.google.android.material.R$styleable.TextAppearance);
            obtainStyledAttributes.getDimension(com.google.android.material.R$styleable.TextAppearance_android_textSize, 0.0f);
            ColorStateList Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, obtainStyledAttributes, com.google.android.material.R$styleable.TextAppearance_android_textColor);
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, obtainStyledAttributes, com.google.android.material.R$styleable.TextAppearance_android_textColorHint);
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, obtainStyledAttributes, com.google.android.material.R$styleable.TextAppearance_android_textColorLink);
            obtainStyledAttributes.getInt(com.google.android.material.R$styleable.TextAppearance_android_textStyle, 0);
            obtainStyledAttributes.getInt(com.google.android.material.R$styleable.TextAppearance_android_typeface, 1);
            int i2 = com.google.android.material.R$styleable.TextAppearance_fontFamily;
            i2 = !obtainStyledAttributes.hasValue(i2) ? com.google.android.material.R$styleable.TextAppearance_android_fontFamily : i2;
            obtainStyledAttributes.getResourceId(i2, 0);
            obtainStyledAttributes.getString(i2);
            obtainStyledAttributes.getBoolean(com.google.android.material.R$styleable.TextAppearance_textAllCaps, false);
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, obtainStyledAttributes, com.google.android.material.R$styleable.TextAppearance_android_shadowColor);
            obtainStyledAttributes.getFloat(com.google.android.material.R$styleable.TextAppearance_android_shadowDx, 0.0f);
            obtainStyledAttributes.getFloat(com.google.android.material.R$styleable.TextAppearance_android_shadowDy, 0.0f);
            obtainStyledAttributes.getFloat(com.google.android.material.R$styleable.TextAppearance_android_shadowRadius, 0.0f);
            obtainStyledAttributes.recycle();
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i, com.google.android.material.R$styleable.MaterialTextAppearance);
            obtainStyledAttributes2.hasValue(com.google.android.material.R$styleable.MaterialTextAppearance_android_letterSpacing);
            obtainStyledAttributes2.getFloat(com.google.android.material.R$styleable.MaterialTextAppearance_android_letterSpacing, 0.0f);
            obtainStyledAttributes2.recycle();
            this.Wwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getDefaultColor();
            this.Wwwwwwwwwwwwwwwwwww = context.getString(com.google.android.material.R$string.mtrl_badge_numberless_content_description);
            this.Wwwwwwwwwwwwwwwwww = com.google.android.material.R$plurals.mtrl_badge_content_description;
            this.Wwwwwwwwwwwwwwwww = com.google.android.material.R$string.mtrl_exceed_max_badge_number_content_description;
            this.Wwwwwwwwwwwwwww = true;
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Parcel parcel) {
            this.Wwwwwwwwwwwwwwwwwwwwww = 255;
            this.Wwwwwwwwwwwwwwwwwwwww = -1;
            this.Wwwwwwwwwwwwwwwwwwwwwwww = parcel.readInt();
            this.Wwwwwwwwwwwwwwwwwwwwwww = parcel.readInt();
            this.Wwwwwwwwwwwwwwwwwwwwww = parcel.readInt();
            this.Wwwwwwwwwwwwwwwwwwwww = parcel.readInt();
            this.Wwwwwwwwwwwwwwwwwwww = parcel.readInt();
            this.Wwwwwwwwwwwwwwwwwww = parcel.readString();
            this.Wwwwwwwwwwwwwwwwww = parcel.readInt();
            this.Wwwwwwwwwwwwwwww = parcel.readInt();
            this.Wwwwwwwwwwwwww = parcel.readInt();
            this.Wwwwwwwwwwwww = parcel.readInt();
            this.Wwwwwwwwwwwwwww = parcel.readInt() != 0;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwwwwww);
            parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwwwww);
            parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwwww);
            parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwww);
            parcel.writeString(this.Wwwwwwwwwwwwwwwwwww.toString());
            parcel.writeInt(this.Wwwwwwwwwwwwwwwwww);
            parcel.writeInt(this.Wwwwwwwwwwwwwwww);
            parcel.writeInt(this.Wwwwwwwwwwwwww);
            parcel.writeInt(this.Wwwwwwwwwwwww);
            parcel.writeInt(this.Wwwwwwwwwwwwwww ? 1 : 0);
        }
    }

    public C1989cn(@NonNull Context context) {
        C2832yp c2832yp;
        Context context2;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = new WeakReference<>(context);
        C2415np.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, C2415np.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "Theme.MaterialComponents");
        Resources resources = context.getResources();
        this.Wwwwwwwwwwwwwwwwwwww = resources.getDimensionPixelSize(com.google.android.material.R$dimen.mtrl_badge_radius);
        this.Wwwwwwwwwwwwwwwwww = resources.getDimensionPixelSize(com.google.android.material.R$dimen.mtrl_badge_long_text_horizontal_padding);
        this.Wwwwwwwwwwwwwwwwwww = resources.getDimensionPixelSize(com.google.android.material.R$dimen.mtrl_badge_with_text_radius);
        C2341lp c2341lp = new C2341lp(this);
        this.Wwwwwwwwwwwwwwwwwwwwww = c2341lp;
        c2341lp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setTextAlign(Paint.Align.CENTER);
        this.Wwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context);
        int i = com.google.android.material.R$style.TextAppearance_MaterialComponents_Badge;
        Context context3 = this.Wwwwwwwwwwwwwwwwwwwwwwww.get();
        if (context3 == null || this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww == (c2832yp = new C2832yp(context3, i)) || (context2 = this.Wwwwwwwwwwwwwwwwwwwwwwww.get()) == null) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2832yp, context2);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        float f;
        float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        float f2;
        Context context = this.Wwwwwwwwwwwwwwwwwwwwwwww.get();
        WeakReference<View> weakReference = this.Wwwwwwwwww;
        FrameLayout frameLayout = null;
        View view = weakReference != null ? weakReference.get() : null;
        if (context == null || view == null) {
            return;
        }
        Rect rect = new Rect();
        rect.set(this.Wwwwwwwwwwwwwwwwwwwww);
        Rect rect2 = new Rect();
        view.getDrawingRect(rect2);
        WeakReference<FrameLayout> weakReference2 = this.Wwwwwwwww;
        if (weakReference2 != null) {
            frameLayout = weakReference2.get();
        }
        if (frameLayout != null) {
            if (frameLayout == null) {
                frameLayout = (ViewGroup) view.getParent();
            }
            frameLayout.offsetDescendantRectToMyCoords(view, rect2);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwww;
        int i = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwww;
        if (i != 8388691 && i != 8388693) {
            f = rect2.top + wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwww;
        } else {
            f = rect2.bottom - this.Wwwwwwwwwwwwwwwww.Wwwwwwwwwwwww;
        }
        this.Wwwwwwwwwwwwwww = f;
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() <= 9) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = !Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() ? this.Wwwwwwwwwwwwwwwwwwww : this.Wwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            this.Wwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        } else {
            float f3 = this.Wwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwww = f3;
            this.Wwwwwwwwwww = f3;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = (this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) / 2.0f) + this.Wwwwwwwwwwwwwwwwww;
        }
        this.Wwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() ? com.google.android.material.R$dimen.mtrl_badge_text_horizontal_edge_offset : com.google.android.material.R$dimen.mtrl_badge_horizontal_edge_offset);
        int i2 = this.Wwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwww;
        if (i2 == 8388659 || i2 == 8388691 ? ViewCompat.getLayoutDirection(view) == 0 : ViewCompat.getLayoutDirection(view) != 0) {
            f2 = (rect2.left - this.Wwwwwwwwwwww) + dimensionPixelSize + this.Wwwwwwwwwwwwwwwww.Wwwwwwwwwwwwww;
        } else {
            f2 = ((rect2.right + this.Wwwwwwwwwwww) - dimensionPixelSize) - this.Wwwwwwwwwwwwwwwww.Wwwwwwwwwwwwww;
        }
        this.Wwwwwwwwwwwwwwww = f2;
        Rect rect3 = this.Wwwwwwwwwwwwwwwwwwwww;
        float f4 = this.Wwwwwwwwwwwwwww;
        float f5 = this.Wwwwwwwwwwww;
        float f6 = this.Wwwwwwwwwww;
        rect3.set((int) (f2 - f5), (int) (f4 - f6), (int) (f2 + f5), (int) (f4 + f6));
        MaterialShapeDrawable materialShapeDrawable = this.Wwwwwwwwwwwwwwwwwwwwwww;
        materialShapeDrawable.setShapeAppearanceModel(materialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwww));
        if (rect.equals(this.Wwwwwwwwwwwwwwwwwwwww)) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwww.setBounds(this.Wwwwwwwwwwwwwwwwwwwww);
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww != -1;
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return 0;
        }
        return this.Wwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww;
    }

    @Nullable
    public FrameLayout Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        WeakReference<FrameLayout> weakReference = this.Wwwwwwwww;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww != i) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwww = ((int) Math.pow(10.0d, i - 1.0d)) - 1;
            this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
            invalidateSelf();
        }
    }

    @Nullable
    public CharSequence Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Context context;
        if (!isVisible()) {
            return null;
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            if (this.Wwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww <= 0 || (context = this.Wwwwwwwwwwwwwwwwwwwwwwww.get()) == null) {
                return null;
            }
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            int i = this.Wwwwwwwwwwwwww;
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww <= i ? context.getResources().getQuantityString(this.Wwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), Integer.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww())) : context.getString(this.Wwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww, Integer.valueOf(i));
        }
        return this.Wwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww;
    }

    @NonNull
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() <= this.Wwwwwwwwwwwwww) {
            return NumberFormat.getInstance().format(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }
        Context context = this.Wwwwwwwwwwwwwwwwwwwwwwww.get();
        return context == null ? "" : context.getString(com.google.android.material.R$string.mtrl_exceed_max_badge_number_suffix, Integer.valueOf(this.Wwwwwwwwwwwwww), Marker.ANY_NON_NULL_MARKER);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwww != i) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwww = i;
            WeakReference<View> weakReference = this.Wwwwwwwwww;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            View view = this.Wwwwwwwwww.get();
            WeakReference<FrameLayout> weakReference2 = this.Wwwwwwwww;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view, weakReference2 != null ? weakReference2.get() : null);
        }
    }

    @Override // me.tvspark.C2341lp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        invalidateSelf();
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@ColorInt int i) {
        this.Wwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = i;
        ColorStateList valueOf = ColorStateList.valueOf(i);
        MaterialShapeDrawable materialShapeDrawable = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (materialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != valueOf) {
            materialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(valueOf);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (getBounds().isEmpty() || this.Wwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww == 0 || !isVisible()) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwww.draw(canvas);
        if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return;
        }
        Rect rect = new Rect();
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getTextBounds(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length(), rect);
        canvas.drawText(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwww + (rect.height() / 2), this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.Wwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.Wwwwwwwwwwwwwwwwwwwww.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.Wwwwwwwwwwwwwwwwwwwww.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return false;
    }

    @Override // android.graphics.drawable.Drawable, me.tvspark.C2341lp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.Wwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        int max = Math.max(0, i);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww != max) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww = max;
            this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
            invalidateSelf();
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull View view, @Nullable FrameLayout frameLayout) {
        this.Wwwwwwwwww = new WeakReference<>(view);
        this.Wwwwwwwww = new WeakReference<>(frameLayout);
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
        invalidateSelf();
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@ColorInt int i) {
        this.Wwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww = i;
        if (this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getColor() != i) {
            this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setColor(i);
            invalidateSelf();
        }
    }
}
