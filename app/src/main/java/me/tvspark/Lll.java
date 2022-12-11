package me.tvspark;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import me.tvspark.Illlllllllllllllll;
import me.tvspark.Llllll;

/* loaded from: classes4.dex */
public class Lll<Model, Data> implements Llllll<Model, Data> {
    public final Pools.Pool<List<Throwable>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final List<Llllll<Model, Data>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Data> implements Illlllllllllllllll<Data>, Illlllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Data> {
        public boolean Wwwwwwwwwwwwwwwwww;
        @Nullable
        public List<Throwable> Wwwwwwwwwwwwwwwwwww;
        public Illlllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<? super Data> Wwwwwwwwwwwwwwwwwwww;
        public Priority Wwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwww;
        public final Pools.Pool<List<Throwable>> Wwwwwwwwwwwwwwwwwwwwwww;
        public final List<Illlllllllllllllll<Data>> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull List<Illlllllllllllllll<Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = pool;
            if (!list.isEmpty()) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = list;
                this.Wwwwwwwwwwwwwwwwwwwwww = 0;
                return;
            }
            throw new IllegalArgumentException("Must not be empty.");
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            if (this.Wwwwwwwwwwwwwwwwww) {
                return;
            }
            if (this.Wwwwwwwwwwwwwwwwwwwwww < this.Wwwwwwwwwwwwwwwwwwwwwwww.size() - 1) {
                this.Wwwwwwwwwwwwwwwwwwwwww++;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwww);
                return;
            }
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwww, "Argument must not be null");
            this.Wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Exception) new GlideException("Fetch failed", new ArrayList(this.Wwwwwwwwwwwwwwwwwww)));
        }

        @Override // me.tvspark.Illlllllllllllllll
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            List<Throwable> list = this.Wwwwwwwwwwwwwwwwwww;
            if (list != null) {
                this.Wwwwwwwwwwwwwwwwwwwwwww.release(list);
            }
            this.Wwwwwwwwwwwwwwwwwww = null;
            for (Illlllllllllllllll<Data> illlllllllllllllll : this.Wwwwwwwwwwwwwwwwwwwwwwww) {
                illlllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }

        @Override // me.tvspark.Illlllllllllllllll
        @NonNull
        public Class<Data> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.get(0).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        @Override // me.tvspark.Illlllllllllllllll
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Priority priority, @NonNull Illlllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<? super Data> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwww = priority;
            this.Wwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww.acquire();
            this.Wwwwwwwwwwwwwwwwwwwwwwww.get(this.Wwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(priority, this);
            if (this.Wwwwwwwwwwwwwwwwww) {
                cancel();
            }
        }

        @Override // me.tvspark.Illlllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Exception exc) {
            List<Throwable> list = this.Wwwwwwwwwwwwwwwwwww;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "Argument must not be null");
            list.add(exc);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        @Override // me.tvspark.Illlllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable Data data) {
            if (data != null) {
                this.Wwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Illlllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<? super Data>) data);
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }

        @Override // me.tvspark.Illlllllllllllllll
        public void cancel() {
            this.Wwwwwwwwwwwwwwwwww = true;
            for (Illlllllllllllllll<Data> illlllllllllllllll : this.Wwwwwwwwwwwwwwwwwwwwwwww) {
                illlllllllllllllll.cancel();
            }
        }

        @Override // me.tvspark.Illlllllllllllllll
        @NonNull
        public DataSource getDataSource() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.get(0).getDataSource();
        }
    }

    public Lll(@NonNull List<Llllll<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = list;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = pool;
    }

    @Override // me.tvspark.Llllll
    public Llllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Data> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Model model, int i, int i2, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) {
        Llllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Data> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        int size = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size();
        ArrayList arrayList = new ArrayList(size);
        Illlllllllllllllllllllllllll illlllllllllllllllllllllllll = null;
        for (int i3 = 0; i3 < size; i3++) {
            Llllll<Model, Data> llllll = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i3);
            if (llllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(model) && (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = llllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(model, i, i2, illllllllllllllllllllllll)) != null) {
                illlllllllllllllllllllllllll = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                arrayList.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }
        if (arrayList.isEmpty() || illlllllllllllllllllllllllll == null) {
            return null;
        }
        return new Llllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(illlllllllllllllllllllllllll, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(arrayList, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
    }

    @Override // me.tvspark.Llllll
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Model model) {
        for (Llllll<Model, Data> llllll : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (llllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(model)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("MultiModelLoader{modelLoaders=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(Arrays.toString(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toArray()));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append('}');
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
    }
}
