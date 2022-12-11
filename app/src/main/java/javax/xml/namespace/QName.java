package javax.xml.namespace;

import java.io.Serializable;

/* loaded from: classes4.dex */
public class QName implements Serializable {
    public String localPart;
    public String namespaceURI;
    public String prefix;

    public QName(String str) {
        this("", str);
    }

    public QName(String str, String str2) {
        this(str, str2, "");
    }

    public QName(String str, String str2, String str3) {
        if (str2 != null) {
            str = str == null ? "" : str;
            str3 = str3 == null ? "" : str3;
            this.namespaceURI = str;
            this.localPart = str2;
            this.prefix = str3;
            return;
        }
        throw new IllegalArgumentException("Local part not allowed to be null");
    }

    public static QName valueOf(String str) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("invalid QName literal");
        }
        if (str.charAt(0) != '{') {
            return new QName(str);
        }
        int indexOf = str.indexOf(125);
        if (indexOf == -1) {
            throw new IllegalArgumentException("invalid QName literal");
        }
        if (indexOf == str.length() - 1) {
            throw new IllegalArgumentException("invalid QName literal");
        }
        return new QName(str.substring(1, indexOf), str.substring(indexOf + 1));
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof QName)) {
            QName qName = (QName) obj;
            return this.localPart.equals(qName.localPart) && this.namespaceURI.equals(qName.namespaceURI);
        }
        return false;
    }

    public String getLocalPart() {
        return this.localPart;
    }

    public String getNamespaceURI() {
        return this.namespaceURI;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public final int hashCode() {
        return this.namespaceURI.hashCode() ^ this.localPart.hashCode();
    }

    public String toString() {
        if (this.namespaceURI.equals("")) {
            return this.localPart;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{");
        stringBuffer.append(this.namespaceURI);
        stringBuffer.append("}");
        stringBuffer.append(this.localPart);
        return stringBuffer.toString();
    }
}
