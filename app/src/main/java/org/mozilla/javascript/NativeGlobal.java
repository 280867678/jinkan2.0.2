package org.mozilla.javascript;

import java.io.Serializable;
import org.mozilla.javascript.TopLevel;
import org.mozilla.javascript.xml.XMLLib;

/* loaded from: classes5.dex */
public class NativeGlobal implements Serializable, IdFunctionCall {
    public static final Object FTAG = "Global";
    public static final int INVALID_UTF8 = Integer.MAX_VALUE;
    public static final int Id_decodeURI = 1;
    public static final int Id_decodeURIComponent = 2;
    public static final int Id_encodeURI = 3;
    public static final int Id_encodeURIComponent = 4;
    public static final int Id_escape = 5;
    public static final int Id_eval = 6;
    public static final int Id_isFinite = 7;
    public static final int Id_isNaN = 8;
    public static final int Id_isXMLName = 9;
    public static final int Id_new_CommonError = 14;
    public static final int Id_parseFloat = 10;
    public static final int Id_parseInt = 11;
    public static final int Id_unescape = 12;
    public static final int Id_uneval = 13;
    public static final int LAST_SCOPE_FUNCTION_ID = 13;
    public static final String URI_DECODE_RESERVED = ";/?:@&=+$,#";
    public static final long serialVersionUID = 6080442165748707530L;

    @Deprecated
    public static EcmaError constructError(Context context, String str, String str2, Scriptable scriptable) {
        return ScriptRuntime.constructError(str, str2);
    }

    @Deprecated
    public static EcmaError constructError(Context context, String str, String str2, Scriptable scriptable, String str3, int i, int i2, String str4) {
        return ScriptRuntime.constructError(str, str2, str3, i, str4, i2);
    }

    public static String decode(String str, boolean z) {
        int i;
        int i2;
        char c;
        int length = str.length();
        char[] cArr = null;
        int i3 = 0;
        int i4 = 0;
        while (i3 != length) {
            char charAt = str.charAt(i3);
            if (charAt != '%') {
                if (cArr != null) {
                    cArr[i4] = charAt;
                    i4++;
                }
                i3++;
            } else {
                if (cArr == null) {
                    cArr = new char[length];
                    str.getChars(0, i3, cArr, 0);
                    i4 = i3;
                }
                int i5 = i3 + 3;
                if (i5 > length) {
                    throw uriError();
                }
                int unHex = unHex(str.charAt(i3 + 1), str.charAt(i3 + 2));
                if (unHex < 0) {
                    throw uriError();
                }
                if ((unHex & 128) != 0) {
                    if ((unHex & 192) == 128) {
                        throw uriError();
                    }
                    if ((unHex & 32) == 0) {
                        unHex &= 31;
                        i = 1;
                        i2 = 128;
                    } else if ((unHex & 16) == 0) {
                        unHex &= 15;
                        i = 2;
                        i2 = 2048;
                    } else if ((unHex & 8) == 0) {
                        unHex &= 7;
                        i = 3;
                        i2 = 65536;
                    } else if ((unHex & 4) == 0) {
                        unHex &= 3;
                        i = 4;
                        i2 = 2097152;
                    } else if ((unHex & 2) != 0) {
                        throw uriError();
                    } else {
                        i = 5;
                        unHex &= 1;
                        i2 = 67108864;
                    }
                    if ((i * 3) + i5 > length) {
                        throw uriError();
                    }
                    for (int i6 = 0; i6 != i; i6++) {
                        if (str.charAt(i5) != '%') {
                            throw uriError();
                        }
                        int unHex2 = unHex(str.charAt(i5 + 1), str.charAt(i5 + 2));
                        if (unHex2 < 0 || (unHex2 & 192) != 128) {
                            throw uriError();
                        }
                        unHex = (unHex << 6) | (unHex2 & 63);
                        i5 += 3;
                    }
                    if (unHex < i2 || (unHex >= 55296 && unHex <= 57343)) {
                        unHex = Integer.MAX_VALUE;
                    } else if (unHex == 65534 || unHex == 65535) {
                        unHex = 65533;
                    }
                    if (unHex >= 65536) {
                        int i7 = unHex - 65536;
                        if (i7 > 1048575) {
                            throw uriError();
                        }
                        cArr[i4] = (char) ((i7 >>> 10) + 55296);
                        c = (char) ((i7 & 1023) + 56320);
                        i4++;
                        if (z || URI_DECODE_RESERVED.indexOf(c) < 0) {
                            cArr[i4] = c;
                            i4++;
                        } else {
                            while (i3 != i5) {
                                cArr[i4] = str.charAt(i3);
                                i3++;
                                i4++;
                            }
                        }
                        i3 = i5;
                    }
                }
                c = (char) unHex;
                if (z) {
                }
                cArr[i4] = c;
                i4++;
                i3 = i5;
            }
        }
        return cArr == null ? str : new String(cArr, 0, i4);
    }

    public static String encode(String str, boolean z) {
        int length = str.length();
        StringBuilder sb = null;
        byte[] bArr = null;
        int i = 0;
        while (i != length) {
            char charAt = str.charAt(i);
            sb = sb;
            if (!encodeUnescaped(charAt, z)) {
                if (sb == null) {
                    StringBuilder sb2 = new StringBuilder(length + 3);
                    sb2.append(str);
                    sb2.setLength(i);
                    bArr = new byte[6];
                    sb = sb2;
                }
                if (56320 <= charAt && charAt <= 57343) {
                    throw uriError();
                }
                char c = charAt;
                if (charAt >= 55296) {
                    c = charAt;
                    if (56319 >= charAt) {
                        i++;
                        if (i == length) {
                            throw uriError();
                        }
                        char charAt2 = str.charAt(i);
                        if (56320 > charAt2 || charAt2 > 57343) {
                            throw uriError();
                        }
                        c = 65536 + (charAt2 - 56320) + ((charAt - 55296) << 10);
                    }
                }
                int oneUcs4ToUtf8Char = oneUcs4ToUtf8Char(bArr, c);
                for (int i2 = 0; i2 < oneUcs4ToUtf8Char; i2++) {
                    int i3 = bArr[i2] & 255;
                    sb.append('%');
                    sb.append(toHexChar(i3 >>> 4));
                    sb.append(toHexChar(i3 & 15));
                }
            } else if (sb != null) {
                sb.append(charAt);
            }
            i++;
            sb = sb;
        }
        return sb == null ? str : sb.toString();
    }

    public static boolean encodeUnescaped(char c, boolean z) {
        if (('A' > c || c > 'Z') && (('a' > c || c > 'z') && (('0' > c || c > '9') && "-_.!~*'()".indexOf(c) < 0))) {
            return z && URI_DECODE_RESERVED.indexOf(c) >= 0;
        }
        return true;
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        TopLevel.NativeErrors[] values;
        String str;
        String str2;
        int i;
        NativeGlobal nativeGlobal = new NativeGlobal();
        for (int i2 = 1; i2 <= 13; i2++) {
            switch (i2) {
                case 1:
                    str = "decodeURI";
                    str2 = str;
                    i = 1;
                    break;
                case 2:
                    str = "decodeURIComponent";
                    str2 = str;
                    i = 1;
                    break;
                case 3:
                    str = "encodeURI";
                    str2 = str;
                    i = 1;
                    break;
                case 4:
                    str = "encodeURIComponent";
                    str2 = str;
                    i = 1;
                    break;
                case 5:
                    str = "escape";
                    str2 = str;
                    i = 1;
                    break;
                case 6:
                    str = "eval";
                    str2 = str;
                    i = 1;
                    break;
                case 7:
                    str = "isFinite";
                    str2 = str;
                    i = 1;
                    break;
                case 8:
                    str = "isNaN";
                    str2 = str;
                    i = 1;
                    break;
                case 9:
                    str = "isXMLName";
                    str2 = str;
                    i = 1;
                    break;
                case 10:
                    str = "parseFloat";
                    str2 = str;
                    i = 1;
                    break;
                case 11:
                    str2 = "parseInt";
                    i = 2;
                    break;
                case 12:
                    str = "unescape";
                    str2 = str;
                    i = 1;
                    break;
                case 13:
                    str = "uneval";
                    str2 = str;
                    i = 1;
                    break;
                default:
                    throw Kit.codeBug();
            }
            IdFunctionObject idFunctionObject = new IdFunctionObject(nativeGlobal, FTAG, i2, str2, i, scriptable);
            if (z) {
                idFunctionObject.sealObject();
            }
            idFunctionObject.exportAsScopeProperty();
        }
        ScriptableObject.defineProperty(scriptable, "NaN", ScriptRuntime.NaNobj, 7);
        ScriptableObject.defineProperty(scriptable, "Infinity", ScriptRuntime.wrapNumber(Double.POSITIVE_INFINITY), 7);
        ScriptableObject.defineProperty(scriptable, "undefined", Undefined.instance, 7);
        for (TopLevel.NativeErrors nativeErrors : TopLevel.NativeErrors.values()) {
            if (nativeErrors != TopLevel.NativeErrors.Error) {
                String name = nativeErrors.name();
                ScriptableObject scriptableObject = (ScriptableObject) ScriptRuntime.newBuiltinObject(context, scriptable, TopLevel.Builtins.Error, ScriptRuntime.emptyArgs);
                scriptableObject.put("name", scriptableObject, name);
                scriptableObject.put("message", scriptableObject, "");
                IdFunctionObject idFunctionObject2 = new IdFunctionObject(nativeGlobal, FTAG, 14, name, 1, scriptable);
                idFunctionObject2.markAsConstructor(scriptableObject);
                scriptableObject.put("constructor", scriptableObject, idFunctionObject2);
                scriptableObject.setAttributes("constructor", 2);
                if (z) {
                    scriptableObject.sealObject();
                    idFunctionObject2.sealObject();
                }
                idFunctionObject2.exportAsScopeProperty();
            }
        }
    }

    public static boolean isEvalFunction(Object obj) {
        if (obj instanceof IdFunctionObject) {
            IdFunctionObject idFunctionObject = (IdFunctionObject) obj;
            return idFunctionObject.hasTag(FTAG) && idFunctionObject.methodId() == 6;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
        if ((r12 & (-8)) == 0) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Object js_escape(Object[] objArr) {
        int i;
        String scriptRuntime = ScriptRuntime.toString(objArr, 0);
        if (objArr.length > 1) {
            double number = ScriptRuntime.toNumber(objArr[1]);
            if (number == number) {
                i = (int) number;
                if (i == number) {
                }
            }
            throw Context.reportRuntimeError0("msg.bad.esc.mask");
        }
        i = 7;
        StringBuilder sb = null;
        int length = scriptRuntime.length();
        for (int i2 = 0; i2 != length; i2++) {
            char charAt = scriptRuntime.charAt(i2);
            if (i == 0 || ((charAt < '0' || charAt > '9') && ((charAt < 'A' || charAt > 'Z') && !((charAt >= 'a' && charAt <= 'z') || charAt == '@' || charAt == '*' || charAt == '_' || charAt == '-' || charAt == '.' || ((i & 4) != 0 && (charAt == '/' || charAt == '+')))))) {
                if (sb == null) {
                    sb = new StringBuilder(length + 3);
                    sb.append(scriptRuntime);
                    sb.setLength(i2);
                }
                int i3 = 2;
                if (charAt >= 256) {
                    sb.append('%');
                    sb.append('u');
                    i3 = 4;
                } else if (charAt == ' ' && i == 2) {
                    sb.append('+');
                } else {
                    sb.append('%');
                }
                for (int i4 = (i3 - 1) * 4; i4 >= 0; i4 -= 4) {
                    int i5 = (charAt >> i4) & 15;
                    sb.append((char) (i5 < 10 ? i5 + 48 : i5 + 55));
                }
            } else if (sb != null) {
                sb.append(charAt);
            }
        }
        return sb == null ? scriptRuntime : sb.toString();
    }

    private Object js_eval(Context context, Scriptable scriptable, Object[] objArr) {
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        return ScriptRuntime.evalSpecial(context, topLevelScope, topLevelScope, objArr, "eval code", 1);
    }

    public static Object js_parseFloat(Object[] objArr) {
        int i;
        if (objArr.length < 1) {
            return ScriptRuntime.NaNobj;
        }
        boolean z = false;
        String scriptRuntime = ScriptRuntime.toString(objArr[0]);
        int length = scriptRuntime.length();
        for (int i2 = 0; i2 != length; i2++) {
            char charAt = scriptRuntime.charAt(i2);
            if (!ScriptRuntime.isStrWhiteSpaceChar(charAt)) {
                if (charAt == '+' || charAt == '-') {
                    int i3 = i2 + 1;
                    if (i3 == length) {
                        return ScriptRuntime.NaNobj;
                    }
                    i = i3;
                    charAt = scriptRuntime.charAt(i3);
                } else {
                    i = i2;
                }
                if (charAt == 'I') {
                    if (i + 8 > length || !scriptRuntime.regionMatches(i, "Infinity", 0, 8)) {
                        return ScriptRuntime.NaNobj;
                    }
                    return ScriptRuntime.wrapNumber(scriptRuntime.charAt(i2) == '-' ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY);
                }
                int i4 = -1;
                int i5 = -1;
                while (true) {
                    if (i < length) {
                        char charAt2 = scriptRuntime.charAt(i);
                        if (charAt2 != '+') {
                            if (charAt2 == 'E' || charAt2 == 'e') {
                                if (i4 == -1 && i != length - 1) {
                                    i4 = i;
                                    i++;
                                }
                            } else if (charAt2 != '-') {
                                if (charAt2 != '.') {
                                    switch (charAt2) {
                                        case '0':
                                        case '1':
                                        case '2':
                                        case '3':
                                        case '4':
                                        case '5':
                                        case '6':
                                        case '7':
                                        case '8':
                                        case '9':
                                            if (i4 != -1) {
                                                z = true;
                                            }
                                            i++;
                                    }
                                } else if (i5 == -1) {
                                    i5 = i;
                                    i++;
                                }
                            }
                        }
                        if (i4 == i - 1) {
                            if (i == length - 1) {
                                i--;
                            } else {
                                i++;
                            }
                        }
                    }
                }
                if (i4 == -1 || z) {
                    i4 = i;
                }
                try {
                    return Double.valueOf(scriptRuntime.substring(i2, i4));
                } catch (NumberFormatException unused) {
                    return ScriptRuntime.NaNobj;
                }
            }
        }
        return ScriptRuntime.NaNobj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002c, code lost:
        if (r0 != false) goto L56;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object js_parseInt(Object[] objArr) {
        char charAt;
        char charAt2;
        boolean z = false;
        String scriptRuntime = ScriptRuntime.toString(objArr, 0);
        int int32 = ScriptRuntime.toInt32(objArr, 1);
        int length = scriptRuntime.length();
        if (length == 0) {
            return ScriptRuntime.NaNobj;
        }
        int i = 0;
        do {
            charAt = scriptRuntime.charAt(i);
            if (!ScriptRuntime.isStrWhiteSpaceChar(charAt)) {
                break;
            }
            i++;
        } while (i < length);
        if (charAt != '+') {
            if (charAt == '-') {
                z = true;
            }
        }
        i++;
        int i2 = 16;
        if (int32 == 0) {
            int32 = -1;
        } else if (int32 < 2 || int32 > 36) {
            return ScriptRuntime.NaNobj;
        } else {
            if (int32 == 16 && length - i > 1 && scriptRuntime.charAt(i) == '0' && ((charAt2 = scriptRuntime.charAt(i + 1)) == 'x' || charAt2 == 'X')) {
                i += 2;
            }
        }
        if (int32 == -1) {
            if (length - i > 1 && scriptRuntime.charAt(i) == '0') {
                int i3 = i + 1;
                char charAt3 = scriptRuntime.charAt(i3);
                if (charAt3 == 'x' || charAt3 == 'X') {
                    i += 2;
                } else if ('0' <= charAt3 && charAt3 <= '9') {
                    i2 = 8;
                    i = i3;
                }
            }
            i2 = 10;
        } else {
            i2 = int32;
        }
        double stringPrefixToNumber = ScriptRuntime.stringPrefixToNumber(scriptRuntime, i, i2);
        if (z) {
            stringPrefixToNumber = -stringPrefixToNumber;
        }
        return ScriptRuntime.wrapNumber(stringPrefixToNumber);
    }

    private Object js_unescape(Object[] objArr) {
        int i;
        int i2;
        String scriptRuntime = ScriptRuntime.toString(objArr, 0);
        int indexOf = scriptRuntime.indexOf(37);
        if (indexOf >= 0) {
            int length = scriptRuntime.length();
            char[] charArray = scriptRuntime.toCharArray();
            int i3 = indexOf;
            while (indexOf != length) {
                char c = charArray[indexOf];
                indexOf++;
                if (c == '%' && indexOf != length) {
                    if (charArray[indexOf] == 'u') {
                        i2 = indexOf + 1;
                        i = indexOf + 5;
                    } else {
                        i = indexOf + 2;
                        i2 = indexOf;
                    }
                    if (i <= length) {
                        int i4 = 0;
                        while (i2 != i) {
                            i4 = Kit.xDigitToInt(charArray[i2], i4);
                            i2++;
                        }
                        if (i4 >= 0) {
                            c = (char) i4;
                            indexOf = i;
                        }
                    }
                }
                charArray[i3] = c;
                i3++;
            }
            return new String(charArray, 0, i3);
        }
        return scriptRuntime;
    }

    public static int oneUcs4ToUtf8Char(byte[] bArr, int i) {
        if ((i & (-128)) == 0) {
            bArr[0] = (byte) i;
            return 1;
        }
        int i2 = i >>> 11;
        int i3 = 2;
        while (i2 != 0) {
            i2 >>>= 5;
            i3++;
        }
        int i4 = i3;
        while (true) {
            i4--;
            if (i4 <= 0) {
                bArr[0] = (byte) ((256 - (1 << (8 - i3))) + i);
                return i3;
            }
            bArr[i4] = (byte) ((i & 63) | 128);
            i >>>= 6;
        }
    }

    public static char toHexChar(int i) {
        if ((i >> 4) != 0) {
            Kit.codeBug();
        }
        return (char) (i < 10 ? i + 48 : (i - 10) + 65);
    }

    public static int unHex(char c) {
        char c2 = 'A';
        if ('A' > c || c > 'F') {
            c2 = 'a';
            if ('a' > c || c > 'f') {
                if ('0' <= c && c <= '9') {
                    return c - '0';
                }
                return -1;
            }
        }
        return (c - c2) + 10;
    }

    public static int unHex(char c, char c2) {
        int unHex = unHex(c);
        int unHex2 = unHex(c2);
        if (unHex < 0 || unHex2 < 0) {
            return -1;
        }
        return (unHex << 4) | unHex2;
    }

    public static EcmaError uriError() {
        return ScriptRuntime.constructError("URIError", ScriptRuntime.getMessage0("msg.bad.uri"));
    }

    @Override // org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (idFunctionObject.hasTag(FTAG)) {
            int methodId = idFunctionObject.methodId();
            boolean z = true;
            switch (methodId) {
                case 1:
                case 2:
                    String scriptRuntime = ScriptRuntime.toString(objArr, 0);
                    if (methodId != 1) {
                        z = false;
                    }
                    return decode(scriptRuntime, z);
                case 3:
                case 4:
                    String scriptRuntime2 = ScriptRuntime.toString(objArr, 0);
                    if (methodId != 3) {
                        z = false;
                    }
                    return encode(scriptRuntime2, z);
                case 5:
                    return js_escape(objArr);
                case 6:
                    return js_eval(context, scriptable, objArr);
                case 7:
                    return objArr.length < 1 ? Boolean.FALSE : NativeNumber.isFinite(objArr[0]);
                case 8:
                    if (objArr.length >= 1) {
                        double number = ScriptRuntime.toNumber(objArr[0]);
                        if (number == number) {
                            z = false;
                        }
                    }
                    return ScriptRuntime.wrapBoolean(z);
                case 9:
                    return ScriptRuntime.wrapBoolean(XMLLib.extractFromScope(scriptable).isXMLName(context, objArr.length == 0 ? Undefined.instance : objArr[0]));
                case 10:
                    return js_parseFloat(objArr);
                case 11:
                    return js_parseInt(objArr);
                case 12:
                    return js_unescape(objArr);
                case 13:
                    return ScriptRuntime.uneval(context, scriptable, objArr.length != 0 ? objArr[0] : Undefined.instance);
                case 14:
                    return NativeError.make(context, scriptable, idFunctionObject, objArr);
            }
        }
        throw idFunctionObject.unknown();
    }
}
