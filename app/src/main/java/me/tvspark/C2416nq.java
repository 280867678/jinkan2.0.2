package me.tvspark;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import androidx.annotation.AttrRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;

/* renamed from: me.tvspark.nq */
/* loaded from: classes4.dex */
public class C2416nq {
    public static final AbstractC2157gq Wwwwwwwwwwwwwwwwwwwwww = new C2342lq(0.5f);
    public C2268jq Wwwwwwwwwwwwwwwwwwwwwww;
    public C2268jq Wwwwwwwwwwwwwwwwwwwwwwww;
    public C2268jq Wwwwwwwwwwwwwwwwwwwwwwwww;
    public C2268jq Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public AbstractC2157gq Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public AbstractC2157gq Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public AbstractC2157gq Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public AbstractC2157gq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public C2194hq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public C2194hq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public C2194hq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public C2194hq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* renamed from: me.tvspark.nq$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        @NonNull
        AbstractC2157gq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull AbstractC2157gq abstractC2157gq);
    }

    public C2416nq() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2379mq();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2379mq();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2379mq();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2379mq();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2083eq(0.0f);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2083eq(0.0f);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2083eq(0.0f);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = new C2083eq(0.0f);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = new C2268jq();
        this.Wwwwwwwwwwwwwwwwwwwwwwwww = new C2268jq();
        this.Wwwwwwwwwwwwwwwwwwwwwwww = new C2268jq();
        this.Wwwwwwwwwwwwwwwwwwwwwww = new C2268jq();
    }

    @NonNull
    public static AbstractC2157gq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TypedArray typedArray, int i, @NonNull AbstractC2157gq abstractC2157gq) {
        TypedValue peekValue = typedArray.peekValue(i);
        if (peekValue == null) {
            return abstractC2157gq;
        }
        int i2 = peekValue.type;
        return i2 == 5 ? new C2083eq(TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics())) : i2 == 6 ? new C2342lq(peekValue.getFraction(1.0f, 1.0f)) : abstractC2157gq;
    }

    @NonNull
    public static Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @NonNull
    public static Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, @StyleRes int i, @StyleRes int i2) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, i, i2, new C2083eq(0));
    }

    @NonNull
    public static Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i, @StyleRes int i2, @NonNull AbstractC2157gq abstractC2157gq) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.google.android.material.R$styleable.MaterialShape, i, i2);
        int resourceId = obtainStyledAttributes.getResourceId(com.google.android.material.R$styleable.MaterialShape_shapeAppearance, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(com.google.android.material.R$styleable.MaterialShape_shapeAppearanceOverlay, 0);
        obtainStyledAttributes.recycle();
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, resourceId, resourceId2, abstractC2157gq);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull RectF rectF) {
        boolean z = this.Wwwwwwwwwwwwwwwwwwwwwww.getClass().equals(C2268jq.class) && this.Wwwwwwwwwwwwwwwwwwwwwwwww.getClass().equals(C2268jq.class) && this.Wwwwwwwwwwwwwwwwwwwwwwwwww.getClass().equals(C2268jq.class) && this.Wwwwwwwwwwwwwwwwwwwwwwww.getClass().equals(C2268jq.class);
        float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(rectF);
        return z && ((this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(rectF) > Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 ? 1 : (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(rectF) == Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 ? 0 : -1)) == 0 && (this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(rectF) > Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 ? 1 : (this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(rectF) == Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 ? 0 : -1)) == 0 && (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(rectF) > Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 ? 1 : (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(rectF) == Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 ? 0 : -1)) == 0) && ((this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof C2379mq) && (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof C2379mq) && (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof C2379mq) && (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof C2379mq));
    }

    @NonNull
    public static Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, @StyleRes int i, @StyleRes int i2, @NonNull AbstractC2157gq abstractC2157gq) {
        if (i2 != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i);
            i = i2;
            context = contextThemeWrapper;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, com.google.android.material.R$styleable.ShapeAppearance);
        try {
            int i3 = obtainStyledAttributes.getInt(com.google.android.material.R$styleable.ShapeAppearance_cornerFamily, 0);
            int i4 = obtainStyledAttributes.getInt(com.google.android.material.R$styleable.ShapeAppearance_cornerFamilyTopLeft, i3);
            int i5 = obtainStyledAttributes.getInt(com.google.android.material.R$styleable.ShapeAppearance_cornerFamilyTopRight, i3);
            int i6 = obtainStyledAttributes.getInt(com.google.android.material.R$styleable.ShapeAppearance_cornerFamilyBottomRight, i3);
            int i7 = obtainStyledAttributes.getInt(com.google.android.material.R$styleable.ShapeAppearance_cornerFamilyBottomLeft, i3);
            AbstractC2157gq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obtainStyledAttributes, com.google.android.material.R$styleable.ShapeAppearance_cornerSize, abstractC2157gq);
            AbstractC2157gq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obtainStyledAttributes, com.google.android.material.R$styleable.ShapeAppearance_cornerSizeTopLeft, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            AbstractC2157gq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obtainStyledAttributes, com.google.android.material.R$styleable.ShapeAppearance_cornerSizeTopRight, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            AbstractC2157gq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obtainStyledAttributes, com.google.android.material.R$styleable.ShapeAppearance_cornerSizeBottomRight, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            AbstractC2157gq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obtainStyledAttributes, com.google.android.material.R$styleable.ShapeAppearance_cornerSizeBottomLeft, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            C2194hq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7;
            float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 != -1.0f) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8);
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
            C2194hq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i5);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9;
            float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10 != -1.0f) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10);
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
            C2194hq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i6);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11;
            float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12 != -1.0f) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12);
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5;
            C2194hq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww13 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i7);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww13;
            float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww14 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww13);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww14 != -1.0f) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww14);
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6;
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @NonNull
    public static Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i, @StyleRes int i2) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, attributeSet, i, i2, new C2083eq(0));
    }

    /* renamed from: me.tvspark.nq$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        @NonNull
        public C2268jq Wwwwwwwwwwwwwwwwwwwwwww;
        @NonNull
        public C2268jq Wwwwwwwwwwwwwwwwwwwwwwww;
        @NonNull
        public C2268jq Wwwwwwwwwwwwwwwwwwwwwwwww;
        @NonNull
        public C2268jq Wwwwwwwwwwwwwwwwwwwwwwwwww;
        @NonNull
        public AbstractC2157gq Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        @NonNull
        public AbstractC2157gq Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        @NonNull
        public AbstractC2157gq Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        @NonNull
        public AbstractC2157gq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        @NonNull
        public C2194hq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        @NonNull
        public C2194hq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        @NonNull
        public C2194hq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        @NonNull
        public C2194hq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2379mq();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2379mq();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2379mq();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2379mq();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2083eq(0.0f);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2083eq(0.0f);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2083eq(0.0f);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = new C2083eq(0.0f);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = new C2268jq();
            this.Wwwwwwwwwwwwwwwwwwwwwwwww = new C2268jq();
            this.Wwwwwwwwwwwwwwwwwwwwwwww = new C2268jq();
            this.Wwwwwwwwwwwwwwwwwwwwwww = new C2268jq();
        }

        public static float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2194hq c2194hq) {
            if (c2194hq instanceof C2379mq) {
                return ((C2379mq) c2194hq).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            if (!(c2194hq instanceof C2231iq)) {
                return -1.0f;
            }
            return ((C2231iq) c2194hq).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @NonNull
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Dimension float f) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2083eq(f);
            return this;
        }

        @NonNull
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Dimension float f) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2083eq(f);
            return this;
        }

        @NonNull
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Dimension float f) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2083eq(f);
            return this;
        }

        @NonNull
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Dimension float f) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = new C2083eq(f);
            return this;
        }

        @NonNull
        public C2416nq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return new C2416nq(this, null);
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull C2416nq c2416nq) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2379mq();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2379mq();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2379mq();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2379mq();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2083eq(0.0f);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2083eq(0.0f);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2083eq(0.0f);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = new C2083eq(0.0f);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = new C2268jq();
            this.Wwwwwwwwwwwwwwwwwwwwwwwww = new C2268jq();
            this.Wwwwwwwwwwwwwwwwwwwwwwww = new C2268jq();
            this.Wwwwwwwwwwwwwwwwwwwwwww = new C2268jq();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = c2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = c2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = c2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwww = c2416nq.Wwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwww = c2416nq.Wwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwww = c2416nq.Wwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    @NonNull
    public C2416nq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f);
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f);
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f);
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f);
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public /* synthetic */ C2416nq(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public C2416nq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }
}
