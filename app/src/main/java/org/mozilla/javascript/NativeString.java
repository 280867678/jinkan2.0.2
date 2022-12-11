package org.mozilla.javascript;

import androidx.cardview.widget.RoundRectDrawableWithShadow;
import com.umeng.analytics.pro.C1543ak;
import java.text.Collator;
import java.text.Normalizer;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.message.TokenParser;
import org.mozilla.javascript.regexp.NativeRegExp;
import org.simpleframework.xml.core.AnnotationHandler;
import org.simpleframework.xml.strategy.Name;

/* loaded from: classes5.dex */
public final class NativeString extends IdScriptableObject {
    public static final int ConstructorId_charAt = -5;
    public static final int ConstructorId_charCodeAt = -6;
    public static final int ConstructorId_concat = -14;
    public static final int ConstructorId_equalsIgnoreCase = -30;
    public static final int ConstructorId_fromCharCode = -1;
    public static final int ConstructorId_indexOf = -7;
    public static final int ConstructorId_lastIndexOf = -8;
    public static final int ConstructorId_localeCompare = -34;
    public static final int ConstructorId_match = -31;
    public static final int ConstructorId_replace = -33;
    public static final int ConstructorId_search = -32;
    public static final int ConstructorId_slice = -15;
    public static final int ConstructorId_split = -9;
    public static final int ConstructorId_substr = -13;
    public static final int ConstructorId_substring = -10;
    public static final int ConstructorId_toLocaleLowerCase = -35;
    public static final int ConstructorId_toLowerCase = -11;
    public static final int ConstructorId_toUpperCase = -12;
    public static final int Id_anchor = 28;
    public static final int Id_big = 21;
    public static final int Id_blink = 22;
    public static final int Id_bold = 16;
    public static final int Id_charAt = 5;
    public static final int Id_charCodeAt = 6;
    public static final int Id_codePointAt = 45;
    public static final int Id_concat = 14;
    public static final int Id_constructor = 1;
    public static final int Id_endsWith = 42;
    public static final int Id_equals = 29;
    public static final int Id_equalsIgnoreCase = 30;
    public static final int Id_fixed = 18;
    public static final int Id_fontcolor = 26;
    public static final int Id_fontsize = 25;
    public static final int Id_includes = 40;
    public static final int Id_indexOf = 7;
    public static final int Id_italics = 17;
    public static final int Id_lastIndexOf = 8;
    public static final int Id_length = 1;
    public static final int Id_link = 27;
    public static final int Id_localeCompare = 34;
    public static final int Id_match = 31;
    public static final int Id_normalize = 43;
    public static final int Id_padEnd = 47;
    public static final int Id_padStart = 46;
    public static final int Id_repeat = 44;
    public static final int Id_replace = 33;
    public static final int Id_search = 32;
    public static final int Id_slice = 15;
    public static final int Id_small = 20;
    public static final int Id_split = 9;
    public static final int Id_startsWith = 41;
    public static final int Id_strike = 19;
    public static final int Id_sub = 24;
    public static final int Id_substr = 13;
    public static final int Id_substring = 10;
    public static final int Id_sup = 23;
    public static final int Id_toLocaleLowerCase = 35;
    public static final int Id_toLocaleUpperCase = 36;
    public static final int Id_toLowerCase = 11;
    public static final int Id_toSource = 3;
    public static final int Id_toString = 2;
    public static final int Id_toUpperCase = 12;
    public static final int Id_trim = 37;
    public static final int Id_trimLeft = 38;
    public static final int Id_trimRight = 39;
    public static final int Id_valueOf = 4;
    public static final int MAX_INSTANCE_ID = 1;
    public static final int MAX_PROTOTYPE_ID = 48;
    public static final Object STRING_TAG = "String";
    public static final int SymbolId_iterator = 48;
    public static final long serialVersionUID = 920268368584188687L;
    public CharSequence string;

    public NativeString(CharSequence charSequence) {
        this.string = charSequence;
    }

    public static void init(Scriptable scriptable, boolean z) {
        new NativeString("").exportAsJSClass(48, scriptable, z);
    }

    public static String js_concat(String str, Object[] objArr) {
        int length = objArr.length;
        if (length == 0) {
            return str;
        }
        if (length == 1) {
            return str.concat(ScriptRuntime.toString(objArr[0]));
        }
        int length2 = str.length();
        String[] strArr = new String[length];
        for (int i = 0; i != length; i++) {
            String scriptRuntime = ScriptRuntime.toString(objArr[i]);
            strArr[i] = scriptRuntime;
            length2 += scriptRuntime.length();
        }
        StringBuilder sb = new StringBuilder(length2);
        sb.append(str);
        for (int i2 = 0; i2 != length; i2++) {
            sb.append(strArr[i2]);
        }
        return sb.toString();
    }

    public static int js_indexOf(int i, String str, Object[] objArr) {
        String scriptRuntime = ScriptRuntime.toString(objArr, 0);
        double integer = ScriptRuntime.toInteger(objArr, 1);
        if (integer <= str.length() || i == 41 || i == 42) {
            if (integer < RoundRectDrawableWithShadow.COS_45) {
                integer = 0.0d;
            } else if (integer > str.length() || (i == 42 && (integer != integer || integer > str.length()))) {
                integer = str.length();
            }
            if (42 != i) {
                return i == 41 ? str.startsWith(scriptRuntime, (int) integer) ? 0 : -1 : str.indexOf(scriptRuntime, (int) integer);
            }
            if (objArr.length == 0 || objArr.length == 1 || (objArr.length == 2 && objArr[1] == Undefined.instance)) {
                integer = str.length();
            }
            return str.substring(0, (int) integer).endsWith(scriptRuntime) ? 0 : -1;
        }
        return -1;
    }

    public static int js_lastIndexOf(String str, Object[] objArr) {
        String scriptRuntime = ScriptRuntime.toString(objArr, 0);
        double number = ScriptRuntime.toNumber(objArr, 1);
        if (number != number || number > str.length()) {
            number = str.length();
        } else if (number < RoundRectDrawableWithShadow.COS_45) {
            number = 0.0d;
        }
        return str.lastIndexOf(scriptRuntime, (int) number);
    }

    public static String js_pad(Context context, Scriptable scriptable, IdFunctionObject idFunctionObject, Object[] objArr, Boolean bool) {
        String str;
        String scriptRuntime = ScriptRuntime.toString(ScriptRuntimeES6.requireObjectCoercible(context, scriptable, idFunctionObject));
        long length = ScriptRuntime.toLength(objArr, 0);
        if (length <= scriptRuntime.length()) {
            return scriptRuntime;
        }
        if (objArr.length < 2 || Undefined.isUndefined(objArr[1])) {
            str = StringUtils.SPACE;
        } else {
            str = ScriptRuntime.toString(objArr[1]);
            if (str.length() < 1) {
                return scriptRuntime;
            }
        }
        int length2 = (int) (length - scriptRuntime.length());
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(str);
        } while (sb.length() < length2);
        sb.setLength(length2);
        if (!bool.booleanValue()) {
            return sb.insert(0, scriptRuntime).toString();
        }
        sb.append(scriptRuntime);
        return sb.toString();
    }

    public static String js_repeat(Context context, Scriptable scriptable, IdFunctionObject idFunctionObject, Object[] objArr) {
        String scriptRuntime = ScriptRuntime.toString(ScriptRuntimeES6.requireObjectCoercible(context, scriptable, idFunctionObject));
        double integer = ScriptRuntime.toInteger(objArr, 0);
        if (integer < RoundRectDrawableWithShadow.COS_45 || integer == Double.POSITIVE_INFINITY) {
            throw ScriptRuntime.rangeError("Invalid count value");
        }
        if (integer == RoundRectDrawableWithShadow.COS_45 || scriptRuntime.length() == 0) {
            return "";
        }
        long length = scriptRuntime.length() * ((long) integer);
        if (integer > 2.147483647E9d || length > 2147483647L) {
            throw ScriptRuntime.rangeError("Invalid size or count value");
        }
        StringBuilder sb = new StringBuilder((int) length);
        sb.append(scriptRuntime);
        int i = 1;
        int i2 = (int) integer;
        while (i <= i2 / 2) {
            sb.append((CharSequence) sb);
            i *= 2;
        }
        if (i < i2) {
            sb.append(sb.substring(0, (i2 - i) * scriptRuntime.length()));
        }
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003e, code lost:
        if (r6 < androidx.cardview.widget.RoundRectDrawableWithShadow.COS_45) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0047, code lost:
        r2 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004a, code lost:
        if (r2 >= r4) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004c, code lost:
        r2 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0044, code lost:
        if (r6 > r2) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static CharSequence js_slice(CharSequence charSequence, Object[] objArr) {
        int length = objArr.length;
        double d = RoundRectDrawableWithShadow.COS_45;
        double integer = length < 1 ? 0.0d : ScriptRuntime.toInteger(objArr[0]);
        int length2 = charSequence.length();
        if (integer < RoundRectDrawableWithShadow.COS_45) {
            integer += length2;
            if (integer < RoundRectDrawableWithShadow.COS_45) {
                integer = 0.0d;
            }
        } else {
            double d2 = length2;
            if (integer > d2) {
                integer = d2;
            }
        }
        if (objArr.length < 2 || objArr[1] == Undefined.instance) {
            d = length2;
        } else {
            double integer2 = ScriptRuntime.toInteger(objArr[1]);
            if (integer2 < RoundRectDrawableWithShadow.COS_45) {
                integer2 += length2;
            } else {
                d = length2;
            }
        }
        return charSequence.subSequence((int) integer, (int) d);
    }

    public static CharSequence js_substr(CharSequence charSequence, Object[] objArr) {
        double d;
        if (objArr.length < 1) {
            return charSequence;
        }
        double integer = ScriptRuntime.toInteger(objArr[0]);
        int length = charSequence.length();
        double d2 = RoundRectDrawableWithShadow.COS_45;
        if (integer < RoundRectDrawableWithShadow.COS_45) {
            integer += length;
            if (integer < RoundRectDrawableWithShadow.COS_45) {
                integer = 0.0d;
            }
        } else {
            double d3 = length;
            if (integer > d3) {
                integer = d3;
            }
        }
        if (objArr.length == 1) {
            d = length;
        } else {
            double integer2 = ScriptRuntime.toInteger(objArr[1]);
            if (integer2 >= RoundRectDrawableWithShadow.COS_45) {
                d2 = integer2;
            }
            double d4 = d2 + integer;
            d = length;
            if (d4 <= d) {
                d = d4;
            }
        }
        return charSequence.subSequence((int) integer, (int) d);
    }

    public static CharSequence js_substring(Context context, CharSequence charSequence, Object[] objArr) {
        int length = charSequence.length();
        double integer = ScriptRuntime.toInteger(objArr, 0);
        double d = RoundRectDrawableWithShadow.COS_45;
        if (integer < RoundRectDrawableWithShadow.COS_45) {
            integer = 0.0d;
        } else {
            double d2 = length;
            if (integer > d2) {
                integer = d2;
            }
        }
        if (objArr.length <= 1 || objArr[1] == Undefined.instance) {
            d = length;
        } else {
            double integer2 = ScriptRuntime.toInteger(objArr[1]);
            if (integer2 >= RoundRectDrawableWithShadow.COS_45) {
                d = length;
                if (integer2 <= d) {
                    d = integer2;
                }
            }
            if (d < integer) {
                if (context.getLanguageVersion() != 120) {
                    double d3 = integer;
                    integer = d;
                    d = d3;
                } else {
                    d = integer;
                }
            }
        }
        return charSequence.subSequence((int) integer, (int) d);
    }

    public static NativeString realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (scriptable instanceof NativeString) {
            return (NativeString) scriptable;
        }
        throw IdScriptableObject.incompatibleCallError(idFunctionObject);
    }

    public static String tagify(Object obj, String str, String str2, Object[] objArr) {
        String scriptRuntime = ScriptRuntime.toString(obj);
        StringBuilder sb = new StringBuilder();
        sb.append('<');
        sb.append(str);
        if (str2 != null) {
            sb.append(TokenParser.f4579SP);
            sb.append(str2);
            sb.append("=\"");
            sb.append(ScriptRuntime.toString(objArr, 0));
            sb.append('\"');
        }
        sb.append('>');
        sb.append(scriptRuntime);
        sb.append("</");
        sb.append(str);
        sb.append('>');
        return sb.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Normalizer.Form form;
        if (!idFunctionObject.hasTag(STRING_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int methodId = idFunctionObject.methodId();
        Scriptable scriptable3 = scriptable2;
        Object[] objArr2 = objArr;
        while (true) {
            CharSequence charSequence = "";
            boolean z = true;
            int i = 0;
            if (methodId == -1) {
                int length = objArr2.length;
                if (length < 1) {
                    return charSequence;
                }
                StringBuilder sb = new StringBuilder(length);
                while (i != length) {
                    sb.append(ScriptRuntime.toUint16(objArr2[i]));
                    i++;
                }
                return sb.toString();
            }
            switch (methodId) {
                case -35:
                case -34:
                case -33:
                case -32:
                case -31:
                case -30:
                    break;
                default:
                    switch (methodId) {
                        case -15:
                        case -14:
                        case -13:
                        case -12:
                        case -11:
                        case -10:
                        case -9:
                        case -8:
                        case -7:
                        case -6:
                        case -5:
                            break;
                        default:
                            int i2 = 3;
                            switch (methodId) {
                                case 1:
                                    if (objArr2.length != 0) {
                                        charSequence = (!ScriptRuntime.isSymbol(objArr2[0]) || scriptable3 == null) ? ScriptRuntime.toCharSequence(objArr2[0]) : objArr2[0].toString();
                                    }
                                    return scriptable3 == null ? new NativeString(charSequence) : charSequence instanceof String ? charSequence : charSequence.toString();
                                case 2:
                                case 4:
                                    CharSequence charSequence2 = realThis(scriptable3, idFunctionObject).string;
                                    return charSequence2 instanceof String ? charSequence2 : charSequence2.toString();
                                case 3:
                                    CharSequence charSequence3 = realThis(scriptable3, idFunctionObject).string;
                                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("(new String(\"");
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(ScriptRuntime.escapeString(charSequence3.toString()));
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("\"))");
                                    return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
                                case 5:
                                case 6:
                                    CharSequence charSequence4 = ScriptRuntime.toCharSequence(scriptable3);
                                    double integer = ScriptRuntime.toInteger(objArr2, 0);
                                    if (integer < RoundRectDrawableWithShadow.COS_45 || integer >= charSequence4.length()) {
                                        return methodId == 5 ? charSequence : ScriptRuntime.NaNobj;
                                    }
                                    char charAt = charSequence4.charAt((int) integer);
                                    return methodId == 5 ? String.valueOf(charAt) : ScriptRuntime.wrapInt(charAt);
                                case 7:
                                    return ScriptRuntime.wrapInt(js_indexOf(7, ScriptRuntime.toString(scriptable3), objArr2));
                                case 8:
                                    return ScriptRuntime.wrapInt(js_lastIndexOf(ScriptRuntime.toString(scriptable3), objArr2));
                                case 9:
                                    return ScriptRuntime.checkRegExpProxy(context).js_split(context, scriptable, ScriptRuntime.toString(scriptable3), objArr2);
                                case 10:
                                    return js_substring(context, ScriptRuntime.toCharSequence(scriptable3), objArr2);
                                case 11:
                                    return ScriptRuntime.toString(scriptable3).toLowerCase(ScriptRuntime.ROOT_LOCALE);
                                case 12:
                                    return ScriptRuntime.toString(scriptable3).toUpperCase(ScriptRuntime.ROOT_LOCALE);
                                case 13:
                                    return js_substr(ScriptRuntime.toCharSequence(scriptable3), objArr2);
                                case 14:
                                    return js_concat(ScriptRuntime.toString(scriptable3), objArr2);
                                case 15:
                                    return js_slice(ScriptRuntime.toCharSequence(scriptable3), objArr2);
                                case 16:
                                    return tagify(scriptable3, "b", null, null);
                                case 17:
                                    return tagify(scriptable3, C1543ak.f2966aC, null, null);
                                case 18:
                                    return tagify(scriptable3, "tt", null, null);
                                case 19:
                                    return tagify(scriptable3, "strike", null, null);
                                case 20:
                                    return tagify(scriptable3, "small", null, null);
                                case 21:
                                    return tagify(scriptable3, "big", null, null);
                                case 22:
                                    return tagify(scriptable3, "blink", null, null);
                                case 23:
                                    return tagify(scriptable3, "sup", null, null);
                                case 24:
                                    return tagify(scriptable3, "sub", null, null);
                                case 25:
                                    return tagify(scriptable3, "font", "size", objArr2);
                                case 26:
                                    return tagify(scriptable3, "font", "color", objArr2);
                                case 27:
                                    return tagify(scriptable3, "a", "href", objArr2);
                                case 28:
                                    return tagify(scriptable3, "a", "name", objArr2);
                                case 29:
                                case 30:
                                    String scriptRuntime = ScriptRuntime.toString(scriptable3);
                                    String scriptRuntime2 = ScriptRuntime.toString(objArr2, 0);
                                    return ScriptRuntime.wrapBoolean(methodId == 29 ? scriptRuntime.equals(scriptRuntime2) : scriptRuntime.equalsIgnoreCase(scriptRuntime2));
                                case 31:
                                case 32:
                                case 33:
                                    if (methodId == 31) {
                                        i2 = 1;
                                    } else if (methodId != 32) {
                                        i2 = 2;
                                    }
                                    return ScriptRuntime.checkRegExpProxy(context).action(context, scriptable, scriptable3, objArr2, i2);
                                case 34:
                                    Collator collator = Collator.getInstance(context.getLocale());
                                    collator.setStrength(3);
                                    collator.setDecomposition(1);
                                    return ScriptRuntime.wrapNumber(collator.compare(ScriptRuntime.toString(scriptable3), ScriptRuntime.toString(objArr2, 0)));
                                case 35:
                                    return ScriptRuntime.toString(scriptable3).toLowerCase(context.getLocale());
                                case 36:
                                    return ScriptRuntime.toString(scriptable3).toUpperCase(context.getLocale());
                                case 37:
                                    String scriptRuntime3 = ScriptRuntime.toString(ScriptRuntimeES6.requireObjectCoercible(context, scriptable3, idFunctionObject));
                                    char[] charArray = scriptRuntime3.toCharArray();
                                    while (i < charArray.length && ScriptRuntime.isJSWhitespaceOrLineTerminator(charArray[i])) {
                                        i++;
                                    }
                                    int length2 = charArray.length;
                                    while (length2 > i && ScriptRuntime.isJSWhitespaceOrLineTerminator(charArray[length2 - 1])) {
                                        length2--;
                                    }
                                    return scriptRuntime3.substring(i, length2);
                                case 38:
                                    String scriptRuntime4 = ScriptRuntime.toString(scriptable3);
                                    char[] charArray2 = scriptRuntime4.toCharArray();
                                    while (i < charArray2.length && ScriptRuntime.isJSWhitespaceOrLineTerminator(charArray2[i])) {
                                        i++;
                                    }
                                    return scriptRuntime4.substring(i, charArray2.length);
                                case 39:
                                    String scriptRuntime5 = ScriptRuntime.toString(scriptable3);
                                    char[] charArray3 = scriptRuntime5.toCharArray();
                                    int length3 = charArray3.length;
                                    while (length3 > 0 && ScriptRuntime.isJSWhitespaceOrLineTerminator(charArray3[length3 - 1])) {
                                        length3--;
                                    }
                                    return scriptRuntime5.substring(0, length3);
                                case 40:
                                case 41:
                                case 42:
                                    String scriptRuntime6 = ScriptRuntime.toString(ScriptRuntimeES6.requireObjectCoercible(context, scriptable3, idFunctionObject));
                                    if (objArr2.length > 0 && (objArr2[0] instanceof NativeRegExp)) {
                                        throw ScriptRuntime.typeError2("msg.first.arg.not.regexp", String.class.getSimpleName(), idFunctionObject.getFunctionName());
                                    }
                                    int js_indexOf = js_indexOf(methodId, scriptRuntime6, objArr2);
                                    if (methodId == 40) {
                                        if (js_indexOf == -1) {
                                            z = false;
                                        }
                                        return Boolean.valueOf(z);
                                    } else if (methodId == 41) {
                                        if (js_indexOf != 0) {
                                            z = false;
                                        }
                                        return Boolean.valueOf(z);
                                    } else if (methodId == 42) {
                                        if (js_indexOf == -1) {
                                            z = false;
                                        }
                                        return Boolean.valueOf(z);
                                    }
                                    break;
                                case 43:
                                    String scriptRuntime7 = ScriptRuntime.toString(objArr2, 0);
                                    if (Normalizer.Form.NFD.name().equals(scriptRuntime7)) {
                                        form = Normalizer.Form.NFD;
                                    } else if (Normalizer.Form.NFKC.name().equals(scriptRuntime7)) {
                                        form = Normalizer.Form.NFKC;
                                    } else if (Normalizer.Form.NFKD.name().equals(scriptRuntime7)) {
                                        form = Normalizer.Form.NFKD;
                                    } else if (!Normalizer.Form.NFC.name().equals(scriptRuntime7) && objArr2.length != 0) {
                                        throw ScriptRuntime.rangeError("The normalization form should be one of NFC, NFD, NFKC, NFKD");
                                    } else {
                                        form = Normalizer.Form.NFC;
                                    }
                                    return Normalizer.normalize(ScriptRuntime.toString(ScriptRuntimeES6.requireObjectCoercible(context, scriptable3, idFunctionObject)), form);
                                case 44:
                                    return js_repeat(context, scriptable3, idFunctionObject, objArr2);
                                case 45:
                                    String scriptRuntime8 = ScriptRuntime.toString(ScriptRuntimeES6.requireObjectCoercible(context, scriptable3, idFunctionObject));
                                    double integer2 = ScriptRuntime.toInteger(objArr2, 0);
                                    return (integer2 < RoundRectDrawableWithShadow.COS_45 || integer2 >= ((double) scriptRuntime8.length())) ? Undefined.instance : Integer.valueOf(scriptRuntime8.codePointAt((int) integer2));
                                case 46:
                                case 47:
                                    break;
                                case 48:
                                    return new NativeStringIterator(scriptable, scriptable3);
                                default:
                                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("String.prototype has no method: ");
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(idFunctionObject.getFunctionName());
                                    throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                            }
                            if (methodId != 46) {
                                z = false;
                            }
                            return js_pad(context, scriptable3, idFunctionObject, objArr2, Boolean.valueOf(z));
                    }
            }
            if (objArr2.length > 0) {
                scriptable3 = ScriptRuntime.toObject(context, scriptable, ScriptRuntime.toCharSequence(objArr2[0]));
                int length4 = objArr2.length - 1;
                Object[] objArr3 = new Object[length4];
                while (i < length4) {
                    int i3 = i + 1;
                    objArr3[i] = objArr2[i3];
                    i = i3;
                }
                objArr2 = objArr3;
            } else {
                scriptable3 = ScriptRuntime.toObject(context, scriptable, ScriptRuntime.toCharSequence(scriptable3));
            }
            methodId = -methodId;
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void fillConstructorProperties(IdFunctionObject idFunctionObject) {
        addIdFunctionProperty(idFunctionObject, STRING_TAG, -1, "fromCharCode", 1);
        addIdFunctionProperty(idFunctionObject, STRING_TAG, -5, "charAt", 2);
        addIdFunctionProperty(idFunctionObject, STRING_TAG, -6, "charCodeAt", 2);
        addIdFunctionProperty(idFunctionObject, STRING_TAG, -7, "indexOf", 2);
        addIdFunctionProperty(idFunctionObject, STRING_TAG, -8, "lastIndexOf", 2);
        addIdFunctionProperty(idFunctionObject, STRING_TAG, -9, "split", 3);
        addIdFunctionProperty(idFunctionObject, STRING_TAG, -10, "substring", 3);
        addIdFunctionProperty(idFunctionObject, STRING_TAG, -11, "toLowerCase", 1);
        addIdFunctionProperty(idFunctionObject, STRING_TAG, -12, "toUpperCase", 1);
        addIdFunctionProperty(idFunctionObject, STRING_TAG, -13, "substr", 3);
        addIdFunctionProperty(idFunctionObject, STRING_TAG, -14, "concat", 2);
        addIdFunctionProperty(idFunctionObject, STRING_TAG, -15, "slice", 3);
        addIdFunctionProperty(idFunctionObject, STRING_TAG, -30, "equalsIgnoreCase", 2);
        addIdFunctionProperty(idFunctionObject, STRING_TAG, -31, "match", 2);
        addIdFunctionProperty(idFunctionObject, STRING_TAG, -32, "search", 2);
        addIdFunctionProperty(idFunctionObject, STRING_TAG, -33, "replace", 2);
        addIdFunctionProperty(idFunctionObject, STRING_TAG, -34, "localeCompare", 2);
        addIdFunctionProperty(idFunctionObject, STRING_TAG, -35, "toLocaleLowerCase", 1);
        super.fillConstructorProperties(idFunctionObject);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findInstanceIdInfo(String str) {
        return str.equals(Name.LENGTH) ? IdScriptableObject.instanceIdInfo(7, 1) : super.findInstanceIdInfo(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(String str) {
        String str2;
        int i = 8;
        switch (str.length()) {
            case 3:
                char charAt = str.charAt(2);
                if (charAt == 'b') {
                    if (str.charAt(0) == 's' && str.charAt(1) == 'u') {
                        return 24;
                    }
                } else if (charAt == 'g') {
                    if (str.charAt(0) == 'b' && str.charAt(1) == 'i') {
                        return 21;
                    }
                } else if (charAt == 'p' && str.charAt(0) == 's' && str.charAt(1) == 'u') {
                    return 23;
                }
                str2 = null;
                i = 0;
                break;
            case 4:
                char charAt2 = str.charAt(0);
                if (charAt2 != 'b') {
                    if (charAt2 != 'l') {
                        if (charAt2 == 't') {
                            i = 37;
                            str2 = "trim";
                            break;
                        }
                        str2 = null;
                        i = 0;
                        break;
                    } else {
                        i = 27;
                        str2 = "link";
                        break;
                    }
                } else {
                    i = 16;
                    str2 = "bold";
                    break;
                }
            case 5:
                char charAt3 = str.charAt(4);
                if (charAt3 == 'd') {
                    i = 18;
                    str2 = "fixed";
                    break;
                } else if (charAt3 == 'e') {
                    i = 15;
                    str2 = "slice";
                    break;
                } else if (charAt3 == 'h') {
                    i = 31;
                    str2 = "match";
                    break;
                } else if (charAt3 == 't') {
                    i = 9;
                    str2 = "split";
                    break;
                } else if (charAt3 == 'k') {
                    i = 22;
                    str2 = "blink";
                    break;
                } else {
                    if (charAt3 == 'l') {
                        i = 20;
                        str2 = "small";
                        break;
                    }
                    str2 = null;
                    i = 0;
                    break;
                }
            case 6:
                char charAt4 = str.charAt(1);
                if (charAt4 == 'a') {
                    i = 47;
                    str2 = "padEnd";
                    break;
                } else if (charAt4 == 'e') {
                    char charAt5 = str.charAt(0);
                    if (charAt5 == 'r') {
                        i = 44;
                        str2 = "repeat";
                        break;
                    } else {
                        if (charAt5 == 's') {
                            i = 32;
                            str2 = "search";
                            break;
                        }
                        str2 = null;
                        i = 0;
                    }
                } else if (charAt4 == 'h') {
                    i = 5;
                    str2 = "charAt";
                    break;
                } else if (charAt4 == 'q') {
                    i = 29;
                    str2 = AnnotationHandler.EQUAL;
                    break;
                } else if (charAt4 == 'n') {
                    i = 28;
                    str2 = "anchor";
                    break;
                } else if (charAt4 == 'o') {
                    i = 14;
                    str2 = "concat";
                    break;
                } else if (charAt4 == 't') {
                    i = 19;
                    str2 = "strike";
                    break;
                } else {
                    if (charAt4 == 'u') {
                        i = 13;
                        str2 = "substr";
                        break;
                    }
                    str2 = null;
                    i = 0;
                    break;
                }
            case 7:
                char charAt6 = str.charAt(1);
                if (charAt6 == 'a') {
                    str2 = "valueOf";
                    i = 4;
                    break;
                } else if (charAt6 == 'e') {
                    i = 33;
                    str2 = "replace";
                    break;
                } else if (charAt6 == 'n') {
                    i = 7;
                    str2 = "indexOf";
                    break;
                } else {
                    if (charAt6 == 't') {
                        i = 17;
                        str2 = "italics";
                        break;
                    }
                    str2 = null;
                    i = 0;
                    break;
                }
            case 8:
                char charAt7 = str.charAt(6);
                if (charAt7 == 'c') {
                    i = 3;
                    str2 = "toSource";
                    break;
                } else if (charAt7 == 'n') {
                    str2 = AnnotationHandler.STRING;
                    i = 2;
                    break;
                } else if (charAt7 == 'r') {
                    i = 46;
                    str2 = "padStart";
                    break;
                } else if (charAt7 == 't') {
                    i = 42;
                    str2 = "endsWith";
                    break;
                } else if (charAt7 == 'z') {
                    i = 25;
                    str2 = "fontsize";
                    break;
                } else if (charAt7 == 'e') {
                    i = 40;
                    str2 = "includes";
                    break;
                } else {
                    if (charAt7 == 'f') {
                        i = 38;
                        str2 = "trimLeft";
                        break;
                    }
                    str2 = null;
                    i = 0;
                    break;
                }
            case 9:
                char charAt8 = str.charAt(0);
                if (charAt8 == 'f') {
                    i = 26;
                    str2 = "fontcolor";
                    break;
                } else if (charAt8 == 'n') {
                    i = 43;
                    str2 = "normalize";
                    break;
                } else if (charAt8 == 's') {
                    i = 10;
                    str2 = "substring";
                    break;
                } else {
                    if (charAt8 == 't') {
                        i = 39;
                        str2 = "trimRight";
                        break;
                    }
                    str2 = null;
                    i = 0;
                    break;
                }
            case 10:
                char charAt9 = str.charAt(0);
                if (charAt9 != 'c') {
                    if (charAt9 == 's') {
                        i = 41;
                        str2 = "startsWith";
                        break;
                    }
                    str2 = null;
                    i = 0;
                    break;
                } else {
                    str2 = "charCodeAt";
                    i = 6;
                    break;
                }
            case 11:
                char charAt10 = str.charAt(2);
                if (charAt10 == 'L') {
                    i = 11;
                    str2 = "toLowerCase";
                    break;
                } else if (charAt10 == 'U') {
                    i = 12;
                    str2 = "toUpperCase";
                    break;
                } else if (charAt10 == 'd') {
                    i = 45;
                    str2 = "codePointAt";
                    break;
                } else if (charAt10 == 'n') {
                    str2 = "constructor";
                    i = 1;
                    break;
                } else {
                    if (charAt10 == 's') {
                        str2 = "lastIndexOf";
                        break;
                    }
                    str2 = null;
                    i = 0;
                    break;
                }
            case 12:
            case 14:
            case 15:
            default:
                str2 = null;
                i = 0;
                break;
            case 13:
                i = 34;
                str2 = "localeCompare";
                break;
            case 16:
                i = 30;
                str2 = "equalsIgnoreCase";
                break;
            case 17:
                char charAt11 = str.charAt(8);
                if (charAt11 != 'L') {
                    if (charAt11 == 'U') {
                        i = 36;
                        str2 = "toLocaleUpperCase";
                        break;
                    }
                    str2 = null;
                    i = 0;
                    break;
                } else {
                    i = 35;
                    str2 = "toLocaleLowerCase";
                    break;
                }
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(Symbol symbol) {
        return SymbolKey.ITERATOR.equals(symbol) ? 48 : 0;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object get(int i, Scriptable scriptable) {
        return (i < 0 || i >= this.string.length()) ? super.get(i, scriptable) : String.valueOf(this.string.charAt(i));
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "String";
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.ScriptableObject
    public Object[] getIds(boolean z, boolean z2) {
        Context currentContext = Context.getCurrentContext();
        if (currentContext == null || currentContext.getLanguageVersion() < 200) {
            return super.getIds(z, z2);
        }
        Object[] ids = super.getIds(z, z2);
        Object[] objArr = new Object[this.string.length() + ids.length];
        int i = 0;
        while (i < this.string.length()) {
            objArr[i] = Integer.valueOf(i);
            i++;
        }
        System.arraycopy(ids, 0, objArr, i, ids.length);
        return objArr;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public String getInstanceIdName(int i) {
        return i == 1 ? Name.LENGTH : super.getInstanceIdName(i);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public Object getInstanceIdValue(int i) {
        return i == 1 ? ScriptRuntime.wrapInt(this.string.length()) : super.getInstanceIdValue(i);
    }

    public int getLength() {
        return this.string.length();
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int getMaxInstanceId() {
        return 1;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public boolean has(int i, Scriptable scriptable) {
        if (i < 0 || i >= this.string.length()) {
            return super.has(i, scriptable);
        }
        return true;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i) {
        String str;
        String str2;
        String str3;
        String str4;
        int i2;
        if (i == 48) {
            initPrototypeMethod(STRING_TAG, i, SymbolKey.ITERATOR, "[Symbol.iterator]", 0);
            return;
        }
        switch (i) {
            case 1:
                str = "constructor";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 2:
                str2 = AnnotationHandler.STRING;
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 3:
                str2 = "toSource";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 4:
                str2 = "valueOf";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 5:
                str = "charAt";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 6:
                str = "charCodeAt";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 7:
                str = "indexOf";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 8:
                str = "lastIndexOf";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 9:
                str3 = "split";
                str4 = str3;
                i2 = 2;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 10:
                str3 = "substring";
                str4 = str3;
                i2 = 2;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 11:
                str2 = "toLowerCase";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 12:
                str2 = "toUpperCase";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 13:
                str3 = "substr";
                str4 = str3;
                i2 = 2;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 14:
                str = "concat";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 15:
                str3 = "slice";
                str4 = str3;
                i2 = 2;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 16:
                str2 = "bold";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 17:
                str2 = "italics";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 18:
                str2 = "fixed";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 19:
                str2 = "strike";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 20:
                str2 = "small";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 21:
                str2 = "big";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 22:
                str2 = "blink";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 23:
                str2 = "sup";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 24:
                str2 = "sub";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 25:
                str2 = "fontsize";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 26:
                str2 = "fontcolor";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 27:
                str2 = "link";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 28:
                str2 = "anchor";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 29:
                str = AnnotationHandler.EQUAL;
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 30:
                str = "equalsIgnoreCase";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 31:
                str = "match";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 32:
                str = "search";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 33:
                str3 = "replace";
                str4 = str3;
                i2 = 2;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 34:
                str = "localeCompare";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 35:
                str2 = "toLocaleLowerCase";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 36:
                str2 = "toLocaleUpperCase";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 37:
                str2 = "trim";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 38:
                str2 = "trimLeft";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 39:
                str2 = "trimRight";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 40:
                str = "includes";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 41:
                str = "startsWith";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 42:
                str = "endsWith";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 43:
                str2 = "normalize";
                str4 = str2;
                i2 = 0;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 44:
                str = "repeat";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 45:
                str = "codePointAt";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 46:
                str = "padStart";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            case 47:
                str = "padEnd";
                str4 = str;
                i2 = 1;
                initPrototypeMethod(STRING_TAG, i, str4, (String) null, i2);
                return;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void put(int i, Scriptable scriptable, Object obj) {
        if (i < 0 || i >= this.string.length()) {
            super.put(i, scriptable, obj);
        }
    }

    public CharSequence toCharSequence() {
        return this.string;
    }

    public String toString() {
        CharSequence charSequence = this.string;
        return charSequence instanceof String ? (String) charSequence : charSequence.toString();
    }
}
