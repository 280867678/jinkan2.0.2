package org.fourthline.cling.support.model.dlna.message.header;

import me.tvspark.outline;
import org.fourthline.cling.model.message.header.InvalidHeaderException;

/* loaded from: classes5.dex */
public class GetContentFeaturesHeader extends DLNAHeader<Integer> {
    public GetContentFeaturesHeader() {
        setValue(1);
    }

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public String getString() {
        return getValue().toString();
    }

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public void setString(String str) throws InvalidHeaderException {
        if (str.length() != 0) {
            try {
                if (Integer.parseInt(str) == 1) {
                    return;
                }
            } catch (Exception unused) {
            }
        }
        throw new InvalidHeaderException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid GetContentFeatures header value: ", str));
    }
}
