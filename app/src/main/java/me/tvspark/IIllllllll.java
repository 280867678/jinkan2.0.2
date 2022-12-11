package me.tvspark;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import java.io.File;
import java.util.List;
import me.tvspark.IIlllll;
import me.tvspark.Illlllllllllllllll;
import me.tvspark.Llllll;

/* loaded from: classes4.dex */
public class IIllllllll implements IIlllll, Illlllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Object> {
    public File Wwwwwwwwwwwwwwww;
    public volatile Llllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<?> Wwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwww;
    public List<Llllll<File, ?>> Wwwwwwwwwwwwwwwwwww;
    public Illlllllllllllllllllllllllll Wwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwww = -1;
    public final IIlllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwww;
    public final IIllll<?> Wwwwwwwwwwwwwwwwwwwwwww;
    public final List<Illlllllllllllllllllllllllll> Wwwwwwwwwwwwwwwwwwwwwwww;

    public IIllllllll(List<Illlllllllllllllllllllllllll> list, IIllll<?> iIllll, IIlllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = list;
        this.Wwwwwwwwwwwwwwwwwwwwwww = iIllll;
        this.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public IIllllllll(IIllll<?> iIllll, IIlllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        List<Illlllllllllllllllllllllllll> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iIllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwww = iIllll;
        this.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.Illlllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Exception exc) {
        this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwww, exc, this.Wwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, DataSource.DATA_DISK_CACHE);
    }

    @Override // me.tvspark.Illlllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
        this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwww, obj, this.Wwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, DataSource.DATA_DISK_CACHE, this.Wwwwwwwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.IIlllll
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
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
                        IIllll<?> iIllll = this.Wwwwwwwwwwwwwwwwwwwwwww;
                        this.Wwwwwwwwwwwwwwwww = list2.get(i).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(file, iIllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, iIllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, iIllll.Wwwwwwwwwwwwwwwwwwwwwwwwww);
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
            if (i2 >= this.Wwwwwwwwwwwwwwwwwwwwwwww.size()) {
                return false;
            }
            Illlllllllllllllllllllllllll illlllllllllllllllllllllllll = this.Wwwwwwwwwwwwwwwwwwwwwwww.get(this.Wwwwwwwwwwwwwwwwwwwww);
            File Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new IIlllllll(illlllllllllllllllllllllllll, this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww));
            this.Wwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                this.Wwwwwwwwwwwwwwwwwwww = illlllllllllllllllllllllllll;
                this.Wwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
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
