package com.google.android.exoplayer2.mediacodec;

import android.annotation.SuppressLint;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.tvspark.C1950bl;
import me.tvspark.C2069ec;
import me.tvspark.C2245j3;
import me.tvspark.C2374ml;
import me.tvspark.C2592sb;
import me.tvspark.C2666ub;
import me.tvspark.C2754wl;
import me.tvspark.outline;

@SuppressLint({"InlinedApi"})
/* loaded from: classes3.dex */
public final class MediaCodecUtil {
    public static final Pattern Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Pattern.compile("^\\D?(\\d+)$");
    public static final HashMap<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, List<C2069ec>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new HashMap<>();
    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;

    /* loaded from: classes3.dex */
    public static class DecoderQueryException extends Exception {
        public DecoderQueryException(Throwable th) {
            super("Failed to query underlying media codecs", th);
        }
    }

    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(T t);
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return false;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return false;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return MediaCodecList.getCodecCount();
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public MediaCodecInfo Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            return MediaCodecList.getCodecInfoAt(i);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return "secure-playback".equals(str) && "video/avc".equals(str2);
        }
    }

    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

        MediaCodecInfo Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i);

        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, boolean z, boolean z2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z2;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.class) {
                return false;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj;
            return TextUtils.equals(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        public int hashCode() {
            int i = 1231;
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 31, 31) + (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ? 1231 : 1237)) * 31;
            if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                i = 1237;
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + i;
        }
    }

    @RequiresApi(29)
    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isVendor();
    }

    @RequiresApi(29)
    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isSoftwareOnly();
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MediaCodecInfo mediaCodecInfo) {
        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 29) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mediaCodecInfo);
        }
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(mediaCodecInfo.getName());
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.startsWith("arc.")) {
            return false;
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.startsWith("omx.google.") || Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.startsWith("omx.ffmpeg.") || (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.startsWith("omx.sec.") && Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.contains(".sw.")) || Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.equals("omx.qcom.video.decoder.hevcswvdec") || Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.startsWith("c2.android.") || Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.startsWith("c2.google.") || (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.startsWith("omx.") && !Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.startsWith("c2."));
    }

    public static /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2069ec c2069ec) {
        return c2069ec.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("OMX.google") ? 1 : 0;
    }

    public static synchronized List<C2069ec> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, boolean z, boolean z2) throws DecoderQueryException {
        synchronized (MediaCodecUtil.class) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, z, z2);
            List<C2069ec> list = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (list != null) {
                return list;
            }
            ArrayList<C2069ec> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 21 ? new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z, z2) : new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null));
            if (z && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.isEmpty() && 21 <= C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww <= 23) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null));
                if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.isEmpty()) {
                    String str2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.get(0).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    String.valueOf(str).length();
                    String.valueOf(str2).length();
                }
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            List<C2069ec> unmodifiableList = Collections.unmodifiableList(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, unmodifiableList);
            return unmodifiableList;
        }
    }

    @RequiresApi(29)
    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isHardwareAccelerated();
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws DecoderQueryException {
        int i;
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1) {
            int i2 = 0;
            C2069ec Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("video/avc", false, false);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
                MediaCodecInfo.CodecProfileLevel[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                int length = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.length;
                int i3 = 0;
                while (i2 < length) {
                    int i4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3[i2].level;
                    if (i4 == 1 || i4 == 2) {
                        i = 25344;
                    } else {
                        switch (i4) {
                            case 8:
                            case 16:
                            case 32:
                                i = 101376;
                                continue;
                            case 64:
                                i = 202752;
                                continue;
                            case 128:
                            case 256:
                                i = 414720;
                                continue;
                            case 512:
                                i = 921600;
                                continue;
                            case 1024:
                                i = 1310720;
                                continue;
                            case 2048:
                            case 4096:
                                i = 2097152;
                                continue;
                            case 8192:
                                i = 2228224;
                                continue;
                            case 16384:
                                i = 5652480;
                                continue;
                            case 32768:
                            case 65536:
                                i = 9437184;
                                continue;
                            default:
                                i = -1;
                                continue;
                        }
                    }
                    i3 = Math.max(i, i3);
                    i2++;
                }
                i2 = Math.max(i3, C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 21 ? 345600 : 172800);
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public static /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww, Object obj, Object obj2) {
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj2) - wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
    }

    public static /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2069ec c2069ec) {
        String str = c2069ec.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
            return 1;
        }
        return (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 26 || !str.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : -1;
    }

    public static /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3, C2069ec c2069ec) {
        try {
            return c2069ec.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3) ? 1 : 0;
        } catch (DecoderQueryException unused) {
            return -1;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:327:0x0496, code lost:
        if (r1.equals("H150") != false) goto L256;
     */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0296 A[Catch: NumberFormatException -> 0x02a6, TRY_LEAVE, TryCatch #0 {NumberFormatException -> 0x02a6, blocks: (B:140:0x0239, B:142:0x024d, B:153:0x0269, B:156:0x0296), top: B:139:0x0239 }] */
    /* JADX WARN: Removed duplicated region for block: B:270:0x057f  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0597  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01b4  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair<Integer, Integer> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3) {
        char c;
        String valueOf;
        int parseInt;
        int parseInt2;
        int i;
        int i2;
        String valueOf2;
        int i3;
        int i4;
        Integer num;
        String valueOf3;
        String valueOf4;
        int i5;
        int i6;
        String valueOf5;
        int i7;
        int i8;
        Integer num2;
        Integer num3;
        String str;
        String valueOf6;
        char c2;
        char c3;
        int i9;
        String valueOf7;
        String str2 = c2245j3.Wwwwwwwwwwwwwwww;
        if (str2 == null) {
            return null;
        }
        String[] split = str2.split("\\.");
        int i10 = 4;
        int i11 = 2;
        if ("video/dolby-vision".equals(c2245j3.Wwwwwwwwwwwww)) {
            String str3 = c2245j3.Wwwwwwwwwwwwwwww;
            if (split.length < 3) {
                valueOf7 = String.valueOf(str3);
                if (valueOf7.length() == 0) {
                    new String("Ignoring malformed Dolby Vision codec string: ");
                    return null;
                }
            } else {
                Matcher matcher = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.matcher(split[1]);
                if (!matcher.matches()) {
                    valueOf7 = String.valueOf(str3);
                    if (valueOf7.length() == 0) {
                        new String("Ignoring malformed Dolby Vision codec string: ");
                        return null;
                    }
                } else {
                    String group = matcher.group(1);
                    if (group != null) {
                        switch (group.hashCode()) {
                            case 1536:
                                if (group.equals("00")) {
                                    c3 = 0;
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case 1537:
                                if (group.equals("01")) {
                                    c3 = 1;
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case 1538:
                                if (group.equals("02")) {
                                    c3 = 2;
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case 1539:
                                if (group.equals("03")) {
                                    c3 = 3;
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case 1540:
                                if (group.equals("04")) {
                                    c3 = 4;
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case 1541:
                                if (group.equals("05")) {
                                    c3 = 5;
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case 1542:
                                if (group.equals("06")) {
                                    c3 = 6;
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case 1543:
                                if (group.equals("07")) {
                                    c3 = 7;
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case 1544:
                                if (group.equals("08")) {
                                    c3 = '\b';
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case 1545:
                                if (group.equals("09")) {
                                    c3 = '\t';
                                    break;
                                }
                                c3 = 65535;
                                break;
                            default:
                                c3 = 65535;
                                break;
                        }
                        switch (c3) {
                            case 0:
                                num2 = 1;
                                break;
                            case 1:
                                num2 = 2;
                                break;
                            case 2:
                                num2 = 4;
                                break;
                            case 3:
                                num2 = 8;
                                break;
                            case 4:
                                i9 = 16;
                                num2 = Integer.valueOf(i9);
                                break;
                            case 5:
                                i9 = 32;
                                num2 = Integer.valueOf(i9);
                                break;
                            case 6:
                                i9 = 64;
                                num2 = Integer.valueOf(i9);
                                break;
                            case 7:
                                i9 = 128;
                                num2 = Integer.valueOf(i9);
                                break;
                            case '\b':
                                i9 = 256;
                                num2 = Integer.valueOf(i9);
                                break;
                            case '\t':
                                i9 = 512;
                                num2 = Integer.valueOf(i9);
                                break;
                        }
                        if (num2 != null) {
                            str = "Unknown Dolby Vision profile string: ";
                            valueOf6 = String.valueOf(group);
                            if (valueOf6.length() == 0) {
                                new String(str);
                                return null;
                            }
                            str.concat(valueOf6);
                            return null;
                        }
                        String str4 = split[2];
                        if (str4 != null) {
                            switch (str4.hashCode()) {
                                case 1537:
                                    if (str4.equals("01")) {
                                        c2 = 0;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 1538:
                                    if (str4.equals("02")) {
                                        c2 = 1;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 1539:
                                    if (str4.equals("03")) {
                                        c2 = 2;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 1540:
                                    if (str4.equals("04")) {
                                        c2 = 3;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 1541:
                                    if (str4.equals("05")) {
                                        c2 = 4;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 1542:
                                    if (str4.equals("06")) {
                                        c2 = 5;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 1543:
                                    if (str4.equals("07")) {
                                        c2 = 6;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 1544:
                                    if (str4.equals("08")) {
                                        c2 = 7;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 1545:
                                    if (str4.equals("09")) {
                                        c2 = '\b';
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                default:
                                    c2 = 65535;
                                    break;
                            }
                            switch (c2) {
                                case 0:
                                    num3 = 1;
                                    break;
                                case 1:
                                    num3 = Integer.valueOf(i11);
                                    break;
                                case 2:
                                    num3 = 4;
                                    break;
                                case 3:
                                    num3 = 8;
                                    break;
                                case 4:
                                    i11 = 16;
                                    num3 = Integer.valueOf(i11);
                                    break;
                                case 5:
                                    i11 = 32;
                                    num3 = Integer.valueOf(i11);
                                    break;
                                case 6:
                                    i11 = 64;
                                    num3 = Integer.valueOf(i11);
                                    break;
                                case 7:
                                    i11 = 128;
                                    num3 = Integer.valueOf(i11);
                                    break;
                                case '\b':
                                    i11 = 256;
                                    num3 = Integer.valueOf(i11);
                                    break;
                            }
                            if (num3 == null) {
                                return new Pair<>(num2, num3);
                            }
                            str = "Unknown Dolby Vision level string: ";
                            valueOf6 = String.valueOf(str4);
                            if (valueOf6.length() == 0) {
                                new String(str);
                                return null;
                            }
                            str.concat(valueOf6);
                            return null;
                        }
                        num3 = null;
                        if (num3 == null) {
                        }
                    }
                    num2 = null;
                    if (num2 != null) {
                    }
                }
            }
            "Ignoring malformed Dolby Vision codec string: ".concat(valueOf7);
            return null;
        }
        String str5 = split[0];
        switch (str5.hashCode()) {
            case 3004662:
                if (str5.equals("av01")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 3006243:
                if (str5.equals("avc1")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 3006244:
                if (str5.equals("avc2")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 3199032:
                if (str5.equals("hev1")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 3214780:
                if (str5.equals("hvc1")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 3356560:
                if (str5.equals("mp4a")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 3624515:
                if (str5.equals("vp09")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        char c4 = 20;
        switch (c) {
            case 0:
            case 1:
                String str6 = c2245j3.Wwwwwwwwwwwwwwww;
                if (split.length < 2) {
                    valueOf = String.valueOf(str6);
                    if (valueOf.length() == 0) {
                        new String("Ignoring malformed AVC codec string: ");
                        return null;
                    }
                    "Ignoring malformed AVC codec string: ".concat(valueOf);
                    return null;
                }
                try {
                } catch (NumberFormatException unused) {
                    valueOf = String.valueOf(str6);
                    if (valueOf.length() == 0) {
                        new String("Ignoring malformed AVC codec string: ");
                    }
                }
                if (split[1].length() == 6) {
                    parseInt = Integer.parseInt(split[1].substring(0, 2), 16);
                    parseInt2 = Integer.parseInt(split[1].substring(4), 16);
                } else if (split.length < 3) {
                    String valueOf8 = String.valueOf(str6);
                    if (valueOf8.length() != 0) {
                        "Ignoring malformed AVC codec string: ".concat(valueOf8);
                    } else {
                        new String("Ignoring malformed AVC codec string: ");
                    }
                    return null;
                } else {
                    parseInt = Integer.parseInt(split[1]);
                    parseInt2 = Integer.parseInt(split[2]);
                }
                if (parseInt == 66) {
                    i = -1;
                    i11 = 1;
                } else if (parseInt == 77) {
                    i = -1;
                } else if (parseInt == 88) {
                    i = -1;
                    i11 = 4;
                } else if (parseInt == 100) {
                    i = -1;
                    i11 = 8;
                } else if (parseInt == 110) {
                    i = -1;
                    i11 = 16;
                } else if (parseInt == 122) {
                    i = -1;
                    i11 = 32;
                } else if (parseInt != 244) {
                    i = -1;
                    i11 = -1;
                } else {
                    i = -1;
                    i11 = 64;
                }
                if (i11 != i) {
                    switch (parseInt2) {
                        case 10:
                            i2 = -1;
                            i10 = 1;
                            break;
                        case 11:
                            i2 = -1;
                            break;
                        case 12:
                            i2 = -1;
                            i10 = 8;
                            break;
                        case 13:
                            i2 = -1;
                            i10 = 16;
                            break;
                        default:
                            switch (parseInt2) {
                                case 20:
                                    i2 = -1;
                                    i10 = 32;
                                    break;
                                case 21:
                                    i2 = -1;
                                    i10 = 64;
                                    break;
                                case 22:
                                    i2 = -1;
                                    i10 = 128;
                                    break;
                                default:
                                    switch (parseInt2) {
                                        case 30:
                                            i2 = -1;
                                            i10 = 256;
                                            break;
                                        case 31:
                                            i2 = -1;
                                            i10 = 512;
                                            break;
                                        case 32:
                                            i2 = -1;
                                            i10 = 1024;
                                            break;
                                        default:
                                            switch (parseInt2) {
                                                case 40:
                                                    i2 = -1;
                                                    i10 = 2048;
                                                    break;
                                                case 41:
                                                    i2 = -1;
                                                    i10 = 4096;
                                                    break;
                                                case 42:
                                                    i2 = -1;
                                                    i10 = 8192;
                                                    break;
                                                default:
                                                    switch (parseInt2) {
                                                        case 50:
                                                            i10 = 16384;
                                                            i2 = -1;
                                                            break;
                                                        case 51:
                                                            i10 = 32768;
                                                            i2 = -1;
                                                            break;
                                                        case 52:
                                                            i10 = 65536;
                                                            i2 = -1;
                                                            break;
                                                        default:
                                                            i2 = -1;
                                                            i10 = -1;
                                                            break;
                                                    }
                                            }
                                    }
                            }
                    }
                    if (i10 != i2) {
                        return new Pair<>(Integer.valueOf(i11), Integer.valueOf(i10));
                    }
                }
                return null;
            case 2:
                String str7 = c2245j3.Wwwwwwwwwwwwwwww;
                if (split.length < 3) {
                    valueOf2 = String.valueOf(str7);
                    if (valueOf2.length() == 0) {
                        new String("Ignoring malformed VP9 codec string: ");
                        return null;
                    }
                    "Ignoring malformed VP9 codec string: ".concat(valueOf2);
                    return null;
                }
                try {
                    int parseInt3 = Integer.parseInt(split[1]);
                    int parseInt4 = Integer.parseInt(split[2]);
                    int i12 = parseInt3 != 0 ? parseInt3 != 1 ? parseInt3 != 2 ? parseInt3 != 3 ? -1 : 8 : 4 : 2 : 1;
                    if (i12 != -1) {
                        if (parseInt4 == 10) {
                            i3 = -1;
                            i10 = 1;
                        } else if (parseInt4 == 11) {
                            i3 = -1;
                            i10 = 2;
                        } else if (parseInt4 == 20) {
                            i3 = -1;
                        } else if (parseInt4 == 21) {
                            i3 = -1;
                            i10 = 8;
                        } else if (parseInt4 == 30) {
                            i3 = -1;
                            i10 = 16;
                        } else if (parseInt4 == 31) {
                            i3 = -1;
                            i10 = 32;
                        } else if (parseInt4 == 40) {
                            i3 = -1;
                            i10 = 64;
                        } else if (parseInt4 == 41) {
                            i3 = -1;
                            i10 = 128;
                        } else if (parseInt4 == 50) {
                            i3 = -1;
                            i10 = 256;
                        } else if (parseInt4 != 51) {
                            switch (parseInt4) {
                                case 60:
                                    i3 = -1;
                                    i10 = 2048;
                                    break;
                                case 61:
                                    i3 = -1;
                                    i10 = 4096;
                                    break;
                                case 62:
                                    i3 = -1;
                                    i10 = 8192;
                                    break;
                                default:
                                    i3 = -1;
                                    i10 = -1;
                                    break;
                            }
                        } else {
                            i3 = -1;
                            i10 = 512;
                        }
                        if (i10 != i3) {
                            return new Pair<>(Integer.valueOf(i12), Integer.valueOf(i10));
                        }
                    }
                } catch (NumberFormatException unused2) {
                    valueOf2 = String.valueOf(str7);
                    if (valueOf2.length() == 0) {
                        new String("Ignoring malformed VP9 codec string: ");
                    }
                }
                return null;
            case 3:
            case 4:
                String str8 = c2245j3.Wwwwwwwwwwwwwwww;
                if (split.length < 4) {
                    valueOf3 = String.valueOf(str8);
                    if (valueOf3.length() == 0) {
                        new String("Ignoring malformed HEVC codec string: ");
                        return null;
                    }
                    "Ignoring malformed HEVC codec string: ".concat(valueOf3);
                    return null;
                }
                Matcher matcher2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.matcher(split[1]);
                if (!matcher2.matches()) {
                    valueOf3 = String.valueOf(str8);
                    if (valueOf3.length() == 0) {
                        new String("Ignoring malformed HEVC codec string: ");
                    }
                    "Ignoring malformed HEVC codec string: ".concat(valueOf3);
                } else {
                    String group2 = matcher2.group(1);
                    if ("1".equals(group2)) {
                        i4 = 1;
                    } else if (ExifInterface.GPS_MEASUREMENT_2D.equals(group2)) {
                        i4 = 2;
                    } else {
                        String valueOf9 = String.valueOf(group2);
                        if (valueOf9.length() != 0) {
                            "Unknown HEVC profile string: ".concat(valueOf9);
                        } else {
                            new String("Unknown HEVC profile string: ");
                        }
                    }
                    String str9 = split[3];
                    if (str9 != null) {
                        switch (str9.hashCode()) {
                            case 70821:
                                if (str9.equals("H30")) {
                                    c4 = '\r';
                                    break;
                                }
                                c4 = 65535;
                                break;
                            case 70914:
                                if (str9.equals("H60")) {
                                    c4 = 14;
                                    break;
                                }
                                c4 = 65535;
                                break;
                            case 70917:
                                if (str9.equals("H63")) {
                                    c4 = 15;
                                    break;
                                }
                                c4 = 65535;
                                break;
                            case 71007:
                                if (str9.equals("H90")) {
                                    c4 = 16;
                                    break;
                                }
                                c4 = 65535;
                                break;
                            case 71010:
                                if (str9.equals("H93")) {
                                    c4 = 17;
                                    break;
                                }
                                c4 = 65535;
                                break;
                            case 74665:
                                if (str9.equals("L30")) {
                                    c4 = 0;
                                    break;
                                }
                                c4 = 65535;
                                break;
                            case 74758:
                                if (str9.equals("L60")) {
                                    c4 = 1;
                                    break;
                                }
                                c4 = 65535;
                                break;
                            case 74761:
                                if (str9.equals("L63")) {
                                    c4 = 2;
                                    break;
                                }
                                c4 = 65535;
                                break;
                            case 74851:
                                if (str9.equals("L90")) {
                                    c4 = 3;
                                    break;
                                }
                                c4 = 65535;
                                break;
                            case 74854:
                                if (str9.equals("L93")) {
                                    c4 = 4;
                                    break;
                                }
                                c4 = 65535;
                                break;
                            case 2193639:
                                if (str9.equals("H120")) {
                                    c4 = 18;
                                    break;
                                }
                                c4 = 65535;
                                break;
                            case 2193642:
                                if (str9.equals("H123")) {
                                    c4 = 19;
                                    break;
                                }
                                c4 = 65535;
                                break;
                            case 2193732:
                                break;
                            case 2193735:
                                if (str9.equals("H153")) {
                                    c4 = 21;
                                    break;
                                }
                                c4 = 65535;
                                break;
                            case 2193738:
                                if (str9.equals("H156")) {
                                    c4 = 22;
                                    break;
                                }
                                c4 = 65535;
                                break;
                            case 2193825:
                                if (str9.equals("H180")) {
                                    c4 = 23;
                                    break;
                                }
                                c4 = 65535;
                                break;
                            case 2193828:
                                if (str9.equals("H183")) {
                                    c4 = 24;
                                    break;
                                }
                                c4 = 65535;
                                break;
                            case 2193831:
                                if (str9.equals("H186")) {
                                    c4 = 25;
                                    break;
                                }
                                c4 = 65535;
                                break;
                            case 2312803:
                                if (str9.equals("L120")) {
                                    c4 = 5;
                                    break;
                                }
                                c4 = 65535;
                                break;
                            case 2312806:
                                if (str9.equals("L123")) {
                                    c4 = 6;
                                    break;
                                }
                                c4 = 65535;
                                break;
                            case 2312896:
                                if (str9.equals("L150")) {
                                    c4 = 7;
                                    break;
                                }
                                c4 = 65535;
                                break;
                            case 2312899:
                                if (str9.equals("L153")) {
                                    c4 = '\b';
                                    break;
                                }
                                c4 = 65535;
                                break;
                            case 2312902:
                                if (str9.equals("L156")) {
                                    c4 = '\t';
                                    break;
                                }
                                c4 = 65535;
                                break;
                            case 2312989:
                                if (str9.equals("L180")) {
                                    c4 = '\n';
                                    break;
                                }
                                c4 = 65535;
                                break;
                            case 2312992:
                                if (str9.equals("L183")) {
                                    c4 = 11;
                                    break;
                                }
                                c4 = 65535;
                                break;
                            case 2312995:
                                if (str9.equals("L186")) {
                                    c4 = '\f';
                                    break;
                                }
                                c4 = 65535;
                                break;
                            default:
                                c4 = 65535;
                                break;
                        }
                        switch (c4) {
                            case 0:
                                num = 1;
                                break;
                            case 1:
                                num = Integer.valueOf(i10);
                                break;
                            case 2:
                                num = 16;
                                break;
                            case 3:
                                i10 = 64;
                                num = Integer.valueOf(i10);
                                break;
                            case 4:
                                i10 = 256;
                                num = Integer.valueOf(i10);
                                break;
                            case 5:
                                i10 = 1024;
                                num = Integer.valueOf(i10);
                                break;
                            case 6:
                                i10 = 4096;
                                num = Integer.valueOf(i10);
                                break;
                            case 7:
                                i10 = 16384;
                                num = Integer.valueOf(i10);
                                break;
                            case '\b':
                                i10 = 65536;
                                num = Integer.valueOf(i10);
                                break;
                            case '\t':
                                i10 = 262144;
                                num = Integer.valueOf(i10);
                                break;
                            case '\n':
                                i10 = 1048576;
                                num = Integer.valueOf(i10);
                                break;
                            case 11:
                                i10 = 4194304;
                                num = Integer.valueOf(i10);
                                break;
                            case '\f':
                                i10 = 16777216;
                                num = Integer.valueOf(i10);
                                break;
                            case '\r':
                                num = 2;
                                break;
                            case 14:
                                num = 8;
                                break;
                            case 15:
                                i10 = 32;
                                num = Integer.valueOf(i10);
                                break;
                            case 16:
                                i10 = 128;
                                num = Integer.valueOf(i10);
                                break;
                            case 17:
                                i10 = 512;
                                num = Integer.valueOf(i10);
                                break;
                            case 18:
                                i10 = 2048;
                                num = Integer.valueOf(i10);
                                break;
                            case 19:
                                i10 = 8192;
                                num = Integer.valueOf(i10);
                                break;
                            case 20:
                                i10 = 32768;
                                num = Integer.valueOf(i10);
                                break;
                            case 21:
                                i10 = 131072;
                                num = Integer.valueOf(i10);
                                break;
                            case 22:
                                i10 = 524288;
                                num = Integer.valueOf(i10);
                                break;
                            case 23:
                                i10 = 2097152;
                                num = Integer.valueOf(i10);
                                break;
                            case 24:
                                i10 = 8388608;
                                num = Integer.valueOf(i10);
                                break;
                            case 25:
                                i10 = 33554432;
                                num = Integer.valueOf(i10);
                                break;
                        }
                        if (num == null) {
                            return new Pair<>(Integer.valueOf(i4), num);
                        }
                        String valueOf10 = String.valueOf(str9);
                        if (valueOf10.length() != 0) {
                            "Unknown HEVC level string: ".concat(valueOf10);
                        } else {
                            new String("Unknown HEVC level string: ");
                        }
                    }
                    num = null;
                    if (num == null) {
                    }
                }
                return null;
            case 5:
                String str10 = c2245j3.Wwwwwwwwwwwwwwww;
                C2754wl c2754wl = c2245j3.Kkkkkkkkkkkkkkkkkkkkkkkkk;
                if (split.length < 4) {
                    valueOf4 = String.valueOf(str10);
                    if (valueOf4.length() == 0) {
                        new String("Ignoring malformed AV1 codec string: ");
                        return null;
                    }
                    "Ignoring malformed AV1 codec string: ".concat(valueOf4);
                    return null;
                }
                try {
                    int parseInt5 = Integer.parseInt(split[1]);
                    int parseInt6 = Integer.parseInt(split[2].substring(0, 2));
                    int parseInt7 = Integer.parseInt(split[3]);
                    if (parseInt5 == 0 && (parseInt7 == 8 || parseInt7 == 10)) {
                        int i13 = parseInt7 == 8 ? 1 : (c2754wl == null || !(c2754wl.Wwwwwwwwwwwwwwwwwwwww != null || (i5 = c2754wl.Wwwwwwwwwwwwwwwwwwwwww) == 7 || i5 == 6)) ? 2 : 4096;
                        switch (parseInt6) {
                            case 0:
                                i6 = -1;
                                i10 = 1;
                                break;
                            case 1:
                                i6 = -1;
                                i10 = 2;
                                break;
                            case 2:
                                i6 = -1;
                                break;
                            case 3:
                                i6 = -1;
                                i10 = 8;
                                break;
                            case 4:
                                i6 = -1;
                                i10 = 16;
                                break;
                            case 5:
                                i6 = -1;
                                i10 = 32;
                                break;
                            case 6:
                                i6 = -1;
                                i10 = 64;
                                break;
                            case 7:
                                i6 = -1;
                                i10 = 128;
                                break;
                            case 8:
                                i6 = -1;
                                i10 = 256;
                                break;
                            case 9:
                                i6 = -1;
                                i10 = 512;
                                break;
                            case 10:
                                i6 = -1;
                                i10 = 1024;
                                break;
                            case 11:
                                i6 = -1;
                                i10 = 2048;
                                break;
                            case 12:
                                i6 = -1;
                                i10 = 4096;
                                break;
                            case 13:
                                i6 = -1;
                                i10 = 8192;
                                break;
                            case 14:
                                i10 = 16384;
                                i6 = -1;
                                break;
                            case 15:
                                i10 = 32768;
                                i6 = -1;
                                break;
                            case 16:
                                i10 = 65536;
                                i6 = -1;
                                break;
                            case 17:
                                i10 = 131072;
                                i6 = -1;
                                break;
                            case 18:
                                i10 = 262144;
                                i6 = -1;
                                break;
                            case 19:
                                i10 = 524288;
                                i6 = -1;
                                break;
                            case 20:
                                i10 = 1048576;
                                i6 = -1;
                                break;
                            case 21:
                                i10 = 2097152;
                                i6 = -1;
                                break;
                            case 22:
                                i10 = 4194304;
                                i6 = -1;
                                break;
                            case 23:
                                i10 = 8388608;
                                i6 = -1;
                                break;
                            default:
                                i6 = -1;
                                i10 = -1;
                                break;
                        }
                        if (i10 != i6) {
                            return new Pair<>(Integer.valueOf(i13), Integer.valueOf(i10));
                        }
                    }
                } catch (NumberFormatException unused3) {
                    valueOf4 = String.valueOf(str10);
                    if (valueOf4.length() == 0) {
                        new String("Ignoring malformed AV1 codec string: ");
                    }
                }
                return null;
            case 6:
                String str11 = c2245j3.Wwwwwwwwwwwwwwww;
                if (split.length != 3) {
                    valueOf5 = String.valueOf(str11);
                    if (valueOf5.length() == 0) {
                        new String("Ignoring malformed MP4A codec string: ");
                        return null;
                    }
                    "Ignoring malformed MP4A codec string: ".concat(valueOf5);
                    return null;
                }
                try {
                    if ("audio/mp4a-latm".equals(C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Integer.parseInt(split[1], 16)))) {
                        int parseInt8 = Integer.parseInt(split[2]);
                        if (parseInt8 != 17) {
                            if (parseInt8 == 20) {
                                i8 = -1;
                                i7 = 20;
                            } else if (parseInt8 == 23) {
                                i7 = 23;
                            } else if (parseInt8 == 29) {
                                i7 = 29;
                            } else if (parseInt8 == 39) {
                                i7 = 39;
                            } else if (parseInt8 != 42) {
                                switch (parseInt8) {
                                    case 1:
                                        i8 = -1;
                                        i7 = 1;
                                        break;
                                    case 2:
                                        i8 = -1;
                                        i7 = 2;
                                        break;
                                    case 3:
                                        i8 = -1;
                                        i7 = 3;
                                        break;
                                    case 4:
                                        i8 = -1;
                                        i7 = 4;
                                        break;
                                    case 5:
                                        i8 = -1;
                                        i7 = 5;
                                        break;
                                    case 6:
                                        i8 = -1;
                                        i7 = 6;
                                        break;
                                    default:
                                        i8 = -1;
                                        i7 = -1;
                                        break;
                                }
                            } else {
                                i7 = 42;
                            }
                            if (i7 != i8) {
                                return new Pair<>(Integer.valueOf(i7), 0);
                            }
                        } else {
                            i7 = 17;
                        }
                        i8 = -1;
                        if (i7 != i8) {
                        }
                    }
                } catch (NumberFormatException unused4) {
                    valueOf5 = String.valueOf(str11);
                    if (valueOf5.length() == 0) {
                        new String("Ignoring malformed MP4A codec string: ");
                    }
                }
                return null;
            default:
                return null;
        }
    }

    @Nullable
    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MediaCodecInfo mediaCodecInfo, String str, String str2) {
        String[] supportedTypes;
        for (String str3 : mediaCodecInfo.getSupportedTypes()) {
            if (str3.equalsIgnoreCase(str2)) {
                return str3;
            }
        }
        if (str2.equals("video/dolby-vision")) {
            if ("OMX.MS.HEVCDV.Decoder".equals(str)) {
                return "video/hevcdv";
            }
            if (!"OMX.RTK.video.decoder".equals(str) && !"OMX.realtek.video.decoder.tunneled".equals(str)) {
                return null;
            }
            return "video/dv_hevc";
        } else if (str2.equals("audio/alac") && "OMX.lge.alac.decoder".equals(str)) {
            return "audio/x-lg-alac";
        } else {
            if (str2.equals("audio/flac") && "OMX.lge.flac.decoder".equals(str)) {
                return "audio/x-lg-flac";
            }
            return null;
        }
    }

    @CheckResult
    public static List<C2069ec> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<C2069ec> list, final C2245j3 c2245j3) {
        ArrayList arrayList = new ArrayList(list);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(arrayList, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() { // from class: me.tvspark.tb
            @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww
            public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
                return MediaCodecUtil.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3.this, (C2069ec) obj);
            }
        });
        return arrayList;
    }

    @Nullable
    public static C2069ec Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, boolean z, boolean z2) throws DecoderQueryException {
        List<C2069ec> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, z, z2);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.isEmpty()) {
            return null;
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.get(0);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, List<C2069ec> list) {
        if ("audio/raw".equals(str)) {
            if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 26 && C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals("R9") && list.size() == 1 && list.get(0).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                list.add(C2069ec.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("OMX.google.raw.decoder", "audio/raw", "audio/raw", null, false, true, false, false, false));
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, C2666ub.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 21 && list.size() > 1) {
            String str2 = list.get(0).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if ("OMX.SEC.mp3.dec".equals(str2) || "OMX.SEC.MP3.Decoder".equals(str2) || "OMX.brcm.audio.mp3.decoder".equals(str2)) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, C2592sb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }
        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 30 || list.size() <= 1 || !"OMX.qti.audio.decoder.flac".equals(list.get(0).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
            return;
        }
        list.add(list.remove(0));
    }

    public static <T> void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<T> list, final Wwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        Collections.sort(list, new Comparator() { // from class: me.tvspark.vb
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return MediaCodecUtil.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MediaCodecUtil.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.this, obj, obj2);
            }
        });
    }

    @RequiresApi(29)
    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isAlias();
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MediaCodecInfo mediaCodecInfo, String str, boolean z, String str2) {
        if (mediaCodecInfo.isEncoder() || (!z && str.endsWith(".secure"))) {
            return false;
        }
        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str) && ("a70".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) || ("Xiaomi".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("HM")))) {
            return false;
        }
        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 16 && "OMX.qcom.audio.decoder.mp3".equals(str) && ("dlxu".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) || "protou".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) || "ville".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) || "villeplus".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) || "villec2".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) || C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("gee") || "C6602".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) || "C6603".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) || "C6606".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) || "C6616".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) || "L36h".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) || "SO-02E".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww))) {
            return false;
        }
        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 16 && "OMX.qcom.audio.decoder.aac".equals(str) && ("C1504".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) || "C1505".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) || "C1604".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) || "C1605".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww))) {
            return false;
        }
        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 24 && (("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && "samsung".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("zeroflte") || C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("zerolte") || C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("zenlte") || "SC-05G".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) || "marinelteatt".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) || "404SC".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) || "SC-04G".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) || "SCV31".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)))) {
            return false;
        }
        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww <= 19 && "OMX.SEC.vp8.dec".equals(str) && "samsung".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("d2") || C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("serrano") || C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("jflte") || C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("santos") || C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("t0"))) {
            return false;
        }
        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww <= 19 && C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) {
            return false;
        }
        return !"audio/eac3-joc".equals(str2) || !"OMX.MTK.AUDIO.DECODER.DSPAC3".equals(str);
    }

    @RequiresApi(21)
    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        @Nullable
        public MediaCodecInfo[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, boolean z2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (z || z2) ? 1 : 0;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return true;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureRequired(str);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new MediaCodecList(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).getCodecInfos();
            }
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported(str);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public MediaCodecInfo Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new MediaCodecList(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).getCodecInfos();
            }
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i];
        }
    }

    public static ArrayList<C2069ec> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) throws DecoderQueryException {
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        String str;
        String str2;
        int i;
        boolean z;
        int i2;
        MediaCodecInfo.CodecCapabilities capabilitiesForType;
        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        boolean z2;
        try {
            ArrayList<C2069ec> arrayList = new ArrayList<>();
            String str3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            int i3 = 0;
            for (int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(); i3 < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4; Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = i2) {
                MediaCodecInfo Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
                if (!(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 29 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5))) {
                    String name = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.getName();
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5, name, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, str3) && (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5, name, str3)) != null) {
                        try {
                            capabilitiesForType = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.getCapabilitiesForType(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("tunneled-playback", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, capabilitiesForType);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("tunneled-playback", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, capabilitiesForType);
                        } catch (Exception e) {
                            e = e;
                            str = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                            str2 = name;
                            i = i3;
                            z = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                            i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
                        }
                        if ((wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) && (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3)) {
                            boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("secure-playback", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, capabilitiesForType);
                            boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("secure-playback", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, capabilitiesForType);
                            if ((wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4) && (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6)) {
                                boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 29 ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5) : !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5);
                                boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5);
                                if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 29) {
                                    z2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5);
                                } else {
                                    String Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.getName());
                                    z2 = !Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.startsWith("omx.google.") && !Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.startsWith("c2.android.") && !Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.startsWith("c2.google.");
                                }
                                boolean z3 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww <= 22 && ("ODROID-XU3".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) || "Nexus 10".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) && ("OMX.Exynos.AVC.Decoder".equals(name) || "OMX.Exynos.AVC.Decoder.secure".equals(name));
                                if ((!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 || wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6) && (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 || wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                                    str = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                                    str2 = name;
                                    i = i3;
                                    z = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                                    i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
                                    if (!z && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6) {
                                        arrayList.add(C2069ec.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String.valueOf(str2).concat(".secure"), str3, str, capabilitiesForType, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, z2, z3, true));
                                        return arrayList;
                                    }
                                    i3 = i + 1;
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = z;
                                } else {
                                    str = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                                    str2 = name;
                                    i = i3;
                                    z = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                                    i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
                                    try {
                                        arrayList.add(C2069ec.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(name, str3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, capabilitiesForType, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, z2, z3, false));
                                    } catch (Exception e2) {
                                        e = e2;
                                        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > 23 || arrayList.isEmpty()) {
                                            String.valueOf(str2).length();
                                            str.length();
                                            throw e;
                                        }
                                        String.valueOf(str2).length();
                                        i3 = i + 1;
                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = z;
                                    }
                                    i3 = i + 1;
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = z;
                                }
                            }
                        }
                    }
                }
                i = i3;
                z = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
                i3 = i + 1;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = z;
            }
            return arrayList;
        } catch (Exception e3) {
            throw new DecoderQueryException(e3);
        }
    }
}
