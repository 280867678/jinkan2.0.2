package com.google.android.exoplayer2.audio;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.PlaybackParams;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioSink;
import com.just.agentweb.WebIndicator;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.Executor;
import me.tvspark.AbstractC1896a4;
import me.tvspark.AbstractC1971c5;
import me.tvspark.C1895a3;
import me.tvspark.C1897a5;
import me.tvspark.C1950bl;
import me.tvspark.C2008d5;
import me.tvspark.C2041dl;
import me.tvspark.C2062e5;
import me.tvspark.C2099f5;
import me.tvspark.C2173h5;
import me.tvspark.C2210i5;
import me.tvspark.C2245j3;
import me.tvspark.C2284k5;
import me.tvspark.C2321l5;
import me.tvspark.C2358m5;
import me.tvspark.C2374ml;
import me.tvspark.C2395n5;
import me.tvspark.C2432o5;
import me.tvspark.C2512q5;
import me.tvspark.C2549r5;
import me.tvspark.C2658u3;
import me.tvspark.C2774x4;
import me.tvspark.C2811y4;
import me.tvspark.C2827yk;
import me.tvspark.C2848z4;
import me.tvspark.Illllllllllllllllllllllllllll;
import me.tvspark.outline;
import org.apache.commons.lang3.time.StopWatch;
import org.eclipse.jetty.server.AsyncContinuation;
import org.mozilla.javascript.regexp.NativeRegExp;
import org.mozilla.javascript.v8dtoa.FastDtoa;

/* loaded from: classes3.dex */
public final class DefaultAudioSink implements AudioSink {
    public boolean Kkkkkkkkk;
    public boolean Kkkkkkkkkk;
    public long Kkkkkkkkkkk;
    public boolean Kkkkkkkkkkkk;
    public C2099f5 Kkkkkkkkkkkkk;
    public int Kkkkkkkkkkkkkk;
    public boolean Kkkkkkkkkkkkkkk;
    public boolean Kkkkkkkkkkkkkkkk;
    public boolean Kkkkkkkkkkkkkkkkk;
    public int Kkkkkkkkkkkkkkkkkk;
    public int Kkkkkkkkkkkkkkkkkkk;
    public byte[] Kkkkkkkkkkkkkkkkkkkk;
    @Nullable
    public ByteBuffer Kkkkkkkkkkkkkkkkkkkkk;
    public int Kkkkkkkkkkkkkkkkkkkkkk;
    @Nullable
    public ByteBuffer Kkkkkkkkkkkkkkkkkkkkkkk;
    public ByteBuffer[] Kkkkkkkkkkkkkkkkkkkkkkkk;
    public AudioProcessor[] Kkkkkkkkkkkkkkkkkkkkkkkkk;
    public float Kkkkkkkkkkkkkkkkkkkkkkkkkk;
    public long Www;
    public boolean Wwww;
    public boolean Wwwww;
    public int Wwwwww;
    public long Wwwwwww;
    public long Wwwwwwww;
    public long Wwwwwwwww;
    public long Wwwwwwwwww;
    public int Wwwwwwwwwww;
    @Nullable
    public ByteBuffer Wwwwwwwwwwww;
    public C2658u3 Wwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwww;
    @Nullable
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwww;
    public C2848z4 Wwwwwwwwwwwwwwww;
    @Nullable
    public AudioTrack Wwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwww;
    @Nullable
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwww;
    @Nullable
    public AudioTrack Wwwwwwwwwwwwwwwwwwww;
    @Nullable
    public AudioSink.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwww;
    public final ArrayDeque<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2062e5 Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public final ConditionVariable Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final AudioProcessor[] Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final AudioProcessor[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2549r5 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2173h5 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final C1897a5 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes3.dex */
    public static final class InvalidAudioTrackTimestampException extends RuntimeException {
        public InvalidAudioTrackTimestampException(String str) {
            super(str);
        }

        public /* synthetic */ InvalidAudioTrackTimestampException(String str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this(str);
        }
    }

    @RequiresApi(29)
    /* loaded from: classes3.dex */
    public final class Wwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final AudioTrack.StreamEventCallback Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final Handler Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Handler();

        /* loaded from: classes3.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AudioTrack.StreamEventCallback {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwww, DefaultAudioSink defaultAudioSink) {
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww(DefaultAudioSink defaultAudioSink) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, defaultAudioSink);
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AudioTrack audioTrack) {
            audioTrack.unregisterStreamEventCallback(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.removeCallbacksAndMessages(null);
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AudioTrack audioTrack) {
            final Handler handler = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            Objects.requireNonNull(handler);
            audioTrack.registerStreamEventCallback(new Executor() { // from class: me.tvspark.v4
                @Override // java.util.concurrent.Executor
                public final void execute(Runnable runnable) {
                    handler.post(runnable);
                }
            }, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final C2658u3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2658u3 c2658u3, boolean z, long j, long j2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2658u3;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j2;
        }
    }

    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        AudioProcessor[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j);

        C2658u3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2658u3 c2658u3);

        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z);
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Thread {
        public final /* synthetic */ AudioTrack Wwwwwwwwwwwwwwwwwwwwwwww;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, AudioTrack audioTrack) {
            super(str);
            this.Wwwwwwwwwwwwwwwwwwwwwwww = audioTrack;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.flush();
                this.Wwwwwwwwwwwwwwwwwwwwwwww.release();
            } finally {
                DefaultAudioSink.this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.open();
            }
        }
    }

    public DefaultAudioSink(@Nullable C1897a5 c1897a5, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, boolean z, boolean z2, boolean z3) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c1897a5;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 21 && z;
            this.Wwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 23 && z2;
            this.Wwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 29 && z3;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = new ConditionVariable(true);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = new C2062e5(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(null));
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2173h5();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2549r5();
            ArrayList arrayList = new ArrayList();
            Collections.addAll(arrayList, new C2395n5(), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            Collections.addAll(arrayList, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[0]);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new AudioProcessor[]{new C2284k5()};
            this.Kkkkkkkkkkkkkkkkkkkkkkkkkk = 1.0f;
            this.Wwwwwwwwwwwwwwww = C2848z4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Kkkkkkkkkkkkkk = 0;
            this.Kkkkkkkkkkkkk = new C2099f5(0, 0.0f);
            this.Wwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2658u3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, false, 0L, 0L, null);
            this.Wwwwwwwwwwwww = C2658u3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Kkkkkkkkkkkkkkkkkk = -1;
            this.Kkkkkkkkkkkkkkkkkkkkkkkkk = new AudioProcessor[0];
            this.Kkkkkkkkkkkkkkkkkkkkkkkk = new ByteBuffer[0];
            this.Wwwwwwwwwwwwwwwwwwwwwwwww = new ArrayDeque<>();
            return;
        }
        throw null;
    }

    @RequiresApi(21)
    public static AudioFormat Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3) {
        return new AudioFormat.Builder().setSampleRate(i).setChannelMask(i2).setEncoding(i3).build();
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AudioTrack audioTrack) {
        return C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 29 && audioTrack.isOffloadedPlayback();
    }

    public final void Wwwwwwwwwwwwwwwww() {
        if (!Wwwwwwwwwwwwwwwwwwwww()) {
            return;
        }
        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 21) {
            this.Wwwwwwwwwwwwwwwww.setVolume(this.Kkkkkkkkkkkkkkkkkkkkkkkkkk);
            return;
        }
        AudioTrack audioTrack = this.Wwwwwwwwwwwwwwwww;
        float f = this.Kkkkkkkkkkkkkkkkkkkkkkkkkk;
        audioTrack.setStereoVolume(f, f);
    }

    public final void Wwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwww = 0L;
        this.Wwwwwwwww = 0L;
        this.Wwwwwwww = 0L;
        this.Wwwwwww = 0L;
        this.Kkkkkkkkk = false;
        this.Wwwwww = 0;
        this.Wwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwww(), Wwwwwwwwwwwwwwwwwwwwwwww(), 0L, 0L, null);
        this.Www = 0L;
        this.Wwwwwwwwwwwwwww = null;
        this.Wwwwwwwwwwwwwwwwwwwwwwwww.clear();
        this.Kkkkkkkkkkkkkkkkkkkkkkk = null;
        this.Kkkkkkkkkkkkkkkkkkkkkk = 0;
        this.Kkkkkkkkkkkkkkkkkkkkk = null;
        this.Kkkkkkkkkkkkkkkk = false;
        this.Kkkkkkkkkkkkkkkkk = false;
        this.Kkkkkkkkkkkkkkkkkk = -1;
        this.Wwwwwwwwwwww = null;
        this.Wwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww = 0L;
        Wwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public final void Wwwwwwwwwwwwwwwwwww() {
        if (!this.Kkkkkkkkkkkkkkkk) {
            this.Kkkkkkkkkkkkkkkk = true;
            C2062e5 c2062e5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
            long Wwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwww();
            c2062e5.Wwwwwwwww = c2062e5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            c2062e5.Wwwwwwwwwww = SystemClock.elapsedRealtime() * 1000;
            c2062e5.Wwwwwwww = Wwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwww.stop();
            this.Wwwwwwwwwww = 0;
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwww() {
        if (!(this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 1)) {
            return;
        }
        this.Kkkkkkkkkk = true;
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwww != null;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwww() throws AudioSink.InitializationException {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.block();
        try {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwww;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            AudioTrack Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkk, this.Wwwwwwwwwwwwwwww, this.Kkkkkkkkkkkkkk);
            this.Wwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2)) {
                AudioTrack audioTrack = this.Wwwwwwwwwwwwwwwww;
                if (this.Wwwwwwwwwwwwwwwwwwwwww == null) {
                    this.Wwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
                }
                this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(audioTrack);
                AudioTrack audioTrack2 = this.Wwwwwwwwwwwwwwwww;
                C2245j3 c2245j3 = this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                audioTrack2.setOffloadDelayPadding(c2245j3.Kkkkkkkkkkkkkkkkkkkkk, c2245j3.Kkkkkkkkkkkkkkkkkkkk);
            }
            final int audioSessionId = this.Wwwwwwwwwwwwwwwww.getAudioSessionId();
            if (this.Kkkkkkkkkkkkkk != audioSessionId) {
                this.Kkkkkkkkkkkkkk = audioSessionId;
                AudioSink.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwww;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    C2321l5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (C2321l5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    final AbstractC1971c5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2321l5.this.IIl;
                    Handler handler = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (handler != null) {
                        handler.post(new Runnable() { // from class: me.tvspark.q4
                            @Override // java.lang.Runnable
                            public final void run() {
                                AbstractC1971c5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(audioSessionId);
                            }
                        });
                    }
                    if (C2321l5.this == null) {
                        throw null;
                    }
                }
            }
            C2062e5 c2062e5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
            AudioTrack audioTrack3 = this.Wwwwwwwwwwwwwwwww;
            boolean z = this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 2;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwww;
            c2062e5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(audioTrack3, z, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwww();
            int i = this.Kkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i != 0) {
                this.Wwwwwwwwwwwwwwwww.attachAuxEffect(i);
                this.Wwwwwwwwwwwwwwwww.setAuxEffectSendLevel(this.Kkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            this.Wwww = true;
        } catch (AudioSink.InitializationException e) {
            Wwwwwwwwwwwwwwwwwwww();
            throw e;
        }
    }

    public final long Wwwwwwwwwwwwwwwwwwwwwww() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwww;
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0 ? this.Wwwwwwww / wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : this.Wwwwwww;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwww() {
        return Wwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwww() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwww;
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null ? wwwwwwwwwwwwwwwwwwwwwwwwwwwwww : !this.Wwwwwwwwwwwwwwwwwwwwwwwww.isEmpty() ? this.Wwwwwwwwwwwwwwwwwwwwwwwww.getLast() : this.Wwwwwwwwwwwwww;
    }

    public final C2658u3 Wwwwwwwwwwwwwwwwwwwwwwwwww() {
        return Wwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i = 0;
        while (true) {
            AudioProcessor[] audioProcessorArr = this.Kkkkkkkkkkkkkkkkkkkkkkkkk;
            if (i < audioProcessorArr.length) {
                AudioProcessor audioProcessor = audioProcessorArr[i];
                audioProcessor.flush();
                this.Kkkkkkkkkkkkkkkkkkkkkkkk[i] = audioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                i++;
            } else {
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwww = true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Kkkkkkkkkkkk) {
            this.Kkkkkkkkkkkk = false;
            this.Kkkkkkkkkkkkkk = 0;
            flush();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return Wwwwwwwwwwwwwwwwwwwww() && this.Wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwww());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws AudioSink.WriteException {
        if (this.Kkkkkkkkkkkkkkkkk || !Wwwwwwwwwwwwwwwwwwwww() || !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return;
        }
        Wwwwwwwwwwwwwwwwwww();
        this.Kkkkkkkkkkkkkkkkk = true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public C2658u3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww ? this.Wwwwwwwwwwwww : Wwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3) {
        boolean z = true;
        if ("audio/raw".equals(c2245j3.Wwwwwwwwwwwww)) {
            if (!C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3.Kkkkkkkkkkkkkkkkkkkkkk)) {
                return 0;
            }
            int i = c2245j3.Kkkkkkkkkkkkkkkkkkkkkk;
            return (i == 2 || (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && i == 4)) ? 2 : 1;
        } else if (this.Wwwwwwwwwwwwwwwwwwwwwww && !this.Kkkkkkkkkk && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3, this.Wwwwwwwwwwwwwwww)) {
            return 2;
        } else {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) == null) {
                z = false;
            }
            return z ? 2 : 0;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 21);
        if (!this.Kkkkkkkkkkkk || this.Kkkkkkkkkkkkkk != i) {
            this.Kkkkkkkkkkkk = true;
            this.Kkkkkkkkkkkkkk = i;
            flush();
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) throws AudioSink.WriteException {
        ByteBuffer byteBuffer;
        int length = this.Kkkkkkkkkkkkkkkkkkkkkkkkk.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                byteBuffer = this.Kkkkkkkkkkkkkkkkkkkkkkkk[i - 1];
            } else {
                byteBuffer = this.Kkkkkkkkkkkkkkkkkkkkkkk;
                if (byteBuffer == null) {
                    byteBuffer = AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
            }
            if (i == length) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer, j);
            } else {
                AudioProcessor audioProcessor = this.Kkkkkkkkkkkkkkkkkkkkkkkkk[i];
                audioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer);
                ByteBuffer Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = audioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                this.Kkkkkkkkkkkkkkkkkkkkkkkk[i] = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.hasRemaining()) {
                    i++;
                }
            }
            if (byteBuffer.hasRemaining()) {
                return;
            }
            i--;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwww(), z);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0029 -> B:4:0x0009). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws AudioSink.WriteException {
        boolean z;
        int i;
        AudioProcessor[] audioProcessorArr;
        if (this.Kkkkkkkkkkkkkkkkkk == -1) {
            this.Kkkkkkkkkkkkkkkkkk = 0;
            z = true;
            i = this.Kkkkkkkkkkkkkkkkkk;
            audioProcessorArr = this.Kkkkkkkkkkkkkkkkkkkkkkkkk;
            if (i < audioProcessorArr.length) {
                AudioProcessor audioProcessor = audioProcessorArr[i];
                if (z) {
                    audioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-9223372036854775807L);
                if (!audioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    return false;
                }
                this.Kkkkkkkkkkkkkkkkkk++;
                z = true;
                i = this.Kkkkkkkkkkkkkkkkkk;
                audioProcessorArr = this.Kkkkkkkkkkkkkkkkkkkkkkkkk;
                if (i < audioProcessorArr.length) {
                    ByteBuffer byteBuffer = this.Kkkkkkkkkkkkkkkkkkkkk;
                    if (byteBuffer != null) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer, -9223372036854775807L);
                        if (this.Kkkkkkkkkkkkkkkkkkkkk != null) {
                            return false;
                        }
                    }
                    this.Kkkkkkkkkkkkkkkkkk = -1;
                    return true;
                }
            }
        } else {
            z = false;
            i = this.Kkkkkkkkkkkkkkkkkk;
            audioProcessorArr = this.Kkkkkkkkkkkkkkkkkkkkkkkkk;
            if (i < audioProcessorArr.length) {
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f) {
        if (this.Kkkkkkkkkkkkkkkkkkkkkkkkkk != f) {
            this.Kkkkkkkkkkkkkkkkkkkkkkkkkk = f;
            Wwwwwwwwwwwwwwwww();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        if (this.Kkkkkkkkkkkkkk != i) {
            this.Kkkkkkkkkkkkkk = i;
            flush();
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        final AbstractC1971c5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Handler handler;
        C2658u3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww ? this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwww()) : C2658u3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww ? this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwww()) : false;
        this.Wwwwwwwwwwwwwwwwwwwwwwwww.add(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, Math.max(0L, j), this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwww()), null));
        AudioProcessor[] audioProcessorArr = this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww;
        ArrayList arrayList = new ArrayList();
        for (AudioProcessor audioProcessor : audioProcessorArr) {
            if (audioProcessor.isActive()) {
                arrayList.add(audioProcessor);
            } else {
                audioProcessor.flush();
            }
        }
        int size = arrayList.size();
        this.Kkkkkkkkkkkkkkkkkkkkkkkkk = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[size]);
        this.Kkkkkkkkkkkkkkkkkkkkkkkk = new ByteBuffer[size];
        Wwwwwwwwwwwwwwwwwwwwwwwwwww();
        AudioSink.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null || (handler = (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2321l5.this.IIl).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: me.tvspark.t4
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC1971c5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
            }
        });
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AudioSink.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2099f5 c2099f5) {
        if (this.Kkkkkkkkkkkkk.equals(c2099f5)) {
            return;
        }
        int i = c2099f5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        float f = c2099f5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        AudioTrack audioTrack = this.Wwwwwwwwwwwwwwwww;
        if (audioTrack != null) {
            if (this.Kkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != i) {
                audioTrack.attachAuxEffect(i);
            }
            if (i != 0) {
                this.Wwwwwwwwwwwwwwwww.setAuxEffectSendLevel(f);
            }
        }
        this.Kkkkkkkkkkkkk = c2099f5;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2658u3 c2658u3) {
        C2658u3 c2658u32 = new C2658u3(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2658u3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0.1f, 8.0f), C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2658u3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0.1f, 8.0f));
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwww || C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 23) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2658u32, Wwwwwwwwwwwwwwwwwwwwwwww());
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2658u32);
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2658u3 c2658u3, boolean z) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwww();
        if (!c2658u3.equals(Wwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) || z != Wwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2658u3, z, -9223372036854775807L, -9223372036854775807L, null);
            if (Wwwwwwwwwwwwwwwwwwwww()) {
                this.Wwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            } else {
                this.Wwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2848z4 c2848z4) {
        if (this.Wwwwwwwwwwwwwwww.equals(c2848z4)) {
            return;
        }
        this.Wwwwwwwwwwwwwwww = c2848z4;
        if (this.Kkkkkkkkkkkk) {
            return;
        }
        flush();
        this.Kkkkkkkkkkkkkk = 0;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return !Wwwwwwwwwwwwwwwwwwwww() || (this.Kkkkkkkkkkkkkkkkk && !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3) != 0;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void flush() {
        if (Wwwwwwwwwwwwwwwwwwwww()) {
            Wwwwwwwwwwwwwwwwww();
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                this.Wwwwwwwwwwwwwwwww.pause();
            }
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwww)) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwww;
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwww);
                wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwww);
            }
            AudioTrack audioTrack = this.Wwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwww = null;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                this.Wwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwww = null;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.close();
            new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("ExoPlayer:AudioTrackReleaseThread", audioTrack).start();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void pause() {
        boolean z = false;
        this.Kkkkkkkkkkkkkkk = false;
        if (Wwwwwwwwwwwwwwwwwwwww()) {
            C2062e5 c2062e5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
            c2062e5.Wwwwwwwwwwwwwwwwwwwwwww = 0L;
            c2062e5.Wwwwwwwwwwww = 0;
            c2062e5.Wwwwwwwwwwwww = 0;
            c2062e5.Wwwwwwwwwwwwwwwwwwwwww = 0L;
            c2062e5.Wwwwww = 0L;
            c2062e5.Www = 0L;
            c2062e5.Wwwwwwwwwwwwwwwwwwwwwwww = false;
            if (c2062e5.Wwwwwwwwwww == -9223372036854775807L) {
                C2008d5 c2008d5 = c2062e5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2008d5);
                c2008d5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                z = true;
            }
            if (!z) {
                return;
            }
            this.Wwwwwwwwwwwwwwwww.pause();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void play() {
        this.Kkkkkkkkkkkkkkk = true;
        if (Wwwwwwwwwwwwwwwwwwwww()) {
            C2008d5 c2008d5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2008d5);
            c2008d5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwwwwwwwww.play();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void reset() {
        flush();
        AudioTrack audioTrack = this.Wwwwwwwwwwwwwwwwwwww;
        if (audioTrack != null) {
            this.Wwwwwwwwwwwwwwwwwwww = null;
            new C2210i5(audioTrack).start();
        }
        for (AudioProcessor audioProcessor : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            audioProcessor.reset();
        }
        for (AudioProcessor audioProcessor2 : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            audioProcessor2.reset();
        }
        this.Kkkkkkkkkkkkkk = 0;
        this.Kkkkkkkkkkkkkkk = false;
        this.Kkkkkkkkkk = false;
    }

    @RequiresApi(23)
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2658u3 c2658u3) {
        if (Wwwwwwwwwwwwwwwwwwwww()) {
            try {
                this.Wwwwwwwwwwwwwwwww.setPlaybackParams(new PlaybackParams().allowDefaults().setSpeed(c2658u3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).setPitch(c2658u3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).setAudioFallbackMode(2));
            } catch (IllegalArgumentException e) {
                C2827yk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Failed to set playback params", e);
            }
            c2658u3 = new C2658u3(this.Wwwwwwwwwwwwwwwww.getPlaybackParams().getSpeed(), this.Wwwwwwwwwwwwwwwww.getPlaybackParams().getPitch());
            C2062e5 c2062e5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
            c2062e5.Wwwwwwwwwwwwwwwwwwwwwwwww = c2658u3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            C2008d5 c2008d5 = c2062e5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (c2008d5 != null) {
                c2008d5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }
        this.Wwwwwwwwwwwww = c2658u3;
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final C2512q5 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final C2432o5 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final AudioProcessor[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AudioProcessor... audioProcessorArr) {
            C2432o5 c2432o5 = new C2432o5();
            C2512q5 c2512q5 = new C2512q5();
            AudioProcessor[] audioProcessorArr2 = new AudioProcessor[audioProcessorArr.length + 2];
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = audioProcessorArr2;
            System.arraycopy(audioProcessorArr, 0, audioProcessorArr2, 0, audioProcessorArr.length);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2432o5;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2512q5;
            AudioProcessor[] audioProcessorArr3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            audioProcessorArr3[audioProcessorArr.length] = c2432o5;
            audioProcessorArr3[audioProcessorArr.length + 1] = c2512q5;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public AudioProcessor[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public C2658u3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2658u3 c2658u3) {
            C2512q5 c2512q5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            float f = c2658u3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (c2512q5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != f) {
                c2512q5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f;
                c2512q5.Wwwwwwwwwwwwwwwwwwwwwwwwww = true;
            }
            C2512q5 c2512q52 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            float f2 = c2658u3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (c2512q52.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != f2) {
                c2512q52.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f2;
                c2512q52.Wwwwwwwwwwwwwwwwwwwwwwwwww = true;
            }
            return new C2658u3(f, f2);
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww = z;
            return z;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
            C2512q5 c2512q5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            long j2 = c2512q5.Wwwwwwwwwwwwwwwwwwww;
            if (j2 >= 1024) {
                int i = c2512q5.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i2 = c2512q5.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                long j3 = c2512q5.Wwwwwwwwwwwwwwwwwwwww;
                return i == i2 ? C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, j3, j2) : C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, j3 * i, j2 * i2);
            }
            return (long) (c2512q5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww * j);
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwww;
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final AudioProcessor[] Wwwwwwwwwwwwwwwwwwwwwwwww;
        public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3, int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, boolean z2, AudioProcessor[] audioProcessorArr) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2245j3;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i4;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = i5;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i6;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = z2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwww = audioProcessorArr;
            if (i7 == 0) {
                long j = 250000;
                boolean z3 = true;
                if (i2 != 0) {
                    if (i2 == 1) {
                        j = 50000000;
                    } else if (i2 != 2) {
                        throw new IllegalStateException();
                    }
                    i7 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
                } else {
                    float f = z ? 8.0f : 1.0f;
                    int minBufferSize = AudioTrack.getMinBufferSize(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(minBufferSize == -2 ? false : z3);
                    long j2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int i8 = (int) ((250000 * j2) / StopWatch.NANO_2_MILLIS);
                    int i9 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(minBufferSize * 4, i8 * i9, Math.max(minBufferSize, ((int) ((j2 * 750000) / StopWatch.NANO_2_MILLIS)) * i9));
                    i7 = f != 1.0f ? Math.round(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww * f) : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = i7;
        }

        @RequiresApi(21)
        public static AudioAttributes Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2848z4 c2848z4, boolean z) {
            if (z) {
                return new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
            }
            return c2848z4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        @RequiresApi(29)
        public final AudioTrack Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, C2848z4 c2848z4, int i) {
            AudioFormat Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = DefaultAudioSink.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
            AudioAttributes Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2848z4, z);
            boolean z2 = true;
            AudioTrack.Builder sessionId = new AudioTrack.Builder().setAudioAttributes(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2).setAudioFormat(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).setTransferMode(1).setBufferSizeInBytes(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww).setSessionId(i);
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 1) {
                z2 = false;
            }
            return sessionId.setOffloadedPlayback(z2).build();
        }

        public final AudioTrack Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, C2848z4 c2848z4, int i) {
            int i2 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i2 >= 29) {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z, c2848z4, i);
            }
            if (i2 >= 21) {
                return new AudioTrack(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2848z4, z), DefaultAudioSink.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww), this.Wwwwwwwwwwwwwwwwwwwwwwwwwww, 1, i);
            }
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2848z4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i6 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
            return i == 0 ? new AudioTrack(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i3, i4, i5, i6, 1) : new AudioTrack(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i3, i4, i5, i6, 1, i);
        }

        public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
            return (j * StopWatch.NANO_2_MILLIS) / this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        public AudioTrack Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, C2848z4 c2848z4, int i) throws AudioSink.InitializationException {
            try {
                AudioTrack Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z, c2848z4, i);
                int state = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getState();
                if (state == 1) {
                    return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
                try {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.release();
                } catch (Exception unused) {
                }
                throw new AudioSink.InitializationException(state, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
            } catch (UnsupportedOperationException unused2) {
                throw new AudioSink.InitializationException(0, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }

        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
            int i;
            switch (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                case 5:
                    i = 80000;
                    break;
                case 6:
                case 18:
                    i = 768000;
                    break;
                case 7:
                    i = 192000;
                    break;
                case 8:
                    i = 2250000;
                    break;
                case 9:
                    i = 40000;
                    break;
                case 10:
                    i = FastDtoa.kTen5;
                    break;
                case 11:
                    i = 16000;
                    break;
                case 12:
                    i = 7000;
                    break;
                case 13:
                default:
                    throw new IllegalArgumentException();
                case 14:
                    i = 3062500;
                    break;
                case 15:
                    i = WebIndicator.MAX_UNIFORM_SPEED_DURATION;
                    break;
                case 16:
                    i = 256000;
                    break;
                case 17:
                    i = 336000;
                    break;
            }
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww == 5) {
                i *= 2;
            }
            return (int) ((j * i) / StopWatch.NANO_2_MILLIS);
        }
    }

    /* loaded from: classes3.dex */
    public final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwww implements C2062e5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        @Override // me.tvspark.C2062e5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        }

        @Override // me.tvspark.C2062e5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2, long j3, long j4) {
            DefaultAudioSink defaultAudioSink = DefaultAudioSink.this;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = defaultAudioSink.Wwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0) {
                long j5 = defaultAudioSink.Wwwwwwwwww / wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            DefaultAudioSink.this.Wwwwwwwwwwwwwwwwwwwwwww();
        }

        @Override // me.tvspark.C2062e5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(final long j) {
            final AbstractC1971c5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            Handler handler;
            AudioSink.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = DefaultAudioSink.this.Wwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null || (handler = (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2321l5.this.IIl).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) == null) {
                return;
            }
            handler.post(new Runnable() { // from class: me.tvspark.n4
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractC1971c5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
                }
            });
        }

        @Override // me.tvspark.C2062e5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2, long j3, long j4) {
            DefaultAudioSink defaultAudioSink = DefaultAudioSink.this;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = defaultAudioSink.Wwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0) {
                long j5 = defaultAudioSink.Wwwwwwwwww / wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            DefaultAudioSink.this.Wwwwwwwwwwwwwwwwwwwwwww();
        }

        @Override // me.tvspark.C2062e5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(final int i, final long j) {
            if (DefaultAudioSink.this.Wwwwwwwwwwwwwwwwwwwww != null) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                DefaultAudioSink defaultAudioSink = DefaultAudioSink.this;
                final long j2 = elapsedRealtime - defaultAudioSink.Kkkkkkkkkkk;
                final AbstractC1971c5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2321l5.this.IIl;
                Handler handler = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (handler == null) {
                    return;
                }
                handler.post(new Runnable() { // from class: me.tvspark.s4
                    @Override // java.lang.Runnable
                    public final void run() {
                        AbstractC1971c5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, j, j2);
                    }
                });
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3, int i, @Nullable int[] iArr) throws AudioSink.ConfigurationException {
        AudioProcessor[] audioProcessorArr;
        int intValue;
        int i2;
        int i3;
        int i4;
        boolean z;
        int i5;
        int i6;
        int[] iArr2;
        if ("audio/raw".equals(c2245j3.Wwwwwwwwwwwww)) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3.Kkkkkkkkkkkkkkkkkkkkkk));
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3.Kkkkkkkkkkkkkkkkkkkkkk, c2245j3.Kkkkkkkkkkkkkkkkkkkkkkkk);
            boolean z2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3.Kkkkkkkkkkkkkkkkkkkkkk);
            AudioProcessor[] audioProcessorArr2 = z2 ? this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            boolean z3 = !z2;
            C2549r5 c2549r5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i7 = c2245j3.Kkkkkkkkkkkkkkkkkkkkk;
            int i8 = c2245j3.Kkkkkkkkkkkkkkkkkkkk;
            c2549r5.Wwwwwwwwwwwwwwwwwwwwwwwwww = i7;
            c2549r5.Wwwwwwwwwwwwwwwwwwwwwwwww = i8;
            if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 21 && c2245j3.Kkkkkkkkkkkkkkkkkkkkkkkk == 8 && iArr == null) {
                iArr2 = new int[6];
                for (int i9 = 0; i9 < 6; i9++) {
                    iArr2[i9] = i9;
                }
            } else {
                iArr2 = iArr;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww = iArr2;
            AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3.Kkkkkkkkkkkkkkkkkkkkkkk, c2245j3.Kkkkkkkkkkkkkkkkkkkkkkkk, c2245j3.Kkkkkkkkkkkkkkkkkkkkkk);
            for (AudioProcessor audioProcessor : audioProcessorArr2) {
                try {
                    AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = audioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    if (audioProcessor.isActive()) {
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                    }
                } catch (AudioProcessor.UnhandledAudioFormatException e) {
                    throw new AudioSink.ConfigurationException(e);
                }
            }
            int i10 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            i5 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            intValue = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            z = z3;
            audioProcessorArr = audioProcessorArr2;
            i2 = i10;
            i6 = 0;
            i4 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i10, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            i3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        } else {
            AudioProcessor[] audioProcessorArr3 = new AudioProcessor[0];
            int i11 = c2245j3.Kkkkkkkkkkkkkkkkkkkkkkk;
            if (!this.Wwwwwwwwwwwwwwwwwwwwwww || !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3, this.Wwwwwwwwwwwwwwww)) {
                Pair<Integer, Integer> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == null) {
                    String valueOf = String.valueOf(c2245j3);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 37);
                    sb.append("Unable to configure passthrough for: ");
                    sb.append(valueOf);
                    throw new AudioSink.ConfigurationException(sb.toString());
                }
                int intValue2 = ((Integer) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.first).intValue();
                audioProcessorArr = audioProcessorArr3;
                intValue = ((Integer) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.second).intValue();
                i2 = intValue2;
                i3 = -1;
                i4 = -1;
                z = false;
                i5 = i11;
                i6 = 2;
            } else {
                String str = c2245j3.Wwwwwwwwwwwww;
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
                audioProcessorArr = audioProcessorArr3;
                i2 = C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, c2245j3.Wwwwwwwwwwwwwwww);
                intValue = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3.Kkkkkkkkkkkkkkkkkkkkkkkk);
                i3 = -1;
                i4 = -1;
                z = false;
                i5 = i11;
                i6 = 1;
            }
        }
        if (i2 == 0) {
            String valueOf2 = String.valueOf(c2245j3);
            StringBuilder sb2 = new StringBuilder(valueOf2.length() + 48);
            sb2.append("Invalid output encoding (mode=");
            sb2.append(i6);
            sb2.append(") for: ");
            sb2.append(valueOf2);
            throw new AudioSink.ConfigurationException(sb2.toString());
        } else if (intValue == 0) {
            String valueOf3 = String.valueOf(c2245j3);
            StringBuilder sb3 = new StringBuilder(valueOf3.length() + 54);
            sb3.append("Invalid output channel config (mode=");
            sb3.append(i6);
            sb3.append(") for: ");
            sb3.append(valueOf3);
            throw new AudioSink.ConfigurationException(sb3.toString());
        } else {
            this.Kkkkkkkkkk = false;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3, i3, i6, i4, i5, intValue, i2, i, this.Wwwwwwwwwwwwwwwwwwwwwwww, z, audioProcessorArr);
            if (Wwwwwwwwwwwwwwwwwwwww()) {
                this.Wwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            } else {
                this.Wwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x00c7, code lost:
        if (r10 != false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00ca, code lost:
        if (r10 == false) goto L74;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01a5 A[Catch: Exception -> 0x01ad, TRY_LEAVE, TryCatch #0 {Exception -> 0x01ad, blocks: (B:67:0x017a, B:69:0x01a5), top: B:66:0x017a }] */
    @Override // com.google.android.exoplayer2.audio.AudioSink
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        long j;
        boolean z2;
        Method method;
        Integer num;
        long max;
        if (!Wwwwwwwwwwwwwwwwwwwww() || this.Wwww) {
            return Long.MIN_VALUE;
        }
        C2062e5 c2062e5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        AudioTrack audioTrack = c2062e5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(audioTrack);
        if (audioTrack.getPlayState() == 3) {
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2062e5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2062e5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != 0) {
                long nanoTime = System.nanoTime() / 1000;
                if (nanoTime - c2062e5.Wwwwwwwwwwwwwwwwwwwwww >= AsyncContinuation.DEFAULT_TIMEOUT) {
                    long[] jArr = c2062e5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int i = c2062e5.Wwwwwwwwwwwww;
                    jArr[i] = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 - nanoTime;
                    c2062e5.Wwwwwwwwwwwww = (i + 1) % 10;
                    int i2 = c2062e5.Wwwwwwwwwwww;
                    if (i2 < 10) {
                        c2062e5.Wwwwwwwwwwww = i2 + 1;
                    }
                    c2062e5.Wwwwwwwwwwwwwwwwwwwwww = nanoTime;
                    c2062e5.Wwwwwwwwwwwwwwwwwwwwwww = 0L;
                    int i3 = 0;
                    while (true) {
                        int i4 = c2062e5.Wwwwwwwwwwww;
                        if (i3 >= i4) {
                            break;
                        }
                        c2062e5.Wwwwwwwwwwwwwwwwwwwwwww = (c2062e5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i3] / i4) + c2062e5.Wwwwwwwwwwwwwwwwwwwwwww;
                        i3++;
                    }
                }
                if (!c2062e5.Wwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    C2008d5 c2008d5 = c2062e5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2008d5);
                    C2008d5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2008d5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null && nanoTime - c2008d5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= c2008d5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        c2008d5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = nanoTime;
                        z2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getTimestamp(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        if (z2) {
                            long j2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.framePosition;
                            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > j2) {
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
                            }
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j2;
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j2 + (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww << 32);
                        }
                        int i5 = c2008d5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (i5 != 0) {
                            if (i5 == 1) {
                                if (z2) {
                                    if (c2008d5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww > c2008d5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                                        c2008d5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                                    }
                                }
                                c2008d5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            } else if (i5 != 2) {
                                if (i5 != 3) {
                                    if (i5 != 4) {
                                        throw new IllegalStateException();
                                    }
                                }
                            }
                        } else if (z2) {
                            C2008d5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2008d5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.nanoTime / 1000 >= c2008d5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                                c2008d5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                c2008d5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                            }
                        } else if (nanoTime - c2008d5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > 500000) {
                            c2008d5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
                        }
                        if (z2) {
                            C2008d5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = c2008d5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            long j3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != null ? wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.nanoTime / 1000 : -9223372036854775807L;
                            C2008d5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = c2008d5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            long j4 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 != null ? wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww : -1L;
                            if (Math.abs(j3 - nanoTime) > 5000000) {
                                c2062e5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j4, j3, nanoTime, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                            } else if (Math.abs(c2062e5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j4) - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) > 5000000) {
                                c2062e5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j4, j3, nanoTime, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                            } else if (c2008d5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 4) {
                                c2008d5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            }
                            c2008d5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                        }
                        if (c2062e5.Wwwwwwwwwwwwwwwwww && (method = c2062e5.Wwwwwwwwwwwwwwwwwwwww) != null && nanoTime - c2062e5.Wwwwwwwwwwwwwwwww >= 500000) {
                            try {
                                AudioTrack audioTrack2 = c2062e5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(audioTrack2);
                                C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Integer) method.invoke(audioTrack2, new Object[0]));
                                long intValue = (num.intValue() * 1000) - c2062e5.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                                c2062e5.Wwwwwwwwwwwwwwwwwwww = intValue;
                                max = Math.max(intValue, 0L);
                                c2062e5.Wwwwwwwwwwwwwwwwwwww = max;
                                if (max > 5000000) {
                                    c2062e5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(max);
                                    c2062e5.Wwwwwwwwwwwwwwwwwwww = 0L;
                                }
                            } catch (Exception unused) {
                                c2062e5.Wwwwwwwwwwwwwwwwwwwww = null;
                            }
                            c2062e5.Wwwwwwwwwwwwwwwww = nanoTime;
                        }
                    }
                    z2 = false;
                    if (z2) {
                    }
                    if (c2062e5.Wwwwwwwwwwwwwwwwww) {
                        AudioTrack audioTrack22 = c2062e5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(audioTrack22);
                        C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Integer) method.invoke(audioTrack22, new Object[0]));
                        long intValue2 = (num.intValue() * 1000) - c2062e5.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                        c2062e5.Wwwwwwwwwwwwwwwwwwww = intValue2;
                        max = Math.max(intValue2, 0L);
                        c2062e5.Wwwwwwwwwwwwwwwwwwww = max;
                        if (max > 5000000) {
                        }
                        c2062e5.Wwwwwwwwwwwwwwwww = nanoTime;
                    }
                }
            }
        }
        long nanoTime2 = System.nanoTime() / 1000;
        C2008d5 c2008d52 = c2062e5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2008d52);
        boolean z3 = c2008d52.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 2;
        if (z3) {
            C2008d5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = c2008d52.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = c2062e5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 != null ? wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww : -1L);
            C2008d5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = c2008d52.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            j = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(nanoTime2 - (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 != null ? wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.nanoTime / 1000 : -9223372036854775807L), c2062e5.Wwwwwwwwwwwwwwwwwwwwwwwww) + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
        } else {
            if (c2062e5.Wwwwwwwwwwww == 0) {
                j = c2062e5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2062e5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            } else {
                j = c2062e5.Wwwwwwwwwwwwwwwwwwwwwww + nanoTime2;
            }
            if (!z) {
                j = Math.max(0L, j - c2062e5.Wwwwwwwwwwwwwwwwwwww);
            }
        }
        if (c2062e5.Wwwww != z3) {
            c2062e5.Www = c2062e5.Wwwwww;
            c2062e5.Wwww = c2062e5.Wwwwwww;
        }
        long j5 = nanoTime2 - c2062e5.Www;
        if (j5 < StopWatch.NANO_2_MILLIS) {
            long j6 = c2062e5.Wwww;
            long j7 = (j5 * 1000) / StopWatch.NANO_2_MILLIS;
            j = (((1000 - j7) * (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j5, c2062e5.Wwwwwwwwwwwwwwwwwwwwwwwww) + j6)) + (j * j7)) / 1000;
        }
        if (!c2062e5.Wwwwwwwwwwwwwwwwwwwwwwww) {
            long j8 = c2062e5.Wwwwwww;
            if (j > j8) {
                c2062e5.Wwwwwwwwwwwwwwwwwwwwwwww = true;
                c2062e5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(System.currentTimeMillis() - C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j - j8), c2062e5.Wwwwwwwwwwwwwwwwwwwwwwwww)));
            }
        }
        c2062e5.Wwwwww = nanoTime2;
        c2062e5.Wwwwwww = j;
        c2062e5.Wwwww = z3;
        long min = Math.min(j, this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwww()));
        while (!this.Wwwwwwwwwwwwwwwwwwwwwwwww.isEmpty() && min >= this.Wwwwwwwwwwwwwwwwwwwwwwwww.getFirst().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwww.remove();
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwww;
        long j9 = min - wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(C2658u3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
            j9 = this.Wwwwwwwwwwwwwwwwwwwwwwwww.isEmpty() ? this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j9) : C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j9, this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        return this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) + this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + j9;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0069 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x006a  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair<Integer, Integer> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3, @Nullable C1897a5 c1897a5) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        int i;
        if (c1897a5 == null) {
            return null;
        }
        String str = c2245j3.Wwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, c2245j3.Wwwwwwwwwwwwwwww);
        int i2 = 8;
        boolean z = false;
        if (!(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 5 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 6 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 18 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 17 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 7 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 8 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 14)) {
            return null;
        }
        int i3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 18 ? 6 : c2245j3.Kkkkkkkkkkkkkkkkkkkkkkkk;
        if (i3 > c1897a5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return null;
        }
        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww <= 28) {
            if (i3 != 7) {
                if (i3 == 3 || i3 == 4 || i3 == 5) {
                    i2 = 6;
                }
            }
            if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww <= 26 && "fugu".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && i2 == 1) {
                i2 = 2;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != 0) {
                return null;
            }
            if (!(Arrays.binarySearch(c1897a5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) >= 0)) {
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 18) {
                    if (Arrays.binarySearch(c1897a5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 6) >= 0) {
                        z = true;
                    }
                    if (z) {
                        i = 6;
                    }
                }
                return null;
            }
            i = Integer.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            return Pair.create(i, Integer.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2));
        }
        i2 = i3;
        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww <= 26) {
            i2 = 2;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != 0) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:173:0x00d4, code lost:
        if (r5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == 0) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f7  */
    @Override // com.google.android.exoplayer2.audio.AudioSink
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteBuffer byteBuffer, long j, int i) throws AudioSink.InitializationException, AudioSink.WriteException {
        boolean z;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        ByteBuffer byteBuffer2 = this.Kkkkkkkkkkkkkkkkkkkkkkk;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (this.Wwwwwwwwwwwwwwwwwww != null) {
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                return false;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwww;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = this.Wwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
                if (!(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww && wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww && wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww && wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                    Wwwwwwwwwwwwwwwwwww();
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                        return false;
                    }
                    flush();
                } else {
                    this.Wwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwww;
                    this.Wwwwwwwwwwwwwwwwwww = null;
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwww)) {
                        this.Wwwwwwwwwwwwwwwww.setOffloadEndOfStream();
                        AudioTrack audioTrack = this.Wwwwwwwwwwwwwwwww;
                        C2245j3 c2245j3 = this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        audioTrack.setOffloadDelayPadding(c2245j3.Kkkkkkkkkkkkkkkkkkkkk, c2245j3.Kkkkkkkkkkkkkkkkkkkk);
                        this.Kkkkkkkkk = true;
                    }
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
            } else {
                throw null;
            }
        }
        if (!Wwwwwwwwwwwwwwwwwwwww()) {
            Wwwwwwwwwwwwwwwwwwwwww();
        }
        if (this.Wwww) {
            this.Www = Math.max(0L, j);
            this.Wwwww = false;
            this.Wwww = false;
            if (this.Wwwwwwwwwwwwwwwwwwwwwwww && C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 23) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwww);
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
            if (this.Kkkkkkkkkkkkkkk) {
                play();
            }
        }
        C2062e5 c2062e5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        long Wwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwww();
        AudioTrack audioTrack2 = c2062e5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(audioTrack2);
        int playState = audioTrack2.getPlayState();
        if (c2062e5.Wwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (playState == 2) {
                c2062e5.Wwwwwwwwwwwwwwwwwww = false;
            } else if (playState == 1) {
            }
            z = false;
            if (z) {
                return false;
            }
            if (this.Kkkkkkkkkkkkkkkkkkkkkkk == null) {
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer.order() == ByteOrder.LITTLE_ENDIAN);
                if (!byteBuffer.hasRemaining()) {
                    return true;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = this.Wwwwwwwwwwwwwwwwww;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 0 && this.Wwwwww == 0) {
                    int i8 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    int i9 = 1024;
                    switch (i8) {
                        case 5:
                        case 6:
                        case 18:
                            int i10 = 3;
                            if (!(((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) > 10)) {
                                i9 = 1536;
                                break;
                            } else {
                                if (((byteBuffer.get(byteBuffer.position() + 4) & ExifInterface.MARKER_SOF0) >> 6) != 3) {
                                    i10 = (byteBuffer.get(byteBuffer.position() + 4) & NativeRegExp.REOP_MINIMALQUANT) >> 4;
                                }
                                i2 = C2774x4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i10] * 256;
                                i9 = i2;
                                break;
                            }
                        case 7:
                        case 8:
                            int position = byteBuffer.position();
                            byte b = byteBuffer.get(position);
                            if (b != -2) {
                                if (b == -1) {
                                    i3 = (byteBuffer.get(position + 4) & 7) << 4;
                                    i6 = position + 7;
                                } else if (b != 31) {
                                    i3 = (byteBuffer.get(position + 4) & 1) << 6;
                                    i4 = position + 5;
                                } else {
                                    i3 = (byteBuffer.get(position + 5) & 7) << 4;
                                    i6 = position + 6;
                                }
                                i5 = byteBuffer.get(i6) & 60;
                                i9 = (((i5 >> 2) | i3) + 1) * 32;
                                break;
                            } else {
                                i3 = (byteBuffer.get(position + 5) & 1) << 6;
                                i4 = position + 4;
                            }
                            i5 = byteBuffer.get(i4) & 252;
                            i9 = (((i5 >> 2) | i3) + 1) * 32;
                        case 9:
                            i9 = C2358m5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer, byteBuffer.position()));
                            if (i9 == -1) {
                                throw new IllegalArgumentException();
                            }
                            break;
                        case 10:
                        case 16:
                            break;
                        case 11:
                        case 12:
                            i9 = 2048;
                            break;
                        case 13:
                        default:
                            throw new IllegalStateException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(38, "Unexpected audio encoding: ", i8));
                        case 14:
                            int position2 = byteBuffer.position();
                            int limit = byteBuffer.limit() - 10;
                            int i11 = position2;
                            while (true) {
                                if (i11 > limit) {
                                    i7 = -1;
                                } else if ((C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer, i11 + 4) & (-2)) == -126718022) {
                                    i7 = i11 - position2;
                                } else {
                                    i11++;
                                }
                            }
                            if (i7 != -1) {
                                i2 = (40 << ((byteBuffer.get((byteBuffer.position() + i7) + ((byteBuffer.get((byteBuffer.position() + i7) + 7) & 255) == 187 ? 9 : 8)) >> 4) & 7)) * 16;
                                i9 = i2;
                                break;
                            } else {
                                i9 = 0;
                                break;
                            }
                        case 15:
                            i9 = 512;
                            break;
                        case 17:
                            byte[] bArr = new byte[16];
                            int position3 = byteBuffer.position();
                            byteBuffer.get(bArr);
                            byteBuffer.position(position3);
                            i9 = C2811y4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new C2041dl(bArr)).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            break;
                    }
                    this.Wwwwww = i9;
                    if (i9 == 0) {
                        return true;
                    }
                }
                if (this.Wwwwwwwwwwwwwww != null) {
                    if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                        return false;
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
                    this.Wwwwwwwwwwwwwww = null;
                }
                long j2 = ((((this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0 ? this.Wwwwwwwwww / wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : this.Wwwwwwwww) - this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww) * StopWatch.NANO_2_MILLIS) / wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkkkkkkkkkkkkkkkk) + this.Www;
                if (!this.Wwwww && Math.abs(j2 - j) > 200000) {
                    this.Wwwww = true;
                }
                if (this.Wwwww) {
                    if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                        return false;
                    }
                    long j3 = j - j2;
                    this.Www += j3;
                    this.Wwwww = false;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
                    AudioSink.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwww;
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null && j3 != 0) {
                        C2321l5.this.O000 = true;
                    }
                }
                if (this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0) {
                    this.Wwwwwwwwww += byteBuffer.remaining();
                } else {
                    this.Wwwwwwwww += this.Wwwwww * i;
                }
                this.Kkkkkkkkkkkkkkkkkkkkkkk = byteBuffer;
                this.Kkkkkkkkkkkkkkkkkkkkkk = i;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
            if (!this.Kkkkkkkkkkkkkkkkkkkkkkk.hasRemaining()) {
                this.Kkkkkkkkkkkkkkkkkkkkkkk = null;
                this.Kkkkkkkkkkkkkkkkkkkkkk = 0;
                return true;
            }
            C2062e5 c2062e52 = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
            if (!(c2062e52.Wwwwwwwwww != -9223372036854775807L && Wwwwwwwwwwwwwwwwwwwwwww() > 0 && SystemClock.elapsedRealtime() - c2062e52.Wwwwwwwwww >= 200)) {
                return false;
            }
            flush();
            return true;
        }
        boolean z2 = c2062e5.Wwwwwwwwwwwwwwwwwww;
        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2062e5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwww);
        c2062e5.Wwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        if (z2 && !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 && playState != 1) {
            c2062e5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2062e5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2062e5.Wwwwwwwwwwwwwwwwwwwwwwwwww));
        }
        z = true;
        if (z) {
        }
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3, C2848z4 c2848z4) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 29) {
            return false;
        }
        String str = c2245j3.Wwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, c2245j3.Wwwwwwwwwwwwwwww);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 0 || (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3.Kkkkkkkkkkkkkkkkkkkkkkkk)) == 0 || !AudioManager.isOffloadedPlaybackSupported(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3.Kkkkkkkkkkkkkkkkkkkkkkk, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2), c2848z4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww())) {
            return false;
        }
        if (!(c2245j3.Kkkkkkkkkkkkkkkkkkkkk == 0 && c2245j3.Kkkkkkkkkkkkkkkkkkkk == 0)) {
            if (!(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 30 && C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("Pixel"))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:76:0x00e4, code lost:
        if (r15 < r14) goto L56;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteBuffer byteBuffer, long j) throws AudioSink.WriteException {
        int write;
        if (!byteBuffer.hasRemaining()) {
            return;
        }
        ByteBuffer byteBuffer2 = this.Kkkkkkkkkkkkkkkkkkkkk;
        boolean z = true;
        if (byteBuffer2 != null) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer2 == byteBuffer);
        } else {
            this.Kkkkkkkkkkkkkkkkkkkkk = byteBuffer;
            if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 21) {
                int remaining = byteBuffer.remaining();
                byte[] bArr = this.Kkkkkkkkkkkkkkkkkkkk;
                if (bArr == null || bArr.length < remaining) {
                    this.Kkkkkkkkkkkkkkkkkkkk = new byte[remaining];
                }
                int position = byteBuffer.position();
                byteBuffer.get(this.Kkkkkkkkkkkkkkkkkkkk, 0, remaining);
                byteBuffer.position(position);
                this.Kkkkkkkkkkkkkkkkkkk = 0;
            }
        }
        int remaining2 = byteBuffer.remaining();
        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 21) {
            C2062e5 c2062e5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2062e5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww - ((int) (this.Wwwwwwww - (c2062e5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() * c2062e5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)));
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 > 0) {
                write = this.Wwwwwwwwwwwwwwwww.write(this.Kkkkkkkkkkkkkkkkkkkk, this.Kkkkkkkkkkkkkkkkkkk, Math.min(remaining2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2));
                if (write > 0) {
                    this.Kkkkkkkkkkkkkkkkkkk += write;
                    byteBuffer.position(byteBuffer.position() + write);
                }
            }
            write = 0;
        } else if (this.Kkkkkkkkkkkk) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j != -9223372036854775807L);
            AudioTrack audioTrack = this.Wwwwwwwwwwwwwwwww;
            if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 26) {
                write = audioTrack.write(byteBuffer, remaining2, 1, j * 1000);
            } else {
                if (this.Wwwwwwwwwwww == null) {
                    ByteBuffer allocate = ByteBuffer.allocate(16);
                    this.Wwwwwwwwwwww = allocate;
                    allocate.order(ByteOrder.BIG_ENDIAN);
                    this.Wwwwwwwwwwww.putInt(1431633921);
                }
                if (this.Wwwwwwwwwww == 0) {
                    this.Wwwwwwwwwwww.putInt(4, remaining2);
                    this.Wwwwwwwwwwww.putLong(8, j * 1000);
                    this.Wwwwwwwwwwww.position(0);
                    this.Wwwwwwwwwww = remaining2;
                }
                int remaining3 = this.Wwwwwwwwwwww.remaining();
                if (remaining3 > 0) {
                    int write2 = audioTrack.write(this.Wwwwwwwwwwww, remaining3, 1);
                    if (write2 < 0) {
                        this.Wwwwwwwwwww = 0;
                        write = write2;
                    }
                }
                write = audioTrack.write(byteBuffer, remaining2, 1);
                if (write < 0) {
                    this.Wwwwwwwwwww = 0;
                } else {
                    this.Wwwwwwwwwww -= write;
                }
            }
        } else {
            write = this.Wwwwwwwwwwwwwwwww.write(byteBuffer, remaining2, 1);
        }
        this.Kkkkkkkkkkk = SystemClock.elapsedRealtime();
        if (write < 0) {
            if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 24 || write != -6) {
                z = false;
            }
            if (z) {
                Wwwwwwwwwwwwwwwwwwww();
            }
            throw new AudioSink.WriteException(write);
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwww)) {
            if (this.Wwwwwww > 0) {
                this.Kkkkkkkkk = false;
            }
            if (this.Kkkkkkkkkkkkkkk && this.Wwwwwwwwwwwwwwwwwwwww != null && write < remaining2 && !this.Kkkkkkkkk) {
                C2062e5 c2062e52 = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2062e52.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwww - c2062e52.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()));
                AbstractC1896a4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2321l5.this.O00;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                }
            }
        }
        if (this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0) {
            this.Wwwwwwww += write;
        }
        if (write != remaining2) {
            return;
        }
        if (this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 0) {
            if (byteBuffer != this.Kkkkkkkkkkkkkkkkkkkkkkk) {
                z = false;
            }
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
            this.Wwwwwww += this.Wwwwww * this.Kkkkkkkkkkkkkkkkkkkkkk;
        }
        this.Kkkkkkkkkkkkkkkkkkkkk = null;
    }
}
