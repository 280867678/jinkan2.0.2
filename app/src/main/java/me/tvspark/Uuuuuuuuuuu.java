package me.tvspark;

import android.util.Log;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes4.dex */
public class Uuuuuuuuuuu implements AbstractC1883Kk<InputStream> {
    public final OO000 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public Uuuuuuuuuuu(OO000 oo000) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = oo000;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    @Override // me.tvspark.AbstractC1883Kk
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull InputStream inputStream, @NonNull File file, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) {
        FileOutputStream fileOutputStream;
        InputStream inputStream2 = inputStream;
        byte[] bArr = (byte[]) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(65536, byte[].class);
        boolean z = false;
        FileOutputStream fileOutputStream2 = 0;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                    while (true) {
                        try {
                            int read = inputStream2.read(bArr);
                            fileOutputStream2 = -1;
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        } catch (IOException unused) {
                            fileOutputStream2 = fileOutputStream;
                            Log.isLoggable("StreamEncoder", 3);
                            if (fileOutputStream2 != null) {
                                fileOutputStream2.close();
                                fileOutputStream2 = fileOutputStream2;
                            }
                            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(bArr);
                            return z;
                        } catch (Throwable th) {
                            th = th;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException unused2) {
                                }
                            }
                            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(bArr);
                            throw th;
                        }
                    }
                    fileOutputStream.close();
                    z = true;
                    fileOutputStream.close();
                } catch (IOException unused3) {
                }
            } catch (IOException unused4) {
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(bArr);
            return z;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = fileOutputStream2;
        }
    }
}
