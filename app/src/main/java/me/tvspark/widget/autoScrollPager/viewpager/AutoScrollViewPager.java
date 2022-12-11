package me.tvspark.widget.autoScrollPager.viewpager;

import android.view.MotionEvent;
import androidx.core.view.MotionEventCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes4.dex */
public class AutoScrollViewPager extends ViewPager {
    public int Wwwwwwwwwwww;
    public int Wwwwwwwwwwwww;
    public float Wwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwww;
    public double Wwwwwwwwwwwwwwwwww;
    public double Wwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwww;

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (this.Wwwwwwwwwwwwwwwwwwwwww) {
            if (actionMasked == 0 && this.Wwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwww = true;
                this.Wwwwwwwwwwwwwwwww = false;
                throw null;
            } else if (motionEvent.getAction() == 1 && this.Wwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwww = true;
                throw null;
            }
        }
        int i = this.Wwwwwwwwwwwwwwwwwwwww;
        if (i == 2 || i == 1) {
            this.Wwwwwwwwwwwwwww = motionEvent.getX();
            if (motionEvent.getAction() == 0) {
                this.Wwwwwwwwwwwwww = this.Wwwwwwwwwwwwwww;
            }
            int currentItem = getCurrentItem();
            PagerAdapter adapter = getAdapter();
            int count = adapter == null ? 0 : adapter.getCount();
            if ((currentItem == 0 && this.Wwwwwwwwwwwwww <= this.Wwwwwwwwwwwwwww) || (currentItem == count - 1 && this.Wwwwwwwwwwwwww >= this.Wwwwwwwwwwwwwww)) {
                if (this.Wwwwwwwwwwwwwwwwwwwww == 2) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                } else {
                    if (count > 1) {
                        setCurrentItem((count - currentItem) - 1, this.Wwwwwwwwwwwwwwwwwwww);
                    }
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                return super.dispatchTouchEvent(motionEvent);
            }
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    public int getDirection() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww == 0 ? 0 : 1;
    }

    public long getInterval() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    public int getSlideBorderMode() {
        return this.Wwwwwwwwwwwwwwwwwwwww;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.Wwwwwwwwwwwww = rawX;
            this.Wwwwwwwwwwww = rawY;
        } else if (action == 2) {
            if (Math.abs(rawX - this.Wwwwwwwwwwwww) < Math.abs(rawY - this.Wwwwwwwwwwww)) {
                getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            }
            getParent().requestDisallowInterceptTouchEvent(true);
            return super.onInterceptTouchEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setAutoScrollDurationFactor(double d) {
        this.Wwwwwwwwwwwwwwwwwww = d;
    }

    public void setBorderAnimation(boolean z) {
        this.Wwwwwwwwwwwwwwwwwwww = z;
    }

    public void setCycle(boolean z) {
    }

    public void setDirection(int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = i;
    }

    public void setInterval(long j) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = j;
    }

    public void setSlideBorderMode(int i) {
        this.Wwwwwwwwwwwwwwwwwwwww = i;
    }

    public void setStopScrollWhenTouch(boolean z) {
        this.Wwwwwwwwwwwwwwwwwwwwww = z;
    }

    public void setSwipeScrollDurationFactor(double d) {
        this.Wwwwwwwwwwwwwwwwww = d;
    }
}
