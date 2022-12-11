package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import me.tvspark.Illllllllllllllllllllllllllll;
import me.tvspark.OO000;

/* loaded from: classes3.dex */
public final class DefaultImageHeaderParser implements ImageHeaderParser {
    public static final byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));
    public static final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* loaded from: classes3.dex */
    public interface Reader {

        /* loaded from: classes3.dex */
        public static final class EndOfFileException extends IOException {
            public static final long serialVersionUID = 1;

            public EndOfFileException() {
                super("Unexpectedly reached end of a file");
            }
        }

        short Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws IOException;

        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws IOException;

        int read(byte[] bArr, int i) throws IOException;

        long skip(long j) throws IOException;
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Reader {
        public final InputStream Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(InputStream inputStream) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = inputStream;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public short Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws IOException {
            int read = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.read();
            if (read != -1) {
                return (short) read;
            }
            throw new Reader.EndOfFileException();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws IOException {
            return (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() << 8) | Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int read(byte[] bArr, int i) throws IOException {
            int i2 = 0;
            int i3 = 0;
            while (i2 < i && (i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.read(bArr, i2, i - i2)) != -1) {
                i2 += i3;
            }
            if (i2 == 0 && i3 == -1) {
                throw new Reader.EndOfFileException();
            }
            return i2;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public long skip(long j) throws IOException {
            if (j < 0) {
                return 0L;
            }
            long j2 = j;
            while (j2 > 0) {
                long skip = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.skip(j2);
                if (skip <= 0) {
                    if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j2 -= skip;
            }
            return j - j2;
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final ByteBuffer Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
        }

        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remaining() - i >= 4) {
                return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getInt(i);
            }
            return -1;
        }

        public short Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remaining() - i >= 2) {
                return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getShort(i);
            }
            return (short) -1;
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Reader {
        public final ByteBuffer Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteBuffer byteBuffer) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public short Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws Reader.EndOfFileException {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remaining() >= 1) {
                return (short) (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get() & 255);
            }
            throw new Reader.EndOfFileException();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws Reader.EndOfFileException {
            return (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() << 8) | Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int read(byte[] bArr, int i) {
            int min = Math.min(i, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remaining());
            if (min == 0) {
                return -1;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(bArr, 0, min);
            return min;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public long skip(long j) {
            int min = (int) Math.min(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remaining(), j);
            ByteBuffer byteBuffer = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            byteBuffer.position(byteBuffer.position() + min);
            return min;
        }
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull InputStream inputStream, @NonNull OO000 oo000) throws IOException {
        int i;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(inputStream, "Argument must not be null");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(inputStream);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(oo000, "Argument must not be null");
        try {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 & 65496) == 65496 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 19789 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 18761) {
                while (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == 255) {
                    short Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 218) {
                        break;
                    } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != 217) {
                        i = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() - 2;
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 225) {
                            break;
                        }
                        long j = i;
                        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.skip(j) != j) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                Log.isLoggable("DfltImageHeaderParser", 3);
                i = -1;
                if (i != -1) {
                    byte[] bArr = (byte[]) oo000.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, byte[].class);
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr, i);
                    oo000.put(bArr);
                    return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                }
            }
            Log.isLoggable("DfltImageHeaderParser", 3);
            return -1;
        } catch (Reader.EndOfFileException unused) {
            return -1;
        }
    }

    @NonNull
    public final ImageHeaderParser.ImageType Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Reader reader) throws IOException {
        try {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = reader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 65496) {
                return ImageHeaderParser.ImageType.JPEG;
            }
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 << 8) | reader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 4671814) {
                return ImageHeaderParser.ImageType.GIF;
            }
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 << 8) | reader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == -1991225785) {
                reader.skip(21L);
                try {
                    return reader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() >= 3 ? ImageHeaderParser.ImageType.PNG_A : ImageHeaderParser.ImageType.PNG;
                } catch (Reader.EndOfFileException unused) {
                    return ImageHeaderParser.ImageType.PNG;
                }
            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != 1380533830) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            } else {
                reader.skip(4L);
                if (((reader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() << 16) | reader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) != 1464156752) {
                    return ImageHeaderParser.ImageType.UNKNOWN;
                }
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = (reader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() << 16) | reader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                if ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 & InputDeviceCompat.SOURCE_ANY) != 1448097792) {
                    return ImageHeaderParser.ImageType.UNKNOWN;
                }
                int i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 & 255;
                if (i == 88) {
                    reader.skip(4L);
                    return (reader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() & 16) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
                } else if (i != 76) {
                    return ImageHeaderParser.ImageType.WEBP;
                } else {
                    reader.skip(4L);
                    return (reader.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() & 8) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
                }
            }
        } catch (Reader.EndOfFileException unused2) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull InputStream inputStream) throws IOException {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(inputStream, "Argument must not be null");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(inputStream));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull ByteBuffer byteBuffer) throws IOException {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer, "Argument must not be null");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer));
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Reader reader, byte[] bArr, int i) throws IOException {
        ByteOrder byteOrder;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        int i2;
        if (reader.read(bArr, i) != i) {
            Log.isLoggable("DfltImageHeaderParser", 3);
            return -1;
        }
        boolean z = bArr != null && i > Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length;
        if (z) {
            int i3 = 0;
            while (true) {
                byte[] bArr2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (i3 >= bArr2.length) {
                    break;
                } else if (bArr[i3] != bArr2[i3]) {
                    z = false;
                    break;
                } else {
                    i3++;
                }
            }
        }
        if (z) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, i);
            short Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(6);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != 18761) {
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != 19789) {
                    Log.isLoggable("DfltImageHeaderParser", 3);
                }
                byteOrder = ByteOrder.BIG_ENDIAN;
            } else {
                byteOrder = ByteOrder.LITTLE_ENDIAN;
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.order(byteOrder);
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(10) + 6;
            short Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
            for (int i4 = 0; i4 < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3; i4++) {
                int i5 = (i4 * 12) + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 + 2;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i5) == 274) {
                    short Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i5 + 2);
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 >= 1 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 <= 12 && (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i5 + 4)) >= 0) {
                        Log.isLoggable("DfltImageHeaderParser", 3);
                        int i6 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4];
                        if (i6 <= 4 && (i2 = i5 + 8) >= 0 && i2 <= wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remaining() && i6 >= 0 && i6 + i2 <= wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remaining()) {
                            return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
                        }
                    }
                    Log.isLoggable("DfltImageHeaderParser", 3);
                }
            }
            return -1;
        }
        Log.isLoggable("DfltImageHeaderParser", 3);
        return -1;
    }
}
