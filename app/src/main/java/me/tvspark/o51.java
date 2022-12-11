package me.tvspark;

import java.lang.reflect.Method;
import org.apache.http.message.BasicHeaderValueParser;

/* loaded from: classes4.dex */
public class o51 {
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final char[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final o51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new o51(0, null, 1443168256, 1);
    public static final o51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new o51(1, null, 1509950721, 1);
    public static final o51 Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new o51(2, null, 1124075009, 1);
    public static final o51 Wwwwwwwwwwwwwwwwwwwwwwwwwww = new o51(3, null, 1107297537, 1);
    public static final o51 Wwwwwwwwwwwwwwwwwwwwwwwwww = new o51(4, null, 1392510721, 1);
    public static final o51 Wwwwwwwwwwwwwwwwwwwwwwwww = new o51(5, null, 1224736769, 1);
    public static final o51 Wwwwwwwwwwwwwwwwwwwwwwww = new o51(6, null, 1174536705, 1);
    public static final o51 Wwwwwwwwwwwwwwwwwwwwwww = new o51(7, null, 1241579778, 1);
    public static final o51 Wwwwwwwwwwwwwwwwwwwwww = new o51(8, null, 1141048066, 1);

    public o51(int i, char[] cArr, int i2, int i3) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = cArr;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
    }

    public static o51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str.toCharArray(), 0);
    }

    public static o51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        char[] charArray = str.toCharArray();
        return new o51(charArray[0] == '[' ? 9 : 10, charArray, 0, charArray.length);
    }

    public static o51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str.toCharArray(), 0);
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        int i;
        char charAt;
        int i2 = 1;
        int i3 = 1;
        int i4 = 1;
        while (true) {
            i = i3 + 1;
            char charAt2 = str.charAt(i3);
            if (charAt2 == ')') {
                break;
            } else if (charAt2 == 'L') {
                while (true) {
                    i3 = i + 1;
                    if (str.charAt(i) == ';') {
                        break;
                    }
                    i = i3;
                }
                i4++;
            } else {
                if (charAt2 == '[') {
                    while (true) {
                        charAt = str.charAt(i);
                        if (charAt != '[') {
                            break;
                        }
                        i++;
                    }
                    if (charAt == 'D' || charAt == 'J') {
                        i4--;
                    }
                } else {
                    i4 = (charAt2 == 'D' || charAt2 == 'J') ? i4 + 2 : i4 + 1;
                }
                i3 = i;
            }
        }
        char charAt3 = str.charAt(i);
        int i5 = i4 << 2;
        if (charAt3 == 'V') {
            i2 = 0;
        } else if (charAt3 == 'D' || charAt3 == 'J') {
            i2 = 2;
        }
        return i5 | i2;
    }

    public static o51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class cls) {
        if (cls.isPrimitive()) {
            return cls == Integer.TYPE ? Wwwwwwwwwwwwwwwwwwwwwwwww : cls == Void.TYPE ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww : cls == Boolean.TYPE ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwww : cls == Byte.TYPE ? Wwwwwwwwwwwwwwwwwwwwwwwwwww : cls == Character.TYPE ? Wwwwwwwwwwwwwwwwwwwwwwwwwwww : cls == Short.TYPE ? Wwwwwwwwwwwwwwwwwwwwwwwwww : cls == Double.TYPE ? Wwwwwwwwwwwwwwwwwwwwww : cls == Float.TYPE ? Wwwwwwwwwwwwwwwwwwwwwwww : Wwwwwwwwwwwwwwwwwwwwwww;
        }
        StringBuffer stringBuffer = new StringBuffer();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(stringBuffer, cls);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(stringBuffer.toString().toCharArray(), 0);
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class cls) {
        return cls.getName().replace('.', '/');
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Method method) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('(');
        for (Class<?> cls : parameterTypes) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(stringBuffer, cls);
        }
        stringBuffer.append(')');
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(stringBuffer, method.getReturnType());
        return stringBuffer.toString();
    }

    public static o51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(char[] cArr, int i) {
        int i2;
        char c = cArr[i];
        if (c != 'F') {
            if (c == 'L') {
                int i3 = 1;
                while (cArr[i + i3] != ';') {
                    i3++;
                }
                return new o51(10, cArr, i + 1, i3 - 1);
            } else if (c == 'S') {
                return Wwwwwwwwwwwwwwwwwwwwwwwwww;
            } else {
                if (c == 'V') {
                    return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
                if (c == 'I') {
                    return Wwwwwwwwwwwwwwwwwwwwwwwww;
                }
                if (c == 'J') {
                    return Wwwwwwwwwwwwwwwwwwwwwww;
                }
                if (c == 'Z') {
                    return Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
                if (c != '[') {
                    switch (c) {
                        case 'B':
                            return Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                        case 'C':
                            return Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        case 'D':
                            return Wwwwwwwwwwwwwwwwwwwwww;
                        default:
                            return new o51(11, cArr, i, cArr.length - i);
                    }
                }
                int i4 = 1;
                while (true) {
                    i2 = i + i4;
                    if (cArr[i2] != '[') {
                        break;
                    }
                    i4++;
                }
                if (cArr[i2] != 'L') {
                    return new o51(9, cArr, i, i4 + 1);
                }
                do {
                    i4++;
                } while (cArr[i + i4] != ';');
                return new o51(9, cArr, i, i4 + 1);
            }
        }
        return Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(StringBuffer stringBuffer, Class cls) {
        while (!cls.isPrimitive()) {
            if (!cls.isArray()) {
                stringBuffer.append('L');
                String name = cls.getName();
                int length = name.length();
                for (int i = 0; i < length; i++) {
                    char charAt = name.charAt(i);
                    if (charAt == '.') {
                        charAt = '/';
                    }
                    stringBuffer.append(charAt);
                }
                stringBuffer.append(BasicHeaderValueParser.PARAM_DELIMITER);
                return;
            }
            stringBuffer.append('[');
            cls = cls.getComponentType();
        }
        stringBuffer.append(cls == Integer.TYPE ? 'I' : cls == Void.TYPE ? 'V' : cls == Boolean.TYPE ? 'Z' : cls == Byte.TYPE ? 'B' : cls == Character.TYPE ? 'C' : cls == Short.TYPE ? 'S' : cls == Double.TYPE ? 'D' : cls == Float.TYPE ? 'F' : 'J');
    }

    public static o51[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        char[] charArray = str.toCharArray();
        int i = 1;
        int i2 = 1;
        int i3 = 0;
        while (true) {
            int i4 = i2 + 1;
            char c = charArray[i2];
            if (c == ')') {
                break;
            } else if (c == 'L') {
                while (true) {
                    i2 = i4 + 1;
                    if (charArray[i4] == ';') {
                        break;
                    }
                    i4 = i2;
                }
                i3++;
            } else {
                if (c != '[') {
                    i3++;
                }
                i2 = i4;
            }
        }
        o51[] o51VarArr = new o51[i3];
        int i5 = 0;
        while (charArray[i] != ')') {
            o51VarArr[i5] = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charArray, i);
            i += o51VarArr[i5].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + (o51VarArr[i5].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 10 ? 2 : 0);
            i5++;
        }
        return o51VarArr;
    }

    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        char c;
        StringBuffer stringBuffer = new StringBuffer();
        char[] cArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (cArr == null) {
            c = (char) ((this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & (-16777216)) >>> 24);
        } else if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 10) {
            stringBuffer.append(cArr, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            return stringBuffer.toString();
        } else {
            stringBuffer.append('L');
            stringBuffer.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            c = BasicHeaderValueParser.PARAM_DELIMITER;
        }
        stringBuffer.append(c);
        return stringBuffer.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o51)) {
            return false;
        }
        o51 o51Var = (o51) obj;
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i != o51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return false;
        }
        if (i >= 9) {
            int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i2 != o51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                return false;
            }
            int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i4 = o51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i5 = i2 + i3;
            while (i3 < i5) {
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i3] != o51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i4]) {
                    return false;
                }
                i3++;
                i4++;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = i * 13;
        if (i >= 9) {
            int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + i3;
            while (i3 < i4) {
                i2 = (i2 + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i3]) * 17;
                i3++;
            }
        }
        return i2;
    }

    public String toString() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }
}
