package org.mozilla.javascript;

import org.mozilla.javascript.debug.DebuggableScript;

/* loaded from: classes5.dex */
public final class InterpretedFunction extends NativeFunction implements Script {
    public static final long serialVersionUID = 541475680333911468L;
    public InterpreterData idata;
    public SecurityController securityController;
    public Object securityDomain;

    public InterpretedFunction(InterpretedFunction interpretedFunction, int i) {
        this.idata = interpretedFunction.idata.itsNestedFunctions[i];
        this.securityController = interpretedFunction.securityController;
        this.securityDomain = interpretedFunction.securityDomain;
    }

    public InterpretedFunction(InterpreterData interpreterData, Object obj) {
        Object obj2;
        this.idata = interpreterData;
        SecurityController securityController = Context.getContext().getSecurityController();
        if (securityController != null) {
            obj2 = securityController.getDynamicSecurityDomain(obj);
        } else if (obj != null) {
            throw new IllegalArgumentException();
        } else {
            obj2 = null;
        }
        this.securityController = securityController;
        this.securityDomain = obj2;
    }

    public static InterpretedFunction createFunction(Context context, Scriptable scriptable, InterpretedFunction interpretedFunction, int i) {
        InterpretedFunction interpretedFunction2 = new InterpretedFunction(interpretedFunction, i);
        interpretedFunction2.initScriptFunction(context, scriptable);
        return interpretedFunction2;
    }

    public static InterpretedFunction createFunction(Context context, Scriptable scriptable, InterpreterData interpreterData, Object obj) {
        InterpretedFunction interpretedFunction = new InterpretedFunction(interpreterData, obj);
        interpretedFunction.initScriptFunction(context, scriptable);
        return interpretedFunction;
    }

    public static InterpretedFunction createScript(InterpreterData interpreterData, Object obj) {
        return new InterpretedFunction(interpreterData, obj);
    }

    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.Function, org.mozilla.javascript.Callable
    public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return !ScriptRuntime.hasTopCall(context) ? ScriptRuntime.doTopCall(this, context, scriptable, scriptable2, objArr, this.idata.isStrict) : Interpreter.interpret(this, context, scriptable, scriptable2, objArr);
    }

    @Override // org.mozilla.javascript.Script
    public Object exec(Context context, Scriptable scriptable) {
        if (isScript()) {
            return !ScriptRuntime.hasTopCall(context) ? ScriptRuntime.doTopCall(this, context, scriptable, scriptable, ScriptRuntime.emptyArgs, this.idata.isStrict) : Interpreter.interpret(this, context, scriptable, scriptable, ScriptRuntime.emptyArgs);
        }
        throw new IllegalStateException();
    }

    @Override // org.mozilla.javascript.NativeFunction
    public DebuggableScript getDebuggableView() {
        return this.idata;
    }

    @Override // org.mozilla.javascript.NativeFunction
    public String getEncodedSource() {
        return Interpreter.getEncodedSource(this.idata);
    }

    @Override // org.mozilla.javascript.BaseFunction
    public String getFunctionName() {
        String str = this.idata.itsName;
        return str == null ? "" : str;
    }

    @Override // org.mozilla.javascript.NativeFunction
    public int getLanguageVersion() {
        return this.idata.languageVersion;
    }

    @Override // org.mozilla.javascript.NativeFunction
    public int getParamAndVarCount() {
        return this.idata.argNames.length;
    }

    @Override // org.mozilla.javascript.NativeFunction
    public int getParamCount() {
        return this.idata.argCount;
    }

    @Override // org.mozilla.javascript.NativeFunction
    public boolean getParamOrVarConst(int i) {
        return this.idata.argIsConst[i];
    }

    @Override // org.mozilla.javascript.NativeFunction
    public String getParamOrVarName(int i) {
        return this.idata.argNames[i];
    }

    public boolean isScript() {
        return this.idata.itsFunctionType == 0;
    }

    @Override // org.mozilla.javascript.NativeFunction
    public Object resumeGenerator(Context context, Scriptable scriptable, int i, Object obj, Object obj2) {
        return Interpreter.resumeGenerator(context, scriptable, i, obj, obj2);
    }
}
