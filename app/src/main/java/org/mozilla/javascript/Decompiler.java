package org.mozilla.javascript;

import androidx.cardview.widget.RoundRectDrawableWithShadow;
import me.tvspark.outline;
import okhttp3.internal.p054ws.WebSocketProtocol;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.apache.http.message.BasicHeaderValueParser;
import org.apache.http.message.TokenParser;
import org.eclipse.jetty.util.MultiPartWriter;
import org.fourthline.cling.model.meta.QueryStateVariableAction;

/* loaded from: classes5.dex */
public class Decompiler {
    public static final int CASE_GAP_PROP = 3;
    public static final int FUNCTION_END = 167;
    public static final int INDENT_GAP_PROP = 2;
    public static final int INITIAL_INDENT_PROP = 1;
    public static final int ONLY_BODY_FLAG = 1;
    public static final int TO_SOURCE_FLAG = 2;
    public static final boolean printSource = false;
    public char[] sourceBuffer = new char[128];
    public int sourceTop;

    private void append(char c) {
        int i = this.sourceTop;
        if (i == this.sourceBuffer.length) {
            increaseSourceCapacity(i + 1);
        }
        char[] cArr = this.sourceBuffer;
        int i2 = this.sourceTop;
        cArr[i2] = c;
        this.sourceTop = i2 + 1;
    }

    private void appendString(String str) {
        int length = str.length();
        int i = this.sourceTop + (length >= 32768 ? 2 : 1) + length;
        if (i > this.sourceBuffer.length) {
            increaseSourceCapacity(i);
        }
        if (length >= 32768) {
            char[] cArr = this.sourceBuffer;
            int i2 = this.sourceTop;
            cArr[i2] = (char) (32768 | (length >>> 16));
            this.sourceTop = i2 + 1;
        }
        char[] cArr2 = this.sourceBuffer;
        int i3 = this.sourceTop;
        cArr2[i3] = (char) length;
        int i4 = i3 + 1;
        this.sourceTop = i4;
        str.getChars(0, length, cArr2, i4);
        this.sourceTop = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:112:0x01a7, code lost:
        if (86 == getNext(r16, r2, r12)) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x01cd, code lost:
        if (r6 != 167) goto L188;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x01f5, code lost:
        if (1 != getNext(r16, r2, r12)) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x02aa, code lost:
        if (83 != getNext(r16, r2, r12)) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x021a, code lost:
        if (39 == getNext(r16, r2, r12)) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01a9, code lost:
        r6 = org.apache.http.message.TokenParser.f4579SP;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0226, code lost:
        if (39 == getNext(r16, r2, r12)) goto L75;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String decompile(String str, int i, UintMap uintMap) {
        char charAt;
        int i2;
        char c;
        boolean z;
        char c2;
        String str2;
        String str3;
        int printSourceString;
        int length = str.length();
        if (length == 0) {
            return "";
        }
        int i3 = uintMap.getInt(1, 0);
        if (i3 < 0) {
            throw new IllegalArgumentException();
        }
        char c3 = 4;
        int i4 = uintMap.getInt(2, 4);
        if (i4 < 0) {
            throw new IllegalArgumentException();
        }
        int i5 = uintMap.getInt(3, 2);
        if (i5 < 0) {
            throw new IllegalArgumentException();
        }
        StringBuilder sb = new StringBuilder();
        boolean z2 = (i & 1) != 0;
        boolean z3 = (i & 2) != 0;
        if (str.charAt(0) == 137) {
            charAt = 65535;
            i2 = 1;
        } else {
            charAt = str.charAt(1);
            i2 = 0;
        }
        if (!z3) {
            sb.append('\n');
            for (int i6 = 0; i6 < i3; i6++) {
                sb.append(TokenParser.f4579SP);
            }
        } else if (charAt == 2) {
            sb.append('(');
        }
        int i7 = 0;
        boolean z4 = false;
        while (i2 < length) {
            char charAt2 = str.charAt(i2);
            if (charAt2 != 1) {
                if (charAt2 != c3) {
                    if (charAt2 == '2') {
                        str2 = "throw ";
                    } else if (charAt2 == 'C') {
                        str2 = ": ";
                    } else if (charAt2 == 'I') {
                        str2 = "yield ";
                    } else if (charAt2 == 161) {
                        str2 = "debugger;\n";
                    } else if (charAt2 != 167) {
                        if (charAt2 == '4') {
                            str2 = " in ";
                        } else if (charAt2 == '5') {
                            str2 = " instanceof ";
                        } else if (charAt2 == 144) {
                            str2 = "..";
                        } else if (charAt2 == 145) {
                            str2 = "::";
                        } else if (charAt2 != 147) {
                            if (charAt2 != 148) {
                                if (charAt2 != 164) {
                                    if (charAt2 != 165) {
                                        switch (charAt2) {
                                            case '\t':
                                                str2 = " | ";
                                                break;
                                            case '\n':
                                                str2 = " ^ ";
                                                break;
                                            case 11:
                                                str2 = " & ";
                                                break;
                                            case '\f':
                                                str2 = " == ";
                                                break;
                                            case '\r':
                                                str2 = " != ";
                                                break;
                                            case 14:
                                                str2 = " < ";
                                                break;
                                            case 15:
                                                str2 = " <= ";
                                                break;
                                            case 16:
                                                str2 = " > ";
                                                break;
                                            case 17:
                                                str2 = " >= ";
                                                break;
                                            case 18:
                                                str2 = " << ";
                                                break;
                                            case 19:
                                                str2 = " >> ";
                                                break;
                                            case 20:
                                                str2 = " >>> ";
                                                break;
                                            case 21:
                                                str2 = " + ";
                                                break;
                                            case 22:
                                                str2 = " - ";
                                                break;
                                            case 23:
                                                str2 = " * ";
                                                break;
                                            case 24:
                                                str2 = " / ";
                                                break;
                                            case 25:
                                                str2 = " % ";
                                                break;
                                            case 26:
                                                c2 = PublicSuffixDatabase.EXCEPTION_MARKER;
                                                break;
                                            case 27:
                                                c2 = '~';
                                                break;
                                            case 28:
                                                c2 = '+';
                                                break;
                                            case 29:
                                                c2 = '-';
                                                break;
                                            case 30:
                                                str2 = "new ";
                                                break;
                                            case 31:
                                                str2 = "delete ";
                                                break;
                                            case ' ':
                                                str2 = "typeof ";
                                                break;
                                            default:
                                                switch (charAt2) {
                                                    case '\'':
                                                    case '0':
                                                        printSourceString = printSourceString(str, i2 + 1, false, sb);
                                                        i2 = printSourceString;
                                                        continue;
                                                    case '(':
                                                        printSourceString = printSourceNumber(str, i2 + 1, sb);
                                                        i2 = printSourceString;
                                                        continue;
                                                    case ')':
                                                        printSourceString = printSourceString(str, i2 + 1, true, sb);
                                                        i2 = printSourceString;
                                                        continue;
                                                    case '*':
                                                        str2 = "null";
                                                        break;
                                                    case '+':
                                                        str2 = "this";
                                                        break;
                                                    case ',':
                                                        str2 = "false";
                                                        break;
                                                    case '-':
                                                        str2 = "true";
                                                        break;
                                                    case '.':
                                                        str2 = " === ";
                                                        break;
                                                    case '/':
                                                        str2 = " !== ";
                                                        break;
                                                    default:
                                                        switch (charAt2) {
                                                            case 'R':
                                                                str2 = "try ";
                                                                break;
                                                            case 'S':
                                                                sb.append(BasicHeaderValueParser.PARAM_DELIMITER);
                                                                break;
                                                            case 'T':
                                                                c2 = '[';
                                                                break;
                                                            case 'U':
                                                                c2 = ']';
                                                                break;
                                                            case 'V':
                                                                i7++;
                                                                if (1 == getNext(str, length, i2)) {
                                                                    i3 += i4;
                                                                }
                                                                c2 = '{';
                                                                break;
                                                            case 'W':
                                                                i7--;
                                                                if (!z2 || i7 != 0) {
                                                                    sb.append('}');
                                                                    int next = getNext(str, length, i2);
                                                                    if (next != 1) {
                                                                        if (next != 114 && next != 118) {
                                                                            break;
                                                                        } else {
                                                                            i3 -= i4;
                                                                            c2 = TokenParser.f4579SP;
                                                                            break;
                                                                        }
                                                                    }
                                                                    i3 -= i4;
                                                                    break;
                                                                }
                                                                break;
                                                            case 'X':
                                                                c2 = '(';
                                                                break;
                                                            case 'Y':
                                                                sb.append(')');
                                                                break;
                                                            case 'Z':
                                                                str2 = ", ";
                                                                break;
                                                            case '[':
                                                                str2 = " = ";
                                                                break;
                                                            case '\\':
                                                                str2 = " |= ";
                                                                break;
                                                            case ']':
                                                                str2 = " ^= ";
                                                                break;
                                                            case '^':
                                                                str2 = " &= ";
                                                                break;
                                                            case '_':
                                                                str2 = " <<= ";
                                                                break;
                                                            case '`':
                                                                str2 = " >>= ";
                                                                break;
                                                            case 'a':
                                                                str2 = " >>>= ";
                                                                break;
                                                            case 'b':
                                                                str2 = " += ";
                                                                break;
                                                            case 'c':
                                                                str2 = " -= ";
                                                                break;
                                                            case 'd':
                                                                str2 = " *= ";
                                                                break;
                                                            case 'e':
                                                                str2 = " /= ";
                                                                break;
                                                            case 'f':
                                                                str2 = " %= ";
                                                                break;
                                                            case 'g':
                                                                str2 = " ? ";
                                                                break;
                                                            case 'h':
                                                                if (1 == getNext(str, length, i2)) {
                                                                    c2 = ':';
                                                                    break;
                                                                } else {
                                                                    str2 = " : ";
                                                                    break;
                                                                }
                                                            case 'i':
                                                                str2 = " || ";
                                                                break;
                                                            case 'j':
                                                                str2 = " && ";
                                                                break;
                                                            case 'k':
                                                                str2 = "++";
                                                                break;
                                                            case 'l':
                                                                str2 = MultiPartWriter.__DASHDASH;
                                                                break;
                                                            case 'm':
                                                                c2 = '.';
                                                                break;
                                                            case 'n':
                                                                i2++;
                                                                str2 = "function ";
                                                                break;
                                                            default:
                                                                switch (charAt2) {
                                                                    case 'q':
                                                                        str2 = "if ";
                                                                        break;
                                                                    case 'r':
                                                                        str2 = "else ";
                                                                        break;
                                                                    case 's':
                                                                        str2 = "switch ";
                                                                        break;
                                                                    case 't':
                                                                        str2 = "case ";
                                                                        break;
                                                                    case 'u':
                                                                        str2 = "default";
                                                                        break;
                                                                    case 'v':
                                                                        str2 = "while ";
                                                                        break;
                                                                    case 'w':
                                                                        str2 = "do ";
                                                                        break;
                                                                    case 'x':
                                                                        str2 = "for ";
                                                                        break;
                                                                    case 'y':
                                                                        sb.append("break");
                                                                        break;
                                                                    case 'z':
                                                                        sb.append("continue");
                                                                        break;
                                                                    case '{':
                                                                        str2 = "var ";
                                                                        break;
                                                                    case '|':
                                                                        str2 = "with ";
                                                                        break;
                                                                    case '}':
                                                                        str2 = "catch ";
                                                                        break;
                                                                    case '~':
                                                                        str2 = "finally ";
                                                                        break;
                                                                    case 127:
                                                                        str2 = "void ";
                                                                        break;
                                                                    default:
                                                                        switch (charAt2) {
                                                                            case 152:
                                                                            case 153:
                                                                                break;
                                                                            case 154:
                                                                                str2 = "let ";
                                                                                break;
                                                                            case 155:
                                                                                str2 = "const ";
                                                                                break;
                                                                            default:
                                                                                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Token: ");
                                                                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Token.name(str.charAt(i2)));
                                                                                throw new RuntimeException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                                                                        }
                                                                }
                                                        }
                                                }
                                                c3 = 4;
                                                break;
                                        }
                                    } else {
                                        str2 = " => ";
                                    }
                                }
                                if (str.charAt(i2) == 152) {
                                    str3 = "get ";
                                } else {
                                    if (str.charAt(i2) == 153) {
                                        str3 = "set ";
                                    }
                                    i2 = printSourceString(str, i2 + 1 + 1, false, sb) + 1;
                                }
                                sb.append(str3);
                                i2 = printSourceString(str, i2 + 1 + 1, false, sb) + 1;
                            } else {
                                c2 = '@';
                            }
                            sb.append(c2);
                        } else {
                            str2 = ".(";
                        }
                    }
                    sb.append(str2);
                } else {
                    sb.append(QueryStateVariableAction.OUTPUT_ARG_RETURN);
                }
            } else if (!z3) {
                if (!z4) {
                    if (z2) {
                        sb.setLength(0);
                        i3 -= i4;
                        z = false;
                    } else {
                        z = true;
                    }
                    z4 = true;
                } else {
                    z = true;
                }
                if (z) {
                    sb.append('\n');
                }
                int i8 = i2 + 1;
                if (i8 < length) {
                    char charAt3 = str.charAt(i8);
                    for (int i9 = (charAt3 == 't' || charAt3 == 'u') ? i4 - i5 : (charAt3 == 'W' || (charAt3 == '\'' && str.charAt(getSourceStringEnd(str, i2 + 2)) == 'h')) ? i4 : 0; i9 < i3; i9++) {
                        sb.append(TokenParser.f4579SP);
                    }
                }
            }
            i2++;
            c3 = 4;
        }
        if (!z3) {
            if (!z2) {
                c = '\n';
                sb.append(c);
            }
            return sb.toString();
        }
        if (charAt == 2) {
            c = ')';
            sb.append(c);
        }
        return sb.toString();
    }

    public static int getNext(String str, int i, int i2) {
        int i3 = i2 + 1;
        if (i3 < i) {
            return str.charAt(i3);
        }
        return 0;
    }

    public static int getSourceStringEnd(String str, int i) {
        return printSourceString(str, i, false, null);
    }

    private void increaseSourceCapacity(int i) {
        if (i <= this.sourceBuffer.length) {
            Kit.codeBug();
        }
        int length = this.sourceBuffer.length * 2;
        if (length >= i) {
            i = length;
        }
        char[] cArr = new char[i];
        System.arraycopy(this.sourceBuffer, 0, cArr, 0, this.sourceTop);
        this.sourceBuffer = cArr;
    }

    public static int printSourceNumber(String str, int i, StringBuilder sb) {
        int i2;
        char charAt = str.charAt(i);
        int i3 = i + 1;
        double d = RoundRectDrawableWithShadow.COS_45;
        if (charAt == 'S') {
            if (sb != null) {
                d = str.charAt(i3);
            }
            i2 = i3 + 1;
        } else if (charAt != 'J' && charAt != 'D') {
            throw new RuntimeException();
        } else {
            if (sb != null) {
                long charAt2 = (str.charAt(i3) << 48) | (str.charAt(i3 + 1) << 32) | (str.charAt(i3 + 2) << 16) | str.charAt(i3 + 3);
                d = charAt == 'J' ? charAt2 : Double.longBitsToDouble(charAt2);
            }
            i2 = i3 + 4;
        }
        if (sb != null) {
            sb.append(ScriptRuntime.numberToString(d, 10));
        }
        return i2;
    }

    public static int printSourceString(String str, int i, boolean z, StringBuilder sb) {
        int charAt = str.charAt(i);
        int i2 = i + 1;
        if ((32768 & charAt) != 0) {
            charAt = ((charAt & 32767) << 16) | str.charAt(i2);
            i2++;
        }
        if (sb != null) {
            String substring = str.substring(i2, i2 + charAt);
            if (!z) {
                sb.append(substring);
            } else {
                sb.append('\"');
                sb.append(ScriptRuntime.escapeString(substring));
                sb.append('\"');
            }
        }
        return i2 + charAt;
    }

    private String sourceToString(int i) {
        if (i < 0 || this.sourceTop < i) {
            Kit.codeBug();
        }
        return new String(this.sourceBuffer, i, this.sourceTop - i);
    }

    public void addEOL(int i) {
        if (i < 0 || i > 166) {
            throw new IllegalArgumentException();
        }
        append((char) i);
        append((char) 1);
    }

    public void addName(String str) {
        addToken(39);
        appendString(str);
    }

    public void addNumber(double d) {
        char c;
        char c2;
        addToken(40);
        long j = (long) d;
        if (j != d) {
            long doubleToLongBits = Double.doubleToLongBits(d);
            append('D');
            append((char) (doubleToLongBits >> 48));
            append((char) (doubleToLongBits >> 32));
            append((char) (doubleToLongBits >> 16));
            c2 = (char) doubleToLongBits;
        } else {
            if (j < 0) {
                Kit.codeBug();
            }
            if (j <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                c = 'S';
            } else {
                append('J');
                append((char) (j >> 48));
                append((char) (j >> 32));
                c = (char) (j >> 16);
            }
            append(c);
            c2 = (char) j;
        }
        append(c2);
    }

    public void addRegexp(String str, String str2) {
        addToken(48);
        appendString('/' + str + '/' + str2);
    }

    public void addString(String str) {
        addToken(41);
        appendString(str);
    }

    public void addToken(int i) {
        if (i < 0 || i > 166) {
            throw new IllegalArgumentException();
        }
        append((char) i);
    }

    public int getCurrentOffset() {
        return this.sourceTop;
    }

    public String getEncodedSource() {
        return sourceToString(0);
    }

    public int markFunctionEnd(int i) {
        int currentOffset = getCurrentOffset();
        append((char) 167);
        return currentOffset;
    }

    public int markFunctionStart(int i) {
        int currentOffset = getCurrentOffset();
        if (i != 4) {
            addToken(110);
            append((char) i);
        }
        return currentOffset;
    }
}
