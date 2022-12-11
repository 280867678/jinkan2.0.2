package me.tvspark;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.util.Map;
import me.tvspark.AbstractC2427o0;

/* renamed from: me.tvspark.o0 */
/* loaded from: classes4.dex */
public abstract class AbstractC2427o0<T extends AbstractC2427o0<T>> implements Cloneable {
    public boolean Kkkkkkkkkkkkkkkkkkkkkkk;
    public boolean Kkkkkkkkkkkkkkkkkkkkkkkkk;
    public boolean Kkkkkkkkkkkkkkkkkkkkkkkkkk;
    public boolean Www;
    @Nullable
    public Resources.Theme Wwww;
    public boolean Wwwww;
    public int Wwwwwwwww;
    @Nullable
    public Drawable Wwwwwwwwww;
    public boolean Wwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwww;
    @Nullable
    public Drawable Wwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwww;
    @Nullable
    public Drawable Wwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwwwwwwwwwww = 1.0f;
    @NonNull
    public IIll Wwwwwwwwwwwwwwwwwwwwww = IIll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @NonNull
    public Priority Wwwwwwwwwwwwwwwwwwwww = Priority.NORMAL;
    public boolean Wwwwwwwwwwwwwwww = true;
    public int Wwwwwwwwwwwwwww = -1;
    public int Wwwwwwwwwwwwww = -1;
    @NonNull
    public Illlllllllllllllllllllllllll Wwwwwwwwwwwww = C2206i1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwww = true;
    @NonNull
    public Illllllllllllllllllllllll Wwwwwwww = new Illllllllllllllllllllllll();
    @NonNull
    public Map<Class<?>, Illlllllllllllllllllll<?>> Wwwwwww = new CachedHashCodeArrayMap();
    @NonNull
    public Class<?> Wwwwww = Object.class;
    public boolean Kkkkkkkkkkkkkkkkkkkkkkkk = true;

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        return (i & i2) != 0;
    }

    @NonNull
    public final T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (!this.Wwwww) {
            return this;
        }
        throw new IllegalStateException("You cannot modify locked T, consider clone()");
    }

    @NonNull
    @CheckResult
    public T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@DrawableRes int i) {
        if (this.Www) {
            return (T) mo4927clone().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        }
        this.Wwwwwwwwwwwwwwwww = i;
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwww | 128;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = i2;
        this.Wwwwwwwwwwwwwwwwww = null;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = i2 & (-65);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return this;
    }

    @NonNull
    @CheckResult
    public final T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull DownsampleStrategy downsampleStrategy, @NonNull Illlllllllllllllllllll<Bitmap> illlllllllllllllllllll) {
        if (this.Www) {
            return (T) mo4927clone().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(downsampleStrategy, illlllllllllllllllllll);
        }
        Illlllllllllllllllllllllll illlllllllllllllllllllllll = DownsampleStrategy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(downsampleStrategy, "Argument must not be null");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Illlllllllllllllllllllllll<Illlllllllllllllllllllllll>) illlllllllllllllllllllllll, (Illlllllllllllllllllllllll) downsampleStrategy);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(illlllllllllllllllllll, true);
    }

    @NonNull
    @CheckResult
    public T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        if (this.Www) {
            return (T) mo4927clone().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
        }
        this.Kkkkkkkkkkkkkkkkkkkkkkk = z;
        this.Wwwwwwwwwwwwwwwwwwwwwwww |= 1048576;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return this;
    }

    @NonNull
    @CheckResult
    public T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DownsampleStrategy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, new Zzzzzzzzzz());
    }

    @NonNull
    @CheckResult
    public T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@DrawableRes int i) {
        if (this.Www) {
            return (T) mo4927clone().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        }
        this.Wwwwwwwwwwwwwwwwwww = i;
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwww | 32;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = i2;
        this.Wwwwwwwwwwwwwwwwwwww = null;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = i2 & (-17);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return this;
    }

    @NonNull
    @CheckResult
    public T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        if (this.Www) {
            return (T) mo4927clone().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2);
        }
        this.Wwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwww = i2;
        this.Wwwwwwwwwwwwwwwwwwwwwwww |= 512;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return this;
    }

    @NonNull
    @CheckResult
    public T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Class<?> cls) {
        if (this.Www) {
            return (T) mo4927clone().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls);
        }
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls, "Argument must not be null");
        this.Wwwwww = cls;
        this.Wwwwwwwwwwwwwwwwwwwwwwww |= 4096;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return this;
    }

    @NonNull
    @CheckResult
    public T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Illlllllllllllllllllll<Bitmap> illlllllllllllllllllll) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(illlllllllllllllllllll, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Illlllllllllllllllllll<Bitmap> illlllllllllllllllllll, boolean z) {
        if (this.Www) {
            return (T) mo4927clone().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(illlllllllllllllllllll, z);
        }
        Zzzzz zzzzz = new Zzzzz(illlllllllllllllllllll, z);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bitmap.class, illlllllllllllllllllll, z);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Drawable.class, zzzzz, z);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(BitmapDrawable.class, zzzzz, z);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(GifDrawable.class, new C1928b(illlllllllllllllllllll), z);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return this;
    }

    @NonNull
    @CheckResult
    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    public T mo4926Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull AbstractC2427o0<?> abstractC2427o0) {
        if (this.Www) {
            return (T) mo4927clone().mo4926Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2427o0);
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2427o0.Wwwwwwwwwwwwwwwwwwwwwwww, 2)) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = abstractC2427o0.Wwwwwwwwwwwwwwwwwwwwwww;
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2427o0.Wwwwwwwwwwwwwwwwwwwwwwww, 262144)) {
            this.Kkkkkkkkkkkkkkkkkkkkkkkkkk = abstractC2427o0.Kkkkkkkkkkkkkkkkkkkkkkkkkk;
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2427o0.Wwwwwwwwwwwwwwwwwwwwwwww, 1048576)) {
            this.Kkkkkkkkkkkkkkkkkkkkkkk = abstractC2427o0.Kkkkkkkkkkkkkkkkkkkkkkk;
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2427o0.Wwwwwwwwwwwwwwwwwwwwwwww, 4)) {
            this.Wwwwwwwwwwwwwwwwwwwwww = abstractC2427o0.Wwwwwwwwwwwwwwwwwwwwww;
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2427o0.Wwwwwwwwwwwwwwwwwwwwwwww, 8)) {
            this.Wwwwwwwwwwwwwwwwwwwww = abstractC2427o0.Wwwwwwwwwwwwwwwwwwwww;
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2427o0.Wwwwwwwwwwwwwwwwwwwwwwww, 16)) {
            this.Wwwwwwwwwwwwwwwwwwww = abstractC2427o0.Wwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwww = 0;
            this.Wwwwwwwwwwwwwwwwwwwwwwww &= -33;
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2427o0.Wwwwwwwwwwwwwwwwwwwwwwww, 32)) {
            this.Wwwwwwwwwwwwwwwwwww = abstractC2427o0.Wwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwww &= -17;
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2427o0.Wwwwwwwwwwwwwwwwwwwwwwww, 64)) {
            this.Wwwwwwwwwwwwwwwwww = abstractC2427o0.Wwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwww = 0;
            this.Wwwwwwwwwwwwwwwwwwwwwwww &= -129;
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2427o0.Wwwwwwwwwwwwwwwwwwwwwwww, 128)) {
            this.Wwwwwwwwwwwwwwwww = abstractC2427o0.Wwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwww &= -65;
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2427o0.Wwwwwwwwwwwwwwwwwwwwwwww, 256)) {
            this.Wwwwwwwwwwwwwwww = abstractC2427o0.Wwwwwwwwwwwwwwww;
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2427o0.Wwwwwwwwwwwwwwwwwwwwwwww, 512)) {
            this.Wwwwwwwwwwwwww = abstractC2427o0.Wwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwww = abstractC2427o0.Wwwwwwwwwwwwwww;
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2427o0.Wwwwwwwwwwwwwwwwwwwwwwww, 1024)) {
            this.Wwwwwwwwwwwww = abstractC2427o0.Wwwwwwwwwwwww;
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2427o0.Wwwwwwwwwwwwwwwwwwwwwwww, 4096)) {
            this.Wwwwww = abstractC2427o0.Wwwwww;
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2427o0.Wwwwwwwwwwwwwwwwwwwwwwww, 8192)) {
            this.Wwwwwwwwww = abstractC2427o0.Wwwwwwwwww;
            this.Wwwwwwwww = 0;
            this.Wwwwwwwwwwwwwwwwwwwwwwww &= -16385;
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2427o0.Wwwwwwwwwwwwwwwwwwwwwwww, 16384)) {
            this.Wwwwwwwww = abstractC2427o0.Wwwwwwwww;
            this.Wwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwww &= -8193;
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2427o0.Wwwwwwwwwwwwwwwwwwwwwwww, 32768)) {
            this.Wwww = abstractC2427o0.Wwww;
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2427o0.Wwwwwwwwwwwwwwwwwwwwwwww, 65536)) {
            this.Wwwwwwwwwww = abstractC2427o0.Wwwwwwwwwww;
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2427o0.Wwwwwwwwwwwwwwwwwwwwwwww, 131072)) {
            this.Wwwwwwwwwwww = abstractC2427o0.Wwwwwwwwwwww;
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2427o0.Wwwwwwwwwwwwwwwwwwwwwwww, 2048)) {
            this.Wwwwwww.putAll(abstractC2427o0.Wwwwwww);
            this.Kkkkkkkkkkkkkkkkkkkkkkkk = abstractC2427o0.Kkkkkkkkkkkkkkkkkkkkkkkk;
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2427o0.Wwwwwwwwwwwwwwwwwwwwwwww, 524288)) {
            this.Kkkkkkkkkkkkkkkkkkkkkkkkk = abstractC2427o0.Kkkkkkkkkkkkkkkkkkkkkkkkk;
        }
        if (!this.Wwwwwwwwwww) {
            this.Wwwwwww.clear();
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwww & (-2049);
            this.Wwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwww = false;
            this.Wwwwwwwwwwwwwwwwwwwwwwww = i & (-131073);
            this.Kkkkkkkkkkkkkkkkkkkkkkkk = true;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwww |= abstractC2427o0.Wwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2427o0.Wwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return this;
    }

    @NonNull
    @CheckResult
    public T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        if (this.Www) {
            return (T) mo4927clone().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
        }
        this.Wwwwwwwwwwwwwwww = !z;
        this.Wwwwwwwwwwwwwwwwwwwwwwww |= 256;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return this;
    }

    @NonNull
    @CheckResult
    public T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Illlllllllllllllllllll<Bitmap>... illlllllllllllllllllllArr) {
        if (illlllllllllllllllllllArr.length > 1) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Illlllllllllllllllllll<Bitmap>) new Illllllllllllllllllllllllll(illlllllllllllllllllllArr), true);
        }
        if (illlllllllllllllllllllArr.length == 1) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(illlllllllllllllllllllArr[0]);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return this;
    }

    @Override // 
    @CheckResult
    /* renamed from: clone */
    public T mo4927clone() {
        try {
            T t = (T) super.clone();
            Illllllllllllllllllllllll illllllllllllllllllllllll = new Illllllllllllllllllllllll();
            t.Wwwwwwww = illllllllllllllllllllllll;
            illllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwww);
            CachedHashCodeArrayMap cachedHashCodeArrayMap = new CachedHashCodeArrayMap();
            t.Wwwwwww = cachedHashCodeArrayMap;
            cachedHashCodeArrayMap.putAll(this.Wwwwwww);
            t.Wwwww = false;
            t.Www = false;
            return t;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof AbstractC2427o0) {
            AbstractC2427o0 abstractC2427o0 = (AbstractC2427o0) obj;
            return Float.compare(abstractC2427o0.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww) == 0 && this.Wwwwwwwwwwwwwwwwwww == abstractC2427o0.Wwwwwwwwwwwwwwwwwww && C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwww, abstractC2427o0.Wwwwwwwwwwwwwwwwwwww) && this.Wwwwwwwwwwwwwwwww == abstractC2427o0.Wwwwwwwwwwwwwwwww && C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwww, abstractC2427o0.Wwwwwwwwwwwwwwwwww) && this.Wwwwwwwww == abstractC2427o0.Wwwwwwwww && C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwww, abstractC2427o0.Wwwwwwwwww) && this.Wwwwwwwwwwwwwwww == abstractC2427o0.Wwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwww == abstractC2427o0.Wwwwwwwwwwwwwww && this.Wwwwwwwwwwwwww == abstractC2427o0.Wwwwwwwwwwwwww && this.Wwwwwwwwwwww == abstractC2427o0.Wwwwwwwwwwww && this.Wwwwwwwwwww == abstractC2427o0.Wwwwwwwwwww && this.Kkkkkkkkkkkkkkkkkkkkkkkkkk == abstractC2427o0.Kkkkkkkkkkkkkkkkkkkkkkkkkk && this.Kkkkkkkkkkkkkkkkkkkkkkkkk == abstractC2427o0.Kkkkkkkkkkkkkkkkkkkkkkkkk && this.Wwwwwwwwwwwwwwwwwwwwww.equals(abstractC2427o0.Wwwwwwwwwwwwwwwwwwwwww) && this.Wwwwwwwwwwwwwwwwwwwww == abstractC2427o0.Wwwwwwwwwwwwwwwwwwwww && this.Wwwwwwww.equals(abstractC2427o0.Wwwwwwww) && this.Wwwwwww.equals(abstractC2427o0.Wwwwwww) && this.Wwwwww.equals(abstractC2427o0.Wwwwww) && C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwww, abstractC2427o0.Wwwwwwwwwwwww) && C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwww, abstractC2427o0.Wwww);
        }
        return false;
    }

    public int hashCode() {
        return C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwww, C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwww, C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwww, C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwww, C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwww, C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwww, C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww, (((((((((((((C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwww, (C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwww, (C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwww, (C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww) * 31) + this.Wwwwwwwwwwwwwwwwwww) * 31) + this.Wwwwwwwwwwwwwwwww) * 31) + this.Wwwwwwwww) * 31) + (this.Wwwwwwwwwwwwwwww ? 1 : 0)) * 31) + this.Wwwwwwwwwwwwwww) * 31) + this.Wwwwwwwwwwwwww) * 31) + (this.Wwwwwwwwwwww ? 1 : 0)) * 31) + (this.Wwwwwwwwwww ? 1 : 0)) * 31) + (this.Kkkkkkkkkkkkkkkkkkkkkkkkkk ? 1 : 0)) * 31) + (this.Kkkkkkkkkkkkkkkkkkkkkkkkk ? 1 : 0))))))));
    }

    @NonNull
    @CheckResult
    public T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull IIll iIll) {
        if (this.Www) {
            return (T) mo4927clone().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iIll);
        }
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iIll, "Argument must not be null");
        this.Wwwwwwwwwwwwwwwwwwwwww = iIll;
        this.Wwwwwwwwwwwwwwwwwwwwwwww |= 4;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return this;
    }

    @NonNull
    public final T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull DownsampleStrategy downsampleStrategy, @NonNull Illlllllllllllllllllll<Bitmap> illlllllllllllllllllll) {
        if (this.Www) {
            return (T) mo4927clone().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(downsampleStrategy, illlllllllllllllllllll);
        }
        Illlllllllllllllllllllllll illlllllllllllllllllllllll = DownsampleStrategy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(downsampleStrategy, "Argument must not be null");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Illlllllllllllllllllllllll<Illlllllllllllllllllllllll>) illlllllllllllllllllllllll, (Illlllllllllllllllllllllll) downsampleStrategy);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(illlllllllllllllllllll, false);
    }

    @NonNull
    @CheckResult
    public T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Priority priority) {
        if (this.Www) {
            return (T) mo4927clone().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(priority);
        }
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(priority, "Argument must not be null");
        this.Wwwwwwwwwwwwwwwwwwwww = priority;
        this.Wwwwwwwwwwwwwwwwwwwwwwww |= 8;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return this;
    }

    @NonNull
    @CheckResult
    public <Y> T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Illlllllllllllllllllllllll<Y> illlllllllllllllllllllllll, @NonNull Y y) {
        if (this.Www) {
            return (T) mo4927clone().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(illlllllllllllllllllllllll, y);
        }
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(illlllllllllllllllllllllll, "Argument must not be null");
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(y, "Argument must not be null");
        this.Wwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(illlllllllllllllllllllllll, y);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return this;
    }

    @NonNull
    @CheckResult
    public T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Illlllllllllllllllllllllllll illlllllllllllllllllllllllll) {
        if (this.Www) {
            return (T) mo4927clone().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(illlllllllllllllllllllllllll);
        }
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(illlllllllllllllllllllllllll, "Argument must not be null");
        this.Wwwwwwwwwwwww = illlllllllllllllllllllllllll;
        this.Wwwwwwwwwwwwwwwwwwwwwwww |= 1024;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return this;
    }

    @NonNull
    public <Y> T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Class<Y> cls, @NonNull Illlllllllllllllllllll<Y> illlllllllllllllllllll, boolean z) {
        if (this.Www) {
            return (T) mo4927clone().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls, illlllllllllllllllllll, z);
        }
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls, "Argument must not be null");
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(illlllllllllllllllllll, "Argument must not be null");
        this.Wwwwwww.put(cls, illlllllllllllllllllll);
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwww | 2048;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwww = true;
        int i2 = i | 65536;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = i2;
        this.Kkkkkkkkkkkkkkkkkkkkkkkk = false;
        if (z) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = i2 | 131072;
            this.Wwwwwwwwwwww = true;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return this;
    }
}
