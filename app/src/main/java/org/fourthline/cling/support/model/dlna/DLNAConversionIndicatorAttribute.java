package org.fourthline.cling.support.model.dlna;

import me.tvspark.outline;

/* loaded from: classes5.dex */
public class DLNAConversionIndicatorAttribute extends DLNAAttribute<DLNAConversionIndicator> {
    public DLNAConversionIndicatorAttribute() {
        setValue(DLNAConversionIndicator.NONE);
    }

    public DLNAConversionIndicatorAttribute(DLNAConversionIndicator dLNAConversionIndicator) {
        setValue(dLNAConversionIndicator);
    }

    @Override // org.fourthline.cling.support.model.dlna.DLNAAttribute
    public String getString() {
        return Integer.toString(getValue().getCode());
    }

    @Override // org.fourthline.cling.support.model.dlna.DLNAAttribute
    public void setString(String str, String str2) throws InvalidDLNAProtocolAttributeException {
        DLNAConversionIndicator dLNAConversionIndicator;
        try {
            dLNAConversionIndicator = DLNAConversionIndicator.valueOf(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            dLNAConversionIndicator = null;
        }
        if (dLNAConversionIndicator != null) {
            setValue(dLNAConversionIndicator);
            return;
        }
        throw new InvalidDLNAProtocolAttributeException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Can't parse DLNA play speed integer from: ", str));
    }
}
