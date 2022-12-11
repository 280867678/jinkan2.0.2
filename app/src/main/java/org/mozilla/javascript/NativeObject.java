package org.mozilla.javascript;

import androidx.core.graphics.TypefaceCompatApi26Impl;
import androidx.lifecycle.SavedStateHandle;
import com.umeng.analytics.pro.C1543ak;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.simpleframework.xml.core.AnnotationHandler;

/* loaded from: classes5.dex */
public class NativeObject extends IdScriptableObject implements Map {
    public static final int ConstructorId_assign = -15;
    public static final int ConstructorId_create = -9;
    public static final int ConstructorId_defineProperties = -8;
    public static final int ConstructorId_defineProperty = -5;
    public static final int ConstructorId_freeze = -13;
    public static final int ConstructorId_getOwnPropertyDescriptor = -4;
    public static final int ConstructorId_getOwnPropertyNames = -3;
    public static final int ConstructorId_getOwnPropertySymbols = -14;
    public static final int ConstructorId_getPrototypeOf = -1;
    public static final int ConstructorId_is = -16;
    public static final int ConstructorId_isExtensible = -6;
    public static final int ConstructorId_isFrozen = -11;
    public static final int ConstructorId_isSealed = -10;
    public static final int ConstructorId_keys = -2;
    public static final int ConstructorId_preventExtensions = -7;
    public static final int ConstructorId_seal = -12;
    public static final int Id___defineGetter__ = 9;
    public static final int Id___defineSetter__ = 10;
    public static final int Id___lookupGetter__ = 11;
    public static final int Id___lookupSetter__ = 12;
    public static final int Id_constructor = 1;
    public static final int Id_hasOwnProperty = 5;
    public static final int Id_isPrototypeOf = 7;
    public static final int Id_propertyIsEnumerable = 6;
    public static final int Id_toLocaleString = 3;
    public static final int Id_toSource = 8;
    public static final int Id_toString = 2;
    public static final int Id_valueOf = 4;
    public static final int MAX_PROTOTYPE_ID = 12;
    public static final Object OBJECT_TAG = "Object";
    public static final long serialVersionUID = -6345305608474346996L;

    /* loaded from: classes5.dex */
    public class EntrySet extends AbstractSet<Map.Entry<Object, Object>> {
        public EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<Object, Object>> iterator() {
            return new Iterator<Map.Entry<Object, Object>>() { // from class: org.mozilla.javascript.NativeObject.EntrySet.1
                public Object[] ids;
                public Object key = null;
                public int index = 0;

                {
                    this.ids = NativeObject.this.getIds();
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.index < this.ids.length;
                }

                @Override // java.util.Iterator
                public Map.Entry<Object, Object> next() {
                    Object[] objArr = this.ids;
                    int i = this.index;
                    this.index = i + 1;
                    final Object obj = objArr[i];
                    this.key = obj;
                    final Object obj2 = NativeObject.this.get(obj);
                    return new Map.Entry<Object, Object>() { // from class: org.mozilla.javascript.NativeObject.EntrySet.1.1
                        @Override // java.util.Map.Entry
                        public boolean equals(Object obj3) {
                            if (!(obj3 instanceof Map.Entry)) {
                                return false;
                            }
                            Map.Entry entry = (Map.Entry) obj3;
                            Object obj4 = obj;
                            if (obj4 == null) {
                                if (entry.getKey() != null) {
                                    return false;
                                }
                            } else if (!obj4.equals(entry.getKey())) {
                                return false;
                            }
                            Object obj5 = obj2;
                            Object value = entry.getValue();
                            if (obj5 == null) {
                                if (value != null) {
                                    return false;
                                }
                            } else if (!obj5.equals(value)) {
                                return false;
                            }
                            return true;
                        }

                        @Override // java.util.Map.Entry
                        public Object getKey() {
                            return obj;
                        }

                        @Override // java.util.Map.Entry
                        public Object getValue() {
                            return obj2;
                        }

                        @Override // java.util.Map.Entry
                        public int hashCode() {
                            Object obj3 = obj;
                            int i2 = 0;
                            int hashCode = obj3 == null ? 0 : obj3.hashCode();
                            Object obj4 = obj2;
                            if (obj4 != null) {
                                i2 = obj4.hashCode();
                            }
                            return hashCode ^ i2;
                        }

                        @Override // java.util.Map.Entry
                        public Object setValue(Object obj3) {
                            throw new UnsupportedOperationException();
                        }

                        public String toString() {
                            return obj + "=" + obj2;
                        }
                    };
                }

                @Override // java.util.Iterator
                public void remove() {
                    Object obj = this.key;
                    if (obj != null) {
                        NativeObject.this.remove(obj);
                        this.key = null;
                        return;
                    }
                    throw new IllegalStateException();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return NativeObject.this.size();
        }
    }

    /* loaded from: classes5.dex */
    public class KeySet extends AbstractSet<Object> {
        public KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return NativeObject.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Object> iterator() {
            return new Iterator<Object>() { // from class: org.mozilla.javascript.NativeObject.KeySet.1
                public Object[] ids;
                public int index = 0;
                public Object key;

                {
                    this.ids = NativeObject.this.getIds();
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.index < this.ids.length;
                }

                @Override // java.util.Iterator
                public Object next() {
                    try {
                        Object[] objArr = this.ids;
                        int i = this.index;
                        this.index = i + 1;
                        Object obj = objArr[i];
                        this.key = obj;
                        return obj;
                    } catch (ArrayIndexOutOfBoundsException unused) {
                        this.key = null;
                        throw new NoSuchElementException();
                    }
                }

                @Override // java.util.Iterator
                public void remove() {
                    Object obj = this.key;
                    if (obj != null) {
                        NativeObject.this.remove(obj);
                        this.key = null;
                        return;
                    }
                    throw new IllegalStateException();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return NativeObject.this.size();
        }
    }

    /* loaded from: classes5.dex */
    public class ValueCollection extends AbstractCollection<Object> {
        public ValueCollection() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Object> iterator() {
            return new Iterator<Object>() { // from class: org.mozilla.javascript.NativeObject.ValueCollection.1
                public Object[] ids;
                public int index = 0;
                public Object key;

                {
                    this.ids = NativeObject.this.getIds();
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.index < this.ids.length;
                }

                @Override // java.util.Iterator
                public Object next() {
                    NativeObject nativeObject = NativeObject.this;
                    Object[] objArr = this.ids;
                    int i = this.index;
                    this.index = i + 1;
                    Object obj = objArr[i];
                    this.key = obj;
                    return nativeObject.get(obj);
                }

                @Override // java.util.Iterator
                public void remove() {
                    Object obj = this.key;
                    if (obj != null) {
                        NativeObject.this.remove(obj);
                        this.key = null;
                        return;
                    }
                    throw new IllegalStateException();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return NativeObject.this.size();
        }
    }

    public static Scriptable getCompatibleObject(Context context, Scriptable scriptable, Object obj) {
        return context.getLanguageVersion() >= 200 ? ScriptableObject.ensureScriptable(ScriptRuntime.toObject(context, scriptable, obj)) : ScriptableObject.ensureScriptable(obj);
    }

    public static void init(Scriptable scriptable, boolean z) {
        new NativeObject().exportAsJSClass(12, scriptable, z);
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        if (obj instanceof String) {
            return has((String) obj, this);
        }
        if (!(obj instanceof Number)) {
            return false;
        }
        return has(((Number) obj).intValue(), this);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        for (Object obj2 : values()) {
            if (obj == obj2) {
                return true;
            }
            if (obj != null && obj.equals(obj2)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public Set<Map.Entry<Object, Object>> entrySet() {
        return new EntrySet();
    }

    /* JADX WARN: Code restructure failed: missing block: B:115:0x013f, code lost:
        if ((((org.mozilla.javascript.ScriptableObject) r12).getAttributes(r9) & 2) == 0) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005b, code lost:
        return r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0103, code lost:
        if ((((org.mozilla.javascript.ScriptableObject) r12).getAttributes(r9) & 2) == 0) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0105, code lost:
        r5 = true;
     */
    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Object[] ids;
        int int32;
        Object obj;
        Object[] allIds;
        Object[] allIds2;
        boolean has;
        boolean has2;
        Scriptable prototype;
        if (!idFunctionObject.hasTag(OBJECT_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int methodId = idFunctionObject.methodId();
        boolean z = false;
        r5 = false;
        r5 = false;
        boolean z2 = false;
        r5 = false;
        boolean z3 = false;
        r5 = false;
        boolean z4 = false;
        boolean z5 = true;
        switch (methodId) {
            case -16:
                return ScriptRuntime.wrapBoolean(ScriptRuntime.same(objArr.length < 1 ? Undefined.instance : objArr[0], objArr.length < 2 ? Undefined.instance : objArr[1]));
            case -15:
                if (objArr.length < 1) {
                    throw ScriptRuntime.typeError1("msg.incompat.call", "assign");
                }
                Scriptable object = ScriptRuntime.toObject(context, scriptable2, objArr[0]);
                for (int i = 1; i < objArr.length; i++) {
                    if (objArr[i] != null && !Undefined.instance.equals(objArr[i])) {
                        Scriptable object2 = ScriptRuntime.toObject(context, scriptable2, objArr[i]);
                        for (Object obj2 : object2.getIds()) {
                            if (obj2 instanceof String) {
                                String str = (String) obj2;
                                Object obj3 = object2.get(str, object);
                                if (obj3 != Scriptable.NOT_FOUND && obj3 != Undefined.instance) {
                                    object.put(str, object, obj3);
                                }
                            } else if ((obj2 instanceof Number) && (obj = object2.get((int32 = ScriptRuntime.toInt32(obj2)), object)) != Scriptable.NOT_FOUND && obj != Undefined.instance) {
                                object.put(int32, object, obj);
                            }
                        }
                    }
                }
                return object;
            case -14:
                Object[] ids2 = ScriptableObject.ensureScriptableObject(getCompatibleObject(context, scriptable, objArr.length < 1 ? Undefined.instance : objArr[0])).getIds(true, true);
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < ids2.length; i2++) {
                    if (ids2[i2] instanceof Symbol) {
                        arrayList.add(ids2[i2]);
                    }
                }
                return context.newArray(scriptable, arrayList.toArray());
            case -13:
                Object obj4 = objArr.length < 1 ? Undefined.instance : objArr[0];
                if (context.getLanguageVersion() >= 200 && !(obj4 instanceof ScriptableObject)) {
                    return obj4;
                }
                ScriptableObject ensureScriptableObject = ScriptableObject.ensureScriptableObject(obj4);
                for (Object obj5 : ensureScriptableObject.getAllIds()) {
                    ScriptableObject ownPropertyDescriptor = ensureScriptableObject.getOwnPropertyDescriptor(context, obj5);
                    if (isDataDescriptor(ownPropertyDescriptor) && Boolean.TRUE.equals(ownPropertyDescriptor.get("writable"))) {
                        ownPropertyDescriptor.put("writable", ownPropertyDescriptor, Boolean.FALSE);
                    }
                    if (Boolean.TRUE.equals(ownPropertyDescriptor.get("configurable"))) {
                        ownPropertyDescriptor.put("configurable", ownPropertyDescriptor, Boolean.FALSE);
                    }
                    ensureScriptableObject.defineOwnProperty(context, obj5, ownPropertyDescriptor, false);
                }
                ensureScriptableObject.preventExtensions();
                return ensureScriptableObject;
            case -12:
                Object obj6 = objArr.length < 1 ? Undefined.instance : objArr[0];
                if (context.getLanguageVersion() >= 200 && !(obj6 instanceof ScriptableObject)) {
                    return obj6;
                }
                ScriptableObject ensureScriptableObject2 = ScriptableObject.ensureScriptableObject(obj6);
                for (Object obj7 : ensureScriptableObject2.getAllIds()) {
                    ScriptableObject ownPropertyDescriptor2 = ensureScriptableObject2.getOwnPropertyDescriptor(context, obj7);
                    if (Boolean.TRUE.equals(ownPropertyDescriptor2.get("configurable"))) {
                        ownPropertyDescriptor2.put("configurable", ownPropertyDescriptor2, Boolean.FALSE);
                        ensureScriptableObject2.defineOwnProperty(context, obj7, ownPropertyDescriptor2, false);
                    }
                }
                ensureScriptableObject2.preventExtensions();
                return ensureScriptableObject2;
            case -11:
                Object obj8 = objArr.length < 1 ? Undefined.instance : objArr[0];
                if (context.getLanguageVersion() >= 200 && !(obj8 instanceof ScriptableObject)) {
                    return Boolean.TRUE;
                }
                ScriptableObject ensureScriptableObject3 = ScriptableObject.ensureScriptableObject(obj8);
                if (ensureScriptableObject3.isExtensible()) {
                    return Boolean.FALSE;
                }
                for (Object obj9 : ensureScriptableObject3.getAllIds()) {
                    ScriptableObject ownPropertyDescriptor3 = ensureScriptableObject3.getOwnPropertyDescriptor(context, obj9);
                    if (Boolean.TRUE.equals(ownPropertyDescriptor3.get("configurable"))) {
                        return Boolean.FALSE;
                    }
                    if (isDataDescriptor(ownPropertyDescriptor3) && Boolean.TRUE.equals(ownPropertyDescriptor3.get("writable"))) {
                        return Boolean.FALSE;
                    }
                }
                return Boolean.TRUE;
            case -10:
                Object obj10 = objArr.length < 1 ? Undefined.instance : objArr[0];
                if (context.getLanguageVersion() >= 200 && !(obj10 instanceof ScriptableObject)) {
                    return Boolean.TRUE;
                }
                ScriptableObject ensureScriptableObject4 = ScriptableObject.ensureScriptableObject(obj10);
                if (ensureScriptableObject4.isExtensible()) {
                    return Boolean.FALSE;
                }
                for (Object obj11 : ensureScriptableObject4.getAllIds()) {
                    if (Boolean.TRUE.equals(ensureScriptableObject4.getOwnPropertyDescriptor(context, obj11).get("configurable"))) {
                        return Boolean.FALSE;
                    }
                }
                return Boolean.TRUE;
            case -9:
                Object obj12 = objArr.length < 1 ? Undefined.instance : objArr[0];
                Scriptable ensureScriptable = obj12 == null ? null : ScriptableObject.ensureScriptable(obj12);
                NativeObject nativeObject = new NativeObject();
                nativeObject.setParentScope(getParentScope());
                nativeObject.setPrototype(ensureScriptable);
                if (objArr.length > 1 && objArr[1] != Undefined.instance) {
                    nativeObject.defineOwnProperties(context, ScriptableObject.ensureScriptableObject(Context.toObject(objArr[1], getParentScope())));
                }
                return nativeObject;
            case -8:
                ScriptableObject ensureScriptableObject5 = ScriptableObject.ensureScriptableObject(objArr.length < 1 ? Undefined.instance : objArr[0]);
                ensureScriptableObject5.defineOwnProperties(context, ScriptableObject.ensureScriptableObject(Context.toObject(objArr.length < 2 ? Undefined.instance : objArr[1], getParentScope())));
                return ensureScriptableObject5;
            case -7:
                Object obj13 = objArr.length < 1 ? Undefined.instance : objArr[0];
                if (context.getLanguageVersion() >= 200 && !(obj13 instanceof ScriptableObject)) {
                    return obj13;
                }
                ScriptableObject ensureScriptableObject6 = ScriptableObject.ensureScriptableObject(obj13);
                ensureScriptableObject6.preventExtensions();
                return ensureScriptableObject6;
            case -6:
                Object obj14 = objArr.length < 1 ? Undefined.instance : objArr[0];
                return (context.getLanguageVersion() < 200 || (obj14 instanceof ScriptableObject)) ? Boolean.valueOf(ScriptableObject.ensureScriptableObject(obj14).isExtensible()) : Boolean.FALSE;
            case -5:
                ScriptableObject ensureScriptableObject7 = ScriptableObject.ensureScriptableObject(objArr.length < 1 ? Undefined.instance : objArr[0]);
                ensureScriptableObject7.defineOwnProperty(context, objArr.length < 2 ? Undefined.instance : objArr[1], ScriptableObject.ensureScriptableObject(objArr.length < 3 ? Undefined.instance : objArr[2]));
                return ensureScriptableObject7;
            case -4:
                ScriptableObject ownPropertyDescriptor4 = ScriptableObject.ensureScriptableObject(getCompatibleObject(context, scriptable, objArr.length < 1 ? Undefined.instance : objArr[0])).getOwnPropertyDescriptor(context, objArr.length < 2 ? Undefined.instance : objArr[1]);
                return ownPropertyDescriptor4 == null ? Undefined.instance : ownPropertyDescriptor4;
            case -3:
                Object[] ids3 = ScriptableObject.ensureScriptableObject(getCompatibleObject(context, scriptable, objArr.length < 1 ? Undefined.instance : objArr[0])).getIds(true, false);
                for (int i3 = 0; i3 < ids3.length; i3++) {
                    ids3[i3] = ScriptRuntime.toString(ids3[i3]);
                }
                return context.newArray(scriptable, ids3);
            case -2:
                Object[] ids4 = getCompatibleObject(context, scriptable, objArr.length < 1 ? Undefined.instance : objArr[0]).getIds();
                for (int i4 = 0; i4 < ids4.length; i4++) {
                    ids4[i4] = ScriptRuntime.toString(ids4[i4]);
                }
                return context.newArray(scriptable, ids4);
            case -1:
                return getCompatibleObject(context, scriptable, objArr.length < 1 ? Undefined.instance : objArr[0]).getPrototype();
            case 0:
            default:
                throw new IllegalArgumentException(String.valueOf(methodId));
            case 1:
                return scriptable2 != null ? idFunctionObject.construct(context, scriptable, objArr) : (objArr.length == 0 || objArr[0] == null || objArr[0] == Undefined.instance) ? new NativeObject() : ScriptRuntime.toObject(context, scriptable, objArr[0]);
            case 2:
                if (!context.hasFeature(4)) {
                    return ScriptRuntime.defaultObjectToString(scriptable2);
                }
                String defaultObjectToSource = ScriptRuntime.defaultObjectToSource(context, scriptable, scriptable2, objArr);
                int length = defaultObjectToSource.length();
                if (length == 0 || defaultObjectToSource.charAt(0) != '(') {
                    return defaultObjectToSource;
                }
                int i5 = length - 1;
                return defaultObjectToSource.charAt(i5) == ')' ? defaultObjectToSource.substring(1, i5) : defaultObjectToSource;
            case 3:
                Object property = ScriptableObject.getProperty(scriptable2, AnnotationHandler.STRING);
                if (!(property instanceof Callable)) {
                    throw ScriptRuntime.notFunctionError(property);
                }
                return ((Callable) property).call(context, scriptable, scriptable2, ScriptRuntime.emptyArgs);
            case 4:
                return scriptable2;
            case 5:
                Object obj15 = objArr.length < 1 ? Undefined.instance : objArr[0];
                if (obj15 instanceof Symbol) {
                    has = ScriptableObject.ensureSymbolScriptable(scriptable2).has((Symbol) obj15, scriptable2);
                } else {
                    String stringIdOrIndex = ScriptRuntime.toStringIdOrIndex(context, obj15);
                    has = stringIdOrIndex == null ? scriptable2.has(ScriptRuntime.lastIndexResult(context), scriptable2) : scriptable2.has(stringIdOrIndex, scriptable2);
                }
                return ScriptRuntime.wrapBoolean(has);
            case 6:
                Object obj16 = objArr.length < 1 ? Undefined.instance : objArr[0];
                if (obj16 instanceof Symbol) {
                    Symbol symbol = (Symbol) obj16;
                    has2 = ((SymbolScriptable) scriptable2).has(symbol, scriptable2);
                    if (has2 && (scriptable2 instanceof ScriptableObject)) {
                        break;
                    }
                    z4 = has2;
                    return ScriptRuntime.wrapBoolean(z4);
                }
                String stringIdOrIndex2 = ScriptRuntime.toStringIdOrIndex(context, obj16);
                try {
                    if (stringIdOrIndex2 == null) {
                        int lastIndexResult = ScriptRuntime.lastIndexResult(context);
                        boolean has3 = scriptable2.has(lastIndexResult, scriptable2);
                        Integer.toString(lastIndexResult);
                        if (has3 && (scriptable2 instanceof ScriptableObject)) {
                            if ((((ScriptableObject) scriptable2).getAttributes(lastIndexResult) & 2) == 0) {
                                z3 = true;
                            }
                            has3 = z3;
                        }
                        z4 = has3;
                    } else {
                        has2 = scriptable2.has(stringIdOrIndex2, scriptable2);
                        if (has2 && (scriptable2 instanceof ScriptableObject)) {
                            break;
                        }
                        z4 = has2;
                    }
                } catch (EvaluatorException e) {
                    if (!e.getMessage().startsWith(ScriptRuntime.getMessage1("msg.prop.not.found", stringIdOrIndex2))) {
                        throw e;
                    }
                }
                return ScriptRuntime.wrapBoolean(z4);
            case 7:
                if (objArr.length != 0 && (objArr[0] instanceof Scriptable)) {
                    Scriptable scriptable3 = (Scriptable) objArr[0];
                    while (true) {
                        scriptable3 = scriptable3.getPrototype();
                        if (scriptable3 == scriptable2) {
                            z2 = true;
                        } else if (scriptable3 == null) {
                        }
                    }
                }
                return ScriptRuntime.wrapBoolean(z2);
            case 8:
                return ScriptRuntime.defaultObjectToSource(context, scriptable, scriptable2, objArr);
            case 9:
            case 10:
                if (objArr.length < 2 || !(objArr[1] instanceof Callable)) {
                    throw ScriptRuntime.notFunctionError(objArr.length >= 2 ? objArr[1] : Undefined.instance);
                } else if (!(scriptable2 instanceof ScriptableObject)) {
                    throw Context.reportRuntimeError2("msg.extend.scriptable", scriptable2 == null ? "null" : scriptable2.getClass().getName(), String.valueOf(objArr[0]));
                } else {
                    ScriptableObject scriptableObject = (ScriptableObject) scriptable2;
                    String stringIdOrIndex3 = ScriptRuntime.toStringIdOrIndex(context, objArr[0]);
                    int lastIndexResult2 = stringIdOrIndex3 != null ? 0 : ScriptRuntime.lastIndexResult(context);
                    Callable callable = (Callable) objArr[1];
                    if (methodId != 10) {
                        z5 = false;
                    }
                    scriptableObject.setGetterOrSetter(stringIdOrIndex3, lastIndexResult2, callable, z5);
                    if (scriptableObject instanceof NativeArray) {
                        ((NativeArray) scriptableObject).setDenseOnly(false);
                    }
                    return Undefined.instance;
                }
            case 11:
            case 12:
                if (objArr.length < 1 || !(scriptable2 instanceof ScriptableObject)) {
                    return Undefined.instance;
                }
                ScriptableObject scriptableObject2 = (ScriptableObject) scriptable2;
                String stringIdOrIndex4 = ScriptRuntime.toStringIdOrIndex(context, objArr[0]);
                int lastIndexResult3 = stringIdOrIndex4 != null ? 0 : ScriptRuntime.lastIndexResult(context);
                if (methodId == 12) {
                    z = true;
                }
                while (true) {
                    Object getterOrSetter = scriptableObject2.getGetterOrSetter(stringIdOrIndex4, lastIndexResult3, z);
                    if (getterOrSetter == null && (prototype = scriptableObject2.getPrototype()) != null && (prototype instanceof ScriptableObject)) {
                        scriptableObject2 = (ScriptableObject) prototype;
                    }
                }
                return Undefined.instance;
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void fillConstructorProperties(IdFunctionObject idFunctionObject) {
        addIdFunctionProperty(idFunctionObject, OBJECT_TAG, -1, "getPrototypeOf", 1);
        addIdFunctionProperty(idFunctionObject, OBJECT_TAG, -2, SavedStateHandle.KEYS, 1);
        addIdFunctionProperty(idFunctionObject, OBJECT_TAG, -3, "getOwnPropertyNames", 1);
        addIdFunctionProperty(idFunctionObject, OBJECT_TAG, -14, "getOwnPropertySymbols", 1);
        addIdFunctionProperty(idFunctionObject, OBJECT_TAG, -4, "getOwnPropertyDescriptor", 2);
        addIdFunctionProperty(idFunctionObject, OBJECT_TAG, -5, "defineProperty", 3);
        addIdFunctionProperty(idFunctionObject, OBJECT_TAG, -6, "isExtensible", 1);
        addIdFunctionProperty(idFunctionObject, OBJECT_TAG, -7, "preventExtensions", 1);
        addIdFunctionProperty(idFunctionObject, OBJECT_TAG, -8, "defineProperties", 2);
        addIdFunctionProperty(idFunctionObject, OBJECT_TAG, -9, "create", 2);
        addIdFunctionProperty(idFunctionObject, OBJECT_TAG, -10, "isSealed", 1);
        addIdFunctionProperty(idFunctionObject, OBJECT_TAG, -11, "isFrozen", 1);
        addIdFunctionProperty(idFunctionObject, OBJECT_TAG, -12, "seal", 1);
        addIdFunctionProperty(idFunctionObject, OBJECT_TAG, -13, TypefaceCompatApi26Impl.FREEZE_METHOD, 1);
        addIdFunctionProperty(idFunctionObject, OBJECT_TAG, -15, "assign", 2);
        addIdFunctionProperty(idFunctionObject, OBJECT_TAG, -16, C1543ak.f2994ae, 2);
        super.fillConstructorProperties(idFunctionObject);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(String str) {
        String str2;
        int length = str.length();
        int i = 2;
        if (length == 7) {
            i = 4;
            str2 = "valueOf";
        } else if (length == 8) {
            char charAt = str.charAt(3);
            if (charAt == 'o') {
                str2 = "toSource";
                i = 8;
            } else {
                if (charAt == 't') {
                    str2 = AnnotationHandler.STRING;
                }
                str2 = null;
                i = 0;
            }
        } else if (length == 11) {
            i = 1;
            str2 = "constructor";
        } else if (length == 16) {
            char charAt2 = str.charAt(2);
            if (charAt2 == 'd') {
                char charAt3 = str.charAt(8);
                if (charAt3 == 'G') {
                    i = 9;
                    str2 = "__defineGetter__";
                } else {
                    if (charAt3 == 'S') {
                        i = 10;
                        str2 = "__defineSetter__";
                    }
                    str2 = null;
                    i = 0;
                }
            } else {
                if (charAt2 == 'l') {
                    char charAt4 = str.charAt(8);
                    if (charAt4 == 'G') {
                        str2 = "__lookupGetter__";
                        i = 11;
                    } else if (charAt4 == 'S') {
                        i = 12;
                        str2 = "__lookupSetter__";
                    }
                }
                str2 = null;
                i = 0;
            }
        } else if (length == 20) {
            i = 6;
            str2 = "propertyIsEnumerable";
        } else if (length != 13) {
            if (length == 14) {
                char charAt5 = str.charAt(0);
                if (charAt5 == 'h') {
                    i = 5;
                    str2 = "hasOwnProperty";
                } else if (charAt5 == 't') {
                    str2 = "toLocaleString";
                    i = 3;
                }
            }
            str2 = null;
            i = 0;
        } else {
            str2 = "isPrototypeOf";
            i = 7;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Object";
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i) {
        String str;
        String str2;
        int i2 = 1;
        switch (i) {
            case 1:
                str = "constructor";
                break;
            case 2:
                str = AnnotationHandler.STRING;
                i2 = 0;
                break;
            case 3:
                str = "toLocaleString";
                i2 = 0;
                break;
            case 4:
                str = "valueOf";
                i2 = 0;
                break;
            case 5:
                str = "hasOwnProperty";
                break;
            case 6:
                str = "propertyIsEnumerable";
                break;
            case 7:
                str = "isPrototypeOf";
                break;
            case 8:
                str = "toSource";
                i2 = 0;
                break;
            case 9:
                str2 = "__defineGetter__";
                str = str2;
                i2 = 2;
                break;
            case 10:
                str2 = "__defineSetter__";
                str = str2;
                i2 = 2;
                break;
            case 11:
                str = "__lookupGetter__";
                break;
            case 12:
                str = "__lookupSetter__";
                break;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
        initPrototypeMethod(OBJECT_TAG, i, str, i2);
    }

    @Override // java.util.Map
    public Set<Object> keySet() {
        return new KeySet();
    }

    @Override // java.util.Map
    public Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        Object obj2 = get(obj);
        if (obj instanceof String) {
            delete((String) obj);
        } else if (obj instanceof Number) {
            delete(((Number) obj).intValue());
        }
        return obj2;
    }

    public String toString() {
        return ScriptRuntime.defaultObjectToString(this);
    }

    @Override // java.util.Map
    public Collection<Object> values() {
        return new ValueCollection();
    }
}
