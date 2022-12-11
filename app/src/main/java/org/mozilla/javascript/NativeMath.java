package org.mozilla.javascript;

import androidx.cardview.widget.RoundRectDrawableWithShadow;
import androidx.exifinterface.media.ExifInterface;

/* loaded from: classes5.dex */
public final class NativeMath extends IdScriptableObject {
    public static final int Id_E = 37;
    public static final int Id_LN10 = 39;
    public static final int Id_LN2 = 40;
    public static final int Id_LOG10E = 42;
    public static final int Id_LOG2E = 41;
    public static final int Id_PI = 38;
    public static final int Id_SQRT1_2 = 43;
    public static final int Id_SQRT2 = 44;
    public static final int Id_abs = 2;
    public static final int Id_acos = 3;
    public static final int Id_acosh = 30;
    public static final int Id_asin = 4;
    public static final int Id_asinh = 31;
    public static final int Id_atan = 5;
    public static final int Id_atan2 = 6;
    public static final int Id_atanh = 32;
    public static final int Id_cbrt = 20;
    public static final int Id_ceil = 7;
    public static final int Id_clz32 = 36;
    public static final int Id_cos = 8;
    public static final int Id_cosh = 21;
    public static final int Id_exp = 9;
    public static final int Id_expm1 = 22;
    public static final int Id_floor = 10;
    public static final int Id_fround = 35;
    public static final int Id_hypot = 23;
    public static final int Id_imul = 28;
    public static final int Id_log = 11;
    public static final int Id_log10 = 25;
    public static final int Id_log1p = 24;
    public static final int Id_log2 = 34;
    public static final int Id_max = 12;
    public static final int Id_min = 13;
    public static final int Id_pow = 14;
    public static final int Id_random = 15;
    public static final int Id_round = 16;
    public static final int Id_sign = 33;
    public static final int Id_sin = 17;
    public static final int Id_sinh = 26;
    public static final int Id_sqrt = 18;
    public static final int Id_tan = 19;
    public static final int Id_tanh = 27;
    public static final int Id_toSource = 1;
    public static final int Id_trunc = 29;
    public static final int LAST_METHOD_ID = 36;
    public static final double LOG2E = 1.4426950408889634d;
    public static final Object MATH_TAG = "Math";
    public static final int MAX_ID = 44;
    public static final long serialVersionUID = -8838847185801131569L;

    public static void init(Scriptable scriptable, boolean z) {
        NativeMath nativeMath = new NativeMath();
        nativeMath.activatePrototypeMap(44);
        nativeMath.setPrototype(ScriptableObject.getObjectPrototype(scriptable));
        nativeMath.setParentScope(scriptable);
        if (z) {
            nativeMath.sealObject();
        }
        ScriptableObject.defineProperty(scriptable, "Math", nativeMath, 2);
    }

    public static double js_hypot(Object[] objArr) {
        double d = RoundRectDrawableWithShadow.COS_45;
        if (objArr == null) {
            return RoundRectDrawableWithShadow.COS_45;
        }
        for (Object obj : objArr) {
            double number = ScriptRuntime.toNumber(obj);
            if (number == ScriptRuntime.NaN) {
                return number;
            }
            if (number == Double.POSITIVE_INFINITY || number == Double.NEGATIVE_INFINITY) {
                return Double.POSITIVE_INFINITY;
            }
            d += number * number;
        }
        return Math.sqrt(d);
    }

    public static int js_imul(Object[] objArr) {
        if (objArr == null) {
            return 0;
        }
        return ScriptRuntime.toInt32(objArr, 1) * ScriptRuntime.toInt32(objArr, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0062, code lost:
        if (r22 < 1.0d) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x007b, code lost:
        if (r22 < 1.0d) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0085, code lost:
        if (r8 > 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x009f, code lost:
        if (r8 > 0) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static double js_pow(double d, double d2) {
        double d3 = Double.POSITIVE_INFINITY;
        if (d2 != d2) {
            return d2;
        }
        int i = (d2 > RoundRectDrawableWithShadow.COS_45 ? 1 : (d2 == RoundRectDrawableWithShadow.COS_45 ? 0 : -1));
        if (i == 0) {
            return 1.0d;
        }
        double d4 = -0.0d;
        double d5 = Double.NEGATIVE_INFINITY;
        if (d != RoundRectDrawableWithShadow.COS_45) {
            double pow = Math.pow(d, d2);
            if (pow != pow) {
                if (d2 == Double.POSITIVE_INFINITY) {
                    if (d >= -1.0d && 1.0d >= d) {
                        if (-1.0d < d) {
                        }
                    }
                } else if (d2 == Double.NEGATIVE_INFINITY) {
                    if (d >= -1.0d && 1.0d >= d) {
                        if (-1.0d < d) {
                        }
                    }
                    return RoundRectDrawableWithShadow.COS_45;
                } else if (d != Double.POSITIVE_INFINITY) {
                    if (d == Double.NEGATIVE_INFINITY) {
                        long j = (long) d2;
                        if (j == d2 && (j & 1) != 0) {
                            if (i <= 0) {
                                d5 = -0.0d;
                            }
                            return d5;
                        }
                    }
                }
            }
            return pow;
        } else if (1.0d / d <= RoundRectDrawableWithShadow.COS_45) {
            long j2 = (long) d2;
            if (j2 == d2 && (j2 & 1) != 0) {
                if (i <= 0) {
                    d4 = Double.NEGATIVE_INFINITY;
                }
                d3 = d4;
            } else if (i > 0) {
                d3 = RoundRectDrawableWithShadow.COS_45;
            }
        } else if (i > 0) {
            d3 = 0.0d;
        }
        return d3;
    }

    public static double js_trunc(double d) {
        return d < RoundRectDrawableWithShadow.COS_45 ? Math.ceil(d) : Math.floor(d);
    }

    /* JADX WARN: Code restructure failed: missing block: B:122:0x01fb, code lost:
        if (r17 != androidx.cardview.widget.RoundRectDrawableWithShadow.COS_45) goto L123;
     */
    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        double number;
        long uint32;
        if (!idFunctionObject.hasTag(MATH_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int methodId = idFunctionObject.methodId();
        double d = Double.NEGATIVE_INFINITY;
        double d2 = Double.NaN;
        int i = 0;
        switch (methodId) {
            case 1:
                return "Math";
            case 2:
                number = ScriptRuntime.toNumber(objArr, 0);
                if (number != RoundRectDrawableWithShadow.COS_45) {
                    if (number < RoundRectDrawableWithShadow.COS_45) {
                        number = -number;
                    }
                    d2 = number;
                    break;
                }
                d2 = 0.0d;
                break;
            case 3:
            case 4:
                double number2 = ScriptRuntime.toNumber(objArr, 0);
                if (number2 == number2 && -1.0d <= number2 && number2 <= 1.0d) {
                    number = methodId == 3 ? Math.acos(number2) : Math.asin(number2);
                    d2 = number;
                    break;
                }
                break;
            case 5:
                d2 = Math.atan(ScriptRuntime.toNumber(objArr, 0));
                break;
            case 6:
                d2 = Math.atan2(ScriptRuntime.toNumber(objArr, 0), ScriptRuntime.toNumber(objArr, 1));
                break;
            case 7:
                d2 = Math.ceil(ScriptRuntime.toNumber(objArr, 0));
                break;
            case 8:
                double number3 = ScriptRuntime.toNumber(objArr, 0);
                if (number3 != Double.POSITIVE_INFINITY && number3 != Double.NEGATIVE_INFINITY) {
                    number = Math.cos(number3);
                    d2 = number;
                    break;
                }
                break;
            case 9:
                number = ScriptRuntime.toNumber(objArr, 0);
                if (number != Double.POSITIVE_INFINITY) {
                    if (number != Double.NEGATIVE_INFINITY) {
                        number = Math.exp(number);
                    }
                    d2 = 0.0d;
                    break;
                }
                d2 = number;
                break;
            case 10:
                d2 = Math.floor(ScriptRuntime.toNumber(objArr, 0));
                break;
            case 11:
                double number4 = ScriptRuntime.toNumber(objArr, 0);
                if (number4 >= RoundRectDrawableWithShadow.COS_45) {
                    number = Math.log(number4);
                    d2 = number;
                    break;
                }
                break;
            case 12:
            case 13:
                if (methodId != 12) {
                    d = Double.POSITIVE_INFINITY;
                }
                while (true) {
                    if (i == objArr.length) {
                        d2 = d;
                        break;
                    } else {
                        double number5 = ScriptRuntime.toNumber(objArr[i]);
                        if (number5 != number5) {
                            d2 = number5;
                            break;
                        } else {
                            d = methodId == 12 ? Math.max(d, number5) : Math.min(d, number5);
                            i++;
                        }
                    }
                }
            case 14:
                d2 = js_pow(ScriptRuntime.toNumber(objArr, 0), ScriptRuntime.toNumber(objArr, 1));
                break;
            case 15:
                d2 = Math.random();
                break;
            case 16:
                d2 = ScriptRuntime.toNumber(objArr, 0);
                if (d2 == d2 && d2 != Double.POSITIVE_INFINITY && d2 != Double.NEGATIVE_INFINITY) {
                    long round = Math.round(d2);
                    if (round == 0) {
                        if (d2 >= RoundRectDrawableWithShadow.COS_45) {
                            break;
                        } else {
                            number = ScriptRuntime.negativeZero;
                        }
                    } else {
                        number = round;
                    }
                    d2 = number;
                    break;
                }
                break;
            case 17:
                double number6 = ScriptRuntime.toNumber(objArr, 0);
                if (number6 != Double.POSITIVE_INFINITY && number6 != Double.NEGATIVE_INFINITY) {
                    number = Math.sin(number6);
                    d2 = number;
                    break;
                }
                break;
            case 18:
                d2 = Math.sqrt(ScriptRuntime.toNumber(objArr, 0));
                break;
            case 19:
                d2 = Math.tan(ScriptRuntime.toNumber(objArr, 0));
                break;
            case 20:
                d2 = Math.cbrt(ScriptRuntime.toNumber(objArr, 0));
                break;
            case 21:
                d2 = Math.cosh(ScriptRuntime.toNumber(objArr, 0));
                break;
            case 22:
                d2 = Math.expm1(ScriptRuntime.toNumber(objArr, 0));
                break;
            case 23:
                d2 = js_hypot(objArr);
                break;
            case 24:
                d2 = Math.log1p(ScriptRuntime.toNumber(objArr, 0));
                break;
            case 25:
                d2 = Math.log10(ScriptRuntime.toNumber(objArr, 0));
                break;
            case 26:
                d2 = Math.sinh(ScriptRuntime.toNumber(objArr, 0));
                break;
            case 27:
                d2 = Math.tanh(ScriptRuntime.toNumber(objArr, 0));
                break;
            case 28:
                return Integer.valueOf(js_imul(objArr));
            case 29:
                d2 = js_trunc(ScriptRuntime.toNumber(objArr, 0));
                break;
            case 30:
                double number7 = ScriptRuntime.toNumber(objArr, 0);
                return number7 == number7 ? Double.valueOf(Math.log(Math.sqrt((number7 * number7) - 1.0d) + number7)) : Double.valueOf(Double.NaN);
            case 31:
                double number8 = ScriptRuntime.toNumber(objArr, 0);
                return (number8 == Double.POSITIVE_INFINITY || number8 == Double.NEGATIVE_INFINITY) ? Double.valueOf(number8) : number8 == number8 ? number8 == RoundRectDrawableWithShadow.COS_45 ? 1.0d / number8 > RoundRectDrawableWithShadow.COS_45 ? Double.valueOf((double) RoundRectDrawableWithShadow.COS_45) : Double.valueOf(-0.0d) : Double.valueOf(Math.log(Math.sqrt((number8 * number8) + 1.0d) + number8)) : Double.valueOf(Double.NaN);
            case 32:
                double number9 = ScriptRuntime.toNumber(objArr, 0);
                return (number9 != number9 || -1.0d > number9 || number9 > 1.0d) ? Double.valueOf(Double.NaN) : number9 == RoundRectDrawableWithShadow.COS_45 ? 1.0d / number9 > RoundRectDrawableWithShadow.COS_45 ? Double.valueOf((double) RoundRectDrawableWithShadow.COS_45) : Double.valueOf(-0.0d) : Double.valueOf(Math.log((number9 + 1.0d) / (number9 - 1.0d)) * 0.5d);
            case 33:
                double number10 = ScriptRuntime.toNumber(objArr, 0);
                return number10 == number10 ? number10 == RoundRectDrawableWithShadow.COS_45 ? 1.0d / number10 > RoundRectDrawableWithShadow.COS_45 ? Double.valueOf((double) RoundRectDrawableWithShadow.COS_45) : Double.valueOf(-0.0d) : Double.valueOf(Math.signum(number10)) : Double.valueOf(Double.NaN);
            case 34:
                double number11 = ScriptRuntime.toNumber(objArr, 0);
                if (number11 >= RoundRectDrawableWithShadow.COS_45) {
                    number = Math.log(number11) * 1.4426950408889634d;
                    d2 = number;
                    break;
                }
                break;
            case 35:
                number = (float) ScriptRuntime.toNumber(objArr, 0);
                d2 = number;
                break;
            case 36:
                double number12 = ScriptRuntime.toNumber(objArr, 0);
                if (number12 == RoundRectDrawableWithShadow.COS_45 || number12 != number12 || number12 == Double.POSITIVE_INFINITY || number12 == Double.NEGATIVE_INFINITY) {
                    return 32;
                }
                if (ScriptRuntime.toUint32(number12) != 0) {
                    return Double.valueOf(31.0d - Math.floor(Math.log(uint32 >>> 0) * 1.4426950408889634d));
                }
                return 32;
            default:
                throw new IllegalStateException(String.valueOf(methodId));
        }
        return ScriptRuntime.wrapNumber(d2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(String str) {
        String str2;
        int i = 4;
        switch (str.length()) {
            case 1:
                if (str.charAt(0) == 'E') {
                    return 37;
                }
                str2 = null;
                i = 0;
                break;
            case 2:
                if (str.charAt(0) == 'P' && str.charAt(1) == 'I') {
                    return 38;
                }
                str2 = null;
                i = 0;
                break;
            case 3:
                char charAt = str.charAt(0);
                if (charAt != 'L') {
                    if (charAt != 'a') {
                        if (charAt != 'c') {
                            if (charAt != 'e') {
                                if (charAt != 'p') {
                                    if (charAt != 'l') {
                                        if (charAt == 'm') {
                                            char charAt2 = str.charAt(2);
                                            if (charAt2 == 'n') {
                                                if (str.charAt(1) == 'i') {
                                                    return 13;
                                                }
                                            } else if (charAt2 == 'x' && str.charAt(1) == 'a') {
                                                return 12;
                                            }
                                        } else if (charAt != 's') {
                                            if (charAt == 't' && str.charAt(2) == 'n' && str.charAt(1) == 'a') {
                                                return 19;
                                            }
                                        } else if (str.charAt(2) == 'n' && str.charAt(1) == 'i') {
                                            return 17;
                                        }
                                    } else if (str.charAt(2) == 'g' && str.charAt(1) == 'o') {
                                        return 11;
                                    }
                                } else if (str.charAt(2) == 'w' && str.charAt(1) == 'o') {
                                    return 14;
                                }
                            } else if (str.charAt(2) == 'p' && str.charAt(1) == 'x') {
                                return 9;
                            }
                        } else if (str.charAt(2) == 's' && str.charAt(1) == 'o') {
                            return 8;
                        }
                    } else if (str.charAt(2) == 's' && str.charAt(1) == 'b') {
                        return 2;
                    }
                } else if (str.charAt(2) == '2' && str.charAt(1) == 'N') {
                    return 40;
                }
                str2 = null;
                i = 0;
                break;
            case 4:
                char charAt3 = str.charAt(1);
                if (charAt3 == 'N') {
                    i = 39;
                    str2 = "LN10";
                    break;
                } else if (charAt3 == 'e') {
                    i = 7;
                    str2 = "ceil";
                    break;
                } else {
                    if (charAt3 == 'i') {
                        char charAt4 = str.charAt(3);
                        if (charAt4 == 'h') {
                            if (str.charAt(0) == 's' && str.charAt(2) == 'n') {
                                return 26;
                            }
                        } else if (charAt4 == 'n' && str.charAt(0) == 's' && str.charAt(2) == 'g') {
                            return 33;
                        }
                    } else if (charAt3 == 'm') {
                        i = 28;
                        str2 = "imul";
                        break;
                    } else if (charAt3 == 'o') {
                        char charAt5 = str.charAt(0);
                        if (charAt5 == 'c') {
                            if (str.charAt(2) == 's' && str.charAt(3) == 'h') {
                                return 21;
                            }
                        } else if (charAt5 == 'l' && str.charAt(2) == 'g' && str.charAt(3) == '2') {
                            return 34;
                        }
                    } else if (charAt3 == 'q') {
                        i = 18;
                        str2 = "sqrt";
                        break;
                    } else if (charAt3 == 's') {
                        str2 = "asin";
                        break;
                    } else if (charAt3 == 't') {
                        i = 5;
                        str2 = "atan";
                        break;
                    } else {
                        switch (charAt3) {
                            case 'a':
                                i = 27;
                                str2 = "tanh";
                                break;
                            case 'b':
                                i = 20;
                                str2 = "cbrt";
                                break;
                            case 'c':
                                str2 = "acos";
                                i = 3;
                                break;
                        }
                    }
                    str2 = null;
                    i = 0;
                    break;
                }
                break;
            case 5:
                char charAt6 = str.charAt(0);
                if (charAt6 == 'L') {
                    i = 41;
                    str2 = "LOG2E";
                    break;
                } else if (charAt6 == 'S') {
                    i = 44;
                    str2 = "SQRT2";
                    break;
                } else if (charAt6 == 'a') {
                    char charAt7 = str.charAt(1);
                    if (charAt7 == 'c') {
                        i = 30;
                        str2 = "acosh";
                        break;
                    } else if (charAt7 == 's') {
                        i = 31;
                        str2 = "asinh";
                        break;
                    } else {
                        if (charAt7 == 't') {
                            char charAt8 = str.charAt(4);
                            if (charAt8 == '2') {
                                if (str.charAt(2) == 'a' && str.charAt(3) == 'n') {
                                    return 6;
                                }
                            } else if (charAt8 == 'h' && str.charAt(2) == 'a' && str.charAt(3) == 'n') {
                                return 32;
                            }
                        }
                        str2 = null;
                        i = 0;
                    }
                } else if (charAt6 == 'c') {
                    i = 36;
                    str2 = "clz32";
                    break;
                } else if (charAt6 == 'h') {
                    i = 23;
                    str2 = "hypot";
                    break;
                } else if (charAt6 == 'l') {
                    char charAt9 = str.charAt(4);
                    if (charAt9 == '0') {
                        i = 25;
                        str2 = "log10";
                        break;
                    } else {
                        if (charAt9 == 'p') {
                            i = 24;
                            str2 = "log1p";
                            break;
                        }
                        str2 = null;
                        i = 0;
                    }
                } else if (charAt6 == 'r') {
                    i = 16;
                    str2 = "round";
                    break;
                } else if (charAt6 == 't') {
                    i = 29;
                    str2 = "trunc";
                    break;
                } else if (charAt6 == 'e') {
                    i = 22;
                    str2 = "expm1";
                    break;
                } else {
                    if (charAt6 == 'f') {
                        i = 10;
                        str2 = "floor";
                        break;
                    }
                    str2 = null;
                    i = 0;
                    break;
                }
                break;
            case 6:
                char charAt10 = str.charAt(0);
                if (charAt10 != 'L') {
                    if (charAt10 != 'f') {
                        if (charAt10 == 'r') {
                            i = 15;
                            str2 = "random";
                            break;
                        }
                        str2 = null;
                        i = 0;
                        break;
                    } else {
                        i = 35;
                        str2 = "fround";
                        break;
                    }
                } else {
                    i = 42;
                    str2 = "LOG10E";
                    break;
                }
            case 7:
                i = 43;
                str2 = "SQRT1_2";
                break;
            case 8:
                str2 = "toSource";
                i = 1;
                break;
            default:
                str2 = null;
                i = 0;
                break;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Math";
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i) {
        double d;
        String str;
        String str2;
        String str3;
        if (i > 36) {
            switch (i) {
                case 37:
                    d = 2.718281828459045d;
                    str = ExifInterface.LONGITUDE_EAST;
                    break;
                case 38:
                    d = 3.141592653589793d;
                    str = "PI";
                    break;
                case 39:
                    d = 2.302585092994046d;
                    str = "LN10";
                    break;
                case 40:
                    d = 0.6931471805599453d;
                    str = "LN2";
                    break;
                case 41:
                    d = 1.4426950408889634d;
                    str = "LOG2E";
                    break;
                case 42:
                    d = 0.4342944819032518d;
                    str = "LOG10E";
                    break;
                case 43:
                    d = 0.7071067811865476d;
                    str = "SQRT1_2";
                    break;
                case 44:
                    d = 1.4142135623730951d;
                    str = "SQRT2";
                    break;
                default:
                    throw new IllegalStateException(String.valueOf(i));
            }
            initPrototypeValue(i, str, ScriptRuntime.wrapNumber(d), 7);
            return;
        }
        int i2 = 1;
        switch (i) {
            case 1:
                str2 = "toSource";
                str3 = str2;
                i2 = 0;
                break;
            case 2:
                str3 = "abs";
                break;
            case 3:
                str3 = "acos";
                break;
            case 4:
                str3 = "asin";
                break;
            case 5:
                str3 = "atan";
                break;
            case 6:
                str3 = "atan2";
                i2 = 2;
                break;
            case 7:
                str3 = "ceil";
                break;
            case 8:
                str3 = "cos";
                break;
            case 9:
                str3 = "exp";
                break;
            case 10:
                str3 = "floor";
                break;
            case 11:
                str3 = "log";
                break;
            case 12:
                str3 = "max";
                i2 = 2;
                break;
            case 13:
                str3 = "min";
                i2 = 2;
                break;
            case 14:
                str3 = "pow";
                i2 = 2;
                break;
            case 15:
                str2 = "random";
                str3 = str2;
                i2 = 0;
                break;
            case 16:
                str3 = "round";
                break;
            case 17:
                str3 = "sin";
                break;
            case 18:
                str3 = "sqrt";
                break;
            case 19:
                str3 = "tan";
                break;
            case 20:
                str3 = "cbrt";
                break;
            case 21:
                str3 = "cosh";
                break;
            case 22:
                str3 = "expm1";
                break;
            case 23:
                str3 = "hypot";
                i2 = 2;
                break;
            case 24:
                str3 = "log1p";
                break;
            case 25:
                str3 = "log10";
                break;
            case 26:
                str3 = "sinh";
                break;
            case 27:
                str3 = "tanh";
                break;
            case 28:
                str3 = "imul";
                i2 = 2;
                break;
            case 29:
                str3 = "trunc";
                break;
            case 30:
                str3 = "acosh";
                break;
            case 31:
                str3 = "asinh";
                break;
            case 32:
                str3 = "atanh";
                break;
            case 33:
                str3 = "sign";
                break;
            case 34:
                str3 = "log2";
                break;
            case 35:
                str3 = "fround";
                break;
            case 36:
                str3 = "clz32";
                break;
            default:
                throw new IllegalStateException(String.valueOf(i));
        }
        initPrototypeMethod(MATH_TAG, i, str3, i2);
    }
}
