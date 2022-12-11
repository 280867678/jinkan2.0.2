package org.mozilla.javascript.commonjs.module.provider;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.simpleframework.xml.strategy.Name;

/* loaded from: classes5.dex */
public abstract class ModuleSourceProviderBase implements ModuleSourceProvider, Serializable {
    public static final long serialVersionUID = 1;

    public static String ensureTrailingSlash(String str) {
        return str.endsWith("/") ? str : str.concat("/");
    }

    private ModuleSource loadFromPathArray(String str, Scriptable scriptable, Object obj) throws IOException {
        long uint32 = ScriptRuntime.toUint32(ScriptableObject.getProperty(scriptable, Name.LENGTH));
        int i = uint32 > 2147483647L ? Integer.MAX_VALUE : (int) uint32;
        for (int i2 = 0; i2 < i; i2++) {
            String ensureTrailingSlash = ensureTrailingSlash((String) ScriptableObject.getTypedProperty(scriptable, i2, String.class));
            try {
                URI uri = new URI(ensureTrailingSlash);
                if (!uri.isAbsolute()) {
                    uri = new File(ensureTrailingSlash).toURI().resolve("");
                }
                ModuleSource loadFromUri = loadFromUri(uri.resolve(str), uri, obj);
                if (loadFromUri != null) {
                    return loadFromUri;
                }
            } catch (URISyntaxException e) {
                throw new MalformedURLException(e.getMessage());
            }
        }
        return null;
    }

    public boolean entityNeedsRevalidation(Object obj) {
        return true;
    }

    public ModuleSource loadFromFallbackLocations(String str, Object obj) throws IOException, URISyntaxException {
        return null;
    }

    public ModuleSource loadFromPrivilegedLocations(String str, Object obj) throws IOException, URISyntaxException {
        return null;
    }

    public abstract ModuleSource loadFromUri(URI uri, URI uri2, Object obj) throws IOException, URISyntaxException;

    @Override // org.mozilla.javascript.commonjs.module.provider.ModuleSourceProvider
    public ModuleSource loadSource(String str, Scriptable scriptable, Object obj) throws IOException, URISyntaxException {
        ModuleSource loadFromPathArray;
        if (!entityNeedsRevalidation(obj)) {
            return ModuleSourceProvider.NOT_MODIFIED;
        }
        ModuleSource loadFromPrivilegedLocations = loadFromPrivilegedLocations(str, obj);
        return loadFromPrivilegedLocations != null ? loadFromPrivilegedLocations : (scriptable == null || (loadFromPathArray = loadFromPathArray(str, scriptable, obj)) == null) ? loadFromFallbackLocations(str, obj) : loadFromPathArray;
    }

    @Override // org.mozilla.javascript.commonjs.module.provider.ModuleSourceProvider
    public ModuleSource loadSource(URI uri, URI uri2, Object obj) throws IOException, URISyntaxException {
        return loadFromUri(uri, uri2, obj);
    }
}
