package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$styleable;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import java.util.List;
import me.tvspark.AbstractC2119fp;
import me.tvspark.C2193hp;
import me.tvspark.C2449om;
import me.tvspark.C2794xo;

/* loaded from: classes3.dex */
public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.AttachedBehavior {
    public boolean Www;
    public boolean Wwww;
    public final AbstractC2119fp Wwwww;
    public final AbstractC2119fp Wwwwww;
    @NonNull
    public final AbstractC2119fp Wwwwwww;
    @NonNull
    public final AbstractC2119fp Wwwwwwww;

    /* loaded from: classes3.dex */
    public static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.Behavior<T> {
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public Rect Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public ExtendedFloatingActionButtonBehavior() {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        }

        public ExtendedFloatingActionButtonBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ExtendedFloatingActionButton_Behavior_Layout);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = obtainStyledAttributes.getBoolean(R$styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, false);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = obtainStyledAttributes.getBoolean(R$styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, true);
            obtainStyledAttributes.recycle();
        }

        public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                return ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior() instanceof BottomSheetBehavior;
            }
            return false;
        }

        public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull View view, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            AbstractC2119fp abstractC2119fp;
            AbstractC2119fp abstractC2119fp2;
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view, extendedFloatingActionButton)) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) extendedFloatingActionButton.getLayoutParams())).topMargin) {
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    abstractC2119fp2 = extendedFloatingActionButton.Wwwwwwww;
                } else {
                    abstractC2119fp2 = extendedFloatingActionButton.Wwwww;
                }
                ExtendedFloatingActionButton.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(extendedFloatingActionButton, abstractC2119fp2);
                return true;
            }
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                abstractC2119fp = extendedFloatingActionButton.Wwwwwww;
            } else {
                abstractC2119fp = extendedFloatingActionButton.Wwwwww;
            }
            ExtendedFloatingActionButton.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(extendedFloatingActionButton, abstractC2119fp);
            return true;
        }

        public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull View view, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            return (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && ((CoordinatorLayout.LayoutParams) extendedFloatingActionButton.getLayoutParams()).getAnchorId() == view.getId();
        }

        public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            AbstractC2119fp abstractC2119fp;
            AbstractC2119fp abstractC2119fp2;
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Rect();
            }
            Rect rect = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            C2193hp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    abstractC2119fp2 = extendedFloatingActionButton.Wwwwwwww;
                } else {
                    abstractC2119fp2 = extendedFloatingActionButton.Wwwww;
                }
                ExtendedFloatingActionButton.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(extendedFloatingActionButton, abstractC2119fp2);
                return true;
            }
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                abstractC2119fp = extendedFloatingActionButton.Wwwwwww;
            } else {
                abstractC2119fp = extendedFloatingActionButton.Wwwwww;
            }
            ExtendedFloatingActionButton.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(extendedFloatingActionButton, abstractC2119fp);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean getInsetDodgeRect(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull Rect rect) {
            return super.getInsetDodgeRect(coordinatorLayout, (ExtendedFloatingActionButton) view, rect);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
            if (layoutParams.dodgeInsetEdges == 0) {
                layoutParams.dodgeInsetEdges = 80;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, @NonNull View view, View view2) {
            ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) view;
            if (view2 instanceof AppBarLayout) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(coordinatorLayout, (AppBarLayout) view2, extendedFloatingActionButton);
                return false;
            } else if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view2)) {
                return false;
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view2, extendedFloatingActionButton);
                return false;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i) {
            ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) view;
            List<View> dependencies = coordinatorLayout.getDependencies(extendedFloatingActionButton);
            int size = dependencies.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view2 = dependencies.get(i2);
                if (!(view2 instanceof AppBarLayout)) {
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view2) && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view2, extendedFloatingActionButton)) {
                        break;
                    }
                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(coordinatorLayout, (AppBarLayout) view2, extendedFloatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.onLayoutChild(extendedFloatingActionButton, i);
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Property<View, Float> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        @NonNull
        public Float get(@NonNull View view) {
            return Float.valueOf(ViewCompat.getPaddingEnd(view));
        }

        @Override // android.util.Property
        public void set(@NonNull View view, @NonNull Float f) {
            View view2 = view;
            ViewCompat.setPaddingRelative(view2, ViewCompat.getPaddingStart(view2), view2.getPaddingTop(), f.intValue(), view2.getPaddingBottom());
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Property<View, Float> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        @NonNull
        public Float get(@NonNull View view) {
            return Float.valueOf(ViewCompat.getPaddingStart(view));
        }

        @Override // android.util.Property
        public void set(@NonNull View view, @NonNull Float f) {
            View view2 = view;
            ViewCompat.setPaddingRelative(view2, f.intValue(), view2.getPaddingTop(), ViewCompat.getPaddingEnd(view2), view2.getPaddingBottom());
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Property<View, Float> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        @NonNull
        public Float get(@NonNull View view) {
            return Float.valueOf(view.getLayoutParams().height);
        }

        @Override // android.util.Property
        public void set(@NonNull View view, @NonNull Float f) {
            View view2 = view;
            view2.getLayoutParams().height = f.intValue();
            view2.requestLayout();
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Property<View, Float> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        @NonNull
        public Float get(@NonNull View view) {
            return Float.valueOf(view.getLayoutParams().width);
        }

        @Override // android.util.Property
        public void set(@NonNull View view, @NonNull Float f) {
            View view2 = view;
            view2.getLayoutParams().width = f.intValue();
            view2.requestLayout();
        }
    }

    static {
        new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Float.class, "width");
        new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Float.class, "height");
        new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Float.class, "paddingStart");
        new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Float.class, "paddingEnd");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
        if (r4.Www != false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0025, code lost:
        if (r4.isInEditMode() == false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ExtendedFloatingActionButton extendedFloatingActionButton, AbstractC2119fp abstractC2119fp) {
        if (extendedFloatingActionButton != null) {
            if (abstractC2119fp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                return;
            }
            boolean z = true;
            if (!ViewCompat.isLaidOut(extendedFloatingActionButton)) {
                if (!(extendedFloatingActionButton.getVisibility() == 0)) {
                }
                z = false;
                if (!z) {
                    abstractC2119fp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    abstractC2119fp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
                    return;
                }
                extendedFloatingActionButton.measure(0, 0);
                AnimatorSet Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = abstractC2119fp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.addListener(new C2794xo(extendedFloatingActionButton, abstractC2119fp));
                for (Animator.AnimatorListener animatorListener : abstractC2119fp.getListeners()) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.addListener(animatorListener);
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.start();
            }
        } else {
            throw null;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    /* renamed from: getBehavior */
    public CoordinatorLayout.Behavior<ExtendedFloatingActionButton> mo4457getBehavior() {
        return null;
    }

    public int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    @VisibleForTesting
    public int getCollapsedSize() {
        return 0;
    }

    @Nullable
    public C2449om getExtendMotionSpec() {
        throw null;
    }

    @Nullable
    public C2449om getHideMotionSpec() {
        throw null;
    }

    @Nullable
    public C2449om getShowMotionSpec() {
        throw null;
    }

    @Nullable
    public C2449om getShrinkMotionSpec() {
        throw null;
    }

    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.Wwww || !TextUtils.isEmpty(getText()) || getIcon() == null) {
            return;
        }
        this.Wwww = false;
        throw null;
    }

    public void setAnimateShowBeforeLayout(boolean z) {
        this.Www = z;
    }

    public void setExtendMotionSpec(@Nullable C2449om c2449om) {
        throw null;
    }

    public void setExtendMotionSpecResource(@AnimatorRes int i) {
        setExtendMotionSpec(C2449om.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext(), i));
    }

    public void setExtended(boolean z) {
        if (this.Wwww == z) {
            return;
        }
        AbstractC2119fp abstractC2119fp = null;
        if (abstractC2119fp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return;
        }
        abstractC2119fp.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public void setHideMotionSpec(@Nullable C2449om c2449om) {
        throw null;
    }

    public void setHideMotionSpecResource(@AnimatorRes int i) {
        setHideMotionSpec(C2449om.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext(), i));
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        if (this.Wwww) {
            ViewCompat.getPaddingStart(this);
            ViewCompat.getPaddingEnd(this);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setPaddingRelative(int i, int i2, int i3, int i4) {
        super.setPaddingRelative(i, i2, i3, i4);
        boolean z = this.Wwww;
    }

    public void setShowMotionSpec(@Nullable C2449om c2449om) {
        throw null;
    }

    public void setShowMotionSpecResource(@AnimatorRes int i) {
        setShowMotionSpec(C2449om.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext(), i));
    }

    public void setShrinkMotionSpec(@Nullable C2449om c2449om) {
        throw null;
    }

    public void setShrinkMotionSpecResource(@AnimatorRes int i) {
        setShrinkMotionSpec(C2449om.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext(), i));
    }

    @Override // android.widget.TextView
    public void setTextColor(int i) {
        super.setTextColor(i);
        getTextColors();
    }

    @Override // android.widget.TextView
    public void setTextColor(@NonNull ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        getTextColors();
    }
}
