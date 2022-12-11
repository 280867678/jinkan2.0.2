package me.tvspark;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public class Kkkk {
    public Kkkkk Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public ByteBuffer Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new byte[256];
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        do {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.position(Math.min(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.position() + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.limit()));
        } while (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > 0);
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getShort();
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > 0) {
            int i = 0;
            while (i < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                try {
                    int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - i;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i, i2);
                    i += i2;
                } catch (Exception unused) {
                    Log.isLoggable("GifHeaderParser", 3);
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
                    return;
                }
            }
        }
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        try {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get() & 255;
        } catch (Exception unused) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
            return 0;
        }
    }

    @NonNull
    public Kkkkk Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                sb.append((char) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            }
            if (!sb.toString().startsWith("GIF")) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
            } else {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() & 128) != 0;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww = (int) Math.pow(2.0d, (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 7) + 1);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww && !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    Kkkkk kkkkk = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    kkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(kkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwww);
                    Kkkkk kkkkk2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    kkkkk2.Wwwwwwwwwwwwwwwwwwwwwww = kkkkk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[kkkkk2.Wwwwwwwwwwwwwwwwwwwwwwwww];
                }
            }
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                boolean z = false;
                while (!z && !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww <= Integer.MAX_VALUE) {
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 33) {
                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != 1) {
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == 249) {
                                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Kkkkkk();
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                Kkkkkk kkkkkk = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                int i2 = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 & 28) >> 2;
                                kkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
                                if (i2 == 0) {
                                    kkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
                                }
                                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 & 1) != 0;
                                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 2) {
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 10;
                                }
                                Kkkkkk kkkkkk2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                kkkkkk2.Wwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww * 10;
                                kkkkkk2.Wwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != 254 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == 255) {
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                StringBuilder sb2 = new StringBuilder();
                                for (int i3 = 0; i3 < 11; i3++) {
                                    sb2.append((char) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i3]);
                                }
                                if (sb2.toString().equals("NETSCAPE2.0")) {
                                    do {
                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                        byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                        if (bArr[0] == 1) {
                                            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
                                        }
                                        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > 0) {
                                        }
                                    } while (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                                }
                            }
                        }
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 44) {
                        Kkkkk kkkkk3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (kkkkk3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                            kkkkk3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Kkkkkk();
                        }
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        boolean z2 = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 & 128) != 0;
                        int pow = (int) Math.pow(2.0d, (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 & 7) + 1);
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 & 64) != 0;
                        Kkkkkk kkkkkk3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (z2) {
                            kkkkkk3.Wwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(pow);
                        } else {
                            kkkkkk3.Wwwwwwwwwwwwwwwwwwwwwwww = null;
                        }
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.position();
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                            Kkkkk kkkkk4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            kkkkk4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
                            kkkkk4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(kkkkk4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        }
                    } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != 59) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
                    } else {
                        z = true;
                    }
                }
                Kkkkk kkkkk5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (kkkkk5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 0) {
                    kkkkk5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
                }
            }
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        throw new IllegalStateException("You must call setData() before parseHeader()");
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 0;
    }

    @Nullable
    public final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        byte[] bArr = new byte[i * 3];
        int[] iArr = null;
        try {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = i3 + 1;
                int i5 = i4 + 1;
                int i6 = i5 + 1;
                int i7 = i2 + 1;
                iArr[i2] = ((bArr[i3] & 255) << 16) | (-16777216) | ((bArr[i4] & 255) << 8) | (bArr[i5] & 255);
                i3 = i6;
                i2 = i7;
            }
        } catch (BufferUnderflowException unused) {
            Log.isLoggable("GifHeaderParser", 3);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
        }
        return iArr;
    }
}
