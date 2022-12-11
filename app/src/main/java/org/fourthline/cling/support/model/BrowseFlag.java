package org.fourthline.cling.support.model;

/* loaded from: classes5.dex */
public enum BrowseFlag {
    METADATA("BrowseMetadata"),
    DIRECT_CHILDREN("BrowseDirectChildren");
    
    public String protocolString;

    BrowseFlag(String str) {
        this.protocolString = str;
    }

    public static BrowseFlag valueOrNullOf(String str) {
        BrowseFlag[] values;
        for (BrowseFlag browseFlag : values()) {
            if (browseFlag.toString().equals(str)) {
                return browseFlag;
            }
        }
        return null;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.protocolString;
    }
}
