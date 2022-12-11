package me.tvspark;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import java.io.IOException;

/* loaded from: classes4.dex */
public class Xxxxxxxx<DataType> implements Illlllllllllllllllllllll<DataType, BitmapDrawable> {
    public final Resources Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Illlllllllllllllllllllll<DataType, Bitmap> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public Xxxxxxxx(@NonNull Resources resources, @NonNull Illlllllllllllllllllllll<DataType, Bitmap> illlllllllllllllllllllll) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(resources, "Argument must not be null");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = resources;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(illlllllllllllllllllllll, "Argument must not be null");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = illlllllllllllllllllllll;
    }

    @Override // me.tvspark.Illlllllllllllllllllllll
    public AbstractC1886O0<BitmapDrawable> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull DataType datatype, int i, int i2, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) throws IOException {
        return Ccccccccc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(datatype, i, i2, illllllllllllllllllllllll));
    }

    @Override // me.tvspark.Illlllllllllllllllllllll
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull DataType datatype, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) throws IOException {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(datatype, illllllllllllllllllllllll);
    }
}
