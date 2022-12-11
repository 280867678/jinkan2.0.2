package org.mozilla.javascript;

import java.util.Iterator;

/* loaded from: classes5.dex */
public final class NativeIterator extends IdScriptableObject {
    public static final String ITERATOR_PROPERTY_NAME = "__iterator__";
    public static final Object ITERATOR_TAG = "Iterator";
    public static final int Id___iterator__ = 3;
    public static final int Id_constructor = 1;
    public static final int Id_next = 2;
    public static final int MAX_PROTOTYPE_ID = 3;
    public static final String STOP_ITERATION = "StopIteration";
    public static final long serialVersionUID = -4136968203581667681L;
    public Object objectIterator;

    /* loaded from: classes5.dex */
    public static class StopIteration extends NativeObject {
        public static final long serialVersionUID = 2485151085722377663L;

        @Override // org.mozilla.javascript.NativeObject, org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
        public String getClassName() {
            return NativeIterator.STOP_ITERATION;
        }

        @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
        public boolean hasInstance(Scriptable scriptable) {
            return scriptable instanceof StopIteration;
        }
    }

    /* loaded from: classes5.dex */
    public static class WrappedJavaIterator {
        public Iterator<?> iterator;
        public Scriptable scope;

        public WrappedJavaIterator(Iterator<?> it, Scriptable scriptable) {
            this.iterator = it;
            this.scope = scriptable;
        }

        public Object __iterator__(boolean z) {
            return this;
        }

        public Object next() {
            if (this.iterator.hasNext()) {
                return this.iterator.next();
            }
            throw new JavaScriptException(NativeIterator.getStopIterationObject(this.scope), null, 0);
        }
    }

    public NativeIterator() {
    }

    public NativeIterator(Object obj) {
        this.objectIterator = obj;
    }

    public static Iterator<?> getJavaIterator(Object obj) {
        Iterator<?> it = null;
        if (obj instanceof Wrapper) {
            Object unwrap = ((Wrapper) obj).unwrap();
            if (unwrap instanceof Iterator) {
                it = (Iterator) unwrap;
            }
            return unwrap instanceof Iterable ? ((Iterable) unwrap).iterator() : it;
        }
        return null;
    }

    public static Object getStopIterationObject(Scriptable scriptable) {
        return ScriptableObject.getTopScopeValue(ScriptableObject.getTopLevelScope(scriptable), ITERATOR_TAG);
    }

    public static void init(ScriptableObject scriptableObject, boolean z) {
        new NativeIterator().exportAsJSClass(3, scriptableObject, z);
        NativeGenerator.init(scriptableObject, z);
        StopIteration stopIteration = new StopIteration();
        stopIteration.setPrototype(ScriptableObject.getObjectPrototype(scriptableObject));
        stopIteration.setParentScope(scriptableObject);
        if (z) {
            stopIteration.sealObject();
        }
        ScriptableObject.defineProperty(scriptableObject, STOP_ITERATION, stopIteration, 2);
        scriptableObject.associateValue(ITERATOR_TAG, stopIteration);
    }

    public static Object jsConstructor(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        boolean z = false;
        if (objArr.length == 0 || objArr[0] == null || objArr[0] == Undefined.instance) {
            throw ScriptRuntime.typeError1("msg.no.properties", ScriptRuntime.toString(objArr.length == 0 ? Undefined.instance : objArr[0]));
        }
        Scriptable object = ScriptRuntime.toObject(context, scriptable, objArr[0]);
        if (objArr.length > 1 && ScriptRuntime.toBoolean(objArr[1])) {
            z = true;
        }
        if (scriptable2 != null) {
            Iterator<?> javaIterator = getJavaIterator(object);
            if (javaIterator != null) {
                Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
                return context.getWrapFactory().wrap(context, topLevelScope, new WrappedJavaIterator(javaIterator, topLevelScope), WrappedJavaIterator.class);
            }
            Scriptable iterator = ScriptRuntime.toIterator(context, scriptable, object, z);
            if (iterator != null) {
                return iterator;
            }
        }
        Object enumInit = ScriptRuntime.enumInit(object, context, scriptable, z ? 3 : 5);
        ScriptRuntime.setEnumNumbers(enumInit, true);
        NativeIterator nativeIterator = new NativeIterator(enumInit);
        nativeIterator.setPrototype(ScriptableObject.getClassPrototype(scriptable, nativeIterator.getClassName()));
        nativeIterator.setParentScope(scriptable);
        return nativeIterator;
    }

    private Object next(Context context, Scriptable scriptable) {
        if (ScriptRuntime.enumNext(this.objectIterator).booleanValue()) {
            return ScriptRuntime.enumId(this.objectIterator, context);
        }
        throw new JavaScriptException(getStopIterationObject(scriptable), null, 0);
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(ITERATOR_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int methodId = idFunctionObject.methodId();
        if (methodId == 1) {
            return jsConstructor(context, scriptable, scriptable2, objArr);
        }
        if (!(scriptable2 instanceof NativeIterator)) {
            throw IdScriptableObject.incompatibleCallError(idFunctionObject);
        }
        NativeIterator nativeIterator = (NativeIterator) scriptable2;
        if (methodId == 2) {
            return nativeIterator.next(context, scriptable);
        }
        if (methodId != 3) {
            throw new IllegalArgumentException(String.valueOf(methodId));
        }
        return scriptable2;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(String str) {
        String str2;
        int i;
        int length = str.length();
        if (length == 4) {
            i = 2;
            str2 = ES6Iterator.NEXT_METHOD;
        } else if (length == 11) {
            i = 1;
            str2 = "constructor";
        } else if (length == 12) {
            i = 3;
            str2 = ITERATOR_PROPERTY_NAME;
        } else {
            str2 = null;
            i = 0;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Iterator";
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i) {
        String str;
        int i2 = 1;
        if (i == 1) {
            str = "constructor";
            i2 = 2;
        } else if (i == 2) {
            str = ES6Iterator.NEXT_METHOD;
            i2 = 0;
        } else if (i != 3) {
            throw new IllegalArgumentException(String.valueOf(i));
        } else {
            str = ITERATOR_PROPERTY_NAME;
        }
        initPrototypeMethod(ITERATOR_TAG, i, str, i2);
    }
}
