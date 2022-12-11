package me.tvspark;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import me.tvspark.Illlllllllllllllll;

/* loaded from: classes4.dex */
public class Illlllllllll implements Illlllllllllllllll<InputStream> {
    @VisibleForTesting
    public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public volatile boolean Wwwwwwwwwwwwwwwwwww;
    public InputStream Wwwwwwwwwwwwwwwwwwww;
    public HttpURLConnection Wwwwwwwwwwwwwwwwwwwww;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwww;
    public final Ooo Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    public Illlllllllll(Ooo ooo, int i) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = ooo;
        this.Wwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.Illlllllllllllllll
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        InputStream inputStream = this.Wwwwwwwwwwwwwwwwwwww;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.Wwwwwwwwwwwwwwwwwwwww;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.Wwwwwwwwwwwwwwwwwwwww = null;
    }

    @Override // me.tvspark.Illlllllllllllllll
    @NonNull
    public Class<InputStream> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return InputStream.class;
    }

    @Override // me.tvspark.Illlllllllllllllll
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Priority priority, @NonNull Illlllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<? super InputStream> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2428o1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        try {
            try {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Illlllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<? super InputStream>) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), 0, null, this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getHeaders()));
                if (!Log.isLoggable("HttpUrlFetcher", 2)) {
                    return;
                }
            } catch (IOException e) {
                Log.isLoggable("HttpUrlFetcher", 3);
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Exception) e);
                if (!Log.isLoggable("HttpUrlFetcher", 2)) {
                    return;
                }
            }
            C2428o1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                C2428o1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            }
            throw th;
        }
    }

    @Override // me.tvspark.Illlllllllllllllll
    public void cancel() {
        this.Wwwwwwwwwwwwwwwwwww = true;
    }

    @Override // me.tvspark.Illlllllllllllllll
    @NonNull
    public DataSource getDataSource() {
        return DataSource.REMOTE;
    }

    public final InputStream Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(URL url, int i, URL url2, Map<String, String> map) throws IOException {
        if (i < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new HttpException("In re-direct loop");
                    }
                } catch (URISyntaxException unused) {
                }
            }
            if (((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this.Wwwwwwwwwwwwwwwwwwwwww) != null) {
                this.Wwwwwwwwwwwwwwwwwwwww = (HttpURLConnection) url.openConnection();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    this.Wwwwwwwwwwwwwwwwwwwww.addRequestProperty(entry.getKey(), entry.getValue());
                }
                this.Wwwwwwwwwwwwwwwwwwwww.setConnectTimeout(this.Wwwwwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwwwwww.setReadTimeout(this.Wwwwwwwwwwwwwwwwwwwwwww);
                boolean z = false;
                this.Wwwwwwwwwwwwwwwwwwwww.setUseCaches(false);
                this.Wwwwwwwwwwwwwwwwwwwww.setDoInput(true);
                this.Wwwwwwwwwwwwwwwwwwwww.setInstanceFollowRedirects(false);
                this.Wwwwwwwwwwwwwwwwwwwww.connect();
                this.Wwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwww.getInputStream();
                if (this.Wwwwwwwwwwwwwwwwwww) {
                    return null;
                }
                int responseCode = this.Wwwwwwwwwwwwwwwwwwwww.getResponseCode();
                int i2 = responseCode / 100;
                if (i2 == 2) {
                    HttpURLConnection httpURLConnection = this.Wwwwwwwwwwwwwwwwwwwww;
                    if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
                        this.Wwwwwwwwwwwwwwwwwwww = new C2317l1(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
                    } else {
                        if (Log.isLoggable("HttpUrlFetcher", 3)) {
                            httpURLConnection.getContentEncoding();
                        }
                        this.Wwwwwwwwwwwwwwwwwwww = httpURLConnection.getInputStream();
                    }
                    return this.Wwwwwwwwwwwwwwwwwwww;
                }
                if (i2 == 3) {
                    z = true;
                }
                if (!z) {
                    if (responseCode != -1) {
                        throw new HttpException(this.Wwwwwwwwwwwwwwwwwwwww.getResponseMessage(), responseCode);
                    }
                    throw new HttpException(responseCode);
                }
                String headerField = this.Wwwwwwwwwwwwwwwwwwwww.getHeaderField("Location");
                if (TextUtils.isEmpty(headerField)) {
                    throw new HttpException("Received empty or null redirect url");
                }
                URL url3 = new URL(url, headerField);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(url3, i + 1, url, map);
            }
            throw null;
        }
        throw new HttpException("Too many (> 5) redirects!");
    }
}
