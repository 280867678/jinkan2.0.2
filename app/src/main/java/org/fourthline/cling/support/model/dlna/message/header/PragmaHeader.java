package org.fourthline.cling.support.model.dlna.message.header;

import java.util.ArrayList;
import java.util.List;
import me.tvspark.outline;
import org.fourthline.cling.model.message.header.InvalidHeaderException;
import org.fourthline.cling.model.types.PragmaType;

/* loaded from: classes5.dex */
public class PragmaHeader extends DLNAHeader<List<PragmaType>> {
    public PragmaHeader() {
        setValue(new ArrayList());
    }

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public String getString() {
        String str = "";
        for (PragmaType pragmaType : getValue()) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str.length() == 0 ? "" : ",");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(pragmaType.getString());
            str = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        return str;
    }

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public void setString(String str) throws InvalidHeaderException {
        if (str.length() != 0) {
            if (str.endsWith(";")) {
                str = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, -1, 0);
            }
            String[] split = str.split("\\s*;\\s*");
            ArrayList arrayList = new ArrayList();
            for (String str2 : split) {
                arrayList.add(PragmaType.valueOf(str2));
            }
            return;
        }
        throw new InvalidHeaderException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid Pragma header value: ", str));
    }
}
