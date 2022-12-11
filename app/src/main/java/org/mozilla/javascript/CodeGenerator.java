package org.mozilla.javascript;

import androidx.cardview.widget.RoundRectDrawableWithShadow;
import androidx.core.view.InputDeviceCompat;
import org.mozilla.javascript.ObjToIntMap;
import org.mozilla.javascript.ast.FunctionNode;
import org.mozilla.javascript.ast.Jump;
import org.mozilla.javascript.ast.ScriptNode;

/* loaded from: classes5.dex */
public class CodeGenerator extends Icode {
    public static final int ECF_TAIL = 1;
    public static final int MIN_FIXUP_TABLE_SIZE = 40;
    public static final int MIN_LABEL_TABLE_SIZE = 32;
    public CompilerEnvirons compilerEnv;
    public int doubleTableTop;
    public int exceptionTableTop;
    public long[] fixupTable;
    public int fixupTableTop;
    public int iCodeTop;
    public InterpreterData itsData;
    public boolean itsInFunctionFlag;
    public boolean itsInTryFlag;
    public int[] labelTable;
    public int labelTableTop;
    public int lineNumber;
    public int localTop;
    public ScriptNode scriptOrFn;
    public int stackDepth;
    public ObjToIntMap strings = new ObjToIntMap(20);
    public ObjArray literalIds = new ObjArray();

    private void addBackwardGoto(int i, int i2) {
        int i3 = this.iCodeTop;
        if (i3 > i2) {
            addGotoOp(i);
            resolveGoto(i3, i2);
            return;
        }
        throw Kit.codeBug();
    }

    private void addExceptionHandler(int i, int i2, int i3, boolean z, int i4, int i5) {
        int i6 = this.exceptionTableTop;
        int[] iArr = this.itsData.itsExceptionTable;
        if (iArr == null) {
            if (i6 != 0) {
                Kit.codeBug();
            }
            iArr = new int[12];
            this.itsData.itsExceptionTable = iArr;
        } else if (iArr.length == i6) {
            int[] iArr2 = new int[iArr.length * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i6);
            this.itsData.itsExceptionTable = iArr2;
            iArr = iArr2;
        }
        iArr[i6 + 0] = i;
        iArr[i6 + 1] = i2;
        iArr[i6 + 2] = i3;
        iArr[i6 + 3] = z ? 1 : 0;
        iArr[i6 + 4] = i4;
        iArr[i6 + 5] = i5;
        this.exceptionTableTop = i6 + 6;
    }

    private void addGoto(Node node, int i) {
        int targetLabel = getTargetLabel(node);
        if (targetLabel >= this.labelTableTop) {
            Kit.codeBug();
        }
        int i2 = this.labelTable[targetLabel];
        if (i2 != -1) {
            addBackwardGoto(i, i2);
            return;
        }
        int i3 = this.iCodeTop;
        addGotoOp(i);
        int i4 = this.fixupTableTop;
        long[] jArr = this.fixupTable;
        if (jArr == null || i4 == jArr.length) {
            long[] jArr2 = this.fixupTable;
            if (jArr2 == null) {
                this.fixupTable = new long[40];
            } else {
                long[] jArr3 = new long[jArr2.length * 2];
                System.arraycopy(jArr2, 0, jArr3, 0, i4);
                this.fixupTable = jArr3;
            }
        }
        this.fixupTableTop = i4 + 1;
        this.fixupTable[i4] = (targetLabel << 32) | i3;
    }

    private void addGotoOp(int i) {
        byte[] bArr = this.itsData.itsICode;
        int i2 = this.iCodeTop;
        if (i2 + 3 > bArr.length) {
            bArr = increaseICodeCapacity(3);
        }
        bArr[i2] = (byte) i;
        this.iCodeTop = i2 + 1 + 2;
    }

    private void addIcode(int i) {
        if (Icode.validIcode(i)) {
            addUint8(i & 255);
            return;
        }
        throw Kit.codeBug();
    }

    private void addIndexOp(int i, int i2) {
        addIndexPrefix(i2);
        if (Icode.validIcode(i)) {
            addIcode(i);
        } else {
            addToken(i);
        }
    }

    private void addIndexPrefix(int i) {
        if (i < 0) {
            Kit.codeBug();
        }
        if (i < 6) {
            addIcode((-32) - i);
        } else if (i <= 255) {
            addIcode(-38);
            addUint8(i);
        } else if (i <= 65535) {
            addIcode(-39);
            addUint16(i);
        } else {
            addIcode(-40);
            addInt(i);
        }
    }

    private void addInt(int i) {
        byte[] bArr = this.itsData.itsICode;
        int i2 = this.iCodeTop;
        int i3 = i2 + 4;
        if (i3 > bArr.length) {
            bArr = increaseICodeCapacity(4);
        }
        bArr[i2] = (byte) (i >>> 24);
        bArr[i2 + 1] = (byte) (i >>> 16);
        bArr[i2 + 2] = (byte) (i >>> 8);
        bArr[i2 + 3] = (byte) i;
        this.iCodeTop = i3;
    }

    private void addStringOp(int i, String str) {
        addStringPrefix(str);
        if (Icode.validIcode(i)) {
            addIcode(i);
        } else {
            addToken(i);
        }
    }

    private void addStringPrefix(String str) {
        int i = this.strings.get(str, -1);
        if (i == -1) {
            i = this.strings.size();
            this.strings.put(str, i);
        }
        if (i < 4) {
            addIcode((-41) - i);
        } else if (i <= 255) {
            addIcode(-45);
            addUint8(i);
        } else if (i <= 65535) {
            addIcode(-46);
            addUint16(i);
        } else {
            addIcode(-47);
            addInt(i);
        }
    }

    private void addToken(int i) {
        if (Icode.validTokenCode(i)) {
            addUint8(i);
            return;
        }
        throw Kit.codeBug();
    }

    private void addUint16(int i) {
        if (((-65536) & i) == 0) {
            byte[] bArr = this.itsData.itsICode;
            int i2 = this.iCodeTop;
            int i3 = i2 + 2;
            if (i3 > bArr.length) {
                bArr = increaseICodeCapacity(2);
            }
            bArr[i2] = (byte) (i >>> 8);
            bArr[i2 + 1] = (byte) i;
            this.iCodeTop = i3;
            return;
        }
        throw Kit.codeBug();
    }

    private void addUint8(int i) {
        if ((i & InputDeviceCompat.SOURCE_ANY) == 0) {
            byte[] bArr = this.itsData.itsICode;
            int i2 = this.iCodeTop;
            if (i2 == bArr.length) {
                bArr = increaseICodeCapacity(1);
            }
            bArr[i2] = (byte) i;
            this.iCodeTop = i2 + 1;
            return;
        }
        throw Kit.codeBug();
    }

    private void addVarOp(int i, int i2) {
        if (i != -7) {
            if (i == 157) {
                if (i2 >= 128) {
                    addIndexOp(-60, i2);
                    return;
                }
                addIcode(-61);
                addUint8(i2);
                return;
            } else if (i != 55 && i != 56) {
                throw Kit.codeBug();
            } else {
                if (i2 < 128) {
                    addIcode(i == 55 ? -48 : -49);
                    addUint8(i2);
                    return;
                }
            }
        }
        addIndexOp(i, i2);
    }

    private int allocLocal() {
        int i = this.localTop;
        int i2 = i + 1;
        this.localTop = i2;
        InterpreterData interpreterData = this.itsData;
        if (i2 > interpreterData.itsMaxLocals) {
            interpreterData.itsMaxLocals = i2;
        }
        return i;
    }

    private RuntimeException badTree(Node node) {
        throw new RuntimeException(node.toString());
    }

    private void fixLabelGotos() {
        for (int i = 0; i < this.fixupTableTop; i++) {
            long j = this.fixupTable[i];
            int i2 = (int) j;
            int i3 = this.labelTable[(int) (j >> 32)];
            if (i3 == -1) {
                throw Kit.codeBug();
            }
            resolveGoto(i2, i3);
        }
        this.fixupTableTop = 0;
    }

    private void generateCallFunAndThis(Node node) {
        int type = node.getType();
        if (type == 33 || type == 36) {
            Node firstChild = node.getFirstChild();
            visitExpression(firstChild, 0);
            Node next = firstChild.getNext();
            if (type != 33) {
                visitExpression(next, 0);
                addIcode(-17);
                return;
            }
            addStringOp(-16, next.getString());
        } else if (type == 39) {
            addStringOp(-15, node.getString());
            stackChange(2);
            return;
        } else {
            visitExpression(node, 0);
            addIcode(-18);
        }
        stackChange(1);
    }

    private void generateFunctionICode() {
        this.itsInFunctionFlag = true;
        FunctionNode functionNode = (FunctionNode) this.scriptOrFn;
        this.itsData.itsFunctionType = functionNode.getFunctionType();
        this.itsData.itsNeedsActivation = functionNode.requiresActivation();
        if (functionNode.getFunctionName() != null) {
            this.itsData.itsName = functionNode.getName();
        }
        if (functionNode.isGenerator()) {
            addIcode(-62);
            addUint16(functionNode.getBaseLineno() & 65535);
        }
        if (functionNode.isInStrictMode()) {
            this.itsData.isStrict = true;
        }
        generateICodeFromTree(functionNode.getLastChild());
    }

    private void generateICodeFromTree(Node node) {
        generateNestedFunctions();
        generateRegExpLiterals();
        visitStatement(node, 0);
        fixLabelGotos();
        if (this.itsData.itsFunctionType == 0) {
            addToken(65);
        }
        byte[] bArr = this.itsData.itsICode;
        int length = bArr.length;
        int i = this.iCodeTop;
        if (length != i) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            this.itsData.itsICode = bArr2;
        }
        if (this.strings.size() == 0) {
            this.itsData.itsStringTable = null;
        } else {
            this.itsData.itsStringTable = new String[this.strings.size()];
            ObjToIntMap.Iterator newIterator = this.strings.newIterator();
            newIterator.start();
            while (!newIterator.done()) {
                String str = (String) newIterator.getKey();
                int value = newIterator.getValue();
                if (this.itsData.itsStringTable[value] != null) {
                    Kit.codeBug();
                }
                this.itsData.itsStringTable[value] = str;
                newIterator.next();
            }
        }
        int i2 = this.doubleTableTop;
        if (i2 == 0) {
            this.itsData.itsDoubleTable = null;
        } else {
            double[] dArr = this.itsData.itsDoubleTable;
            if (dArr.length != i2) {
                double[] dArr2 = new double[i2];
                System.arraycopy(dArr, 0, dArr2, 0, i2);
                this.itsData.itsDoubleTable = dArr2;
            }
        }
        int i3 = this.exceptionTableTop;
        if (i3 != 0) {
            int[] iArr = this.itsData.itsExceptionTable;
            if (iArr.length != i3) {
                int[] iArr2 = new int[i3];
                System.arraycopy(iArr, 0, iArr2, 0, i3);
                this.itsData.itsExceptionTable = iArr2;
            }
        }
        this.itsData.itsMaxVars = this.scriptOrFn.getParamAndVarCount();
        InterpreterData interpreterData = this.itsData;
        interpreterData.itsMaxFrameArray = interpreterData.itsMaxVars + interpreterData.itsMaxLocals + interpreterData.itsMaxStack;
        interpreterData.argNames = this.scriptOrFn.getParamAndVarNames();
        this.itsData.argIsConst = this.scriptOrFn.getParamAndVarConst();
        this.itsData.argCount = this.scriptOrFn.getParamCount();
        this.itsData.encodedSourceStart = this.scriptOrFn.getEncodedSourceStart();
        this.itsData.encodedSourceEnd = this.scriptOrFn.getEncodedSourceEnd();
        if (this.literalIds.size() != 0) {
            this.itsData.literalIds = this.literalIds.toArray();
        }
    }

    private void generateNestedFunctions() {
        int functionCount = this.scriptOrFn.getFunctionCount();
        if (functionCount == 0) {
            return;
        }
        InterpreterData[] interpreterDataArr = new InterpreterData[functionCount];
        for (int i = 0; i != functionCount; i++) {
            FunctionNode functionNode = this.scriptOrFn.getFunctionNode(i);
            CodeGenerator codeGenerator = new CodeGenerator();
            codeGenerator.compilerEnv = this.compilerEnv;
            codeGenerator.scriptOrFn = functionNode;
            codeGenerator.itsData = new InterpreterData(this.itsData);
            codeGenerator.generateFunctionICode();
            interpreterDataArr[i] = codeGenerator.itsData;
        }
        this.itsData.itsNestedFunctions = interpreterDataArr;
    }

    private void generateRegExpLiterals() {
        int regexpCount = this.scriptOrFn.getRegexpCount();
        if (regexpCount == 0) {
            return;
        }
        Context context = Context.getContext();
        RegExpProxy checkRegExpProxy = ScriptRuntime.checkRegExpProxy(context);
        Object[] objArr = new Object[regexpCount];
        for (int i = 0; i != regexpCount; i++) {
            objArr[i] = checkRegExpProxy.compileRegExp(context, this.scriptOrFn.getRegexpString(i), this.scriptOrFn.getRegexpFlags(i));
        }
        this.itsData.itsRegExpLiterals = objArr;
    }

    private int getDoubleIndex(double d) {
        int i = this.doubleTableTop;
        InterpreterData interpreterData = this.itsData;
        if (i == 0) {
            interpreterData.itsDoubleTable = new double[64];
        } else {
            double[] dArr = interpreterData.itsDoubleTable;
            if (dArr.length == i) {
                double[] dArr2 = new double[i * 2];
                System.arraycopy(dArr, 0, dArr2, 0, i);
                this.itsData.itsDoubleTable = dArr2;
            }
        }
        this.itsData.itsDoubleTable[i] = d;
        this.doubleTableTop = i + 1;
        return i;
    }

    private int getLocalBlockRef(Node node) {
        return ((Node) node.getProp(3)).getExistingIntProp(2);
    }

    private int getTargetLabel(Node node) {
        int labelId = node.labelId();
        if (labelId != -1) {
            return labelId;
        }
        int i = this.labelTableTop;
        int[] iArr = this.labelTable;
        if (iArr == null || i == iArr.length) {
            int[] iArr2 = this.labelTable;
            if (iArr2 == null) {
                this.labelTable = new int[32];
            } else {
                int[] iArr3 = new int[iArr2.length * 2];
                System.arraycopy(iArr2, 0, iArr3, 0, i);
                this.labelTable = iArr3;
            }
        }
        this.labelTableTop = i + 1;
        this.labelTable[i] = -1;
        node.labelId(i);
        return i;
    }

    private byte[] increaseICodeCapacity(int i) {
        int length = this.itsData.itsICode.length;
        int i2 = this.iCodeTop;
        int i3 = i + i2;
        if (i3 > length) {
            int i4 = length * 2;
            if (i3 <= i4) {
                i3 = i4;
            }
            byte[] bArr = new byte[i3];
            System.arraycopy(this.itsData.itsICode, 0, bArr, 0, i2);
            this.itsData.itsICode = bArr;
            return bArr;
        }
        throw Kit.codeBug();
    }

    private void markTargetLabel(Node node) {
        int targetLabel = getTargetLabel(node);
        if (this.labelTable[targetLabel] != -1) {
            Kit.codeBug();
        }
        this.labelTable[targetLabel] = this.iCodeTop;
    }

    private void releaseLocal(int i) {
        int i2 = this.localTop - 1;
        this.localTop = i2;
        if (i != i2) {
            Kit.codeBug();
        }
    }

    private void resolveForwardGoto(int i) {
        int i2 = this.iCodeTop;
        if (i2 >= i + 3) {
            resolveGoto(i, i2);
            return;
        }
        throw Kit.codeBug();
    }

    private void resolveGoto(int i, int i2) {
        int i3 = i2 - i;
        if (i3 < 0 || i3 > 2) {
            int i4 = i + 1;
            if (i3 != ((short) i3)) {
                InterpreterData interpreterData = this.itsData;
                if (interpreterData.longJumps == null) {
                    interpreterData.longJumps = new UintMap();
                }
                this.itsData.longJumps.put(i4, i2);
                i3 = 0;
            }
            byte[] bArr = this.itsData.itsICode;
            bArr[i4] = (byte) (i3 >> 8);
            bArr[i4 + 1] = (byte) i3;
            return;
        }
        throw Kit.codeBug();
    }

    private void stackChange(int i) {
        int i2 = this.stackDepth + i;
        if (i > 0) {
            InterpreterData interpreterData = this.itsData;
            if (i2 > interpreterData.itsMaxStack) {
                interpreterData.itsMaxStack = i2;
            }
        }
        this.stackDepth = i2;
    }

    private void updateLineNumber(Node node) {
        int lineno = node.getLineno();
        if (lineno == this.lineNumber || lineno < 0) {
            return;
        }
        InterpreterData interpreterData = this.itsData;
        if (interpreterData.firstLinePC < 0) {
            interpreterData.firstLinePC = lineno;
        }
        this.lineNumber = lineno;
        addIcode(-26);
        addUint16(lineno & 65535);
    }

    private void visitArrayComprehension(Node node, Node node2, Node node3) {
        visitStatement(node2, this.stackDepth);
        visitExpression(node3, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void visitExpression(Node node, int i) {
        int i2;
        int existingIntProp;
        int i3;
        int i4;
        String string;
        String string2;
        int indexForNameNode;
        int i5;
        int type = node.getType();
        Node firstChild = node.getFirstChild();
        int i6 = this.stackDepth;
        int i7 = 0;
        if (type != 90) {
            int i8 = 7;
            if (type != 103) {
                if (type != 110) {
                    if (type != 127) {
                        if (type != 143) {
                            if (type != 147) {
                                if (type != 160) {
                                    switch (type) {
                                        case 8:
                                            string = firstChild.getString();
                                            visitExpression(firstChild, 0);
                                            visitExpression(firstChild.getNext(), 0);
                                            addStringOp(type, string);
                                            stackChange(-1);
                                            break;
                                        case 9:
                                        case 10:
                                        case 11:
                                        case 12:
                                        case 13:
                                        case 14:
                                        case 15:
                                        case 16:
                                        case 17:
                                        case 18:
                                        case 19:
                                        case 20:
                                        case 21:
                                        case 22:
                                        case 23:
                                        case 24:
                                        case 25:
                                        case 36:
                                        case 46:
                                        case 47:
                                            visitExpression(firstChild, 0);
                                            visitExpression(firstChild.getNext(), 0);
                                            addToken(type);
                                            stackChange(-1);
                                            break;
                                        case 26:
                                        case 27:
                                        case 28:
                                        case 29:
                                        case 32:
                                            break;
                                        case 30:
                                        case 38:
                                            if (type == 30) {
                                                visitExpression(firstChild, 0);
                                            } else {
                                                generateCallFunAndThis(firstChild);
                                            }
                                            int i9 = 0;
                                            while (true) {
                                                firstChild = firstChild.getNext();
                                                if (firstChild == null) {
                                                    int intProp = node.getIntProp(10, 0);
                                                    if (type == 71 || intProp == 0) {
                                                        if (type == 38 && (i & 1) != 0 && !this.compilerEnv.isGenerateDebugInfo() && !this.itsInTryFlag) {
                                                            type = -55;
                                                        }
                                                        addIndexOp(type, i9);
                                                    } else {
                                                        addIndexOp(-21, i9);
                                                        addUint8(intProp);
                                                        if (type == 30) {
                                                            i7 = 1;
                                                        }
                                                        addUint8(i7);
                                                        addUint16(this.lineNumber & 65535);
                                                    }
                                                    if (type == 30) {
                                                        stackChange(-i9);
                                                    } else {
                                                        stackChange((-1) - i9);
                                                    }
                                                    InterpreterData interpreterData = this.itsData;
                                                    if (i9 > interpreterData.itsMaxCalleeArgs) {
                                                        interpreterData.itsMaxCalleeArgs = i9;
                                                        break;
                                                    }
                                                } else {
                                                    visitExpression(firstChild, 0);
                                                    i9++;
                                                }
                                            }
                                            break;
                                        case 31:
                                            boolean z = firstChild.getType() == 49;
                                            visitExpression(firstChild, 0);
                                            visitExpression(firstChild.getNext(), 0);
                                            if (z) {
                                                addIcode(0);
                                                stackChange(-1);
                                                break;
                                            } else {
                                                i3 = 31;
                                                addToken(i3);
                                                stackChange(-1);
                                            }
                                        case 33:
                                        case 34:
                                            visitExpression(firstChild, 0);
                                            string2 = firstChild.getNext().getString();
                                            addStringOp(type, string2);
                                            break;
                                        case 35:
                                            visitExpression(firstChild, 0);
                                            Node next = firstChild.getNext();
                                            String string3 = next.getString();
                                            Node next2 = next.getNext();
                                            if (type == 140) {
                                                addIcode(-1);
                                                stackChange(1);
                                                addStringOp(33, string3);
                                                stackChange(-1);
                                            }
                                            visitExpression(next2, 0);
                                            addStringOp(35, string3);
                                            stackChange(-1);
                                            break;
                                        case 37:
                                            visitExpression(firstChild, 0);
                                            Node next3 = firstChild.getNext();
                                            visitExpression(next3, 0);
                                            Node next4 = next3.getNext();
                                            if (type == 141) {
                                                addIcode(-2);
                                                stackChange(2);
                                                addToken(36);
                                                stackChange(-1);
                                                stackChange(-1);
                                            }
                                            visitExpression(next4, 0);
                                            addToken(37);
                                            stackChange(-2);
                                            break;
                                        case 39:
                                        case 41:
                                        case 49:
                                            addStringOp(type, node.getString());
                                            stackChange(1);
                                            break;
                                        case 40:
                                            double d = node.getDouble();
                                            int i10 = (int) d;
                                            if (i10 != d) {
                                                existingIntProp = getDoubleIndex(d);
                                                type = 40;
                                                break;
                                            } else {
                                                if (i10 == 0) {
                                                    addIcode(-51);
                                                    if (1.0d / d < RoundRectDrawableWithShadow.COS_45) {
                                                        addToken(29);
                                                    }
                                                } else if (i10 == 1) {
                                                    addIcode(-52);
                                                } else if (((short) i10) == i10) {
                                                    addIcode(-27);
                                                    addUint16(i10 & 65535);
                                                } else {
                                                    addIcode(-28);
                                                    addInt(i10);
                                                }
                                                stackChange(1);
                                                break;
                                            }
                                        case 42:
                                        case 43:
                                        case 44:
                                        case 45:
                                            addToken(type);
                                            stackChange(1);
                                            break;
                                        case 48:
                                            existingIntProp = node.getExistingIntProp(4);
                                            type = 48;
                                            break;
                                        default:
                                            switch (type) {
                                                case 52:
                                                case 53:
                                                    break;
                                                case 54:
                                                    existingIntProp = getLocalBlockRef(node);
                                                    type = 54;
                                                    break;
                                                case 55:
                                                    if (this.itsData.itsNeedsActivation) {
                                                        Kit.codeBug();
                                                    }
                                                    addVarOp(55, this.scriptOrFn.getIndexForNameNode(node));
                                                    stackChange(1);
                                                    break;
                                                case 56:
                                                    if (this.itsData.itsNeedsActivation) {
                                                        Kit.codeBug();
                                                    }
                                                    indexForNameNode = this.scriptOrFn.getIndexForNameNode(firstChild);
                                                    visitExpression(firstChild.getNext(), 0);
                                                    i5 = 56;
                                                    addVarOp(i5, indexForNameNode);
                                                    break;
                                                default:
                                                    switch (type) {
                                                        case 62:
                                                        case 63:
                                                            existingIntProp = getLocalBlockRef(node);
                                                            break;
                                                        case 64:
                                                            break;
                                                        default:
                                                            switch (type) {
                                                                case 66:
                                                                case 67:
                                                                    visitLiteral(node, firstChild);
                                                                    break;
                                                                case 68:
                                                                case 70:
                                                                case 75:
                                                                case 76:
                                                                case 77:
                                                                    visitExpression(firstChild, 0);
                                                                    addToken(type);
                                                                    break;
                                                                case 69:
                                                                    break;
                                                                case 71:
                                                                    break;
                                                                case 72:
                                                                    visitExpression(firstChild, 0);
                                                                    string2 = (String) node.getProp(17);
                                                                    addStringOp(type, string2);
                                                                    break;
                                                                case 73:
                                                                    if (firstChild != null) {
                                                                        visitExpression(firstChild, 0);
                                                                    } else {
                                                                        addIcode(-50);
                                                                        stackChange(1);
                                                                    }
                                                                    addToken(73);
                                                                    addUint16(node.getLineno() & 65535);
                                                                    break;
                                                                case 74:
                                                                    break;
                                                                case 78:
                                                                case 79:
                                                                case 80:
                                                                case 81:
                                                                    int intProp2 = node.getIntProp(16, 0);
                                                                    int i11 = 0;
                                                                    do {
                                                                        visitExpression(firstChild, 0);
                                                                        i11++;
                                                                        firstChild = firstChild.getNext();
                                                                    } while (firstChild != null);
                                                                    addIndexOp(type, intProp2);
                                                                    stackChange(1 - i11);
                                                                    break;
                                                                default:
                                                                    switch (type) {
                                                                        case 105:
                                                                        case 106:
                                                                            visitExpression(firstChild, 0);
                                                                            addIcode(-1);
                                                                            stackChange(1);
                                                                            i2 = this.iCodeTop;
                                                                            if (type != 106) {
                                                                                i8 = 6;
                                                                            }
                                                                            addGotoOp(i8);
                                                                            stackChange(-1);
                                                                            addIcode(-4);
                                                                            stackChange(-1);
                                                                            visitExpression(firstChild.getNext(), i & 1);
                                                                            break;
                                                                        case 107:
                                                                        case 108:
                                                                            visitIncDec(node, firstChild);
                                                                            break;
                                                                        default:
                                                                            switch (type) {
                                                                                case Token.TYPEOFNAME /* 138 */:
                                                                                    int indexForNameNode2 = (!this.itsInFunctionFlag || this.itsData.itsNeedsActivation) ? -1 : this.scriptOrFn.getIndexForNameNode(node);
                                                                                    if (indexForNameNode2 != -1) {
                                                                                        addVarOp(55, indexForNameNode2);
                                                                                        stackChange(1);
                                                                                        i4 = 32;
                                                                                        break;
                                                                                    } else {
                                                                                        type = -14;
                                                                                        addStringOp(type, node.getString());
                                                                                        stackChange(1);
                                                                                        break;
                                                                                    }
                                                                                    break;
                                                                                case Token.USE_STACK /* 139 */:
                                                                                    stackChange(1);
                                                                                    break;
                                                                                case 140:
                                                                                    break;
                                                                                case 141:
                                                                                    break;
                                                                                default:
                                                                                    switch (type) {
                                                                                        case 156:
                                                                                            string = firstChild.getString();
                                                                                            visitExpression(firstChild, 0);
                                                                                            visitExpression(firstChild.getNext(), 0);
                                                                                            type = -59;
                                                                                            addStringOp(type, string);
                                                                                            stackChange(-1);
                                                                                            break;
                                                                                        case 157:
                                                                                            if (this.itsData.itsNeedsActivation) {
                                                                                                Kit.codeBug();
                                                                                            }
                                                                                            indexForNameNode = this.scriptOrFn.getIndexForNameNode(firstChild);
                                                                                            visitExpression(firstChild.getNext(), 0);
                                                                                            i5 = 157;
                                                                                            addVarOp(i5, indexForNameNode);
                                                                                            break;
                                                                                        case 158:
                                                                                            visitArrayComprehension(node, firstChild, firstChild.getNext());
                                                                                            break;
                                                                                        default:
                                                                                            throw badTree(node);
                                                                                    }
                                                                            }
                                                                    }
                                                            }
                                                    }
                                            }
                                    }
                                } else {
                                    Node firstChild2 = node.getFirstChild();
                                    Node next5 = firstChild2.getNext();
                                    visitExpression(firstChild2.getFirstChild(), 0);
                                    addToken(2);
                                    stackChange(-1);
                                    visitExpression(next5.getFirstChild(), 0);
                                    i4 = 3;
                                }
                                addToken(i4);
                            } else {
                                updateLineNumber(node);
                                visitExpression(firstChild, 0);
                                addIcode(-53);
                                stackChange(-1);
                                int i12 = this.iCodeTop;
                                visitExpression(firstChild.getNext(), 0);
                                addBackwardGoto(-54, i12);
                            }
                        }
                        visitExpression(firstChild, 0);
                        Node next6 = firstChild.getNext();
                        if (type == 143) {
                            addIcode(-1);
                            stackChange(1);
                            addToken(68);
                            stackChange(-1);
                        }
                        visitExpression(next6, 0);
                        i3 = 69;
                        addToken(i3);
                        stackChange(-1);
                    }
                    visitExpression(firstChild, 0);
                    if (type == 127) {
                        addIcode(-4);
                        addIcode(-50);
                    }
                    addToken(type);
                } else {
                    existingIntProp = node.getExistingIntProp(1);
                    FunctionNode functionNode = this.scriptOrFn.getFunctionNode(existingIntProp);
                    if (functionNode.getFunctionType() != 2 && functionNode.getFunctionType() != 4) {
                        throw Kit.codeBug();
                    }
                    type = -19;
                }
                addIndexOp(type, existingIntProp);
                stackChange(1);
            } else {
                Node next7 = firstChild.getNext();
                Node next8 = next7.getNext();
                visitExpression(firstChild, 0);
                int i13 = this.iCodeTop;
                addGotoOp(7);
                stackChange(-1);
                int i14 = i & 1;
                visitExpression(next7, i14);
                i2 = this.iCodeTop;
                addGotoOp(5);
                resolveForwardGoto(i13);
                this.stackDepth = i6;
                visitExpression(next8, i14);
            }
            resolveForwardGoto(i2);
        } else {
            Node lastChild = node.getLastChild();
            while (firstChild != lastChild) {
                visitExpression(firstChild, 0);
                addIcode(-4);
                stackChange(-1);
                firstChild = firstChild.getNext();
            }
            visitExpression(firstChild, i & 1);
        }
        if (i6 + 1 != this.stackDepth) {
            Kit.codeBug();
        }
    }

    private void visitIncDec(Node node, Node node2) {
        int existingIntProp = node.getExistingIntProp(13);
        int type = node2.getType();
        if (type != 33) {
            if (type == 36) {
                Node firstChild = node2.getFirstChild();
                visitExpression(firstChild, 0);
                visitExpression(firstChild.getNext(), 0);
                addIcode(-10);
                addUint8(existingIntProp);
                stackChange(-1);
                return;
            }
            if (type == 39) {
                addStringOp(-8, node2.getString());
            } else if (type == 55) {
                if (this.itsData.itsNeedsActivation) {
                    Kit.codeBug();
                }
                addVarOp(-7, this.scriptOrFn.getIndexForNameNode(node2));
            } else if (type != 68) {
                throw badTree(node);
            } else {
                visitExpression(node2.getFirstChild(), 0);
                addIcode(-11);
            }
            addUint8(existingIntProp);
            stackChange(1);
            return;
        }
        Node firstChild2 = node2.getFirstChild();
        visitExpression(firstChild2, 0);
        addStringOp(-9, firstChild2.getNext().getString());
        addUint8(existingIntProp);
    }

    private void visitLiteral(Node node, Node node2) {
        Object[] objArr;
        int length;
        int i;
        int type = node.getType();
        if (type == 66) {
            length = 0;
            for (Node node3 = node2; node3 != null; node3 = node3.getNext()) {
                length++;
            }
            objArr = null;
        } else if (type != 67) {
            throw badTree(node);
        } else {
            objArr = (Object[]) node.getProp(12);
            length = objArr.length;
        }
        addIndexOp(-29, length);
        stackChange(2);
        while (node2 != null) {
            int type2 = node2.getType();
            if (type2 == 152) {
                visitExpression(node2.getFirstChild(), 0);
                i = -57;
            } else if (type2 == 153) {
                visitExpression(node2.getFirstChild(), 0);
                i = -58;
            } else {
                if (type2 == 164) {
                    visitExpression(node2.getFirstChild(), 0);
                } else {
                    visitExpression(node2, 0);
                }
                addIcode(-30);
                stackChange(-1);
                node2 = node2.getNext();
            }
            addIcode(i);
            stackChange(-1);
            node2 = node2.getNext();
        }
        if (type == 66) {
            int[] iArr = (int[]) node.getProp(11);
            if (iArr == null) {
                addToken(66);
            } else {
                int size = this.literalIds.size();
                this.literalIds.add(iArr);
                addIndexOp(-31, size);
            }
        } else {
            int size2 = this.literalIds.size();
            this.literalIds.add(objArr);
            addIndexOp(67, size2);
        }
        stackChange(-1);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:39:0x014a A[LOOP:0: B:38:0x0148->B:39:0x014a, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void visitStatement(Node node, int i) {
        int i2;
        Node node2;
        int type = node.getType();
        Node firstChild = node.getFirstChild();
        if (type != -62) {
            if (type != 65) {
                int i3 = 1;
                if (type != 82) {
                    int i4 = -5;
                    if (type == 110) {
                        int existingIntProp = node.getExistingIntProp(1);
                        int functionType = this.scriptOrFn.getFunctionNode(existingIntProp).getFunctionType();
                        if (functionType == 3) {
                            addIndexOp(-20, existingIntProp);
                        } else if (functionType != 1) {
                            throw Kit.codeBug();
                        }
                        if (!this.itsInFunctionFlag) {
                            addIndexOp(-19, existingIntProp);
                            stackChange(1);
                            addIcode(i4);
                        }
                    } else if (type == 115) {
                        updateLineNumber(node);
                        visitExpression(firstChild, 0);
                        Node next = firstChild.getNext();
                        while (true) {
                            Jump jump = (Jump) next;
                            if (jump == null) {
                                addIcode(-4);
                                break;
                            } else if (jump.getType() != 116) {
                                throw badTree(jump);
                            } else {
                                Node firstChild2 = jump.getFirstChild();
                                addIcode(-1);
                                stackChange(1);
                                visitExpression(firstChild2, 0);
                                addToken(46);
                                stackChange(-1);
                                addGoto(jump.target, -6);
                                stackChange(-1);
                                next = jump.getNext();
                            }
                        }
                    } else {
                        if (type != 124) {
                            if (type == 126) {
                                stackChange(1);
                                int localBlockRef = getLocalBlockRef(node);
                                addIndexOp(-24, localBlockRef);
                                stackChange(-1);
                                while (firstChild != null) {
                                    visitStatement(firstChild, i);
                                    firstChild = firstChild.getNext();
                                }
                                addIndexOp(-25, localBlockRef);
                            } else if (type != 142) {
                                if (type == 161) {
                                    i2 = -64;
                                } else if (type == 50) {
                                    updateLineNumber(node);
                                    visitExpression(firstChild, 0);
                                    addToken(50);
                                    addUint16(this.lineNumber & 65535);
                                } else if (type != 51) {
                                    switch (type) {
                                        case 2:
                                            visitExpression(firstChild, 0);
                                            addToken(2);
                                            break;
                                        case 3:
                                            addToken(3);
                                            break;
                                        case 4:
                                            updateLineNumber(node);
                                            if (node.getIntProp(20, 0) == 0) {
                                                if (firstChild == null) {
                                                    i2 = -22;
                                                    break;
                                                } else {
                                                    visitExpression(firstChild, 1);
                                                    addToken(4);
                                                    break;
                                                }
                                            } else {
                                                addIcode(-63);
                                                addUint16(this.lineNumber & 65535);
                                                break;
                                            }
                                        case 5:
                                            node2 = ((Jump) node).target;
                                            addGoto(node2, type);
                                            break;
                                        case 6:
                                        case 7:
                                            Node node3 = ((Jump) node).target;
                                            visitExpression(firstChild, 0);
                                            addGoto(node3, type);
                                            break;
                                        default:
                                            switch (type) {
                                                case 57:
                                                    int localBlockRef2 = getLocalBlockRef(node);
                                                    int existingIntProp2 = node.getExistingIntProp(14);
                                                    String string = firstChild.getString();
                                                    visitExpression(firstChild.getNext(), 0);
                                                    addStringPrefix(string);
                                                    addIndexPrefix(localBlockRef2);
                                                    addToken(57);
                                                    if (existingIntProp2 == 0) {
                                                        i3 = 0;
                                                    }
                                                    addUint8(i3);
                                                    break;
                                                case 58:
                                                case 59:
                                                case 60:
                                                case 61:
                                                    visitExpression(firstChild, 0);
                                                    addIndexOp(type, getLocalBlockRef(node));
                                                    break;
                                                default:
                                                    switch (type) {
                                                        case 129:
                                                        case 130:
                                                        case Token.LABEL /* 131 */:
                                                        case Token.LOOP /* 133 */:
                                                            break;
                                                        case Token.TARGET /* 132 */:
                                                            markTargetLabel(node);
                                                            break;
                                                        case Token.EXPR_VOID /* 134 */:
                                                        case Token.EXPR_RESULT /* 135 */:
                                                            updateLineNumber(node);
                                                            visitExpression(firstChild, 0);
                                                            if (type == 134) {
                                                                i4 = -4;
                                                            }
                                                            addIcode(i4);
                                                            break;
                                                        case Token.JSR /* 136 */:
                                                            node2 = ((Jump) node).target;
                                                            type = -23;
                                                            addGoto(node2, type);
                                                            break;
                                                        case Token.SCRIPT /* 137 */:
                                                            while (firstChild != null) {
                                                                visitStatement(firstChild, i);
                                                                firstChild = firstChild.getNext();
                                                            }
                                                            break;
                                                        default:
                                                            throw badTree(node);
                                                    }
                                            }
                                    }
                                } else {
                                    updateLineNumber(node);
                                    addIndexOp(51, getLocalBlockRef(node));
                                }
                                addIcode(i2);
                            } else {
                                int allocLocal = allocLocal();
                                node.putIntProp(2, allocLocal);
                                updateLineNumber(node);
                                while (firstChild != null) {
                                    visitStatement(firstChild, i);
                                    firstChild = firstChild.getNext();
                                }
                                addIndexOp(-56, allocLocal);
                                releaseLocal(allocLocal);
                            }
                        }
                        updateLineNumber(node);
                        while (firstChild != null) {
                        }
                    }
                    stackChange(-1);
                } else {
                    Jump jump2 = (Jump) node;
                    int localBlockRef3 = getLocalBlockRef(jump2);
                    int allocLocal2 = allocLocal();
                    addIndexOp(-13, allocLocal2);
                    int i5 = this.iCodeTop;
                    boolean z = this.itsInTryFlag;
                    this.itsInTryFlag = true;
                    while (firstChild != null) {
                        visitStatement(firstChild, i);
                        firstChild = firstChild.getNext();
                    }
                    this.itsInTryFlag = z;
                    Node node4 = jump2.target;
                    if (node4 != null) {
                        int i6 = this.labelTable[getTargetLabel(node4)];
                        addExceptionHandler(i5, i6, i6, false, localBlockRef3, allocLocal2);
                    }
                    Node node5 = jump2.getFinally();
                    if (node5 != null) {
                        int i7 = this.labelTable[getTargetLabel(node5)];
                        addExceptionHandler(i5, i7, i7, true, localBlockRef3, allocLocal2);
                    }
                    addIndexOp(-56, allocLocal2);
                    releaseLocal(allocLocal2);
                }
            } else {
                updateLineNumber(node);
                addToken(65);
            }
        }
        if (this.stackDepth == i) {
            return;
        }
        throw Kit.codeBug();
    }

    public InterpreterData compile(CompilerEnvirons compilerEnvirons, ScriptNode scriptNode, String str, boolean z) {
        this.compilerEnv = compilerEnvirons;
        new NodeTransformer().transform(scriptNode, compilerEnvirons);
        if (z) {
            scriptNode = scriptNode.getFunctionNode(0);
        }
        this.scriptOrFn = scriptNode;
        InterpreterData interpreterData = new InterpreterData(compilerEnvirons.getLanguageVersion(), this.scriptOrFn.getSourceName(), str, this.scriptOrFn.isInStrictMode());
        this.itsData = interpreterData;
        interpreterData.topLevel = true;
        if (z) {
            generateFunctionICode();
        } else {
            generateICodeFromTree(this.scriptOrFn);
        }
        return this.itsData;
    }
}
