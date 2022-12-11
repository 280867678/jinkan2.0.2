package me.tvspark;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.Arrays;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

/* renamed from: me.tvspark.nf */
/* loaded from: classes4.dex */
public final class C2405nf {
    public static final C2405nf Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2405nf(new long[0]);
    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final long[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.nf$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
        public final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new int[0];
        public final Uri[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Uri[0];
        public final long[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new long[0];

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
        }

        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            int i2 = i + 1;
            while (true) {
                int[] iArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (i2 >= iArr.length || iArr[i2] == 0 || iArr[i2] == 1) {
                    break;
                }
                i2++;
            }
            return i2;
        }

        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-1) < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.class != obj.getClass()) {
                return false;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj;
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && Arrays.equals(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && Arrays.equals(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && Arrays.equals(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        public int hashCode() {
            int hashCode = Arrays.hashCode(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            return Arrays.hashCode(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) + ((hashCode + (((this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww * 31) + Arrays.hashCode(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) * 31)) * 31);
        }
    }

    public C2405nf(long... jArr) {
        int length = jArr.length;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = length;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Arrays.copyOf(jArr, length);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[length];
        for (int i = 0; i < length; i++) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i] = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0L;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -9223372036854775807L;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2405nf.class != obj.getClass()) {
            return false;
        }
        C2405nf c2405nf = (C2405nf) obj;
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == c2405nf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == c2405nf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == c2405nf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww && Arrays.equals(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2405nf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && Arrays.equals(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2405nf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public int hashCode() {
        int hashCode = Arrays.hashCode(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        return Arrays.hashCode(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) + ((hashCode + (((((this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww * 31) + ((int) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) * 31) + ((int) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("AdPlaybackState(adResumePositionUs=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(", adGroups=[");
        for (int i = 0; i < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length; i++) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append("adGroup(timeUs=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i]);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(", ads=[");
            for (int i2 = 0; i2 < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length; i2++) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append("ad(state=");
                int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i2];
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(i3 != 0 ? i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? '?' : PublicSuffixDatabase.EXCEPTION_MARKER : 'P' : 'S' : 'R' : '_');
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(", durationUs=");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i2]);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(')');
                if (i2 < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length - 1) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(", ");
                }
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append("])");
            if (i < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length - 1) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(", ");
            }
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append("])");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
    }
}
