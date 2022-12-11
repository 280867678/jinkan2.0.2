package okhttp3.internal.publicsuffix;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.TypeCastException;
import kotlin.collections.EmptyList;
import me.tvspark.ax0;
import me.tvspark.cx0;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.hx0;
import me.tvspark.ih0;
import me.tvspark.ii0;
import me.tvspark.nk0;
import me.tvspark.nx0;
import me.tvspark.outline;
import me.tvspark.r40;
import me.tvspark.wj0;
import me.tvspark.xf0;
import me.tvspark.xj0;
import me.tvspark.zj0;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;

@ef0
/* loaded from: classes4.dex */
public final class PublicSuffixDatabase {
    public static final char EXCEPTION_MARKER = '!';
    public static final String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.gz";
    public byte[] publicSuffixExceptionListBytes;
    public byte[] publicSuffixListBytes;
    public static final Companion Companion = new Companion(null);
    public static final byte[] WILDCARD_LABEL = {(byte) 42};
    public static final List<String> PREVAILING_RULE = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("*");
    public static final PublicSuffixDatabase instance = new PublicSuffixDatabase();
    public final AtomicBoolean listRead = new AtomicBoolean(false);
    public final CountDownLatch readCompleteLatch = new CountDownLatch(1);

    @ef0
    /* loaded from: classes4.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(gi0 gi0Var) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String binarySearch(byte[] bArr, byte[][] bArr2, int i) {
            int i2;
            boolean z;
            int and;
            int and2;
            int length = bArr.length;
            int i3 = 0;
            while (i3 < length) {
                int i4 = (i3 + length) / 2;
                while (i4 > -1 && bArr[i4] != ((byte) 10)) {
                    i4--;
                }
                int i5 = i4 + 1;
                int i6 = 1;
                while (true) {
                    i2 = i5 + i6;
                    if (bArr[i2] == ((byte) 10)) {
                        break;
                    }
                    i6++;
                }
                int i7 = i2 - i5;
                int i8 = i;
                boolean z2 = false;
                int i9 = 0;
                int i10 = 0;
                while (true) {
                    if (z2) {
                        and = 46;
                        z = false;
                    } else {
                        z = z2;
                        and = Util.and(bArr2[i8][i9], 255);
                    }
                    and2 = and - Util.and(bArr[i5 + i10], 255);
                    if (and2 != 0) {
                        break;
                    }
                    i10++;
                    i9++;
                    if (i10 == i7) {
                        break;
                    } else if (bArr2[i8].length != i9) {
                        z2 = z;
                    } else if (i8 == bArr2.length - 1) {
                        break;
                    } else {
                        i8++;
                        z2 = true;
                        i9 = -1;
                    }
                }
                if (and2 >= 0) {
                    if (and2 <= 0) {
                        int i11 = i7 - i10;
                        int length2 = bArr2[i8].length - i9;
                        int length3 = bArr2.length;
                        for (int i12 = i8 + 1; i12 < length3; i12++) {
                            length2 += bArr2[i12].length;
                        }
                        if (length2 >= i11) {
                            if (length2 <= i11) {
                                Charset charset = StandardCharsets.UTF_8;
                                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) charset, "UTF_8");
                                return new String(bArr, i5, i7, charset);
                            }
                        }
                    }
                    i3 = i2 + 1;
                }
                length = i5 - 1;
            }
            return null;
        }

        public final PublicSuffixDatabase get() {
            return PublicSuffixDatabase.instance;
        }
    }

    public static final /* synthetic */ byte[] access$getPublicSuffixListBytes$p(PublicSuffixDatabase publicSuffixDatabase) {
        byte[] bArr = publicSuffixDatabase.publicSuffixListBytes;
        if (bArr != null) {
            return bArr;
        }
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("publicSuffixListBytes");
        throw null;
    }

    private final List<String> findMatchingRule(List<String> list) {
        String str;
        String str2;
        String str3;
        List<String> list2;
        List<String> list3;
        if (this.listRead.get() || !this.listRead.compareAndSet(false, true)) {
            try {
                this.readCompleteLatch.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            readTheListUninterruptibly();
        }
        if (this.publicSuffixListBytes != null) {
            int size = list.size();
            byte[][] bArr = new byte[size];
            for (int i = 0; i < size; i++) {
                String str4 = list.get(i);
                Charset charset = StandardCharsets.UTF_8;
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) charset, "UTF_8");
                if (str4 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                byte[] bytes = str4.getBytes(charset);
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) bytes, "(this as java.lang.String).getBytes(charset)");
                bArr[i] = bytes;
            }
            int i2 = 0;
            while (true) {
                str = null;
                if (i2 >= size) {
                    str2 = null;
                    break;
                }
                Companion companion = Companion;
                byte[] bArr2 = this.publicSuffixListBytes;
                if (bArr2 == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("publicSuffixListBytes");
                    throw null;
                }
                str2 = companion.binarySearch(bArr2, bArr, i2);
                if (str2 != null) {
                    break;
                }
                i2++;
            }
            if (size > 1) {
                byte[][] bArr3 = (byte[][]) bArr.clone();
                int length = bArr3.length - 1;
                for (int i3 = 0; i3 < length; i3++) {
                    bArr3[i3] = WILDCARD_LABEL;
                    Companion companion2 = Companion;
                    byte[] bArr4 = this.publicSuffixListBytes;
                    if (bArr4 == null) {
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("publicSuffixListBytes");
                        throw null;
                    }
                    str3 = companion2.binarySearch(bArr4, bArr3, i3);
                    if (str3 != null) {
                        break;
                    }
                }
            }
            str3 = null;
            if (str3 != null) {
                int i4 = size - 1;
                int i5 = 0;
                while (true) {
                    if (i5 >= i4) {
                        break;
                    }
                    Companion companion3 = Companion;
                    byte[] bArr5 = this.publicSuffixExceptionListBytes;
                    if (bArr5 == null) {
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("publicSuffixExceptionListBytes");
                        throw null;
                    }
                    String binarySearch = companion3.binarySearch(bArr5, bArr, i5);
                    if (binarySearch != null) {
                        str = binarySearch;
                        break;
                    }
                    i5++;
                }
            }
            if (str != null) {
                return nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) (EXCEPTION_MARKER + str), new char[]{'.'}, false, 0, 6);
            } else if (str2 == null && str3 == null) {
                return PREVAILING_RULE;
            } else {
                if (str2 == null || (list2 = nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) str2, new char[]{'.'}, false, 0, 6)) == null) {
                    list2 = EmptyList.INSTANCE;
                }
                if (str3 == null || (list3 = nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) str3, new char[]{'.'}, false, 0, 6)) == null) {
                    list3 = EmptyList.INSTANCE;
                }
                return list2.size() > list3.size() ? list2 : list3;
            }
        }
        throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.".toString());
    }

    private final void readTheList() throws IOException {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream(PUBLIC_SUFFIX_RESOURCE);
        if (resourceAsStream != null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(resourceAsStream, "$receiver");
            ax0 ax0Var = new ax0(new cx0(resourceAsStream, new nx0()));
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ax0Var, "$receiver");
            hx0 hx0Var = new hx0(ax0Var);
            try {
                byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = hx0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(hx0Var.readInt());
                byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = hx0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(hx0Var.readInt());
                th = null;
                synchronized (this) {
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        throw th;
                    }
                    this.publicSuffixListBytes = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == null) {
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        throw th;
                    }
                    this.publicSuffixExceptionListBytes = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                }
                this.readCompleteLatch.countDown();
            } finally {
            }
        }
    }

    private final void readTheListUninterruptibly() {
        boolean z = false;
        while (true) {
            try {
                try {
                    readTheList();
                    if (!z) {
                        return;
                    }
                    Thread.currentThread().interrupt();
                    return;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z = true;
                } catch (IOException e) {
                    Platform.Companion.get().log(5, "Failed to read public suffix list", e);
                    if (!z) {
                        return;
                    }
                    Thread.currentThread().interrupt();
                    return;
                }
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
    }

    public final String getEffectiveTldPlusOne(String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "domain");
        String unicode = IDN.toUnicode(str);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) unicode, "unicodeDomain");
        int i = 0;
        List<String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) unicode, new char[]{'.'}, false, 0, 6);
        List<String> findMatchingRule = findMatchingRule(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() != findMatchingRule.size() || findMatchingRule.get(0).charAt(0) == '!') {
            char charAt = findMatchingRule.get(0).charAt(0);
            int size = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size();
            int size2 = findMatchingRule.size();
            if (charAt != '!') {
                size2++;
            }
            int i2 = size - size2;
            List Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) str, new char[]{'.'}, false, 0, 6);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, "$this$asSequence");
            zj0 xf0Var = new xf0(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(xf0Var, "$this$drop");
            if (i2 >= 0) {
                if (i2 != 0) {
                    xf0Var = xf0Var instanceof xj0 ? ((xj0) xf0Var).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2) : new wj0(xf0Var, i2);
                }
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(xf0Var, "$this$joinToString");
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(".", "separator");
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("", "prefix");
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("", "postfix");
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("...", "truncated");
                StringBuilder sb = new StringBuilder();
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(xf0Var, "$this$joinTo");
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, "buffer");
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(".", "separator");
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("", "prefix");
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("", "postfix");
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("...", "truncated");
                sb.append((CharSequence) "");
                for (Object obj : xf0Var) {
                    i++;
                    if (i > 1) {
                        sb.append((CharSequence) ".");
                    }
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, obj, (ih0<? super Object, ? extends CharSequence>) null);
                }
                sb.append((CharSequence) "");
                String sb2 = sb.toString();
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb2, "joinTo(StringBuilder(), …ed, transform).toString()");
                return sb2;
            }
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Requested element count ", i2, " is less than zero.").toString());
        }
        return null;
    }

    public final void setListBytes(byte[] bArr, byte[] bArr2) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, "publicSuffixListBytes");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr2, "publicSuffixExceptionListBytes");
        this.publicSuffixListBytes = bArr;
        this.publicSuffixExceptionListBytes = bArr2;
        this.listRead.set(true);
        this.readCompleteLatch.countDown();
    }
}
