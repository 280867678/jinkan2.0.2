package me.tvspark;

import androidx.annotation.Nullable;
import com.just.agentweb.WebIndicator;
import com.p046uc.crashsdk.export.LogType;
import org.fourthline.cling.support.model.dlna.DLNAProfiles;

/* renamed from: me.tvspark.m5 */
/* loaded from: classes4.dex */
public final class C2358m5 {
    public static final String[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = {"audio/mpeg-L1", "audio/mpeg-L2", DLNAProfiles.DLNAMimeTypes.MIME_AUDIO_MPEG};
    public static final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = {44100, 48000, LogType.UNEXP_KNOWN_REASON};
    public static final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = {LogType.UNEXP_KNOWN_REASON, 64000, 96000, 128000, 160000, 192000, 224000, 256000, 288000, 320000, 352000, 384000, 416000, 448000};
    public static final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = {LogType.UNEXP_KNOWN_REASON, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 176000, 192000, 224000, 256000};
    public static final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = {LogType.UNEXP_KNOWN_REASON, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000, 384000};
    public static final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = {LogType.UNEXP_KNOWN_REASON, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000};
    public static final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwww = {WebIndicator.MAX_UNIFORM_SPEED_DURATION, 16000, 24000, LogType.UNEXP_KNOWN_REASON, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000};

    /* renamed from: me.tvspark.m5$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        @Nullable
        public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        /* JADX WARN: Removed duplicated region for block: B:23:0x004e  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x009c  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0068  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            int i2;
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            int i8;
            int i9;
            if (!C2358m5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i) || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0 || (i4 = (i >>> 12) & 15) == 0 || i4 == 15 || (i5 = (i >>> 10) & 3) == 3) {
                return false;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2358m5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[3 - i3];
            int i10 = C2358m5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i5];
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i10;
            int i11 = 2;
            if (i2 != 2) {
                if (i2 == 0) {
                    i6 = i10 / 4;
                }
                int i12 = (i >>> 9) & 1;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = C2358m5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, i3);
                if (i3 != 3) {
                    if (i2 == 3) {
                        i9 = C2358m5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i4 - 1];
                    } else {
                        i9 = C2358m5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i4 - 1];
                    }
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = i9;
                    i8 = (((i9 * 12) / this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) + i12) * 4;
                } else {
                    int i13 = 144;
                    if (i2 != 3) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2358m5.Wwwwwwwwwwwwwwwwwwwwwwwwwwww[i4 - 1];
                        if (i3 == 1) {
                            i13 = 72;
                        }
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ((i13 * this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) / this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) + i12;
                        if (((i >> 6) & 3) == 3) {
                            i11 = 1;
                        }
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i11;
                        return true;
                    }
                    if (i3 == 2) {
                        i7 = C2358m5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i4 - 1];
                    } else {
                        i7 = C2358m5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww[i4 - 1];
                    }
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = i7;
                    i8 = ((i7 * 144) / this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) + i12;
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i8;
                if (((i >> 6) & 3) == 3) {
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i11;
                return true;
            }
            i6 = i10 / 2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i6;
            int i122 = (i >>> 9) & 1;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = C2358m5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, i3);
            if (i3 != 3) {
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i8;
            if (((i >> 6) & 3) == 3) {
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i11;
            return true;
        }
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        int i2;
        int i3;
        if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i) || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0) {
            return -1;
        }
        int i4 = (i >>> 12) & 15;
        int i5 = (i >>> 10) & 3;
        if (i4 != 0 && i4 != 15 && i5 != 3) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, i3);
        }
        return -1;
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return (i & (-2097152)) == -2097152;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i) || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0 || (i4 = (i >>> 12) & 15) == 0 || i4 == 15 || (i5 = (i >>> 10) & 3) == 3) {
            return -1;
        }
        int i6 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i5];
        if (i2 == 2) {
            i6 /= 2;
        } else if (i2 == 0) {
            i6 /= 4;
        }
        int i7 = (i >>> 9) & 1;
        if (i3 == 3) {
            return ((((i2 == 3 ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i4 - 1] : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i4 - 1]) * 12) / i6) + i7) * 4;
        }
        int i8 = i2 == 3 ? i3 == 2 ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i4 - 1] : Wwwwwwwwwwwwwwwwwwwwwwwwwwwww[i4 - 1] : Wwwwwwwwwwwwwwwwwwwwwwwwwwww[i4 - 1];
        int i9 = 144;
        if (i2 == 3) {
            return ((i8 * 144) / i6) + i7;
        }
        if (i3 == 1) {
            i9 = 72;
        }
        return ((i9 * i8) / i6) + i7;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        if (i2 == 1) {
            return i == 3 ? 1152 : 576;
        } else if (i2 == 2) {
            return 1152;
        } else {
            if (i2 != 3) {
                throw new IllegalArgumentException();
            }
            return 384;
        }
    }
}
