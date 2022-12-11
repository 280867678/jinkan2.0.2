package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.C0186R;
import androidx.core.widget.NestedScrollView;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes3.dex */
public class TouchResponse {
    public static final boolean DEBUG = false;
    public static final int FLAG_DISABLE_POST_SCROLL = 1;
    public static final int FLAG_DISABLE_SCROLL = 2;
    public static final int SIDE_BOTTOM = 3;
    public static final int SIDE_END = 6;
    public static final int SIDE_LEFT = 1;
    public static final int SIDE_MIDDLE = 4;
    public static final int SIDE_RIGHT = 2;
    public static final int SIDE_START = 5;
    public static final int SIDE_TOP = 0;
    public static final String TAG = "TouchResponse";
    public static final int TOUCH_DOWN = 1;
    public static final int TOUCH_END = 5;
    public static final int TOUCH_LEFT = 2;
    public static final int TOUCH_RIGHT = 3;
    public static final int TOUCH_START = 4;
    public static final int TOUCH_UP = 0;
    public float mLastTouchX;
    public float mLastTouchY;
    public final MotionLayout mMotionLayout;
    public static final float[][] TOUCH_SIDES = {new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};
    public static final float[][] TOUCH_DIRECTION = {new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};
    public int mTouchAnchorSide = 0;
    public int mTouchSide = 0;
    public int mOnTouchUp = 0;
    public int mTouchAnchorId = -1;
    public int mTouchRegionId = -1;
    public int mLimitBoundsTo = -1;
    public float mTouchAnchorY = 0.5f;
    public float mTouchAnchorX = 0.5f;
    public float mTouchDirectionX = 0.0f;
    public float mTouchDirectionY = 1.0f;
    public boolean mDragStarted = false;
    public float[] mAnchorDpDt = new float[2];
    public float mMaxVelocity = 4.0f;
    public float mMaxAcceleration = 1.2f;
    public boolean mMoveWhenScrollAtTop = true;
    public float mDragScale = 1.0f;
    public int mFlags = 0;
    public float mDragThreshold = 10.0f;

    public TouchResponse(Context context, MotionLayout motionLayout, XmlPullParser xmlPullParser) {
        this.mMotionLayout = motionLayout;
        fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser));
    }

    private void fill(TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArray.getIndex(i);
            if (index == C0186R.styleable.OnSwipe_touchAnchorId) {
                this.mTouchAnchorId = typedArray.getResourceId(index, this.mTouchAnchorId);
            } else if (index == C0186R.styleable.OnSwipe_touchAnchorSide) {
                int i2 = typedArray.getInt(index, this.mTouchAnchorSide);
                this.mTouchAnchorSide = i2;
                float[][] fArr = TOUCH_SIDES;
                this.mTouchAnchorX = fArr[i2][0];
                this.mTouchAnchorY = fArr[i2][1];
            } else if (index == C0186R.styleable.OnSwipe_dragDirection) {
                int i3 = typedArray.getInt(index, this.mTouchSide);
                this.mTouchSide = i3;
                float[][] fArr2 = TOUCH_DIRECTION;
                this.mTouchDirectionX = fArr2[i3][0];
                this.mTouchDirectionY = fArr2[i3][1];
            } else if (index == C0186R.styleable.OnSwipe_maxVelocity) {
                this.mMaxVelocity = typedArray.getFloat(index, this.mMaxVelocity);
            } else if (index == C0186R.styleable.OnSwipe_maxAcceleration) {
                this.mMaxAcceleration = typedArray.getFloat(index, this.mMaxAcceleration);
            } else if (index == C0186R.styleable.OnSwipe_moveWhenScrollAtTop) {
                this.mMoveWhenScrollAtTop = typedArray.getBoolean(index, this.mMoveWhenScrollAtTop);
            } else if (index == C0186R.styleable.OnSwipe_dragScale) {
                this.mDragScale = typedArray.getFloat(index, this.mDragScale);
            } else if (index == C0186R.styleable.OnSwipe_dragThreshold) {
                this.mDragThreshold = typedArray.getFloat(index, this.mDragThreshold);
            } else if (index == C0186R.styleable.OnSwipe_touchRegionId) {
                this.mTouchRegionId = typedArray.getResourceId(index, this.mTouchRegionId);
            } else if (index == C0186R.styleable.OnSwipe_onTouchUp) {
                this.mOnTouchUp = typedArray.getInt(index, this.mOnTouchUp);
            } else if (index == C0186R.styleable.OnSwipe_nestedScrollFlags) {
                this.mFlags = typedArray.getInteger(index, 0);
            } else if (index == C0186R.styleable.OnSwipe_limitBoundsTo) {
                this.mLimitBoundsTo = typedArray.getResourceId(index, 0);
            }
        }
    }

    private void fillFromAttributeList(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0186R.styleable.OnSwipe);
        fill(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    public float dot(float f, float f2) {
        return (f2 * this.mTouchDirectionY) + (f * this.mTouchDirectionX);
    }

    public int getAnchorId() {
        return this.mTouchAnchorId;
    }

    public int getFlags() {
        return this.mFlags;
    }

    public RectF getLimitBoundsTo(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i = this.mLimitBoundsTo;
        if (i == -1 || (findViewById = viewGroup.findViewById(i)) == null) {
            return null;
        }
        rectF.set(findViewById.getLeft(), findViewById.getTop(), findViewById.getRight(), findViewById.getBottom());
        return rectF;
    }

    public int getLimitBoundsToId() {
        return this.mLimitBoundsTo;
    }

    public float getMaxAcceleration() {
        return this.mMaxAcceleration;
    }

    public float getMaxVelocity() {
        return this.mMaxVelocity;
    }

    public boolean getMoveWhenScrollAtTop() {
        return this.mMoveWhenScrollAtTop;
    }

    public float getProgressDirection(float f, float f2) {
        this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, this.mMotionLayout.getProgress(), this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        if (this.mTouchDirectionX != 0.0f) {
            float[] fArr = this.mAnchorDpDt;
            if (fArr[0] == 0.0f) {
                fArr[0] = 1.0E-7f;
            }
            return (f * this.mTouchDirectionX) / this.mAnchorDpDt[0];
        }
        float[] fArr2 = this.mAnchorDpDt;
        if (fArr2[1] == 0.0f) {
            fArr2[1] = 1.0E-7f;
        }
        return (f2 * this.mTouchDirectionY) / this.mAnchorDpDt[1];
    }

    public RectF getTouchRegion(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i = this.mTouchRegionId;
        if (i == -1 || (findViewById = viewGroup.findViewById(i)) == null) {
            return null;
        }
        rectF.set(findViewById.getLeft(), findViewById.getTop(), findViewById.getRight(), findViewById.getBottom());
        return rectF;
    }

    public int getTouchRegionId() {
        return this.mTouchRegionId;
    }

    public void processTouchEvent(MotionEvent motionEvent, MotionLayout.MotionTracker motionTracker, int i, MotionScene motionScene) {
        int i2;
        motionTracker.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mLastTouchX = motionEvent.getRawX();
            this.mLastTouchY = motionEvent.getRawY();
            this.mDragStarted = false;
        } else if (action == 1) {
            this.mDragStarted = false;
            motionTracker.computeCurrentVelocity(1000);
            float xVelocity = motionTracker.getXVelocity();
            float yVelocity = motionTracker.getYVelocity();
            float progress = this.mMotionLayout.getProgress();
            int i3 = this.mTouchAnchorId;
            if (i3 != -1) {
                this.mMotionLayout.getAnchorDpDt(i3, progress, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
            } else {
                float min = Math.min(this.mMotionLayout.getWidth(), this.mMotionLayout.getHeight());
                float[] fArr = this.mAnchorDpDt;
                fArr[1] = this.mTouchDirectionY * min;
                fArr[0] = min * this.mTouchDirectionX;
            }
            float f = this.mTouchDirectionX;
            float[] fArr2 = this.mAnchorDpDt;
            float f2 = fArr2[0];
            float f3 = fArr2[1];
            float f4 = f != 0.0f ? xVelocity / fArr2[0] : yVelocity / fArr2[1];
            float f5 = !Float.isNaN(f4) ? (f4 / 3.0f) + progress : progress;
            if (f5 != 0.0f && f5 != 1.0f && (i2 = this.mOnTouchUp) != 3) {
                this.mMotionLayout.touchAnimateTo(i2, ((double) f5) < 0.5d ? 0.0f : 1.0f, f4);
                if (0.0f < progress && 1.0f > progress) {
                    return;
                }
            } else if (0.0f < f5 && 1.0f > f5) {
                return;
            }
            this.mMotionLayout.setState(MotionLayout.TransitionState.FINISHED);
        } else if (action != 2) {
        } else {
            float rawY = motionEvent.getRawY() - this.mLastTouchY;
            float rawX = motionEvent.getRawX() - this.mLastTouchX;
            if (Math.abs((this.mTouchDirectionY * rawY) + (this.mTouchDirectionX * rawX)) <= this.mDragThreshold && !this.mDragStarted) {
                return;
            }
            float progress2 = this.mMotionLayout.getProgress();
            if (!this.mDragStarted) {
                this.mDragStarted = true;
                this.mMotionLayout.setProgress(progress2);
            }
            int i4 = this.mTouchAnchorId;
            if (i4 != -1) {
                this.mMotionLayout.getAnchorDpDt(i4, progress2, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
            } else {
                float min2 = Math.min(this.mMotionLayout.getWidth(), this.mMotionLayout.getHeight());
                float[] fArr3 = this.mAnchorDpDt;
                fArr3[1] = this.mTouchDirectionY * min2;
                fArr3[0] = min2 * this.mTouchDirectionX;
            }
            float f6 = this.mTouchDirectionX;
            float[] fArr4 = this.mAnchorDpDt;
            if (Math.abs(((this.mTouchDirectionY * fArr4[1]) + (f6 * fArr4[0])) * this.mDragScale) < 0.01d) {
                float[] fArr5 = this.mAnchorDpDt;
                fArr5[0] = 0.01f;
                fArr5[1] = 0.01f;
            }
            float max = Math.max(Math.min(progress2 + (this.mTouchDirectionX != 0.0f ? rawX / this.mAnchorDpDt[0] : rawY / this.mAnchorDpDt[1]), 1.0f), 0.0f);
            if (max != this.mMotionLayout.getProgress()) {
                this.mMotionLayout.setProgress(max);
                motionTracker.computeCurrentVelocity(1000);
                this.mMotionLayout.mLastVelocity = this.mTouchDirectionX != 0.0f ? motionTracker.getXVelocity() / this.mAnchorDpDt[0] : motionTracker.getYVelocity() / this.mAnchorDpDt[1];
            } else {
                this.mMotionLayout.mLastVelocity = 0.0f;
            }
            this.mLastTouchX = motionEvent.getRawX();
            this.mLastTouchY = motionEvent.getRawY();
        }
    }

    public void scrollMove(float f, float f2) {
        float progress = this.mMotionLayout.getProgress();
        if (!this.mDragStarted) {
            this.mDragStarted = true;
            this.mMotionLayout.setProgress(progress);
        }
        this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, progress, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        float f3 = this.mTouchDirectionX;
        float[] fArr = this.mAnchorDpDt;
        if (Math.abs((this.mTouchDirectionY * fArr[1]) + (f3 * fArr[0])) < 0.01d) {
            float[] fArr2 = this.mAnchorDpDt;
            fArr2[0] = 0.01f;
            fArr2[1] = 0.01f;
        }
        float f4 = this.mTouchDirectionX;
        float max = Math.max(Math.min(progress + (f4 != 0.0f ? (f * f4) / this.mAnchorDpDt[0] : (f2 * this.mTouchDirectionY) / this.mAnchorDpDt[1]), 1.0f), 0.0f);
        if (max != this.mMotionLayout.getProgress()) {
            this.mMotionLayout.setProgress(max);
        }
    }

    public void scrollUp(float f, float f2) {
        boolean z = false;
        this.mDragStarted = false;
        float progress = this.mMotionLayout.getProgress();
        this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, progress, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        float f3 = this.mTouchDirectionX;
        float[] fArr = this.mAnchorDpDt;
        float f4 = fArr[0];
        float f5 = this.mTouchDirectionY;
        float f6 = fArr[1];
        float f7 = 0.0f;
        float f8 = f3 != 0.0f ? (f * f3) / fArr[0] : (f2 * f5) / fArr[1];
        if (!Float.isNaN(f8)) {
            progress += f8 / 3.0f;
        }
        if (progress != 0.0f) {
            boolean z2 = progress != 1.0f;
            if (this.mOnTouchUp != 3) {
                z = true;
            }
            if (!z || !z2) {
                return;
            }
            MotionLayout motionLayout = this.mMotionLayout;
            int i = this.mOnTouchUp;
            if (progress >= 0.5d) {
                f7 = 1.0f;
            }
            motionLayout.touchAnimateTo(i, f7, f8);
        }
    }

    public void setAnchorId(int i) {
        this.mTouchAnchorId = i;
    }

    public void setDown(float f, float f2) {
        this.mLastTouchX = f;
        this.mLastTouchY = f2;
    }

    public void setMaxAcceleration(float f) {
        this.mMaxAcceleration = f;
    }

    public void setMaxVelocity(float f) {
        this.mMaxVelocity = f;
    }

    public void setRTL(boolean z) {
        if (z) {
            float[][] fArr = TOUCH_DIRECTION;
            fArr[4] = fArr[3];
            fArr[5] = fArr[2];
            float[][] fArr2 = TOUCH_SIDES;
            fArr2[5] = fArr2[2];
            fArr2[6] = fArr2[1];
        } else {
            float[][] fArr3 = TOUCH_DIRECTION;
            fArr3[4] = fArr3[2];
            fArr3[5] = fArr3[3];
            float[][] fArr4 = TOUCH_SIDES;
            fArr4[5] = fArr4[1];
            fArr4[6] = fArr4[2];
        }
        float[][] fArr5 = TOUCH_SIDES;
        int i = this.mTouchAnchorSide;
        this.mTouchAnchorX = fArr5[i][0];
        this.mTouchAnchorY = fArr5[i][1];
        float[][] fArr6 = TOUCH_DIRECTION;
        int i2 = this.mTouchSide;
        this.mTouchDirectionX = fArr6[i2][0];
        this.mTouchDirectionY = fArr6[i2][1];
    }

    public void setTouchAnchorLocation(float f, float f2) {
        this.mTouchAnchorX = f;
        this.mTouchAnchorY = f2;
    }

    public void setUpTouchEvent(float f, float f2) {
        this.mLastTouchX = f;
        this.mLastTouchY = f2;
        this.mDragStarted = false;
    }

    public void setupTouch() {
        View view;
        int i = this.mTouchAnchorId;
        if (i != -1) {
            view = this.mMotionLayout.findViewById(i);
            if (view == null) {
                Debug.getName(this.mMotionLayout.getContext(), this.mTouchAnchorId);
            }
        } else {
            view = null;
        }
        if (view instanceof NestedScrollView) {
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            nestedScrollView.setOnTouchListener(new View.OnTouchListener() { // from class: androidx.constraintlayout.motion.widget.TouchResponse.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    return false;
                }
            });
            nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: androidx.constraintlayout.motion.widget.TouchResponse.2
                @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
                public void onScrollChange(NestedScrollView nestedScrollView2, int i2, int i3, int i4, int i5) {
                }
            });
        }
    }

    public String toString() {
        return this.mTouchDirectionX + " , " + this.mTouchDirectionY;
    }
}
