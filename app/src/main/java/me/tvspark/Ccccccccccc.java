package me.tvspark;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* loaded from: classes4.dex */
public interface Ccccccccccc {

    @RequiresApi(21)
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Ccccccccccc {
        public final Illllllll Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final List<ImageHeaderParser> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final OO000 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ParcelFileDescriptor parcelFileDescriptor, List<ImageHeaderParser> list, OO000 oo000) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(oo000, "Argument must not be null");
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = oo000;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "Argument must not be null");
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = list;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Illllllll(parcelFileDescriptor);
        }

        @Override // me.tvspark.Ccccccccccc
        public ImageHeaderParser.ImageType Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws IOException {
            List<ImageHeaderParser> list = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            Illllllll illllllll = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            OO000 oo000 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ImageHeaderParser imageHeaderParser = list.get(i);
                RecyclableBufferedInputStream recyclableBufferedInputStream = null;
                try {
                    RecyclableBufferedInputStream recyclableBufferedInputStream2 = new RecyclableBufferedInputStream(new FileInputStream(illllllll.mo4924Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().getFileDescriptor()), oo000);
                    try {
                        ImageHeaderParser.ImageType Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = imageHeaderParser.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(recyclableBufferedInputStream2);
                        try {
                            recyclableBufferedInputStream2.close();
                        } catch (IOException unused) {
                        }
                        illllllll.mo4924Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != ImageHeaderParser.ImageType.UNKNOWN) {
                            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        }
                    } catch (Throwable th) {
                        th = th;
                        recyclableBufferedInputStream = recyclableBufferedInputStream2;
                        if (recyclableBufferedInputStream != null) {
                            try {
                                recyclableBufferedInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        illllllll.mo4924Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            return ImageHeaderParser.ImageType.UNKNOWN;
        }

        @Override // me.tvspark.Ccccccccccc
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.Ccccccccccc
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws IOException {
            List<ImageHeaderParser> list = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            Illllllll illllllll = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            OO000 oo000 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ImageHeaderParser imageHeaderParser = list.get(i);
                RecyclableBufferedInputStream recyclableBufferedInputStream = null;
                try {
                    RecyclableBufferedInputStream recyclableBufferedInputStream2 = new RecyclableBufferedInputStream(new FileInputStream(illllllll.mo4924Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().getFileDescriptor()), oo000);
                    try {
                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = imageHeaderParser.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(recyclableBufferedInputStream2, oo000);
                        try {
                            recyclableBufferedInputStream2.close();
                        } catch (IOException unused) {
                        }
                        illllllll.mo4924Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != -1) {
                            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        }
                    } catch (Throwable th) {
                        th = th;
                        recyclableBufferedInputStream = recyclableBufferedInputStream2;
                        if (recyclableBufferedInputStream != null) {
                            try {
                                recyclableBufferedInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        illllllll.mo4924Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            return -1;
        }

        @Override // me.tvspark.Ccccccccccc
        @Nullable
        public Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeFileDescriptor(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4924Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().getFileDescriptor(), null, options);
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Ccccccccccc {
        public final List<ImageHeaderParser> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final OO000 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final Illllllllll Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(InputStream inputStream, List<ImageHeaderParser> list, OO000 oo000) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(oo000, "Argument must not be null");
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = oo000;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "Argument must not be null");
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = list;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Illllllllll(inputStream, oo000);
        }

        @Override // me.tvspark.Ccccccccccc
        public ImageHeaderParser.ImageType Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws IOException {
            return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4924Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // me.tvspark.Ccccccccccc
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        @Override // me.tvspark.Ccccccccccc
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws IOException {
            return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4924Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // me.tvspark.Ccccccccccc
        @Nullable
        public Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeStream(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4924Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), null, options);
        }
    }

    ImageHeaderParser.ImageType Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws IOException;

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws IOException;

    @Nullable
    Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(BitmapFactory.Options options) throws IOException;
}
