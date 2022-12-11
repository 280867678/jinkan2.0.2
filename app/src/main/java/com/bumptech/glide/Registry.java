package com.bumptech.glide;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import me.tvspark.C2205i0;
import me.tvspark.C2242j0;
import me.tvspark.C2279k0;
import me.tvspark.C2315l;
import me.tvspark.C2316l0;
import me.tvspark.C2353m0;
import me.tvspark.C2390n0;
import me.tvspark.C2619t1;
import me.tvspark.Illlllllllllllll;
import me.tvspark.Llll;
import me.tvspark.Llllll;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class Registry {
    public final Pools.Pool<List<Throwable>> Wwwwwwwwwwwwwwwwwwwwwwwww;
    public final Llll Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2316l0 Wwwwwwwwwwwwwwwwwwwwwwwwwww = new C2316l0();
    public final C2279k0 Wwwwwwwwwwwwwwwwwwwwwwwwww = new C2279k0();
    public final C2205i0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2205i0();
    public final C2353m0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2353m0();
    public final C2390n0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2390n0();
    public final Illlllllllllllll Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Illlllllllllllll();
    public final C2315l Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2315l();
    public final C2242j0 Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2242j0();

    /* loaded from: classes3.dex */
    public static class MissingComponentException extends RuntimeException {
        public MissingComponentException(@NonNull String str) {
            super(str);
        }
    }

    /* loaded from: classes3.dex */
    public static final class NoImageHeaderParserException extends MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }

    /* loaded from: classes3.dex */
    public static class NoModelLoaderAvailableException extends MissingComponentException {
        public NoModelLoaderAvailableException(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public NoModelLoaderAvailableException(@NonNull Object obj) {
            super(r0.toString());
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Failed to find any ModelLoaders registered for model class: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(obj.getClass());
        }

        public <M> NoModelLoaderAvailableException(@NonNull M m, @NonNull List<Llllll<M, ?>> list) {
            super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + m);
        }
    }

    /* loaded from: classes3.dex */
    public static class NoResultEncoderAvailableException extends MissingComponentException {
        public NoResultEncoderAvailableException(@NonNull Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    /* loaded from: classes3.dex */
    public static class NoSourceEncoderAvailableException extends MissingComponentException {
        public NoSourceEncoderAvailableException(@NonNull Class<?> cls) {
            super(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Failed to find source encoder for data class: ", (Class) cls));
        }
    }

    public Registry() {
        Pools.Pool<List<Throwable>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2619t1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Llll(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        List asList = Arrays.asList("Gif", "Bitmap", "BitmapDrawable");
        ArrayList arrayList = new ArrayList(asList.size());
        arrayList.addAll(asList);
        arrayList.add(0, "legacy_prepend_all");
        arrayList.add("legacy_append");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(arrayList);
    }

    @NonNull
    public List<ImageHeaderParser> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        List<ImageHeaderParser> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        throw new NoImageHeaderParserException();
    }

    @NonNull
    public <Model> List<Llllll<Model, ?>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Model model) {
        Llll llll = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (llll != null) {
            List Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = llll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(model.getClass());
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
                throw new NoModelLoaderAvailableException(model);
            }
            int size = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size();
            List<Llllll<Model, ?>> emptyList = Collections.emptyList();
            boolean z = true;
            for (int i = 0; i < size; i++) {
                Llllll<Model, ?> llllll = (Llllll) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i);
                if (llllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(model)) {
                    if (z) {
                        emptyList = new ArrayList<>(size - i);
                        z = false;
                    }
                    emptyList.add(llllll);
                }
            }
            if (emptyList.isEmpty()) {
                throw new NoModelLoaderAvailableException(model, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            return emptyList;
        }
        throw null;
    }
}
