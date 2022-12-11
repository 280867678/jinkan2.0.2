package me.tvspark.utils.player;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.stub.StubApp;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import me.tvspark.AbstractC2079em;
import me.tvspark.AbstractC2209i4;
import me.tvspark.AbstractC2564rk;
import me.tvspark.AbstractC2736w3;
import me.tvspark.AbstractC2858ze;
import me.tvspark.C1907af;
import me.tvspark.C1932b3;
import me.tvspark.C1986ck;
import me.tvspark.C2006d3;
import me.tvspark.C2039dj;
import me.tvspark.C2040dk;
import me.tvspark.C2042dm;
import me.tvspark.C2072ef;
import me.tvspark.C2097f3;
import me.tvspark.C2101f7;
import me.tvspark.C2114fk;
import me.tvspark.C2135g4;
import me.tvspark.C2172h4;
import me.tvspark.C2188hk;
import me.tvspark.C2208i3;
import me.tvspark.C2225ik;
import me.tvspark.C2246j4;
import me.tvspark.C2283k4;
import me.tvspark.C2320l4;
import me.tvspark.C2356m3;
import me.tvspark.C2368mf;
import me.tvspark.C2374ml;
import me.tvspark.C2621t3;
import me.tvspark.C2658u3;
import me.tvspark.C2696v3;
import me.tvspark.C2751wi;
import me.tvspark.C2772x2;
import me.tvspark.C2825yi;
import me.tvspark.C2845z1;
import me.tvspark.Illllllllllllllllllllllllllll;
import me.tvspark.RunnableC2808y1;
import me.tvspark.Wwwwww;
import me.tvspark.Wwwwwwwww;
import me.tvspark.utils.player.JZMediaExo;
import org.apache.commons.lang3.time.StopWatch;

/* loaded from: classes4.dex */
public class JZMediaExo extends Wwwwwwwww implements AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, AbstractC2079em {
    public Runnable callback;
    public C2135g4 simpleExoPlayer;
    public String TAG = "JZMediaExo";
    public long previousSeek = 0;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            JZMediaExo.this.jzvd.setBufferProgress(i);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (JZMediaExo.this.simpleExoPlayer != null) {
                C2135g4 c2135g4 = JZMediaExo.this.simpleExoPlayer;
                long Wwwwwwwwwwwwwwwwwwwwwwwwwwww = c2135g4.Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
                long duration = c2135g4.getDuration();
                final int i = 0;
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwww != -9223372036854775807L && duration != -9223372036854775807L) {
                    i = duration == 0 ? 100 : C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) ((Wwwwwwwwwwwwwwwwwwwwwwwwwwww * 100) / duration), 0, 100);
                }
                JZMediaExo.this.handler.post(new Runnable() { // from class: me.tvspark.rq0
                    @Override // java.lang.Runnable
                    public final void run() {
                        JZMediaExo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
                    }
                });
                if (i < 100) {
                    JZMediaExo jZMediaExo = JZMediaExo.this;
                    jZMediaExo.handler.postDelayed(jZMediaExo.callback, 300L);
                    return;
                }
                JZMediaExo jZMediaExo2 = JZMediaExo.this;
                jZMediaExo2.handler.removeCallbacks(jZMediaExo2.callback);
            }
        }
    }

    public JZMediaExo(Wwwwww wwwwww) {
        super(wwwwww);
    }

    @Override // me.tvspark.AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        C2696v3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, z);
    }

    @Override // me.tvspark.AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        C2696v3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, i);
    }

    @Override // me.tvspark.AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        C2696v3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, z);
    }

    public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.jzvd != null) {
            return;
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        C2696v3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, i);
    }

    public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        this.jzvd.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2);
    }

    @Override // me.tvspark.AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        C2696v3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, z);
    }

    public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.jzvd.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1000, 1000);
    }

    @Override // me.tvspark.AbstractC2079em
    public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        C2042dm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, i, i2);
    }

    public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, boolean z) {
        if (i == 2) {
            this.handler.post(this.callback);
        } else if (i != 3) {
            if (i != 4) {
                return;
            }
            this.jzvd.Wwwwwwwwwwwwwwwwwwwwwwwwwww();
        } else if (!z) {
        } else {
            this.jzvd.Wwwwwwwwwwwwwwwwwwww();
        }
    }

    public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context) {
        AbstractC2858ze Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        SurfaceTexture surfaceTexture;
        try {
            C2825yi c2825yi = new C2825yi(context, new C2751wi.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            C1986ck c1986ck = new C1986ck(true, 65536);
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
            C1932b3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1000, 0, "bufferForPlaybackMs", "0");
            C1932b3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(5000, 0, "bufferForPlaybackAfterRebufferMs", "0");
            C1932b3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(360000, 1000, "minBufferMs", "bufferForPlaybackMs");
            C1932b3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(360000, 5000, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
            C1932b3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(600000, 360000, "maxBufferMs", "minBufferMs");
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
            C1932b3 c1932b3 = new C1932b3(c1986ck, 360000, 600000, 1000, 5000, -1, false, 0, false);
            Context origApplicationContext = context == null ? null : StubApp.getOrigApplicationContext(context.getApplicationContext());
            ImmutableList<Integer> mo4793get = C2040dk.Wwwwwwwwwwwwwwwwwwwww.mo4793get((ImmutableListMultimap<String, Integer>) C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context));
            if (mo4793get.isEmpty()) {
                mo4793get = ImmutableList.m3914of(2, 2, 2, 2, 2);
            }
            HashMap hashMap = new HashMap(6);
            hashMap.put(0, Long.valueOf((long) StopWatch.NANO_2_MILLIS));
            hashMap.put(2, C2040dk.Wwwwwwwwwwwwwwwwwwww.get(mo4793get.get(0).intValue()));
            hashMap.put(3, C2040dk.Wwwwwwwwwwwwwwwwwww.get(mo4793get.get(1).intValue()));
            hashMap.put(4, C2040dk.Wwwwwwwwwwwwwwwwww.get(mo4793get.get(2).intValue()));
            hashMap.put(5, C2040dk.Wwwwwwwwwwwwwwwww.get(mo4793get.get(3).intValue()));
            hashMap.put(9, C2040dk.Wwwwwwwwwwwwwwww.get(mo4793get.get(4).intValue()));
            hashMap.put(7, C2040dk.Wwwwwwwwwwwwwwwwwwww.get(mo4793get.get(0).intValue()));
            C2040dk c2040dk = new C2040dk(origApplicationContext, hashMap, 2000, AbstractC2564rk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, true);
            C2135g4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2135g4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, new C2006d3(context));
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwww);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2825yi;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwww);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = c1932b3;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwww);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = c2040dk;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwww);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwww = true;
            this.simpleExoPlayer = new C2135g4(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            Context origApplicationContext2 = context == null ? null : StubApp.getOrigApplicationContext(context.getApplicationContext());
            ImmutableList<Integer> mo4793get2 = C2040dk.Wwwwwwwwwwwwwwwwwwwww.mo4793get((ImmutableListMultimap<String, Integer>) C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context));
            if (mo4793get2.isEmpty()) {
                mo4793get2 = ImmutableList.m3914of(2, 2, 2, 2, 2);
            }
            HashMap hashMap2 = new HashMap(6);
            hashMap2.put(0, Long.valueOf((long) StopWatch.NANO_2_MILLIS));
            hashMap2.put(2, C2040dk.Wwwwwwwwwwwwwwwwwwww.get(mo4793get2.get(0).intValue()));
            hashMap2.put(3, C2040dk.Wwwwwwwwwwwwwwwwwww.get(mo4793get2.get(1).intValue()));
            hashMap2.put(4, C2040dk.Wwwwwwwwwwwwwwwwww.get(mo4793get2.get(2).intValue()));
            hashMap2.put(5, C2040dk.Wwwwwwwwwwwwwwwww.get(mo4793get2.get(3).intValue()));
            hashMap2.put(9, C2040dk.Wwwwwwwwwwwwwwww.get(mo4793get2.get(4).intValue()));
            hashMap2.put(7, C2040dk.Wwwwwwwwwwwwwwwwwwww.get(mo4793get2.get(0).intValue()));
            C2114fk c2114fk = new C2114fk(context, new C2040dk(origApplicationContext2, hashMap2, 2000, AbstractC2564rk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, true), new C2188hk(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, "app"), null, 15000, 15000, true));
            String obj = this.jzvd.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().toString();
            if (obj.contains(".mp4")) {
                C2101f7 c2101f7 = new C2101f7();
                C1907af c1907af = new C1907af();
                C2225ik c2225ik = new C2225ik();
                Uri parse = Uri.parse(obj);
                C2356m3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new C2356m3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = parse;
                C2356m3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                Object obj2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new C2072ef(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, c2114fk, c2101f7, c1907af.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3), c2225ik, 1048576);
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new HlsMediaSource.Factory(c2114fk).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri.parse(obj));
            }
            this.simpleExoPlayer.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(this);
            this.simpleExoPlayer.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
            if (Boolean.valueOf(this.jzvd.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww).booleanValue()) {
                this.simpleExoPlayer.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
            } else {
                this.simpleExoPlayer.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
            }
            this.simpleExoPlayer.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            this.simpleExoPlayer.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
            this.callback = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
            if (this.jzvd.Wwwww == null || (surfaceTexture = this.jzvd.Wwwww.getSurfaceTexture()) == null) {
                return;
            }
            this.simpleExoPlayer.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Surface(surfaceTexture));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // me.tvspark.AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2209i4 abstractC2209i4, int i) {
        C2696v3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, abstractC2209i4, i);
    }

    @Override // me.tvspark.AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable C2356m3 c2356m3, int i) {
        C2696v3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, c2356m3, i);
    }

    @Override // me.tvspark.AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, int i) {
        C2696v3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, z, i);
    }

    @Override // me.tvspark.Wwwwwwwww
    public long getCurrentPosition() {
        C2135g4 c2135g4 = this.simpleExoPlayer;
        if (c2135g4 != null) {
            return c2135g4.getCurrentPosition();
        }
        return 0L;
    }

    @Override // me.tvspark.Wwwwwwwww
    public long getDuration() {
        C2135g4 c2135g4 = this.simpleExoPlayer;
        if (c2135g4 != null) {
            c2135g4.Wwwwwwwwwwwwwwwwwwwwwww();
            return c2135g4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getDuration();
        }
        return 0L;
    }

    @Override // me.tvspark.Wwwwwwwww
    public boolean isPlaying() {
        C2135g4 c2135g4 = this.simpleExoPlayer;
        if (c2135g4 != null) {
            return c2135g4.Wwwwwwwwwwwwwwwwwwwwwwwww();
        }
        return false;
    }

    @Override // me.tvspark.AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void onLoadingChanged(boolean z) {
    }

    @Override // me.tvspark.AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void onPlaybackParametersChanged(C2658u3 c2658u3) {
    }

    @Override // me.tvspark.AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void onPlayerError(ExoPlaybackException exoPlaybackException) {
        exoPlaybackException.toString();
        this.handler.post(new Runnable() { // from class: me.tvspark.qq0
            @Override // java.lang.Runnable
            public final void run() {
                JZMediaExo.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        });
    }

    @Override // me.tvspark.AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void onPlayerStateChanged(final boolean z, final int i) {
        String.valueOf(z);
        this.handler.post(new Runnable() { // from class: me.tvspark.tq0
            @Override // java.lang.Runnable
            public final void run() {
                JZMediaExo.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, z);
            }
        });
    }

    @Override // me.tvspark.AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void onPositionDiscontinuity(int i) {
    }

    @Override // me.tvspark.AbstractC2079em
    public void onRenderedFirstFrame() {
    }

    @Override // me.tvspark.AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void onRepeatModeChanged(int i) {
    }

    @Override // me.tvspark.AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void onSeekProcessed() {
        this.handler.post(new Runnable() { // from class: me.tvspark.sq0
            @Override // java.lang.Runnable
            public final void run() {
                JZMediaExo.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        });
    }

    public void onShuffleModeEnabledChanged(boolean z) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        SurfaceTexture surfaceTexture2 = Wwwwwwwww.SAVED_SURFACE;
        if (surfaceTexture2 != null) {
            this.jzvd.Wwwww.setSurfaceTexture(surfaceTexture2);
            return;
        }
        Wwwwwwwww.SAVED_SURFACE = surfaceTexture;
        prepare();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // me.tvspark.AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void onTimelineChanged(AbstractC2209i4 abstractC2209i4, Object obj, int i) {
    }

    @Override // me.tvspark.AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void onTracksChanged(C2368mf c2368mf, C2039dj c2039dj) {
    }

    @Override // me.tvspark.AbstractC2079em
    public void onVideoSizeChanged(final int i, final int i2, int i3, float f) {
        this.handler.post(new Runnable() { // from class: me.tvspark.pq0
            @Override // java.lang.Runnable
            public final void run() {
                JZMediaExo.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2);
            }
        });
    }

    @Override // me.tvspark.Wwwwwwwww
    public void pause() {
        C2135g4 c2135g4 = this.simpleExoPlayer;
        if (c2135g4 != null) {
            c2135g4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
        }
    }

    @Override // me.tvspark.Wwwwwwwww
    public void prepare() {
        final Context context = this.jzvd.getContext();
        release();
        HandlerThread handlerThread = new HandlerThread("JZVD");
        this.mMediaHandlerThread = handlerThread;
        handlerThread.start();
        this.mMediaHandler = new Handler(this.mMediaHandlerThread.getLooper());
        this.handler = new Handler();
        this.mMediaHandler.post(new Runnable() { // from class: me.tvspark.oq0
            @Override // java.lang.Runnable
            public final void run() {
                JZMediaExo.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context);
            }
        });
    }

    @Override // me.tvspark.Wwwwwwwww
    public void release() {
        final HandlerThread handlerThread;
        final C2135g4 c2135g4;
        Handler handler = this.mMediaHandler;
        if (handler == null || (handlerThread = this.mMediaHandlerThread) == null || (c2135g4 = this.simpleExoPlayer) == null) {
            return;
        }
        Wwwwwwwww.SAVED_SURFACE = null;
        handler.post(new Runnable() { // from class: me.tvspark.nq0
            @Override // java.lang.Runnable
            public final void run() {
                JZMediaExo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2135g4.this, handlerThread);
            }
        });
        this.simpleExoPlayer = null;
    }

    @Override // me.tvspark.Wwwwwwwww
    public void seekTo(long j) {
        C2135g4 c2135g4 = this.simpleExoPlayer;
        if (c2135g4 == null || j == this.previousSeek) {
            return;
        }
        c2135g4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2135g4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), j);
        this.previousSeek = j;
        this.jzvd.Wwwwwwwwwwwwww = j;
    }

    @Override // me.tvspark.Wwwwwwwww
    public void setSpeed(float f) {
        if (this.simpleExoPlayer != null) {
            C2658u3 c2658u3 = new C2658u3(f, 1.0f);
            C2135g4 c2135g4 = this.simpleExoPlayer;
            c2135g4.Wwwwwwwwwwwwwwwwwwwwwww();
            C2097f3 c2097f3 = c2135g4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (c2097f3 == null) {
                throw null;
            }
            if (c2097f3.Wwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww.equals(c2658u3)) {
                return;
            }
            C2621t3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2097f3.Wwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2658u3);
            c2097f3.Wwwwwwwwwwwwwwwwww++;
            c2097f3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4, c2658u3).sendToTarget();
            c2097f3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, false, 4, 0, 1, false);
        }
    }

    @Override // me.tvspark.Wwwwwwwww
    public void setSurface(Surface surface) {
        C2135g4 c2135g4 = this.simpleExoPlayer;
        if (c2135g4 != null) {
            c2135g4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(surface);
        }
    }

    @Override // me.tvspark.Wwwwwwwww
    public void setVolume(float f, float f2) {
        C2135g4 c2135g4 = this.simpleExoPlayer;
        if (c2135g4 != null) {
            c2135g4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f);
            this.simpleExoPlayer.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f2);
        }
    }

    @Override // me.tvspark.Wwwwwwwww
    public void start() {
        C2135g4 c2135g4 = this.simpleExoPlayer;
        if (c2135g4 != null) {
            c2135g4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
        }
    }

    public static /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2135g4 c2135g4, HandlerThread handlerThread) {
        c2135g4.Wwwwwwwwwwwwwwwwwwwwwww();
        c2135g4.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
        C2172h4 c2172h4 = c2135g4.Wwwwwwwwwwwwwwwwwwww;
        if (!c2172h4.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
            c2172h4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.unregisterReceiver(c2172h4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            c2172h4.Wwwwwwwwwwwwwwwwwwwwwwwwww = true;
        }
        C2246j4 c2246j4 = c2135g4.Wwwwwwwwwwwwwwwwwww;
        c2246j4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        c2246j4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        C2283k4 c2283k4 = c2135g4.Wwwwwwwwwwwwwwwwww;
        c2283k4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        c2283k4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        C2772x2 c2772x2 = c2135g4.Wwwwwwwwwwwwwwwwwwwww;
        c2772x2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        c2772x2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        C2097f3 c2097f3 = c2135g4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (c2097f3 != null) {
            String hexString = Integer.toHexString(System.identityHashCode(c2097f3));
            String str = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2208i3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            String.valueOf(hexString).length();
            String.valueOf(str).length();
            String.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2).length();
            if (!c2097f3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww()) {
                c2097f3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new RunnableC2808y1(new CopyOnWriteArrayList(c2097f3.Wwwwwwwwwwwwwwwwwwwwwwwwwww), C2845z1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
            }
            c2097f3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.removeCallbacksAndMessages(null);
            C2320l4 c2320l4 = c2097f3.Wwwwwwwwwwwwwwwwwwwwww;
            if (c2320l4 != null) {
                c2097f3.Wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2320l4);
            }
            C2621t3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = c2097f3.Wwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
            c2097f3.Wwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
            C2621t3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            c2097f3.Wwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwww;
            c2097f3.Wwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww = 0L;
            c2135g4.Wwwwwwwwwwwwwwwwwwwwwwww();
            Surface surface = c2135g4.Wwwwwwwwwwwwwww;
            if (surface != null) {
                if (c2135g4.Wwwwwwwwwwwwww) {
                    surface.release();
                }
                c2135g4.Wwwwwwwwwwwwwww = null;
            }
            if (c2135g4.Kkkkkkkkkkkkkkkkkkkkkkk) {
                PriorityTaskManager priorityTaskManager = c2135g4.Kkkkkkkkkkkkkkkkkkkkkkkk;
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(priorityTaskManager);
                priorityTaskManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                c2135g4.Kkkkkkkkkkkkkkkkkkkkkkk = false;
            }
            Collections.emptyList();
            handlerThread.quit();
            return;
        }
        throw null;
    }
}
