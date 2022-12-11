package me.tvspark;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import me.tvspark.Kkkkkkkkkk;
import me.tvspark.Sssssssssss;

/* loaded from: classes4.dex */
public class Sssssss implements Sssssssssss {
    public Kkkkkkkkkk Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final File Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Sssssssss Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Sssssssss();
    public final Ooooooooooo Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Ooooooooooo();

    @Deprecated
    public Sssssss(File file, long j) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = file;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
    }

    @Override // me.tvspark.Sssssssssss
    public File Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Illlllllllllllllllllllllllll illlllllllllllllllllllllllll) {
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(illlllllllllllllllllllllllll);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            String str = "Get: Obtained: " + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + " for for Key: " + illlllllllllllllllllllllllll;
        }
        try {
            Kkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                return null;
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[0];
        } catch (IOException unused) {
            Log.isLoggable("DiskLruCacheWrapper", 5);
            return null;
        }
    }

    public final synchronized Kkkkkkkkkk Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws IOException {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Kkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 1, 1, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.Sssssssssss
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Illlllllllllllllllllllllllll illlllllllllllllllllllllllll, Sssssssssss.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        boolean z;
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(illlllllllllllllllllllllllll);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                String str = "Put: Obtained: " + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + " for for Key: " + illlllllllllllllllllllllllll;
            }
            try {
                Kkkkkkkkkk Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) == null) {
                    Kkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, -1L);
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == null) {
                        throw new IllegalStateException("Had two simultaneous puts for: " + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    }
                    try {
                        IIllllll iIllllll = (IIllllll) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (iIllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iIllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0), iIllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                            Kkkkkkkkkk.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, true);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                        }
                        if (!z) {
                            try {
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            } catch (IOException unused) {
                            }
                        }
                    } finally {
                        if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                            try {
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            } catch (IOException unused2) {
                            }
                        }
                    }
                }
            } catch (IOException unused3) {
                Log.isLoggable("DiskLruCacheWrapper", 5);
            }
        } finally {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }
}
