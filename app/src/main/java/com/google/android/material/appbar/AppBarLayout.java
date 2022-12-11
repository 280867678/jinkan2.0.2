package com.google.android.material.appbar;

import android.animation.AnimatorInflater;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$integer;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.AbstractC2792xm;
import me.tvspark.AbstractC2829ym;
import me.tvspark.C1915an;
import me.tvspark.C1952bn;
import me.tvspark.C1957bs;
import me.tvspark.C2227im;
import me.tvspark.C2415np;
import me.tvspark.C2603sm;
import me.tvspark.C2605so;
import me.tvspark.C2640tm;
import me.tvspark.C2677um;
import me.tvspark.C2718vm;
import me.tvspark.Illllllllllllllllllllllllllll;

/* loaded from: classes3.dex */
public class AppBarLayout extends LinearLayout implements CoordinatorLayout.AttachedBehavior {
    public static final int Wwwwwwww = R$style.Widget_Design_AppBarLayout;
    @Nullable
    public Drawable Wwwwwwwww;
    public int[] Wwwwwwwwww;
    @Nullable
    public ValueAnimator Wwwwwwwwwww;
    @Nullable
    public WeakReference<View> Wwwwwwwwwwww;
    @IdRes
    public int Wwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwww;
    public List<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwww;
    @Nullable
    public WindowInsetsCompat Wwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes3.dex */
    public static class BaseBehavior<T extends AppBarLayout> extends AbstractC2792xm<T> {
        @Nullable
        public WeakReference<View> Wwwwwwwwwwwwwwwwww;
        public float Wwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwww = -1;
        public ValueAnimator Wwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwww;

        /* loaded from: classes3.dex */
        public static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            public boolean Wwwwwwwwwwwwwwwwwwwwww;
            public float Wwwwwwwwwwwwwwwwwwwwwww;
            public int Wwwwwwwwwwwwwwwwwwwwwwww;

            /* loaded from: classes3.dex */
            public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable.ClassLoaderCreator<SavedState> {
                @Override // android.os.Parcelable.Creator
                @Nullable
                public Object createFromParcel(@NonNull Parcel parcel) {
                    return new SavedState(parcel, null);
                }

                @Override // android.os.Parcelable.Creator
                @NonNull
                public Object[] newArray(int i) {
                    return new SavedState[i];
                }

                @Override // android.os.Parcelable.ClassLoaderCreator
                @NonNull
                public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                    return new SavedState(parcel, classLoader);
                }
            }

            public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.Wwwwwwwwwwwwwwwwwwwwwwww = parcel.readInt();
                this.Wwwwwwwwwwwwwwwwwwwwwww = parcel.readFloat();
                this.Wwwwwwwwwwwwwwwwwwwwww = parcel.readByte() != 0;
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(@NonNull Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwwwwwww);
                parcel.writeFloat(this.Wwwwwwwwwwwwwwwwwwwwwww);
                parcel.writeByte(this.Wwwwwwwwwwwwwwwwwwwwww ? (byte) 1 : (byte) 0);
            }
        }

        public BaseBehavior() {
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
            return (i & i2) == i2;
        }

        @Override // me.tvspark.AbstractC2792xm
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() + this.Wwwwwwwwwwwwwwwwwwwwwwww;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // me.tvspark.AbstractC2792xm
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i, int i2, int i3) {
            int i4;
            int i5;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            int i6 = 0;
            boolean z = false;
            i6 = 0;
            if (i2 == 0 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < i2 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > i3) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = 0;
            } else {
                int clamp = MathUtils.clamp(i, i2, i3);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != clamp) {
                    if (appBarLayout.Wwwwwwwwwwwwwwwwwwww) {
                        int abs = Math.abs(clamp);
                        int childCount = appBarLayout.getChildCount();
                        int i7 = 0;
                        while (true) {
                            if (i7 >= childCount) {
                                break;
                            }
                            View childAt = appBarLayout.getChildAt(i7);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) childAt.getLayoutParams();
                            Interpolator interpolator = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                                i7++;
                            } else if (interpolator != null) {
                                int i8 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                if ((i8 & 1) != 0) {
                                    i5 = childAt.getHeight() + ((LinearLayout.LayoutParams) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).topMargin + ((LinearLayout.LayoutParams) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).bottomMargin + 0;
                                    if ((i8 & 2) != 0) {
                                        i5 -= ViewCompat.getMinimumHeight(childAt);
                                    }
                                } else {
                                    i5 = 0;
                                }
                                if (ViewCompat.getFitsSystemWindows(childAt)) {
                                    i5 -= appBarLayout.getTopInset();
                                }
                                if (i5 > 0) {
                                    float f = i5;
                                    i4 = (childAt.getTop() + Math.round(interpolator.getInterpolation((abs - childAt.getTop()) / f) * f)) * Integer.signum(clamp);
                                }
                            }
                        }
                    }
                    i4 = clamp;
                    C1915an c1915an = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (c1915an != null) {
                        z = c1915an.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4);
                    } else {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i4;
                    }
                    int i9 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - clamp;
                    this.Wwwwwwwwwwwwwwwwwwwwwwww = clamp - i4;
                    if (!z && appBarLayout.Wwwwwwwwwwwwwwwwwwww) {
                        coordinatorLayout.dispatchDependentViewsChanged(appBarLayout);
                    }
                    appBarLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(coordinatorLayout, (CoordinatorLayout) appBarLayout, clamp, clamp < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ? -1 : 1, false);
                    i6 = i9;
                }
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(coordinatorLayout, appBarLayout);
            return i6;
        }

        @Nullable
        public final View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if ((childAt instanceof NestedScrollingChild) || (childAt instanceof ListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CoordinatorLayout coordinatorLayout, @NonNull T t, int i, float f) {
            int abs = Math.abs(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() - i);
            float abs2 = Math.abs(f);
            int round = abs2 > 0.0f ? Math.round((abs / abs2) * 1000.0f) * 3 : (int) (((abs / t.getHeight()) + 1.0f) * 150.0f);
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == i) {
                ValueAnimator valueAnimator = this.Wwwwwwwwwwwwwwwwwwwwww;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.Wwwwwwwwwwwwwwwwwwwwww.cancel();
                return;
            }
            ValueAnimator valueAnimator2 = this.Wwwwwwwwwwwwwwwwwwwwww;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.Wwwwwwwwwwwwwwwwwwwwww = valueAnimator3;
                valueAnimator3.setInterpolator(C2227im.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwwwwwww.addUpdateListener(new C2640tm(this, coordinatorLayout, t));
            } else {
                valueAnimator2.cancel();
            }
            this.Wwwwwwwwwwwwwwwwwwwwww.setDuration(Math.min(round, 600));
            this.Wwwwwwwwwwwwwwwwwwwwww.setIntValues(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i);
            this.Wwwwwwwwwwwwwwwwwwwwww.start();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // me.tvspark.C2866zm, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            super.onLayoutChild(coordinatorLayout, appBarLayout, i);
            int pendingAction = appBarLayout.getPendingAction();
            int i2 = this.Wwwwwwwwwwwwwwwwwwwww;
            if (i2 >= 0 && (pendingAction & 8) == 0) {
                View childAt = appBarLayout.getChildAt(i2);
                int i3 = -childAt.getBottom();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(coordinatorLayout, appBarLayout, this.Wwwwwwwwwwwwwwwwwwww ? appBarLayout.getTopInset() + ViewCompat.getMinimumHeight(childAt) + i3 : Math.round(childAt.getHeight() * this.Wwwwwwwwwwwwwwwwwww) + i3);
            } else if (pendingAction != 0) {
                boolean z = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    int i4 = -appBarLayout.getUpNestedPreScrollRange();
                    if (z) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(coordinatorLayout, appBarLayout, i4, 0.0f);
                    } else {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(coordinatorLayout, appBarLayout, i4);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(coordinatorLayout, appBarLayout, 0, 0.0f);
                    } else {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(coordinatorLayout, appBarLayout, 0);
                    }
                }
            }
            appBarLayout.Wwwwwwwwwwwwwwwwwww = 0;
            this.Wwwwwwwwwwwwwwwwwwwww = -1;
            int clamp = MathUtils.clamp(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), -appBarLayout.getTotalScrollRange(), 0);
            C1915an c1915an = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (c1915an != null) {
                c1915an.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(clamp);
            } else {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = clamp;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(coordinatorLayout, (CoordinatorLayout) appBarLayout, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), 0, true);
            appBarLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(coordinatorLayout, appBarLayout);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i, int i2, int i3, int i4) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams())).height == -2) {
                coordinatorLayout.onMeasureChild(appBarLayout, i, i2, View.MeasureSpec.makeMeasureSpec(0, 0), i4);
                return true;
            }
            return super.onMeasureChild(coordinatorLayout, appBarLayout, i, i2, i3, i4);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout coordinatorLayout, @NonNull View view, View view2, int i, int i2, int[] iArr, int i3) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(coordinatorLayout, (AppBarLayout) view, view2, i2, iArr);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull View view, View view2, int i, int i2, int i3, int i4, int i5, int[] iArr) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (i4 < 0) {
                iArr[1] = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(coordinatorLayout, (CoordinatorLayout) appBarLayout, i4, -appBarLayout.getDownNestedScrollRange(), 0);
            }
            if (i4 == 0) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(coordinatorLayout, appBarLayout);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, Parcelable parcelable) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (!(parcelable instanceof SavedState)) {
                super.onRestoreInstanceState(coordinatorLayout, appBarLayout, parcelable);
                this.Wwwwwwwwwwwwwwwwwwwww = -1;
                return;
            }
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(coordinatorLayout, appBarLayout, savedState.getSuperState());
            this.Wwwwwwwwwwwwwwwwwwwww = savedState.Wwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwww = savedState.Wwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwww = savedState.Wwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            Parcelable onSaveInstanceState = super.onSaveInstanceState(coordinatorLayout, appBarLayout);
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            int childCount = appBarLayout.getChildCount();
            boolean z = false;
            for (int i = 0; i < childCount; i++) {
                View childAt = appBarLayout.getChildAt(i);
                int bottom = childAt.getBottom() + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (childAt.getTop() + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww <= 0 && bottom >= 0) {
                    SavedState savedState = new SavedState(onSaveInstanceState);
                    savedState.Wwwwwwwwwwwwwwwwwwwwwwww = i;
                    if (bottom == appBarLayout.getTopInset() + ViewCompat.getMinimumHeight(childAt)) {
                        z = true;
                    }
                    savedState.Wwwwwwwwwwwwwwwwwwwwww = z;
                    savedState.Wwwwwwwwwwwwwwwwwwwwwww = bottom / childAt.getHeight();
                    return savedState;
                }
            }
            return onSaveInstanceState;
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0029, code lost:
            if (((r3.getTotalScrollRange() != 0) && r2.getHeight() - r4.getHeight() <= r3.getHeight()) != false) goto L15;
         */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2, View view3, int i, int i2) {
            ValueAnimator valueAnimator;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            int i3 = i & 2;
            boolean z = false;
            if (i3 != 0) {
                if (!appBarLayout.Wwwwwwwwwwwwww) {
                }
                z = true;
            }
            if (z && (valueAnimator = this.Wwwwwwwwwwwwwwwwwwwwww) != null) {
                valueAnimator.cancel();
            }
            this.Wwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwww = i2;
            return z;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull View view, View view2, int i) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (this.Wwwwwwwwwwwwwwwwwwwwwww == 0 || i == 1) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(coordinatorLayout, (CoordinatorLayout) appBarLayout);
                if (appBarLayout.Wwwwwwwwwwwwww) {
                    appBarLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(appBarLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view2));
                }
            }
            this.Wwwwwwwwwwwwwwwwww = new WeakReference<>(view2);
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i, int[] iArr) {
            int i2;
            int i3;
            if (i != 0) {
                if (i < 0) {
                    int i4 = -appBarLayout.getTotalScrollRange();
                    i2 = i4;
                    i3 = appBarLayout.getDownNestedPreScrollRange() + i4;
                } else {
                    i2 = -appBarLayout.getUpNestedPreScrollRange();
                    i3 = 0;
                }
                if (i2 != i3) {
                    iArr[1] = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(coordinatorLayout, (CoordinatorLayout) appBarLayout, i, i2, i3);
                }
            }
            if (appBarLayout.Wwwwwwwwwwwwww) {
                appBarLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(appBarLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view));
            }
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CoordinatorLayout coordinatorLayout, @NonNull T t) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            int childCount = t.getChildCount();
            int i = 0;
            while (true) {
                if (i >= childCount) {
                    i = -1;
                    break;
                }
                View childAt = t.getChildAt(i);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) childAt.getLayoutParams();
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 32)) {
                    top -= ((LinearLayout.LayoutParams) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).topMargin;
                    bottom += ((LinearLayout.LayoutParams) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).bottomMargin;
                }
                int i2 = -Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (top <= i2 && bottom >= i2) {
                    break;
                }
                i++;
            }
            if (i >= 0) {
                View childAt2 = t.getChildAt(i);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) childAt2.getLayoutParams();
                int i3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if ((i3 & 17) != 17) {
                    return;
                }
                int i4 = -childAt2.getTop();
                int i5 = -childAt2.getBottom();
                if (i == t.getChildCount() - 1) {
                    i5 += t.getTopInset();
                }
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3, 2)) {
                    i5 += ViewCompat.getMinimumHeight(childAt2);
                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3, 5)) {
                    int minimumHeight = ViewCompat.getMinimumHeight(childAt2) + i5;
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < minimumHeight) {
                        i4 = minimumHeight;
                    } else {
                        i5 = minimumHeight;
                    }
                }
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3, 32)) {
                    i4 += ((LinearLayout.LayoutParams) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2).topMargin;
                    i5 -= ((LinearLayout.LayoutParams) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2).bottomMargin;
                }
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < (i5 + i4) / 2) {
                    i4 = i5;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(coordinatorLayout, t, MathUtils.clamp(i4, -t.getTotalScrollRange(), 0), 0.0f);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0061  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x006f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t, int i, int i2, boolean z) {
            View view;
            boolean z2;
            int abs = Math.abs(i);
            int childCount = t.getChildCount();
            boolean z3 = false;
            int i3 = 0;
            while (true) {
                if (i3 >= childCount) {
                    view = null;
                    break;
                }
                view = t.getChildAt(i3);
                if (abs >= view.getTop() && abs <= view.getBottom()) {
                    break;
                }
                i3++;
            }
            if (view != null) {
                int i4 = ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) view.getLayoutParams()).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if ((i4 & 1) != 0) {
                    int minimumHeight = ViewCompat.getMinimumHeight(view);
                    if (i2 <= 0 || (i4 & 12) == 0 ? !((i4 & 2) == 0 || (-i) < (view.getBottom() - minimumHeight) - t.getTopInset()) : (-i) >= (view.getBottom() - minimumHeight) - t.getTopInset()) {
                        z2 = true;
                        if (t.Wwwwwwwwwwwwww) {
                            z2 = t.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(coordinatorLayout));
                        }
                        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = t.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z2);
                        if (!z) {
                            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                                return;
                            }
                            List<View> dependents = coordinatorLayout.getDependents(t);
                            int size = dependents.size();
                            int i5 = 0;
                            while (true) {
                                if (i5 >= size) {
                                    break;
                                }
                                CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) dependents.get(i5).getLayoutParams()).getBehavior();
                                if (!(behavior instanceof ScrollingViewBehavior)) {
                                    i5++;
                                } else if (((ScrollingViewBehavior) behavior).Wwwwwwwwwwwwwwwwwwwwwwwwwwww != 0) {
                                    z3 = true;
                                }
                            }
                            if (!z3) {
                                return;
                            }
                        }
                        t.jumpDrawablesToCurrentState();
                    }
                }
                z2 = false;
                if (t.Wwwwwwwwwwwwww) {
                }
                boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = t.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z2);
                if (!z) {
                }
                t.jumpDrawablesToCurrentState();
            }
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CoordinatorLayout coordinatorLayout, @NonNull T t) {
            ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
            ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
            View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(coordinatorLayout);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null || t.getTotalScrollRange() == 0 || !(((CoordinatorLayout.LayoutParams) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getLayoutParams()).getBehavior() instanceof ScrollingViewBehavior)) {
                return;
            }
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != (-t.getTotalScrollRange()) && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.canScrollVertically(1)) {
                ViewCompat.replaceAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD, null, new C2718vm(this, t, false));
            }
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == 0) {
                return;
            }
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.canScrollVertically(-1)) {
                ViewCompat.replaceAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, null, new C2718vm(this, t, true));
                return;
            }
            int i = -t.getDownNestedPreScrollRange();
            if (i == 0) {
                return;
            }
            ViewCompat.replaceAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, null, new C2677um(this, coordinatorLayout, t, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i));
        }
    }

    /* loaded from: classes3.dex */
    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* loaded from: classes3.dex */
    public static class ScrollingViewBehavior extends AbstractC2829ym {
        public ScrollingViewBehavior() {
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ScrollingViewBehavior_Layout);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0);
            obtainStyledAttributes.recycle();
        }

        @Nullable
        public AppBarLayout Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull List<View> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = list.get(i);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onDependentViewChanged(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) view2.getLayoutParams()).getBehavior();
            if (behavior instanceof BaseBehavior) {
                ViewCompat.offsetTopAndBottom(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) behavior).Wwwwwwwwwwwwwwwwwwwwwwww) + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view2));
            }
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (!appBarLayout.Wwwwwwwwwwwwww) {
                    return false;
                }
                appBarLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(appBarLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view));
                return false;
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onDependentViewRemoved(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
            if (view2 instanceof AppBarLayout) {
                ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
                ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onRequestChildRectangleOnScreen(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull Rect rect, boolean z) {
            AppBarLayout Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(coordinatorLayout.getDependencies(view));
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, !z, true);
                    return true;
                }
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<AppBarLayout> {
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends LinearLayout.LayoutParams {
        public Interpolator Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
            super(i, i2);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.AppBarLayout_Layout);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = obtainStyledAttributes.getInt(R$styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            if (obtainStyledAttributes.hasValue(R$styleable.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(R$styleable.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
        }

        @RequiresApi(19)
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
        }
    }

    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T extends AppBarLayout> {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T t, int i);
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements OnApplyWindowInsetsListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            AppBarLayout appBarLayout = AppBarLayout.this;
            WindowInsetsCompat windowInsetsCompat2 = null;
            if (appBarLayout != null) {
                if (ViewCompat.getFitsSystemWindows(appBarLayout)) {
                    windowInsetsCompat2 = windowInsetsCompat;
                }
                if (!ObjectsCompat.equals(appBarLayout.Wwwwwwwwwwwwwwwwww, windowInsetsCompat2)) {
                    appBarLayout.Wwwwwwwwwwwwwwwwww = windowInsetsCompat2;
                    appBarLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    appBarLayout.requestLayout();
                }
                return windowInsetsCompat;
            }
            throw null;
        }
    }

    public AppBarLayout(@NonNull Context context) {
        this(context, null);
    }

    public AppBarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.appBarLayoutStyle);
    }

    /* JADX WARN: Finally extract failed */
    public AppBarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(C1957bs.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, attributeSet, i, Wwwwwwww), attributeSet, i);
        this.Wwwwwwwwwwwwwwwwwwwwwww = -1;
        this.Wwwwwwwwwwwwwwwwwwwwww = -1;
        this.Wwwwwwwwwwwwwwwwwwwww = -1;
        this.Wwwwwwwwwwwwwwwwwww = 0;
        Context context2 = getContext();
        setOrientation(1);
        setOutlineProvider(ViewOutlineProvider.BOUNDS);
        int i2 = Wwwwwwww;
        Context context3 = getContext();
        TypedArray Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2415np.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context3, attributeSet, C1952bn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i, i2, new int[0]);
        try {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.hasValue(0)) {
                setStateListAnimator(AnimatorInflater.loadStateListAnimator(context3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getResourceId(0, 0)));
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.recycle();
            TypedArray Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = C2415np.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context2, attributeSet, R$styleable.AppBarLayout, i, Wwwwwwww, new int[0]);
            ViewCompat.setBackground(this, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.getDrawable(R$styleable.AppBarLayout_android_background));
            if (getBackground() instanceof ColorDrawable) {
                MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
                materialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ColorStateList.valueOf(((ColorDrawable) getBackground()).getColor()));
                materialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2605so(context2);
                materialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwww();
                ViewCompat.setBackground(this, materialShapeDrawable);
            }
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.hasValue(R$styleable.AppBarLayout_expanded)) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.getBoolean(R$styleable.AppBarLayout_expanded, false), false, false);
            }
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.hasValue(R$styleable.AppBarLayout_elevation)) {
                C1952bn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.getDimensionPixelSize(R$styleable.AppBarLayout_elevation, 0));
            }
            if (Build.VERSION.SDK_INT >= 26) {
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.hasValue(R$styleable.AppBarLayout_android_keyboardNavigationCluster)) {
                    setKeyboardNavigationCluster(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.getBoolean(R$styleable.AppBarLayout_android_keyboardNavigationCluster, false));
                }
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.hasValue(R$styleable.AppBarLayout_android_touchscreenBlocksFocus)) {
                    setTouchscreenBlocksFocus(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.getBoolean(R$styleable.AppBarLayout_android_touchscreenBlocksFocus, false));
                }
            }
            this.Wwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.getBoolean(R$styleable.AppBarLayout_liftOnScroll, false);
            this.Wwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.getResourceId(R$styleable.AppBarLayout_liftOnScrollTargetViewId, -1);
            setStatusBarForeground(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.getDrawable(R$styleable.AppBarLayout_statusBarForeground));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.recycle();
            ViewCompat.setOnApplyWindowInsetsListener(this, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        } catch (Throwable th) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.recycle();
            throw th;
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        setWillNotDraw(!(this.Wwwwwwwww != null && getTopInset() > 0));
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = i;
        if (!willNotDraw()) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        List<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> list = this.Wwwwwwwwwwwwwwwww;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwww.get(i2);
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, i);
                }
            }
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        if (this.Wwwwwwwwwwwwwwwww == null) {
            this.Wwwwwwwwwwwwwwwww = new ArrayList();
        }
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null || this.Wwwwwwwwwwwwwwwww.contains(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
            return;
        }
        this.Wwwwwwwwwwwwwwwww.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, boolean z2, boolean z3) {
        int i = 0;
        int i2 = (z ? 1 : 2) | (z2 ? 4 : 0);
        if (z3) {
            i = 8;
        }
        this.Wwwwwwwwwwwwwwwwwww = i2 | i;
        requestLayout();
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            return childAt.getVisibility() != 8 && !ViewCompat.getFitsSystemWindows(childAt);
        }
        return false;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        if (this.Wwwwwwwww != null && getTopInset() > 0) {
            int save = canvas.save();
            canvas.translate(0.0f, -this.Wwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwww.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.Wwwwwwwww;
        if (drawable == null || !drawable.isStateful() || !drawable.setState(drawableState)) {
            return;
        }
        invalidateDrawable(drawable);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext(), attributeSet);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: generateLayoutParams  reason: collision with other method in class */
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww mo4453generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LinearLayout.LayoutParams ? new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((LinearLayout.LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ViewGroup.MarginLayoutParams) layoutParams) : new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(layoutParams);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    /* renamed from: getBehavior */
    public CoordinatorLayout.Behavior<AppBarLayout> mo4457getBehavior() {
        return new Behavior();
    }

    public int getDownNestedPreScrollRange() {
        int i;
        int minimumHeight;
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i4 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if ((i4 & 5) == 5) {
                int i5 = ((LinearLayout.LayoutParams) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).topMargin + ((LinearLayout.LayoutParams) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).bottomMargin;
                if ((i4 & 8) != 0) {
                    minimumHeight = ViewCompat.getMinimumHeight(childAt);
                } else if ((i4 & 2) != 0) {
                    minimumHeight = measuredHeight - ViewCompat.getMinimumHeight(childAt);
                } else {
                    i = i5 + measuredHeight;
                    if (childCount == 0 && ViewCompat.getFitsSystemWindows(childAt)) {
                        i = Math.min(i, measuredHeight - getTopInset());
                    }
                    i3 += i;
                }
                i = minimumHeight + i5;
                if (childCount == 0) {
                    i = Math.min(i, measuredHeight - getTopInset());
                }
                i3 += i;
            } else if (i3 > 0) {
                break;
            }
        }
        int max = Math.max(0, i3);
        this.Wwwwwwwwwwwwwwwwwwwwww = max;
        return max;
    }

    public int getDownNestedScrollRange() {
        int i = this.Wwwwwwwwwwwwwwwwwwwww;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            View childAt = getChildAt(i2);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) childAt.getLayoutParams();
            int measuredHeight = ((LinearLayout.LayoutParams) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).topMargin + ((LinearLayout.LayoutParams) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).bottomMargin + childAt.getMeasuredHeight();
            int i4 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if ((i4 & 1) == 0) {
                break;
            }
            i3 += measuredHeight;
            if ((i4 & 2) != 0) {
                i3 -= ViewCompat.getMinimumHeight(childAt);
                break;
            }
            i2++;
        }
        int max = Math.max(0, i3);
        this.Wwwwwwwwwwwwwwwwwwwww = max;
        return max;
    }

    @IdRes
    public int getLiftOnScrollTargetViewId() {
        return this.Wwwwwwwwwwwww;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        if (minimumHeight == 0) {
            int childCount = getChildCount();
            minimumHeight = childCount >= 1 ? ViewCompat.getMinimumHeight(getChildAt(childCount - 1)) : 0;
            if (minimumHeight == 0) {
                return getHeight() / 3;
            }
        }
        return (minimumHeight * 2) + topInset;
    }

    public int getPendingAction() {
        return this.Wwwwwwwwwwwwwwwwwww;
    }

    @Nullable
    public Drawable getStatusBarForeground() {
        return this.Wwwwwwwww;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    @VisibleForTesting
    public final int getTopInset() {
        WindowInsetsCompat windowInsetsCompat = this.Wwwwwwwwwwwwwwwwww;
        if (windowInsetsCompat != null) {
            return windowInsetsCompat.getSystemWindowInsetTop();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            View childAt = getChildAt(i2);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i4 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if ((i4 & 1) == 0) {
                break;
            }
            int i5 = measuredHeight + ((LinearLayout.LayoutParams) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).topMargin + ((LinearLayout.LayoutParams) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).bottomMargin + i3;
            if (i2 == 0 && ViewCompat.getFitsSystemWindows(childAt)) {
                i5 -= getTopInset();
            }
            i3 = i5;
            if ((i4 & 2) != 0) {
                i3 -= ViewCompat.getMinimumHeight(childAt);
                break;
            }
            i2++;
        }
        int max = Math.max(0, i3);
        this.Wwwwwwwwwwwwwwwwwwwwwww = max;
        return max;
    }

    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof MaterialShapeDrawable) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((View) this, (MaterialShapeDrawable) background);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i) {
        if (this.Wwwwwwwwww == null) {
            this.Wwwwwwwwww = new int[4];
        }
        int[] iArr = this.Wwwwwwwwww;
        int[] onCreateDrawableState = super.onCreateDrawableState(i + iArr.length);
        iArr[0] = this.Wwwwwwwwwwwwwwww ? R$attr.state_liftable : -R$attr.state_liftable;
        iArr[1] = (!this.Wwwwwwwwwwwwwwww || !this.Wwwwwwwwwwwwwww) ? -R$attr.state_lifted : R$attr.state_lifted;
        iArr[2] = this.Wwwwwwwwwwwwwwww ? R$attr.state_collapsible : -R$attr.state_collapsible;
        iArr[3] = (!this.Wwwwwwwwwwwwwwww || !this.Wwwwwwwwwwwwwww) ? -R$attr.state_collapsed : R$attr.state_collapsed;
        return LinearLayout.mergeDrawableStates(onCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        WeakReference<View> weakReference = this.Wwwwwwwwwwww;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.Wwwwwwwwwwww = null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        super.onLayout(z, i, i2, i3, i4);
        boolean z3 = true;
        if (ViewCompat.getFitsSystemWindows(this) && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                ViewCompat.offsetTopAndBottom(getChildAt(childCount), topInset);
            }
        }
        this.Wwwwwwwwwwwwwwwwwwwwwww = -1;
        this.Wwwwwwwwwwwwwwwwwwwwww = -1;
        this.Wwwwwwwwwwwwwwwwwwwww = -1;
        this.Wwwwwwwwwwwwwwwwwwww = false;
        int childCount2 = getChildCount();
        int i5 = 0;
        while (true) {
            if (i5 >= childCount2) {
                break;
            } else if (((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) getChildAt(i5).getLayoutParams()).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                this.Wwwwwwwwwwwwwwwwwwww = true;
                break;
            } else {
                i5++;
            }
        }
        Drawable drawable = this.Wwwwwwwww;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (!this.Wwwwwwwwwwwwww) {
            int childCount3 = getChildCount();
            int i6 = 0;
            while (true) {
                if (i6 >= childCount3) {
                    z2 = false;
                    break;
                }
                int i7 = ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) getChildAt(i6).getLayoutParams()).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if ((i7 & 1) == 1 && (i7 & 10) != 0) {
                    z2 = true;
                    break;
                }
                i6++;
            }
            if (!z2) {
                z3 = false;
            }
        }
        if (this.Wwwwwwwwwwwwwwww != z3) {
            this.Wwwwwwwwwwwwwwww = z3;
            refreshDrawableState();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i2);
        if (mode != 1073741824 && ViewCompat.getFitsSystemWindows(this) && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            int measuredHeight = getMeasuredHeight();
            if (mode == Integer.MIN_VALUE) {
                measuredHeight = MathUtils.clamp(getTopInset() + getMeasuredHeight(), 0, View.MeasureSpec.getSize(i2));
            } else if (mode == 0) {
                measuredHeight += getTopInset();
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        this.Wwwwwwwwwwwwwwwwwwwwwww = -1;
        this.Wwwwwwwwwwwwwwwwwwwwww = -1;
        this.Wwwwwwwwwwwwwwwwwwwww = -1;
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f) {
        super.setElevation(f);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, f);
    }

    public void setExpanded(boolean z) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z, ViewCompat.isLaidOut(this), true);
    }

    public void setLiftOnScroll(boolean z) {
        this.Wwwwwwwwwwwwww = z;
    }

    public void setLiftOnScrollTargetViewId(@IdRes int i) {
        this.Wwwwwwwwwwwww = i;
        WeakReference<View> weakReference = this.Wwwwwwwwwwww;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.Wwwwwwwwwwww = null;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        if (i == 1) {
            super.setOrientation(i);
            return;
        }
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    public void setStatusBarForeground(@Nullable Drawable drawable) {
        Drawable drawable2 = this.Wwwwwwwww;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.Wwwwwwwww = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.Wwwwwwwww.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.Wwwwwwwww, ViewCompat.getLayoutDirection(this));
                this.Wwwwwwwww.setVisible(getVisibility() == 0, false);
                this.Wwwwwwwww.setCallback(this);
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setStatusBarForegroundColor(@ColorInt int i) {
        setStatusBarForeground(new ColorDrawable(i));
    }

    public void setStatusBarForegroundResource(@DrawableRes int i) {
        setStatusBarForeground(AppCompatResources.getDrawable(getContext(), i));
    }

    @Deprecated
    public void setTargetElevation(float f) {
        C1952bn.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, f);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.Wwwwwwwww;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(@NonNull Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.Wwwwwwwww;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        if (this.Wwwwwwwwwwwwwww != z) {
            this.Wwwwwwwwwwwwwww = z;
            refreshDrawableState();
            if (this.Wwwwwwwwwwwwww && (getBackground() instanceof MaterialShapeDrawable)) {
                MaterialShapeDrawable materialShapeDrawable = (MaterialShapeDrawable) getBackground();
                float dimension = getResources().getDimension(R$dimen.design_appbar_elevation);
                float f = z ? 0.0f : dimension;
                if (!z) {
                    dimension = 0.0f;
                }
                ValueAnimator valueAnimator = this.Wwwwwwwwwww;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(f, dimension);
                this.Wwwwwwwwwww = ofFloat;
                ofFloat.setDuration(getResources().getInteger(R$integer.app_bar_elevation_anim_duration));
                this.Wwwwwwwwwww.setInterpolator(C2227im.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwww.addUpdateListener(new C2603sm(this, materialShapeDrawable));
                this.Wwwwwwwwwww.start();
            }
            return true;
        }
        return false;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: generateDefaultLayoutParams  reason: collision with other method in class */
    public LinearLayout.LayoutParams mo4451generateDefaultLayoutParams() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: generateLayoutParams  reason: collision with other method in class */
    public LinearLayout.LayoutParams mo4452generateLayoutParams(AttributeSet attributeSet) {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getContext(), attributeSet);
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable View view) {
        int i;
        View view2 = null;
        if (this.Wwwwwwwwwwww == null && (i = this.Wwwwwwwwwwwww) != -1) {
            View findViewById = view != null ? view.findViewById(i) : null;
            if (findViewById == null && (getParent() instanceof ViewGroup)) {
                findViewById = ((ViewGroup) getParent()).findViewById(this.Wwwwwwwwwwwww);
            }
            if (findViewById != null) {
                this.Wwwwwwwwwwww = new WeakReference<>(findViewById);
            }
        }
        WeakReference<View> weakReference = this.Wwwwwwwwwwww;
        if (weakReference != null) {
            view2 = weakReference.get();
        }
        if (view2 != null) {
            view = view2;
        }
        return view != null && (view.canScrollVertically(-1) || view.getScrollY() > 0);
    }
}
