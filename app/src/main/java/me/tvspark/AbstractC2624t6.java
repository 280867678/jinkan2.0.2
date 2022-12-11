package me.tvspark;

import android.media.DeniedByServerException;
import android.media.MediaCryptoException;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import me.tvspark.C2322l6;

/* renamed from: me.tvspark.t6 */
/* loaded from: classes4.dex */
public interface AbstractC2624t6 {

    /* renamed from: me.tvspark.t6$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, String str) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bArr;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
        }
    }

    /* renamed from: me.tvspark.t6$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        AbstractC2624t6 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(UUID uuid);
    }

    /* renamed from: me.tvspark.t6$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* renamed from: me.tvspark.t6$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, String str) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bArr;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
        }
    }

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr) throws DeniedByServerException;

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr);

    byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws MediaDrmException;

    AbstractC2587s6 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr) throws MediaCryptoException;

    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    @Nullable
    byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, byte[] bArr2) throws NotProvisionedException, DeniedByServerException;

    Class<? extends AbstractC2587s6> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    Map<String, String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr);

    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, @Nullable List<C2322l6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> list, int i, @Nullable HashMap<String, String> hashMap) throws NotProvisionedException;

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, byte[] bArr2);

    void release();
}
