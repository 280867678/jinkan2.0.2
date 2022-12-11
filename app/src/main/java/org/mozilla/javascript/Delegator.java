package org.mozilla.javascript;

/* loaded from: classes5.dex */
public class Delegator implements Function, SymbolScriptable {
    public Scriptable obj;

    public Delegator() {
        this.obj = null;
    }

    public Delegator(Scriptable scriptable) {
        this.obj = null;
        this.obj = scriptable;
    }

    @Override // org.mozilla.javascript.Function, org.mozilla.javascript.Callable
    public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return ((Function) getDelegee()).call(context, scriptable, scriptable2, objArr);
    }

    @Override // org.mozilla.javascript.Function
    public Scriptable construct(Context context, Scriptable scriptable, Object[] objArr) {
        Scriptable delegee = getDelegee();
        if (delegee == null) {
            Delegator newInstance = newInstance();
            newInstance.setDelegee(objArr.length == 0 ? new NativeObject() : ScriptRuntime.toObject(context, scriptable, objArr[0]));
            return newInstance;
        }
        return ((Function) delegee).construct(context, scriptable, objArr);
    }

    @Override // org.mozilla.javascript.Scriptable
    public void delete(int i) {
        getDelegee().delete(i);
    }

    @Override // org.mozilla.javascript.Scriptable
    public void delete(String str) {
        getDelegee().delete(str);
    }

    @Override // org.mozilla.javascript.SymbolScriptable
    public void delete(Symbol symbol) {
        Scriptable delegee = getDelegee();
        if (delegee instanceof SymbolScriptable) {
            ((SymbolScriptable) delegee).delete(symbol);
        }
    }

    @Override // org.mozilla.javascript.Scriptable
    public Object get(int i, Scriptable scriptable) {
        return getDelegee().get(i, scriptable);
    }

    @Override // org.mozilla.javascript.Scriptable
    public Object get(String str, Scriptable scriptable) {
        return getDelegee().get(str, scriptable);
    }

    @Override // org.mozilla.javascript.SymbolScriptable
    public Object get(Symbol symbol, Scriptable scriptable) {
        Scriptable delegee = getDelegee();
        return delegee instanceof SymbolScriptable ? ((SymbolScriptable) delegee).get(symbol, scriptable) : Scriptable.NOT_FOUND;
    }

    @Override // org.mozilla.javascript.Scriptable
    public String getClassName() {
        return getDelegee().getClassName();
    }

    @Override // org.mozilla.javascript.Scriptable
    public Object getDefaultValue(Class<?> cls) {
        return (cls == null || cls == ScriptRuntime.ScriptableClass || cls == ScriptRuntime.FunctionClass) ? this : getDelegee().getDefaultValue(cls);
    }

    public Scriptable getDelegee() {
        return this.obj;
    }

    @Override // org.mozilla.javascript.Scriptable
    public Object[] getIds() {
        return getDelegee().getIds();
    }

    @Override // org.mozilla.javascript.Scriptable
    public Scriptable getParentScope() {
        return getDelegee().getParentScope();
    }

    @Override // org.mozilla.javascript.Scriptable
    public Scriptable getPrototype() {
        return getDelegee().getPrototype();
    }

    @Override // org.mozilla.javascript.Scriptable
    public boolean has(int i, Scriptable scriptable) {
        return getDelegee().has(i, scriptable);
    }

    @Override // org.mozilla.javascript.Scriptable
    public boolean has(String str, Scriptable scriptable) {
        return getDelegee().has(str, scriptable);
    }

    @Override // org.mozilla.javascript.SymbolScriptable
    public boolean has(Symbol symbol, Scriptable scriptable) {
        Scriptable delegee = getDelegee();
        if (delegee instanceof SymbolScriptable) {
            return ((SymbolScriptable) delegee).has(symbol, scriptable);
        }
        return false;
    }

    @Override // org.mozilla.javascript.Scriptable
    public boolean hasInstance(Scriptable scriptable) {
        return getDelegee().hasInstance(scriptable);
    }

    public Delegator newInstance() {
        try {
            return (Delegator) getClass().newInstance();
        } catch (Exception e) {
            throw Context.throwAsScriptRuntimeEx(e);
        }
    }

    @Override // org.mozilla.javascript.Scriptable
    public void put(int i, Scriptable scriptable, Object obj) {
        getDelegee().put(i, scriptable, obj);
    }

    @Override // org.mozilla.javascript.Scriptable
    public void put(String str, Scriptable scriptable, Object obj) {
        getDelegee().put(str, scriptable, obj);
    }

    @Override // org.mozilla.javascript.SymbolScriptable
    public void put(Symbol symbol, Scriptable scriptable, Object obj) {
        Scriptable delegee = getDelegee();
        if (delegee instanceof SymbolScriptable) {
            ((SymbolScriptable) delegee).put(symbol, scriptable, obj);
        }
    }

    public void setDelegee(Scriptable scriptable) {
        this.obj = scriptable;
    }

    @Override // org.mozilla.javascript.Scriptable
    public void setParentScope(Scriptable scriptable) {
        getDelegee().setParentScope(scriptable);
    }

    @Override // org.mozilla.javascript.Scriptable
    public void setPrototype(Scriptable scriptable) {
        getDelegee().setPrototype(scriptable);
    }
}
