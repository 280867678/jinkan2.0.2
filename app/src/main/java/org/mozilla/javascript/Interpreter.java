package org.mozilla.javascript;

import androidx.cardview.widget.RoundRectDrawableWithShadow;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.EqualObjectGraphs;
import org.mozilla.javascript.Interpreter;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ast.ScriptNode;
import org.mozilla.javascript.debug.DebugFrame;
import org.mozilla.javascript.debug.Debugger;

/* loaded from: classes5.dex */
public final class Interpreter extends Icode implements Evaluator {
    public static final int EXCEPTION_HANDLER_SLOT = 2;
    public static final int EXCEPTION_LOCAL_SLOT = 4;
    public static final int EXCEPTION_SCOPE_SLOT = 5;
    public static final int EXCEPTION_SLOT_SIZE = 6;
    public static final int EXCEPTION_TRY_END_SLOT = 1;
    public static final int EXCEPTION_TRY_START_SLOT = 0;
    public static final int EXCEPTION_TYPE_SLOT = 3;
    public InterpreterData itsData;

    /* loaded from: classes5.dex */
    public static class CallFrame implements Cloneable, Serializable {
        public static final long serialVersionUID = -2843792508994958978L;
        public final DebugFrame debuggerFrame;
        public final int emptyStackTop;
        public final InterpretedFunction fnOrScript;
        public int frameIndex;
        public boolean frozen;
        public final InterpreterData idata;
        public boolean isContinuationsTopFrame;
        public final int localShift;
        public CallFrame parentFrame;

        /* renamed from: pc */
        public int f4669pc;
        public int pcPrevBranch;
        public int pcSourceLineStart;
        public Object result;
        public double resultDbl;
        public double[] sDbl;
        public int savedCallOp;
        public int savedStackTop;
        public Scriptable scope;
        public Object[] stack;
        public int[] stackAttributes;
        public final Scriptable thisObj;
        public Object throwable;
        public final boolean useActivation;
        public final CallFrame varSource;

        public CallFrame(Context context, Scriptable scriptable, InterpretedFunction interpretedFunction, CallFrame callFrame) {
            InterpreterData interpreterData = interpretedFunction.idata;
            this.idata = interpreterData;
            Debugger debugger = context.debugger;
            DebugFrame frame = debugger != null ? debugger.getFrame(context, interpreterData) : null;
            this.debuggerFrame = frame;
            int i = 0;
            this.useActivation = frame != null || this.idata.itsNeedsActivation;
            InterpreterData interpreterData2 = this.idata;
            int i2 = interpreterData2.itsMaxVars;
            this.emptyStackTop = (interpreterData2.itsMaxLocals + i2) - 1;
            this.fnOrScript = interpretedFunction;
            this.varSource = this;
            this.localShift = i2;
            this.thisObj = scriptable;
            this.parentFrame = callFrame;
            i = callFrame != null ? callFrame.frameIndex + 1 : i;
            this.frameIndex = i;
            if (i <= context.getMaximumInterpreterStackDepth()) {
                this.result = Undefined.instance;
                this.pcSourceLineStart = this.idata.firstLinePC;
                this.savedStackTop = this.emptyStackTop;
                return;
            }
            throw Context.reportRuntimeError("Exceeded maximum stack depth");
        }

        public static boolean equals(CallFrame callFrame, CallFrame callFrame2, EqualObjectGraphs equalObjectGraphs) {
            while (callFrame != callFrame2) {
                if (callFrame == null || callFrame2 == null || !callFrame.fieldsEqual(callFrame2, equalObjectGraphs)) {
                    return false;
                }
                callFrame = callFrame.parentFrame;
                callFrame2 = callFrame2.parentFrame;
            }
            return true;
        }

        private boolean equalsInTopScope(final Object obj) {
            return ((Boolean) EqualObjectGraphs.withThreadLocal(new java.util.function.Function() { // from class: me.tvspark.p21
                @Override // java.util.function.Function
                public final Object apply(Object obj2) {
                    return Interpreter.CallFrame.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, (EqualObjectGraphs) obj2);
                }
            })).booleanValue();
        }

        private boolean fieldsEqual(CallFrame callFrame, EqualObjectGraphs equalObjectGraphs) {
            return this.frameIndex == callFrame.frameIndex && this.f4669pc == callFrame.f4669pc && Interpreter.compareIdata(this.idata, callFrame.idata) && equalObjectGraphs.equalGraphs(this.varSource.stack, callFrame.varSource.stack) && Arrays.equals(this.varSource.sDbl, callFrame.varSource.sDbl) && equalObjectGraphs.equalGraphs(this.thisObj, callFrame.thisObj) && equalObjectGraphs.equalGraphs(this.fnOrScript, callFrame.fnOrScript) && equalObjectGraphs.equalGraphs(this.scope, callFrame.scope);
        }

        private boolean isStrictTopFrame() {
            CallFrame callFrame = this;
            while (true) {
                CallFrame callFrame2 = callFrame.parentFrame;
                if (callFrame2 == null) {
                    return callFrame.idata.isStrict;
                }
                callFrame = callFrame2;
            }
        }

        public /* synthetic */ Boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, EqualObjectGraphs equalObjectGraphs) {
            return Boolean.valueOf(equals(this, (CallFrame) obj, equalObjectGraphs));
        }

        public /* synthetic */ Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
            return Boolean.valueOf(equalsInTopScope(obj));
        }

        public CallFrame cloneFrozen() {
            if (!this.frozen) {
                Kit.codeBug();
            }
            try {
                CallFrame callFrame = (CallFrame) clone();
                callFrame.stack = (Object[]) this.stack.clone();
                callFrame.stackAttributes = (int[]) this.stackAttributes.clone();
                callFrame.sDbl = (double[]) this.sDbl.clone();
                callFrame.frozen = false;
                return callFrame;
            } catch (CloneNotSupportedException unused) {
                throw new IllegalStateException();
            }
        }

        public boolean equals(final Object obj) {
            if (obj instanceof CallFrame) {
                Context enter = Context.enter();
                try {
                    if (ScriptRuntime.hasTopCall(enter)) {
                        return equalsInTopScope(obj);
                    }
                    Scriptable topLevelScope = ScriptableObject.getTopLevelScope(this.scope);
                    return ((Boolean) ScriptRuntime.doTopCall(new Callable() { // from class: me.tvspark.o21
                        @Override // org.mozilla.javascript.Callable
                        public final Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
                            return Interpreter.CallFrame.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, context, scriptable, scriptable2, objArr);
                        }
                    }, enter, topLevelScope, topLevelScope, ScriptRuntime.emptyArgs, isStrictTopFrame())).booleanValue();
                } finally {
                    Context.exit();
                }
            }
            return false;
        }

        public int hashCode() {
            int i = 0;
            int i2 = 0;
            CallFrame callFrame = this;
            while (true) {
                i = (((i * 31) + callFrame.f4669pc) * 31) + callFrame.idata.icodeHashCode();
                callFrame = callFrame.parentFrame;
                if (callFrame == null) {
                    break;
                }
                int i3 = i2 + 1;
                if (i2 >= 8) {
                    break;
                }
                i2 = i3;
            }
            return i;
        }

        public void initializeArgs(Context context, Scriptable scriptable, Object[] objArr, double[] dArr, int i, int i2) {
            if (this.useActivation) {
                if (dArr != null) {
                    objArr = Interpreter.getArgsArray(objArr, dArr, i, i2);
                }
                dArr = null;
                i = 0;
            }
            if (this.idata.itsFunctionType != 0) {
                Scriptable parentScope = this.fnOrScript.getParentScope();
                this.scope = parentScope;
                if (this.useActivation) {
                    InterpreterData interpreterData = this.idata;
                    this.scope = interpreterData.itsFunctionType == 4 ? ScriptRuntime.createArrowFunctionActivation(this.fnOrScript, parentScope, objArr, interpreterData.isStrict) : ScriptRuntime.createFunctionActivation(this.fnOrScript, parentScope, objArr, interpreterData.isStrict);
                }
            } else {
                this.scope = scriptable;
                InterpretedFunction interpretedFunction = this.fnOrScript;
                ScriptRuntime.initScript(interpretedFunction, this.thisObj, context, scriptable, interpretedFunction.idata.evalScriptFlag);
            }
            InterpreterData interpreterData2 = this.idata;
            if (interpreterData2.itsNestedFunctions != null) {
                if (interpreterData2.itsFunctionType != 0 && !interpreterData2.itsNeedsActivation) {
                    Kit.codeBug();
                }
                int i3 = 0;
                while (true) {
                    InterpreterData[] interpreterDataArr = this.idata.itsNestedFunctions;
                    if (i3 >= interpreterDataArr.length) {
                        break;
                    }
                    if (interpreterDataArr[i3].itsFunctionType == 1) {
                        Interpreter.initFunction(context, this.scope, this.fnOrScript, i3);
                    }
                    i3++;
                }
            }
            InterpreterData interpreterData3 = this.idata;
            int i4 = interpreterData3.itsMaxFrameArray;
            if (i4 != this.emptyStackTop + interpreterData3.itsMaxStack + 1) {
                Kit.codeBug();
            }
            this.stack = new Object[i4];
            this.stackAttributes = new int[i4];
            this.sDbl = new double[i4];
            int paramAndVarCount = this.idata.getParamAndVarCount();
            for (int i5 = 0; i5 < paramAndVarCount; i5++) {
                if (this.idata.getParamOrVarConst(i5)) {
                    this.stackAttributes[i5] = 13;
                }
            }
            int i6 = this.idata.argCount;
            if (i6 <= i2) {
                i2 = i6;
            }
            System.arraycopy(objArr, i, this.stack, 0, i2);
            if (dArr != null) {
                System.arraycopy(dArr, i, this.sDbl, 0, i2);
            }
            while (i2 != this.idata.itsMaxVars) {
                this.stack[i2] = Undefined.instance;
                i2++;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class ContinuationJump implements Serializable {
        public static final long serialVersionUID = 7687739156004308247L;
        public CallFrame branchFrame;
        public CallFrame capturedFrame;
        public Object result;
        public double resultDbl;

        public ContinuationJump(NativeContinuation nativeContinuation, CallFrame callFrame) {
            CallFrame callFrame2 = (CallFrame) nativeContinuation.getImplementation();
            this.capturedFrame = callFrame2;
            if (callFrame2 == null || callFrame == null) {
                this.branchFrame = null;
                return;
            }
            int i = callFrame2.frameIndex - callFrame.frameIndex;
            if (i != 0) {
                if (i < 0) {
                    i = -i;
                } else {
                    callFrame = callFrame2;
                    callFrame2 = callFrame;
                }
                do {
                    callFrame = callFrame.parentFrame;
                    i--;
                } while (i != 0);
                if (callFrame.frameIndex != callFrame2.frameIndex) {
                    Kit.codeBug();
                }
                callFrame = callFrame2;
                callFrame2 = callFrame;
            }
            while (callFrame2 != callFrame && callFrame2 != null) {
                callFrame2 = callFrame2.parentFrame;
                callFrame = callFrame.parentFrame;
            }
            this.branchFrame = callFrame2;
            if (callFrame2 == null || callFrame2.frozen) {
                return;
            }
            Kit.codeBug();
        }
    }

    /* loaded from: classes5.dex */
    public static class GeneratorState {
        public int operation;
        public RuntimeException returnedException;
        public Object value;

        public GeneratorState(int i, Object obj) {
            this.operation = i;
            this.value = obj;
        }
    }

    public static void addInstructionCount(Context context, CallFrame callFrame, int i) {
        int i2 = (callFrame.f4669pc - callFrame.pcPrevBranch) + i + context.instructionCount;
        context.instructionCount = i2;
        if (i2 > context.instructionThreshold) {
            context.observeInstructionCount(i2);
            context.instructionCount = 0;
        }
    }

    public static int bytecodeSpan(int i) {
        if (i != -54 && i != -23) {
            if (i == -21) {
                return 5;
            }
            if (i != 50) {
                if (i != 57) {
                    if (i != 73 && i != 5 && i != 6 && i != 7) {
                        switch (i) {
                            case Icode.Icode_GENERATOR_END /* -63 */:
                            case Icode.Icode_GENERATOR /* -62 */:
                                break;
                            case Icode.Icode_SETCONSTVAR1 /* -61 */:
                                break;
                            default:
                                switch (i) {
                                    case Icode.Icode_SETVAR1 /* -49 */:
                                    case Icode.Icode_GETVAR1 /* -48 */:
                                        break;
                                    case Icode.Icode_REG_STR4 /* -47 */:
                                        return 5;
                                    case Icode.Icode_REG_STR2 /* -46 */:
                                        return 3;
                                    case Icode.Icode_REG_STR1 /* -45 */:
                                        return 2;
                                    default:
                                        switch (i) {
                                            case Icode.Icode_REG_IND4 /* -40 */:
                                                return 5;
                                            case Icode.Icode_REG_IND2 /* -39 */:
                                                return 3;
                                            case -38:
                                                return 2;
                                            default:
                                                switch (i) {
                                                    case -28:
                                                        return 5;
                                                    case -27:
                                                    case -26:
                                                        return 3;
                                                    default:
                                                        switch (i) {
                                                            case -11:
                                                            case -10:
                                                            case -9:
                                                            case -8:
                                                            case -7:
                                                                return 2;
                                                            case -6:
                                                                break;
                                                            default:
                                                                if (!Icode.validBytecode(i)) {
                                                                    throw Kit.codeBug();
                                                                }
                                                                return 1;
                                                        }
                                                }
                                        }
                                }
                        }
                    }
                }
                return 2;
            }
            return 3;
        }
        return 3;
    }

    public static NativeContinuation captureContinuation(Context context) {
        Object obj = context.lastInterpreterFrame;
        if (obj == null || !(obj instanceof CallFrame)) {
            throw new IllegalStateException("Interpreter frames not found");
        }
        return captureContinuation(context, (CallFrame) obj, true);
    }

    public static NativeContinuation captureContinuation(Context context, CallFrame callFrame, boolean z) {
        Object[] objArr;
        NativeContinuation nativeContinuation = new NativeContinuation();
        ScriptRuntime.setObjectProtoAndParent(nativeContinuation, ScriptRuntime.getTopCallScope(context));
        CallFrame callFrame2 = callFrame;
        CallFrame callFrame3 = callFrame2;
        while (callFrame2 != null && !callFrame2.frozen) {
            callFrame2.frozen = true;
            int i = callFrame2.savedStackTop + 1;
            while (true) {
                objArr = callFrame2.stack;
                if (i == objArr.length) {
                    break;
                }
                objArr[i] = null;
                callFrame2.stackAttributes[i] = 0;
                i++;
            }
            int i2 = callFrame2.savedCallOp;
            if (i2 == 38) {
                objArr[callFrame2.savedStackTop] = null;
            } else if (i2 != 30) {
                Kit.codeBug();
            }
            callFrame3 = callFrame2;
            callFrame2 = callFrame2.parentFrame;
        }
        if (z) {
            while (true) {
                CallFrame callFrame4 = callFrame3.parentFrame;
                if (callFrame4 == null) {
                    break;
                }
                callFrame3 = callFrame4;
            }
            if (!callFrame3.isContinuationsTopFrame) {
                throw new IllegalStateException("Cannot capture continuation from JavaScript code not called directly by executeScriptWithContinuations or callFunctionWithContinuations");
            }
        }
        nativeContinuation.initImplementation(callFrame);
        return nativeContinuation;
    }

    public static CallFrame captureFrameForGenerator(CallFrame callFrame) {
        callFrame.frozen = true;
        CallFrame cloneFrozen = callFrame.cloneFrozen();
        callFrame.frozen = false;
        cloneFrozen.parentFrame = null;
        cloneFrozen.frameIndex = 0;
        return cloneFrozen;
    }

    public static boolean compareIdata(InterpreterData interpreterData, InterpreterData interpreterData2) {
        return interpreterData == interpreterData2 || Objects.equals(getEncodedSource(interpreterData), getEncodedSource(interpreterData2));
    }

    /* JADX WARN: Type inference failed for: r2v7 */
    public static void doAdd(Object[] objArr, double[] dArr, int i, Context context) {
        double d;
        boolean z;
        CharSequence charSequence;
        int i2 = i + 1;
        Object obj = objArr[i2];
        Object obj2 = objArr[i];
        UniqueTag uniqueTag = UniqueTag.DOUBLE_MARK;
        if (obj == uniqueTag) {
            d = dArr[i2];
            if (obj2 == uniqueTag) {
                dArr[i] = dArr[i] + d;
                return;
            } else {
                z = true;
                charSequence = obj2;
            }
        } else if (obj2 != uniqueTag) {
            if ((obj2 instanceof Scriptable) || (obj instanceof Scriptable)) {
                objArr[i] = ScriptRuntime.add(obj2, obj, context);
                return;
            } else if ((obj2 instanceof CharSequence) || (obj instanceof CharSequence)) {
                objArr[i] = new ConsString(ScriptRuntime.toCharSequence(obj2), ScriptRuntime.toCharSequence(obj));
                return;
            } else {
                double doubleValue = obj2 instanceof Number ? ((Number) obj2).doubleValue() : ScriptRuntime.toNumber(obj2);
                double doubleValue2 = obj instanceof Number ? ((Number) obj).doubleValue() : ScriptRuntime.toNumber(obj);
                objArr[i] = UniqueTag.DOUBLE_MARK;
                dArr[i] = doubleValue + doubleValue2;
                return;
            }
        } else {
            double d2 = dArr[i];
            ?? r2 = obj;
            d = r2;
            z = false;
            charSequence = r2;
        }
        if (charSequence instanceof Scriptable) {
            Number wrapNumber = ScriptRuntime.wrapNumber(d);
            CharSequence charSequence2 = charSequence;
            if (!z) {
                Number number = charSequence;
                charSequence2 = wrapNumber;
                wrapNumber = number;
            }
            objArr[i] = ScriptRuntime.add(charSequence2, wrapNumber, context);
        } else if (!(charSequence instanceof CharSequence)) {
            double doubleValue3 = charSequence instanceof Number ? ((Number) charSequence).doubleValue() : ScriptRuntime.toNumber(charSequence);
            objArr[i] = UniqueTag.DOUBLE_MARK;
            dArr[i] = doubleValue3 + d;
        } else {
            CharSequence charSequence3 = charSequence;
            CharSequence charSequence4 = ScriptRuntime.toCharSequence(Double.valueOf(d));
            if (z) {
                objArr[i] = new ConsString(charSequence3, charSequence4);
            } else {
                objArr[i] = new ConsString(charSequence4, charSequence3);
            }
        }
    }

    public static int doArithmetic(CallFrame callFrame, int i, Object[] objArr, double[] dArr, int i2) {
        double stack_double = stack_double(callFrame, i2);
        int i3 = i2 - 1;
        double stack_double2 = stack_double(callFrame, i3);
        objArr[i3] = UniqueTag.DOUBLE_MARK;
        switch (i) {
            case 22:
                stack_double2 -= stack_double;
                break;
            case 23:
                stack_double2 *= stack_double;
                break;
            case 24:
                stack_double2 /= stack_double;
                break;
            case 25:
                stack_double2 %= stack_double;
                break;
        }
        dArr[i3] = stack_double2;
        return i3;
    }

    public static int doBitOp(CallFrame callFrame, int i, Object[] objArr, double[] dArr, int i2) {
        int stack_int32 = stack_int32(callFrame, i2 - 1);
        int stack_int322 = stack_int32(callFrame, i2);
        int i3 = i2 - 1;
        objArr[i3] = UniqueTag.DOUBLE_MARK;
        if (i == 18) {
            stack_int32 <<= stack_int322;
        } else if (i != 19) {
            switch (i) {
                case 9:
                    stack_int32 |= stack_int322;
                    break;
                case 10:
                    stack_int32 ^= stack_int322;
                    break;
                case 11:
                    stack_int32 &= stack_int322;
                    break;
            }
        } else {
            stack_int32 >>= stack_int322;
        }
        dArr[i3] = stack_int32;
        return i3;
    }

    public static int doCallSpecial(Context context, CallFrame callFrame, Object[] objArr, double[] dArr, int i, byte[] bArr, int i2) {
        int i3;
        int i4 = callFrame.f4669pc;
        int i5 = bArr[i4] & 255;
        boolean z = true;
        if (bArr[i4 + 1] == 0) {
            z = false;
        }
        int index = getIndex(bArr, callFrame.f4669pc + 2);
        if (z) {
            i3 = i - i2;
            Object obj = objArr[i3];
            if (obj == UniqueTag.DOUBLE_MARK) {
                obj = ScriptRuntime.wrapNumber(dArr[i3]);
            }
            objArr[i3] = ScriptRuntime.newSpecial(context, obj, getArgsArray(objArr, dArr, i3 + 1, i2), callFrame.scope, i5);
        } else {
            i3 = i - (i2 + 1);
            objArr[i3] = ScriptRuntime.callSpecial(context, (Callable) objArr[i3], (Scriptable) objArr[i3 + 1], getArgsArray(objArr, dArr, i3 + 2, i2), callFrame.scope, callFrame.thisObj, i5, callFrame.idata.itsSourceFile, index);
        }
        callFrame.f4669pc += 4;
        return i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0027, code lost:
        if (r2 >= r0) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0029, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
        if (r2 > r0) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0032, code lost:
        if (r2 <= r0) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0037, code lost:
        if (r2 < r0) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int doCompare(CallFrame callFrame, int i, Object[] objArr, double[] dArr, int i2) {
        boolean cmp_LT;
        double number;
        double d;
        int i3 = i2 - 1;
        int i4 = i3 + 1;
        Object obj = objArr[i4];
        Object obj2 = objArr[i3];
        UniqueTag uniqueTag = UniqueTag.DOUBLE_MARK;
        if (obj == uniqueTag) {
            number = dArr[i4];
            d = stack_double(callFrame, i3);
        } else if (obj2 != uniqueTag) {
            switch (i) {
                case 14:
                    cmp_LT = ScriptRuntime.cmp_LT(obj2, obj);
                    break;
                case 15:
                    cmp_LT = ScriptRuntime.cmp_LE(obj2, obj);
                    break;
                case 16:
                    cmp_LT = ScriptRuntime.cmp_LT(obj, obj2);
                    break;
                case 17:
                    cmp_LT = ScriptRuntime.cmp_LE(obj, obj2);
                    break;
                default:
                    throw Kit.codeBug();
            }
            objArr[i3] = ScriptRuntime.wrapBoolean(cmp_LT);
            return i3;
        } else {
            number = ScriptRuntime.toNumber(obj);
            d = dArr[i3];
        }
        cmp_LT = false;
        switch (i) {
            case 14:
                break;
            case 15:
                break;
            case 16:
                break;
            case 17:
                break;
            default:
                throw Kit.codeBug();
        }
        objArr[i3] = ScriptRuntime.wrapBoolean(cmp_LT);
        return i3;
    }

    public static int doDelName(Context context, CallFrame callFrame, int i, Object[] objArr, double[] dArr, int i2) {
        Object obj = objArr[i2];
        if (obj == UniqueTag.DOUBLE_MARK) {
            obj = ScriptRuntime.wrapNumber(dArr[i2]);
        }
        int i3 = i2 - 1;
        Object obj2 = objArr[i3];
        if (obj2 == UniqueTag.DOUBLE_MARK) {
            obj2 = ScriptRuntime.wrapNumber(dArr[i3]);
        }
        objArr[i3] = ScriptRuntime.delete(obj2, obj, context, callFrame.scope, i == 0);
        return i3;
    }

    public static int doElemIncDec(Context context, CallFrame callFrame, byte[] bArr, Object[] objArr, double[] dArr, int i) {
        Object obj = objArr[i];
        if (obj == UniqueTag.DOUBLE_MARK) {
            obj = ScriptRuntime.wrapNumber(dArr[i]);
        }
        int i2 = i - 1;
        Object obj2 = objArr[i2];
        if (obj2 == UniqueTag.DOUBLE_MARK) {
            obj2 = ScriptRuntime.wrapNumber(dArr[i2]);
        }
        objArr[i2] = ScriptRuntime.elemIncrDecr(obj2, obj, context, callFrame.scope, bArr[callFrame.f4669pc]);
        callFrame.f4669pc++;
        return i2;
    }

    public static boolean doEquals(Object[] objArr, double[] dArr, int i) {
        int i2 = i + 1;
        Object obj = objArr[i2];
        Object obj2 = objArr[i];
        UniqueTag uniqueTag = UniqueTag.DOUBLE_MARK;
        return obj == uniqueTag ? obj2 == uniqueTag ? dArr[i] == dArr[i2] : ScriptRuntime.eqNumber(dArr[i2], obj2) : obj2 == uniqueTag ? ScriptRuntime.eqNumber(dArr[i], obj) : ScriptRuntime.m26eq(obj2, obj);
    }

    public static int doGetElem(Context context, CallFrame callFrame, Object[] objArr, double[] dArr, int i) {
        int i2 = i - 1;
        Object obj = objArr[i2];
        if (obj == UniqueTag.DOUBLE_MARK) {
            obj = ScriptRuntime.wrapNumber(dArr[i2]);
        }
        int i3 = i2 + 1;
        Object obj2 = objArr[i3];
        objArr[i2] = obj2 != UniqueTag.DOUBLE_MARK ? ScriptRuntime.getObjectElem(obj, obj2, context, callFrame.scope) : ScriptRuntime.getObjectIndex(obj, dArr[i3], context, callFrame.scope);
        return i2;
    }

    public static int doGetVar(CallFrame callFrame, Object[] objArr, double[] dArr, int i, Object[] objArr2, double[] dArr2, int i2) {
        int i3 = i + 1;
        if (!callFrame.useActivation) {
            objArr[i3] = objArr2[i2];
            dArr[i3] = dArr2[i2];
        } else {
            String str = callFrame.idata.argNames[i2];
            Scriptable scriptable = callFrame.scope;
            objArr[i3] = scriptable.get(str, scriptable);
        }
        return i3;
    }

    public static int doInOrInstanceof(Context context, int i, Object[] objArr, double[] dArr, int i2) {
        Object obj = objArr[i2];
        if (obj == UniqueTag.DOUBLE_MARK) {
            obj = ScriptRuntime.wrapNumber(dArr[i2]);
        }
        int i3 = i2 - 1;
        Object obj2 = objArr[i3];
        if (obj2 == UniqueTag.DOUBLE_MARK) {
            obj2 = ScriptRuntime.wrapNumber(dArr[i3]);
        }
        objArr[i3] = ScriptRuntime.wrapBoolean(i == 52 ? ScriptRuntime.m25in(obj2, obj, context) : ScriptRuntime.instanceOf(obj2, obj, context));
        return i3;
    }

    public static int doRefMember(Context context, Object[] objArr, double[] dArr, int i, int i2) {
        Object obj = objArr[i];
        if (obj == UniqueTag.DOUBLE_MARK) {
            obj = ScriptRuntime.wrapNumber(dArr[i]);
        }
        int i3 = i - 1;
        Object obj2 = objArr[i3];
        if (obj2 == UniqueTag.DOUBLE_MARK) {
            obj2 = ScriptRuntime.wrapNumber(dArr[i3]);
        }
        objArr[i3] = ScriptRuntime.memberRef(obj2, obj, context, i2);
        return i3;
    }

    public static int doRefNsMember(Context context, Object[] objArr, double[] dArr, int i, int i2) {
        Object obj = objArr[i];
        if (obj == UniqueTag.DOUBLE_MARK) {
            obj = ScriptRuntime.wrapNumber(dArr[i]);
        }
        int i3 = i - 1;
        Object obj2 = objArr[i3];
        if (obj2 == UniqueTag.DOUBLE_MARK) {
            obj2 = ScriptRuntime.wrapNumber(dArr[i3]);
        }
        int i4 = i3 - 1;
        Object obj3 = objArr[i4];
        if (obj3 == UniqueTag.DOUBLE_MARK) {
            obj3 = ScriptRuntime.wrapNumber(dArr[i4]);
        }
        objArr[i4] = ScriptRuntime.memberRef(obj3, obj2, obj, context, i2);
        return i4;
    }

    public static int doRefNsName(Context context, CallFrame callFrame, Object[] objArr, double[] dArr, int i, int i2) {
        Object obj = objArr[i];
        if (obj == UniqueTag.DOUBLE_MARK) {
            obj = ScriptRuntime.wrapNumber(dArr[i]);
        }
        int i3 = i - 1;
        Object obj2 = objArr[i3];
        if (obj2 == UniqueTag.DOUBLE_MARK) {
            obj2 = ScriptRuntime.wrapNumber(dArr[i3]);
        }
        objArr[i3] = ScriptRuntime.nameRef(obj2, obj, context, callFrame.scope, i2);
        return i3;
    }

    public static int doSetConstVar(CallFrame callFrame, Object[] objArr, double[] dArr, int i, Object[] objArr2, double[] dArr2, int[] iArr, int i2) {
        if (callFrame.useActivation) {
            Object obj = objArr[i];
            if (obj == UniqueTag.DOUBLE_MARK) {
                obj = ScriptRuntime.wrapNumber(dArr[i]);
            }
            String str = callFrame.idata.argNames[i2];
            Scriptable scriptable = callFrame.scope;
            if (!(scriptable instanceof ConstProperties)) {
                throw Kit.codeBug();
            }
            ((ConstProperties) scriptable).putConst(str, scriptable, obj);
        } else if ((iArr[i2] & 1) == 0) {
            throw Context.reportRuntimeError1("msg.var.redecl", callFrame.idata.argNames[i2]);
        } else {
            if ((iArr[i2] & 8) != 0) {
                objArr2[i2] = objArr[i];
                iArr[i2] = iArr[i2] & (-9);
                dArr2[i2] = dArr[i];
            }
        }
        return i;
    }

    public static int doSetElem(Context context, CallFrame callFrame, Object[] objArr, double[] dArr, int i) {
        int i2 = i - 2;
        int i3 = i2 + 2;
        Object obj = objArr[i3];
        if (obj == UniqueTag.DOUBLE_MARK) {
            obj = ScriptRuntime.wrapNumber(dArr[i3]);
        }
        Object obj2 = obj;
        Object obj3 = objArr[i2];
        if (obj3 == UniqueTag.DOUBLE_MARK) {
            obj3 = ScriptRuntime.wrapNumber(dArr[i2]);
        }
        Object obj4 = obj3;
        int i4 = i2 + 1;
        Object obj5 = objArr[i4];
        objArr[i2] = obj5 != UniqueTag.DOUBLE_MARK ? ScriptRuntime.setObjectElem(obj4, obj5, obj2, context, callFrame.scope) : ScriptRuntime.setObjectIndex(obj4, dArr[i4], obj2, context, callFrame.scope);
        return i2;
    }

    public static int doSetVar(CallFrame callFrame, Object[] objArr, double[] dArr, int i, Object[] objArr2, double[] dArr2, int[] iArr, int i2) {
        if (callFrame.useActivation) {
            Object obj = objArr[i];
            if (obj == UniqueTag.DOUBLE_MARK) {
                obj = ScriptRuntime.wrapNumber(dArr[i]);
            }
            String str = callFrame.idata.argNames[i2];
            Scriptable scriptable = callFrame.scope;
            scriptable.put(str, scriptable, obj);
        } else if ((iArr[i2] & 1) == 0) {
            objArr2[i2] = objArr[i];
            dArr2[i2] = dArr[i];
        }
        return i;
    }

    public static boolean doShallowEquals(Object[] objArr, double[] dArr, int i) {
        double d;
        double doubleValue;
        int i2 = i + 1;
        Object obj = objArr[i2];
        Object obj2 = objArr[i];
        UniqueTag uniqueTag = UniqueTag.DOUBLE_MARK;
        if (obj == uniqueTag) {
            doubleValue = dArr[i2];
            if (obj2 == uniqueTag) {
                d = dArr[i];
            } else if (!(obj2 instanceof Number)) {
                return false;
            } else {
                d = ((Number) obj2).doubleValue();
            }
        } else if (obj2 != uniqueTag) {
            return ScriptRuntime.shallowEq(obj2, obj);
        } else {
            d = dArr[i];
            if (!(obj instanceof Number)) {
                return false;
            }
            doubleValue = ((Number) obj).doubleValue();
        }
        return d == doubleValue;
    }

    public static int doVarIncDec(Context context, CallFrame callFrame, Object[] objArr, double[] dArr, int i, Object[] objArr2, double[] dArr2, int[] iArr, int i2) {
        int i3 = i + 1;
        InterpreterData interpreterData = callFrame.idata;
        byte b = interpreterData.itsICode[callFrame.f4669pc];
        if (!callFrame.useActivation) {
            Object obj = objArr2[i2];
            double number = obj == UniqueTag.DOUBLE_MARK ? dArr2[i2] : ScriptRuntime.toNumber(obj);
            double d = (b & 1) == 0 ? 1.0d + number : number - 1.0d;
            boolean z = (b & 2) != 0;
            if ((iArr[i2] & 1) == 0) {
                UniqueTag uniqueTag = UniqueTag.DOUBLE_MARK;
                if (obj != uniqueTag) {
                    objArr2[i2] = uniqueTag;
                }
                dArr2[i2] = d;
                objArr[i3] = UniqueTag.DOUBLE_MARK;
                if (!z) {
                    number = d;
                }
                dArr[i3] = number;
            } else if (!z || obj == UniqueTag.DOUBLE_MARK) {
                objArr[i3] = UniqueTag.DOUBLE_MARK;
                if (!z) {
                    number = d;
                }
                dArr[i3] = number;
            } else {
                objArr[i3] = obj;
            }
        } else {
            objArr[i3] = ScriptRuntime.nameIncrDecr(callFrame.scope, interpreterData.argNames[i2], context, b);
        }
        callFrame.f4669pc++;
        return i3;
    }

    public static void dumpICode(InterpreterData interpreterData) {
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void enterFrame(Context context, CallFrame callFrame, Object[] objArr, boolean z) {
        CallFrame callFrame2;
        boolean z2 = callFrame.idata.itsNeedsActivation;
        boolean z3 = callFrame.debuggerFrame != null;
        if (z2 || z3) {
            Scriptable scriptable = callFrame.scope;
            if (scriptable != null) {
                if (z) {
                    while (scriptable instanceof NativeWith) {
                        scriptable = scriptable.getParentScope();
                        if (scriptable != null && ((callFrame2 = callFrame.parentFrame) == null || callFrame2.scope != scriptable)) {
                        }
                    }
                }
                if (z3) {
                    callFrame.debuggerFrame.onEnter(context, scriptable, callFrame.thisObj, objArr);
                }
                if (z2) {
                    return;
                }
                ScriptRuntime.enterActivationFunction(context, scriptable);
                return;
            }
            Kit.codeBug();
            if (z3) {
            }
            if (z2) {
            }
        }
    }

    public static void exitFrame(Context context, CallFrame callFrame, Object obj) {
        if (callFrame.idata.itsNeedsActivation) {
            ScriptRuntime.exitActivationFunction(context);
        }
        DebugFrame debugFrame = callFrame.debuggerFrame;
        if (debugFrame != null) {
            try {
                if (obj instanceof Throwable) {
                    debugFrame.onExit(context, true, obj);
                    return;
                }
                ContinuationJump continuationJump = (ContinuationJump) obj;
                Object obj2 = continuationJump == null ? callFrame.result : continuationJump.result;
                if (obj2 == UniqueTag.DOUBLE_MARK) {
                    obj2 = ScriptRuntime.wrapNumber(continuationJump == null ? callFrame.resultDbl : continuationJump.resultDbl);
                }
                callFrame.debuggerFrame.onExit(context, false, obj2);
            } catch (Throwable th) {
                System.err.println("RHINO USAGE WARNING: onExit terminated with exception");
                th.printStackTrace(System.err);
            }
        }
    }

    public static Object freezeGenerator(Context context, CallFrame callFrame, int i, GeneratorState generatorState) {
        if (generatorState.operation != 2) {
            callFrame.frozen = true;
            callFrame.result = callFrame.stack[i];
            callFrame.resultDbl = callFrame.sDbl[i];
            callFrame.savedStackTop = i;
            callFrame.f4669pc--;
            ScriptRuntime.exitActivationFunction(context);
            Object obj = callFrame.result;
            return obj != UniqueTag.DOUBLE_MARK ? obj : ScriptRuntime.wrapNumber(callFrame.resultDbl);
        }
        throw ScriptRuntime.typeError0("msg.yield.closing");
    }

    public static Object[] getArgsArray(Object[] objArr, double[] dArr, int i, int i2) {
        if (i2 == 0) {
            return ScriptRuntime.emptyArgs;
        }
        Object[] objArr2 = new Object[i2];
        int i3 = 0;
        while (i3 != i2) {
            Object obj = objArr[i];
            if (obj == UniqueTag.DOUBLE_MARK) {
                obj = ScriptRuntime.wrapNumber(dArr[i]);
            }
            objArr2[i3] = obj;
            i3++;
            i++;
        }
        return objArr2;
    }

    public static String getEncodedSource(InterpreterData interpreterData) {
        String str = interpreterData.encodedSource;
        if (str == null) {
            return null;
        }
        return str.substring(interpreterData.encodedSourceStart, interpreterData.encodedSourceEnd);
    }

    public static int getExceptionHandler(CallFrame callFrame, boolean z) {
        int[] iArr = callFrame.idata.itsExceptionTable;
        int i = -1;
        if (iArr == null) {
            return -1;
        }
        int i2 = callFrame.f4669pc - 1;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 != iArr.length; i5 += 6) {
            int i6 = iArr[i5 + 0];
            int i7 = iArr[i5 + 1];
            if (i6 <= i2 && i2 < i7 && (!z || iArr[i5 + 3] == 1)) {
                if (i >= 0) {
                    if (i3 >= i7) {
                        if (i4 > i6) {
                            Kit.codeBug();
                        }
                        if (i3 == i7) {
                            Kit.codeBug();
                        }
                    }
                }
                i = i5;
                i4 = i6;
                i3 = i7;
            }
        }
        return i;
    }

    public static int getIndex(byte[] bArr, int i) {
        return (bArr[i + 1] & 255) | ((bArr[i] & 255) << 8);
    }

    public static int getInt(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | (bArr[i] << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    public static int[] getLineNumbers(InterpreterData interpreterData) {
        UintMap uintMap = new UintMap();
        byte[] bArr = interpreterData.itsICode;
        int length = bArr.length;
        int i = 0;
        while (i != length) {
            byte b = bArr[i];
            int bytecodeSpan = bytecodeSpan(b);
            if (b == -26) {
                if (bytecodeSpan != 3) {
                    Kit.codeBug();
                }
                uintMap.put(getIndex(bArr, i + 1), 0);
            }
            i += bytecodeSpan;
        }
        return uintMap.getKeys();
    }

    public static int getShort(byte[] bArr, int i) {
        return (bArr[i + 1] & 255) | (bArr[i] << 8);
    }

    public static CallFrame initFrame(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr, double[] dArr, int i, int i2, InterpretedFunction interpretedFunction, CallFrame callFrame) {
        CallFrame callFrame2 = new CallFrame(context, scriptable2, interpretedFunction, callFrame);
        callFrame2.initializeArgs(context, scriptable, objArr, dArr, i, i2);
        enterFrame(context, callFrame2, objArr, false);
        return callFrame2;
    }

    public static CallFrame initFrameForApplyOrCall(Context context, CallFrame callFrame, int i, Object[] objArr, double[] dArr, int i2, int i3, Scriptable scriptable, IdFunctionObject idFunctionObject, InterpretedFunction interpretedFunction) {
        Scriptable scriptable2;
        CallFrame callFrame2 = callFrame;
        if (i != 0) {
            int i4 = i2 + 2;
            Object obj = objArr[i4];
            if (obj == UniqueTag.DOUBLE_MARK) {
                obj = ScriptRuntime.wrapNumber(dArr[i4]);
            }
            scriptable2 = ScriptRuntime.toObjectOrNull(context, obj, callFrame2.scope);
        } else {
            scriptable2 = null;
        }
        if (scriptable2 == null) {
            scriptable2 = ScriptRuntime.getTopCallScope(context);
        }
        if (i3 == -55) {
            exitFrame(context, callFrame, null);
            callFrame2 = callFrame2.parentFrame;
        } else {
            callFrame2.savedStackTop = i2;
            callFrame2.savedCallOp = i3;
        }
        CallFrame callFrame3 = callFrame2;
        if (BaseFunction.isApply(idFunctionObject)) {
            Object[] applyArguments = i < 2 ? ScriptRuntime.emptyArgs : ScriptRuntime.getApplyArguments(context, objArr[i2 + 3]);
            return initFrame(context, scriptable, scriptable2, applyArguments, null, 0, applyArguments.length, interpretedFunction, callFrame3);
        }
        for (int i5 = 1; i5 < i; i5++) {
            int i6 = i2 + 1 + i5;
            int i7 = i2 + 2 + i5;
            objArr[i6] = objArr[i7];
            dArr[i6] = dArr[i7];
        }
        return initFrame(context, scriptable, scriptable2, objArr, dArr, i2 + 2, i < 2 ? 0 : i - 1, interpretedFunction, callFrame3);
    }

    public static CallFrame initFrameForNoSuchMethod(Context context, CallFrame callFrame, int i, Object[] objArr, double[] dArr, int i2, int i3, Scriptable scriptable, Scriptable scriptable2, ScriptRuntime.NoSuchMethodShim noSuchMethodShim, InterpretedFunction interpretedFunction) {
        CallFrame callFrame2;
        int i4 = i2 + 2;
        Object[] objArr2 = new Object[i];
        int i5 = 0;
        while (i5 < i) {
            Object obj = objArr[i4];
            if (obj == UniqueTag.DOUBLE_MARK) {
                obj = ScriptRuntime.wrapNumber(dArr[i4]);
            }
            objArr2[i5] = obj;
            i5++;
            i4++;
        }
        Object[] objArr3 = {noSuchMethodShim.methodName, context.newArray(scriptable2, objArr2)};
        if (i3 == -55) {
            CallFrame callFrame3 = callFrame.parentFrame;
            exitFrame(context, callFrame, null);
            callFrame2 = callFrame3;
        } else {
            callFrame2 = callFrame;
        }
        CallFrame initFrame = initFrame(context, scriptable2, scriptable, objArr3, null, 0, 2, interpretedFunction, callFrame2);
        if (i3 != -55) {
            callFrame.savedStackTop = i2;
            callFrame.savedCallOp = i3;
        }
        return initFrame;
    }

    public static void initFunction(Context context, Scriptable scriptable, InterpretedFunction interpretedFunction, int i) {
        InterpretedFunction createFunction = InterpretedFunction.createFunction(context, scriptable, interpretedFunction, i);
        ScriptRuntime.initFunction(context, scriptable, createFunction, createFunction.idata.itsFunctionType, interpretedFunction.idata.evalScriptFlag);
    }

    public static Object interpret(InterpretedFunction interpretedFunction, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!ScriptRuntime.hasTopCall(context)) {
            Kit.codeBug();
        }
        Object obj = context.interpreterSecurityDomain;
        Object obj2 = interpretedFunction.securityDomain;
        if (obj != obj2) {
            context.interpreterSecurityDomain = obj2;
            try {
                return interpretedFunction.securityController.callWithDomain(obj2, context, interpretedFunction, scriptable, scriptable2, objArr);
            } finally {
                context.interpreterSecurityDomain = obj;
            }
        }
        CallFrame initFrame = initFrame(context, scriptable, scriptable2, objArr, null, 0, objArr.length, interpretedFunction, null);
        initFrame.isContinuationsTopFrame = context.isContinuationsTopCall;
        context.isContinuationsTopCall = false;
        return interpretLoop(context, initFrame, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:111:0x1883, code lost:
        r4 = r47.previousInterpreterInvocations;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x1885, code lost:
        if (r4 == null) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x188b, code lost:
        if (r4.size() == 0) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x188d, code lost:
        r47.lastInterpreterFrame = r47.previousInterpreterInvocations.pop();
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x189a, code lost:
        if (r9 == null) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x189e, code lost:
        if ((r9 instanceof java.lang.RuntimeException) == false) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x18a2, code lost:
        throw r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x18a5, code lost:
        throw ((java.lang.Error) r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x18a6, code lost:
        if (r1 == r7) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x18ad, code lost:
        return org.mozilla.javascript.ScriptRuntime.wrapNumber(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:?, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x1896, code lost:
        r47.lastInterpreterFrame = r6;
        r47.previousInterpreterInvocations = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x17e2, code lost:
        if ((r1 instanceof org.mozilla.javascript.JavaScriptException) == false) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x17e4, code lost:
        r9 = r6;
        r11 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x17e9, code lost:
        if ((r1 instanceof org.mozilla.javascript.EcmaError) == false) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x17ee, code lost:
        if ((r1 instanceof org.mozilla.javascript.EvaluatorException) == false) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x17f3, code lost:
        if ((r1 instanceof org.mozilla.javascript.ContinuationPending) == false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x17f5, code lost:
        r9 = r6;
        r11 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x17fa, code lost:
        if ((r1 instanceof java.lang.RuntimeException) == false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x1802, code lost:
        if (r47.hasFeature(13) == false) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x1804, code lost:
        r11 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x1807, code lost:
        r9 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x1806, code lost:
        r11 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x180d, code lost:
        if ((r1 instanceof java.lang.Error) == false) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x1813, code lost:
        if (r47.hasFeature(13) == false) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x1816, code lost:
        r11 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x181a, code lost:
        if ((r1 instanceof org.mozilla.javascript.Interpreter.ContinuationJump) == false) goto L157;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x181c, code lost:
        r9 = (org.mozilla.javascript.Interpreter.ContinuationJump) r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x1824, code lost:
        if (r47.hasFeature(13) == false) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:290:0x16e7, code lost:
        exitFrame(r47, r15, r6);
        r1 = r15.result;
     */
    /* JADX WARN: Code restructure failed: missing block: B:292:0x16ec, code lost:
        r2 = r15.resultDbl;
     */
    /* JADX WARN: Code restructure failed: missing block: B:296:0x16f0, code lost:
        if (r15.parentFrame == null) goto L310;
     */
    /* JADX WARN: Code restructure failed: missing block: B:297:0x16f2, code lost:
        r4 = r15.parentFrame;
     */
    /* JADX WARN: Code restructure failed: missing block: B:302:0x16f6, code lost:
        if (r4.frozen == false) goto L304;
     */
    /* JADX WARN: Code restructure failed: missing block: B:303:0x16f8, code lost:
        r4 = r4.cloneFrozen();
     */
    /* JADX WARN: Code restructure failed: missing block: B:304:0x16fc, code lost:
        setCallResult(r4, r1, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:305:0x16ff, code lost:
        r20 = r2;
        r3 = r4;
        r9 = r6;
        r19 = r9;
        r2 = r13;
        r4 = r14;
        r1 = r22;
        r14 = r35;
        r10 = r36;
        r13 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:307:0x1711, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:308:0x1712, code lost:
        r19 = r1;
        r20 = r2;
        r3 = r4;
        r4 = r14;
        r0 = r0;
        r6 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:311:0x171a, code lost:
        r9 = r22;
        r6 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:313:0x171e, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:314:0x171f, code lost:
        r19 = r1;
        r20 = r2;
        r0 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:315:0x1727, code lost:
        r4 = r14;
        r3 = r15;
        r0 = r0;
        r6 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:316:0x1724, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:317:0x1725, code lost:
        r19 = r1;
        r0 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:344:0x0403, code lost:
        r6 = null;
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:508:0x14f5, code lost:
        r4 = r14;
        r1 = r22;
        r14 = r35;
        r10 = r36;
        r8 = r40;
        r13 = r44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x17cd, code lost:
        if (r1 != null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x17cf, code lost:
        org.mozilla.javascript.Kit.codeBug();
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x17d2, code lost:
        if (r8 == null) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x17d7, code lost:
        if (r8.operation != 2) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x17db, code lost:
        if (r1 != r8.value) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x17dd, code lost:
        r9 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x17de, code lost:
        r11 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x1827, code lost:
        if (r36 == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x182b, code lost:
        addInstructionCount(r47, r15, 100);
     */
    /* JADX WARN: Code restructure failed: missing block: B:635:0x03ff, code lost:
        r36 = r10;
        r7 = r13;
        r4 = r14;
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x182f, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x1830, code lost:
        r1 = r0;
        r9 = r6;
        r11 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x1834, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x1835, code lost:
        r1 = r0;
        r11 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x18b4, code lost:
        r9 = r6;
        r13 = r7;
        r3 = r15;
        r14 = r35;
        r10 = r36;
        r2 = -1;
        r1 = r1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x186a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x18bf A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x132a A[Catch: all -> 0x121a, TryCatch #37 {all -> 0x121a, blocks: (B:366:0x0fab, B:368:0x0fb9, B:369:0x0fdc, B:372:0x0fcc, B:373:0x0fd6, B:440:0x1247, B:436:0x11f8, B:462:0x136d, B:469:0x138d, B:478:0x13a9, B:482:0x13b4, B:193:0x132a, B:194:0x132e, B:196:0x1336, B:203:0x134c, B:204:0x133e, B:289:0x0e14, B:319:0x0e22, B:321:0x0e47, B:324:0x0e63, B:326:0x0e73, B:328:0x0e77, B:335:0x0ea0, B:336:0x0ea4, B:338:0x0eb4, B:340:0x0ebb, B:346:0x0ec3, B:348:0x0edf, B:349:0x0ee8, B:351:0x0eef, B:352:0x0f13, B:355:0x0f18, B:357:0x0f3d, B:359:0x0f63, B:361:0x0f7d, B:362:0x0f83, B:392:0x1067, B:395:0x1086, B:396:0x10a2, B:398:0x10a7, B:400:0x10c4, B:403:0x10de, B:407:0x10fa, B:409:0x1129, B:411:0x115c, B:420:0x119f, B:430:0x11c4, B:435:0x11f4, B:439:0x1229, B:442:0x125c, B:444:0x127b, B:446:0x129b, B:448:0x12bd, B:450:0x12da, B:451:0x12e0, B:453:0x12ec, B:458:0x1311, B:456:0x1326), top: B:365:0x0fab }] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x1336 A[Catch: all -> 0x121a, TryCatch #37 {all -> 0x121a, blocks: (B:366:0x0fab, B:368:0x0fb9, B:369:0x0fdc, B:372:0x0fcc, B:373:0x0fd6, B:440:0x1247, B:436:0x11f8, B:462:0x136d, B:469:0x138d, B:478:0x13a9, B:482:0x13b4, B:193:0x132a, B:194:0x132e, B:196:0x1336, B:203:0x134c, B:204:0x133e, B:289:0x0e14, B:319:0x0e22, B:321:0x0e47, B:324:0x0e63, B:326:0x0e73, B:328:0x0e77, B:335:0x0ea0, B:336:0x0ea4, B:338:0x0eb4, B:340:0x0ebb, B:346:0x0ec3, B:348:0x0edf, B:349:0x0ee8, B:351:0x0eef, B:352:0x0f13, B:355:0x0f18, B:357:0x0f3d, B:359:0x0f63, B:361:0x0f7d, B:362:0x0f83, B:392:0x1067, B:395:0x1086, B:396:0x10a2, B:398:0x10a7, B:400:0x10c4, B:403:0x10de, B:407:0x10fa, B:409:0x1129, B:411:0x115c, B:420:0x119f, B:430:0x11c4, B:435:0x11f4, B:439:0x1229, B:442:0x125c, B:444:0x127b, B:446:0x129b, B:448:0x12bd, B:450:0x12da, B:451:0x12e0, B:453:0x12ec, B:458:0x1311, B:456:0x1326), top: B:365:0x0fab }] */
    /* JADX WARN: Removed duplicated region for block: B:203:0x134c A[Catch: all -> 0x121a, TryCatch #37 {all -> 0x121a, blocks: (B:366:0x0fab, B:368:0x0fb9, B:369:0x0fdc, B:372:0x0fcc, B:373:0x0fd6, B:440:0x1247, B:436:0x11f8, B:462:0x136d, B:469:0x138d, B:478:0x13a9, B:482:0x13b4, B:193:0x132a, B:194:0x132e, B:196:0x1336, B:203:0x134c, B:204:0x133e, B:289:0x0e14, B:319:0x0e22, B:321:0x0e47, B:324:0x0e63, B:326:0x0e73, B:328:0x0e77, B:335:0x0ea0, B:336:0x0ea4, B:338:0x0eb4, B:340:0x0ebb, B:346:0x0ec3, B:348:0x0edf, B:349:0x0ee8, B:351:0x0eef, B:352:0x0f13, B:355:0x0f18, B:357:0x0f3d, B:359:0x0f63, B:361:0x0f7d, B:362:0x0f83, B:392:0x1067, B:395:0x1086, B:396:0x10a2, B:398:0x10a7, B:400:0x10c4, B:403:0x10de, B:407:0x10fa, B:409:0x1129, B:411:0x115c, B:420:0x119f, B:430:0x11c4, B:435:0x11f4, B:439:0x1229, B:442:0x125c, B:444:0x127b, B:446:0x129b, B:448:0x12bd, B:450:0x12da, B:451:0x12e0, B:453:0x12ec, B:458:0x1311, B:456:0x1326), top: B:365:0x0fab }] */
    /* JADX WARN: Removed duplicated region for block: B:204:0x133e A[Catch: all -> 0x121a, TryCatch #37 {all -> 0x121a, blocks: (B:366:0x0fab, B:368:0x0fb9, B:369:0x0fdc, B:372:0x0fcc, B:373:0x0fd6, B:440:0x1247, B:436:0x11f8, B:462:0x136d, B:469:0x138d, B:478:0x13a9, B:482:0x13b4, B:193:0x132a, B:194:0x132e, B:196:0x1336, B:203:0x134c, B:204:0x133e, B:289:0x0e14, B:319:0x0e22, B:321:0x0e47, B:324:0x0e63, B:326:0x0e73, B:328:0x0e77, B:335:0x0ea0, B:336:0x0ea4, B:338:0x0eb4, B:340:0x0ebb, B:346:0x0ec3, B:348:0x0edf, B:349:0x0ee8, B:351:0x0eef, B:352:0x0f13, B:355:0x0f18, B:357:0x0f3d, B:359:0x0f63, B:361:0x0f7d, B:362:0x0f83, B:392:0x1067, B:395:0x1086, B:396:0x10a2, B:398:0x10a7, B:400:0x10c4, B:403:0x10de, B:407:0x10fa, B:409:0x1129, B:411:0x115c, B:420:0x119f, B:430:0x11c4, B:435:0x11f4, B:439:0x1229, B:442:0x125c, B:444:0x127b, B:446:0x129b, B:448:0x12bd, B:450:0x12da, B:451:0x12e0, B:453:0x12ec, B:458:0x1311, B:456:0x1326), top: B:365:0x0fab }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:368:0x0fb9 A[Catch: all -> 0x121a, TryCatch #37 {all -> 0x121a, blocks: (B:366:0x0fab, B:368:0x0fb9, B:369:0x0fdc, B:372:0x0fcc, B:373:0x0fd6, B:440:0x1247, B:436:0x11f8, B:462:0x136d, B:469:0x138d, B:478:0x13a9, B:482:0x13b4, B:193:0x132a, B:194:0x132e, B:196:0x1336, B:203:0x134c, B:204:0x133e, B:289:0x0e14, B:319:0x0e22, B:321:0x0e47, B:324:0x0e63, B:326:0x0e73, B:328:0x0e77, B:335:0x0ea0, B:336:0x0ea4, B:338:0x0eb4, B:340:0x0ebb, B:346:0x0ec3, B:348:0x0edf, B:349:0x0ee8, B:351:0x0eef, B:352:0x0f13, B:355:0x0f18, B:357:0x0f3d, B:359:0x0f63, B:361:0x0f7d, B:362:0x0f83, B:392:0x1067, B:395:0x1086, B:396:0x10a2, B:398:0x10a7, B:400:0x10c4, B:403:0x10de, B:407:0x10fa, B:409:0x1129, B:411:0x115c, B:420:0x119f, B:430:0x11c4, B:435:0x11f4, B:439:0x1229, B:442:0x125c, B:444:0x127b, B:446:0x129b, B:448:0x12bd, B:450:0x12da, B:451:0x12e0, B:453:0x12ec, B:458:0x1311, B:456:0x1326), top: B:365:0x0fab }] */
    /* JADX WARN: Removed duplicated region for block: B:370:0x0fc8  */
    /* JADX WARN: Removed duplicated region for block: B:462:0x136d A[Catch: all -> 0x121a, TRY_LEAVE, TryCatch #37 {all -> 0x121a, blocks: (B:366:0x0fab, B:368:0x0fb9, B:369:0x0fdc, B:372:0x0fcc, B:373:0x0fd6, B:440:0x1247, B:436:0x11f8, B:462:0x136d, B:469:0x138d, B:478:0x13a9, B:482:0x13b4, B:193:0x132a, B:194:0x132e, B:196:0x1336, B:203:0x134c, B:204:0x133e, B:289:0x0e14, B:319:0x0e22, B:321:0x0e47, B:324:0x0e63, B:326:0x0e73, B:328:0x0e77, B:335:0x0ea0, B:336:0x0ea4, B:338:0x0eb4, B:340:0x0ebb, B:346:0x0ec3, B:348:0x0edf, B:349:0x0ee8, B:351:0x0eef, B:352:0x0f13, B:355:0x0f18, B:357:0x0f3d, B:359:0x0f63, B:361:0x0f7d, B:362:0x0f83, B:392:0x1067, B:395:0x1086, B:396:0x10a2, B:398:0x10a7, B:400:0x10c4, B:403:0x10de, B:407:0x10fa, B:409:0x1129, B:411:0x115c, B:420:0x119f, B:430:0x11c4, B:435:0x11f4, B:439:0x1229, B:442:0x125c, B:444:0x127b, B:446:0x129b, B:448:0x12bd, B:450:0x12da, B:451:0x12e0, B:453:0x12ec, B:458:0x1311, B:456:0x1326), top: B:365:0x0fab }] */
    /* JADX WARN: Removed duplicated region for block: B:468:0x138b  */
    /* JADX WARN: Removed duplicated region for block: B:476:0x13a3 A[Catch: all -> 0x1539, TRY_ENTER, TRY_LEAVE, TryCatch #15 {all -> 0x1539, blocks: (B:465:0x137c, B:476:0x13a3, B:480:0x13b0), top: B:464:0x137c }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x17cc  */
    /* JADX WARN: Removed duplicated region for block: B:500:0x14ca A[Catch: all -> 0x1524, TryCatch #5 {all -> 0x1524, blocks: (B:498:0x14c6, B:500:0x14ca, B:502:0x14d3), top: B:497:0x14c6 }] */
    /* JADX WARN: Removed duplicated region for block: B:590:0x1376  */
    /* JADX WARN: Removed duplicated region for block: B:669:0x16b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:677:0x16ad A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x184f  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x18ae  */
    /* JADX WARN: Removed duplicated region for block: B:957:0x1762 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:969:0x0052 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r14v107 */
    /* JADX WARN: Type inference failed for: r14v108 */
    /* JADX WARN: Type inference failed for: r15v114 */
    /* JADX WARN: Type inference failed for: r6v231 */
    /* JADX WARN: Type inference failed for: r6v232 */
    /* JADX WARN: Type inference failed for: r6v233 */
    /* JADX WARN: Type inference failed for: r6v3, types: [org.mozilla.javascript.ObjArray, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14, types: [org.mozilla.javascript.Interpreter$ContinuationJump] */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object interpretLoop(Context context, CallFrame callFrame, Object obj) {
        CallFrame callFrame2;
        GeneratorState generatorState;
        String str;
        byte b;
        Object obj2;
        Object obj3;
        boolean z;
        UniqueTag uniqueTag;
        Object obj4;
        Error error;
        RuntimeException runtimeException;
        RuntimeException runtimeException2;
        ?? r6;
        double d;
        Object obj5;
        CallFrame callFrame3;
        Object obj6;
        Error error2;
        char c;
        char c2;
        RuntimeException runtimeException3;
        Object[] objArr;
        CallFrame callFrame4;
        Object obj7;
        Error error3;
        Error error4;
        Object obj8;
        Object[] objArr2;
        Object[] objArr3;
        double[] dArr;
        int[] iArr;
        byte[] bArr;
        String[] strArr;
        double[] dArr2;
        int i;
        byte b2;
        String str2;
        Object obj9;
        String str3;
        int i2;
        int i3;
        byte b3;
        String str4;
        Object[] objArr4;
        double[] dArr3;
        UniqueTag uniqueTag2;
        Object obj10;
        int[] iArr2;
        int i4;
        String str5;
        Object[] objArr5;
        CallFrame callFrame5;
        byte[] bArr2;
        double[] dArr4;
        Object[] objArr6;
        double[] dArr5;
        int[] iArr3;
        int i5;
        Object[] objArr7;
        byte b4;
        byte[] bArr3;
        double[] dArr6;
        Object obj11;
        GeneratorState generatorState2;
        Object[] objArr8;
        int[] iArr4;
        String str6;
        Object[] objArr9;
        int i6;
        double[] dArr7;
        int i7;
        byte b5;
        Object obj12;
        Error error5;
        Error error6;
        GeneratorState generatorState3;
        double[] dArr8;
        byte b6;
        int i8;
        GeneratorState generatorState4;
        double[] dArr9;
        byte b7;
        int i9;
        UniqueTag uniqueTag3;
        Object obj13;
        byte[] bArr4;
        byte b8;
        int i10;
        int i11;
        byte b9;
        byte b10;
        Object strictSetName;
        double[] dArr10;
        String str7;
        Object[] objArr10;
        byte b11;
        String str8;
        Object obj14;
        byte b12;
        double[] dArr11;
        String str9;
        int i12;
        Error error7;
        byte b13;
        Object obj15;
        byte b14;
        int i13;
        byte b15;
        Object obj16;
        Object[] objArr11;
        byte b16;
        double[] dArr12;
        Object[] objArr12;
        int[] iArr5;
        double[] dArr13;
        int i14;
        Object obj17;
        byte[] bArr5;
        double[] dArr14;
        byte b17;
        Object obj18;
        String str10;
        byte b18;
        int i15;
        int i16;
        int i17;
        byte b19;
        Object[] objArr13;
        byte b20;
        int i18;
        Object[] objArr14;
        Object[] objArr15;
        Number number;
        String str11;
        JavaScriptException javaScriptException;
        UniqueTag uniqueTag4;
        byte b21;
        int i19;
        Object obj19;
        int i20;
        int i21;
        Error error8;
        byte b22;
        Object obj20;
        int i22;
        Error error9;
        Error th;
        ContinuationJump continuationJump;
        Scriptable scriptable;
        Error error10;
        Object obj21;
        CallFrame callFrame6;
        Error error11;
        Object obj22;
        int i23;
        int doSetVar;
        int i24;
        Object[] objArr16;
        double[] dArr15;
        GeneratorState generatorState5;
        UniqueTag uniqueTag5;
        Object obj23;
        int[] iArr6;
        int i25;
        Object[] objArr17;
        byte b23;
        CallFrame callFrame7;
        byte[] bArr6;
        double[] dArr16;
        String str12;
        int i26;
        int i27;
        Object[] objArr18;
        double[] dArr17;
        UniqueTag uniqueTag6;
        Object obj24;
        int[] iArr7;
        int i28;
        Object[] objArr19;
        byte b24;
        byte[] bArr7;
        double[] dArr18;
        String str13;
        byte b25;
        int i29;
        int i30;
        Scriptable newArrayLiteral;
        int i31;
        byte b26;
        int i32;
        int i33;
        int i34;
        byte b27;
        byte b28;
        Object obj25;
        String str14;
        CallFrame callFrame8;
        byte[] bArr8;
        byte b29;
        UniqueTag uniqueTag7;
        double[] dArr19;
        int i35;
        byte b30;
        byte[] bArr9;
        Object obj26;
        double[] dArr20;
        Object[] objArr20;
        byte b31;
        int i36;
        double[] dArr21;
        int i37;
        Object[] objArr21;
        int i38;
        int i39;
        byte b32;
        byte[] bArr10;
        Object obj27;
        int i40;
        int i41;
        byte b33;
        Object[] objArr22;
        double[] dArr22;
        GeneratorState generatorState6;
        UniqueTag uniqueTag8;
        int[] iArr8;
        double[] dArr23;
        String str15;
        Object[] objArr23;
        byte b34;
        CallFrame callFrame9;
        byte[] bArr11;
        Error error12;
        Object obj28;
        int i42;
        byte b35;
        int i43;
        Object obj29;
        Error error13;
        Object obj30;
        Error error14;
        Error error15;
        Object obj31 = obj;
        UniqueTag uniqueTag9 = UniqueTag.DOUBLE_MARK;
        String str16 = Undefined.instance;
        boolean z2 = context.instructionThreshold != 0;
        if (context.lastInterpreterFrame != null) {
            if (context.previousInterpreterInvocations == null) {
                context.previousInterpreterInvocations = new ObjArray();
            }
            context.previousInterpreterInvocations.push(context.lastInterpreterFrame);
        }
        Object obj32 = null;
        if (obj31 == null) {
            callFrame2 = callFrame;
        } else if (obj31 instanceof GeneratorState) {
            callFrame2 = callFrame;
            enterFrame(context, callFrame2, ScriptRuntime.emptyArgs, true);
            generatorState = (GeneratorState) obj31;
            obj31 = null;
            str = null;
            Object obj33 = null;
            double d2 = 0.0d;
            b = -1;
            while (true) {
                if (obj31 == null) {
                    try {
                        callFrame2 = processThrowable(context, obj31, callFrame2, b, z2);
                        obj31 = callFrame2.throwable;
                        callFrame2.throwable = obj32;
                    } catch (Throwable th2) {
                        obj2 = obj31;
                        obj3 = obj32;
                        z = z2;
                        uniqueTag = uniqueTag9;
                        obj4 = str16;
                        error = th2;
                        Error error16 = error;
                        Object obj34 = obj3;
                        runtimeException = error16;
                        objArr = obj34;
                        if (obj2 != null) {
                        }
                    }
                } else if (generatorState == null && callFrame2.frozen) {
                    Kit.codeBug();
                }
                obj2 = obj31;
                callFrame4 = callFrame2;
                try {
                    objArr2 = callFrame4.stack;
                    double[] dArr24 = callFrame4.sDbl;
                    objArr3 = callFrame4.varSource.stack;
                    dArr = callFrame4.varSource.sDbl;
                    iArr = callFrame4.varSource.stackAttributes;
                    try {
                        bArr = callFrame4.idata.itsICode;
                        strArr = callFrame4.idata.itsStringTable;
                        dArr2 = dArr24;
                        i = callFrame4.savedStackTop;
                        context.lastInterpreterFrame = callFrame4;
                        String str17 = str;
                        b2 = b;
                        str2 = str17;
                    } catch (Throwable th3) {
                        callFrame3 = callFrame4;
                        z = z2;
                        uniqueTag = uniqueTag9;
                        obj4 = str16;
                        obj7 = null;
                        error3 = th3;
                        error4 = error3;
                        obj8 = obj7;
                        callFrame2 = callFrame3;
                        runtimeException = error4;
                        objArr = obj8;
                        if (obj2 != null) {
                        }
                    }
                } catch (Throwable th4) {
                    callFrame3 = callFrame4;
                    obj7 = obj32;
                    z = z2;
                    uniqueTag = uniqueTag9;
                    obj4 = str16;
                    error3 = th4;
                }
                while (true) {
                    try {
                        int i44 = callFrame4.f4669pc;
                        i2 = i;
                        i3 = i44 + 1;
                        callFrame4.f4669pc = i3;
                        b3 = bArr[i44];
                        str4 = str2;
                    } catch (Throwable th5) {
                        th = th5;
                        callFrame3 = callFrame4;
                        z = z2;
                        uniqueTag = uniqueTag9;
                        obj4 = str16;
                        obj9 = null;
                        str3 = str2;
                    }
                    if (b3 == 157) {
                        switch (b3) {
                            case -64:
                                objArr6 = objArr3;
                                dArr5 = dArr;
                                z = z2;
                                uniqueTag = uniqueTag9;
                                obj4 = str16;
                                iArr3 = iArr;
                                i5 = i2;
                                str3 = str4;
                                objArr7 = objArr2;
                                b4 = b2;
                                callFrame3 = callFrame4;
                                bArr3 = bArr;
                                dArr6 = dArr2;
                                if (callFrame3.debuggerFrame != null) {
                                    callFrame3.debuggerFrame.onDebuggerStatement(context);
                                }
                                i = i5;
                                dArr2 = dArr6;
                                b2 = b4;
                                str2 = str3;
                                callFrame4 = callFrame3;
                                str16 = obj4;
                                iArr = iArr3;
                                objArr3 = objArr6;
                                bArr = bArr3;
                                uniqueTag9 = uniqueTag;
                                objArr2 = objArr7;
                                z2 = z;
                                dArr = dArr5;
                            case Icode.Icode_GENERATOR_END /* -63 */:
                                callFrame3 = callFrame4;
                                z = z2;
                                uniqueTag = uniqueTag9;
                                obj4 = str16;
                                str3 = str4;
                                obj11 = null;
                                b4 = b2;
                                callFrame3.frozen = true;
                                generatorState.returnedException = new JavaScriptException(NativeIterator.getStopIterationObject(callFrame3.scope), callFrame3.idata.itsSourceFile, getIndex(bArr, i3));
                                break;
                            case Icode.Icode_GENERATOR /* -62 */:
                                objArr6 = objArr3;
                                dArr5 = dArr;
                                generatorState2 = generatorState;
                                z = z2;
                                uniqueTag = uniqueTag9;
                                obj4 = str16;
                                iArr3 = iArr;
                                i5 = i2;
                                str3 = str4;
                                obj9 = null;
                                obj11 = null;
                                objArr7 = objArr2;
                                b4 = b2;
                                callFrame3 = callFrame4;
                                bArr3 = bArr;
                                dArr6 = dArr2;
                                if (!callFrame3.frozen) {
                                    callFrame3.f4669pc = i3 - 1;
                                    CallFrame captureFrameForGenerator = captureFrameForGenerator(callFrame3);
                                    captureFrameForGenerator.frozen = true;
                                    callFrame3.result = new NativeGenerator(callFrame3.scope, captureFrameForGenerator.fnOrScript, captureFrameForGenerator);
                                    generatorState = generatorState2;
                                    break;
                                }
                                try {
                                    generatorState = generatorState2;
                                    if (callFrame3.frozen) {
                                        return freezeGenerator(context, callFrame3, i5, generatorState);
                                    }
                                    try {
                                        Object thawGenerator = thawGenerator(callFrame3, i5, generatorState, b3);
                                        if (thawGenerator != Scriptable.NOT_FOUND) {
                                            str = str3;
                                            error2 = thawGenerator;
                                            obj6 = obj9;
                                            break;
                                        }
                                        i = i5;
                                        dArr2 = dArr6;
                                        b2 = b4;
                                        str2 = str3;
                                        callFrame4 = callFrame3;
                                        str16 = obj4;
                                        iArr = iArr3;
                                        objArr3 = objArr6;
                                        bArr = bArr3;
                                        uniqueTag9 = uniqueTag;
                                        objArr2 = objArr7;
                                        z2 = z;
                                        dArr = dArr5;
                                    } catch (Throwable th6) {
                                        th = th6;
                                    }
                                    th = th6;
                                } catch (Throwable th7) {
                                    th = th7;
                                    generatorState = generatorState2;
                                }
                                error4 = th;
                                str = str3;
                                obj8 = obj9;
                                callFrame2 = callFrame3;
                                runtimeException = error4;
                                objArr = obj8;
                                if (obj2 != null) {
                                    runtimeException.printStackTrace(System.err);
                                    throw new IllegalStateException();
                                }
                                callFrame3 = callFrame2;
                                error2 = runtimeException;
                                obj6 = objArr;
                                break;
                            case Icode.Icode_SETCONSTVAR1 /* -61 */:
                                objArr4 = objArr3;
                                dArr3 = dArr;
                                GeneratorState generatorState7 = generatorState;
                                z = z2;
                                uniqueTag2 = uniqueTag9;
                                obj10 = str16;
                                iArr2 = iArr;
                                i4 = i2;
                                str5 = str4;
                                objArr5 = objArr2;
                                callFrame5 = callFrame4;
                                bArr2 = bArr;
                                dArr4 = dArr2;
                                callFrame5.f4669pc = i3 + 1;
                                b2 = bArr2[i3];
                                generatorState = generatorState7;
                                break;
                            default:
                                switch (b3) {
                                    case Icode.Icode_SETCONST /* -59 */:
                                        Object[] objArr24 = objArr3;
                                        dArr5 = dArr;
                                        GeneratorState generatorState8 = generatorState;
                                        z = z2;
                                        UniqueTag uniqueTag10 = uniqueTag9;
                                        obj4 = str16;
                                        int[] iArr9 = iArr;
                                        String str18 = str4;
                                        Object[] objArr25 = null;
                                        objArr25 = null;
                                        objArr7 = objArr2;
                                        byte b36 = b2;
                                        iArr = callFrame4;
                                        bArr3 = bArr;
                                        double[] dArr25 = dArr2;
                                        try {
                                            Object obj35 = objArr7[i2];
                                            uniqueTag = uniqueTag10;
                                            if (obj35 == uniqueTag) {
                                                try {
                                                    obj35 = ScriptRuntime.wrapNumber(dArr25[i2]);
                                                } catch (Throwable th8) {
                                                    th = th8;
                                                    runtimeException = th;
                                                    str = str18;
                                                    callFrame2 = iArr;
                                                    generatorState = generatorState8;
                                                    objArr = objArr25;
                                                    if (obj2 != null) {
                                                    }
                                                }
                                            }
                                            int i45 = i2 - 1;
                                            objArr7[i45] = ScriptRuntime.setConst((Scriptable) objArr7[i45], obj35, context, str18);
                                            i = i45;
                                            dArr2 = dArr25;
                                            b2 = b36;
                                            str2 = str18;
                                            callFrame4 = iArr;
                                            str18 = obj4;
                                            iArr = iArr9;
                                            objArr25 = objArr24;
                                            generatorState = generatorState8;
                                            objArr3 = objArr25;
                                            str16 = str18;
                                            bArr = bArr3;
                                            uniqueTag9 = uniqueTag;
                                            objArr2 = objArr7;
                                            z2 = z;
                                            dArr = dArr5;
                                        } catch (Throwable th9) {
                                            th = th9;
                                            uniqueTag = uniqueTag10;
                                        }
                                        break;
                                    case Icode.Icode_LITERAL_SETTER /* -58 */:
                                        objArr12 = objArr3;
                                        dArr13 = dArr;
                                        generatorState3 = generatorState;
                                        z = z2;
                                        uniqueTag4 = uniqueTag9;
                                        obj4 = str16;
                                        iArr5 = iArr;
                                        str3 = str4;
                                        objArr5 = objArr2;
                                        b21 = b2;
                                        callFrame3 = callFrame4;
                                        bArr2 = bArr;
                                        dArr14 = dArr2;
                                        Object obj36 = objArr5[i2];
                                        i19 = i2 - 1;
                                        int i46 = (int) dArr14[i19];
                                        ((Object[]) objArr5[i19])[i46] = obj36;
                                        ((int[]) objArr5[i19 - 1])[i46] = 1;
                                        dArr14[i19] = i46 + 1;
                                        i = i19;
                                        dArr2 = dArr14;
                                        i20 = b21;
                                        str2 = str3;
                                        callFrame4 = callFrame3;
                                        str16 = obj4;
                                        dArr = dArr13;
                                        iArr = iArr5;
                                        objArr3 = objArr12;
                                        generatorState = generatorState3;
                                        uniqueTag9 = uniqueTag4;
                                        b2 = i20;
                                        bArr = bArr2;
                                        objArr2 = objArr5;
                                        z2 = z;
                                    case Icode.Icode_LITERAL_GETTER /* -57 */:
                                        objArr12 = objArr3;
                                        dArr13 = dArr;
                                        generatorState3 = generatorState;
                                        z = z2;
                                        uniqueTag4 = uniqueTag9;
                                        obj4 = str16;
                                        iArr5 = iArr;
                                        str3 = str4;
                                        objArr5 = objArr2;
                                        b21 = b2;
                                        callFrame3 = callFrame4;
                                        bArr2 = bArr;
                                        dArr14 = dArr2;
                                        Object obj37 = objArr5[i2];
                                        i19 = i2 - 1;
                                        int i47 = (int) dArr14[i19];
                                        ((Object[]) objArr5[i19])[i47] = obj37;
                                        ((int[]) objArr5[i19 - 1])[i47] = -1;
                                        dArr14[i19] = i47 + 1;
                                        i = i19;
                                        dArr2 = dArr14;
                                        i20 = b21;
                                        str2 = str3;
                                        callFrame4 = callFrame3;
                                        str16 = obj4;
                                        dArr = dArr13;
                                        iArr = iArr5;
                                        objArr3 = objArr12;
                                        generatorState = generatorState3;
                                        uniqueTag9 = uniqueTag4;
                                        b2 = i20;
                                        bArr = bArr2;
                                        objArr2 = objArr5;
                                        z2 = z;
                                    case Icode.Icode_LOCAL_CLEAR /* -56 */:
                                        objArr12 = objArr3;
                                        dArr13 = dArr;
                                        generatorState3 = generatorState;
                                        z = z2;
                                        uniqueTag4 = uniqueTag9;
                                        obj4 = str16;
                                        iArr5 = iArr;
                                        str3 = str4;
                                        objArr5 = objArr2;
                                        callFrame3 = callFrame4;
                                        bArr2 = bArr;
                                        double[] dArr26 = dArr2;
                                        try {
                                            i20 = b2 + callFrame3.localShift;
                                            obj19 = null;
                                            try {
                                                objArr5[i20] = null;
                                                i = i2;
                                                dArr2 = dArr26;
                                                str2 = str3;
                                                callFrame4 = callFrame3;
                                                str16 = obj4;
                                                dArr = dArr13;
                                                iArr = iArr5;
                                                objArr3 = objArr12;
                                                generatorState = generatorState3;
                                                uniqueTag9 = uniqueTag4;
                                                b2 = i20;
                                                bArr = bArr2;
                                                objArr2 = objArr5;
                                                z2 = z;
                                            } catch (Throwable th10) {
                                                th = th10;
                                                runtimeException = th;
                                                str = str3;
                                                callFrame2 = callFrame3;
                                                generatorState = generatorState3;
                                                uniqueTag = uniqueTag4;
                                                objArr = obj19;
                                                if (obj2 != null) {
                                                }
                                            }
                                        } catch (Throwable th11) {
                                            th = th11;
                                            obj19 = null;
                                        }
                                        break;
                                    case Icode.Icode_TAIL_CALL /* -55 */:
                                        objArr12 = objArr3;
                                        dArr13 = dArr;
                                        generatorState3 = generatorState;
                                        z = z2;
                                        uniqueTag3 = uniqueTag9;
                                        obj17 = str16;
                                        iArr5 = iArr;
                                        i14 = i2;
                                        str3 = str4;
                                        objArr5 = objArr2;
                                        b17 = b2;
                                        callFrame3 = callFrame4;
                                        bArr5 = bArr;
                                        dArr14 = dArr2;
                                        if (!z) {
                                            context.instructionCount += 100;
                                        }
                                        i21 = i14 - (b17 + 1);
                                        try {
                                            Callable callable = (Callable) objArr5[i21];
                                            Scriptable scriptable2 = (Scriptable) objArr5[i21 + 1];
                                            if (b3 != 71) {
                                                objArr5[i21] = ScriptRuntime.callRef(callable, scriptable2, getArgsArray(objArr5, dArr14, i21 + 2, b17), context);
                                                obj4 = obj17;
                                                uniqueTag4 = uniqueTag3;
                                                bArr2 = bArr5;
                                                b21 = b17;
                                                i22 = i21;
                                            } else {
                                                Scriptable scriptable3 = callFrame3.scope;
                                                if (callFrame3.useActivation) {
                                                    scriptable3 = ScriptableObject.getTopLevelScope(callFrame3.scope);
                                                }
                                                Scriptable scriptable4 = scriptable3;
                                                if (callable instanceof InterpretedFunction) {
                                                    InterpretedFunction interpretedFunction = (InterpretedFunction) callable;
                                                    byte b37 = b17;
                                                    obj4 = obj17;
                                                    try {
                                                        if (callFrame3.fnOrScript.securityDomain == interpretedFunction.securityDomain) {
                                                            if (b3 == -55) {
                                                                CallFrame callFrame10 = callFrame3.parentFrame;
                                                                obj21 = null;
                                                                try {
                                                                    exitFrame(context, callFrame3, null);
                                                                    callFrame6 = callFrame10;
                                                                } catch (Throwable th12) {
                                                                    error11 = th12;
                                                                    obj22 = null;
                                                                    uniqueTag = uniqueTag3;
                                                                    str = str3;
                                                                    callFrame2 = callFrame3;
                                                                    generatorState = generatorState3;
                                                                    error13 = error11;
                                                                    obj14 = obj22;
                                                                    error14 = error13;
                                                                    obj30 = obj14;
                                                                    runtimeException = error14;
                                                                    objArr = obj30;
                                                                    if (obj2 != null) {
                                                                    }
                                                                }
                                                            } else {
                                                                obj21 = null;
                                                                callFrame6 = callFrame3;
                                                            }
                                                            uniqueTag4 = uniqueTag3;
                                                            try {
                                                                callFrame2 = initFrame(context, scriptable4, scriptable2, objArr5, dArr14, i21 + 2, b37, interpretedFunction, callFrame6);
                                                                if (b3 != -55) {
                                                                    callFrame3.savedStackTop = i21;
                                                                    callFrame3.savedCallOp = b3;
                                                                }
                                                                str = str3;
                                                                obj15 = obj2;
                                                                z2 = z;
                                                                generatorState = generatorState3;
                                                                str16 = obj4;
                                                                uniqueTag9 = uniqueTag4;
                                                                b14 = b37;
                                                                break;
                                                            } catch (Throwable th13) {
                                                                error9 = th13;
                                                                str = str3;
                                                                callFrame2 = callFrame3;
                                                                generatorState = generatorState3;
                                                                obj4 = obj4;
                                                                uniqueTag = uniqueTag4;
                                                                error6 = error9;
                                                                obj30 = null;
                                                                error14 = error6;
                                                                runtimeException = error14;
                                                                objArr = obj30;
                                                                if (obj2 != null) {
                                                                }
                                                            }
                                                        } else {
                                                            i22 = i21;
                                                            uniqueTag4 = uniqueTag3;
                                                            b22 = b37;
                                                            obj20 = obj4;
                                                        }
                                                    } catch (Throwable th14) {
                                                        error10 = th14;
                                                        uniqueTag = uniqueTag3;
                                                        error15 = error10;
                                                        str = str3;
                                                        error7 = error15;
                                                        callFrame2 = callFrame3;
                                                        generatorState = generatorState3;
                                                        error6 = error7;
                                                        obj30 = null;
                                                        error14 = error6;
                                                        runtimeException = error14;
                                                        objArr = obj30;
                                                        if (obj2 != null) {
                                                        }
                                                    }
                                                } else {
                                                    b22 = b17;
                                                    obj20 = obj17;
                                                    uniqueTag4 = uniqueTag3;
                                                    i22 = i21;
                                                }
                                                try {
                                                    if (callable instanceof NativeContinuation) {
                                                        ContinuationJump continuationJump2 = new ContinuationJump((NativeContinuation) callable, callFrame3);
                                                        Object obj38 = obj20;
                                                        if (b22 == 0) {
                                                            try {
                                                                continuationJump2.result = obj38;
                                                            } catch (Throwable th15) {
                                                                error9 = th15;
                                                                obj4 = obj38;
                                                                str = str3;
                                                                callFrame2 = callFrame3;
                                                                generatorState = generatorState3;
                                                                uniqueTag = uniqueTag4;
                                                                error6 = error9;
                                                                obj30 = null;
                                                                error14 = error6;
                                                                runtimeException = error14;
                                                                objArr = obj30;
                                                                if (obj2 != null) {
                                                                }
                                                            }
                                                        } else {
                                                            int i48 = i22 + 2;
                                                            continuationJump2.result = objArr5[i48];
                                                            continuationJump2.resultDbl = dArr14[i48];
                                                        }
                                                        continuationJump = continuationJump2;
                                                        obj4 = obj38;
                                                        str = str3;
                                                        generatorState = generatorState3;
                                                        uniqueTag = uniqueTag4;
                                                        break;
                                                    } else {
                                                        Object obj39 = obj20;
                                                        byte b38 = b22;
                                                        try {
                                                            try {
                                                                try {
                                                                    if (callable instanceof IdFunctionObject) {
                                                                        try {
                                                                            IdFunctionObject idFunctionObject = (IdFunctionObject) callable;
                                                                            if (NativeContinuation.isContinuationConstructor(idFunctionObject)) {
                                                                                callFrame3.stack[i22] = captureContinuation(context, callFrame3.parentFrame, false);
                                                                                obj4 = obj39;
                                                                                bArr2 = bArr5;
                                                                                b21 = b38;
                                                                            } else if (BaseFunction.isApplyOrCall(idFunctionObject)) {
                                                                                Callable callable2 = ScriptRuntime.getCallable(scriptable2);
                                                                                if (callable2 instanceof InterpretedFunction) {
                                                                                    InterpretedFunction interpretedFunction2 = (InterpretedFunction) callable2;
                                                                                    scriptable = scriptable2;
                                                                                    if (callFrame3.fnOrScript.securityDomain == interpretedFunction2.securityDomain) {
                                                                                        obj4 = obj39;
                                                                                        try {
                                                                                            callFrame2 = initFrameForApplyOrCall(context, callFrame3, b38, objArr5, dArr14, i22, b3, scriptable4, idFunctionObject, interpretedFunction2);
                                                                                            b14 = b38;
                                                                                            break;
                                                                                        } catch (Throwable th16) {
                                                                                            th = th16;
                                                                                            error8 = th;
                                                                                            str = str3;
                                                                                            callFrame2 = callFrame3;
                                                                                            generatorState = generatorState3;
                                                                                            uniqueTag = uniqueTag4;
                                                                                            objArr = null;
                                                                                            runtimeException = error8;
                                                                                            if (obj2 != null) {
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    obj4 = obj39;
                                                                                    if (callable instanceof ScriptRuntime.NoSuchMethodShim) {
                                                                                        ScriptRuntime.NoSuchMethodShim noSuchMethodShim = (ScriptRuntime.NoSuchMethodShim) callable;
                                                                                        Callable callable3 = noSuchMethodShim.noSuchMethodMethod;
                                                                                        if (callable3 instanceof InterpretedFunction) {
                                                                                            InterpretedFunction interpretedFunction3 = (InterpretedFunction) callable3;
                                                                                            if (callFrame3.fnOrScript.securityDomain == interpretedFunction3.securityDomain) {
                                                                                                callFrame2 = initFrameForNoSuchMethod(context, callFrame3, b38, objArr5, dArr14, i22, b3, scriptable, scriptable4, noSuchMethodShim, interpretedFunction3);
                                                                                                b14 = b38;
                                                                                                break;
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    Scriptable scriptable5 = scriptable;
                                                                                    bArr2 = bArr5;
                                                                                    b21 = b38;
                                                                                    context.lastInterpreterFrame = callFrame3;
                                                                                    callFrame3.savedCallOp = b3;
                                                                                    callFrame3.savedStackTop = i22;
                                                                                    objArr5[i22] = callable.call(context, scriptable4, scriptable5, getArgsArray(objArr5, dArr14, i22 + 2, b21));
                                                                                }
                                                                            }
                                                                        } catch (Throwable th17) {
                                                                            th = th17;
                                                                            obj4 = obj39;
                                                                        }
                                                                    }
                                                                    context.lastInterpreterFrame = callFrame3;
                                                                    callFrame3.savedCallOp = b3;
                                                                    callFrame3.savedStackTop = i22;
                                                                    objArr5[i22] = callable.call(context, scriptable4, scriptable5, getArgsArray(objArr5, dArr14, i22 + 2, b21));
                                                                } catch (Throwable th18) {
                                                                    th = th18;
                                                                    error8 = th;
                                                                    str = str3;
                                                                    callFrame2 = callFrame3;
                                                                    generatorState = generatorState3;
                                                                    uniqueTag = uniqueTag4;
                                                                    objArr = null;
                                                                    runtimeException = error8;
                                                                    if (obj2 != null) {
                                                                    }
                                                                }
                                                                if (callable instanceof ScriptRuntime.NoSuchMethodShim) {
                                                                }
                                                                Scriptable scriptable52 = scriptable;
                                                                bArr2 = bArr5;
                                                                b21 = b38;
                                                            } catch (Throwable th19) {
                                                                th = th19;
                                                            }
                                                            scriptable = scriptable2;
                                                            obj4 = obj39;
                                                        } catch (Throwable th20) {
                                                            obj4 = obj39;
                                                            th = th20;
                                                            error8 = th;
                                                            str = str3;
                                                            callFrame2 = callFrame3;
                                                            generatorState = generatorState3;
                                                            uniqueTag = uniqueTag4;
                                                            objArr = null;
                                                            runtimeException = error8;
                                                            if (obj2 != null) {
                                                            }
                                                        }
                                                    }
                                                } catch (Throwable th21) {
                                                    obj4 = obj20;
                                                    th = th21;
                                                }
                                            }
                                            i = i22;
                                            dArr2 = dArr14;
                                            i20 = b21;
                                            str2 = str3;
                                            callFrame4 = callFrame3;
                                            str16 = obj4;
                                            dArr = dArr13;
                                            iArr = iArr5;
                                            objArr3 = objArr12;
                                            generatorState = generatorState3;
                                            uniqueTag9 = uniqueTag4;
                                            b2 = i20;
                                            bArr = bArr2;
                                            objArr2 = objArr5;
                                            z2 = z;
                                        } catch (Throwable th22) {
                                            obj4 = obj17;
                                            error8 = th22;
                                            uniqueTag = uniqueTag3;
                                            str = str3;
                                            callFrame2 = callFrame3;
                                            generatorState = generatorState3;
                                        }
                                        break;
                                    case Icode.Icode_LEAVEDQ /* -54 */:
                                        objArr6 = objArr3;
                                        dArr5 = dArr;
                                        generatorState3 = generatorState;
                                        z = z2;
                                        uniqueTag3 = uniqueTag9;
                                        obj13 = str16;
                                        iArr3 = iArr;
                                        i5 = i2;
                                        str3 = str4;
                                        objArr7 = objArr2;
                                        byte b39 = b2;
                                        callFrame3 = callFrame4;
                                        bArr4 = bArr;
                                        dArr6 = dArr2;
                                        Object updateDotQuery = ScriptRuntime.updateDotQuery(stack_boolean(callFrame3, i5), callFrame3.scope);
                                        if (updateDotQuery != null) {
                                            objArr7[i5] = updateDotQuery;
                                            callFrame3.scope = ScriptRuntime.leaveDotQuery(callFrame3.scope);
                                            callFrame3.f4669pc += 2;
                                            obj4 = obj13;
                                            uniqueTag = uniqueTag3;
                                            b28 = b39;
                                            bArr3 = bArr4;
                                            generatorState = generatorState3;
                                            b4 = b28;
                                            i = i5;
                                            dArr2 = dArr6;
                                            b2 = b4;
                                            str2 = str3;
                                            callFrame4 = callFrame3;
                                            str16 = obj4;
                                            iArr = iArr3;
                                            objArr3 = objArr6;
                                            bArr = bArr3;
                                            uniqueTag9 = uniqueTag;
                                            objArr2 = objArr7;
                                            z2 = z;
                                            dArr = dArr5;
                                        } else {
                                            i = i5 - 1;
                                            i9 = b39;
                                            if (z) {
                                                addInstructionCount(context, callFrame3, 2);
                                            }
                                            i42 = getShort(bArr4, callFrame3.f4669pc);
                                            if (i42 == 0) {
                                                callFrame3.f4669pc = (i42 - 1) + callFrame3.f4669pc;
                                            } else {
                                                callFrame3.f4669pc = callFrame3.idata.longJumps.getExistingInt(callFrame3.f4669pc);
                                            }
                                            if (z) {
                                                callFrame3.pcPrevBranch = callFrame3.f4669pc;
                                            }
                                            i24 = i9;
                                            dArr2 = dArr6;
                                            objArr2 = objArr7;
                                            bArr = bArr4;
                                            str2 = str3;
                                            callFrame4 = callFrame3;
                                            z2 = z;
                                            iArr = iArr3;
                                            objArr3 = objArr6;
                                            str16 = obj13;
                                            b33 = i24;
                                            uniqueTag9 = uniqueTag3;
                                            dArr = dArr5;
                                            b2 = b33;
                                            generatorState = generatorState3;
                                        }
                                    case Icode.Icode_ENTERDQ /* -53 */:
                                        objArr6 = objArr3;
                                        dArr5 = dArr;
                                        generatorState3 = generatorState;
                                        z = z2;
                                        uniqueTag3 = uniqueTag9;
                                        obj13 = str16;
                                        iArr3 = iArr;
                                        str3 = str4;
                                        objArr7 = objArr2;
                                        i9 = b2;
                                        callFrame3 = callFrame4;
                                        bArr4 = bArr;
                                        dArr6 = dArr2;
                                        Object obj40 = objArr7[i2];
                                        if (obj40 == uniqueTag3) {
                                            obj40 = ScriptRuntime.wrapNumber(dArr6[i2]);
                                        }
                                        i23 = i2 - 1;
                                        callFrame3.scope = ScriptRuntime.enterDotQuery(obj40, callFrame3.scope);
                                        i = i23;
                                        i24 = i9;
                                        dArr2 = dArr6;
                                        objArr2 = objArr7;
                                        bArr = bArr4;
                                        str2 = str3;
                                        callFrame4 = callFrame3;
                                        z2 = z;
                                        iArr = iArr3;
                                        objArr3 = objArr6;
                                        str16 = obj13;
                                        b33 = i24;
                                        uniqueTag9 = uniqueTag3;
                                        dArr = dArr5;
                                        b2 = b33;
                                        generatorState = generatorState3;
                                    case Icode.Icode_ONE /* -52 */:
                                        objArr6 = objArr3;
                                        dArr5 = dArr;
                                        generatorState3 = generatorState;
                                        z = z2;
                                        uniqueTag3 = uniqueTag9;
                                        obj13 = str16;
                                        iArr3 = iArr;
                                        str3 = str4;
                                        objArr7 = objArr2;
                                        i9 = b2;
                                        callFrame3 = callFrame4;
                                        bArr4 = bArr;
                                        dArr6 = dArr2;
                                        i = i2 + 1;
                                        objArr7[i] = uniqueTag3;
                                        dArr6[i] = 1.0d;
                                        i24 = i9;
                                        dArr2 = dArr6;
                                        objArr2 = objArr7;
                                        bArr = bArr4;
                                        str2 = str3;
                                        callFrame4 = callFrame3;
                                        z2 = z;
                                        iArr = iArr3;
                                        objArr3 = objArr6;
                                        str16 = obj13;
                                        b33 = i24;
                                        uniqueTag9 = uniqueTag3;
                                        dArr = dArr5;
                                        b2 = b33;
                                        generatorState = generatorState3;
                                    case Icode.Icode_ZERO /* -51 */:
                                        objArr6 = objArr3;
                                        dArr5 = dArr;
                                        generatorState3 = generatorState;
                                        z = z2;
                                        uniqueTag3 = uniqueTag9;
                                        obj13 = str16;
                                        iArr3 = iArr;
                                        str3 = str4;
                                        objArr7 = objArr2;
                                        i9 = b2;
                                        callFrame3 = callFrame4;
                                        bArr4 = bArr;
                                        dArr6 = dArr2;
                                        i = i2 + 1;
                                        objArr7[i] = uniqueTag3;
                                        dArr6[i] = 0.0d;
                                        i24 = i9;
                                        dArr2 = dArr6;
                                        objArr2 = objArr7;
                                        bArr = bArr4;
                                        str2 = str3;
                                        callFrame4 = callFrame3;
                                        z2 = z;
                                        iArr = iArr3;
                                        objArr3 = objArr6;
                                        str16 = obj13;
                                        b33 = i24;
                                        uniqueTag9 = uniqueTag3;
                                        dArr = dArr5;
                                        b2 = b33;
                                        generatorState = generatorState3;
                                    case Icode.Icode_UNDEF /* -50 */:
                                        objArr6 = objArr3;
                                        dArr5 = dArr;
                                        generatorState3 = generatorState;
                                        z = z2;
                                        uniqueTag3 = uniqueTag9;
                                        obj13 = str16;
                                        iArr3 = iArr;
                                        str3 = str4;
                                        objArr7 = objArr2;
                                        i9 = b2;
                                        callFrame3 = callFrame4;
                                        bArr4 = bArr;
                                        dArr6 = dArr2;
                                        i = i2 + 1;
                                        objArr7[i] = obj13;
                                        i24 = i9;
                                        dArr2 = dArr6;
                                        objArr2 = objArr7;
                                        bArr = bArr4;
                                        str2 = str3;
                                        callFrame4 = callFrame3;
                                        z2 = z;
                                        iArr = iArr3;
                                        objArr3 = objArr6;
                                        str16 = obj13;
                                        b33 = i24;
                                        uniqueTag9 = uniqueTag3;
                                        dArr = dArr5;
                                        b2 = b33;
                                        generatorState = generatorState3;
                                    case Icode.Icode_SETVAR1 /* -49 */:
                                        objArr6 = objArr3;
                                        dArr5 = dArr;
                                        generatorState3 = generatorState;
                                        z = z2;
                                        uniqueTag3 = uniqueTag9;
                                        obj13 = str16;
                                        iArr3 = iArr;
                                        i16 = i2;
                                        str3 = str4;
                                        objArr7 = objArr2;
                                        callFrame3 = callFrame4;
                                        bArr4 = bArr;
                                        dArr6 = dArr2;
                                        callFrame3.f4669pc = i3 + 1;
                                        b18 = bArr4[i3];
                                        doSetVar = doSetVar(callFrame3, objArr7, dArr6, i16, objArr6, dArr5, iArr3, b18);
                                        i24 = b18;
                                        i = doSetVar;
                                        dArr2 = dArr6;
                                        objArr2 = objArr7;
                                        bArr = bArr4;
                                        str2 = str3;
                                        callFrame4 = callFrame3;
                                        z2 = z;
                                        iArr = iArr3;
                                        objArr3 = objArr6;
                                        str16 = obj13;
                                        b33 = i24;
                                        uniqueTag9 = uniqueTag3;
                                        dArr = dArr5;
                                        b2 = b33;
                                        generatorState = generatorState3;
                                    case Icode.Icode_GETVAR1 /* -48 */:
                                        objArr6 = objArr3;
                                        dArr5 = dArr;
                                        generatorState3 = generatorState;
                                        z = z2;
                                        uniqueTag3 = uniqueTag9;
                                        obj13 = str16;
                                        iArr3 = iArr;
                                        i15 = i2;
                                        str3 = str4;
                                        objArr7 = objArr2;
                                        callFrame3 = callFrame4;
                                        bArr4 = bArr;
                                        dArr6 = dArr2;
                                        callFrame3.f4669pc = i3 + 1;
                                        b18 = bArr4[i3];
                                        doSetVar = doGetVar(callFrame3, objArr7, dArr6, i15, objArr6, dArr5, b18);
                                        i24 = b18;
                                        i = doSetVar;
                                        dArr2 = dArr6;
                                        objArr2 = objArr7;
                                        bArr = bArr4;
                                        str2 = str3;
                                        callFrame4 = callFrame3;
                                        z2 = z;
                                        iArr = iArr3;
                                        objArr3 = objArr6;
                                        str16 = obj13;
                                        b33 = i24;
                                        uniqueTag9 = uniqueTag3;
                                        dArr = dArr5;
                                        b2 = b33;
                                        generatorState = generatorState3;
                                    case Icode.Icode_REG_STR4 /* -47 */:
                                        objArr16 = objArr3;
                                        dArr15 = dArr;
                                        generatorState5 = generatorState;
                                        z = z2;
                                        uniqueTag5 = uniqueTag9;
                                        obj23 = str16;
                                        iArr6 = iArr;
                                        i25 = i2;
                                        objArr17 = objArr2;
                                        b23 = b2;
                                        callFrame7 = callFrame4;
                                        bArr6 = bArr;
                                        dArr16 = dArr2;
                                        str12 = strArr[getInt(bArr6, i3)];
                                        i26 = callFrame7.f4669pc;
                                        i27 = 4;
                                        callFrame7.f4669pc = i26 + i27;
                                        b2 = b23;
                                        str16 = obj23;
                                        dArr2 = dArr16;
                                        objArr2 = objArr17;
                                        bArr = bArr6;
                                        callFrame4 = callFrame7;
                                        z2 = z;
                                        dArr = dArr15;
                                        iArr = iArr6;
                                        objArr3 = objArr16;
                                        uniqueTag9 = uniqueTag5;
                                        generatorState = generatorState5;
                                        int i49 = i25;
                                        str2 = str12;
                                        i = i49;
                                    case Icode.Icode_REG_STR2 /* -46 */:
                                        objArr16 = objArr3;
                                        dArr15 = dArr;
                                        generatorState5 = generatorState;
                                        z = z2;
                                        uniqueTag5 = uniqueTag9;
                                        obj23 = str16;
                                        iArr6 = iArr;
                                        i25 = i2;
                                        objArr17 = objArr2;
                                        b23 = b2;
                                        callFrame7 = callFrame4;
                                        bArr6 = bArr;
                                        dArr16 = dArr2;
                                        str12 = strArr[getIndex(bArr6, i3)];
                                        try {
                                            i26 = callFrame7.f4669pc;
                                            i27 = 2;
                                            callFrame7.f4669pc = i26 + i27;
                                            b2 = b23;
                                            str16 = obj23;
                                            dArr2 = dArr16;
                                            objArr2 = objArr17;
                                            bArr = bArr6;
                                            callFrame4 = callFrame7;
                                            z2 = z;
                                            dArr = dArr15;
                                            iArr = iArr6;
                                            objArr3 = objArr16;
                                            uniqueTag9 = uniqueTag5;
                                            generatorState = generatorState5;
                                            int i492 = i25;
                                            str2 = str12;
                                            i = i492;
                                        } catch (Throwable th23) {
                                            str = str12;
                                            obj4 = obj23;
                                            uniqueTag = uniqueTag5;
                                            callFrame2 = callFrame7;
                                            generatorState = generatorState5;
                                            obj3 = null;
                                            error = th23;
                                            Error error162 = error;
                                            Object obj342 = obj3;
                                            runtimeException = error162;
                                            objArr = obj342;
                                            if (obj2 != null) {
                                            }
                                        }
                                        break;
                                    case Icode.Icode_REG_STR1 /* -45 */:
                                        objArr18 = objArr3;
                                        dArr17 = dArr;
                                        generatorState3 = generatorState;
                                        z = z2;
                                        uniqueTag6 = uniqueTag9;
                                        obj24 = str16;
                                        iArr7 = iArr;
                                        i28 = i2;
                                        objArr19 = objArr2;
                                        b24 = b2;
                                        callFrame3 = callFrame4;
                                        bArr7 = bArr;
                                        dArr18 = dArr2;
                                        str13 = strArr[(bArr7[i3] & 255) == 1 ? 1 : 0];
                                        try {
                                            callFrame3.f4669pc = i3 + 1;
                                            i = i28;
                                            str2 = str13;
                                            b25 = b24;
                                            str16 = obj24;
                                            dArr2 = dArr18;
                                            objArr2 = objArr19;
                                            bArr = bArr7;
                                            callFrame4 = callFrame3;
                                            z2 = z;
                                            dArr = dArr17;
                                            iArr = iArr7;
                                            objArr3 = objArr18;
                                            uniqueTag9 = uniqueTag6;
                                            b2 = b25;
                                            generatorState = generatorState3;
                                        } catch (Throwable th24) {
                                            error7 = th24;
                                            str = str13;
                                            obj4 = obj24;
                                            uniqueTag = uniqueTag6;
                                            callFrame2 = callFrame3;
                                            generatorState = generatorState3;
                                            error6 = error7;
                                            obj30 = null;
                                            error14 = error6;
                                            runtimeException = error14;
                                            objArr = obj30;
                                            if (obj2 != null) {
                                            }
                                        }
                                        break;
                                    case Icode.Icode_REG_STR_C3 /* -44 */:
                                        objArr16 = objArr3;
                                        dArr15 = dArr;
                                        generatorState5 = generatorState;
                                        z = z2;
                                        uniqueTag5 = uniqueTag9;
                                        obj23 = str16;
                                        iArr6 = iArr;
                                        i25 = i2;
                                        objArr17 = objArr2;
                                        b23 = b2;
                                        callFrame7 = callFrame4;
                                        bArr6 = bArr;
                                        dArr16 = dArr2;
                                        str12 = strArr[3];
                                        b2 = b23;
                                        str16 = obj23;
                                        dArr2 = dArr16;
                                        objArr2 = objArr17;
                                        bArr = bArr6;
                                        callFrame4 = callFrame7;
                                        z2 = z;
                                        dArr = dArr15;
                                        iArr = iArr6;
                                        objArr3 = objArr16;
                                        uniqueTag9 = uniqueTag5;
                                        generatorState = generatorState5;
                                        int i4922 = i25;
                                        str2 = str12;
                                        i = i4922;
                                    case Icode.Icode_REG_STR_C2 /* -43 */:
                                        objArr18 = objArr3;
                                        dArr17 = dArr;
                                        generatorState3 = generatorState;
                                        z = z2;
                                        uniqueTag6 = uniqueTag9;
                                        obj24 = str16;
                                        iArr7 = iArr;
                                        i28 = i2;
                                        objArr19 = objArr2;
                                        b24 = b2;
                                        callFrame3 = callFrame4;
                                        bArr7 = bArr;
                                        dArr18 = dArr2;
                                        str13 = strArr[2];
                                        i = i28;
                                        str2 = str13;
                                        b25 = b24;
                                        str16 = obj24;
                                        dArr2 = dArr18;
                                        objArr2 = objArr19;
                                        bArr = bArr7;
                                        callFrame4 = callFrame3;
                                        z2 = z;
                                        dArr = dArr17;
                                        iArr = iArr7;
                                        objArr3 = objArr18;
                                        uniqueTag9 = uniqueTag6;
                                        b2 = b25;
                                        generatorState = generatorState3;
                                    case Icode.Icode_REG_STR_C1 /* -42 */:
                                        objArr16 = objArr3;
                                        dArr15 = dArr;
                                        generatorState5 = generatorState;
                                        z = z2;
                                        uniqueTag5 = uniqueTag9;
                                        obj23 = str16;
                                        iArr6 = iArr;
                                        i25 = i2;
                                        objArr17 = objArr2;
                                        b23 = b2;
                                        callFrame7 = callFrame4;
                                        bArr6 = bArr;
                                        dArr16 = dArr2;
                                        str12 = strArr[1];
                                        b2 = b23;
                                        str16 = obj23;
                                        dArr2 = dArr16;
                                        objArr2 = objArr17;
                                        bArr = bArr6;
                                        callFrame4 = callFrame7;
                                        z2 = z;
                                        dArr = dArr15;
                                        iArr = iArr6;
                                        objArr3 = objArr16;
                                        uniqueTag9 = uniqueTag5;
                                        generatorState = generatorState5;
                                        int i49222 = i25;
                                        str2 = str12;
                                        i = i49222;
                                    case Icode.Icode_REG_STR_C0 /* -41 */:
                                        objArr18 = objArr3;
                                        dArr17 = dArr;
                                        generatorState3 = generatorState;
                                        z = z2;
                                        uniqueTag6 = uniqueTag9;
                                        obj24 = str16;
                                        iArr7 = iArr;
                                        i28 = i2;
                                        objArr19 = objArr2;
                                        b24 = b2;
                                        callFrame3 = callFrame4;
                                        bArr7 = bArr;
                                        dArr18 = dArr2;
                                        str13 = strArr[0];
                                        i = i28;
                                        str2 = str13;
                                        b25 = b24;
                                        str16 = obj24;
                                        dArr2 = dArr18;
                                        objArr2 = objArr19;
                                        bArr = bArr7;
                                        callFrame4 = callFrame3;
                                        z2 = z;
                                        dArr = dArr17;
                                        iArr = iArr7;
                                        objArr3 = objArr18;
                                        uniqueTag9 = uniqueTag6;
                                        b2 = b25;
                                        generatorState = generatorState3;
                                    case Icode.Icode_REG_IND4 /* -40 */:
                                        objArr6 = objArr3;
                                        dArr5 = dArr;
                                        generatorState3 = generatorState;
                                        z = z2;
                                        uniqueTag3 = uniqueTag9;
                                        obj13 = str16;
                                        iArr3 = iArr;
                                        doSetVar = i2;
                                        str3 = str4;
                                        objArr7 = objArr2;
                                        callFrame3 = callFrame4;
                                        bArr4 = bArr;
                                        dArr6 = dArr2;
                                        i24 = getInt(bArr4, i3);
                                        i29 = callFrame3.f4669pc;
                                        i30 = 4;
                                        callFrame3.f4669pc = i29 + i30;
                                        i = doSetVar;
                                        dArr2 = dArr6;
                                        objArr2 = objArr7;
                                        bArr = bArr4;
                                        str2 = str3;
                                        callFrame4 = callFrame3;
                                        z2 = z;
                                        iArr = iArr3;
                                        objArr3 = objArr6;
                                        str16 = obj13;
                                        b33 = i24;
                                        uniqueTag9 = uniqueTag3;
                                        dArr = dArr5;
                                        b2 = b33;
                                        generatorState = generatorState3;
                                    case Icode.Icode_REG_IND2 /* -39 */:
                                        objArr6 = objArr3;
                                        dArr5 = dArr;
                                        generatorState3 = generatorState;
                                        z = z2;
                                        uniqueTag3 = uniqueTag9;
                                        obj13 = str16;
                                        iArr3 = iArr;
                                        doSetVar = i2;
                                        str3 = str4;
                                        objArr7 = objArr2;
                                        callFrame3 = callFrame4;
                                        bArr4 = bArr;
                                        dArr6 = dArr2;
                                        i24 = getIndex(bArr4, i3);
                                        i29 = callFrame3.f4669pc;
                                        i30 = 2;
                                        callFrame3.f4669pc = i29 + i30;
                                        i = doSetVar;
                                        dArr2 = dArr6;
                                        objArr2 = objArr7;
                                        bArr = bArr4;
                                        str2 = str3;
                                        callFrame4 = callFrame3;
                                        z2 = z;
                                        iArr = iArr3;
                                        objArr3 = objArr6;
                                        str16 = obj13;
                                        b33 = i24;
                                        uniqueTag9 = uniqueTag3;
                                        dArr = dArr5;
                                        b2 = b33;
                                        generatorState = generatorState3;
                                    case -38:
                                        objArr6 = objArr3;
                                        dArr5 = dArr;
                                        generatorState3 = generatorState;
                                        z = z2;
                                        uniqueTag3 = uniqueTag9;
                                        obj13 = str16;
                                        iArr3 = iArr;
                                        doSetVar = i2;
                                        str3 = str4;
                                        objArr7 = objArr2;
                                        callFrame3 = callFrame4;
                                        bArr4 = bArr;
                                        dArr6 = dArr2;
                                        i24 = bArr4[i3] & 255;
                                        callFrame3.f4669pc = i3 + 1;
                                        i = doSetVar;
                                        dArr2 = dArr6;
                                        objArr2 = objArr7;
                                        bArr = bArr4;
                                        str2 = str3;
                                        callFrame4 = callFrame3;
                                        z2 = z;
                                        iArr = iArr3;
                                        objArr3 = objArr6;
                                        str16 = obj13;
                                        b33 = i24;
                                        uniqueTag9 = uniqueTag3;
                                        dArr = dArr5;
                                        b2 = b33;
                                        generatorState = generatorState3;
                                    case Icode.Icode_REG_IND_C5 /* -37 */:
                                        dArr5 = dArr;
                                        generatorState3 = generatorState;
                                        uniqueTag3 = uniqueTag9;
                                        obj13 = str16;
                                        i24 = 5;
                                        i = i2;
                                        bArr = bArr;
                                        str2 = str4;
                                        z2 = z2;
                                        iArr = iArr;
                                        str16 = obj13;
                                        b33 = i24;
                                        uniqueTag9 = uniqueTag3;
                                        dArr = dArr5;
                                        b2 = b33;
                                        generatorState = generatorState3;
                                    case Icode.Icode_REG_IND_C4 /* -36 */:
                                        dArr5 = dArr;
                                        generatorState3 = generatorState;
                                        uniqueTag3 = uniqueTag9;
                                        obj13 = str16;
                                        i = i2;
                                        str2 = str4;
                                        i24 = 4;
                                        str16 = obj13;
                                        b33 = i24;
                                        uniqueTag9 = uniqueTag3;
                                        dArr = dArr5;
                                        b2 = b33;
                                        generatorState = generatorState3;
                                    case -35:
                                        dArr5 = dArr;
                                        generatorState3 = generatorState;
                                        uniqueTag3 = uniqueTag9;
                                        obj13 = str16;
                                        i = i2;
                                        str2 = str4;
                                        i24 = 3;
                                        str16 = obj13;
                                        b33 = i24;
                                        uniqueTag9 = uniqueTag3;
                                        dArr = dArr5;
                                        b2 = b33;
                                        generatorState = generatorState3;
                                    case -34:
                                        dArr5 = dArr;
                                        generatorState3 = generatorState;
                                        uniqueTag3 = uniqueTag9;
                                        obj13 = str16;
                                        i = i2;
                                        str2 = str4;
                                        i24 = 2;
                                        str16 = obj13;
                                        b33 = i24;
                                        uniqueTag9 = uniqueTag3;
                                        dArr = dArr5;
                                        b2 = b33;
                                        generatorState = generatorState3;
                                    case -33:
                                        dArr5 = dArr;
                                        generatorState3 = generatorState;
                                        uniqueTag3 = uniqueTag9;
                                        obj13 = str16;
                                        i = i2;
                                        str2 = str4;
                                        i24 = 1;
                                        str16 = obj13;
                                        b33 = i24;
                                        uniqueTag9 = uniqueTag3;
                                        dArr = dArr5;
                                        b2 = b33;
                                        generatorState = generatorState3;
                                    case -32:
                                        dArr5 = dArr;
                                        generatorState3 = generatorState;
                                        uniqueTag3 = uniqueTag9;
                                        obj13 = str16;
                                        i = i2;
                                        str2 = str4;
                                        i24 = 0;
                                        str16 = obj13;
                                        b33 = i24;
                                        uniqueTag9 = uniqueTag3;
                                        dArr = dArr5;
                                        b2 = b33;
                                        generatorState = generatorState3;
                                    case -31:
                                        objArr6 = objArr3;
                                        dArr5 = dArr;
                                        generatorState3 = generatorState;
                                        z = z2;
                                        uniqueTag3 = uniqueTag9;
                                        obj13 = str16;
                                        iArr3 = iArr;
                                        i17 = i2;
                                        str3 = str4;
                                        objArr7 = objArr2;
                                        b19 = b2;
                                        callFrame3 = callFrame4;
                                        bArr4 = bArr;
                                        dArr6 = dArr2;
                                        try {
                                            Object[] objArr26 = (Object[]) objArr7[i17];
                                            i23 = i17 - 1;
                                            int[] iArr10 = (int[]) objArr7[i23];
                                            if (b3 != 67) {
                                                newArrayLiteral = ScriptRuntime.newObjectLiteral((Object[]) callFrame3.idata.literalIds[b19], objArr26, iArr10, context, callFrame3.scope);
                                            } else {
                                                newArrayLiteral = ScriptRuntime.newArrayLiteral(objArr26, b3 == -31 ? (int[]) callFrame3.idata.literalIds[b19] : null, context, callFrame3.scope);
                                            }
                                            objArr7[i23] = newArrayLiteral;
                                            i9 = b19;
                                            i = i23;
                                            i24 = i9;
                                            dArr2 = dArr6;
                                            objArr2 = objArr7;
                                            bArr = bArr4;
                                            str2 = str3;
                                            callFrame4 = callFrame3;
                                            z2 = z;
                                            iArr = iArr3;
                                            objArr3 = objArr6;
                                            str16 = obj13;
                                            b33 = i24;
                                            uniqueTag9 = uniqueTag3;
                                            dArr = dArr5;
                                            b2 = b33;
                                            generatorState = generatorState3;
                                        } catch (Throwable th25) {
                                            error10 = th25;
                                            obj4 = obj13;
                                            uniqueTag = uniqueTag3;
                                            error15 = error10;
                                            str = str3;
                                            error7 = error15;
                                            callFrame2 = callFrame3;
                                            generatorState = generatorState3;
                                            error6 = error7;
                                            obj30 = null;
                                            error14 = error6;
                                            runtimeException = error14;
                                            objArr = obj30;
                                            if (obj2 != null) {
                                            }
                                        }
                                        break;
                                    case -30:
                                        objArr6 = objArr3;
                                        dArr5 = dArr;
                                        generatorState3 = generatorState;
                                        z = z2;
                                        uniqueTag3 = uniqueTag9;
                                        obj13 = str16;
                                        iArr3 = iArr;
                                        str3 = str4;
                                        objArr7 = objArr2;
                                        i9 = b2;
                                        callFrame3 = callFrame4;
                                        bArr4 = bArr;
                                        dArr6 = dArr2;
                                        Object obj41 = objArr7[i2];
                                        if (obj41 == uniqueTag3) {
                                            obj41 = ScriptRuntime.wrapNumber(dArr6[i2]);
                                        }
                                        i23 = i2 - 1;
                                        ((Object[]) objArr7[i23])[(int) dArr6[i23]] = obj41;
                                        dArr6[i23] = i31 + 1;
                                        i = i23;
                                        i24 = i9;
                                        dArr2 = dArr6;
                                        objArr2 = objArr7;
                                        bArr = bArr4;
                                        str2 = str3;
                                        callFrame4 = callFrame3;
                                        z2 = z;
                                        iArr = iArr3;
                                        objArr3 = objArr6;
                                        str16 = obj13;
                                        b33 = i24;
                                        uniqueTag9 = uniqueTag3;
                                        dArr = dArr5;
                                        b2 = b33;
                                        generatorState = generatorState3;
                                    case Icode.Icode_LITERAL_NEW /* -29 */:
                                        objArr6 = objArr3;
                                        dArr5 = dArr;
                                        generatorState3 = generatorState;
                                        z = z2;
                                        uniqueTag3 = uniqueTag9;
                                        obj13 = str16;
                                        iArr3 = iArr;
                                        str3 = str4;
                                        objArr7 = objArr2;
                                        i9 = b2;
                                        callFrame3 = callFrame4;
                                        bArr4 = bArr;
                                        dArr6 = dArr2;
                                        int i50 = i2 + 1;
                                        objArr7[i50] = new int[i9];
                                        i = i50 + 1;
                                        objArr7[i] = new Object[i9];
                                        dArr6[i] = 0.0d;
                                        i24 = i9;
                                        dArr2 = dArr6;
                                        objArr2 = objArr7;
                                        bArr = bArr4;
                                        str2 = str3;
                                        callFrame4 = callFrame3;
                                        z2 = z;
                                        iArr = iArr3;
                                        objArr3 = objArr6;
                                        str16 = obj13;
                                        b33 = i24;
                                        uniqueTag9 = uniqueTag3;
                                        dArr = dArr5;
                                        b2 = b33;
                                        generatorState = generatorState3;
                                    case -28:
                                        objArr6 = objArr3;
                                        dArr5 = dArr;
                                        generatorState3 = generatorState;
                                        z = z2;
                                        uniqueTag3 = uniqueTag9;
                                        obj13 = str16;
                                        iArr3 = iArr;
                                        str3 = str4;
                                        objArr7 = objArr2;
                                        b26 = b2;
                                        callFrame3 = callFrame4;
                                        bArr4 = bArr;
                                        dArr6 = dArr2;
                                        i23 = i2 + 1;
                                        objArr7[i23] = uniqueTag3;
                                        dArr6[i23] = getInt(bArr4, i3);
                                        i32 = callFrame3.f4669pc;
                                        i33 = 4;
                                        callFrame3.f4669pc = i32 + i33;
                                        i9 = b26;
                                        i = i23;
                                        i24 = i9;
                                        dArr2 = dArr6;
                                        objArr2 = objArr7;
                                        bArr = bArr4;
                                        str2 = str3;
                                        callFrame4 = callFrame3;
                                        z2 = z;
                                        iArr = iArr3;
                                        objArr3 = objArr6;
                                        str16 = obj13;
                                        b33 = i24;
                                        uniqueTag9 = uniqueTag3;
                                        dArr = dArr5;
                                        b2 = b33;
                                        generatorState = generatorState3;
                                    case -27:
                                        objArr6 = objArr3;
                                        dArr5 = dArr;
                                        generatorState3 = generatorState;
                                        z = z2;
                                        uniqueTag3 = uniqueTag9;
                                        obj13 = str16;
                                        iArr3 = iArr;
                                        str3 = str4;
                                        objArr7 = objArr2;
                                        b26 = b2;
                                        callFrame3 = callFrame4;
                                        bArr4 = bArr;
                                        dArr6 = dArr2;
                                        i23 = i2 + 1;
                                        objArr7[i23] = uniqueTag3;
                                        dArr6[i23] = getShort(bArr4, i3);
                                        i32 = callFrame3.f4669pc;
                                        i33 = 2;
                                        callFrame3.f4669pc = i32 + i33;
                                        i9 = b26;
                                        i = i23;
                                        i24 = i9;
                                        dArr2 = dArr6;
                                        objArr2 = objArr7;
                                        bArr = bArr4;
                                        str2 = str3;
                                        callFrame4 = callFrame3;
                                        z2 = z;
                                        iArr = iArr3;
                                        objArr3 = objArr6;
                                        str16 = obj13;
                                        b33 = i24;
                                        uniqueTag9 = uniqueTag3;
                                        dArr = dArr5;
                                        b2 = b33;
                                        generatorState = generatorState3;
                                    case -26:
                                        objArr6 = objArr3;
                                        dArr5 = dArr;
                                        generatorState3 = generatorState;
                                        z = z2;
                                        uniqueTag3 = uniqueTag9;
                                        obj13 = str16;
                                        iArr3 = iArr;
                                        i34 = i2;
                                        str3 = str4;
                                        objArr7 = objArr2;
                                        b27 = b2;
                                        callFrame3 = callFrame4;
                                        bArr4 = bArr;
                                        dArr6 = dArr2;
                                        callFrame3.pcSourceLineStart = i3;
                                        if (callFrame3.debuggerFrame != null) {
                                            callFrame3.debuggerFrame.onLineChange(context, getIndex(bArr4, i3));
                                        }
                                        callFrame3.f4669pc += 2;
                                        obj4 = obj13;
                                        uniqueTag = uniqueTag3;
                                        i5 = i34;
                                        b28 = b27;
                                        bArr3 = bArr4;
                                        generatorState = generatorState3;
                                        b4 = b28;
                                        i = i5;
                                        dArr2 = dArr6;
                                        b2 = b4;
                                        str2 = str3;
                                        callFrame4 = callFrame3;
                                        str16 = obj4;
                                        iArr = iArr3;
                                        objArr3 = objArr6;
                                        bArr = bArr3;
                                        uniqueTag9 = uniqueTag;
                                        objArr2 = objArr7;
                                        z2 = z;
                                        dArr = dArr5;
                                    case -25:
                                        objArr6 = objArr3;
                                        dArr5 = dArr;
                                        generatorState3 = generatorState;
                                        z = z2;
                                        uniqueTag3 = uniqueTag9;
                                        obj13 = str16;
                                        iArr3 = iArr;
                                        str3 = str4;
                                        Object[] objArr27 = objArr2;
                                        byte b40 = b2;
                                        callFrame3 = callFrame4;
                                        bArr4 = bArr;
                                        double[] dArr27 = dArr2;
                                        if (z) {
                                            addInstructionCount(context, callFrame3, 0);
                                        }
                                        i24 = b40 + callFrame3.localShift;
                                        Object obj42 = objArr27[i24];
                                        if (obj42 != uniqueTag3) {
                                            obj4 = obj13;
                                            uniqueTag = uniqueTag3;
                                            str = str3;
                                            generatorState = generatorState3;
                                            continuationJump = obj42;
                                            break;
                                        } else {
                                            int i51 = (int) dArr27[i24];
                                            callFrame3.f4669pc = i51;
                                            if (z) {
                                                callFrame3.pcPrevBranch = i51;
                                            }
                                            dArr2 = dArr27;
                                            objArr2 = objArr27;
                                            i = i2;
                                            bArr = bArr4;
                                            str2 = str3;
                                            callFrame4 = callFrame3;
                                            z2 = z;
                                            iArr = iArr3;
                                            objArr3 = objArr6;
                                            str16 = obj13;
                                            b33 = i24;
                                            uniqueTag9 = uniqueTag3;
                                            dArr = dArr5;
                                            b2 = b33;
                                            generatorState = generatorState3;
                                        }
                                    case -24:
                                        objArr6 = objArr3;
                                        dArr5 = dArr;
                                        generatorState3 = generatorState;
                                        z = z2;
                                        uniqueTag3 = uniqueTag9;
                                        obj13 = str16;
                                        iArr3 = iArr;
                                        i34 = i2;
                                        str3 = str4;
                                        objArr7 = objArr2;
                                        b27 = b2;
                                        callFrame3 = callFrame4;
                                        bArr4 = bArr;
                                        dArr6 = dArr2;
                                        if (i34 == callFrame3.emptyStackTop + 1) {
                                            i24 = b27 + callFrame3.localShift;
                                            objArr7[i24] = objArr7[i34];
                                            dArr6[i24] = dArr6[i34];
                                            i = i34 - 1;
                                            dArr2 = dArr6;
                                            objArr2 = objArr7;
                                            bArr = bArr4;
                                            str2 = str3;
                                            callFrame4 = callFrame3;
                                            z2 = z;
                                            iArr = iArr3;
                                            objArr3 = objArr6;
                                            str16 = obj13;
                                            b33 = i24;
                                            uniqueTag9 = uniqueTag3;
                                            dArr = dArr5;
                                            b2 = b33;
                                            generatorState = generatorState3;
                                        } else {
                                            if (i34 != callFrame3.emptyStackTop) {
                                                Kit.codeBug();
                                            }
                                            obj4 = obj13;
                                            uniqueTag = uniqueTag3;
                                            i5 = i34;
                                            b28 = b27;
                                            bArr3 = bArr4;
                                            generatorState = generatorState3;
                                            b4 = b28;
                                            i = i5;
                                            dArr2 = dArr6;
                                            b2 = b4;
                                            str2 = str3;
                                            callFrame4 = callFrame3;
                                            str16 = obj4;
                                            iArr = iArr3;
                                            objArr3 = objArr6;
                                            bArr = bArr3;
                                            uniqueTag9 = uniqueTag;
                                            objArr2 = objArr7;
                                            z2 = z;
                                            dArr = dArr5;
                                        }
                                    case -23:
                                        objArr6 = objArr3;
                                        dArr5 = dArr;
                                        generatorState3 = generatorState;
                                        z = z2;
                                        uniqueTag3 = uniqueTag9;
                                        obj13 = str16;
                                        iArr3 = iArr;
                                        str3 = str4;
                                        objArr7 = objArr2;
                                        i9 = b2;
                                        callFrame3 = callFrame4;
                                        bArr4 = bArr;
                                        dArr6 = dArr2;
                                        int i52 = i2 + 1;
                                        objArr7[i52] = uniqueTag3;
                                        dArr6[i52] = i3 + 2;
                                        i = i52;
                                        if (z) {
                                        }
                                        i42 = getShort(bArr4, callFrame3.f4669pc);
                                        if (i42 == 0) {
                                        }
                                        if (z) {
                                        }
                                        i24 = i9;
                                        dArr2 = dArr6;
                                        objArr2 = objArr7;
                                        bArr = bArr4;
                                        str2 = str3;
                                        callFrame4 = callFrame3;
                                        z2 = z;
                                        iArr = iArr3;
                                        objArr3 = objArr6;
                                        str16 = obj13;
                                        b33 = i24;
                                        uniqueTag9 = uniqueTag3;
                                        dArr = dArr5;
                                        b2 = b33;
                                        generatorState = generatorState3;
                                        break;
                                    case -22:
                                        byte b41 = b2;
                                        callFrame3 = callFrame4;
                                        GeneratorState generatorState9 = generatorState;
                                        z = z2;
                                        UniqueTag uniqueTag11 = uniqueTag9;
                                        Object obj43 = str16;
                                        str3 = str4;
                                        callFrame3.result = obj43;
                                        obj4 = obj43;
                                        uniqueTag = uniqueTag11;
                                        b4 = b41;
                                        generatorState = generatorState9;
                                        obj11 = null;
                                        break;
                                    case -21:
                                        objArr18 = objArr3;
                                        dArr17 = dArr;
                                        generatorState3 = generatorState;
                                        z = z2;
                                        uniqueTag6 = uniqueTag9;
                                        obj25 = str16;
                                        iArr7 = iArr;
                                        double[] dArr28 = dArr2;
                                        str14 = str4;
                                        Object[] objArr28 = objArr2;
                                        byte b42 = b2;
                                        callFrame8 = callFrame4;
                                        bArr8 = bArr;
                                        if (z) {
                                            context.instructionCount += 100;
                                        }
                                        i = doCallSpecial(context, callFrame8, objArr28, dArr28, i2, bArr8, b42);
                                        dArr2 = dArr28;
                                        objArr2 = objArr28;
                                        b29 = b42;
                                        bArr = bArr8;
                                        str2 = str14;
                                        callFrame4 = callFrame8;
                                        str16 = obj25;
                                        b25 = b29;
                                        z2 = z;
                                        dArr = dArr17;
                                        iArr = iArr7;
                                        objArr3 = objArr18;
                                        uniqueTag9 = uniqueTag6;
                                        b2 = b25;
                                        generatorState = generatorState3;
                                    case -20:
                                        objArr6 = objArr3;
                                        dArr5 = dArr;
                                        generatorState3 = generatorState;
                                        z = z2;
                                        uniqueTag7 = uniqueTag9;
                                        obj4 = str16;
                                        iArr3 = iArr;
                                        dArr19 = dArr2;
                                        i35 = i2;
                                        str3 = str4;
                                        objArr7 = objArr2;
                                        b30 = b2;
                                        callFrame3 = callFrame4;
                                        bArr9 = bArr;
                                        obj26 = null;
                                        initFunction(context, callFrame3.scope, callFrame3.fnOrScript, b30);
                                        i5 = i35;
                                        bArr3 = bArr9;
                                        b4 = b30;
                                        dArr6 = dArr19;
                                        uniqueTag = uniqueTag7;
                                        generatorState = generatorState3;
                                        i = i5;
                                        dArr2 = dArr6;
                                        b2 = b4;
                                        str2 = str3;
                                        callFrame4 = callFrame3;
                                        str16 = obj4;
                                        iArr = iArr3;
                                        objArr3 = objArr6;
                                        bArr = bArr3;
                                        uniqueTag9 = uniqueTag;
                                        objArr2 = objArr7;
                                        z2 = z;
                                        dArr = dArr5;
                                    case -19:
                                        objArr18 = objArr3;
                                        dArr17 = dArr;
                                        generatorState3 = generatorState;
                                        z = z2;
                                        uniqueTag6 = uniqueTag9;
                                        obj25 = str16;
                                        iArr7 = iArr;
                                        dArr20 = dArr2;
                                        str14 = str4;
                                        objArr20 = objArr2;
                                        b31 = b2;
                                        callFrame8 = callFrame4;
                                        bArr8 = bArr;
                                        InterpretedFunction createFunction = InterpretedFunction.createFunction(context, callFrame8.scope, callFrame8.fnOrScript, b31);
                                        if (createFunction.idata.itsFunctionType == 4) {
                                            i36 = i2 + 1;
                                            objArr20[i36] = new ArrowFunction(context, callFrame8.scope, createFunction, callFrame8.thisObj);
                                        } else {
                                            i36 = i2 + 1;
                                            objArr20[i36] = createFunction;
                                        }
                                        i = i36;
                                        b29 = b31;
                                        dArr2 = dArr20;
                                        objArr2 = objArr20;
                                        bArr = bArr8;
                                        str2 = str14;
                                        callFrame4 = callFrame8;
                                        str16 = obj25;
                                        b25 = b29;
                                        z2 = z;
                                        dArr = dArr17;
                                        iArr = iArr7;
                                        objArr3 = objArr18;
                                        uniqueTag9 = uniqueTag6;
                                        b2 = b25;
                                        generatorState = generatorState3;
                                    case -18:
                                        objArr18 = objArr3;
                                        dArr17 = dArr;
                                        generatorState3 = generatorState;
                                        z = z2;
                                        uniqueTag6 = uniqueTag9;
                                        obj25 = str16;
                                        iArr7 = iArr;
                                        dArr20 = dArr2;
                                        str14 = str4;
                                        objArr20 = objArr2;
                                        b31 = b2;
                                        callFrame8 = callFrame4;
                                        bArr8 = bArr;
                                        Object obj44 = objArr20[i2];
                                        if (obj44 == uniqueTag6) {
                                            obj44 = ScriptRuntime.wrapNumber(dArr20[i2]);
                                        }
                                        objArr20[i2] = ScriptRuntime.getValueFunctionAndThis(obj44, context);
                                        i = i2 + 1;
                                        objArr20[i] = ScriptRuntime.lastStoredScriptable(context);
                                        b29 = b31;
                                        dArr2 = dArr20;
                                        objArr2 = objArr20;
                                        bArr = bArr8;
                                        str2 = str14;
                                        callFrame4 = callFrame8;
                                        str16 = obj25;
                                        b25 = b29;
                                        z2 = z;
                                        dArr = dArr17;
                                        iArr = iArr7;
                                        objArr3 = objArr18;
                                        uniqueTag9 = uniqueTag6;
                                        b2 = b25;
                                        generatorState = generatorState3;
                                    case -17:
                                        objArr6 = objArr3;
                                        dArr5 = dArr;
                                        generatorState3 = generatorState;
                                        z = z2;
                                        uniqueTag7 = uniqueTag9;
                                        obj4 = str16;
                                        iArr3 = iArr;
                                        dArr19 = dArr2;
                                        i35 = i2;
                                        str3 = str4;
                                        objArr7 = objArr2;
                                        b30 = b2;
                                        callFrame3 = callFrame4;
                                        bArr9 = bArr;
                                        obj26 = null;
                                        int i53 = i35 - 1;
                                        Object obj45 = objArr7[i53];
                                        if (obj45 == uniqueTag7) {
                                            obj45 = ScriptRuntime.wrapNumber(dArr19[i53]);
                                        }
                                        Object obj46 = objArr7[i35];
                                        if (obj46 == uniqueTag7) {
                                            obj46 = ScriptRuntime.wrapNumber(dArr19[i35]);
                                        }
                                        objArr7[i53] = ScriptRuntime.getElemFunctionAndThis(obj45, obj46, context, callFrame3.scope);
                                        objArr7[i35] = ScriptRuntime.lastStoredScriptable(context);
                                        i5 = i35;
                                        bArr3 = bArr9;
                                        b4 = b30;
                                        dArr6 = dArr19;
                                        uniqueTag = uniqueTag7;
                                        generatorState = generatorState3;
                                        i = i5;
                                        dArr2 = dArr6;
                                        b2 = b4;
                                        str2 = str3;
                                        callFrame4 = callFrame3;
                                        str16 = obj4;
                                        iArr = iArr3;
                                        objArr3 = objArr6;
                                        bArr = bArr3;
                                        uniqueTag9 = uniqueTag;
                                        objArr2 = objArr7;
                                        z2 = z;
                                        dArr = dArr5;
                                    case -16:
                                        objArr18 = objArr3;
                                        dArr17 = dArr;
                                        generatorState3 = generatorState;
                                        z = z2;
                                        uniqueTag6 = uniqueTag9;
                                        obj25 = str16;
                                        iArr7 = iArr;
                                        dArr20 = dArr2;
                                        str14 = str4;
                                        objArr20 = objArr2;
                                        b31 = b2;
                                        callFrame8 = callFrame4;
                                        bArr8 = bArr;
                                        Object obj47 = objArr20[i2];
                                        if (obj47 == uniqueTag6) {
                                            obj47 = ScriptRuntime.wrapNumber(dArr20[i2]);
                                        }
                                        objArr20[i2] = ScriptRuntime.getPropFunctionAndThis(obj47, str14, context, callFrame8.scope);
                                        i = i2 + 1;
                                        objArr20[i] = ScriptRuntime.lastStoredScriptable(context);
                                        b29 = b31;
                                        dArr2 = dArr20;
                                        objArr2 = objArr20;
                                        bArr = bArr8;
                                        str2 = str14;
                                        callFrame4 = callFrame8;
                                        str16 = obj25;
                                        b25 = b29;
                                        z2 = z;
                                        dArr = dArr17;
                                        iArr = iArr7;
                                        objArr3 = objArr18;
                                        uniqueTag9 = uniqueTag6;
                                        b2 = b25;
                                        generatorState = generatorState3;
                                    case -15:
                                        objArr18 = objArr3;
                                        dArr17 = dArr;
                                        generatorState3 = generatorState;
                                        z = z2;
                                        uniqueTag6 = uniqueTag9;
                                        obj25 = str16;
                                        iArr7 = iArr;
                                        dArr20 = dArr2;
                                        str14 = str4;
                                        objArr20 = objArr2;
                                        b31 = b2;
                                        callFrame8 = callFrame4;
                                        bArr8 = bArr;
                                        int i54 = i2 + 1;
                                        objArr20[i54] = ScriptRuntime.getNameFunctionAndThis(str14, context, callFrame8.scope);
                                        i = i54 + 1;
                                        objArr20[i] = ScriptRuntime.lastStoredScriptable(context);
                                        b29 = b31;
                                        dArr2 = dArr20;
                                        objArr2 = objArr20;
                                        bArr = bArr8;
                                        str2 = str14;
                                        callFrame4 = callFrame8;
                                        str16 = obj25;
                                        b25 = b29;
                                        z2 = z;
                                        dArr = dArr17;
                                        iArr = iArr7;
                                        objArr3 = objArr18;
                                        uniqueTag9 = uniqueTag6;
                                        b2 = b25;
                                        generatorState = generatorState3;
                                    case -14:
                                        objArr18 = objArr3;
                                        dArr17 = dArr;
                                        generatorState3 = generatorState;
                                        z = z2;
                                        uniqueTag6 = uniqueTag9;
                                        obj25 = str16;
                                        iArr7 = iArr;
                                        dArr20 = dArr2;
                                        str14 = str4;
                                        objArr20 = objArr2;
                                        b31 = b2;
                                        callFrame8 = callFrame4;
                                        bArr8 = bArr;
                                        i = i2 + 1;
                                        objArr20[i] = ScriptRuntime.typeofName(callFrame8.scope, str14);
                                        b29 = b31;
                                        dArr2 = dArr20;
                                        objArr2 = objArr20;
                                        bArr = bArr8;
                                        str2 = str14;
                                        callFrame4 = callFrame8;
                                        str16 = obj25;
                                        b25 = b29;
                                        z2 = z;
                                        dArr = dArr17;
                                        iArr = iArr7;
                                        objArr3 = objArr18;
                                        uniqueTag9 = uniqueTag6;
                                        b2 = b25;
                                        generatorState = generatorState3;
                                    case -13:
                                        objArr18 = objArr3;
                                        dArr17 = dArr;
                                        generatorState3 = generatorState;
                                        z = z2;
                                        uniqueTag6 = uniqueTag9;
                                        obj25 = str16;
                                        iArr7 = iArr;
                                        dArr21 = dArr2;
                                        i37 = i2;
                                        str14 = str4;
                                        objArr21 = objArr2;
                                        callFrame8 = callFrame4;
                                        bArr8 = bArr;
                                        i38 = b2 + callFrame8.localShift;
                                        objArr21[i38] = callFrame8.scope;
                                        dArr2 = dArr21;
                                        objArr2 = objArr21;
                                        i = i37;
                                        b29 = i38;
                                        bArr = bArr8;
                                        str2 = str14;
                                        callFrame4 = callFrame8;
                                        str16 = obj25;
                                        b25 = b29;
                                        z2 = z;
                                        dArr = dArr17;
                                        iArr = iArr7;
                                        objArr3 = objArr18;
                                        uniqueTag9 = uniqueTag6;
                                        b2 = b25;
                                        generatorState = generatorState3;
                                    case -12:
                                        objArr18 = objArr3;
                                        dArr17 = dArr;
                                        generatorState3 = generatorState;
                                        z = z2;
                                        uniqueTag6 = uniqueTag9;
                                        obj25 = str16;
                                        iArr7 = iArr;
                                        dArr21 = dArr2;
                                        i37 = i2;
                                        str14 = str4;
                                        objArr21 = objArr2;
                                        callFrame8 = callFrame4;
                                        bArr8 = bArr;
                                        i38 = b2 + callFrame8.localShift;
                                        callFrame8.scope = (Scriptable) objArr21[i38];
                                        dArr2 = dArr21;
                                        objArr2 = objArr21;
                                        i = i37;
                                        b29 = i38;
                                        bArr = bArr8;
                                        str2 = str14;
                                        callFrame4 = callFrame8;
                                        str16 = obj25;
                                        b25 = b29;
                                        z2 = z;
                                        dArr = dArr17;
                                        iArr = iArr7;
                                        objArr3 = objArr18;
                                        uniqueTag9 = uniqueTag6;
                                        b2 = b25;
                                        generatorState = generatorState3;
                                    case -11:
                                        objArr6 = objArr3;
                                        dArr5 = dArr;
                                        generatorState3 = generatorState;
                                        z = z2;
                                        uniqueTag7 = uniqueTag9;
                                        obj4 = str16;
                                        iArr3 = iArr;
                                        dArr19 = dArr2;
                                        i39 = i2;
                                        str3 = str4;
                                        objArr7 = objArr2;
                                        b32 = b2;
                                        callFrame3 = callFrame4;
                                        bArr10 = bArr;
                                        obj27 = null;
                                        objArr7[i39] = ScriptRuntime.refIncrDecr((Ref) objArr7[i39], context, callFrame3.scope, bArr10[i3]);
                                        i40 = callFrame3.f4669pc;
                                        i41 = 1;
                                        callFrame3.f4669pc = i40 + i41;
                                        i5 = i39;
                                        bArr3 = bArr10;
                                        b4 = b32;
                                        dArr6 = dArr19;
                                        uniqueTag = uniqueTag7;
                                        generatorState = generatorState3;
                                        i = i5;
                                        dArr2 = dArr6;
                                        b2 = b4;
                                        str2 = str3;
                                        callFrame4 = callFrame3;
                                        str16 = obj4;
                                        iArr = iArr3;
                                        objArr3 = objArr6;
                                        bArr = bArr3;
                                        uniqueTag9 = uniqueTag;
                                        objArr2 = objArr7;
                                        z2 = z;
                                        dArr = dArr5;
                                    case -10:
                                        dArr5 = dArr;
                                        generatorState3 = generatorState;
                                        boolean z3 = z2;
                                        uniqueTag3 = uniqueTag9;
                                        int[] iArr11 = iArr;
                                        double[] dArr29 = dArr2;
                                        Object[] objArr29 = objArr2;
                                        CallFrame callFrame11 = callFrame4;
                                        byte[] bArr12 = bArr;
                                        i = doElemIncDec(context, callFrame11, bArr12, objArr29, dArr29, i2);
                                        objArr2 = objArr29;
                                        bArr = bArr12;
                                        str2 = str4;
                                        callFrame4 = callFrame11;
                                        b33 = b2;
                                        str16 = str16;
                                        z2 = z3;
                                        iArr = iArr11;
                                        objArr3 = objArr3;
                                        dArr2 = dArr29;
                                        uniqueTag9 = uniqueTag3;
                                        dArr = dArr5;
                                        b2 = b33;
                                        generatorState = generatorState3;
                                    case -9:
                                        objArr6 = objArr3;
                                        dArr5 = dArr;
                                        generatorState3 = generatorState;
                                        z = z2;
                                        UniqueTag uniqueTag12 = uniqueTag9;
                                        obj4 = str16;
                                        iArr3 = iArr;
                                        double[] dArr30 = dArr2;
                                        i39 = i2;
                                        str3 = str4;
                                        objArr7 = objArr2;
                                        b32 = b2;
                                        callFrame3 = callFrame4;
                                        bArr10 = bArr;
                                        obj27 = null;
                                        Object obj48 = objArr7[i39];
                                        uniqueTag7 = uniqueTag12;
                                        if (obj48 == uniqueTag7) {
                                            dArr19 = dArr30;
                                            try {
                                                obj48 = ScriptRuntime.wrapNumber(dArr19[i39]);
                                            } catch (Throwable th26) {
                                                error11 = th26;
                                                uniqueTag = uniqueTag7;
                                                obj22 = obj27;
                                                str = str3;
                                                callFrame2 = callFrame3;
                                                generatorState = generatorState3;
                                                error13 = error11;
                                                obj14 = obj22;
                                                error14 = error13;
                                                obj30 = obj14;
                                                runtimeException = error14;
                                                objArr = obj30;
                                                if (obj2 != null) {
                                                }
                                            }
                                        } else {
                                            dArr19 = dArr30;
                                        }
                                        objArr7[i39] = ScriptRuntime.propIncrDecr(obj48, str3, context, callFrame3.scope, bArr10[callFrame3.f4669pc]);
                                        i40 = callFrame3.f4669pc;
                                        i41 = 1;
                                        callFrame3.f4669pc = i40 + i41;
                                        i5 = i39;
                                        bArr3 = bArr10;
                                        b4 = b32;
                                        dArr6 = dArr19;
                                        uniqueTag = uniqueTag7;
                                        generatorState = generatorState3;
                                        i = i5;
                                        dArr2 = dArr6;
                                        b2 = b4;
                                        str2 = str3;
                                        callFrame4 = callFrame3;
                                        str16 = obj4;
                                        iArr = iArr3;
                                        objArr3 = objArr6;
                                        bArr = bArr3;
                                        uniqueTag9 = uniqueTag;
                                        objArr2 = objArr7;
                                        z2 = z;
                                        dArr = dArr5;
                                        break;
                                    case -8:
                                        objArr22 = objArr3;
                                        dArr22 = dArr;
                                        generatorState6 = generatorState;
                                        z = z2;
                                        uniqueTag8 = uniqueTag9;
                                        obj4 = str16;
                                        iArr8 = iArr;
                                        dArr23 = dArr2;
                                        str15 = str4;
                                        objArr23 = objArr2;
                                        b34 = b2;
                                        callFrame9 = callFrame4;
                                        bArr11 = bArr;
                                        int i55 = i2 + 1;
                                        try {
                                            objArr23[i55] = ScriptRuntime.nameIncrDecr(callFrame9.scope, str15, context, bArr11[i3]);
                                            callFrame9.f4669pc++;
                                            i = i55;
                                            objArr2 = objArr23;
                                            bArr = bArr11;
                                            str2 = str15;
                                            callFrame4 = callFrame9;
                                            b2 = b34;
                                            str16 = obj4;
                                            z2 = z;
                                            dArr = dArr22;
                                            iArr = iArr8;
                                            objArr3 = objArr22;
                                            generatorState = generatorState6;
                                            uniqueTag9 = uniqueTag8;
                                            dArr2 = dArr23;
                                        } catch (Throwable th27) {
                                            error12 = th27;
                                            obj28 = null;
                                            str = str15;
                                            callFrame2 = callFrame9;
                                            generatorState = generatorState6;
                                            uniqueTag = uniqueTag8;
                                            error13 = error12;
                                            obj14 = obj28;
                                            error14 = error13;
                                            obj30 = obj14;
                                            runtimeException = error14;
                                            objArr = obj30;
                                            if (obj2 != null) {
                                            }
                                        }
                                        break;
                                    case -7:
                                        objArr22 = objArr3;
                                        generatorState6 = generatorState;
                                        z = z2;
                                        obj4 = str16;
                                        iArr8 = iArr;
                                        double[] dArr31 = dArr2;
                                        str15 = str4;
                                        objArr23 = objArr2;
                                        b34 = b2;
                                        callFrame9 = callFrame4;
                                        dArr22 = dArr;
                                        dArr23 = dArr31;
                                        uniqueTag8 = uniqueTag9;
                                        bArr11 = bArr;
                                        try {
                                            i = doVarIncDec(context, callFrame9, objArr2, dArr31, i2, objArr22, dArr, iArr8, b34);
                                            objArr2 = objArr23;
                                            bArr = bArr11;
                                            str2 = str15;
                                            callFrame4 = callFrame9;
                                            b2 = b34;
                                            str16 = obj4;
                                            z2 = z;
                                            dArr = dArr22;
                                            iArr = iArr8;
                                            objArr3 = objArr22;
                                            generatorState = generatorState6;
                                            uniqueTag9 = uniqueTag8;
                                            dArr2 = dArr23;
                                        } catch (Throwable th28) {
                                            error12 = th28;
                                            obj28 = null;
                                            str = str15;
                                            callFrame2 = callFrame9;
                                            generatorState = generatorState6;
                                            uniqueTag = uniqueTag8;
                                            error13 = error12;
                                            obj14 = obj28;
                                            error14 = error13;
                                            obj30 = obj14;
                                            runtimeException = error14;
                                            objArr = obj30;
                                            if (obj2 != null) {
                                            }
                                        }
                                        break;
                                    case -6:
                                        objArr6 = objArr3;
                                        generatorState3 = generatorState;
                                        z = z2;
                                        obj4 = str16;
                                        iArr3 = iArr;
                                        dArr8 = dArr2;
                                        str3 = str4;
                                        objArr7 = objArr2;
                                        b35 = b2;
                                        callFrame3 = callFrame4;
                                        i = i2 - 1;
                                        if (!stack_boolean(callFrame3, i2)) {
                                            callFrame3.f4669pc += 2;
                                            objArr2 = objArr7;
                                            str2 = str3;
                                            callFrame4 = callFrame3;
                                            b2 = b35;
                                            str16 = obj4;
                                            z2 = z;
                                            iArr = iArr3;
                                            objArr3 = objArr6;
                                            dArr2 = dArr8;
                                            generatorState = generatorState3;
                                        } else {
                                            int i56 = i - 1;
                                            objArr7[i] = null;
                                            i = i56;
                                            dArr5 = dArr;
                                            b8 = b35;
                                            obj13 = obj4;
                                            byte[] bArr13 = bArr;
                                            dArr6 = dArr8;
                                            uniqueTag3 = uniqueTag9;
                                            bArr4 = bArr13;
                                            i9 = b8;
                                            if (z) {
                                            }
                                            i42 = getShort(bArr4, callFrame3.f4669pc);
                                            if (i42 == 0) {
                                            }
                                            if (z) {
                                            }
                                            i24 = i9;
                                            dArr2 = dArr6;
                                            objArr2 = objArr7;
                                            bArr = bArr4;
                                            str2 = str3;
                                            callFrame4 = callFrame3;
                                            z2 = z;
                                            iArr = iArr3;
                                            objArr3 = objArr6;
                                            str16 = obj13;
                                            b33 = i24;
                                            uniqueTag9 = uniqueTag3;
                                            dArr = dArr5;
                                            b2 = b33;
                                            generatorState = generatorState3;
                                        }
                                        break;
                                    case -5:
                                        objArr6 = objArr3;
                                        generatorState3 = generatorState;
                                        z = z2;
                                        obj4 = str16;
                                        iArr3 = iArr;
                                        dArr8 = dArr2;
                                        i43 = i2;
                                        str3 = str4;
                                        obj29 = null;
                                        objArr7 = objArr2;
                                        b35 = b2;
                                        callFrame3 = callFrame4;
                                        callFrame3.result = objArr7[i43];
                                        callFrame3.resultDbl = dArr8[i43];
                                        objArr7[i43] = null;
                                        i = i43 - 1;
                                        objArr2 = objArr7;
                                        str2 = str3;
                                        callFrame4 = callFrame3;
                                        b2 = b35;
                                        str16 = obj4;
                                        z2 = z;
                                        iArr = iArr3;
                                        objArr3 = objArr6;
                                        dArr2 = dArr8;
                                        generatorState = generatorState3;
                                    case -4:
                                        objArr6 = objArr3;
                                        generatorState3 = generatorState;
                                        z = z2;
                                        obj4 = str16;
                                        iArr3 = iArr;
                                        dArr8 = dArr2;
                                        i43 = i2;
                                        str3 = str4;
                                        obj29 = null;
                                        obj29 = null;
                                        objArr7 = objArr2;
                                        b35 = b2;
                                        callFrame3 = callFrame4;
                                        try {
                                            objArr7[i43] = null;
                                            i = i43 - 1;
                                            objArr2 = objArr7;
                                            str2 = str3;
                                            callFrame4 = callFrame3;
                                            b2 = b35;
                                            str16 = obj4;
                                            z2 = z;
                                            iArr = iArr3;
                                            objArr3 = objArr6;
                                            dArr2 = dArr8;
                                            generatorState = generatorState3;
                                        } catch (Throwable th29) {
                                            error11 = th29;
                                            uniqueTag = uniqueTag9;
                                            obj22 = obj29;
                                            str = str3;
                                            callFrame2 = callFrame3;
                                            generatorState = generatorState3;
                                            error13 = error11;
                                            obj14 = obj22;
                                            error14 = error13;
                                            obj30 = obj14;
                                            runtimeException = error14;
                                            objArr = obj30;
                                            if (obj2 != null) {
                                            }
                                        }
                                        break;
                                    case -3:
                                        objArr6 = objArr3;
                                        generatorState3 = generatorState;
                                        z = z2;
                                        obj4 = str16;
                                        iArr3 = iArr;
                                        double[] dArr32 = dArr2;
                                        str3 = str4;
                                        objArr7 = objArr2;
                                        byte b43 = b2;
                                        callFrame3 = callFrame4;
                                        Object obj49 = objArr7[i2];
                                        int i57 = i2 - 1;
                                        objArr7[i2] = objArr7[i57];
                                        objArr7[i57] = obj49;
                                        double d3 = dArr32[i2];
                                        dArr32[i2] = dArr32[i57];
                                        dArr32[i57] = d3;
                                        dArr5 = dArr;
                                        bArr3 = bArr;
                                        i5 = i2;
                                        uniqueTag = uniqueTag9;
                                        b4 = b43;
                                        dArr6 = dArr32;
                                        generatorState = generatorState3;
                                        i = i5;
                                        dArr2 = dArr6;
                                        b2 = b4;
                                        str2 = str3;
                                        callFrame4 = callFrame3;
                                        str16 = obj4;
                                        iArr = iArr3;
                                        objArr3 = objArr6;
                                        bArr = bArr3;
                                        uniqueTag9 = uniqueTag;
                                        objArr2 = objArr7;
                                        z2 = z;
                                        dArr = dArr5;
                                    case -2:
                                        objArr6 = objArr3;
                                        generatorState3 = generatorState;
                                        z = z2;
                                        obj4 = str16;
                                        iArr3 = iArr;
                                        dArr8 = dArr2;
                                        str3 = str4;
                                        objArr7 = objArr2;
                                        b35 = b2;
                                        callFrame3 = callFrame4;
                                        int i58 = i2 + 1;
                                        int i59 = i2 - 1;
                                        objArr7[i58] = objArr7[i59];
                                        dArr8[i58] = dArr8[i59];
                                        i = i2 + 2;
                                        objArr7[i] = objArr7[i2];
                                        dArr8[i] = dArr8[i2];
                                        objArr2 = objArr7;
                                        str2 = str3;
                                        callFrame4 = callFrame3;
                                        b2 = b35;
                                        str16 = obj4;
                                        z2 = z;
                                        iArr = iArr3;
                                        objArr3 = objArr6;
                                        dArr2 = dArr8;
                                        generatorState = generatorState3;
                                    case -1:
                                        objArr6 = objArr3;
                                        generatorState3 = generatorState;
                                        z = z2;
                                        obj4 = str16;
                                        iArr3 = iArr;
                                        dArr8 = dArr2;
                                        str3 = str4;
                                        objArr7 = objArr2;
                                        b35 = b2;
                                        callFrame3 = callFrame4;
                                        i = i2 + 1;
                                        objArr7[i] = objArr7[i2];
                                        dArr8[i] = dArr8[i2];
                                        objArr2 = objArr7;
                                        str2 = str3;
                                        callFrame4 = callFrame3;
                                        b2 = b35;
                                        str16 = obj4;
                                        z2 = z;
                                        iArr = iArr3;
                                        objArr3 = objArr6;
                                        dArr2 = dArr8;
                                        generatorState = generatorState3;
                                    case 0:
                                        objArr6 = objArr3;
                                        generatorState3 = generatorState;
                                        z = z2;
                                        obj4 = str16;
                                        iArr3 = iArr;
                                        dArr8 = dArr2;
                                        i13 = i2;
                                        str3 = str4;
                                        objArr7 = objArr2;
                                        b15 = b2;
                                        callFrame3 = callFrame4;
                                        try {
                                            b35 = b15;
                                            i = doDelName(context, callFrame3, b3, objArr7, dArr8, i13);
                                            objArr2 = objArr7;
                                            str2 = str3;
                                            callFrame4 = callFrame3;
                                            b2 = b35;
                                            str16 = obj4;
                                            z2 = z;
                                            iArr = iArr3;
                                            objArr3 = objArr6;
                                            dArr2 = dArr8;
                                            generatorState = generatorState3;
                                        } catch (Throwable th30) {
                                            th = th30;
                                            error15 = th;
                                            uniqueTag = uniqueTag9;
                                            str = str3;
                                            error7 = error15;
                                            callFrame2 = callFrame3;
                                            generatorState = generatorState3;
                                            error6 = error7;
                                            obj30 = null;
                                            error14 = error6;
                                            runtimeException = error14;
                                            objArr = obj30;
                                            if (obj2 != null) {
                                            }
                                        }
                                        break;
                                    default:
                                        switch (b3) {
                                            case 2:
                                                objArr6 = objArr3;
                                                generatorState3 = generatorState;
                                                z = z2;
                                                obj4 = str16;
                                                iArr3 = iArr;
                                                dArr8 = dArr2;
                                                str3 = str4;
                                                objArr7 = objArr2;
                                                b6 = b2;
                                                callFrame3 = callFrame4;
                                                Object obj50 = objArr7[i2];
                                                if (obj50 == uniqueTag9) {
                                                    obj50 = ScriptRuntime.wrapNumber(dArr8[i2]);
                                                }
                                                i8 = i2 - 1;
                                                callFrame3.scope = ScriptRuntime.enterWith(obj50, context, callFrame3.scope);
                                                i = i8;
                                                b9 = b6;
                                                b10 = b9;
                                                dArr2 = dArr8;
                                                objArr2 = objArr7;
                                                str2 = str3;
                                                callFrame4 = callFrame3;
                                                str16 = obj4;
                                                z2 = z;
                                                iArr = iArr3;
                                                objArr3 = objArr6;
                                                b2 = b10;
                                                generatorState = generatorState3;
                                            case 3:
                                                objArr6 = objArr3;
                                                generatorState4 = generatorState;
                                                z = z2;
                                                obj4 = str16;
                                                iArr3 = iArr;
                                                dArr9 = dArr2;
                                                i5 = i2;
                                                str3 = str4;
                                                objArr7 = objArr2;
                                                b7 = b2;
                                                callFrame3 = callFrame4;
                                                callFrame3.scope = ScriptRuntime.leaveWith(callFrame3.scope);
                                                dArr5 = dArr;
                                                bArr3 = bArr;
                                                uniqueTag = uniqueTag9;
                                                b4 = b7;
                                                dArr6 = dArr9;
                                                generatorState = generatorState4;
                                                i = i5;
                                                dArr2 = dArr6;
                                                b2 = b4;
                                                str2 = str3;
                                                callFrame4 = callFrame3;
                                                str16 = obj4;
                                                iArr = iArr3;
                                                objArr3 = objArr6;
                                                bArr = bArr3;
                                                uniqueTag9 = uniqueTag;
                                                objArr2 = objArr7;
                                                z2 = z;
                                                dArr = dArr5;
                                            case 4:
                                                callFrame3 = callFrame4;
                                                z = z2;
                                                obj4 = str16;
                                                str3 = str4;
                                                callFrame3.result = objArr2[i2];
                                                callFrame3.resultDbl = dArr2[i2];
                                                uniqueTag = uniqueTag9;
                                                generatorState = generatorState;
                                                b4 = b2;
                                                obj11 = null;
                                                break;
                                            case 5:
                                                objArr6 = objArr3;
                                                generatorState3 = generatorState;
                                                z = z2;
                                                Object obj51 = str16;
                                                iArr3 = iArr;
                                                str3 = str4;
                                                objArr7 = objArr2;
                                                callFrame3 = callFrame4;
                                                i = i2;
                                                i9 = b2;
                                                dArr5 = dArr;
                                                uniqueTag3 = uniqueTag9;
                                                obj13 = obj51;
                                                bArr4 = bArr;
                                                dArr6 = dArr2;
                                                if (z) {
                                                }
                                                i42 = getShort(bArr4, callFrame3.f4669pc);
                                                if (i42 == 0) {
                                                }
                                                if (z) {
                                                }
                                                i24 = i9;
                                                dArr2 = dArr6;
                                                objArr2 = objArr7;
                                                bArr = bArr4;
                                                str2 = str3;
                                                callFrame4 = callFrame3;
                                                z2 = z;
                                                iArr = iArr3;
                                                objArr3 = objArr6;
                                                str16 = obj13;
                                                b33 = i24;
                                                uniqueTag9 = uniqueTag3;
                                                dArr = dArr5;
                                                b2 = b33;
                                                generatorState = generatorState3;
                                                break;
                                            case 6:
                                                objArr6 = objArr3;
                                                generatorState3 = generatorState;
                                                z = z2;
                                                obj4 = str16;
                                                iArr3 = iArr;
                                                dArr8 = dArr2;
                                                str3 = str4;
                                                objArr7 = objArr2;
                                                b8 = b2;
                                                callFrame3 = callFrame4;
                                                i = i2 - 1;
                                                if (!stack_boolean(callFrame3, i2)) {
                                                    i10 = callFrame3.f4669pc;
                                                    i11 = 2;
                                                    callFrame3.f4669pc = i10 + i11;
                                                    b9 = b8;
                                                    b10 = b9;
                                                    dArr2 = dArr8;
                                                    objArr2 = objArr7;
                                                    str2 = str3;
                                                    callFrame4 = callFrame3;
                                                    str16 = obj4;
                                                    z2 = z;
                                                    iArr = iArr3;
                                                    objArr3 = objArr6;
                                                    b2 = b10;
                                                    generatorState = generatorState3;
                                                }
                                                dArr5 = dArr;
                                                obj13 = obj4;
                                                byte[] bArr132 = bArr;
                                                dArr6 = dArr8;
                                                uniqueTag3 = uniqueTag9;
                                                bArr4 = bArr132;
                                                i9 = b8;
                                                if (z) {
                                                }
                                                i42 = getShort(bArr4, callFrame3.f4669pc);
                                                if (i42 == 0) {
                                                }
                                                if (z) {
                                                }
                                                i24 = i9;
                                                dArr2 = dArr6;
                                                objArr2 = objArr7;
                                                bArr = bArr4;
                                                str2 = str3;
                                                callFrame4 = callFrame3;
                                                z2 = z;
                                                iArr = iArr3;
                                                objArr3 = objArr6;
                                                str16 = obj13;
                                                b33 = i24;
                                                uniqueTag9 = uniqueTag3;
                                                dArr = dArr5;
                                                b2 = b33;
                                                generatorState = generatorState3;
                                                break;
                                            case 7:
                                                objArr6 = objArr3;
                                                generatorState3 = generatorState;
                                                z = z2;
                                                obj4 = str16;
                                                iArr3 = iArr;
                                                dArr8 = dArr2;
                                                str3 = str4;
                                                objArr7 = objArr2;
                                                b8 = b2;
                                                callFrame3 = callFrame4;
                                                i = i2 - 1;
                                                if (stack_boolean(callFrame3, i2)) {
                                                    i10 = callFrame3.f4669pc;
                                                    i11 = 2;
                                                    callFrame3.f4669pc = i10 + i11;
                                                    b9 = b8;
                                                    b10 = b9;
                                                    dArr2 = dArr8;
                                                    objArr2 = objArr7;
                                                    str2 = str3;
                                                    callFrame4 = callFrame3;
                                                    str16 = obj4;
                                                    z2 = z;
                                                    iArr = iArr3;
                                                    objArr3 = objArr6;
                                                    b2 = b10;
                                                    generatorState = generatorState3;
                                                }
                                                dArr5 = dArr;
                                                obj13 = obj4;
                                                byte[] bArr1322 = bArr;
                                                dArr6 = dArr8;
                                                uniqueTag3 = uniqueTag9;
                                                bArr4 = bArr1322;
                                                i9 = b8;
                                                if (z) {
                                                }
                                                i42 = getShort(bArr4, callFrame3.f4669pc);
                                                if (i42 == 0) {
                                                }
                                                if (z) {
                                                }
                                                i24 = i9;
                                                dArr2 = dArr6;
                                                objArr2 = objArr7;
                                                bArr = bArr4;
                                                str2 = str3;
                                                callFrame4 = callFrame3;
                                                z2 = z;
                                                iArr = iArr3;
                                                objArr3 = objArr6;
                                                str16 = obj13;
                                                b33 = i24;
                                                uniqueTag9 = uniqueTag3;
                                                dArr = dArr5;
                                                b2 = b33;
                                                generatorState = generatorState3;
                                                break;
                                            case 8:
                                            case 74:
                                                objArr6 = objArr3;
                                                generatorState3 = generatorState;
                                                z = z2;
                                                obj4 = str16;
                                                iArr3 = iArr;
                                                dArr8 = dArr2;
                                                objArr7 = objArr2;
                                                b6 = b2;
                                                callFrame3 = callFrame4;
                                                try {
                                                    Object obj52 = objArr7[i2];
                                                    if (obj52 == uniqueTag9) {
                                                        obj52 = ScriptRuntime.wrapNumber(dArr8[i2]);
                                                    }
                                                    i8 = i2 - 1;
                                                    Scriptable scriptable6 = (Scriptable) objArr7[i8];
                                                    if (b3 == 8) {
                                                        str3 = str4;
                                                        strictSetName = ScriptRuntime.setName(scriptable6, obj52, context, callFrame3.scope, str3);
                                                    } else {
                                                        str3 = str4;
                                                        strictSetName = ScriptRuntime.strictSetName(scriptable6, obj52, context, callFrame3.scope, str3);
                                                    }
                                                    objArr7[i8] = strictSetName;
                                                    i = i8;
                                                    b9 = b6;
                                                    b10 = b9;
                                                    dArr2 = dArr8;
                                                    objArr2 = objArr7;
                                                    str2 = str3;
                                                    callFrame4 = callFrame3;
                                                    str16 = obj4;
                                                    z2 = z;
                                                    iArr = iArr3;
                                                    objArr3 = objArr6;
                                                    b2 = b10;
                                                    generatorState = generatorState3;
                                                } catch (Throwable th31) {
                                                    th = th31;
                                                    str3 = str4;
                                                    error15 = th;
                                                    uniqueTag = uniqueTag9;
                                                    str = str3;
                                                    error7 = error15;
                                                    callFrame2 = callFrame3;
                                                    generatorState = generatorState3;
                                                    error6 = error7;
                                                    obj30 = null;
                                                    error14 = error6;
                                                    runtimeException = error14;
                                                    objArr = obj30;
                                                    if (obj2 != null) {
                                                    }
                                                }
                                                break;
                                            case 9:
                                            case 10:
                                            case 11:
                                            case 18:
                                            case 19:
                                                objArr6 = objArr3;
                                                generatorState3 = generatorState;
                                                z = z2;
                                                obj4 = str16;
                                                iArr3 = iArr;
                                                dArr10 = dArr2;
                                                str7 = str4;
                                                objArr10 = objArr2;
                                                b11 = b2;
                                                callFrame3 = callFrame4;
                                                i = doBitOp(callFrame3, b3, objArr10, dArr10, i2);
                                                str2 = str7;
                                                b10 = b11;
                                                dArr2 = dArr10;
                                                objArr2 = objArr10;
                                                callFrame4 = callFrame3;
                                                str16 = obj4;
                                                z2 = z;
                                                iArr = iArr3;
                                                objArr3 = objArr6;
                                                b2 = b10;
                                                generatorState = generatorState3;
                                            case 12:
                                            case 13:
                                                objArr6 = objArr3;
                                                generatorState3 = generatorState;
                                                z = z2;
                                                obj4 = str16;
                                                iArr3 = iArr;
                                                dArr10 = dArr2;
                                                str7 = str4;
                                                objArr10 = objArr2;
                                                b11 = b2;
                                                callFrame3 = callFrame4;
                                                i = i2 - 1;
                                                objArr10[i] = ScriptRuntime.wrapBoolean(doEquals(objArr10, dArr10, i) ^ (b3 == 13));
                                                str2 = str7;
                                                b10 = b11;
                                                dArr2 = dArr10;
                                                objArr2 = objArr10;
                                                callFrame4 = callFrame3;
                                                str16 = obj4;
                                                z2 = z;
                                                iArr = iArr3;
                                                objArr3 = objArr6;
                                                b2 = b10;
                                                generatorState = generatorState3;
                                            case 14:
                                            case 15:
                                            case 16:
                                            case 17:
                                                objArr6 = objArr3;
                                                generatorState3 = generatorState;
                                                z = z2;
                                                obj4 = str16;
                                                iArr3 = iArr;
                                                dArr10 = dArr2;
                                                str7 = str4;
                                                objArr10 = objArr2;
                                                b11 = b2;
                                                callFrame3 = callFrame4;
                                                i = doCompare(callFrame3, b3, objArr10, dArr10, i2);
                                                str2 = str7;
                                                b10 = b11;
                                                dArr2 = dArr10;
                                                objArr2 = objArr10;
                                                callFrame4 = callFrame3;
                                                str16 = obj4;
                                                z2 = z;
                                                iArr = iArr3;
                                                objArr3 = objArr6;
                                                b2 = b10;
                                                generatorState = generatorState3;
                                            case 20:
                                                GeneratorState generatorState10 = generatorState;
                                                boolean z4 = z2;
                                                int[] iArr12 = iArr;
                                                double[] dArr33 = dArr2;
                                                Object[] objArr30 = objArr2;
                                                CallFrame callFrame12 = callFrame4;
                                                double stack_double = stack_double(callFrame12, i2 - 1);
                                                int i60 = i2 - 1;
                                                objArr30[i60] = uniqueTag9;
                                                dArr33[i60] = ScriptRuntime.toUint32(stack_double) >>> (stack_int32(callFrame12, i2) & 31);
                                                i = i60;
                                                b2 = b2;
                                                dArr2 = dArr33;
                                                objArr2 = objArr30;
                                                callFrame4 = callFrame12;
                                                str16 = str16;
                                                z2 = z4;
                                                iArr = iArr12;
                                                objArr3 = objArr3;
                                                generatorState = generatorState10;
                                                str2 = str4;
                                            case 21:
                                                objArr6 = objArr3;
                                                generatorState3 = generatorState;
                                                z = z2;
                                                obj4 = str16;
                                                iArr3 = iArr;
                                                dArr10 = dArr2;
                                                str7 = str4;
                                                objArr10 = objArr2;
                                                b11 = b2;
                                                callFrame3 = callFrame4;
                                                i = i2 - 1;
                                                doAdd(objArr10, dArr10, i, context);
                                                str2 = str7;
                                                b10 = b11;
                                                dArr2 = dArr10;
                                                objArr2 = objArr10;
                                                callFrame4 = callFrame3;
                                                str16 = obj4;
                                                z2 = z;
                                                iArr = iArr3;
                                                objArr3 = objArr6;
                                                b2 = b10;
                                                generatorState = generatorState3;
                                            case 22:
                                            case 23:
                                            case 24:
                                            case 25:
                                                objArr6 = objArr3;
                                                generatorState3 = generatorState;
                                                z = z2;
                                                obj4 = str16;
                                                iArr3 = iArr;
                                                dArr10 = dArr2;
                                                str7 = str4;
                                                objArr10 = objArr2;
                                                b11 = b2;
                                                callFrame3 = callFrame4;
                                                i = doArithmetic(callFrame3, b3, objArr10, dArr10, i2);
                                                str2 = str7;
                                                b10 = b11;
                                                dArr2 = dArr10;
                                                objArr2 = objArr10;
                                                callFrame4 = callFrame3;
                                                str16 = obj4;
                                                z2 = z;
                                                iArr = iArr3;
                                                objArr3 = objArr6;
                                                b2 = b10;
                                                generatorState = generatorState3;
                                            case 26:
                                                objArr6 = objArr3;
                                                generatorState4 = generatorState;
                                                z = z2;
                                                obj4 = str16;
                                                iArr3 = iArr;
                                                dArr9 = dArr2;
                                                i5 = i2;
                                                str8 = str4;
                                                objArr7 = objArr2;
                                                b7 = b2;
                                                callFrame3 = callFrame4;
                                                objArr7[i5] = ScriptRuntime.wrapBoolean(!stack_boolean(callFrame3, i5));
                                                str3 = str8;
                                                dArr5 = dArr;
                                                bArr3 = bArr;
                                                uniqueTag = uniqueTag9;
                                                b4 = b7;
                                                dArr6 = dArr9;
                                                generatorState = generatorState4;
                                                i = i5;
                                                dArr2 = dArr6;
                                                b2 = b4;
                                                str2 = str3;
                                                callFrame4 = callFrame3;
                                                str16 = obj4;
                                                iArr = iArr3;
                                                objArr3 = objArr6;
                                                bArr = bArr3;
                                                uniqueTag9 = uniqueTag;
                                                objArr2 = objArr7;
                                                z2 = z;
                                                dArr = dArr5;
                                            case 27:
                                                objArr6 = objArr3;
                                                generatorState4 = generatorState;
                                                z = z2;
                                                obj4 = str16;
                                                iArr3 = iArr;
                                                dArr9 = dArr2;
                                                i5 = i2;
                                                str8 = str4;
                                                objArr7 = objArr2;
                                                b7 = b2;
                                                callFrame3 = callFrame4;
                                                int stack_int32 = stack_int32(callFrame3, i5);
                                                objArr7[i5] = uniqueTag9;
                                                dArr9[i5] = ~stack_int32;
                                                str3 = str8;
                                                dArr5 = dArr;
                                                bArr3 = bArr;
                                                uniqueTag = uniqueTag9;
                                                b4 = b7;
                                                dArr6 = dArr9;
                                                generatorState = generatorState4;
                                                i = i5;
                                                dArr2 = dArr6;
                                                b2 = b4;
                                                str2 = str3;
                                                callFrame4 = callFrame3;
                                                str16 = obj4;
                                                iArr = iArr3;
                                                objArr3 = objArr6;
                                                bArr = bArr3;
                                                uniqueTag9 = uniqueTag;
                                                objArr2 = objArr7;
                                                z2 = z;
                                                dArr = dArr5;
                                            case 28:
                                            case 29:
                                                objArr6 = objArr3;
                                                generatorState4 = generatorState;
                                                z = z2;
                                                obj4 = str16;
                                                iArr3 = iArr;
                                                dArr9 = dArr2;
                                                i5 = i2;
                                                str8 = str4;
                                                objArr7 = objArr2;
                                                b7 = b2;
                                                callFrame3 = callFrame4;
                                                double stack_double2 = stack_double(callFrame3, i5);
                                                objArr7[i5] = uniqueTag9;
                                                if (b3 == 29) {
                                                    stack_double2 = -stack_double2;
                                                }
                                                dArr9[i5] = stack_double2;
                                                str3 = str8;
                                                dArr5 = dArr;
                                                bArr3 = bArr;
                                                uniqueTag = uniqueTag9;
                                                b4 = b7;
                                                dArr6 = dArr9;
                                                generatorState = generatorState4;
                                                i = i5;
                                                dArr2 = dArr6;
                                                b2 = b4;
                                                str2 = str3;
                                                callFrame4 = callFrame3;
                                                str16 = obj4;
                                                iArr = iArr3;
                                                objArr3 = objArr6;
                                                bArr = bArr3;
                                                uniqueTag9 = uniqueTag;
                                                objArr2 = objArr7;
                                                z2 = z;
                                                dArr = dArr5;
                                            case 30:
                                                objArr6 = objArr3;
                                                obj4 = str16;
                                                iArr3 = iArr;
                                                obj12 = null;
                                                Object[] objArr31 = objArr2;
                                                byte b44 = b2;
                                                callFrame3 = callFrame4;
                                                double[] dArr34 = dArr2;
                                                if (z2) {
                                                    context.instructionCount += 100;
                                                }
                                                int i61 = i2 - b44;
                                                try {
                                                    Object obj53 = objArr31[i61];
                                                    if (obj53 instanceof InterpretedFunction) {
                                                        InterpretedFunction interpretedFunction4 = (InterpretedFunction) obj53;
                                                        b12 = b44;
                                                        if (callFrame3.fnOrScript.securityDomain == interpretedFunction4.securityDomain) {
                                                            Scriptable createObject = interpretedFunction4.createObject(context, callFrame3.scope);
                                                            z = z2;
                                                            str9 = str4;
                                                            generatorState3 = generatorState;
                                                            try {
                                                                callFrame2 = initFrame(context, callFrame3.scope, createObject, objArr31, dArr34, i61 + 1, b12, interpretedFunction4, callFrame3);
                                                                objArr31[i61] = createObject;
                                                                callFrame3.savedStackTop = i61;
                                                                callFrame3.savedCallOp = b3;
                                                                str = str9;
                                                                obj15 = obj2;
                                                                b14 = b12;
                                                                str16 = obj4;
                                                                z2 = z;
                                                                generatorState = generatorState3;
                                                                break;
                                                            } catch (Throwable th32) {
                                                                str = str9;
                                                                error7 = th32;
                                                                uniqueTag = uniqueTag9;
                                                                callFrame2 = callFrame3;
                                                                generatorState = generatorState3;
                                                                error6 = error7;
                                                                obj30 = null;
                                                                error14 = error6;
                                                                runtimeException = error14;
                                                                objArr = obj30;
                                                                if (obj2 != null) {
                                                                }
                                                            }
                                                        } else {
                                                            generatorState3 = generatorState;
                                                            str9 = str4;
                                                            dArr11 = dArr34;
                                                            i12 = i61;
                                                            z = z2;
                                                        }
                                                    } else {
                                                        b12 = b44;
                                                        dArr11 = dArr34;
                                                        generatorState3 = generatorState;
                                                        z = z2;
                                                        str9 = str4;
                                                        i12 = i61;
                                                    }
                                                    if (!(obj53 instanceof Function)) {
                                                        if (obj53 == uniqueTag9) {
                                                            obj53 = ScriptRuntime.wrapNumber(dArr11[i12]);
                                                        }
                                                        throw ScriptRuntime.notFunctionError(obj53);
                                                        break;
                                                    } else {
                                                        double[] dArr35 = dArr11;
                                                        Function function = (Function) obj53;
                                                        if (!(function instanceof IdFunctionObject) || !NativeContinuation.isContinuationConstructor((IdFunctionObject) function)) {
                                                            b13 = b12;
                                                            objArr31[i12] = function.construct(context, callFrame3.scope, getArgsArray(objArr31, dArr35, i12 + 1, b13));
                                                        } else {
                                                            callFrame3.stack[i12] = captureContinuation(context, callFrame3.parentFrame, false);
                                                            b13 = b12;
                                                        }
                                                        str2 = str9;
                                                        b10 = b13;
                                                        dArr2 = dArr35;
                                                        objArr2 = objArr31;
                                                        i = i12;
                                                        callFrame4 = callFrame3;
                                                        str16 = obj4;
                                                        z2 = z;
                                                        iArr = iArr3;
                                                        objArr3 = objArr6;
                                                        b2 = b10;
                                                        generatorState = generatorState3;
                                                    }
                                                } catch (Throwable th33) {
                                                    str = str4;
                                                    error5 = th33;
                                                    z = z2;
                                                    uniqueTag = uniqueTag9;
                                                    callFrame2 = callFrame3;
                                                    obj14 = obj12;
                                                    error13 = error5;
                                                    error14 = error13;
                                                    obj30 = obj14;
                                                    runtimeException = error14;
                                                    objArr = obj30;
                                                    if (obj2 != null) {
                                                    }
                                                }
                                                break;
                                            case 31:
                                                objArr6 = objArr3;
                                                obj4 = str16;
                                                iArr3 = iArr;
                                                i13 = i2;
                                                callFrame3 = callFrame4;
                                                generatorState3 = generatorState;
                                                z = z2;
                                                dArr8 = dArr2;
                                                str3 = str4;
                                                objArr7 = objArr2;
                                                b15 = b2;
                                                b35 = b15;
                                                i = doDelName(context, callFrame3, b3, objArr7, dArr8, i13);
                                                objArr2 = objArr7;
                                                str2 = str3;
                                                callFrame4 = callFrame3;
                                                b2 = b35;
                                                str16 = obj4;
                                                z2 = z;
                                                iArr = iArr3;
                                                objArr3 = objArr6;
                                                dArr2 = dArr8;
                                                generatorState = generatorState3;
                                            case 32:
                                                objArr6 = objArr3;
                                                obj4 = str16;
                                                iArr3 = iArr;
                                                i5 = i2;
                                                str3 = str4;
                                                obj16 = null;
                                                objArr11 = objArr2;
                                                b16 = b2;
                                                callFrame3 = callFrame4;
                                                dArr12 = dArr2;
                                                Object obj54 = objArr11[i5];
                                                if (obj54 == uniqueTag9) {
                                                    obj54 = ScriptRuntime.wrapNumber(dArr12[i5]);
                                                }
                                                objArr11[i5] = ScriptRuntime.typeof(obj54);
                                                dArr5 = dArr;
                                                z = z2;
                                                uniqueTag = uniqueTag9;
                                                b4 = b16;
                                                objArr7 = objArr11;
                                                bArr3 = bArr;
                                                dArr6 = dArr12;
                                                i = i5;
                                                dArr2 = dArr6;
                                                b2 = b4;
                                                str2 = str3;
                                                callFrame4 = callFrame3;
                                                str16 = obj4;
                                                iArr = iArr3;
                                                objArr3 = objArr6;
                                                bArr = bArr3;
                                                uniqueTag9 = uniqueTag;
                                                objArr2 = objArr7;
                                                z2 = z;
                                                dArr = dArr5;
                                            case 33:
                                                objArr6 = objArr3;
                                                obj4 = str16;
                                                iArr3 = iArr;
                                                i5 = i2;
                                                str3 = str4;
                                                obj16 = null;
                                                objArr11 = objArr2;
                                                b16 = b2;
                                                callFrame3 = callFrame4;
                                                dArr12 = dArr2;
                                                Object obj55 = objArr11[i5];
                                                if (obj55 == uniqueTag9) {
                                                    obj55 = ScriptRuntime.wrapNumber(dArr12[i5]);
                                                }
                                                objArr11[i5] = ScriptRuntime.getObjectProp(obj55, str3, context, callFrame3.scope);
                                                dArr5 = dArr;
                                                z = z2;
                                                uniqueTag = uniqueTag9;
                                                b4 = b16;
                                                objArr7 = objArr11;
                                                bArr3 = bArr;
                                                dArr6 = dArr12;
                                                i = i5;
                                                dArr2 = dArr6;
                                                b2 = b4;
                                                str2 = str3;
                                                callFrame4 = callFrame3;
                                                str16 = obj4;
                                                iArr = iArr3;
                                                objArr3 = objArr6;
                                                bArr = bArr3;
                                                uniqueTag9 = uniqueTag;
                                                objArr2 = objArr7;
                                                z2 = z;
                                                dArr = dArr5;
                                            case 34:
                                                objArr6 = objArr3;
                                                obj4 = str16;
                                                iArr3 = iArr;
                                                i5 = i2;
                                                str3 = str4;
                                                obj16 = null;
                                                objArr11 = objArr2;
                                                b16 = b2;
                                                callFrame3 = callFrame4;
                                                dArr12 = dArr2;
                                                Object obj56 = objArr11[i5];
                                                if (obj56 == uniqueTag9) {
                                                    obj56 = ScriptRuntime.wrapNumber(dArr12[i5]);
                                                }
                                                objArr11[i5] = ScriptRuntime.getObjectPropNoWarn(obj56, str3, context, callFrame3.scope);
                                                dArr5 = dArr;
                                                z = z2;
                                                uniqueTag = uniqueTag9;
                                                b4 = b16;
                                                objArr7 = objArr11;
                                                bArr3 = bArr;
                                                dArr6 = dArr12;
                                                i = i5;
                                                dArr2 = dArr6;
                                                b2 = b4;
                                                str2 = str3;
                                                callFrame4 = callFrame3;
                                                str16 = obj4;
                                                iArr = iArr3;
                                                objArr3 = objArr6;
                                                bArr = bArr3;
                                                uniqueTag9 = uniqueTag;
                                                objArr2 = objArr7;
                                                z2 = z;
                                                dArr = dArr5;
                                            case 35:
                                                objArr8 = objArr3;
                                                obj4 = str16;
                                                iArr4 = iArr;
                                                str6 = str4;
                                                objArr9 = objArr2;
                                                i6 = b2;
                                                callFrame3 = callFrame4;
                                                dArr7 = dArr2;
                                                Object obj57 = objArr9[i2];
                                                if (obj57 == uniqueTag9) {
                                                    obj57 = ScriptRuntime.wrapNumber(dArr7[i2]);
                                                }
                                                i7 = i2 - 1;
                                                Object obj58 = objArr9[i7];
                                                if (obj58 == uniqueTag9) {
                                                    obj58 = ScriptRuntime.wrapNumber(dArr7[i7]);
                                                }
                                                objArr9[i7] = ScriptRuntime.setObjectProp(obj58, str6, obj57, context, callFrame3.scope);
                                                i = i7;
                                                b5 = i6;
                                                dArr2 = dArr7;
                                                str2 = str6;
                                                callFrame4 = callFrame3;
                                                str16 = obj4;
                                                iArr = iArr4;
                                                b2 = b5;
                                                objArr2 = objArr9;
                                                objArr3 = objArr8;
                                            case 36:
                                                objArr8 = objArr3;
                                                obj4 = str16;
                                                iArr4 = iArr;
                                                str6 = str4;
                                                objArr9 = objArr2;
                                                b5 = b2;
                                                callFrame3 = callFrame4;
                                                dArr7 = dArr2;
                                                i = doGetElem(context, callFrame3, objArr9, dArr7, i2);
                                                dArr2 = dArr7;
                                                str2 = str6;
                                                callFrame4 = callFrame3;
                                                str16 = obj4;
                                                iArr = iArr4;
                                                b2 = b5;
                                                objArr2 = objArr9;
                                                objArr3 = objArr8;
                                            case 37:
                                                objArr8 = objArr3;
                                                obj4 = str16;
                                                iArr4 = iArr;
                                                str6 = str4;
                                                objArr9 = objArr2;
                                                b5 = b2;
                                                callFrame3 = callFrame4;
                                                dArr7 = dArr2;
                                                i = doSetElem(context, callFrame3, objArr9, dArr7, i2);
                                                dArr2 = dArr7;
                                                str2 = str6;
                                                callFrame4 = callFrame3;
                                                str16 = obj4;
                                                iArr = iArr4;
                                                b2 = b5;
                                                objArr2 = objArr9;
                                                objArr3 = objArr8;
                                            case 38:
                                            case 71:
                                                objArr12 = objArr3;
                                                Object obj59 = str16;
                                                iArr5 = iArr;
                                                callFrame3 = callFrame4;
                                                dArr13 = dArr;
                                                generatorState3 = generatorState;
                                                z = z2;
                                                uniqueTag3 = uniqueTag9;
                                                i14 = i2;
                                                str3 = str4;
                                                obj17 = obj59;
                                                objArr5 = objArr2;
                                                bArr5 = bArr;
                                                dArr14 = dArr2;
                                                b17 = b2;
                                                if (!z) {
                                                }
                                                i21 = i14 - (b17 + 1);
                                                Callable callable4 = (Callable) objArr5[i21];
                                                Scriptable scriptable22 = (Scriptable) objArr5[i21 + 1];
                                                if (b3 != 71) {
                                                }
                                                i = i22;
                                                dArr2 = dArr14;
                                                i20 = b21;
                                                str2 = str3;
                                                callFrame4 = callFrame3;
                                                str16 = obj4;
                                                dArr = dArr13;
                                                iArr = iArr5;
                                                objArr3 = objArr12;
                                                generatorState = generatorState3;
                                                uniqueTag9 = uniqueTag4;
                                                b2 = i20;
                                                bArr = bArr2;
                                                objArr2 = objArr5;
                                                z2 = z;
                                                break;
                                            case 39:
                                                objArr8 = objArr3;
                                                obj4 = str16;
                                                iArr4 = iArr;
                                                str6 = str4;
                                                objArr9 = objArr2;
                                                b5 = b2;
                                                callFrame3 = callFrame4;
                                                dArr7 = dArr2;
                                                i = i2 + 1;
                                                objArr9[i] = ScriptRuntime.name(context, callFrame3.scope, str6);
                                                dArr2 = dArr7;
                                                str2 = str6;
                                                callFrame4 = callFrame3;
                                                str16 = obj4;
                                                iArr = iArr4;
                                                b2 = b5;
                                                objArr2 = objArr9;
                                                objArr3 = objArr8;
                                            case 40:
                                                objArr8 = objArr3;
                                                obj4 = str16;
                                                iArr4 = iArr;
                                                str6 = str4;
                                                objArr9 = objArr2;
                                                byte b45 = b2;
                                                callFrame3 = callFrame4;
                                                dArr7 = dArr2;
                                                i = i2 + 1;
                                                objArr9[i] = uniqueTag9;
                                                dArr7[i] = callFrame3.idata.itsDoubleTable[b45];
                                                b5 = b45;
                                                dArr2 = dArr7;
                                                str2 = str6;
                                                callFrame4 = callFrame3;
                                                str16 = obj4;
                                                iArr = iArr4;
                                                b2 = b5;
                                                objArr2 = objArr9;
                                                objArr3 = objArr8;
                                            case 41:
                                                objArr8 = objArr3;
                                                obj4 = str16;
                                                iArr4 = iArr;
                                                str6 = str4;
                                                objArr9 = objArr2;
                                                b5 = b2;
                                                callFrame3 = callFrame4;
                                                dArr7 = dArr2;
                                                i = i2 + 1;
                                                objArr9[i] = str6;
                                                dArr2 = dArr7;
                                                str2 = str6;
                                                callFrame4 = callFrame3;
                                                str16 = obj4;
                                                iArr = iArr4;
                                                b2 = b5;
                                                objArr2 = objArr9;
                                                objArr3 = objArr8;
                                            case 42:
                                                objArr8 = objArr3;
                                                obj4 = str16;
                                                iArr4 = iArr;
                                                str6 = str4;
                                                objArr9 = objArr2;
                                                b5 = b2;
                                                callFrame3 = callFrame4;
                                                dArr7 = dArr2;
                                                i = i2 + 1;
                                                obj12 = null;
                                                try {
                                                    objArr9[i] = null;
                                                    dArr2 = dArr7;
                                                    str2 = str6;
                                                    callFrame4 = callFrame3;
                                                    str16 = obj4;
                                                    iArr = iArr4;
                                                    b2 = b5;
                                                    objArr2 = objArr9;
                                                    objArr3 = objArr8;
                                                } catch (Throwable th34) {
                                                    error5 = th34;
                                                    z = z2;
                                                    uniqueTag = uniqueTag9;
                                                    str = str6;
                                                    callFrame2 = callFrame3;
                                                    obj14 = obj12;
                                                    error13 = error5;
                                                    error14 = error13;
                                                    obj30 = obj14;
                                                    runtimeException = error14;
                                                    objArr = obj30;
                                                    if (obj2 != null) {
                                                    }
                                                }
                                                break;
                                            case 43:
                                                objArr8 = objArr3;
                                                obj4 = str16;
                                                iArr4 = iArr;
                                                str6 = str4;
                                                objArr9 = objArr2;
                                                b5 = b2;
                                                callFrame3 = callFrame4;
                                                dArr7 = dArr2;
                                                i = i2 + 1;
                                                objArr9[i] = callFrame3.thisObj;
                                                dArr2 = dArr7;
                                                str2 = str6;
                                                callFrame4 = callFrame3;
                                                str16 = obj4;
                                                iArr = iArr4;
                                                b2 = b5;
                                                objArr2 = objArr9;
                                                objArr3 = objArr8;
                                            case 44:
                                                objArr8 = objArr3;
                                                obj4 = str16;
                                                iArr4 = iArr;
                                                str6 = str4;
                                                objArr9 = objArr2;
                                                b5 = b2;
                                                callFrame3 = callFrame4;
                                                dArr7 = dArr2;
                                                i = i2 + 1;
                                                objArr9[i] = Boolean.FALSE;
                                                dArr2 = dArr7;
                                                str2 = str6;
                                                callFrame4 = callFrame3;
                                                str16 = obj4;
                                                iArr = iArr4;
                                                b2 = b5;
                                                objArr2 = objArr9;
                                                objArr3 = objArr8;
                                            case 45:
                                                objArr8 = objArr3;
                                                obj4 = str16;
                                                iArr4 = iArr;
                                                str6 = str4;
                                                objArr9 = objArr2;
                                                b5 = b2;
                                                callFrame3 = callFrame4;
                                                dArr7 = dArr2;
                                                i = i2 + 1;
                                                objArr9[i] = Boolean.TRUE;
                                                dArr2 = dArr7;
                                                str2 = str6;
                                                callFrame4 = callFrame3;
                                                str16 = obj4;
                                                iArr = iArr4;
                                                b2 = b5;
                                                objArr2 = objArr9;
                                                objArr3 = objArr8;
                                            case 46:
                                            case 47:
                                                objArr8 = objArr3;
                                                obj4 = str16;
                                                iArr4 = iArr;
                                                str6 = str4;
                                                objArr9 = objArr2;
                                                b5 = b2;
                                                callFrame3 = callFrame4;
                                                dArr7 = dArr2;
                                                i = i2 - 1;
                                                objArr9[i] = ScriptRuntime.wrapBoolean(doShallowEquals(objArr9, dArr7, i) ^ (b3 == 47));
                                                dArr2 = dArr7;
                                                str2 = str6;
                                                callFrame4 = callFrame3;
                                                str16 = obj4;
                                                iArr = iArr4;
                                                b2 = b5;
                                                objArr2 = objArr9;
                                                objArr3 = objArr8;
                                            case 48:
                                                objArr8 = objArr3;
                                                obj4 = str16;
                                                iArr4 = iArr;
                                                str6 = str4;
                                                objArr9 = objArr2;
                                                i6 = b2;
                                                callFrame3 = callFrame4;
                                                dArr7 = dArr2;
                                                i7 = i2 + 1;
                                                objArr9[i7] = ScriptRuntime.wrapRegExp(context, callFrame3.scope, callFrame3.idata.itsRegExpLiterals[i6]);
                                                i = i7;
                                                b5 = i6;
                                                dArr2 = dArr7;
                                                str2 = str6;
                                                callFrame4 = callFrame3;
                                                str16 = obj4;
                                                iArr = iArr4;
                                                b2 = b5;
                                                objArr2 = objArr9;
                                                objArr3 = objArr8;
                                            case 49:
                                                objArr8 = objArr3;
                                                obj4 = str16;
                                                iArr4 = iArr;
                                                str6 = str4;
                                                objArr9 = objArr2;
                                                b5 = b2;
                                                callFrame3 = callFrame4;
                                                dArr7 = dArr2;
                                                i = i2 + 1;
                                                objArr9[i] = ScriptRuntime.bind(context, callFrame3.scope, str6);
                                                dArr2 = dArr7;
                                                str2 = str6;
                                                callFrame4 = callFrame3;
                                                str16 = obj4;
                                                iArr = iArr4;
                                                b2 = b5;
                                                objArr2 = objArr9;
                                                objArr3 = objArr8;
                                            case 50:
                                                callFrame3 = callFrame4;
                                                obj4 = str16;
                                                double[] dArr36 = dArr2;
                                                str11 = str4;
                                                Object obj60 = objArr2[i2];
                                                if (obj60 == uniqueTag9) {
                                                    obj60 = ScriptRuntime.wrapNumber(dArr36[i2]);
                                                }
                                                javaScriptException = new JavaScriptException(obj60, callFrame3.idata.itsSourceFile, getIndex(bArr, callFrame3.f4669pc));
                                                break;
                                            case 51:
                                                callFrame3 = callFrame4;
                                                obj4 = str16;
                                                str11 = str4;
                                                javaScriptException = objArr2[b2 + callFrame3.localShift];
                                                break;
                                            case 52:
                                            case 53:
                                                objArr8 = objArr3;
                                                obj4 = str16;
                                                iArr4 = iArr;
                                                str6 = str4;
                                                objArr9 = objArr2;
                                                b5 = b2;
                                                callFrame3 = callFrame4;
                                                dArr7 = dArr2;
                                                i = doInOrInstanceof(context, b3, objArr9, dArr7, i2);
                                                dArr2 = dArr7;
                                                str2 = str6;
                                                callFrame4 = callFrame3;
                                                str16 = obj4;
                                                iArr = iArr4;
                                                b2 = b5;
                                                objArr2 = objArr9;
                                                objArr3 = objArr8;
                                            case 54:
                                                Object[] objArr32 = objArr3;
                                                obj18 = str16;
                                                int[] iArr13 = iArr;
                                                str10 = str4;
                                                Object[] objArr33 = objArr2;
                                                byte b46 = b2;
                                                CallFrame callFrame13 = callFrame4;
                                                double[] dArr37 = dArr2;
                                                i = i2 + 1;
                                                int i62 = callFrame13.localShift + b46;
                                                objArr33[i] = objArr33[i62];
                                                dArr37[i] = dArr37[i62];
                                                dArr2 = dArr37;
                                                objArr2 = objArr33;
                                                callFrame4 = callFrame13;
                                                iArr = iArr13;
                                                objArr3 = objArr32;
                                                b2 = i62;
                                                str2 = str10;
                                                str16 = obj18;
                                            case 55:
                                                objArr6 = objArr3;
                                                Object obj61 = str16;
                                                iArr3 = iArr;
                                                callFrame3 = callFrame4;
                                                b18 = b2;
                                                dArr5 = dArr;
                                                generatorState3 = generatorState;
                                                z = z2;
                                                uniqueTag3 = uniqueTag9;
                                                i15 = i2;
                                                str3 = str4;
                                                obj13 = obj61;
                                                objArr7 = objArr2;
                                                bArr4 = bArr;
                                                dArr6 = dArr2;
                                                doSetVar = doGetVar(callFrame3, objArr7, dArr6, i15, objArr6, dArr5, b18);
                                                i24 = b18;
                                                i = doSetVar;
                                                dArr2 = dArr6;
                                                objArr2 = objArr7;
                                                bArr = bArr4;
                                                str2 = str3;
                                                callFrame4 = callFrame3;
                                                z2 = z;
                                                iArr = iArr3;
                                                objArr3 = objArr6;
                                                str16 = obj13;
                                                b33 = i24;
                                                uniqueTag9 = uniqueTag3;
                                                dArr = dArr5;
                                                b2 = b33;
                                                generatorState = generatorState3;
                                            case 56:
                                                objArr6 = objArr3;
                                                Object obj62 = str16;
                                                iArr3 = iArr;
                                                callFrame3 = callFrame4;
                                                b18 = b2;
                                                dArr5 = dArr;
                                                generatorState3 = generatorState;
                                                z = z2;
                                                uniqueTag3 = uniqueTag9;
                                                i16 = i2;
                                                str3 = str4;
                                                obj13 = obj62;
                                                objArr7 = objArr2;
                                                bArr4 = bArr;
                                                dArr6 = dArr2;
                                                doSetVar = doSetVar(callFrame3, objArr7, dArr6, i16, objArr6, dArr5, iArr3, b18);
                                                i24 = b18;
                                                i = doSetVar;
                                                dArr2 = dArr6;
                                                objArr2 = objArr7;
                                                bArr = bArr4;
                                                str2 = str3;
                                                callFrame4 = callFrame3;
                                                z2 = z;
                                                iArr = iArr3;
                                                objArr3 = objArr6;
                                                str16 = obj13;
                                                b33 = i24;
                                                uniqueTag9 = uniqueTag3;
                                                dArr = dArr5;
                                                b2 = b33;
                                                generatorState = generatorState3;
                                            case 57:
                                                objArr8 = objArr3;
                                                obj4 = str16;
                                                iArr4 = iArr;
                                                str6 = str4;
                                                objArr9 = objArr2;
                                                byte b47 = b2;
                                                callFrame3 = callFrame4;
                                                dArr7 = dArr2;
                                                i7 = i2 - 1;
                                                i6 = b47 + callFrame3.localShift;
                                                objArr9[i6] = ScriptRuntime.newCatchScope((Throwable) objArr9[i7 + 1], !(callFrame3.idata.itsICode[i3] != 0) ? null : (Scriptable) objArr9[i6], str6, context, callFrame3.scope);
                                                callFrame3.f4669pc++;
                                                i = i7;
                                                b5 = i6;
                                                dArr2 = dArr7;
                                                str2 = str6;
                                                callFrame4 = callFrame3;
                                                str16 = obj4;
                                                iArr = iArr4;
                                                b2 = b5;
                                                objArr2 = objArr9;
                                                objArr3 = objArr8;
                                            case 58:
                                            case 59:
                                            case 60:
                                            case 61:
                                                objArr8 = objArr3;
                                                obj4 = str16;
                                                iArr4 = iArr;
                                                str6 = str4;
                                                objArr9 = objArr2;
                                                byte b48 = b2;
                                                callFrame3 = callFrame4;
                                                dArr7 = dArr2;
                                                Object obj63 = objArr9[i2];
                                                if (obj63 == uniqueTag9) {
                                                    obj63 = ScriptRuntime.wrapNumber(dArr7[i2]);
                                                }
                                                i7 = i2 - 1;
                                                i6 = b48 + callFrame3.localShift;
                                                objArr9[i6] = ScriptRuntime.enumInit(obj63, context, callFrame3.scope, b3 == 58 ? 0 : b3 == 59 ? 1 : b3 == 61 ? 6 : 2);
                                                i = i7;
                                                b5 = i6;
                                                dArr2 = dArr7;
                                                str2 = str6;
                                                callFrame4 = callFrame3;
                                                str16 = obj4;
                                                iArr = iArr4;
                                                b2 = b5;
                                                objArr2 = objArr9;
                                                objArr3 = objArr8;
                                            case 62:
                                            case 63:
                                                Object[] objArr34 = objArr3;
                                                obj18 = str16;
                                                int[] iArr14 = iArr;
                                                str10 = str4;
                                                Object[] objArr35 = objArr2;
                                                byte b49 = b2;
                                                CallFrame callFrame14 = callFrame4;
                                                double[] dArr38 = dArr2;
                                                int i63 = callFrame14.localShift + b49;
                                                Object obj64 = objArr35[i63];
                                                int i64 = i2 + 1;
                                                objArr35[i64] = b3 == 62 ? ScriptRuntime.enumNext(obj64) : ScriptRuntime.enumId(obj64, context);
                                                dArr2 = dArr38;
                                                objArr2 = objArr35;
                                                callFrame4 = callFrame14;
                                                iArr = iArr14;
                                                objArr3 = objArr34;
                                                b2 = i63;
                                                i = i64;
                                                str2 = str10;
                                                str16 = obj18;
                                            case 64:
                                                objArr8 = objArr3;
                                                obj4 = str16;
                                                iArr4 = iArr;
                                                str6 = str4;
                                                objArr9 = objArr2;
                                                b5 = b2;
                                                callFrame3 = callFrame4;
                                                dArr7 = dArr2;
                                                i = i2 + 1;
                                                objArr9[i] = callFrame3.fnOrScript;
                                                dArr2 = dArr7;
                                                str2 = str6;
                                                callFrame4 = callFrame3;
                                                str16 = obj4;
                                                iArr = iArr4;
                                                b2 = b5;
                                                objArr2 = objArr9;
                                                objArr3 = objArr8;
                                            case 65:
                                                callFrame3 = callFrame4;
                                                obj4 = str16;
                                                z = z2;
                                                uniqueTag = uniqueTag9;
                                                str3 = str4;
                                                obj11 = null;
                                                b4 = b2;
                                                break;
                                            case 66:
                                            case 67:
                                                objArr6 = objArr3;
                                                Object obj65 = str16;
                                                iArr3 = iArr;
                                                callFrame3 = callFrame4;
                                                dArr5 = dArr;
                                                generatorState3 = generatorState;
                                                z = z2;
                                                uniqueTag3 = uniqueTag9;
                                                i17 = i2;
                                                str3 = str4;
                                                obj13 = obj65;
                                                objArr7 = objArr2;
                                                bArr4 = bArr;
                                                dArr6 = dArr2;
                                                b19 = b2;
                                                Object[] objArr262 = (Object[]) objArr7[i17];
                                                i23 = i17 - 1;
                                                int[] iArr102 = (int[]) objArr7[i23];
                                                if (b3 != 67) {
                                                }
                                                objArr7[i23] = newArrayLiteral;
                                                i9 = b19;
                                                i = i23;
                                                i24 = i9;
                                                dArr2 = dArr6;
                                                objArr2 = objArr7;
                                                bArr = bArr4;
                                                str2 = str3;
                                                callFrame4 = callFrame3;
                                                z2 = z;
                                                iArr = iArr3;
                                                objArr3 = objArr6;
                                                str16 = obj13;
                                                b33 = i24;
                                                uniqueTag9 = uniqueTag3;
                                                dArr = dArr5;
                                                b2 = b33;
                                                generatorState = generatorState3;
                                                break;
                                            case 68:
                                                objArr6 = objArr3;
                                                obj4 = str16;
                                                iArr3 = iArr;
                                                i5 = i2;
                                                str3 = str4;
                                                objArr13 = objArr2;
                                                b20 = b2;
                                                callFrame3 = callFrame4;
                                                dArr12 = dArr2;
                                                objArr13[i5] = ScriptRuntime.refGet((Ref) objArr13[i5], context);
                                                dArr5 = dArr;
                                                z = z2;
                                                objArr14 = objArr13;
                                                uniqueTag = uniqueTag9;
                                                b4 = b20;
                                                objArr7 = objArr14;
                                                bArr3 = bArr;
                                                dArr6 = dArr12;
                                                i = i5;
                                                dArr2 = dArr6;
                                                b2 = b4;
                                                str2 = str3;
                                                callFrame4 = callFrame3;
                                                str16 = obj4;
                                                iArr = iArr3;
                                                objArr3 = objArr6;
                                                bArr = bArr3;
                                                uniqueTag9 = uniqueTag;
                                                objArr2 = objArr7;
                                                z2 = z;
                                                dArr = dArr5;
                                            case 69:
                                                objArr8 = objArr3;
                                                obj4 = str16;
                                                iArr4 = iArr;
                                                str6 = str4;
                                                objArr9 = objArr2;
                                                i6 = b2;
                                                callFrame3 = callFrame4;
                                                dArr7 = dArr2;
                                                Object obj66 = objArr9[i2];
                                                if (obj66 == uniqueTag9) {
                                                    obj66 = ScriptRuntime.wrapNumber(dArr7[i2]);
                                                }
                                                i7 = i2 - 1;
                                                objArr9[i7] = ScriptRuntime.refSet((Ref) objArr9[i7], obj66, context, callFrame3.scope);
                                                i = i7;
                                                b5 = i6;
                                                dArr2 = dArr7;
                                                str2 = str6;
                                                callFrame4 = callFrame3;
                                                str16 = obj4;
                                                iArr = iArr4;
                                                b2 = b5;
                                                objArr2 = objArr9;
                                                objArr3 = objArr8;
                                            case 70:
                                                objArr6 = objArr3;
                                                obj4 = str16;
                                                iArr3 = iArr;
                                                i5 = i2;
                                                str3 = str4;
                                                objArr13 = objArr2;
                                                b20 = b2;
                                                callFrame3 = callFrame4;
                                                dArr12 = dArr2;
                                                objArr13[i5] = ScriptRuntime.refDel((Ref) objArr13[i5], context);
                                                dArr5 = dArr;
                                                z = z2;
                                                objArr14 = objArr13;
                                                uniqueTag = uniqueTag9;
                                                b4 = b20;
                                                objArr7 = objArr14;
                                                bArr3 = bArr;
                                                dArr6 = dArr12;
                                                i = i5;
                                                dArr2 = dArr6;
                                                b2 = b4;
                                                str2 = str3;
                                                callFrame4 = callFrame3;
                                                str16 = obj4;
                                                iArr = iArr3;
                                                objArr3 = objArr6;
                                                bArr = bArr3;
                                                uniqueTag9 = uniqueTag;
                                                objArr2 = objArr7;
                                                z2 = z;
                                                dArr = dArr5;
                                            case 72:
                                                objArr6 = objArr3;
                                                obj4 = str16;
                                                iArr3 = iArr;
                                                i5 = i2;
                                                str3 = str4;
                                                objArr13 = objArr2;
                                                b20 = b2;
                                                callFrame3 = callFrame4;
                                                dArr12 = dArr2;
                                                Object obj67 = objArr13[i5];
                                                if (obj67 == uniqueTag9) {
                                                    obj67 = ScriptRuntime.wrapNumber(dArr12[i5]);
                                                }
                                                objArr13[i5] = ScriptRuntime.specialRef(obj67, str3, context, callFrame3.scope);
                                                dArr5 = dArr;
                                                z = z2;
                                                objArr14 = objArr13;
                                                uniqueTag = uniqueTag9;
                                                b4 = b20;
                                                objArr7 = objArr14;
                                                bArr3 = bArr;
                                                dArr6 = dArr12;
                                                i = i5;
                                                dArr2 = dArr6;
                                                b2 = b4;
                                                str2 = str3;
                                                callFrame4 = callFrame3;
                                                str16 = obj4;
                                                iArr = iArr3;
                                                objArr3 = objArr6;
                                                bArr = bArr3;
                                                uniqueTag9 = uniqueTag;
                                                objArr2 = objArr7;
                                                z2 = z;
                                                dArr = dArr5;
                                            case 73:
                                                objArr6 = objArr3;
                                                obj4 = str16;
                                                iArr3 = iArr;
                                                callFrame3 = callFrame4;
                                                dArr5 = dArr;
                                                generatorState2 = generatorState;
                                                z = z2;
                                                uniqueTag = uniqueTag9;
                                                i5 = i2;
                                                str3 = str4;
                                                b4 = b2;
                                                objArr7 = objArr2;
                                                bArr3 = bArr;
                                                dArr6 = dArr2;
                                                obj9 = null;
                                                generatorState = generatorState2;
                                                if (callFrame3.frozen) {
                                                }
                                                th = th6;
                                                error4 = th;
                                                str = str3;
                                                obj8 = obj9;
                                                callFrame2 = callFrame3;
                                                runtimeException = error4;
                                                objArr = obj8;
                                                if (obj2 != null) {
                                                }
                                                break;
                                            case 75:
                                                objArr6 = objArr3;
                                                obj4 = str16;
                                                iArr3 = iArr;
                                                i18 = i2;
                                                str3 = str4;
                                                Object[] objArr36 = objArr2;
                                                b20 = b2;
                                                callFrame3 = callFrame4;
                                                dArr12 = dArr2;
                                                Object obj68 = objArr36[i18];
                                                Number number2 = obj68;
                                                if (obj68 == uniqueTag9) {
                                                    number2 = ScriptRuntime.wrapNumber(dArr12[i18]);
                                                }
                                                objArr36[i18] = ScriptRuntime.setDefaultNamespace(number2, context);
                                                objArr15 = objArr36;
                                                dArr5 = dArr;
                                                z = z2;
                                                i5 = i18;
                                                objArr14 = objArr15;
                                                uniqueTag = uniqueTag9;
                                                b4 = b20;
                                                objArr7 = objArr14;
                                                bArr3 = bArr;
                                                dArr6 = dArr12;
                                                i = i5;
                                                dArr2 = dArr6;
                                                b2 = b4;
                                                str2 = str3;
                                                callFrame4 = callFrame3;
                                                str16 = obj4;
                                                iArr = iArr3;
                                                objArr3 = objArr6;
                                                bArr = bArr3;
                                                uniqueTag9 = uniqueTag;
                                                objArr2 = objArr7;
                                                z2 = z;
                                                dArr = dArr5;
                                            case 76:
                                                objArr6 = objArr3;
                                                obj4 = str16;
                                                iArr3 = iArr;
                                                i18 = i2;
                                                str3 = str4;
                                                Object[] objArr37 = objArr2;
                                                b20 = b2;
                                                callFrame3 = callFrame4;
                                                dArr12 = dArr2;
                                                Object obj69 = objArr37[i18];
                                                objArr15 = objArr37;
                                                if (obj69 != uniqueTag9) {
                                                    objArr37[i18] = ScriptRuntime.escapeAttributeValue(obj69, context);
                                                    objArr15 = objArr37;
                                                }
                                                dArr5 = dArr;
                                                z = z2;
                                                i5 = i18;
                                                objArr14 = objArr15;
                                                uniqueTag = uniqueTag9;
                                                b4 = b20;
                                                objArr7 = objArr14;
                                                bArr3 = bArr;
                                                dArr6 = dArr12;
                                                i = i5;
                                                dArr2 = dArr6;
                                                b2 = b4;
                                                str2 = str3;
                                                callFrame4 = callFrame3;
                                                str16 = obj4;
                                                iArr = iArr3;
                                                objArr3 = objArr6;
                                                bArr = bArr3;
                                                uniqueTag9 = uniqueTag;
                                                objArr2 = objArr7;
                                                z2 = z;
                                                dArr = dArr5;
                                            case 77:
                                                objArr6 = objArr3;
                                                obj4 = str16;
                                                iArr3 = iArr;
                                                i18 = i2;
                                                str3 = str4;
                                                Object[] objArr38 = objArr2;
                                                b20 = b2;
                                                callFrame3 = callFrame4;
                                                dArr12 = dArr2;
                                                Object obj70 = objArr38[i18];
                                                objArr15 = objArr38;
                                                if (obj70 != uniqueTag9) {
                                                    objArr38[i18] = ScriptRuntime.escapeTextValue(obj70, context);
                                                    objArr15 = objArr38;
                                                }
                                                dArr5 = dArr;
                                                z = z2;
                                                i5 = i18;
                                                objArr14 = objArr15;
                                                uniqueTag = uniqueTag9;
                                                b4 = b20;
                                                objArr7 = objArr14;
                                                bArr3 = bArr;
                                                dArr6 = dArr12;
                                                i = i5;
                                                dArr2 = dArr6;
                                                b2 = b4;
                                                str2 = str3;
                                                callFrame4 = callFrame3;
                                                str16 = obj4;
                                                iArr = iArr3;
                                                objArr3 = objArr6;
                                                bArr = bArr3;
                                                uniqueTag9 = uniqueTag;
                                                objArr2 = objArr7;
                                                z2 = z;
                                                dArr = dArr5;
                                            case 78:
                                                objArr8 = objArr3;
                                                obj4 = str16;
                                                iArr4 = iArr;
                                                str6 = str4;
                                                objArr9 = objArr2;
                                                byte b50 = b2;
                                                callFrame3 = callFrame4;
                                                dArr7 = dArr2;
                                                i = doRefMember(context, objArr9, dArr7, i2, b50);
                                                b5 = b50;
                                                dArr2 = dArr7;
                                                str2 = str6;
                                                callFrame4 = callFrame3;
                                                str16 = obj4;
                                                iArr = iArr4;
                                                b2 = b5;
                                                objArr2 = objArr9;
                                                objArr3 = objArr8;
                                            case 79:
                                                objArr8 = objArr3;
                                                obj4 = str16;
                                                iArr4 = iArr;
                                                str6 = str4;
                                                objArr9 = objArr2;
                                                byte b51 = b2;
                                                callFrame3 = callFrame4;
                                                dArr7 = dArr2;
                                                i = doRefNsMember(context, objArr9, dArr7, i2, b51);
                                                b5 = b51;
                                                dArr2 = dArr7;
                                                str2 = str6;
                                                callFrame4 = callFrame3;
                                                str16 = obj4;
                                                iArr = iArr4;
                                                b2 = b5;
                                                objArr2 = objArr9;
                                                objArr3 = objArr8;
                                            case 80:
                                                objArr6 = objArr3;
                                                obj4 = str16;
                                                iArr3 = iArr;
                                                double[] dArr39 = dArr2;
                                                i18 = i2;
                                                str3 = str4;
                                                Object[] objArr39 = objArr2;
                                                byte b52 = b2;
                                                callFrame3 = callFrame4;
                                                Object obj71 = objArr39[i18];
                                                if (obj71 == uniqueTag9) {
                                                    dArr12 = dArr39;
                                                    number = ScriptRuntime.wrapNumber(dArr12[i18]);
                                                } else {
                                                    dArr12 = dArr39;
                                                    number = obj71;
                                                }
                                                b20 = b52;
                                                objArr39[i18] = ScriptRuntime.nameRef(number, context, callFrame3.scope, b20);
                                                objArr15 = objArr39;
                                                dArr5 = dArr;
                                                z = z2;
                                                i5 = i18;
                                                objArr14 = objArr15;
                                                uniqueTag = uniqueTag9;
                                                b4 = b20;
                                                objArr7 = objArr14;
                                                bArr3 = bArr;
                                                dArr6 = dArr12;
                                                i = i5;
                                                dArr2 = dArr6;
                                                b2 = b4;
                                                str2 = str3;
                                                callFrame4 = callFrame3;
                                                str16 = obj4;
                                                iArr = iArr3;
                                                objArr3 = objArr6;
                                                bArr = bArr3;
                                                uniqueTag9 = uniqueTag;
                                                objArr2 = objArr7;
                                                z2 = z;
                                                dArr = dArr5;
                                            case 81:
                                                double[] dArr40 = dArr2;
                                                obj4 = str16;
                                                str16 = str4;
                                                Object[] objArr40 = objArr2;
                                                byte b53 = b2;
                                                int[] iArr15 = iArr;
                                                iArr = callFrame4;
                                                objArr8 = objArr3;
                                                try {
                                                    i = doRefNsName(context, callFrame4, objArr2, dArr40, i2, b53);
                                                    str2 = str16;
                                                    callFrame4 = iArr;
                                                    b2 = b53;
                                                    str16 = obj4;
                                                    dArr2 = dArr40;
                                                    objArr2 = objArr40;
                                                    iArr = iArr15;
                                                    objArr3 = objArr8;
                                                } catch (Throwable th35) {
                                                    error6 = th35;
                                                    z = z2;
                                                    uniqueTag = uniqueTag9;
                                                    str = str16;
                                                    callFrame2 = iArr;
                                                    obj30 = null;
                                                    error14 = error6;
                                                    runtimeException = error14;
                                                    objArr = obj30;
                                                    if (obj2 != null) {
                                                    }
                                                }
                                                break;
                                            default:
                                                try {
                                                    dumpICode(callFrame4.idata);
                                                    throw new RuntimeException("Unknown icode : " + ((int) b3) + " @ pc : " + (callFrame4.f4669pc - 1));
                                                    break;
                                                } catch (Throwable th36) {
                                                    error6 = th36;
                                                    callFrame2 = callFrame4;
                                                    z = z2;
                                                    uniqueTag = uniqueTag9;
                                                    obj4 = str16;
                                                    str = str4;
                                                    obj30 = null;
                                                    error14 = error6;
                                                    runtimeException = error14;
                                                    objArr = obj30;
                                                    if (obj2 != null) {
                                                    }
                                                }
                                                break;
                                        }
                                        break;
                                }
                                break;
                        }
                    } else {
                        objArr4 = objArr3;
                        dArr3 = dArr;
                        z = z2;
                        uniqueTag2 = uniqueTag9;
                        obj10 = str16;
                        iArr2 = iArr;
                        i4 = i2;
                        str5 = str4;
                        objArr5 = objArr2;
                        callFrame5 = callFrame4;
                        bArr2 = bArr;
                        dArr4 = dArr2;
                    }
                    i = doSetConstVar(callFrame5, objArr5, dArr4, i4, objArr4, dArr3, iArr2, b2);
                    uniqueTag9 = uniqueTag2;
                    dArr2 = dArr4;
                    str2 = str5;
                    callFrame4 = callFrame5;
                    str16 = obj10;
                    dArr = dArr3;
                    iArr = iArr2;
                    objArr3 = objArr4;
                    b2 = b2;
                    bArr = bArr2;
                    objArr2 = objArr5;
                    z2 = z;
                }
                obj32 = null;
                obj31 = obj15;
                b = b14;
            }
        } else {
            callFrame2 = callFrame;
            if (!(obj31 instanceof ContinuationJump)) {
                Kit.codeBug();
            }
        }
        generatorState = null;
        str = null;
        Object obj332 = null;
        double d22 = 0.0d;
        b = -1;
        while (true) {
            if (obj31 == null) {
            }
            obj2 = obj31;
            callFrame4 = callFrame2;
            objArr2 = callFrame4.stack;
            double[] dArr242 = callFrame4.sDbl;
            objArr3 = callFrame4.varSource.stack;
            dArr = callFrame4.varSource.sDbl;
            iArr = callFrame4.varSource.stackAttributes;
            bArr = callFrame4.idata.itsICode;
            strArr = callFrame4.idata.itsStringTable;
            dArr2 = dArr242;
            i = callFrame4.savedStackTop;
            context.lastInterpreterFrame = callFrame4;
            String str172 = str;
            b2 = b;
            str2 = str172;
            while (true) {
                int i442 = callFrame4.f4669pc;
                i2 = i;
                i3 = i442 + 1;
                callFrame4.f4669pc = i3;
                b3 = bArr[i442];
                str4 = str2;
                if (b3 == 157) {
                }
                i = doSetConstVar(callFrame5, objArr5, dArr4, i4, objArr4, dArr3, iArr2, b2);
                uniqueTag9 = uniqueTag2;
                dArr2 = dArr4;
                str2 = str5;
                callFrame4 = callFrame5;
                str16 = obj10;
                dArr = dArr3;
                iArr = iArr2;
                objArr3 = objArr4;
                b2 = b2;
                bArr = bArr2;
                objArr2 = objArr5;
                z2 = z;
            }
            obj32 = null;
            obj31 = obj15;
            b = b14;
        }
        DebugFrame debugFrame = callFrame3.debuggerFrame;
        if (debugFrame != null && (error2 instanceof RuntimeException)) {
            try {
                debugFrame.onExceptionThrown(context, error2);
            } catch (Throwable th37) {
                runtimeException3 = th37;
                Object obj72 = obj6;
                c2 = 0;
                while (true) {
                    if (c2 != 0) {
                        int exceptionHandler = getExceptionHandler(callFrame3, c2 != 2);
                        if (exceptionHandler >= 0) {
                            obj32 = obj6;
                            uniqueTag9 = uniqueTag;
                            b = exceptionHandler;
                            callFrame2 = callFrame3;
                            str16 = obj4;
                            z2 = z;
                            obj31 = runtimeException3;
                        }
                    }
                    exitFrame(context, callFrame3, runtimeException3);
                    callFrame3 = callFrame3.parentFrame;
                    if (callFrame3 != null) {
                        if (obj72 != null) {
                            if (obj72.branchFrame != null) {
                                Kit.codeBug();
                            }
                            if (obj72.capturedFrame == null) {
                                obj5 = obj72.result;
                                d = obj72.resultDbl;
                                runtimeException2 = obj6;
                                r6 = obj6;
                            }
                        } else {
                            runtimeException2 = runtimeException3;
                            obj5 = obj332;
                            d = d22;
                            r6 = obj6;
                        }
                    } else if (obj72 == null || obj72.branchFrame != callFrame3) {
                    }
                }
            }
        }
        c2 = c;
        runtimeException3 = error2;
        while (true) {
            if (c2 != 0) {
            }
            exitFrame(context, callFrame3, runtimeException3);
            callFrame3 = callFrame3.parentFrame;
            if (callFrame3 != null) {
            }
        }
    }

    public static CallFrame processThrowable(Context context, Object obj, CallFrame callFrame, int i, boolean z) {
        if (i >= 0) {
            if (callFrame.frozen) {
                callFrame = callFrame.cloneFrozen();
            }
            int[] iArr = callFrame.idata.itsExceptionTable;
            int i2 = iArr[i + 2];
            callFrame.f4669pc = i2;
            if (z) {
                callFrame.pcPrevBranch = i2;
            }
            callFrame.savedStackTop = callFrame.emptyStackTop;
            int i3 = callFrame.localShift;
            int i4 = iArr[i + 5] + i3;
            int i5 = i3 + iArr[i + 4];
            Object[] objArr = callFrame.stack;
            callFrame.scope = (Scriptable) objArr[i4];
            objArr[i5] = obj;
        } else {
            ContinuationJump continuationJump = (ContinuationJump) obj;
            if (continuationJump.branchFrame != callFrame) {
                Kit.codeBug();
            }
            if (continuationJump.capturedFrame == null) {
                Kit.codeBug();
            }
            int i6 = continuationJump.capturedFrame.frameIndex + 1;
            CallFrame callFrame2 = continuationJump.branchFrame;
            if (callFrame2 != null) {
                i6 -= callFrame2.frameIndex;
            }
            CallFrame callFrame3 = continuationJump.capturedFrame;
            CallFrame[] callFrameArr = null;
            int i7 = 0;
            for (int i8 = 0; i8 != i6; i8++) {
                if (!callFrame3.frozen) {
                    Kit.codeBug();
                }
                if (callFrame3.useActivation) {
                    if (callFrameArr == null) {
                        callFrameArr = new CallFrame[i6 - i8];
                    }
                    callFrameArr[i7] = callFrame3;
                    i7++;
                }
                callFrame3 = callFrame3.parentFrame;
            }
            while (i7 != 0) {
                i7--;
                enterFrame(context, callFrameArr[i7], ScriptRuntime.emptyArgs, true);
            }
            callFrame = continuationJump.capturedFrame.cloneFrozen();
            setCallResult(callFrame, continuationJump.result, continuationJump.resultDbl);
        }
        callFrame.throwable = null;
        return callFrame;
    }

    public static Object restartContinuation(NativeContinuation nativeContinuation, Context context, Scriptable scriptable, Object[] objArr) {
        if (!ScriptRuntime.hasTopCall(context)) {
            return ScriptRuntime.doTopCall(nativeContinuation, context, scriptable, null, objArr, context.isTopLevelStrict);
        }
        Object obj = objArr.length == 0 ? Undefined.instance : objArr[0];
        if (((CallFrame) nativeContinuation.getImplementation()) == null) {
            return obj;
        }
        ContinuationJump continuationJump = new ContinuationJump(nativeContinuation, null);
        continuationJump.result = obj;
        return interpretLoop(context, null, continuationJump);
    }

    public static Object resumeGenerator(Context context, Scriptable scriptable, int i, Object obj, Object obj2) {
        CallFrame callFrame = (CallFrame) obj;
        GeneratorState generatorState = new GeneratorState(i, obj2);
        if (i == 2) {
            try {
                return interpretLoop(context, callFrame, generatorState);
            } catch (RuntimeException e) {
                if (e != obj2) {
                    throw e;
                }
                return Undefined.instance;
            }
        }
        Object interpretLoop = interpretLoop(context, callFrame, generatorState);
        RuntimeException runtimeException = generatorState.returnedException;
        if (runtimeException != null) {
            throw runtimeException;
        }
        return interpretLoop;
    }

    public static void setCallResult(CallFrame callFrame, Object obj, double d) {
        int i = callFrame.savedCallOp;
        if (i == 38) {
            Object[] objArr = callFrame.stack;
            int i2 = callFrame.savedStackTop;
            objArr[i2] = obj;
            callFrame.sDbl[i2] = d;
        } else if (i != 30) {
            Kit.codeBug();
        } else if (obj instanceof Scriptable) {
            callFrame.stack[callFrame.savedStackTop] = obj;
        }
        callFrame.savedCallOp = 0;
    }

    public static boolean stack_boolean(CallFrame callFrame, int i) {
        Object obj = callFrame.stack[i];
        if (obj == Boolean.TRUE) {
            return true;
        }
        if (obj == Boolean.FALSE) {
            return false;
        }
        if (obj == UniqueTag.DOUBLE_MARK) {
            double d = callFrame.sDbl[i];
            return d == d && d != RoundRectDrawableWithShadow.COS_45;
        } else if (obj == null || obj == Undefined.instance) {
            return false;
        } else {
            if (!(obj instanceof Number)) {
                return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : ScriptRuntime.toBoolean(obj);
            }
            double doubleValue = ((Number) obj).doubleValue();
            return doubleValue == doubleValue && doubleValue != RoundRectDrawableWithShadow.COS_45;
        }
    }

    public static double stack_double(CallFrame callFrame, int i) {
        Object obj = callFrame.stack[i];
        return obj != UniqueTag.DOUBLE_MARK ? ScriptRuntime.toNumber(obj) : callFrame.sDbl[i];
    }

    public static int stack_int32(CallFrame callFrame, int i) {
        Object obj = callFrame.stack[i];
        return obj == UniqueTag.DOUBLE_MARK ? ScriptRuntime.toInt32(callFrame.sDbl[i]) : ScriptRuntime.toInt32(obj);
    }

    public static Object thawGenerator(CallFrame callFrame, int i, GeneratorState generatorState, int i2) {
        callFrame.frozen = false;
        int index = getIndex(callFrame.idata.itsICode, callFrame.f4669pc);
        callFrame.f4669pc += 2;
        int i3 = generatorState.operation;
        if (i3 == 1) {
            return new JavaScriptException(generatorState.value, callFrame.idata.itsSourceFile, index);
        }
        if (i3 == 2) {
            return generatorState.value;
        }
        if (i3 != 0) {
            throw Kit.codeBug();
        }
        if (i2 == 73) {
            callFrame.stack[i] = generatorState.value;
        }
        return Scriptable.NOT_FOUND;
    }

    @Override // org.mozilla.javascript.Evaluator
    public void captureStackInfo(RhinoException rhinoException) {
        CallFrame[] callFrameArr;
        Context currentContext = Context.getCurrentContext();
        if (currentContext == null || currentContext.lastInterpreterFrame == null) {
            rhinoException.interpreterStackInfo = null;
            rhinoException.interpreterLineData = null;
            return;
        }
        ObjArray objArray = currentContext.previousInterpreterInvocations;
        if (objArray == null || objArray.size() == 0) {
            callFrameArr = new CallFrame[1];
        } else {
            int size = currentContext.previousInterpreterInvocations.size();
            if (currentContext.previousInterpreterInvocations.peek() == currentContext.lastInterpreterFrame) {
                size--;
            }
            callFrameArr = new CallFrame[size + 1];
            currentContext.previousInterpreterInvocations.toArray(callFrameArr);
        }
        callFrameArr[callFrameArr.length - 1] = (CallFrame) currentContext.lastInterpreterFrame;
        int i = 0;
        for (int i2 = 0; i2 != callFrameArr.length; i2++) {
            i += callFrameArr[i2].frameIndex + 1;
        }
        int[] iArr = new int[i];
        int length = callFrameArr.length;
        while (length != 0) {
            length--;
            for (CallFrame callFrame = callFrameArr[length]; callFrame != null; callFrame = callFrame.parentFrame) {
                i--;
                iArr[i] = callFrame.pcSourceLineStart;
            }
        }
        if (i != 0) {
            Kit.codeBug();
        }
        rhinoException.interpreterStackInfo = callFrameArr;
        rhinoException.interpreterLineData = iArr;
    }

    @Override // org.mozilla.javascript.Evaluator
    public Object compile(CompilerEnvirons compilerEnvirons, ScriptNode scriptNode, String str, boolean z) {
        InterpreterData compile = new CodeGenerator().compile(compilerEnvirons, scriptNode, str, z);
        this.itsData = compile;
        return compile;
    }

    @Override // org.mozilla.javascript.Evaluator
    public Function createFunctionObject(Context context, Scriptable scriptable, Object obj, Object obj2) {
        if (obj != this.itsData) {
            Kit.codeBug();
        }
        return InterpretedFunction.createFunction(context, scriptable, this.itsData, obj2);
    }

    @Override // org.mozilla.javascript.Evaluator
    public Script createScriptObject(Object obj, Object obj2) {
        if (obj != this.itsData) {
            Kit.codeBug();
        }
        return InterpretedFunction.createScript(this.itsData, obj2);
    }

    @Override // org.mozilla.javascript.Evaluator
    public String getPatchedStack(RhinoException rhinoException, String str) {
        char charAt;
        StringBuilder sb = new StringBuilder(str.length() + 1000);
        String systemProperty = SecurityUtilities.getSystemProperty("line.separator");
        CallFrame[] callFrameArr = (CallFrame[]) rhinoException.interpreterStackInfo;
        int[] iArr = rhinoException.interpreterLineData;
        int length = callFrameArr.length;
        int length2 = iArr.length;
        int i = 0;
        while (length != 0) {
            length--;
            int indexOf = str.indexOf("org.mozilla.javascript.Interpreter.interpretLoop", i);
            if (indexOf < 0) {
                break;
            }
            int i2 = indexOf + 48;
            while (i2 != str.length() && (charAt = str.charAt(i2)) != '\n' && charAt != '\r') {
                i2++;
            }
            sb.append(str.substring(i, i2));
            for (CallFrame callFrame = callFrameArr[length]; callFrame != null; callFrame = callFrame.parentFrame) {
                if (length2 == 0) {
                    Kit.codeBug();
                }
                length2--;
                InterpreterData interpreterData = callFrame.idata;
                sb.append(systemProperty);
                sb.append("\tat script");
                String str2 = interpreterData.itsName;
                if (str2 != null && str2.length() != 0) {
                    sb.append('.');
                    sb.append(interpreterData.itsName);
                }
                sb.append('(');
                sb.append(interpreterData.itsSourceFile);
                int i3 = iArr[length2];
                if (i3 >= 0) {
                    sb.append(':');
                    sb.append(getIndex(interpreterData.itsICode, i3));
                }
                sb.append(')');
            }
            i = i2;
        }
        sb.append(str.substring(i));
        return sb.toString();
    }

    @Override // org.mozilla.javascript.Evaluator
    public List<String> getScriptStack(RhinoException rhinoException) {
        ScriptStackElement[][] scriptStackElements = getScriptStackElements(rhinoException);
        ArrayList arrayList = new ArrayList(scriptStackElements.length);
        String systemProperty = SecurityUtilities.getSystemProperty("line.separator");
        for (ScriptStackElement[] scriptStackElementArr : scriptStackElements) {
            StringBuilder sb = new StringBuilder();
            for (ScriptStackElement scriptStackElement : scriptStackElementArr) {
                scriptStackElement.renderJavaStyle(sb);
                sb.append(systemProperty);
            }
            arrayList.add(sb.toString());
        }
        return arrayList;
    }

    public ScriptStackElement[][] getScriptStackElements(RhinoException rhinoException) {
        if (rhinoException.interpreterStackInfo == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        CallFrame[] callFrameArr = (CallFrame[]) rhinoException.interpreterStackInfo;
        int[] iArr = rhinoException.interpreterLineData;
        int length = callFrameArr.length;
        int length2 = iArr.length;
        while (length != 0) {
            length--;
            CallFrame callFrame = callFrameArr[length];
            ArrayList arrayList2 = new ArrayList();
            while (callFrame != null) {
                if (length2 == 0) {
                    Kit.codeBug();
                }
                length2--;
                InterpreterData interpreterData = callFrame.idata;
                String str = interpreterData.itsSourceFile;
                int i = iArr[length2];
                int index = i >= 0 ? getIndex(interpreterData.itsICode, i) : -1;
                String str2 = interpreterData.itsName;
                String str3 = (str2 == null || str2.length() == 0) ? null : interpreterData.itsName;
                callFrame = callFrame.parentFrame;
                arrayList2.add(new ScriptStackElement(str, str3, index));
            }
            arrayList.add(arrayList2.toArray(new ScriptStackElement[arrayList2.size()]));
        }
        return (ScriptStackElement[][]) arrayList.toArray(new ScriptStackElement[arrayList.size()]);
    }

    @Override // org.mozilla.javascript.Evaluator
    public String getSourcePositionFromStack(Context context, int[] iArr) {
        CallFrame callFrame = (CallFrame) context.lastInterpreterFrame;
        InterpreterData interpreterData = callFrame.idata;
        int i = callFrame.pcSourceLineStart;
        if (i >= 0) {
            iArr[0] = getIndex(interpreterData.itsICode, i);
        } else {
            iArr[0] = 0;
        }
        return interpreterData.itsSourceFile;
    }

    @Override // org.mozilla.javascript.Evaluator
    public void setEvalScriptFlag(Script script) {
        ((InterpretedFunction) script).idata.evalScriptFlag = true;
    }
}
