package me.tvspark;

import androidx.annotation.NonNull;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.DataSource;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import me.tvspark.IIlllll;
import me.tvspark.Illlllllllllllllll;
import me.tvspark.Llllll;

/* loaded from: classes4.dex */
public class OO000000000 implements IIlllll, Illlllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Object> {
    public OO00000000 Wwwwwwwwwwwwwww;
    public File Wwwwwwwwwwwwwwww;
    public volatile Llllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?> Wwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwww;
    public List<Llllll<File, ?>> Wwwwwwwwwwwwwwwwwww;
    public Illlllllllllllllllllllllllll Wwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwww = -1;
    public int Wwwwwwwwwwwwwwwwwwwwww;
    public final IIllll<?> Wwwwwwwwwwwwwwwwwwwwwww;
    public final IIlllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwww;

    public OO000000000(IIllll<?> iIllll, IIlllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = iIllll;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.Illlllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Exception exc) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwww, exc, this.Wwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, DataSource.RESOURCE_DISK_CACHE);
    }

    @Override // me.tvspark.Illlllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwww, obj, this.Wwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, DataSource.RESOURCE_DISK_CACHE, this.Wwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.IIlllll
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        List<Illlllllllllllllllllllllllll> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
            return false;
        }
        IIllll<?> iIllll = this.Wwwwwwwwwwwwwwwwwwwwwww;
        Registry registry = iIllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Class<?> cls = iIllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getClass();
        Class<?> cls2 = iIllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Class<?> cls3 = iIllll.Wwwwwwwwwwwwwwwwwwwwwwww;
        List<Class<?>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = registry.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls, cls2, cls3);
        ArrayList arrayList = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null) {
            ArrayList arrayList2 = new ArrayList();
            for (Class<?> cls4 : registry.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls)) {
                Iterator it = ((ArrayList) registry.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls4, cls2)).iterator();
                while (it.hasNext()) {
                    Class cls5 = (Class) it.next();
                    if (!((ArrayList) registry.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls5, cls3)).isEmpty() && !arrayList2.contains(cls5)) {
                        arrayList2.add(cls5);
                    }
                }
            }
            registry.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls, cls2, cls3, Collections.unmodifiableList(arrayList2));
            arrayList = arrayList2;
        }
        if (arrayList.isEmpty()) {
            if (File.class.equals(this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww)) {
                return false;
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Failed to find any load path from ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getClass());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(" to ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww);
            throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
        }
        while (true) {
            List<Llllll<File, ?>> list = this.Wwwwwwwwwwwwwwwwwww;
            if (list != null) {
                if (this.Wwwwwwwwwwwwwwwwww < list.size()) {
                    this.Wwwwwwwwwwwwwwwww = null;
                    boolean z = false;
                    while (!z) {
                        if (!(this.Wwwwwwwwwwwwwwwwww < this.Wwwwwwwwwwwwwwwwwww.size())) {
                            break;
                        }
                        List<Llllll<File, ?>> list2 = this.Wwwwwwwwwwwwwwwwwww;
                        int i = this.Wwwwwwwwwwwwwwwwww;
                        this.Wwwwwwwwwwwwwwwwww = i + 1;
                        File file = this.Wwwwwwwwwwwwwwww;
                        IIllll<?> iIllll2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
                        this.Wwwwwwwwwwwwwwwww = list2.get(i).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(file, iIllll2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, iIllll2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, iIllll2.Wwwwwwwwwwwwwwwwwwwwwwwwww);
                        if (this.Wwwwwwwwwwwwwwwww != null && this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww())) {
                            this.Wwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww, this);
                            z = true;
                        }
                    }
                    return z;
                }
            }
            int i2 = this.Wwwwwwwwwwwwwwwwwwwww + 1;
            this.Wwwwwwwwwwwwwwwwwwwww = i2;
            if (i2 >= arrayList.size()) {
                int i3 = this.Wwwwwwwwwwwwwwwwwwwwww + 1;
                this.Wwwwwwwwwwwwwwwwwwwwww = i3;
                if (i3 >= Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size()) {
                    return false;
                }
                this.Wwwwwwwwwwwwwwwwwwwww = 0;
            }
            Illlllllllllllllllllllllllll illlllllllllllllllllllllllll = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(this.Wwwwwwwwwwwwwwwwwwwwww);
            Class<?> cls6 = arrayList.get(this.Wwwwwwwwwwwwwwwwwwwww);
            Illlllllllllllllllllll<Z> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls6);
            IIllll<?> iIllll3 = this.Wwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwww = new OO00000000(iIllll3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, illlllllllllllllllllllllllll, iIllll3.Wwwwwwwwwwwwwwwwwwwww, iIllll3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, iIllll3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, cls6, iIllll3.Wwwwwwwwwwwwwwwwwwwwwwwwww);
            File Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 != null) {
                this.Wwwwwwwwwwwwwwwwwwww = illlllllllllllllllllllllllll;
                this.Wwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
                this.Wwwwwwwwwwwwwwwwww = 0;
            }
        }
    }

    @Override // me.tvspark.IIlllll
    public void cancel() {
        Llllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.cancel();
        }
    }
}
