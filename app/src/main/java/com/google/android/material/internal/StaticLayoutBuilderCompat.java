package com.google.android.material.internal;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.lang.reflect.Constructor;
import me.tvspark.outline;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public final class StaticLayoutBuilderCompat {
    @Nullable
    public static Object Wwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public static Constructor<StaticLayout> Wwwwwwwwwwwwwwwwwwwwwww;
    public static boolean Wwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final TextPaint Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public CharSequence Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
    public Layout.Alignment Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Layout.Alignment.ALIGN_NORMAL;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Integer.MAX_VALUE;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwww = true;
    @Nullable
    public TextUtils.TruncateAt Wwwwwwwwwwwwwwwwwwwwwwwww = null;

    /* loaded from: classes3.dex */
    public static class StaticLayoutBuilderCompatException extends Exception {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public StaticLayoutBuilderCompatException(Throwable th) {
            super(r0.toString(), th);
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Error thrown initializing StaticLayout ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(th.getMessage());
        }
    }

    public StaticLayoutBuilderCompat(CharSequence charSequence, TextPaint textPaint, int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = charSequence;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = textPaint;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = charSequence.length();
    }

    public StaticLayout Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws StaticLayoutBuilderCompatException {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = "";
        }
        int max = Math.max(0, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        CharSequence charSequence = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww == 1) {
            charSequence = TextUtils.ellipsize(charSequence, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, max, this.Wwwwwwwwwwwwwwwwwwwwwwwww);
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Math.min(charSequence.length(), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Layout.Alignment.ALIGN_OPPOSITE;
            }
            StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, max);
            obtain.setAlignment(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            obtain.setIncludePad(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
            obtain.setTextDirection(this.Wwwwwwwwwwwwwwwwwwwwwwwwww ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
            TextUtils.TruncateAt truncateAt = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
            if (truncateAt != null) {
                obtain.setEllipsize(truncateAt);
            }
            obtain.setMaxLines(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
            return obtain.build();
        }
        if (!Wwwwwwwwwwwwwwwwwwwwwwww) {
            try {
                Wwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwww && i >= 23 ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
                Constructor<StaticLayout> declaredConstructor = StaticLayout.class.getDeclaredConstructor(CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE, Layout.Alignment.class, TextDirectionHeuristic.class, Float.TYPE, Float.TYPE, Boolean.TYPE, TextUtils.TruncateAt.class, Integer.TYPE, Integer.TYPE);
                Wwwwwwwwwwwwwwwwwwwwwww = declaredConstructor;
                declaredConstructor.setAccessible(true);
                Wwwwwwwwwwwwwwwwwwwwwwww = true;
            } catch (Exception e) {
                throw new StaticLayoutBuilderCompatException(e);
            }
        }
        try {
            return (StaticLayout) ((Constructor) Preconditions.checkNotNull(Wwwwwwwwwwwwwwwwwwwwwww)).newInstance(charSequence, Integer.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), Integer.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Integer.valueOf(max), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, Preconditions.checkNotNull(Wwwwwwwwwwwwwwwwwwwwww), Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww), null, Integer.valueOf(max), Integer.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww));
        } catch (Exception e2) {
            throw new StaticLayoutBuilderCompatException(e2);
        }
    }
}
