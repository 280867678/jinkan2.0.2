package com.sun.script.javascript;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.NativeArray;
import org.mozilla.javascript.NativeJavaArray;
import org.mozilla.javascript.RhinoException;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

/* loaded from: classes3.dex */
public final class JSAdapter implements Scriptable, Function {
    public static final String DEL_PROP = "__delete__";
    public static final String GET_PROP = "__get__";
    public static final String GET_PROPIDS = "__getIds__";
    public static final String HAS_PROP = "__has__";
    public static final String PUT_PROP = "__put__";
    public Scriptable adaptee;
    public boolean isPrototype;
    public Scriptable parent;
    public Scriptable prototype;

    public JSAdapter(Scriptable scriptable) {
        setAdaptee(scriptable);
    }

    private Object call(Function function, Object[] objArr) {
        try {
            return function.call(Context.getCurrentContext(), function.getParentScope(), getAdaptee(), objArr);
        } catch (RhinoException e) {
            throw Context.reportRuntimeError(e.getMessage());
        }
    }

    private Function getAdapteeFunction(String str) {
        Object property = ScriptableObject.getProperty(getAdaptee(), str);
        if (property instanceof Function) {
            return (Function) property;
        }
        return null;
    }

    public static Scriptable getFunctionPrototype(Scriptable scriptable) {
        return ScriptableObject.getFunctionPrototype(scriptable);
    }

    public static void init(Context context, Scriptable scriptable, boolean z) throws RhinoException {
        JSAdapter jSAdapter = new JSAdapter(context.newObject(scriptable));
        jSAdapter.setParentScope(scriptable);
        jSAdapter.setPrototype(getFunctionPrototype(scriptable));
        jSAdapter.isPrototype = true;
        ScriptableObject.defineProperty(scriptable, "JSAdapter", jSAdapter, 2);
    }

    private Object mapToId(Object obj) {
        return obj instanceof Double ? new Integer(((Double) obj).intValue()) : Context.toString(obj);
    }

    @Override // org.mozilla.javascript.Function, org.mozilla.javascript.Callable
    public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) throws RhinoException {
        if (this.isPrototype) {
            return construct(context, scriptable, objArr);
        }
        Scriptable adaptee = getAdaptee();
        if (!(adaptee instanceof Function)) {
            throw Context.reportRuntimeError("TypeError: not a function");
        }
        return ((Function) adaptee).call(context, scriptable, adaptee, objArr);
    }

    @Override // org.mozilla.javascript.Function
    public Scriptable construct(Context context, Scriptable scriptable, Object[] objArr) throws RhinoException {
        if (this.isPrototype) {
            Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
            if (objArr.length <= 0) {
                throw Context.reportRuntimeError("JSAdapter requires adaptee");
            }
            return new JSAdapter(Context.toObject(objArr[0], topLevelScope));
        }
        Scriptable adaptee = getAdaptee();
        if (!(adaptee instanceof Function)) {
            throw Context.reportRuntimeError("TypeError: not a constructor");
        }
        return ((Function) adaptee).construct(context, scriptable, objArr);
    }

    @Override // org.mozilla.javascript.Scriptable
    public void delete(int i) {
        Function adapteeFunction = getAdapteeFunction(DEL_PROP);
        if (adapteeFunction != null) {
            call(adapteeFunction, new Object[]{new Integer(i)});
        } else {
            getAdaptee().delete(i);
        }
    }

    @Override // org.mozilla.javascript.Scriptable
    public void delete(String str) {
        Function adapteeFunction = getAdapteeFunction(DEL_PROP);
        if (adapteeFunction != null) {
            call(adapteeFunction, new Object[]{str});
        } else {
            getAdaptee().delete(str);
        }
    }

    @Override // org.mozilla.javascript.Scriptable
    public Object get(int i, Scriptable scriptable) {
        Function adapteeFunction = getAdapteeFunction(GET_PROP);
        if (adapteeFunction != null) {
            return call(adapteeFunction, new Object[]{new Integer(i)});
        }
        Scriptable adaptee = getAdaptee();
        return adaptee.get(i, adaptee);
    }

    @Override // org.mozilla.javascript.Scriptable
    public Object get(String str, Scriptable scriptable) {
        Function adapteeFunction = getAdapteeFunction(GET_PROP);
        if (adapteeFunction != null) {
            return call(adapteeFunction, new Object[]{str});
        }
        Scriptable adaptee = getAdaptee();
        return adaptee.get(str, adaptee);
    }

    public Scriptable getAdaptee() {
        return this.adaptee;
    }

    @Override // org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "JSAdapter";
    }

    @Override // org.mozilla.javascript.Scriptable
    public Object getDefaultValue(Class cls) {
        return getAdaptee().getDefaultValue(cls);
    }

    @Override // org.mozilla.javascript.Scriptable
    public Object[] getIds() {
        Function adapteeFunction = getAdapteeFunction(GET_PROPIDS);
        if (adapteeFunction != null) {
            int i = 0;
            Object call = call(adapteeFunction, new Object[0]);
            if (call instanceof NativeArray) {
                NativeArray nativeArray = (NativeArray) call;
                int length = (int) nativeArray.getLength();
                Object[] objArr = new Object[length];
                while (i < length) {
                    objArr[i] = mapToId(nativeArray.get(i, nativeArray));
                    i++;
                }
                return objArr;
            } else if (!(call instanceof NativeJavaArray)) {
                return Context.emptyArgs;
            } else {
                Object unwrap = ((NativeJavaArray) call).unwrap();
                if (unwrap.getClass() != Object[].class) {
                    return Context.emptyArgs;
                }
                Object[] objArr2 = (Object[]) unwrap;
                Object[] objArr3 = new Object[objArr2.length];
                while (i < objArr2.length) {
                    objArr3[i] = mapToId(objArr2[i]);
                    i++;
                }
                return objArr3;
            }
        }
        return getAdaptee().getIds();
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
        Function adapteeFunction = getAdapteeFunction(HAS_PROP);
        if (adapteeFunction != null) {
            return Context.toBoolean(call(adapteeFunction, new Object[]{new Integer(i)}));
        }
        Scriptable adaptee = getAdaptee();
        return adaptee.has(i, adaptee);
    }

    @Override // org.mozilla.javascript.Scriptable
    public boolean has(String str, Scriptable scriptable) {
        Function adapteeFunction = getAdapteeFunction(HAS_PROP);
        if (adapteeFunction != null) {
            return Context.toBoolean(call(adapteeFunction, new Object[]{str}));
        }
        Scriptable adaptee = getAdaptee();
        return adaptee.has(str, adaptee);
    }

    @Override // org.mozilla.javascript.Scriptable
    public boolean hasInstance(Scriptable scriptable) {
        if (scriptable instanceof JSAdapter) {
            return true;
        }
        do {
            scriptable = scriptable.getPrototype();
            if (scriptable == null) {
                return false;
            }
        } while (!scriptable.equals(this));
        return true;
    }

    @Override // org.mozilla.javascript.Scriptable
    public void put(int i, Scriptable scriptable, Object obj) {
        if (scriptable == this) {
            Function adapteeFunction = getAdapteeFunction(PUT_PROP);
            if (adapteeFunction != null) {
                call(adapteeFunction, new Object[]{new Integer(i), obj});
                return;
            }
            scriptable = getAdaptee();
        }
        scriptable.put(i, scriptable, obj);
    }

    @Override // org.mozilla.javascript.Scriptable
    public void put(String str, Scriptable scriptable, Object obj) {
        if (scriptable == this) {
            Function adapteeFunction = getAdapteeFunction(PUT_PROP);
            if (adapteeFunction != null) {
                call(adapteeFunction, new Object[]{str, obj});
                return;
            }
            scriptable = getAdaptee();
        }
        scriptable.put(str, scriptable, obj);
    }

    public void setAdaptee(Scriptable scriptable) {
        if (scriptable != null) {
            this.adaptee = scriptable;
            return;
        }
        throw new NullPointerException("adaptee can not be null");
    }

    @Override // org.mozilla.javascript.Scriptable
    public void setParentScope(Scriptable scriptable) {
        this.parent = scriptable;
    }

    @Override // org.mozilla.javascript.Scriptable
    public void setPrototype(Scriptable scriptable) {
        this.prototype = scriptable;
    }
}
