package me.tvspark;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.fourthline.cling.support.model.dlna.DLNAProfiles;

/* renamed from: me.tvspark.bl */
/* loaded from: classes4.dex */
public final class C1950bl {
    public static final ArrayList<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList<>();
    public static final Pattern Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Pattern.compile("^mp4a\\.([a-zA-Z0-9]{2})(?:\\.([0-9]{1,2}))?$");

    @VisibleForTesting
    /* renamed from: me.tvspark.bl$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        }
    }

    /* renamed from: me.tvspark.bl$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode == -1007807498) {
            if (str.equals("audio/x-flac")) {
                c = 0;
            }
            c = 65535;
        } else if (hashCode != -586683234) {
            if (hashCode == 187090231 && str.equals("audio/mp3")) {
                c = 1;
            }
            c = 65535;
        } else {
            if (str.equals("audio/x-wav")) {
                c = 2;
            }
            c = 65535;
        }
        return c != 0 ? c != 1 ? c != 2 ? str : "audio/wav" : DLNAProfiles.DLNAMimeTypes.MIME_AUDIO_MPEG : "audio/flac";
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable String str) {
        return "video".equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str));
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable String str) {
        return "text".equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str)) || "application/cea-608".equals(str) || "application/cea-708".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/x-subrip".equals(str) || "application/ttml+xml".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-rawcc".equals(str) || "application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str);
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable String str) {
        return "audio".equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str));
    }

    @Nullable
    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str)) {
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null && Wwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2)) {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            }
        }
        return null;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwww(str)) {
            return 1;
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwww(str)) {
            return 2;
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwww(str)) {
            return 3;
        }
        if ("application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str)) {
            return 4;
        }
        if ("application/x-camera-motion".equals(str)) {
            return 5;
        }
        int size = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size();
        for (int i = 0; i < size; i++) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i);
            if (str.equals(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
        }
        return -1;
    }

    @Nullable
    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable String str) {
        int indexOf;
        if (str == null || (indexOf = str.indexOf(47)) == -1) {
            return null;
        }
        return str.substring(0, indexOf);
    }

    @Nullable
    @VisibleForTesting
    public static Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        Matcher matcher = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        String group = matcher.group(1);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(group);
        String str2 = group;
        String group2 = matcher.group(2);
        int i = 0;
        try {
            int parseInt = Integer.parseInt(str2, 16);
            if (group2 != null) {
                i = Integer.parseInt(group2);
            }
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parseInt, i);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, @Nullable String str2) {
        char c;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        switch (str.hashCode()) {
            case -2123537834:
                if (str.equals("audio/eac3-joc")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -1095064472:
                if (str.equals("audio/vnd.dts")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -53558318:
                if (str.equals("audio/mp4a-latm")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 187078296:
                if (str.equals("audio/ac3")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 187078297:
                if (str.equals("audio/ac4")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 1504578661:
                if (str.equals("audio/eac3")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1504831518:
                if (str.equals(DLNAProfiles.DLNAMimeTypes.MIME_AUDIO_MPEG)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 1505942594:
                if (str.equals("audio/vnd.dts.hd")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 1556697186:
                if (str.equals("audio/true-hd")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return 9;
            case 1:
                if (str2 != null && (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2)) != null) {
                    return C2737w4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
                return 0;
            case 2:
                return 5;
            case 3:
                return 6;
            case 4:
                return 18;
            case 5:
                return 17;
            case 6:
                return 7;
            case 7:
                return 8;
            case '\b':
                return 14;
            default:
                return 0;
        }
    }

    @Nullable
    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable String str) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        String str2 = null;
        if (str == null) {
            return null;
        }
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(str.trim());
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("avc1") || Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("avc3")) {
            return "video/avc";
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("hev1") || Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("hvc1")) {
            return "video/hevc";
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("dvav") || Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("dva1") || Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("dvhe") || Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("dvh1")) {
            return "video/dolby-vision";
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("av01")) {
            return "video/av01";
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("vp9") || Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("vp09")) {
            return "video/x-vnd.on2.vp9";
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("vp8") || Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("vp08")) {
            return "video/x-vnd.on2.vp8";
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("mp4a")) {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("mp4a.") && (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww)) != null) {
                str2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            return str2 == null ? "audio/mp4a-latm" : str2;
        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("ac-3") || Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("dac3")) {
            return "audio/ac3";
        } else {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("ec-3") || Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("dec3")) {
                return "audio/eac3";
            }
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("ec+3")) {
                return "audio/eac3-joc";
            }
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("ac-4") || Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("dac4")) {
                return "audio/ac4";
            }
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("dtsc") || Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("dtse")) {
                return "audio/vnd.dts";
            }
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("dtsh") || Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("dtsl")) {
                return "audio/vnd.dts.hd";
            }
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("opus")) {
                return "audio/opus";
            }
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("vorbis")) {
                return "audio/vorbis";
            }
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("flac")) {
                return "audio/flac";
            }
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("stpp")) {
                return "application/ttml+xml";
            }
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("wvtt")) {
                return "text/vtt";
            }
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.contains("cea708")) {
                return "application/cea-708";
            }
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.contains("eia608") || Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.contains("cea608")) {
                return "application/cea-608";
            }
            int size = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size();
            for (int i = 0; i < size; i++) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                    return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
            }
            return null;
        }
    }

    @Nullable
    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        if (i != 32) {
            if (i == 33) {
                return "video/avc";
            }
            if (i == 35) {
                return "video/hevc";
            }
            if (i == 64) {
                return "audio/mp4a-latm";
            }
            if (i == 163) {
                return "video/wvc1";
            }
            if (i == 177) {
                return "video/x-vnd.on2.vp9";
            }
            if (i == 165) {
                return "audio/ac3";
            }
            if (i == 166) {
                return "audio/eac3";
            }
            switch (i) {
                case 96:
                case 97:
                case 98:
                case 99:
                case 100:
                case 101:
                    return "video/mpeg2";
                case 102:
                case 103:
                case 104:
                    return "audio/mp4a-latm";
                case 105:
                case 107:
                    return DLNAProfiles.DLNAMimeTypes.MIME_AUDIO_MPEG;
                case 106:
                    return DLNAProfiles.DLNAMimeTypes.MIME_VIDEO_MPEG;
                default:
                    switch (i) {
                        case TbsListener.ErrorCode.STARTDOWNLOAD_10 /* 169 */:
                        case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_2 /* 172 */:
                            return "audio/vnd.dts";
                        case 170:
                        case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_1 /* 171 */:
                            return "audio/vnd.dts.hd";
                        case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_3 /* 173 */:
                            return "audio/opus";
                        case TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4 /* 174 */:
                            return "audio/ac4";
                        default:
                            return null;
                    }
            }
        }
        return "video/mp4v-es";
    }

    @Nullable
    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str)) {
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null && Wwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2)) {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            }
        }
        return null;
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable String str, @Nullable String str2) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        if (str == null) {
            return false;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -2123537834:
                if (str.equals("audio/eac3-joc")) {
                    c = '\t';
                    break;
                }
                break;
            case -432837260:
                if (str.equals("audio/mpeg-L1")) {
                    c = 1;
                    break;
                }
                break;
            case -432837259:
                if (str.equals("audio/mpeg-L2")) {
                    c = 2;
                    break;
                }
                break;
            case -53558318:
                if (str.equals("audio/mp4a-latm")) {
                    c = '\n';
                    break;
                }
                break;
            case 187078296:
                if (str.equals("audio/ac3")) {
                    c = 7;
                    break;
                }
                break;
            case 187094639:
                if (str.equals("audio/raw")) {
                    c = 3;
                    break;
                }
                break;
            case 1504578661:
                if (str.equals("audio/eac3")) {
                    c = '\b';
                    break;
                }
                break;
            case 1504619009:
                if (str.equals("audio/flac")) {
                    c = 6;
                    break;
                }
                break;
            case 1504831518:
                if (str.equals(DLNAProfiles.DLNAMimeTypes.MIME_AUDIO_MPEG)) {
                    c = 0;
                    break;
                }
                break;
            case 1903231877:
                if (str.equals("audio/g711-alaw")) {
                    c = 4;
                    break;
                }
                break;
            case 1903589369:
                if (str.equals("audio/g711-mlaw")) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case '\b':
            case '\t':
                return true;
            case '\n':
                return (str2 == null || (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2)) == null || (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2737w4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) == 0 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 16) ? false : true;
            default:
                return false;
        }
    }
}
