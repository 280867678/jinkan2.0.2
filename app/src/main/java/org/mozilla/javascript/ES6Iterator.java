package org.mozilla.javascript;

/* loaded from: classes5.dex */
public abstract class ES6Iterator extends IdScriptableObject {
    public static final String DONE_PROPERTY = "done";
    public static final int Id_next = 1;
    public static final int MAX_PROTOTYPE_ID = 3;
    public static final String NEXT_METHOD = "next";
    public static final int SymbolId_iterator = 2;
    public static final int SymbolId_toStringTag = 3;
    public static final String VALUE_PROPERTY = "value";
    public boolean exhausted = false;
    public String tag;

    public ES6Iterator() {
    }

    public ES6Iterator(Scriptable scriptable, String str) {
        this.tag = str;
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        setParentScope(topLevelScope);
        setPrototype((IdScriptableObject) ScriptableObject.getTopScopeValue(topLevelScope, str));
    }

    public static void init(ScriptableObject scriptableObject, boolean z, IdScriptableObject idScriptableObject, String str) {
        if (scriptableObject != null) {
            idScriptableObject.setParentScope(scriptableObject);
            idScriptableObject.setPrototype(ScriptableObject.getObjectPrototype(scriptableObject));
        }
        idScriptableObject.activatePrototypeMap(3);
        if (z) {
            idScriptableObject.sealObject();
        }
        if (scriptableObject != null) {
            scriptableObject.associateValue(str, idScriptableObject);
        }
    }

    private Scriptable makeIteratorResult(Context context, Scriptable scriptable, boolean z, Object obj) {
        Scriptable newObject = context.newObject(scriptable);
        ScriptableObject.putProperty(newObject, "value", obj);
        ScriptableObject.putProperty(newObject, DONE_PROPERTY, Boolean.valueOf(z));
        return newObject;
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(getTag())) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int methodId = idFunctionObject.methodId();
        if (!(scriptable2 instanceof ES6Iterator)) {
            throw IdScriptableObject.incompatibleCallError(idFunctionObject);
        }
        ES6Iterator eS6Iterator = (ES6Iterator) scriptable2;
        if (methodId == 1) {
            return eS6Iterator.next(context, scriptable);
        }
        if (methodId != 2) {
            throw new IllegalArgumentException(String.valueOf(methodId));
        }
        return eS6Iterator;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(String str) {
        return NEXT_METHOD.equals(str) ? 1 : 0;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(Symbol symbol) {
        if (SymbolKey.ITERATOR.equals(symbol)) {
            return 2;
        }
        return SymbolKey.TO_STRING_TAG.equals(symbol) ? 3 : 0;
    }

    public String getTag() {
        return this.tag;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i) {
        if (i == 1) {
            initPrototypeMethod(getTag(), i, NEXT_METHOD, 0);
        } else if (i == 2) {
            initPrototypeMethod(getTag(), i, SymbolKey.ITERATOR, "[Symbol.iterator]", 3);
        } else if (i != 3) {
            throw new IllegalArgumentException(String.valueOf(i));
        } else {
            initPrototypeValue(3, SymbolKey.TO_STRING_TAG, getClassName(), 3);
        }
    }

    public abstract boolean isDone(Context context, Scriptable scriptable);

    public Object next(Context context, Scriptable scriptable) {
        Object obj = Undefined.instance;
        boolean z = isDone(context, scriptable) || this.exhausted;
        if (!z) {
            obj = nextValue(context, scriptable);
        } else {
            this.exhausted = true;
        }
        return makeIteratorResult(context, scriptable, z, obj);
    }

    public abstract Object nextValue(Context context, Scriptable scriptable);
}
