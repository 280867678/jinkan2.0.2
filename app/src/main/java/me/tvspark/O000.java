package me.tvspark;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.load.engine.GlideException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import me.tvspark.IIlll;

/* loaded from: classes4.dex */
public class O000<Data, ResourceType, Transcode> {
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final List<? extends IIlll<Data, ResourceType, Transcode>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Pools.Pool<List<Throwable>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public O000(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<IIlll<Data, ResourceType, Transcode>> list, Pools.Pool<List<Throwable>> pool) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = pool;
        if (!list.isEmpty()) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = list;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Failed LoadPath{");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(cls.getSimpleName());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("->");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(cls2.getSimpleName());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("->");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(cls3.getSimpleName());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("}");
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            return;
        }
        throw new IllegalArgumentException("Must not be empty.");
    }

    public AbstractC1886O0<Transcode> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Illllllllllllllll<Data> illllllllllllllll, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll, int i, int i2, IIlll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<ResourceType> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) throws GlideException {
        List<Throwable> acquire = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.acquire();
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(acquire, "Argument must not be null");
        List<Throwable> list = acquire;
        try {
            int size = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size();
            AbstractC1886O0<Transcode> abstractC1886O0 = null;
            for (int i3 = 0; i3 < size; i3++) {
                try {
                    abstractC1886O0 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i3).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(illllllllllllllll, i, i2, illllllllllllllllllllllll, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                } catch (GlideException e) {
                    list.add(e);
                }
                if (abstractC1886O0 != null) {
                    break;
                }
            }
            if (abstractC1886O0 != null) {
                return abstractC1886O0;
            }
            throw new GlideException(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, new ArrayList(list));
        } finally {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.release(list);
        }
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("LoadPath{decodePaths=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Arrays.toString(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toArray()));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append('}');
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
