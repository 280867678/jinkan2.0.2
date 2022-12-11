package org.mozilla.javascript;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.WeakHashMap;
import me.tvspark.outline;

/* loaded from: classes5.dex */
public class NativeWeakMap extends IdScriptableObject {
    public static final int Id_constructor = 1;
    public static final int Id_delete = 2;
    public static final int Id_get = 3;
    public static final int Id_has = 4;
    public static final int Id_set = 5;
    public static final int MAX_PROTOTYPE_ID = 6;
    public static final int SymbolId_toStringTag = 6;
    public boolean instanceOfWeakMap = false;
    public transient WeakHashMap<Scriptable, Object> map = new WeakHashMap<>();
    public static final Object MAP_TAG = "WeakMap";
    public static final Object NULL_VALUE = new Object();

    public static void init(Scriptable scriptable, boolean z) {
        new NativeWeakMap().exportAsJSClass(6, scriptable, z);
    }

    private Object js_delete(Object obj) {
        boolean z = false;
        if (!ScriptRuntime.isObject(obj)) {
            return false;
        }
        if (this.map.remove(obj) != null) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    private Object js_get(Object obj) {
        Object obj2;
        if (ScriptRuntime.isObject(obj) && (obj2 = this.map.get(obj)) != null) {
            if (obj2 != NULL_VALUE) {
                return obj2;
            }
            return null;
        }
        return Undefined.instance;
    }

    private Object js_has(Object obj) {
        return Boolean.valueOf(!ScriptRuntime.isObject(obj) ? false : this.map.containsKey(obj));
    }

    private Object js_set(Object obj, Object obj2) {
        if (ScriptRuntime.isObject(obj)) {
            if (obj2 == null) {
                obj2 = NULL_VALUE;
            }
            this.map.put((Scriptable) obj, obj2);
            return this;
        }
        throw ScriptRuntime.typeError1("msg.arg.not.object", ScriptRuntime.typeof(obj));
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.map = new WeakHashMap<>();
    }

    private NativeWeakMap realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (scriptable != null) {
            try {
                NativeWeakMap nativeWeakMap = (NativeWeakMap) scriptable;
                if (nativeWeakMap.instanceOfWeakMap) {
                    return nativeWeakMap;
                }
                throw IdScriptableObject.incompatibleCallError(idFunctionObject);
            } catch (ClassCastException unused) {
                throw IdScriptableObject.incompatibleCallError(idFunctionObject);
            }
        }
        throw IdScriptableObject.incompatibleCallError(idFunctionObject);
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(MAP_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int methodId = idFunctionObject.methodId();
        if (methodId == 1) {
            if (scriptable2 != null) {
                throw ScriptRuntime.typeError1("msg.no.new", "WeakMap");
            }
            NativeWeakMap nativeWeakMap = new NativeWeakMap();
            nativeWeakMap.instanceOfWeakMap = true;
            if (objArr.length > 0) {
                NativeMap.loadFromIterable(context, scriptable, nativeWeakMap, objArr[0]);
            }
            return nativeWeakMap;
        } else if (methodId == 2) {
            return realThis(scriptable2, idFunctionObject).js_delete(objArr.length > 0 ? objArr[0] : Undefined.instance);
        } else if (methodId == 3) {
            return realThis(scriptable2, idFunctionObject).js_get(objArr.length > 0 ? objArr[0] : Undefined.instance);
        } else if (methodId == 4) {
            return realThis(scriptable2, idFunctionObject).js_has(objArr.length > 0 ? objArr[0] : Undefined.instance);
        } else if (methodId == 5) {
            return realThis(scriptable2, idFunctionObject).js_set(objArr.length > 0 ? objArr[0] : Undefined.instance, objArr.length > 1 ? objArr[1] : Undefined.instance);
        } else {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("WeakMap.prototype has no method: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(idFunctionObject.getFunctionName());
            throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(String str) {
        String str2;
        int i;
        int length = str.length();
        if (length != 3) {
            if (length == 6) {
                str2 = "delete";
                i = 2;
            } else if (length == 11) {
                str2 = "constructor";
                i = 1;
            }
            if (str2 == null && str2 != str && !str2.equals(str)) {
                return 0;
            }
            return i;
        }
        char charAt = str.charAt(0);
        if (charAt == 'g') {
            if (str.charAt(2) == 't' && str.charAt(1) == 'e') {
                return 3;
            }
        } else if (charAt == 'h') {
            if (str.charAt(2) == 's' && str.charAt(1) == 'a') {
                return 4;
            }
        } else if (charAt == 's' && str.charAt(2) == 't' && str.charAt(1) == 'e') {
            return 5;
        }
        str2 = null;
        i = 0;
        return str2 == null ? i : i;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(Symbol symbol) {
        return SymbolKey.TO_STRING_TAG.equals(symbol) ? 6 : 0;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "WeakMap";
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i) {
        String str;
        int i2;
        String str2;
        if (i == 6) {
            initPrototypeValue(6, SymbolKey.TO_STRING_TAG, getClassName(), 3);
            return;
        }
        if (i != 1) {
            if (i == 2) {
                str2 = "delete";
            } else if (i == 3) {
                str2 = "get";
            } else if (i == 4) {
                str2 = "has";
            } else if (i != 5) {
                throw new IllegalArgumentException(String.valueOf(i));
            } else {
                str = "set";
                i2 = 2;
            }
            str = str2;
            i2 = 1;
        } else {
            str = "constructor";
            i2 = 0;
        }
        initPrototypeMethod(MAP_TAG, i, str, (String) null, i2);
    }
}
