package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.media.ResourceBusyException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.drm.DefaultDrmSession;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import me.tvspark.AbstractC2239iy;
import me.tvspark.AbstractC2299kk;
import me.tvspark.AbstractC2396n6;
import me.tvspark.AbstractC2470p6;
import me.tvspark.AbstractC2587s6;
import me.tvspark.AbstractC2624t6;
import me.tvspark.AbstractC2776x6;
import me.tvspark.C1895a3;
import me.tvspark.C1950bl;
import me.tvspark.C2245j3;
import me.tvspark.C2322l6;
import me.tvspark.C2374ml;
import me.tvspark.C2550r6;
import me.tvspark.C2661u6;
import me.tvspark.C2813y6;
import me.tvspark.Illllllllllllllllllllllllllll;

@RequiresApi(18)
/* loaded from: classes3.dex */
public class DefaultDrmSessionManager implements AbstractC2470p6 {
    @Nullable
    public volatile Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwww;
    @Nullable
    public byte[] Wwwwwwwwwwww;
    public int Wwwwwwwwwwwww;
    public Handler Wwwwwwwwwwwwww;
    @Nullable
    public Looper Wwwwwwwwwwwwwww;
    @Nullable
    public DefaultDrmSession Wwwwwwwwwwwwwwww;
    @Nullable
    public DefaultDrmSession Wwwwwwwwwwwwwwwww;
    @Nullable
    public AbstractC2624t6 Wwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwww;
    public final Set<DefaultDrmSession> Wwwwwwwwwwwwwwwwwwww;
    public final List<DefaultDrmSession> Wwwwwwwwwwwwwwwwwwwww;
    public final List<DefaultDrmSession> Wwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwww;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC2299kk Wwwwwwwwwwwwwwwwwwwwwwwww;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final HashMap<String, String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC2776x6 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC2624t6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final UUID Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes3.dex */
    public static final class MissingSchemeDataException extends Exception {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public MissingSchemeDataException(UUID uuid) {
            super(r1.toString());
            String valueOf = String.valueOf(uuid);
            StringBuilder sb = new StringBuilder(valueOf.length() + 29);
            sb.append("Media does not support uuid: ");
            sb.append(valueOf);
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DefaultDrmSession.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Handler {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            if (bArr == null) {
                return;
            }
            for (DefaultDrmSession defaultDrmSession : DefaultDrmSessionManager.this.Wwwwwwwwwwwwwwwwwwwwww) {
                if (Arrays.equals(defaultDrmSession.Wwwwwwwwwwwwwww, bArr)) {
                    if (message.what != 2 || defaultDrmSession.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 0 || defaultDrmSession.Wwwwwwwwwwwwwwwwwwwww != 4) {
                        return;
                    }
                    C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(defaultDrmSession.Wwwwwwwwwwwwwww);
                    defaultDrmSession.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
                    return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC2624t6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }
    }

    public /* synthetic */ DefaultDrmSessionManager(UUID uuid, AbstractC2624t6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, AbstractC2776x6 abstractC2776x6, HashMap hashMap, boolean z, int[] iArr, boolean z2, AbstractC2299kk abstractC2299kk, long j, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        if (uuid != null) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(uuid), (Object) "Use C.CLEARKEY_UUID instead");
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = uuid;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2776x6;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = hashMap;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = iArr;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = z2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwww = abstractC2299kk;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
            this.Wwwwwwwwwwwww = 0;
            this.Wwwwwwwwwwwwwwwwwwwwww = new ArrayList();
            this.Wwwwwwwwwwwwwwwwwwwww = new ArrayList();
            this.Wwwwwwwwwwwwwwwwwwww = Collections.newSetFromMap(new IdentityHashMap());
            this.Wwwwwwwwwwwwwwwwwwwwwww = j;
            return;
        }
        throw null;
    }

    public final DefaultDrmSession Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable List<C2322l6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> list, boolean z, @Nullable AbstractC2396n6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        DefaultDrmSession Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, z, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwww == 1) {
            if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 19) {
                DrmSession.DrmSessionException Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                if (!(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getCause() instanceof ResourceBusyException)) {
                    return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                }
            }
            if (this.Wwwwwwwwwwwwwwwwwwww.isEmpty()) {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            }
            AbstractC2239iy mo4735iterator = ImmutableList.copyOf((Collection) this.Wwwwwwwwwwwwwwwwwwww).mo4735iterator();
            while (mo4735iterator.hasNext()) {
                ((DrmSession) mo4735iterator.next()).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (this.Wwwwwwwwwwwwwwwwwwwwwww != -9223372036854775807L) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2396n6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) null);
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, z, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
    }

    public final DefaultDrmSession Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable List<C2322l6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> list, boolean z, @Nullable AbstractC2396n6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwww);
        UUID uuid = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        AbstractC2624t6 abstractC2624t6 = this.Wwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        int i = this.Wwwwwwwwwwwww;
        byte[] bArr = this.Wwwwwwwwwwww;
        HashMap<String, String> hashMap = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        AbstractC2776x6 abstractC2776x6 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Looper looper = this.Wwwwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(looper);
        DefaultDrmSession defaultDrmSession = new DefaultDrmSession(uuid, abstractC2624t6, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, list, i, this.Wwwwwwwwwwwwwwwwwwwwwwwwwww | z, z, bArr, hashMap, abstractC2776x6, looper, this.Wwwwwwwwwwwwwwwwwwwwwwwww);
        defaultDrmSession.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (this.Wwwwwwwwwwwwwwwwwwwwwww != -9223372036854775807L) {
            defaultDrmSession.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2396n6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) null);
        }
        return defaultDrmSession;
    }

    @Override // me.tvspark.AbstractC2470p6
    @Nullable
    public DrmSession Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Looper looper, @Nullable AbstractC2396n6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, C2245j3 c2245j3) {
        List<C2322l6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> list;
        Looper looper2 = this.Wwwwwwwwwwwwwww;
        boolean z = false;
        if (looper2 == null) {
            this.Wwwwwwwwwwwwwww = looper;
            this.Wwwwwwwwwwwwww = new Handler(looper);
        } else {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(looper2 == looper);
        }
        if (this.Wwwwwwwwwww == null) {
            this.Wwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(looper);
        }
        C2322l6 c2322l6 = c2245j3.Wwwwwwwwww;
        DefaultDrmSession defaultDrmSession = null;
        if (c2322l6 == null) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3.Wwwwwwwwwwwww);
            AbstractC2624t6 abstractC2624t6 = this.Wwwwwwwwwwwwwwwwww;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2624t6);
            if (C2661u6.class.equals(abstractC2624t6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) && C2661u6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                z = true;
            }
            if (z || C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) == -1 || C2813y6.class.equals(abstractC2624t6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww())) {
                return null;
            }
            DefaultDrmSession defaultDrmSession2 = this.Wwwwwwwwwwwwwwwww;
            if (defaultDrmSession2 == null) {
                DefaultDrmSession Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ImmutableList.m3919of(), true, null);
                this.Wwwwwwwwwwwwwwwwwwwwww.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                this.Wwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            } else {
                defaultDrmSession2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2396n6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) null);
            }
            return this.Wwwwwwwwwwwwwwwww;
        }
        if (this.Wwwwwwwwwwww == null) {
            list = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2322l6, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, false);
            if (((ArrayList) list).isEmpty()) {
                MissingSchemeDataException missingSchemeDataException = new MissingSchemeDataException(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(missingSchemeDataException);
                }
                return new C2550r6(new DrmSession.DrmSessionException(missingSchemeDataException));
            }
        } else {
            list = null;
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Iterator<DefaultDrmSession> it = this.Wwwwwwwwwwwwwwwwwwwwww.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DefaultDrmSession next = it.next();
                if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, list)) {
                    defaultDrmSession = next;
                    break;
                }
            }
        } else {
            defaultDrmSession = this.Wwwwwwwwwwwwwwww;
        }
        if (defaultDrmSession == null) {
            defaultDrmSession = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, false, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwww = defaultDrmSession;
            }
            this.Wwwwwwwwwwwwwwwwwwwwww.add(defaultDrmSession);
        } else {
            defaultDrmSession.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        return defaultDrmSession;
    }

    @Override // me.tvspark.AbstractC2470p6
    public final void prepare() {
        int i = this.Wwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwww = i + 1;
        if (i != 0) {
            return;
        }
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwww == null);
        AbstractC2624t6 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null));
    }

    @Override // me.tvspark.AbstractC2470p6
    public final void release() {
        int i = this.Wwwwwwwwwwwwwwwwwww - 1;
        this.Wwwwwwwwwwwwwwwwwww = i;
        if (i != 0) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.Wwwwwwwwwwwwwwwwwwwwww);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ((DefaultDrmSession) arrayList.get(i2)).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2396n6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) null);
        }
        AbstractC2624t6 abstractC2624t6 = this.Wwwwwwwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2624t6);
        abstractC2624t6.release();
        this.Wwwwwwwwwwwwwwwwww = null;
    }

    /* loaded from: classes3.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DefaultDrmSession.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Exception exc) {
            for (DefaultDrmSession defaultDrmSession : DefaultDrmSessionManager.this.Wwwwwwwwwwwwwwwwwwwww) {
                defaultDrmSession.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(exc);
            }
            DefaultDrmSessionManager.this.Wwwwwwwwwwwwwwwwwwwww.clear();
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DefaultDrmSession defaultDrmSession) {
            if (DefaultDrmSessionManager.this.Wwwwwwwwwwwwwwwwwwwww.contains(defaultDrmSession)) {
                return;
            }
            DefaultDrmSessionManager.this.Wwwwwwwwwwwwwwwwwwwww.add(defaultDrmSession);
            if (DefaultDrmSessionManager.this.Wwwwwwwwwwwwwwwwwwwww.size() != 1) {
                return;
            }
            defaultDrmSession.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    @Override // me.tvspark.AbstractC2470p6
    @Nullable
    public Class<? extends AbstractC2587s6> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3) {
        AbstractC2624t6 abstractC2624t6 = this.Wwwwwwwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2624t6);
        Class<? extends AbstractC2587s6> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = abstractC2624t6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        C2322l6 c2322l6 = c2245j3.Wwwwwwwwww;
        if (c2322l6 == null) {
            if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3.Wwwwwwwwwwwww)) == -1) {
                return null;
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        }
        boolean z = true;
        if (this.Wwwwwwwwwwww == null) {
            if (((ArrayList) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2322l6, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, true)).isEmpty()) {
                if (c2322l6.Wwwwwwwwwwwwwwwwwwwww == 1 && c2322l6.Wwwwwwwwwwwwwwwwwwwwwwww[0].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                    String.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).length();
                }
                z = false;
            }
            String str = c2322l6.Wwwwwwwwwwwwwwwwwwwwww;
            if (str != null) {
                if (!"cenc".equals(str)) {
                    if (!"cbcs".equals(str)) {
                        z = false;
                    }
                }
            }
        }
        return z ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 : C2813y6.class;
    }

    public static List<C2322l6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2322l6 c2322l6, UUID uuid, boolean z) {
        ArrayList arrayList = new ArrayList(c2322l6.Wwwwwwwwwwwwwwwwwwwww);
        for (int i = 0; i < c2322l6.Wwwwwwwwwwwwwwwwwwwww; i++) {
            C2322l6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2322l6.Wwwwwwwwwwwwwwwwwwwwwwww[i];
            if ((wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uuid) || (C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(uuid) && wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww))) && (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww != null || z)) {
                arrayList.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }
        return arrayList;
    }
}
