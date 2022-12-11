package me.tvspark;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.SingleRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public class Kkkkkkkkkkkkk<TranscodeType> extends AbstractC2427o0<Kkkkkkkkkkkkk<TranscodeType>> implements Cloneable {
    public boolean Kkkkkkkkkkkkkk;
    public boolean Kkkkkkkkkkkkkkk = true;
    @Nullable
    public List<AbstractC2507q0<TranscodeType>> Kkkkkkkkkkkkkkkk;
    @Nullable
    public Object Kkkkkkkkkkkkkkkkk;
    @NonNull
    public Kkkkkkkkkkk<?, ? super TranscodeType> Kkkkkkkkkkkkkkkkkk;
    public final Kkkkkkkkkkkkkk Kkkkkkkkkkkkkkkkkkk;
    public final Class<TranscodeType> Kkkkkkkkkkkkkkkkkkkk;
    public final Kkkkkkkkkkkk Kkkkkkkkkkkkkkkkkkkkk;
    public final Context Kkkkkkkkkkkkkkkkkkkkkk;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public static final /* synthetic */ int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public static final /* synthetic */ int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        static {
            int[] iArr = new int[Priority.values().length];
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iArr;
            try {
                Priority priority = Priority.LOW;
                iArr[3] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                Priority priority2 = Priority.NORMAL;
                iArr2[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                Priority priority3 = Priority.HIGH;
                iArr3[1] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                Priority priority4 = Priority.IMMEDIATE;
                iArr4[0] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr5 = new int[ImageView.ScaleType.values().length];
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iArr5;
            try {
                iArr5[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    static {
        new C2544r0().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(IIll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Priority.LOW).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"CheckResult"})
    public Kkkkkkkkkkkkk(@NonNull Kkkkkkkkkkkkkkkk kkkkkkkkkkkkkkkk, Kkkkkkkkkkkk kkkkkkkkkkkk, Class<TranscodeType> cls, Context context) {
        this.Kkkkkkkkkkkkkkkkkkkkk = kkkkkkkkkkkk;
        this.Kkkkkkkkkkkkkkkkkkkk = cls;
        this.Kkkkkkkkkkkkkkkkkkkkkk = context;
        Kkkkkkkkkkkkkk kkkkkkkkkkkkkk = kkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww;
        Kkkkkkkkkkk<?, ?> kkkkkkkkkkk = kkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(cls);
        if (kkkkkkkkkkk == null) {
            for (Map.Entry<Class<?>, Kkkkkkkkkkk<?, ?>> entry : kkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    kkkkkkkkkkk = (Kkkkkkkkkkk<?, ? super TranscodeType>) entry.getValue();
                }
            }
        }
        this.Kkkkkkkkkkkkkkkkkk = (Kkkkkkkkkkk<?, ? super TranscodeType>) (kkkkkkkkkkk == null ? (Kkkkkkkkkkk<?, ? super TranscodeType>) Kkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwww : kkkkkkkkkkk);
        this.Kkkkkkkkkkkkkkkkkkk = kkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwww;
        for (AbstractC2507q0<Object> abstractC2507q0 : kkkkkkkkkkkk.Wwwwwwwwwwwwwww) {
            if (abstractC2507q0 != null) {
                if (this.Kkkkkkkkkkkkkkkk == null) {
                    this.Kkkkkkkkkkkkkkkk = new ArrayList();
                }
                this.Kkkkkkkkkkkkkkkk.add(abstractC2507q0);
            }
        }
        mo4926Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2427o0<?>) kkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    @Override // me.tvspark.AbstractC2427o0
    @NonNull
    @CheckResult
    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    public Kkkkkkkkkkkkk<TranscodeType> mo4926Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull AbstractC2427o0<?> abstractC2427o0) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2427o0, "Argument must not be null");
        return (Kkkkkkkkkkkkk) super.mo4926Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2427o0);
    }

    @Override // me.tvspark.AbstractC2427o0
    @NonNull
    @CheckResult
    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ AbstractC2427o0 mo4926Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull AbstractC2427o0 abstractC2427o0) {
        return mo4926Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2427o0<?>) abstractC2427o0);
    }

    @Override // me.tvspark.AbstractC2427o0
    @CheckResult
    /* renamed from: clone  reason: collision with other method in class */
    public AbstractC2427o0 mo4927clone() {
        Kkkkkkkkkkkkk kkkkkkkkkkkkk = (Kkkkkkkkkkkkk) super.mo4927clone();
        kkkkkkkkkkkkk.Kkkkkkkkkkkkkkkkkk = (Kkkkkkkkkkk<?, ? super TranscodeType>) kkkkkkkkkkkkk.Kkkkkkkkkkkkkkkkkk.m4925clone();
        return kkkkkkkkkkkkk;
    }

    @Override // me.tvspark.AbstractC2427o0
    @CheckResult
    /* renamed from: clone */
    public Object mo4927clone() throws CloneNotSupportedException {
        Kkkkkkkkkkkkk kkkkkkkkkkkkk = (Kkkkkkkkkkkkk) super.mo4927clone();
        kkkkkkkkkkkkk.Kkkkkkkkkkkkkkkkkk = (Kkkkkkkkkkk<?, ? super TranscodeType>) kkkkkkkkkkkkk.Kkkkkkkkkkkkkkkkkk.m4925clone();
        return kkkkkkkkkkkkk;
    }

    public final AbstractC2464p0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, AbstractC1930b1<TranscodeType> abstractC1930b1, @Nullable AbstractC2507q0<TranscodeType> abstractC2507q0, @Nullable RequestCoordinator requestCoordinator, Kkkkkkkkkkk<?, ? super TranscodeType> kkkkkkkkkkk, Priority priority, int i, int i2, AbstractC2427o0<?> abstractC2427o0, Executor executor) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, abstractC1930b1, abstractC2507q0, abstractC2427o0, requestCoordinator, kkkkkkkkkkk, priority, i, i2, executor);
    }

    public final <Y extends AbstractC1930b1<TranscodeType>> Y Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Y y, @Nullable AbstractC2507q0<TranscodeType> abstractC2507q0, AbstractC2427o0<?> abstractC2427o0, Executor executor) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(y, "Argument must not be null");
        if (this.Kkkkkkkkkkkkkk) {
            AbstractC2464p0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Object(), y, abstractC2507q0, (RequestCoordinator) null, this.Kkkkkkkkkkkkkkkkkk, abstractC2427o0.Wwwwwwwwwwwwwwwwwwwww, abstractC2427o0.Wwwwwwwwwwwwww, abstractC2427o0.Wwwwwwwwwwwwwww, abstractC2427o0, executor);
            AbstractC2464p0 request = y.getRequest();
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(request)) {
                if (!(!abstractC2427o0.Wwwwwwwwwwwwwwww && request.isComplete())) {
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(request, "Argument must not be null");
                    if (!request.isRunning()) {
                        request.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    }
                    return y;
                }
            }
            this.Kkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC1930b1<?>) y);
            y.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            this.Kkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(y, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            return y;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c0  */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AbstractC1967c1<ImageView, TranscodeType> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull ImageView imageView) {
        AbstractC2427o0<?> abstractC2427o0;
        Kkkkkkkkkkkkkk kkkkkkkkkkkkkk;
        AbstractC1967c1<ImageView, TranscodeType> c2733w0;
        AbstractC2427o0 mo4927clone;
        DownsampleStrategy downsampleStrategy;
        Zzzzzzzzz zzzzzzzzz;
        C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(imageView, "Argument must not be null");
        if (!AbstractC2427o0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, 2048) && this.Wwwwwwwwwww && imageView.getScaleType() != null) {
            switch (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[imageView.getScaleType().ordinal()]) {
                case 1:
                    AbstractC2427o0 mo4927clone2 = mo4927clone();
                    if (mo4927clone2 == null) {
                        throw null;
                    }
                    abstractC2427o0 = mo4927clone2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DownsampleStrategy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, new Zzzzzzzzzz());
                    break;
                case 2:
                    mo4927clone = mo4927clone();
                    if (mo4927clone != null) {
                        downsampleStrategy = DownsampleStrategy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        zzzzzzzzz = new Zzzzzzzzz();
                        abstractC2427o0 = mo4927clone.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(downsampleStrategy, zzzzzzzzz);
                        abstractC2427o0.Kkkkkkkkkkkkkkkkkkkkkkkk = true;
                        break;
                    } else {
                        throw null;
                    }
                case 3:
                case 4:
                case 5:
                    AbstractC2427o0 mo4927clone3 = mo4927clone();
                    if (mo4927clone3 != null) {
                        abstractC2427o0 = mo4927clone3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DownsampleStrategy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, new Zzz());
                        abstractC2427o0.Kkkkkkkkkkkkkkkkkkkkkkkk = true;
                        break;
                    } else {
                        throw null;
                    }
                case 6:
                    mo4927clone = mo4927clone();
                    if (mo4927clone == null) {
                        throw null;
                    }
                    downsampleStrategy = DownsampleStrategy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    zzzzzzzzz = new Zzzzzzzzz();
                    abstractC2427o0 = mo4927clone.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(downsampleStrategy, zzzzzzzzz);
                    abstractC2427o0.Kkkkkkkkkkkkkkkkkkkkkkkk = true;
                    break;
            }
            kkkkkkkkkkkkkk = this.Kkkkkkkkkkkkkkkkkkk;
            Class<TranscodeType> cls = this.Kkkkkkkkkkkkkkkkkkkk;
            if (kkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                throw null;
            }
            if (Bitmap.class.equals(cls)) {
                c2733w0 = new C2655u0(imageView);
            } else if (!Drawable.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException("Unhandled class: " + cls + ", try .as*(Class).transcode(ResourceTranscoder)");
            } else {
                c2733w0 = new C2733w0(imageView);
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2733w0, null, abstractC2427o0, C2391n1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            return c2733w0;
        }
        abstractC2427o0 = this;
        kkkkkkkkkkkkkk = this.Kkkkkkkkkkkkkkkkkkk;
        Class<TranscodeType> cls2 = this.Kkkkkkkkkkkkkkkkkkkk;
        if (kkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
        }
    }

    @NonNull
    @CheckResult
    public Kkkkkkkkkkkkk<TranscodeType> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable AbstractC2507q0<TranscodeType> abstractC2507q0) {
        this.Kkkkkkkkkkkkkkkk = null;
        if (abstractC2507q0 != null) {
            ArrayList arrayList = new ArrayList();
            this.Kkkkkkkkkkkkkkkk = arrayList;
            arrayList.add(abstractC2507q0);
        }
        return this;
    }

    @NonNull
    @CheckResult
    public Kkkkkkkkkkkkk<TranscodeType> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable @DrawableRes @RawRes Integer num) {
        this.Kkkkkkkkkkkkkkkkk = num;
        this.Kkkkkkkkkkkkkk = true;
        return mo4926Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2427o0<?>) new C2544r0().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2132g1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkkkkkkk)));
    }

    @NonNull
    @CheckResult
    public Kkkkkkkkkkkkk<TranscodeType> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable Object obj) {
        this.Kkkkkkkkkkkkkkkkk = obj;
        this.Kkkkkkkkkkkkkk = true;
        return this;
    }

    public final AbstractC2464p0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, AbstractC1930b1<TranscodeType> abstractC1930b1, AbstractC2507q0<TranscodeType> abstractC2507q0, AbstractC2427o0<?> abstractC2427o0, RequestCoordinator requestCoordinator, Kkkkkkkkkkk<?, ? super TranscodeType> kkkkkkkkkkk, Priority priority, int i, int i2, Executor executor) {
        Context context = this.Kkkkkkkkkkkkkkkkkkkkkk;
        Kkkkkkkkkkkkkk kkkkkkkkkkkkkk = this.Kkkkkkkkkkkkkkkkkkk;
        return new SingleRequest(context, kkkkkkkkkkkkkk, obj, this.Kkkkkkkkkkkkkkkkk, this.Kkkkkkkkkkkkkkkkkkkk, abstractC2427o0, i, i2, priority, abstractC1930b1, abstractC2507q0, this.Kkkkkkkkkkkkkkkk, requestCoordinator, kkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, kkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwww, executor);
    }
}
