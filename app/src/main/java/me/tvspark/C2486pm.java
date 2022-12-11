package me.tvspark;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* renamed from: me.tvspark.pm */
/* loaded from: classes4.dex */
public class C2486pm {
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public TimeInterpolator Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2486pm(long j, long j2) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0L;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 300L;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j2;
    }

    public C2486pm(long j, long j2, @NonNull TimeInterpolator timeInterpolator) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0L;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 300L;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = timeInterpolator;
    }

    @Nullable
    public TimeInterpolator Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        TimeInterpolator timeInterpolator = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        return timeInterpolator != null ? timeInterpolator : C2227im.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Animator animator) {
        animator.setStartDelay(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        animator.setDuration(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        animator.setInterpolator(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            valueAnimator.setRepeatMode(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2486pm)) {
            return false;
        }
        C2486pm c2486pm = (C2486pm) obj;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != c2486pm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != c2486pm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != c2486pm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww != c2486pm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return false;
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().getClass().equals(c2486pm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().getClass());
    }

    public int hashCode() {
        long j = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        long j2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        return ((((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().getClass().hashCode() + (((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31)) * 31) + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) * 31) + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @NonNull
    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('\n');
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(C2486pm.class.getName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append('{');
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Integer.toHexString(System.identityHashCode(this)));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" delay: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" duration: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" interpolator: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().getClass());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" repeatCount: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" repeatMode: ");
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "}\n");
    }
}
