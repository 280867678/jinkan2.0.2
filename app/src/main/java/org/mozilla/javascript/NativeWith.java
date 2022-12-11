package org.mozilla.javascript;

import java.io.Serializable;

/* loaded from: classes5.dex */
public class NativeWith implements Scriptable, SymbolScriptable, IdFunctionCall, Serializable {
    public static final Object FTAG = "With";
    public static final int Id_constructor = 1;
    public static final long serialVersionUID = 1;
    public Scriptable parent;
    public Scriptable prototype;

    public NativeWith() {
    }

    public NativeWith(Scriptable scriptable, Scriptable scriptable2) {
        this.parent = scriptable;
        this.prototype = scriptable2;
    }

    public static void init(Scriptable scriptable, boolean z) {
        NativeWith nativeWith = new NativeWith();
        nativeWith.setParentScope(scriptable);
        nativeWith.setPrototype(ScriptableObject.getObjectPrototype(scriptable));
        IdFunctionObject idFunctionObject = new IdFunctionObject(nativeWith, FTAG, 1, "With", 0, scriptable);
        idFunctionObject.markAsConstructor(nativeWith);
        if (z) {
            idFunctionObject.sealObject();
        }
        idFunctionObject.exportAsScopeProperty();
    }

    public static boolean isWithFunction(Object obj) {
        if (obj instanceof IdFunctionObject) {
            IdFunctionObject idFunctionObject = (IdFunctionObject) obj;
            return idFunctionObject.hasTag(FTAG) && idFunctionObject.methodId() == 1;
        }
        return false;
    }

    public static Object newWithSpecial(Context context, Scriptable scriptable, Object[] objArr) {
        ScriptRuntime.checkDeprecated(context, "With");
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        NativeWith nativeWith = new NativeWith();
        nativeWith.setPrototype(objArr.length == 0 ? ScriptableObject.getObjectPrototype(topLevelScope) : ScriptRuntime.toObject(context, topLevelScope, objArr[0]));
        nativeWith.setParentScope(topLevelScope);
        return nativeWith;
    }

    @Override // org.mozilla.javascript.Scriptable
    public void delete(int i) {
        this.prototype.delete(i);
    }

    @Override // org.mozilla.javascript.Scriptable
    public void delete(String str) {
        this.prototype.delete(str);
    }

    @Override // org.mozilla.javascript.SymbolScriptable
    public void delete(Symbol symbol) {
        Scriptable scriptable = this.prototype;
        if (scriptable instanceof SymbolScriptable) {
            ((SymbolScriptable) scriptable).delete(symbol);
        }
    }

    @Override // org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(FTAG) || idFunctionObject.methodId() != 1) {
            throw idFunctionObject.unknown();
        }
        throw Context.reportRuntimeError1("msg.cant.call.indirect", "With");
    }

    @Override // org.mozilla.javascript.Scriptable
    public Object get(int i, Scriptable scriptable) {
        if (scriptable == this) {
            scriptable = this.prototype;
        }
        return this.prototype.get(i, scriptable);
    }

    @Override // org.mozilla.javascript.Scriptable
    public Object get(String str, Scriptable scriptable) {
        if (scriptable == this) {
            scriptable = this.prototype;
        }
        return this.prototype.get(str, scriptable);
    }

    @Override // org.mozilla.javascript.SymbolScriptable
    public Object get(Symbol symbol, Scriptable scriptable) {
        if (scriptable == this) {
            scriptable = this.prototype;
        }
        Scriptable scriptable2 = this.prototype;
        return scriptable2 instanceof SymbolScriptable ? ((SymbolScriptable) scriptable2).get(symbol, scriptable) : Scriptable.NOT_FOUND;
    }

    @Override // org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "With";
    }

    @Override // org.mozilla.javascript.Scriptable
    public Object getDefaultValue(Class<?> cls) {
        return this.prototype.getDefaultValue(cls);
    }

    @Override // org.mozilla.javascript.Scriptable
    public Object[] getIds() {
        return this.prototype.getIds();
    }

    @Override // org.mozilla.javascript.Scriptable
    public Scriptable getParentScope() {
        return this.parent;
    }

    @Override // org.mozilla.javascript.Scriptable
    public Scriptable getPrototype() {
        return this.prototype;
    }

    @Override // org.mozilla.javascript.Scriptable
    public boolean has(int i, Scriptable scriptable) {
        Scriptable scriptable2 = this.prototype;
        return scriptable2.has(i, scriptable2);
    }

    @Override // org.mozilla.javascript.Scriptable
    public boolean has(String str, Scriptable scriptable) {
        Scriptable scriptable2 = this.prototype;
        return scriptable2.has(str, scriptable2);
    }

    @Override // org.mozilla.javascript.SymbolScriptable
    public boolean has(Symbol symbol, Scriptable scriptable) {
        Scriptable scriptable2 = this.prototype;
        if (scriptable2 instanceof SymbolScriptable) {
            return ((SymbolScriptable) scriptable2).has(symbol, scriptable2);
        }
        return false;
    }

    @Override // org.mozilla.javascript.Scriptable
    public boolean hasInstance(Scriptable scriptable) {
        return this.prototype.hasInstance(scriptable);
    }

    @Override // org.mozilla.javascript.Scriptable
    public void put(int i, Scriptable scriptable, Object obj) {
        if (scriptable == this) {
            scriptable = this.prototype;
        }
        this.prototype.put(i, scriptable, obj);
    }

    @Override // org.mozilla.javascript.Scriptable
    public void put(String str, Scriptable scriptable, Object obj) {
        if (scriptable == this) {
            scriptable = this.prototype;
        }
        this.prototype.put(str, scriptable, obj);
    }

    @Override // org.mozilla.javascript.SymbolScriptable
    public void put(Symbol symbol, Scriptable scriptable, Object obj) {
        if (scriptable == this) {
            scriptable = this.prototype;
        }
        Scriptable scriptable2 = this.prototype;
        if (scriptable2 instanceof SymbolScriptable) {
            ((SymbolScriptable) scriptable2).put(symbol, scriptable, obj);
        }
    }

    @Override // org.mozilla.javascript.Scriptable
    public void setParentScope(Scriptable scriptable) {
        this.parent = scriptable;
    }

    @Override // org.mozilla.javascript.Scriptable
    public void setPrototype(Scriptable scriptable) {
        this.prototype = scriptable;
    }

    public Object updateDotQuery(boolean z) {
        throw new IllegalStateException();
    }
}
