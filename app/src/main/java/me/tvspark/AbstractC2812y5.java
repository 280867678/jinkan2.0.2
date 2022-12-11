package me.tvspark;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.util.ArrayDeque;
import me.tvspark.AbstractC2775x5;
import me.tvspark.C2738w5;

/* renamed from: me.tvspark.y5 */
/* loaded from: classes4.dex */
public abstract class AbstractC2812y5<I extends C2738w5, O extends AbstractC2775x5, E extends DecoderException> implements AbstractC2660u5<I, O, E> {
    public int Wwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwww;
    public E Wwwwwwwwwwwwwwwwwwwwwwwww;
    public I Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final O[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final I[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Thread Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Object();
    public final ArrayDeque<I> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayDeque<>();
    public final ArrayDeque<O> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayDeque<>();

    /* renamed from: me.tvspark.y5$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Thread {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            AbstractC2812y5 abstractC2812y5 = AbstractC2812y5.this;
            if (abstractC2812y5 != null) {
                do {
                    try {
                    } catch (InterruptedException e) {
                        throw new IllegalStateException(e);
                    }
                } while (abstractC2812y5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                return;
            }
            throw null;
        }
    }

    public AbstractC2812y5(I[] iArr, O[] oArr) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iArr;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = iArr.length;
        for (int i = 0; i < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww; i++) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i] = new C2037dh();
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = oArr;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = oArr.length;
        for (int i2 = 0; i2 < this.Wwwwwwwwwwwwwwwwwwwwwwwwwww; i2++) {
            final AbstractC2823yg abstractC2823yg = (AbstractC2823yg) this;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww[i2] = new C2860zg(new AbstractC2775x5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() { // from class: me.tvspark.vg
                @Override // me.tvspark.AbstractC2775x5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
                public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2775x5 abstractC2775x5) {
                    AbstractC2823yg.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2823yg) ((AbstractC2074eh) abstractC2775x5));
                }
            });
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("ExoPlayer:SimpleDecoder");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.start();
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws DecoderException {
        E e = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
        if (e == null) {
            return;
        }
        throw e;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty() && this.Wwwwwwwwwwwwwwwwwwwwwwwwwww > 0) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.notify();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0078 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws InterruptedException {
        SubtitleDecoderException subtitleDecoderException;
        SubtitleDecoderException subtitleDecoderException2;
        synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            while (!this.Wwwwwwwwwwwwwwwwwwwwwww) {
                if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty() && this.Wwwwwwwwwwwwwwwwwwwwwwwwwww > 0) {
                    break;
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.wait();
            }
            if (this.Wwwwwwwwwwwwwwwwwwwwwww) {
                return false;
            }
            I removeFirst = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.removeFirst();
            O[] oArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww - 1;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            O o = oArr[i];
            boolean z = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwww = false;
            if (removeFirst.isEndOfStream()) {
                o.addFlag(4);
            } else {
                if (removeFirst.isDecodeOnly()) {
                    o.addFlag(Integer.MIN_VALUE);
                }
                try {
                    subtitleDecoderException2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(removeFirst, o, z);
                } catch (OutOfMemoryError e) {
                    subtitleDecoderException = new SubtitleDecoderException("Unexpected decode error", e);
                    subtitleDecoderException2 = subtitleDecoderException;
                    if (subtitleDecoderException2 != null) {
                    }
                    synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    }
                } catch (RuntimeException e2) {
                    subtitleDecoderException = new SubtitleDecoderException("Unexpected decode error", e2);
                    subtitleDecoderException2 = subtitleDecoderException;
                    if (subtitleDecoderException2 != null) {
                    }
                    synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    }
                }
                if (subtitleDecoderException2 != null) {
                    synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwww = subtitleDecoderException2;
                    }
                    return false;
                }
            }
            synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                if (!this.Wwwwwwwwwwwwwwwwwwwwwwww) {
                    if (o.isDecodeOnly()) {
                        this.Wwwwwwwwwwwwwwwwwwwwww++;
                    } else {
                        o.skippedOutputBufferCount = this.Wwwwwwwwwwwwwwwwwwwwww;
                        this.Wwwwwwwwwwwwwwwwwwwwww = 0;
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.addLast(o);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(removeFirst);
                    }
                }
                o.release();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(removeFirst);
            }
            return true;
        }
    }

    @Override // me.tvspark.AbstractC2660u5
    @Nullable
    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other method in class */
    public final I mo4971Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws DecoderException {
        I i;
        synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwww == null);
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww == 0) {
                i = null;
            } else {
                I[] iArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww - 1;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
                i = iArr[i2];
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = i;
        }
        return i;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(I i) {
        i.clear();
        I[] iArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i2 + 1;
        iArr[i2] = i;
    }

    @Nullable
    public abstract E Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(I i, O o, boolean z);

    @Override // me.tvspark.AbstractC2660u5
    @Nullable
    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other method in class */
    public final O mo4972Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws DecoderException {
        synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
                return null;
            }
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.removeFirst();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.tvspark.AbstractC2660u5
    public /* bridge */ /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) throws DecoderException {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2812y5<I, O, E>) ((C2738w5) obj));
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(I i) throws DecoderException {
        synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i == this.Wwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.addLast(i);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = null;
        }
    }

    @CallSuper
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(O o) {
        synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            o.clear();
            O[] oArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = i + 1;
            oArr[i] = o;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    @Override // me.tvspark.AbstractC2660u5
    public final void flush() {
        synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwwwwwwwwww = 0;
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwww = null;
            }
            while (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.removeFirst());
            }
            while (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.removeFirst().release();
            }
        }
    }

    @Override // me.tvspark.AbstractC2660u5
    @CallSuper
    public void release() {
        synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.notify();
        }
        try {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
