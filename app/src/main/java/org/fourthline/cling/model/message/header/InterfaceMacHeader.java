package org.fourthline.cling.model.message.header;

import me.tvspark.outline;
import org.seamless.util.p061io.HexBin;

/* loaded from: classes5.dex */
public class InterfaceMacHeader extends UpnpHeader<byte[]> {
    public InterfaceMacHeader() {
    }

    public InterfaceMacHeader(String str) {
        setString(str);
    }

    public InterfaceMacHeader(byte[] bArr) {
        setValue(bArr);
    }

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public String getString() {
        return HexBin.bytesToString(getValue(), ":");
    }

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public void setString(String str) throws InvalidHeaderException {
        byte[] stringToBytes = HexBin.stringToBytes(str, ":");
        setValue(stringToBytes);
        if (stringToBytes.length == 6) {
            return;
        }
        throw new InvalidHeaderException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid MAC address: ", str));
    }

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(InterfaceMacHeader.class.getSimpleName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(") '");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getString());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("'");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
