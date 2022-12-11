package org.mozilla.javascript.tools.shell;

import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

/* loaded from: classes5.dex */
public class Environment extends ScriptableObject {
    public static final long serialVersionUID = -430727378460177065L;
    public Environment thePrototypeInstance;

    public Environment() {
        this.thePrototypeInstance = null;
        if (0 == 0) {
            this.thePrototypeInstance = this;
        }
    }

    public Environment(ScriptableObject scriptableObject) {
        this.thePrototypeInstance = null;
        setParentScope(scriptableObject);
        Object topLevelProp = ScriptRuntime.getTopLevelProp(scriptableObject, "Environment");
        if (topLevelProp == null || !(topLevelProp instanceof Scriptable)) {
            return;
        }
        Scriptable scriptable = (Scriptable) topLevelProp;
        setPrototype((Scriptable) scriptable.get("prototype", scriptable));
    }

    private Object[] collectIds() {
        return System.getProperties().keySet().toArray();
    }

    public static void defineClass(ScriptableObject scriptableObject) {
        try {
            ScriptableObject.defineClass(scriptableObject, Environment.class);
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object get(String str, Scriptable scriptable) {
        if (this == this.thePrototypeInstance) {
            return super.get(str, scriptable);
        }
        String property = System.getProperty(str);
        return property != null ? ScriptRuntime.toObject(getParentScope(), property) : Scriptable.NOT_FOUND;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.debug.DebuggableObject
    public Object[] getAllIds() {
        return this == this.thePrototypeInstance ? super.getAllIds() : collectIds();
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Environment";
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object[] getIds() {
        return this == this.thePrototypeInstance ? super.getIds() : collectIds();
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public boolean has(String str, Scriptable scriptable) {
        return this == this.thePrototypeInstance ? super.has(str, scriptable) : System.getProperty(str) != null;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void put(String str, Scriptable scriptable, Object obj) {
        if (this == this.thePrototypeInstance) {
            super.put(str, scriptable, obj);
        } else {
            System.getProperties().put(str, ScriptRuntime.toString(obj));
        }
    }
}
