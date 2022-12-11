package okio;

import androidx.core.app.Person;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;
import me.tvspark.outline;
import me.tvspark.ox0;
import me.tvspark.r40;
import me.tvspark.uw0;
import org.litepal.crud.LitePalSupport;
import org.litepal.util.cipher.AESCrypt;

@ef0
/* loaded from: classes4.dex */
public class ByteString implements Serializable, Comparable<ByteString> {
    public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Companion = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
    public static final ByteString EMPTY = ox0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final long serialVersionUID = 1;
    public final byte[] data;
    public transient int hashCode;
    public transient String utf8;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(gi0 gi0Var) {
        }

        public static /* bridge */ /* synthetic */ ByteString Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, byte[] bArr, int i, int i2, int i3) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = bArr.length;
            }
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, i, i2);
        }

        public final ByteString Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "$receiver");
            return ox0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
        }

        public final ByteString Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "$receiver");
            return ox0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
        }

        public final ByteString Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(InputStream inputStream, int i) throws IOException {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(inputStream, "$receiver");
            int i2 = 0;
            if (i >= 0) {
                byte[] bArr = new byte[i];
                while (i2 < i) {
                    int read = inputStream.read(bArr, i2, i - i2);
                    if (read == -1) {
                        throw new EOFException();
                    }
                    i2 += read;
                }
                return new ByteString(bArr);
            }
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("byteCount < 0: ", i).toString());
        }

        public final ByteString Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "$receiver");
            return ox0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
        }

        public final ByteString Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, Charset charset) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "$receiver");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charset, "charset");
            byte[] bytes = str.getBytes(charset);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) bytes, "(this as java.lang.String).getBytes(charset)");
            return new ByteString(bytes);
        }

        public final ByteString Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, int i2) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, "$receiver");
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr.length, i, i2);
            byte[] bArr2 = new byte[i2];
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, "src");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr2, "dest");
            System.arraycopy(bArr, i, bArr2, 0, i2);
            return new ByteString(bArr2);
        }
    }

    public ByteString(byte[] bArr) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, "data");
        this.data = bArr;
    }

    public static final ByteString decodeBase64(String str) {
        return Companion.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
    }

    public static final ByteString decodeHex(String str) {
        return Companion.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
    }

    public static final ByteString encodeString(String str, Charset charset) {
        return Companion.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, charset);
    }

    public static final ByteString encodeUtf8(String str) {
        return Companion.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
    }

    public static /* bridge */ /* synthetic */ int indexOf$default(ByteString byteString, ByteString byteString2, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return byteString.indexOf(byteString2, i);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
    }

    public static /* bridge */ /* synthetic */ int indexOf$default(ByteString byteString, byte[] bArr, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return byteString.indexOf(bArr, i);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
    }

    public static /* bridge */ /* synthetic */ int lastIndexOf$default(ByteString byteString, ByteString byteString2, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                i = byteString.size();
            }
            return byteString.lastIndexOf(byteString2, i);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
    }

    public static /* bridge */ /* synthetic */ int lastIndexOf$default(ByteString byteString, byte[] bArr, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                i = byteString.size();
            }
            return byteString.lastIndexOf(bArr, i);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
    }

    /* renamed from: of */
    public static final ByteString m52of(ByteBuffer byteBuffer) {
        if (Companion != null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer, "$receiver");
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            return new ByteString(bArr);
        }
        throw null;
    }

    /* renamed from: of */
    public static final ByteString m50of(byte[] bArr, int i, int i2) {
        return Companion.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, i, i2);
    }

    public static final ByteString read(InputStream inputStream, int i) throws IOException {
        return Companion.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(inputStream, i);
    }

    private final void readObject(ObjectInputStream objectInputStream) throws IOException {
        ByteString Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Companion.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(objectInputStream, objectInputStream.readInt());
        Field declaredField = ByteString.class.getDeclaredField("data");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) declaredField, "field");
        declaredField.setAccessible(true);
        declaredField.set(this, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.data);
    }

    public static /* bridge */ /* synthetic */ ByteString substring$default(ByteString byteString, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = byteString.size();
            }
            return byteString.substring(i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
    }

    private final void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.write(this.data);
    }

    /* renamed from: -deprecated_getByte  reason: not valid java name */
    public final byte m5111deprecated_getByte(int i) {
        return getByte(i);
    }

    /* renamed from: -deprecated_size  reason: not valid java name */
    public final int m5112deprecated_size() {
        return size();
    }

    public ByteBuffer asByteBuffer() {
        ByteBuffer asReadOnlyBuffer = ByteBuffer.wrap(this.data).asReadOnlyBuffer();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) asReadOnlyBuffer, "ByteBuffer.wrap(data).asReadOnlyBuffer()");
        return asReadOnlyBuffer;
    }

    public String base64() {
        return ox0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
    }

    public String base64Url() {
        return ox0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
    }

    @Override // java.lang.Comparable
    public int compareTo(ByteString byteString) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "other");
        return ox0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, byteString);
    }

    public ByteString digest$jvm(String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "algorithm");
        byte[] digest = MessageDigest.getInstance(str).digest(this.data);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) digest, "MessageDigest.getInstance(algorithm).digest(data)");
        return new ByteString(digest);
    }

    public final boolean endsWith(ByteString byteString) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "suffix");
        return ox0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, byteString);
    }

    public final boolean endsWith(byte[] bArr) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, "suffix");
        return ox0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, bArr);
    }

    public boolean equals(Object obj) {
        return ox0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, obj);
    }

    public final byte getByte(int i) {
        return internalGet$jvm(i);
    }

    public final byte[] getData$jvm() {
        return this.data;
    }

    public final int getHashCode$jvm() {
        return this.hashCode;
    }

    public int getSize$jvm() {
        return ox0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
    }

    public final String getUtf8$jvm() {
        return this.utf8;
    }

    public int hashCode() {
        return ox0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
    }

    public String hex() {
        return ox0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
    }

    public ByteString hmac$jvm(String str, ByteString byteString) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "algorithm");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, Person.KEY_KEY);
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.toByteArray(), str));
            byte[] doFinal = mac.doFinal(this.data);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) doFinal, "mac.doFinal(data)");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public ByteString hmacSha1(ByteString byteString) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, Person.KEY_KEY);
        return hmac$jvm("HmacSHA1", byteString);
    }

    public ByteString hmacSha256(ByteString byteString) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, Person.KEY_KEY);
        return hmac$jvm("HmacSHA256", byteString);
    }

    public ByteString hmacSha512(ByteString byteString) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, Person.KEY_KEY);
        return hmac$jvm("HmacSHA512", byteString);
    }

    public final int indexOf(ByteString byteString) {
        return indexOf$default(this, byteString, 0, 2, (Object) null);
    }

    public final int indexOf(ByteString byteString, int i) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "other");
        return indexOf(byteString.internalArray$jvm(), i);
    }

    public int indexOf(byte[] bArr) {
        return indexOf$default(this, bArr, 0, 2, (Object) null);
    }

    public int indexOf(byte[] bArr, int i) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, "other");
        return ox0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, bArr, i);
    }

    public byte[] internalArray$jvm() {
        return ox0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
    }

    public byte internalGet$jvm(int i) {
        return ox0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, i);
    }

    public final int lastIndexOf(ByteString byteString) {
        return lastIndexOf$default(this, byteString, 0, 2, (Object) null);
    }

    public final int lastIndexOf(ByteString byteString, int i) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "other");
        return lastIndexOf(byteString.internalArray$jvm(), i);
    }

    public int lastIndexOf(byte[] bArr) {
        return lastIndexOf$default(this, bArr, 0, 2, (Object) null);
    }

    public int lastIndexOf(byte[] bArr, int i) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, "other");
        return ox0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, bArr, i);
    }

    public ByteString md5() {
        return digest$jvm(LitePalSupport.MD5);
    }

    public boolean rangeEquals(int i, ByteString byteString, int i2, int i3) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "other");
        return ox0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, i, byteString, i2, i3);
    }

    public boolean rangeEquals(int i, byte[] bArr, int i2, int i3) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, "other");
        return ox0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, i, bArr, i2, i3);
    }

    public final void setHashCode$jvm(int i) {
        this.hashCode = i;
    }

    public final void setUtf8$jvm(String str) {
        this.utf8 = str;
    }

    public ByteString sha1() {
        return digest$jvm("SHA-1");
    }

    public ByteString sha256() {
        return digest$jvm(AESCrypt.HASH_ALGORITHM);
    }

    public ByteString sha512() {
        return digest$jvm("SHA-512");
    }

    public final int size() {
        return getSize$jvm();
    }

    public final boolean startsWith(ByteString byteString) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "prefix");
        return ox0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, byteString);
    }

    public final boolean startsWith(byte[] bArr) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, "prefix");
        return ox0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, bArr);
    }

    public String string(Charset charset) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charset, "charset");
        return new String(this.data, charset);
    }

    public ByteString substring() {
        return substring$default(this, 0, 0, 3, null);
    }

    public ByteString substring(int i) {
        return substring$default(this, i, 0, 2, null);
    }

    public ByteString substring(int i, int i2) {
        return ox0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, i, i2);
    }

    public ByteString toAsciiLowercase() {
        return ox0.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
    }

    public ByteString toAsciiUppercase() {
        return ox0.Wwwwwwwwwwwwwwwwwwwwwwwwwww(this);
    }

    public byte[] toByteArray() {
        return ox0.Wwwwwwwwwwwwwwwwwwwwwwwwww(this);
    }

    public String toString() {
        return ox0.Wwwwwwwwwwwwwwwwwwwwwwwww(this);
    }

    public String utf8() {
        return ox0.Wwwwwwwwwwwwwwwwwwwwwwww(this);
    }

    public void write(OutputStream outputStream) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outputStream, "out");
        outputStream.write(this.data);
    }

    public void write$jvm(uw0 uw0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var, "buffer");
        byte[] bArr = this.data;
        uw0Var.mo4962write(bArr, 0, bArr.length);
    }

    /* renamed from: of */
    public static final ByteString m51of(byte... bArr) {
        if (Companion != null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, "data");
            return ox0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr);
        }
        throw null;
    }
}
