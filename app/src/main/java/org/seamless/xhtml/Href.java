package org.seamless.xhtml;

import java.net.URI;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes5.dex */
public class Href {
    public URI uri;

    public Href(URI uri) {
        this.uri = uri;
    }

    public static Href fromString(String str) {
        if (str == null) {
            return null;
        }
        return new Href(URI.create(str.replaceAll(StringUtils.SPACE, "%20")));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && Href.class == obj.getClass() && this.uri.equals(((Href) obj).uri);
    }

    public URI getURI() {
        return this.uri;
    }

    public int hashCode() {
        return this.uri.hashCode();
    }

    public String toString() {
        return getURI().toString();
    }
}
