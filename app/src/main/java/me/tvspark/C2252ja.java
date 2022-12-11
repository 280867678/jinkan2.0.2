package me.tvspark;

import androidx.annotation.Nullable;
import me.tvspark.AbstractC2327lb;
import me.tvspark.C2245j3;
import org.apache.commons.lang3.time.StopWatch;

/* renamed from: me.tvspark.ja */
/* loaded from: classes4.dex */
public final class C2252ja implements AbstractC2554ra {
    public long Wwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwww;
    public C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
    public AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2041dl Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2252ja(@Nullable String str) {
        C2041dl c2041dl = new C2041dl(new byte[128]);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2041dl;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2078el(c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
    }

    @Override // me.tvspark.AbstractC2554ra
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
    }

    @Override // me.tvspark.AbstractC2554ra
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = false;
    }

    @Override // me.tvspark.AbstractC2554ra
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x035a, code lost:
        if (r23.Wwwwwwwwwwwwwwwwwwwwww() == 11) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x036c, code lost:
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x036a, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0368, code lost:
        if (r2 == 11) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0209  */
    @Override // me.tvspark.AbstractC2554ra
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el) {
        int i;
        int i2;
        int i3;
        String str;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        boolean z;
        boolean z2;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        while (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() > 0) {
            int i13 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i13 == 0) {
                while (true) {
                    if (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() <= 0) {
                        z = false;
                        break;
                    }
                    if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        int Wwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
                        if (Wwwwwwwwwwwwwwwwwwwwww == 119) {
                            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = false;
                            z = true;
                            break;
                        }
                    }
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = z2;
                }
                if (z) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
                    byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    bArr[0] = 11;
                    bArr[1] = 119;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 2;
                }
            } else if (i13 == 1) {
                byte[] bArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int min = Math.min(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), 128 - this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
                System.arraycopy(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr2, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, min);
                c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += min;
                int i14 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww + min;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i14;
                if (i14 == 128) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                    C2041dl c2041dl = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(40);
                    boolean z3 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(5) > 10;
                    c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    int i15 = -1;
                    if (z3) {
                        c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16);
                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0) {
                            i15 = 0;
                        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 1) {
                            i15 = 1;
                        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 2) {
                            i15 = 2;
                        }
                        c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
                        i4 = (c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(11) + 1) * 2;
                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 3) {
                            i7 = C2774x4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2)];
                            i6 = 6;
                            i5 = 3;
                        } else {
                            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                            i5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                            i6 = C2774x4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3];
                            i7 = C2774x4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2];
                        }
                        i3 = i6 * 256;
                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
                        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        i2 = C2774x4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4] + (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww ? 1 : 0);
                        c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(10);
                        if (c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                            c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                        }
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 == 0) {
                            c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(5);
                            if (c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                            }
                        }
                        if (i15 == 1 && c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                            c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16);
                        }
                        if (c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 > 2) {
                                c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                            }
                            if ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 & 1) == 0 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 <= 2) {
                                i10 = 6;
                            } else {
                                i10 = 6;
                                c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(6);
                            }
                            if ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 & 4) != 0) {
                                c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i10);
                            }
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww && c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(5);
                            }
                            if (i15 == 0) {
                                if (c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                    i11 = 6;
                                    c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(6);
                                } else {
                                    i11 = 6;
                                }
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 == 0 && c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                    c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i11);
                                }
                                if (c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                    c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i11);
                                }
                                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 == 1) {
                                    c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(5);
                                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 == 2) {
                                    c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(12);
                                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 == 3) {
                                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(5);
                                    if (c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                        c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(5);
                                        if (c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                            c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                                        }
                                        if (c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                            c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                                        }
                                        if (c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                            c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                                        }
                                        if (c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                            c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                                        }
                                        if (c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                            c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                                        }
                                        if (c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                            c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                                        }
                                        if (c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                            c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                                        }
                                        if (c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                            if (c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                                c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                                            }
                                            if (c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                                c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                                            }
                                        }
                                    }
                                    if (c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                        c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(5);
                                        if (c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                            c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(7);
                                            if (c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                                c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                                                i12 = 2;
                                                c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 + 2) * 8);
                                                c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 < i12) {
                                                    if (c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                                        c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(14);
                                                    }
                                                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 == 0 && c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                                        c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(14);
                                                    }
                                                }
                                                if (c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                                    if (i5 == 0) {
                                                        c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(5);
                                                    } else {
                                                        for (int i16 = 0; i16 < i6; i16++) {
                                                            if (c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                                                c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(5);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i12 = 2;
                                    c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 + 2) * 8);
                                    c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 < i12) {
                                    }
                                    if (c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                    }
                                }
                                i12 = 2;
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 < i12) {
                                }
                                if (c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                }
                            }
                        }
                        if (c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                            c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(5);
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 == 2) {
                                c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                            }
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 >= 6) {
                                c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                            }
                            if (c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                i9 = 8;
                                c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                            } else {
                                i9 = 8;
                            }
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 == 0 && c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i9);
                            }
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 < 3) {
                                c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            }
                        }
                        if (i15 == 0 && i5 != 3) {
                            c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        }
                        if (i15 != 2 || (i5 != 3 && !c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww())) {
                            i8 = 6;
                        } else {
                            i8 = 6;
                            c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(6);
                        }
                        str = (c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() && c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i8) == 1 && c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8) == 1) ? "audio/eac3-joc" : "audio/eac3";
                        i15 = i7;
                    } else {
                        c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(32);
                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                        String str2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 == 3 ? null : "audio/ac3";
                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 = C2774x4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7, c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(6));
                        c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
                        if ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 & 1) == 0 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 == 1) {
                            i = 2;
                        } else {
                            i = 2;
                            c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                        }
                        if ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 & 4) != 0) {
                            c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
                        }
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 == i) {
                            c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
                        }
                        int[] iArr = C2774x4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 < iArr.length) {
                            i15 = iArr[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7];
                        }
                        i2 = C2774x4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9] + (c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() ? 1 : 0);
                        i3 = 1536;
                        str = str2;
                        i4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8;
                    }
                    int i17 = i2;
                    C2245j3 c2245j3 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
                    if (c2245j3 == null || i17 != c2245j3.Kkkkkkkkkkkkkkkkkkkkkkkk || i15 != c2245j3.Kkkkkkkkkkkkkkkkkkkkkkk || !C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str, (Object) c2245j3.Wwwwwwwwwwwww)) {
                        C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = str;
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwww = i17;
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwww = i15;
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        this.Wwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10;
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10);
                    }
                    this.Wwwwwwwwwwwwwwwwwwwwwwww = i4;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwww = (i3 * StopWatch.NANO_2_MILLIS) / this.Wwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkkkkkkkkkkkkkkkk;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 128);
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 2;
                }
            } else if (i13 == 2) {
                int min2 = Math.min(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), this.Wwwwwwwwwwwwwwwwwwwwwwww - this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el, min2);
                int i18 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww + min2;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i18;
                int i19 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                if (i18 == i19) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, 1, i19, 0, null);
                    this.Wwwwwwwwwwwwwwwwwwwwwww += this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
                }
            }
        }
    }

    @Override // me.tvspark.AbstractC2554ra
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2249j7 abstractC2249j7, AbstractC2327lb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2249j7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), 1);
    }
}
