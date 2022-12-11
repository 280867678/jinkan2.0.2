package me.tvspark;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleableRes;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;
import java.util.List;

/* renamed from: me.tvspark.om */
/* loaded from: classes4.dex */
public class C2449om {
    public final SimpleArrayMap<String, C2486pm> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new SimpleArrayMap<>();
    public final SimpleArrayMap<String, PropertyValuesHolder[]> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new SimpleArrayMap<>();

    @Nullable
    public static C2449om Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Context context, @AnimatorRes int i) {
        try {
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, i);
            if (loadAnimator instanceof AnimatorSet) {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((AnimatorSet) loadAnimator).getChildAnimations());
            }
            if (loadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(loadAnimator);
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(arrayList);
        } catch (Exception unused) {
            Integer.toHexString(i);
            return null;
        }
    }

    @Nullable
    public static C2449om Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Context context, @NonNull TypedArray typedArray, @StyleableRes int i) {
        int resourceId;
        if (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) {
            return null;
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, resourceId);
    }

    @NonNull
    public static C2449om Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull List<Animator> list) {
        C2449om c2449om = new C2449om();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Animator animator = list.get(i);
            if (animator instanceof ObjectAnimator) {
                ObjectAnimator objectAnimator = (ObjectAnimator) animator;
                c2449om.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(objectAnimator.getPropertyName(), objectAnimator.getValues());
                String propertyName = objectAnimator.getPropertyName();
                long startDelay = objectAnimator.getStartDelay();
                long duration = objectAnimator.getDuration();
                TimeInterpolator interpolator = objectAnimator.getInterpolator();
                if ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) {
                    interpolator = C2227im.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                } else if (interpolator instanceof AccelerateInterpolator) {
                    interpolator = C2227im.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                } else if (interpolator instanceof DecelerateInterpolator) {
                    interpolator = C2227im.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
                C2486pm c2486pm = new C2486pm(startDelay, duration, interpolator);
                c2486pm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = objectAnimator.getRepeatCount();
                c2486pm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = objectAnimator.getRepeatMode();
                c2449om.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(propertyName, c2486pm);
            } else {
                throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
            }
        }
        return c2449om;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C2449om) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(((C2449om) obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        return false;
    }

    public int hashCode() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode();
    }

    @NonNull
    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('\n');
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(C2449om.class.getName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append('{');
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Integer.toHexString(System.identityHashCode(this)));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" timings: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("}\n");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    public C2486pm Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(str) != null) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(str);
        }
        throw new IllegalArgumentException();
    }
}
