package me.tvspark;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;

/* loaded from: classes4.dex */
public class Ooo implements Illlllllllllllllllllllllllll {
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public volatile byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public URL Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final URL Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Llllllllllll Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public Ooo(String str, Llllllllllll llllllllllll) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        if (!TextUtils.isEmpty(str)) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(llllllllllll, "Argument must not be null");
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = llllllllllll;
            return;
        }
        throw new IllegalArgumentException("Must not be null or empty");
    }

    public URL Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws MalformedURLException {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            if (TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                String str = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (TextUtils.isEmpty(str)) {
                    URL url = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(url, "Argument must not be null");
                    str = url.toString();
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Uri.encode(str, "@#&=*+-_.,:!?()/~'%;$");
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new URL(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        String str = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (str != null) {
            return str;
        }
        URL url = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(url, "Argument must not be null");
        return url.toString();
    }

    @Override // me.tvspark.Illlllllllllllllllllllllllll
    public boolean equals(Object obj) {
        if (obj instanceof Ooo) {
            Ooo ooo = (Ooo) obj;
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().equals(ooo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(ooo.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        return false;
    }

    @Override // me.tvspark.Illlllllllllllllllllllllllll
    public int hashCode() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwww == 0) {
            int hashCode = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().hashCode();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = hashCode;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode() + (hashCode * 31);
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public String toString() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.Illlllllllllllllllllllllllll
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull MessageDigest messageDigest) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().getBytes(Illlllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        messageDigest.update(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public Ooo(URL url) {
        Llllllllllll llllllllllll = Llllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(url, "Argument must not be null");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = url;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(llllllllllll, "Argument must not be null");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = llllllllllll;
    }
}
