package me.tvspark;

/* renamed from: me.tvspark.b3 */
/* loaded from: classes4.dex */
public class C1932b3 implements AbstractC2319l3 {
    public boolean Wwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C1986ck Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C1932b3() {
        this(new C1986ck(true, 65536), 50000, 50000, 2500, 5000, -1, false, 0, false);
    }

    public C1932b3(C1986ck c1986ck, int i, int i2, int i3, int i4, int i5, boolean z, int i6, boolean z2) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3, 0, "bufferForPlaybackMs", "0");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4, 0, "bufferForPlaybackAfterRebufferMs", "0");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i3, "minBufferMs", "bufferForPlaybackMs");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i4, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, i, "maxBufferMs", "minBufferMs");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i6, 0, "backBufferDurationMs", "0");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c1986ck;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = i5;
        this.Wwwwwwwwwwwwwwwwwwwwwwwww = i5 == -1 ? 13107200 : i5;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i6);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = z2;
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, String str, String str2) {
        boolean z = i >= i2;
        StringBuilder sb = new StringBuilder(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, 21)));
        sb.append(str);
        sb.append(" cannot be less than ");
        sb.append(str2);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z, (Object) sb.toString());
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i == -1) {
            i = 13107200;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = false;
        if (z) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }
}
