package org.fourthline.cling.support.model.dlna.message.header;

import java.util.regex.Pattern;
import me.tvspark.outline;
import org.fourthline.cling.model.message.header.InvalidHeaderException;
import org.fourthline.cling.support.model.dlna.types.ScmsFlagType;

/* loaded from: classes5.dex */
public class ScmsFlagHeader extends DLNAHeader<ScmsFlagType> {
    public static final Pattern pattern = Pattern.compile("^[01]{2}$", 2);

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public String getString() {
        ScmsFlagType value = getValue();
        StringBuilder sb = new StringBuilder();
        String str = "0";
        sb.append(value.isCopyright() ? str : "1");
        if (!value.isOriginal()) {
            str = "1";
        }
        sb.append(str);
        return sb.toString();
    }

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public void setString(String str) throws InvalidHeaderException {
        if (pattern.matcher(str).matches()) {
            boolean z = false;
            boolean z2 = str.charAt(0) == '0';
            if (str.charAt(1) == '0') {
                z = true;
            }
            setValue(new ScmsFlagType(z2, z));
            return;
        }
        throw new InvalidHeaderException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid ScmsFlag header value: ", str));
    }
}
