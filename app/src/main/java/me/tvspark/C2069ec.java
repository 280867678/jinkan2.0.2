package me.tvspark;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import org.fourthline.cling.support.model.dlna.DLNAProfiles;

/* renamed from: me.tvspark.ec */
/* loaded from: classes4.dex */
public final class C2069ec {
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final MediaCodecInfo.CodecCapabilities Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0040, code lost:
        if (r4 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0044, code lost:
        if (me.tvspark.C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 21) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004c, code lost:
        if (r4.isFeatureSupported("secure-playback") == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004e, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0051, code lost:
        if (r4 == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0050, code lost:
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0054, code lost:
        r1 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C2069ec(String str, String str2, String str3, @Nullable MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        boolean z6;
        if (str != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str3;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = codecCapabilities;
            boolean z7 = true;
            if (!z4 && codecCapabilities != null) {
                if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 19 && codecCapabilities.isFeatureSupported("adaptive-playback")) {
                    z6 = true;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z6;
                    if (codecCapabilities != null && (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 21 || !codecCapabilities.isFeatureSupported("tunneled-playback"))) {
                    }
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = z7;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwww(str2);
                    return;
                }
            }
            z6 = false;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z6;
            if (codecCapabilities != null) {
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = z7;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwww(str2);
            return;
        }
        throw null;
    }

    @RequiresApi(21)
    public static Point Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, widthAlignment) * widthAlignment, C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, heightAlignment) * heightAlignment);
    }

    public static C2069ec Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, String str3, @Nullable MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        return new C2069ec(str, str2, str3, codecCapabilities, z, z2, z3, z4, z5);
    }

    @RequiresApi(21)
    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        Point Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(videoCapabilities, i, i2);
        int i3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.x;
        int i4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.y;
        return (d == -1.0d || d < 1.0d) ? videoCapabilities.isSizeSupported(i3, i4) : videoCapabilities.areSizeAndRateSupported(i3, i4, Math.floor(d));
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        Pair<Integer, Integer> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = MediaCodecUtil.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null && ((Integer) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.first).intValue() == 42;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        String str2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        String str3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        String str4 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        String.valueOf(str).length();
        String.valueOf(str2).length();
        String.valueOf(str3).length();
        String.valueOf(str4).length();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0095 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3) throws MediaCodecUtil.DecoderQueryException {
        boolean z;
        boolean z2;
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        boolean z3;
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        int i;
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        MediaCodecInfo.CodecProfileLevel[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
        String str;
        StringBuilder sb;
        String str2;
        String str3 = c2245j3.Wwwwwwwwwwwwwwww;
        boolean z4 = false;
        if (str3 != null && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null && (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str3)) != null) {
            if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                str = c2245j3.Wwwwwwwwwwwwwwww;
                sb = new StringBuilder(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length() + outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, 13));
                str2 = "codec.mime ";
            } else {
                Pair<Integer, Integer> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = MediaCodecUtil.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 != null) {
                    int intValue = ((Integer) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.first).intValue();
                    int intValue2 = ((Integer) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.second).intValue();
                    if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww || intValue == 42) {
                        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                            if (codecProfileLevel.profile != intValue || codecProfileLevel.level < intValue2) {
                            }
                        }
                        str = c2245j3.Wwwwwwwwwwwwwwww;
                        sb = new StringBuilder(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length() + outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, 22));
                        str2 = "codec.profileLevel, ";
                    }
                }
            }
            sb.append(str2);
            sb.append(str);
            sb.append(", ");
            sb.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb.toString());
            z = false;
            if (z) {
                return false;
            }
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                int i2 = c2245j3.Wwwwwwww;
                if (i2 <= 0 || (i = c2245j3.Wwwwwww) <= 0) {
                    return true;
                }
                if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 21) {
                    return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, i, c2245j3.Wwwwww);
                }
                if (i2 * i <= MediaCodecUtil.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    z4 = true;
                }
                if (!z4) {
                    int i3 = c2245j3.Wwwwwwww;
                    int i4 = c2245j3.Wwwwwww;
                    StringBuilder sb2 = new StringBuilder(40);
                    sb2.append("legacyFrameSize, ");
                    sb2.append(i3);
                    sb2.append("x");
                    sb2.append(i4);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb2.toString());
                }
                return z4;
            }
            if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 21) {
                int i5 = c2245j3.Kkkkkkkkkkkkkkkkkkkkkkk;
                if (i5 != -1) {
                    MediaCodecInfo.CodecCapabilities codecCapabilities = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (codecCapabilities == null) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = "sampleRate.caps";
                    } else {
                        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
                        if (audioCapabilities == null) {
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = "sampleRate.aCaps";
                        } else if (!audioCapabilities.isSampleRateSupported(i5)) {
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(31, "sampleRate.support, ", i5);
                        } else {
                            z3 = true;
                            if (!z3) {
                                return false;
                            }
                        }
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                    z3 = false;
                    if (!z3) {
                    }
                }
                int i6 = c2245j3.Kkkkkkkkkkkkkkkkkkkkkkkk;
                if (i6 != -1) {
                    MediaCodecInfo.CodecCapabilities codecCapabilities2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (codecCapabilities2 == null) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = "channelCount.caps";
                    } else {
                        MediaCodecInfo.AudioCapabilities audioCapabilities2 = codecCapabilities2.getAudioCapabilities();
                        if (audioCapabilities2 == null) {
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = "channelCount.aCaps";
                        } else {
                            String str4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            String str5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            int maxInputChannelCount = audioCapabilities2.getMaxInputChannelCount();
                            if (maxInputChannelCount <= 1 && ((C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 26 || maxInputChannelCount <= 0) && !DLNAProfiles.DLNAMimeTypes.MIME_AUDIO_MPEG.equals(str5) && !DLNAProfiles.DLNAMimeTypes.MIME_AUDIO_3GP.equals(str5) && !"audio/amr-wb".equals(str5) && !"audio/mp4a-latm".equals(str5) && !"audio/vorbis".equals(str5) && !"audio/opus".equals(str5) && !"audio/raw".equals(str5) && !"audio/flac".equals(str5) && !"audio/g711-alaw".equals(str5) && !"audio/g711-mlaw".equals(str5) && !"audio/gsm".equals(str5))) {
                                maxInputChannelCount = "audio/ac3".equals(str5) ? 6 : "audio/eac3".equals(str5) ? 16 : 30;
                                String.valueOf(str4).length();
                            }
                            if (maxInputChannelCount < i6) {
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(33, "channelCount.support, ", i6);
                            } else {
                                z2 = true;
                                if (z2) {
                                    return false;
                                }
                            }
                        }
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    z2 = false;
                    if (z2) {
                    }
                }
            }
            return true;
        }
        z = true;
        if (z) {
        }
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3, C2245j3 c2245j32, boolean z) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            String str = c2245j3.Wwwwwwwwwwwww;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
            return str.equals(c2245j32.Wwwwwwwwwwwww) && c2245j3.Wwwww == c2245j32.Wwwww && (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww || (c2245j3.Wwwwwwww == c2245j32.Wwwwwwww && c2245j3.Wwwwwww == c2245j32.Wwwwwww)) && ((!z && c2245j32.Kkkkkkkkkkkkkkkkkkkkkkkkk == null) || C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3.Kkkkkkkkkkkkkkkkkkkkkkkkk, c2245j32.Kkkkkkkkkkkkkkkkkkkkkkkkk));
        }
        if ("audio/mp4a-latm".equals(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
            String str2 = c2245j3.Wwwwwwwwwwwww;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2);
            if (str2.equals(c2245j32.Wwwwwwwwwwwww) && c2245j3.Kkkkkkkkkkkkkkkkkkkkkkkk == c2245j32.Kkkkkkkkkkkkkkkkkkkkkkkk && c2245j3.Kkkkkkkkkkkkkkkkkkkkkkk == c2245j32.Kkkkkkkkkkkkkkkkkkkkkkk) {
                Pair<Integer, Integer> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = MediaCodecUtil.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3);
                Pair<Integer, Integer> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = MediaCodecUtil.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j32);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
                    return ((Integer) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.first).intValue() == 42 && ((Integer) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.first).intValue() == 42;
                }
            }
        }
        return false;
    }

    public MediaCodecInfo.CodecProfileLevel[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        return (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) ? new MediaCodecInfo.CodecProfileLevel[0] : codecProfileLevelArr;
    }

    public String toString() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @RequiresApi(21)
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, double d) {
        String sb;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (codecCapabilities == null) {
            sb = "sizeAndRate.caps";
        } else {
            MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
            if (videoCapabilities != null) {
                if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(videoCapabilities, i, i2, d)) {
                    if (i < i2) {
                        if ((!"OMX.MTK.VIDEO.DECODER.HEVC".equals(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) || !"mcv5a".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(videoCapabilities, i2, i, d)) {
                            StringBuilder sb2 = new StringBuilder(69);
                            sb2.append("sizeAndRate.rotated, ");
                            sb2.append(i);
                            sb2.append("x");
                            sb2.append(i2);
                            sb2.append("x");
                            sb2.append(d);
                            String sb3 = sb2.toString();
                            String str = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            String str2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            String str3 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            String.valueOf(sb3).length();
                            String.valueOf(str).length();
                            String.valueOf(str2).length();
                            String.valueOf(str3).length();
                        }
                    }
                    StringBuilder sb4 = new StringBuilder(69);
                    sb4.append("sizeAndRate.support, ");
                    sb4.append(i);
                    sb4.append("x");
                    sb4.append(i2);
                    sb4.append("x");
                    sb4.append(d);
                    sb = sb4.toString();
                }
                return true;
            }
            sb = "sizeAndRate.vCaps";
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb);
        return false;
    }
}
