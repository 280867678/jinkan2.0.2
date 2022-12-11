package me.tvspark;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

@RequiresApi(27)
/* loaded from: classes4.dex */
public final class Zzzz implements ImageHeaderParser {
    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull InputStream inputStream, @NonNull OO000 oo000) throws IOException {
        int attributeInt = new ExifInterface(inputStream).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
        if (attributeInt == 0) {
            return -1;
        }
        return attributeInt;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull InputStream inputStream) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull ByteBuffer byteBuffer) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }
}
