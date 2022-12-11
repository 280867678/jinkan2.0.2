package org.mozilla.javascript;

import org.simpleframework.xml.core.AnnotationHandler;

/* loaded from: classes5.dex */
public class NativeScript extends BaseFunction {
    public static final int Id_compile = 3;
    public static final int Id_constructor = 1;
    public static final int Id_exec = 4;
    public static final int Id_toString = 2;
    public static final int MAX_PROTOTYPE_ID = 4;
    public static final Object SCRIPT_TAG = "Script";
    public static final long serialVersionUID = -6795101161980121700L;
    public Script script;

    public NativeScript(Script script) {
        this.script = script;
    }

    public static Script compile(Context context, String str) {
        int[] iArr = {0};
        String sourcePositionFromStack = Context.getSourcePositionFromStack(iArr);
        if (sourcePositionFromStack == null) {
            iArr[0] = 1;
            sourcePositionFromStack = "<Script object>";
        }
        return context.compileString(str, null, DefaultErrorReporter.forEval(context.getErrorReporter()), sourcePositionFromStack, iArr[0], null);
    }

    public static void init(Scriptable scriptable, boolean z) {
        new NativeScript(null).exportAsJSClass(4, scriptable, z);
    }

    public static NativeScript realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (scriptable instanceof NativeScript) {
            return (NativeScript) scriptable;
        }
        throw IdScriptableObject.incompatibleCallError(idFunctionObject);
    }

    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.Function, org.mozilla.javascript.Callable
    public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Script script = this.script;
        return script != null ? script.exec(context, scriptable) : Undefined.instance;
    }

    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.Function
    public Scriptable construct(Context context, Scriptable scriptable, Object[] objArr) {
        throw Context.reportRuntimeError0("msg.script.is.not.constructor");
    }

    @Override // org.mozilla.javascript.BaseFunction
    public String decompile(int i, int i2) {
        Script script = this.script;
        return script instanceof NativeFunction ? ((NativeFunction) script).decompile(i, i2) : super.decompile(i, i2);
    }

    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(SCRIPT_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int methodId = idFunctionObject.methodId();
        String str = "";
        if (methodId == 1) {
            if (objArr.length != 0) {
                str = ScriptRuntime.toString(objArr[0]);
            }
            NativeScript nativeScript = new NativeScript(compile(context, str));
            ScriptRuntime.setObjectProtoAndParent(nativeScript, scriptable);
            return nativeScript;
        } else if (methodId == 2) {
            Script script = realThis(scriptable2, idFunctionObject).script;
            return script == null ? str : context.decompileScript(script, 0);
        } else if (methodId != 3) {
            if (methodId == 4) {
                throw Context.reportRuntimeError1("msg.cant.call.indirect", "exec");
            }
            throw new IllegalArgumentException(String.valueOf(methodId));
        } else {
            NativeScript realThis = realThis(scriptable2, idFunctionObject);
            realThis.script = compile(context, ScriptRuntime.toString(objArr, 0));
            return realThis;
        }
    }

    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(String str) {
        String str2;
        int length = str.length();
        int i = 4;
        if (length == 4) {
            str2 = "exec";
        } else if (length == 11) {
            i = 1;
            str2 = "constructor";
        } else if (length == 7) {
            i = 3;
            str2 = "compile";
        } else if (length != 8) {
            str2 = null;
            i = 0;
        } else {
            i = 2;
            str2 = AnnotationHandler.STRING;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }

    @Override // org.mozilla.javascript.BaseFunction
    public int getArity() {
        return 0;
    }

    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Script";
    }

    @Override // org.mozilla.javascript.BaseFunction
    public int getLength() {
        return 0;
    }

    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i) {
        String str;
        String str2;
        int i2 = 0;
        if (i != 1) {
            if (i == 2) {
                str2 = AnnotationHandler.STRING;
            } else if (i == 3) {
                str = "compile";
            } else if (i != 4) {
                throw new IllegalArgumentException(String.valueOf(i));
            } else {
                str2 = "exec";
            }
            initPrototypeMethod(SCRIPT_TAG, i, str2, i2);
        }
        str = "constructor";
        str2 = str;
        i2 = 1;
        initPrototypeMethod(SCRIPT_TAG, i, str2, i2);
    }
}
