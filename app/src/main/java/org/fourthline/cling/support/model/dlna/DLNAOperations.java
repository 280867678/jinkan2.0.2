package org.fourthline.cling.support.model.dlna;

/* loaded from: classes5.dex */
public enum DLNAOperations {
    NONE(0),
    RANGE(1),
    TIMESEEK(16);
    
    public int code;

    DLNAOperations(int i) {
        this.code = i;
    }

    public static DLNAOperations valueOf(int i) {
        DLNAOperations[] values;
        for (DLNAOperations dLNAOperations : values()) {
            if (dLNAOperations.getCode() == i) {
                return dLNAOperations;
            }
        }
        return null;
    }

    public int getCode() {
        return this.code;
    }
}
