package me.tvspark;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes4.dex */
public class QQOOOO implements OO0 {
    public static final Bitmap.Config Wwwwwwwwwwwwwwwwwwwwwwwww = Bitmap.Config.ARGB_8888;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Set<Bitmap.Config> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final QQOOO Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    public QQOOOO(long j) {
        QQO qqo = new QQO();
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        hashSet.add(null);
        if (Build.VERSION.SDK_INT >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        Set<Bitmap.Config> unmodifiableSet = Collections.unmodifiableSet(hashSet);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = qqo;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = unmodifiableSet;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Nullable
    public final synchronized Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, @Nullable Bitmap.Config config) {
        Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2, config != null ? config : Wwwwwwwwwwwwwwwwwwwwwwwww);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2, config);
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww++;
        } else {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww -= this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            if (((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) != null) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.setHasAlpha(true);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.setPremultiplied(true);
            } else {
                throw null;
            }
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2, config);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Hits=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(", misses=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(", puts=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(", evictions=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(", currentSize=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(", maxSize=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append("\nStrategy=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
    }

    @Override // me.tvspark.OO0
    @NonNull
    public Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, Bitmap.Config config) {
        Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2, config);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            if (config == null) {
                config = Wwwwwwwwwwwwwwwwwwwwwwwww;
            }
            return Bitmap.createBitmap(i, i2, config);
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    @Override // me.tvspark.OO0
    @NonNull
    public Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, Bitmap.Config config) {
        Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2, config);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.eraseColor(0);
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        if (config == null) {
            config = Wwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return Bitmap.createBitmap(i, i2, config);
    }

    @Override // me.tvspark.OO0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Log.isLoggable("LruBitmapPool", 3);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0L);
    }

    @Override // me.tvspark.OO0
    @SuppressLint({"InlinedApi"})
    public void trimMemory(int i) {
        Log.isLoggable("LruBitmapPool", 3);
        if (i >= 40 || (Build.VERSION.SDK_INT >= 23 && i >= 20)) {
            Log.isLoggable("LruBitmapPool", 3);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0L);
        } else if (i < 20 && i != 15) {
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww / 2);
        }
    }

    @Override // me.tvspark.OO0
    public synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bitmap bitmap) {
        try {
            if (bitmap == null) {
                throw new NullPointerException("Bitmap must not be null");
            }
            if (bitmap.isRecycled()) {
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            if (bitmap.isMutable() && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bitmap) <= this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.contains(bitmap.getConfig())) {
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bitmap);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bitmap);
                if (((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) != null) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwww++;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww += Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bitmap);
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    return;
                }
                throw null;
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bitmap);
                bitmap.isMutable();
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.contains(bitmap.getConfig());
            }
            bitmap.recycle();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        while (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww > j) {
            Bitmap removeLast = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.removeLast();
            if (removeLast == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0L;
                return;
            } else if (((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) == null) {
                throw null;
            } else {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww -= this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(removeLast);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwww++;
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(removeLast);
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                removeLast.recycle();
            }
        }
    }
}
