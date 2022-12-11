package me.tvspark;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.stub.StubApp;
import me.tvspark.C2135g4;
import me.tvspark.C2772x2;

/* renamed from: me.tvspark.x2 */
/* loaded from: classes4.dex */
public final class C2772x2 {
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public AudioFocusRequest Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public C2848z4 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final AudioManager Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 1.0f;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;

    /* renamed from: me.tvspark.x2$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* renamed from: me.tvspark.x2$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AudioManager.OnAudioFocusChangeListener {
        public final Handler Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Handler handler) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = handler;
        }

        public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            int i2;
            C2772x2 c2772x2 = C2772x2.this;
            if (c2772x2 != null) {
                boolean z = true;
                if (i != -3 && i != -2) {
                    if (i == -1) {
                        c2772x2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-1);
                        c2772x2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        return;
                    } else if (i != 1) {
                        return;
                    } else {
                        c2772x2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                        c2772x2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                        return;
                    }
                }
                if (i != -2) {
                    C2848z4 c2848z4 = c2772x2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (c2848z4 == null || c2848z4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 1) {
                        z = false;
                    }
                    if (!z) {
                        i2 = 3;
                        c2772x2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
                        return;
                    }
                }
                c2772x2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                i2 = 2;
                c2772x2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
                return;
            }
            throw null;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.post(new Runnable() { // from class: me.tvspark.x1
                @Override // java.lang.Runnable
                public final void run() {
                    C2772x2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
                }
            });
        }
    }

    public C2772x2(Context context, Handler handler, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        AudioManager audioManager = (AudioManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("audio");
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(audioManager);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = audioManager;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(handler);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == i) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        float f = i == 3 ? 0.2f : 1.0f;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww == f) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = f;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            return;
        }
        C2135g4 c2135g4 = C2135g4.this;
        c2135g4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1, 2, Float.valueOf(c2135g4.Wwww * c2135g4.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww));
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0) {
            return;
        }
        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 26) {
            AudioFocusRequest audioFocusRequest = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (audioFocusRequest != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.abandonAudioFocusRequest(audioFocusRequest);
            }
        } else {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.abandonAudioFocus(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            C2135g4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (C2135g4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            boolean Wwwwwwwwwwwwwwwwwwwwwwwww = C2135g4.this.Wwwwwwwwwwwwwwwwwwwwwwwww();
            C2135g4.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwww, i, C2135g4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwww, i));
        }
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, int i) {
        int requestAudioFocus;
        int i2 = 1;
        if (i == 1 || this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww != 1) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return z ? 1 : -1;
        } else if (!z) {
            return -1;
        } else {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 1) {
                if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 26) {
                    if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwww == null || this.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
                        AudioFocusRequest.Builder builder = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww == null ? new AudioFocusRequest.Builder(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) : new AudioFocusRequest.Builder(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
                        C2848z4 c2848z4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        boolean z2 = c2848z4 != null && c2848z4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 1;
                        C2848z4 c2848z42 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2848z42);
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = builder.setAudioAttributes(c2848z42.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()).setWillPauseWhenDucked(z2).setOnAudioFocusChangeListener(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).build();
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = false;
                    }
                    requestAudioFocus = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.requestAudioFocus(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
                } else {
                    AudioManager audioManager = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    C2848z4 c2848z43 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2848z43);
                    requestAudioFocus = audioManager.requestAudioFocus(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2848z43.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
                if (requestAudioFocus == 1) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                } else {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                    i2 = -1;
                }
            }
            return i2;
        }
    }
}
