package com.sun.script.javascript;

import javax.script.Invocable;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.RhinoException;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.Wrapper;

/* loaded from: classes3.dex */
public final class JavaAdapter extends ScriptableObject implements Function {
    public Invocable engine;

    public JavaAdapter(Invocable invocable) {
        this.engine = invocable;
    }

    public static void init(Context context, Scriptable scriptable, boolean z) throws RhinoException {
        RhinoTopLevel rhinoTopLevel = (RhinoTopLevel) scriptable;
        JavaAdapter javaAdapter = new JavaAdapter(rhinoTopLevel.getScriptEngine());
        javaAdapter.setParentScope(scriptable);
        javaAdapter.setPrototype(ScriptableObject.getFunctionPrototype(scriptable));
        ScriptableObject.putProperty(rhinoTopLevel, "JavaAdapter", javaAdapter);
    }

    @Override // org.mozilla.javascript.Function, org.mozilla.javascript.Callable
    public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) throws RhinoException {
        return construct(context, scriptable, objArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0029, code lost:
        if (r0.isInterface() != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001c, code lost:
        if (r0.isInterface() != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002b, code lost:
        r3 = r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    @Override // org.mozilla.javascript.Function
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Scriptable construct(Context context, Scriptable scriptable, Object[] objArr) throws RhinoException {
        Class cls;
        if (objArr.length == 2) {
            Class cls2 = null;
            Object obj = objArr[0];
            if (obj instanceof Wrapper) {
                Object unwrap = ((Wrapper) obj).unwrap();
                if (unwrap instanceof Class) {
                    cls = (Class) unwrap;
                }
                if (cls2 != null) {
                    throw Context.reportRuntimeError("JavaAdapter: first arg should be interface Class");
                }
                return Context.toObject(this.engine.getInterface(objArr[1], cls2), ScriptableObject.getTopLevelScope(scriptable));
            }
            if (obj instanceof Class) {
                cls = (Class) obj;
            }
            if (cls2 != null) {
            }
        } else {
            throw Context.reportRuntimeError("JavaAdapter requires two arguments");
        }
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "JavaAdapter";
    }
}
