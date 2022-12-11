package me.tvspark;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.p056io.input.Tailer;

/* loaded from: classes4.dex */
public class Illllllllllll extends Illlllllll<ParcelFileDescriptor> {
    public Illllllllllll(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    @Override // me.tvspark.Illlllllllllllllll
    @NonNull
    public Class<ParcelFileDescriptor> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return ParcelFileDescriptor.class;
    }

    @Override // me.tvspark.Illlllllll
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        parcelFileDescriptor.close();
    }

    @Override // me.tvspark.Illlllllll
    public ParcelFileDescriptor Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, Tailer.RAF_MODE);
        if (openAssetFileDescriptor != null) {
            return openAssetFileDescriptor.getParcelFileDescriptor();
        }
        throw new FileNotFoundException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("FileDescriptor is null for: ", uri));
    }
}
