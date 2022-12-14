package androidx.core.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* loaded from: classes3.dex */
public final class GestureDetectorCompat {
    public final GestureDetectorCompatImpl mImpl;

    /* loaded from: classes3.dex */
    public interface GestureDetectorCompatImpl {
        boolean isLongpressEnabled();

        boolean onTouchEvent(MotionEvent motionEvent);

        void setIsLongpressEnabled(boolean z);

        void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener);
    }

    /* loaded from: classes3.dex */
    public static class GestureDetectorCompatImplBase implements GestureDetectorCompatImpl {
        public static final int LONG_PRESS = 2;
        public static final int SHOW_PRESS = 1;
        public static final int TAP = 3;
        public boolean mAlwaysInBiggerTapRegion;
        public boolean mAlwaysInTapRegion;
        public MotionEvent mCurrentDownEvent;
        public boolean mDeferConfirmSingleTap;
        public GestureDetector.OnDoubleTapListener mDoubleTapListener;
        public int mDoubleTapSlopSquare;
        public float mDownFocusX;
        public float mDownFocusY;
        public final Handler mHandler;
        public boolean mInLongPress;
        public boolean mIsDoubleTapping;
        public boolean mIsLongpressEnabled;
        public float mLastFocusX;
        public float mLastFocusY;
        public final GestureDetector.OnGestureListener mListener;
        public int mMaximumFlingVelocity;
        public int mMinimumFlingVelocity;
        public MotionEvent mPreviousUpEvent;
        public boolean mStillDown;
        public int mTouchSlopSquare;
        public VelocityTracker mVelocityTracker;
        public static final int LONGPRESS_TIMEOUT = ViewConfiguration.getLongPressTimeout();
        public static final int TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
        public static final int DOUBLE_TAP_TIMEOUT = ViewConfiguration.getDoubleTapTimeout();

        /* loaded from: classes3.dex */
        public class GestureHandler extends Handler {
            public GestureHandler() {
            }

            public GestureHandler(Handler handler) {
                super(handler.getLooper());
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 1) {
                    GestureDetectorCompatImplBase gestureDetectorCompatImplBase = GestureDetectorCompatImplBase.this;
                    gestureDetectorCompatImplBase.mListener.onShowPress(gestureDetectorCompatImplBase.mCurrentDownEvent);
                } else if (i == 2) {
                    GestureDetectorCompatImplBase.this.dispatchLongPress();
                } else if (i != 3) {
                    throw new RuntimeException("Unknown message " + message);
                } else {
                    GestureDetectorCompatImplBase gestureDetectorCompatImplBase2 = GestureDetectorCompatImplBase.this;
                    GestureDetector.OnDoubleTapListener onDoubleTapListener = gestureDetectorCompatImplBase2.mDoubleTapListener;
                    if (onDoubleTapListener == null) {
                        return;
                    }
                    if (!gestureDetectorCompatImplBase2.mStillDown) {
                        onDoubleTapListener.onSingleTapConfirmed(gestureDetectorCompatImplBase2.mCurrentDownEvent);
                    } else {
                        gestureDetectorCompatImplBase2.mDeferConfirmSingleTap = true;
                    }
                }
            }
        }

        public GestureDetectorCompatImplBase(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            if (handler != null) {
                this.mHandler = new GestureHandler(handler);
            } else {
                this.mHandler = new GestureHandler();
            }
            this.mListener = onGestureListener;
            if (onGestureListener instanceof GestureDetector.OnDoubleTapListener) {
                setOnDoubleTapListener((GestureDetector.OnDoubleTapListener) onGestureListener);
            }
            init(context);
        }

        private void cancel() {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(3);
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
            this.mIsDoubleTapping = false;
            this.mStillDown = false;
            this.mAlwaysInTapRegion = false;
            this.mAlwaysInBiggerTapRegion = false;
            this.mDeferConfirmSingleTap = false;
            if (this.mInLongPress) {
                this.mInLongPress = false;
            }
        }

        private void cancelTaps() {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(3);
            this.mIsDoubleTapping = false;
            this.mAlwaysInTapRegion = false;
            this.mAlwaysInBiggerTapRegion = false;
            this.mDeferConfirmSingleTap = false;
            if (this.mInLongPress) {
                this.mInLongPress = false;
            }
        }

        private void init(Context context) {
            if (context != null) {
                if (this.mListener == null) {
                    throw new IllegalArgumentException("OnGestureListener must not be null");
                }
                this.mIsLongpressEnabled = true;
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
                int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
                this.mMinimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
                this.mMaximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
                this.mTouchSlopSquare = scaledTouchSlop * scaledTouchSlop;
                this.mDoubleTapSlopSquare = scaledDoubleTapSlop * scaledDoubleTapSlop;
                return;
            }
            throw new IllegalArgumentException("Context must not be null");
        }

        private boolean isConsideredDoubleTap(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
            if (this.mAlwaysInBiggerTapRegion && motionEvent3.getEventTime() - motionEvent2.getEventTime() <= DOUBLE_TAP_TIMEOUT) {
                int x = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
                int y = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
                return (y * y) + (x * x) < this.mDoubleTapSlopSquare;
            }
            return false;
        }

        public void dispatchLongPress() {
            this.mHandler.removeMessages(3);
            this.mDeferConfirmSingleTap = false;
            this.mInLongPress = true;
            this.mListener.onLongPress(this.mCurrentDownEvent);
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public boolean isLongpressEnabled() {
            return this.mIsLongpressEnabled;
        }

        /* JADX WARN: Removed duplicated region for block: B:114:0x0208  */
        /* JADX WARN: Removed duplicated region for block: B:117:0x021f  */
        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z;
            MotionEvent motionEvent2;
            MotionEvent motionEvent3;
            boolean onFling;
            GestureDetector.OnDoubleTapListener onDoubleTapListener;
            int action = motionEvent.getAction();
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            int i = action & 255;
            boolean z2 = i == 6;
            int actionIndex = z2 ? motionEvent.getActionIndex() : -1;
            int pointerCount = motionEvent.getPointerCount();
            float f = 0.0f;
            float f2 = 0.0f;
            for (int i2 = 0; i2 < pointerCount; i2++) {
                if (actionIndex != i2) {
                    f += motionEvent.getX(i2);
                    f2 += motionEvent.getY(i2);
                }
            }
            float f3 = z2 ? pointerCount - 1 : pointerCount;
            float f4 = f / f3;
            float f5 = f2 / f3;
            if (i == 0) {
                if (this.mDoubleTapListener != null) {
                    boolean hasMessages = this.mHandler.hasMessages(3);
                    if (hasMessages) {
                        this.mHandler.removeMessages(3);
                    }
                    MotionEvent motionEvent4 = this.mCurrentDownEvent;
                    if (motionEvent4 != null && (motionEvent3 = this.mPreviousUpEvent) != null && hasMessages && isConsideredDoubleTap(motionEvent4, motionEvent3, motionEvent)) {
                        this.mIsDoubleTapping = true;
                        z = this.mDoubleTapListener.onDoubleTap(this.mCurrentDownEvent) | false | this.mDoubleTapListener.onDoubleTapEvent(motionEvent);
                        this.mLastFocusX = f4;
                        this.mDownFocusX = f4;
                        this.mLastFocusY = f5;
                        this.mDownFocusY = f5;
                        motionEvent2 = this.mCurrentDownEvent;
                        if (motionEvent2 != null) {
                            motionEvent2.recycle();
                        }
                        this.mCurrentDownEvent = MotionEvent.obtain(motionEvent);
                        this.mAlwaysInTapRegion = true;
                        this.mAlwaysInBiggerTapRegion = true;
                        this.mStillDown = true;
                        this.mInLongPress = false;
                        this.mDeferConfirmSingleTap = false;
                        if (this.mIsLongpressEnabled) {
                            this.mHandler.removeMessages(2);
                            this.mHandler.sendEmptyMessageAtTime(2, this.mCurrentDownEvent.getDownTime() + TAP_TIMEOUT + LONGPRESS_TIMEOUT);
                        }
                        this.mHandler.sendEmptyMessageAtTime(1, this.mCurrentDownEvent.getDownTime() + TAP_TIMEOUT);
                        return z | this.mListener.onDown(motionEvent);
                    }
                    this.mHandler.sendEmptyMessageDelayed(3, DOUBLE_TAP_TIMEOUT);
                }
                z = false;
                this.mLastFocusX = f4;
                this.mDownFocusX = f4;
                this.mLastFocusY = f5;
                this.mDownFocusY = f5;
                motionEvent2 = this.mCurrentDownEvent;
                if (motionEvent2 != null) {
                }
                this.mCurrentDownEvent = MotionEvent.obtain(motionEvent);
                this.mAlwaysInTapRegion = true;
                this.mAlwaysInBiggerTapRegion = true;
                this.mStillDown = true;
                this.mInLongPress = false;
                this.mDeferConfirmSingleTap = false;
                if (this.mIsLongpressEnabled) {
                }
                this.mHandler.sendEmptyMessageAtTime(1, this.mCurrentDownEvent.getDownTime() + TAP_TIMEOUT);
                return z | this.mListener.onDown(motionEvent);
            }
            if (i == 1) {
                this.mStillDown = false;
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                if (this.mIsDoubleTapping) {
                    onFling = this.mDoubleTapListener.onDoubleTapEvent(motionEvent) | false;
                } else {
                    if (this.mInLongPress) {
                        this.mHandler.removeMessages(3);
                        this.mInLongPress = false;
                    } else if (this.mAlwaysInTapRegion) {
                        boolean onSingleTapUp = this.mListener.onSingleTapUp(motionEvent);
                        if (this.mDeferConfirmSingleTap && (onDoubleTapListener = this.mDoubleTapListener) != null) {
                            onDoubleTapListener.onSingleTapConfirmed(motionEvent);
                        }
                        onFling = onSingleTapUp;
                    } else {
                        VelocityTracker velocityTracker = this.mVelocityTracker;
                        int pointerId = motionEvent.getPointerId(0);
                        velocityTracker.computeCurrentVelocity(1000, this.mMaximumFlingVelocity);
                        float yVelocity = velocityTracker.getYVelocity(pointerId);
                        float xVelocity = velocityTracker.getXVelocity(pointerId);
                        if (Math.abs(yVelocity) > this.mMinimumFlingVelocity || Math.abs(xVelocity) > this.mMinimumFlingVelocity) {
                            onFling = this.mListener.onFling(this.mCurrentDownEvent, motionEvent, xVelocity, yVelocity);
                        }
                    }
                    onFling = false;
                }
                MotionEvent motionEvent5 = this.mPreviousUpEvent;
                if (motionEvent5 != null) {
                    motionEvent5.recycle();
                }
                this.mPreviousUpEvent = obtain;
                VelocityTracker velocityTracker2 = this.mVelocityTracker;
                if (velocityTracker2 != null) {
                    velocityTracker2.recycle();
                    this.mVelocityTracker = null;
                }
                this.mIsDoubleTapping = false;
                this.mDeferConfirmSingleTap = false;
                this.mHandler.removeMessages(1);
                this.mHandler.removeMessages(2);
            } else if (i != 2) {
                if (i == 3) {
                    cancel();
                    return false;
                } else if (i == 5) {
                    this.mLastFocusX = f4;
                    this.mDownFocusX = f4;
                    this.mLastFocusY = f5;
                    this.mDownFocusY = f5;
                    cancelTaps();
                    return false;
                } else if (i != 6) {
                    return false;
                } else {
                    this.mLastFocusX = f4;
                    this.mDownFocusX = f4;
                    this.mLastFocusY = f5;
                    this.mDownFocusY = f5;
                    this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaximumFlingVelocity);
                    int actionIndex2 = motionEvent.getActionIndex();
                    int pointerId2 = motionEvent.getPointerId(actionIndex2);
                    float xVelocity2 = this.mVelocityTracker.getXVelocity(pointerId2);
                    float yVelocity2 = this.mVelocityTracker.getYVelocity(pointerId2);
                    for (int i3 = 0; i3 < pointerCount; i3++) {
                        if (i3 != actionIndex2) {
                            int pointerId3 = motionEvent.getPointerId(i3);
                            if ((this.mVelocityTracker.getYVelocity(pointerId3) * yVelocity2) + (this.mVelocityTracker.getXVelocity(pointerId3) * xVelocity2) < 0.0f) {
                                this.mVelocityTracker.clear();
                                return false;
                            }
                        }
                    }
                    return false;
                }
            } else if (this.mInLongPress) {
                return false;
            } else {
                float f6 = this.mLastFocusX - f4;
                float f7 = this.mLastFocusY - f5;
                if (this.mIsDoubleTapping) {
                    return false | this.mDoubleTapListener.onDoubleTapEvent(motionEvent);
                }
                if (!this.mAlwaysInTapRegion) {
                    if (Math.abs(f6) < 1.0f && Math.abs(f7) < 1.0f) {
                        return false;
                    }
                    boolean onScroll = this.mListener.onScroll(this.mCurrentDownEvent, motionEvent, f6, f7);
                    this.mLastFocusX = f4;
                    this.mLastFocusY = f5;
                    return onScroll;
                }
                int i4 = (int) (f4 - this.mDownFocusX);
                int i5 = (int) (f5 - this.mDownFocusY);
                int i6 = (i5 * i5) + (i4 * i4);
                if (i6 > this.mTouchSlopSquare) {
                    onFling = this.mListener.onScroll(this.mCurrentDownEvent, motionEvent, f6, f7);
                    this.mLastFocusX = f4;
                    this.mLastFocusY = f5;
                    this.mAlwaysInTapRegion = false;
                    this.mHandler.removeMessages(3);
                    this.mHandler.removeMessages(1);
                    this.mHandler.removeMessages(2);
                } else {
                    onFling = false;
                }
                if (i6 > this.mTouchSlopSquare) {
                    this.mAlwaysInBiggerTapRegion = false;
                }
            }
            return onFling;
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public void setIsLongpressEnabled(boolean z) {
            this.mIsLongpressEnabled = z;
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            this.mDoubleTapListener = onDoubleTapListener;
        }
    }

    /* loaded from: classes3.dex */
    public static class GestureDetectorCompatImplJellybeanMr2 implements GestureDetectorCompatImpl {
        public final GestureDetector mDetector;

        public GestureDetectorCompatImplJellybeanMr2(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            this.mDetector = new GestureDetector(context, onGestureListener, handler);
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public boolean isLongpressEnabled() {
            return this.mDetector.isLongpressEnabled();
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return this.mDetector.onTouchEvent(motionEvent);
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public void setIsLongpressEnabled(boolean z) {
            this.mDetector.setIsLongpressEnabled(z);
        }

        @Override // androidx.core.view.GestureDetectorCompat.GestureDetectorCompatImpl
        public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            this.mDetector.setOnDoubleTapListener(onDoubleTapListener);
        }
    }

    public GestureDetectorCompat(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public GestureDetectorCompat(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        this.mImpl = new GestureDetectorCompatImplJellybeanMr2(context, onGestureListener, handler);
    }

    public boolean isLongpressEnabled() {
        return this.mImpl.isLongpressEnabled();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mImpl.onTouchEvent(motionEvent);
    }

    public void setIsLongpressEnabled(boolean z) {
        this.mImpl.setIsLongpressEnabled(z);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.mImpl.setOnDoubleTapListener(onDoubleTapListener);
    }
}
