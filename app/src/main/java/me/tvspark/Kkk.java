package me.tvspark;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
import me.tvspark.Kkkkkkk;

/* loaded from: classes4.dex */
public class Kkk implements Kkkkkkk {
    @Nullable
    public Boolean Wwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwww;
    public Bitmap Wwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwww;
    @ColorInt
    public int[] Wwwwwwwwwwwwwwwwwwwwwwwww;
    public byte[] Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public short[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public ByteBuffer Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Kkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @ColorInt
    public int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @ColorInt
    public final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new int[256];
    @NonNull
    public Bitmap.Config Wwwwwwwwwwwwwww = Bitmap.Config.ARGB_8888;
    public Kkkkk Wwwwwwwwwwwwwwwwwwwwwww = new Kkkkk();

    public Kkk(@NonNull Kkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Kkkkk kkkkk, ByteBuffer byteBuffer, int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(kkkkk, byteBuffer, i);
    }

    public final Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwww() {
        Boolean bool = this.Wwwwwwwwwwwwwwww;
        Bitmap.Config config = (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.Wwwwwwwwwwwwwww;
        Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ((tooSimple) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwww, config);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setHasAlpha(true);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.Kkkkkkk
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return (this.Wwwwwwwwwwwwwwwwwwwwwwwww.length * 4) + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.limit() + this.Wwwwwwwwwwwwwwwwwwwwwwwwww.length;
    }

    @Override // me.tvspark.Kkkkkkk
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.Kkkkkkk
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = -1;
    }

    @Override // me.tvspark.Kkkkkkk
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i;
        Kkkkk kkkkk = this.Wwwwwwwwwwwwwwwwwwwwwww;
        int i2 = kkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i2 <= 0 || (i = this.Wwwwwwwwwwwwwwwwwwwwwwww) < 0) {
            return 0;
        }
        if (i >= 0 && i < i2) {
            return kkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i).Wwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return -1;
    }

    @Override // me.tvspark.Kkkkkkk
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.Kkkkkkk
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = (this.Wwwwwwwwwwwwwwwwwwwwwwww + 1) % this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.Kkkkkkk
    @Nullable
    public synchronized Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww <= 0 || this.Wwwwwwwwwwwwwwwwwwwwwwww < 0) {
            if (Log.isLoggable("Kkk", 3)) {
                int i = this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            this.Wwwwwwwwwwwwwwwwwwww = 1;
        }
        if (this.Wwwwwwwwwwwwwwwwwwww != 1 && this.Wwwwwwwwwwwwwwwwwwww != 2) {
            this.Wwwwwwwwwwwwwwwwwwww = 0;
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ((tooSimple) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(255);
            }
            Kkkkkk kkkkkk = this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwww - 1;
            Kkkkkk kkkkkk2 = i2 >= 0 ? this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i2) : null;
            int[] iArr = kkkkkk.Wwwwwwwwwwwwwwwwwwwwwwww != null ? kkkkkk.Wwwwwwwwwwwwwwwwwwwwwwww : this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iArr;
            if (iArr == null) {
                Log.isLoggable("Kkk", 3);
                this.Wwwwwwwwwwwwwwwwwwww = 1;
                return null;
            }
            if (kkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                System.arraycopy(iArr, 0, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, iArr.length);
                int[] iArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iArr2;
                iArr2[kkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwww] = 0;
                if (kkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwww == 2 && this.Wwwwwwwwwwwwwwwwwwwwwwww == 0) {
                    this.Wwwwwwwwwwwwwwww = true;
                }
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(kkkkkk, kkkkkk2);
        }
        Log.isLoggable("Kkk", 3);
        return null;
    }

    @Override // me.tvspark.Kkkkkkk
    @NonNull
    public ByteBuffer Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.Kkkkkkk
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888 || config == Bitmap.Config.RGB_565) {
            this.Wwwwwwwwwwwwwww = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
    }

    public synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Kkkkk kkkkk, @NonNull ByteBuffer byteBuffer, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
        }
        int highestOneBit = Integer.highestOneBit(i);
        this.Wwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwww = kkkkk;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = -1;
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.order(ByteOrder.LITTLE_ENDIAN);
        this.Wwwwwwwwwwwwwwwwwwwww = false;
        Iterator<Kkkkkk> it = kkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().Wwwwwwwwwwwwwwwwwwwwwwwwwwww == 3) {
                    this.Wwwwwwwwwwwwwwwwwwwww = true;
                    break;
                }
            } else {
                break;
            }
        }
        this.Wwwwwwwwwwwwwwwwwww = highestOneBit;
        this.Wwwwwwwwwwwwwwwww = kkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww / highestOneBit;
        this.Wwwwwwwwwwwwwwwwww = kkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwww / highestOneBit;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = ((tooSimple) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(kkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww * kkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Kkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = this.Wwwwwwwwwwwwwwwww * this.Wwwwwwwwwwwwwwwwww;
        OO000 oo000 = ((tooSimple) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwww = oo000 == null ? new int[i2] : (int[]) oo000.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, int[].class);
    }

    @Override // me.tvspark.Kkkkkkk
    public void clear() {
        OO000 oo000;
        OO000 oo0002;
        OO000 oo0003;
        this.Wwwwwwwwwwwwwwwwwwwwwww = null;
        byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        if (bArr != null && (oo0003 = ((tooSimple) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) != null) {
            oo0003.put(bArr);
        }
        int[] iArr = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
        if (iArr != null && (oo0002 = ((tooSimple) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) != null) {
            oo0002.put(iArr);
        }
        Bitmap bitmap = this.Wwwwwwwwwwwwwwwwwwwwww;
        if (bitmap != null) {
            ((tooSimple) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bitmap);
        }
        this.Wwwwwwwwwwwwwwwwwwwwww = null;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        this.Wwwwwwwwwwwwwwww = null;
        byte[] bArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (bArr2 == null || (oo000 = ((tooSimple) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) == null) {
            return;
        }
        oo000.put(bArr2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0045, code lost:
        if (r3.Wwwwwwwwwwwwwwwwwwwwwwwww == r34.Wwwwwwwwwwwwwwwwwwwwwwwwwww) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0424  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Kkkkkk kkkkkk, Kkkkkk kkkkkk2) {
        int i;
        int i2;
        int[] iArr;
        Kkk kkk;
        Boolean bool;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        short s;
        byte[] bArr;
        byte[] bArr2;
        int i15;
        Kkk kkk2;
        short s2;
        int i16;
        Bitmap bitmap;
        int i17;
        int i18;
        int i19;
        int[] iArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
        if (kkkkkk2 == null) {
            Bitmap bitmap2 = this.Wwwwwwwwwwwwwwwwwwwwww;
            if (bitmap2 != null) {
                ((tooSimple) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bitmap2);
            }
            this.Wwwwwwwwwwwwwwwwwwwwww = null;
            Arrays.fill(iArr2, 0);
        }
        if (kkkkkk2 != null && kkkkkk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww == 3 && this.Wwwwwwwwwwwwwwwwwwwwww == null) {
            Arrays.fill(iArr2, 0);
        }
        if (kkkkkk2 != null && (i16 = kkkkkk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) > 0) {
            if (i16 == 2) {
                if (!kkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    Kkkkk kkkkk = this.Wwwwwwwwwwwwwwwwwwwwwww;
                    i17 = kkkkk.Wwwwwwwwwwwwwwwwwwwwwww;
                    if (kkkkkk.Wwwwwwwwwwwwwwwwwwwwwwww != null) {
                    }
                    int i20 = kkkkkk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int i21 = this.Wwwwwwwwwwwwwwwwwww;
                    int i22 = i20 / i21;
                    int i23 = kkkkkk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww / i21;
                    int i24 = kkkkkk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww / i21;
                    int i25 = kkkkkk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww / i21;
                    int i26 = this.Wwwwwwwwwwwwwwwww;
                    i18 = (i23 * i26) + i25;
                    i19 = (i22 * i26) + i18;
                    while (i18 < i19) {
                        int i27 = i18 + i24;
                        for (int i28 = i18; i28 < i27; i28++) {
                            iArr2[i28] = i17;
                        }
                        i18 += this.Wwwwwwwwwwwwwwwww;
                    }
                }
                i17 = 0;
                int i202 = kkkkkk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i212 = this.Wwwwwwwwwwwwwwwwwww;
                int i222 = i202 / i212;
                int i232 = kkkkkk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww / i212;
                int i242 = kkkkkk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww / i212;
                int i252 = kkkkkk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww / i212;
                int i262 = this.Wwwwwwwwwwwwwwwww;
                i18 = (i232 * i262) + i252;
                i19 = (i222 * i262) + i18;
                while (i18 < i19) {
                }
            } else if (i16 == 3 && (bitmap = this.Wwwwwwwwwwwwwwwwwwwwww) != null) {
                int i29 = this.Wwwwwwwwwwwwwwwww;
                bitmap.getPixels(iArr2, 0, i29, 0, 0, i29, this.Wwwwwwwwwwwwwwwwww);
            }
        }
        if (kkkkkk != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.position(kkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwww);
        }
        if (kkkkkk == null) {
            Kkkkk kkkkk2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
            i = kkkkk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            i2 = kkkkk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        } else {
            i = kkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            i2 = kkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        int i30 = i * i2;
        byte[] bArr3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        if (bArr3 == null || bArr3.length < i30) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = ((tooSimple) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i30);
        }
        byte[] bArr4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new short[4096];
        }
        short[] sArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new byte[4096];
        }
        byte[] bArr5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = new byte[4097];
        }
        byte[] bArr6 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i31 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get() & 255;
        int i32 = 1 << i31;
        int i33 = i32 + 1;
        int i34 = i32 + 2;
        int i35 = i31 + 1;
        int i36 = (1 << i35) - 1;
        for (int i37 = 0; i37 < i32; i37++) {
            sArr[i37] = 0;
            bArr5[i37] = (byte) i37;
        }
        byte[] bArr7 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i38 = 0;
        short s3 = -1;
        int i39 = 0;
        int i40 = 0;
        int i41 = 0;
        int i42 = 0;
        int i43 = 0;
        int i44 = 0;
        int i45 = i35;
        int i46 = i36;
        int i47 = i34;
        int i48 = 0;
        Kkk kkk3 = this;
        while (true) {
            if (i38 >= i30) {
                iArr = iArr2;
                break;
            }
            if (i39 == 0) {
                i13 = i34;
                int i49 = kkk3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get() & 255;
                if (i49 <= 0) {
                    iArr = iArr2;
                    i14 = i38;
                    s = s3;
                } else {
                    i14 = i38;
                    ByteBuffer byteBuffer = kkk3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    s = s3;
                    iArr = iArr2;
                    byteBuffer.get(kkk3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, Math.min(i49, byteBuffer.remaining()));
                }
                if (i49 <= 0) {
                    kkk3.Wwwwwwwwwwwwwwwwwwww = 3;
                    break;
                }
                i40 = 0;
                i39 = i49;
            } else {
                iArr = iArr2;
                i13 = i34;
                i14 = i38;
                s = s3;
            }
            i42 += (bArr7[i40] & 255) << i41;
            i40++;
            i39--;
            int i50 = i41 + 8;
            int i51 = i43;
            int i52 = i47;
            i38 = i14;
            s3 = s;
            Kkk kkk4 = kkk3;
            int i53 = i45;
            while (true) {
                if (i50 < i53) {
                    bArr = bArr6;
                    bArr2 = bArr7;
                    kkk4 = this;
                    break;
                }
                bArr2 = bArr7;
                int i54 = i42 & i46;
                i42 >>= i53;
                i50 -= i53;
                if (i54 == i32) {
                    i53 = i35;
                    i46 = i36;
                    i52 = i13;
                    s3 = -1;
                    Kkk kkk5 = kkk4;
                    i15 = i50;
                    kkk2 = kkk5;
                } else if (i54 == i33) {
                    bArr = bArr6;
                    break;
                } else {
                    i15 = i50;
                    if (s3 == -1) {
                        bArr4[i48] = bArr5[i54];
                        i48++;
                        i38++;
                        kkk2 = this;
                        i51 = i54;
                        s3 = i51;
                    } else {
                        if (i54 >= i52) {
                            bArr6[i44] = (byte) i51;
                            i44++;
                            s2 = s3;
                        } else {
                            s2 = i54;
                        }
                        while (s2 >= i32) {
                            bArr6[i44] = bArr5[s2];
                            i44++;
                            s2 = sArr[s2];
                        }
                        i51 = bArr5[s2] & 255;
                        byte b = (byte) i51;
                        bArr4[i48] = b;
                        while (true) {
                            i48++;
                            i38++;
                            if (i44 <= 0) {
                                break;
                            }
                            i44--;
                            bArr4[i48] = bArr6[i44];
                        }
                        byte[] bArr8 = bArr6;
                        if (i52 < 4096) {
                            sArr[i52] = s3;
                            bArr5[i52] = b;
                            i52++;
                            if ((i52 & i46) == 0 && i52 < 4096) {
                                i53++;
                                i46 += i52;
                            }
                        }
                        s3 = i54;
                        i50 = i15;
                        bArr7 = bArr2;
                        bArr6 = bArr8;
                        kkk4 = this;
                    }
                }
                bArr7 = bArr2;
                int i55 = i15;
                kkk4 = kkk2;
                i50 = i55;
            }
            i45 = i53;
            kkk3 = kkk4;
            bArr7 = bArr2;
            bArr6 = bArr;
            i41 = i50;
            i43 = i51;
            i47 = i52;
            i34 = i13;
            iArr2 = iArr;
        }
        Arrays.fill(bArr4, i48, i30, (byte) 0);
        if (!kkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            kkk = this;
            if (kkk.Wwwwwwwwwwwwwwwwwww == 1) {
                int[] iArr3 = kkk.Wwwwwwwwwwwwwwwwwwwwwwwww;
                int i56 = kkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i57 = kkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i58 = kkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i59 = kkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                boolean z = kkk.Wwwwwwwwwwwwwwwwwwwwwwww == 0;
                int i60 = kkk.Wwwwwwwwwwwwwwwww;
                byte[] bArr9 = kkk.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                int[] iArr4 = kkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                byte b2 = -1;
                for (int i61 = 0; i61 < i56; i61++) {
                    int i62 = (i61 + i57) * i60;
                    int i63 = i62 + i59;
                    int i64 = i63 + i58;
                    int i65 = i62 + i60;
                    if (i65 < i64) {
                        i64 = i65;
                    }
                    int i66 = kkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww * i61;
                    while (true) {
                        int i67 = i56;
                        if (i63 < i64) {
                            byte b3 = bArr9[i66];
                            int i68 = i57;
                            int i69 = b3 & 255;
                            if (i69 != b2) {
                                int i70 = iArr4[i69];
                                if (i70 != 0) {
                                    iArr3[i63] = i70;
                                } else {
                                    b2 = b3;
                                }
                            }
                            i66++;
                            i63++;
                            i56 = i67;
                            i57 = i68;
                        }
                    }
                }
                Boolean bool2 = kkk.Wwwwwwwwwwwwwwww;
                kkk.Wwwwwwwwwwwwwwww = Boolean.valueOf((bool2 != null && bool2.booleanValue()) || (kkk.Wwwwwwwwwwwwwwww == null && z && b2 != -1));
                if (kkk.Wwwwwwwwwwwwwwwwwwwww && ((i12 = kkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) == 0 || i12 == 1)) {
                    if (kkk.Wwwwwwwwwwwwwwwwwwwwww == null) {
                        kkk.Wwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwww();
                    }
                    Bitmap bitmap3 = kkk.Wwwwwwwwwwwwwwwwwwwwww;
                    int i71 = kkk.Wwwwwwwwwwwwwwwww;
                    bitmap3.setPixels(iArr, 0, i71, 0, 0, i71, kkk.Wwwwwwwwwwwwwwwwww);
                }
                Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwww();
                int i72 = kkk.Wwwwwwwwwwwwwwwww;
                Wwwwwwwwwwwwwwwwwwwwwwwwww.setPixels(iArr, 0, i72, 0, 0, i72, kkk.Wwwwwwwwwwwwwwwwww);
                return Wwwwwwwwwwwwwwwwwwwwwwwwww;
            }
        } else {
            kkk = this;
        }
        int[] iArr5 = kkk.Wwwwwwwwwwwwwwwwwwwwwwwww;
        int i73 = kkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i74 = kkk.Wwwwwwwwwwwwwwwwwww;
        int i75 = i73 / i74;
        int i76 = kkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww / i74;
        int i77 = kkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww / i74;
        int i78 = kkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww / i74;
        boolean z2 = kkk.Wwwwwwwwwwwwwwwwwwwwwwww == 0;
        int i79 = kkk.Wwwwwwwwwwwwwwwwwww;
        int i80 = kkk.Wwwwwwwwwwwwwwwww;
        int i81 = kkk.Wwwwwwwwwwwwwwwwww;
        byte[] bArr10 = kkk.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        int[] iArr6 = kkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Boolean bool3 = kkk.Wwwwwwwwwwwwwwww;
        int i82 = 0;
        int i83 = 1;
        int i84 = 8;
        int i85 = 0;
        while (true) {
            bool = bool3;
            if (i85 >= i75) {
                break;
            }
            if (kkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                if (i82 >= i75) {
                    int i86 = i83 + 1;
                    i3 = i75;
                    if (i86 == 2) {
                        i82 = 4;
                    } else if (i86 == 3) {
                        i82 = 2;
                        i84 = 4;
                    } else if (i86 == 4) {
                        i82 = 1;
                        i84 = 2;
                    }
                    i83 = i86;
                } else {
                    i3 = i75;
                }
                i4 = i82 + i84;
            } else {
                i3 = i75;
                i4 = i82;
                i82 = i85;
            }
            int i87 = i82 + i76;
            boolean z3 = i79 == 1;
            if (i87 < i81) {
                int i88 = i87 * i80;
                int i89 = i88 + i78;
                i5 = i4;
                int i90 = i89 + i77;
                int i91 = i88 + i80;
                if (i91 < i90) {
                    i90 = i91;
                }
                i6 = i76;
                int i92 = i85 * i79 * kkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (z3) {
                    bool3 = bool;
                    int i93 = i89;
                    while (true) {
                        i7 = i77;
                        if (i93 >= i90) {
                            break;
                        }
                        int i94 = iArr6[bArr10[i92] & 255];
                        if (i94 != 0) {
                            iArr5[i93] = i94;
                        } else if (z2 && bool3 == null) {
                            bool3 = true;
                        }
                        i92 += i79;
                        i93++;
                        i77 = i7;
                    }
                } else {
                    i7 = i77;
                    int i95 = ((i90 - i89) * i79) + i92;
                    bool3 = bool;
                    int i96 = i89;
                    while (i96 < i90) {
                        int i97 = i90;
                        int i98 = kkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        int i99 = 0;
                        int i100 = 0;
                        int i101 = 0;
                        int i102 = 0;
                        int i103 = 0;
                        int i104 = i78;
                        int i105 = i80;
                        int i106 = i92;
                        while (true) {
                            if (i106 >= kkk.Wwwwwwwwwwwwwwwwwww + i92) {
                                i11 = i81;
                                break;
                            }
                            byte[] bArr11 = kkk.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                            i11 = i81;
                            if (i106 >= bArr11.length || i106 >= i95) {
                                break;
                            }
                            int i107 = kkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[bArr11[i106] & 255];
                            if (i107 != 0) {
                                i99 += (i107 >> 24) & 255;
                                i100 += (i107 >> 16) & 255;
                                i101 += (i107 >> 8) & 255;
                                i102 += i107 & 255;
                                i103++;
                            }
                            i106++;
                            i81 = i11;
                        }
                        int i108 = i98 + i92;
                        for (int i109 = i108; i109 < kkk.Wwwwwwwwwwwwwwwwwww + i108; i109++) {
                            byte[] bArr12 = kkk.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                            if (i109 >= bArr12.length || i109 >= i95) {
                                break;
                            }
                            int i110 = kkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[bArr12[i109] & 255];
                            if (i110 != 0) {
                                i99 += (i110 >> 24) & 255;
                                i100 += (i110 >> 16) & 255;
                                i101 += (i110 >> 8) & 255;
                                i102 += i110 & 255;
                                i103++;
                            }
                        }
                        int i111 = i103 == 0 ? 0 : ((i99 / i103) << 24) | ((i100 / i103) << 16) | ((i101 / i103) << 8) | (i102 / i103);
                        if (i111 != 0) {
                            iArr5[i96] = i111;
                        } else if (z2 && bool3 == null) {
                            bool3 = true;
                        }
                        i92 += i79;
                        i96++;
                        i90 = i97;
                        i78 = i104;
                        i80 = i105;
                        i81 = i11;
                    }
                }
                i8 = i78;
                i9 = i80;
                i10 = i81;
            } else {
                i5 = i4;
                i6 = i76;
                i7 = i77;
                i8 = i78;
                i9 = i80;
                i10 = i81;
                bool3 = bool;
            }
            i85++;
            i75 = i3;
            i82 = i5;
            i76 = i6;
            i77 = i7;
            i78 = i8;
            i80 = i9;
            i81 = i10;
        }
        if (kkk.Wwwwwwwwwwwwwwww == null) {
            kkk.Wwwwwwwwwwwwwwww = Boolean.valueOf(bool == null ? false : bool.booleanValue());
        }
        if (kkk.Wwwwwwwwwwwwwwwwwwwww) {
            if (kkk.Wwwwwwwwwwwwwwwwwwwwww == null) {
            }
            Bitmap bitmap32 = kkk.Wwwwwwwwwwwwwwwwwwwwww;
            int i712 = kkk.Wwwwwwwwwwwwwwwww;
            bitmap32.setPixels(iArr, 0, i712, 0, 0, i712, kkk.Wwwwwwwwwwwwwwwwww);
        }
        Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwww();
        int i722 = kkk.Wwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwww2.setPixels(iArr, 0, i722, 0, 0, i722, kkk.Wwwwwwwwwwwwwwwwww);
        return Wwwwwwwwwwwwwwwwwwwwwwwwww2;
    }
}
