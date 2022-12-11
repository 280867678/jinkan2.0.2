package me.tvspark;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import java.util.Collections;
import java.util.List;

/* renamed from: me.tvspark.lb */
/* loaded from: classes4.dex */
public interface AbstractC2327lb {

    /* renamed from: me.tvspark.lb$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3) {
            String str;
            if (i != Integer.MIN_VALUE) {
                StringBuilder sb = new StringBuilder(12);
                sb.append(i);
                sb.append("/");
                str = sb.toString();
            } else {
                str = "";
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Integer.MIN_VALUE;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = "";
        }

        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
        }

        public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != Integer.MIN_VALUE) {
                return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i2 = i == Integer.MIN_VALUE ? this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : i + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
            String str = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, 11), str, i2);
        }
    }

    /* renamed from: me.tvspark.lb$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        SparseArray<AbstractC2327lb> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

        @Nullable
        AbstractC2327lb Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    /* renamed from: me.tvspark.lb$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final List<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        @Nullable
        public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, @Nullable String str, @Nullable List<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> list, byte[] bArr) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bArr;
        }
    }

    /* renamed from: me.tvspark.lb$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, int i, byte[] bArr) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bArr;
        }
    }

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, int i) throws ParserException;

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2337ll c2337ll, AbstractC2249j7 abstractC2249j7, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
}
