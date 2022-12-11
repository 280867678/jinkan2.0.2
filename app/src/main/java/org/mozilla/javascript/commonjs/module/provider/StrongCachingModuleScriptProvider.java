package org.mozilla.javascript.commonjs.module.provider;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.mozilla.javascript.commonjs.module.ModuleScript;
import org.mozilla.javascript.commonjs.module.provider.CachingModuleScriptProviderBase;

/* loaded from: classes5.dex */
public class StrongCachingModuleScriptProvider extends CachingModuleScriptProviderBase {
    public static final long serialVersionUID = 1;
    public final Map<String, CachingModuleScriptProviderBase.CachedModuleScript> modules = new ConcurrentHashMap(16, 0.75f, CachingModuleScriptProviderBase.getConcurrencyLevel());

    public StrongCachingModuleScriptProvider(ModuleSourceProvider moduleSourceProvider) {
        super(moduleSourceProvider);
    }

    @Override // org.mozilla.javascript.commonjs.module.provider.CachingModuleScriptProviderBase
    public CachingModuleScriptProviderBase.CachedModuleScript getLoadedModule(String str) {
        return this.modules.get(str);
    }

    @Override // org.mozilla.javascript.commonjs.module.provider.CachingModuleScriptProviderBase
    public void putLoadedModule(String str, ModuleScript moduleScript, Object obj) {
        this.modules.put(str, new CachingModuleScriptProviderBase.CachedModuleScript(moduleScript, obj));
    }
}
