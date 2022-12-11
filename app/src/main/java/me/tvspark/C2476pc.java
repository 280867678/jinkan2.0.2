package me.tvspark;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import me.tvspark.C2254jc;

/* renamed from: me.tvspark.pc */
/* loaded from: classes4.dex */
public final class C2476pc extends AbstractC2846z2 implements Handler.Callback {
    public long Www;
    public boolean Wwww;
    @Nullable
    public AbstractC2328lc Wwwww;
    public int Wwwwww;
    public int Wwwwwww;
    public final long[] Wwwwwwww;
    public final C2254jc[] Wwwwwwwww;
    public final C2402nc Wwwwwwwwww;
    @Nullable
    public final Handler Wwwwwwwwwww;
    public final AbstractC2439oc Wwwwwwwwwwww;
    public final AbstractC2365mc Wwwwwwwwwwwww;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2476pc(AbstractC2439oc abstractC2439oc, @Nullable Looper looper) {
        super(4);
        AbstractC2365mc abstractC2365mc = AbstractC2365mc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Handler handler = null;
        if (abstractC2439oc != null) {
            this.Wwwwwwwwwwww = abstractC2439oc;
            this.Wwwwwwwwwww = looper != null ? C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(looper, (Handler.Callback) this) : handler;
            this.Wwwwwwwwwwwww = abstractC2365mc;
            this.Wwwwwwwwww = new C2402nc();
            this.Wwwwwwwww = new C2254jc[5];
            this.Wwwwwwww = new long[5];
            return;
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2846z2
    public void Wwwwwwwwwwwwwwwwwww() {
        Arrays.fill(this.Wwwwwwwww, (Object) null);
        this.Wwwwwww = 0;
        this.Wwwwww = 0;
        this.Wwwww = null;
    }

    @Override // me.tvspark.AbstractC1896a4
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return true;
    }

    @Override // me.tvspark.AbstractC1970c4
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3) {
        if (this.Wwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3)) {
            return C1933b4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3.Kkkkkkkkkkkkkkkkkk == null ? 4 : 2);
        }
        return C1933b4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2254jc c2254jc, List<C2254jc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> list) {
        int i = 0;
        while (true) {
            C2254jc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr = c2254jc.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (i < wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr.length) {
                C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr[i].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null && this.Wwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                    AbstractC2328lc Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    byte[] Wwwwwwwwwwwwwwwwwwwwww = c2254jc.Wwwwwwwwwwwwwwwwwwwwwwww[i].Wwwwwwwwwwwwwwwwwwwwww();
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwww);
                    byte[] bArr = Wwwwwwwwwwwwwwwwwwwwww;
                    this.Wwwwwwwwww.clear();
                    this.Wwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr.length);
                    ByteBuffer byteBuffer = this.Wwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
                    C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer);
                    byteBuffer.put(bArr);
                    this.Wwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    C2254jc Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwww);
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, list);
                    }
                } else {
                    list.add(c2254jc.Wwwwwwwwwwwwwwwwwwwwwwww[i]);
                }
                i++;
            } else {
                return;
            }
        }
    }

    @Override // me.tvspark.AbstractC2846z2
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3[] c2245j3Arr, long j, long j2) {
        this.Wwwww = this.Wwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3Arr[0]);
    }

    @Override // me.tvspark.AbstractC1896a4
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwww;
    }

    @Override // me.tvspark.AbstractC1896a4, me.tvspark.AbstractC1970c4
    public String getName() {
        return "MetadataRenderer";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            this.Wwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((C2254jc) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }

    @Override // me.tvspark.AbstractC2846z2
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, boolean z) {
        Arrays.fill(this.Wwwwwwwww, (Object) null);
        this.Wwwwwww = 0;
        this.Wwwwww = 0;
        this.Wwww = false;
    }

    @Override // me.tvspark.AbstractC1896a4
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2) {
        if (!this.Wwww && this.Wwwwww < 5) {
            this.Wwwwwwwwww.clear();
            C2282k3 Wwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwww();
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwww, false);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -4) {
                if (this.Wwwwwwwwww.isEndOfStream()) {
                    this.Wwww = true;
                } else {
                    C2402nc c2402nc = this.Wwwwwwwwww;
                    c2402nc.Wwwwwwwwwwwwwwwww = this.Www;
                    c2402nc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    AbstractC2328lc abstractC2328lc = this.Wwwww;
                    C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2328lc);
                    C2254jc Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = abstractC2328lc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwww);
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
                        ArrayList arrayList = new ArrayList(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwww.length);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, arrayList);
                        if (!arrayList.isEmpty()) {
                            C2254jc c2254jc = new C2254jc(arrayList);
                            int i = this.Wwwwwww;
                            int i2 = this.Wwwwww;
                            int i3 = (i + i2) % 5;
                            this.Wwwwwwwww[i3] = c2254jc;
                            this.Wwwwwwww[i3] = this.Wwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww;
                            this.Wwwwww = i2 + 1;
                        }
                    }
                }
            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -5) {
                C2245j3 c2245j3 = Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3);
                this.Www = c2245j3.Wwwwwwwww;
            }
        }
        if (this.Wwwwww > 0) {
            long[] jArr = this.Wwwwwwww;
            int i4 = this.Wwwwwww;
            if (jArr[i4] > j) {
                return;
            }
            C2254jc c2254jc2 = this.Wwwwwwwww[i4];
            C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2254jc2);
            C2254jc c2254jc3 = c2254jc2;
            Handler handler = this.Wwwwwwwwwww;
            if (handler != null) {
                handler.obtainMessage(0, c2254jc3).sendToTarget();
            } else {
                this.Wwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2254jc3);
            }
            C2254jc[] c2254jcArr = this.Wwwwwwwww;
            int i5 = this.Wwwwwww;
            c2254jcArr[i5] = null;
            this.Wwwwwww = (i5 + 1) % 5;
            this.Wwwwww--;
        }
    }
}
