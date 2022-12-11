package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.Key;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$animator;
import com.google.android.material.R$id;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.AbstractC2641tn;
import me.tvspark.C2227im;
import me.tvspark.C2264jm;
import me.tvspark.C2301km;
import me.tvspark.C2338lm;
import me.tvspark.C2418ns;
import me.tvspark.C2449om;
import me.tvspark.C2455os;
import me.tvspark.C2486pm;
import me.tvspark.C2498ps;
import me.tvspark.C2529qm;
import me.tvspark.C2535qs;
import me.tvspark.C2567rn;
import me.tvspark.Illllllllllllllllllllllllllll;

@Deprecated
/* loaded from: classes3.dex */
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {
    public float Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final RectF Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final RectF Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Rect Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public C2529qm Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        @Nullable
        public C2449om Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AnimatorListenerAdapter {
        public final /* synthetic */ View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(FabTransformationBehavior fabTransformationBehavior, boolean z, View view, View view2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = view;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setVisibility(4);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setAlpha(1.0f);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setVisibility(0);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setVisibility(0);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setAlpha(0.0f);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setVisibility(4);
            }
        }
    }

    public FabTransformationBehavior() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Rect();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new RectF();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new RectF();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new int[2];
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Rect();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new RectF();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new RectF();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new int[2];
    }

    public final float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull View view, @NonNull View view2, @NonNull C2529qm c2529qm) {
        float centerY;
        float centerY2;
        RectF rectF = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        RectF rectF2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view, rectF);
        rectF.offset(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view2, rectF2);
        float f = 0.0f;
        int i = c2529qm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 112;
        if (i == 16) {
            centerY = rectF2.centerY();
            centerY2 = rectF.centerY();
        } else if (i != 48) {
            if (i == 80) {
                centerY = rectF2.bottom;
                centerY2 = rectF.bottom;
            }
            return f + c2529qm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        } else {
            centerY = rectF2.top;
            centerY2 = rectF.top;
        }
        f = centerY - centerY2;
        return f + c2529qm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public final float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull View view, @NonNull View view2, @NonNull C2529qm c2529qm) {
        float centerX;
        float centerX2;
        RectF rectF = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        RectF rectF2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view, rectF);
        rectF.offset(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view2, rectF2);
        float f = 0.0f;
        int i = c2529qm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 7;
        if (i == 1) {
            centerX = rectF2.centerX();
            centerX2 = rectF.centerX();
        } else if (i != 3) {
            if (i == 5) {
                centerX = rectF2.right;
                centerX2 = rectF.right;
            }
            return f + c2529qm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        } else {
            centerX = rectF2.left;
            centerX2 = rectF.left;
        }
        f = centerX - centerX2;
        return f + c2529qm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @NonNull
    public final Pair<C2486pm, C2486pm> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f, float f2, boolean z, @NonNull Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        C2486pm Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        C2449om c2449om;
        String str;
        int i;
        if (f == 0.0f || f2 == 0.0f) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("translationXLinear");
            c2449om = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            str = "translationYLinear";
        } else if ((!z || f2 >= 0.0f) && (z || i <= 0)) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("translationXCurveDownwards");
            c2449om = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            str = "translationYCurveDownwards";
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("translationXCurveUpwards");
            c2449om = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            str = "translationYCurveUpwards";
        }
        return new Pair<>(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, c2449om.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str));
    }

    @Nullable
    public final ViewGroup Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        int[] iArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        view.getLocationInWindow(iArr);
        rectF.offsetTo(iArr[0], iArr[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public boolean layoutDependsOn(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
        if (view.getVisibility() != 8) {
            if (!(view2 instanceof FloatingActionButton)) {
                return false;
            }
            int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
            return expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId();
        }
        throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        if (layoutParams.dodgeInsetEdges == 0) {
            layoutParams.dodgeInsetEdges = 80;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x03ee A[LOOP:0: B:43:0x03ec->B:44:0x03ee, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01ad  */
    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AnimatorSet Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull View view, @NonNull View view2, boolean z, boolean z2) {
        ObjectAnimator ofFloat;
        ArrayList arrayList;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ArrayList arrayList2;
        boolean z3;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        ArrayList arrayList3;
        AbstractC2641tn abstractC2641tn;
        ArrayList arrayList4;
        Animator animator;
        ArrayList arrayList5;
        boolean z4;
        ObjectAnimator ofInt;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        FabTransformationBehavior fabTransformationBehavior;
        ViewGroup Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        int i;
        ObjectAnimator ofFloat4;
        int size;
        ObjectAnimator ofInt2;
        Context context = view2.getContext();
        int i2 = z ? R$animator.mtrl_fab_transformation_sheet_expand_spec : R$animator.mtrl_fab_transformation_sheet_collapse_spec;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2449om.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, i2);
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2529qm(17, 0.0f, 0.0f);
        if (z) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = view.getTranslationX();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = view.getTranslationY();
        }
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        float elevation = ViewCompat.getElevation(view2) - ViewCompat.getElevation(view);
        if (z) {
            if (!z2) {
                view2.setTranslationZ(-elevation);
            }
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, 0.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, -elevation);
        }
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Key.ELEVATION).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ofFloat);
        arrayList6.add(ofFloat);
        RectF rectF = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view, view2, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view, view2, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Pair<C2486pm, C2486pm> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, z, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
        C2486pm c2486pm = (C2486pm) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.first;
        C2486pm c2486pm2 = (C2486pm) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.second;
        if (z) {
            if (!z2) {
                view2.setTranslationX(-Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                view2.setTranslationY(-Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            }
            arrayList = arrayList7;
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, 0.0f);
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, 0.0f);
            float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, c2486pm, -Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, 0.0f);
            float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, c2486pm2, -Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, 0.0f);
            Rect rect = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            view2.getWindowVisibleDisplayFrame(rect);
            RectF rectF2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            rectF2.set(rect);
            RectF rectF3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view2, rectF3);
            rectF3.offset(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6);
            rectF3.intersect(rectF2);
            rectF.set(rectF3);
            ofFloat3 = ofFloat6;
            ofFloat2 = ofFloat5;
        } else {
            arrayList = arrayList7;
            ofFloat2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, -Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
            ofFloat3 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, -Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        }
        c2486pm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ofFloat2);
        c2486pm2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ofFloat3);
        arrayList6.add(ofFloat2);
        arrayList6.add(ofFloat3);
        float width = rectF.width();
        float height = rectF.height();
        float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view, view2, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view, view2, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Pair<C2486pm, C2486pm> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, z, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
        C2486pm c2486pm3 = (C2486pm) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.first;
        C2486pm c2486pm4 = (C2486pm) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.second;
        Property property = View.TRANSLATION_X;
        float[] fArr = new float[1];
        if (!z) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        fArr[0] = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7;
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(view, property, fArr);
        Property property2 = View.TRANSLATION_Y;
        float[] fArr2 = new float[1];
        if (!z) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        fArr2[0] = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(view, property2, fArr2);
        c2486pm3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ofFloat7);
        c2486pm4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ofFloat8);
        arrayList6.add(ofFloat7);
        arrayList6.add(ofFloat8);
        boolean z5 = view2 instanceof AbstractC2641tn;
        if (z5 && (view instanceof ImageView)) {
            AbstractC2641tn abstractC2641tn2 = (AbstractC2641tn) view2;
            Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable != null) {
                drawable.mutate();
                if (z) {
                    if (!z2) {
                        drawable.setAlpha(255);
                    }
                    ofInt2 = ObjectAnimator.ofInt(drawable, C2338lm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0);
                } else {
                    ofInt2 = ObjectAnimator.ofInt(drawable, C2338lm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 255);
                }
                ofInt2.addUpdateListener(new C2418ns(this, view2));
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("iconFade").Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ofInt2);
                arrayList6.add(ofInt2);
                C2455os c2455os = new C2455os(this, abstractC2641tn2, drawable);
                arrayList2 = arrayList;
                arrayList2.add(c2455os);
                if (z5) {
                    arrayList4 = arrayList6;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                    z3 = z5;
                    arrayList5 = arrayList2;
                } else {
                    AbstractC2641tn abstractC2641tn3 = (AbstractC2641tn) view2;
                    C2529qm c2529qm = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    RectF rectF4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    RectF rectF5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view, rectF4);
                    rectF4.offset(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view2, rectF5);
                    rectF5.offset(-Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view, view2, c2529qm), 0.0f);
                    float centerX = rectF4.centerX() - rectF5.left;
                    C2529qm c2529qm2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    RectF rectF6 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    RectF rectF7 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view, rectF6);
                    z3 = z5;
                    rectF6.offset(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view2, rectF7);
                    rectF7.offset(0.0f, -Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view, view2, c2529qm2));
                    float centerY = rectF6.centerY() - rectF7.top;
                    ((FloatingActionButton) view).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    float width2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.width() / 2.0f;
                    C2486pm Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("expansion");
                    if (z) {
                        if (!z2) {
                            abstractC2641tn3.setRevealInfo(new AbstractC2641tn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(centerX, centerY, width2));
                        }
                        if (z2) {
                            width2 = abstractC2641tn3.getRevealInfo().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        }
                        float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(centerX, centerY, 0.0f, 0.0f);
                        float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(centerX, centerY, width, 0.0f);
                        float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(centerX, centerY, width, height);
                        float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww13 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(centerX, centerY, 0.0f, height);
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10 <= Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10 <= Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10 <= Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww13) {
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10 = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11 <= Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11 <= Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww13) ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12 > Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww13 ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12 : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww13 : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11;
                        }
                        animator = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2641tn3, centerX, centerY, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10);
                        animator.addListener(new C2498ps(this, abstractC2641tn3));
                        long j = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        int i3 = (int) centerX;
                        int i4 = (int) centerY;
                        if (j > 0) {
                            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view2, i3, i4, width2, width2);
                            createCircularReveal.setStartDelay(0L);
                            createCircularReveal.setDuration(j);
                            arrayList6.add(createCircularReveal);
                        }
                        arrayList4 = arrayList6;
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                        arrayList3 = arrayList2;
                        abstractC2641tn = abstractC2641tn3;
                    } else {
                        float f = abstractC2641tn3.getRevealInfo().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        Animator Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww14 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2641tn3, centerX, centerY, width2);
                        long j2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        int i5 = (int) centerX;
                        int i6 = (int) centerY;
                        if (j2 > 0) {
                            Animator createCircularReveal2 = ViewAnimationUtils.createCircularReveal(view2, i5, i6, f, f);
                            createCircularReveal2.setStartDelay(0L);
                            createCircularReveal2.setDuration(j2);
                            arrayList6.add(createCircularReveal2);
                        }
                        long j3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        long j4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        C2449om c2449om = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        int size2 = c2449om.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size();
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                        arrayList3 = arrayList2;
                        abstractC2641tn = abstractC2641tn3;
                        int i7 = 0;
                        long j5 = 0;
                        while (i7 < size2) {
                            int i8 = size2;
                            C2486pm valueAt = c2449om.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.valueAt(i7);
                            j5 = Math.max(j5, valueAt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + valueAt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            i7++;
                            size2 = i8;
                            arrayList6 = arrayList6;
                            i5 = i5;
                            c2449om = c2449om;
                        }
                        int i9 = i5;
                        ArrayList arrayList8 = arrayList6;
                        long j6 = j3 + j4;
                        if (j6 < j5) {
                            Animator createCircularReveal3 = ViewAnimationUtils.createCircularReveal(view2, i9, i6, width2, width2);
                            createCircularReveal3.setStartDelay(j6);
                            createCircularReveal3.setDuration(j5 - j6);
                            arrayList4 = arrayList8;
                            arrayList4.add(createCircularReveal3);
                        } else {
                            arrayList4 = arrayList8;
                        }
                        animator = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww14;
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(animator);
                    arrayList4.add(animator);
                    arrayList5 = arrayList3;
                    arrayList5.add(new C2567rn(abstractC2641tn));
                }
                if (z3) {
                    z4 = z;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                } else {
                    AbstractC2641tn abstractC2641tn4 = (AbstractC2641tn) view2;
                    ColorStateList backgroundTintList = ViewCompat.getBackgroundTintList(view);
                    int colorForState = backgroundTintList != null ? backgroundTintList.getColorForState(view.getDrawableState(), backgroundTintList.getDefaultColor()) : 0;
                    int i10 = 16777215 & colorForState;
                    z4 = z;
                    if (z4) {
                        if (!z2) {
                            abstractC2641tn4.setCircularRevealScrimColor(colorForState);
                        }
                        ofInt = ObjectAnimator.ofInt(abstractC2641tn4, AbstractC2641tn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i10);
                    } else {
                        ofInt = ObjectAnimator.ofInt(abstractC2641tn4, AbstractC2641tn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, colorForState);
                    }
                    ofInt.setEvaluator(C2264jm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("color").Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ofInt);
                    arrayList4.add(ofInt);
                }
                if (view2 instanceof ViewGroup) {
                    i = 0;
                    fabTransformationBehavior = this;
                } else {
                    View findViewById = view2.findViewById(R$id.mtrl_child_content_container);
                    if (findViewById == null) {
                        if ((view2 instanceof C2535qs) || (view2 instanceof TransformationChildCard)) {
                            findViewById = ((ViewGroup) view2).getChildAt(0);
                        } else {
                            fabTransformationBehavior = this;
                            findViewById = view2;
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = fabTransformationBehavior.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(findViewById);
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
                                i = 0;
                            } else {
                                if (z4) {
                                    if (!z2) {
                                        C2301km.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.set(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, Float.valueOf(0.0f));
                                    }
                                    i = 0;
                                    ofFloat4 = ObjectAnimator.ofFloat(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, C2301km.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 1.0f);
                                } else {
                                    i = 0;
                                    ofFloat4 = ObjectAnimator.ofFloat(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, C2301km.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0.0f);
                                }
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("contentFade").Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ofFloat4);
                                arrayList4.add(ofFloat4);
                            }
                        }
                    }
                    fabTransformationBehavior = this;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = fabTransformationBehavior.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(findViewById);
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
                    }
                }
                AnimatorSet animatorSet = new AnimatorSet();
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(animatorSet, (List<Animator>) arrayList4);
                animatorSet.addListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fabTransformationBehavior, z4, view2, view));
                size = arrayList5.size();
                while (i < size) {
                    animatorSet.addListener((Animator.AnimatorListener) arrayList5.get(i));
                    i++;
                }
                return animatorSet;
            }
        }
        arrayList2 = arrayList;
        if (z5) {
        }
        if (z3) {
        }
        if (view2 instanceof ViewGroup) {
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(animatorSet2, (List<Animator>) arrayList4);
        animatorSet2.addListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fabTransformationBehavior, z4, view2, view));
        size = arrayList5.size();
        while (i < size) {
        }
        return animatorSet2;
    }

    public final float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, @NonNull C2486pm c2486pm, float f, float f2) {
        long j = c2486pm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        long j2 = c2486pm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        C2486pm Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("expansion");
        return C2227im.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f, f2, c2486pm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().getInterpolation(((float) (((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) + 17) - j)) / ((float) j2)));
    }
}
