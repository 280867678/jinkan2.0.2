package com.google.android.exoplayer2.text;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderException;

/* loaded from: classes3.dex */
public class SubtitleDecoderException extends DecoderException {
    public SubtitleDecoderException(String str) {
        super(str);
    }

    public SubtitleDecoderException(String str, @Nullable Throwable th) {
        super(str, th);
    }

    public SubtitleDecoderException(@Nullable Throwable th) {
        super(th);
    }
}
