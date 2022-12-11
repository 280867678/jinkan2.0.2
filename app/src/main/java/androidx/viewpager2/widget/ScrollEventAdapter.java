package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class ScrollEventAdapter extends RecyclerView.OnScrollListener {
    public static final int NO_POSITION = -1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_IN_PROGRESS_FAKE_DRAG = 4;
    public static final int STATE_IN_PROGRESS_IMMEDIATE_SCROLL = 3;
    public static final int STATE_IN_PROGRESS_MANUAL_DRAG = 1;
    public static final int STATE_IN_PROGRESS_SMOOTH_SCROLL = 2;
    public int mAdapterState;
    public ViewPager2.OnPageChangeCallback mCallback;
    public boolean mDataSetChangeHappened;
    public boolean mDispatchSelected;
    public int mDragStartPosition;
    public boolean mFakeDragging;
    @NonNull
    public final LinearLayoutManager mLayoutManager;
    @NonNull
    public final RecyclerView mRecyclerView;
    public boolean mScrollHappened;
    public int mScrollState;
    public ScrollEventValues mScrollValues = new ScrollEventValues();
    public int mTarget;
    @NonNull
    public final ViewPager2 mViewPager;

    /* loaded from: classes3.dex */
    public static final class ScrollEventValues {
        public float mOffset;
        public int mOffsetPx;
        public int mPosition;

        public void reset() {
            this.mPosition = -1;
            this.mOffset = 0.0f;
            this.mOffsetPx = 0;
        }
    }

    public ScrollEventAdapter(@NonNull ViewPager2 viewPager2) {
        this.mViewPager = viewPager2;
        RecyclerView recyclerView = viewPager2.mRecyclerView;
        this.mRecyclerView = recyclerView;
        this.mLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        resetState();
    }

    private void dispatchScrolled(int i, float f, int i2) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.mCallback;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageScrolled(i, f, i2);
        }
    }

    private void dispatchSelected(int i) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.mCallback;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageSelected(i);
        }
    }

    private void dispatchStateChanged(int i) {
        if ((this.mAdapterState == 3 && this.mScrollState == 0) || this.mScrollState == i) {
            return;
        }
        this.mScrollState = i;
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.mCallback;
        if (onPageChangeCallback == null) {
            return;
        }
        onPageChangeCallback.onPageScrollStateChanged(i);
    }

    private int getPosition() {
        return this.mLayoutManager.findFirstVisibleItemPosition();
    }

    private boolean isInAnyDraggingState() {
        int i = this.mAdapterState;
        return i == 1 || i == 4;
    }

    private void resetState() {
        this.mAdapterState = 0;
        this.mScrollState = 0;
        this.mScrollValues.reset();
        this.mDragStartPosition = -1;
        this.mTarget = -1;
        this.mDispatchSelected = false;
        this.mScrollHappened = false;
        this.mFakeDragging = false;
        this.mDataSetChangeHappened = false;
    }

    private void startDrag(boolean z) {
        this.mFakeDragging = z;
        this.mAdapterState = z ? 4 : 1;
        int i = this.mTarget;
        if (i != -1) {
            this.mDragStartPosition = i;
            this.mTarget = -1;
        } else if (this.mDragStartPosition == -1) {
            this.mDragStartPosition = getPosition();
        }
        dispatchStateChanged(1);
    }

    private void updateScrollEventValues() {
        int top;
        ScrollEventValues scrollEventValues = this.mScrollValues;
        int findFirstVisibleItemPosition = this.mLayoutManager.findFirstVisibleItemPosition();
        scrollEventValues.mPosition = findFirstVisibleItemPosition;
        if (findFirstVisibleItemPosition == -1) {
            scrollEventValues.reset();
            return;
        }
        View findViewByPosition = this.mLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
        if (findViewByPosition == null) {
            scrollEventValues.reset();
            return;
        }
        int leftDecorationWidth = this.mLayoutManager.getLeftDecorationWidth(findViewByPosition);
        int rightDecorationWidth = this.mLayoutManager.getRightDecorationWidth(findViewByPosition);
        int topDecorationHeight = this.mLayoutManager.getTopDecorationHeight(findViewByPosition);
        int bottomDecorationHeight = this.mLayoutManager.getBottomDecorationHeight(findViewByPosition);
        ViewGroup.LayoutParams layoutParams = findViewByPosition.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            leftDecorationWidth += marginLayoutParams.leftMargin;
            rightDecorationWidth += marginLayoutParams.rightMargin;
            topDecorationHeight += marginLayoutParams.topMargin;
            bottomDecorationHeight += marginLayoutParams.bottomMargin;
        }
        int height = findViewByPosition.getHeight() + topDecorationHeight + bottomDecorationHeight;
        int width = findViewByPosition.getWidth() + leftDecorationWidth + rightDecorationWidth;
        if (this.mLayoutManager.getOrientation() == 0) {
            top = (findViewByPosition.getLeft() - leftDecorationWidth) - this.mRecyclerView.getPaddingLeft();
            if (this.mViewPager.isRtl()) {
                top = -top;
            }
            height = width;
        } else {
            top = (findViewByPosition.getTop() - topDecorationHeight) - this.mRecyclerView.getPaddingTop();
        }
        int i = -top;
        scrollEventValues.mOffsetPx = i;
        if (i >= 0) {
            scrollEventValues.mOffset = height == 0 ? 0.0f : i / height;
        } else if (!new AnimateLayoutChangeDetector(this.mLayoutManager).mayHaveInterferingAnimations()) {
            throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", Integer.valueOf(scrollEventValues.mOffsetPx)));
        } else {
            throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
        }
    }

    public double getRelativeScrollPosition() {
        updateScrollEventValues();
        ScrollEventValues scrollEventValues = this.mScrollValues;
        return scrollEventValues.mPosition + scrollEventValues.mOffset;
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public boolean isDragging() {
        return this.mScrollState == 1;
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    public boolean isIdle() {
        return this.mScrollState == 0;
    }

    public void notifyBeginFakeDrag() {
        this.mAdapterState = 4;
        startDrag(true);
    }

    public void notifyDataSetChangeHappened() {
        this.mDataSetChangeHappened = true;
    }

    public void notifyEndFakeDrag() {
        if (!isDragging() || this.mFakeDragging) {
            this.mFakeDragging = false;
            updateScrollEventValues();
            ScrollEventValues scrollEventValues = this.mScrollValues;
            if (scrollEventValues.mOffsetPx != 0) {
                dispatchStateChanged(2);
                return;
            }
            int i = scrollEventValues.mPosition;
            if (i != this.mDragStartPosition) {
                dispatchSelected(i);
            }
            dispatchStateChanged(0);
            resetState();
        }
    }

    public void notifyProgrammaticScroll(int i, boolean z) {
        this.mAdapterState = z ? 2 : 3;
        boolean z2 = false;
        this.mFakeDragging = false;
        if (this.mTarget != i) {
            z2 = true;
        }
        this.mTarget = i;
        dispatchStateChanged(2);
        if (z2) {
            dispatchSelected(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
        boolean z = true;
        if (!(this.mAdapterState == 1 && this.mScrollState == 1) && i == 1) {
            startDrag(false);
        } else if (isInAnyDraggingState() && i == 2) {
            if (!this.mScrollHappened) {
                return;
            }
            dispatchStateChanged(2);
            this.mDispatchSelected = true;
        } else {
            if (isInAnyDraggingState() && i == 0) {
                updateScrollEventValues();
                if (!this.mScrollHappened) {
                    int i2 = this.mScrollValues.mPosition;
                    if (i2 != -1) {
                        dispatchScrolled(i2, 0.0f, 0);
                    }
                } else {
                    ScrollEventValues scrollEventValues = this.mScrollValues;
                    if (scrollEventValues.mOffsetPx == 0) {
                        int i3 = this.mDragStartPosition;
                        int i4 = scrollEventValues.mPosition;
                        if (i3 != i4) {
                            dispatchSelected(i4);
                        }
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    dispatchStateChanged(0);
                    resetState();
                }
            }
            if (this.mAdapterState != 2 || i != 0 || !this.mDataSetChangeHappened) {
                return;
            }
            updateScrollEventValues();
            ScrollEventValues scrollEventValues2 = this.mScrollValues;
            if (scrollEventValues2.mOffsetPx != 0) {
                return;
            }
            int i5 = this.mTarget;
            int i6 = scrollEventValues2.mPosition;
            if (i5 != i6) {
                if (i6 == -1) {
                    i6 = 0;
                }
                dispatchSelected(i6);
            }
            dispatchStateChanged(0);
            resetState();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0037, code lost:
        if (r3.mDragStartPosition != r5) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001d, code lost:
        if ((r5 < 0) == r3.mViewPager.isRtl()) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
        int i3;
        boolean z;
        this.mScrollHappened = true;
        updateScrollEventValues();
        if (this.mDispatchSelected) {
            this.mDispatchSelected = false;
            if (i2 <= 0) {
                if (i2 == 0) {
                }
                z = false;
                if (z) {
                    ScrollEventValues scrollEventValues = this.mScrollValues;
                    if (scrollEventValues.mOffsetPx != 0) {
                        i3 = scrollEventValues.mPosition + 1;
                        this.mTarget = i3;
                    }
                }
                i3 = this.mScrollValues.mPosition;
                this.mTarget = i3;
            }
            z = true;
            if (z) {
            }
            i3 = this.mScrollValues.mPosition;
            this.mTarget = i3;
        } else if (this.mAdapterState == 0) {
            i3 = this.mScrollValues.mPosition;
            if (i3 == -1) {
                i3 = 0;
            }
            dispatchSelected(i3);
        }
        int i4 = this.mScrollValues.mPosition;
        if (i4 == -1) {
            i4 = 0;
        }
        ScrollEventValues scrollEventValues2 = this.mScrollValues;
        dispatchScrolled(i4, scrollEventValues2.mOffset, scrollEventValues2.mOffsetPx);
        int i5 = this.mScrollValues.mPosition;
        int i6 = this.mTarget;
        if ((i5 == i6 || i6 == -1) && this.mScrollValues.mOffsetPx == 0 && this.mScrollState != 1) {
            dispatchStateChanged(0);
            resetState();
        }
    }

    public void setOnPageChangeCallback(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.mCallback = onPageChangeCallback;
    }
}
