package me.tvspark;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.IllegalSeekPositionException;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import me.tvspark.AbstractC2736w3;
import me.tvspark.AbstractC2809y2;
import me.tvspark.C2097f3;
import me.tvspark.C2171h3;
import me.tvspark.C2172h4;
import me.tvspark.C2584s3;
import me.tvspark.C2735w2;
import me.tvspark.C2772x2;

/* renamed from: me.tvspark.g4 */
/* loaded from: classes4.dex */
public class C2135g4 extends AbstractC2809y2 implements AbstractC2060e3 {
    public C2849z5 Kkkkkkkkkkkkkkkkkkkkkk;
    public boolean Kkkkkkkkkkkkkkkkkkkkkkk;
    @Nullable
    public PriorityTaskManager Kkkkkkkkkkkkkkkkkkkkkkkk;
    public boolean Kkkkkkkkkkkkkkkkkkkkkkkkk;
    public List<C2786xg> Kkkkkkkkkkkkkkkkkkkkkkkkkk;
    public boolean Www;
    public float Wwww;
    public C2848z4 Wwwww;
    public int Wwwwww;
    @Nullable
    public C2698v5 Wwwwwww;
    @Nullable
    public C2698v5 Wwwwwwww;
    public int Wwwwwwwww;
    public int Wwwwwwwwww;
    @Nullable
    public TextureView Wwwwwwwwwww;
    @Nullable
    public SurfaceHolder Wwwwwwwwwwww;
    public int Wwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwww;
    @Nullable
    public Surface Wwwwwwwwwwwwwww;
    @Nullable
    public C2245j3 Wwwwwwwwwwwwwwww;
    @Nullable
    public C2245j3 Wwwwwwwwwwwwwwwww;
    public final C2283k4 Wwwwwwwwwwwwwwwwww;
    public final C2246j4 Wwwwwwwwwwwwwwwwwww;
    public final C2172h4 Wwwwwwwwwwwwwwwwwwww;
    public final C2772x2 Wwwwwwwwwwwwwwwwwwwww;
    public final C2735w2 Wwwwwwwwwwwwwwwwwwwwww;
    public final C2320l4 Wwwwwwwwwwwwwwwwwwwwwww;
    public final C2097f3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC1896a4[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
    public final CopyOnWriteArraySet<AbstractC2079em> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new CopyOnWriteArraySet<>();
    public final CopyOnWriteArraySet<AbstractC1934b5> Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new CopyOnWriteArraySet<>();
    public final CopyOnWriteArraySet<AbstractC2111fh> Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new CopyOnWriteArraySet<>();
    public final CopyOnWriteArraySet<AbstractC2439oc> Wwwwwwwwwwwwwwwwwwwwwwwwwww = new CopyOnWriteArraySet<>();
    public final CopyOnWriteArraySet<AbstractC1898a6> Wwwwwwwwwwwwwwwwwwwwwwwwww = new CopyOnWriteArraySet<>();
    public final CopyOnWriteArraySet<AbstractC2116fm> Wwwwwwwwwwwwwwwwwwwwwwwww = new CopyOnWriteArraySet<>();
    public final CopyOnWriteArraySet<AbstractC1971c5> Wwwwwwwwwwwwwwwwwwwwwwww = new CopyOnWriteArraySet<>();

    /* renamed from: me.tvspark.g4$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public boolean Wwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwww;
        @Nullable
        public PriorityTaskManager Wwwwwwwwwwwwwwwwwwwwwwwww;
        public C2320l4 Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        public AbstractC2674uj Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public AbstractC2319l3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public AbstractC1981cf Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public AbstractC2113fj Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final AbstractC2061e4 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final Context Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public Looper Wwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        public C2848z4 Wwwwwwwwwwwwwwwwwwwwwwww = C2848z4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwww = 0;
        public int Wwwwwwwwwwwwwwwwwww = 1;
        public boolean Wwwwwwwwwwwwwwwwww = true;
        public C2098f4 Wwwwwwwwwwwwwwwww = C2098f4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public AbstractC2564rk Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = AbstractC2564rk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwww = true;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, AbstractC2061e4 abstractC2061e4) {
            C2101f7 c2101f7 = new C2101f7();
            C2825yi c2825yi = new C2825yi(context);
            C2478pe c2478pe = new C2478pe(context, c2101f7);
            C1932b3 c1932b3 = new C1932b3(new C1986ck(true, 65536), 50000, 50000, 2500, 5000, -1, false, 0, false);
            C2040dk Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2040dk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context);
            C2320l4 c2320l4 = new C2320l4(AbstractC2564rk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = context;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2061e4;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2825yi;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2478pe;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = c1932b3;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = c2320l4;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x02df, code lost:
        if (r3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == r5) goto L56;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0381  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x03cf  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0165  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C2135g4(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        AbstractC1896a4 abstractC1896a4;
        C2320l4 c2320l4;
        C2283k4 c2283k4;
        boolean z;
        WifiManager wifiManager;
        int i6;
        int i7;
        this.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Kkkkkkkkkkkkkkkkkkkkkkkk = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww;
        this.Www = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww;
        Handler handler = new Handler(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww);
        AbstractC2061e4 abstractC2061e4 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        C2006d3 c2006d3 = (C2006d3) abstractC2061e4;
        if (c2006d3 != null) {
            ArrayList arrayList = new ArrayList();
            Context context = c2006d3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i8 = c2006d3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            AbstractC2143gc abstractC2143gc = c2006d3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            long j = c2006d3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            C1914am c1914am = new C1914am(context, abstractC2143gc, j, false, handler, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 50);
            c1914am.IIlllllllll = c2006d3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            arrayList.add(c1914am);
            if (i8 != 0) {
                int size = arrayList.size();
                size = i8 == 2 ? size - 1 : size;
                try {
                    try {
                        i7 = size + 1;
                    } catch (ClassNotFoundException unused) {
                    }
                    try {
                        arrayList.add(size, (AbstractC1896a4) Class.forName("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(Long.TYPE, Handler.class, AbstractC2116fm.class, Integer.TYPE).newInstance(Long.valueOf(j), handler, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 50));
                    } catch (ClassNotFoundException unused2) {
                        size = i7;
                        i7 = size;
                        arrayList.add(i7, (AbstractC1896a4) Class.forName("com.google.android.exoplayer2.ext.av1.Libgav1VideoRenderer").getConstructor(Long.TYPE, Handler.class, AbstractC2116fm.class, Integer.TYPE).newInstance(Long.valueOf(j), handler, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 50));
                        DefaultAudioSink defaultAudioSink = new DefaultAudioSink(C1897a5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2006d3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), new DefaultAudioSink.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new AudioProcessor[0]), false, false, false);
                        Context context2 = c2006d3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        i = c2006d3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        C2321l5 c2321l5 = new C2321l5(context2, c2006d3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, false, handler, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, defaultAudioSink);
                        c2321l5.IIlllllllll = c2006d3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        arrayList.add(c2321l5);
                        if (i != 0) {
                        }
                        arrayList.add(new C2148gh(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, handler.getLooper()));
                        arrayList.add(new C2476pc(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, handler.getLooper()));
                        arrayList.add(new C2190hm());
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (AbstractC1896a4[]) arrayList.toArray(new AbstractC1896a4[i3]);
                        this.Wwww = 1.0f;
                        this.Wwwwww = i3;
                        Collections.emptyList();
                        C2097f3 c2097f3 = new C2097f3(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww);
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2097f3;
                        c2097f3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        this.Wwwwwwwwwwwwwwwwwwwwwwwww.add(this.Wwwwwwwwwwwwwwwwwwwwwww);
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(this.Wwwwwwwwwwwwwwwwwwwwwww);
                        this.Wwwwwwwwwwwwwwwwwwwwwwww.add(this.Wwwwwwwwwwwwwwwwwwwwwww);
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(this.Wwwwwwwwwwwwwwwwwwwwwww);
                        c2320l4 = this.Wwwwwwwwwwwwwwwwwwwwwww;
                        if (c2320l4 == null) {
                        }
                    }
                    try {
                        arrayList.add(i7, (AbstractC1896a4) Class.forName("com.google.android.exoplayer2.ext.av1.Libgav1VideoRenderer").getConstructor(Long.TYPE, Handler.class, AbstractC2116fm.class, Integer.TYPE).newInstance(Long.valueOf(j), handler, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 50));
                    } catch (ClassNotFoundException unused3) {
                    } catch (Exception e) {
                        throw new RuntimeException("Error instantiating AV1 extension", e);
                    }
                } catch (Exception e2) {
                    throw new RuntimeException("Error instantiating VP9 extension", e2);
                }
            }
            DefaultAudioSink defaultAudioSink2 = new DefaultAudioSink(C1897a5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2006d3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), new DefaultAudioSink.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new AudioProcessor[0]), false, false, false);
            Context context22 = c2006d3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            i = c2006d3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            C2321l5 c2321l52 = new C2321l5(context22, c2006d3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, false, handler, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, defaultAudioSink2);
            c2321l52.IIlllllllll = c2006d3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            arrayList.add(c2321l52);
            if (i != 0) {
                i2 = 1;
                i3 = 0;
            } else {
                int size2 = arrayList.size();
                size2 = i == 2 ? size2 - 1 : size2;
                try {
                    try {
                        Class<?> cls = Class.forName("com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer");
                        Class<?>[] clsArr = new Class[3];
                        i3 = 0;
                        try {
                            clsArr[0] = Handler.class;
                            i2 = 1;
                            try {
                                clsArr[1] = AbstractC1971c5.class;
                                clsArr[2] = AudioSink.class;
                                abstractC1896a4 = (AbstractC1896a4) cls.getConstructor(clsArr).newInstance(handler, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, defaultAudioSink2);
                                i4 = size2 + 1;
                            } catch (ClassNotFoundException unused4) {
                            }
                            try {
                                arrayList.add(size2, abstractC1896a4);
                            } catch (ClassNotFoundException unused5) {
                                size2 = i4;
                                i4 = size2;
                                try {
                                    Class<?> cls2 = Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer");
                                    Class<?>[] clsArr2 = new Class[3];
                                    clsArr2[i3] = Handler.class;
                                    clsArr2[i2] = AbstractC1971c5.class;
                                    clsArr2[2] = AudioSink.class;
                                    Constructor<?> constructor = cls2.getConstructor(clsArr2);
                                    Object[] objArr = new Object[3];
                                    objArr[i3] = handler;
                                    objArr[i2] = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    objArr[2] = defaultAudioSink2;
                                    AbstractC1896a4 abstractC1896a42 = (AbstractC1896a4) constructor.newInstance(objArr);
                                    i5 = i4 + 1;
                                    arrayList.add(i4, abstractC1896a42);
                                } catch (ClassNotFoundException unused6) {
                                }
                                Class<?> cls3 = Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer");
                                Class<?>[] clsArr3 = new Class[3];
                                clsArr3[i3] = Handler.class;
                                clsArr3[i2] = AbstractC1971c5.class;
                                clsArr3[2] = AudioSink.class;
                                Constructor<?> constructor2 = cls3.getConstructor(clsArr3);
                                Object[] objArr2 = new Object[3];
                                objArr2[i3] = handler;
                                objArr2[i2] = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                objArr2[2] = defaultAudioSink2;
                                arrayList.add(i5, (AbstractC1896a4) constructor2.newInstance(objArr2));
                                arrayList.add(new C2148gh(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, handler.getLooper()));
                                arrayList.add(new C2476pc(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, handler.getLooper()));
                                arrayList.add(new C2190hm());
                                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (AbstractC1896a4[]) arrayList.toArray(new AbstractC1896a4[i3]);
                                this.Wwww = 1.0f;
                                this.Wwwwww = i3;
                                Collections.emptyList();
                                C2097f3 c2097f32 = new C2097f3(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww);
                                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2097f32;
                                c2097f32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                this.Wwwwwwwwwwwwwwwwwwwwwwwww.add(this.Wwwwwwwwwwwwwwwwwwwwwww);
                                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(this.Wwwwwwwwwwwwwwwwwwwwwww);
                                this.Wwwwwwwwwwwwwwwwwwwwwwww.add(this.Wwwwwwwwwwwwwwwwwwwwwww);
                                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(this.Wwwwwwwwwwwwwwwwwwwwwww);
                                c2320l4 = this.Wwwwwwwwwwwwwwwwwwwwwww;
                                if (c2320l4 == null) {
                                }
                            }
                        } catch (ClassNotFoundException unused7) {
                            i2 = 1;
                        }
                    } catch (ClassNotFoundException unused8) {
                        i2 = 1;
                        i3 = 0;
                    }
                    try {
                        Class<?> cls22 = Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer");
                        Class<?>[] clsArr22 = new Class[3];
                        clsArr22[i3] = Handler.class;
                        clsArr22[i2] = AbstractC1971c5.class;
                        clsArr22[2] = AudioSink.class;
                        Constructor<?> constructor3 = cls22.getConstructor(clsArr22);
                        Object[] objArr3 = new Object[3];
                        objArr3[i3] = handler;
                        objArr3[i2] = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        objArr3[2] = defaultAudioSink2;
                        AbstractC1896a4 abstractC1896a422 = (AbstractC1896a4) constructor3.newInstance(objArr3);
                        i5 = i4 + 1;
                        try {
                            arrayList.add(i4, abstractC1896a422);
                        } catch (ClassNotFoundException unused9) {
                            i4 = i5;
                            i5 = i4;
                            Class<?> cls32 = Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer");
                            Class<?>[] clsArr32 = new Class[3];
                            clsArr32[i3] = Handler.class;
                            clsArr32[i2] = AbstractC1971c5.class;
                            clsArr32[2] = AudioSink.class;
                            Constructor<?> constructor22 = cls32.getConstructor(clsArr32);
                            Object[] objArr22 = new Object[3];
                            objArr22[i3] = handler;
                            objArr22[i2] = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            objArr22[2] = defaultAudioSink2;
                            arrayList.add(i5, (AbstractC1896a4) constructor22.newInstance(objArr22));
                            arrayList.add(new C2148gh(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, handler.getLooper()));
                            arrayList.add(new C2476pc(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, handler.getLooper()));
                            arrayList.add(new C2190hm());
                            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (AbstractC1896a4[]) arrayList.toArray(new AbstractC1896a4[i3]);
                            this.Wwww = 1.0f;
                            this.Wwwwww = i3;
                            Collections.emptyList();
                            C2097f3 c2097f322 = new C2097f3(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww);
                            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2097f322;
                            c2097f322.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            this.Wwwwwwwwwwwwwwwwwwwwwwwww.add(this.Wwwwwwwwwwwwwwwwwwwwwww);
                            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(this.Wwwwwwwwwwwwwwwwwwwwwww);
                            this.Wwwwwwwwwwwwwwwwwwwwwwww.add(this.Wwwwwwwwwwwwwwwwwwwwwww);
                            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(this.Wwwwwwwwwwwwwwwwwwwwwww);
                            c2320l4 = this.Wwwwwwwwwwwwwwwwwwwwwww;
                            if (c2320l4 == null) {
                            }
                        }
                        try {
                            Class<?> cls322 = Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer");
                            Class<?>[] clsArr322 = new Class[3];
                            clsArr322[i3] = Handler.class;
                            clsArr322[i2] = AbstractC1971c5.class;
                            clsArr322[2] = AudioSink.class;
                            Constructor<?> constructor222 = cls322.getConstructor(clsArr322);
                            Object[] objArr222 = new Object[3];
                            objArr222[i3] = handler;
                            objArr222[i2] = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            objArr222[2] = defaultAudioSink2;
                            arrayList.add(i5, (AbstractC1896a4) constructor222.newInstance(objArr222));
                        } catch (ClassNotFoundException unused10) {
                        } catch (Exception e3) {
                            throw new RuntimeException("Error instantiating FFmpeg extension", e3);
                        }
                    } catch (Exception e4) {
                        throw new RuntimeException("Error instantiating FLAC extension", e4);
                    }
                } catch (Exception e5) {
                    throw new RuntimeException("Error instantiating Opus extension", e5);
                }
            }
            arrayList.add(new C2148gh(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, handler.getLooper()));
            arrayList.add(new C2476pc(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, handler.getLooper()));
            arrayList.add(new C2190hm());
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (AbstractC1896a4[]) arrayList.toArray(new AbstractC1896a4[i3]);
            this.Wwww = 1.0f;
            this.Wwwwww = i3;
            Collections.emptyList();
            C2097f3 c2097f3222 = new C2097f3(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2097f3222;
            c2097f3222.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwww.add(this.Wwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(this.Wwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwww.add(this.Wwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(this.Wwwwwwwwwwwwwwwwwwwwwww);
            c2320l4 = this.Wwwwwwwwwwwwwwwwwwwwwww;
            if (c2320l4 == null) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.add(c2320l4);
                C2735w2 c2735w2 = new C2735w2(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, handler, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwwwwwww = c2735w2;
                c2735w2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww);
                C2772x2 c2772x2 = new C2772x2(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, handler, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwwwwww = c2772x2;
                C2848z4 c2848z4 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww ? this.Wwwww : null;
                if (!C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2772x2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2848z4)) {
                    c2772x2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2848z4;
                    if (c2848z4 != null) {
                        switch (c2848z4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                            case 0:
                            case 1:
                            case 14:
                                i6 = 1;
                                break;
                            case 2:
                            case 4:
                                i6 = 2;
                                break;
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                            case 12:
                            case 13:
                                i6 = 3;
                                break;
                            case 16:
                                if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 19) {
                                    i6 = 4;
                                    break;
                                }
                                i6 = 2;
                                break;
                        }
                        c2772x2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = i6;
                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i6 != i2 || i6 == 0, (Object) "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME.");
                    }
                    i6 = 0;
                    c2772x2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = i6;
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i6 != i2 || i6 == 0, (Object) "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME.");
                }
                C2172h4 c2172h4 = new C2172h4(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, handler, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwwwww = c2172h4;
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                if (c2172h4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww != Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
                    c2172h4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                    c2172h4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) c2172h4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    C2849z5 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2135g4.this.Wwwwwwwwwwwwwwwwwwww);
                    if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.equals(C2135g4.this.Kkkkkkkkkkkkkkkkkkkkkk)) {
                        C2135g4 c2135g4 = C2135g4.this;
                        c2135g4.Kkkkkkkkkkkkkkkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                        Iterator<AbstractC1898a6> it = c2135g4.Wwwwwwwwwwwwwwwwwwwwwwwwww.iterator();
                        while (it.hasNext()) {
                            it.next().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        }
                    }
                }
                C2246j4 c2246j4 = new C2246j4(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwwww = c2246j4;
                boolean z2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww != 0;
                if (z2 && c2246j4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                    PowerManager powerManager = c2246j4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (powerManager != null) {
                        PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(i2, "ExoPlayer:WakeLockManager");
                        c2246j4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = newWakeLock;
                        newWakeLock.setReferenceCounted(false);
                    }
                    c2283k4 = new C2283k4(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    this.Wwwwwwwwwwwwwwwwww = c2283k4;
                    z = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww != 2;
                    if (z && c2283k4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                        wifiManager = c2283k4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (wifiManager != null) {
                            WifiManager.WifiLock createWifiLock = wifiManager.createWifiLock(3, "ExoPlayer:WifiLockManager");
                            c2283k4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = createWifiLock;
                            createWifiLock.setReferenceCounted(false);
                        }
                        this.Kkkkkkkkkkkkkkkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwww);
                        if (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwww) {
                            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Kkkkkkkkkkk = false;
                        }
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, 3, this.Wwwww);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2, 4, Integer.valueOf(this.Wwwwwwwwwwwww));
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, 101, Boolean.valueOf(this.Www));
                        return;
                    }
                    c2283k4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
                    c2283k4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    this.Kkkkkkkkkkkkkkkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwww);
                    if (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwww) {
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, 3, this.Wwwww);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2, 4, Integer.valueOf(this.Wwwwwwwwwwwww));
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, 101, Boolean.valueOf(this.Www));
                    return;
                }
                c2246j4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z2;
                c2246j4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                c2283k4 = new C2283k4(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwww = c2283k4;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww != 2) {
                }
                if (z) {
                    wifiManager = c2283k4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (wifiManager != null) {
                    }
                    this.Kkkkkkkkkkkkkkkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwww);
                    if (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwww) {
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, 3, this.Wwwww);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2, 4, Integer.valueOf(this.Wwwwwwwwwwwww));
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, 101, Boolean.valueOf(this.Www));
                    return;
                }
                c2283k4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
                c2283k4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                this.Kkkkkkkkkkkkkkkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwww);
                if (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwww) {
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, 3, this.Wwwww);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2, 4, Integer.valueOf(this.Wwwwwwwwwwwww));
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, 101, Boolean.valueOf(this.Www));
                return;
            }
            throw null;
        }
        throw null;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, int i) {
        return (!z || i == 1) ? 1 : 2;
    }

    public static /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2135g4 c2135g4) {
        C2283k4 c2283k4;
        boolean z;
        c2135g4.Wwwwwwwwwwwwwwwwwwwwwww();
        int i = c2135g4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i != 1) {
            if (i == 2 || i == 3) {
                C2246j4 c2246j4 = c2135g4.Wwwwwwwwwwwwwwwwwww;
                c2246j4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2135g4.Wwwwwwwwwwwwwwwwwwwwwwwww();
                c2246j4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                c2283k4 = c2135g4.Wwwwwwwwwwwwwwwwww;
                z = c2135g4.Wwwwwwwwwwwwwwwwwwwwwwwww();
                c2283k4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
                c2283k4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            } else if (i != 4) {
                throw new IllegalStateException();
            }
        }
        C2246j4 c2246j42 = c2135g4.Wwwwwwwwwwwwwwwwwww;
        c2246j42.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        c2246j42.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        c2283k4 = c2135g4.Wwwwwwwwwwwwwwwwww;
        z = false;
        c2283k4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
        c2283k4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwww() {
        if (Looper.myLooper() != this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww) {
            C2827yk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Player is accessed on the wrong thread. See https://exoplayer.dev/issues/player-accessed-on-wrong-thread", this.Kkkkkkkkkkkkkkkkkkkkkkkkk ? null : new IllegalStateException());
            this.Kkkkkkkkkkkkkkkkkkkkkkkkk = true;
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwww() {
        TextureView textureView = this.Wwwwwwwwwww;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() == this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwww.setSurfaceTextureListener(null);
            }
            this.Wwwwwwwwwww = null;
        }
        SurfaceHolder surfaceHolder = this.Wwwwwwwwwwww;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwww = null;
        }
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwww() {
        Wwwwwwwwwwwwwwwwwwwwwww();
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC2736w3
    public AbstractC2209i4 Wwwwwwwwwwwwwwwwwwwwwwwwww() {
        Wwwwwwwwwwwwwwwwwwwwwww();
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC2736w3
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Wwwwwwwwwwwwwwwwwwwwwww();
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2736w3
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Wwwwwwwwwwwwwwwwwwwwwww();
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2736w3
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Wwwwwwwwwwwwwwwwwwwwwww();
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2736w3
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Wwwwwwwwwwwwwwwwwwwwwww();
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2736w3
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Wwwwwwwwwwwwwwwwwwwwwww();
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2736w3
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Wwwwwwwwwwwwwwwwwwwwwww();
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2736w3
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Wwwwwwwwwwwwwwwwwwwwwww();
        return C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        if (i == this.Wwwwwwwwww && i2 == this.Wwwwwwwww) {
            return;
        }
        this.Wwwwwwwwww = i;
        this.Wwwwwwwww = i2;
        Iterator<AbstractC2079em> it = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.iterator();
        while (it.hasNext()) {
            it.next().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2);
        }
    }

    @Override // me.tvspark.AbstractC2736w3
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Wwwwwwwwwwwwwwwwwwwwwww();
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2736w3
    public long getCurrentPosition() {
        Wwwwwwwwwwwwwwwwwwwwwww();
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getCurrentPosition();
    }

    @Override // me.tvspark.AbstractC2736w3
    public long getDuration() {
        Wwwwwwwwwwwwwwwwwwwwwww();
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getDuration();
    }

    /* renamed from: me.tvspark.g4$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC2116fm, AbstractC1971c5, AbstractC2111fh, AbstractC2439oc, SurfaceHolder.Callback, TextureView.SurfaceTextureListener, C2772x2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, C2735w2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, C2172h4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        @Override // me.tvspark.AbstractC2116fm
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2698v5 c2698v5) {
            Iterator<AbstractC2116fm> it = C2135g4.this.Wwwwwwwwwwwwwwwwwwwwwwwww.iterator();
            while (it.hasNext()) {
                it.next().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2698v5);
            }
            C2135g4.this.Wwwwwwwwwwwwwwwww = null;
        }

        @Override // me.tvspark.AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
            C2696v3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, z);
        }

        @Override // me.tvspark.AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            C2135g4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2135g4.this);
        }

        @Override // me.tvspark.AbstractC2116fm
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2698v5 c2698v5) {
            C2135g4 c2135g4 = C2135g4.this;
            c2135g4.Wwwwwwww = c2698v5;
            Iterator<AbstractC2116fm> it = c2135g4.Wwwwwwwwwwwwwwwwwwwwwwwww.iterator();
            while (it.hasNext()) {
                it.next().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2698v5);
            }
        }

        @Override // me.tvspark.AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
            C2696v3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, z);
        }

        @Override // me.tvspark.AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            C2696v3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, i);
        }

        @Override // me.tvspark.AbstractC1971c5
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, long j, long j2) {
            Iterator<AbstractC1971c5> it = C2135g4.this.Wwwwwwwwwwwwwwwwwwwwwwww.iterator();
            while (it.hasNext()) {
                it.next().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, j, j2);
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

        @Override // me.tvspark.AbstractC1971c5
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2698v5 c2698v5) {
            Iterator<AbstractC1971c5> it = C2135g4.this.Wwwwwwwwwwwwwwwwwwwwwwww.iterator();
            while (it.hasNext()) {
                it.next().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2698v5);
            }
            C2135g4 c2135g4 = C2135g4.this;
            c2135g4.Wwwwwwwwwwwwwwww = null;
            c2135g4.Wwwwww = 0;
        }

        @Override // me.tvspark.AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, int i) {
            C2135g4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2135g4.this);
        }

        @Override // me.tvspark.AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        @Deprecated
        public /* synthetic */ void onLoadingChanged(boolean z) {
            C2696v3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, z);
        }

        @Override // me.tvspark.AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public /* synthetic */ void onPlaybackParametersChanged(C2658u3 c2658u3) {
            C2696v3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, c2658u3);
        }

        @Override // me.tvspark.AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public /* synthetic */ void onPlayerError(ExoPlaybackException exoPlaybackException) {
            C2696v3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, exoPlaybackException);
        }

        @Override // me.tvspark.AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        @Deprecated
        public /* synthetic */ void onPlayerStateChanged(boolean z, int i) {
            C2696v3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, z, i);
        }

        @Override // me.tvspark.AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public /* synthetic */ void onPositionDiscontinuity(int i) {
            C2696v3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, i);
        }

        @Override // me.tvspark.AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public /* synthetic */ void onRepeatModeChanged(int i) {
            C2696v3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, i);
        }

        @Override // me.tvspark.AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        @Deprecated
        public /* synthetic */ void onSeekProcessed() {
            C2696v3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            C2135g4.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Surface(surfaceTexture), true);
            C2135g4.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            C2135g4.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Surface) null, true);
            C2135g4.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, 0);
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            C2135g4.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // me.tvspark.AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        @Deprecated
        public /* synthetic */ void onTimelineChanged(AbstractC2209i4 abstractC2209i4, @Nullable Object obj, int i) {
            C2696v3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, abstractC2209i4, obj, i);
        }

        @Override // me.tvspark.AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public /* synthetic */ void onTracksChanged(C2368mf c2368mf, C2039dj c2039dj) {
            C2696v3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, c2368mf, c2039dj);
        }

        @Override // me.tvspark.AbstractC2116fm
        public void onVideoSizeChanged(int i, int i2, int i3, float f) {
            Iterator<AbstractC2079em> it = C2135g4.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.iterator();
            while (it.hasNext()) {
                AbstractC2079em next = it.next();
                if (!C2135g4.this.Wwwwwwwwwwwwwwwwwwwwwwwww.contains(next)) {
                    next.onVideoSizeChanged(i, i2, i3, f);
                }
            }
            Iterator<AbstractC2116fm> it2 = C2135g4.this.Wwwwwwwwwwwwwwwwwwwwwwwww.iterator();
            while (it2.hasNext()) {
                it2.next().onVideoSizeChanged(i, i2, i3, f);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            C2135g4.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, i3);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            C2135g4.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(surfaceHolder.getSurface(), false);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            C2135g4.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Surface) null, false);
            C2135g4.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, 0);
        }

        @Override // me.tvspark.AbstractC1971c5
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2698v5 c2698v5) {
            C2135g4 c2135g4 = C2135g4.this;
            c2135g4.Wwwwwww = c2698v5;
            Iterator<AbstractC1971c5> it = c2135g4.Wwwwwwwwwwwwwwwwwwwwwwww.iterator();
            while (it.hasNext()) {
                it.next().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2698v5);
            }
        }

        @Override // me.tvspark.AbstractC1971c5
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
            Iterator<AbstractC1971c5> it = C2135g4.this.Wwwwwwwwwwwwwwwwwwwwwwww.iterator();
            while (it.hasNext()) {
                it.next().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
            }
        }

        @Override // me.tvspark.AbstractC1971c5
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3) {
            C2135g4 c2135g4 = C2135g4.this;
            c2135g4.Wwwwwwwwwwwwwwww = c2245j3;
            Iterator<AbstractC1971c5> it = c2135g4.Wwwwwwwwwwwwwwwwwwwwwwww.iterator();
            while (it.hasNext()) {
                it.next().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3);
            }
        }

        @Override // me.tvspark.AbstractC1971c5
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            C2135g4 c2135g4 = C2135g4.this;
            if (c2135g4.Wwwwww == i) {
                return;
            }
            c2135g4.Wwwwww = i;
            Iterator<AbstractC1934b5> it = c2135g4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.iterator();
            while (it.hasNext()) {
                AbstractC1934b5 next = it.next();
                if (!c2135g4.Wwwwwwwwwwwwwwwwwwwwwwww.contains(next)) {
                    next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2135g4.Wwwwww);
                }
            }
            Iterator<AbstractC1971c5> it2 = c2135g4.Wwwwwwwwwwwwwwwwwwwwwwww.iterator();
            while (it2.hasNext()) {
                it2.next().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2135g4.Wwwwww);
            }
        }

        @Override // me.tvspark.AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
            C2135g4 c2135g4 = C2135g4.this;
            PriorityTaskManager priorityTaskManager = c2135g4.Kkkkkkkkkkkkkkkkkkkkkkkk;
            if (priorityTaskManager != null) {
                if (z && !c2135g4.Kkkkkkkkkkkkkkkkkkkkkkk) {
                    priorityTaskManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                    C2135g4.this.Kkkkkkkkkkkkkkkkkkkkkkk = true;
                } else if (z) {
                } else {
                    C2135g4 c2135g42 = C2135g4.this;
                    if (!c2135g42.Kkkkkkkkkkkkkkkkkkkkkkk) {
                        return;
                    }
                    c2135g42.Kkkkkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                    C2135g4.this.Kkkkkkkkkkkkkkkkkkkkkkk = false;
                }
            }
        }

        @Override // me.tvspark.AbstractC1971c5
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, long j, long j2) {
            Iterator<AbstractC1971c5> it = C2135g4.this.Wwwwwwwwwwwwwwwwwwwwwwww.iterator();
            while (it.hasNext()) {
                it.next().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, j, j2);
            }
        }

        @Override // me.tvspark.AbstractC2111fh
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<C2786xg> list) {
            C2135g4 c2135g4 = C2135g4.this;
            c2135g4.Kkkkkkkkkkkkkkkkkkkkkkkkkk = list;
            Iterator<AbstractC2111fh> it = c2135g4.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.iterator();
            while (it.hasNext()) {
                it.next().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list);
            }
        }

        @Override // me.tvspark.AbstractC2116fm
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, long j) {
            Iterator<AbstractC2116fm> it = C2135g4.this.Wwwwwwwwwwwwwwwwwwwwwwwww.iterator();
            while (it.hasNext()) {
                it.next().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, j);
            }
        }

        @Override // me.tvspark.AbstractC2439oc
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2254jc c2254jc) {
            Iterator<AbstractC2439oc> it = C2135g4.this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.iterator();
            while (it.hasNext()) {
                it.next().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2254jc);
            }
        }

        @Override // me.tvspark.AbstractC2116fm
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Surface surface) {
            C2135g4 c2135g4 = C2135g4.this;
            if (c2135g4.Wwwwwwwwwwwwwww == surface) {
                Iterator<AbstractC2079em> it = c2135g4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.iterator();
                while (it.hasNext()) {
                    it.next().onRenderedFirstFrame();
                }
            }
            Iterator<AbstractC2116fm> it2 = C2135g4.this.Wwwwwwwwwwwwwwwwwwwwwwwww.iterator();
            while (it2.hasNext()) {
                it2.next().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(surface);
            }
        }

        @Override // me.tvspark.AbstractC1971c5
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
            C2135g4 c2135g4 = C2135g4.this;
            if (c2135g4.Www == z) {
                return;
            }
            c2135g4.Www = z;
            Iterator<AbstractC1934b5> it = c2135g4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.iterator();
            while (it.hasNext()) {
                AbstractC1934b5 next = it.next();
                if (!c2135g4.Wwwwwwwwwwwwwwwwwwwwwwww.contains(next)) {
                    next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2135g4.Www);
                }
            }
            Iterator<AbstractC1971c5> it2 = c2135g4.Wwwwwwwwwwwwwwwwwwwwwwww.iterator();
            while (it2.hasNext()) {
                it2.next().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2135g4.Www);
            }
        }

        @Override // me.tvspark.AbstractC2116fm
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, long j, long j2) {
            Iterator<AbstractC2116fm> it = C2135g4.this.Wwwwwwwwwwwwwwwwwwwwwwwww.iterator();
            while (it.hasNext()) {
                it.next().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, j, j2);
            }
        }

        @Override // me.tvspark.AbstractC2116fm
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, int i) {
            Iterator<AbstractC2116fm> it = C2135g4.this.Wwwwwwwwwwwwwwwwwwwwwwwww.iterator();
            while (it.hasNext()) {
                it.next().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, i);
            }
        }

        @Override // me.tvspark.AbstractC2116fm
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3) {
            C2135g4 c2135g4 = C2135g4.this;
            c2135g4.Wwwwwwwwwwwwwwwww = c2245j3;
            Iterator<AbstractC2116fm> it = c2135g4.Wwwwwwwwwwwwwwwwwwwwwwwww.iterator();
            while (it.hasNext()) {
                it.next().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3);
            }
        }
    }

    public static C2849z5 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2172h4 c2172h4) {
        if (c2172h4 != null) {
            return new C2849z5(0, C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 28 ? c2172h4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getStreamMinVolume(c2172h4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) : 0, c2172h4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getStreamMaxVolume(c2172h4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        }
        throw null;
    }

    @Deprecated
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2858ze abstractC2858ze) {
        Wwwwwwwwwwwwwwwwwwwwwww();
        List singletonList = Collections.singletonList(abstractC2858ze);
        Wwwwwwwwwwwwwwwwwwwwwww();
        if (this.Wwwwwwwwwwwwwwwwwwwwwww != null) {
            C2097f3 c2097f3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (c2097f3 != null) {
                singletonList.size();
                for (int i = 0; i < singletonList.size(); i++) {
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2858ze) singletonList.get(i));
                }
                c2097f3.Wwwwwwwwwwwwwwwwwwwwwwwww();
                c2097f3.getCurrentPosition();
                c2097f3.Wwwwwwwwwwwwwwwwww++;
                if (!c2097f3.Wwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
                    int size = c2097f3.Wwwwwwwwwwwwwwwwwwwwwwww.size();
                    for (int i2 = size - 1; i2 >= 0; i2--) {
                        c2097f3.Wwwwwwwwwwwwwwwwwwwwwwww.remove(i2);
                    }
                    c2097f3.Wwwwwwwwwwwwww = c2097f3.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, size);
                    if (c2097f3.Wwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
                        c2097f3.Wwwwwwwwwwwww = false;
                    }
                }
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < singletonList.size(); i3++) {
                    C2584s3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2584s3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2858ze) singletonList.get(i3), c2097f3.Wwwwwwwwwwwwwwwwwwwwwww);
                    arrayList.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    c2097f3.Wwwwwwwwwwwwwwwwwwwwwwww.add(i3 + 0, new C2097f3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww));
                }
                c2097f3.Wwwwwwwwwwwwww = c2097f3.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, arrayList.size());
                C2810y3 c2810y3 = new C2810y3(c2097f3.Wwwwwwwwwwwwwwwwwwwwwwww, c2097f3.Wwwwwwwwwwwwww);
                if (!c2810y3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && c2810y3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww <= 0) {
                    throw new IllegalSeekPositionException(c2810y3, 0, -9223372036854775807L);
                }
                C2621t3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2097f3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2097f3.Wwwwwwwwwwww, c2810y3, c2097f3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2810y3, 0, -9223372036854775807L));
                int i4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (i4 != 1) {
                    i4 = (c2810y3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() || c2810y3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww <= 0) ? 4 : 2;
                }
                C2621t3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4);
                c2097f3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(17, new C2171h3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(arrayList, c2097f3.Wwwwwwwwwwwwww, 0, C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-9223372036854775807L), null)).sendToTarget();
                int i5 = 2;
                c2097f3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, false, 4, 0, 1, false);
                Wwwwwwwwwwwwwwwwwwwwwww();
                boolean Wwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwww();
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwww, 2);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4));
                C2097f3 c2097f32 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                C2621t3 c2621t3 = c2097f32.Wwwwwwwwwwww;
                if (c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 1) {
                    return;
                }
                C2621t3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ExoPlaybackException) null);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    i5 = 4;
                }
                C2621t3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i5);
                c2097f32.Wwwwwwwwwwwwwwwwww++;
                c2097f32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.obtainMessage(0).sendToTarget();
                c2097f32.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6, false, 4, 1, 1, false);
                return;
            }
            throw null;
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2736w3
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, long j) {
        Wwwwwwwwwwwwwwwwwwwwwww();
        C2320l4 c2320l4 = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (!c2320l4.Wwwwwwwwwwwwwwwwww) {
            c2320l4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            c2320l4.Wwwwwwwwwwwwwwwwww = true;
            Iterator<AbstractC2357m4> it = c2320l4.Wwwwwwwwwwwwwwwwwwwwwwww.iterator();
            while (it.hasNext()) {
                it.next().Kkkkkkkkkkkkkkk();
            }
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, j);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, @Nullable Object obj) {
        AbstractC1896a4[] abstractC1896a4Arr;
        for (AbstractC1896a4 abstractC1896a4 : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (abstractC1896a4.getTrackType() == i) {
                C2773x3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1896a4);
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwww);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwww);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = obj;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        Wwwwwwwwwwwwwwwwwwwwwww();
        C2772x2 c2772x2 = this.Wwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwww();
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2772x2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2));
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(final int i) {
        Wwwwwwwwwwwwwwwwwwwwwww();
        C2097f3 c2097f3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (c2097f3.Wwwwwwwwwwwwwwwwwww != i) {
            c2097f3.Wwwwwwwwwwwwwwwwwww = i;
            c2097f3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.obtainMessage(11, i, 0).sendToTarget();
            c2097f3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new RunnableC2808y1(new CopyOnWriteArrayList(c2097f3.Wwwwwwwwwwwwwwwwwwwwwwwwwww), new AbstractC2809y2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() { // from class: me.tvspark.p2
                @Override // me.tvspark.AbstractC2809y2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
                public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2736w3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.onRepeatModeChanged(i);
                }
            }));
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable Surface surface) {
        Wwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwww();
        if (surface != null) {
            Wwwwwwwwwwwwwwwwwwwwwww();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2, 8, (Object) null);
        }
        int i = 0;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(surface, false);
        if (surface != null) {
            i = -1;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable Surface surface, boolean z) {
        AbstractC1896a4[] abstractC1896a4Arr;
        ArrayList arrayList = new ArrayList();
        for (AbstractC1896a4 abstractC1896a4 : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (abstractC1896a4.getTrackType() == 2) {
                C2773x3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1896a4);
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwww);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwww);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = surface;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                arrayList.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            }
        }
        Surface surface2 = this.Wwwwwwwwwwwwwww;
        if (surface2 != null && surface2 != surface) {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((C2773x3) it.next()).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
            if (this.Wwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwww.release();
            }
        }
        this.Wwwwwwwwwwwwwww = surface;
        this.Wwwwwwwwwwwwww = z;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f) {
        Wwwwwwwwwwwwwwwwwwwwwww();
        float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f, 0.0f, 1.0f);
        if (this.Wwww == Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
            return;
        }
        this.Wwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1, 2, Float.valueOf(this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww * Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2));
        Iterator<AbstractC1934b5> it = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.iterator();
        while (it.hasNext()) {
            it.next().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, int i, int i2) {
        int i3 = 0;
        boolean z2 = z && i != -1;
        if (z2 && i != 1) {
            i3 = 1;
        }
        C2097f3 c2097f3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        C2621t3 c2621t3 = c2097f3.Wwwwwwwwwwww;
        if (c2621t3.Wwwwwwwwwwwwwwwwwwwwwwwww == z2 && c2621t3.Wwwwwwwwwwwwwwwwwwwwwwww == i3) {
            return;
        }
        c2097f3.Wwwwwwwwwwwwwwwwww++;
        C2621t3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2097f3.Wwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z2, i3);
        Handler handler = c2097f3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i4 = z2 ? 1 : 0;
        int i5 = z2 ? 1 : 0;
        handler.obtainMessage(1, i4, i3).sendToTarget();
        c2097f3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, false, 4, 0, i2, false);
    }
}
