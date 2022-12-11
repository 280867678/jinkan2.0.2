package me.tvspark;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import java.io.IOException;

/* loaded from: classes4.dex */
public class Illlllllllllll extends Illlllllllllllllllll<ParcelFileDescriptor> {
    public Illlllllllllll(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    @Override // me.tvspark.Illlllllllllllllll
    @NonNull
    public Class<ParcelFileDescriptor> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return ParcelFileDescriptor.class;
    }

    @Override // me.tvspark.Illlllllllllllllllll
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        parcelFileDescriptor.close();
    }

    @Override // me.tvspark.Illlllllllllllllllll
    public ParcelFileDescriptor Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AssetManager assetManager, String str) throws IOException {
        return assetManager.openFd(str).getParcelFileDescriptor();
    }
}
