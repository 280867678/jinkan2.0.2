package me.tvspark;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import me.tvspark.AbstractC2333lh;
import me.tvspark.AbstractC2775x5;

/* renamed from: me.tvspark.lh */
/* loaded from: classes4.dex */
public abstract class AbstractC2333lh implements AbstractC1946bh {
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final PriorityQueue<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final ArrayDeque<AbstractC2074eh> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final ArrayDeque<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayDeque<>();

    /* renamed from: me.tvspark.lh$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2074eh {
        public AbstractC2775x5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2775x5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.AbstractC2775x5
        public final void release() {
            this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        }
    }

    /* renamed from: me.tvspark.lh$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends C2037dh implements Comparable<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> {
        public long Wwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        @Override // java.lang.Comparable
        public int compareTo(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (isEndOfStream() == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.isEndOfStream()) {
                long j = this.Wwwwwwwwwwwwwwwwwwwww - wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwww;
                if (j == 0) {
                    j = this.Wwwwwwwwwwwwwwww - wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwww;
                    if (j == 0) {
                        return 0;
                    }
                }
                if (j > 0) {
                    return 1;
                }
            } else if (isEndOfStream()) {
                return 1;
            }
            return -1;
        }
    }

    public AbstractC2333lh() {
        for (int i = 0; i < 10; i++) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null));
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayDeque<>();
        for (int i2 = 0; i2 < 2; i2++) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new AbstractC2775x5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() { // from class: me.tvspark.ih
                @Override // me.tvspark.AbstractC2775x5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
                public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2775x5 abstractC2775x5) {
                    AbstractC2333lh.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2074eh) ((AbstractC2333lh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) abstractC2775x5));
                }
            }));
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new PriorityQueue<>();
    }

    public abstract boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    public abstract AbstractC1909ah Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    @Override // me.tvspark.AbstractC2660u5
    @Nullable
    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    public C2037dh mo4971Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws DecoderException {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null);
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
            return null;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww pollFirst = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.pollFirst();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = pollFirst;
        return pollFirst;
    }

    @Override // me.tvspark.AbstractC2660u5
    @Nullable
    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: avoid collision after fix types in other method */
    public AbstractC2074eh mo4972Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws SubtitleDecoderException {
        AbstractC2074eh pollFirst;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
            return null;
        }
        while (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww peek = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.peek();
            C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(peek);
            if (peek.Wwwwwwwwwwwwwwwwwwwww > this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                break;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww poll = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.poll();
            if (poll.isEndOfStream()) {
                pollFirst = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.pollFirst();
                pollFirst.addFlag(4);
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((C2037dh) poll);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    AbstractC1909ah Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    pollFirst = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.pollFirst();
                    pollFirst.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(poll.Wwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, Long.MAX_VALUE);
                } else {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(poll);
                }
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(poll);
            return pollFirst;
        }
        return null;
    }

    @Override // me.tvspark.AbstractC1946bh
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
    }

    @Override // me.tvspark.AbstractC2660u5
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2037dh c2037dh) throws DecoderException {
        C2037dh c2037dh2 = c2037dh;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2037dh2 == this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) c2037dh2;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isDecodeOnly()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        } else {
            long j = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1 + j;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwww = j;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2037dh c2037dh);

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2074eh abstractC2074eh) {
        abstractC2074eh.clear();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(abstractC2074eh);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.AbstractC2660u5
    public void flush() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0L;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0L;
        while (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww poll = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.poll();
            C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(poll);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(poll);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        }
    }

    @Override // me.tvspark.AbstractC2660u5
    public void release() {
    }
}
