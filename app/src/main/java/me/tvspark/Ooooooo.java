package me.tvspark;

import android.util.Log;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public class Ooooooo implements AbstractC1883Kk<ByteBuffer> {
    @Override // me.tvspark.AbstractC1883Kk
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull ByteBuffer byteBuffer, @NonNull File file, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) {
        try {
            C2280k1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer, file);
            return true;
        } catch (IOException unused) {
            Log.isLoggable("ByteBufferEncoder", 3);
            return false;
        }
    }
}
