package me.tvspark;

import androidx.annotation.Nullable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import org.fourthline.cling.support.model.dlna.DLNAProfiles;

/* renamed from: me.tvspark.id */
/* loaded from: classes4.dex */
public final class C2218id extends AbstractC2519qc {
    public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C1942bd.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.id$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, boolean z, int i2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        }
    }

    /* renamed from: me.tvspark.id$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3, int i4, int i5);
    }

    public C2218id() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
    }

    public C2218id(@Nullable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, int i) {
        byte[] bArr = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i3 = i2;
        while (true) {
            int i4 = i3 + 1;
            if (i4 < i2 + i) {
                if ((bArr[i3] & 255) == 255 && bArr[i4] == 0) {
                    System.arraycopy(bArr, i3 + 2, bArr, i4, (i - (i3 - i2)) - 2);
                    i--;
                }
                i3 = i4;
            } else {
                return i;
            }
        }
    }

    @Nullable
    public static C2440od Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, int i) throws UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int Wwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwww);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        System.arraycopy(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr, 0, i2);
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i2;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, 0, Wwwwwwwwwwwwwwwwwwwwww);
        String str = new String(bArr, 0, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwww) + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
        return new C2440od("WXXX", str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2), "ISO-8859-1"));
    }

    @Nullable
    public static C2403nd Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, int i) throws UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int Wwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwww);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        System.arraycopy(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr, 0, i2);
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i2;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, 0, Wwwwwwwwwwwwwwwwwwwwww);
        String str = new String(bArr, 0, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwww) + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
        return new C2403nd("TXXX", str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwww), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2));
    }

    public static C2366md Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, int i) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i];
        System.arraycopy(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr, 0, i);
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, 0);
        return new C2366md(new String(bArr, 0, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, "ISO-8859-1"), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 + 1, i));
    }

    public static C2329ld Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, int i) {
        int Wwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwww();
        int Wwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwww();
        int Wwwwwwwwwwwwwwwwwwww2 = c2078el.Wwwwwwwwwwwwwwwwwwww();
        int Wwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
        int Wwwwwwwwwwwwwwwwwwwwww2 = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
        C2041dl c2041dl = new C2041dl();
        c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww * 8);
        int i2 = ((i - 10) * 8) / (Wwwwwwwwwwwwwwwwwwwwww + Wwwwwwwwwwwwwwwwwwwwww2);
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwww);
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwww2);
            iArr[i3] = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            iArr2[i3] = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
        }
        return new C2329ld(Wwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwww2, iArr, iArr2);
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i) {
        while (i < bArr.length) {
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
        return bArr.length;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, int i2) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, i);
        if (i2 == 0 || i2 == 3) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        }
        while (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 < bArr.length - 1) {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 % 2 == 0 && bArr[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 + 1] == 0) {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 + 1);
        }
        return bArr.length;
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return i != 1 ? i != 2 ? i != 3 ? "ISO-8859-1" : "UTF-8" : "UTF-16BE" : "UTF-16";
    }

    public static C2107fd Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, int i, int i2, boolean z, int i3, @Nullable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) throws UnsupportedEncodingException {
        int i4 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i4);
        String str = new String(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i4, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 - i4, "ISO-8859-1");
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 + 1);
        int Wwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
        boolean z2 = (Wwwwwwwwwwwwwwwwwwwwww & 2) != 0;
        boolean z3 = (Wwwwwwwwwwwwwwwwwwwwww & 1) != 0;
        int Wwwwwwwwwwwwwwwwwwwwww2 = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
        String[] strArr = new String[Wwwwwwwwwwwwwwwwwwwwww2];
        for (int i5 = 0; i5 < Wwwwwwwwwwwwwwwwwwwwww2; i5++) {
            int i6 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i6);
            strArr[i5] = new String(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i6, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 - i6, "ISO-8859-1");
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i7 = i4 + i;
        while (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < i7) {
            AbstractC2255jd Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, c2078el, z, i3, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
                arrayList.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            }
        }
        return new C2107fd(str, z2, z3, strArr, (AbstractC2255jd[]) arrayList.toArray(new AbstractC2255jd[0]));
    }

    public static /* synthetic */ boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3, int i4, int i5) {
        return false;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3, int i4, int i5) {
        return i == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, int i2, String str) throws UnsupportedEncodingException {
        return (i2 <= i || i2 > bArr.length) ? "" : new String(bArr, i, i2 - i, str);
    }

    public static byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, int i2) {
        return i2 <= i ? C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww : Arrays.copyOfRange(bArr, i, i2);
    }

    @Override // me.tvspark.AbstractC2519qc
    @Nullable
    public C2254jc Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2402nc c2402nc, ByteBuffer byteBuffer) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer.array(), byteBuffer.limit());
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0060, code lost:
        if (((r7 & 64) != 0) != false) goto L73;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ab A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ac  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C2254jc Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        ArrayList arrayList = new ArrayList();
        C2078el c2078el = new C2078el(bArr, i);
        boolean z = false;
        int i2 = 10;
        if (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() >= 10) {
            int Wwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwww();
            if (Wwwwwwwwwwwwwwwwwwww == 4801587) {
                int Wwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
                c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                int Wwwwwwwwwwwwwwwwwwwwww2 = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
                int Wwwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwwww();
                if (Wwwwwwwwwwwwwwwwwwwwww != 2) {
                    if (Wwwwwwwwwwwwwwwwwwwwww == 3) {
                        if ((Wwwwwwwwwwwwwwwwwwwwww2 & 64) != 0) {
                            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            Wwwwwwwwwwwwwwwwwwwwwww -= Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 4;
                        }
                    } else if (Wwwwwwwwwwwwwwwwwwwwww == 4) {
                        if ((Wwwwwwwwwwwwwwwwwwwwww2 & 64) != 0) {
                            int Wwwwwwwwwwwwwwwwwwwwwww2 = c2078el.Wwwwwwwwwwwwwwwwwwwwwww();
                            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwww2 - 4);
                            Wwwwwwwwwwwwwwwwwwwwwww -= Wwwwwwwwwwwwwwwwwwwwwww2;
                        }
                        if ((Wwwwwwwwwwwwwwwwwwwwww2 & 16) != 0) {
                            Wwwwwwwwwwwwwwwwwwwwwww -= 10;
                        }
                    }
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwww < 4 && (Wwwwwwwwwwwwwwwwwwwwww2 & 128) != 0, Wwwwwwwwwwwwwwwwwwwwwww);
                }
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    return null;
                }
                int i3 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 2) {
                    i2 = 6;
                }
                int i4 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    i4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el, i4);
                }
                c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3 + i4);
                if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i2, false)) {
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 4 || !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el, 4, i2, true)) {
                        return null;
                    }
                    z = true;
                }
                while (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() >= i2) {
                    AbstractC2255jd Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2078el, z, i2, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
                        arrayList.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                    }
                }
                return new C2254jc(arrayList);
            }
            String valueOf = String.valueOf(String.format("%06X", Integer.valueOf(Wwwwwwwwwwwwwwwwwwww)));
            if (valueOf.length() != 0) {
                "Unexpected first three bytes of ID3 tag header: 0x".concat(valueOf);
            } else {
                new String("Unexpected first three bytes of ID3 tag header: 0x");
            }
        }
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
        }
    }

    public static C2440od Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, int i, String str) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i];
        System.arraycopy(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr, 0, i);
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i;
        return new C2440od(str, null, new String(bArr, 0, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, 0), "ISO-8859-1"));
    }

    public static C2181hd Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, int i) throws UnsupportedEncodingException {
        int Wwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwww);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        System.arraycopy(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr, 0, i2);
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i2;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, 0);
        String str = new String(bArr, 0, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, "ISO-8859-1");
        int i3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 + 1;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, i3, Wwwwwwwwwwwwwwwwwwwwww);
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, i3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwww) + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwwwwwwwwwwwwww);
        return new C2181hd(str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwww) + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5, i2));
    }

    public static C1979cd Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, int i, int i2) throws UnsupportedEncodingException {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        String concat;
        int Wwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwww);
        int i3 = i - 1;
        byte[] bArr = new byte[i3];
        System.arraycopy(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr, 0, i3);
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i3;
        if (i2 == 2) {
            String valueOf = String.valueOf(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(new String(bArr, 0, 3, "ISO-8859-1")));
            String concat2 = valueOf.length() != 0 ? "image/".concat(valueOf) : new String("image/");
            if ("image/jpg".equals(concat2)) {
                concat2 = DLNAProfiles.DLNAMimeTypes.MIME_IMAGE_JPEG;
            }
            concat = concat2;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = 2;
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, 0);
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(new String(bArr, 0, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, "ISO-8859-1"));
            concat = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.indexOf(47) == -1 ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.length() != 0 ? "image/".concat(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) : new String("image/") : Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        int i4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 + 2;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, i4, Wwwwwwwwwwwwwwwwwwwwww);
        return new C1979cd(concat, new String(bArr, i4, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 - i4, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3), bArr[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 + 1] & 255, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwww) + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4, i3));
    }

    @Nullable
    public static C2403nd Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, int i, String str) throws UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int Wwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwww);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        System.arraycopy(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr, 0, i2);
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i2;
        return new C2403nd(str, null, new String(bArr, 0, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, 0, Wwwwwwwwwwwwwwwwwwwwww), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2));
    }

    public static C2033dd Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, int i, String str) {
        byte[] bArr = new byte[i];
        System.arraycopy(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr, 0, i);
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i;
        return new C2033dd(str, bArr);
    }

    public static C2070ed Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, int i, int i2, boolean z, int i3, @Nullable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) throws UnsupportedEncodingException {
        int i4 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i4);
        String str = new String(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i4, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 - i4, "ISO-8859-1");
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 + 1);
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        long Wwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwww();
        long j = Wwwwwwwwwwwwwwwwwwwww == 4294967295L ? -1L : Wwwwwwwwwwwwwwwwwwwww;
        long Wwwwwwwwwwwwwwwwwwwww2 = c2078el.Wwwwwwwwwwwwwwwwwwwww();
        long j2 = Wwwwwwwwwwwwwwwwwwwww2 == 4294967295L ? -1L : Wwwwwwwwwwwwwwwwwwwww2;
        ArrayList arrayList = new ArrayList();
        int i5 = i4 + i;
        while (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < i5) {
            AbstractC2255jd Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, c2078el, z, i3, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
                arrayList.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            }
        }
        return new C2070ed(str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, j, j2, (AbstractC2255jd[]) arrayList.toArray(new AbstractC2255jd[0]));
    }

    @Nullable
    public static C2144gd Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, int i) throws UnsupportedEncodingException {
        if (i < 4) {
            return null;
        }
        int Wwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwww);
        byte[] bArr = new byte[3];
        System.arraycopy(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr, 0, 3);
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += 3;
        String str = new String(bArr, 0, 3);
        int i2 = i - 4;
        byte[] bArr2 = new byte[i2];
        System.arraycopy(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr2, 0, i2);
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i2;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr2, 0, Wwwwwwwwwwwwwwwwwwwwww);
        String str2 = new String(bArr2, 0, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwww) + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
        return new C2144gd(str, str2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwww), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2));
    }

    /* JADX WARN: Code restructure failed: missing block: B:127:0x017f, code lost:
        if (r13 == 67) goto L98;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AbstractC2255jd Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, C2078el c2078el, boolean z, int i2, @Nullable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        int Wwwwwwwwwwwwwwwwwww;
        int i3;
        int i4;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        AbstractC2255jd Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        int Wwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
        int Wwwwwwwwwwwwwwwwwwwwww2 = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
        int Wwwwwwwwwwwwwwwwwwwwww3 = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
        int Wwwwwwwwwwwwwwwwwwwwww4 = i >= 3 ? c2078el.Wwwwwwwwwwwwwwwwwwwwww() : 0;
        if (i == 4) {
            Wwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwww();
            if (!z) {
                Wwwwwwwwwwwwwwwwwww = (((Wwwwwwwwwwwwwwwwwww >> 24) & 255) << 21) | (Wwwwwwwwwwwwwwwwwww & 255) | (((Wwwwwwwwwwwwwwwwwww >> 8) & 255) << 7) | (((Wwwwwwwwwwwwwwwwwww >> 16) & 255) << 14);
            }
        } else {
            Wwwwwwwwwwwwwwwwwww = i == 3 ? c2078el.Wwwwwwwwwwwwwwwwwww() : c2078el.Wwwwwwwwwwwwwwwwwwww();
        }
        int i5 = Wwwwwwwwwwwwwwwwwww;
        int Wwwwwwwwwwwwwwwww = i >= 3 ? c2078el.Wwwwwwwwwwwwwwwww() : 0;
        if (Wwwwwwwwwwwwwwwwwwwwww == 0 && Wwwwwwwwwwwwwwwwwwwwww2 == 0 && Wwwwwwwwwwwwwwwwwwwwww3 == 0 && Wwwwwwwwwwwwwwwwwwwwww4 == 0 && i5 == 0 && Wwwwwwwwwwwwwwwww == 0) {
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            return null;
        }
        int i6 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + i5;
        int i7 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i6 > i7) {
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i7);
            return null;
        }
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            i3 = i6;
            i4 = Wwwwwwwwwwwwwwwww;
            if (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, Wwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwwwwwwwwwwwwww4)) {
                c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
                return null;
            }
        } else {
            i3 = i6;
            i4 = Wwwwwwwwwwwwwwwww;
        }
        if (i == 3) {
            boolean z7 = (i4 & 128) != 0;
            z3 = (i4 & 64) != 0;
            z6 = z7;
            z5 = false;
            z2 = (i4 & 32) != 0;
            z4 = z6;
        } else if (i == 4) {
            z2 = (i4 & 64) != 0;
            boolean z8 = (i4 & 8) != 0;
            boolean z9 = (i4 & 4) != 0;
            z5 = (i4 & 2) != 0;
            z6 = z8;
            z3 = z9;
            z4 = (i4 & 1) != 0;
        } else {
            z2 = false;
            z3 = false;
            z4 = false;
            z5 = false;
            z6 = false;
        }
        if (z6 || z3) {
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
            return null;
        }
        if (z2) {
            i5--;
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        }
        if (z4) {
            i5 -= 4;
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
        }
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwww = z5 ? Wwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el, i5) : i5;
        try {
            if (Wwwwwwwwwwwwwwwwwwwwww == 84 && Wwwwwwwwwwwwwwwwwwwwww2 == 88 && Wwwwwwwwwwwwwwwwwwwwww3 == 88 && (i == 2 || Wwwwwwwwwwwwwwwwwwwwww4 == 88)) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el, Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
            } else if (Wwwwwwwwwwwwwwwwwwwwww == 84) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el, Wwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, Wwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwwwwwwwwwwwwww4));
            } else if (Wwwwwwwwwwwwwwwwwwwwww == 87 && Wwwwwwwwwwwwwwwwwwwwww2 == 88 && Wwwwwwwwwwwwwwwwwwwwww3 == 88 && (i == 2 || Wwwwwwwwwwwwwwwwwwwwww4 == 88)) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el, Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
            } else if (Wwwwwwwwwwwwwwwwwwwwww == 87) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el, Wwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, Wwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwwwwwwwwwwwwww4));
            } else if (Wwwwwwwwwwwwwwwwwwwwww == 80 && Wwwwwwwwwwwwwwwwwwwwww2 == 82 && Wwwwwwwwwwwwwwwwwwwwww3 == 73 && Wwwwwwwwwwwwwwwwwwwwww4 == 86) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el, Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
            } else if (Wwwwwwwwwwwwwwwwwwwwww == 71 && Wwwwwwwwwwwwwwwwwwwwww2 == 69 && Wwwwwwwwwwwwwwwwwwwwww3 == 79 && (Wwwwwwwwwwwwwwwwwwwwww4 == 66 || i == 2)) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el, Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
            } else if (i == 2) {
                if (Wwwwwwwwwwwwwwwwwwwwww == 80 && Wwwwwwwwwwwwwwwwwwwwww2 == 73 && Wwwwwwwwwwwwwwwwwwwwww3 == 67) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el, Wwwwwwwwwwwwwwwwwwwwwwwwwwww, i);
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = (Wwwwwwwwwwwwwwwwwwwwww != 67 && Wwwwwwwwwwwwwwwwwwwwww2 == 79 && Wwwwwwwwwwwwwwwwwwwwww3 == 77 && (Wwwwwwwwwwwwwwwwwwwwww4 == 77 || i == 2)) ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el, Wwwwwwwwwwwwwwwwwwwwwwwwwwww) : (Wwwwwwwwwwwwwwwwwwwwww != 67 && Wwwwwwwwwwwwwwwwwwwwww2 == 72 && Wwwwwwwwwwwwwwwwwwwwww3 == 65 && Wwwwwwwwwwwwwwwwwwwwww4 == 80) ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el, Wwwwwwwwwwwwwwwwwwwwwwwwwwww, i, z, i2, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) : (Wwwwwwwwwwwwwwwwwwwwww != 67 && Wwwwwwwwwwwwwwwwwwwwww2 == 84 && Wwwwwwwwwwwwwwwwwwwwww3 == 79 && Wwwwwwwwwwwwwwwwwwwwww4 == 67) ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el, Wwwwwwwwwwwwwwwwwwwwwwwwwwww, i, z, i2, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) : (Wwwwwwwwwwwwwwwwwwwwww != 77 && Wwwwwwwwwwwwwwwwwwwwww2 == 76 && Wwwwwwwwwwwwwwwwwwwwww3 == 76 && Wwwwwwwwwwwwwwwwwwwwww4 == 84) ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el, Wwwwwwwwwwwwwwwwwwwwwwwwwwww) : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el, Wwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, Wwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwwwwwwwwwwwwww4));
            } else {
                if (Wwwwwwwwwwwwwwwwwwwwww == 65) {
                    if (Wwwwwwwwwwwwwwwwwwwwww2 == 80) {
                        if (Wwwwwwwwwwwwwwwwwwwwww3 == 73) {
                        }
                    }
                }
                if (Wwwwwwwwwwwwwwwwwwwwww != 67) {
                }
            }
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null) {
                String.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, Wwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwww3, Wwwwwwwwwwwwwwwwwwwwww4)).length();
            }
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        } catch (UnsupportedEncodingException unused) {
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
            return null;
        } catch (Throwable th) {
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0074, code lost:
        if ((r10 & 1) != 0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0076, code lost:
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0083, code lost:
        if ((r10 & 128) != 0) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, int i, int i2, boolean z) {
        int Wwwwwwwwwwwwwwwwwwww;
        long Wwwwwwwwwwwwwwwwwwww2;
        int i3;
        boolean z2;
        boolean z3;
        int i4 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        while (true) {
            try {
                int i5 = 1;
                if (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() < i2) {
                    return true;
                }
                if (i >= 3) {
                    Wwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    Wwwwwwwwwwwwwwwwwwww2 = c2078el.Wwwwwwwwwwwwwwwwwwwww();
                    i3 = c2078el.Wwwwwwwwwwwwwwwww();
                } else {
                    Wwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwww();
                    Wwwwwwwwwwwwwwwwwwww2 = c2078el.Wwwwwwwwwwwwwwwwwwww();
                    i3 = 0;
                }
                if (Wwwwwwwwwwwwwwwwwwww == 0 && Wwwwwwwwwwwwwwwwwwww2 == 0 && i3 == 0) {
                    return true;
                }
                if (i == 4 && !z) {
                    if ((8421504 & Wwwwwwwwwwwwwwwwwwww2) != 0) {
                        return false;
                    }
                    Wwwwwwwwwwwwwwwwwwww2 = (((Wwwwwwwwwwwwwwwwwwww2 >> 24) & 255) << 21) | (Wwwwwwwwwwwwwwwwwwww2 & 255) | (((Wwwwwwwwwwwwwwwwwwww2 >> 8) & 255) << 7) | (((Wwwwwwwwwwwwwwwwwwww2 >> 16) & 255) << 14);
                }
                if (i == 4) {
                    z2 = (i3 & 64) != 0;
                } else {
                    if (i == 3) {
                        z2 = (i3 & 32) != 0;
                    } else {
                        z2 = false;
                    }
                    z3 = false;
                }
                if (!z2) {
                    i5 = 0;
                }
                if (z3) {
                    i5 += 4;
                }
                if (Wwwwwwwwwwwwwwwwwwww2 < i5) {
                    return false;
                }
                if (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() < Wwwwwwwwwwwwwwwwwwww2) {
                    return false;
                }
                c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) Wwwwwwwwwwwwwwwwwwww2);
            } finally {
                c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4);
            }
        }
    }
}
