package com.thegrizzlylabs.sardineandroid.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Namespace(prefix = "D", reference = "DAV:")
@Root
/* loaded from: classes4.dex */
public class Principal {
    @Element(required = false)
    public All all;
    @Element(required = false)
    public Authenticated authenticated;
    @Element(required = false)
    public String href;
    @Element(required = false)
    public Property property;
    @Element(required = false)
    public Self self;
    @Element(required = false)
    public Unauthenticated unauthenticated;

    public All getAll() {
        return this.all;
    }

    public Authenticated getAuthenticated() {
        return this.authenticated;
    }

    public String getHref() {
        return this.href;
    }

    public Property getProperty() {
        return this.property;
    }

    public Self getSelf() {
        return this.self;
    }

    public Unauthenticated getUnauthenticated() {
        return this.unauthenticated;
    }

    public void setAll(All all) {
        this.all = all;
    }

    public void setAuthenticated(Authenticated authenticated) {
        this.authenticated = authenticated;
    }

    public void setHref(String str) {
        this.href = str;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public void setSelf(Self self) {
        this.self = self;
    }

    public void setUnauthenticated(Unauthenticated unauthenticated) {
        this.unauthenticated = unauthenticated;
    }
}
