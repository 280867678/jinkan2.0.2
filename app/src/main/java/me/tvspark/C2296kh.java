package me.tvspark;

import android.graphics.Color;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.umeng.commonsdk.debug.UMLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.http.message.TokenParser;
import org.mozilla.javascript.Token;

/* renamed from: me.tvspark.kh */
/* loaded from: classes4.dex */
public final class C2296kh extends AbstractC2333lh {
    public int Wwwwwwwwwwwwwwwwwwww;
    @Nullable
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public List<C2786xg> Wwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public List<C2786xg> Wwwwwwwwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwww;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] Wwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2078el();
    public final C2041dl Wwwwwwwwwwwwwwwwwwwwwwwwwww = new C2041dl();

    /* renamed from: me.tvspark.kh$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        public final byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new byte[(i2 * 2) - 1];
        }
    }

    /* renamed from: me.tvspark.kh$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public static final int[] Kkkkkkkkkkkkkkkkkkkkkkkkkk;
        public static final int[] Wwwww;
        public static final int Wwwwwwwwww;
        public int Wwwwwwwwwwwww;
        public int Wwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public static final int Wwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2, 2, 2, 0);
        public static final int Wwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, 0, 0, 0);
        public static final int[] Wwwwwwwww = {0, 0, 0, 0, 0, 2, 0};
        public static final int[] Wwwwwwww = {0, 0, 0, 0, 0, 0, 2};
        public static final int[] Wwwwwww = {3, 3, 3, 3, 3, 3, 1};
        public static final boolean[] Wwwwww = {false, false, false, true, true, true, false};
        public static final int[] Wwww = {0, 1, 2, 3, 4, 3, 4};
        public static final int[] Www = {0, 0, 0, 0, 0, 3, 3};
        public final List<SpannableString> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
        public final SpannableStringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new SpannableStringBuilder();

        static {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, 0, 0, 3);
            Wwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i = Wwwwwwwwwww;
            Wwwww = new int[]{i, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i, i, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i, i};
            Kkkkkkkkkkkkkkkkkkkkkkkkkk = new int[]{i, i, i, i, i, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww};
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x002e  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0028  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3, int i4) {
            int i5;
            int i6 = 0;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, 0, 4);
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, 0, 4);
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3, 0, 4);
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4, 0, 4);
            if (i4 != 0 && i4 != 1) {
                if (i4 == 2) {
                    i5 = 127;
                } else if (i4 == 3) {
                    i5 = 0;
                }
                int i7 = i <= 1 ? 255 : 0;
                int i8 = i2 <= 1 ? 255 : 0;
                if (i3 > 1) {
                    i6 = 255;
                }
                return Color.argb(i5, i7, i8, i6);
            }
            i5 = 255;
            if (i <= 1) {
            }
            if (i2 <= 1) {
            }
            if (i3 > 1) {
            }
            return Color.argb(i5, i7, i8, i6);
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 4;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = 0;
            this.Wwwwwwwwwwwwwwwwwwwwwwwww = 15;
            this.Wwwwwwwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwwwwwwwwwww = 0;
            this.Wwwwwwwwwwwwwwwwwwwwww = 0;
            this.Wwwwwwwwwwwwwwwwwwwww = 0;
            int i = Wwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwww = Wwwwwwwwwwww;
            this.Wwwwwwwwwwwwww = i;
        }

        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return !this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty() && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length() == 0);
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
            this.Wwwwwwwwwwwwwwwwwww = -1;
            this.Wwwwwwwwwwwwwwwwww = -1;
            this.Wwwwwwwwwwwwwwwww = -1;
            this.Wwwwwwwwwwwwwww = -1;
            this.Wwwwwwwwwwwww = 0;
        }

        public SpannableString Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.Wwwwwwwwwwwwwwwwwww != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.Wwwwwwwwwwwwwwwwwww, length, 33);
                }
                if (this.Wwwwwwwwwwwwwwwwww != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.Wwwwwwwwwwwwwwwwww, length, 33);
                }
                if (this.Wwwwwwwwwwwwwwwww != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.Wwwwwwwwwwwwwwww), this.Wwwwwwwwwwwwwwwww, length, 33);
                }
                if (this.Wwwwwwwwwwwwwww != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.Wwwwwwwwwwwwww), this.Wwwwwwwwwwwwwww, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(char c) {
            if (c != '\n') {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(c);
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
            if (this.Wwwwwwwwwwwwwwwwwww != -1) {
                this.Wwwwwwwwwwwwwwwwwww = 0;
            }
            if (this.Wwwwwwwwwwwwwwwwww != -1) {
                this.Wwwwwwwwwwwwwwwwww = 0;
            }
            if (this.Wwwwwwwwwwwwwwwww != -1) {
                this.Wwwwwwwwwwwwwwwww = 0;
            }
            if (this.Wwwwwwwwwwwwwww != -1) {
                this.Wwwwwwwwwwwwwww = 0;
            }
            while (true) {
                if ((!this.Wwwwwwwwwwwwwwwwwwwwwwww || this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() < this.Wwwwwwwwwwwwwwwwwwwwwwwww) && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() < 15) {
                    return;
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remove(0);
            }
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
            if (this.Wwwwwwwwwwwwwwwww != -1 && this.Wwwwwwwwwwwwwwww != i) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setSpan(new ForegroundColorSpan(this.Wwwwwwwwwwwwwwww), this.Wwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length(), 33);
            }
            if (i != Wwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length();
                this.Wwwwwwwwwwwwwwww = i;
            }
            if (this.Wwwwwwwwwwwwwww != -1 && this.Wwwwwwwwwwwwww != i2) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setSpan(new BackgroundColorSpan(this.Wwwwwwwwwwwwww), this.Wwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length(), 33);
            }
            if (i2 != Wwwwwwwwwww) {
                this.Wwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length();
                this.Wwwwwwwwwwwwww = i2;
            }
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, boolean z2) {
            if (this.Wwwwwwwwwwwwwwwwwww != -1) {
                if (!z) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setSpan(new StyleSpan(2), this.Wwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length(), 33);
                    this.Wwwwwwwwwwwwwwwwwww = -1;
                }
            } else if (z) {
                this.Wwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length();
            }
            if (this.Wwwwwwwwwwwwwwwwww == -1) {
                if (!z2) {
                    return;
                }
                this.Wwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length();
            } else if (z2) {
            } else {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setSpan(new UnderlineSpan(), this.Wwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length(), 33);
                this.Wwwwwwwwwwwwwwwwww = -1;
            }
        }
    }

    /* renamed from: me.tvspark.kh$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final C2786xg Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CharSequence charSequence, Layout.Alignment alignment, float f, int i, int i2, float f2, int i3, float f3, boolean z, int i4, int i5) {
            boolean z2;
            int i6;
            if (z) {
                i6 = i4;
                z2 = true;
            } else {
                z2 = false;
                i6 = -16777216;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2786xg(charSequence, alignment, null, f, i, i2, f2, i3, Integer.MIN_VALUE, -3.4028235E38f, f3, -3.4028235E38f, z2, i6, Integer.MIN_VALUE, null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i5;
        }
    }

    public C2296kh(int i, @Nullable List<byte[]> list) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = i == -1 ? 1 : i;
        if (list != null && (list.size() != 1 || list.get(0).length != 1 || list.get(0)[0] != 1)) {
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[8];
        for (int i2 = 0; i2 < 8; i2++) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwww[i2] = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwww[0];
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        for (int i = 0; i < 8; i++) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwww[i].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<C2786xg> Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Layout.Alignment alignment;
        float f;
        float f2;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 8; i++) {
            if (!this.Wwwwwwwwwwwwwwwwwwwwwwwww[i].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr[i].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr[i];
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                    } else {
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                        for (int i2 = 0; i2 < wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size(); i2++) {
                            spannableStringBuilder.append((CharSequence) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i2));
                            spannableStringBuilder.append('\n');
                        }
                        spannableStringBuilder.append((CharSequence) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                        int i3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
                        if (i3 != 0) {
                            if (i3 == 1) {
                                alignment = Layout.Alignment.ALIGN_OPPOSITE;
                            } else if (i3 == 2) {
                                alignment = Layout.Alignment.ALIGN_CENTER;
                            } else if (i3 != 3) {
                                throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(43, "Unexpected justification value: ", wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww));
                            }
                            Layout.Alignment alignment2 = alignment;
                            if (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                                f = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww / 99.0f;
                                f2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww / 99.0f;
                            } else {
                                f = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww / 209.0f;
                                f2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww / 74.0f;
                            }
                            float f3 = (f * 0.9f) + 0.05f;
                            float f4 = (f2 * 0.9f) + 0.05f;
                            int i4 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww % 3;
                            int i5 = i4 != 0 ? 0 : i4 == 1 ? 1 : 2;
                            int i6 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww / 3;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(spannableStringBuilder, alignment2, f4, 0, i5, f3, i6 != 0 ? 0 : i6 == 1 ? 1 : 2, -3.4028235E38f, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww == Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        }
                        alignment = Layout.Alignment.ALIGN_NORMAL;
                        Layout.Alignment alignment22 = alignment;
                        if (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        }
                        float f32 = (f * 0.9f) + 0.05f;
                        float f42 = (f2 * 0.9f) + 0.05f;
                        int i42 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww % 3;
                        if (i42 != 0) {
                        }
                        int i62 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww / 3;
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(spannableStringBuilder, alignment22, f42, 0, i5, f32, i62 != 0 ? 0 : i62 == 1 ? 1 : 2, -3.4028235E38f, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww == Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    }
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                        arrayList.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    }
                } else {
                    continue;
                }
            }
        }
        Collections.sort(arrayList, C2185hh.Wwwwwwwwwwwwwwwwwwwwwwww);
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            arrayList2.add(((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) arrayList.get(i7)).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        return Collections.unmodifiableList(arrayList2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        char c;
        C2041dl c2041dl;
        int i;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        char c2;
        C2041dl c2041dl2;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
        C2041dl c2041dl3;
        C2041dl c2041dl4;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            return;
        }
        int i2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i2 == (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww * 2) - 1) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i2);
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(5);
            int i3 = 7;
            int i4 = 6;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 7) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(6);
            }
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != 0 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == this.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
                boolean z = false;
                while (this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() > 0) {
                    int i5 = 8;
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                    int i6 = 24;
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 == 16) {
                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 <= 31) {
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 > 7) {
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 <= 15) {
                                    c2041dl2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 <= 23) {
                                    c2041dl2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    i5 = 16;
                                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 <= 31) {
                                    c2041dl2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    i5 = 24;
                                }
                                c2041dl2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i5);
                            }
                        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 <= 127) {
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 == 32) {
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                                c2 = TokenParser.f4579SP;
                            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 == 33) {
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                                c2 = 160;
                            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 == 37) {
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                                c2 = 8230;
                            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 == 42) {
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                                c2 = 352;
                            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 == 44) {
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                                c2 = 338;
                            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 == 63) {
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                                c2 = 376;
                            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 == 57) {
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                                c2 = 8482;
                            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 == 58) {
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                                c2 = 353;
                            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 == 60) {
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                                c2 = 339;
                            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 != 61) {
                                switch (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5) {
                                    case 48:
                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                                        c2 = 9608;
                                        break;
                                    case 49:
                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                                        c2 = 8216;
                                        break;
                                    case 50:
                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                                        c2 = 8217;
                                        break;
                                    case 51:
                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                                        c2 = 8220;
                                        break;
                                    case 52:
                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                                        c2 = 8221;
                                        break;
                                    case 53:
                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                                        c2 = 8226;
                                        break;
                                    default:
                                        switch (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5) {
                                            case 118:
                                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                                                c2 = 8539;
                                                break;
                                            case 119:
                                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                                                c2 = 8540;
                                                break;
                                            case 120:
                                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                                                c2 = 8541;
                                                break;
                                            case 121:
                                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                                                c2 = 8542;
                                                break;
                                            case 122:
                                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                                                c2 = UMLog.HORIZONTAL_LINE;
                                                break;
                                            case 123:
                                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                                                c2 = 9488;
                                                break;
                                            case 124:
                                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                                                c2 = UMLog.BOTTOM_LEFT_CORNER;
                                                break;
                                            case 125:
                                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                                                c2 = 9472;
                                                break;
                                            case 126:
                                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                                                c2 = 9496;
                                                break;
                                            case 127:
                                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                                                c2 = UMLog.TOP_LEFT_CORNER;
                                                break;
                                        }
                                }
                                z = true;
                            } else {
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                                c2 = 8480;
                            }
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2);
                            z = true;
                        } else {
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 <= 159) {
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 <= 135) {
                                    c2041dl = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    i = 32;
                                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 <= 143) {
                                    c2041dl = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    i = 40;
                                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 <= 159) {
                                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(6) * 8);
                                }
                                c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
                            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 <= 255) {
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 == 160) {
                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                                    c = 13252;
                                } else {
                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                                    c = '_';
                                }
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c);
                                z = true;
                            }
                            i3 = 7;
                            i4 = 6;
                        }
                    } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 <= 31) {
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 != 0) {
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 == 3) {
                                this.Wwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 != 8) {
                                switch (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4) {
                                    case 12:
                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                        break;
                                    case 13:
                                        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('\n');
                                        break;
                                    case 14:
                                        break;
                                    default:
                                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 >= 17 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 <= 23) {
                                            c2041dl4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                                        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 >= 24 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 <= 31) {
                                            c2041dl4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                                            i5 = 16;
                                        }
                                        c2041dl4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i5);
                                        break;
                                }
                            } else {
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                                int length = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length();
                                if (length > 0) {
                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.delete(length - 1, length);
                                }
                            }
                        }
                    } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 <= 127) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 == 127 ? (char) 9835 : (char) (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 & 255));
                        z = true;
                    } else {
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 <= 159) {
                            switch (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4) {
                                case 128:
                                case 129:
                                case 130:
                                case Token.LABEL /* 131 */:
                                case Token.TARGET /* 132 */:
                                case Token.LOOP /* 133 */:
                                case Token.EXPR_VOID /* 134 */:
                                case Token.EXPR_RESULT /* 135 */:
                                    int i7 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 - 128;
                                    if (this.Wwwwwwwwwwwwwwwwwwww != i7) {
                                        this.Wwwwwwwwwwwwwwwwwwww = i7;
                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = this.Wwwwwwwwwwwwwwwwwwwwwwwww[i7];
                                        this.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                                        break;
                                    }
                                    break;
                                case Token.JSR /* 136 */:
                                    for (int i8 = 1; i8 <= 8; i8++) {
                                        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                            this.Wwwwwwwwwwwwwwwwwwwwwwwww[8 - i8].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                        }
                                    }
                                    break;
                                case Token.SCRIPT /* 137 */:
                                    for (int i9 = 1; i9 <= 8; i9++) {
                                        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                            this.Wwwwwwwwwwwwwwwwwwwwwwwww[8 - i9].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                                        }
                                    }
                                    break;
                                case Token.TYPEOFNAME /* 138 */:
                                    for (int i10 = 1; i10 <= 8; i10++) {
                                        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                            this.Wwwwwwwwwwwwwwwwwwwwwwwww[8 - i10].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
                                        }
                                    }
                                    break;
                                case Token.USE_STACK /* 139 */:
                                    for (int i11 = 1; i11 <= 8; i11++) {
                                        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                            this.Wwwwwwwwwwwwwwwwwwwwwwwww[8 - i11].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = !wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                        }
                                    }
                                    break;
                                case 140:
                                    for (int i12 = 1; i12 <= 8; i12++) {
                                        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                            this.Wwwwwwwwwwwwwwwwwwwwwwwww[8 - i12].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                        }
                                    }
                                    break;
                                case 141:
                                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                                    break;
                                case 143:
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                    break;
                                case 144:
                                    if (this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                                        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
                                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
                                        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                                        break;
                                    }
                                    c2041dl3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    i6 = 16;
                                    c2041dl3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i6);
                                case 145:
                                    if (!this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                                        c2041dl3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                                        c2041dl3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i6);
                                        break;
                                    } else {
                                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2), this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2), this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2), this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2));
                                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2), this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2), this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2), this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2));
                                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2), this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2), this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2), 0);
                                        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7);
                                    }
                                case 146:
                                    if (this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(6);
                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                                        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwww != Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8) {
                                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('\n');
                                        }
                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8;
                                        break;
                                    }
                                    c2041dl3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    i6 = 16;
                                    c2041dl3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i6);
                                case 151:
                                    if (!this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                                        c2041dl3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                                        i6 = 32;
                                        c2041dl3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i6);
                                        break;
                                    } else {
                                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2), this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2), this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2), this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2));
                                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2), this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2), this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2), 0);
                                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7.Wwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9;
                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7.Wwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10;
                                    }
                                case 152:
                                case 153:
                                case 154:
                                case 155:
                                case 156:
                                case 157:
                                case 158:
                                case Token.LETEXPR /* 159 */:
                                    int i13 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 - 152;
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 = this.Wwwwwwwwwwwwwwwwwwwwwwwww[i13];
                                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                                    boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                    boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
                                    boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
                                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww13 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww14 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww15 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4);
                                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww16 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
                                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww17 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.Wwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11;
                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww5;
                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12;
                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.Wwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww13;
                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.Wwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww14;
                                    int i14 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww15 + 1;
                                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.Wwwwwwwwwwwwwwwwwwwwwwwww != i14) {
                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.Wwwwwwwwwwwwwwwwwwwwwwwww = i14;
                                        while (true) {
                                            if ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwww4 && wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() >= wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.Wwwwwwwwwwwwwwwwwwwwwwwww) || wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() >= 15) {
                                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remove(0);
                                            }
                                        }
                                    }
                                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww16 != 0 && wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.Wwwwwwwwwwwwwwwwwwwwww != Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww16) {
                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.Wwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww16;
                                        int i15 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww16 - 1;
                                        int i16 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwww[i15];
                                        boolean z2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwww[i15];
                                        int i17 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwww[i15];
                                        int i18 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwww[i15];
                                        int i19 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwww[i15];
                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.Wwwwwwwwwwwwwwwwwwww = i16;
                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.Wwwwwwwwwwwwwwwwwwwwwww = i19;
                                    }
                                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww17 != 0 && wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.Wwwwwwwwwwwwwwwwwwwww != Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww17) {
                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.Wwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww17;
                                        int i20 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww17 - 1;
                                        int i21 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Www[i20];
                                        int i22 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwww[i20];
                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, false);
                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkkkkkkkkkkkkkkkkkkk[i20]);
                                    }
                                    if (this.Wwwwwwwwwwwwwwwwwwww != i13) {
                                        this.Wwwwwwwwwwwwwwwwwwww = i13;
                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = this.Wwwwwwwwwwwwwwwwwwwwwwwww[i13];
                                        this.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                                        break;
                                    }
                                    break;
                            }
                        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 <= 255) {
                            this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((char) (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 & 255));
                        }
                        z = true;
                    }
                    i3 = 7;
                    i4 = 6;
                }
                if (z) {
                    this.Wwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
            }
        }
        this.Wwwwwwwwwwwwwwwwwwwww = null;
    }

    @Override // me.tvspark.AbstractC2333lh
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww != this.Wwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC2333lh
    public AbstractC1909ah Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        List<C2786xg> list = this.Wwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwww = list;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list);
        return new C2370mh(list);
    }

    @Override // me.tvspark.AbstractC2333lh
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2037dh c2037dh) {
        ByteBuffer byteBuffer = c2037dh.Wwwwwwwwwwwwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer);
        ByteBuffer byteBuffer2 = byteBuffer;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer2.array(), byteBuffer2.limit());
        while (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() >= 3) {
            int Wwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww() & 7;
            int i = Wwwwwwwwwwwwwwwwwwwwww & 3;
            boolean z = false;
            boolean z2 = (Wwwwwwwwwwwwwwwwwwwwww & 4) == 4;
            byte Wwwwwwwwwwwwwwwwwwwwww2 = (byte) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww();
            byte Wwwwwwwwwwwwwwwwwwwwww3 = (byte) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww();
            if (i == 2 || i == 3) {
                if (z2) {
                    if (i == 3) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        int i2 = (Wwwwwwwwwwwwwwwwwwwwww2 & ExifInterface.MARKER_SOF0) >> 6;
                        int i3 = Wwwwwwwwwwwwwwwwwwwwww2 & 63;
                        if (i3 == 0) {
                            i3 = 64;
                        }
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, i3);
                        this.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        byte[] bArr = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        int i4 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i4 + 1;
                        bArr[i4] = Wwwwwwwwwwwwwwwwwwwwww3;
                    } else {
                        if (i == 2) {
                            z = true;
                        }
                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwww;
                        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
                            byte[] bArr2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            int i5 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            int i6 = i5 + 1;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i6;
                            bArr2[i5] = Wwwwwwwwwwwwwwwwwwwwww2;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i6 + 1;
                            bArr2[i6] = Wwwwwwwwwwwwwwwwwwwwww3;
                        }
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = this.Wwwwwwwwwwwwwwwwwwwww;
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww * 2) - 1) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    }
                }
            }
        }
    }

    @Override // me.tvspark.AbstractC2333lh, me.tvspark.AbstractC2660u5
    public void flush() {
        super.flush();
        this.Wwwwwwwwwwwwwwwwwwwwwww = null;
        this.Wwwwwwwwwwwwwwwwwwwwww = null;
        this.Wwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwww[0];
        Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwww = null;
    }
}
