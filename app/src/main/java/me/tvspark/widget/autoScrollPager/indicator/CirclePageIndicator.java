package me.tvspark.widget.autoScrollPager.indicator;

import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.MotionEventCompat;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes4.dex */
public class CirclePageIndicator extends View implements PageIndicator {
    public boolean Wwwwwwwwwwww;
    public int Wwwwwwwwwwwww;
    public float Wwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwww;
    public ViewPager.OnPageChangeListener Wwwwwwwwwwwwwwwwwwwwww;
    public ViewPager Wwwwwwwwwwwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends View.BaseSavedState {
        public static final Parcelable.Creator<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> CREATOR = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        public int Wwwwwwwwwwwwwwwwwwwwwwww;

        /* loaded from: classes4.dex */
        public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Parcelable.Creator<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> {
            @Override // android.os.Parcelable.Creator
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww createFromParcel(Parcel parcel) {
                return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] newArray(int i) {
                return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i];
            }
        }

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Parcel parcel, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            super(parcel);
            this.Wwwwwwwwwwwwwwwwwwwwwwww = parcel.readInt();
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        int paddingTop = (int) ((this.Wwwwwwwwwwwwwwwwwwwwwwww * 2.0f) + getPaddingTop() + getPaddingBottom() + 1.0f);
        return mode == Integer.MIN_VALUE ? Math.min(paddingTop, size) : paddingTop;
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        ViewPager viewPager;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824 || (viewPager = this.Wwwwwwwwwwwwwwwwwwwwwww) == null) {
            return size;
        }
        int count = viewPager.getAdapter().getCount();
        float paddingRight = getPaddingRight() + getPaddingLeft();
        float f = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = (int) (((count - 1) * f) + (count * 2 * f) + paddingRight + 1.0f);
        return mode == Integer.MIN_VALUE ? Math.min(i2, size) : i2;
    }

    public int getFillColor() {
        throw null;
    }

    public int getOrientation() {
        return this.Wwwwwwwwwwwwwwwww;
    }

    public int getPageColor() {
        throw null;
    }

    public float getRadius() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    public int getStrokeColor() {
        throw null;
    }

    public float getStrokeWidth() {
        throw null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int count;
        super.onDraw(canvas);
        ViewPager viewPager = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (viewPager == null || (count = viewPager.getAdapter().getCount()) == 0) {
            return;
        }
        if (this.Wwwwwwwwwwwwwwwwwwwww >= count) {
            setCurrentItem(count - 1);
            return;
        }
        if (this.Wwwwwwwwwwwwwwwww == 0) {
            getWidth();
            getPaddingLeft();
            getPaddingRight();
            getPaddingTop();
        } else {
            getHeight();
            getPaddingTop();
            getPaddingBottom();
            getPaddingLeft();
        }
        boolean z = this.Wwwwwwwwwwwwwwww;
        throw null;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        if (this.Wwwwwwwwwwwwwwwww == 0) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
        }
        setMeasuredDimension(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        this.Wwwwwwwwwwwwwwwwww = i;
        ViewPager.OnPageChangeListener onPageChangeListener = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        this.Wwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwww = f;
        invalidate();
        ViewPager.OnPageChangeListener onPageChangeListener = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.Wwwwwwwwwwwwwww || this.Wwwwwwwwwwwwwwwwww == 0) {
            this.Wwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwww = i;
            invalidate();
        }
        ViewPager.OnPageChangeListener onPageChangeListener = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(i);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) parcelable;
        super.onRestoreInstanceState(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getSuperState());
        int i = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwww = i;
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(super.onSaveInstanceState());
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwww;
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x;
        if (super.onTouchEvent(motionEvent)) {
            return true;
        }
        ViewPager viewPager = this.Wwwwwwwwwwwwwwwwwwwwwww;
        int i = 0;
        if (viewPager == null || viewPager.getAdapter().getCount() == 0) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float x2 = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.Wwwwwwwwwwwww));
                    float f = x2 - this.Wwwwwwwwwwwwww;
                    if (!this.Wwwwwwwwwwww && Math.abs(f) > 0) {
                        this.Wwwwwwwwwwww = true;
                    }
                    if (this.Wwwwwwwwwwww) {
                        this.Wwwwwwwwwwwwww = x2;
                        if (this.Wwwwwwwwwwwwwwwwwwwwwww.isFakeDragging() || this.Wwwwwwwwwwwwwwwwwwwwwww.beginFakeDrag()) {
                            this.Wwwwwwwwwwwwwwwwwwwwwww.fakeDragBy(f);
                        }
                    }
                } else if (action != 3) {
                    if (action == 5) {
                        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                        this.Wwwwwwwwwwwwww = MotionEventCompat.getX(motionEvent, actionIndex);
                        this.Wwwwwwwwwwwww = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                    } else if (action == 6) {
                        int actionIndex2 = MotionEventCompat.getActionIndex(motionEvent);
                        if (MotionEventCompat.getPointerId(motionEvent, actionIndex2) == this.Wwwwwwwwwwwww) {
                            if (actionIndex2 == 0) {
                                i = 1;
                            }
                            this.Wwwwwwwwwwwww = MotionEventCompat.getPointerId(motionEvent, i);
                        }
                        x = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.Wwwwwwwwwwwww));
                    }
                }
                return true;
            }
            if (!this.Wwwwwwwwwwww) {
                int count = this.Wwwwwwwwwwwwwwwwwwwwwww.getAdapter().getCount();
                float width = getWidth();
                float f2 = width / 2.0f;
                float f3 = width / 6.0f;
                if (this.Wwwwwwwwwwwwwwwwwwwww > 0 && motionEvent.getX() < f2 - f3) {
                    if (action != 3) {
                        this.Wwwwwwwwwwwwwwwwwwwwwww.setCurrentItem(this.Wwwwwwwwwwwwwwwwwwwww - 1);
                    }
                    return true;
                } else if (this.Wwwwwwwwwwwwwwwwwwwww < count - 1 && motionEvent.getX() > f2 + f3) {
                    if (action != 3) {
                        this.Wwwwwwwwwwwwwwwwwwwwwww.setCurrentItem(this.Wwwwwwwwwwwwwwwwwwwww + 1);
                    }
                    return true;
                }
            }
            this.Wwwwwwwwwwww = false;
            this.Wwwwwwwwwwwww = -1;
            if (this.Wwwwwwwwwwwwwwwwwwwwwww.isFakeDragging()) {
                this.Wwwwwwwwwwwwwwwwwwwwwww.endFakeDrag();
            }
            return true;
        }
        this.Wwwwwwwwwwwww = MotionEventCompat.getPointerId(motionEvent, 0);
        x = motionEvent.getX();
        this.Wwwwwwwwwwwwww = x;
        return true;
    }

    public void setCentered(boolean z) {
        this.Wwwwwwwwwwwwwwww = z;
        invalidate();
    }

    public void setCurrentItem(int i) {
        ViewPager viewPager = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (viewPager != null) {
            viewPager.setCurrentItem(i);
            this.Wwwwwwwwwwwwwwwwwwwww = i;
            invalidate();
            return;
        }
        throw new IllegalStateException("ViewPager has not been bound.");
    }

    public void setFillColor(int i) {
        throw null;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.Wwwwwwwwwwwwwwwwwwwwww = onPageChangeListener;
    }

    public void setOrientation(int i) {
        if (i == 0 || i == 1) {
            this.Wwwwwwwwwwwwwwwww = i;
            requestLayout();
            return;
        }
        throw new IllegalArgumentException("Orientation must be either HORIZONTAL or VERTICAL.");
    }

    public void setPageColor(int i) {
        throw null;
    }

    public void setRadius(float f) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = f;
        invalidate();
    }

    public void setSnap(boolean z) {
        this.Wwwwwwwwwwwwwww = z;
        invalidate();
    }

    public void setStrokeColor(int i) {
        throw null;
    }

    public void setStrokeWidth(float f) {
        throw null;
    }

    public void setViewPager(ViewPager viewPager) {
        ViewPager viewPager2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (viewPager2 == viewPager) {
            return;
        }
        if (viewPager2 != null) {
            viewPager2.setOnPageChangeListener(null);
        }
        if (viewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        this.Wwwwwwwwwwwwwwwwwwwwwww = viewPager;
        viewPager.setOnPageChangeListener(this);
        invalidate();
    }
}
