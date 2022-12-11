package org.mozilla.javascript;

import org.mozilla.javascript.NativeArrayIterator;
import org.simpleframework.xml.strategy.Name;

/* loaded from: classes5.dex */
public final class Arguments extends IdScriptableObject {
    public static final String FTAG = "Arguments";
    public static final int Id_callee = 1;
    public static final int Id_caller = 3;
    public static final int Id_length = 2;
    public static final int MAX_INSTANCE_ID = 3;
    public static BaseFunction iteratorMethod = new BaseFunction() { // from class: org.mozilla.javascript.Arguments.1
        @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.Function, org.mozilla.javascript.Callable
        public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
            return new NativeArrayIterator(scriptable, scriptable2, NativeArrayIterator.ARRAY_ITERATOR_TYPE.VALUES);
        }
    };
    public static final long serialVersionUID = 4275508002492040609L;
    public NativeCall activation;
    public Object[] args;
    public Object calleeObj;
    public Object callerObj;
    public Object lengthObj;
    public int callerAttr = 2;
    public int calleeAttr = 2;
    public int lengthAttr = 2;

    /* loaded from: classes5.dex */
    public static class ThrowTypeError extends BaseFunction {
        public String propertyName;

        public ThrowTypeError(String str) {
            this.propertyName = str;
        }

        @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.Function, org.mozilla.javascript.Callable
        public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
            throw ScriptRuntime.typeError1("msg.arguments.not.access.strict", this.propertyName);
        }
    }

    public Arguments(NativeCall nativeCall) {
        this.activation = nativeCall;
        Scriptable parentScope = nativeCall.getParentScope();
        setParentScope(parentScope);
        setPrototype(ScriptableObject.getObjectPrototype(parentScope));
        Object[] objArr = nativeCall.originalArgs;
        this.args = objArr;
        this.lengthObj = Integer.valueOf(objArr.length);
        NativeFunction nativeFunction = nativeCall.function;
        this.calleeObj = nativeFunction;
        int languageVersion = nativeFunction.getLanguageVersion();
        this.callerObj = (languageVersion > 130 || languageVersion == 0) ? Scriptable.NOT_FOUND : null;
        defineProperty(SymbolKey.ITERATOR, iteratorMethod, 2);
    }

    private Object arg(int i) {
        if (i >= 0) {
            Object[] objArr = this.args;
            if (objArr.length > i) {
                return objArr[i];
            }
        }
        return Scriptable.NOT_FOUND;
    }

    private Object getFromActivation(int i) {
        String paramOrVarName = this.activation.function.getParamOrVarName(i);
        Scriptable scriptable = this.activation;
        return scriptable.get(paramOrVarName, scriptable);
    }

    private void putIntoActivation(int i, Object obj) {
        String paramOrVarName = this.activation.function.getParamOrVarName(i);
        Scriptable scriptable = this.activation;
        scriptable.put(paramOrVarName, scriptable, obj);
    }

    private void removeArg(int i) {
        synchronized (this) {
            if (this.args[i] != Scriptable.NOT_FOUND) {
                if (this.args == this.activation.originalArgs) {
                    this.args = (Object[]) this.args.clone();
                }
                this.args[i] = Scriptable.NOT_FOUND;
            }
        }
    }

    private void replaceArg(int i, Object obj) {
        if (sharedWithActivation(i)) {
            putIntoActivation(i, obj);
        }
        synchronized (this) {
            if (this.args == this.activation.originalArgs) {
                this.args = (Object[]) this.args.clone();
            }
            this.args[i] = obj;
        }
    }

    private boolean sharedWithActivation(int i) {
        NativeFunction nativeFunction;
        int paramCount;
        if (!Context.getContext().isStrictMode() && i < (paramCount = (nativeFunction = this.activation.function).getParamCount())) {
            if (i < paramCount - 1) {
                String paramOrVarName = nativeFunction.getParamOrVarName(i);
                for (int i2 = i + 1; i2 < paramCount; i2++) {
                    if (paramOrVarName.equals(nativeFunction.getParamOrVarName(i2))) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public void defineAttributesForStrictMode() {
        if (!Context.getContext().isStrictMode()) {
            return;
        }
        setGetterOrSetter("caller", 0, new ThrowTypeError("caller"), true);
        setGetterOrSetter("caller", 0, new ThrowTypeError("caller"), false);
        setGetterOrSetter("callee", 0, new ThrowTypeError("callee"), true);
        setGetterOrSetter("callee", 0, new ThrowTypeError("callee"), false);
        setAttributes("caller", 6);
        setAttributes("callee", 6);
        this.callerObj = null;
        this.calleeObj = null;
    }

    @Override // org.mozilla.javascript.ScriptableObject
    public void defineOwnProperty(Context context, Object obj, ScriptableObject scriptableObject, boolean z) {
        super.defineOwnProperty(context, obj, scriptableObject, z);
        double number = ScriptRuntime.toNumber(obj);
        int i = (int) number;
        if (number == i && arg(i) != Scriptable.NOT_FOUND) {
            if (isAccessorDescriptor(scriptableObject)) {
                removeArg(i);
                return;
            }
            Object property = ScriptableObject.getProperty(scriptableObject, "value");
            if (property == Scriptable.NOT_FOUND) {
                return;
            }
            replaceArg(i, property);
            if (!ScriptableObject.isFalse(ScriptableObject.getProperty(scriptableObject, "writable"))) {
                return;
            }
            removeArg(i);
        }
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void delete(int i) {
        if (i >= 0 && i < this.args.length) {
            removeArg(i);
        }
        super.delete(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0050  */
    @Override // org.mozilla.javascript.IdScriptableObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int findInstanceIdInfo(String str) {
        String str2;
        int i;
        int i2;
        int i3 = 0;
        if (str.length() == 6) {
            char charAt = str.charAt(5);
            if (charAt == 'e') {
                str2 = "callee";
                i = 1;
            } else if (charAt == 'h') {
                str2 = Name.LENGTH;
                i = 2;
            } else if (charAt == 'r') {
                str2 = "caller";
                i = 3;
            }
            if (str2 != null || str2 == str || str2.equals(str)) {
                i3 = i;
            }
            if (!Context.getContext().isStrictMode() && (i3 == 1 || i3 == 3)) {
                return super.findInstanceIdInfo(str);
            }
            if (i3 != 0) {
                return super.findInstanceIdInfo(str);
            }
            if (i3 == 1) {
                i2 = this.calleeAttr;
            } else if (i3 == 2) {
                i2 = this.lengthAttr;
            } else if (i3 != 3) {
                throw new IllegalStateException();
            } else {
                i2 = this.callerAttr;
            }
            return IdScriptableObject.instanceIdInfo(i2, i3);
        }
        str2 = null;
        i = 0;
        if (str2 != null) {
        }
        i3 = i;
        if (!Context.getContext().isStrictMode()) {
        }
        if (i3 != 0) {
        }
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object get(int i, Scriptable scriptable) {
        Object arg = arg(i);
        return arg == Scriptable.NOT_FOUND ? super.get(i, scriptable) : sharedWithActivation(i) ? getFromActivation(i) : arg;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return FTAG;
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.ScriptableObject
    public Object[] getIds(boolean z, boolean z2) {
        int intValue;
        Object[] ids = super.getIds(z, z2);
        Object[] objArr = this.args;
        if (objArr.length != 0) {
            int length = objArr.length;
            boolean[] zArr = new boolean[length];
            int length2 = objArr.length;
            for (int i = 0; i != ids.length; i++) {
                Object obj = ids[i];
                if ((obj instanceof Integer) && (intValue = ((Integer) obj).intValue()) >= 0 && intValue < this.args.length && !zArr[intValue]) {
                    zArr[intValue] = true;
                    length2--;
                }
            }
            if (!z) {
                for (int i2 = 0; i2 < length; i2++) {
                    if (!zArr[i2] && super.has(i2, this)) {
                        zArr[i2] = true;
                        length2--;
                    }
                }
            }
            if (length2 == 0) {
                return ids;
            }
            Object[] objArr2 = new Object[ids.length + length2];
            System.arraycopy(ids, 0, objArr2, length2, ids.length);
            int i3 = 0;
            for (int i4 = 0; i4 != this.args.length; i4++) {
                if (!zArr[i4]) {
                    objArr2[i3] = Integer.valueOf(i4);
                    i3++;
                }
            }
            if (i3 != length2) {
                Kit.codeBug();
            }
            return objArr2;
        }
        return ids;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public String getInstanceIdName(int i) {
        if (i != 1) {
            if (i == 2) {
                return Name.LENGTH;
            }
            if (i == 3) {
                return "caller";
            }
            return null;
        }
        return "callee";
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public Object getInstanceIdValue(int i) {
        Scriptable scriptable;
        if (i != 1) {
            if (i == 2) {
                return this.lengthObj;
            }
            if (i != 3) {
                return super.getInstanceIdValue(i);
            }
            Object obj = this.callerObj;
            if (obj == UniqueTag.NULL_VALUE) {
                return null;
            }
            return (obj != null || (scriptable = this.activation.parentActivationCall) == null) ? obj : scriptable.get("arguments", scriptable);
        }
        return this.calleeObj;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int getMaxInstanceId() {
        return 3;
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.ScriptableObject
    public ScriptableObject getOwnPropertyDescriptor(Context context, Object obj) {
        Object arg;
        if (obj instanceof Scriptable) {
            return super.getOwnPropertyDescriptor(context, obj);
        }
        double number = ScriptRuntime.toNumber(obj);
        int i = (int) number;
        if (number == i && (arg = arg(i)) != Scriptable.NOT_FOUND) {
            if (sharedWithActivation(i)) {
                arg = getFromActivation(i);
            }
            if (super.has(i, this)) {
                ScriptableObject ownPropertyDescriptor = super.getOwnPropertyDescriptor(context, obj);
                ownPropertyDescriptor.put("value", ownPropertyDescriptor, arg);
                return ownPropertyDescriptor;
            }
            Scriptable parentScope = getParentScope();
            if (parentScope == null) {
                parentScope = this;
            }
            return ScriptableObject.buildDataDescriptor(parentScope, arg, 0);
        }
        return super.getOwnPropertyDescriptor(context, obj);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public boolean has(int i, Scriptable scriptable) {
        if (arg(i) != Scriptable.NOT_FOUND) {
            return true;
        }
        return super.has(i, scriptable);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void put(int i, Scriptable scriptable, Object obj) {
        if (arg(i) == Scriptable.NOT_FOUND) {
            super.put(i, scriptable, obj);
        } else {
            replaceArg(i, obj);
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void put(String str, Scriptable scriptable, Object obj) {
        super.put(str, scriptable, obj);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void setInstanceIdAttributes(int i, int i2) {
        if (i == 1) {
            this.calleeAttr = i2;
        } else if (i == 2) {
            this.lengthAttr = i2;
        } else if (i != 3) {
            super.setInstanceIdAttributes(i, i2);
        } else {
            this.callerAttr = i2;
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void setInstanceIdValue(int i, Object obj) {
        if (i == 1) {
            this.calleeObj = obj;
        } else if (i == 2) {
            this.lengthObj = obj;
        } else if (i != 3) {
            super.setInstanceIdValue(i, obj);
        } else {
            if (obj == null) {
                obj = UniqueTag.NULL_VALUE;
            }
            this.callerObj = obj;
        }
    }
}
