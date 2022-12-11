package org.mozilla.javascript;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.WeakHashMap;
import me.tvspark.outline;

/* loaded from: classes5.dex */
public class NativeWeakSet extends IdScriptableObject {
    public static final int Id_add = 2;
    public static final int Id_constructor = 1;
    public static final int Id_delete = 3;
    public static final int Id_has = 4;
    public static final Object MAP_TAG = "WeakSet";
    public static final int MAX_PROTOTYPE_ID = 5;
    public static final int SymbolId_toStringTag = 5;
    public boolean instanceOfWeakSet = false;
    public transient WeakHashMap<Scriptable, Boolean> map = new WeakHashMap<>();

    public static void init(Scriptable scriptable, boolean z) {
        new NativeWeakSet().exportAsJSClass(5, scriptable, z);
    }

    private Object js_add(Object obj) {
        if (ScriptRuntime.isObject(obj)) {
            this.map.put((Scriptable) obj, Boolean.TRUE);
            return this;
        }
        throw ScriptRuntime.typeError1("msg.arg.not.object", ScriptRuntime.typeof(obj));
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

    private Object js_has(Object obj) {
        return Boolean.valueOf(!ScriptRuntime.isObject(obj) ? false : this.map.containsKey(obj));
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.map = new WeakHashMap<>();
    }

    private NativeWeakSet realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (scriptable != null) {
            try {
                NativeWeakSet nativeWeakSet = (NativeWeakSet) scriptable;
                if (nativeWeakSet.instanceOfWeakSet) {
                    return nativeWeakSet;
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
                throw ScriptRuntime.typeError1("msg.no.new", "WeakSet");
            }
            NativeWeakSet nativeWeakSet = new NativeWeakSet();
            nativeWeakSet.instanceOfWeakSet = true;
            if (objArr.length > 0) {
                NativeSet.loadFromIterable(context, scriptable, nativeWeakSet, objArr[0]);
            }
            return nativeWeakSet;
        } else if (methodId == 2) {
            return realThis(scriptable2, idFunctionObject).js_add(objArr.length > 0 ? objArr[0] : Undefined.instance);
        } else if (methodId == 3) {
            return realThis(scriptable2, idFunctionObject).js_delete(objArr.length > 0 ? objArr[0] : Undefined.instance);
        } else if (methodId == 4) {
            return realThis(scriptable2, idFunctionObject).js_has(objArr.length > 0 ? objArr[0] : Undefined.instance);
        } else {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("WeakMap.prototype has no method: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(idFunctionObject.getFunctionName());
            throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(String str) {
        String str2;
        int length = str.length();
        int i = 3;
        if (length != 3) {
            if (length == 6) {
                str2 = "delete";
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
        if (charAt == 'a') {
            if (str.charAt(2) == 'd' && str.charAt(1) == 'd') {
                return 2;
            }
        } else if (charAt == 'h' && str.charAt(2) == 's' && str.charAt(1) == 'a') {
            return 4;
        }
        str2 = null;
        i = 0;
        if (str2 == null) {
        }
        return i;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(Symbol symbol) {
        return SymbolKey.TO_STRING_TAG.equals(symbol) ? 5 : 0;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "WeakSet";
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i) {
        String str;
        int i2;
        String str2;
        if (i == 5) {
            initPrototypeValue(5, SymbolKey.TO_STRING_TAG, getClassName(), 3);
            return;
        }
        if (i != 1) {
            if (i == 2) {
                str2 = "add";
            } else if (i == 3) {
                str2 = "delete";
            } else if (i != 4) {
                throw new IllegalArgumentException(String.valueOf(i));
            } else {
                str2 = "has";
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
