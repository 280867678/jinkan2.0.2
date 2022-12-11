package org.simpleframework.xml.core;

import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

/* loaded from: classes5.dex */
public class DetailExtractor {
    public final Cache<Detail> details;
    public final Cache<ContactList> fields;
    public final Cache<ContactList> methods;
    public final DefaultType override;
    public final Support support;

    public DetailExtractor(Support support) {
        this(support, null);
    }

    public DetailExtractor(Support support, DefaultType defaultType) {
        this.methods = new ConcurrentCache();
        this.fields = new ConcurrentCache();
        this.details = new ConcurrentCache();
        this.override = defaultType;
        this.support = support;
    }

    private ContactList getFields(Class cls, Detail detail) throws Exception {
        FieldScanner fieldScanner = new FieldScanner(detail, this.support);
        if (detail != null) {
            this.fields.cache(cls, fieldScanner);
        }
        return fieldScanner;
    }

    private ContactList getMethods(Class cls, Detail detail) throws Exception {
        MethodScanner methodScanner = new MethodScanner(detail, this.support);
        if (detail != null) {
            this.methods.cache(cls, methodScanner);
        }
        return methodScanner;
    }

    public Detail getDetail(Class cls) {
        Detail fetch = this.details.fetch(cls);
        if (fetch == null) {
            DetailScanner detailScanner = new DetailScanner(cls, this.override);
            this.details.cache(cls, detailScanner);
            return detailScanner;
        }
        return fetch;
    }

    public ContactList getFields(Class cls) throws Exception {
        Detail detail;
        ContactList fetch = this.fields.fetch(cls);
        return (fetch != null || (detail = getDetail(cls)) == null) ? fetch : getFields(cls, detail);
    }

    public ContactList getMethods(Class cls) throws Exception {
        Detail detail;
        ContactList fetch = this.methods.fetch(cls);
        return (fetch != null || (detail = getDetail(cls)) == null) ? fetch : getMethods(cls, detail);
    }
}
