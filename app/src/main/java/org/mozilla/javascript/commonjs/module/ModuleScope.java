package org.mozilla.javascript.commonjs.module;

import java.net.URI;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.TopLevel;

/* loaded from: classes5.dex */
public class ModuleScope extends TopLevel {
    public static final long serialVersionUID = 1;
    public final URI base;
    public final URI uri;

    public ModuleScope(Scriptable scriptable, URI uri, URI uri2) {
        this.uri = uri;
        this.base = uri2;
        setPrototype(scriptable);
        cacheBuiltins();
    }

    public URI getBase() {
        return this.base;
    }

    public URI getUri() {
        return this.uri;
    }
}
