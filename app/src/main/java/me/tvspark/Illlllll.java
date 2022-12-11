package me.tvspark;

import android.content.res.AssetManager;
import androidx.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes4.dex */
public class Illlllll extends Illlllllllllllllllll<InputStream> {
    public Illlllll(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    @Override // me.tvspark.Illlllllllllllllll
    @NonNull
    public Class<InputStream> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return InputStream.class;
    }

    @Override // me.tvspark.Illlllllllllllllllll
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    @Override // me.tvspark.Illlllllllllllllllll
    public InputStream Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AssetManager assetManager, String str) throws IOException {
        return assetManager.open(str);
    }
}
