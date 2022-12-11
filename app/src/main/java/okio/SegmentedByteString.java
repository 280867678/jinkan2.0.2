package okio;

import androidx.core.app.Person;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.TypeCastException;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;
import me.tvspark.ix0;
import me.tvspark.nh0;
import me.tvspark.of0;
import me.tvspark.outline;
import me.tvspark.r40;
import me.tvspark.uw0;

@ef0
/* loaded from: classes4.dex */
public final class SegmentedByteString extends ByteString {
    public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Companion = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
    public final transient int[] directory;
    public final transient byte[][] segments;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(gi0 gi0Var) {
        }
    }

    public SegmentedByteString(byte[][] bArr, int[] iArr) {
        super(ByteString.EMPTY.getData$jvm());
        this.segments = bArr;
        this.directory = iArr;
    }

    public /* synthetic */ SegmentedByteString(byte[][] bArr, int[] iArr, gi0 gi0Var) {
        this(bArr, iArr);
    }

    private final void forEachSegment(int i, int i2, nh0<? super byte[], ? super Integer, ? super Integer, of0> nh0Var) {
        int segment = segment(i);
        while (i < i2) {
            int i3 = segment == 0 ? 0 : getDirectory()[segment - 1];
            int i4 = getDirectory()[getSegments().length + segment];
            int min = Math.min(i2, (getDirectory()[segment] - i3) + i3) - i;
            nh0Var.invoke(getSegments()[segment], Integer.valueOf((i - i3) + i4), Integer.valueOf(min));
            i += min;
            segment++;
        }
    }

    private final void forEachSegment(nh0<? super byte[], ? super Integer, ? super Integer, of0> nh0Var) {
        int length = getSegments().length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = getDirectory()[length + i];
            int i4 = getDirectory()[i];
            nh0Var.invoke(getSegments()[i], Integer.valueOf(i3), Integer.valueOf(i4 - i2));
            i++;
            i2 = i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int segment(int i) {
        int binarySearch = Arrays.binarySearch(this.directory, 0, this.segments.length, i + 1);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }

    private final ByteString toByteString() {
        return new ByteString(toByteArray());
    }

    private final Object writeReplace() {
        ByteString byteString = toByteString();
        if (byteString != null) {
            return byteString;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
    }

    @Override // okio.ByteString
    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    @Override // okio.ByteString
    public String base64() {
        return toByteString().base64();
    }

    @Override // okio.ByteString
    public String base64Url() {
        return toByteString().base64Url();
    }

    @Override // okio.ByteString
    public ByteString digest$jvm(String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        int length = getSegments().length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = getDirectory()[length + i];
            int i4 = getDirectory()[i];
            messageDigest.update(getSegments()[i], i3, i4 - i2);
            i++;
            i2 = i4;
        }
        byte[] digest = messageDigest.digest();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) digest, "digest.digest()");
        return new ByteString(digest);
    }

    @Override // okio.ByteString
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == size() && rangeEquals(0, byteString, 0, size())) {
                return true;
            }
        }
        return false;
    }

    public final int[] getDirectory() {
        return this.directory;
    }

    public final byte[][] getSegments() {
        return this.segments;
    }

    @Override // okio.ByteString
    public int getSize$jvm() {
        return this.directory[this.segments.length - 1];
    }

    @Override // okio.ByteString
    public int hashCode() {
        int hashCode$jvm = getHashCode$jvm();
        if (hashCode$jvm != 0) {
            return hashCode$jvm;
        }
        int length = getSegments().length;
        int i = 0;
        int i2 = 0;
        int i3 = 1;
        while (i < length) {
            int i4 = getDirectory()[length + i];
            int i5 = getDirectory()[i];
            byte[] bArr = getSegments()[i];
            int i6 = (i5 - i2) + i4;
            while (i4 < i6) {
                i3 = (i3 * 31) + bArr[i4];
                i4++;
            }
            i++;
            i2 = i5;
        }
        setHashCode$jvm(i3);
        return i3;
    }

    @Override // okio.ByteString
    public String hex() {
        return toByteString().hex();
    }

    @Override // okio.ByteString
    public ByteString hmac$jvm(String str, ByteString byteString) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "algorithm");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, Person.KEY_KEY);
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.toByteArray(), str));
            int length = getSegments().length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int i3 = getDirectory()[length + i];
                int i4 = getDirectory()[i];
                mac.update(getSegments()[i], i3, i4 - i2);
                i++;
                i2 = i4;
            }
            byte[] doFinal = mac.doFinal();
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) doFinal, "mac.doFinal()");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override // okio.ByteString
    public int indexOf(byte[] bArr, int i) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, "other");
        return toByteString().indexOf(bArr, i);
    }

    @Override // okio.ByteString
    public byte[] internalArray$jvm() {
        return toByteArray();
    }

    @Override // okio.ByteString
    public byte internalGet$jvm(int i) {
        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.directory[this.segments.length - 1], i, 1L);
        int segment = segment(i);
        int i2 = segment == 0 ? 0 : this.directory[segment - 1];
        int[] iArr = this.directory;
        byte[][] bArr = this.segments;
        return bArr[segment][(i - i2) + iArr[bArr.length + segment]];
    }

    @Override // okio.ByteString
    public int lastIndexOf(byte[] bArr, int i) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, "other");
        return toByteString().lastIndexOf(bArr, i);
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int i, ByteString byteString, int i2, int i3) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "other");
        if (i < 0 || i > size() - i3) {
            return false;
        }
        int i4 = i3 + i;
        int segment = segment(i);
        while (i < i4) {
            int i5 = segment == 0 ? 0 : getDirectory()[segment - 1];
            int i6 = getDirectory()[getSegments().length + segment];
            int min = Math.min(i4, (getDirectory()[segment] - i5) + i5) - i;
            if (!byteString.rangeEquals(i2, getSegments()[segment], (i - i5) + i6, min)) {
                return false;
            }
            i2 += min;
            i += min;
            segment++;
        }
        return true;
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int i, byte[] bArr, int i2, int i3) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, "other");
        if (i < 0 || i > size() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int i4 = i3 + i;
        int segment = segment(i);
        while (i < i4) {
            int i5 = segment == 0 ? 0 : getDirectory()[segment - 1];
            int i6 = getDirectory()[getSegments().length + segment];
            int min = Math.min(i4, (getDirectory()[segment] - i5) + i5) - i;
            if (!r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getSegments()[segment], (i - i5) + i6, bArr, i2, min)) {
                return false;
            }
            i2 += min;
            i += min;
            segment++;
        }
        return true;
    }

    @Override // okio.ByteString
    public String string(Charset charset) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charset, "charset");
        return toByteString().string(charset);
    }

    @Override // okio.ByteString
    public ByteString substring(int i, int i2) {
        int i3 = 0;
        if (i >= 0) {
            if (!(i2 <= size())) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("endIndex=", i2, " > length(");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(size());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(')');
                throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString().toString());
            }
            int i4 = i2 - i;
            if (!(i4 >= 0)) {
                throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("endIndex=", i2, " < beginIndex=", i).toString());
            }
            if (i == 0 && i2 == size()) {
                return this;
            }
            if (i == i2) {
                return ByteString.EMPTY;
            }
            int segment = segment(i);
            int segment2 = segment(i2 - 1);
            Object[] copyOfRange = Arrays.copyOfRange(this.segments, segment, segment2 + 1);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            byte[][] bArr = (byte[][]) copyOfRange;
            int[] iArr = new int[bArr.length * 2];
            if (segment <= segment2) {
                int i5 = 0;
                int i6 = segment;
                while (true) {
                    iArr[i5] = Math.min(this.directory[i6] - i, i4);
                    int i7 = i5 + 1;
                    iArr[i5 + bArr.length] = this.directory[this.segments.length + i6];
                    if (i6 == segment2) {
                        break;
                    }
                    i6++;
                    i5 = i7;
                }
            }
            if (segment != 0) {
                i3 = this.directory[segment - 1];
            }
            int length = bArr.length;
            iArr[length] = (i - i3) + iArr[length];
            return new SegmentedByteString(bArr, iArr);
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("beginIndex=", i, " < 0").toString());
    }

    @Override // okio.ByteString
    public ByteString toAsciiLowercase() {
        return toByteString().toAsciiLowercase();
    }

    @Override // okio.ByteString
    public ByteString toAsciiUppercase() {
        return toByteString().toAsciiUppercase();
    }

    @Override // okio.ByteString
    public byte[] toByteArray() {
        byte[] bArr = new byte[size()];
        int length = getSegments().length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            int i4 = getDirectory()[length + i];
            int i5 = getDirectory()[i];
            int i6 = i5 - i2;
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getSegments()[i], i4, bArr, i3, i6);
            i3 += i6;
            i++;
            i2 = i5;
        }
        return bArr;
    }

    @Override // okio.ByteString
    public String toString() {
        return toByteString().toString();
    }

    @Override // okio.ByteString
    public void write(OutputStream outputStream) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outputStream, "out");
        int length = getSegments().length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = getDirectory()[length + i];
            int i4 = getDirectory()[i];
            outputStream.write(getSegments()[i], i3, i4 - i2);
            i++;
            i2 = i4;
        }
    }

    @Override // okio.ByteString
    public void write$jvm(uw0 uw0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var, "buffer");
        int length = getSegments().length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = getDirectory()[length + i];
            int i4 = getDirectory()[i];
            ix0 ix0Var = new ix0(getSegments()[i], i3, i3 + (i4 - i2), true, false);
            ix0 ix0Var2 = uw0Var.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (ix0Var2 == null) {
                ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = ix0Var;
                ix0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = ix0Var;
                uw0Var.Wwwwwwwwwwwwwwwwwwwwwwww = ix0Var;
            } else if (ix0Var2 == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            } else {
                ix0 ix0Var3 = ix0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (ix0Var3 == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
                ix0Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ix0Var);
            }
            i++;
            i2 = i4;
        }
        uw0Var.Wwwwwwwwwwwwwwwwwwwwwww += size();
    }
}
