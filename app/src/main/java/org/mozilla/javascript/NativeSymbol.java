package org.mozilla.javascript;

import java.util.HashMap;
import java.util.Map;
import org.simpleframework.xml.core.AnnotationHandler;

/* loaded from: classes5.dex */
public class NativeSymbol extends IdScriptableObject implements Symbol {
    public static final String CLASS_NAME = "Symbol";
    public static final int ConstructorId_for = -1;
    public static final int ConstructorId_keyFor = -2;
    public static final int Id_constructor = 1;
    public static final int Id_toString = 2;
    public static final int Id_valueOf = 4;
    public static final int MAX_PROTOTYPE_ID = 5;
    public static final int SymbolId_toPrimitive = 5;
    public static final int SymbolId_toStringTag = 3;
    public static final String TYPE_NAME = "symbol";
    public static final long serialVersionUID = -589539749749830003L;
    public final SymbolKey key;
    public final NativeSymbol symbolData;
    public static final Object GLOBAL_TABLE_KEY = new Object();
    public static final Object CONSTRUCTOR_SLOT = new Object();

    public NativeSymbol(String str) {
        this.key = new SymbolKey(str);
        this.symbolData = null;
    }

    public NativeSymbol(NativeSymbol nativeSymbol) {
        this.key = nativeSymbol.key;
        this.symbolData = nativeSymbol.symbolData;
    }

    public NativeSymbol(SymbolKey symbolKey) {
        this.key = symbolKey;
        this.symbolData = this;
    }

    public static NativeSymbol construct(Context context, Scriptable scriptable, Object[] objArr) {
        context.putThreadLocal(CONSTRUCTOR_SLOT, Boolean.TRUE);
        try {
            return (NativeSymbol) context.newObject(scriptable, CLASS_NAME, objArr);
        } finally {
            context.removeThreadLocal(CONSTRUCTOR_SLOT);
        }
    }

    public static void createStandardSymbol(Context context, Scriptable scriptable, ScriptableObject scriptableObject, String str, SymbolKey symbolKey) {
        scriptableObject.defineProperty(str, context.newObject(scriptable, CLASS_NAME, new Object[]{str, symbolKey}), 7);
    }

    private Map<String, NativeSymbol> getGlobalMap() {
        ScriptableObject scriptableObject = (ScriptableObject) ScriptableObject.getTopLevelScope(this);
        Map<String, NativeSymbol> map = (Map) scriptableObject.getAssociatedValue(GLOBAL_TABLE_KEY);
        if (map == null) {
            HashMap hashMap = new HashMap();
            scriptableObject.associateValue(GLOBAL_TABLE_KEY, hashMap);
            return hashMap;
        }
        return map;
    }

    public static NativeSymbol getSelf(Object obj) {
        try {
            return (NativeSymbol) obj;
        } catch (ClassCastException unused) {
            throw ScriptRuntime.typeError1("msg.invalid.type", obj.getClass().getName());
        }
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        IdFunctionObject exportAsJSClass = new NativeSymbol("").exportAsJSClass(5, scriptable, false);
        context.putThreadLocal(CONSTRUCTOR_SLOT, Boolean.TRUE);
        try {
            createStandardSymbol(context, scriptable, exportAsJSClass, "iterator", SymbolKey.ITERATOR);
            createStandardSymbol(context, scriptable, exportAsJSClass, "species", SymbolKey.SPECIES);
            createStandardSymbol(context, scriptable, exportAsJSClass, "toStringTag", SymbolKey.TO_STRING_TAG);
            createStandardSymbol(context, scriptable, exportAsJSClass, "hasInstance", SymbolKey.HAS_INSTANCE);
            createStandardSymbol(context, scriptable, exportAsJSClass, "isConcatSpreadable", SymbolKey.IS_CONCAT_SPREADABLE);
            createStandardSymbol(context, scriptable, exportAsJSClass, "isRegExp", SymbolKey.IS_REGEXP);
            createStandardSymbol(context, scriptable, exportAsJSClass, "toPrimitive", SymbolKey.TO_PRIMITIVE);
            createStandardSymbol(context, scriptable, exportAsJSClass, "match", SymbolKey.MATCH);
            createStandardSymbol(context, scriptable, exportAsJSClass, "replace", SymbolKey.REPLACE);
            createStandardSymbol(context, scriptable, exportAsJSClass, "search", SymbolKey.SEARCH);
            createStandardSymbol(context, scriptable, exportAsJSClass, "split", SymbolKey.SPLIT);
            createStandardSymbol(context, scriptable, exportAsJSClass, "unscopables", SymbolKey.UNSCOPABLES);
            if (!z) {
                return;
            }
            exportAsJSClass.sealObject();
        } finally {
            context.removeThreadLocal(CONSTRUCTOR_SLOT);
        }
    }

    private boolean isStrictMode() {
        Context currentContext = Context.getCurrentContext();
        return currentContext != null && currentContext.isStrictMode();
    }

    public static NativeSymbol js_constructor(Object[] objArr) {
        String str = "";
        if (objArr.length > 0 && !Undefined.instance.equals(objArr[0])) {
            str = ScriptRuntime.toString(objArr[0]);
        }
        return objArr.length > 1 ? new NativeSymbol((SymbolKey) objArr[1]) : new NativeSymbol(new SymbolKey(str));
    }

    private Object js_for(Context context, Scriptable scriptable, Object[] objArr) {
        String scriptRuntime = ScriptRuntime.toString(objArr.length > 0 ? objArr[0] : Undefined.instance);
        Map<String, NativeSymbol> globalMap = getGlobalMap();
        NativeSymbol nativeSymbol = globalMap.get(scriptRuntime);
        if (nativeSymbol == null) {
            NativeSymbol construct = construct(context, scriptable, new Object[]{scriptRuntime});
            globalMap.put(scriptRuntime, construct);
            return construct;
        }
        return nativeSymbol;
    }

    private Object js_keyFor(Context context, Scriptable scriptable, Object[] objArr) {
        Object obj = objArr.length > 0 ? objArr[0] : Undefined.instance;
        if (obj instanceof NativeSymbol) {
            NativeSymbol nativeSymbol = (NativeSymbol) obj;
            for (Map.Entry<String, NativeSymbol> entry : getGlobalMap().entrySet()) {
                if (entry.getValue().key == nativeSymbol.key) {
                    return entry.getKey();
                }
            }
            return Undefined.instance;
        }
        throw ScriptRuntime.throwCustomError(context, scriptable, "TypeError", "Not a Symbol");
    }

    private Object js_valueOf() {
        return this.symbolData;
    }

    public boolean equals(Object obj) {
        return this.key.equals(obj);
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(CLASS_NAME)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int methodId = idFunctionObject.methodId();
        if (methodId == -2) {
            return js_keyFor(context, scriptable, objArr);
        }
        if (methodId == -1) {
            return js_for(context, scriptable, objArr);
        }
        if (methodId != 1) {
            return methodId != 2 ? (methodId == 4 || methodId == 5) ? getSelf(scriptable2).js_valueOf() : super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr) : getSelf(scriptable2).toString();
        } else if (scriptable2 != null) {
            return construct(context, scriptable, objArr);
        } else {
            if (context.getThreadLocal(CONSTRUCTOR_SLOT) == null) {
                throw ScriptRuntime.typeError0("msg.no.symbol.new");
            }
            return js_constructor(objArr);
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void fillConstructorProperties(IdFunctionObject idFunctionObject) {
        super.fillConstructorProperties(idFunctionObject);
        addIdFunctionProperty(idFunctionObject, CLASS_NAME, -1, "for", 1);
        addIdFunctionProperty(idFunctionObject, CLASS_NAME, -2, "keyFor", 1);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(String str) {
        String str2;
        int i;
        int length = str.length();
        if (length == 7) {
            i = 4;
            str2 = "valueOf";
        } else if (length == 8) {
            i = 2;
            str2 = AnnotationHandler.STRING;
        } else if (length == 11) {
            i = 1;
            str2 = "constructor";
        } else {
            str2 = null;
            i = 0;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(Symbol symbol) {
        if (SymbolKey.TO_STRING_TAG.equals(symbol)) {
            return 3;
        }
        return SymbolKey.TO_PRIMITIVE.equals(symbol) ? 5 : 0;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return CLASS_NAME;
    }

    public SymbolKey getKey() {
        return this.key;
    }

    @Override // org.mozilla.javascript.ScriptableObject
    public String getTypeOf() {
        return isSymbol() ? TYPE_NAME : super.getTypeOf();
    }

    public int hashCode() {
        return this.key.hashCode();
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i) {
        String str;
        if (i == 1) {
            initPrototypeMethod(CLASS_NAME, i, "constructor", 1);
            return;
        }
        if (i == 2) {
            str = AnnotationHandler.STRING;
        } else if (i == 3) {
            initPrototypeValue(i, SymbolKey.TO_STRING_TAG, CLASS_NAME, 3);
            return;
        } else if (i != 4) {
            if (i != 5) {
                super.initPrototypeId(i);
                return;
            } else {
                initPrototypeMethod(CLASS_NAME, i, SymbolKey.TO_PRIMITIVE, "Symbol.toPrimitive", 1);
                return;
            }
        } else {
            str = "valueOf";
        }
        initPrototypeMethod(CLASS_NAME, i, str, 0);
    }

    public boolean isSymbol() {
        return this.symbolData == this;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void put(int i, Scriptable scriptable, Object obj) {
        if (!isSymbol()) {
            super.put(i, scriptable, obj);
        } else if (isStrictMode()) {
            throw ScriptRuntime.typeError0("msg.no.assign.symbol.strict");
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void put(String str, Scriptable scriptable, Object obj) {
        if (!isSymbol()) {
            super.put(str, scriptable, obj);
        } else if (isStrictMode()) {
            throw ScriptRuntime.typeError0("msg.no.assign.symbol.strict");
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.SymbolScriptable
    public void put(Symbol symbol, Scriptable scriptable, Object obj) {
        if (!isSymbol()) {
            super.put(symbol, scriptable, obj);
        } else if (isStrictMode()) {
            throw ScriptRuntime.typeError0("msg.no.assign.symbol.strict");
        }
    }

    public String toString() {
        return this.key.toString();
    }
}
