package org.mozilla.javascript.optimizer;

import androidx.cardview.widget.RoundRectDrawableWithShadow;
import androidx.core.app.NotificationCompat;
import androidx.core.location.GpsStatusWrapper;
import androidx.transition.Transition;
import com.arialyy.aria.core.command.NormalCmdFactory;
import com.tencent.smtt.sdk.TbsListener;
import com.umeng.analytics.pro.C1543ak;
import java.util.HashMap;
import java.util.List;
import me.tvspark.outline;
import org.mozilla.classfile.ClassFileWriter;
import org.mozilla.javascript.CompilerEnvirons;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Evaluator;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.GeneratedClassLoader;
import org.mozilla.javascript.Kit;
import org.mozilla.javascript.NativeFunction;
import org.mozilla.javascript.ObjArray;
import org.mozilla.javascript.ObjToIntMap;
import org.mozilla.javascript.RhinoException;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.SecurityController;
import org.mozilla.javascript.ast.FunctionNode;
import org.mozilla.javascript.ast.Name;
import org.mozilla.javascript.ast.ScriptNode;
import org.mozilla.javascript.optimizer.OptRuntime;

/* loaded from: classes5.dex */
public class Codegen implements Evaluator {
    public static final String DEFAULT_MAIN_METHOD_CLASS = "org.mozilla.javascript.optimizer.OptRuntime";
    public static final String FUNCTION_CONSTRUCTOR_SIGNATURE = "(Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Context;I)V";
    public static final String FUNCTION_INIT_SIGNATURE = "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)V";
    public static final String ID_FIELD_NAME = "_id";
    public static final String REGEXP_INIT_METHOD_NAME = "_reInit";
    public static final String REGEXP_INIT_METHOD_SIGNATURE = "(Lorg/mozilla/javascript/Context;)V";
    public static final String SUPER_CLASS_NAME = "org.mozilla.javascript.NativeFunction";
    public static final Object globalLock = new Object();
    public static int globalSerialClassCounter;
    public CompilerEnvirons compilerEnv;
    public ObjArray directCallTargets;
    public double[] itsConstantList;
    public int itsConstantListSize;
    public String mainClassName;
    public String mainClassSignature;
    public String mainMethodClass = DEFAULT_MAIN_METHOD_CLASS;
    public ObjToIntMap scriptOrFnIndexes;
    public ScriptNode[] scriptOrFnNodes;

    public static void addDoubleWrap(ClassFileWriter classFileWriter) {
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(184, "org/mozilla/javascript/optimizer/OptRuntime", "wrapDouble", "(D)Ljava/lang/Double;");
    }

    public static RuntimeException badTree() {
        throw new RuntimeException("Bad tree in codegen");
    }

    public static void collectScriptNodes_r(ScriptNode scriptNode, ObjArray objArray) {
        objArray.add(scriptNode);
        int functionCount = scriptNode.getFunctionCount();
        for (int i = 0; i != functionCount; i++) {
            collectScriptNodes_r(scriptNode.getFunctionNode(i), objArray);
        }
    }

    private Class<?> defineClass(Object obj, Object obj2) {
        Object[] objArr = (Object[]) obj;
        String str = (String) objArr[0];
        byte[] bArr = (byte[]) objArr[1];
        GeneratedClassLoader createLoader = SecurityController.createLoader(Codegen.class.getClassLoader(), obj2);
        try {
            Class<?> defineClass = createLoader.defineClass(str, bArr);
            createLoader.linkClass(defineClass);
            return defineClass;
        } catch (IllegalArgumentException | SecurityException e) {
            throw new RuntimeException("Malformed optimizer package " + e);
        }
    }

    private void emitConstantDudeInitializers(ClassFileWriter classFileWriter) {
        int i = this.itsConstantListSize;
        if (i == 0) {
            return;
        }
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("<clinit>", "()V", (short) 24);
        double[] dArr = this.itsConstantList;
        for (int i2 = 0; i2 != i; i2++) {
            double d = dArr[i2];
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("_k", i2);
            String staticConstantWrapperType = getStaticConstantWrapperType(d);
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, staticConstantWrapperType, (short) 10);
            int i3 = (int) d;
            if (i3 == d) {
                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwww(i3);
                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            } else {
                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(d);
                addDoubleWrap(classFileWriter);
            }
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(179, this.mainClassName, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, staticConstantWrapperType);
        }
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(177);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((short) 0);
    }

    private void emitDirectConstructor(ClassFileWriter classFileWriter, OptFunctionNode optFunctionNode) {
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getDirectCtorName(optFunctionNode.fnode), getBodyMethodSignature(optFunctionNode.fnode), (short) 10);
        int paramCount = optFunctionNode.fnode.getParamCount();
        int i = (paramCount * 3) + 4;
        int i2 = i + 1;
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(182, "org/mozilla/javascript/BaseFunction", "createObject", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
        for (int i3 = 0; i3 < paramCount; i3++) {
            int i4 = i3 * 3;
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4 + 4);
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4 + 5);
        }
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(184, this.mainClassName, getBodyMethodName(optFunctionNode.fnode), getBodyMethodSignature(optFunctionNode.fnode));
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(89);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(GpsStatusWrapper.QZSS_SVID_MIN, "org/mozilla/javascript/Scriptable");
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(153, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(192, "org/mozilla/javascript/Scriptable");
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6);
        classFileWriter.Wwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((short) (i2 + 1));
    }

    private void emitRegExpInit(ClassFileWriter classFileWriter) {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            ScriptNode[] scriptNodeArr = this.scriptOrFnNodes;
            if (i2 == scriptNodeArr.length) {
                break;
            }
            i3 += scriptNodeArr[i2].getRegexpCount();
            i2++;
        }
        if (i3 == 0) {
            return;
        }
        short s = 10;
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(REGEXP_INIT_METHOD_NAME, REGEXP_INIT_METHOD_SIGNATURE, (short) 10);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("_reInitDone", "Z", (short) 74);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(178, this.mainClassName, "_reInitDone", "Z");
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(153, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(177);
        classFileWriter.Wwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(184, "org/mozilla/javascript/ScriptRuntime", "checkRegExpProxy", "(Lorg/mozilla/javascript/Context;)Lorg/mozilla/javascript/RegExpProxy;");
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        int i4 = 0;
        while (true) {
            ScriptNode[] scriptNodeArr2 = this.scriptOrFnNodes;
            if (i4 == scriptNodeArr2.length) {
                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwww(1);
                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(179, this.mainClassName, "_reInitDone", "Z");
                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(177);
                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((short) 2);
                return;
            }
            ScriptNode scriptNode = scriptNodeArr2[i4];
            int regexpCount = scriptNode.getRegexpCount();
            int i5 = 0;
            while (i5 != regexpCount) {
                String compiledRegexpName = getCompiledRegexpName(scriptNode, i5);
                String regexpString = scriptNode.getRegexpString(i5);
                String regexpFlags = scriptNode.getRegexpFlags(i5);
                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(compiledRegexpName, "Ljava/lang/Object;", s);
                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(regexpString);
                if (regexpFlags == null) {
                    classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                } else {
                    classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(regexpFlags);
                }
                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(NormalCmdFactory.TASK_CANCEL_ALL, "org/mozilla/javascript/RegExpProxy", "compileRegExp", "(Lorg/mozilla/javascript/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;");
                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(179, this.mainClassName, compiledRegexpName, "Ljava/lang/Object;");
                i5++;
                i = 0;
                s = 10;
            }
            i4++;
            i = 0;
            s = 10;
        }
    }

    private void generateCallMethod(ClassFileWriter classFileWriter, boolean z) {
        int i;
        int paramCount;
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(NotificationCompat.CATEGORY_CALL, "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Ljava/lang/Object;", (short) 17);
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(184, "org/mozilla/javascript/ScriptRuntime", "hasTopCall", "(Lorg/mozilla/javascript/Context;)Z");
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(154, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z ? 4 : 3);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(184, "org/mozilla/javascript/ScriptRuntime", "doTopCall", "(Lorg/mozilla/javascript/Callable;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;Z)Ljava/lang/Object;");
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6);
        classFileWriter.Wwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
        int length = this.scriptOrFnNodes.length;
        boolean z2 = 2 <= length;
        if (z2) {
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(42);
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(180, classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "_id", OptRuntime.GeneratorState.resumptionPoint_TYPE);
            i = classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1, length - 1);
        } else {
            i = 0;
        }
        short s = 0;
        for (int i2 = 0; i2 != length; i2++) {
            ScriptNode scriptNode = this.scriptOrFnNodes[i2];
            if (z2) {
                if (i2 == 0) {
                    classFileWriter.Wwwwwwwwwwwwwwwww(i);
                    s = classFileWriter.Wwwwwwwwwwwwwwwwwwwwww;
                } else {
                    classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2 - 1, s);
                }
            }
            if (scriptNode.getType() == 110) {
                OptFunctionNode optFunctionNode = OptFunctionNode.get(scriptNode);
                if (optFunctionNode.isTargetOfDirectCall() && (paramCount = optFunctionNode.fnode.getParamCount()) != 0) {
                    for (int i3 = 0; i3 != paramCount; i3++) {
                        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(190);
                        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwww(i3);
                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(164, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwww(i3);
                        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(50);
                        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(167, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                        classFileWriter.Wwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                        pushUndefined(classFileWriter);
                        classFileWriter.Wwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                        classFileWriter.Wwwwwwwwwwwwwwwwwwwww(-1);
                        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(RoundRectDrawableWithShadow.COS_45);
                        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                    }
                }
            }
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(184, this.mainClassName, getBodyMethodName(scriptNode), getBodyMethodSignature(scriptNode));
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6);
        }
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((short) 5);
    }

    private byte[] generateCode(String str) {
        boolean z = true;
        boolean z2 = this.scriptOrFnNodes[0].getType() == 137;
        if (this.scriptOrFnNodes.length <= 1 && z2) {
            z = false;
        }
        boolean isInStrictMode = this.scriptOrFnNodes[0].isInStrictMode();
        String str2 = null;
        if (this.compilerEnv.isGenerateDebugInfo()) {
            str2 = this.scriptOrFnNodes[0].getSourceName();
        }
        ClassFileWriter classFileWriter = new ClassFileWriter(this.mainClassName, SUPER_CLASS_NAME, str2);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("_id", OptRuntime.GeneratorState.resumptionPoint_TYPE, (short) 2);
        if (z) {
            generateFunctionConstructor(classFileWriter);
        }
        if (z2) {
            classFileWriter.Wwwwwwwwwwwwwwwww.add(Short.valueOf(classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("org/mozilla/javascript/Script")));
            generateScriptCtor(classFileWriter);
            generateMain(classFileWriter);
            generateExecute(classFileWriter);
        }
        generateCallMethod(classFileWriter, isInStrictMode);
        generateResumeGenerator(classFileWriter);
        generateNativeFunctionOverrides(classFileWriter, str);
        int length = this.scriptOrFnNodes.length;
        for (int i = 0; i != length; i++) {
            ScriptNode scriptNode = this.scriptOrFnNodes[i];
            BodyCodegen bodyCodegen = new BodyCodegen();
            bodyCodegen.cfw = classFileWriter;
            bodyCodegen.codegen = this;
            bodyCodegen.compilerEnv = this.compilerEnv;
            bodyCodegen.scriptOrFn = scriptNode;
            bodyCodegen.scriptOrFnIndex = i;
            bodyCodegen.generateBodyCode();
            if (scriptNode.getType() == 110) {
                OptFunctionNode optFunctionNode = OptFunctionNode.get(scriptNode);
                generateFunctionInit(classFileWriter, optFunctionNode);
                if (optFunctionNode.isTargetOfDirectCall()) {
                    emitDirectConstructor(classFileWriter, optFunctionNode);
                }
            }
        }
        emitRegExpInit(classFileWriter);
        emitConstantDudeInitializers(classFileWriter);
        return classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    private void generateExecute(ClassFileWriter classFileWriter) {
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("exec", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;", (short) 17);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(42);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(89);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(182, classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, NotificationCompat.CATEGORY_CALL, "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Ljava/lang/Object;");
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((short) 3);
    }

    private void generateFunctionConstructor(ClassFileWriter classFileWriter) {
        int i;
        boolean z = true;
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("<init>", FUNCTION_CONSTRUCTOR_SIGNATURE, (short) 1);
        short s = 0;
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(183, SUPER_CLASS_NAME, "<init>", "()V");
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(42);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(181, classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "_id", OptRuntime.GeneratorState.resumptionPoint_TYPE);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(42);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        int i2 = this.scriptOrFnNodes[0].getType() == 137 ? 1 : 0;
        int length = this.scriptOrFnNodes.length;
        if (i2 != length) {
            if (2 > length - i2) {
                z = false;
            }
            if (z) {
                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
                i = classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2 + 1, length - 1);
            } else {
                i = 0;
            }
            for (int i3 = i2; i3 != length; i3++) {
                if (z) {
                    if (i3 == i2) {
                        classFileWriter.Wwwwwwwwwwwwwwwww(i);
                        s = classFileWriter.Wwwwwwwwwwwwwwwwwwwwww;
                    } else {
                        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, (i3 - 1) - i2, s);
                    }
                }
                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(183, this.mainClassName, getFunctionInitMethodName(OptFunctionNode.get(this.scriptOrFnNodes[i3])), FUNCTION_INIT_SIGNATURE);
                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(177);
            }
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((short) 4);
            return;
        }
        throw badTree();
    }

    private void generateFunctionInit(ClassFileWriter classFileWriter, OptFunctionNode optFunctionNode) {
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getFunctionInitMethodName(optFunctionNode), FUNCTION_INIT_SIGNATURE, (short) 18);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(42);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(182, "org/mozilla/javascript/NativeFunction", "initScriptFunction", FUNCTION_INIT_SIGNATURE);
        if (optFunctionNode.fnode.getRegexpCount() != 0) {
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(184, this.mainClassName, REGEXP_INIT_METHOD_NAME, REGEXP_INIT_METHOD_SIGNATURE);
        }
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(177);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((short) 3);
    }

    private void generateMain(ClassFileWriter classFileWriter) {
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("main", "([Ljava/lang/String;)V", (short) 9);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(187, classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(89);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(183, classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "<init>", "()V");
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(42);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(184, this.mainMethodClass, "main", "(Lorg/mozilla/javascript/Script;[Ljava/lang/String;)V");
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(177);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((short) 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void generateNativeFunctionOverrides(ClassFileWriter classFileWriter, String str) {
        short s;
        int length;
        int i;
        int i2;
        int i3;
        String str2;
        short s2 = 1;
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("getLanguageVersion", "()I", (short) 1);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwww(this.compilerEnv.getLanguageVersion());
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_2);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((short) 1);
        int i4 = 0;
        while (i4 != 6) {
            int i5 = 4;
            if (i4 != 4 || str != null) {
                int i6 = 5;
                int i7 = 2;
                int i8 = 3;
                if (i4 != 0) {
                    if (i4 == s2) {
                        str2 = "getParamCount";
                    } else if (i4 != 2) {
                        if (i4 == 3) {
                            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("getParamOrVarName", "(I)Ljava/lang/String;", s2);
                            s = 2;
                        } else if (i4 == 4) {
                            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("getEncodedSource", "()Ljava/lang/String;", s2);
                            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
                        } else if (i4 != 5) {
                            throw Kit.codeBug();
                        } else {
                            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("getParamOrVarConst", "(I)Z", s2);
                            s = 3;
                        }
                        length = this.scriptOrFnNodes.length;
                        if (length <= s2) {
                            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(42);
                            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(180, classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "_id", OptRuntime.GeneratorState.resumptionPoint_TYPE);
                            i = classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s2, length - 1);
                        } else {
                            i = 0;
                        }
                        int i9 = 0;
                        i2 = 0;
                        while (i2 != length) {
                            ScriptNode scriptNode = this.scriptOrFnNodes[i2];
                            if (i2 != 0) {
                                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2 - 1, i9);
                            } else if (length > s2) {
                                classFileWriter.Wwwwwwwwwwwwwwwww(i);
                                i9 = classFileWriter.Wwwwwwwwwwwwwwwwwwwwww;
                            }
                            int i10 = TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6;
                            if (i4 != 0) {
                                if (i4 == s2) {
                                    i3 = TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_2;
                                    classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwww(scriptNode.getParamCount());
                                } else if (i4 != i7) {
                                    if (i4 == i8) {
                                        int paramAndVarCount = scriptNode.getParamAndVarCount();
                                        if (paramAndVarCount == 0) {
                                            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) s2);
                                        } else if (paramAndVarCount == s2) {
                                            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(scriptNode.getParamOrVarName(0));
                                        } else {
                                            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(s2);
                                            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s2, paramAndVarCount - 1);
                                            for (int i11 = 0; i11 != paramAndVarCount; i11++) {
                                                if (classFileWriter.Wwwwwwwwwwwwwwwwwwwwww != 0) {
                                                    Kit.codeBug();
                                                }
                                                String paramOrVarName = scriptNode.getParamOrVarName(i11);
                                                if (i11 == 0) {
                                                    classFileWriter.Wwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                                } else {
                                                    classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i11 - 1, 0);
                                                }
                                                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(paramOrVarName);
                                                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6);
                                            }
                                        }
                                    } else if (i4 == i5) {
                                        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwww(scriptNode.getEncodedSourceStart());
                                        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwww(scriptNode.getEncodedSourceEnd());
                                        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(182, "java/lang/String", "substring", "(II)Ljava/lang/String;");
                                    } else if (i4 != i6) {
                                        throw Kit.codeBug();
                                    } else {
                                        int paramAndVarCount2 = scriptNode.getParamAndVarCount();
                                        boolean[] paramAndVarConst = scriptNode.getParamAndVarConst();
                                        if (paramAndVarCount2 == 0) {
                                            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i8);
                                            i10 = TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_2;
                                        } else if (paramAndVarCount2 == s2) {
                                            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(paramAndVarConst[0]);
                                            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_2);
                                        } else {
                                            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(s2);
                                            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s2, paramAndVarCount2 - 1);
                                            for (int i12 = 0; i12 != paramAndVarCount2; i12++) {
                                                if (classFileWriter.Wwwwwwwwwwwwwwwwwwwwww != 0) {
                                                    Kit.codeBug();
                                                }
                                                if (i12 == 0) {
                                                    classFileWriter.Wwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                                                } else {
                                                    classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, i12 - 1, 0);
                                                }
                                                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(paramAndVarConst[i12]);
                                                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_2);
                                            }
                                        }
                                    }
                                    classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i10);
                                } else {
                                    classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwww(scriptNode.getParamAndVarCount());
                                    i3 = TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_2;
                                }
                                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
                            } else {
                                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(scriptNode.getType() == 137 ? "" : ((FunctionNode) scriptNode).getName());
                                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6);
                            }
                            i2++;
                            s2 = 1;
                            i5 = 4;
                            i6 = 5;
                            i7 = 2;
                            i8 = 3;
                        }
                        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s);
                    } else {
                        str2 = "getParamAndVarCount";
                    }
                    classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, "()I", s2);
                } else {
                    classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("getFunctionName", "()Ljava/lang/String;", s2);
                }
                s = 1;
                length = this.scriptOrFnNodes.length;
                if (length <= s2) {
                }
                int i92 = 0;
                i2 = 0;
                while (i2 != length) {
                }
                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s);
            }
            i4++;
            s2 = 1;
        }
    }

    private void generateResumeGenerator(ClassFileWriter classFileWriter) {
        int i = 0;
        int i2 = 0;
        boolean z = false;
        while (true) {
            ScriptNode[] scriptNodeArr = this.scriptOrFnNodes;
            if (i2 >= scriptNodeArr.length) {
                break;
            }
            if (isGenerator(scriptNodeArr[i2])) {
                z = true;
            }
            i2++;
        }
        if (!z) {
            return;
        }
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("resumeGenerator", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", (short) 17);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(5);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(42);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(180, classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "_id", OptRuntime.GeneratorState.resumptionPoint_TYPE);
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, this.scriptOrFnNodes.length - 1);
        classFileWriter.Wwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        while (true) {
            ScriptNode[] scriptNodeArr2 = this.scriptOrFnNodes;
            if (i >= scriptNodeArr2.length) {
                classFileWriter.Wwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                pushUndefined(classFileWriter);
                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6);
                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((short) 6);
                return;
            }
            ScriptNode scriptNode = scriptNodeArr2[i];
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i, 6);
            if (isGenerator(scriptNode)) {
                String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("("), this.mainClassSignature, "Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;Ljava/lang/Object;I)Ljava/lang/Object;");
                String str = this.mainClassName;
                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(184, str, getBodyMethodName(scriptNode) + "_gen", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6);
            } else {
                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(167, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            i++;
        }
    }

    private void generateScriptCtor(ClassFileWriter classFileWriter) {
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("<init>", "()V", (short) 1);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(42);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(183, SUPER_CLASS_NAME, "<init>", "()V");
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(42);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwww(0);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(181, classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "_id", OptRuntime.GeneratorState.resumptionPoint_TYPE);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(177);
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((short) 1);
    }

    public static String getStaticConstantWrapperType(double d) {
        return ((double) ((int) d)) == d ? "Ljava/lang/Integer;" : "Ljava/lang/Double;";
    }

    public static void initOptFunctions_r(ScriptNode scriptNode) {
        int functionCount = scriptNode.getFunctionCount();
        for (int i = 0; i != functionCount; i++) {
            FunctionNode functionNode = scriptNode.getFunctionNode(i);
            new OptFunctionNode(functionNode);
            initOptFunctions_r(functionNode);
        }
    }

    private void initScriptNodesData(ScriptNode scriptNode) {
        ObjArray objArray = new ObjArray();
        collectScriptNodes_r(scriptNode, objArray);
        int size = objArray.size();
        ScriptNode[] scriptNodeArr = new ScriptNode[size];
        this.scriptOrFnNodes = scriptNodeArr;
        objArray.toArray(scriptNodeArr);
        this.scriptOrFnIndexes = new ObjToIntMap(size);
        for (int i = 0; i != size; i++) {
            this.scriptOrFnIndexes.put(this.scriptOrFnNodes[i], i);
        }
    }

    public static boolean isGenerator(ScriptNode scriptNode) {
        return scriptNode.getType() == 110 && ((FunctionNode) scriptNode).isGenerator();
    }

    public static void pushUndefined(ClassFileWriter classFileWriter) {
        classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(178, "org/mozilla/javascript/Undefined", Transition.MATCH_INSTANCE_STR, "Ljava/lang/Object;");
    }

    private void transform(ScriptNode scriptNode) {
        initOptFunctions_r(scriptNode);
        int optimizationLevel = this.compilerEnv.getOptimizationLevel();
        HashMap hashMap = null;
        if (optimizationLevel > 0 && scriptNode.getType() == 137) {
            int functionCount = scriptNode.getFunctionCount();
            for (int i = 0; i != functionCount; i++) {
                OptFunctionNode optFunctionNode = OptFunctionNode.get(scriptNode, i);
                if (optFunctionNode.fnode.getFunctionType() == 1) {
                    String name = optFunctionNode.fnode.getName();
                    if (name.length() != 0) {
                        if (hashMap == null) {
                            hashMap = new HashMap();
                        }
                        hashMap.put(name, optFunctionNode);
                    }
                }
            }
        }
        if (hashMap != null) {
            this.directCallTargets = new ObjArray();
        }
        new OptTransformer(hashMap, this.directCallTargets).transform(scriptNode, this.compilerEnv);
        if (optimizationLevel > 0) {
            new Optimizer().optimize(scriptNode);
        }
    }

    @Override // org.mozilla.javascript.Evaluator
    public void captureStackInfo(RhinoException rhinoException) {
        throw new UnsupportedOperationException();
    }

    public String cleanName(ScriptNode scriptNode) {
        if (scriptNode instanceof FunctionNode) {
            Name functionName = ((FunctionNode) scriptNode).getFunctionName();
            return functionName == null ? "anonymous" : functionName.getIdentifier();
        }
        return "script";
    }

    @Override // org.mozilla.javascript.Evaluator
    public Object compile(CompilerEnvirons compilerEnvirons, ScriptNode scriptNode, String str, boolean z) {
        int i;
        String str2;
        synchronized (globalLock) {
            i = globalSerialClassCounter + 1;
            globalSerialClassCounter = i;
        }
        if (scriptNode.getSourceName().length() > 0) {
            str2 = scriptNode.getSourceName().replaceAll("\\W", "_");
            if (!Character.isJavaIdentifierStart(str2.charAt(0))) {
                str2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("_", str2);
            }
        } else {
            str2 = C1543ak.f2969aF;
        }
        String str3 = "org.mozilla.javascript.gen." + str2 + "_" + i;
        return new Object[]{str3, compileToClassFile(compilerEnvirons, str3, scriptNode, str, z)};
    }

    public byte[] compileToClassFile(CompilerEnvirons compilerEnvirons, String str, ScriptNode scriptNode, String str2, boolean z) {
        this.compilerEnv = compilerEnvirons;
        transform(scriptNode);
        if (z) {
            scriptNode = scriptNode.getFunctionNode(0);
        }
        initScriptNodesData(scriptNode);
        this.mainClassName = str;
        this.mainClassSignature = ClassFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
        return generateCode(str2);
    }

    @Override // org.mozilla.javascript.Evaluator
    public Function createFunctionObject(Context context, Scriptable scriptable, Object obj, Object obj2) {
        try {
            return (NativeFunction) defineClass(obj, obj2).getConstructors()[0].newInstance(scriptable, context, 0);
        } catch (Exception e) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unable to instantiate compiled class:");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.toString());
            throw new RuntimeException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
    }

    @Override // org.mozilla.javascript.Evaluator
    public Script createScriptObject(Object obj, Object obj2) {
        try {
            return (Script) defineClass(obj, obj2).newInstance();
        } catch (Exception e) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unable to instantiate compiled class:");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.toString());
            throw new RuntimeException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
    }

    public String getBodyMethodName(ScriptNode scriptNode) {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("_c_");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(cleanName(scriptNode));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("_");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getIndex(scriptNode));
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    public String getBodyMethodSignature(ScriptNode scriptNode) {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('(');
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mainClassSignature);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;");
        if (scriptNode.getType() == 110) {
            OptFunctionNode optFunctionNode = OptFunctionNode.get(scriptNode);
            if (optFunctionNode.isTargetOfDirectCall()) {
                int paramCount = optFunctionNode.fnode.getParamCount();
                for (int i = 0; i != paramCount; i++) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("Ljava/lang/Object;D");
                }
            }
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("[Ljava/lang/Object;)Ljava/lang/Object;");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    public String getCompiledRegexpName(ScriptNode scriptNode, int i) {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("_re");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getIndex(scriptNode));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("_");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(i);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    public String getDirectCtorName(ScriptNode scriptNode) {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("_n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getIndex(scriptNode));
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    public String getFunctionInitMethodName(OptFunctionNode optFunctionNode) {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("_i");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getIndex(optFunctionNode.fnode));
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    public int getIndex(ScriptNode scriptNode) {
        return this.scriptOrFnIndexes.getExisting(scriptNode);
    }

    @Override // org.mozilla.javascript.Evaluator
    public String getPatchedStack(RhinoException rhinoException, String str) {
        throw new UnsupportedOperationException();
    }

    @Override // org.mozilla.javascript.Evaluator
    public List<String> getScriptStack(RhinoException rhinoException) {
        throw new UnsupportedOperationException();
    }

    @Override // org.mozilla.javascript.Evaluator
    public String getSourcePositionFromStack(Context context, int[] iArr) {
        throw new UnsupportedOperationException();
    }

    public void pushNumberAsObject(ClassFileWriter classFileWriter, double d) {
        String str;
        if (d == RoundRectDrawableWithShadow.COS_45) {
            if (1.0d / d > RoundRectDrawableWithShadow.COS_45) {
                str = "zeroObj";
                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(178, "org/mozilla/javascript/optimizer/OptRuntime", str, "Ljava/lang/Double;");
            }
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(d);
            addDoubleWrap(classFileWriter);
        } else if (d == 1.0d) {
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(178, "org/mozilla/javascript/optimizer/OptRuntime", "oneObj", "Ljava/lang/Double;");
        } else if (d == -1.0d) {
            str = "minusOneObj";
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(178, "org/mozilla/javascript/optimizer/OptRuntime", str, "Ljava/lang/Double;");
        } else if (d != d) {
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(178, "org/mozilla/javascript/ScriptRuntime", "NaNobj", "Ljava/lang/Double;");
        } else {
            int i = this.itsConstantListSize;
            if (i < 2000) {
                int i2 = 0;
                if (i == 0) {
                    this.itsConstantList = new double[64];
                } else {
                    double[] dArr = this.itsConstantList;
                    int i3 = 0;
                    while (i3 != i && dArr[i3] != d) {
                        i3++;
                    }
                    if (i == dArr.length) {
                        double[] dArr2 = new double[i * 2];
                        System.arraycopy(this.itsConstantList, 0, dArr2, 0, i);
                        this.itsConstantList = dArr2;
                    }
                    i2 = i3;
                }
                if (i2 == i) {
                    this.itsConstantList[i] = d;
                    this.itsConstantListSize = i + 1;
                }
                classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(178, this.mainClassName, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("_k", i2), getStaticConstantWrapperType(d));
                return;
            }
            classFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(d);
            addDoubleWrap(classFileWriter);
        }
    }

    @Override // org.mozilla.javascript.Evaluator
    public void setEvalScriptFlag(Script script) {
        throw new UnsupportedOperationException();
    }

    public void setMainMethodClass(String str) {
        this.mainMethodClass = str;
    }
}
