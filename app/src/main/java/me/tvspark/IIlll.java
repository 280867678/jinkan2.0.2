package me.tvspark;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.GlideException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.Llllll;

/* loaded from: classes4.dex */
public class IIlll<DataType, ResourceType, Transcode> {
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Pools.Pool<List<Throwable>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC2278k<ResourceType, Transcode> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final List<? extends Illlllllllllllllllllllll<DataType, ResourceType>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Class<DataType> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<ResourceType> {
    }

    public IIlll(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends Illlllllllllllllllllllll<DataType, ResourceType>> list, AbstractC2278k<ResourceType, Transcode> abstractC2278k, Pools.Pool<List<Throwable>> pool) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = cls;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = list;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2278k;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = pool;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Failed DecodePath{");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(cls.getSimpleName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append("->");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(cls2.getSimpleName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append("->");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(cls3.getSimpleName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append("}");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
    }

    @NonNull
    public final AbstractC1886O0<ResourceType> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Illllllllllllllll<DataType> illllllllllllllll, int i, int i2, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll, List<Throwable> list) throws GlideException {
        int size = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size();
        AbstractC1886O0<ResourceType> abstractC1886O0 = null;
        for (int i3 = 0; i3 < size; i3++) {
            Illlllllllllllllllllllll<DataType, ResourceType> illlllllllllllllllllllll = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i3);
            try {
                if (illlllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(illllllllllllllll.mo4924Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), illllllllllllllllllllllll)) {
                    abstractC1886O0 = illlllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(illllllllllllllll.mo4924Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), i, i2, illllllllllllllllllllllll);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e) {
                if (Log.isLoggable("DecodePath", 2)) {
                    String str = "Failed to decode data for " + illlllllllllllllllllllll;
                }
                list.add(e);
            }
            if (abstractC1886O0 != null) {
                break;
            }
        }
        if (abstractC1886O0 != null) {
            return abstractC1886O0;
        }
        throw new GlideException(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, new ArrayList(list));
    }

    public AbstractC1886O0<Transcode> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Illllllllllllllll<DataType> illllllllllllllll, int i, int i2, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<ResourceType> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) throws GlideException {
        AbstractC1886O0<ResourceType> abstractC1886O0;
        Illlllllllllllllllllll illlllllllllllllllllll;
        EncodeStrategy encodeStrategy;
        Illlllllllllllllllllllllllll iIlllllll;
        List<Throwable> acquire = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.acquire();
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(acquire, "Argument must not be null");
        List<Throwable> list = acquire;
        try {
            AbstractC1886O0<ResourceType> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(illllllllllllllll, i, i2, illllllllllllllllllllllll, list);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.release(list);
            DecodeJob.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (DecodeJob.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            DecodeJob decodeJob = DecodeJob.this;
            DataSource dataSource = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            Illllllllllllllllllllll illllllllllllllllllllll = null;
            if (decodeJob != null) {
                Class<?> cls = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.get().getClass();
                if (dataSource != DataSource.RESOURCE_DISK_CACHE) {
                    Illlllllllllllllllllll Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = decodeJob.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls);
                    illlllllllllllllllllll = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    abstractC1886O0 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(decodeJob.Wwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, decodeJob.Wwwwwwwwwwwww, decodeJob.Wwwwwwwwwwww);
                } else {
                    abstractC1886O0 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                    illlllllllllllllllllll = null;
                }
                if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.equals(abstractC1886O0)) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.recycle();
                }
                boolean z = false;
                if (decodeJob.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1886O0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) != null) {
                    Illllllllllllllllllllll Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = decodeJob.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1886O0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != null) {
                        encodeStrategy = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(decodeJob.Wwwwwwwwww);
                        illllllllllllllllllllll = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                    } else {
                        throw new Registry.NoResultEncoderAvailableException(abstractC1886O0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                    }
                } else {
                    encodeStrategy = EncodeStrategy.NONE;
                }
                IIllll<R> iIllll = decodeJob.Wwwwwwwwwwwwwwwwwwwwwwww;
                Illlllllllllllllllllllllllll illlllllllllllllllllllllllll = decodeJob.Kkkkkkkkkkkkkkkkkkkkkkkkk;
                List<Llllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iIllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                int size = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        break;
                    } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i3).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(illlllllllllllllllllllllllll)) {
                        z = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                AbstractC1886O0<ResourceType> abstractC1886O02 = abstractC1886O0;
                if (decodeJob.Wwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!z, dataSource, encodeStrategy)) {
                    if (illllllllllllllllllllll != null) {
                        int ordinal = encodeStrategy.ordinal();
                        if (ordinal == 0) {
                            iIlllllll = new IIlllllll(decodeJob.Kkkkkkkkkkkkkkkkkkkkkkkkk, decodeJob.Wwwwwwwwwwwwwwww);
                        } else if (ordinal != 1) {
                            throw new IllegalArgumentException("Unknown strategy: " + encodeStrategy);
                        } else {
                            iIlllllll = new OO00000000(decodeJob.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, decodeJob.Kkkkkkkkkkkkkkkkkkkkkkkkk, decodeJob.Wwwwwwwwwwwwwwww, decodeJob.Wwwwwwwwwwwww, decodeJob.Wwwwwwwwwwww, illlllllllllllllllllll, cls, decodeJob.Wwwwwwwwww);
                        }
                        O00<Z> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = O00.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1886O0);
                        DecodeJob.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = decodeJob.Wwwwwwwwwwwwwwwwwww;
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iIlllllll;
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = illllllllllllllllllllll;
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
                        abstractC1886O02 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
                    } else {
                        throw new Registry.NoResultEncoderAvailableException(abstractC1886O0.get().getClass());
                    }
                }
                return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1886O02, illllllllllllllllllllllll);
            }
            throw null;
        } catch (Throwable th) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.release(list);
            throw th;
        }
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("DecodePath{ dataClass=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(", decoders=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(", transcoder=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append('}');
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
    }
}
