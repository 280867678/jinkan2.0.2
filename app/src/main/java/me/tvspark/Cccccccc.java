package me.tvspark;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import me.tvspark.Ccccccccccc;

@RequiresApi(21)
/* loaded from: classes4.dex */
public final class Cccccccc implements Illlllllllllllllllllllll<ParcelFileDescriptor, Bitmap> {
    public final Zzzzzzz Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public Cccccccc(Zzzzzzz zzzzzzz) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = zzzzzzz;
    }

    @Override // me.tvspark.Illlllllllllllllllllllll
    @Nullable
    public AbstractC1886O0<Bitmap> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull ParcelFileDescriptor parcelFileDescriptor, int i, int i2, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) throws IOException {
        Zzzzzzz zzzzzzz = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        return zzzzzzz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Ccccccccccc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parcelFileDescriptor, zzzzzzz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, zzzzzzz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), i, i2, illllllllllllllllllllllll, Zzzzzzz.Wwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.Illlllllllllllllllllllll
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull ParcelFileDescriptor parcelFileDescriptor, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) throws IOException {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            return true;
        }
        throw null;
    }
}
