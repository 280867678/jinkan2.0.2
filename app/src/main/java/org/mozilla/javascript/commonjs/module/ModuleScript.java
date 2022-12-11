package org.mozilla.javascript.commonjs.module;

import java.io.Serializable;
import java.net.URI;
import org.mozilla.javascript.Script;

/* loaded from: classes5.dex */
public class ModuleScript implements Serializable {
    public static final long serialVersionUID = 1;
    public final URI base;
    public final Script script;
    public final URI uri;

    public ModuleScript(Script script, URI uri, URI uri2) {
        this.script = script;
        this.uri = uri;
        this.base = uri2;
    }

    public URI getBase() {
        return this.base;
    }

    public Script getScript() {
        return this.script;
    }

    public URI getUri() {
        return this.uri;
    }

    public boolean isSandboxed() {
        URI uri;
        URI uri2 = this.base;
        return (uri2 == null || (uri = this.uri) == null || uri2.relativize(uri).isAbsolute()) ? false : true;
    }
}
