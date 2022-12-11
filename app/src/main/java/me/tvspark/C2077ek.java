package me.tvspark;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.AssetDataSource;
import com.google.android.exoplayer2.upstream.ContentDataSource;
import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.RawResourceDataSource;
import com.google.android.exoplayer2.upstream.UdpDataSource;
import com.stub.StubApp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: me.tvspark.ek */
/* loaded from: classes4.dex */
public final class C2077ek implements AbstractC2863zj {
    @Nullable
    public AbstractC2863zj Wwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public AbstractC2863zj Wwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public AbstractC2863zj Wwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public AbstractC2863zj Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public AbstractC2863zj Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public AbstractC2863zj Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public AbstractC2863zj Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public AbstractC2863zj Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC2863zj Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final List<AbstractC2410nk> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Context Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2077ek(Context context, AbstractC2863zj abstractC2863zj) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = StubApp.getOrigApplicationContext(context.getApplicationContext());
        if (abstractC2863zj != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2863zj;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
            return;
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2863zj
    public Map<String, List<String>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        AbstractC2863zj abstractC2863zj = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        return abstractC2863zj == null ? Collections.emptyMap() : abstractC2863zj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2863zj
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2410nk abstractC2410nk) {
        if (abstractC2410nk != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2410nk);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(abstractC2410nk);
            AbstractC2863zj abstractC2863zj = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (abstractC2863zj != null) {
                abstractC2863zj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2410nk);
            }
            AbstractC2863zj abstractC2863zj2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (abstractC2863zj2 != null) {
                abstractC2863zj2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2410nk);
            }
            AbstractC2863zj abstractC2863zj3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (abstractC2863zj3 != null) {
                abstractC2863zj3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2410nk);
            }
            AbstractC2863zj abstractC2863zj4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (abstractC2863zj4 != null) {
                abstractC2863zj4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2410nk);
            }
            AbstractC2863zj abstractC2863zj5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (abstractC2863zj5 != null) {
                abstractC2863zj5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2410nk);
            }
            AbstractC2863zj abstractC2863zj6 = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
            if (abstractC2863zj6 != null) {
                abstractC2863zj6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2410nk);
            }
            AbstractC2863zj abstractC2863zj7 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
            if (abstractC2863zj7 == null) {
                return;
            }
            abstractC2863zj7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2410nk);
            return;
        }
        throw null;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2863zj abstractC2863zj) {
        for (int i = 0; i < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size(); i++) {
            abstractC2863zj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i));
        }
    }

    @Override // me.tvspark.AbstractC2863zj
    public void close() throws IOException {
        AbstractC2863zj abstractC2863zj = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (abstractC2863zj != null) {
            try {
                abstractC2863zj.close();
            } finally {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = null;
            }
        }
    }

    @Override // me.tvspark.AbstractC2863zj
    @Nullable
    public Uri getUri() {
        AbstractC2863zj abstractC2863zj = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (abstractC2863zj == null) {
            return null;
        }
        return abstractC2863zj.getUri();
    }

    @Override // me.tvspark.AbstractC2752wj
    public int read(byte[] bArr, int i, int i2) throws IOException {
        AbstractC2863zj abstractC2863zj = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2863zj);
        return abstractC2863zj.read(bArr, i, i2);
    }

    @Override // me.tvspark.AbstractC2863zj
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1949bk c1949bk) throws IOException {
        AbstractC2863zj abstractC2863zj;
        AssetDataSource assetDataSource;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww == null);
        String scheme = c1949bk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getScheme();
        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c1949bk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
            String path = c1949bk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getPath();
            if (path != null && path.startsWith("/android_asset/")) {
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                    assetDataSource = new AssetDataSource(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = assetDataSource;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(assetDataSource);
                }
                abstractC2863zj = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwwwww = abstractC2863zj;
                return abstractC2863zj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c1949bk);
            }
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                FileDataSource fileDataSource = new FileDataSource();
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = fileDataSource;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fileDataSource);
            }
            abstractC2863zj = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwww = abstractC2863zj;
            return abstractC2863zj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c1949bk);
        } else if ("asset".equals(scheme)) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                assetDataSource = new AssetDataSource(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = assetDataSource;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(assetDataSource);
            }
            abstractC2863zj = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwww = abstractC2863zj;
            return abstractC2863zj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c1949bk);
        } else {
            if ("content".equals(scheme)) {
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                    ContentDataSource contentDataSource = new ContentDataSource(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = contentDataSource;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(contentDataSource);
                }
                abstractC2863zj = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            } else if ("rtmp".equals(scheme)) {
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                    try {
                        AbstractC2863zj abstractC2863zj2 = (AbstractC2863zj) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]);
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2863zj2;
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2863zj2);
                    } catch (ClassNotFoundException unused) {
                    } catch (Exception e) {
                        throw new RuntimeException("Error instantiating RTMP extension", e);
                    }
                    if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    }
                }
                abstractC2863zj = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            } else if ("udp".equals(scheme)) {
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                    UdpDataSource udpDataSource = new UdpDataSource();
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = udpDataSource;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(udpDataSource);
                }
                abstractC2863zj = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
            } else if ("data".equals(scheme)) {
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                    C2789xj c2789xj = new C2789xj();
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwww = c2789xj;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2789xj);
                }
                abstractC2863zj = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
            } else if ("rawresource".equals(scheme) || "android.resource".equals(scheme)) {
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwww == null) {
                    RawResourceDataSource rawResourceDataSource = new RawResourceDataSource(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    this.Wwwwwwwwwwwwwwwwwwwwwwwww = rawResourceDataSource;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(rawResourceDataSource);
                }
                abstractC2863zj = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
            } else {
                abstractC2863zj = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwww = abstractC2863zj;
            return abstractC2863zj.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c1949bk);
        }
    }
}
