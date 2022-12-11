package org.fourthline.cling.model.message.header;

import me.tvspark.outline;

/* loaded from: classes5.dex */
public class SubscriptionIdHeader extends UpnpHeader<String> {
    public static final String PREFIX = "uuid:";

    public SubscriptionIdHeader() {
    }

    public SubscriptionIdHeader(String str) {
        setValue(str);
    }

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public String getString() {
        return getValue();
    }

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public void setString(String str) throws InvalidHeaderException {
        if (str.startsWith("uuid:")) {
            setValue(str);
            return;
        }
        throw new InvalidHeaderException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid subscription ID header value, must start with 'uuid:': ", str));
    }
}
