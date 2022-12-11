package me.tvspark;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Deprecated
/* renamed from: me.tvspark.c1 */
/* loaded from: classes4.dex */
public abstract class AbstractC1967c1<T extends View, Z> extends AbstractC2618t0<Z> {
    public static int Wwwwwwwwwwwwwwwwwwwww = com.bumptech.glide.R$id.glide_custom_view_target_tag;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwww;
    public final T Wwwwwwwwwwwwwwwwwwwwwww;

    @VisibleForTesting
    /* renamed from: me.tvspark.c1$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        @Nullable
        @VisibleForTesting
        public static Integer Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        @Nullable
        public ViewTreeObserver$OnPreDrawListenerC3471Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final List<AbstractC1893a1> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
        public final View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        /* renamed from: me.tvspark.c1$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class ViewTreeObserver$OnPreDrawListenerC3471Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements ViewTreeObserver.OnPreDrawListener {
            public final WeakReference<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwww;

            public ViewTreeObserver$OnPreDrawListenerC3471Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = new WeakReference<>(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    String str = "OnGlobalLayoutListener called attachStateListener=" + this;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww.get();
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null || wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
                    return true;
                }
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                if (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                    return true;
                }
                Iterator it = new ArrayList(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).iterator();
                while (it.hasNext()) {
                    ((AbstractC1893a1) it.next()).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return true;
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = view;
        }

        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            int paddingRight = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getPaddingRight() + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getPaddingLeft();
            ViewGroup.LayoutParams layoutParams = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getLayoutParams();
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingRight);
        }

        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            int paddingBottom = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getPaddingBottom() + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getPaddingTop();
            ViewGroup.LayoutParams layoutParams = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getLayoutParams();
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingBottom);
        }

        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3) {
            int i4 = i2 - i3;
            if (i4 > 0) {
                return i4;
            }
            int i5 = i - i3;
            if (i5 > 0) {
                return i5;
            }
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isLayoutRequested() || i2 != -2) {
                return 0;
            }
            Log.isLoggable("ViewTarget", 4);
            Context context = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getContext();
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(windowManager, "Argument must not be null");
                Display defaultDisplay = windowManager.getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Integer.valueOf(Math.max(point.x, point.y));
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.intValue();
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            ViewTreeObserver viewTreeObserver = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
        }

        public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
            if (i > 0 || i == Integer.MIN_VALUE) {
                if (i2 > 0 || i2 == Integer.MIN_VALUE) {
                    return true;
                }
            }
            return false;
        }
    }

    public AbstractC1967c1(@NonNull T t) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t, "Argument must not be null");
        this.Wwwwwwwwwwwwwwwwwwwwwww = t;
        this.Wwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t);
    }

    @Override // me.tvspark.AbstractC1930b1
    @CallSuper
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull AbstractC1893a1 abstractC1893a1) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwww;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
            abstractC1893a1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            return;
        }
        if (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.contains(abstractC1893a1)) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(abstractC1893a1);
        }
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            return;
        }
        ViewTreeObserver viewTreeObserver = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getViewTreeObserver();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.ViewTreeObserver$OnPreDrawListenerC3471Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww viewTreeObserver$OnPreDrawListenerC3471Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.ViewTreeObserver$OnPreDrawListenerC3471Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = viewTreeObserver$OnPreDrawListenerC3471Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        viewTreeObserver.addOnPreDrawListener(viewTreeObserver$OnPreDrawListenerC3471Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.AbstractC1930b1
    @CallSuper
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull AbstractC1893a1 abstractC1893a1) {
        this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remove(abstractC1893a1);
    }

    @Override // me.tvspark.AbstractC2618t0, me.tvspark.AbstractC1930b1
    @Nullable
    public AbstractC2464p0 getRequest() {
        Object tag = this.Wwwwwwwwwwwwwwwwwwwwwww.getTag(Wwwwwwwwwwwwwwwwwwwww);
        if (tag != null) {
            if (!(tag instanceof AbstractC2464p0)) {
                throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
            }
            return (AbstractC2464p0) tag;
        }
        return null;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Target for: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Wwwwwwwwwwwwwwwwwwwwwww);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
    }

    @Override // me.tvspark.AbstractC2618t0, me.tvspark.AbstractC1930b1
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable AbstractC2464p0 abstractC2464p0) {
        this.Wwwwwwwwwwwwwwwwwwwwwww.setTag(Wwwwwwwwwwwwwwwwwwwww, abstractC2464p0);
    }
}
