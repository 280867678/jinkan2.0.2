package me.tvspark;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import androidx.annotation.NonNull;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.p056io.input.Tailer;

/* loaded from: classes4.dex */
public final class Illllllllllllllllllll extends Illlllllll<AssetFileDescriptor> {
    public Illllllllllllllllllll(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    @Override // me.tvspark.Illlllllllllllllll
    @NonNull
    public Class<AssetFileDescriptor> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return AssetFileDescriptor.class;
    }

    @Override // me.tvspark.Illlllllll
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AssetFileDescriptor assetFileDescriptor) throws IOException {
        assetFileDescriptor.close();
    }

    @Override // me.tvspark.Illlllllll
    public AssetFileDescriptor Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, Tailer.RAF_MODE);
        if (openAssetFileDescriptor != null) {
            return openAssetFileDescriptor;
        }
        throw new FileNotFoundException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("FileDescriptor is null for: ", uri));
    }
}
