package me.tvspark;

import android.util.Pair;
import com.google.android.exoplayer2.ParserException;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.tencent.smtt.sdk.TbsListener;
import java.io.IOException;
import me.tvspark.C2245j3;
import org.apache.commons.lang3.time.StopWatch;

/* renamed from: me.tvspark.ob */
/* loaded from: classes4.dex */
public final class C2438ob implements AbstractC2175h7 {
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public AbstractC2249j7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;

    /* renamed from: me.tvspark.ob$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public long Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final C2475pb Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final AbstractC2249j7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2249j7 abstractC2249j7, AbstractC2740w7 abstractC2740w7, C2475pb c2475pb, String str, int i) throws ParserException {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2249j7;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2740w7;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2475pb;
            int i2 = (c2475pb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww * c2475pb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) / 8;
            if (c2475pb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != i2) {
                int i3 = c2475pb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                StringBuilder sb = new StringBuilder(50);
                sb.append("Expected block size: ");
                sb.append(i2);
                sb.append("; got: ");
                sb.append(i3);
                throw new ParserException(sb.toString());
            }
            int i4 = c2475pb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i5 = i4 * i2 * 8;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Math.max(i2, (i4 * i2) / 10);
            C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = str;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = i5;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i5;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwww = c2475pb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwww = c2475pb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        @Override // me.tvspark.C2438ob.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, long j) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new C2555rb(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 1, i, j));
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // me.tvspark.C2438ob.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = 0L;
        }

        @Override // me.tvspark.C2438ob.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7, long j) throws IOException {
            int i;
            C2475pb c2475pb;
            int i2;
            int i3;
            long j2 = j;
            while (true) {
                i = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
                if (i <= 0 || (i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) >= (i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                    break;
                }
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2752wj) abstractC2212i7, (int) Math.min(i3 - i2, j2), true);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1) {
                    j2 = 0;
                } else {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww += Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    j2 -= Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
            }
            int i4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww / i4;
            if (i5 > 0) {
                int i6 = i5 * i4;
                int i7 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww - i6;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww + C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww, StopWatch.NANO_2_MILLIS, c2475pb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), 1, i6, i7, null);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwww += i5;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i7;
            }
            return i <= 0;
        }
    }

    /* renamed from: me.tvspark.ob$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, long j) throws ParserException;

        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j);

        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7, long j) throws IOException;
    }

    /* renamed from: me.tvspark.ob$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public long Wwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwww;
        public long Wwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwww;
        public final C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final C2475pb Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final AbstractC2249j7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public static final int[] Wwwwwwwwwwwwwwwwwwwwww = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};
        public static final int[] Wwwwwwwwwwwwwwwwwwwww = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, 130, 143, 157, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_3, 190, 209, TbsListener.ErrorCode.RENAME_SUCCESS, TinkerReport.KEY_LOADED_EXCEPTION_DEX_CHECK, 279, 307, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2249j7 abstractC2249j7, AbstractC2740w7 abstractC2740w7, C2475pb c2475pb) throws ParserException {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2249j7;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2740w7;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2475pb;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Math.max(1, c2475pb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww / 10);
            byte[] bArr = c2475pb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int length = bArr.length;
            int i = 0 + 1;
            byte b = bArr[0];
            int i2 = i + 1;
            byte b2 = bArr[i];
            int i3 = ((bArr[i2 + 1] & 255) << 8) | (bArr[i2] & 255);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
            int i4 = c2475pb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i5 = (((c2475pb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - (i4 * 4)) * 8) / (c2475pb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww * i4)) + 1;
            if (i3 != i5) {
                int i6 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                StringBuilder sb = new StringBuilder(56);
                sb.append("Expected frames per block: ");
                sb.append(i5);
                sb.append("; got: ");
                sb.append(i6);
                throw new ParserException(sb.toString());
            }
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, i3);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new byte[c2475pb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww * Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww];
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2078el(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww * this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww * 2 * i4);
            int i7 = ((c2475pb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww * c2475pb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) * 8) / this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = "audio/raw";
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = i7;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i7;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww * 2 * i4;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwww = c2475pb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwww = c2475pb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwww = 2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwww + C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, StopWatch.NANO_2_MILLIS, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            int i2 = i * 2 * this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 1, i2, this.Wwwwwwwwwwwwwwwwwwwwwwww - i2, null);
            this.Wwwwwwwwwwwwwwwwwwwwwww += i;
            this.Wwwwwwwwwwwwwwwwwwwwwwww -= i2;
        }

        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            return i / (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww * 2);
        }

        @Override // me.tvspark.C2438ob.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, long j) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new C2555rb(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i, j));
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        @Override // me.tvspark.C2438ob.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = 0;
            this.Wwwwwwwwwwwwwwwwwwwwwwwww = j;
            this.Wwwwwwwwwwwwwwwwwwwwwwww = 0;
            this.Wwwwwwwwwwwwwwwwwwwwwww = 0L;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x003e A[LOOP:0: B:5:0x0022->B:11:0x003e, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:12:0x001f A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x004d  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0158  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x003b -> B:3:0x001f). Please submit an issue!!! */
        @Override // me.tvspark.C2438ob.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7, long j) throws IOException {
            boolean z;
            int i;
            boolean z2;
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i2;
            int read;
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) * this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (j != 0) {
                z = false;
                while (!z && (i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwww) < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
                    read = abstractC2212i7.read(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwww, (int) Math.min(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 - i2, j));
                    if (read == -1) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwww += read;
                    }
                }
                i = this.Wwwwwwwwwwwwwwwwwwwwwwwwww / this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (i <= 0) {
                    byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    C2078el c2078el = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int i3 = 0;
                    while (i3 < i) {
                        int i4 = 0;
                        while (true) {
                            C2475pb c2475pb = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            int i5 = c2475pb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            if (i4 < i5) {
                                byte[] bArr2 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                int i6 = c2475pb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                int i7 = (i4 * 4) + (i3 * i6);
                                int i8 = (i5 * 4) + i7;
                                int i9 = (i6 / i5) - 4;
                                int i10 = (short) ((bArr[i7] & 255) | ((bArr[i7 + 1] & 255) << 8));
                                int min = Math.min(bArr[i7 + 2] & 255, 88);
                                int i11 = Wwwwwwwwwwwwwwwwwwwww[min];
                                int i12 = ((this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww * i3 * i5) + i4) * 2;
                                bArr2[i12] = (byte) (i10 & 255);
                                bArr2[i12 + 1] = (byte) (i10 >> 8);
                                int i13 = i12;
                                boolean z3 = z;
                                int i14 = 0;
                                while (i14 < i9 * 2) {
                                    int i15 = bArr[((i14 / 8) * i5 * 4) + i8 + ((i14 / 2) % 4)] & 255;
                                    int i16 = i14 % 2 == 0 ? i15 & 15 : i15 >> 4;
                                    int i17 = ((((i16 & 7) * 2) + 1) * i11) >> 3;
                                    if ((i16 & 8) != 0) {
                                        i17 = -i17;
                                    }
                                    i10 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i10 + i17, -32768, 32767);
                                    i13 += i5 * 2;
                                    bArr2[i13] = (byte) (i10 & 255);
                                    bArr2[i13 + 1] = (byte) (i10 >> 8);
                                    min = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(min + Wwwwwwwwwwwwwwwwwwwwww[i16], 0, Wwwwwwwwwwwwwwwwwwwww.length - 1);
                                    i14++;
                                    i11 = Wwwwwwwwwwwwwwwwwwwww[min];
                                    bArr = bArr;
                                }
                                i4++;
                                z = z3;
                            }
                        }
                        i3++;
                        z = z;
                    }
                    z2 = z;
                    c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww * i * 2 * this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwww -= i * this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    C2078el c2078el2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int i18 = c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el2, i18);
                    int i19 = this.Wwwwwwwwwwwwwwwwwwwwwwww + i18;
                    this.Wwwwwwwwwwwwwwwwwwwwwwww = i19;
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i19);
                    int i20 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 >= i20) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i20);
                    }
                } else {
                    z2 = z;
                }
                if (z2 && (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww)) > 0) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
                return z2;
            }
            z = true;
            while (!z) {
                read = abstractC2212i7.read(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwww, (int) Math.min(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 - i2, j));
                if (read == -1) {
                }
            }
            i = this.Wwwwwwwwwwwwwwwwwwwwwwwwww / this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i <= 0) {
            }
            if (z2) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            return z2;
        }
    }

    static {
        C2401nb c2401nb = C2401nb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public static /* synthetic */ AbstractC2175h7[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return new AbstractC2175h7[]{new C2438ob()};
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0075  */
    @Override // me.tvspark.AbstractC2175h7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7, C2588s7 c2588s7) throws IOException {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        int i;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        boolean z = true;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            C2475pb Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null) {
                throw new ParserException("Unsupported or unrecognized wav header.");
            }
            int i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i2 == 17) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            } else if (i2 == 6) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, "audio/g711-alaw", -1);
            } else if (i2 == 7) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, "audio/g711-mlaw", -1);
            } else {
                int i3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (i2 != 1) {
                    if (i2 == 3) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = i3 == 32 ? 4 : 0;
                        i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                        if (i == 0) {
                        }
                    } else if (i2 != 65534) {
                        i = 0;
                        if (i == 0) {
                            throw new ParserException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(40, "Unsupported WAV format type: ", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                        }
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, "audio/raw", i);
                    }
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
                i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                if (i == 0) {
                }
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1) {
            if (abstractC2212i7 != null) {
                abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                C2078el c2078el = new C2078el(8);
                while (true) {
                    C2518qb Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = C2518qb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7, c2078el);
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 1684108385) {
                        long j = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 8;
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 1380533830) {
                            j = 12;
                        }
                        if (j > 2147483647L) {
                            throw new ParserException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(51, "Chunk is too large (~2GB+) to skip; id: ", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                        }
                        abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) j);
                    } else {
                        abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                        long position = abstractC2212i7.getPosition();
                        long j2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + position;
                        long length = abstractC2212i7.getLength();
                        if (length != -1 && j2 > length) {
                            j2 = length;
                        }
                        Pair create = Pair.create(Long.valueOf(position), Long.valueOf(j2));
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ((Long) create.first).intValue();
                        long longValue = ((Long) create.second).longValue();
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = longValue;
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, longValue);
                    }
                }
            } else {
                throw null;
            }
        } else if (abstractC2212i7.getPosition() == 0) {
            abstractC2212i7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1) {
            z = false;
        }
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww - abstractC2212i7.getPosition()) ? -1 : 0;
    }

    @Override // me.tvspark.AbstractC2175h7
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2);
        }
    }

    @Override // me.tvspark.AbstractC2175h7
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2249j7 abstractC2249j7) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2249j7;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2249j7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, 1);
        abstractC2249j7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2175h7
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7) throws IOException {
        return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2212i7) != null;
    }

    @Override // me.tvspark.AbstractC2175h7
    public void release() {
    }
}
