package me.tvspark;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.transition.TransitionValues;
import androidx.transition.Visibility;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.AbstractC2086et;

/* renamed from: me.tvspark.at */
/* loaded from: classes4.dex */
public abstract class AbstractC1921at<P extends AbstractC2086et> extends Visibility {
    public final List<AbstractC2086et> Wwwwwwwwwwwwwwwwwwwwww = new ArrayList();
    @Nullable
    public AbstractC2086et Wwwwwwwwwwwwwwwwwwwwwww;
    public final P Wwwwwwwwwwwwwwwwwwwwwwww;

    public AbstractC1921at(P p, @Nullable AbstractC2086et abstractC2086et) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = p;
        this.Wwwwwwwwwwwwwwwwwwwwwww = abstractC2086et;
        mo4387setInterpolator(C2227im.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<Animator> list, @Nullable AbstractC2086et abstractC2086et, ViewGroup viewGroup, View view, boolean z) {
        if (abstractC2086et == null) {
            return;
        }
        Animator Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z ? abstractC2086et.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, view) : abstractC2086et.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, view);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            return;
        }
        list.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public final Animator Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ViewGroup viewGroup, View view, boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(arrayList, this.Wwwwwwwwwwwwwwwwwwwwwwww, viewGroup, view, z);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(arrayList, this.Wwwwwwwwwwwwwwwwwwwwwww, viewGroup, view, z);
        for (AbstractC2086et abstractC2086et : this.Wwwwwwwwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(arrayList, abstractC2086et, viewGroup, view, z);
        }
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(animatorSet, (List<Animator>) arrayList);
        return animatorSet;
    }

    @Override // androidx.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, view, true);
    }

    @Override // androidx.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, view, false);
    }
}
