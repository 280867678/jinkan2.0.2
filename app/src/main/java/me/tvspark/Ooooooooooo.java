package me.tvspark;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import me.tvspark.AbstractC2734w1;
import me.tvspark.C2619t1;
import org.litepal.util.cipher.AESCrypt;

/* loaded from: classes4.dex */
public class Ooooooooooo {
    public final C2465p1<Illlllllllllllllllllllllllll, String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2465p1<>(1000);
    public final Pools.Pool<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2619t1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(10, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this));

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements C2619t1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final AbstractC2734w1 Wwwwwwwwwwwwwwwwwwwwwww = new AbstractC2734w1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        public final MessageDigest Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MessageDigest messageDigest) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = messageDigest;
        }

        @Override // me.tvspark.C2619t1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        @NonNull
        public AbstractC2734w1 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return this.Wwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements C2619t1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Ooooooooooo ooooooooooo) {
        }

        @Override // me.tvspark.C2619t1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww create() {
            try {
                return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MessageDigest.getInstance(AESCrypt.HASH_ALGORITHM));
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Illlllllllllllllllllllllllll illlllllllllllllllllllllllll) {
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((C2465p1<Illlllllllllllllllllllllllll, String>) illlllllllllllllllllllllllll);
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww acquire = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.acquire();
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(acquire, "Argument must not be null");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = acquire;
            try {
                illlllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.digest());
            } finally {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.release(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }
        synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(illlllllllllllllllllllllllll, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
    }
}
