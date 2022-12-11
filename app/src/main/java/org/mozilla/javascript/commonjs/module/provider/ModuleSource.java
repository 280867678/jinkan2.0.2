package org.mozilla.javascript.commonjs.module.provider;

import java.io.Reader;
import java.io.Serializable;
import java.net.URI;

/* loaded from: classes5.dex */
public class ModuleSource implements Serializable {
    public static final long serialVersionUID = 1;
    public final URI base;
    public final Reader reader;
    public final Object securityDomain;
    public final URI uri;
    public final Object validator;

    public ModuleSource(Reader reader, Object obj, URI uri, URI uri2, Object obj2) {
        this.reader = reader;
        this.securityDomain = obj;
        this.uri = uri;
        this.base = uri2;
        this.validator = obj2;
    }

    public URI getBase() {
        return this.base;
    }

    public Reader getReader() {
        return this.reader;
    }

    public Object getSecurityDomain() {
        return this.securityDomain;
    }

    public URI getUri() {
        return this.uri;
    }

    public Object getValidator() {
        return this.validator;
    }
}
