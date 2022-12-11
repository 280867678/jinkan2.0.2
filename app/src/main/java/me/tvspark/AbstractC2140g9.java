package me.tvspark;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: me.tvspark.g9 */
/* loaded from: classes4.dex */
public abstract class AbstractC2140g9 {
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.g9$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2140g9 {
        public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, C2078el c2078el) {
            super(i);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el;
        }
    }

    /* renamed from: me.tvspark.g9$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2140g9 {
        public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final List<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
        public final List<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, long j) {
            super(i);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
        }

        @Nullable
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            int size = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size();
            for (int i2 = 0; i2 < size; i2++) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i2);
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == i) {
                    return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
            }
            return null;
        }

        @Nullable
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            int size = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size();
            for (int i2 = 0; i2 < size; i2++) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i2);
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == i) {
                    return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
            }
            return null;
        }

        @Override // me.tvspark.AbstractC2140g9
        public String toString() {
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = AbstractC2140g9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            String arrays = Arrays.toString(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toArray());
            String arrays2 = Arrays.toString(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toArray());
            StringBuilder sb = new StringBuilder(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(arrays2, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(arrays, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 22))));
            sb.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            sb.append(" leaves: ");
            sb.append(arrays);
            sb.append(" containers: ");
            sb.append(arrays2);
            return sb.toString();
        }
    }

    public AbstractC2140g9(int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        StringBuilder sb = new StringBuilder(4);
        sb.append((char) ((i >> 24) & 255));
        sb.append((char) ((i >> 16) & 255));
        sb.append((char) ((i >> 8) & 255));
        sb.append((char) (i & 255));
        return sb.toString();
    }

    public String toString() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }
}
