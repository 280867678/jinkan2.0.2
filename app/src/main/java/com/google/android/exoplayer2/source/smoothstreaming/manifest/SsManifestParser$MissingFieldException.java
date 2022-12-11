package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import com.google.android.exoplayer2.ParserException;

/* loaded from: classes3.dex */
public class SsManifestParser$MissingFieldException extends ParserException {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SsManifestParser$MissingFieldException(String str) {
        super(r3.length() != 0 ? "Missing required field: ".concat(r3) : new String("Missing required field: "));
        String valueOf = String.valueOf(str);
    }
}
