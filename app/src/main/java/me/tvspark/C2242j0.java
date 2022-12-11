package me.tvspark;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;

/* renamed from: me.tvspark.j0 */
/* loaded from: classes4.dex */
public final class C2242j0 {
    public final List<ImageHeaderParser> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();

    @NonNull
    public synchronized List<ImageHeaderParser> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull ImageHeaderParser imageHeaderParser) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(imageHeaderParser);
    }
}
