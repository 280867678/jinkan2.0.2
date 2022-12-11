package me.tvspark;

import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.smtt.sdk.TbsListener;
import java.util.Arrays;
import java.util.Collections;
import me.tvspark.AbstractC2327lb;
import me.tvspark.C2245j3;

/* renamed from: me.tvspark.ta */
/* loaded from: classes4.dex */
public final class C2628ta implements AbstractC2554ra {
    public static final float[] Wwwwwwwwwwwwwwwwwwwwwww = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};
    public long Wwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwww;
    public AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final C2854za Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final C2364mb Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final boolean[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new boolean[4];
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(128);

    /* renamed from: me.tvspark.ta$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public long Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        public long Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2740w7 abstractC2740w7) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2740w7;
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, int i2) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i4 = (i + 1) - i3;
                if (i4 >= i2) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = (i2 - i) + i3;
                    return;
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ((bArr[i4] & ExifInterface.MARKER_SOF0) >> 6) == 0;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
            }
        }
    }

    /* renamed from: me.tvspark.ta$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public static final byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = {0, 0, 1};
        public byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new byte[i];
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, int i2) {
            if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                return;
            }
            int i3 = i2 - i;
            byte[] bArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int length = bArr2.length;
            int i4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (length < i4 + i3) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Arrays.copyOf(bArr2, (i4 + i3) * 2);
            }
            System.arraycopy(bArr, i, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i3);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i3;
        }
    }

    public C2628ta(@Nullable C2364mb c2364mb) {
        C2078el c2078el;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2364mb;
        if (c2364mb != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2854za(178, 128);
            c2078el = new C2078el();
        } else {
            c2078el = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el;
    }

    @Override // me.tvspark.AbstractC2554ra
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
    }

    @Override // me.tvspark.AbstractC2554ra
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = j;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0257  */
    @Override // me.tvspark.AbstractC2554ra
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el) {
        long j;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i;
        byte[] bArr;
        long j2;
        int i2;
        int i3;
        boolean z;
        float f;
        float f2;
        int i4;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwww);
        int i5 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i6 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        byte[] bArr2 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww += c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el, c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        while (true) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C1987cl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr2, i5, i6, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == i6) {
                if (!this.Wwwwwwwwwwwwwwwwwwwwwwwww) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr2, i5, i6);
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr2, i5, i6);
                C2854za c2854za = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (c2854za == null) {
                    return;
                }
                c2854za.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr2, i5, i6);
                return;
            }
            int i7 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 + 3;
            int i8 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i7] & 255;
            int i9 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 - i5;
            if (!this.Wwwwwwwwwwwwwwwwwwwwwwwww) {
                if (i9 > 0) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr2, i5, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                }
                int i10 = i9 < 0 ? -i9 : 0;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i11 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (i11 != 0) {
                    if (i11 == 1) {
                        if (i8 == 181) {
                            i4 = 2;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i4;
                        }
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    } else if (i11 == 2) {
                        if (i8 <= 31) {
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 3;
                        }
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    } else if (i11 == 3) {
                        if ((i8 & TbsListener.ErrorCode.TPATCH_VERSION_FAILED) == 32) {
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            i4 = 4;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i4;
                        }
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    } else if (i11 != 4) {
                        throw new IllegalStateException();
                    } else {
                        if (i8 == 179 || i8 == 181) {
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww -= i10;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
                            z = true;
                            if (z) {
                                AbstractC2740w7 abstractC2740w7 = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                int i12 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                String str = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
                                String str2 = str;
                                byte[] copyOf = Arrays.copyOf(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                C2041dl c2041dl = new C2041dl(copyOf);
                                c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i12);
                                c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                                c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                                if (c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                    c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                                    c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
                                }
                                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == 15) {
                                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 != 0) {
                                        f = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 / Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5;
                                        f2 = f;
                                    }
                                    f2 = 1.0f;
                                } else {
                                    float[] fArr = Wwwwwwwwwwwwwwwwwwwwwww;
                                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 < fArr.length) {
                                        f = fArr[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3];
                                        f2 = f;
                                    }
                                    f2 = 1.0f;
                                }
                                if (c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                    c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                                    c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                                    if (c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                        c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(15);
                                        c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                        c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(15);
                                        c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                        c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(15);
                                        c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                        c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
                                        c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(11);
                                        c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                        c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(15);
                                        c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                    }
                                }
                                c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                                c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16);
                                c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                if (c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 != 0) {
                                    int i13 = 0;
                                    for (int i14 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 - 1; i14 > 0; i14 >>= 1) {
                                        i13++;
                                    }
                                    c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i13);
                                }
                                c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(13);
                                c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(13);
                                c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str2;
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwww = "video/mp4v-es";
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7;
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8;
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwww = f2;
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwww = Collections.singletonList(copyOf);
                                abstractC2740w7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                                this.Wwwwwwwwwwwwwwwwwwwwwwwww = true;
                            }
                        }
                    }
                } else if (i8 == 176) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                }
                byte[] bArr3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr3, 0, bArr3.length);
                z = false;
                if (z) {
                }
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr2, i5, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            C2854za c2854za2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (c2854za2 != null) {
                if (i9 > 0) {
                    c2854za2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr2, i5, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                    i3 = 0;
                } else {
                    i3 = -i9;
                }
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3)) {
                    C2854za c2854za3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 = C1987cl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2854za3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2854za3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    C2078el c2078el2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el2);
                    c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9);
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
                if (i8 == 178) {
                    if (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 + 2] == 1) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i8);
                    }
                    int i15 = i6 - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                    j = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww - i15;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    boolean z2 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 182 || !z2 || !wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        i = i6;
                        bArr = bArr2;
                        j2 = j;
                        i2 = 182;
                    } else {
                        i = i6;
                        bArr = bArr2;
                        j2 = j;
                        i2 = 182;
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ? 1 : 0, (int) (j - wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww), i15, null);
                    }
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 179) {
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = j2;
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    long j3 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i8;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i8 != i2 || i8 == 179;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i8 != i2;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwww = j3;
                    i5 = i7;
                    i6 = i;
                    bArr2 = bArr;
                }
            }
            int i152 = i6 - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            j = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww - i152;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            boolean z22 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 182) {
            }
            i = i6;
            bArr = bArr2;
            j2 = j;
            i2 = 182;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 179) {
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww32 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            long j32 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i8;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i8 != i2 || i8 == 179;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i8 != i2;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww32.Wwwwwwwwwwwwwwwwwwwwwwwwwww = j32;
            i5 = i7;
            i6 = i;
            bArr2 = bArr;
        }
    }

    @Override // me.tvspark.AbstractC2554ra
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2249j7 abstractC2249j7, AbstractC2327lb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = abstractC2249j7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), 2);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        C2364mb c2364mb = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (c2364mb != null) {
            c2364mb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2249j7, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    @Override // me.tvspark.AbstractC2554ra
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        C1987cl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
        }
        C2854za c2854za = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (c2854za != null) {
            c2854za.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 0L;
    }
}
