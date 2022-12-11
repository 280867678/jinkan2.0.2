package com.sun.script.javascript;

import com.umeng.p048vt.diff.C1865V;
import java.security.AccessControlContext;
import javax.script.Bindings;
import javax.script.SimpleScriptContext;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.ImporterTopLevel;
import org.mozilla.javascript.LazilyLoadedCtor;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.Synchronizer;
import org.mozilla.javascript.Wrapper;

/* loaded from: classes3.dex */
public final class RhinoTopLevel extends ImporterTopLevel {
    public RhinoScriptEngine engine;

    public RhinoTopLevel(Context context, RhinoScriptEngine rhinoScriptEngine) {
        super(context, System.getSecurityManager() != null);
        this.engine = rhinoScriptEngine;
        new LazilyLoadedCtor(this, "JSAdapter", "com.sun.script.javascript.JSAdapter", false);
        JavaAdapter.init(context, this, false);
        defineFunctionProperties(new String[]{C1865V.SP_BINDINGS_KEY, "scope", "sync"}, RhinoTopLevel.class, 2);
    }

    public static Object bindings(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        if (objArr.length == 1) {
            Object obj = objArr[0];
            if (obj instanceof Wrapper) {
                obj = ((Wrapper) obj).unwrap();
            }
            if (obj instanceof ExternalScriptable) {
                return Context.javaToJS(((ExternalScriptable) obj).getContext().getBindings(100), ScriptableObject.getTopLevelScope(scriptable));
            }
        }
        return Context.getUndefinedValue();
    }

    public static Object scope(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        if (objArr.length == 1) {
            Object obj = objArr[0];
            if (obj instanceof Wrapper) {
                obj = ((Wrapper) obj).unwrap();
            }
            if (obj instanceof Bindings) {
                SimpleScriptContext simpleScriptContext = new SimpleScriptContext();
                simpleScriptContext.setBindings((Bindings) obj, 100);
                ExternalScriptable externalScriptable = new ExternalScriptable(simpleScriptContext);
                externalScriptable.setPrototype(ScriptableObject.getObjectPrototype(scriptable));
                externalScriptable.setParentScope(ScriptableObject.getTopLevelScope(scriptable));
                return externalScriptable;
            }
        }
        return Context.getUndefinedValue();
    }

    public static Object sync(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        if (objArr.length != 1 || !(objArr[0] instanceof Function)) {
            throw Context.reportRuntimeError("wrong argument(s) for sync");
        }
        return new Synchronizer((Function) objArr[0]);
    }

    public AccessControlContext getAccessContext() {
        return this.engine.getAccessContext();
    }

    public RhinoScriptEngine getScriptEngine() {
        return this.engine;
    }
}
