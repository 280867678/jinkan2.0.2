package me.tvspark;

import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.engine.DecodeJob;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.tvspark.IIl;
import me.tvspark.Llllll;

/* loaded from: classes4.dex */
public final class IIllll<Transcode> {
    public boolean Wwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwww;
    public IIll Wwwwwwwwwwwwwwwwwww;
    public Priority Wwwwwwwwwwwwwwwwwwww;
    public Illlllllllllllllllllllllllll Wwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwww;
    public Class<Transcode> Wwwwwwwwwwwwwwwwwwwwwwww;
    public Map<Class<?>, Illlllllllllllllllllll<?>> Wwwwwwwwwwwwwwwwwwwwwwwww;
    public Illllllllllllllllllllllll Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public DecodeJob.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Class<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Kkkkkkkkkkkkkk Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final List<Llllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
    public final List<Illlllllllllllllllllllllllll> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();

    public List<Llllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
            List Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            int size = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size();
            for (int i = 0; i < size; i++) {
                Llllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = ((Llllll) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i)).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwww);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                }
            }
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class<?> cls) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls) != null;
    }

    public <Z> Illlllllllllllllllllll<Z> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class<Z> cls) {
        Illlllllllllllllllllll<Z> illlllllllllllllllllll = (Illlllllllllllllllllll<Z>) this.Wwwwwwwwwwwwwwwwwwwwwwwww.get(cls);
        if (illlllllllllllllllllll == null) {
            Iterator<Map.Entry<Class<?>, Illlllllllllllllllllll<?>>> it = this.Wwwwwwwwwwwwwwwwwwwwwwwww.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Class<?>, Illlllllllllllllllllll<?>> next = it.next();
                if (next.getKey().isAssignableFrom(cls)) {
                    illlllllllllllllllllll = (Illlllllllllllllllllll<Z>) next.getValue();
                    break;
                }
            }
        }
        if (illlllllllllllllllllll == null) {
            if (!this.Wwwwwwwwwwwwwwwwwwwwwwwww.isEmpty() || !this.Wwwwwwwwwwwwwwwwww) {
                return (Xxxxxxxxx) Xxxxxxxxx.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
        }
        return illlllllllllllllllllll;
    }

    public Sssssssssss Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return ((IIl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this.Wwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public List<Illlllllllllllllllllllllllll> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (!this.Wwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
            List<Llllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            int size = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size();
            for (int i = 0; i < size; i++) {
                Llllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i);
                if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.contains(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
                for (int i2 = 0; i2 < wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size(); i2++) {
                    if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.contains(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i2))) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i2));
                    }
                }
            }
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public <Data> O000<Data, ?, Transcode> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class<Data> cls) {
        Registry registry = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Class<?> cls2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Class<Transcode> cls3 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        O000<?, ?, ?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = registry.Wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls, cls2, cls3);
        if (registry.Wwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            if (C2279k0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                return null;
            }
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                ArrayList arrayList = new ArrayList();
                Iterator it = ((ArrayList) registry.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls, cls2)).iterator();
                while (it.hasNext()) {
                    Class cls4 = (Class) it.next();
                    Iterator it2 = ((ArrayList) registry.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls4, cls3)).iterator();
                    while (it2.hasNext()) {
                        Class cls5 = (Class) it2.next();
                        arrayList.add(new IIlll(cls, cls4, cls5, registry.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls, cls4), registry.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls4, cls5), registry.Wwwwwwwwwwwwwwwwwwwwwwwww));
                    }
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = arrayList.isEmpty() ? null : new O000<>(cls, cls2, cls3, arrayList, registry.Wwwwwwwwwwwwwwwwwwwwwwwww);
                registry.Wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls, cls2, cls3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        throw null;
    }
}
