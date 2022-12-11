package me.tvspark;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import androidx.core.location.GpsStatusWrapper;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.lzf.easyfloat.permission.PermissionUtils;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.tencent.smtt.sdk.TbsListener;
import com.umeng.analytics.pro.C1588bm;
import com.umeng.analytics.pro.C1648o;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.http.message.TokenParser;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* renamed from: me.tvspark.jh */
/* loaded from: classes4.dex */
public final class C2259jh extends AbstractC2333lh {
    public long Wwwwwwwwwww;
    public boolean Wwwwwwwwwwww;
    public byte Wwwwwwwwwwwwww;
    public byte Wwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwww;
    @Nullable
    public List<C2786xg> Wwwwwwwwwwwwwwwwwwww;
    @Nullable
    public List<C2786xg> Wwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final int[] Wwwwwwwwww = {11, 1, 3, 12, 14, 5, 7, 9};
    public static final int[] Wwwwwwwww = {0, 4, 8, 12, 16, 20, 24, 28};
    public static final int[] Wwwwwwww = {-1, -16711936, -16776961, -16711681, -65536, InputDeviceCompat.SOURCE_ANY, -65281};
    public static final int[] Wwwwwww = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, TbsListener.ErrorCode.CREATE_TEMP_CONF_ERROR, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS, 93, TbsListener.ErrorCode.DECOUPLE_TPATCH_INSTALL_SUCCESS, TbsListener.ErrorCode.DOWNLOAD_FAILED_FOR_PREINIT_CALLBACK, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, TbsListener.ErrorCode.RENAME_FAIL, 247, 209, TbsListener.ErrorCode.TPATCH_BACKUP_NOT_VALID, 9632};
    public static final int[] Wwwwww = {TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6, 189, 191, 8482, 162, 163, 9834, TbsListener.ErrorCode.EXCEED_INCR_UPDATE, 32, TbsListener.ErrorCode.INSTALL_SUCCESS_AND_RELEASE_LOCK, TbsListener.ErrorCode.DEXOAT_EXCEPTION, TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_SUCCESS, TbsListener.ErrorCode.TPATCH_FAIL, IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION};
    public static final int[] Wwwww = {GpsStatusWrapper.QZSS_SVID_MIN, 201, 211, TbsListener.ErrorCode.INCR_UPDATE_EXCEPTION, TbsListener.ErrorCode.COPY_INSTALL_SUCCESS, TinkerReport.KEY_LOADED_EXCEPTION_DEX, 8216, 161, 42, 39, C1648o.C1650a.f3580B, TbsListener.ErrorCode.STARTDOWNLOAD_10, 8480, 8226, 8220, 8221, 192, 194, PermissionUtils.requestCode, 200, 202, 203, TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_FAIL, 206, 207, TbsListener.ErrorCode.DECOUPLE_TPATCH_FAIL, 212, TbsListener.ErrorCode.INCR_UPDATE_FAIL, 249, TbsListener.ErrorCode.RENAME_EXCEPTION, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_1, 187};
    public static final int[] Wwww = {195, TbsListener.ErrorCode.HOST_CONTEXT_IS_NULL, 205, 204, TbsListener.ErrorCode.TPATCH_INSTALL_SUCCESS, 210, TbsListener.ErrorCode.TPATCH_ENABLE_EXCEPTION, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, TbsListener.ErrorCode.INCR_ERROR_DETAIL, TbsListener.ErrorCode.COPY_TMPDIR_ERROR, 246, TbsListener.ErrorCode.EXCEED_LZMA_RETRY_NUM, 165, 164, 9474, 197, TbsListener.ErrorCode.INSTALL_FROM_UNZIP, TbsListener.ErrorCode.INCR_UPDATE_ERROR, 248, 9484, 9488, 9492, 9496};
    public static final boolean[] Www = {false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false};
    public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2078el();
    public final ArrayList<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwww = new ArrayList<>();
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, 4);
    public int Wwwwwwwwwwwww = 0;

    /* renamed from: me.tvspark.jh$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final List<C3476Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
        public final List<SpannableString> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
        public final StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new StringBuilder();

        /* renamed from: me.tvspark.jh$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C3476Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
            public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

            public C3476Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, boolean z, int i2) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        }

        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty() && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty() && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length() == 0;
        }

        public final SpannableString Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            int length = spannableStringBuilder.length();
            int i = 0;
            int i2 = -1;
            int i3 = -1;
            int i4 = 0;
            int i5 = -1;
            boolean z = false;
            int i6 = -1;
            while (i < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size()) {
                C3476Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww c3476Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i);
                boolean z2 = c3476Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i7 = c3476Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (i7 != 8) {
                    boolean z3 = i7 == 7;
                    if (i7 != 7) {
                        i6 = C2259jh.Wwwwwwww[i7];
                    }
                    z = z3;
                }
                int i8 = c3476Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                i++;
                if (i8 != (i < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() ? this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : length)) {
                    if (i2 != -1 && !z2) {
                        spannableStringBuilder.setSpan(new UnderlineSpan(), i2, i8, 33);
                        i2 = -1;
                    } else if (i2 == -1 && z2) {
                        i2 = i8;
                    }
                    if (i3 != -1 && !z) {
                        spannableStringBuilder.setSpan(new StyleSpan(2), i3, i8, 33);
                        i3 = -1;
                    } else if (i3 == -1 && z) {
                        i3 = i8;
                    }
                    if (i6 != i5) {
                        if (i5 != -1) {
                            spannableStringBuilder.setSpan(new ForegroundColorSpan(i5), i4, i8, 33);
                        }
                        i4 = i8;
                        i5 = i6;
                    }
                }
            }
            if (i2 != -1 && i2 != length) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i2, length, 33);
            }
            if (i3 != -1 && i3 != length) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i3, length, 33);
            }
            if (i4 != length && i5 != -1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(i5), i4, length, 33);
            }
            return new SpannableString(spannableStringBuilder);
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setLength(0);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 15;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        }

        @Nullable
        public C2786xg Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            float f;
            int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i3 = 32 - i2;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i4 = 0; i4 < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size(); i4++) {
                spannableStringBuilder.append(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i4), i3));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), i3));
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int length = i3 - spannableStringBuilder.length();
            int i5 = i2 - length;
            int i6 = i != Integer.MIN_VALUE ? i : (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww != 2 || (Math.abs(i5) >= 3 && length >= 0)) ? (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww != 2 || i5 <= 0) ? 0 : 2 : 1;
            if (i6 != 1) {
                if (i6 == 2) {
                    i2 = 32 - length;
                }
                f = ((i2 / 32.0f) * 0.8f) + 0.1f;
            } else {
                f = 0.5f;
            }
            int i7 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i7 > 7) {
                i7 = (i7 - 15) - 2;
            } else if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww == 1) {
                i7 -= this.Wwwwwwwwwwwwwwwwwwwwwwwwwww - 1;
            }
            return new C2786xg(spannableStringBuilder, Layout.Alignment.ALIGN_NORMAL, null, i7, 1, Integer.MIN_VALUE, f, i6, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, -3.4028235E38f, false, -16777216, Integer.MIN_VALUE, null);
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            int length = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length();
            if (length > 0) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.delete(length - 1, length);
                for (int size = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() - 1; size >= 0; size--) {
                    C3476Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww c3476Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(size);
                    int i = c3476Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (i != length) {
                        return;
                    }
                    c3476Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i - 1;
                }
            }
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(char c) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length() < 32) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(c);
            }
        }
    }

    public C2259jh(String str, int i, long j) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = j > 0 ? j * 1000 : -9223372036854775807L;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = "application/x-mp4-cea-608".equals(str) ? 2 : 3;
        if (i != 1) {
            if (i == 2) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwww = 1;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwww = 0;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                this.Wwwwwwwwwwww = true;
                this.Wwwwwwwwwww = -9223372036854775807L;
            }
            if (i == 3) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwww = 0;
            } else if (i == 4) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwww = 1;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = 1;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwwww = true;
            this.Wwwwwwwwwww = -9223372036854775807L;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwww = true;
        this.Wwwwwwwwwww = -9223372036854775807L;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwww.clear();
        this.Wwwwwwwwwwwwwwwwwwwwwww.add(this.Wwwwwwwwwwwwwwwwwwwwww);
    }

    public final List<C2786xg> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int size = this.Wwwwwwwwwwwwwwwwwwwwwww.size();
        ArrayList arrayList = new ArrayList(size);
        int i = 2;
        for (int i2 = 0; i2 < size; i2++) {
            C2786xg Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwww.get(i2).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Integer.MIN_VALUE);
            arrayList.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
                i = Math.min(i, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }
        ArrayList arrayList2 = new ArrayList(size);
        for (int i3 = 0; i3 < size; i3++) {
            C2786xg c2786xg = (C2786xg) arrayList.get(i3);
            if (c2786xg != null) {
                if (c2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwww != i) {
                    C2786xg Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = this.Wwwwwwwwwwwwwwwwwwwwwww.get(i3).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                    c2786xg = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                }
                arrayList2.add(c2786xg);
            }
        }
        return arrayList2;
    }

    @Override // me.tvspark.AbstractC2333lh
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwww != this.Wwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC2333lh
    public AbstractC1909ah Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        List<C2786xg> list = this.Wwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwww = list;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list);
        return new C2370mh(list);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        this.Wwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww = i;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x0273, code lost:
        if (r1 != 3) goto L82;
     */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0015 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0015 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00cb A[SYNTHETIC] */
    @Override // me.tvspark.AbstractC2333lh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2037dh c2037dh) {
        boolean z;
        boolean z2;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i;
        ByteBuffer byteBuffer = c2037dh.Wwwwwwwwwwwwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer.array(), byteBuffer.limit());
        boolean z3 = false;
        while (true) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 < i2) {
                if (!z3) {
                    return;
                }
                int i3 = this.Wwwwwwwwwwwwwwwwwww;
                if (i3 != 1 && i3 != 3) {
                    return;
                }
                this.Wwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                this.Wwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                return;
            }
            byte Wwwwwwwwwwwwwwwwwwwwww = i2 == 2 ? (byte) -4 : (byte) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww();
            int Wwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww();
            int Wwwwwwwwwwwwwwwwwwwwww3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww();
            if ((Wwwwwwwwwwwwwwwwwwwwww & 2) == 0 && (Wwwwwwwwwwwwwwwwwwwwww & 1) == this.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
                byte b = (byte) (Wwwwwwwwwwwwwwwwwwwwww2 & 127);
                byte b2 = (byte) (Wwwwwwwwwwwwwwwwwwwwww3 & 127);
                if (b != 0 || b2 != 0) {
                    boolean z4 = this.Wwwwwwwwwwwwwwwww;
                    if ((Wwwwwwwwwwwwwwwwwwwwww & 4) == 4) {
                        boolean[] zArr = Www;
                        if (zArr[Wwwwwwwwwwwwwwwwwwwwww2] && zArr[Wwwwwwwwwwwwwwwwwwwwww3]) {
                            z = true;
                            this.Wwwwwwwwwwwwwwwww = z;
                            if (z) {
                                if ((b & 240) == 16) {
                                    if (this.Wwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwww == b && this.Wwwwwwwwwwwwww == b2) {
                                        this.Wwwwwwwwwwwwwwww = false;
                                        z2 = true;
                                        if (!z2) {
                                        }
                                    } else {
                                        this.Wwwwwwwwwwwwwwww = true;
                                        this.Wwwwwwwwwwwwwww = b;
                                        this.Wwwwwwwwwwwwww = b2;
                                        z2 = false;
                                        if (!z2) {
                                            if (this.Wwwwwwwwwwwwwwwww) {
                                                if (!(1 <= b && b <= 15)) {
                                                    if ((b & 247) == 20) {
                                                        if (b2 != 32 && b2 != 47) {
                                                            switch (b2) {
                                                                default:
                                                                    switch (b2) {
                                                                    }
                                                                case 37:
                                                                case 38:
                                                                case 39:
                                                                    this.Wwwwwwwwwwww = true;
                                                                    break;
                                                            }
                                                        }
                                                        this.Wwwwwwwwwwww = true;
                                                    }
                                                    if (this.Wwwwwwwwwwww) {
                                                        int i4 = b & C1588bm.f3196k;
                                                        if (i4 == 0) {
                                                            this.Wwwwwwwwwwwww = (b >> 3) & 1;
                                                        }
                                                        if (this.Wwwwwwwwwwwww == this.Wwwwwwwwwwwwwwwwwwwwwwwww) {
                                                            if (!(i4 == 0)) {
                                                                this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((char) Wwwwwww[(b & Byte.MAX_VALUE) - 32]);
                                                                if ((b2 & C1588bm.f3196k) != 0) {
                                                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwww;
                                                                    i = Wwwwwww[(b2 & Byte.MAX_VALUE) - 32];
                                                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((char) i);
                                                                }
                                                                z3 = true;
                                                            } else {
                                                                int i5 = b & 247;
                                                                if (i5 == 17 && (b2 & 240) == 48) {
                                                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwww;
                                                                    i = Wwwwww[b2 & 15];
                                                                } else {
                                                                    int i6 = b & 246;
                                                                    if (i6 == 18 && (b2 & C1588bm.f3196k) == 32) {
                                                                        this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwww;
                                                                        if ((b & 1) == 0) {
                                                                            i = Wwwww[b2 & 31];
                                                                        } else {
                                                                            i = Wwww[b2 & 31];
                                                                        }
                                                                    } else {
                                                                        if (i5 == 17 && (b2 & 240) == 32) {
                                                                            this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TokenParser.f4579SP);
                                                                            boolean z5 = (b2 & 1) == 1;
                                                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwww;
                                                                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.C3476Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((b2 >> 1) & 7, z5, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length()));
                                                                        } else {
                                                                            if ((b & 240) == 16 && (b2 & ExifInterface.MARKER_SOF0) == 64) {
                                                                                int i7 = Wwwwwwwwww[b & 7];
                                                                                if ((b2 & 32) != 0) {
                                                                                    i7++;
                                                                                }
                                                                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = this.Wwwwwwwwwwwwwwwwwwwwww;
                                                                                if (i7 != wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                                                                                    if (this.Wwwwwwwwwwwwwwwwwww != 1 && !wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                                                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwww);
                                                                                        this.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
                                                                                        this.Wwwwwwwwwwwwwwwwwwwwwww.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
                                                                                    }
                                                                                    this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i7;
                                                                                }
                                                                                boolean z6 = (b2 & 16) == 16;
                                                                                boolean z7 = (b2 & 1) == 1;
                                                                                int i8 = (b2 >> 1) & 7;
                                                                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = this.Wwwwwwwwwwwwwwwwwwwwww;
                                                                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.C3476Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z6 ? 8 : i8, z7, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length()));
                                                                                if (z6) {
                                                                                    this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwww[i8];
                                                                                }
                                                                            } else {
                                                                                if (i5 == 23 && b2 >= 33 && b2 <= 35) {
                                                                                    this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = b2 + C1588bm.f3196k;
                                                                                } else {
                                                                                    if (i6 == 20 && (b2 & 240) == 32) {
                                                                                        if (b2 == 32) {
                                                                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                                                                                        } else if (b2 != 41) {
                                                                                            switch (b2) {
                                                                                                case 37:
                                                                                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                                                                                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                                                                                                    break;
                                                                                                case 38:
                                                                                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                                                                                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
                                                                                                    break;
                                                                                                case 39:
                                                                                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                                                                                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                                                                                                    break;
                                                                                                default:
                                                                                                    int i9 = this.Wwwwwwwwwwwwwwwwwww;
                                                                                                    if (i9 != 0) {
                                                                                                        if (b2 == 33) {
                                                                                                            this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                                            break;
                                                                                                        } else {
                                                                                                            switch (b2) {
                                                                                                                case 44:
                                                                                                                    this.Wwwwwwwwwwwwwwwwwwwww = Collections.emptyList();
                                                                                                                    int i10 = this.Wwwwwwwwwwwwwwwwwww;
                                                                                                                    if (i10 != 1) {
                                                                                                                    }
                                                                                                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                                                    break;
                                                                                                                case 45:
                                                                                                                    if (i9 == 1 && !this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                                                                                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = this.Wwwwwwwwwwwwwwwwwwwwww;
                                                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                                                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setLength(0);
                                                                                                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
                                                                                                                        int min = Math.min(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                                                                                                        while (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() >= min) {
                                                                                                                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remove(0);
                                                                                                                        }
                                                                                                                        break;
                                                                                                                    }
                                                                                                                    break;
                                                                                                                case 46:
                                                                                                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                                                    break;
                                                                                                                case 47:
                                                                                                                    this.Wwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                                                                                    break;
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                    break;
                                                                                            }
                                                                                        } else {
                                                                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                        z3 = true;
                                                                    }
                                                                }
                                                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((char) i);
                                                                z3 = true;
                                                            }
                                                        }
                                                    }
                                                }
                                                this.Wwwwwwwwwwww = false;
                                                if (this.Wwwwwwwwwwww) {
                                                }
                                            } else if (z4) {
                                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                z3 = true;
                                            }
                                        }
                                    }
                                }
                            }
                            this.Wwwwwwwwwwwwwwww = false;
                            z2 = false;
                            if (!z2) {
                            }
                        }
                    }
                    z = false;
                    this.Wwwwwwwwwwwwwwwww = z;
                    if (z) {
                    }
                    this.Wwwwwwwwwwwwwwww = false;
                    z2 = false;
                    if (!z2) {
                    }
                }
            }
        }
    }

    @Override // me.tvspark.AbstractC2333lh, me.tvspark.AbstractC2660u5
    public void flush() {
        super.flush();
        this.Wwwwwwwwwwwwwwwwwwwww = null;
        this.Wwwwwwwwwwwwwwwwwwww = null;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwww = false;
        this.Wwwwwwwwwwwwwwww = false;
        this.Wwwwwwwwwwwwwww = (byte) 0;
        this.Wwwwwwwwwwwwww = (byte) 0;
        this.Wwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwww = true;
        this.Wwwwwwwwwww = -9223372036854775807L;
    }

    @Override // me.tvspark.AbstractC2333lh, me.tvspark.AbstractC2660u5
    public void release() {
    }

    @Override // me.tvspark.AbstractC2333lh, me.tvspark.AbstractC2660u5
    @Nullable
    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: avoid collision after fix types in other method */
    public AbstractC2074eh mo4972Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws SubtitleDecoderException {
        AbstractC2074eh pollFirst;
        AbstractC2074eh mo4972Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = super.mo4972Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (mo4972Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            return mo4972Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        long j = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        boolean z = false;
        if (j != -9223372036854775807L) {
            long j2 = this.Wwwwwwwwwww;
            if (j2 != -9223372036854775807L && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww - j2 >= j) {
                z = true;
            }
        }
        if (!z || (pollFirst = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.pollFirst()) == null) {
            return null;
        }
        List<C2786xg> emptyList = Collections.emptyList();
        this.Wwwwwwwwwwwwwwwwwwwww = emptyList;
        this.Wwwwwwwwwww = -9223372036854775807L;
        this.Wwwwwwwwwwwwwwwwwwww = emptyList;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(emptyList);
        pollFirst.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, new C2370mh(emptyList), Long.MAX_VALUE);
        return pollFirst;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        int i2 = this.Wwwwwwwwwwwwwwwwwww;
        if (i2 == i) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwww = i;
        if (i == 3) {
            for (int i3 = 0; i3 < this.Wwwwwwwwwwwwwwwwwwwwwww.size(); i3++) {
                this.Wwwwwwwwwwwwwwwwwwwwwww.get(i3).Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            }
            return;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (i2 != 3 && i != 1 && i != 0) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwww = Collections.emptyList();
    }
}
