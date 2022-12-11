package org.mozilla.javascript;

import java.lang.reflect.Array;
import org.simpleframework.xml.strategy.Name;

/* loaded from: classes5.dex */
public class NativeJavaArray extends NativeJavaObject implements SymbolScriptable {
    public static final long serialVersionUID = -924022554283675333L;
    public Object array;
    public Class<?> cls;
    public int length;

    public NativeJavaArray(Scriptable scriptable, Object obj) {
        super(scriptable, null, ScriptRuntime.ObjectClass);
        Class<?> cls = obj.getClass();
        if (cls.isArray()) {
            this.array = obj;
            this.length = Array.getLength(obj);
            this.cls = cls.getComponentType();
            return;
        }
        throw new RuntimeException("Array expected");
    }

    public static NativeJavaArray wrap(Scriptable scriptable, Object obj) {
        return new NativeJavaArray(scriptable, obj);
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.SymbolScriptable
    public void delete(Symbol symbol) {
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public Object get(int i, Scriptable scriptable) {
        if (i < 0 || i >= this.length) {
            return Undefined.instance;
        }
        Context context = Context.getContext();
        return context.getWrapFactory().wrap(context, this, Array.get(this.array, i), this.cls);
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public Object get(String str, Scriptable scriptable) {
        if (str.equals(Name.LENGTH)) {
            return Integer.valueOf(this.length);
        }
        Object obj = super.get(str, scriptable);
        if (obj == Scriptable.NOT_FOUND && !ScriptableObject.hasProperty(getPrototype(), str)) {
            throw Context.reportRuntimeError2("msg.java.member.not.found", this.array.getClass().getName(), str);
        }
        return obj;
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.SymbolScriptable
    public Object get(Symbol symbol, Scriptable scriptable) {
        if (SymbolKey.IS_CONCAT_SPREADABLE.equals(symbol)) {
            return true;
        }
        return Scriptable.NOT_FOUND;
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "JavaArray";
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public Object getDefaultValue(Class<?> cls) {
        return (cls == null || cls == ScriptRuntime.StringClass) ? this.array.toString() : cls == ScriptRuntime.BooleanClass ? Boolean.TRUE : cls == ScriptRuntime.NumberClass ? ScriptRuntime.NaNobj : this;
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public Object[] getIds() {
        int i = this.length;
        Object[] objArr = new Object[i];
        while (true) {
            i--;
            if (i >= 0) {
                objArr[i] = Integer.valueOf(i);
            } else {
                return objArr;
            }
        }
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public Scriptable getPrototype() {
        if (this.prototype == null) {
            this.prototype = ScriptableObject.getArrayPrototype(getParentScope());
        }
        return this.prototype;
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public boolean has(int i, Scriptable scriptable) {
        return i >= 0 && i < this.length;
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public boolean has(String str, Scriptable scriptable) {
        return str.equals(Name.LENGTH) || super.has(str, scriptable);
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.SymbolScriptable
    public boolean has(Symbol symbol, Scriptable scriptable) {
        return SymbolKey.IS_CONCAT_SPREADABLE.equals(symbol);
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public boolean hasInstance(Scriptable scriptable) {
        if (!(scriptable instanceof Wrapper)) {
            return false;
        }
        return this.cls.isInstance(((Wrapper) scriptable).unwrap());
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public void put(int i, Scriptable scriptable, Object obj) {
        if (i < 0 || i >= this.length) {
            throw Context.reportRuntimeError2("msg.java.array.index.out.of.bounds", String.valueOf(i), String.valueOf(this.length - 1));
        }
        Array.set(this.array, i, Context.jsToJava(obj, this.cls));
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Scriptable
    public void put(String str, Scriptable scriptable, Object obj) {
        if (str.equals(Name.LENGTH)) {
            return;
        }
        throw Context.reportRuntimeError1("msg.java.array.member.not.found", str);
    }

    @Override // org.mozilla.javascript.NativeJavaObject, org.mozilla.javascript.Wrapper
    public Object unwrap() {
        return this.array;
    }
}
