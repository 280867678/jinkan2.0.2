package com.google.thirdparty.publicsuffix;

import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

/* loaded from: classes3.dex */
public enum PublicSuffixType {
    PRIVATE(':', ','),
    REGISTRY(PublicSuffixDatabase.EXCEPTION_MARKER, '?');
    
    public final char innerNodeCode;
    public final char leafNodeCode;

    PublicSuffixType(char c, char c2) {
        this.innerNodeCode = c;
        this.leafNodeCode = c2;
    }

    public static PublicSuffixType fromCode(char c) {
        PublicSuffixType[] values;
        for (PublicSuffixType publicSuffixType : values()) {
            if (publicSuffixType.getInnerNodeCode() == c || publicSuffixType.getLeafNodeCode() == c) {
                return publicSuffixType;
            }
        }
        throw new IllegalArgumentException("No enum corresponding to given code: " + c);
    }

    public static PublicSuffixType fromIsPrivate(boolean z) {
        return z ? PRIVATE : REGISTRY;
    }

    public char getInnerNodeCode() {
        return this.innerNodeCode;
    }

    public char getLeafNodeCode() {
        return this.leafNodeCode;
    }
}
