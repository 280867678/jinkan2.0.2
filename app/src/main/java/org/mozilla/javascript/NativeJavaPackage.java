package org.mozilla.javascript;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashSet;
import java.util.Set;
import me.tvspark.outline;

/* loaded from: classes5.dex */
public class NativeJavaPackage extends ScriptableObject {
    public static final long serialVersionUID = 7445054382212031523L;
    public transient ClassLoader classLoader;
    public Set<String> negativeCache;
    public String packageName;

    @Deprecated
    public NativeJavaPackage(String str) {
        this(false, str, Context.getCurrentContext().getApplicationClassLoader());
    }

    @Deprecated
    public NativeJavaPackage(String str, ClassLoader classLoader) {
        this(false, str, classLoader);
    }

    public NativeJavaPackage(boolean z, String str, ClassLoader classLoader) {
        this.negativeCache = null;
        this.packageName = str;
        this.classLoader = classLoader;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.classLoader = Context.getCurrentContext().getApplicationClassLoader();
    }

    public boolean equals(Object obj) {
        if (obj instanceof NativeJavaPackage) {
            NativeJavaPackage nativeJavaPackage = (NativeJavaPackage) obj;
            return this.packageName.equals(nativeJavaPackage.packageName) && this.classLoader == nativeJavaPackage.classLoader;
        }
        return false;
    }

    public NativeJavaPackage forcePackage(String str, Scriptable scriptable) {
        Object obj = super.get(str, this);
        if (obj == null || !(obj instanceof NativeJavaPackage)) {
            NativeJavaPackage nativeJavaPackage = new NativeJavaPackage(true, this.packageName.length() == 0 ? str : outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new StringBuilder(), this.packageName, ".", str), this.classLoader);
            ScriptRuntime.setObjectProtoAndParent(nativeJavaPackage, scriptable);
            super.put(str, this, nativeJavaPackage);
            return nativeJavaPackage;
        }
        return (NativeJavaPackage) obj;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object get(int i, Scriptable scriptable) {
        return Scriptable.NOT_FOUND;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object get(String str, Scriptable scriptable) {
        return getPkgProperty(str, scriptable, true);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "JavaPackage";
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object getDefaultValue(Class<?> cls) {
        return toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v6, types: [org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.NativeJavaPackage] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r5v0, types: [org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable, org.mozilla.javascript.NativeJavaPackage] */
    public synchronized Object getPkgProperty(String str, Scriptable scriptable, boolean z) {
        String str2;
        Object obj = super.get(str, scriptable);
        if (obj != Scriptable.NOT_FOUND) {
            return obj;
        }
        Scriptable scriptable2 = 0;
        scriptable2 = 0;
        if (this.negativeCache != null && this.negativeCache.contains(str)) {
            return null;
        }
        if (this.packageName.length() == 0) {
            str2 = str;
        } else {
            str2 = this.packageName + '.' + str;
        }
        Context context = Context.getContext();
        ClassShutter classShutter = context.getClassShutter();
        if (classShutter == null || classShutter.visibleToScripts(str2)) {
            Class<?> classOrNull = this.classLoader != null ? Kit.classOrNull(this.classLoader, str2) : Kit.classOrNull(str2);
            if (classOrNull != null) {
                scriptable2 = context.getWrapFactory().wrapJavaClass(context, ScriptableObject.getTopLevelScope(this), classOrNull);
                scriptable2.setPrototype(getPrototype());
            }
        }
        if (scriptable2 == 0) {
            if (z) {
                scriptable2 = new NativeJavaPackage(true, str2, this.classLoader);
                ScriptRuntime.setObjectProtoAndParent(scriptable2, getParentScope());
            } else {
                if (this.negativeCache == null) {
                    this.negativeCache = new HashSet();
                }
                this.negativeCache.add(str);
            }
        }
        if (scriptable2 != 0) {
            super.put(str, scriptable, scriptable2);
        }
        return scriptable2;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public boolean has(int i, Scriptable scriptable) {
        return false;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public boolean has(String str, Scriptable scriptable) {
        return true;
    }

    public int hashCode() {
        int hashCode = this.packageName.hashCode();
        ClassLoader classLoader = this.classLoader;
        return hashCode ^ (classLoader == null ? 0 : classLoader.hashCode());
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void put(int i, Scriptable scriptable, Object obj) {
        throw Context.reportRuntimeError0("msg.pkg.int");
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void put(String str, Scriptable scriptable, Object obj) {
    }

    public String toString() {
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[JavaPackage "), this.packageName, "]");
    }
}
