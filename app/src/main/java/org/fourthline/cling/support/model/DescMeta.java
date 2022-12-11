package org.fourthline.cling.support.model;

import java.net.URI;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

/* loaded from: classes5.dex */
public class DescMeta<M> {

    /* renamed from: id */
    public String f4646id;
    public M metadata;
    public URI nameSpace;
    public String type;

    public DescMeta() {
    }

    public DescMeta(String str, String str2, URI uri, M m) {
        this.f4646id = str;
        this.type = str2;
        this.nameSpace = uri;
        this.metadata = m;
    }

    public Document createMetadataDocument() {
        try {
            DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
            newInstance.setNamespaceAware(true);
            Document newDocument = newInstance.newDocumentBuilder().newDocument();
            newDocument.appendChild(newDocument.createElementNS(DIDLContent.DESC_WRAPPER_NAMESPACE_URI, "desc-wrapper"));
            return newDocument;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getId() {
        return this.f4646id;
    }

    public M getMetadata() {
        return this.metadata;
    }

    public URI getNameSpace() {
        return this.nameSpace;
    }

    public String getType() {
        return this.type;
    }

    public void setId(String str) {
        this.f4646id = str;
    }

    public void setMetadata(M m) {
        this.metadata = m;
    }

    public void setNameSpace(URI uri) {
        this.nameSpace = uri;
    }

    public void setType(String str) {
        this.type = str;
    }
}
