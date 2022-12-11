package me.tvspark;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* renamed from: me.tvspark.tn */
/* loaded from: classes4.dex */
public interface AbstractC2641tn {

    /* renamed from: me.tvspark.tn$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f, float f2, float f3) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f3;
        }

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }
    }

    /* renamed from: me.tvspark.tn$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Property<AbstractC2641tn, Integer> {
        public static final Property<AbstractC2641tn, Integer> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("circularRevealScrimColor");

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
            super(Integer.class, str);
        }

        @Override // android.util.Property
        @NonNull
        public Integer get(@NonNull AbstractC2641tn abstractC2641tn) {
            return Integer.valueOf(abstractC2641tn.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        public void set(@NonNull AbstractC2641tn abstractC2641tn, @NonNull Integer num) {
            abstractC2641tn.setCircularRevealScrimColor(num.intValue());
        }
    }

    /* renamed from: me.tvspark.tn$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Property<AbstractC2641tn, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww> {
        public static final Property<AbstractC2641tn, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("circularReveal");

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
            super(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.class, str);
        }

        @Override // android.util.Property
        @Nullable
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww get(@NonNull AbstractC2641tn abstractC2641tn) {
            return abstractC2641tn.getRevealInfo();
        }

        @Override // android.util.Property
        public void set(@NonNull AbstractC2641tn abstractC2641tn, @Nullable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            abstractC2641tn.setRevealInfo(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* renamed from: me.tvspark.tn$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements TypeEvaluator<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww> {
        public static final TypeEvaluator<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);

        @Override // android.animation.TypeEvaluator
        @NonNull
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww evaluate(float f, @NonNull Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, @NonNull Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, f);
            float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, f);
            float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, f);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    @ColorInt
    int getCircularRevealScrimColor();

    @Nullable
    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww getRevealInfo();

    void setCircularRevealOverlayDrawable(@Nullable Drawable drawable);

    void setCircularRevealScrimColor(@ColorInt int i);

    void setRevealInfo(@Nullable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
}
