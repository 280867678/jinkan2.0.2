package me.tvspark;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.UnrecognizedInputFormatException;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* renamed from: me.tvspark.ke */
/* loaded from: classes4.dex */
public final class C2293ke {
    @Nullable
    public AbstractC2212i7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public AbstractC2175h7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC2323l7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2293ke(AbstractC2323l7 abstractC2323l7) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2323l7;
    }

    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        AbstractC2212i7 abstractC2212i7 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (abstractC2212i7 != null) {
            return abstractC2212i7.getPosition();
        }
        return -1L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x004b, code lost:
        if (r6.getPosition() != r11) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0071, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x006e, code lost:
        if (r6.getPosition() != r11) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2752wj abstractC2752wj, Uri uri, Map<String, List<String>> map, long j, long j2, AbstractC2249j7 abstractC2249j7) throws IOException {
        C2064e7 c2064e7 = new C2064e7(abstractC2752wj, j, j2);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2064e7;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            return;
        }
        AbstractC2175h7[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uri, map);
        boolean z = false;
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length == 1) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[0];
        } else {
            int length = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                AbstractC2175h7 abstractC2175h7 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i];
                try {
                } catch (EOFException unused) {
                    if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                    }
                } catch (Throwable th) {
                    if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null || c2064e7.getPosition() == j) {
                        z = true;
                    }
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
                    c2064e7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw th;
                }
                if (abstractC2175h7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2064e7)) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2175h7;
                    if (abstractC2175h7 != null || c2064e7.getPosition() == j) {
                        z = true;
                    }
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
                    c2064e7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                } else {
                    if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                    }
                    boolean z2 = true;
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z2);
                    c2064e7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    i++;
                }
            }
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                StringBuilder sb = new StringBuilder(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 58));
                sb.append("None of the available extractors (");
                sb.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                sb.append(") could read the stream.");
                String sb2 = sb.toString();
                if (uri == null) {
                    throw null;
                }
                throw new UnrecognizedInputFormatException(sb2, uri);
            }
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2249j7);
    }
}
