package me.tvspark.widget.easytagdragview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.GridView;
import android.widget.ImageView;
import me.tvspark.R$styleable;
import me.tvspark.su0;
import me.tvspark.tu0;
import white.whale.R;

/* loaded from: classes4.dex */
public class DragDropGirdView extends GridView implements su0, tu0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    public static final String Wwww = DragDropGirdView.class.getSimpleName();
    public final AnimatorListenerAdapter Wwwww;
    public final Runnable Wwwwww;
    public tu0 Wwwwwww;
    public int Wwwwwwww;
    public int Wwwwwwwww;
    public int Wwwwwwwwww;
    public int Wwwwwwwwwww;
    public final int[] Wwwwwwwwwwww;
    public int Wwwwwwwwwwwww;
    public View Wwwwwwwwwwwwww;
    public ImageView Wwwwwwwwwwwwwww;
    public Bitmap Wwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwww;
    public Handler Wwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AnimatorListenerAdapter {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Bitmap bitmap = DragDropGirdView.this.Wwwwwwwwwwwwwwww;
            if (bitmap != null) {
                bitmap.recycle();
                DragDropGirdView.this.Wwwwwwwwwwwwwwww = null;
            }
            DragDropGirdView.this.Wwwwwwwwwwwwwww.setVisibility(8);
            DragDropGirdView.this.Wwwwwwwwwwwwwww.setImageBitmap(null);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            DragDropGirdView dragDropGirdView = DragDropGirdView.this;
            int i2 = dragDropGirdView.Wwwwwwwwwwwwwwwwwwww;
            if (i2 > dragDropGirdView.Wwwwwwwwwwwwwwwwwwwwww) {
                if (i2 >= dragDropGirdView.Wwwwwwwwwwwwwwwwwwwww) {
                    i = 25;
                }
                DragDropGirdView.this.Wwwwwwwwwwwwwwwwwww.postDelayed(this, 5L);
            }
            i = -25;
            dragDropGirdView.smoothScrollBy(i, 5);
            DragDropGirdView.this.Wwwwwwwwwwwwwwwwwww.postDelayed(this, 5L);
        }
    }

    public DragDropGirdView(Context context) {
        this(context, null);
    }

    public DragDropGirdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public DragDropGirdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Wwwwwwwwwwwwwwwwww = false;
        this.Wwwwwwwwwwww = new int[2];
        this.Wwwwwww = new tu0(this);
        this.Wwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.DragDropGirdView);
        this.Wwwwwwwwwwwwwwwwwwwwwww = obtainStyledAttributes.getBoolean(1, false);
        this.Wwwwwwwwwwwww = obtainStyledAttributes.getInteger(0, context.getResources().getInteger(R.integer.fade_duration));
        obtainStyledAttributes.recycle();
        this.Wwwwwwwwwwwwwwwwwwwwwwww = ViewConfiguration.get(context).getScaledPagingTouchSlop();
        tu0 tu0Var = this.Wwwwwww;
        if (!tu0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.contains(this)) {
            tu0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(this);
        }
    }

    public final View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (i2 >= childAt.getTop() && i2 <= childAt.getBottom() && i >= childAt.getLeft() && i <= childAt.getRight()) {
                return childAt;
            }
        }
        return null;
    }

    @Override // me.tvspark.su0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        ImageView imageView = this.Wwwwwwwwwwwwwww;
        if (imageView != null) {
            imageView.clearAnimation();
            this.Wwwwwwwwwwwwwww.animate().alpha(0.0f).setDuration(this.Wwwwwwwwwwwww).setListener(this.Wwwww).start();
        }
    }

    @Override // me.tvspark.su0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, View view) {
        ImageView imageView = this.Wwwwwwwwwwwwwww;
        if (imageView == null) {
            return;
        }
        imageView.clearAnimation();
        view.setDrawingCacheEnabled(true);
        Bitmap drawingCache = view.getDrawingCache();
        Bitmap bitmap = null;
        if (drawingCache != null) {
            try {
                bitmap = drawingCache.copy(Bitmap.Config.ARGB_8888, false);
            } catch (OutOfMemoryError unused) {
            }
        }
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);
        this.Wwwwwwwwwwwwwwww = bitmap;
        if (bitmap == null) {
            return;
        }
        view.getLocationInWindow(this.Wwwwwwwwwwww);
        int[] iArr = this.Wwwwwwwwwwww;
        int i3 = iArr[0];
        this.Wwwwwwwww = i3;
        int i4 = iArr[1];
        this.Wwwwwwww = i4;
        this.Wwwwwwwwwww = i - i3;
        this.Wwwwwwwwww = i2 - i4;
        this.Wwwwwwwwwwwwww.getLocationInWindow(iArr);
        int i5 = this.Wwwwwwwww;
        int[] iArr2 = this.Wwwwwwwwwwww;
        this.Wwwwwwwww = i5 - iArr2[0];
        this.Wwwwwwww -= iArr2[1];
        this.Wwwwwwwwwwwwwww.setImageBitmap(this.Wwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwww.setVisibility(0);
        this.Wwwwwwwwwwwwwww.setAlpha(0.7f);
        this.Wwwwwwwwwwwwwww.setX(this.Wwwwwwwww);
        this.Wwwwwwwwwwwwwww.setY(this.Wwwwwwww);
    }

    @Override // me.tvspark.tu0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        getLocationInWindow(this.Wwwwwwwwwwww);
        int[] iArr = this.Wwwwwwwwwwww;
        return Build.VERSION.SDK_INT >= 24 ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2) : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i - iArr[0], i2 - iArr[1]);
    }

    @Override // me.tvspark.su0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, View view) {
        this.Wwwwwwwwwwwwww.getLocationInWindow(this.Wwwwwwwwwwww);
        int i3 = i - this.Wwwwwwwwwww;
        int[] iArr = this.Wwwwwwwwwwww;
        int i4 = i3 - iArr[0];
        this.Wwwwwwwww = i4;
        this.Wwwwwwww = (i2 - this.Wwwwwwwwww) - iArr[1];
        ImageView imageView = this.Wwwwwwwwwwwwwww;
        if (imageView != null) {
            imageView.setX(i4);
            this.Wwwwwwwwwwwwwww.setY(this.Wwwwwwww);
        }
    }

    public tu0 getDragDropController() {
        return this.Wwwwwww;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = ViewConfiguration.get(getContext()).getScaledPagingTouchSlop();
    }

    @Override // android.view.View
    public boolean onDragEvent(DragEvent dragEvent) {
        boolean z;
        int action = dragEvent.getAction();
        int x = (int) dragEvent.getX();
        int y = (int) dragEvent.getY();
        int i = 0;
        switch (action) {
            case 1:
                if (!"FAVORITE_TILE".equals(dragEvent.getLocalState())) {
                    return false;
                }
                tu0 tu0Var = this.Wwwwwww;
                View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = tu0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(x, y);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null) {
                    z = false;
                } else {
                    for (int i2 = 0; i2 < tu0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size(); i2++) {
                        tu0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i2).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(x, y, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                    }
                    z = true;
                }
                if (!z) {
                    return false;
                }
                break;
            case 2:
                this.Wwwwwwwwwwwwwwwwwwww = y;
                tu0 tu0Var2 = this.Wwwwwww;
                getLocationInWindow(tu0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                int[] iArr = tu0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i3 = iArr[0] + x;
                int i4 = iArr[1] + y;
                if (Build.VERSION.SDK_INT >= 24) {
                    View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = tu0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(x, y);
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != null) {
                        while (i < tu0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size()) {
                            tu0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(x, y, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                            i++;
                        }
                    }
                } else {
                    View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = tu0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3, i4);
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 != null) {
                        while (i < tu0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size()) {
                            tu0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3, i4, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
                            i++;
                        }
                    }
                }
                if (!this.Wwwwwwwwwwwwwwwwww && Math.abs(this.Wwwwwwwwwwwwwwwwwwww - this.Wwwwwwwwwwwwwwwww) >= this.Wwwwwwwwwwwwwwwwwwwwwwww * 4.0f) {
                    this.Wwwwwwwwwwwwwwwwww = true;
                    if (this.Wwwwwwwwwwwwwwwwwww == null) {
                        this.Wwwwwwwwwwwwwwwwwww = getHandler();
                    }
                    this.Wwwwwwwwwwwwwwwwwww.postDelayed(this.Wwwwww, 5L);
                    break;
                }
                break;
            case 3:
            case 4:
            case 6:
                if (this.Wwwwwwwwwwwwwwwwwww == null) {
                    this.Wwwwwwwwwwwwwwwwwww = getHandler();
                }
                this.Wwwwwwwwwwwwwwwwwww.removeCallbacks(this.Wwwwww);
                this.Wwwwwwwwwwwwwwwwww = false;
                if (action == 3 || action == 4) {
                    tu0 tu0Var3 = this.Wwwwwww;
                    while (i < tu0Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size()) {
                        tu0Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(x, y);
                        i++;
                    }
                    break;
                }
                break;
            case 5:
                int height = (int) (getHeight() * 0.2f);
                this.Wwwwwwwwwwwwwwwwwwwwww = getTop() + height;
                this.Wwwwwwwwwwwwwwwwwwwww = getBottom() - height;
                break;
        }
        return true;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            motionEvent.getX();
            this.Wwwwwwwwwwwwwwwww = (int) motionEvent.getY();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwww) {
            i2 = View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
    }

    public void setDragShadowOverlay(ImageView imageView) {
        this.Wwwwwwwwwwwwwww = imageView;
        this.Wwwwwwwwwwwwww = (View) imageView.getParent();
    }
}
