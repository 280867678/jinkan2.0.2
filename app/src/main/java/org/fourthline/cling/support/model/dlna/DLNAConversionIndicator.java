package org.fourthline.cling.support.model.dlna;

/* loaded from: classes5.dex */
public enum DLNAConversionIndicator {
    NONE(0),
    TRANSCODED(1);
    
    public int code;

    DLNAConversionIndicator(int i) {
        this.code = i;
    }

    public static DLNAConversionIndicator valueOf(int i) {
        DLNAConversionIndicator[] values;
        for (DLNAConversionIndicator dLNAConversionIndicator : values()) {
            if (dLNAConversionIndicator.getCode() == i) {
                return dLNAConversionIndicator;
            }
        }
        return null;
    }

    public int getCode() {
        return this.code;
    }
}
