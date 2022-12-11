package org.mozilla.javascript.regexp;

import androidx.cardview.widget.RoundRectDrawableWithShadow;
import me.tvspark.outline;
import org.apache.http.message.TokenParser;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.IdFunctionObject;
import org.mozilla.javascript.IdScriptableObject;
import org.mozilla.javascript.Kit;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.TopLevel;
import org.mozilla.javascript.Undefined;
import org.simpleframework.xml.core.AnnotationHandler;

/* loaded from: classes5.dex */
public class NativeRegExp extends IdScriptableObject implements Function {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int ANCHOR_BOL = -2;
    public static final int INDEX_LEN = 2;
    public static final int Id_compile = 1;
    public static final int Id_exec = 4;
    public static final int Id_global = 3;
    public static final int Id_ignoreCase = 4;
    public static final int Id_lastIndex = 1;
    public static final int Id_multiline = 5;
    public static final int Id_prefix = 6;
    public static final int Id_source = 2;
    public static final int Id_test = 5;
    public static final int Id_toSource = 3;
    public static final int Id_toString = 2;
    public static final int JSREG_FOLD = 2;
    public static final int JSREG_GLOB = 1;
    public static final int JSREG_MULTILINE = 4;
    public static final int MATCH = 1;
    public static final int MAX_INSTANCE_ID = 5;
    public static final int MAX_PROTOTYPE_ID = 6;
    public static final int PREFIX = 2;
    public static final Object REGEXP_TAG = new Object();
    public static final byte REOP_ALNUM = 9;
    public static final byte REOP_ALT = 31;
    public static final byte REOP_ALTPREREQ = 53;
    public static final byte REOP_ALTPREREQ2 = 55;
    public static final byte REOP_ALTPREREQi = 54;
    public static final byte REOP_ASSERT = 41;
    public static final byte REOP_ASSERTNOTTEST = 44;
    public static final byte REOP_ASSERTTEST = 43;
    public static final byte REOP_ASSERT_NOT = 42;
    public static final byte REOP_BACKREF = 13;
    public static final byte REOP_BOL = 2;
    public static final byte REOP_CLASS = 22;
    public static final byte REOP_DIGIT = 7;
    public static final byte REOP_DOT = 6;
    public static final byte REOP_EMPTY = 1;
    public static final byte REOP_END = 57;
    public static final byte REOP_ENDCHILD = 49;
    public static final byte REOP_EOL = 3;
    public static final byte REOP_FLAT = 14;
    public static final byte REOP_FLAT1 = 15;
    public static final byte REOP_FLAT1i = 17;
    public static final byte REOP_FLATi = 16;
    public static final byte REOP_JUMP = 32;
    public static final byte REOP_LPAREN = 29;
    public static final byte REOP_MINIMALOPT = 47;
    public static final byte REOP_MINIMALPLUS = 46;
    public static final byte REOP_MINIMALQUANT = 48;
    public static final byte REOP_MINIMALREPEAT = 52;
    public static final byte REOP_MINIMALSTAR = 45;
    public static final byte REOP_NCLASS = 23;
    public static final byte REOP_NONALNUM = 10;
    public static final byte REOP_NONDIGIT = 8;
    public static final byte REOP_NONSPACE = 12;
    public static final byte REOP_OPT = 28;
    public static final byte REOP_PLUS = 27;
    public static final byte REOP_QUANT = 25;
    public static final byte REOP_REPEAT = 51;
    public static final byte REOP_RPAREN = 30;
    public static final byte REOP_SIMPLE_END = 23;
    public static final byte REOP_SIMPLE_START = 1;
    public static final byte REOP_SPACE = 11;
    public static final byte REOP_STAR = 26;
    public static final byte REOP_UCFLAT1 = 18;
    public static final byte REOP_UCFLAT1i = 19;
    public static final byte REOP_WBDRY = 4;
    public static final byte REOP_WNONBDRY = 5;
    public static final int TEST = 0;
    public static final boolean debug = false;
    public static final long serialVersionUID = 4965263491464903264L;
    public Object lastIndex;
    public int lastIndexAttr;

    /* renamed from: re */
    public RECompiled f4728re;

    public NativeRegExp() {
        this.lastIndex = Double.valueOf((double) RoundRectDrawableWithShadow.COS_45);
        this.lastIndexAttr = 6;
    }

    public NativeRegExp(Scriptable scriptable, RECompiled rECompiled) {
        Double valueOf = Double.valueOf((double) RoundRectDrawableWithShadow.COS_45);
        this.lastIndex = valueOf;
        this.lastIndexAttr = 6;
        this.f4728re = rECompiled;
        this.lastIndex = valueOf;
        ScriptRuntime.setBuiltinProtoAndParent(this, scriptable, TopLevel.Builtins.RegExp);
    }

    public static void addCharacterRangeToCharSet(RECharSet rECharSet, char c, char c2) {
        int i = c / '\b';
        int i2 = c2 / '\b';
        if (c2 >= rECharSet.length || c > c2) {
            throw ScriptRuntime.constructError("SyntaxError", "invalid range in character class");
        }
        char c3 = (char) (c & 7);
        char c4 = (char) (c2 & 7);
        if (i == i2) {
            byte[] bArr = rECharSet.bits;
            bArr[i] = (byte) (((255 >> (7 - (c4 - c3))) << c3) | bArr[i]);
            return;
        }
        byte[] bArr2 = rECharSet.bits;
        bArr2[i] = (byte) ((255 << c3) | bArr2[i]);
        while (true) {
            i++;
            if (i >= i2) {
                byte[] bArr3 = rECharSet.bits;
                bArr3[i2] = (byte) (bArr3[i2] | (255 >> (7 - c4)));
                return;
            }
            rECharSet.bits[i] = -1;
        }
    }

    public static void addCharacterToCharSet(RECharSet rECharSet, char c) {
        int i = c / '\b';
        if (c < rECharSet.length) {
            byte[] bArr = rECharSet.bits;
            bArr[i] = (byte) ((1 << (c & 7)) | bArr[i]);
            return;
        }
        throw ScriptRuntime.constructError("SyntaxError", "invalid range in character class");
    }

    public static int addIndex(byte[] bArr, int i, int i2) {
        if (i2 >= 0) {
            if (i2 > 65535) {
                throw Context.reportRuntimeError("Too complex regexp");
            }
            bArr[i] = (byte) (i2 >> 8);
            bArr[i + 1] = (byte) i2;
            return i + 2;
        }
        throw Kit.codeBug();
    }

    public static boolean backrefMatcher(REGlobalData rEGlobalData, int i, String str, int i2) {
        long[] jArr = rEGlobalData.parens;
        if (jArr == null || i >= jArr.length) {
            return false;
        }
        int parensIndex = rEGlobalData.parensIndex(i);
        if (parensIndex == -1) {
            return true;
        }
        int parensLength = rEGlobalData.parensLength(i);
        int i3 = rEGlobalData.f4732cp;
        if (i3 + parensLength > i2) {
            return false;
        }
        if ((rEGlobalData.regexp.flags & 2) != 0) {
            for (int i4 = 0; i4 < parensLength; i4++) {
                char charAt = str.charAt(parensIndex + i4);
                char charAt2 = str.charAt(rEGlobalData.f4732cp + i4);
                if (charAt != charAt2 && upcase(charAt) != upcase(charAt2)) {
                    return false;
                }
            }
        } else if (!str.regionMatches(parensIndex, str, i3, parensLength)) {
            return false;
        }
        rEGlobalData.f4732cp += parensLength;
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x00ff, code lost:
        reportError("msg.bad.range", "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0102, code lost:
        return false;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00fa A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x001c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00cb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0070 A[LOOP:1: B:58:0x005d->B:62:0x0070, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x006d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean calculateBitmapSize(CompilerState compilerState, RENode rENode, char[] cArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        char c;
        int i7 = i;
        rENode.bmsize = 0;
        rENode.sense = true;
        if (i7 == i2) {
            return true;
        }
        if (cArr[i7] == '^') {
            i7++;
            rENode.sense = false;
        }
        int i8 = 0;
        boolean z = false;
        char c2 = 0;
        while (i7 != i2) {
            int i9 = 92;
            if (cArr[i7] == '\\') {
                int i10 = i7 + 1;
                i3 = i10 + 1;
                char c3 = cArr[i10];
                if (c3 != 'D' && c3 != 'S' && c3 != 'W') {
                    if (c3 != 'f') {
                        char c4 = c3;
                        if (c3 != 'n') {
                            switch (c3) {
                                case '0':
                                case '1':
                                case '2':
                                case '3':
                                case '4':
                                case '5':
                                case '6':
                                case '7':
                                    int i11 = c3 - '0';
                                    char c5 = cArr[i3];
                                    c4 = i11;
                                    if ('0' <= c5) {
                                        c4 = i11;
                                        if (c5 <= '7') {
                                            i3++;
                                            int i12 = (c5 - '0') + (i11 * 8);
                                            char c6 = cArr[i3];
                                            i9 = i12;
                                            i9 = i12;
                                            if ('0' <= c6 && c6 <= '7') {
                                                i3++;
                                                int i13 = (c6 - '0') + (i12 * 8);
                                                c4 = i13;
                                                if (i13 > 255) {
                                                    i3--;
                                                    i9 = i12;
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    i9 = c4;
                                    break;
                                default:
                                    switch (c3) {
                                        case 'b':
                                            i9 = 8;
                                            break;
                                        case 'c':
                                            if (i3 < i2 && isControlLetter(cArr[i3])) {
                                                i7 = i3 + 1;
                                                char c7 = cArr[i3];
                                                break;
                                            } else {
                                                i7 = i3 - 1;
                                                break;
                                            }
                                            break;
                                        case 'd':
                                            if (!z) {
                                                i9 = 57;
                                                break;
                                            } else {
                                                reportError("msg.bad.range", "");
                                                return false;
                                            }
                                        default:
                                            switch (c3) {
                                                case 'r':
                                                    i9 = 13;
                                                    break;
                                                case 's':
                                                case 'w':
                                                    break;
                                                case 't':
                                                    i9 = 9;
                                                    break;
                                                case 'u':
                                                    i4 = 4;
                                                    i5 = 0;
                                                    i6 = 0;
                                                    while (i5 < i4 && i3 < i2) {
                                                        int i14 = i3 + 1;
                                                        i6 = Kit.xDigitToInt(cArr[i3], i6);
                                                        i5++;
                                                        if (i6 >= 0) {
                                                            i3 = i14 - i5;
                                                            break;
                                                        } else {
                                                            i3 = i14;
                                                        }
                                                    }
                                                    i9 = i6;
                                                    break;
                                                case 'v':
                                                    i9 = 11;
                                                    break;
                                                case 'x':
                                                    i4 = 2;
                                                    i5 = 0;
                                                    i6 = 0;
                                                    while (i5 < i4) {
                                                        int i142 = i3 + 1;
                                                        i6 = Kit.xDigitToInt(cArr[i3], i6);
                                                        i5++;
                                                        if (i6 >= 0) {
                                                        }
                                                    }
                                                    i9 = i6;
                                                    break;
                                                default:
                                                    i9 = c4;
                                                    break;
                                            }
                                    }
                            }
                            if (!z) {
                                if (c2 > i9) {
                                    reportError("msg.bad.range", "");
                                    return false;
                                }
                                z = false;
                            } else if (i7 < i2 - 1 && cArr[i7] == '-') {
                                i7++;
                                c2 = (char) i9;
                                z = true;
                            }
                            c = i9;
                            if ((2 & compilerState.flags) != 0) {
                                char c8 = (char) i9;
                                char upcase = upcase(c8);
                                char downcase = downcase(c8);
                                c = upcase >= downcase ? upcase : downcase;
                            }
                            if (c <= i8) {
                                i8 = c;
                            }
                        } else {
                            i9 = 10;
                        }
                    } else {
                        i9 = 12;
                    }
                }
                rENode.bmsize = 65536;
                return true;
            }
            i3 = i7 + 1;
            i9 = cArr[i7];
            i7 = i3;
            if (!z) {
            }
            c = i9;
            if ((2 & compilerState.flags) != 0) {
            }
            if (c <= i8) {
            }
        }
        rENode.bmsize = i8 + 1;
        return true;
    }

    public static boolean classMatcher(REGlobalData rEGlobalData, RECharSet rECharSet, char c) {
        if (!rECharSet.converted) {
            processCharSet(rEGlobalData, rECharSet);
        }
        int i = c >> 3;
        int i2 = rECharSet.length;
        boolean z = true;
        if (i2 != 0 && c < i2 && (rECharSet.bits[i] & (1 << (c & 7))) != 0) {
            z = false;
        }
        return rECharSet.sense ^ z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00dd, code lost:
        if (r10.kid2.f4733op == 2) goto L46;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static RECompiled compileRE(Context context, String str, String str2, boolean z) {
        int i;
        char c;
        int i2;
        int i3;
        RECompiled rECompiled = new RECompiled(str);
        int length = str.length();
        if (str2 != null) {
            i = 0;
            for (int i4 = 0; i4 < str2.length(); i4++) {
                char charAt = str2.charAt(i4);
                if (charAt == 'g') {
                    i3 = 1;
                } else if (charAt == 'i') {
                    i3 = 2;
                } else if (charAt == 'm') {
                    i3 = 4;
                } else {
                    reportError("msg.invalid.re.flag", String.valueOf(charAt));
                    i3 = 0;
                }
                if ((i & i3) != 0) {
                    reportError("msg.invalid.re.flag", String.valueOf(charAt));
                }
                i |= i3;
            }
        } else {
            i = 0;
        }
        rECompiled.flags = i;
        CompilerState compilerState = new CompilerState(context, rECompiled.source, length, i);
        if (z && length > 0) {
            RENode rENode = new RENode((byte) 14);
            compilerState.result = rENode;
            rENode.chr = compilerState.cpbegin[0];
            rENode.length = length;
            rENode.flatIndex = 0;
            compilerState.progLength += 5;
        } else if (!parseDisjunction(compilerState)) {
            return null;
        } else {
            if (compilerState.maxBackReference > compilerState.parenCount) {
                compilerState = new CompilerState(context, rECompiled.source, length, i);
                compilerState.backReferenceLimit = compilerState.parenCount;
                if (!parseDisjunction(compilerState)) {
                    return null;
                }
            }
        }
        rECompiled.program = new byte[compilerState.progLength + 1];
        int i5 = compilerState.classCount;
        if (i5 != 0) {
            rECompiled.classList = new RECharSet[i5];
            rECompiled.classCount = i5;
        }
        int emitREBytecode = emitREBytecode(compilerState, rECompiled, 0, compilerState.result);
        byte[] bArr = rECompiled.program;
        bArr[emitREBytecode] = REOP_END;
        rECompiled.parenCount = compilerState.parenCount;
        byte b = bArr[0];
        if (b != 2) {
            if (b != 31) {
                switch (b) {
                    case 14:
                    case 16:
                        c = rECompiled.source[getIndex(bArr, 1)];
                        rECompiled.anchorCh = c;
                        break;
                    case 15:
                    case 17:
                        i2 = bArr[1] & 255;
                        c = (char) i2;
                        rECompiled.anchorCh = c;
                        break;
                    case 18:
                    case 19:
                        i2 = getIndex(bArr, 1);
                        c = (char) i2;
                        rECompiled.anchorCh = c;
                        break;
                }
            } else {
                RENode rENode2 = compilerState.result;
                if (rENode2.kid.f4733op == 2) {
                }
            }
            return rECompiled;
        }
        rECompiled.anchorCh = -2;
        return rECompiled;
    }

    public static void doFlat(CompilerState compilerState, char c) {
        RENode rENode = new RENode((byte) 14);
        compilerState.result = rENode;
        rENode.chr = c;
        rENode.length = 1;
        rENode.flatIndex = -1;
        compilerState.progLength += 3;
    }

    public static char downcase(char c) {
        if (c < 128) {
            return ('A' > c || c > 'Z') ? c : (char) (c + TokenParser.f4579SP);
        }
        char lowerCase = Character.toLowerCase(c);
        return lowerCase < 128 ? c : lowerCase;
    }

    public static int emitREBytecode(CompilerState compilerState, RECompiled rECompiled, int i, RENode rENode) {
        int i2;
        int i3;
        byte[] bArr = rECompiled.program;
        while (rENode != null) {
            int i4 = i + 1;
            byte b = rENode.f4733op;
            bArr[i] = b;
            boolean z = true;
            if (b != 1) {
                if (b != 22) {
                    if (b != 25) {
                        if (b != 29) {
                            if (b != 31) {
                                if (b != 13) {
                                    if (b != 14) {
                                        if (b == 41) {
                                            int emitREBytecode = emitREBytecode(compilerState, rECompiled, i4 + 2, rENode.kid);
                                            i2 = emitREBytecode + 1;
                                            bArr[emitREBytecode] = REOP_ASSERTTEST;
                                        } else if (b != 42) {
                                            switch (b) {
                                                case 53:
                                                case 54:
                                                case 55:
                                                    if (b != 54) {
                                                        z = false;
                                                    }
                                                    char c = rENode.chr;
                                                    if (z) {
                                                        c = upcase(c);
                                                    }
                                                    addIndex(bArr, i4, c);
                                                    int i5 = i4 + 2;
                                                    addIndex(bArr, i5, z ? upcase((char) rENode.index) : rENode.index);
                                                    i4 = i5 + 2;
                                                    break;
                                            }
                                        } else {
                                            int emitREBytecode2 = emitREBytecode(compilerState, rECompiled, i4 + 2, rENode.kid);
                                            i2 = emitREBytecode2 + 1;
                                            bArr[emitREBytecode2] = REOP_ASSERTNOTTEST;
                                        }
                                        resolveForwardJump(bArr, i4, i2);
                                    } else {
                                        if (rENode.flatIndex != -1) {
                                            while (true) {
                                                RENode rENode2 = rENode.next;
                                                if (rENode2 != null && rENode2.f4733op == 14) {
                                                    int i6 = rENode.flatIndex;
                                                    int i7 = rENode.length;
                                                    if (i6 + i7 == rENode2.flatIndex) {
                                                        rENode.length = i7 + rENode2.length;
                                                        rENode.next = rENode2.next;
                                                    }
                                                }
                                            }
                                        }
                                        if (rENode.flatIndex != -1 && rENode.length > 1) {
                                            if ((compilerState.flags & 2) != 0) {
                                                bArr[i4 - 1] = 16;
                                            } else {
                                                bArr[i4 - 1] = 14;
                                            }
                                            i = addIndex(bArr, addIndex(bArr, i4, rENode.flatIndex), rENode.length);
                                        } else if (rENode.chr < 256) {
                                            if ((compilerState.flags & 2) != 0) {
                                                bArr[i4 - 1] = REOP_FLAT1i;
                                            } else {
                                                bArr[i4 - 1] = 15;
                                            }
                                            i = i4 + 1;
                                            bArr[i4] = (byte) rENode.chr;
                                        } else {
                                            if ((compilerState.flags & 2) != 0) {
                                                bArr[i4 - 1] = REOP_UCFLAT1i;
                                            } else {
                                                bArr[i4 - 1] = 18;
                                            }
                                            i3 = rENode.chr;
                                            i = addIndex(bArr, i4, i3);
                                        }
                                    }
                                }
                            }
                            RENode rENode3 = rENode.kid2;
                            int emitREBytecode3 = emitREBytecode(compilerState, rECompiled, i4 + 2, rENode.kid);
                            int i8 = emitREBytecode3 + 1;
                            bArr[emitREBytecode3] = 32;
                            int i9 = i8 + 2;
                            resolveForwardJump(bArr, i4, i9);
                            int emitREBytecode4 = emitREBytecode(compilerState, rECompiled, i9, rENode3);
                            int i10 = emitREBytecode4 + 1;
                            bArr[emitREBytecode4] = 32;
                            i = i10 + 2;
                            resolveForwardJump(bArr, i8, i);
                            resolveForwardJump(bArr, i10, i);
                        } else {
                            int emitREBytecode5 = emitREBytecode(compilerState, rECompiled, addIndex(bArr, i4, rENode.parenIndex), rENode.kid);
                            i4 = emitREBytecode5 + 1;
                            bArr[emitREBytecode5] = REOP_RPAREN;
                        }
                        i3 = rENode.parenIndex;
                        i = addIndex(bArr, i4, i3);
                    } else {
                        if (rENode.min == 0 && rENode.max == -1) {
                            bArr[i4 - 1] = rENode.greedy ? REOP_STAR : (byte) 45;
                        } else if (rENode.min == 0 && rENode.max == 1) {
                            bArr[i4 - 1] = rENode.greedy ? REOP_OPT : REOP_MINIMALOPT;
                        } else if (rENode.min == 1 && rENode.max == -1) {
                            bArr[i4 - 1] = rENode.greedy ? REOP_PLUS : REOP_MINIMALPLUS;
                        } else {
                            if (!rENode.greedy) {
                                bArr[i4 - 1] = REOP_MINIMALQUANT;
                            }
                            i4 = addIndex(bArr, addIndex(bArr, i4, rENode.min), rENode.max + 1);
                        }
                        int addIndex = addIndex(bArr, addIndex(bArr, i4, rENode.parenCount), rENode.parenIndex);
                        int emitREBytecode6 = emitREBytecode(compilerState, rECompiled, addIndex + 2, rENode.kid);
                        i2 = emitREBytecode6 + 1;
                        bArr[emitREBytecode6] = REOP_ENDCHILD;
                        resolveForwardJump(bArr, addIndex, i2);
                    }
                    i = i2;
                } else {
                    if (!rENode.sense) {
                        bArr[i4 - 1] = 23;
                    }
                    i = addIndex(bArr, i4, rENode.index);
                    rECompiled.classList[rENode.index] = new RECharSet(rENode.bmsize, rENode.startIndex, rENode.kidlen, rENode.sense);
                }
                rENode = rENode.next;
            } else {
                i4--;
            }
            i = i4;
            rENode = rENode.next;
        }
        return i;
    }

    public static String escapeRegExp(Object obj) {
        String scriptRuntime = ScriptRuntime.toString(obj);
        StringBuilder sb = null;
        int i = 0;
        for (int indexOf = scriptRuntime.indexOf(47); indexOf > -1; indexOf = scriptRuntime.indexOf(47, indexOf + 1)) {
            if (indexOf == i || scriptRuntime.charAt(indexOf - 1) != '\\') {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append((CharSequence) scriptRuntime, i, indexOf);
                sb.append("\\/");
                i = indexOf + 1;
            }
        }
        if (sb != null) {
            sb.append((CharSequence) scriptRuntime, i, scriptRuntime.length());
            return sb.toString();
        }
        return scriptRuntime;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Object execSub(Context context, Scriptable scriptable, Object[] objArr, int i) {
        Object obj;
        String str;
        double integer;
        RegExpImpl impl = getImpl(context);
        if (objArr.length == 0) {
            str = impl.input;
            if (str == null) {
                obj = Undefined.instance;
            }
            String str2 = str;
            int i2 = this.f4728re.flags & 1;
            double d = RoundRectDrawableWithShadow.COS_45;
            integer = i2 == 0 ? ScriptRuntime.toInteger(this.lastIndex) : 0.0d;
            if (integer >= RoundRectDrawableWithShadow.COS_45 || str2.length() < integer) {
                this.lastIndex = Double.valueOf((double) RoundRectDrawableWithShadow.COS_45);
                return null;
            }
            int[] iArr = {(int) integer};
            Object executeRegExp = executeRegExp(context, scriptable, impl, str2, iArr, i);
            if ((this.f4728re.flags & 1) == 0) {
                return executeRegExp;
            }
            if (executeRegExp != null && executeRegExp != Undefined.instance) {
                d = iArr[0];
            }
            this.lastIndex = Double.valueOf(d);
            return executeRegExp;
        }
        obj = objArr[0];
        str = ScriptRuntime.toString(obj);
        String str22 = str;
        int i22 = this.f4728re.flags & 1;
        double d2 = RoundRectDrawableWithShadow.COS_45;
        if (i22 == 0) {
        }
        if (integer >= RoundRectDrawableWithShadow.COS_45) {
        }
        this.lastIndex = Double.valueOf((double) RoundRectDrawableWithShadow.COS_45);
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0401  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0413  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x03df  */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v93, types: [int] */
    /* JADX WARN: Type inference failed for: r1v23, types: [int] */
    /* JADX WARN: Type inference failed for: r1v26, types: [int] */
    /* JADX WARN: Type inference failed for: r1v37, types: [int] */
    /* JADX WARN: Type inference failed for: r1v45, types: [int] */
    /* JADX WARN: Type inference failed for: r1v52, types: [int] */
    /* JADX WARN: Type inference failed for: r1v55, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v41, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean executeREBytecode(REGlobalData rEGlobalData, String str, int i) {
        byte b;
        int i2;
        int i3;
        byte b2;
        byte b3;
        int i4;
        boolean z;
        int i5;
        int i6;
        int i7;
        boolean z2;
        byte b4;
        int i8;
        int i9;
        boolean z3;
        int i10;
        int i11;
        int i12;
        byte b5;
        byte b6;
        byte b7;
        byte b8;
        boolean z4;
        RECompiled rECompiled = rEGlobalData.regexp;
        byte[] bArr = rECompiled.program;
        byte b9 = bArr[0];
        int i13 = rECompiled.anchorCh;
        byte b10 = REOP_END;
        byte b11 = REOP_MINIMALREPEAT;
        int i14 = 1;
        if (i13 >= 0 || !reopIsSimple(b9)) {
            b = b9;
            i2 = 1;
        } else {
            while (true) {
                if (rEGlobalData.f4732cp > i) {
                    z4 = false;
                    break;
                }
                int simpleMatch = simpleMatch(rEGlobalData, str, b9, bArr, 1, i, true);
                if (simpleMatch >= 0) {
                    i14 = simpleMatch + 1;
                    b9 = bArr[simpleMatch];
                    z4 = true;
                    break;
                }
                rEGlobalData.skipped++;
                rEGlobalData.f4732cp++;
            }
            if (!z4) {
                return false;
            }
            b = b9;
            i2 = i14;
        }
        int i15 = 0;
        byte b12 = REOP_END;
        boolean z5 = false;
        while (true) {
            if (reopIsSimple(b)) {
                int simpleMatch2 = simpleMatch(rEGlobalData, str, b, bArr, i2, i, true);
                boolean z6 = simpleMatch2 >= 0;
                if (z6) {
                    i2 = simpleMatch2;
                }
                z5 = z6;
            } else if (b == b10) {
                return true;
            } else {
                switch (b) {
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                        switch (b) {
                            case 25:
                                z = true;
                                int offset = getOffset(bArr, i2);
                                int i16 = i2 + 2;
                                i6 = getOffset(bArr, i16) - 1;
                                i7 = offset;
                                i5 = i16 + 2;
                                z2 = z;
                                pushProgState(rEGlobalData, i7, i6, rEGlobalData.f4732cp, null, b12, i15);
                                if (!z2) {
                                    pushBackTrackState(rEGlobalData, REOP_REPEAT, i5);
                                    int i17 = i5 + 6;
                                    int i18 = i17 + 1;
                                    b4 = bArr[i17];
                                    i2 = i18;
                                    i15 = i5;
                                    b12 = REOP_REPEAT;
                                } else if (i7 == 0) {
                                    pushBackTrackState(rEGlobalData, REOP_MINIMALREPEAT, i5);
                                    popProgState(rEGlobalData);
                                    int i19 = i5 + 4;
                                    int offset2 = getOffset(bArr, i19) + i19;
                                    int i20 = offset2 + 1;
                                    b = bArr[offset2];
                                    i2 = i20;
                                    b10 = REOP_END;
                                    b11 = REOP_MINIMALREPEAT;
                                    break;
                                } else {
                                    int i21 = i5 + 6;
                                    int i22 = i21 + 1;
                                    b4 = bArr[i21];
                                    i2 = i22;
                                    i15 = i5;
                                    b12 = REOP_MINIMALREPEAT;
                                }
                                b = b4;
                                b10 = REOP_END;
                                b11 = REOP_MINIMALREPEAT;
                            case 26:
                                z = true;
                                i5 = i2;
                                i6 = -1;
                                i7 = 0;
                                z2 = z;
                                pushProgState(rEGlobalData, i7, i6, rEGlobalData.f4732cp, null, b12, i15);
                                if (!z2) {
                                }
                                b = b4;
                                b10 = REOP_END;
                                b11 = REOP_MINIMALREPEAT;
                                break;
                            case 27:
                                z = true;
                                i5 = i2;
                                i6 = -1;
                                i7 = 1;
                                z2 = z;
                                pushProgState(rEGlobalData, i7, i6, rEGlobalData.f4732cp, null, b12, i15);
                                if (!z2) {
                                }
                                b = b4;
                                b10 = REOP_END;
                                b11 = REOP_MINIMALREPEAT;
                                break;
                            case 28:
                                z = true;
                                i5 = i2;
                                i6 = 1;
                                i7 = 0;
                                z2 = z;
                                pushProgState(rEGlobalData, i7, i6, rEGlobalData.f4732cp, null, b12, i15);
                                if (!z2) {
                                }
                                b = b4;
                                b10 = REOP_END;
                                b11 = REOP_MINIMALREPEAT;
                                break;
                            default:
                                switch (b) {
                                    case 45:
                                        z = false;
                                        i5 = i2;
                                        i6 = -1;
                                        i7 = 0;
                                        z2 = z;
                                        pushProgState(rEGlobalData, i7, i6, rEGlobalData.f4732cp, null, b12, i15);
                                        if (!z2) {
                                        }
                                        b = b4;
                                        b10 = REOP_END;
                                        b11 = REOP_MINIMALREPEAT;
                                        break;
                                    case 46:
                                        z = false;
                                        i5 = i2;
                                        i6 = -1;
                                        i7 = 1;
                                        z2 = z;
                                        pushProgState(rEGlobalData, i7, i6, rEGlobalData.f4732cp, null, b12, i15);
                                        if (!z2) {
                                        }
                                        b = b4;
                                        b10 = REOP_END;
                                        b11 = REOP_MINIMALREPEAT;
                                        break;
                                    case 47:
                                        z = false;
                                        i5 = i2;
                                        i6 = 1;
                                        i7 = 0;
                                        z2 = z;
                                        pushProgState(rEGlobalData, i7, i6, rEGlobalData.f4732cp, null, b12, i15);
                                        if (!z2) {
                                        }
                                        b = b4;
                                        b10 = REOP_END;
                                        b11 = REOP_MINIMALREPEAT;
                                        break;
                                    case 48:
                                        z = false;
                                        int offset3 = getOffset(bArr, i2);
                                        int i162 = i2 + 2;
                                        i6 = getOffset(bArr, i162) - 1;
                                        i7 = offset3;
                                        i5 = i162 + 2;
                                        z2 = z;
                                        pushProgState(rEGlobalData, i7, i6, rEGlobalData.f4732cp, null, b12, i15);
                                        if (!z2) {
                                        }
                                        b = b4;
                                        b10 = REOP_END;
                                        b11 = REOP_MINIMALREPEAT;
                                        break;
                                    default:
                                        throw Kit.codeBug();
                                }
                        }
                    case 29:
                        int index = getIndex(bArr, i2);
                        int i23 = i2 + 2;
                        rEGlobalData.setParens(index, rEGlobalData.f4732cp, 0);
                        i3 = i23 + 1;
                        b = bArr[i23];
                        i2 = i3;
                        b10 = REOP_END;
                        b11 = REOP_MINIMALREPEAT;
                        break;
                    case 30:
                        int index2 = getIndex(bArr, i2);
                        int i24 = i2 + 2;
                        int parensIndex = rEGlobalData.parensIndex(index2);
                        rEGlobalData.setParens(index2, parensIndex, rEGlobalData.f4732cp - parensIndex);
                        i3 = i24 + 1;
                        b = bArr[i24];
                        i2 = i3;
                        b10 = REOP_END;
                        b11 = REOP_MINIMALREPEAT;
                        break;
                    case 31:
                        int offset4 = getOffset(bArr, i2) + i2;
                        int i25 = i2 + 2;
                        int i26 = i25 + 1;
                        b2 = bArr[i25];
                        int i27 = rEGlobalData.f4732cp;
                        if (reopIsSimple(b2)) {
                            int simpleMatch3 = simpleMatch(rEGlobalData, str, b2, bArr, i26, i, true);
                            if (simpleMatch3 < 0) {
                                i2 = offset4 + 1;
                                b = bArr[offset4];
                                b10 = REOP_END;
                                b11 = REOP_MINIMALREPEAT;
                                break;
                            } else {
                                b3 = bArr[simpleMatch3];
                                i4 = simpleMatch3 + 1;
                                z5 = true;
                            }
                        } else {
                            b3 = b2;
                            i4 = i26;
                        }
                        pushBackTrackState(rEGlobalData, bArr[offset4], offset4 + 1, i27, b12, i15);
                        b = b3;
                        i2 = i4;
                        b10 = REOP_END;
                        b11 = REOP_MINIMALREPEAT;
                    case 32:
                        int offset5 = getOffset(bArr, i2) + i2;
                        i2 = offset5 + 1;
                        b = bArr[offset5];
                        b10 = REOP_END;
                        b11 = REOP_MINIMALREPEAT;
                        break;
                    default:
                        switch (b) {
                            case 41:
                                int index3 = getIndex(bArr, i2) + i2;
                                int i28 = i2 + 2;
                                i4 = i28 + 1;
                                b7 = bArr[i28];
                                if (!reopIsSimple(b7) || simpleMatch(rEGlobalData, str, b7, bArr, i4, i, false) >= 0) {
                                    pushProgState(rEGlobalData, 0, 0, rEGlobalData.f4732cp, rEGlobalData.backTrackStackTop, b12, i15);
                                    pushBackTrackState(rEGlobalData, REOP_ASSERTTEST, index3);
                                    b = b7;
                                    i2 = i4;
                                    b10 = REOP_END;
                                    b11 = REOP_MINIMALREPEAT;
                                    break;
                                }
                                i2 = i4;
                                z5 = false;
                                break;
                            case 42:
                                int index4 = getIndex(bArr, i2) + i2;
                                int i29 = i2 + 2;
                                i4 = i29 + 1;
                                b7 = bArr[i29];
                                if (reopIsSimple(b7)) {
                                    b8 = REOP_ASSERTNOTTEST;
                                    int simpleMatch4 = simpleMatch(rEGlobalData, str, b7, bArr, i4, i, false);
                                    if (simpleMatch4 >= 0) {
                                        if (bArr[simpleMatch4] != 44) {
                                        }
                                        i2 = i4;
                                        z5 = false;
                                        break;
                                    }
                                } else {
                                    b8 = REOP_ASSERTNOTTEST;
                                }
                                pushProgState(rEGlobalData, 0, 0, rEGlobalData.f4732cp, rEGlobalData.backTrackStackTop, b12, i15);
                                pushBackTrackState(rEGlobalData, b8, index4);
                                b = b7;
                                i2 = i4;
                                b10 = REOP_END;
                                b11 = REOP_MINIMALREPEAT;
                                break;
                            case 43:
                            case 44:
                                REProgState popProgState = popProgState(rEGlobalData);
                                rEGlobalData.f4732cp = popProgState.index;
                                rEGlobalData.backTrackStackTop = popProgState.backTrack;
                                int i30 = popProgState.continuationPc;
                                ?? r0 = popProgState.continuationOp;
                                if (b == 44) {
                                    z5 = !z5;
                                }
                                b12 = r0;
                                i15 = i30;
                                break;
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                                switch (b) {
                                }
                            case 49:
                                i2 = i15;
                                b = b12;
                                z5 = true;
                                continue;
                            default:
                                switch (b) {
                                    case 51:
                                        while (true) {
                                            REProgState popProgState2 = popProgState(rEGlobalData);
                                            int i31 = popProgState2.min;
                                            if (!z5) {
                                                if (i31 == 0) {
                                                    z5 = true;
                                                }
                                                i8 = popProgState2.continuationPc;
                                                ?? r1 = popProgState2.continuationOp;
                                                int i32 = i2 + 4;
                                                i2 = i32 + getOffset(bArr, i32);
                                                b5 = r1;
                                                break;
                                            } else if (i31 == 0 && rEGlobalData.f4732cp == popProgState2.index) {
                                                i12 = popProgState2.continuationPc;
                                                ?? r12 = popProgState2.continuationOp;
                                                int i33 = i2 + 4;
                                                i2 = i33 + getOffset(bArr, i33);
                                                b6 = r12;
                                            } else {
                                                int i34 = popProgState2.min;
                                                int i35 = popProgState2.max;
                                                if (i34 != 0) {
                                                    i34--;
                                                }
                                                int i36 = i34;
                                                if (i35 != -1) {
                                                    i35--;
                                                }
                                                int i37 = i35;
                                                if (i37 == 0) {
                                                    int i38 = popProgState2.continuationPc;
                                                    ?? r13 = popProgState2.continuationOp;
                                                    int i39 = i2 + 4;
                                                    i2 = i39 + getOffset(bArr, i39);
                                                    i15 = i38;
                                                    b12 = r13;
                                                    z5 = true;
                                                    break;
                                                } else {
                                                    int i40 = i2 + 6;
                                                    byte b13 = bArr[i40];
                                                    int i41 = rEGlobalData.f4732cp;
                                                    if (reopIsSimple(b13)) {
                                                        i9 = i41;
                                                        int simpleMatch5 = simpleMatch(rEGlobalData, str, b13, bArr, i40 + 1, i, true);
                                                        if (simpleMatch5 < 0) {
                                                            boolean z7 = i36 == 0;
                                                            int i42 = popProgState2.continuationPc;
                                                            ?? r2 = popProgState2.continuationOp;
                                                            int i43 = i2 + 4;
                                                            i2 = i43 + getOffset(bArr, i43);
                                                            z5 = z7;
                                                            i15 = i42;
                                                            b12 = r2;
                                                            break;
                                                        } else {
                                                            i10 = simpleMatch5;
                                                            z3 = true;
                                                        }
                                                    } else {
                                                        i9 = i41;
                                                        z3 = z5;
                                                        i10 = i40;
                                                    }
                                                    pushProgState(rEGlobalData, i36, i37, i9, null, popProgState2.continuationOp, popProgState2.continuationPc);
                                                    if (i36 == 0) {
                                                        pushBackTrackState(rEGlobalData, REOP_REPEAT, i2, i9, popProgState2.continuationOp, popProgState2.continuationPc);
                                                        int index5 = getIndex(bArr, i2);
                                                        int index6 = getIndex(bArr, i2 + 2);
                                                        for (int i44 = 0; i44 < index5; i44++) {
                                                            rEGlobalData.setParens(index6 + i44, -1, 0);
                                                        }
                                                    }
                                                    if (bArr[i10] != 49) {
                                                        i11 = i10 + 1;
                                                        b = bArr[i10];
                                                        z5 = z3;
                                                        b10 = REOP_END;
                                                        b12 = REOP_REPEAT;
                                                        break;
                                                    } else {
                                                        z5 = z3;
                                                    }
                                                }
                                            }
                                        }
                                        i15 = i12;
                                        b12 = b6;
                                        z5 = false;
                                        break;
                                    case 52:
                                        REProgState popProgState3 = popProgState(rEGlobalData);
                                        if (!z5) {
                                            int i45 = popProgState3.max;
                                            if (i45 != -1 && i45 <= 0) {
                                                i8 = popProgState3.continuationPc;
                                                b5 = popProgState3.continuationOp;
                                                i15 = i8;
                                                b12 = b5;
                                                break;
                                            } else {
                                                pushProgState(rEGlobalData, popProgState3.min, popProgState3.max, rEGlobalData.f4732cp, null, popProgState3.continuationOp, popProgState3.continuationPc);
                                                int index7 = getIndex(bArr, i2);
                                                int i46 = i2 + 2;
                                                int index8 = getIndex(bArr, i46);
                                                int i47 = i46 + 4;
                                                for (int i48 = 0; i48 < index7; i48++) {
                                                    rEGlobalData.setParens(index8 + i48, -1, 0);
                                                }
                                                i11 = i47 + 1;
                                                b = bArr[i47];
                                            }
                                        } else if (popProgState3.min == 0 && rEGlobalData.f4732cp == popProgState3.index) {
                                            i12 = popProgState3.continuationPc;
                                            b6 = popProgState3.continuationOp;
                                            i15 = i12;
                                            b12 = b6;
                                            z5 = false;
                                            break;
                                        } else {
                                            int i49 = popProgState3.min;
                                            int i50 = popProgState3.max;
                                            if (i49 != 0) {
                                                i49--;
                                            }
                                            int i51 = i49;
                                            if (i50 != -1) {
                                                i50--;
                                            }
                                            pushProgState(rEGlobalData, i51, i50, rEGlobalData.f4732cp, null, popProgState3.continuationOp, popProgState3.continuationPc);
                                            if (i51 != 0) {
                                                int index9 = getIndex(bArr, i2);
                                                int i52 = i2 + 2;
                                                int index10 = getIndex(bArr, i52);
                                                int i53 = i52 + 4;
                                                for (int i54 = 0; i54 < index9; i54++) {
                                                    rEGlobalData.setParens(index10 + i54, -1, 0);
                                                }
                                                i11 = i53 + 1;
                                                b = bArr[i53];
                                            } else {
                                                int i55 = popProgState3.continuationPc;
                                                ?? r14 = popProgState3.continuationOp;
                                                pushBackTrackState(rEGlobalData, b11, i2);
                                                popProgState(rEGlobalData);
                                                int i56 = i2 + 4;
                                                int offset6 = getOffset(bArr, i56) + i56;
                                                i2 = offset6 + 1;
                                                b = bArr[offset6];
                                                i15 = i55;
                                                b12 = r14;
                                                b10 = REOP_END;
                                                continue;
                                            }
                                        }
                                        b10 = REOP_END;
                                        b12 = REOP_MINIMALREPEAT;
                                        int i57 = i11;
                                        i15 = i2;
                                        i2 = i57;
                                        break;
                                    case 53:
                                    case 54:
                                    case 55:
                                        char index11 = (char) getIndex(bArr, i2);
                                        int i58 = i2 + 2;
                                        char index12 = (char) getIndex(bArr, i58);
                                        i2 = i58 + 2;
                                        int i59 = rEGlobalData.f4732cp;
                                        if (i59 != i) {
                                            char charAt = str.charAt(i59);
                                            if (b == 55) {
                                                if (charAt != index11) {
                                                    if (classMatcher(rEGlobalData, rEGlobalData.regexp.classList[index12], charAt)) {
                                                    }
                                                }
                                                int offset42 = getOffset(bArr, i2) + i2;
                                                int i252 = i2 + 2;
                                                int i262 = i252 + 1;
                                                b2 = bArr[i252];
                                                int i272 = rEGlobalData.f4732cp;
                                                if (reopIsSimple(b2)) {
                                                }
                                                pushBackTrackState(rEGlobalData, bArr[offset42], offset42 + 1, i272, b12, i15);
                                                b = b3;
                                                i2 = i4;
                                                b10 = REOP_END;
                                                b11 = REOP_MINIMALREPEAT;
                                                break;
                                            } else {
                                                if (b == 54) {
                                                    charAt = upcase(charAt);
                                                }
                                                if (charAt != index11) {
                                                    if (charAt == index12) {
                                                    }
                                                }
                                                int offset422 = getOffset(bArr, i2) + i2;
                                                int i2522 = i2 + 2;
                                                int i2622 = i2522 + 1;
                                                b2 = bArr[i2522];
                                                int i2722 = rEGlobalData.f4732cp;
                                                if (reopIsSimple(b2)) {
                                                }
                                                pushBackTrackState(rEGlobalData, bArr[offset422], offset422 + 1, i2722, b12, i15);
                                                b = b3;
                                                i2 = i4;
                                                b10 = REOP_END;
                                                b11 = REOP_MINIMALREPEAT;
                                            }
                                        }
                                        z5 = false;
                                        break;
                                    default:
                                        throw Kit.codeBug("invalid bytecode");
                                }
                        }
                }
            }
            if (!z5) {
                REBackTrackData rEBackTrackData = rEGlobalData.backTrackStackTop;
                if (rEBackTrackData == null) {
                    return false;
                }
                rEGlobalData.backTrackStackTop = rEBackTrackData.previous;
                rEGlobalData.parens = rEBackTrackData.parens;
                rEGlobalData.f4732cp = rEBackTrackData.f4729cp;
                rEGlobalData.stateStackTop = rEBackTrackData.stateStackTop;
                ?? r15 = rEBackTrackData.continuationOp;
                int i60 = rEBackTrackData.continuationPc;
                i2 = rEBackTrackData.f4731pc;
                ?? r02 = rEBackTrackData.f4730op;
                b12 = r15;
                i15 = i60;
                b10 = REOP_END;
                b11 = REOP_MINIMALREPEAT;
                b = r02;
            } else {
                i3 = i2 + 1;
                b = bArr[i2];
                i2 = i3;
                b10 = REOP_END;
                b11 = REOP_MINIMALREPEAT;
            }
        }
    }

    public static boolean flatNIMatcher(REGlobalData rEGlobalData, int i, int i2, String str, int i3) {
        if (rEGlobalData.f4732cp + i2 > i3) {
            return false;
        }
        char[] cArr = rEGlobalData.regexp.source;
        for (int i4 = 0; i4 < i2; i4++) {
            char c = cArr[i + i4];
            char charAt = str.charAt(rEGlobalData.f4732cp + i4);
            if (c != charAt && upcase(c) != upcase(charAt)) {
                return false;
            }
        }
        rEGlobalData.f4732cp += i2;
        return true;
    }

    public static boolean flatNMatcher(REGlobalData rEGlobalData, int i, int i2, String str, int i3) {
        if (rEGlobalData.f4732cp + i2 > i3) {
            return false;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            if (rEGlobalData.regexp.source[i + i4] != str.charAt(rEGlobalData.f4732cp + i4)) {
                return false;
            }
        }
        rEGlobalData.f4732cp += i2;
        return true;
    }

    public static int getDecimalValue(char c, CompilerState compilerState, int i, String str) {
        int i2 = compilerState.f4726cp;
        char[] cArr = compilerState.cpbegin;
        int i3 = c - 48;
        boolean z = false;
        while (true) {
            int i4 = compilerState.f4726cp;
            if (i4 == compilerState.cpend) {
                break;
            }
            char c2 = cArr[i4];
            if (!isDigit(c2)) {
                break;
            }
            if (!z) {
                int i5 = (c2 - '0') + (i3 * 10);
                if (i5 < i) {
                    i3 = i5;
                } else {
                    i3 = i;
                    z = true;
                }
            }
            compilerState.f4726cp++;
        }
        if (z) {
            reportError(str, String.valueOf(cArr, i2, compilerState.f4726cp - i2));
        }
        return i3;
    }

    public static RegExpImpl getImpl(Context context) {
        return (RegExpImpl) ScriptRuntime.getRegExpProxy(context);
    }

    public static int getIndex(byte[] bArr, int i) {
        return (bArr[i + 1] & 255) | ((bArr[i] & 255) << 8);
    }

    public static int getOffset(byte[] bArr, int i) {
        return getIndex(bArr, i);
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        NativeRegExp nativeRegExp = new NativeRegExp();
        nativeRegExp.f4728re = compileRE(context, "", null, false);
        nativeRegExp.activatePrototypeMap(6);
        nativeRegExp.setParentScope(scriptable);
        nativeRegExp.setPrototype(ScriptableObject.getObjectPrototype(scriptable));
        NativeRegExpCtor nativeRegExpCtor = new NativeRegExpCtor();
        nativeRegExp.defineProperty("constructor", nativeRegExpCtor, 2);
        ScriptRuntime.setFunctionProtoAndParent(nativeRegExpCtor, scriptable);
        nativeRegExpCtor.setImmunePrototypeProperty(nativeRegExp);
        if (z) {
            nativeRegExp.sealObject();
            nativeRegExpCtor.sealObject();
        }
        ScriptableObject.defineProperty(scriptable, "RegExp", nativeRegExpCtor, 2);
    }

    public static boolean isControlLetter(char c) {
        return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
    }

    public static boolean isDigit(char c) {
        return '0' <= c && c <= '9';
    }

    public static boolean isLineTerm(char c) {
        return ScriptRuntime.isJSLineTerminator(c);
    }

    public static boolean isREWhiteSpace(int i) {
        return ScriptRuntime.isJSWhitespaceOrLineTerminator(i);
    }

    public static boolean isWord(char c) {
        return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z') || isDigit(c) || c == '_';
    }

    public static boolean matchRegExp(REGlobalData rEGlobalData, RECompiled rECompiled, String str, int i, int i2, boolean z) {
        int i3 = rECompiled.parenCount;
        if (i3 != 0) {
            rEGlobalData.parens = new long[i3];
        } else {
            rEGlobalData.parens = null;
        }
        rEGlobalData.backTrackStackTop = null;
        rEGlobalData.stateStackTop = null;
        rEGlobalData.multiline = z || (rECompiled.flags & 4) != 0;
        rEGlobalData.regexp = rECompiled;
        int i4 = rECompiled.anchorCh;
        int i5 = i;
        while (i5 <= i2) {
            if (i4 >= 0) {
                while (i5 != i2) {
                    char charAt = str.charAt(i5);
                    if (charAt != i4 && ((rEGlobalData.regexp.flags & 2) == 0 || upcase(charAt) != upcase((char) i4))) {
                        i5++;
                    }
                }
                return false;
            }
            rEGlobalData.f4732cp = i5;
            rEGlobalData.skipped = i5 - i;
            for (int i6 = 0; i6 < rECompiled.parenCount; i6++) {
                rEGlobalData.parens[i6] = -1;
            }
            boolean executeREBytecode = executeREBytecode(rEGlobalData, str, i2);
            rEGlobalData.backTrackStackTop = null;
            rEGlobalData.stateStackTop = null;
            if (executeREBytecode) {
                return true;
            }
            if (i4 == -2 && !rEGlobalData.multiline) {
                rEGlobalData.skipped = i2;
                return false;
            }
            i5 = rEGlobalData.skipped + i + 1;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0034, code lost:
        if (r1 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0036, code lost:
        r1 = new org.mozilla.javascript.regexp.RENode((byte) 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003b, code lost:
        r6.result = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003d, code lost:
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean parseAlternative(CompilerState compilerState) {
        char[] cArr = compilerState.cpbegin;
        RENode rENode = null;
        RENode rENode2 = null;
        while (true) {
            int i = compilerState.f4726cp;
            if (i == compilerState.cpend || cArr[i] == '|' || (compilerState.parenNesting != 0 && cArr[i] == ')')) {
                break;
            } else if (!parseTerm(compilerState)) {
                return false;
            } else {
                if (rENode == null) {
                    rENode = compilerState.result;
                    rENode2 = rENode;
                } else {
                    rENode2.next = compilerState.result;
                }
                while (true) {
                    RENode rENode3 = rENode2.next;
                    if (rENode3 != null) {
                        rENode2 = rENode3;
                    }
                }
            }
        }
    }

    public static boolean parseDisjunction(CompilerState compilerState) {
        int i;
        int i2;
        int i3;
        if (!parseAlternative(compilerState)) {
            return false;
        }
        char[] cArr = compilerState.cpbegin;
        int i4 = compilerState.f4726cp;
        if (i4 != cArr.length && cArr[i4] == '|') {
            compilerState.f4726cp = i4 + 1;
            RENode rENode = new RENode((byte) 31);
            rENode.kid = compilerState.result;
            if (!parseDisjunction(compilerState)) {
                return false;
            }
            RENode rENode2 = compilerState.result;
            rENode.kid2 = rENode2;
            compilerState.result = rENode;
            if (rENode.kid.f4733op == 14 && rENode2.f4733op == 14) {
                rENode.f4733op = (compilerState.flags & 2) == 0 ? REOP_ALTPREREQ : REOP_ALTPREREQi;
                rENode.chr = rENode.kid.chr;
                i3 = rENode.kid2.chr;
            } else {
                RENode rENode3 = rENode.kid;
                if (rENode3.f4733op == 22 && (i3 = rENode3.index) < 256) {
                    RENode rENode4 = rENode.kid2;
                    if (rENode4.f4733op == 14 && (compilerState.flags & 2) == 0) {
                        rENode.f4733op = REOP_ALTPREREQ2;
                        rENode.chr = rENode4.chr;
                    }
                }
                RENode rENode5 = rENode.kid;
                if (rENode5.f4733op == 14) {
                    RENode rENode6 = rENode.kid2;
                    if (rENode6.f4733op == 22 && (i2 = rENode6.index) < 256 && (compilerState.flags & 2) == 0) {
                        rENode.f4733op = REOP_ALTPREREQ2;
                        rENode.chr = rENode5.chr;
                        rENode.index = i2;
                        i = compilerState.progLength + 13;
                        compilerState.progLength = i;
                    }
                }
                i = compilerState.progLength + 9;
                compilerState.progLength = i;
            }
            rENode.index = i3;
            i = compilerState.progLength + 13;
            compilerState.progLength = i;
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0142 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x02ad A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x036f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0339  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean parseTerm(CompilerState compilerState) {
        RENode rENode;
        RENode rENode2;
        int i;
        String str;
        String str2;
        int i2;
        int i3;
        RENode rENode3;
        int i4;
        boolean z;
        String str3;
        RENode rENode4;
        char c;
        int i5;
        char c2;
        char c3;
        int i6;
        char c4;
        int i7;
        String str4;
        char c5;
        char[] cArr = compilerState.cpbegin;
        int i8 = compilerState.f4726cp;
        int i9 = i8 + 1;
        compilerState.f4726cp = i9;
        char c6 = cArr[i8];
        int i10 = compilerState.parenCount;
        if (c6 != '$') {
            if (c6 != '.') {
                if (c6 != '?') {
                    if (c6 != '^') {
                        char c7 = '\\';
                        if (c6 == '[') {
                            RENode rENode5 = new RENode(REOP_CLASS);
                            compilerState.result = rENode5;
                            int i11 = compilerState.f4726cp;
                            rENode5.startIndex = i11;
                            while (true) {
                                int i12 = compilerState.f4726cp;
                                if (i12 == compilerState.cpend) {
                                    str3 = "msg.unterm.class";
                                    break;
                                }
                                if (cArr[i12] == '\\') {
                                    compilerState.f4726cp = i12 + 1;
                                } else if (cArr[i12] == ']') {
                                    RENode rENode6 = compilerState.result;
                                    rENode6.kidlen = i12 - i11;
                                    int i13 = compilerState.classCount;
                                    compilerState.classCount = i13 + 1;
                                    rENode6.index = i13;
                                    compilerState.f4726cp = i12 + 1;
                                    if (!calculateBitmapSize(compilerState, rENode6, cArr, i11, i12)) {
                                        return false;
                                    }
                                }
                                compilerState.f4726cp++;
                            }
                            reportError(str3, "");
                            return false;
                        }
                        int i14 = 4;
                        if (c6 != '\\') {
                            switch (c6) {
                                case '(':
                                    RENode rENode7 = null;
                                    if (i9 + 1 < compilerState.cpend && cArr[i9] == '?' && ((c5 = cArr[i9 + 1]) == '=' || c5 == '!' || c5 == ':')) {
                                        compilerState.f4726cp += 2;
                                        if (c5 == '=') {
                                            rENode7 = new RENode(REOP_ASSERT);
                                        } else if (c5 == '!') {
                                            rENode7 = new RENode((byte) 42);
                                        }
                                        compilerState.progLength += 4;
                                    } else {
                                        rENode7 = new RENode(REOP_LPAREN);
                                        compilerState.progLength += 6;
                                        int i15 = compilerState.parenCount;
                                        compilerState.parenCount = i15 + 1;
                                        rENode7.parenIndex = i15;
                                    }
                                    compilerState.parenNesting++;
                                    if (parseDisjunction(compilerState)) {
                                        int i16 = compilerState.f4726cp;
                                        if (i16 != compilerState.cpend && cArr[i16] == ')') {
                                            compilerState.f4726cp = i16 + 1;
                                            compilerState.parenNesting--;
                                            if (rENode7 != null) {
                                                rENode7.kid = compilerState.result;
                                                compilerState.result = rENode7;
                                                break;
                                            }
                                        } else {
                                            str4 = "msg.unterm.paren";
                                            reportError(str4, "");
                                            return false;
                                        }
                                    } else {
                                        return false;
                                    }
                                    break;
                                case ')':
                                    str4 = "msg.re.unmatched.right.paren";
                                    reportError(str4, "");
                                    return false;
                                case '*':
                                case '+':
                                    break;
                                default:
                                    RENode rENode8 = new RENode((byte) 14);
                                    compilerState.result = rENode8;
                                    rENode8.chr = c6;
                                    rENode8.length = 1;
                                    rENode8.flatIndex = compilerState.f4726cp - 1;
                                    i = compilerState.progLength + 3;
                                    break;
                            }
                        } else {
                            int i17 = compilerState.cpend;
                            if (i9 >= i17) {
                                str3 = "msg.trail.backslash";
                                reportError(str3, "");
                                return false;
                            }
                            int i18 = i9 + 1;
                            compilerState.f4726cp = i18;
                            char c8 = cArr[i9];
                            if (c8 == 'B') {
                                rENode = new RENode((byte) 5);
                            } else if (c8 != 'D') {
                                if (c8 != 'S') {
                                    char c9 = '\n';
                                    if (c8 != 'W') {
                                        if (c8 != 'f') {
                                            if (c8 != 'n') {
                                                c9 = '\r';
                                                switch (c8) {
                                                    case '0':
                                                        reportWarning(compilerState.f4727cx, "msg.bad.backref", "");
                                                        int i19 = 0;
                                                        while (i19 < 32 && (i5 = compilerState.f4726cp) < compilerState.cpend && (c2 = cArr[i5]) >= '0' && c2 <= '7') {
                                                            compilerState.f4726cp = i5 + 1;
                                                            i19 = (i19 * 8) + (c2 - '0');
                                                        }
                                                        c = (char) i19;
                                                        break;
                                                    case '1':
                                                    case '2':
                                                    case '3':
                                                    case '4':
                                                    case '5':
                                                    case '6':
                                                    case '7':
                                                    case '8':
                                                    case '9':
                                                        int i20 = i18 - 1;
                                                        int decimalValue = getDecimalValue(c8, compilerState, 65535, "msg.overlarge.backref");
                                                        if (decimalValue > compilerState.backReferenceLimit) {
                                                            reportWarning(compilerState.f4727cx, "msg.bad.backref", "");
                                                        }
                                                        if (decimalValue <= compilerState.backReferenceLimit) {
                                                            RENode rENode9 = new RENode((byte) 13);
                                                            compilerState.result = rENode9;
                                                            rENode9.parenIndex = decimalValue - 1;
                                                            compilerState.progLength += 3;
                                                            if (compilerState.maxBackReference < decimalValue) {
                                                                compilerState.maxBackReference = decimalValue;
                                                                break;
                                                            }
                                                        } else {
                                                            compilerState.f4726cp = i20;
                                                            if (c8 < '8') {
                                                                compilerState.f4726cp = i20 + 1;
                                                                c3 = c8 - '0';
                                                                while (c3 < 32 && (i6 = compilerState.f4726cp) < compilerState.cpend && (c4 = cArr[i6]) >= '0' && c4 <= '7') {
                                                                    compilerState.f4726cp = i6 + 1;
                                                                    c3 = (c3 * 8) + (c4 - '0');
                                                                }
                                                                c = (char) c3;
                                                            }
                                                            doFlat(compilerState, c7);
                                                            break;
                                                        }
                                                        break;
                                                    default:
                                                        switch (c8) {
                                                            case 'b':
                                                                rENode = new RENode((byte) 4);
                                                                break;
                                                            case 'c':
                                                                if (i18 >= i17 || !isControlLetter(cArr[i18])) {
                                                                    compilerState.f4726cp--;
                                                                } else {
                                                                    int i21 = compilerState.f4726cp;
                                                                    compilerState.f4726cp = i21 + 1;
                                                                    c7 = (char) (cArr[i21] & 31);
                                                                }
                                                                doFlat(compilerState, c7);
                                                                break;
                                                            case 'd':
                                                                rENode2 = new RENode((byte) 7);
                                                                break;
                                                            default:
                                                                c = 11;
                                                                switch (c8) {
                                                                    case 'r':
                                                                        break;
                                                                    case 's':
                                                                        rENode4 = new RENode((byte) 11);
                                                                        break;
                                                                    case 't':
                                                                        c = '\t';
                                                                        break;
                                                                    case 'u':
                                                                        i7 = 0;
                                                                        c3 = 0;
                                                                        while (true) {
                                                                            if (i7 < i14) {
                                                                                int i22 = compilerState.f4726cp;
                                                                                if (i22 < compilerState.cpend) {
                                                                                    compilerState.f4726cp = i22 + 1;
                                                                                    c3 = Kit.xDigitToInt(cArr[i22], c3);
                                                                                    if (c3 < 0) {
                                                                                        int i23 = compilerState.f4726cp - (i7 + 2);
                                                                                        compilerState.f4726cp = i23;
                                                                                        compilerState.f4726cp = i23 + 1;
                                                                                        c3 = cArr[i23];
                                                                                    } else {
                                                                                        i7++;
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                        c = (char) c3;
                                                                    case 'v':
                                                                        break;
                                                                    case 'w':
                                                                        rENode2 = new RENode((byte) 9);
                                                                        break;
                                                                    case 'x':
                                                                        i14 = 2;
                                                                        i7 = 0;
                                                                        c3 = 0;
                                                                        while (true) {
                                                                            if (i7 < i14) {
                                                                            }
                                                                            i7++;
                                                                        }
                                                                        c = (char) c3;
                                                                        break;
                                                                    default:
                                                                        RENode rENode10 = new RENode((byte) 14);
                                                                        compilerState.result = rENode10;
                                                                        rENode10.chr = c8;
                                                                        rENode10.length = 1;
                                                                        rENode10.flatIndex = compilerState.f4726cp - 1;
                                                                        i = compilerState.progLength + 3;
                                                                        break;
                                                                }
                                                                break;
                                                        }
                                                }
                                            }
                                            doFlat(compilerState, c9);
                                        } else {
                                            c = '\f';
                                        }
                                        doFlat(compilerState, c);
                                    } else {
                                        compilerState.result = new RENode((byte) 10);
                                        compilerState.progLength++;
                                    }
                                } else {
                                    rENode4 = new RENode((byte) 12);
                                }
                                compilerState.result = rENode4;
                                i = compilerState.progLength + 1;
                            } else {
                                rENode2 = new RENode((byte) 8);
                            }
                        }
                        RENode rENode11 = compilerState.result;
                        i2 = compilerState.f4726cp;
                        if (i2 == compilerState.cpend) {
                            return true;
                        }
                        char c10 = cArr[i2];
                        int i24 = -1;
                        if (c10 == '*') {
                            i3 = 8;
                            rENode3 = new RENode(REOP_QUANT);
                            compilerState.result = rENode3;
                            rENode3.min = 0;
                        } else if (c10 == '+') {
                            i3 = 8;
                            rENode3 = new RENode(REOP_QUANT);
                            compilerState.result = rENode3;
                            rENode3.min = 1;
                        } else if (c10 != '?') {
                            if (c10 != '{') {
                                z = false;
                            } else {
                                int i25 = i2 + 1;
                                compilerState.f4726cp = i25;
                                if (i25 < cArr.length) {
                                    char c11 = cArr[i25];
                                    if (isDigit(c11)) {
                                        compilerState.f4726cp++;
                                        int decimalValue2 = getDecimalValue(c11, compilerState, 65535, "msg.overlarge.min");
                                        int i26 = compilerState.f4726cp;
                                        if (i26 < cArr.length) {
                                            char c12 = cArr[i26];
                                            if (c12 == ',') {
                                                int i27 = i26 + 1;
                                                compilerState.f4726cp = i27;
                                                if (i27 < cArr.length) {
                                                    c12 = cArr[i27];
                                                    if (isDigit(c12)) {
                                                        int i28 = compilerState.f4726cp + 1;
                                                        compilerState.f4726cp = i28;
                                                        if (i28 < cArr.length) {
                                                            i24 = getDecimalValue(c12, compilerState, 65535, "msg.overlarge.max");
                                                            int i29 = compilerState.f4726cp;
                                                            c12 = cArr[i29];
                                                            if (decimalValue2 > i24) {
                                                                str2 = String.valueOf(cArr[i29]);
                                                                str = "msg.max.lt.min";
                                                                reportError(str, str2);
                                                                return false;
                                                            }
                                                        }
                                                    }
                                                    if (c12 == '}') {
                                                        RENode rENode12 = new RENode(REOP_QUANT);
                                                        compilerState.result = rENode12;
                                                        rENode12.min = decimalValue2;
                                                        rENode12.max = i24;
                                                        compilerState.progLength += 12;
                                                        z = true;
                                                        if (!z) {
                                                            compilerState.f4726cp = i2;
                                                        }
                                                    }
                                                }
                                            }
                                            i24 = decimalValue2;
                                            if (c12 == '}') {
                                            }
                                        }
                                    }
                                }
                                z = false;
                                if (!z) {
                                }
                            }
                            if (!z) {
                                return true;
                            }
                            int i30 = compilerState.f4726cp + 1;
                            compilerState.f4726cp = i30;
                            RENode rENode13 = compilerState.result;
                            rENode13.kid = rENode11;
                            rENode13.parenIndex = i10;
                            rENode13.parenCount = compilerState.parenCount - i10;
                            if (i30 >= compilerState.cpend || cArr[i30] != '?') {
                                compilerState.result.greedy = true;
                            } else {
                                compilerState.f4726cp = i30 + 1;
                                rENode13.greedy = false;
                            }
                            return true;
                        } else {
                            RENode rENode14 = new RENode(REOP_QUANT);
                            compilerState.result = rENode14;
                            rENode14.min = 0;
                            rENode14.max = 1;
                            i4 = compilerState.progLength;
                            i3 = 8;
                            compilerState.progLength = i4 + i3;
                            z = true;
                            if (!z) {
                            }
                        }
                        rENode3.max = -1;
                        i4 = compilerState.progLength;
                        compilerState.progLength = i4 + i3;
                        z = true;
                        if (!z) {
                        }
                        compilerState.progLength = i;
                        RENode rENode112 = compilerState.result;
                        i2 = compilerState.f4726cp;
                        if (i2 == compilerState.cpend) {
                        }
                    } else {
                        rENode = new RENode((byte) 2);
                    }
                }
                str2 = String.valueOf(cArr[compilerState.f4726cp - 1]);
                str = "msg.bad.quant";
                reportError(str, str2);
                return false;
            }
            rENode2 = new RENode((byte) 6);
            compilerState.result = rENode2;
            i = compilerState.progLength + 1;
            compilerState.progLength = i;
            RENode rENode1122 = compilerState.result;
            i2 = compilerState.f4726cp;
            if (i2 == compilerState.cpend) {
            }
        } else {
            rENode = new RENode((byte) 3);
        }
        compilerState.result = rENode;
        compilerState.progLength++;
        return true;
    }

    public static REProgState popProgState(REGlobalData rEGlobalData) {
        REProgState rEProgState = rEGlobalData.stateStackTop;
        rEGlobalData.stateStackTop = rEProgState.previous;
        return rEProgState;
    }

    public static void processCharSet(REGlobalData rEGlobalData, RECharSet rECharSet) {
        synchronized (rECharSet) {
            if (!rECharSet.converted) {
                processCharSetImpl(rEGlobalData, rECharSet);
                rECharSet.converted = true;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0135 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x010a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x008f A[LOOP:4: B:88:0x0078->B:92:0x008f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x008a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void processCharSetImpl(REGlobalData rEGlobalData, RECharSet rECharSet) {
        int i;
        int i2;
        int i3;
        int aSCIIHexDigit;
        int i4 = rECharSet.startIndex;
        int i5 = rECharSet.strlength + i4;
        rECharSet.bits = new byte[(rECharSet.length + 7) / 8];
        if (i4 == i5) {
            return;
        }
        if (rEGlobalData.regexp.source[i4] == '^') {
            i4++;
        }
        boolean z = false;
        char c = 0;
        while (i4 != i5) {
            char[] cArr = rEGlobalData.regexp.source;
            char c2 = '\\';
            if (cArr[i4] != '\\') {
                i = i4 + 1;
                c2 = cArr[i4];
            } else {
                int i6 = i4 + 1;
                i = i6 + 1;
                char c3 = cArr[i6];
                if (c3 == 'D') {
                    addCharacterRangeToCharSet(rECharSet, (char) 0, '/');
                    addCharacterRangeToCharSet(rECharSet, ':', (char) (rECharSet.length - 1));
                } else if (c3 == 'S') {
                    for (int i7 = rECharSet.length - 1; i7 >= 0; i7--) {
                        if (!isREWhiteSpace(i7)) {
                            addCharacterToCharSet(rECharSet, (char) i7);
                        }
                    }
                } else if (c3 == 'W') {
                    for (int i8 = rECharSet.length - 1; i8 >= 0; i8--) {
                        char c4 = (char) i8;
                        if (!isWord(c4)) {
                            addCharacterToCharSet(rECharSet, c4);
                        }
                    }
                } else if (c3 == 'f') {
                    c2 = '\f';
                } else if (c3 != 'n') {
                    switch (c3) {
                        case '0':
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                            int i9 = c3 - '0';
                            char c5 = cArr[i];
                            if ('0' <= c5 && c5 <= '7') {
                                i++;
                                i9 = (i9 * 8) + (c5 - '0');
                                char c6 = cArr[i];
                                if ('0' <= c6 && c6 <= '7') {
                                    i++;
                                    int i10 = (c6 - '0') + (i9 * 8);
                                    if (i10 <= 255) {
                                        i9 = i10;
                                    } else {
                                        i--;
                                    }
                                }
                            }
                            c2 = (char) i9;
                            break;
                        default:
                            switch (c3) {
                                case 'b':
                                    i4 = i;
                                    c2 = '\b';
                                    if (z) {
                                        if ((rEGlobalData.regexp.flags & 2) != 0) {
                                            char c7 = c;
                                            while (c7 <= c2) {
                                                addCharacterToCharSet(rECharSet, c7);
                                                char upcase = upcase(c7);
                                                char downcase = downcase(c7);
                                                if (c7 != upcase) {
                                                    addCharacterToCharSet(rECharSet, upcase);
                                                }
                                                if (c7 != downcase) {
                                                    addCharacterToCharSet(rECharSet, downcase);
                                                }
                                                c7 = (char) (c7 + 1);
                                                if (c7 == 0) {
                                                }
                                            }
                                        } else {
                                            addCharacterRangeToCharSet(rECharSet, c, c2);
                                        }
                                        z = false;
                                    } else {
                                        if ((rEGlobalData.regexp.flags & 2) != 0) {
                                            addCharacterToCharSet(rECharSet, upcase(c2));
                                            addCharacterToCharSet(rECharSet, downcase(c2));
                                        } else {
                                            addCharacterToCharSet(rECharSet, c2);
                                        }
                                        if (i4 < i5 - 1 && rEGlobalData.regexp.source[i4] == '-') {
                                            i4++;
                                            c = c2;
                                            z = true;
                                        }
                                    }
                                    break;
                                case 'c':
                                    if (i >= i5 || !isControlLetter(cArr[i])) {
                                        i--;
                                        break;
                                    } else {
                                        c2 = (char) (rEGlobalData.regexp.source[i] & 31);
                                        i4 = i + 1;
                                        if (z) {
                                        }
                                    }
                                    break;
                                case 'd':
                                    addCharacterRangeToCharSet(rECharSet, '0', '9');
                                    break;
                                default:
                                    switch (c3) {
                                        case 'r':
                                            c2 = '\r';
                                            break;
                                        case 's':
                                            for (int i11 = rECharSet.length - 1; i11 >= 0; i11--) {
                                                if (isREWhiteSpace(i11)) {
                                                    addCharacterToCharSet(rECharSet, (char) i11);
                                                }
                                            }
                                            break;
                                        case 't':
                                            c2 = '\t';
                                            break;
                                        case 'u':
                                            i2 = 4;
                                            i3 = 0;
                                            int i12 = 0;
                                            while (i3 < i2 && i < i5) {
                                                int i13 = i + 1;
                                                aSCIIHexDigit = toASCIIHexDigit(rEGlobalData.regexp.source[i]);
                                                if (aSCIIHexDigit >= 0) {
                                                    i = i13 - (i3 + 1);
                                                    c2 = c2;
                                                    break;
                                                } else {
                                                    i12 = ((i12 == 1 ? 1 : 0) << 4) | aSCIIHexDigit;
                                                    i3++;
                                                    i = i13;
                                                }
                                            }
                                            c2 = i12 == 1 ? 1 : 0;
                                            c2 = c2;
                                            break;
                                        case 'v':
                                            c2 = 11;
                                            break;
                                        case 'w':
                                            for (int i14 = rECharSet.length - 1; i14 >= 0; i14--) {
                                                char c8 = (char) i14;
                                                if (isWord(c8)) {
                                                    addCharacterToCharSet(rECharSet, c8);
                                                }
                                            }
                                            break;
                                        case 'x':
                                            i2 = 2;
                                            i3 = 0;
                                            int i122 = 0;
                                            while (i3 < i2) {
                                                int i132 = i + 1;
                                                aSCIIHexDigit = toASCIIHexDigit(rEGlobalData.regexp.source[i]);
                                                if (aSCIIHexDigit >= 0) {
                                                }
                                            }
                                            c2 = i122 == 1 ? 1 : 0;
                                            c2 = c2;
                                            break;
                                        default:
                                            c2 = c3;
                                            break;
                                    }
                            }
                    }
                } else {
                    c2 = '\n';
                }
                i4 = i;
            }
            i4 = i;
            if (z) {
            }
        }
    }

    public static void pushBackTrackState(REGlobalData rEGlobalData, byte b, int i) {
        REProgState rEProgState = rEGlobalData.stateStackTop;
        rEGlobalData.backTrackStackTop = new REBackTrackData(rEGlobalData, b, i, rEGlobalData.f4732cp, rEProgState.continuationOp, rEProgState.continuationPc);
    }

    public static void pushBackTrackState(REGlobalData rEGlobalData, byte b, int i, int i2, int i3, int i4) {
        rEGlobalData.backTrackStackTop = new REBackTrackData(rEGlobalData, b, i, i2, i3, i4);
    }

    public static void pushProgState(REGlobalData rEGlobalData, int i, int i2, int i3, REBackTrackData rEBackTrackData, int i4, int i5) {
        rEGlobalData.stateStackTop = new REProgState(rEGlobalData.stateStackTop, i, i2, i3, rEBackTrackData, i4, i5);
    }

    public static NativeRegExp realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (scriptable instanceof NativeRegExp) {
            return (NativeRegExp) scriptable;
        }
        throw IdScriptableObject.incompatibleCallError(idFunctionObject);
    }

    public static boolean reopIsSimple(int i) {
        return i >= 1 && i <= 23;
    }

    public static void reportError(String str, String str2) {
        throw ScriptRuntime.constructError("SyntaxError", ScriptRuntime.getMessage1(str, str2));
    }

    public static void reportWarning(Context context, String str, String str2) {
        if (context.hasFeature(11)) {
            Context.reportWarning(ScriptRuntime.getMessage1(str, str2));
        }
    }

    public static void resolveForwardJump(byte[] bArr, int i, int i2) {
        if (i <= i2) {
            addIndex(bArr, i, i2 - i);
            return;
        }
        throw Kit.codeBug();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0041, code lost:
        if (upcase(r5) == upcase(r4)) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0054, code lost:
        if (r4.charAt(r6) == r5) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00cc, code lost:
        if (isREWhiteSpace(r4.charAt(r0)) == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00d9, code lost:
        if (isREWhiteSpace(r4.charAt(r0)) != false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00e6, code lost:
        if (isWord(r4.charAt(r0)) == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00f3, code lost:
        if (isWord(r4.charAt(r0)) != false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0100, code lost:
        if (isDigit(r4.charAt(r0)) == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x010d, code lost:
        if (isDigit(r4.charAt(r0)) != false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x011a, code lost:
        if (isLineTerm(r4.charAt(r0)) == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0141, code lost:
        if (isWord(r4.charAt(r6)) != false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0162, code lost:
        if (isWord(r4.charAt(r6)) != false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0175, code lost:
        if (isLineTerm(r4.charAt(r0)) == false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0188, code lost:
        if (isLineTerm(r4.charAt(r0 - 1)) == false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0024, code lost:
        if (classMatcher(r3, r3.regexp.classList[r5], r4.charAt(r6)) != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int simpleMatch(REGlobalData rEGlobalData, String str, int i, byte[] bArr, int i2, int i3, boolean z) {
        boolean z2;
        int i4;
        char charAt;
        int i5 = rEGlobalData.f4732cp;
        boolean z3 = false;
        switch (i) {
            case 1:
                z3 = true;
                break;
            case 2:
                if (i5 != 0) {
                    if (rEGlobalData.multiline) {
                        break;
                    }
                }
                z3 = true;
                break;
            case 3:
                if (i5 != i3) {
                    if (rEGlobalData.multiline) {
                        break;
                    }
                }
                z3 = true;
                break;
            case 4:
                z2 = i5 == 0 || !isWord(str.charAt(i5 + (-1)));
                int i6 = rEGlobalData.f4732cp;
                if (i6 < i3) {
                    break;
                }
                z3 = true;
                z3 ^= z2;
                break;
            case 5:
                z2 = i5 == 0 || !isWord(str.charAt(i5 + (-1)));
                int i7 = rEGlobalData.f4732cp;
                if (i7 < i3) {
                    break;
                }
                z3 ^= z2;
                break;
            case 6:
                if (i5 != i3) {
                    break;
                }
                break;
            case 7:
                if (i5 != i3) {
                    break;
                }
                break;
            case 8:
                if (i5 != i3) {
                    break;
                }
                break;
            case 9:
                if (i5 != i3) {
                    break;
                }
                break;
            case 10:
                if (i5 != i3) {
                    break;
                }
                break;
            case 11:
                if (i5 != i3) {
                    break;
                }
                break;
            case 12:
                if (i5 != i3) {
                    break;
                }
                break;
            case 13:
                int index = getIndex(bArr, i2);
                i2 += 2;
                z3 = backrefMatcher(rEGlobalData, index, str, i3);
                break;
            case 14:
                int index2 = getIndex(bArr, i2);
                int i8 = i2 + 2;
                int index3 = getIndex(bArr, i8);
                i2 = i8 + 2;
                z3 = flatNMatcher(rEGlobalData, index2, index3, str, i3);
                break;
            case 15:
                i4 = i2 + 1;
                char c = (char) (bArr[i2] & 255);
                if (i5 != i3 && str.charAt(i5) == c) {
                    rEGlobalData.f4732cp++;
                    i2 = i4;
                    z3 = true;
                    break;
                }
                i2 = i4;
                break;
            case 16:
                int index4 = getIndex(bArr, i2);
                int i9 = i2 + 2;
                int index5 = getIndex(bArr, i9);
                i2 = i9 + 2;
                z3 = flatNIMatcher(rEGlobalData, index4, index5, str, i3);
                break;
            case 17:
                i4 = i2 + 1;
                char c2 = (char) (bArr[i2] & 255);
                if (i5 != i3 && (c2 == (charAt = str.charAt(i5)) || upcase(c2) == upcase(charAt))) {
                    rEGlobalData.f4732cp++;
                    z3 = true;
                }
                i2 = i4;
                break;
            case 18:
                char index6 = (char) getIndex(bArr, i2);
                i2 += 2;
                int i10 = rEGlobalData.f4732cp;
                if (i10 != i3) {
                    break;
                }
                break;
            case 19:
                char index7 = (char) getIndex(bArr, i2);
                i2 += 2;
                int i11 = rEGlobalData.f4732cp;
                if (i11 != i3) {
                    char charAt2 = str.charAt(i11);
                    if (index7 != charAt2) {
                        break;
                    }
                    rEGlobalData.f4732cp++;
                    z3 = true;
                    break;
                }
                break;
            case 20:
            case 21:
            default:
                throw Kit.codeBug();
            case 22:
            case 23:
                int index8 = getIndex(bArr, i2);
                i2 += 2;
                int i12 = rEGlobalData.f4732cp;
                if (i12 != i3) {
                    break;
                }
                break;
        }
        if (!z3) {
            rEGlobalData.f4732cp = i5;
            return -1;
        }
        if (!z) {
            rEGlobalData.f4732cp = i5;
        }
        return i2;
    }

    public static int toASCIIHexDigit(int i) {
        if (i < 48) {
            return -1;
        }
        if (i <= 57) {
            return i - 48;
        }
        int i2 = i | 32;
        if (97 <= i2 && i2 <= 102) {
            return (i2 - 97) + 10;
        }
        return -1;
    }

    public static char upcase(char c) {
        if (c < 128) {
            return ('a' > c || c > 'z') ? c : (char) (c - ' ');
        }
        char upperCase = Character.toUpperCase(c);
        return upperCase < 128 ? c : upperCase;
    }

    @Override // org.mozilla.javascript.Function, org.mozilla.javascript.Callable
    public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return execSub(context, scriptable, objArr, 1);
    }

    public Scriptable compile(Context context, Scriptable scriptable, Object[] objArr) {
        Object valueOf;
        if (objArr.length <= 0 || !(objArr[0] instanceof NativeRegExp)) {
            this.f4728re = compileRE(context, (objArr.length == 0 || (objArr[0] instanceof Undefined)) ? "" : escapeRegExp(objArr[0]), (objArr.length <= 1 || objArr[1] == Undefined.instance) ? null : ScriptRuntime.toString(objArr[1]), false);
            valueOf = Double.valueOf((double) RoundRectDrawableWithShadow.COS_45);
        } else if (objArr.length > 1 && objArr[1] != Undefined.instance) {
            throw ScriptRuntime.typeError0("msg.bad.regexp.compile");
        } else {
            NativeRegExp nativeRegExp = (NativeRegExp) objArr[0];
            this.f4728re = nativeRegExp.f4728re;
            valueOf = nativeRegExp.lastIndex;
        }
        this.lastIndex = valueOf;
        return this;
    }

    @Override // org.mozilla.javascript.Function
    public Scriptable construct(Context context, Scriptable scriptable, Object[] objArr) {
        return (Scriptable) execSub(context, scriptable, objArr, 1);
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(REGEXP_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int methodId = idFunctionObject.methodId();
        switch (methodId) {
            case 1:
                return realThis(scriptable2, idFunctionObject).compile(context, scriptable, objArr);
            case 2:
            case 3:
                return realThis(scriptable2, idFunctionObject).toString();
            case 4:
                return realThis(scriptable2, idFunctionObject).execSub(context, scriptable, objArr, 1);
            case 5:
                return Boolean.TRUE.equals(realThis(scriptable2, idFunctionObject).execSub(context, scriptable, objArr, 0)) ? Boolean.TRUE : Boolean.FALSE;
            case 6:
                return realThis(scriptable2, idFunctionObject).execSub(context, scriptable, objArr, 2);
            default:
                throw new IllegalArgumentException(String.valueOf(methodId));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Boolean] */
    public Object executeRegExp(Context context, Scriptable scriptable, RegExpImpl regExpImpl, String str, int[] iArr, int i) {
        Scriptable newArray;
        Scriptable scriptable2;
        int i2;
        Object obj;
        NativeRegExp nativeRegExp = this;
        REGlobalData rEGlobalData = new REGlobalData();
        int i3 = iArr[0];
        int length = str.length();
        int i4 = i3 > length ? length : i3;
        SubString subString = null;
        if (!matchRegExp(rEGlobalData, nativeRegExp.f4728re, str, i4, length, regExpImpl.multiline)) {
            if (i == 2) {
                return Undefined.instance;
            }
            return null;
        }
        int i5 = rEGlobalData.f4732cp;
        iArr[0] = i5;
        int i6 = i5 - (rEGlobalData.skipped + i4);
        int i7 = i5 - i6;
        if (i == 0) {
            scriptable2 = null;
            newArray = Boolean.TRUE;
        } else {
            newArray = context.newArray(scriptable, 0);
            newArray.put(0, newArray, str.substring(i7, i7 + i6));
            scriptable2 = newArray;
        }
        int i8 = nativeRegExp.f4728re.parenCount;
        if (i8 == 0) {
            regExpImpl.parens = null;
            subString = new SubString();
        } else {
            regExpImpl.parens = new SubString[i8];
            int i9 = 0;
            while (i9 < nativeRegExp.f4728re.parenCount) {
                int parensIndex = rEGlobalData.parensIndex(i9);
                if (parensIndex != -1) {
                    subString = new SubString(str, parensIndex, rEGlobalData.parensLength(i9));
                    regExpImpl.parens[i9] = subString;
                    if (i != 0) {
                        i2 = i9 + 1;
                        obj = subString.toString();
                        scriptable2.put(i2, scriptable2, obj);
                        i9++;
                        nativeRegExp = this;
                    } else {
                        i9++;
                        nativeRegExp = this;
                    }
                } else if (i != 0) {
                    i2 = i9 + 1;
                    obj = Undefined.instance;
                    scriptable2.put(i2, scriptable2, obj);
                    i9++;
                    nativeRegExp = this;
                } else {
                    i9++;
                    nativeRegExp = this;
                }
            }
        }
        regExpImpl.lastParen = subString;
        if (i != 0) {
            scriptable2.put("index", scriptable2, Integer.valueOf(rEGlobalData.skipped + i4));
            scriptable2.put("input", scriptable2, str);
        }
        if (regExpImpl.lastMatch == null) {
            regExpImpl.lastMatch = new SubString();
            regExpImpl.leftContext = new SubString();
            regExpImpl.rightContext = new SubString();
        }
        SubString subString2 = regExpImpl.lastMatch;
        subString2.str = str;
        subString2.index = i7;
        subString2.length = i6;
        regExpImpl.leftContext.str = str;
        if (context.getLanguageVersion() == 120) {
            SubString subString3 = regExpImpl.leftContext;
            subString3.index = i4;
            subString3.length = rEGlobalData.skipped;
        } else {
            SubString subString4 = regExpImpl.leftContext;
            subString4.index = 0;
            subString4.length = i4 + rEGlobalData.skipped;
        }
        SubString subString5 = regExpImpl.rightContext;
        subString5.str = str;
        subString5.index = i5;
        subString5.length = length - i5;
        return newArray;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findInstanceIdInfo(String str) {
        String str2;
        int i;
        int i2;
        int length = str.length();
        int i3 = 0;
        if (length == 6) {
            char charAt = str.charAt(0);
            if (charAt == 'g') {
                str2 = "global";
                i = 3;
            } else {
                if (charAt == 's') {
                    str2 = "source";
                    i = 2;
                }
                str2 = null;
                i = 0;
            }
        } else if (length == 9) {
            char charAt2 = str.charAt(0);
            if (charAt2 == 'l') {
                str2 = "lastIndex";
                i = 1;
            } else {
                if (charAt2 == 'm') {
                    str2 = "multiline";
                    i = 5;
                }
                str2 = null;
                i = 0;
            }
        } else {
            if (length == 10) {
                str2 = "ignoreCase";
                i = 4;
            }
            str2 = null;
            i = 0;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            i3 = i;
        }
        if (i3 == 0) {
            return super.findInstanceIdInfo(str);
        }
        if (i3 == 1) {
            i2 = this.lastIndexAttr;
        } else if (i3 != 2 && i3 != 3 && i3 != 4 && i3 != 5) {
            throw new IllegalStateException();
        } else {
            i2 = 7;
        }
        return IdScriptableObject.instanceIdInfo(i2, i3);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(String str) {
        String str2;
        int length = str.length();
        int i = 3;
        if (length == 4) {
            char charAt = str.charAt(0);
            if (charAt == 'e') {
                str2 = "exec";
                i = 4;
            } else {
                if (charAt == 't') {
                    i = 5;
                    str2 = "test";
                }
                str2 = null;
                i = 0;
            }
        } else if (length == 6) {
            str2 = "prefix";
            i = 6;
        } else if (length != 7) {
            if (length == 8) {
                char charAt2 = str.charAt(3);
                if (charAt2 == 'o') {
                    str2 = "toSource";
                } else if (charAt2 == 't') {
                    i = 2;
                    str2 = AnnotationHandler.STRING;
                }
            }
            str2 = null;
            i = 0;
        } else {
            i = 1;
            str2 = "compile";
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "RegExp";
    }

    public int getFlags() {
        return this.f4728re.flags;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public String getInstanceIdName(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? super.getInstanceIdName(i) : "multiline" : "ignoreCase" : "global" : "source" : "lastIndex";
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public Object getInstanceIdValue(int i) {
        boolean z = true;
        if (i != 1) {
            if (i == 2) {
                return new String(this.f4728re.source);
            }
            if (i == 3) {
                if ((this.f4728re.flags & 1) == 0) {
                    z = false;
                }
                return ScriptRuntime.wrapBoolean(z);
            } else if (i == 4) {
                if ((this.f4728re.flags & 2) == 0) {
                    z = false;
                }
                return ScriptRuntime.wrapBoolean(z);
            } else if (i != 5) {
                return super.getInstanceIdValue(i);
            } else {
                if ((this.f4728re.flags & 4) == 0) {
                    z = false;
                }
                return ScriptRuntime.wrapBoolean(z);
            }
        }
        return this.lastIndex;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int getMaxInstanceId() {
        return 5;
    }

    @Override // org.mozilla.javascript.ScriptableObject
    public String getTypeOf() {
        return "object";
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i) {
        String str;
        String str2;
        int i2 = 1;
        switch (i) {
            case 1:
                str = "compile";
                i2 = 2;
                break;
            case 2:
                str2 = AnnotationHandler.STRING;
                str = str2;
                i2 = 0;
                break;
            case 3:
                str2 = "toSource";
                str = str2;
                i2 = 0;
                break;
            case 4:
                str = "exec";
                break;
            case 5:
                str = "test";
                break;
            case 6:
                str = "prefix";
                break;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
        initPrototypeMethod(REGEXP_TAG, i, str, i2);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void setInstanceIdAttributes(int i, int i2) {
        if (i != 1) {
            super.setInstanceIdAttributes(i, i2);
        } else {
            this.lastIndexAttr = i2;
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void setInstanceIdValue(int i, Object obj) {
        if (i == 1) {
            this.lastIndex = obj;
        } else if (i == 2 || i == 3 || i == 4 || i == 5) {
        } else {
            super.setInstanceIdValue(i, obj);
        }
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('/');
        char[] cArr = this.f4728re.source;
        if (cArr.length != 0) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(cArr);
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("(?:)");
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append('/');
        if ((this.f4728re.flags & 1) != 0) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append('g');
        }
        if ((this.f4728re.flags & 2) != 0) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append('i');
        }
        if ((this.f4728re.flags & 4) != 0) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append('m');
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
