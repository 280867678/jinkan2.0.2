package org.mozilla.javascript;

import androidx.cardview.widget.RoundRectDrawableWithShadow;
import me.tvspark.outline;
import org.simpleframework.xml.core.AnnotationHandler;

/* loaded from: classes5.dex */
public final class NativeNumber extends IdScriptableObject {
    public static final int ConstructorId_isFinite = -1;
    public static final int ConstructorId_isInteger = -3;
    public static final int ConstructorId_isNaN = -2;
    public static final int ConstructorId_isSafeInteger = -4;
    public static final int ConstructorId_parseFloat = -5;
    public static final int ConstructorId_parseInt = -6;
    public static final int Id_constructor = 1;
    public static final int Id_toExponential = 7;
    public static final int Id_toFixed = 6;
    public static final int Id_toLocaleString = 3;
    public static final int Id_toPrecision = 8;
    public static final int Id_toSource = 4;
    public static final int Id_toString = 2;
    public static final int Id_valueOf = 5;
    public static final int MAX_PRECISION = 100;
    public static final int MAX_PROTOTYPE_ID = 8;
    public static final double MAX_SAFE_INTEGER = 9.007199254740991E15d;
    public static final double MIN_SAFE_INTEGER = -9.007199254740991E15d;
    public static final Object NUMBER_TAG = "Number";
    public static final long serialVersionUID = 3504516769741512101L;
    public double doubleValue;

    public NativeNumber(double d) {
        this.doubleValue = d;
    }

    private Double doubleVal(Number number) {
        return number instanceof Double ? (Double) number : Double.valueOf(number.doubleValue());
    }

    private Object execConstructorCall(int i, Object[] objArr) {
        switch (i) {
            case -6:
                return NativeGlobal.js_parseInt(objArr);
            case -5:
                return NativeGlobal.js_parseFloat(objArr);
            case -4:
                if (objArr.length != 0 && Undefined.instance != objArr[0] && (objArr[0] instanceof Number)) {
                    return Boolean.valueOf(isSafeInteger((Number) objArr[0]));
                }
                return false;
            case -3:
                if (objArr.length != 0 && Undefined.instance != objArr[0] && (objArr[0] instanceof Number)) {
                    return Boolean.valueOf(isInteger((Number) objArr[0]));
                }
                return false;
            case -2:
                if (objArr.length != 0 && Undefined.instance != objArr[0] && (objArr[0] instanceof Number)) {
                    return isNaN((Number) objArr[0]);
                }
                return false;
            case -1:
                if (objArr.length != 0 && Undefined.instance != objArr[0] && (objArr[0] instanceof Number)) {
                    return isFinite(objArr[0]);
                }
                return false;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
    }

    public static void init(Scriptable scriptable, boolean z) {
        new NativeNumber(RoundRectDrawableWithShadow.COS_45).exportAsJSClass(8, scriptable, z);
    }

    private boolean isDoubleInteger(Double d) {
        return !d.isInfinite() && !d.isNaN() && Math.floor(d.doubleValue()) == d.doubleValue();
    }

    private boolean isDoubleNan(Double d) {
        return d.isNaN();
    }

    private boolean isDoubleSafeInteger(Double d) {
        return isDoubleInteger(d) && d.doubleValue() <= 9.007199254740991E15d && d.doubleValue() >= -9.007199254740991E15d;
    }

    public static Object isFinite(Object obj) {
        Double valueOf = Double.valueOf(ScriptRuntime.toNumber(obj));
        return ScriptRuntime.wrapBoolean(!valueOf.isInfinite() && !valueOf.isNaN());
    }

    private boolean isInteger(Number number) {
        return ScriptRuntime.toBoolean(Boolean.valueOf(isDoubleInteger(doubleVal(number))));
    }

    private Object isNaN(Number number) {
        return Boolean.valueOf(ScriptRuntime.toBoolean(Boolean.valueOf(isDoubleNan(doubleVal(number)))));
    }

    private boolean isSafeInteger(Number number) {
        return ScriptRuntime.toBoolean(Boolean.valueOf(isDoubleSafeInteger(doubleVal(number))));
    }

    public static String num_to(double d, Object[] objArr, int i, int i2, int i3, int i4) {
        int i5 = 0;
        if (objArr.length != 0) {
            double integer = ScriptRuntime.toInteger(objArr[0]);
            if (integer < i3 || integer > 100.0d) {
                throw ScriptRuntime.constructError("RangeError", ScriptRuntime.getMessage1("msg.bad.precision", ScriptRuntime.toString(objArr[0])));
            }
            i5 = ScriptRuntime.toInt32(integer);
            i = i2;
        }
        StringBuilder sb = new StringBuilder();
        DToA.JS_dtostr(sb, i, i5 + i4, d);
        return sb.toString();
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(NUMBER_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int methodId = idFunctionObject.methodId();
        double d = RoundRectDrawableWithShadow.COS_45;
        if (methodId == 1) {
            if (objArr.length >= 1) {
                d = ScriptRuntime.toNumber(objArr[0]);
            }
            return scriptable2 == null ? new NativeNumber(d) : ScriptRuntime.wrapNumber(d);
        } else if (methodId < 1) {
            return execConstructorCall(methodId, objArr);
        } else {
            if (!(scriptable2 instanceof NativeNumber)) {
                throw IdScriptableObject.incompatibleCallError(idFunctionObject);
            }
            double d2 = ((NativeNumber) scriptable2).doubleValue;
            int i = 10;
            switch (methodId) {
                case 2:
                case 3:
                    if (objArr.length != 0 && objArr[0] != Undefined.instance) {
                        i = ScriptRuntime.toInt32(objArr[0]);
                    }
                    return ScriptRuntime.numberToString(d2, i);
                case 4:
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("(new Number(");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(ScriptRuntime.toString(d2));
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("))");
                    return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
                case 5:
                    return ScriptRuntime.wrapNumber(d2);
                case 6:
                    return num_to(d2, objArr, 2, 2, -20, 0);
                case 7:
                    return Double.isNaN(d2) ? "NaN" : Double.isInfinite(d2) ? d2 >= RoundRectDrawableWithShadow.COS_45 ? "Infinity" : "-Infinity" : num_to(d2, objArr, 1, 3, 0, 1);
                case 8:
                    return (objArr.length == 0 || objArr[0] == Undefined.instance) ? ScriptRuntime.numberToString(d2, 10) : Double.isNaN(d2) ? "NaN" : Double.isInfinite(d2) ? d2 >= RoundRectDrawableWithShadow.COS_45 ? "Infinity" : "-Infinity" : num_to(d2, objArr, 0, 4, 1, 0);
                default:
                    throw new IllegalArgumentException(String.valueOf(methodId));
            }
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void fillConstructorProperties(IdFunctionObject idFunctionObject) {
        idFunctionObject.defineProperty("NaN", ScriptRuntime.NaNobj, 7);
        idFunctionObject.defineProperty("POSITIVE_INFINITY", ScriptRuntime.wrapNumber(Double.POSITIVE_INFINITY), 7);
        idFunctionObject.defineProperty("NEGATIVE_INFINITY", ScriptRuntime.wrapNumber(Double.NEGATIVE_INFINITY), 7);
        idFunctionObject.defineProperty("MAX_VALUE", ScriptRuntime.wrapNumber(Double.MAX_VALUE), 7);
        idFunctionObject.defineProperty("MIN_VALUE", ScriptRuntime.wrapNumber(Double.MIN_VALUE), 7);
        idFunctionObject.defineProperty("MAX_SAFE_INTEGER", ScriptRuntime.wrapNumber(9.007199254740991E15d), 7);
        idFunctionObject.defineProperty("MIN_SAFE_INTEGER", ScriptRuntime.wrapNumber(-9.007199254740991E15d), 7);
        addIdFunctionProperty(idFunctionObject, NUMBER_TAG, -1, "isFinite", 1);
        addIdFunctionProperty(idFunctionObject, NUMBER_TAG, -2, "isNaN", 1);
        addIdFunctionProperty(idFunctionObject, NUMBER_TAG, -3, "isInteger", 1);
        addIdFunctionProperty(idFunctionObject, NUMBER_TAG, -4, "isSafeInteger", 1);
        addIdFunctionProperty(idFunctionObject, NUMBER_TAG, -5, "parseFloat", 1);
        addIdFunctionProperty(idFunctionObject, NUMBER_TAG, -6, "parseInt", 1);
        super.fillConstructorProperties(idFunctionObject);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(String str) {
        String str2;
        int length = str.length();
        int i = 3;
        if (length == 7) {
            char charAt = str.charAt(0);
            if (charAt == 't') {
                i = 6;
                str2 = "toFixed";
            } else {
                if (charAt == 'v') {
                    i = 5;
                    str2 = "valueOf";
                }
                str2 = null;
                i = 0;
            }
        } else if (length == 8) {
            char charAt2 = str.charAt(3);
            if (charAt2 == 'o') {
                i = 4;
                str2 = "toSource";
            } else {
                if (charAt2 == 't') {
                    i = 2;
                    str2 = AnnotationHandler.STRING;
                }
                str2 = null;
                i = 0;
            }
        } else if (length == 11) {
            char charAt3 = str.charAt(0);
            if (charAt3 == 'c') {
                i = 1;
                str2 = "constructor";
            } else {
                if (charAt3 == 't') {
                    str2 = "toPrecision";
                    i = 8;
                }
                str2 = null;
                i = 0;
            }
        } else if (length != 13) {
            if (length == 14) {
                str2 = "toLocaleString";
            }
            str2 = null;
            i = 0;
        } else {
            str2 = "toExponential";
            i = 7;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Number";
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i) {
        String str;
        String str2;
        int i2 = 1;
        switch (i) {
            case 1:
                str = "constructor";
                break;
            case 2:
                str = AnnotationHandler.STRING;
                break;
            case 3:
                str = "toLocaleString";
                break;
            case 4:
                str2 = "toSource";
                str = str2;
                i2 = 0;
                break;
            case 5:
                str2 = "valueOf";
                str = str2;
                i2 = 0;
                break;
            case 6:
                str = "toFixed";
                break;
            case 7:
                str = "toExponential";
                break;
            case 8:
                str = "toPrecision";
                break;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
        initPrototypeMethod(NUMBER_TAG, i, str, i2);
    }

    public String toString() {
        return ScriptRuntime.numberToString(this.doubleValue, 10);
    }
}
