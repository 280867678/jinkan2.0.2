package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ViewDragHelper;
import me.tvspark.C2080en;
import me.tvspark.C2084er;
import me.tvspark.C2195hr;

/* loaded from: classes3.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public ViewDragHelper Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0.0f;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 2;
    public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0.5f;
    public float Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 0.0f;
    public float Wwwwwwwwwwwwwwwwwwwwwwwwwww = 0.5f;
    public final ViewDragHelper.Callback Wwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
        public final boolean Wwwwwwwwwwwwwwwwwwwwwww;
        public final View Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(View view, boolean z) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = view;
            this.Wwwwwwwwwwwwwwwwwwwwwww = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            ViewDragHelper viewDragHelper = SwipeDismissBehavior.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
                ViewCompat.postOnAnimation(this.Wwwwwwwwwwwwwwwwwwwwwwww, this);
            } else if (!this.Wwwwwwwwwwwwwwwwwwwwwww || (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = SwipeDismissBehavior.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) == null) {
            } else {
                ((C2084er) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends ViewDragHelper.Callback {
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x001c, code lost:
            r5 = r2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            r3 = r3.getWidth() + r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0026, code lost:
            if (r5 != false) goto L11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:6:0x0010, code lost:
            if (r5 != false) goto L7;
         */
        /* JADX WARN: Code restructure failed: missing block: B:7:0x0012, code lost:
            r5 = r2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - r3.getWidth();
            r3 = r2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
         */
        @Override // androidx.customview.widget.ViewDragHelper.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int clampViewPositionHorizontal(@NonNull View view, int i, int i2) {
            int width;
            int width2;
            boolean z = ViewCompat.getLayoutDirection(view) == 1;
            int i3 = SwipeDismissBehavior.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i3 != 0) {
                if (i3 != 1) {
                    width = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - view.getWidth();
                    width2 = view.getWidth() + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
            }
            return Math.min(Math.max(width, i), width2);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(@NonNull View view, int i, int i2) {
            return view.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(@NonNull View view) {
            return view.getWidth();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewCaptured(@NonNull View view, int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = SwipeDismissBehavior.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                C2084er c2084er = (C2084er) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (c2084er == null) {
                    throw null;
                }
                if (i == 0) {
                    C2195hr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwww(c2084er.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww);
                } else if (i != 1 && i != 2) {
                } else {
                    C2195hr.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2084er.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww);
                }
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(@NonNull View view, int i, int i2, int i3, int i4) {
            float width = (view.getWidth() * SwipeDismissBehavior.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            float width2 = (view.getWidth() * SwipeDismissBehavior.this.Wwwwwwwwwwwwwwwwwwwwwwwwwww) + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            float f = i;
            if (f <= width) {
                view.setAlpha(1.0f);
            } else if (f >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0.0f, 1.0f - ((f - width) / (width2 - width)), 1.0f));
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:41:0x0054, code lost:
            if (java.lang.Math.abs(r8.getLeft() - r7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) >= java.lang.Math.round(r8.getWidth() * r7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww)) goto L38;
         */
        @Override // androidx.customview.widget.ViewDragHelper.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onViewReleased(@NonNull View view, float f, float f2) {
            boolean z;
            int i;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
            int width = view.getWidth();
            boolean z2 = false;
            int i2 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
            if (i2 != 0) {
                boolean z3 = ViewCompat.getLayoutDirection(view) == 1;
                int i3 = SwipeDismissBehavior.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (i3 != 2) {
                    z = i3 == 0 ? false : false;
                }
                z = true;
            }
            if (z) {
                int left = view.getLeft();
                int i4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                i = left < i4 ? i4 - width : i4 + width;
                z2 = true;
            } else {
                i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            if (SwipeDismissBehavior.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.settleCapturedViewAt(i, view.getTop())) {
                ViewCompat.postOnAnimation(view, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view, z2));
            } else if (!z2 || (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = SwipeDismissBehavior.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) == null) {
            } else {
                ((C2084er) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i) {
            int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            return (i2 == -1 || i2 == i) && SwipeDismissBehavior.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view);
        }
    }

    public static float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f, float f2, float f3) {
        return Math.min(Math.max(f, f2), f3);
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull View view) {
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull MotionEvent motionEvent) {
        boolean z = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            z = coordinatorLayout.isPointInChildBounds(v, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        }
        if (z) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ViewDragHelper.create(coordinatorLayout, this.Wwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.shouldInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i) {
        boolean onLayoutChild = super.onLayoutChild(coordinatorLayout, v, i);
        if (ViewCompat.getImportantForAccessibility(v) == 0) {
            ViewCompat.setImportantForAccessibility(v, 1);
            ViewCompat.removeAccessibilityAction(v, 1048576);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(v)) {
                ViewCompat.replaceAccessibilityAction(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, null, new C2080en(this));
            }
        }
        return onLayoutChild;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (viewDragHelper != null) {
            viewDragHelper.processTouchEvent(motionEvent);
            return true;
        }
        return false;
    }
}
