package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.drm.DefaultDrmSession;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSession;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import me.tvspark.AbstractC2299kk;
import me.tvspark.AbstractC2396n6;
import me.tvspark.AbstractC2587s6;
import me.tvspark.AbstractC2624t6;
import me.tvspark.AbstractC2716vk;
import me.tvspark.AbstractC2776x6;
import me.tvspark.C1895a3;
import me.tvspark.C2225ik;
import me.tvspark.C2322l6;
import me.tvspark.C2374ml;
import me.tvspark.C2632te;
import me.tvspark.C2739w6;
import me.tvspark.C2747we;
import me.tvspark.C2753wk;
import me.tvspark.C2827yk;
import me.tvspark.Illllllllllllllllllllllllllll;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

@RequiresApi(18)
/* loaded from: classes3.dex */
public class DefaultDrmSession implements DrmSession {
    @Nullable
    public AbstractC2624t6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwww;
    @Nullable
    public AbstractC2624t6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwww;
    public byte[] Wwwwwwwwwwwwww;
    @Nullable
    public byte[] Wwwwwwwwwwwwwww;
    @Nullable
    public DrmSession.DrmSessionException Wwwwwwwwwwwwwwww;
    @Nullable
    public AbstractC2587s6 Wwwwwwwwwwwwwwwww;
    @Nullable
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwww;
    @Nullable
    public HandlerThread Wwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwww;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwww;
    public final UUID Wwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC2776x6 Wwwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC2299kk Wwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2753wk<AbstractC2396n6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public final HashMap<String, String> Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC2624t6 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final List<C2322l6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes3.dex */
    public static final class UnexpectedDrmSessionException extends IOException {
        public UnexpectedDrmSessionException(@Nullable Throwable th) {
            super(th);
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Handler {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            Pair pair = (Pair) message.obj;
            Object obj = pair.first;
            Object obj2 = pair.second;
            int i = message.what;
            if (i == 0) {
                DefaultDrmSession defaultDrmSession = DefaultDrmSession.this;
                if (obj != defaultDrmSession.Wwwwwwwwwwww) {
                    return;
                }
                if (defaultDrmSession.Wwwwwwwwwwwwwwwwwwwww != 2 && !defaultDrmSession.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    return;
                }
                defaultDrmSession.Wwwwwwwwwwww = null;
                if (obj2 instanceof Exception) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = defaultDrmSession.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    e = (Exception) obj2;
                } else {
                    try {
                        defaultDrmSession.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((byte[]) obj2);
                        DefaultDrmSessionManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (DefaultDrmSessionManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) defaultDrmSession.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        for (DefaultDrmSession defaultDrmSession2 : DefaultDrmSessionManager.this.Wwwwwwwwwwwwwwwwwwwww) {
                            if (defaultDrmSession2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false)) {
                                defaultDrmSession2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
                            }
                        }
                        DefaultDrmSessionManager.this.Wwwwwwwwwwwwwwwwwwwww.clear();
                        return;
                    } catch (Exception e) {
                        e = e;
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = defaultDrmSession.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    }
                }
                ((DefaultDrmSessionManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e);
            } else if (i == 1) {
                DefaultDrmSession defaultDrmSession3 = DefaultDrmSession.this;
                if (obj != defaultDrmSession3.Wwwwwwwwwwwww || !defaultDrmSession3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    return;
                }
                defaultDrmSession3.Wwwwwwwwwwwww = null;
                if (obj2 instanceof Exception) {
                    e = (Exception) obj2;
                } else {
                    try {
                        byte[] bArr = (byte[]) obj2;
                        if (defaultDrmSession3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 3) {
                            AbstractC2624t6 abstractC2624t6 = defaultDrmSession3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            byte[] bArr2 = defaultDrmSession3.Wwwwwwwwwwwwww;
                            C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr2);
                            abstractC2624t6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr2, bArr);
                            for (AbstractC2396n6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 : defaultDrmSession3.Wwwwwwwwwwwwwwwwwwwwwwwwww.elementSet()) {
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            }
                            return;
                        }
                        byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = defaultDrmSession3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(defaultDrmSession3.Wwwwwwwwwwwwwww, bArr);
                        if ((defaultDrmSession3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 2 || (defaultDrmSession3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0 && defaultDrmSession3.Wwwwwwwwwwwwww != null)) && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length != 0) {
                            defaultDrmSession3.Wwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        }
                        defaultDrmSession3.Wwwwwwwwwwwwwwwwwwwww = 4;
                        for (AbstractC2396n6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 : defaultDrmSession3.Wwwwwwwwwwwwwwwwwwwwwwwwww.elementSet()) {
                            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        }
                        return;
                    } catch (Exception e2) {
                        e = e2;
                    }
                }
                defaultDrmSession3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, boolean z, long j2, Object obj) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = obj;
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Handler {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Looper looper) {
            super(looper);
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, Object obj, boolean z) {
            obtainMessage(i, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2632te.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), z, SystemClock.elapsedRealtime(), obj)).sendToTarget();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:22:0x00c3 A[RETURN] */
        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Throwable, java.lang.Exception] */
        /* JADX WARN: Type inference failed for: r0v10, types: [byte[]] */
        /* JADX WARN: Type inference failed for: r0v15, types: [byte[]] */
        /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.exoplayer2.drm.MediaDrmCallbackException, java.io.IOException] */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void handleMessage(Message message) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) message.obj;
            boolean z = true;
            try {
                int i = message.what;
                if (i == 0) {
                    e = ((C2739w6) DefaultDrmSession.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DefaultDrmSession.this.Wwwwwwwwwwwwwwwwwwwwwww, (AbstractC2624t6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                } else if (i != 1) {
                    throw new RuntimeException();
                } else {
                    e = ((C2739w6) DefaultDrmSession.this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DefaultDrmSession.this.Wwwwwwwwwwwwwwwwwwwwwww, (AbstractC2624t6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
            } catch (MediaDrmCallbackException e) {
                e = e;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) message.obj;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    int i2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
                    if (i2 <= ((C2225ik) DefaultDrmSession.this.Wwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3)) {
                        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ((C2225ik) DefaultDrmSession.this.Wwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new AbstractC2299kk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new C2632te(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, e.dataSpec, e.uriAfterRedirects, e.responseHeaders, SystemClock.elapsedRealtime(), SystemClock.elapsedRealtime() - wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, e.bytesLoaded), new C2747we(3), e.getCause() instanceof IOException ? (IOException) e.getCause() : new UnexpectedDrmSessionException(e.getCause()), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != -9223372036854775807L) {
                            sendMessageDelayed(Message.obtain(message), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            if (z) {
                                return;
                            }
                        }
                    }
                }
                z = false;
                if (z) {
                }
            } catch (Exception e2) {
                e = e2;
                C2827yk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Key/provisioning request produced an unexpected exception. Not retrying.", e);
            }
            DefaultDrmSession.this.Wwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            DefaultDrmSession.this.Wwwwwwwwwwwwwwwwwwwwww.obtainMessage(message.what, Pair.create(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, e)).sendToTarget();
        }
    }

    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    public DefaultDrmSession(UUID uuid, AbstractC2624t6 abstractC2624t6, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, @Nullable List<C2322l6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> list, int i, boolean z, boolean z2, @Nullable byte[] bArr, HashMap<String, String> hashMap, AbstractC2776x6 abstractC2776x6, Looper looper, AbstractC2299kk abstractC2299kk) {
        if ((i == 1 || i == 3) && bArr == null) {
            throw null;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwww = uuid;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2624t6;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = z2;
        if (bArr != null) {
            this.Wwwwwwwwwwwwww = bArr;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        } else if (list == null) {
            throw null;
        } else {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Collections.unmodifiableList(list);
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = hashMap;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = abstractC2776x6;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = new C2753wk<>();
        this.Wwwwwwwwwwwwwwwwwwwwwwwww = abstractC2299kk;
        this.Wwwwwwwwwwwwwwwwwwwww = 2;
        this.Wwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(looper);
    }

    @RequiresNonNull({"sessionId", "offlineLicenseKeySetId"})
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        try {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwww, this.Wwwwwwwwwwwwww);
            return true;
        } catch (Exception e) {
            C2827yk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Error trying to restore keys.", e);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e);
            return false;
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwww;
        C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        AbstractC2624t6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, true);
    }

    @EnsuresNonNullIf(expression = {"sessionId"}, result = true)
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i = this.Wwwwwwwwwwwwwwwwwwwww;
        return i == 3 || i == 4;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    public final DrmSession.DrmSessionException Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwwwwwwww == 1) {
            return this.Wwwwwwwwwwwwwwww;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    public final AbstractC2587s6 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwww;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    public Map<String, String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        byte[] bArr = this.Wwwwwwwwwwwwwww;
        if (bArr == null) {
            return null;
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Exception exc) {
        if (exc instanceof NotProvisionedException) {
            ((DefaultDrmSessionManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(exc);
        }
    }

    @EnsuresNonNullIf(expression = {"sessionId"}, result = true)
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return true;
        }
        try {
            byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            this.Wwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            for (AbstractC2396n6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : this.Wwwwwwwwwwwwwwwwwwwwwwwwww.elementSet()) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            this.Wwwwwwwwwwwwwwwwwwwww = 3;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwww);
            return true;
        } catch (NotProvisionedException e) {
            if (z) {
                ((DefaultDrmSessionManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
                return false;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e);
            return false;
        } catch (Exception e2) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e2);
            return false;
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(final Exception exc) {
        this.Wwwwwwwwwwwwwwww = new DrmSession.DrmSessionException(exc);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new AbstractC2716vk() { // from class: me.tvspark.b6
            @Override // me.tvspark.AbstractC2716vk
            public final void accept(Object obj) {
                ((AbstractC2396n6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(exc);
            }
        });
        if (this.Wwwwwwwwwwwwwwwwwwwww != 4) {
            this.Wwwwwwwwwwwwwwwwwwwww = 1;
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable AbstractC2396n6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        boolean z = false;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwww >= 0);
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        int i = this.Wwwwwwwwwwwwwwwwwwww + 1;
        this.Wwwwwwwwwwwwwwwwwwww = i;
        if (i == 1) {
            if (this.Wwwwwwwwwwwwwwwwwwwww == 2) {
                z = true;
            }
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:DrmRequestHandler");
            this.Wwwwwwwwwwwwwwwwwww = handlerThread;
            handlerThread.start();
            this.Wwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwww.getLooper());
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true)) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
            }
        } else if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        DefaultDrmSessionManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (DefaultDrmSessionManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        DefaultDrmSessionManager defaultDrmSessionManager = DefaultDrmSessionManager.this;
        if (defaultDrmSessionManager.Wwwwwwwwwwwwwwwwwwwwwww != -9223372036854775807L) {
            defaultDrmSessionManager.Wwwwwwwwwwwwwwwwwwww.remove(this);
            Handler handler = DefaultDrmSessionManager.this.Wwwwwwwwwwwwww;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(handler);
            handler.removeCallbacksAndMessages(this);
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2716vk<AbstractC2396n6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> abstractC2716vk) {
        for (AbstractC2396n6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : this.Wwwwwwwwwwwwwwwwwwwwwwwwww.elementSet()) {
            abstractC2716vk.accept(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, boolean z) {
        try {
            this.Wwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i, this.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwww;
            C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            AbstractC2624t6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwww;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, z);
        } catch (Exception e) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e);
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final int getState() {
        return this.Wwwwwwwwwwwwwwwwwwwww;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable AbstractC2396n6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwww > 0);
        int i = this.Wwwwwwwwwwwwwwwwwwww - 1;
        this.Wwwwwwwwwwwwwwwwwwww = i;
        if (i == 0) {
            this.Wwwwwwwwwwwwwwwwwwwww = 0;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwww;
            C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.removeCallbacksAndMessages(null);
            this.Wwwwwwwwwwwwwwwwww.removeCallbacksAndMessages(null);
            this.Wwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwww.quit();
            this.Wwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwww = null;
            this.Wwwwwwwwwwww = null;
            byte[] bArr = this.Wwwwwwwwwwwwwww;
            if (bArr != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr);
                this.Wwwwwwwwwwwwwww = null;
            }
            for (AbstractC2396n6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 : this.Wwwwwwwwwwwwwwwwwwwwwwwwww.elementSet()) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww.remove(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = this.Wwwwwwwwwwwwwwwwwwww;
        DefaultDrmSessionManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = (DefaultDrmSessionManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
            if (i2 == 1) {
                DefaultDrmSessionManager defaultDrmSessionManager = DefaultDrmSessionManager.this;
                if (defaultDrmSessionManager.Wwwwwwwwwwwwwwwwwwwwwww != -9223372036854775807L) {
                    defaultDrmSessionManager.Wwwwwwwwwwwwwwwwwwww.add(this);
                    Handler handler = DefaultDrmSessionManager.this.Wwwwwwwwwwwwww;
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(handler);
                    handler.postAtTime(new Runnable() { // from class: me.tvspark.c6
                        @Override // java.lang.Runnable
                        public final void run() {
                            DefaultDrmSession.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2396n6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) null);
                        }
                    }, this, SystemClock.uptimeMillis() + DefaultDrmSessionManager.this.Wwwwwwwwwwwwwwwwwwwwwww);
                    return;
                }
            }
            if (i2 != 0) {
                return;
            }
            DefaultDrmSessionManager.this.Wwwwwwwwwwwwwwwwwwwwww.remove(this);
            DefaultDrmSessionManager defaultDrmSessionManager2 = DefaultDrmSessionManager.this;
            if (defaultDrmSessionManager2.Wwwwwwwwwwwwwwwww == this) {
                defaultDrmSessionManager2.Wwwwwwwwwwwwwwwww = null;
            }
            DefaultDrmSessionManager defaultDrmSessionManager3 = DefaultDrmSessionManager.this;
            if (defaultDrmSessionManager3.Wwwwwwwwwwwwwwww == this) {
                defaultDrmSessionManager3.Wwwwwwwwwwwwwwww = null;
            }
            if (DefaultDrmSessionManager.this.Wwwwwwwwwwwwwwwwwwwww.size() > 1 && DefaultDrmSessionManager.this.Wwwwwwwwwwwwwwwwwwwww.get(0) == this) {
                DefaultDrmSessionManager.this.Wwwwwwwwwwwwwwwwwwwww.get(1).Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            DefaultDrmSessionManager.this.Wwwwwwwwwwwwwwwwwwwww.remove(this);
            DefaultDrmSessionManager defaultDrmSessionManager4 = DefaultDrmSessionManager.this;
            if (defaultDrmSessionManager4.Wwwwwwwwwwwwwwwwwwwwwww == -9223372036854775807L) {
                return;
            }
            Handler handler2 = defaultDrmSessionManager4.Wwwwwwwwwwwwww;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(handler2);
            handler2.removeCallbacksAndMessages(this);
            DefaultDrmSessionManager.this.Wwwwwwwwwwwwwwwwwwww.remove(this);
            return;
        }
        throw null;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:54|55|56|(6:58|59|60|61|(1:63)|65)|68|59|60|61|(0)|65) */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0090 A[Catch: NumberFormatException -> 0x0094, TRY_LEAVE, TryCatch #1 {NumberFormatException -> 0x0094, blocks: (B:61:0x0088, B:63:0x0090), top: B:60:0x0088 }] */
    @RequiresNonNull({"sessionId"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        long j;
        Pair pair;
        String str;
        String str2;
        long min;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return;
        }
        byte[] bArr = this.Wwwwwwwwwwwwwww;
        C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr);
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i == 0 || i == 1) {
            if (this.Wwwwwwwwwwwwww == null) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, 1, z);
                return;
            } else if (this.Wwwwwwwwwwwwwwwwwwwww != 4 && !Wwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                return;
            } else {
                if (!C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(this.Wwwwwwwwwwwwwwwwwwwwwww)) {
                    min = Long.MAX_VALUE;
                } else {
                    Map<String, String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null) {
                        pair = null;
                    } else {
                        long j2 = -9223372036854775807L;
                        try {
                            str2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.get("LicenseDurationRemaining");
                        } catch (NumberFormatException unused) {
                        }
                        if (str2 != null) {
                            j = Long.parseLong(str2);
                            Long valueOf = Long.valueOf(j);
                            str = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.get("PlaybackDurationRemaining");
                            if (str != null) {
                                j2 = Long.parseLong(str);
                            }
                            pair = new Pair(valueOf, Long.valueOf(j2));
                        }
                        j = -9223372036854775807L;
                        Long valueOf2 = Long.valueOf(j);
                        str = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.get("PlaybackDurationRemaining");
                        if (str != null) {
                        }
                        pair = new Pair(valueOf2, Long.valueOf(j2));
                    }
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(pair);
                    min = Math.min(((Long) pair.first).longValue(), ((Long) pair.second).longValue());
                }
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 0 || min > 60) {
                    if (min <= 0) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new KeysExpiredException());
                        return;
                    }
                    this.Wwwwwwwwwwwwwwwwwwwww = 4;
                    for (AbstractC2396n6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : this.Wwwwwwwwwwwwwwwwwwwwwwwwww.elementSet()) {
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    }
                    return;
                }
            }
        } else if (i != 2) {
            if (i != 3) {
                return;
            }
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwww);
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwww);
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                return;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwww, 3, z);
            return;
        } else if (this.Wwwwwwwwwwwwww != null && !Wwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, 2, z);
    }
}
