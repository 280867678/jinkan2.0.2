package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.C0186R;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes3.dex */
public class KeyTrigger extends Key {
    public static final int KEY_TYPE = 5;
    public static final String NAME = "KeyTrigger";
    public static final String TAG = "KeyTrigger";
    public Method mFireCross;
    public float mFireLastPos;
    public Method mFireNegativeCross;
    public Method mFirePositiveCross;
    public int mTriggerCollisionId;
    public int mTriggerID;
    public int mTriggerReceiver;
    public int mCurveFit = -1;
    public String mCross = null;
    public String mNegativeCross = null;
    public String mPositiveCross = null;
    public View mTriggerCollisionView = null;
    public float mTriggerSlack = 0.1f;
    public boolean mFireCrossReset = true;
    public boolean mFireNegativeReset = true;
    public boolean mFirePositiveReset = true;
    public float mFireThreshold = Float.NaN;
    public boolean mPostLayout = false;
    public RectF mCollisionRect = new RectF();
    public RectF mTargetRect = new RectF();

    /* loaded from: classes3.dex */
    public static class Loader {
        public static final int COLLISION = 9;
        public static final int CROSS = 4;
        public static final int FRAME_POS = 8;
        public static final int NEGATIVE_CROSS = 1;
        public static final int POSITIVE_CROSS = 2;
        public static final int POST_LAYOUT = 10;
        public static final int TARGET_ID = 7;
        public static final int TRIGGER_ID = 6;
        public static final int TRIGGER_RECEIVER = 11;
        public static final int TRIGGER_SLACK = 5;
        public static SparseIntArray mAttrMap;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mAttrMap = sparseIntArray;
            sparseIntArray.append(C0186R.styleable.KeyTrigger_framePosition, 8);
            mAttrMap.append(C0186R.styleable.KeyTrigger_onCross, 4);
            mAttrMap.append(C0186R.styleable.KeyTrigger_onNegativeCross, 1);
            mAttrMap.append(C0186R.styleable.KeyTrigger_onPositiveCross, 2);
            mAttrMap.append(C0186R.styleable.KeyTrigger_motionTarget, 7);
            mAttrMap.append(C0186R.styleable.KeyTrigger_triggerId, 6);
            mAttrMap.append(C0186R.styleable.KeyTrigger_triggerSlack, 5);
            mAttrMap.append(C0186R.styleable.KeyTrigger_motion_triggerOnCollision, 9);
            mAttrMap.append(C0186R.styleable.KeyTrigger_motion_postLayoutCollision, 10);
            mAttrMap.append(C0186R.styleable.KeyTrigger_triggerReceiver, 11);
        }

        public static void read(KeyTrigger keyTrigger, TypedArray typedArray, Context context) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                switch (mAttrMap.get(index)) {
                    case 1:
                        keyTrigger.mNegativeCross = typedArray.getString(index);
                        continue;
                    case 2:
                        keyTrigger.mPositiveCross = typedArray.getString(index);
                        continue;
                    case 4:
                        keyTrigger.mCross = typedArray.getString(index);
                        continue;
                    case 5:
                        keyTrigger.mTriggerSlack = typedArray.getFloat(index, keyTrigger.mTriggerSlack);
                        continue;
                    case 6:
                        keyTrigger.mTriggerID = typedArray.getResourceId(index, keyTrigger.mTriggerID);
                        continue;
                    case 7:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            int resourceId = typedArray.getResourceId(index, keyTrigger.mTargetId);
                            keyTrigger.mTargetId = resourceId;
                            if (resourceId != -1) {
                                continue;
                            }
                            keyTrigger.mTargetString = typedArray.getString(index);
                        } else {
                            if (typedArray.peekValue(index).type != 3) {
                                keyTrigger.mTargetId = typedArray.getResourceId(index, keyTrigger.mTargetId);
                            }
                            keyTrigger.mTargetString = typedArray.getString(index);
                        }
                    case 8:
                        int integer = typedArray.getInteger(index, keyTrigger.mFramePosition);
                        keyTrigger.mFramePosition = integer;
                        keyTrigger.mFireThreshold = (integer + 0.5f) / 100.0f;
                        continue;
                    case 9:
                        keyTrigger.mTriggerCollisionId = typedArray.getResourceId(index, keyTrigger.mTriggerCollisionId);
                        continue;
                    case 10:
                        keyTrigger.mPostLayout = typedArray.getBoolean(index, keyTrigger.mPostLayout);
                        continue;
                    case 11:
                        keyTrigger.mTriggerReceiver = typedArray.getResourceId(index, keyTrigger.mTriggerReceiver);
                        break;
                }
                Integer.toHexString(index);
                mAttrMap.get(index);
            }
        }
    }

    public KeyTrigger() {
        int i = Key.UNSET;
        this.mTriggerReceiver = i;
        this.mTriggerID = i;
        this.mTriggerCollisionId = i;
        this.mType = 5;
        this.mCustomConstraints = new HashMap<>();
    }

    private void setUpRect(RectF rectF, View view, boolean z) {
        rectF.top = view.getTop();
        rectF.bottom = view.getBottom();
        rectF.left = view.getLeft();
        rectF.right = view.getRight();
        if (z) {
            view.getMatrix().mapRect(rectF);
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, SplineSet> hashMap) {
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void conditionallyFire(float f, View view) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5 = true;
        if (this.mTriggerCollisionId != Key.UNSET) {
            if (this.mTriggerCollisionView == null) {
                this.mTriggerCollisionView = ((ViewGroup) view.getParent()).findViewById(this.mTriggerCollisionId);
            }
            setUpRect(this.mCollisionRect, this.mTriggerCollisionView, this.mPostLayout);
            setUpRect(this.mTargetRect, view, this.mPostLayout);
            if (this.mCollisionRect.intersect(this.mTargetRect)) {
                if (this.mFireCrossReset) {
                    this.mFireCrossReset = false;
                    z = true;
                } else {
                    z = false;
                }
                if (this.mFirePositiveReset) {
                    this.mFirePositiveReset = false;
                    z4 = true;
                } else {
                    z4 = false;
                }
                this.mFireNegativeReset = true;
                z5 = z4;
                z3 = false;
            } else {
                if (!this.mFireCrossReset) {
                    this.mFireCrossReset = true;
                    z = true;
                } else {
                    z = false;
                }
                if (this.mFireNegativeReset) {
                    this.mFireNegativeReset = false;
                    z3 = true;
                } else {
                    z3 = false;
                }
                this.mFirePositiveReset = true;
                z5 = false;
            }
        } else {
            if (this.mFireCrossReset) {
                float f2 = this.mFireThreshold;
                if ((this.mFireLastPos - f2) * (f - f2) < 0.0f) {
                    this.mFireCrossReset = false;
                    z = true;
                    if (!this.mFireNegativeReset) {
                        float f3 = this.mFireThreshold;
                        float f4 = f - f3;
                        if ((this.mFireLastPos - f3) * f4 < 0.0f && f4 < 0.0f) {
                            this.mFireNegativeReset = false;
                            z2 = true;
                            if (this.mFirePositiveReset) {
                                float f5 = this.mFireThreshold;
                                float f6 = f - f5;
                                if ((this.mFireLastPos - f5) * f6 >= 0.0f || f6 <= 0.0f) {
                                    z5 = false;
                                } else {
                                    this.mFirePositiveReset = false;
                                }
                                z3 = z2;
                            } else {
                                if (Math.abs(f - this.mFireThreshold) > this.mTriggerSlack) {
                                    this.mFirePositiveReset = true;
                                }
                                z3 = z2;
                                z5 = false;
                            }
                        }
                    } else if (Math.abs(f - this.mFireThreshold) > this.mTriggerSlack) {
                        this.mFireNegativeReset = true;
                    }
                    z2 = false;
                    if (this.mFirePositiveReset) {
                    }
                }
            } else if (Math.abs(f - this.mFireThreshold) > this.mTriggerSlack) {
                this.mFireCrossReset = true;
            }
            z = false;
            if (!this.mFireNegativeReset) {
            }
            z2 = false;
            if (this.mFirePositiveReset) {
            }
        }
        this.mFireLastPos = f;
        if (z3 || z || z5) {
            ((MotionLayout) view.getParent()).fireTrigger(this.mTriggerID, z5, f);
        }
        if (this.mTriggerReceiver != Key.UNSET) {
            view = ((MotionLayout) view.getParent()).findViewById(this.mTriggerReceiver);
        }
        if (z3 && this.mNegativeCross != null) {
            if (this.mFireNegativeCross == null) {
                try {
                    this.mFireNegativeCross = view.getClass().getMethod(this.mNegativeCross, new Class[0]);
                } catch (NoSuchMethodException unused) {
                    view.getClass().getSimpleName();
                    Debug.getName(view);
                }
            }
            try {
                this.mFireNegativeCross.invoke(view, new Object[0]);
            } catch (Exception unused2) {
                view.getClass().getSimpleName();
                Debug.getName(view);
            }
        }
        if (z5 && this.mPositiveCross != null) {
            if (this.mFirePositiveCross == null) {
                try {
                    this.mFirePositiveCross = view.getClass().getMethod(this.mPositiveCross, new Class[0]);
                } catch (NoSuchMethodException unused3) {
                    view.getClass().getSimpleName();
                    Debug.getName(view);
                }
            }
            try {
                this.mFirePositiveCross.invoke(view, new Object[0]);
            } catch (Exception unused4) {
                view.getClass().getSimpleName();
                Debug.getName(view);
            }
        }
        if (!z || this.mCross == null) {
            return;
        }
        if (this.mFireCross == null) {
            try {
                this.mFireCross = view.getClass().getMethod(this.mCross, new Class[0]);
            } catch (NoSuchMethodException unused5) {
                view.getClass().getSimpleName();
                Debug.getName(view);
            }
        }
        try {
            this.mFireCross.invoke(view, new Object[0]);
        } catch (Exception unused6) {
            view.getClass().getSimpleName();
            Debug.getName(view);
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> hashSet) {
    }

    public int getCurveFit() {
        return this.mCurveFit;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attributeSet) {
        Loader.read(this, context.obtainStyledAttributes(attributeSet, C0186R.styleable.KeyTrigger), context);
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String str, Object obj) {
    }
}
