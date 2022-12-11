package org.mozilla.javascript;

import androidx.cardview.widget.RoundRectDrawableWithShadow;
import androidx.lifecycle.SavedStateHandle;
import java.util.Iterator;
import me.tvspark.outline;
import org.mozilla.javascript.Hashtable;
import org.mozilla.javascript.NativeCollectionIterator;

/* loaded from: classes5.dex */
public class NativeMap extends IdScriptableObject {
    public static final String ITERATOR_TAG = "Map Iterator";
    public static final int Id_clear = 6;
    public static final int Id_constructor = 1;
    public static final int Id_delete = 4;
    public static final int Id_entries = 9;
    public static final int Id_forEach = 10;
    public static final int Id_get = 3;
    public static final int Id_has = 5;
    public static final int Id_keys = 7;
    public static final int Id_set = 2;
    public static final int Id_values = 8;
    public static final int MAX_PROTOTYPE_ID = 12;
    public static final int SymbolId_getSize = 11;
    public static final int SymbolId_toStringTag = 12;
    public final Hashtable entries = new Hashtable();
    public boolean instanceOfMap = false;
    public static final Object MAP_TAG = "Map";
    public static final Object NULL_VALUE = new Object();

    public static void init(Context context, Scriptable scriptable, boolean z) {
        NativeMap nativeMap = new NativeMap();
        nativeMap.exportAsJSClass(12, scriptable, false);
        ScriptableObject scriptableObject = (ScriptableObject) context.newObject(scriptable);
        scriptableObject.put("enumerable", (Scriptable) scriptableObject, (Object) false);
        scriptableObject.put("configurable", (Scriptable) scriptableObject, (Object) true);
        scriptableObject.put("get", scriptableObject, nativeMap.get(NativeSet.GETSIZE, nativeMap));
        nativeMap.defineOwnProperty(context, "size", scriptableObject);
        if (z) {
            nativeMap.sealObject();
        }
    }

    private Object js_clear() {
        this.entries.clear();
        return Undefined.instance;
    }

    private Object js_delete(Object obj) {
        return Boolean.valueOf(this.entries.delete(obj) != null);
    }

    private Object js_forEach(Context context, Scriptable scriptable, Object obj, Object obj2) {
        if (obj instanceof Callable) {
            Callable callable = (Callable) obj;
            boolean isStrictMode = context.isStrictMode();
            Iterator<Hashtable.Entry> it = this.entries.iterator();
            while (it.hasNext()) {
                Scriptable objectOrNull = ScriptRuntime.toObjectOrNull(context, obj2, scriptable);
                if (objectOrNull == null && !isStrictMode) {
                    objectOrNull = scriptable;
                }
                if (objectOrNull == null) {
                    objectOrNull = Undefined.SCRIPTABLE_UNDEFINED;
                }
                Hashtable.Entry next = it.next();
                Object obj3 = next.value;
                if (obj3 == NULL_VALUE) {
                    obj3 = null;
                }
                callable.call(context, scriptable, objectOrNull, new Object[]{obj3, next.key, this});
            }
            return Undefined.instance;
        }
        throw ScriptRuntime.typeError2("msg.isnt.function", obj, ScriptRuntime.typeof(obj));
    }

    private Object js_get(Object obj) {
        Object obj2 = this.entries.get(obj);
        if (obj2 == null) {
            return Undefined.instance;
        }
        if (obj2 != NULL_VALUE) {
            return obj2;
        }
        return null;
    }

    private Object js_getSize() {
        return Integer.valueOf(this.entries.size());
    }

    private Object js_has(Object obj) {
        return Boolean.valueOf(this.entries.has(obj));
    }

    private Object js_iterator(Scriptable scriptable, NativeCollectionIterator.Type type) {
        return new NativeCollectionIterator(scriptable, ITERATOR_TAG, type, this.entries.iterator());
    }

    private Object js_set(Object obj, Object obj2) {
        if (obj2 == null) {
            obj2 = NULL_VALUE;
        }
        if ((obj instanceof Number) && ((Number) obj).doubleValue() == ScriptRuntime.negativeZero) {
            obj = Double.valueOf((double) RoundRectDrawableWithShadow.COS_45);
        }
        this.entries.put(obj, obj2);
        return this;
    }

    public static void loadFromIterable(Context context, Scriptable scriptable, ScriptableObject scriptableObject, Object obj) {
        if (obj == null || Undefined.instance.equals(obj)) {
            return;
        }
        Object callIterator = ScriptRuntime.callIterator(obj, context, scriptable);
        if (Undefined.instance.equals(callIterator)) {
            return;
        }
        Callable propFunctionAndThis = ScriptRuntime.getPropFunctionAndThis(ScriptableObject.ensureScriptableObject(context.newObject(scriptable, scriptableObject.getClassName())).getPrototype(), "set", context, scriptable);
        ScriptRuntime.lastStoredScriptable(context);
        IteratorLikeIterable iteratorLikeIterable = new IteratorLikeIterable(context, scriptable, callIterator);
        try {
            Iterator<Object> it = iteratorLikeIterable.iterator();
            while (it.hasNext()) {
                Scriptable ensureScriptable = ScriptableObject.ensureScriptable(it.next());
                if (ensureScriptable instanceof Symbol) {
                    throw ScriptRuntime.typeError1("msg.arg.not.object", ScriptRuntime.typeof(ensureScriptable));
                }
                Object obj2 = ensureScriptable.get(0, ensureScriptable);
                if (obj2 == Scriptable.NOT_FOUND) {
                    obj2 = Undefined.instance;
                }
                Object obj3 = ensureScriptable.get(1, ensureScriptable);
                if (obj3 == Scriptable.NOT_FOUND) {
                    obj3 = Undefined.instance;
                }
                propFunctionAndThis.call(context, scriptable, scriptableObject, new Object[]{obj2, obj3});
            }
            iteratorLikeIterable.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    iteratorLikeIterable.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    private NativeMap realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (scriptable != null) {
            try {
                NativeMap nativeMap = (NativeMap) scriptable;
                if (nativeMap.instanceOfMap) {
                    return nativeMap;
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
        switch (idFunctionObject.methodId()) {
            case 1:
                if (scriptable2 != null) {
                    throw ScriptRuntime.typeError1("msg.no.new", "Map");
                }
                NativeMap nativeMap = new NativeMap();
                nativeMap.instanceOfMap = true;
                if (objArr.length > 0) {
                    loadFromIterable(context, scriptable, nativeMap, objArr[0]);
                }
                return nativeMap;
            case 2:
                return realThis(scriptable2, idFunctionObject).js_set(objArr.length > 0 ? objArr[0] : Undefined.instance, objArr.length > 1 ? objArr[1] : Undefined.instance);
            case 3:
                return realThis(scriptable2, idFunctionObject).js_get(objArr.length > 0 ? objArr[0] : Undefined.instance);
            case 4:
                return realThis(scriptable2, idFunctionObject).js_delete(objArr.length > 0 ? objArr[0] : Undefined.instance);
            case 5:
                return realThis(scriptable2, idFunctionObject).js_has(objArr.length > 0 ? objArr[0] : Undefined.instance);
            case 6:
                return realThis(scriptable2, idFunctionObject).js_clear();
            case 7:
                return realThis(scriptable2, idFunctionObject).js_iterator(scriptable, NativeCollectionIterator.Type.KEYS);
            case 8:
                return realThis(scriptable2, idFunctionObject).js_iterator(scriptable, NativeCollectionIterator.Type.VALUES);
            case 9:
                return realThis(scriptable2, idFunctionObject).js_iterator(scriptable, NativeCollectionIterator.Type.BOTH);
            case 10:
                return realThis(scriptable2, idFunctionObject).js_forEach(context, scriptable, objArr.length > 0 ? objArr[0] : Undefined.instance, objArr.length > 1 ? objArr[1] : Undefined.instance);
            case 11:
                return realThis(scriptable2, idFunctionObject).js_getSize();
            default:
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Map.prototype has no method: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(idFunctionObject.getFunctionName());
                throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(String str) {
        String str2;
        int length = str.length();
        int i = 7;
        if (length != 3) {
            if (length == 4) {
                str2 = SavedStateHandle.KEYS;
            } else if (length == 5) {
                str2 = "clear";
                i = 6;
            } else if (length == 6) {
                char charAt = str.charAt(0);
                if (charAt == 'd') {
                    str2 = "delete";
                    i = 4;
                } else if (charAt == 'v') {
                    i = 8;
                    str2 = SavedStateHandle.VALUES;
                }
            } else if (length == 7) {
                char charAt2 = str.charAt(0);
                if (charAt2 == 'e') {
                    i = 9;
                    str2 = "entries";
                } else if (charAt2 == 'f') {
                    i = 10;
                    str2 = "forEach";
                }
            } else if (length == 11) {
                str2 = "constructor";
                i = 1;
            }
            if (str2 == null && str2 != str && !str2.equals(str)) {
                return 0;
            }
            return i;
        }
        char charAt3 = str.charAt(0);
        if (charAt3 == 'g') {
            if (str.charAt(2) == 't' && str.charAt(1) == 'e') {
                return 3;
            }
        } else if (charAt3 == 'h') {
            if (str.charAt(2) == 's' && str.charAt(1) == 'a') {
                return 5;
            }
        } else if (charAt3 == 's' && str.charAt(2) == 't' && str.charAt(1) == 'e') {
            return 2;
        }
        str2 = null;
        i = 0;
        if (str2 == null) {
        }
        return i;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(Symbol symbol) {
        if (NativeSet.GETSIZE.equals(symbol)) {
            return 11;
        }
        if (SymbolKey.ITERATOR.equals(symbol)) {
            return 9;
        }
        return SymbolKey.TO_STRING_TAG.equals(symbol) ? 12 : 0;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Map";
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i) {
        String str;
        String str2;
        int i2;
        String str3;
        if (i == 11) {
            initPrototypeMethod(MAP_TAG, i, NativeSet.GETSIZE, "get size", 0);
        } else if (i == 12) {
            initPrototypeValue(12, SymbolKey.TO_STRING_TAG, getClassName(), 3);
        } else {
            switch (i) {
                case 1:
                    str = "constructor";
                    str2 = str;
                    i2 = 0;
                    break;
                case 2:
                    str2 = "set";
                    i2 = 2;
                    break;
                case 3:
                    str3 = "get";
                    str2 = str3;
                    i2 = 1;
                    break;
                case 4:
                    str3 = "delete";
                    str2 = str3;
                    i2 = 1;
                    break;
                case 5:
                    str3 = "has";
                    str2 = str3;
                    i2 = 1;
                    break;
                case 6:
                    str = "clear";
                    str2 = str;
                    i2 = 0;
                    break;
                case 7:
                    str = SavedStateHandle.KEYS;
                    str2 = str;
                    i2 = 0;
                    break;
                case 8:
                    str = SavedStateHandle.VALUES;
                    str2 = str;
                    i2 = 0;
                    break;
                case 9:
                    str = "entries";
                    str2 = str;
                    i2 = 0;
                    break;
                case 10:
                    str3 = "forEach";
                    str2 = str3;
                    i2 = 1;
                    break;
                default:
                    throw new IllegalArgumentException(String.valueOf(i));
            }
            initPrototypeMethod(MAP_TAG, i, str2, (String) null, i2);
        }
    }
}
