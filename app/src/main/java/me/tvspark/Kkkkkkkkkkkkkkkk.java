package me.tvspark;

import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.GeneratedAppGlideModule;
import com.bumptech.glide.MemoryCategory;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.stub.StubApp;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import me.tvspark.C1881Cc;
import me.tvspark.C1887Ss;
import me.tvspark.C1888Uu;
import me.tvspark.Illllllll;
import me.tvspark.Illllllllll;
import me.tvspark.Illllllllllllllll;
import me.tvspark.Lllllllll;
import me.tvspark.Mmmmmmmmmm;
import me.tvspark.Oooo;
import me.tvspark.Ooooo;
import me.tvspark.Oooooo;
import me.tvspark.Oooooooo;
import me.tvspark.Ooooooooo;
import me.tvspark.Oooooooooo;
import me.tvspark.Uuu;
import me.tvspark.Uuuu;
import me.tvspark.Uuuuu;
import me.tvspark.Uuuuuu;
import me.tvspark.Uuuuuuu;
import me.tvspark.Uuuuuuuu;
import me.tvspark.Uuuuuuuuu;
import me.tvspark.Uuuuuuuuuu;
import me.tvspark.Uuuuuuuuuuuu;
import me.tvspark.Xxxxxxxxxxx;

/* loaded from: classes4.dex */
public class Kkkkkkkkkkkkkkkk implements ComponentCallbacks2 {
    public static volatile boolean Wwwwwwwwwwwwwww;
    public static volatile Kkkkkkkkkkkkkkkk Wwwwwwwwwwwwwwww;
    public final List<Kkkkkkkkkkkk> Wwwwwwwwwwwwwwwww = new ArrayList();
    public final AbstractC2506q Wwwwwwwwwwwwwwwwww;
    public final C2806y Wwwwwwwwwwwwwwwwwww;
    public final OO000 Wwwwwwwwwwwwwwwwwwww;
    public final Registry Wwwwwwwwwwwwwwwwwwwww;
    public final Kkkkkkkkkkkkkk Wwwwwwwwwwwwwwwwwwwwww;
    public final Sss Wwwwwwwwwwwwwwwwwwwwwww;
    public final OO0 Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    public Kkkkkkkkkkkkkkkk(@NonNull Context context, @NonNull IIl iIl, @NonNull Sss sss, @NonNull OO0 oo0, @NonNull OO000 oo000, @NonNull C2806y c2806y, @NonNull AbstractC2506q abstractC2506q, int i, @NonNull Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, @NonNull Map<Class<?>, Kkkkkkkkkkk<?, ?>> map, @NonNull List<AbstractC2507q0<Object>> list, boolean z, boolean z2) {
        Illlllllllllllllllllllll c1889Xx;
        Illlllllllllllllllllllll ccccc;
        MemoryCategory memoryCategory = MemoryCategory.NORMAL;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = oo0;
        this.Wwwwwwwwwwwwwwwwwwww = oo000;
        this.Wwwwwwwwwwwwwwwwwwwwwww = sss;
        this.Wwwwwwwwwwwwwwwwwww = c2806y;
        this.Wwwwwwwwwwwwwwwwww = abstractC2506q;
        Resources resources = context.getResources();
        Registry registry = new Registry();
        this.Wwwwwwwwwwwwwwwwwwwww = registry;
        registry.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new DefaultImageHeaderParser());
        if (Build.VERSION.SDK_INT >= 27) {
            Registry registry2 = this.Wwwwwwwwwwwwwwwwwwwww;
            registry2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Zzzz());
        }
        List<ImageHeaderParser> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        tooYoung tooyoung = new tooYoung(context, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, oo0, oo000);
        C1881Cc c1881Cc = new C1881Cc(oo0, new C1881Cc.Wwwwwwwwwwwwwwwwwwwwwwwwwwww());
        Zzzzzzz zzzzzzz = new Zzzzzzz(this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), resources.getDisplayMetrics(), oo0, oo000);
        if (!z2 || Build.VERSION.SDK_INT < 28) {
            c1889Xx = new C1889Xx(zzzzzzz);
            ccccc = new Ccccc(zzzzzzz, oo000);
        } else {
            ccccc = new Cccccccccc();
            c1889Xx = new Zzzzzzzzzzz();
        }
        Mmmmm mmmmm = new Mmmmm(context);
        Uuuuuuuuuuuu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Uuuuuuuuuuuu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(resources);
        Uuuuuuuuuuuu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Uuuuuuuuuuuu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(resources);
        Uuuuuuuuuuuu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Uuuuuuuuuuuu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(resources);
        Uuuuuuuuuuuu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new Uuuuuuuuuuuu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(resources);
        Xxxxxx xxxxxx = new Xxxxxx(oo000);
        C2130g c2130g = new C2130g();
        C2241j c2241j = new C2241j();
        ContentResolver contentResolver = context.getContentResolver();
        Registry registry3 = this.Wwwwwwwwwwwwwwwwwwwww;
        registry3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteBuffer.class, new Ooooooo());
        registry3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(InputStream.class, new Uuuuuuuuuuu(oo000));
        registry3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Bitmap", c1889Xx, ByteBuffer.class, Bitmap.class);
        registry3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Bitmap", ccccc, InputStream.class, Bitmap.class);
        Registry registry4 = this.Wwwwwwwwwwwwwwwwwwwww;
        registry4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Bitmap", new Cccccccc(zzzzzzz), ParcelFileDescriptor.class, Bitmap.class);
        Registry registry5 = this.Wwwwwwwwwwwwwwwwwwwww;
        registry5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Bitmap", c1881Cc, ParcelFileDescriptor.class, Bitmap.class);
        registry5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Bitmap", new C1881Cc(oo0, new C1881Cc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null)), AssetFileDescriptor.class, Bitmap.class);
        registry5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bitmap.class, Bitmap.class, Uuuuuuuuu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        registry5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Bitmap", new Ccc(), Bitmap.class, Bitmap.class);
        registry5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bitmap.class, xxxxxx);
        registry5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("BitmapDrawable", new Xxxxxxxx(resources, c1889Xx), ByteBuffer.class, BitmapDrawable.class);
        registry5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("BitmapDrawable", new Xxxxxxxx(resources, ccccc), InputStream.class, BitmapDrawable.class);
        registry5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("BitmapDrawable", new Xxxxxxxx(resources, c1881Cc), ParcelFileDescriptor.class, BitmapDrawable.class);
        registry5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(BitmapDrawable.class, new Xxxxxxx(oo0, xxxxxx));
        registry5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Gif", new C2093f(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, tooyoung, oo000), InputStream.class, GifDrawable.class);
        registry5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Gif", tooyoung, ByteBuffer.class, GifDrawable.class);
        registry5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(GifDrawable.class, new sometimesNaive());
        registry5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Kkkkkkk.class, Kkkkkkk.class, Uuuuuuuuu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        registry5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Bitmap", new C2002d(oo0), Kkkkkkk.class, Bitmap.class);
        registry5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("legacy_append", mmmmm, Uri.class, Drawable.class);
        registry5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("legacy_append", new Ccccccc(mmmmm, oo0), Uri.class, Bitmap.class);
        registry5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Illllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?>) new Mmmmmmmmmm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        registry5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(File.class, ByteBuffer.class, new Oooooo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        registry5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(File.class, InputStream.class, new Oooo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        registry5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("legacy_append", new Mmm(), File.class, File.class);
        registry5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(File.class, ParcelFileDescriptor.class, new Oooo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        registry5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(File.class, File.class, Uuuuuuuuu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        registry5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Illllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?>) new Illllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(oo000));
        Registry registry6 = this.Wwwwwwwwwwwwwwwwwwwww;
        registry6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Illllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?>) new Illllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        Registry registry7 = this.Wwwwwwwwwwwwwwwwwwwww;
        registry7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Integer.TYPE, InputStream.class, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        registry7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Integer.TYPE, ParcelFileDescriptor.class, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        registry7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Integer.class, InputStream.class, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        registry7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Integer.class, ParcelFileDescriptor.class, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        registry7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Integer.class, Uri.class, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        registry7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Integer.TYPE, AssetFileDescriptor.class, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        registry7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Integer.class, AssetFileDescriptor.class, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        registry7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Integer.TYPE, Uri.class, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        registry7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String.class, InputStream.class, new Ooooo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        registry7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri.class, InputStream.class, new Ooooo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        registry7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String.class, InputStream.class, new Uuuuuuuuuu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        registry7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String.class, ParcelFileDescriptor.class, new Uuuuuuuuuu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        registry7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String.class, AssetFileDescriptor.class, new Uuuuuuuuuu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        registry7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri.class, InputStream.class, new Uuuuu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        registry7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri.class, InputStream.class, new Ooooooooo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context.getAssets()));
        registry7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri.class, ParcelFileDescriptor.class, new Ooooooooo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context.getAssets()));
        registry7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri.class, InputStream.class, new Uuuu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context));
        registry7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri.class, InputStream.class, new Uuu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context));
        if (Build.VERSION.SDK_INT >= 29) {
            Registry registry8 = this.Wwwwwwwwwwwwwwwwwwwww;
            registry8.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri.class, InputStream.class, new C1888Uu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context));
            Registry registry9 = this.Wwwwwwwwwwwwwwwwwwwww;
            registry9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri.class, ParcelFileDescriptor.class, new C1888Uu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context));
        }
        Registry registry10 = this.Wwwwwwwwwwwwwwwwwwwww;
        registry10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri.class, InputStream.class, new Uuuuuuuu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(contentResolver));
        registry10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri.class, ParcelFileDescriptor.class, new Uuuuuuuu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(contentResolver));
        registry10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri.class, AssetFileDescriptor.class, new Uuuuuuuu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(contentResolver));
        registry10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri.class, InputStream.class, new Uuuuuuu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        registry10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(URL.class, InputStream.class, new Xxxxxxxxxxx.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        registry10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri.class, File.class, new Lllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context));
        registry10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Ooo.class, InputStream.class, new Uuuuuu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        registry10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[].class, ByteBuffer.class, new Oooooooo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        registry10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[].class, InputStream.class, new Oooooooo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        registry10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri.class, Uri.class, Uuuuuuuuu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        registry10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Drawable.class, Drawable.class, Uuuuuuuuu.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        registry10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("legacy_append", new Mmmm(), Drawable.class, Drawable.class);
        registry10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bitmap.class, BitmapDrawable.class, new C2167h(resources));
        registry10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bitmap.class, byte[].class, c2130g);
        registry10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Drawable.class, byte[].class, new C2204i(oo0, c2130g, c2241j));
        registry10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(GifDrawable.class, byte[].class, c2241j);
        if (Build.VERSION.SDK_INT >= 23) {
            C1881Cc c1881Cc2 = new C1881Cc(oo0, new C1881Cc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("legacy_append", c1881Cc2, ByteBuffer.class, Bitmap.class);
            Registry registry11 = this.Wwwwwwwwwwwwwwwwwwwww;
            registry11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("legacy_append", new Xxxxxxxx(resources, c1881Cc2), ByteBuffer.class, BitmapDrawable.class);
        }
        this.Wwwwwwwwwwwwwwwwwwwwww = new Kkkkkkkkkkkkkk(context, oo000, this.Wwwwwwwwwwwwwwwwwwwww, new C2807y0(), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, map, list, iIl, z, i);
    }

    @NonNull
    public static Kkkkkkkkkkkk Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Context context) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context).Wwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context);
    }

    @GuardedBy("Glide.class")
    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Context context, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        List<AbstractC2057e0> list;
        if (!Wwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwww = true;
            Kkkkkkkkkkkkkkk kkkkkkkkkkkkkkk = new Kkkkkkkkkkkkkkk();
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            List emptyList = Collections.emptyList();
            if (generatedAppGlideModule == null || generatedAppGlideModule.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                Log.isLoggable("ManifestParser", 3);
                ArrayList arrayList = new ArrayList();
                try {
                    ApplicationInfo applicationInfo = origApplicationContext.getPackageManager().getApplicationInfo(origApplicationContext.getPackageName(), 128);
                    if (applicationInfo.metaData == null) {
                        Log.isLoggable("ManifestParser", 3);
                    } else {
                        if (Log.isLoggable("ManifestParser", 2)) {
                            String str = "Got app info metadata: " + applicationInfo.metaData;
                        }
                        for (String str2 : applicationInfo.metaData.keySet()) {
                            if ("GlideModule".equals(applicationInfo.metaData.get(str2))) {
                                arrayList.add(C2131g0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2));
                                Log.isLoggable("ManifestParser", 3);
                            }
                        }
                        Log.isLoggable("ManifestParser", 3);
                    }
                    list = arrayList;
                } catch (PackageManager.NameNotFoundException e) {
                    throw new RuntimeException("Unable to find metadata to parse GlideModules", e);
                }
            } else {
                list = emptyList;
            }
            if (generatedAppGlideModule != null && !generatedAppGlideModule.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().isEmpty()) {
                Set<Class<?>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = generatedAppGlideModule.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    AbstractC2057e0 abstractC2057e0 = (AbstractC2057e0) it.next();
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.contains(abstractC2057e0.getClass())) {
                        if (Log.isLoggable("Glide", 3)) {
                            String str3 = "AppGlideModule excludes manifest GlideModule: " + abstractC2057e0;
                        }
                        it.remove();
                    }
                }
            }
            if (Log.isLoggable("Glide", 3)) {
                for (AbstractC2057e0 abstractC2057e02 : list) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Discovered GlideModule from manifest: ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(abstractC2057e02.getClass());
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
                }
            }
            kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwww = generatedAppGlideModule != null ? generatedAppGlideModule.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() : null;
            for (AbstractC2057e0 abstractC2057e03 : list) {
                abstractC2057e03.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(origApplicationContext, kkkkkkkkkkkkkkk);
            }
            if (generatedAppGlideModule != null) {
                generatedAppGlideModule.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(origApplicationContext, kkkkkkkkkkkkkkk);
            }
            if (kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Oooooooooo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            if (kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Oooooooooo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            if (kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwww == null) {
                int i = Oooooooooo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() >= 4 ? 2 : 1;
                Oooooooooo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Oooooooooo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (!TextUtils.isEmpty("animation")) {
                    kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwww = new Oooooooooo(new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new Oooooooooo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("animation", wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, true)));
                } else {
                    throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Name must be non-null and non-empty, but given: ", "animation"));
                }
            }
            if (kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwww = new C1887Ss(new C1887Ss.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(origApplicationContext));
            }
            if (kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwww == null) {
                kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwww = new C2580s();
            }
            if (kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                int i2 = kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (i2 > 0) {
                    kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new QQOOOO(i2);
                } else {
                    kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new QQOOOOOOOOO();
                }
            }
            if (kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new QQOOOOO(kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            if (kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Ssss(kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            if (kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwww = new Sssss(origApplicationContext);
            }
            if (kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new IIl(kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwww, kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, new Oooooooooo(new ThreadPoolExecutor(0, Integer.MAX_VALUE, Oooooooooo.Wwwwwwwwwwwwwwwwwwwwwww, TimeUnit.MILLISECONDS, new SynchronousQueue(), new Oooooooooo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("source-unlimited", Oooooooooo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, false))), kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwww, false);
            }
            List<AbstractC2507q0<Object>> list2 = kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwww;
            kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwww = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
            Kkkkkkkkkkkkkkkk kkkkkkkkkkkkkkkk = new Kkkkkkkkkkkkkkkk(origApplicationContext, kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, new C2806y(kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwww), kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwww, kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwww, kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwww, kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, kkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwww, false, false);
            for (AbstractC2057e0 abstractC2057e04 : list) {
                try {
                    abstractC2057e04.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(origApplicationContext, kkkkkkkkkkkkkkkk, kkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwww);
                } catch (AbstractMethodError e2) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(abstractC2057e04.getClass().getName());
                    throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString(), e2);
                }
            }
            if (generatedAppGlideModule != null) {
                generatedAppGlideModule.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(origApplicationContext, kkkkkkkkkkkkkkkk, kkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwww);
            }
            origApplicationContext.registerComponentCallbacks(kkkkkkkkkkkkkkkk);
            Wwwwwwwwwwwwwwww = kkkkkkkkkkkkkkkk;
            Wwwwwwwwwwwwwww = false;
            return;
        }
        throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Kkkkkkkkkkkk kkkkkkkkkkkk) {
        synchronized (this.Wwwwwwwwwwwwwwwww) {
            if (!this.Wwwwwwwwwwwwwwwww.contains(kkkkkkkkkkkk)) {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
            this.Wwwwwwwwwwwwwwwww.remove(kkkkkkkkkkkk);
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Kkkkkkkkkkkk kkkkkkkkkkkk) {
        synchronized (this.Wwwwwwwwwwwwwwwww) {
            if (this.Wwwwwwwwwwwwwwwww.contains(kkkkkkkkkkkk)) {
                throw new IllegalStateException("Cannot register already registered manager");
            }
            this.Wwwwwwwwwwwwwwwww.add(kkkkkkkkkkkk);
        }
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull AbstractC1930b1<?> abstractC1930b1) {
        synchronized (this.Wwwwwwwwwwwwwwwww) {
            for (Kkkkkkkkkkkk kkkkkkkkkkkk : this.Wwwwwwwwwwwwwwwww) {
                if (kkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1930b1)) {
                    return true;
                }
            }
            return false;
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        ((C2465p1) this.Wwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0L);
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        for (Kkkkkkkkkkkk kkkkkkkkkkkk : this.Wwwwwwwwwwwwwwwww) {
            if (kkkkkkkkkkkk == null) {
                throw null;
            }
        }
        Ssss ssss = (Ssss) this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (ssss != null) {
            if (i >= 40) {
                ssss.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0L);
            } else if (i >= 20 || i == 15) {
                ssss.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ssss.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() / 2);
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwww.trimMemory(i);
            this.Wwwwwwwwwwwwwwwwwwww.trimMemory(i);
            return;
        }
        throw null;
    }

    @NonNull
    public static Kkkkkkkkkkkkkkkk Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Context context) {
        if (Wwwwwwwwwwwwwwww == null) {
            GeneratedAppGlideModule generatedAppGlideModule = null;
            try {
                generatedAppGlideModule = (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(Context.class).newInstance(StubApp.getOrigApplicationContext(StubApp.getOrigApplicationContext(context.getApplicationContext()).getApplicationContext()));
            } catch (ClassNotFoundException unused) {
                Log.isLoggable("Glide", 5);
            } catch (IllegalAccessException e) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e);
                throw null;
            } catch (InstantiationException e2) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e2);
                throw null;
            } catch (NoSuchMethodException e3) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e3);
                throw null;
            } catch (InvocationTargetException e4) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e4);
                throw null;
            }
            synchronized (Kkkkkkkkkkkkkkkk.class) {
                if (Wwwwwwwwwwwwwwww == null) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, generatedAppGlideModule);
                }
            }
        }
        return Wwwwwwwwwwwwwwww;
    }
}
