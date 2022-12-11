package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.core.view.ViewCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import me.tvspark.outline;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes3.dex */
public class ConstraintAttribute {
    public static final String TAG = "TransitionLayout";
    public boolean mBooleanValue;
    public int mColorValue;
    public float mFloatValue;
    public int mIntegerValue;
    public String mName;
    public String mStringValue;
    public AttributeType mType;

    /* renamed from: androidx.constraintlayout.widget.ConstraintAttribute$1 */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C01841 {

        /* renamed from: $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType */
        public static final /* synthetic */ int[] f46x66adad53;

        static {
            int[] iArr = new int[AttributeType.values().length];
            f46x66adad53 = iArr;
            try {
                AttributeType attributeType = AttributeType.COLOR_TYPE;
                iArr[2] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = f46x66adad53;
                AttributeType attributeType2 = AttributeType.COLOR_DRAWABLE_TYPE;
                iArr2[3] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = f46x66adad53;
                AttributeType attributeType3 = AttributeType.INT_TYPE;
                iArr3[0] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = f46x66adad53;
                AttributeType attributeType4 = AttributeType.FLOAT_TYPE;
                iArr4[1] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                int[] iArr5 = f46x66adad53;
                AttributeType attributeType5 = AttributeType.STRING_TYPE;
                iArr5[4] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                int[] iArr6 = f46x66adad53;
                AttributeType attributeType6 = AttributeType.BOOLEAN_TYPE;
                iArr6[5] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                int[] iArr7 = f46x66adad53;
                AttributeType attributeType7 = AttributeType.DIMENSION_TYPE;
                iArr7[6] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public enum AttributeType {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE
    }

    public ConstraintAttribute(ConstraintAttribute constraintAttribute, Object obj) {
        this.mName = constraintAttribute.mName;
        this.mType = constraintAttribute.mType;
        setValue(obj);
    }

    public ConstraintAttribute(String str, AttributeType attributeType) {
        this.mName = str;
        this.mType = attributeType;
    }

    public ConstraintAttribute(String str, AttributeType attributeType, Object obj) {
        this.mName = str;
        this.mType = attributeType;
        setValue(obj);
    }

    public static int clamp(int i) {
        int i2 = (i & (~(i >> 31))) - 255;
        return (i2 & (i2 >> 31)) + 255;
    }

    public static HashMap<String, ConstraintAttribute> extractAttributes(HashMap<String, ConstraintAttribute> hashMap, View view) {
        HashMap<String, ConstraintAttribute> hashMap2 = new HashMap<>();
        Class<?> cls = view.getClass();
        for (String str : hashMap.keySet()) {
            ConstraintAttribute constraintAttribute = hashMap.get(str);
            try {
                hashMap2.put(str, str.equals("BackgroundColor") ? new ConstraintAttribute(constraintAttribute, Integer.valueOf(((ColorDrawable) view.getBackground()).getColor())) : new ConstraintAttribute(constraintAttribute, cls.getMethod("getMap" + str, new Class[0]).invoke(view, new Object[0])));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
        return hashMap2;
    }

    public static void parse(Context context, XmlPullParser xmlPullParser, HashMap<String, ConstraintAttribute> hashMap) {
        AttributeType attributeType;
        Object string;
        int integer;
        float f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), C0186R.styleable.CustomAttribute);
        int indexCount = obtainStyledAttributes.getIndexCount();
        String str = null;
        Object obj = null;
        AttributeType attributeType2 = null;
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == C0186R.styleable.CustomAttribute_attributeName) {
                str = obtainStyledAttributes.getString(index);
                if (str != null && str.length() > 0) {
                    str = Character.toUpperCase(str.charAt(0)) + str.substring(1);
                }
            } else if (index == C0186R.styleable.CustomAttribute_customBoolean) {
                obj = Boolean.valueOf(obtainStyledAttributes.getBoolean(index, false));
                attributeType2 = AttributeType.BOOLEAN_TYPE;
            } else {
                if (index == C0186R.styleable.CustomAttribute_customColorValue) {
                    attributeType = AttributeType.COLOR_TYPE;
                } else if (index == C0186R.styleable.CustomAttribute_customColorDrawableValue) {
                    attributeType = AttributeType.COLOR_DRAWABLE_TYPE;
                } else {
                    if (index == C0186R.styleable.CustomAttribute_customPixelDimension) {
                        attributeType = AttributeType.DIMENSION_TYPE;
                        f = TypedValue.applyDimension(1, obtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics());
                    } else if (index == C0186R.styleable.CustomAttribute_customDimension) {
                        attributeType = AttributeType.DIMENSION_TYPE;
                        f = obtainStyledAttributes.getDimension(index, 0.0f);
                    } else if (index == C0186R.styleable.CustomAttribute_customFloatValue) {
                        attributeType = AttributeType.FLOAT_TYPE;
                        f = obtainStyledAttributes.getFloat(index, Float.NaN);
                    } else if (index == C0186R.styleable.CustomAttribute_customIntegerValue) {
                        attributeType = AttributeType.INT_TYPE;
                        integer = obtainStyledAttributes.getInteger(index, -1);
                        string = Integer.valueOf(integer);
                        Object obj2 = string;
                        attributeType2 = attributeType;
                        obj = obj2;
                    } else if (index == C0186R.styleable.CustomAttribute_customStringValue) {
                        attributeType = AttributeType.STRING_TYPE;
                        string = obtainStyledAttributes.getString(index);
                        Object obj22 = string;
                        attributeType2 = attributeType;
                        obj = obj22;
                    }
                    string = Float.valueOf(f);
                    Object obj222 = string;
                    attributeType2 = attributeType;
                    obj = obj222;
                }
                integer = obtainStyledAttributes.getColor(index, 0);
                string = Integer.valueOf(integer);
                Object obj2222 = string;
                attributeType2 = attributeType;
                obj = obj2222;
            }
        }
        if (str != null && obj != null) {
            hashMap.put(str, new ConstraintAttribute(str, attributeType2, obj));
        }
        obtainStyledAttributes.recycle();
    }

    public static void setAttributes(View view, HashMap<String, ConstraintAttribute> hashMap) {
        Class<?> cls = view.getClass();
        for (String str : hashMap.keySet()) {
            ConstraintAttribute constraintAttribute = hashMap.get(str);
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("set", str);
            try {
                switch (constraintAttribute.mType.ordinal()) {
                    case 0:
                        cls.getMethod(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Integer.TYPE).invoke(view, Integer.valueOf(constraintAttribute.mIntegerValue));
                        break;
                    case 1:
                        cls.getMethod(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Float.TYPE).invoke(view, Float.valueOf(constraintAttribute.mFloatValue));
                        break;
                    case 2:
                        cls.getMethod(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Integer.TYPE).invoke(view, Integer.valueOf(constraintAttribute.mColorValue));
                        break;
                    case 3:
                        Method method = cls.getMethod(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Drawable.class);
                        ColorDrawable colorDrawable = new ColorDrawable();
                        colorDrawable.setColor(constraintAttribute.mColorValue);
                        method.invoke(view, colorDrawable);
                        break;
                    case 4:
                        cls.getMethod(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, CharSequence.class).invoke(view, constraintAttribute.mStringValue);
                        break;
                    case 5:
                        cls.getMethod(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Boolean.TYPE).invoke(view, Boolean.valueOf(constraintAttribute.mBooleanValue));
                        break;
                    case 6:
                        cls.getMethod(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Float.TYPE).invoke(view, Float.valueOf(constraintAttribute.mFloatValue));
                        break;
                }
            } catch (IllegalAccessException e) {
                cls.getName();
                e.printStackTrace();
            } catch (NoSuchMethodException e2) {
                e2.getMessage();
                cls.getName();
            } catch (InvocationTargetException e3) {
                cls.getName();
                e3.printStackTrace();
            }
        }
    }

    public boolean diff(ConstraintAttribute constraintAttribute) {
        AttributeType attributeType;
        if (constraintAttribute == null || (attributeType = this.mType) != constraintAttribute.mType) {
            return false;
        }
        switch (attributeType.ordinal()) {
            case 0:
                return this.mIntegerValue == constraintAttribute.mIntegerValue;
            case 1:
                return this.mFloatValue == constraintAttribute.mFloatValue;
            case 2:
            case 3:
                return this.mColorValue == constraintAttribute.mColorValue;
            case 4:
                return this.mIntegerValue == constraintAttribute.mIntegerValue;
            case 5:
                return this.mBooleanValue == constraintAttribute.mBooleanValue;
            case 6:
                return this.mFloatValue == constraintAttribute.mFloatValue;
            default:
                return false;
        }
    }

    public AttributeType getType() {
        return this.mType;
    }

    public float getValueToInterpolate() {
        switch (this.mType.ordinal()) {
            case 0:
                return this.mIntegerValue;
            case 1:
                return this.mFloatValue;
            case 2:
            case 3:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 4:
                throw new RuntimeException("Cannot interpolate String");
            case 5:
                return this.mBooleanValue ? 0.0f : 1.0f;
            case 6:
                return this.mFloatValue;
            default:
                return Float.NaN;
        }
    }

    public void getValuesToInterpolate(float[] fArr) {
        switch (this.mType.ordinal()) {
            case 0:
                fArr[0] = this.mIntegerValue;
                return;
            case 1:
                fArr[0] = this.mFloatValue;
                return;
            case 2:
            case 3:
                int i = this.mColorValue;
                float pow = (float) Math.pow(((i >> 16) & 255) / 255.0f, 2.2d);
                float pow2 = (float) Math.pow(((i >> 8) & 255) / 255.0f, 2.2d);
                fArr[0] = pow;
                fArr[1] = pow2;
                fArr[2] = (float) Math.pow((i & 255) / 255.0f, 2.2d);
                fArr[3] = ((i >> 24) & 255) / 255.0f;
                return;
            case 4:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 5:
                fArr[0] = this.mBooleanValue ? 0.0f : 1.0f;
                return;
            case 6:
                fArr[0] = this.mFloatValue;
                return;
            default:
                return;
        }
    }

    public int noOfInterpValues() {
        int ordinal = this.mType.ordinal();
        return (ordinal == 2 || ordinal == 3) ? 4 : 1;
    }

    public void setColorValue(int i) {
        this.mColorValue = i;
    }

    public void setFloatValue(float f) {
        this.mFloatValue = f;
    }

    public void setIntValue(int i) {
        this.mIntegerValue = i;
    }

    public void setInterpolatedValue(View view, float[] fArr) {
        Class<?> cls = view.getClass();
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("set");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mName);
        String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        try {
            boolean z = true;
            switch (this.mType.ordinal()) {
                case 0:
                    cls.getMethod(sb, Integer.TYPE).invoke(view, Integer.valueOf((int) fArr[0]));
                    return;
                case 1:
                    cls.getMethod(sb, Float.TYPE).invoke(view, Float.valueOf(fArr[0]));
                    return;
                case 2:
                    cls.getMethod(sb, Integer.TYPE).invoke(view, Integer.valueOf((clamp((int) (fArr[3] * 255.0f)) << 24) | (clamp((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (clamp((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | clamp((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f))));
                    return;
                case 3:
                    Method method = cls.getMethod(sb, Drawable.class);
                    int clamp = clamp((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f));
                    int clamp2 = clamp((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f));
                    int clamp3 = clamp((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f));
                    ColorDrawable colorDrawable = new ColorDrawable();
                    colorDrawable.setColor((clamp((int) (fArr[3] * 255.0f)) << 24) | (clamp << 16) | (clamp2 << 8) | clamp3);
                    method.invoke(view, colorDrawable);
                    return;
                case 4:
                    throw new RuntimeException("unable to interpolate strings " + this.mName);
                case 5:
                    Method method2 = cls.getMethod(sb, Boolean.TYPE);
                    Object[] objArr = new Object[1];
                    if (fArr[0] <= 0.5f) {
                        z = false;
                    }
                    objArr[0] = Boolean.valueOf(z);
                    method2.invoke(view, objArr);
                    return;
                case 6:
                    cls.getMethod(sb, Float.TYPE).invoke(view, Float.valueOf(fArr[0]));
                    return;
                default:
                    return;
            }
        } catch (IllegalAccessException e) {
            Debug.getName(view);
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            Debug.getName(view);
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
    }

    public void setStringValue(String str) {
        this.mStringValue = str;
    }

    public void setValue(Object obj) {
        switch (this.mType.ordinal()) {
            case 0:
                this.mIntegerValue = ((Integer) obj).intValue();
                return;
            case 1:
            case 6:
                this.mFloatValue = ((Float) obj).floatValue();
                return;
            case 2:
            case 3:
                this.mColorValue = ((Integer) obj).intValue();
                return;
            case 4:
                this.mStringValue = (String) obj;
                return;
            case 5:
                this.mBooleanValue = ((Boolean) obj).booleanValue();
                return;
            default:
                return;
        }
    }

    public void setValue(float[] fArr) {
        float f;
        boolean z = false;
        switch (this.mType.ordinal()) {
            case 0:
                this.mIntegerValue = (int) fArr[0];
                return;
            case 1:
                f = fArr[0];
                break;
            case 2:
            case 3:
                int HSVToColor = Color.HSVToColor(fArr);
                this.mColorValue = HSVToColor;
                this.mColorValue = (clamp((int) (fArr[3] * 255.0f)) << 24) | (HSVToColor & ViewCompat.MEASURED_SIZE_MASK);
                return;
            case 4:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 5:
                if (fArr[0] > 0.5d) {
                    z = true;
                }
                this.mBooleanValue = z;
                return;
            case 6:
                f = fArr[0];
                break;
            default:
                return;
        }
        this.mFloatValue = f;
    }
}
