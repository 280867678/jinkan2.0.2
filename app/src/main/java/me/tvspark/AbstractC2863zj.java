package me.tvspark;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* renamed from: me.tvspark.zj */
/* loaded from: classes4.dex */
public interface AbstractC2863zj extends AbstractC2752wj {

    /* renamed from: me.tvspark.zj$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
        AbstractC2863zj mo4450Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    Map<String, List<String>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1949bk c1949bk) throws IOException;

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2410nk abstractC2410nk);

    void close() throws IOException;

    @Nullable
    Uri getUri();
}
