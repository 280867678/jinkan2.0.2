package me.tvspark;

import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import me.tvspark.Illllllllllllllll;

/* loaded from: classes4.dex */
public final class Illllllll implements Illllllllllllllll<ParcelFileDescriptor> {
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    @RequiresApi(21)
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final ParcelFileDescriptor Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ParcelFileDescriptor parcelFileDescriptor) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = parcelFileDescriptor;
        }
    }

    @RequiresApi(21)
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Illllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<ParcelFileDescriptor> {
        @Override // me.tvspark.Illllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        @NonNull
        public Class<ParcelFileDescriptor> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return ParcelFileDescriptor.class;
        }

        @Override // me.tvspark.Illllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        @NonNull
        public Illllllllllllllll<ParcelFileDescriptor> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull ParcelFileDescriptor parcelFileDescriptor) {
            return new Illllllll(parcelFileDescriptor);
        }
    }

    @RequiresApi(21)
    public Illllllll(ParcelFileDescriptor parcelFileDescriptor) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parcelFileDescriptor);
    }

    @Override // me.tvspark.Illllllllllllllll
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // me.tvspark.Illllllllllllllll
    @NonNull
    @RequiresApi(21)
    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    public ParcelFileDescriptor mo4924Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws IOException {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            try {
                Os.lseek(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getFileDescriptor(), 0L, OsConstants.SEEK_SET);
                return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            } catch (ErrnoException e) {
                throw new IOException(e);
            }
        }
        throw null;
    }
}
