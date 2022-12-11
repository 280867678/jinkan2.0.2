package me.tvspark;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import androidx.annotation.FontRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.content.res.ResourcesCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: me.tvspark.yp */
/* loaded from: classes4.dex */
public class C2832yp {
    public Typeface Wwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwww = false;
    @FontRes
    public final int Wwwwwwwwwwwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwwwwwwwwwwww;
    public final float Wwwwwwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public final float Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final float Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final float Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final ColorStateList Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final ColorStateList Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.yp$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends ResourcesCompat.FontCallback {
        public final /* synthetic */ AbstractC1918aq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC1918aq abstractC1918aq) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC1918aq;
        }

        @Override // androidx.core.content.res.ResourcesCompat.FontCallback
        public void onFontRetrievalFailed(int i) {
            C2832yp.this.Wwwwwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        }

        @Override // androidx.core.content.res.ResourcesCompat.FontCallback
        public void onFontRetrieved(@NonNull Typeface typeface) {
            C2832yp c2832yp = C2832yp.this;
            c2832yp.Wwwwwwwwwwwwwwwwwwwww = Typeface.create(typeface, c2832yp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            C2832yp c2832yp2 = C2832yp.this;
            c2832yp2.Wwwwwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2832yp2.Wwwwwwwwwwwwwwwwwwwww, false);
        }
    }

    public C2832yp(@NonNull Context context, @StyleRes int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, com.google.android.material.R$styleable.TextAppearance);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = obtainStyledAttributes.getDimension(com.google.android.material.R$styleable.TextAppearance_android_textSize, 0.0f);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, obtainStyledAttributes, com.google.android.material.R$styleable.TextAppearance_android_textColor);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, obtainStyledAttributes, com.google.android.material.R$styleable.TextAppearance_android_textColorHint);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, obtainStyledAttributes, com.google.android.material.R$styleable.TextAppearance_android_textColorLink);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = obtainStyledAttributes.getInt(com.google.android.material.R$styleable.TextAppearance_android_textStyle, 0);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = obtainStyledAttributes.getInt(com.google.android.material.R$styleable.TextAppearance_android_typeface, 1);
        int i2 = com.google.android.material.R$styleable.TextAppearance_fontFamily;
        i2 = !obtainStyledAttributes.hasValue(i2) ? com.google.android.material.R$styleable.TextAppearance_android_fontFamily : i2;
        this.Wwwwwwwwwwwwwwwwwwwwwww = obtainStyledAttributes.getResourceId(i2, 0);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = obtainStyledAttributes.getString(i2);
        obtainStyledAttributes.getBoolean(com.google.android.material.R$styleable.TextAppearance_textAllCaps, false);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, obtainStyledAttributes, com.google.android.material.R$styleable.TextAppearance_android_shadowColor);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = obtainStyledAttributes.getFloat(com.google.android.material.R$styleable.TextAppearance_android_shadowDx, 0.0f);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = obtainStyledAttributes.getFloat(com.google.android.material.R$styleable.TextAppearance_android_shadowDy, 0.0f);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = obtainStyledAttributes.getFloat(com.google.android.material.R$styleable.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i, com.google.android.material.R$styleable.MaterialTextAppearance);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = obtainStyledAttributes2.hasValue(com.google.android.material.R$styleable.MaterialTextAppearance_android_letterSpacing);
        this.Wwwwwwwwwwwwwwwwwwwwwwwww = obtainStyledAttributes2.getFloat(com.google.android.material.R$styleable.MaterialTextAppearance_android_letterSpacing, 0.0f);
        obtainStyledAttributes2.recycle();
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        String str;
        if (this.Wwwwwwwwwwwwwwwwwwwww == null && (str = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) != null) {
            this.Wwwwwwwwwwwwwwwwwwwww = Typeface.create(str, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        if (this.Wwwwwwwwwwwwwwwwwwwww == null) {
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwww = i != 1 ? i != 2 ? i != 3 ? Typeface.DEFAULT : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF;
            this.Wwwwwwwwwwwwwwwwwwwww = Typeface.create(this.Wwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull AbstractC1918aq abstractC1918aq) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(textPaint, this.Wwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, new C2869zp(this, textPaint, abstractC1918aq));
        ColorStateList colorStateList = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        float f = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        float f2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        float f3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        ColorStateList colorStateList2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        textPaint.setShadowLayer(f, f2, f3, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Context context, @NonNull AbstractC1918aq abstractC1918aq) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (this.Wwwwwwwwwwwwwwwwwwwwwww == 0) {
            this.Wwwwwwwwwwwwwwwwwwwwww = true;
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwww) {
            abstractC1918aq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwww, true);
            return;
        }
        try {
            ResourcesCompat.getFont(context, this.Wwwwwwwwwwwwwwwwwwwwwww, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1918aq), null);
        } catch (Resources.NotFoundException unused) {
            this.Wwwwwwwwwwwwwwwwwwwwww = true;
            abstractC1918aq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        } catch (Exception unused2) {
            this.Wwwwwwwwwwwwwwwwwwwwww = true;
            abstractC1918aq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-3);
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull TextPaint textPaint, @NonNull Typeface typeface) {
        textPaint.setTypeface(typeface);
        int i = (~typeface.getStyle()) & this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        textPaint.setFakeBoldText((i & 1) != 0);
        textPaint.setTextSkewX((i & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
            textPaint.setLetterSpacing(this.Wwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }
}
