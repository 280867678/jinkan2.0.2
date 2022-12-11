package org.seamless.xhtml;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPath;
import org.seamless.xml.DOM;
import org.w3c.dom.Document;

/* loaded from: classes5.dex */
public class XHTML extends DOM {
    public static final String NAMESPACE_URI = "http://www.w3.org/1999/xhtml";
    public static final String SCHEMA_RESOURCE = "org/seamless/schemas/xhtml1-strict.xsd";

    /* loaded from: classes5.dex */
    public enum ATTR {
        id,
        style,
        title,
        type,
        href,
        name,
        content,
        scheme,
        rel,
        rev,
        colspan,
        rowspan,
        src,
        alt,
        action,
        method;
        
        public static final String CLASS = "class";
    }

    /* loaded from: classes5.dex */
    public enum ELEMENT {
        html,
        head,
        title,
        meta,
        link,
        script,
        style,
        body,
        div,
        span,
        p,
        object,
        a,
        img,
        pre,
        h1,
        h2,
        h3,
        h4,
        h5,
        h6,
        table,
        thead,
        tfoot,
        tbody,
        tr,
        th,
        td,
        ul,
        ol,
        li,
        dl,
        dt,
        dd,
        form,
        input,
        select,
        option
    }

    public XHTML(Document document) {
        super(document);
    }

    public static Source[] createSchemaSources() {
        return new Source[]{new StreamSource(XHTML.class.getClassLoader().getResourceAsStream(SCHEMA_RESOURCE))};
    }

    @Override // org.seamless.xml.DOM
    /* renamed from: copy */
    public XHTML mo5290copy() {
        return new XHTML((Document) getW3CDocument().cloneNode(true));
    }

    public Root createRoot(XPath xPath, ELEMENT element) {
        super.createRoot(element.name());
        return mo5291getRoot(xPath);
    }

    @Override // org.seamless.xml.DOM
    /* renamed from: getRoot */
    public Root mo5291getRoot(XPath xPath) {
        return new Root(xPath, getW3CDocument().getDocumentElement());
    }

    @Override // org.seamless.xml.DOM
    public String getRootElementNamespace() {
        return NAMESPACE_URI;
    }
}
