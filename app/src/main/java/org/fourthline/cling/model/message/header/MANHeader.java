package org.fourthline.cling.model.message.header;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.tvspark.outline;

/* loaded from: classes5.dex */
public class MANHeader extends UpnpHeader<String> {
    public String namespace;
    public static final Pattern PATTERN = Pattern.compile("\"(.+?)\"(;.+?)??");
    public static final Pattern NAMESPACE_PATTERN = Pattern.compile(";\\s?ns\\s?=\\s?([0-9]{2})");

    public MANHeader() {
    }

    public MANHeader(String str) {
        setValue(str);
    }

    public MANHeader(String str, String str2) {
        this(str);
        this.namespace = str2;
    }

    public String getNamespace() {
        return this.namespace;
    }

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public String getString() {
        if (getValue() == null) {
            return null;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("\"");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getValue());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("\"");
        if (getNamespace() != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("; ns=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getNamespace());
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    public void setNamespace(String str) {
        this.namespace = str;
    }

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public void setString(String str) throws InvalidHeaderException {
        Matcher matcher = PATTERN.matcher(str);
        if (matcher.matches()) {
            setValue(matcher.group(1));
            if (matcher.group(2) == null) {
                return;
            }
            Matcher matcher2 = NAMESPACE_PATTERN.matcher(matcher.group(2));
            if (!matcher2.matches()) {
                throw new InvalidHeaderException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid namespace in MAN header value: ", str));
            }
            setNamespace(matcher2.group(1));
            return;
        }
        throw new InvalidHeaderException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid MAN header value: ", str));
    }
}
