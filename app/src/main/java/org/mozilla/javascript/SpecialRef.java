package org.mozilla.javascript;

/* loaded from: classes5.dex */
public class SpecialRef extends Ref {
    public static final int SPECIAL_NONE = 0;
    public static final int SPECIAL_PARENT = 2;
    public static final int SPECIAL_PROTO = 1;
    public static final long serialVersionUID = -7521596632456797847L;
    public String name;
    public Scriptable target;
    public int type;

    public SpecialRef(Scriptable scriptable, int i, String str) {
        this.target = scriptable;
        this.type = i;
        this.name = str;
    }

    public static Ref createSpecial(Context context, Scriptable scriptable, Object obj, String str) {
        int i;
        Scriptable objectOrNull = ScriptRuntime.toObjectOrNull(context, obj, scriptable);
        if (objectOrNull != null) {
            if (str.equals("__proto__")) {
                i = 1;
            } else if (!str.equals("__parent__")) {
                throw new IllegalArgumentException(str);
            } else {
                i = 2;
            }
            if (!context.hasFeature(5)) {
                i = 0;
            }
            return new SpecialRef(objectOrNull, i, str);
        }
        throw ScriptRuntime.undefReadError(obj, str);
    }

    @Override // org.mozilla.javascript.Ref
    public boolean delete(Context context) {
        if (this.type == 0) {
            return ScriptRuntime.deleteObjectElem(this.target, this.name, context);
        }
        return false;
    }

    @Override // org.mozilla.javascript.Ref
    public Object get(Context context) {
        int i = this.type;
        if (i != 0) {
            if (i == 1) {
                return this.target.getPrototype();
            }
            if (i != 2) {
                throw Kit.codeBug();
            }
            return this.target.getParentScope();
        }
        return ScriptRuntime.getObjectProp(this.target, this.name, context);
    }

    @Override // org.mozilla.javascript.Ref
    public boolean has(Context context) {
        if (this.type == 0) {
            return ScriptRuntime.hasObjectElem(this.target, this.name, context);
        }
        return true;
    }

    @Override // org.mozilla.javascript.Ref
    @Deprecated
    public Object set(Context context, Object obj) {
        throw new IllegalStateException();
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x003e  */
    @Override // org.mozilla.javascript.Ref
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object set(Context context, Scriptable scriptable, Object obj) {
        int i = this.type;
        if (i != 0) {
            if (i != 1 && i != 2) {
                throw Kit.codeBug();
            }
            Scriptable objectOrNull = ScriptRuntime.toObjectOrNull(context, obj, scriptable);
            if (objectOrNull == null) {
                if (this.type != 1) {
                }
                return objectOrNull;
            }
            Scriptable scriptable2 = objectOrNull;
            while (scriptable2 != this.target) {
                if (this.type == 1) {
                    scriptable2 = scriptable2.getPrototype();
                    continue;
                } else {
                    scriptable2 = scriptable2.getParentScope();
                    continue;
                }
                if (scriptable2 == null) {
                    if (this.type != 1) {
                        this.target.setPrototype(objectOrNull);
                    } else {
                        this.target.setParentScope(objectOrNull);
                    }
                    return objectOrNull;
                }
            }
            throw Context.reportRuntimeError1("msg.cyclic.value", this.name);
        }
        return ScriptRuntime.setObjectProp(this.target, this.name, obj, context);
    }
}
