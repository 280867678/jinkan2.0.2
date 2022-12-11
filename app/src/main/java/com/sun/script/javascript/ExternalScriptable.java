package com.sun.script.javascript;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.script.Bindings;
import javax.script.ScriptContext;
import me.tvspark.outline;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.NativeJavaClass;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.Wrapper;
import org.mozilla.javascript.tools.idswitch.Main;
import org.simpleframework.xml.core.AnnotationHandler;
import org.simpleframework.xml.transform.ClassTransform;

/* loaded from: classes3.dex */
public final class ExternalScriptable implements Scriptable {
    public ScriptContext context;
    public Map<Object, Object> indexedProps;
    public Scriptable parent;
    public Scriptable prototype;

    public ExternalScriptable(ScriptContext scriptContext) {
        this(scriptContext, new HashMap());
    }

    public ExternalScriptable(ScriptContext scriptContext, Map<Object, Object> map) {
        if (scriptContext != null) {
            this.context = scriptContext;
            this.indexedProps = map;
            return;
        }
        throw new NullPointerException("context is null");
    }

    private String[] getAllKeys() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.context) {
            for (Integer num : this.context.getScopes()) {
                Bindings bindings = this.context.getBindings(num.intValue());
                if (bindings != null) {
                    arrayList.ensureCapacity(bindings.size());
                    for (String str : bindings.keySet()) {
                        arrayList.add(str);
                    }
                }
            }
        }
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        return strArr;
    }

    private boolean isEmpty(String str) {
        return str.equals("");
    }

    private Object jsToJava(Object obj) {
        boolean z = obj instanceof Wrapper;
        Wrapper wrapper = obj;
        if (z) {
            Wrapper wrapper2 = (Wrapper) obj;
            if (wrapper2 instanceof NativeJavaClass) {
                return wrapper2;
            }
            Object unwrap = wrapper2.unwrap();
            wrapper = wrapper2;
            if (!(unwrap instanceof Number)) {
                wrapper = wrapper2;
                if (!(unwrap instanceof String)) {
                    wrapper = wrapper2;
                    if (!(unwrap instanceof Boolean)) {
                        wrapper = wrapper2;
                        if (!(unwrap instanceof Character)) {
                            return unwrap;
                        }
                    }
                }
            }
        }
        return wrapper;
    }

    @Override // org.mozilla.javascript.Scriptable
    public void delete(int i) {
        this.indexedProps.remove(new Integer(i));
    }

    @Override // org.mozilla.javascript.Scriptable
    public synchronized void delete(String str) {
        if (isEmpty(str)) {
            this.indexedProps.remove(str);
        } else {
            synchronized (this.context) {
                int attributesScope = this.context.getAttributesScope(str);
                if (attributesScope != -1) {
                    this.context.removeAttribute(str, attributesScope);
                }
            }
        }
    }

    @Override // org.mozilla.javascript.Scriptable
    public synchronized Object get(int i, Scriptable scriptable) {
        Integer num = new Integer(i);
        if (this.indexedProps.containsKey(Integer.valueOf(i))) {
            return this.indexedProps.get(num);
        }
        return Scriptable.NOT_FOUND;
    }

    @Override // org.mozilla.javascript.Scriptable
    public synchronized Object get(String str, Scriptable scriptable) {
        if (isEmpty(str)) {
            if (this.indexedProps.containsKey(str)) {
                return this.indexedProps.get(str);
            }
            return Scriptable.NOT_FOUND;
        }
        synchronized (this.context) {
            int attributesScope = this.context.getAttributesScope(str);
            if (attributesScope != -1) {
                return Context.javaToJS(this.context.getAttribute(str, attributesScope), this);
            }
            return Scriptable.NOT_FOUND;
        }
    }

    @Override // org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Global";
    }

    public ScriptContext getContext() {
        return this.context;
    }

    @Override // org.mozilla.javascript.Scriptable
    public Object getDefaultValue(Class cls) {
        String str;
        Object[] objArr;
        int i = 0;
        while (true) {
            String str2 = "undefined";
            if (i >= 2) {
                if (cls != null) {
                    str2 = cls.getName();
                }
                throw Context.reportRuntimeError("Cannot find default value for object " + str2);
            }
            boolean z = cls != ScriptRuntime.StringClass ? i == 1 : i == 0;
            if (z) {
                objArr = ScriptRuntime.emptyArgs;
                str = AnnotationHandler.STRING;
            } else {
                Object[] objArr2 = new Object[1];
                if (cls != null) {
                    if (cls == ScriptRuntime.StringClass) {
                        str2 = Main.STRING_TAG_STR;
                    } else if (cls == ScriptRuntime.ScriptableClass) {
                        str2 = "object";
                    } else if (cls == ScriptRuntime.FunctionClass) {
                        str2 = "function";
                    } else if (cls == ScriptRuntime.BooleanClass || cls == Boolean.TYPE) {
                        str2 = ClassTransform.BOOLEAN;
                    } else if (cls != ScriptRuntime.NumberClass && cls != ScriptRuntime.ByteClass && cls != Byte.TYPE && cls != ScriptRuntime.ShortClass && cls != Short.TYPE && cls != ScriptRuntime.IntegerClass && cls != Integer.TYPE && cls != ScriptRuntime.FloatClass && cls != Float.TYPE && cls != ScriptRuntime.DoubleClass && cls != Double.TYPE) {
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid JavaScript value of type ");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(cls.toString());
                        throw Context.reportRuntimeError(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                    } else {
                        str2 = "number";
                    }
                }
                objArr2[0] = str2;
                str = "valueOf";
                objArr = objArr2;
            }
            Object property = ScriptableObject.getProperty(this, str);
            if (property instanceof Function) {
                Function function = (Function) property;
                try {
                    Object call = function.call(RhinoScriptEngine.enterContext(), function.getParentScope(), this, objArr);
                    if (call == null) {
                        continue;
                    } else if ((call instanceof Scriptable) && cls != ScriptRuntime.ScriptableClass && cls != ScriptRuntime.FunctionClass) {
                        if (z && (call instanceof Wrapper)) {
                            Object unwrap = ((Wrapper) call).unwrap();
                            if (unwrap instanceof String) {
                                return unwrap;
                            }
                        }
                    }
                } finally {
                    Context.exit();
                }
            }
            i++;
        }
    }

    @Override // org.mozilla.javascript.Scriptable
    public synchronized Object[] getIds() {
        Object[] objArr;
        String[] allKeys = getAllKeys();
        objArr = new Object[allKeys.length + this.indexedProps.size()];
        System.arraycopy(allKeys, 0, objArr, 0, allKeys.length);
        int length = allKeys.length;
        for (Object obj : this.indexedProps.keySet()) {
            int i = length + 1;
            objArr[length] = obj;
            length = i;
        }
        return objArr;
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
    public synchronized boolean has(int i, Scriptable scriptable) {
        return this.indexedProps.containsKey(new Integer(i));
    }

    @Override // org.mozilla.javascript.Scriptable
    public synchronized boolean has(String str, Scriptable scriptable) {
        boolean z;
        if (isEmpty(str)) {
            return this.indexedProps.containsKey(str);
        }
        synchronized (this.context) {
            z = this.context.getAttributesScope(str) != -1;
        }
        return z;
    }

    @Override // org.mozilla.javascript.Scriptable
    public boolean hasInstance(Scriptable scriptable) {
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
        if (scriptable != this) {
            scriptable.put(i, scriptable, obj);
            return;
        }
        synchronized (this) {
            this.indexedProps.put(new Integer(i), obj);
        }
    }

    @Override // org.mozilla.javascript.Scriptable
    public void put(String str, Scriptable scriptable, Object obj) {
        if (scriptable != this) {
            scriptable.put(str, scriptable, obj);
            return;
        }
        synchronized (this) {
            if (isEmpty(str)) {
                this.indexedProps.put(str, obj);
            } else {
                synchronized (this.context) {
                    int attributesScope = this.context.getAttributesScope(str);
                    if (attributesScope == -1) {
                        attributesScope = 100;
                    }
                    this.context.setAttribute(str, jsToJava(obj), attributesScope);
                }
            }
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
}
