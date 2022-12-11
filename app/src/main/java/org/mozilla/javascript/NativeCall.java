package org.mozilla.javascript;

/* loaded from: classes5.dex */
public final class NativeCall extends IdScriptableObject {
    public static final Object CALL_TAG = "Call";
    public static final int Id_constructor = 1;
    public static final int MAX_PROTOTYPE_ID = 1;
    public static final long serialVersionUID = -7471457301304454454L;
    public Arguments arguments;
    public NativeFunction function;
    public boolean isStrict;
    public Object[] originalArgs;
    public transient NativeCall parentActivationCall;

    public NativeCall() {
    }

    public NativeCall(NativeFunction nativeFunction, Scriptable scriptable, Object[] objArr, boolean z, boolean z2) {
        this.function = nativeFunction;
        setParentScope(scriptable);
        this.originalArgs = objArr == null ? ScriptRuntime.emptyArgs : objArr;
        this.isStrict = z2;
        int paramAndVarCount = nativeFunction.getParamAndVarCount();
        int paramCount = nativeFunction.getParamCount();
        if (paramAndVarCount != 0) {
            int i = 0;
            while (i < paramCount) {
                defineProperty(nativeFunction.getParamOrVarName(i), i < objArr.length ? objArr[i] : Undefined.instance, 4);
                i++;
            }
        }
        if (!super.has("arguments", this) && !z) {
            Arguments arguments = new Arguments(this);
            this.arguments = arguments;
            defineProperty("arguments", arguments, 4);
        }
        if (paramAndVarCount != 0) {
            while (paramCount < paramAndVarCount) {
                String paramOrVarName = nativeFunction.getParamOrVarName(paramCount);
                if (!super.has(paramOrVarName, this)) {
                    if (nativeFunction.getParamOrVarConst(paramCount)) {
                        defineProperty(paramOrVarName, Undefined.instance, 13);
                    } else {
                        defineProperty(paramOrVarName, Undefined.instance, 4);
                    }
                }
                paramCount++;
            }
        }
    }

    public static void init(Scriptable scriptable, boolean z) {
        new NativeCall().exportAsJSClass(1, scriptable, z);
    }

    public void defineAttributesForArguments() {
        Arguments arguments = this.arguments;
        if (arguments != null) {
            arguments.defineAttributesForStrictMode();
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(CALL_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int methodId = idFunctionObject.methodId();
        if (methodId != 1) {
            throw new IllegalArgumentException(String.valueOf(methodId));
        }
        if (scriptable2 != null) {
            throw Context.reportRuntimeError1("msg.only.from.new", "Call");
        }
        ScriptRuntime.checkDeprecated(context, "Call");
        NativeCall nativeCall = new NativeCall();
        nativeCall.setPrototype(ScriptableObject.getObjectPrototype(scriptable));
        return nativeCall;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(String str) {
        return str.equals("constructor") ? 1 : 0;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Call";
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i) {
        if (i == 1) {
            initPrototypeMethod(CALL_TAG, i, "constructor", 1);
            return;
        }
        throw new IllegalArgumentException(String.valueOf(i));
    }
}
