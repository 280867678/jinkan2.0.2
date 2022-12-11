package me.tvspark;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.ref.WeakReference;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: me.tvspark.lp */
/* loaded from: classes4.dex */
public class C2341lp {
    @Nullable
    public C2832yp Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public WeakReference<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final TextPaint Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new TextPaint(1);
    public final AbstractC1918aq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;

    /* renamed from: me.tvspark.lp$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

        @NonNull
        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public C2341lp(@Nullable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new WeakReference<>(null);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new WeakReference<>(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        float measureText = str == null ? 0.0f : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.measureText((CharSequence) str, 0, str.length());
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = measureText;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        return measureText;
    }

    /* renamed from: me.tvspark.lp$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC1918aq {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.AbstractC1918aq
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            C2341lp c2341lp = C2341lp.this;
            c2341lp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2341lp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get();
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }

        @Override // me.tvspark.AbstractC1918aq
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Typeface typeface, boolean z) {
            if (z) {
                return;
            }
            C2341lp c2341lp = C2341lp.this;
            c2341lp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2341lp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get();
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                return;
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable C2832yp c2832yp, Context context) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww != c2832yp) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2832yp;
            if (c2832yp != null) {
                TextPaint textPaint = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                AbstractC1918aq abstractC1918aq = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                c2832yp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                c2832yp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(textPaint, c2832yp.Wwwwwwwwwwwwwwwwwwwww);
                c2832yp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, new C2869zp(c2832yp, textPaint, abstractC1918aq));
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get();
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.drawableState = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getState();
                }
                c2832yp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get();
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null) {
                return;
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.onStateChange(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getState());
        }
    }
}
