package org.mozilla.javascript.optimizer;

import androidx.cardview.widget.RoundRectDrawableWithShadow;
import androidx.core.app.NotificationCompat;
import androidx.core.location.GpsStatusWrapper;
import com.arialyy.aria.core.command.NormalCmdFactory;
import com.lzf.easyfloat.permission.PermissionUtils;
import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import me.tvspark.outline;
import org.mozilla.classfile.ClassFileWriter;
import org.mozilla.javascript.CompilerEnvirons;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Kit;
import org.mozilla.javascript.Node;
import org.mozilla.javascript.Token;
import org.mozilla.javascript.ast.FunctionNode;
import org.mozilla.javascript.ast.Jump;
import org.mozilla.javascript.ast.ScriptNode;
import org.mozilla.javascript.optimizer.OptRuntime;

/* loaded from: classes5.dex */
public class BodyCodegen {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int ECMAERROR_EXCEPTION = 2;
    public static final int EVALUATOR_EXCEPTION = 1;
    public static final int EXCEPTION_MAX = 5;
    public static final int FINALLY_EXCEPTION = 4;
    public static final int GENERATOR_START = 0;
    public static final int GENERATOR_TERMINATE = -1;
    public static final int GENERATOR_YIELD_START = 1;
    public static final int JAVASCRIPT_EXCEPTION = 0;
    public static final int MAX_LOCALS = 1024;
    public static final int THROWABLE_EXCEPTION = 3;
    public short argsLocal;
    public ClassFileWriter cfw;
    public Codegen codegen;
    public CompilerEnvirons compilerEnv;
    public short contextLocal;
    public int enterAreaStartLabel;
    public int epilogueLabel;
    public Map<Node, FinallyReturnPoint> finallys;
    public short firstFreeLocal;
    public OptFunctionNode fnCurrent;
    public short funObjLocal;
    public short generatorStateLocal;
    public int generatorSwitch;
    public boolean hasVarsInRegs;
    public boolean inDirectCallFunction;
    public boolean inLocalBlock;
    public boolean isGenerator;
    public boolean itsForcedObjectParameters;
    public int itsLineNumber;
    public short itsOneArgArray;
    public short itsZeroArgArray;
    public List<Node> literals;
    public int[] locals;
    public short localsMax;
    public short operationLocal;
    public short popvLocal;
    public int savedCodeOffset;
    public ScriptNode scriptOrFn;
    public int scriptOrFnIndex;
    public short thisObjLocal;
    public short[] varRegisters;
    public short variableObjectLocal;
    public ExceptionManager exceptionManager = new ExceptionManager();
    public int maxLocals = 0;
    public int maxStack = 0;

    /* loaded from: classes5.dex */
    public class ExceptionManager {
        public LinkedList<ExceptionInfo> exceptionInfo = new LinkedList<>();

        /* loaded from: classes5.dex */
        public class ExceptionInfo {
            public Node finallyBlock;
            public int[] handlerLabels = new int[5];
            public int[] exceptionStarts = new int[5];
            public Node currentFinally = null;

            public ExceptionInfo(Jump jump, Node node) {
                this.finallyBlock = node;
            }
        }

        public ExceptionManager() {
        }

        private void endCatch(ExceptionInfo exceptionInfo, int i, int i2) {
            int[] iArr = exceptionInfo.exceptionStarts;
            if (iArr[i] != 0) {
                if (BodyCodegen.this.cfw.Wwwwwwwwwwwwwwwwwwww(iArr[i]) == BodyCodegen.this.cfw.Wwwwwwwwwwwwwwwwwwww(i2)) {
                    return;
                }
                BodyCodegen bodyCodegen = BodyCodegen.this;
                bodyCodegen.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(exceptionInfo.exceptionStarts[i], i2, exceptionInfo.handlerLabels[i], bodyCodegen.exceptionTypeToName(i));
                return;
            }
            throw new IllegalStateException("bad exception start");
        }

        private ExceptionInfo getTop() {
            return this.exceptionInfo.getLast();
        }

        public void addHandler(int i, int i2, int i3) {
            ExceptionInfo top = getTop();
            top.handlerLabels[i] = i2;
            top.exceptionStarts[i] = i3;
        }

        public void markInlineFinallyEnd(Node node, int i) {
            LinkedList<ExceptionInfo> linkedList = this.exceptionInfo;
            ListIterator<ExceptionInfo> listIterator = linkedList.listIterator(linkedList.size());
            while (listIterator.hasPrevious()) {
                ExceptionInfo previous = listIterator.previous();
                for (int i2 = 0; i2 < 5; i2++) {
                    if (previous.handlerLabels[i2] != 0 && previous.currentFinally == node) {
                        previous.exceptionStarts[i2] = i;
                        previous.currentFinally = null;
                    }
                }
                if (previous.finallyBlock == node) {
                    return;
                }
            }
        }

        public void markInlineFinallyStart(Node node, int i) {
            LinkedList<ExceptionInfo> linkedList = this.exceptionInfo;
            ListIterator<ExceptionInfo> listIterator = linkedList.listIterator(linkedList.size());
            while (listIterator.hasPrevious()) {
                ExceptionInfo previous = listIterator.previous();
                for (int i2 = 0; i2 < 5; i2++) {
                    if (previous.handlerLabels[i2] != 0 && previous.currentFinally == null) {
                        endCatch(previous, i2, i);
                        previous.exceptionStarts[i2] = 0;
                        previous.currentFinally = node;
                    }
                }
                if (previous.finallyBlock == node) {
                    return;
                }
            }
        }

        public void popExceptionInfo() {
            this.exceptionInfo.removeLast();
        }

        public void pushExceptionInfo(Jump jump) {
            this.exceptionInfo.add(new ExceptionInfo(jump, BodyCodegen.this.getFinallyAtTarget(jump.getFinally())));
        }

        public int removeHandler(int i, int i2) {
            ExceptionInfo top = getTop();
            int[] iArr = top.handlerLabels;
            if (iArr[i] != 0) {
                int i3 = iArr[i];
                endCatch(top, i, i2);
                top.handlerLabels[i] = 0;
                return i3;
            }
            return 0;
        }

        public void setHandlers(int[] iArr, int i) {
            for (int i2 = 0; i2 < iArr.length; i2++) {
                if (iArr[i2] != 0) {
                    addHandler(i2, iArr[i2], i);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class FinallyReturnPoint {
        public List<Integer> jsrPoints = new ArrayList();
        public int tableLabel = 0;
    }

    private void addDoubleWrap() {
        addOptRuntimeInvoke("wrapDouble", "(D)Ljava/lang/Double;");
    }

    private void addGoto(Node node, int i) {
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, getTargetLabel(node));
    }

    private void addGotoWithReturn(Node node) {
        FinallyReturnPoint finallyReturnPoint = this.finallys.get(node);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwww(finallyReturnPoint.jsrPoints.size());
        addGoto(node, 167);
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.cfw.Wwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        finallyReturnPoint.jsrPoints.add(Integer.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
    }

    private void addInstructionCount() {
        addInstructionCount(Math.max(this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwww - this.savedCodeOffset, 1));
    }

    private void addInstructionCount(int i) {
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.contextLocal);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwww(i);
        addScriptRuntimeInvoke("addInstructionCount", "(Lorg/mozilla/javascript/Context;I)V");
    }

    private void addJumpedBooleanWrap(int i, int i2) {
        this.cfw.Wwwwwwwwwwwwwwwwww(i2);
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(178, "java/lang/Boolean", "FALSE", "Ljava/lang/Boolean;");
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(167, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.cfw.Wwwwwwwwwwwwwwwwww(i);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(178, "java/lang/Boolean", "TRUE", "Ljava/lang/Boolean;");
        this.cfw.Wwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.cfw.Wwwwwwwwwwwwwwwwwwwww(-1);
    }

    private void addLoadPropertyIds(Object[] objArr, int i) {
        addNewObjectArray(i);
        for (int i2 = 0; i2 != i; i2++) {
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(89);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwww(i2);
            Object obj = objArr[i2];
            if (obj instanceof String) {
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((String) obj);
            } else {
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwww(((Integer) obj).intValue());
                addScriptRuntimeInvoke("wrapInt", "(I)Ljava/lang/Integer;");
            }
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(83);
        }
    }

    private void addLoadPropertyValues(Node node, Node node2, int i) {
        int i2 = 0;
        if (!this.isGenerator) {
            addNewObjectArray(i);
            while (i2 != i) {
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(89);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwww(i2);
                int type = node2.getType();
                if (type == 152 || type == 153 || type == 164) {
                    generateExpression(node2.getFirstChild(), node);
                } else {
                    generateExpression(node2, node);
                }
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(83);
                node2 = node2.getNext();
                i2++;
            }
            return;
        }
        for (int i3 = 0; i3 != i; i3++) {
            int type2 = node2.getType();
            if (type2 == 152 || type2 == 153 || type2 == 164) {
                generateExpression(node2.getFirstChild(), node);
            } else {
                generateExpression(node2, node);
            }
            node2 = node2.getNext();
        }
        addNewObjectArray(i);
        while (i2 != i) {
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(90);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(95);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwww((i - i2) - 1);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(95);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(83);
            i2++;
        }
    }

    private void addNewObjectArray(int i) {
        if (i != 0) {
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwww(i);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(189, "java/lang/Object");
            return;
        }
        short s = this.itsZeroArgArray;
        if (s >= 0) {
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) s);
        } else {
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(178, "org/mozilla/javascript/ScriptRuntime", "emptyArgs", "[Ljava/lang/Object;");
        }
    }

    private void addObjectToDouble() {
        addScriptRuntimeInvoke("toNumber", "(Ljava/lang/Object;)D");
    }

    private void addOptRuntimeInvoke(String str, String str2) {
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(184, "org/mozilla/javascript/optimizer/OptRuntime", str, str2);
    }

    private void addScriptRuntimeInvoke(String str, String str2) {
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(184, "org.mozilla.javascript.ScriptRuntime", str, str2);
    }

    private void dcpLoadAsNumber(int i) {
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(42, 25, i);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(178, "java/lang/Void", "TYPE", "Ljava/lang/Class;");
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(165, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        ClassFileWriter classFileWriter = this.cfw;
        short s = classFileWriter.Wwwwwwwwwwwwwwwwwwwwww;
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(42, 25, i);
        addObjectToDouble();
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(167, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        ClassFileWriter classFileWriter2 = this.cfw;
        classFileWriter2.Wwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        classFileWriter2.Wwwwwwwwwwwwwwwwwwwwww = s;
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i + 1);
        this.cfw.Wwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
    }

    private void dcpLoadAsObject(int i) {
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(42, 25, i);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(178, "java/lang/Void", "TYPE", "Ljava/lang/Class;");
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(165, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        ClassFileWriter classFileWriter = this.cfw;
        short s = classFileWriter.Wwwwwwwwwwwwwwwwwwwwww;
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(42, 25, i);
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(167, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        ClassFileWriter classFileWriter2 = this.cfw;
        classFileWriter2.Wwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        classFileWriter2.Wwwwwwwwwwwwwwwwwwwwww = s;
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i + 1);
        addDoubleWrap();
        this.cfw.Wwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
    }

    private void decReferenceWordLocal(short s) {
        int[] iArr = this.locals;
        iArr[s] = iArr[s] - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String exceptionTypeToName(int i) {
        if (i == 0) {
            return "org/mozilla/javascript/JavaScriptException";
        }
        if (i == 1) {
            return "org/mozilla/javascript/EvaluatorException";
        }
        if (i == 2) {
            return "org/mozilla/javascript/EcmaError";
        }
        if (i == 3) {
            return "java/lang/Throwable";
        }
        if (i != 4) {
            throw Kit.codeBug();
        }
        return null;
    }

    private void genSimpleCompare(int i, int i2, int i3) {
        ClassFileWriter classFileWriter;
        int i4;
        if (i2 != -1) {
            switch (i) {
                case 14:
                    this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(152);
                    classFileWriter = this.cfw;
                    i4 = 155;
                    break;
                case 15:
                    this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(152);
                    classFileWriter = this.cfw;
                    i4 = 158;
                    break;
                case 16:
                    this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(151);
                    classFileWriter = this.cfw;
                    i4 = 157;
                    break;
                case 17:
                    this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(151);
                    classFileWriter = this.cfw;
                    i4 = 156;
                    break;
                default:
                    throw Codegen.badTree();
            }
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4, i2);
            if (i3 == -1) {
                return;
            }
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(167, i3);
            return;
        }
        throw Codegen.badTree();
    }

    private void generateActivationExit() {
        if (this.fnCurrent == null || this.hasVarsInRegs) {
            throw Kit.codeBug();
        }
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.contextLocal);
        addScriptRuntimeInvoke("exitActivationFunction", Codegen.REGEXP_INIT_METHOD_SIGNATURE);
    }

    private void generateArrayLiteralFactory(Node node, int i) {
        initBodyGeneration();
        short s = this.firstFreeLocal;
        short s2 = (short) (s + 1);
        this.firstFreeLocal = s2;
        this.argsLocal = s;
        this.localsMax = s2;
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.codegen.getBodyMethodName(this.scriptOrFn) + "_literal" + i, "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;", (short) 2);
        visitArrayLiteral(node, node.getFirstChild(), true);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((short) (this.localsMax + 1));
    }

    private void generateCallArgArray(Node node, Node node2, boolean z) {
        short s;
        int i = 0;
        for (Node node3 = node2; node3 != null; node3 = node3.getNext()) {
            i++;
        }
        if (i != 1 || (s = this.itsOneArgArray) < 0) {
            addNewObjectArray(i);
        } else {
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) s);
        }
        for (int i2 = 0; i2 != i; i2++) {
            if (!this.isGenerator) {
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(89);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwww(i2);
            }
            if (!z) {
                generateExpression(node2, node);
            } else {
                int nodeIsDirectCallParameter = nodeIsDirectCallParameter(node2);
                if (nodeIsDirectCallParameter >= 0) {
                    dcpLoadAsObject(nodeIsDirectCallParameter);
                } else {
                    generateExpression(node2, node);
                    if (node2.getIntProp(8, -1) == 0) {
                        addDoubleWrap();
                    }
                }
            }
            if (this.isGenerator) {
                short newWordLocal = getNewWordLocal();
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(newWordLocal);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(192, "[Ljava/lang/Object;");
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(89);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwww(i2);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) newWordLocal);
                releaseWordLocal(newWordLocal);
            }
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(83);
            node2 = node2.getNext();
        }
    }

    private void generateCatchBlock(int i, short s, int i2, int i3, int i4) {
        if (i4 == 0) {
            i4 = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        this.cfw.Wwwwwwwwwwwwwwwwwww(i4);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(75, 58, i3);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(42, 25, s);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.variableObjectLocal);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(167, i2);
    }

    private void generateCheckForThrowOrClose(int i, boolean z, int i2) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.cfw.Wwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.argsLocal);
        generateThrowJavaScriptException();
        this.cfw.Wwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.argsLocal);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(192, "java/lang/Throwable");
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(191);
        if (i != -1) {
            this.cfw.Wwwwwwwwwwwwwwwwww(i);
        }
        if (!z) {
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.generatorSwitch, i2);
        }
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.operationLocal);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwww(2);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Token.LETEXPR, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.operationLocal);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Token.LETEXPR, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    private void generateEpilogue() {
        if (this.compilerEnv.isGenerateObserverCount()) {
            addInstructionCount();
        }
        if (this.isGenerator) {
            Map<Node, int[]> liveLocals = ((FunctionNode) this.scriptOrFn).getLiveLocals();
            if (liveLocals != null) {
                List<Node> resumptionPoints = ((FunctionNode) this.scriptOrFn).getResumptionPoints();
                for (int i = 0; i < resumptionPoints.size(); i++) {
                    Node node = resumptionPoints.get(i);
                    int[] iArr = liveLocals.get(node);
                    if (iArr != null) {
                        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.generatorSwitch, getNextGeneratorState(node));
                        generateGetGeneratorLocalsState();
                        for (int i2 = 0; i2 < iArr.length; i2++) {
                            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(89);
                            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
                            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(50);
                            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iArr[i2]);
                        }
                        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(87);
                        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(167, getTargetLabel(node));
                    }
                }
            }
            Map<Node, FinallyReturnPoint> map = this.finallys;
            if (map != null) {
                for (Node node2 : map.keySet()) {
                    if (node2.getType() == 126) {
                        FinallyReturnPoint finallyReturnPoint = this.finallys.get(node2);
                        ClassFileWriter classFileWriter = this.cfw;
                        classFileWriter.Wwwwwwwwwwwwwwwwww(finallyReturnPoint.tableLabel);
                        classFileWriter.Wwwwwwwwwwwwwwwwwwwwww = (short) 1;
                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, finallyReturnPoint.jsrPoints.size() - 1);
                        this.cfw.Wwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        int i3 = 0;
                        for (int i4 = 0; i4 < finallyReturnPoint.jsrPoints.size(); i4++) {
                            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i3);
                            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(167, finallyReturnPoint.jsrPoints.get(i4).intValue());
                            i3++;
                        }
                    }
                }
            }
        }
        int i5 = this.epilogueLabel;
        if (i5 != -1) {
            this.cfw.Wwwwwwwwwwwwwwwwww(i5);
        }
        if (this.hasVarsInRegs) {
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6);
            return;
        }
        if (this.isGenerator) {
            if (((FunctionNode) this.scriptOrFn).getResumptionPoints() != null) {
                this.cfw.Wwwwwwwwwwwwwwwww(this.generatorSwitch);
            }
            generateSetGeneratorResumptionPoint(-1);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.variableObjectLocal);
            addOptRuntimeInvoke("throwStopIteration", "(Ljava/lang/Object;)V");
            Codegen.pushUndefined(this.cfw);
        } else if (this.fnCurrent != null) {
            generateActivationExit();
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6);
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.cfw.Wwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            short newWordLocal = getNewWordLocal();
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(newWordLocal);
            generateActivationExit();
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) newWordLocal);
            releaseWordLocal(newWordLocal);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(191);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.enterAreaStartLabel, this.epilogueLabel, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, (String) null);
            return;
        } else {
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.popvLocal);
        }
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:817)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:856)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    private void generateExpression(org.mozilla.javascript.Node r14, org.mozilla.javascript.Node r15) {
        /*
            Method dump skipped, instructions count: 1538
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.optimizer.BodyCodegen.generateExpression(org.mozilla.javascript.Node, org.mozilla.javascript.Node):void");
    }

    private void generateFunctionAndThisObj(Node node, Node node2) {
        String str;
        String str2;
        int type = node.getType();
        int type2 = node.getType();
        if (type2 != 33) {
            if (type2 == 34) {
                throw Kit.codeBug();
            }
            if (type2 != 36) {
                if (type2 != 39) {
                    generateExpression(node, node2);
                    this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.contextLocal);
                    str = "getValueFunctionAndThis";
                    str2 = "(Ljava/lang/Object;Lorg/mozilla/javascript/Context;)Lorg/mozilla/javascript/Callable;";
                } else {
                    this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(node.getString());
                    this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.contextLocal);
                    this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.variableObjectLocal);
                    str = "getNameFunctionAndThis";
                    str2 = "(Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Callable;";
                }
                addScriptRuntimeInvoke(str, str2);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.contextLocal);
                addScriptRuntimeInvoke("lastStoredScriptable", "(Lorg/mozilla/javascript/Context;)Lorg/mozilla/javascript/Scriptable;");
            }
        }
        Node firstChild = node.getFirstChild();
        generateExpression(firstChild, node);
        Node next = firstChild.getNext();
        if (type == 33) {
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next.getString());
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.contextLocal);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.variableObjectLocal);
            str = "getPropFunctionAndThis";
            str2 = "(Ljava/lang/Object;Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Callable;";
        } else {
            generateExpression(next, node);
            if (node.getIntProp(8, -1) != -1) {
                addDoubleWrap();
            }
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.contextLocal);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.variableObjectLocal);
            str = "getElemFunctionAndThis";
            str2 = "(Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Callable;";
        }
        addScriptRuntimeInvoke(str, str2);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.contextLocal);
        addScriptRuntimeInvoke("lastStoredScriptable", "(Lorg/mozilla/javascript/Context;)Lorg/mozilla/javascript/Scriptable;");
    }

    private void generateGenerator() {
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.codegen.getBodyMethodName(this.scriptOrFn), this.codegen.getBodyMethodSignature(this.scriptOrFn), (short) 10);
        initBodyGeneration();
        short s = this.firstFreeLocal;
        short s2 = (short) (s + 1);
        this.firstFreeLocal = s2;
        this.argsLocal = s;
        this.localsMax = s2;
        if (this.fnCurrent != null) {
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.funObjLocal);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(NormalCmdFactory.TASK_CANCEL_ALL, "org/mozilla/javascript/Scriptable", "getParentScope", "()Lorg/mozilla/javascript/Scriptable;");
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.variableObjectLocal);
        }
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.funObjLocal);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.variableObjectLocal);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.argsLocal);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.scriptOrFn.isInStrictMode());
        addScriptRuntimeInvoke("createFunctionActivation", "(Lorg/mozilla/javascript/NativeFunction;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;Z)Lorg/mozilla/javascript/Scriptable;");
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.variableObjectLocal);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(187, this.codegen.mainClassName);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(89);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.variableObjectLocal);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.contextLocal);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwww(this.scriptOrFnIndex);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(183, this.codegen.mainClassName, "<init>", Codegen.FUNCTION_CONSTRUCTOR_SIGNATURE);
        generateNestedFunctionInits();
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.variableObjectLocal);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.thisObjLocal);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwww(this.maxLocals);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwww(this.maxStack);
        addOptRuntimeInvoke("createNativeGenerator", "(Lorg/mozilla/javascript/NativeFunction;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;II)Lorg/mozilla/javascript/Scriptable;");
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((short) (this.localsMax + 1));
    }

    private void generateGetGeneratorLocalsState() {
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.generatorStateLocal);
        addOptRuntimeInvoke("getGeneratorLocalsState", "(Ljava/lang/Object;)[Ljava/lang/Object;");
    }

    private void generateGetGeneratorResumptionPoint() {
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.generatorStateLocal);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(180, OptRuntime.GeneratorState.CLASS_NAME, OptRuntime.GeneratorState.resumptionPoint_NAME, OptRuntime.GeneratorState.resumptionPoint_TYPE);
    }

    private void generateGetGeneratorStackState() {
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.generatorStateLocal);
        addOptRuntimeInvoke("getGeneratorStackState", "(Ljava/lang/Object;)[Ljava/lang/Object;");
    }

    private void generateIfJump(Node node, Node node2, int i, int i2) {
        int type = node.getType();
        Node firstChild = node.getFirstChild();
        if (type == 26) {
            generateIfJump(firstChild, node, i2, i);
            return;
        }
        if (type != 46 && type != 47) {
            if (type != 52 && type != 53) {
                if (type == 105 || type == 106) {
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    if (type == 106) {
                        generateIfJump(firstChild, node, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i2);
                    } else {
                        generateIfJump(firstChild, node, i, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    }
                    this.cfw.Wwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    generateIfJump(firstChild.getNext(), node, i, i2);
                    return;
                }
                switch (type) {
                    case 12:
                    case 13:
                        break;
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                        break;
                    default:
                        generateExpression(node, node2);
                        addScriptRuntimeInvoke("toBoolean", "(Ljava/lang/Object;)Z");
                        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(154, i);
                        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(167, i2);
                        return;
                }
            }
            visitIfJumpRelOp(node, firstChild, i, i2);
            return;
        }
        visitIfJumpEqOp(node, firstChild, i, i2);
    }

    private void generateIntegerUnwrap() {
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(182, "java/lang/Integer", "intValue", "()I");
    }

    private void generateIntegerWrap() {
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
    }

    private void generateNestedFunctionInits() {
        int functionCount = this.scriptOrFn.getFunctionCount();
        for (int i = 0; i != functionCount; i++) {
            OptFunctionNode optFunctionNode = OptFunctionNode.get(this.scriptOrFn, i);
            if (optFunctionNode.fnode.getFunctionType() == 1) {
                visitFunction(optFunctionNode, 1);
            }
        }
    }

    private void generateObjectLiteralFactory(Node node, int i) {
        initBodyGeneration();
        short s = this.firstFreeLocal;
        short s2 = (short) (s + 1);
        this.firstFreeLocal = s2;
        this.argsLocal = s;
        this.localsMax = s2;
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.codegen.getBodyMethodName(this.scriptOrFn) + "_literal" + i, "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;", (short) 2);
        visitObjectLiteral(node, node.getFirstChild(), true);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((short) (this.localsMax + 1));
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0241 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void generatePrologue() {
        String str;
        short newWordLocal;
        if (this.inDirectCallFunction) {
            int paramCount = this.scriptOrFn.getParamCount();
            if (this.firstFreeLocal != 4) {
                Kit.codeBug();
            }
            for (int i = 0; i != paramCount; i++) {
                short[] sArr = this.varRegisters;
                short s = this.firstFreeLocal;
                sArr[i] = s;
                this.firstFreeLocal = (short) (s + 3);
            }
            if (!this.fnCurrent.getParameterNumberContext()) {
                this.itsForcedObjectParameters = true;
                for (int i2 = 0; i2 != paramCount; i2++) {
                    short s2 = this.varRegisters[i2];
                    this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) s2);
                    this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(178, "java/lang/Void", "TYPE", "Ljava/lang/Class;");
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(166, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s2 + 1);
                    addDoubleWrap();
                    this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s2);
                    this.cfw.Wwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
            }
        }
        if (this.fnCurrent != null) {
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.funObjLocal);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(NormalCmdFactory.TASK_CANCEL_ALL, "org/mozilla/javascript/Scriptable", "getParentScope", "()Lorg/mozilla/javascript/Scriptable;");
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.variableObjectLocal);
        }
        short s3 = this.firstFreeLocal;
        short s4 = (short) (s3 + 1);
        this.firstFreeLocal = s4;
        this.argsLocal = s3;
        this.localsMax = s4;
        if (this.isGenerator) {
            short s5 = (short) (s4 + 1);
            this.firstFreeLocal = s5;
            this.operationLocal = s4;
            this.localsMax = s5;
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.thisObjLocal);
            short s6 = this.firstFreeLocal;
            short s7 = (short) (s6 + 1);
            this.firstFreeLocal = s7;
            this.generatorStateLocal = s6;
            this.localsMax = s7;
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(192, OptRuntime.GeneratorState.CLASS_NAME);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(89);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.generatorStateLocal);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(180, OptRuntime.GeneratorState.CLASS_NAME, OptRuntime.GeneratorState.thisObj_NAME, OptRuntime.GeneratorState.thisObj_TYPE);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.thisObjLocal);
            if (this.epilogueLabel == -1) {
                this.epilogueLabel = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            List<Node> resumptionPoints = ((FunctionNode) this.scriptOrFn).getResumptionPoints();
            if (resumptionPoints != null) {
                generateGetGeneratorResumptionPoint();
                this.generatorSwitch = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, resumptionPoints.size() + 0);
                generateCheckForThrowOrClose(-1, false, 0);
            }
        }
        if (this.fnCurrent == null && this.scriptOrFn.getRegexpCount() != 0) {
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.contextLocal);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(184, this.codegen.mainClassName, Codegen.REGEXP_INIT_METHOD_NAME, Codegen.REGEXP_INIT_METHOD_SIGNATURE);
        }
        if (this.compilerEnv.isGenerateObserverCount()) {
            saveCurrentCodeOffset();
        }
        if (!this.hasVarsInRegs) {
            if (this.isGenerator) {
                return;
            }
            ScriptNode scriptNode = this.scriptOrFn;
            boolean z = (scriptNode instanceof FunctionNode) && ((FunctionNode) scriptNode).getFunctionType() == 4;
            if (this.fnCurrent != null) {
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.funObjLocal);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.variableObjectLocal);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.argsLocal);
                String str2 = z ? "createArrowFunctionActivation" : "createFunctionActivation";
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.scriptOrFn.isInStrictMode());
                addScriptRuntimeInvoke(str2, "(Lorg/mozilla/javascript/NativeFunction;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;Z)Lorg/mozilla/javascript/Scriptable;");
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.variableObjectLocal);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.contextLocal);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.variableObjectLocal);
                addScriptRuntimeInvoke("enterActivationFunction", Codegen.FUNCTION_INIT_SIGNATURE);
                str = "activation";
            } else {
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.funObjLocal);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.thisObjLocal);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.contextLocal);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.variableObjectLocal);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwww(0);
                addScriptRuntimeInvoke("initScript", "(Lorg/mozilla/javascript/NativeFunction;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Z)V");
                str = "global";
            }
            this.enterAreaStartLabel = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.epilogueLabel = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.cfw.Wwwwwwwwwwwwwwwwww(this.enterAreaStartLabel);
            generateNestedFunctionInits();
            if (this.compilerEnv.isGenerateDebugInfo()) {
                ClassFileWriter classFileWriter = this.cfw;
                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, OptRuntime.GeneratorState.thisObj_TYPE, classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwww, this.variableObjectLocal);
            }
            OptFunctionNode optFunctionNode = this.fnCurrent;
            if (optFunctionNode == null) {
                this.popvLocal = getNewWordLocal();
                Codegen.pushUndefined(this.cfw);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.popvLocal);
                int endLineno = this.scriptOrFn.getEndLineno();
                if (endLineno == -1) {
                    return;
                }
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((short) endLineno);
                return;
            }
            if (optFunctionNode.itsContainsCalls0) {
                this.itsZeroArgArray = getNewWordLocal();
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(178, "org/mozilla/javascript/ScriptRuntime", "emptyArgs", "[Ljava/lang/Object;");
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.itsZeroArgArray);
            }
            if (!this.fnCurrent.itsContainsCalls1) {
                return;
            }
            this.itsOneArgArray = getNewWordLocal();
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwww(1);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(189, "java/lang/Object");
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.itsOneArgArray);
            return;
        }
        int paramCount2 = this.scriptOrFn.getParamCount();
        if (paramCount2 > 0 && !this.inDirectCallFunction) {
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.argsLocal);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(190);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwww(paramCount2);
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(162, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.argsLocal);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwww(paramCount2);
            addScriptRuntimeInvoke("padArguments", "([Ljava/lang/Object;I)[Ljava/lang/Object;");
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.argsLocal);
            this.cfw.Wwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        }
        int paramCount3 = this.fnCurrent.fnode.getParamCount();
        int paramAndVarCount = this.fnCurrent.fnode.getParamAndVarCount();
        boolean[] paramAndVarConst = this.fnCurrent.fnode.getParamAndVarConst();
        short s8 = -1;
        for (int i3 = 0; i3 != paramAndVarCount; i3++) {
            if (i3 < paramCount3) {
                if (!this.inDirectCallFunction) {
                    newWordLocal = getNewWordLocal();
                    this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.argsLocal);
                    this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwww(i3);
                    this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(50);
                    this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(newWordLocal);
                    if (newWordLocal >= 0) {
                        if (paramAndVarConst[i3]) {
                            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwww(0);
                            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwww((this.fnCurrent.isNumberVar(i3) ? (short) 2 : (short) 1) + newWordLocal);
                        }
                        this.varRegisters[i3] = newWordLocal;
                    }
                    if (!this.compilerEnv.isGenerateDebugInfo()) {
                        String paramOrVarName = this.fnCurrent.fnode.getParamOrVarName(i3);
                        String str3 = this.fnCurrent.isNumberVar(i3) ? "D" : "Ljava/lang/Object;";
                        int i4 = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwww;
                        if (newWordLocal < 0) {
                            newWordLocal = this.varRegisters[i3];
                        }
                        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(paramOrVarName, str3, i4, newWordLocal);
                    }
                } else {
                    newWordLocal = -1;
                    if (newWordLocal >= 0) {
                    }
                    if (!this.compilerEnv.isGenerateDebugInfo()) {
                    }
                }
            } else if (this.fnCurrent.isNumberVar(i3)) {
                newWordLocal = getNewWordPairLocal(paramAndVarConst[i3]);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(RoundRectDrawableWithShadow.COS_45);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(newWordLocal);
                if (newWordLocal >= 0) {
                }
                if (!this.compilerEnv.isGenerateDebugInfo()) {
                }
            } else {
                newWordLocal = getNewWordLocal(paramAndVarConst[i3]);
                if (s8 == -1) {
                    Codegen.pushUndefined(this.cfw);
                    s8 = newWordLocal;
                } else {
                    this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) s8);
                }
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(newWordLocal);
                if (newWordLocal >= 0) {
                }
                if (!this.compilerEnv.isGenerateDebugInfo()) {
                }
            }
        }
    }

    private boolean generateSaveLocals(Node node) {
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < this.firstFreeLocal; i3++) {
            if (this.locals[i3] != 0) {
                i2++;
            }
        }
        if (i2 == 0) {
            ((FunctionNode) this.scriptOrFn).addLiveLocals(node, null);
            return false;
        }
        int i4 = this.maxLocals;
        if (i4 <= i2) {
            i4 = i2;
        }
        this.maxLocals = i4;
        int[] iArr = new int[i2];
        int i5 = 0;
        for (int i6 = 0; i6 < this.firstFreeLocal; i6++) {
            if (this.locals[i6] != 0) {
                iArr[i5] = i6;
                i5++;
            }
        }
        ((FunctionNode) this.scriptOrFn).addLiveLocals(node, iArr);
        generateGetGeneratorLocalsState();
        while (true) {
            ClassFileWriter classFileWriter = this.cfw;
            if (i >= i2) {
                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(87);
                return true;
            }
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(89);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwww(i);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iArr[i]);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(83);
            i++;
        }
    }

    private void generateSetGeneratorResumptionPoint(int i) {
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.generatorStateLocal);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(181, OptRuntime.GeneratorState.CLASS_NAME, OptRuntime.GeneratorState.resumptionPoint_NAME, OptRuntime.GeneratorState.resumptionPoint_TYPE);
    }

    /* JADX WARN: Removed duplicated region for block: B:80:0x0104  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void generateStatement(Node node) {
        ClassFileWriter classFileWriter;
        int i;
        int localBlockRegister;
        ClassFileWriter classFileWriter2;
        updateLineNumber(node);
        int type = node.getType();
        Node firstChild = node.getFirstChild();
        if (type == 50) {
            generateExpression(firstChild, node);
            if (this.compilerEnv.isGenerateObserverCount()) {
                addInstructionCount();
            }
            generateThrowJavaScriptException();
            return;
        }
        if (type != 51) {
            if (type != 65) {
                if (type == 82) {
                    visitTryCatchFinally((Jump) node, firstChild);
                    return;
                }
                int i2 = 1;
                if (type == 110) {
                    OptFunctionNode optFunctionNode = OptFunctionNode.get(this.scriptOrFn, node.getExistingIntProp(1));
                    int functionType = optFunctionNode.fnode.getFunctionType();
                    if (functionType == 3) {
                        visitFunction(optFunctionNode, functionType);
                        return;
                    } else if (functionType != 1) {
                        throw Codegen.badTree();
                    } else {
                        return;
                    }
                } else if (type == 115) {
                    if (this.compilerEnv.isGenerateObserverCount()) {
                        addInstructionCount();
                    }
                    visitSwitch((Jump) node, firstChild);
                    return;
                } else {
                    if (type != 124) {
                        if (type == 126) {
                            if (!this.isGenerator) {
                                return;
                            }
                            if (this.compilerEnv.isGenerateObserverCount()) {
                                saveCurrentCodeOffset();
                            }
                            this.cfw.Wwwwwwwwwwwwwwwwwwwwww = (short) 1;
                            short newWordLocal = getNewWordLocal();
                            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            this.cfw.Wwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            generateIntegerWrap();
                            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(newWordLocal);
                            while (firstChild != null) {
                                generateStatement(firstChild);
                                firstChild = firstChild.getNext();
                            }
                            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) newWordLocal);
                            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(192, "java/lang/Integer");
                            generateIntegerUnwrap();
                            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            this.finallys.get(node).tableLabel = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(167, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                            releaseWordLocal(newWordLocal);
                            this.cfw.Wwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                            return;
                        } else if (type == 142) {
                            boolean z = this.inLocalBlock;
                            this.inLocalBlock = true;
                            short newWordLocal2 = getNewWordLocal();
                            if (this.isGenerator) {
                                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(newWordLocal2);
                            }
                            node.putIntProp(2, newWordLocal2);
                            while (firstChild != null) {
                                generateStatement(firstChild);
                                firstChild = firstChild.getNext();
                            }
                            releaseWordLocal(newWordLocal2);
                            node.removeProp(2);
                            this.inLocalBlock = z;
                            return;
                        } else if (type == 161) {
                            return;
                        } else {
                            switch (type) {
                                case 2:
                                    generateExpression(firstChild, node);
                                    this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.contextLocal);
                                    this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.variableObjectLocal);
                                    addScriptRuntimeInvoke("enterWith", "(Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
                                    this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.variableObjectLocal);
                                    incReferenceWordLocal(this.variableObjectLocal);
                                    return;
                                case 3:
                                    this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.variableObjectLocal);
                                    addScriptRuntimeInvoke("leaveWith", "(Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
                                    this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.variableObjectLocal);
                                    decReferenceWordLocal(this.variableObjectLocal);
                                    return;
                                case 4:
                                    break;
                                case 5:
                                case 6:
                                case 7:
                                    if (this.compilerEnv.isGenerateObserverCount()) {
                                        addInstructionCount();
                                    }
                                    visitGoto((Jump) node, type, firstChild);
                                    return;
                                default:
                                    switch (type) {
                                        case 57:
                                            this.cfw.Wwwwwwwwwwwwwwwwwwwwww = (short) 0;
                                            localBlockRegister = getLocalBlockRegister(node);
                                            int existingIntProp = node.getExistingIntProp(14);
                                            String string = firstChild.getString();
                                            generateExpression(firstChild.getNext(), node);
                                            ClassFileWriter classFileWriter3 = this.cfw;
                                            if (existingIntProp == 0) {
                                                classFileWriter3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                                            } else {
                                                classFileWriter3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(localBlockRegister);
                                            }
                                            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(string);
                                            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.contextLocal);
                                            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.variableObjectLocal);
                                            addScriptRuntimeInvoke("newCatchScope", "(Ljava/lang/Throwable;Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
                                            classFileWriter2 = this.cfw;
                                            break;
                                        case 58:
                                        case 59:
                                        case 60:
                                        case 61:
                                            generateExpression(firstChild, node);
                                            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.contextLocal);
                                            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.variableObjectLocal);
                                            if (type == 58) {
                                                i2 = 0;
                                            } else if (type != 59) {
                                                i2 = type == 61 ? 6 : 2;
                                            }
                                            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwww(i2);
                                            addScriptRuntimeInvoke("enumInit", "(Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;I)Ljava/lang/Object;");
                                            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getLocalBlockRegister(node));
                                            return;
                                        default:
                                            switch (type) {
                                                case 129:
                                                case 130:
                                                case Token.LABEL /* 131 */:
                                                case Token.LOOP /* 133 */:
                                                case Token.SCRIPT /* 137 */:
                                                    break;
                                                case Token.TARGET /* 132 */:
                                                    if (this.compilerEnv.isGenerateObserverCount()) {
                                                        addInstructionCount();
                                                    }
                                                    this.cfw.Wwwwwwwwwwwwwwwwww(getTargetLabel(node));
                                                    if (!this.compilerEnv.isGenerateObserverCount()) {
                                                        return;
                                                    }
                                                    saveCurrentCodeOffset();
                                                    return;
                                                case Token.EXPR_VOID /* 134 */:
                                                    if (firstChild.getType() != 56) {
                                                        if (firstChild.getType() != 157) {
                                                            if (firstChild.getType() != 73) {
                                                                generateExpression(firstChild, node);
                                                                if (node.getIntProp(8, -1) == -1) {
                                                                    classFileWriter = this.cfw;
                                                                    i = 87;
                                                                    break;
                                                                } else {
                                                                    classFileWriter = this.cfw;
                                                                    i = 88;
                                                                    break;
                                                                }
                                                            } else {
                                                                generateYieldPoint(firstChild, false);
                                                                return;
                                                            }
                                                        } else {
                                                            visitSetConstVar(firstChild, firstChild.getFirstChild(), false);
                                                            return;
                                                        }
                                                    } else {
                                                        visitSetVar(firstChild, firstChild.getFirstChild(), false);
                                                        return;
                                                    }
                                                case Token.EXPR_RESULT /* 135 */:
                                                    generateExpression(firstChild, node);
                                                    if (this.popvLocal < 0) {
                                                        this.popvLocal = getNewWordLocal();
                                                    }
                                                    classFileWriter2 = this.cfw;
                                                    localBlockRegister = this.popvLocal;
                                                    break;
                                                case Token.JSR /* 136 */:
                                                    break;
                                                default:
                                                    throw Codegen.badTree();
                                            }
                                    }
                                    classFileWriter2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(localBlockRegister);
                                    return;
                            }
                        }
                    }
                    if (this.compilerEnv.isGenerateObserverCount()) {
                        addInstructionCount(1);
                    }
                    while (firstChild != null) {
                        generateStatement(firstChild);
                        firstChild = firstChild.getNext();
                    }
                    return;
                }
            }
            if (!this.isGenerator) {
                if (firstChild != null) {
                    generateExpression(firstChild, node);
                } else if (type == 4) {
                    Codegen.pushUndefined(this.cfw);
                } else {
                    short s = this.popvLocal;
                    if (s < 0) {
                        throw Codegen.badTree();
                    }
                    this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) s);
                }
            }
            if (this.compilerEnv.isGenerateObserverCount()) {
                addInstructionCount();
            }
            if (this.epilogueLabel == -1) {
                if (!this.hasVarsInRegs) {
                    throw Codegen.badTree();
                }
                this.epilogueLabel = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(167, this.epilogueLabel);
            return;
        }
        if (this.compilerEnv.isGenerateObserverCount()) {
            addInstructionCount();
        }
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getLocalBlockRegister(node));
        classFileWriter = this.cfw;
        i = 191;
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
    }

    private void generateThrowJavaScriptException() {
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(187, "org/mozilla/javascript/JavaScriptException");
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(90);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(95);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.scriptOrFn.getSourceName());
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwww(this.itsLineNumber);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(183, "org/mozilla/javascript/JavaScriptException", "<init>", "(Ljava/lang/Object;Ljava/lang/String;I)V");
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(191);
    }

    private void generateYieldPoint(Node node, boolean z) {
        ClassFileWriter classFileWriter;
        short s = this.cfw.Wwwwwwwwwwwwwwwwwwwwww;
        int i = this.maxStack;
        if (i <= s) {
            i = s;
        }
        this.maxStack = i;
        int i2 = 0;
        if (this.cfw.Wwwwwwwwwwwwwwwwwwwwww != 0) {
            generateGetGeneratorStackState();
            for (int i3 = 0; i3 < s; i3++) {
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(90);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(95);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(95);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(83);
            }
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(87);
        }
        Node firstChild = node.getFirstChild();
        if (firstChild != null) {
            generateExpression(firstChild, node);
        } else {
            Codegen.pushUndefined(this.cfw);
        }
        int nextGeneratorState = getNextGeneratorState(node);
        generateSetGeneratorResumptionPoint(nextGeneratorState);
        boolean generateSaveLocals = generateSaveLocals(node);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6);
        generateCheckForThrowOrClose(getTargetLabel(node), generateSaveLocals, nextGeneratorState);
        if (s != 0) {
            generateGetGeneratorStackState();
            while (true) {
                classFileWriter = this.cfw;
                if (i2 >= s) {
                    break;
                }
                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(89);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwww((s - i2) - 1);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(50);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(95);
                i2++;
            }
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(87);
        }
        if (z) {
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.argsLocal);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Node getFinallyAtTarget(Node node) {
        Node next;
        if (node == null) {
            return null;
        }
        if (node.getType() == 126) {
            return node;
        }
        if (node.getType() != 132 || (next = node.getNext()) == null || next.getType() != 126) {
            throw Kit.codeBug("bad finally target");
        }
        return next;
    }

    private int getLocalBlockRegister(Node node) {
        return ((Node) node.getProp(3)).getExistingIntProp(2);
    }

    private short getNewWordIntern(int i) {
        int i2;
        int[] iArr = this.locals;
        int i3 = this.firstFreeLocal;
        if (i > 1) {
            loop0: while (true) {
                if (i3 + i > 1024) {
                    i3 = -1;
                    break;
                }
                i2 = 0;
                while (i2 < i) {
                    int i4 = iArr[i3 + i2];
                    i2++;
                    if (i4 != 0) {
                        break;
                    }
                }
                break loop0;
                i3 += i2;
            }
        }
        if (i3 != -1) {
            iArr[i3] = 1;
            if (i > 1) {
                iArr[i3 + 1] = 1;
            }
            if (i > 2) {
                iArr[i3 + 2] = 1;
            }
            if (i3 != this.firstFreeLocal) {
                return (short) i3;
            }
            for (int i5 = i + i3; i5 < 1024; i5++) {
                if (iArr[i5] == 0) {
                    short s = (short) i5;
                    this.firstFreeLocal = s;
                    if (this.localsMax < s) {
                        this.localsMax = s;
                    }
                    return (short) i3;
                }
            }
        }
        throw Context.reportRuntimeError("Program too complex (out of locals)");
    }

    private short getNewWordLocal() {
        return getNewWordIntern(1);
    }

    private short getNewWordLocal(boolean z) {
        return getNewWordIntern(z ? 2 : 1);
    }

    private short getNewWordPairLocal(boolean z) {
        return getNewWordIntern(z ? 3 : 2);
    }

    private int getNextGeneratorState(Node node) {
        return ((FunctionNode) this.scriptOrFn).getResumptionPoints().indexOf(node) + 1;
    }

    private int getTargetLabel(Node node) {
        int labelId = node.labelId();
        if (labelId == -1) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            node.labelId(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return labelId;
    }

    private void incReferenceWordLocal(short s) {
        int[] iArr = this.locals;
        iArr[s] = iArr[s] + 1;
    }

    private void initBodyGeneration() {
        int paramAndVarCount;
        this.varRegisters = null;
        if (this.scriptOrFn.getType() == 110) {
            OptFunctionNode optFunctionNode = OptFunctionNode.get(this.scriptOrFn);
            this.fnCurrent = optFunctionNode;
            boolean z = !optFunctionNode.fnode.requiresActivation();
            this.hasVarsInRegs = z;
            if (z && (paramAndVarCount = this.fnCurrent.fnode.getParamAndVarCount()) != 0) {
                this.varRegisters = new short[paramAndVarCount];
            }
            boolean isTargetOfDirectCall = this.fnCurrent.isTargetOfDirectCall();
            this.inDirectCallFunction = isTargetOfDirectCall;
            if (isTargetOfDirectCall && !this.hasVarsInRegs) {
                Codegen.badTree();
            }
        } else {
            this.fnCurrent = null;
            this.hasVarsInRegs = false;
            this.inDirectCallFunction = false;
        }
        this.locals = new int[1024];
        this.funObjLocal = (short) 0;
        this.contextLocal = (short) 1;
        this.variableObjectLocal = (short) 2;
        this.thisObjLocal = (short) 3;
        this.localsMax = (short) 4;
        this.firstFreeLocal = (short) 4;
        this.popvLocal = (short) -1;
        this.argsLocal = (short) -1;
        this.itsZeroArgArray = (short) -1;
        this.itsOneArgArray = (short) -1;
        this.epilogueLabel = -1;
        this.enterAreaStartLabel = -1;
        this.generatorStateLocal = (short) -1;
    }

    private void inlineFinally(Node node) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.cfw.Wwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        inlineFinally(node, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        this.cfw.Wwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
    }

    private void inlineFinally(Node node, int i, int i2) {
        Node finallyAtTarget = getFinallyAtTarget(node);
        finallyAtTarget.resetTargets();
        this.exceptionManager.markInlineFinallyStart(finallyAtTarget, i);
        for (Node firstChild = finallyAtTarget.getFirstChild(); firstChild != null; firstChild = firstChild.getNext()) {
            generateStatement(firstChild);
        }
        this.exceptionManager.markInlineFinallyEnd(finallyAtTarget, i2);
    }

    public static boolean isArithmeticNode(Node node) {
        int type = node.getType();
        return type == 22 || type == 25 || type == 24 || type == 23;
    }

    private int nodeIsDirectCallParameter(Node node) {
        if (node.getType() != 55 || !this.inDirectCallFunction || this.itsForcedObjectParameters) {
            return -1;
        }
        int varIndex = this.fnCurrent.getVarIndex(node);
        if (!this.fnCurrent.isParameter(varIndex)) {
            return -1;
        }
        return this.varRegisters[varIndex];
    }

    private void releaseWordLocal(short s) {
        if (s < this.firstFreeLocal) {
            this.firstFreeLocal = s;
        }
        this.locals[s] = 0;
    }

    private void saveCurrentCodeOffset() {
        this.savedCodeOffset = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwww;
    }

    private void updateLineNumber(Node node) {
        int lineno = node.getLineno();
        this.itsLineNumber = lineno;
        if (lineno == -1) {
            return;
        }
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((short) lineno);
    }

    private boolean varIsDirectCallParameter(int i) {
        return this.fnCurrent.isParameter(i) && this.inDirectCallFunction && !this.itsForcedObjectParameters;
    }

    private void visitArithmetic(Node node, int i, Node node2, Node node3) {
        if (node.getIntProp(8, -1) != -1) {
            generateExpression(node2, node);
            generateExpression(node2.getNext(), node);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
            return;
        }
        boolean isArithmeticNode = isArithmeticNode(node3);
        generateExpression(node2, node);
        if (!isArithmeticNode(node2)) {
            addObjectToDouble();
        }
        generateExpression(node2.getNext(), node);
        if (!isArithmeticNode(node2.getNext())) {
            addObjectToDouble();
        }
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        if (isArithmeticNode) {
            return;
        }
        addDoubleWrap();
    }

    private void visitArrayLiteral(Node node, Node node2, boolean z) {
        int i = 0;
        int i2 = 0;
        for (Node node3 = node2; node3 != null; node3 = node3.getNext()) {
            i2++;
        }
        if (!z && ((i2 > 10 || this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwww > 30000) && !this.hasVarsInRegs && !this.isGenerator && !this.inLocalBlock)) {
            if (this.literals == null) {
                this.literals = new LinkedList();
            }
            this.literals.add(node);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.funObjLocal);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.contextLocal);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.variableObjectLocal);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.thisObjLocal);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.argsLocal);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(182, this.codegen.mainClassName, this.codegen.getBodyMethodName(this.scriptOrFn) + "_literal" + this.literals.size(), "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;");
            return;
        }
        if (this.isGenerator) {
            for (int i3 = 0; i3 != i2; i3++) {
                generateExpression(node2, node);
                node2 = node2.getNext();
            }
            addNewObjectArray(i2);
            while (i != i2) {
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(90);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(95);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwww((i2 - i) - 1);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(95);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(83);
                i++;
            }
        } else {
            addNewObjectArray(i2);
            while (i != i2) {
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(89);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwww(i);
                generateExpression(node2, node);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(83);
                node2 = node2.getNext();
                i++;
            }
        }
        int[] iArr = (int[]) node.getProp(11);
        if (iArr == null) {
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
        } else {
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(OptRuntime.encodeIntArray(iArr));
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwww(iArr.length);
        }
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.contextLocal);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.variableObjectLocal);
        addOptRuntimeInvoke("newArrayLiteral", "([Ljava/lang/Object;Ljava/lang/String;ILorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void visitBitOp(Node node, int i, Node node2) {
        ClassFileWriter classFileWriter;
        int i2;
        int intProp = node.getIntProp(8, -1);
        generateExpression(node2, node);
        String str = "(Ljava/lang/Object;)I";
        if (i == 20) {
            addScriptRuntimeInvoke("toUint32", "(Ljava/lang/Object;)J");
            generateExpression(node2.getNext(), node);
            addScriptRuntimeInvoke("toInt32", str);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwww(31);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(126);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(125);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Token.TYPEOFNAME);
            addDoubleWrap();
            return;
        }
        if (intProp != -1) {
            str = "(D)I";
        }
        addScriptRuntimeInvoke("toInt32", str);
        generateExpression(node2.getNext(), node);
        addScriptRuntimeInvoke("toInt32", str);
        if (i == 18) {
            classFileWriter = this.cfw;
            i2 = 120;
        } else if (i != 19) {
            switch (i) {
                case 9:
                    classFileWriter = this.cfw;
                    i2 = 128;
                    break;
                case 10:
                    classFileWriter = this.cfw;
                    i2 = 130;
                    break;
                case 11:
                    this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(126);
                    break;
                default:
                    throw Codegen.badTree();
            }
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Token.EXPR_RESULT);
            if (intProp == -1) {
                return;
            }
            addDoubleWrap();
            return;
        } else {
            classFileWriter = this.cfw;
            i2 = 122;
        }
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Token.EXPR_RESULT);
        if (intProp == -1) {
        }
    }

    private void visitDotQuery(Node node, Node node2) {
        updateLineNumber(node);
        generateExpression(node2, node);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.variableObjectLocal);
        addScriptRuntimeInvoke("enterDotQuery", "(Ljava/lang/Object;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.variableObjectLocal);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.cfw.Wwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(87);
        generateExpression(node2.getNext(), node);
        addScriptRuntimeInvoke("toBoolean", "(Ljava/lang/Object;)Z");
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.variableObjectLocal);
        addScriptRuntimeInvoke("updateDotQuery", "(ZLorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;");
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(89);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(198, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.variableObjectLocal);
        addScriptRuntimeInvoke("leaveDotQuery", "(Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.variableObjectLocal);
    }

    private void visitFunction(OptFunctionNode optFunctionNode, int i) {
        int index = this.codegen.getIndex(optFunctionNode.fnode);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(187, this.codegen.mainClassName);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(89);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.variableObjectLocal);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.contextLocal);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwww(index);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(183, this.codegen.mainClassName, "<init>", Codegen.FUNCTION_CONSTRUCTOR_SIGNATURE);
        if (i == 4) {
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.contextLocal);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.variableObjectLocal);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.thisObjLocal);
            addOptRuntimeInvoke("bindThis", "(Lorg/mozilla/javascript/NativeFunction;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Function;");
        }
        if (i == 2 || i == 4) {
            return;
        }
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwww(i);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.variableObjectLocal);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.contextLocal);
        addOptRuntimeInvoke("initFunction", "(Lorg/mozilla/javascript/NativeFunction;ILorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Context;)V");
    }

    private void visitGetProp(Node node, Node node2) {
        generateExpression(node2, node);
        Node next = node2.getNext();
        generateExpression(next, node);
        if (node.getType() == 34) {
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.contextLocal);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.variableObjectLocal);
            addScriptRuntimeInvoke("getObjectPropNoWarn", "(Ljava/lang/Object;Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;");
        } else if (node2.getType() == 43 && next.getType() == 41) {
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.contextLocal);
            addScriptRuntimeInvoke("getObjectProp", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;Lorg/mozilla/javascript/Context;)Ljava/lang/Object;");
        } else {
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.contextLocal);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.variableObjectLocal);
            addScriptRuntimeInvoke("getObjectProp", "(Ljava/lang/Object;Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;");
        }
    }

    private void visitGetVar(Node node) {
        if (!this.hasVarsInRegs) {
            Kit.codeBug();
        }
        int varIndex = this.fnCurrent.getVarIndex(node);
        short s = this.varRegisters[varIndex];
        if (varIsDirectCallParameter(varIndex)) {
            if (node.getIntProp(8, -1) != -1) {
                dcpLoadAsNumber(s);
            } else {
                dcpLoadAsObject(s);
            }
        } else if (this.fnCurrent.isNumberVar(varIndex)) {
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s);
        } else {
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) s);
        }
    }

    private void visitGoto(Jump jump, int i, Node node) {
        Node node2 = jump.target;
        if (i != 6 && i != 7) {
            if (i != 136) {
                addGoto(node2, 167);
            } else if (this.isGenerator) {
                addGotoWithReturn(node2);
            } else {
                inlineFinally(node2);
            }
        } else if (node == null) {
            throw Codegen.badTree();
        } else {
            int targetLabel = getTargetLabel(node2);
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (i == 6) {
                generateIfJump(node, jump, targetLabel, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            } else {
                generateIfJump(node, jump, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, targetLabel);
            }
            this.cfw.Wwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void visitIfJumpEqOp(Node node, Node node2, int i, int i2) {
        int i3;
        Node node3 = node2;
        int i4 = i;
        int i5 = i2;
        if (i4 == -1 || i5 == -1) {
            throw Codegen.badTree();
        }
        short s = this.cfw.Wwwwwwwwwwwwwwwwwwwwww;
        int type = node.getType();
        Node next = node2.getNext();
        if (node2.getType() == 42 || next.getType() == 42) {
            if (node2.getType() == 42) {
                node3 = next;
            }
            generateExpression(node3, node);
            int i6 = PermissionUtils.requestCode;
            int i7 = 46;
            if (type != 46) {
                if (type == 47) {
                    i7 = 46;
                } else {
                    if (type != 12) {
                        if (type != 13) {
                            throw Codegen.badTree();
                        }
                        i5 = i4;
                        i4 = i5;
                    }
                    this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(89);
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(PermissionUtils.requestCode, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    ClassFileWriter classFileWriter = this.cfw;
                    short s2 = classFileWriter.Wwwwwwwwwwwwwwwwwwwwww;
                    classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(87);
                    this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(167, i4);
                    ClassFileWriter classFileWriter2 = this.cfw;
                    classFileWriter2.Wwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    classFileWriter2.Wwwwwwwwwwwwwwwwwwwwww = s2;
                    Codegen.pushUndefined(this.cfw);
                    this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(165, i4);
                }
            }
            if (type == i7) {
                i6 = 198;
            }
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i6, i4);
        } else {
            int nodeIsDirectCallParameter = nodeIsDirectCallParameter(node3);
            if (nodeIsDirectCallParameter != -1 && next.getType() == 150) {
                Node firstChild = next.getFirstChild();
                if (firstChild.getType() == 40) {
                    this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(nodeIsDirectCallParameter);
                    this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(178, "java/lang/Void", "TYPE", "Ljava/lang/Class;");
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(166, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                    this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(nodeIsDirectCallParameter + 1);
                    this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(firstChild.getDouble());
                    this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(151);
                    if (type == 12) {
                        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(153, i4);
                    } else {
                        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(154, i4);
                    }
                    this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(167, i5);
                    this.cfw.Wwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                    generateExpression(node3, node);
                    generateExpression(next, node);
                    String str = "shallowEq";
                    if (type == 12) {
                        if (type == 13) {
                            str = "eq";
                        } else if (type != 46) {
                            if (type != 47) {
                                throw Codegen.badTree();
                            }
                        }
                        i3 = 153;
                        addScriptRuntimeInvoke(str, "(Ljava/lang/Object;Ljava/lang/Object;)Z");
                        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3, i4);
                    } else {
                        str = "eq";
                    }
                    i3 = 154;
                    addScriptRuntimeInvoke(str, "(Ljava/lang/Object;Ljava/lang/Object;)Z");
                    this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3, i4);
                }
            }
            generateExpression(node3, node);
            generateExpression(next, node);
            String str2 = "shallowEq";
            if (type == 12) {
            }
            i3 = 154;
            addScriptRuntimeInvoke(str2, "(Ljava/lang/Object;Ljava/lang/Object;)Z");
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3, i4);
        }
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(167, i5);
        if (s != this.cfw.Wwwwwwwwwwwwwwwwwwwwww) {
            throw Codegen.badTree();
        }
    }

    private void visitIfJumpRelOp(Node node, Node node2, int i, int i2) {
        if (i == -1 || i2 == -1) {
            throw Codegen.badTree();
        }
        int type = node.getType();
        Node next = node2.getNext();
        if (type == 53 || type == 52) {
            generateExpression(node2, node);
            generateExpression(next, node);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.contextLocal);
            addScriptRuntimeInvoke(type == 53 ? "instanceOf" : "in", "(Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;)Z");
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(154, i);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(167, i2);
            return;
        }
        int intProp = node.getIntProp(8, -1);
        int nodeIsDirectCallParameter = nodeIsDirectCallParameter(node2);
        int nodeIsDirectCallParameter2 = nodeIsDirectCallParameter(next);
        if (intProp != -1) {
            if (intProp != 2) {
                generateExpression(node2, node);
            } else if (nodeIsDirectCallParameter != -1) {
                dcpLoadAsNumber(nodeIsDirectCallParameter);
            } else {
                generateExpression(node2, node);
                addObjectToDouble();
            }
            if (intProp != 1) {
                generateExpression(next, node);
            } else if (nodeIsDirectCallParameter2 != -1) {
                dcpLoadAsNumber(nodeIsDirectCallParameter2);
            } else {
                generateExpression(next, node);
                addObjectToDouble();
            }
            genSimpleCompare(type, i, i2);
            return;
        }
        if (nodeIsDirectCallParameter == -1 || nodeIsDirectCallParameter2 == -1) {
            generateExpression(node2, node);
            generateExpression(next, node);
        } else {
            ClassFileWriter classFileWriter = this.cfw;
            short s = classFileWriter.Wwwwwwwwwwwwwwwwwwwwww;
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(nodeIsDirectCallParameter);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(178, "java/lang/Void", "TYPE", "Ljava/lang/Class;");
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(166, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(nodeIsDirectCallParameter + 1);
            dcpLoadAsNumber(nodeIsDirectCallParameter2);
            genSimpleCompare(type, i, i2);
            ClassFileWriter classFileWriter2 = this.cfw;
            if (s != classFileWriter2.Wwwwwwwwwwwwwwwwwwwwww) {
                throw Codegen.badTree();
            }
            classFileWriter2.Wwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(nodeIsDirectCallParameter2);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(178, "java/lang/Void", "TYPE", "Ljava/lang/Class;");
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(166, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(nodeIsDirectCallParameter);
            addObjectToDouble();
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(nodeIsDirectCallParameter2 + 1);
            genSimpleCompare(type, i, i2);
            ClassFileWriter classFileWriter3 = this.cfw;
            if (s != classFileWriter3.Wwwwwwwwwwwwwwwwwwwwww) {
                throw Codegen.badTree();
            }
            classFileWriter3.Wwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(nodeIsDirectCallParameter);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(nodeIsDirectCallParameter2);
        }
        if (type == 17 || type == 16) {
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(95);
        }
        addScriptRuntimeInvoke((type == 14 || type == 16) ? "cmp_LT" : "cmp_LE", "(Ljava/lang/Object;Ljava/lang/Object;)Z");
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(154, i);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(167, i2);
    }

    private void visitIncDec(Node node) {
        String str;
        String str2;
        int existingIntProp = node.getExistingIntProp(13);
        Node firstChild = node.getFirstChild();
        int type = firstChild.getType();
        if (type == 33) {
            Node firstChild2 = firstChild.getFirstChild();
            generateExpression(firstChild2, node);
            generateExpression(firstChild2.getNext(), node);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.contextLocal);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.variableObjectLocal);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwww(existingIntProp);
            str = "propIncrDecr";
            str2 = "(Ljava/lang/Object;Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;I)Ljava/lang/Object;";
        } else if (type == 34) {
            throw Kit.codeBug();
        } else {
            if (type == 36) {
                Node firstChild3 = firstChild.getFirstChild();
                generateExpression(firstChild3, node);
                generateExpression(firstChild3.getNext(), node);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.contextLocal);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.variableObjectLocal);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwww(existingIntProp);
                if (firstChild3.getNext().getIntProp(8, -1) != -1) {
                    addOptRuntimeInvoke("elemIncrDecr", "(Ljava/lang/Object;DLorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;I)Ljava/lang/Object;");
                    return;
                } else {
                    addScriptRuntimeInvoke("elemIncrDecr", "(Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;I)Ljava/lang/Object;");
                    return;
                }
            } else if (type == 39) {
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.variableObjectLocal);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(firstChild.getString());
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.contextLocal);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwww(existingIntProp);
                str = "nameIncrDecr";
                str2 = "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;Lorg/mozilla/javascript/Context;I)Ljava/lang/Object;";
            } else if (type == 55) {
                if (!this.hasVarsInRegs) {
                    Kit.codeBug();
                }
                boolean z = (existingIntProp & 2) != 0;
                int varIndex = this.fnCurrent.getVarIndex(firstChild);
                short s = this.varRegisters[varIndex];
                boolean z2 = this.fnCurrent.fnode.getParamAndVarConst()[varIndex];
                int intProp = node.getIntProp(8, -1);
                if (z2) {
                    if (intProp != -1) {
                        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s + (varIsDirectCallParameter(varIndex) ? 1 : 0));
                        if (z) {
                            return;
                        }
                        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1.0d);
                        if ((existingIntProp & 1) == 0) {
                            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(99);
                            return;
                        } else {
                            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(103);
                            return;
                        }
                    }
                    if (varIsDirectCallParameter(varIndex)) {
                        dcpLoadAsObject(s);
                    } else {
                        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) s);
                    }
                    if (z) {
                        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(89);
                        addObjectToDouble();
                        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(88);
                        return;
                    }
                    addObjectToDouble();
                    this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1.0d);
                    if ((existingIntProp & 1) == 0) {
                        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(99);
                    } else {
                        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(103);
                    }
                } else if (intProp != -1) {
                    boolean varIsDirectCallParameter = varIsDirectCallParameter(varIndex);
                    ClassFileWriter classFileWriter = this.cfw;
                    int i = s + (varIsDirectCallParameter ? 1 : 0);
                    classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
                    if (z) {
                        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(92);
                    }
                    this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1.0d);
                    if ((existingIntProp & 1) == 0) {
                        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(99);
                    } else {
                        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(103);
                    }
                    if (!z) {
                        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(92);
                    }
                    this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
                    return;
                } else {
                    if (varIsDirectCallParameter(varIndex)) {
                        dcpLoadAsObject(s);
                    } else {
                        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) s);
                    }
                    addObjectToDouble();
                    if (z) {
                        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(92);
                    }
                    this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1.0d);
                    if ((existingIntProp & 1) == 0) {
                        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(99);
                    } else {
                        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(103);
                    }
                    addDoubleWrap();
                    if (!z) {
                        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(89);
                    }
                    this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s);
                    if (!z) {
                        return;
                    }
                }
                addDoubleWrap();
                return;
            } else if (type != 68) {
                Codegen.badTree();
                return;
            } else {
                generateExpression(firstChild.getFirstChild(), node);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.contextLocal);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.variableObjectLocal);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwww(existingIntProp);
                str = "refIncrDecr";
                str2 = "(Lorg/mozilla/javascript/Ref;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;I)Ljava/lang/Object;";
            }
        }
        addScriptRuntimeInvoke(str, str2);
    }

    private void visitObjectLiteral(Node node, Node node2, boolean z) {
        boolean z2;
        ClassFileWriter classFileWriter;
        int i;
        Object[] objArr = (Object[]) node.getProp(12);
        int length = objArr.length;
        if (!z && ((length > 10 || this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwww > 30000) && !this.hasVarsInRegs && !this.isGenerator && !this.inLocalBlock)) {
            if (this.literals == null) {
                this.literals = new LinkedList();
            }
            this.literals.add(node);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.funObjLocal);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.contextLocal);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.variableObjectLocal);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.thisObjLocal);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.argsLocal);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(182, this.codegen.mainClassName, this.codegen.getBodyMethodName(this.scriptOrFn) + "_literal" + this.literals.size(), "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;");
            return;
        }
        if (this.isGenerator) {
            addLoadPropertyValues(node, node2, length);
            addLoadPropertyIds(objArr, length);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(95);
        } else {
            addLoadPropertyIds(objArr, length);
            addLoadPropertyValues(node, node2, length);
        }
        Node node3 = node2;
        for (int i2 = 0; i2 != length; i2++) {
            int type = node3.getType();
            if (type == 152 || type == 153) {
                z2 = true;
                break;
            }
            node3 = node3.getNext();
        }
        z2 = false;
        if (z2) {
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwww(length);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(188, 10);
            for (int i3 = 0; i3 != length; i3++) {
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(89);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwww(i3);
                int type2 = node2.getType();
                if (type2 == 152) {
                    classFileWriter = this.cfw;
                    i = 2;
                } else if (type2 == 153) {
                    classFileWriter = this.cfw;
                    i = 4;
                } else {
                    classFileWriter = this.cfw;
                    i = 3;
                }
                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(79);
                node2 = node2.getNext();
            }
        } else {
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        }
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.contextLocal);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.variableObjectLocal);
        addScriptRuntimeInvoke("newObjectLiteral", "([Ljava/lang/Object;[Ljava/lang/Object;[ILorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
    }

    private void visitOptimizedCall(Node node, OptFunctionNode optFunctionNode, int i, Node node2) {
        short newWordLocal;
        Node next = node2.getNext();
        String str = this.codegen.mainClassName;
        if (i == 30) {
            generateExpression(node2, node);
            newWordLocal = 0;
        } else {
            generateFunctionAndThisObj(node2, node);
            newWordLocal = getNewWordLocal();
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(newWordLocal);
        }
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(89);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(GpsStatusWrapper.QZSS_SVID_MIN, str);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(153, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(192, str);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(89);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(180, str, "_id", OptRuntime.GeneratorState.resumptionPoint_TYPE);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwww(this.codegen.getIndex(optFunctionNode.fnode));
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(160, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.contextLocal);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.variableObjectLocal);
        ClassFileWriter classFileWriter = this.cfw;
        if (i == 30) {
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        } else {
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) newWordLocal);
        }
        for (Node node3 = next; node3 != null; node3 = node3.getNext()) {
            int nodeIsDirectCallParameter = nodeIsDirectCallParameter(node3);
            if (nodeIsDirectCallParameter >= 0) {
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(nodeIsDirectCallParameter);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(nodeIsDirectCallParameter + 1);
            } else if (node3.getIntProp(8, -1) == 0) {
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(178, "java/lang/Void", "TYPE", "Ljava/lang/Class;");
                generateExpression(node3, node);
            } else {
                generateExpression(node3, node);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(RoundRectDrawableWithShadow.COS_45);
            }
        }
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(178, "org/mozilla/javascript/ScriptRuntime", "emptyArgs", "[Ljava/lang/Object;");
        ClassFileWriter classFileWriter2 = this.cfw;
        Codegen codegen = this.codegen;
        String str2 = codegen.mainClassName;
        FunctionNode functionNode = optFunctionNode.fnode;
        classFileWriter2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(184, str2, i == 30 ? codegen.getDirectCtorName(functionNode) : codegen.getBodyMethodName(functionNode), this.codegen.getBodyMethodSignature(optFunctionNode.fnode));
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(167, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.cfw.Wwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.contextLocal);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.variableObjectLocal);
        if (i != 30) {
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) newWordLocal);
            releaseWordLocal(newWordLocal);
        }
        generateCallArgArray(node, next, true);
        if (i == 30) {
            addScriptRuntimeInvoke("newObject", "(Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;");
        } else {
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(NormalCmdFactory.TASK_CANCEL_ALL, "org/mozilla/javascript/Callable", NotificationCompat.CATEGORY_CALL, "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Ljava/lang/Object;");
        }
        this.cfw.Wwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    private void visitSetConst(Node node, Node node2) {
        String string = node.getFirstChild().getString();
        while (node2 != null) {
            generateExpression(node2, node);
            node2 = node2.getNext();
        }
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.contextLocal);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(string);
        addScriptRuntimeInvoke("setConst", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Ljava/lang/String;)Ljava/lang/Object;");
    }

    private void visitSetConstVar(Node node, Node node2, boolean z) {
        short s;
        ClassFileWriter classFileWriter;
        int i;
        if (!this.hasVarsInRegs) {
            Kit.codeBug();
        }
        int varIndex = this.fnCurrent.getVarIndex(node);
        generateExpression(node2.getNext(), node);
        boolean z2 = node.getIntProp(8, -1) != -1;
        short s2 = this.varRegisters[varIndex];
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (z2) {
            int i2 = s2 + 2;
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(154, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            ClassFileWriter classFileWriter2 = this.cfw;
            s = classFileWriter2.Wwwwwwwwwwwwwwwwwwwwww;
            classFileWriter2.Wwwwwwwwwwwwwwwwwwwwwwwwww(1);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s2);
            ClassFileWriter classFileWriter3 = this.cfw;
            if (z) {
                classFileWriter3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s2);
                ClassFileWriter classFileWriter4 = this.cfw;
                classFileWriter4.Wwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                classFileWriter4.Wwwwwwwwwwwwwwwwwwwwww = s;
            } else {
                classFileWriter3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(167, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                ClassFileWriter classFileWriter5 = this.cfw;
                classFileWriter5.Wwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                classFileWriter5.Wwwwwwwwwwwwwwwwwwwwww = s;
                classFileWriter = this.cfw;
                i = 88;
                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
            }
        } else {
            int i3 = s2 + 1;
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(154, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            ClassFileWriter classFileWriter6 = this.cfw;
            s = classFileWriter6.Wwwwwwwwwwwwwwwwwwwwww;
            classFileWriter6.Wwwwwwwwwwwwwwwwwwwwwwwwww(1);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s2);
            ClassFileWriter classFileWriter7 = this.cfw;
            if (z) {
                classFileWriter7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) s2);
                ClassFileWriter classFileWriter42 = this.cfw;
                classFileWriter42.Wwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                classFileWriter42.Wwwwwwwwwwwwwwwwwwwwww = s;
            } else {
                classFileWriter7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(167, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                ClassFileWriter classFileWriter8 = this.cfw;
                classFileWriter8.Wwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                classFileWriter8.Wwwwwwwwwwwwwwwwwwwwww = s;
                classFileWriter = this.cfw;
                i = 87;
                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
            }
        }
        this.cfw.Wwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    private void visitSetElem(int i, Node node, Node node2) {
        String str;
        String str2;
        String str3;
        String str4;
        generateExpression(node2, node);
        Node next = node2.getNext();
        if (i == 141) {
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(89);
        }
        generateExpression(next, node);
        Node next2 = next.getNext();
        boolean z = node.getIntProp(8, -1) != -1;
        if (i == 141) {
            ClassFileWriter classFileWriter = this.cfw;
            if (z) {
                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(93);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.contextLocal);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.variableObjectLocal);
                str3 = "getObjectIndex";
                str4 = "(Ljava/lang/Object;DLorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
            } else {
                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(90);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.contextLocal);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.variableObjectLocal);
                str3 = "getObjectElem";
                str4 = "(Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
            }
            addScriptRuntimeInvoke(str3, str4);
        }
        generateExpression(next2, node);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.contextLocal);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.variableObjectLocal);
        if (z) {
            str = "setObjectIndex";
            str2 = "(Ljava/lang/Object;DLjava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
        } else {
            str = "setObjectElem";
            str2 = "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
        }
        addScriptRuntimeInvoke(str, str2);
    }

    private void visitSetName(Node node, Node node2) {
        String string = node.getFirstChild().getString();
        while (node2 != null) {
            generateExpression(node2, node);
            node2 = node2.getNext();
        }
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.contextLocal);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.variableObjectLocal);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(string);
        addScriptRuntimeInvoke("setName", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;)Ljava/lang/Object;");
    }

    private void visitSetProp(int i, Node node, Node node2) {
        String str;
        generateExpression(node2, node);
        Node next = node2.getNext();
        if (i == 140) {
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(89);
        }
        generateExpression(next, node);
        Node next2 = next.getNext();
        if (i == 140) {
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(90);
            if (node2.getType() == 43 && next.getType() == 41) {
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.contextLocal);
                str = "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;Lorg/mozilla/javascript/Context;)Ljava/lang/Object;";
            } else {
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.contextLocal);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.variableObjectLocal);
                str = "(Ljava/lang/Object;Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
            }
            addScriptRuntimeInvoke("getObjectProp", str);
        }
        generateExpression(next2, node);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.contextLocal);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.variableObjectLocal);
        addScriptRuntimeInvoke("setObjectProp", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;");
    }

    private void visitSetVar(Node node, Node node2, boolean z) {
        ClassFileWriter classFileWriter;
        int i;
        if (!this.hasVarsInRegs) {
            Kit.codeBug();
        }
        int varIndex = this.fnCurrent.getVarIndex(node);
        generateExpression(node2.getNext(), node);
        boolean z2 = node.getIntProp(8, -1) != -1;
        short s = this.varRegisters[varIndex];
        if (this.fnCurrent.fnode.getParamAndVarConst()[varIndex]) {
            if (z) {
                return;
            }
            if (z2) {
                classFileWriter = this.cfw;
                i = 88;
            } else {
                classFileWriter = this.cfw;
                i = 87;
            }
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
            return;
        }
        if (!varIsDirectCallParameter(varIndex)) {
            boolean isNumberVar = this.fnCurrent.isNumberVar(varIndex);
            if (!z2) {
                if (isNumberVar) {
                    Kit.codeBug();
                }
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s);
                if (!z) {
                    return;
                }
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) s);
                return;
            } else if (isNumberVar) {
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s);
                if (!z) {
                    return;
                }
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s);
                return;
            } else {
                if (z) {
                    this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(92);
                }
                addDoubleWrap();
            }
        } else if (z2) {
            if (z) {
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(92);
            }
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) s);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(178, "java/lang/Void", "TYPE", "Ljava/lang/Class;");
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(165, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            short s2 = this.cfw.Wwwwwwwwwwwwwwwwwwwwww;
            addDoubleWrap();
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(167, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            ClassFileWriter classFileWriter2 = this.cfw;
            classFileWriter2.Wwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            classFileWriter2.Wwwwwwwwwwwwwwwwwwwwww = s2;
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s + 1);
            this.cfw.Wwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            return;
        } else if (z) {
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(89);
        }
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s);
    }

    private void visitSpecialCall(Node node, int i, int i2, Node node2) {
        String str;
        String str2;
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.contextLocal);
        if (i == 30) {
            generateExpression(node2, node);
        } else {
            generateFunctionAndThisObj(node2, node);
        }
        generateCallArgArray(node, node2.getNext(), false);
        ClassFileWriter classFileWriter = this.cfw;
        if (i == 30) {
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.variableObjectLocal);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.thisObjLocal);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwww(i2);
            str = "newObjectSpecial";
            str2 = "(Lorg/mozilla/javascript/Context;Ljava/lang/Object;[Ljava/lang/Object;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;I)Ljava/lang/Object;";
        } else {
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.variableObjectLocal);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.thisObjLocal);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwww(i2);
            String sourceName = this.scriptOrFn.getSourceName();
            ClassFileWriter classFileWriter2 = this.cfw;
            if (sourceName == null) {
                sourceName = "";
            }
            classFileWriter2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sourceName);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwww(this.itsLineNumber);
            str = "callSpecial";
            str2 = "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Callable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;ILjava/lang/String;I)Ljava/lang/Object;";
        }
        addOptRuntimeInvoke(str, str2);
    }

    private void visitStandardCall(Node node, Node node2) {
        String str;
        String str2;
        if (node.getType() == 38) {
            Node next = node2.getNext();
            int type = node2.getType();
            if (next == null) {
                if (type == 39) {
                    this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(node2.getString());
                    str = "callName0";
                    str2 = "(Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
                } else if (type == 33) {
                    Node firstChild = node2.getFirstChild();
                    generateExpression(firstChild, node);
                    this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(firstChild.getNext().getString());
                    str = "callProp0";
                    str2 = "(Ljava/lang/Object;Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
                } else if (type == 34) {
                    throw Kit.codeBug();
                } else {
                    generateFunctionAndThisObj(node2, node);
                    str = "call0";
                    str2 = "(Lorg/mozilla/javascript/Callable;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
                }
            } else if (type == 39) {
                String string = node2.getString();
                generateCallArgArray(node, next, false);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(string);
                str = "callName";
                str2 = "([Ljava/lang/Object;Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
            } else {
                int i = 0;
                for (Node node3 = next; node3 != null; node3 = node3.getNext()) {
                    i++;
                }
                generateFunctionAndThisObj(node2, node);
                if (i == 1) {
                    generateExpression(next, node);
                    str = "call1";
                    str2 = "(Lorg/mozilla/javascript/Callable;Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
                } else if (i == 2) {
                    generateExpression(next, node);
                    generateExpression(next.getNext(), node);
                    str = "call2";
                    str2 = "(Lorg/mozilla/javascript/Callable;Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
                } else {
                    generateCallArgArray(node, next, false);
                    str = "callN";
                    str2 = "(Lorg/mozilla/javascript/Callable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
                }
            }
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.contextLocal);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.variableObjectLocal);
            addOptRuntimeInvoke(str, str2);
            return;
        }
        throw Codegen.badTree();
    }

    private void visitStandardNew(Node node, Node node2) {
        if (node.getType() == 30) {
            Node next = node2.getNext();
            generateExpression(node2, node);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.contextLocal);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.variableObjectLocal);
            generateCallArgArray(node, next, false);
            addScriptRuntimeInvoke("newObject", "(Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;");
            return;
        }
        throw Codegen.badTree();
    }

    private void visitStrictSetName(Node node, Node node2) {
        String string = node.getFirstChild().getString();
        while (node2 != null) {
            generateExpression(node2, node);
            node2 = node2.getNext();
        }
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.contextLocal);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.variableObjectLocal);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(string);
        addScriptRuntimeInvoke("strictSetName", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;)Ljava/lang/Object;");
    }

    private void visitSwitch(Jump jump, Node node) {
        generateExpression(node, jump);
        short newWordLocal = getNewWordLocal();
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(newWordLocal);
        Jump jump2 = node;
        while (true) {
            Jump jump3 = (Jump) jump2.getNext();
            if (jump3 == null) {
                releaseWordLocal(newWordLocal);
                return;
            } else if (jump3.getType() != 116) {
                throw Codegen.badTree();
            } else {
                generateExpression(jump3.getFirstChild(), jump3);
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) newWordLocal);
                addScriptRuntimeInvoke("shallowEq", "(Ljava/lang/Object;Ljava/lang/Object;)Z");
                addGoto(jump3.target, 154);
                jump2 = jump3;
            }
        }
    }

    private void visitTryCatchFinally(Jump jump, Node node) {
        int i;
        int i2;
        short newWordLocal = getNewWordLocal();
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.variableObjectLocal);
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(newWordLocal);
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        ClassFileWriter classFileWriter = this.cfw;
        classFileWriter.Wwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwww = (short) 0;
        Node node2 = jump.target;
        Node node3 = jump.getFinally();
        int[] iArr = new int[5];
        this.exceptionManager.pushExceptionInfo(jump);
        if (node2 != null) {
            iArr[0] = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            iArr[1] = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            iArr[2] = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            Context currentContext = Context.getCurrentContext();
            if (currentContext != null && currentContext.hasFeature(13)) {
                iArr[3] = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }
        if (node3 != null) {
            iArr[4] = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        this.exceptionManager.setHandlers(iArr, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (this.isGenerator && node3 != null) {
            FinallyReturnPoint finallyReturnPoint = new FinallyReturnPoint();
            if (this.finallys == null) {
                this.finallys = new HashMap();
            }
            this.finallys.put(node3, finallyReturnPoint);
            this.finallys.put(node3.getNext(), finallyReturnPoint);
        }
        for (Node node4 = node; node4 != null; node4 = node4.getNext()) {
            if (node4 == node2) {
                int targetLabel = getTargetLabel(node2);
                this.exceptionManager.removeHandler(0, targetLabel);
                this.exceptionManager.removeHandler(1, targetLabel);
                this.exceptionManager.removeHandler(2, targetLabel);
                this.exceptionManager.removeHandler(3, targetLabel);
            }
            generateStatement(node4);
        }
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(167, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        int localBlockRegister = getLocalBlockRegister(jump);
        if (node2 != null) {
            int labelId = node2.labelId();
            i = localBlockRegister;
            i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            generateCatchBlock(0, newWordLocal, labelId, localBlockRegister, iArr[0]);
            generateCatchBlock(1, newWordLocal, labelId, localBlockRegister, iArr[1]);
            generateCatchBlock(2, newWordLocal, labelId, localBlockRegister, iArr[2]);
            Context currentContext2 = Context.getCurrentContext();
            if (currentContext2 != null && currentContext2.hasFeature(13)) {
                generateCatchBlock(3, newWordLocal, labelId, i, iArr[3]);
            }
        } else {
            i = localBlockRegister;
            i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        }
        if (node3 != null) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.cfw.Wwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
            if (!this.isGenerator) {
                this.cfw.Wwwwwwwwwwwwwwwwww(iArr[4]);
            }
            int i3 = i;
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) newWordLocal);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.variableObjectLocal);
            int labelId2 = node3.labelId();
            if (this.isGenerator) {
                addGotoWithReturn(node3);
            } else {
                inlineFinally(node3, iArr[4], Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
            }
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
            if (this.isGenerator) {
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(192, "java/lang/Throwable");
            }
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(191);
            this.cfw.Wwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
            if (this.isGenerator) {
                this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, labelId2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, (String) null);
            }
        }
        releaseWordLocal(newWordLocal);
        this.cfw.Wwwwwwwwwwwwwwwwww(i2);
        if (!this.isGenerator) {
            this.exceptionManager.popExceptionInfo();
        }
    }

    private void visitTypeofname(Node node) {
        int indexForNameNode;
        if (!this.hasVarsInRegs || (indexForNameNode = this.fnCurrent.fnode.getIndexForNameNode(node)) < 0) {
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.variableObjectLocal);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(node.getString());
            addScriptRuntimeInvoke("typeofName", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;)Ljava/lang/String;");
        } else if (this.fnCurrent.isNumberVar(indexForNameNode)) {
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("number");
        } else if (!varIsDirectCallParameter(indexForNameNode)) {
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) this.varRegisters[indexForNameNode]);
            addScriptRuntimeInvoke("typeof", "(Ljava/lang/Object;)Ljava/lang/String;");
        } else {
            short s = this.varRegisters[indexForNameNode];
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) s);
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(178, "java/lang/Void", "TYPE", "Ljava/lang/Class;");
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(165, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            ClassFileWriter classFileWriter = this.cfw;
            short s2 = classFileWriter.Wwwwwwwwwwwwwwwwwwwwww;
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) s);
            addScriptRuntimeInvoke("typeof", "(Ljava/lang/Object;)Ljava/lang/String;");
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(167, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            ClassFileWriter classFileWriter2 = this.cfw;
            classFileWriter2.Wwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            classFileWriter2.Wwwwwwwwwwwwwwwwwwwwww = s2;
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("number");
            this.cfw.Wwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        }
    }

    public void generateBodyCode() {
        this.isGenerator = Codegen.isGenerator(this.scriptOrFn);
        initBodyGeneration();
        if (this.isGenerator) {
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("("), this.codegen.mainClassSignature, "Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;Ljava/lang/Object;I)Ljava/lang/Object;");
            ClassFileWriter classFileWriter = this.cfw;
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.codegen.getBodyMethodName(this.scriptOrFn) + "_gen", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, (short) 10);
        } else {
            this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.codegen.getBodyMethodName(this.scriptOrFn), this.codegen.getBodyMethodSignature(this.scriptOrFn), (short) 10);
        }
        generatePrologue();
        generateStatement(this.fnCurrent != null ? this.scriptOrFn.getLastChild() : this.scriptOrFn);
        generateEpilogue();
        this.cfw.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((short) (this.localsMax + 1));
        if (this.isGenerator) {
            generateGenerator();
        }
        if (this.literals != null) {
            for (int i = 0; i < this.literals.size(); i++) {
                Node node = this.literals.get(i);
                int type = node.getType();
                if (type == 66) {
                    generateArrayLiteralFactory(node, i + 1);
                } else if (type != 67) {
                    Kit.codeBug(Token.typeToName(type));
                } else {
                    generateObjectLiteralFactory(node, i + 1);
                }
            }
        }
    }
}
