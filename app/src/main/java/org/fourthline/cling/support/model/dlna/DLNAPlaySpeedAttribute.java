package org.fourthline.cling.support.model.dlna;

import me.tvspark.outline;
import org.fourthline.cling.model.types.InvalidValueException;
import org.fourthline.cling.support.avtransport.lastchange.AVTransportVariable;

/* loaded from: classes5.dex */
public class DLNAPlaySpeedAttribute extends DLNAAttribute<AVTransportVariable.TransportPlaySpeed[]> {
    public DLNAPlaySpeedAttribute() {
        setValue(new AVTransportVariable.TransportPlaySpeed[0]);
    }

    public DLNAPlaySpeedAttribute(String[] strArr) {
        AVTransportVariable.TransportPlaySpeed[] transportPlaySpeedArr = new AVTransportVariable.TransportPlaySpeed[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            try {
                transportPlaySpeedArr[i] = new AVTransportVariable.TransportPlaySpeed(strArr[i]);
            } catch (InvalidValueException unused) {
                throw new InvalidDLNAProtocolAttributeException("Can't parse DLNA play speeds.");
            }
        }
        setValue(transportPlaySpeedArr);
    }

    public DLNAPlaySpeedAttribute(AVTransportVariable.TransportPlaySpeed[] transportPlaySpeedArr) {
        setValue(transportPlaySpeedArr);
    }

    @Override // org.fourthline.cling.support.model.dlna.DLNAAttribute
    public String getString() {
        AVTransportVariable.TransportPlaySpeed[] value;
        String str = "";
        for (AVTransportVariable.TransportPlaySpeed transportPlaySpeed : getValue()) {
            if (!transportPlaySpeed.getValue().equals("1")) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str.length() == 0 ? "" : ",");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(transportPlaySpeed);
                str = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            }
        }
        return str;
    }

    @Override // org.fourthline.cling.support.model.dlna.DLNAAttribute
    public void setString(String str, String str2) throws InvalidDLNAProtocolAttributeException {
        AVTransportVariable.TransportPlaySpeed[] transportPlaySpeedArr = null;
        if (str != null && str.length() != 0) {
            String[] split = str.split(",");
            try {
                AVTransportVariable.TransportPlaySpeed[] transportPlaySpeedArr2 = new AVTransportVariable.TransportPlaySpeed[split.length];
                for (int i = 0; i < split.length; i++) {
                    transportPlaySpeedArr2[i] = new AVTransportVariable.TransportPlaySpeed(split[i]);
                }
                transportPlaySpeedArr = transportPlaySpeedArr2;
            } catch (InvalidValueException unused) {
            }
        }
        if (transportPlaySpeedArr != null) {
            setValue(transportPlaySpeedArr);
            return;
        }
        throw new InvalidDLNAProtocolAttributeException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Can't parse DLNA play speeds from: ", str));
    }
}
