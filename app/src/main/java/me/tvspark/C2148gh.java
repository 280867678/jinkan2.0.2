package me.tvspark;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.util.Collections;
import java.util.List;
import me.tvspark.AbstractC1983ch;

/* renamed from: me.tvspark.gh */
/* loaded from: classes4.dex */
public final class C2148gh extends AbstractC2846z2 implements Handler.Callback {
    public int Kkkkkkkkkkkkkkkkkkkkkkkk;
    @Nullable
    public AbstractC2074eh Kkkkkkkkkkkkkkkkkkkkkkkkk;
    @Nullable
    public AbstractC2074eh Kkkkkkkkkkkkkkkkkkkkkkkkkk;
    @Nullable
    public C2037dh Www;
    @Nullable
    public AbstractC1946bh Wwww;
    @Nullable
    public C2245j3 Wwwww;
    public int Wwwwww;
    public boolean Wwwwwww;
    public boolean Wwwwwwww;
    public boolean Wwwwwwwww;
    public final C2282k3 Wwwwwwwwww;
    public final AbstractC1983ch Wwwwwwwwwww;
    public final AbstractC2111fh Wwwwwwwwwwww;
    @Nullable
    public final Handler Wwwwwwwwwwwww;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2148gh(AbstractC2111fh abstractC2111fh, @Nullable Looper looper) {
        super(3);
        AbstractC1983ch abstractC1983ch = AbstractC1983ch.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Handler handler = null;
        if (abstractC2111fh != null) {
            this.Wwwwwwwwwwww = abstractC2111fh;
            this.Wwwwwwwwwwwww = looper != null ? C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(looper, (Handler.Callback) this) : handler;
            this.Wwwwwwwwwww = abstractC1983ch;
            this.Wwwwwwwwww = new C2282k3();
            return;
        }
        throw null;
    }

    public final void Wwwwwwwwwww() {
        Wwwwwwwwwwww();
        AbstractC1946bh abstractC1946bh = this.Wwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1946bh);
        abstractC1946bh.release();
        this.Wwww = null;
        this.Wwwwww = 0;
        Wwwwwwwwwwwww();
    }

    public final void Wwwwwwwwwwww() {
        this.Www = null;
        this.Kkkkkkkkkkkkkkkkkkkkkkkk = -1;
        AbstractC2074eh abstractC2074eh = this.Kkkkkkkkkkkkkkkkkkkkkkkkkk;
        if (abstractC2074eh != null) {
            abstractC2074eh.release();
            this.Kkkkkkkkkkkkkkkkkkkkkkkkkk = null;
        }
        AbstractC2074eh abstractC2074eh2 = this.Kkkkkkkkkkkkkkkkkkkkkkkkk;
        if (abstractC2074eh2 != null) {
            abstractC2074eh2.release();
            this.Kkkkkkkkkkkkkkkkkkkkkkkkk = null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0058, code lost:
        if (r1.equals("text/x-ssa") != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Wwwwwwwwwwwww() {
        AbstractC1946bh c2525qi;
        char c = 1;
        this.Wwwwwww = true;
        AbstractC1983ch abstractC1983ch = this.Wwwwwwwwwww;
        C2245j3 c2245j3 = this.Wwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3);
        C2245j3 c2245j32 = c2245j3;
        if (((AbstractC1983ch.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) abstractC1983ch) != null) {
            String str = c2245j32.Wwwwwwwwwwwww;
            if (str != null) {
                switch (str.hashCode()) {
                    case -1351681404:
                        if (str.equals("application/dvbsubs")) {
                            c = '\t';
                            break;
                        }
                        c = 65535;
                        break;
                    case -1248334819:
                        if (str.equals("application/pgs")) {
                            c = '\n';
                            break;
                        }
                        c = 65535;
                        break;
                    case -1026075066:
                        if (str.equals("application/x-mp4-vtt")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1004728940:
                        if (str.equals("text/vtt")) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    case 691401887:
                        if (str.equals("application/x-quicktime-tx3g")) {
                            c = 5;
                            break;
                        }
                        c = 65535;
                        break;
                    case 822864842:
                        break;
                    case 930165504:
                        if (str.equals("application/x-mp4-cea-608")) {
                            c = 7;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1566015601:
                        if (str.equals("application/cea-608")) {
                            c = 6;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1566016562:
                        if (str.equals("application/cea-708")) {
                            c = '\b';
                            break;
                        }
                        c = 65535;
                        break;
                    case 1668750253:
                        if (str.equals("application/x-subrip")) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1693976202:
                        if (str.equals("application/ttml+xml")) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                switch (c) {
                    case 0:
                        c2525qi = new C2525qi();
                        this.Wwww = c2525qi;
                        return;
                    case 1:
                        c2525qi = new C2672uh(c2245j32.Wwwwwwwwwww);
                        this.Wwww = c2525qi;
                        return;
                    case 2:
                        c2525qi = new C2334li();
                        this.Wwww = c2525qi;
                        return;
                    case 3:
                        c2525qi = new C1947bi();
                        this.Wwww = c2525qi;
                        return;
                    case 4:
                        c2525qi = new C2824yh();
                        this.Wwww = c2525qi;
                        return;
                    case 5:
                        c2525qi = new C2149gi(c2245j32.Wwwwwwwwwww);
                        this.Wwww = c2525qi;
                        return;
                    case 6:
                    case 7:
                        c2525qi = new C2259jh(str, c2245j32.Kkkkkkkkkkkkkkkkkkk, 16000L);
                        this.Wwww = c2525qi;
                        return;
                    case '\b':
                        c2525qi = new C2296kh(c2245j32.Kkkkkkkkkkkkkkkkkkk, c2245j32.Wwwwwwwwwww);
                        this.Wwww = c2525qi;
                        return;
                    case '\t':
                        c2525qi = new C2407nh(c2245j32.Wwwwwwwwwww);
                        this.Wwww = c2525qi;
                        return;
                    case '\n':
                        c2525qi = new C2524qh();
                        this.Wwww = c2525qi;
                        return;
                }
            }
            String valueOf = String.valueOf(str);
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Attempted to create decoder for unsupported MIME type: ".concat(valueOf) : new String("Attempted to create decoder for unsupported MIME type: "));
        }
        throw null;
    }

    public final long Wwwwwwwwwwwwww() {
        if (this.Kkkkkkkkkkkkkkkkkkkkkkkk == -1) {
            return Long.MAX_VALUE;
        }
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkkkkkkkkkkk);
        int i = this.Kkkkkkkkkkkkkkkkkkkkkkkk;
        AbstractC1909ah abstractC1909ah = this.Kkkkkkkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1909ah);
        if (i >= abstractC1909ah.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return Long.MAX_VALUE;
        }
        AbstractC2074eh abstractC2074eh = this.Kkkkkkkkkkkkkkkkkkkkkkkkkk;
        int i2 = this.Kkkkkkkkkkkkkkkkkkkkkkkk;
        AbstractC1909ah abstractC1909ah2 = abstractC2074eh.Wwwwwwwwwwwwwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1909ah2);
        return abstractC1909ah2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2) + abstractC2074eh.Wwwwwwwwwwwwwwwwwwwwwww;
    }

    public final void Wwwwwwwwwwwwwww() {
        List<C2786xg> emptyList = Collections.emptyList();
        Handler handler = this.Wwwwwwwwwwwww;
        if (handler != null) {
            handler.obtainMessage(0, emptyList).sendToTarget();
        } else {
            this.Wwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(emptyList);
        }
    }

    @Override // me.tvspark.AbstractC2846z2
    public void Wwwwwwwwwwwwwwwwwww() {
        this.Wwwww = null;
        Wwwwwwwwwwwwwww();
        Wwwwwwwwwwww();
        AbstractC1946bh abstractC1946bh = this.Wwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1946bh);
        abstractC1946bh.release();
        this.Wwww = null;
        this.Wwwwww = 0;
    }

    @Override // me.tvspark.AbstractC1896a4
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return true;
    }

    @Override // me.tvspark.AbstractC2846z2
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, boolean z) {
        Wwwwwwwwwwwwwww();
        this.Wwwwwwwww = false;
        this.Wwwwwwww = false;
        if (this.Wwwwww != 0) {
            Wwwwwwwwwww();
            return;
        }
        Wwwwwwwwwwww();
        AbstractC1946bh abstractC1946bh = this.Wwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1946bh);
        abstractC1946bh.flush();
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SubtitleDecoderException subtitleDecoderException) {
        String valueOf = String.valueOf(this.Wwwww);
        StringBuilder sb = new StringBuilder(valueOf.length() + 39);
        sb.append("Subtitle decoding failed. streamFormat=");
        sb.append(valueOf);
        C2827yk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb.toString(), subtitleDecoderException);
        Wwwwwwwwwwwwwww();
        Wwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2846z2
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3[] c2245j3Arr, long j, long j2) {
        this.Wwwww = c2245j3Arr[0];
        if (this.Wwww != null) {
            this.Wwwwww = 1;
        } else {
            Wwwwwwwwwwwww();
        }
    }

    @Override // me.tvspark.AbstractC1896a4
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwww;
    }

    @Override // me.tvspark.AbstractC1896a4, me.tvspark.AbstractC1970c4
    public String getName() {
        return "TextRenderer";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            this.Wwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((List) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }

    @Override // me.tvspark.AbstractC1896a4
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2) {
        boolean z;
        if (this.Wwwwwwww) {
            return;
        }
        if (this.Kkkkkkkkkkkkkkkkkkkkkkkkk == null) {
            AbstractC1946bh abstractC1946bh = this.Wwww;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1946bh);
            abstractC1946bh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
            try {
                AbstractC1946bh abstractC1946bh2 = this.Wwww;
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1946bh2);
                this.Kkkkkkkkkkkkkkkkkkkkkkkkk = abstractC1946bh2.mo4972Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            } catch (SubtitleDecoderException e) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e);
                return;
            }
        }
        if (this.Wwwwwwwwwwwwwwwwwwww != 2) {
            return;
        }
        if (this.Kkkkkkkkkkkkkkkkkkkkkkkkkk != null) {
            long Wwwwwwwwwwwwww = Wwwwwwwwwwwwww();
            z = false;
            while (Wwwwwwwwwwwwww <= j) {
                this.Kkkkkkkkkkkkkkkkkkkkkkkk++;
                Wwwwwwwwwwwwww = Wwwwwwwwwwwwww();
                z = true;
            }
        } else {
            z = false;
        }
        AbstractC2074eh abstractC2074eh = this.Kkkkkkkkkkkkkkkkkkkkkkkkk;
        if (abstractC2074eh != null) {
            if (abstractC2074eh.isEndOfStream()) {
                if (!z && Wwwwwwwwwwwwww() == Long.MAX_VALUE) {
                    if (this.Wwwwww == 2) {
                        Wwwwwwwwwww();
                    } else {
                        Wwwwwwwwwwww();
                        this.Wwwwwwww = true;
                    }
                }
            } else if (abstractC2074eh.timeUs <= j) {
                AbstractC2074eh abstractC2074eh2 = this.Kkkkkkkkkkkkkkkkkkkkkkkkkk;
                if (abstractC2074eh2 != null) {
                    abstractC2074eh2.release();
                }
                AbstractC1909ah abstractC1909ah = abstractC2074eh.Wwwwwwwwwwwwwwwwwwwwwwww;
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1909ah);
                this.Kkkkkkkkkkkkkkkkkkkkkkkk = abstractC1909ah.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j - abstractC2074eh.Wwwwwwwwwwwwwwwwwwwwwww);
                this.Kkkkkkkkkkkkkkkkkkkkkkkkkk = abstractC2074eh;
                this.Kkkkkkkkkkkkkkkkkkkkkkkkk = null;
                z = true;
            }
        }
        if (z) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkkkkkkkkkkk);
            AbstractC2074eh abstractC2074eh3 = this.Kkkkkkkkkkkkkkkkkkkkkkkkkk;
            AbstractC1909ah abstractC1909ah2 = abstractC2074eh3.Wwwwwwwwwwwwwwwwwwwwwwww;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1909ah2);
            List<C2786xg> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC1909ah2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j - abstractC2074eh3.Wwwwwwwwwwwwwwwwwwwwwww);
            Handler handler = this.Wwwwwwwwwwwww;
            if (handler != null) {
                handler.obtainMessage(0, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).sendToTarget();
            } else {
                this.Wwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }
        if (this.Wwwwww == 2) {
            return;
        }
        while (!this.Wwwwwwwww) {
            try {
                C2037dh c2037dh = this.Www;
                if (c2037dh == null) {
                    AbstractC1946bh abstractC1946bh3 = this.Wwww;
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1946bh3);
                    c2037dh = abstractC1946bh3.mo4971Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    if (c2037dh == null) {
                        return;
                    }
                    this.Www = c2037dh;
                }
                if (this.Wwwwww == 1) {
                    c2037dh.setFlags(4);
                    AbstractC1946bh abstractC1946bh4 = this.Wwww;
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1946bh4);
                    abstractC1946bh4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC1946bh) c2037dh);
                    this.Www = null;
                    this.Wwwwww = 2;
                    return;
                }
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwww, (C2738w5) c2037dh, false);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -4) {
                    if (c2037dh.isEndOfStream()) {
                        this.Wwwwwwwww = true;
                        this.Wwwwwww = false;
                    } else {
                        C2245j3 c2245j3 = this.Wwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (c2245j3 == null) {
                            return;
                        }
                        c2037dh.Wwwwwwwwwwwwwwwww = c2245j3.Wwwwwwwww;
                        c2037dh.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        this.Wwwwwww &= !c2037dh.isKeyFrame();
                    }
                    if (!this.Wwwwwww) {
                        AbstractC1946bh abstractC1946bh5 = this.Wwww;
                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1946bh5);
                        abstractC1946bh5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC1946bh) c2037dh);
                        this.Www = null;
                    }
                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -3) {
                    return;
                }
            } catch (SubtitleDecoderException e2) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e2);
                return;
            }
        }
    }

    @Override // me.tvspark.AbstractC1970c4
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3) {
        if (((AbstractC1983ch.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this.Wwwwwwwwwww) != null) {
            String str = c2245j3.Wwwwwwwwwwwww;
            if ("text/vtt".equals(str) || "text/x-ssa".equals(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-subrip".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/cea-608".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/cea-708".equals(str) || "application/dvbsubs".equals(str) || "application/pgs".equals(str)) {
                return C1933b4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3.Kkkkkkkkkkkkkkkkkk == null ? 4 : 2);
            }
            return C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3.Wwwwwwwwwwwww) ? C1933b4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1) : C1933b4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
        }
        throw null;
    }
}
