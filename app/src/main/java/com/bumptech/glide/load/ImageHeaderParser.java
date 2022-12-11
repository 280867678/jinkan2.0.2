package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import me.tvspark.OO000;

/* loaded from: classes3.dex */
public interface ImageHeaderParser {

    /* loaded from: classes3.dex */
    public enum ImageType {
        GIF(true),
        JPEG(false),
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        UNKNOWN(false);
        
        public final boolean hasAlpha;

        ImageType(boolean z) {
            this.hasAlpha = z;
        }

        public boolean hasAlpha() {
            return this.hasAlpha;
        }
    }

    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull InputStream inputStream, @NonNull OO000 oo000) throws IOException;

    @NonNull
    ImageType Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull InputStream inputStream) throws IOException;

    @NonNull
    ImageType Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull ByteBuffer byteBuffer) throws IOException;
}
