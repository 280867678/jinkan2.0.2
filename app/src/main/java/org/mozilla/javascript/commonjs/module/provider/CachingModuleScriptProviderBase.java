package org.mozilla.javascript.commonjs.module.provider;

import java.io.Reader;
import java.io.Serializable;
import java.net.URI;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.commonjs.module.ModuleScript;
import org.mozilla.javascript.commonjs.module.ModuleScriptProvider;

/* loaded from: classes5.dex */
public abstract class CachingModuleScriptProviderBase implements ModuleScriptProvider, Serializable {
    public static final int loadConcurrencyLevel = Runtime.getRuntime().availableProcessors() * 8;
    public static final int loadLockCount;
    public static final int loadLockMask;
    public static final int loadLockShift;
    public static final long serialVersionUID = 1;
    public final Object[] loadLocks = new Object[loadLockCount];
    public final ModuleSourceProvider moduleSourceProvider;

    /* loaded from: classes5.dex */
    public static class CachedModuleScript {
        public final ModuleScript moduleScript;
        public final Object validator;

        public CachedModuleScript(ModuleScript moduleScript, Object obj) {
            this.moduleScript = moduleScript;
            this.validator = obj;
        }

        public ModuleScript getModule() {
            return this.moduleScript;
        }

        public Object getValidator() {
            return this.validator;
        }
    }

    static {
        int i = 1;
        int i2 = 0;
        while (i < loadConcurrencyLevel) {
            i2++;
            i <<= 1;
        }
        loadLockShift = 32 - i2;
        loadLockMask = i - 1;
        loadLockCount = i;
    }

    public CachingModuleScriptProviderBase(ModuleSourceProvider moduleSourceProvider) {
        int i = 0;
        while (true) {
            Object[] objArr = this.loadLocks;
            if (i >= objArr.length) {
                this.moduleSourceProvider = moduleSourceProvider;
                return;
            } else {
                objArr[i] = new Object();
                i++;
            }
        }
    }

    public static boolean equal(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static int getConcurrencyLevel() {
        return loadLockCount;
    }

    public static Object getValidator(CachedModuleScript cachedModuleScript) {
        if (cachedModuleScript == null) {
            return null;
        }
        return cachedModuleScript.getValidator();
    }

    public abstract CachedModuleScript getLoadedModule(String str);

    @Override // org.mozilla.javascript.commonjs.module.ModuleScriptProvider
    public ModuleScript getModuleScript(Context context, String str, URI uri, URI uri2, Scriptable scriptable) throws Exception {
        CachedModuleScript loadedModule = getLoadedModule(str);
        Object validator = getValidator(loadedModule);
        ModuleSource loadSource = uri == null ? this.moduleSourceProvider.loadSource(str, scriptable, validator) : this.moduleSourceProvider.loadSource(uri, uri2, validator);
        if (loadSource == ModuleSourceProvider.NOT_MODIFIED) {
            return loadedModule.getModule();
        }
        if (loadSource == null) {
            return null;
        }
        Reader reader = loadSource.getReader();
        try {
            synchronized (this.loadLocks[(str.hashCode() >>> loadLockShift) & loadLockMask]) {
                CachedModuleScript loadedModule2 = getLoadedModule(str);
                if (loadedModule2 != null && !equal(validator, getValidator(loadedModule2))) {
                    ModuleScript module = loadedModule2.getModule();
                    if (reader != null) {
                        reader.close();
                    }
                    return module;
                }
                URI uri3 = loadSource.getUri();
                ModuleScript moduleScript = new ModuleScript(context.compileReader(reader, uri3.toString(), 1, loadSource.getSecurityDomain()), uri3, loadSource.getBase());
                putLoadedModule(str, moduleScript, loadSource.getValidator());
                if (reader != null) {
                    reader.close();
                }
                return moduleScript;
            }
        } finally {
        }
    }

    public abstract void putLoadedModule(String str, ModuleScript moduleScript, Object obj);
}
