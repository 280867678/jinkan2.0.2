package org.mozilla.javascript;

import org.eclipse.jetty.http.HttpHeaderValues;
import org.litepal.tablemanager.Generator;

/* loaded from: classes5.dex */
public final class NativeGenerator extends IdScriptableObject {
    public static final int GENERATOR_CLOSE = 2;
    public static final int GENERATOR_SEND = 0;
    public static final Object GENERATOR_TAG = Generator.TAG;
    public static final int GENERATOR_THROW = 1;
    public static final int Id___iterator__ = 5;
    public static final int Id_close = 1;
    public static final int Id_next = 2;
    public static final int Id_send = 3;
    public static final int Id_throw = 4;
    public static final int MAX_PROTOTYPE_ID = 5;
    public static final long serialVersionUID = 1645892441041347273L;
    public boolean firstTime = true;
    public NativeFunction function;
    public int lineNumber;
    public String lineSource;
    public boolean locked;
    public Object savedState;

    /* loaded from: classes5.dex */
    public static class GeneratorClosedException extends RuntimeException {
        public static final long serialVersionUID = 2561315658662379681L;
    }

    public NativeGenerator() {
    }

    public NativeGenerator(Scriptable scriptable, NativeFunction nativeFunction, Object obj) {
        this.function = nativeFunction;
        this.savedState = obj;
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        setParentScope(topLevelScope);
        setPrototype((NativeGenerator) ScriptableObject.getTopScopeValue(topLevelScope, GENERATOR_TAG));
    }

    public static NativeGenerator init(ScriptableObject scriptableObject, boolean z) {
        NativeGenerator nativeGenerator = new NativeGenerator();
        if (scriptableObject != null) {
            nativeGenerator.setParentScope(scriptableObject);
            nativeGenerator.setPrototype(ScriptableObject.getObjectPrototype(scriptableObject));
        }
        nativeGenerator.activatePrototypeMap(5);
        if (z) {
            nativeGenerator.sealObject();
        }
        if (scriptableObject != null) {
            scriptableObject.associateValue(GENERATOR_TAG, nativeGenerator);
        }
        return nativeGenerator;
    }

    private Object resume(Context context, Scriptable scriptable, int i, Object obj) {
        if (this.savedState == null) {
            if (i == 2) {
                return Undefined.instance;
            }
            if (i != 1) {
                obj = NativeIterator.getStopIterationObject(scriptable);
            }
            throw new JavaScriptException(obj, this.lineSource, this.lineNumber);
        }
        try {
            try {
                synchronized (this) {
                    if (this.locked) {
                        throw ScriptRuntime.typeError0("msg.already.exec.gen");
                    }
                    this.locked = true;
                }
                Object resumeGenerator = this.function.resumeGenerator(context, scriptable, i, this.savedState, obj);
                synchronized (this) {
                    this.locked = false;
                }
                if (i == 2) {
                    this.savedState = null;
                }
                return resumeGenerator;
            } catch (GeneratorClosedException unused) {
                Object obj2 = Undefined.instance;
                synchronized (this) {
                    this.locked = false;
                    if (i == 2) {
                        this.savedState = null;
                    }
                    return obj2;
                }
            } catch (RhinoException e) {
                this.lineNumber = e.lineNumber();
                this.lineSource = e.lineSource();
                this.savedState = null;
                throw e;
            }
        } catch (Throwable th) {
            synchronized (this) {
                this.locked = false;
                if (i == 2) {
                    this.savedState = null;
                }
                throw th;
            }
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(GENERATOR_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int methodId = idFunctionObject.methodId();
        if (!(scriptable2 instanceof NativeGenerator)) {
            throw IdScriptableObject.incompatibleCallError(idFunctionObject);
        }
        NativeGenerator nativeGenerator = (NativeGenerator) scriptable2;
        if (methodId == 1) {
            return nativeGenerator.resume(context, scriptable, 2, new GeneratorClosedException());
        }
        if (methodId == 2) {
            nativeGenerator.firstTime = false;
            return nativeGenerator.resume(context, scriptable, 0, Undefined.instance);
        } else if (methodId != 3) {
            if (methodId == 4) {
                return nativeGenerator.resume(context, scriptable, 1, objArr.length > 0 ? objArr[0] : Undefined.instance);
            } else if (methodId != 5) {
                throw new IllegalArgumentException(String.valueOf(methodId));
            } else {
                return scriptable2;
            }
        } else {
            Object obj = objArr.length > 0 ? objArr[0] : Undefined.instance;
            if (nativeGenerator.firstTime && !obj.equals(Undefined.instance)) {
                throw ScriptRuntime.typeError0("msg.send.newborn");
            }
            return nativeGenerator.resume(context, scriptable, 0, obj);
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(String str) {
        String str2;
        int length = str.length();
        int i = 5;
        if (length == 4) {
            char charAt = str.charAt(0);
            if (charAt == 'n') {
                i = 2;
                str2 = ES6Iterator.NEXT_METHOD;
            } else {
                if (charAt == 's') {
                    i = 3;
                    str2 = "send";
                }
                str2 = null;
                i = 0;
            }
        } else if (length == 5) {
            char charAt2 = str.charAt(0);
            if (charAt2 == 'c') {
                i = 1;
                str2 = HttpHeaderValues.CLOSE;
            } else {
                if (charAt2 == 't') {
                    str2 = "throw";
                    i = 4;
                }
                str2 = null;
                i = 0;
            }
        } else {
            if (length == 12) {
                str2 = NativeIterator.ITERATOR_PROPERTY_NAME;
            }
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
        return Generator.TAG;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i) {
        String str;
        String str2;
        int i2 = 1;
        if (i == 1) {
            str = HttpHeaderValues.CLOSE;
        } else if (i != 2) {
            if (i == 3) {
                str2 = "send";
            } else if (i == 4) {
                str2 = "throw";
            } else if (i != 5) {
                throw new IllegalArgumentException(String.valueOf(i));
            } else {
                str = NativeIterator.ITERATOR_PROPERTY_NAME;
            }
            str = str2;
            i2 = 0;
        } else {
            str = ES6Iterator.NEXT_METHOD;
        }
        initPrototypeMethod(GENERATOR_TAG, i, str, i2);
    }
}
