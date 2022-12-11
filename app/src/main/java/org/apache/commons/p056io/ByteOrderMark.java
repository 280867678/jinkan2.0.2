package org.apache.commons.p056io;

import com.tencent.bugly.beta.tinker.TinkerReport;
import com.tencent.smtt.sdk.TbsListener;
import java.io.Serializable;
import org.apache.commons.p056io.input.XmlStreamReader;

/* renamed from: org.apache.commons.io.ByteOrderMark */
/* loaded from: classes4.dex */
public class ByteOrderMark implements Serializable {
    public static final char UTF_BOM = 65279;
    public static final long serialVersionUID = 1;
    public final int[] bytes;
    public final String charsetName;
    public static final ByteOrderMark UTF_8 = new ByteOrderMark("UTF-8", TbsListener.ErrorCode.DECOUPLE_TPATCH_FAIL, 187, 191);
    public static final ByteOrderMark UTF_16BE = new ByteOrderMark("UTF-16BE", TinkerReport.KEY_LOADED_EXCEPTION_RESOURCE, 255);
    public static final ByteOrderMark UTF_16LE = new ByteOrderMark("UTF-16LE", 255, TinkerReport.KEY_LOADED_EXCEPTION_RESOURCE);
    public static final ByteOrderMark UTF_32BE = new ByteOrderMark(XmlStreamReader.UTF_32BE, 0, 0, TinkerReport.KEY_LOADED_EXCEPTION_RESOURCE, 255);
    public static final ByteOrderMark UTF_32LE = new ByteOrderMark(XmlStreamReader.UTF_32LE, 255, TinkerReport.KEY_LOADED_EXCEPTION_RESOURCE, 0, 0);

    public ByteOrderMark(String str, int... iArr) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("No charsetName specified");
        }
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("No bytes specified");
        }
        this.charsetName = str;
        int[] iArr2 = new int[iArr.length];
        this.bytes = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ByteOrderMark)) {
            return false;
        }
        ByteOrderMark byteOrderMark = (ByteOrderMark) obj;
        if (this.bytes.length != byteOrderMark.length()) {
            return false;
        }
        int i = 0;
        while (true) {
            int[] iArr = this.bytes;
            if (i >= iArr.length) {
                return true;
            }
            if (iArr[i] != byteOrderMark.get(i)) {
                return false;
            }
            i++;
        }
    }

    public int get(int i) {
        return this.bytes[i];
    }

    public byte[] getBytes() {
        byte[] bArr = new byte[this.bytes.length];
        int i = 0;
        while (true) {
            int[] iArr = this.bytes;
            if (i < iArr.length) {
                bArr[i] = (byte) iArr[i];
                i++;
            } else {
                return bArr;
            }
        }
    }

    public String getCharsetName() {
        return this.charsetName;
    }

    public int hashCode() {
        int hashCode = ByteOrderMark.class.hashCode();
        for (int i : this.bytes) {
            hashCode += i;
        }
        return hashCode;
    }

    public int length() {
        return this.bytes.length;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ByteOrderMark.class.getSimpleName());
        sb.append('[');
        sb.append(this.charsetName);
        sb.append(": ");
        for (int i = 0; i < this.bytes.length; i++) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append("0x");
            sb.append(Integer.toHexString(this.bytes[i] & 255).toUpperCase());
        }
        sb.append(']');
        return sb.toString();
    }
}
