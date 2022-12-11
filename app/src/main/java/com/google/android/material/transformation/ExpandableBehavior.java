package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import java.util.List;
import me.tvspark.AbstractC2679uo;

@Deprecated
/* loaded from: classes3.dex */
public abstract class ExpandableBehavior extends CoordinatorLayout.Behavior<View> {
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements ViewTreeObserver.OnPreDrawListener {
        public final /* synthetic */ AbstractC2679uo Wwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ View Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(View view, int i, AbstractC2679uo abstractC2679uo) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = view;
            this.Wwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwww = abstractC2679uo;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.getViewTreeObserver().removeOnPreDrawListener(this);
            ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
            if (expandableBehavior.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == this.Wwwwwwwwwwwwwwwwwwwwwww) {
                AbstractC2679uo abstractC2679uo = this.Wwwwwwwwwwwwwwwwwwwwww;
                expandableBehavior.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((View) abstractC2679uo, this.Wwwwwwwwwwwwwwwwwwwwwwww, abstractC2679uo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), false);
            }
            return false;
        }
    }

    public ExpandableBehavior() {
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public abstract boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(View view, View view2, boolean z, boolean z2);

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        if (!z) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 1;
        }
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        return i == 0 || i == 2;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        AbstractC2679uo abstractC2679uo = (AbstractC2679uo) view2;
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2679uo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww())) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2679uo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() ? 1 : 2;
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((View) abstractC2679uo, view, abstractC2679uo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), true);
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i) {
        AbstractC2679uo abstractC2679uo;
        if (!ViewCompat.isLaidOut(view)) {
            List<View> dependencies = coordinatorLayout.getDependencies(view);
            int size = dependencies.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    abstractC2679uo = null;
                    break;
                }
                View view2 = dependencies.get(i2);
                if (layoutDependsOn(coordinatorLayout, view, view2)) {
                    abstractC2679uo = (AbstractC2679uo) view2;
                    break;
                }
                i2++;
            }
            if (abstractC2679uo != null && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2679uo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww())) {
                int i3 = abstractC2679uo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() ? 1 : 2;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
                view.getViewTreeObserver().addOnPreDrawListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view, i3, abstractC2679uo));
            }
        }
        return false;
    }
}
