package org.mozilla.javascript;

/* loaded from: classes5.dex */
public class ImporterTopLevel extends TopLevel {
    public static final Object IMPORTER_TAG = "Importer";
    public static final int Id_constructor = 1;
    public static final int Id_importClass = 2;
    public static final int Id_importPackage = 3;
    public static final int MAX_PROTOTYPE_ID = 3;
    public static final long serialVersionUID = -9095380847465315412L;
    public ObjArray importedPackages;
    public boolean topScopeFlag;

    public ImporterTopLevel() {
        this.importedPackages = new ObjArray();
    }

    public ImporterTopLevel(Context context) {
        this(context, false);
    }

    public ImporterTopLevel(Context context, boolean z) {
        this.importedPackages = new ObjArray();
        initStandardObjects(context, z);
    }

    private Object getPackageProperty(String str, Scriptable scriptable) {
        Object[] array;
        Object obj = Scriptable.NOT_FOUND;
        synchronized (this.importedPackages) {
            array = this.importedPackages.toArray();
        }
        for (Object obj2 : array) {
            Object pkgProperty = ((NativeJavaPackage) obj2).getPkgProperty(str, scriptable, false);
            if (pkgProperty != null && !(pkgProperty instanceof NativeJavaPackage)) {
                if (obj != Scriptable.NOT_FOUND) {
                    throw Context.reportRuntimeError2("msg.ambig.import", obj.toString(), pkgProperty.toString());
                }
                obj = pkgProperty;
            }
        }
        return obj;
    }

    private void importClass(NativeJavaClass nativeJavaClass) {
        String name = nativeJavaClass.getClassObject().getName();
        String substring = name.substring(name.lastIndexOf(46) + 1);
        Object obj = get(substring, this);
        if (obj == Scriptable.NOT_FOUND || obj == nativeJavaClass) {
            put(substring, this, nativeJavaClass);
            return;
        }
        throw Context.reportRuntimeError1("msg.prop.defined", substring);
    }

    private void importPackage(NativeJavaPackage nativeJavaPackage) {
        if (nativeJavaPackage == null) {
            return;
        }
        synchronized (this.importedPackages) {
            for (int i = 0; i != this.importedPackages.size(); i++) {
                if (nativeJavaPackage.equals(this.importedPackages.get(i))) {
                    return;
                }
            }
            this.importedPackages.add(nativeJavaPackage);
        }
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        new ImporterTopLevel().exportAsJSClass(3, scriptable, z);
    }

    private Object js_construct(Scriptable scriptable, Object[] objArr) {
        ImporterTopLevel importerTopLevel = new ImporterTopLevel();
        for (int i = 0; i != objArr.length; i++) {
            Object obj = objArr[i];
            if (obj instanceof NativeJavaClass) {
                importerTopLevel.importClass((NativeJavaClass) obj);
            } else if (!(obj instanceof NativeJavaPackage)) {
                throw Context.reportRuntimeError1("msg.not.class.not.pkg", Context.toString(obj));
            } else {
                importerTopLevel.importPackage((NativeJavaPackage) obj);
            }
        }
        importerTopLevel.setParentScope(scriptable);
        importerTopLevel.setPrototype(this);
        return importerTopLevel;
    }

    private Object js_importClass(Object[] objArr) {
        for (int i = 0; i != objArr.length; i++) {
            Object obj = objArr[i];
            if (!(obj instanceof NativeJavaClass)) {
                throw Context.reportRuntimeError1("msg.not.class", Context.toString(obj));
            }
            importClass((NativeJavaClass) obj);
        }
        return Undefined.instance;
    }

    private Object js_importPackage(Object[] objArr) {
        for (int i = 0; i != objArr.length; i++) {
            Object obj = objArr[i];
            if (!(obj instanceof NativeJavaPackage)) {
                throw Context.reportRuntimeError1("msg.not.pkg", Context.toString(obj));
            }
            importPackage((NativeJavaPackage) obj);
        }
        return Undefined.instance;
    }

    private ImporterTopLevel realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (this.topScopeFlag) {
            return this;
        }
        if (!(scriptable instanceof ImporterTopLevel)) {
            throw IdScriptableObject.incompatibleCallError(idFunctionObject);
        }
        return (ImporterTopLevel) scriptable;
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(IMPORTER_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int methodId = idFunctionObject.methodId();
        if (methodId == 1) {
            return js_construct(scriptable, objArr);
        }
        if (methodId == 2) {
            return realThis(scriptable2, idFunctionObject).js_importClass(objArr);
        }
        if (methodId != 3) {
            throw new IllegalArgumentException(String.valueOf(methodId));
        }
        return realThis(scriptable2, idFunctionObject).js_importPackage(objArr);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(String str) {
        int i;
        String str2;
        int length = str.length();
        if (length == 11) {
            char charAt = str.charAt(0);
            if (charAt == 'c') {
                i = 1;
                str2 = "constructor";
            } else {
                if (charAt == 'i') {
                    i = 2;
                    str2 = "importClass";
                }
                str2 = null;
                i = 0;
            }
        } else {
            if (length == 13) {
                i = 3;
                str2 = "importPackage";
            }
            str2 = null;
            i = 0;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object get(String str, Scriptable scriptable) {
        Object obj = super.get(str, scriptable);
        return obj != Scriptable.NOT_FOUND ? obj : getPackageProperty(str, scriptable);
    }

    @Override // org.mozilla.javascript.TopLevel, org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return this.topScopeFlag ? "global" : "JavaImporter";
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public boolean has(String str, Scriptable scriptable) {
        return super.has(str, scriptable) || getPackageProperty(str, scriptable) != Scriptable.NOT_FOUND;
    }

    @Deprecated
    public void importPackage(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        js_importPackage(objArr);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i) {
        String str;
        int i2 = 1;
        if (i == 1) {
            i2 = 0;
            str = "constructor";
        } else if (i == 2) {
            str = "importClass";
        } else if (i != 3) {
            throw new IllegalArgumentException(String.valueOf(i));
        } else {
            str = "importPackage";
        }
        initPrototypeMethod(IMPORTER_TAG, i, str, i2);
    }

    public void initStandardObjects(Context context, boolean z) {
        context.initStandardObjects(this, z);
        this.topScopeFlag = true;
        IdFunctionObject exportAsJSClass = exportAsJSClass(3, this, false);
        if (z) {
            exportAsJSClass.sealObject();
        }
        delete("constructor");
    }
}
