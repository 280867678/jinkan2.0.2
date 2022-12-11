package org.mozilla.javascript;

import me.tvspark.outline;

/* loaded from: classes5.dex */
public class IdFunctionObject extends BaseFunction {
    public static final long serialVersionUID = -5332312783643935019L;
    public int arity;
    public String functionName;
    public final IdFunctionCall idcall;
    public final int methodId;
    public final Object tag;
    public boolean useCallAsConstructor;

    public IdFunctionObject(IdFunctionCall idFunctionCall, Object obj, int i, int i2) {
        if (i2 >= 0) {
            this.idcall = idFunctionCall;
            this.tag = obj;
            this.methodId = i;
            this.arity = i2;
            return;
        }
        throw new IllegalArgumentException();
    }

    public IdFunctionObject(IdFunctionCall idFunctionCall, Object obj, int i, String str, int i2, Scriptable scriptable) {
        super(scriptable, null);
        if (i2 >= 0) {
            if (str == null) {
                throw new IllegalArgumentException();
            }
            this.idcall = idFunctionCall;
            this.tag = obj;
            this.methodId = i;
            this.arity = i2;
            this.functionName = str;
            return;
        }
        throw new IllegalArgumentException();
    }

    public static boolean equalObjectGraphs(IdFunctionObject idFunctionObject, IdFunctionObject idFunctionObject2, EqualObjectGraphs equalObjectGraphs) {
        return idFunctionObject.methodId == idFunctionObject2.methodId && idFunctionObject.hasTag(idFunctionObject2.tag) && equalObjectGraphs.equalGraphs(idFunctionObject.idcall, idFunctionObject2.idcall);
    }

    public final void addAsProperty(Scriptable scriptable) {
        ScriptableObject.defineProperty(scriptable, this.functionName, this, 2);
    }

    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.Function, org.mozilla.javascript.Callable
    public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return this.idcall.execIdCall(this, context, scriptable, scriptable2, objArr);
    }

    @Override // org.mozilla.javascript.BaseFunction
    public Scriptable createObject(Context context, Scriptable scriptable) {
        if (this.useCallAsConstructor) {
            return null;
        }
        throw ScriptRuntime.typeError1("msg.not.ctor", this.functionName);
    }

    @Override // org.mozilla.javascript.BaseFunction
    public String decompile(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        if ((i2 & 1) == 0) {
            z = false;
        }
        if (!z) {
            sb.append("function ");
            sb.append(getFunctionName());
            sb.append("() { ");
        }
        sb.append("[native code for ");
        IdFunctionCall idFunctionCall = this.idcall;
        if (idFunctionCall instanceof Scriptable) {
            sb.append(((Scriptable) idFunctionCall).getClassName());
            sb.append('.');
        }
        sb.append(getFunctionName());
        sb.append(", arity=");
        sb.append(getArity());
        sb.append(z ? "]\n" : "] }\n");
        return sb.toString();
    }

    public void exportAsScopeProperty() {
        addAsProperty(getParentScope());
    }

    @Override // org.mozilla.javascript.BaseFunction
    public int getArity() {
        return this.arity;
    }

    @Override // org.mozilla.javascript.BaseFunction
    public String getFunctionName() {
        String str = this.functionName;
        return str == null ? "" : str;
    }

    @Override // org.mozilla.javascript.BaseFunction
    public int getLength() {
        return getArity();
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Scriptable getPrototype() {
        Scriptable prototype = super.getPrototype();
        if (prototype == null) {
            Scriptable functionPrototype = ScriptableObject.getFunctionPrototype(getParentScope());
            setPrototype(functionPrototype);
            return functionPrototype;
        }
        return prototype;
    }

    public Object getTag() {
        return this.tag;
    }

    public final boolean hasTag(Object obj) {
        return obj == null ? this.tag == null : obj.equals(this.tag);
    }

    public void initFunction(String str, Scriptable scriptable) {
        if (str != null) {
            if (scriptable == null) {
                throw new IllegalArgumentException();
            }
            this.functionName = str;
            setParentScope(scriptable);
            return;
        }
        throw new IllegalArgumentException();
    }

    public final void markAsConstructor(Scriptable scriptable) {
        this.useCallAsConstructor = true;
        setImmunePrototypeProperty(scriptable);
    }

    public final int methodId() {
        return this.methodId;
    }

    public final RuntimeException unknown() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("BAD FUNCTION ID=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.methodId);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" MASTER=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.idcall);
        return new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }
}
