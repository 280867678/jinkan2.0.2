package org.fourthline.cling.model.types;

import org.seamless.util.p061io.HexBin;

/* loaded from: classes5.dex */
public class BinHexDatatype extends AbstractDatatype<byte[]> {
    @Override // org.fourthline.cling.model.types.AbstractDatatype, org.fourthline.cling.model.types.Datatype
    public String getString(byte[] bArr) throws InvalidValueException {
        if (bArr == null) {
            return "";
        }
        try {
            return HexBin.bytesToString(bArr);
        } catch (Exception e) {
            throw new InvalidValueException(e.getMessage(), e);
        }
    }

    @Override // org.fourthline.cling.model.types.AbstractDatatype
    public Class<byte[]> getValueType() {
        return byte[].class;
    }

    @Override // org.fourthline.cling.model.types.AbstractDatatype, org.fourthline.cling.model.types.Datatype
    /* renamed from: valueOf  reason: collision with other method in class */
    public byte[] mo5215valueOf(String str) throws InvalidValueException {
        if (str.equals("")) {
            return null;
        }
        try {
            return HexBin.stringToBytes(str);
        } catch (Exception e) {
            throw new InvalidValueException(e.getMessage(), e);
        }
    }
}
