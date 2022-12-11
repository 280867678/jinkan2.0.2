package me.tvspark;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.appbar.AppBarLayout;
import java.lang.ref.WeakReference;

/* renamed from: me.tvspark.xm */
/* loaded from: classes4.dex */
public abstract class AbstractC2792xm<V extends View> extends C2866zm<V> {
    @Nullable
    public VelocityTracker Wwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public OverScroller Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public Runnable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwww = -1;

    /* renamed from: me.tvspark.xm$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
        public final V Wwwwwwwwwwwwwwwwwwwwwww;
        public final CoordinatorLayout Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CoordinatorLayout coordinatorLayout, V v) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = coordinatorLayout;
            this.Wwwwwwwwwwwwwwwwwwwwwww = v;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.Wwwwwwwwwwwwwwwwwwwwwww == null || (overScroller = AbstractC2792xm.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) == null) {
                return;
            }
            if (overScroller.computeScrollOffset()) {
                AbstractC2792xm abstractC2792xm = AbstractC2792xm.this;
                abstractC2792xm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww, abstractC2792xm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getCurrY());
                ViewCompat.postOnAnimation(this.Wwwwwwwwwwwwwwwwwwwwwww, this);
                return;
            }
            AbstractC2792xm abstractC2792xm2 = AbstractC2792xm.this;
            CoordinatorLayout coordinatorLayout = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            V v = this.Wwwwwwwwwwwwwwwwwwwwwww;
            AppBarLayout.BaseBehavior baseBehavior = (AppBarLayout.BaseBehavior) abstractC2792xm2;
            if (baseBehavior != null) {
                AppBarLayout appBarLayout = (AppBarLayout) v;
                baseBehavior.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(coordinatorLayout, (CoordinatorLayout) appBarLayout);
                if (!appBarLayout.Wwwwwwwwwwwwww) {
                    return;
                }
                appBarLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(appBarLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseBehavior.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(coordinatorLayout)));
                return;
            }
            throw null;
        }
    }

    public AbstractC2792xm() {
    }

    public AbstractC2792xm(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public abstract int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CoordinatorLayout coordinatorLayout, V v, int i) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(coordinatorLayout, v, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public abstract int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3);

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(coordinatorLayout, v, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() - i, i2, i3);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull MotionEvent motionEvent) {
        View view;
        int findPointerIndex;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwww < 0) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i == -1 || (findPointerIndex = motionEvent.findPointerIndex(i)) == -1) {
                return false;
            }
            int y = (int) motionEvent.getY(findPointerIndex);
            if (Math.abs(y - this.Wwwwwwwwwwwwwwwwwwwwwwwwwww) > this.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = y;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
            int x = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            AppBarLayout appBarLayout = (AppBarLayout) v;
            WeakReference<View> weakReference = ((AppBarLayout.BaseBehavior) this).Wwwwwwwwwwwwwwwwww;
            boolean z = (weakReference == null || ((view = weakReference.get()) != null && view.isShown() && !view.canScrollVertically(-1))) && coordinatorLayout.isPointInChildBounds(v, x, y2);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
            if (z) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = y2;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = motionEvent.getPointerId(0);
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwww == null) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwww = VelocityTracker.obtain();
                }
                OverScroller overScroller = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ee A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00de  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull MotionEvent motionEvent) {
        boolean z;
        VelocityTracker velocityTracker;
        VelocityTracker velocityTracker2;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                int findPointerIndex = motionEvent.findPointerIndex(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
                if (findPointerIndex == -1) {
                    return false;
                }
                int y = (int) motionEvent.getY(findPointerIndex);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = y;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(coordinatorLayout, v, this.Wwwwwwwwwwwwwwwwwwwwwwwwwww - y, -((AppBarLayout) v).getDownNestedScrollRange(), 0);
            } else if (actionMasked != 3) {
                if (actionMasked == 6) {
                    int i = motionEvent.getActionIndex() == 0 ? 1 : 0;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = motionEvent.getPointerId(i);
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = (int) (motionEvent.getY(i) + 0.5f);
                }
            }
            z = false;
            velocityTracker2 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
            if (velocityTracker2 != null) {
                velocityTracker2.addMovement(motionEvent);
            }
            return !this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww || z;
        }
        VelocityTracker velocityTracker3 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
        if (velocityTracker3 != null) {
            velocityTracker3.addMovement(motionEvent);
            this.Wwwwwwwwwwwwwwwwwwwwwwwww.computeCurrentVelocity(1000);
            float yVelocity = this.Wwwwwwwwwwwwwwwwwwwwwwwww.getYVelocity(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
            AppBarLayout appBarLayout = (AppBarLayout) v;
            int i2 = -appBarLayout.getTotalScrollRange();
            Runnable runnable = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (runnable != null) {
                v.removeCallbacks(runnable);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            }
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new OverScroller(v.getContext());
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.fling(0, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), 0, Math.round(yVelocity), 0, 0, i2, 0);
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.computeScrollOffset()) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(coordinatorLayout, v);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                ViewCompat.postOnAnimation(v, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            } else {
                AppBarLayout.BaseBehavior baseBehavior = (AppBarLayout.BaseBehavior) this;
                baseBehavior.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(coordinatorLayout, (CoordinatorLayout) appBarLayout);
                if (appBarLayout.Wwwwwwwwwwwwww) {
                    appBarLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(appBarLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseBehavior.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(coordinatorLayout)));
                }
            }
            z = true;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
            velocityTracker = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.Wwwwwwwwwwwwwwwwwwwwwwwww = null;
            }
            velocityTracker2 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
            if (velocityTracker2 != null) {
            }
            if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                return true;
            }
        }
        z = false;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
        velocityTracker = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
        if (velocityTracker != null) {
        }
        velocityTracker2 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
        if (velocityTracker2 != null) {
        }
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }
    }
}
