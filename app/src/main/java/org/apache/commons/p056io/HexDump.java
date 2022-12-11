package org.apache.commons.p056io;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import me.tvspark.outline;
import org.apache.http.message.TokenParser;

/* renamed from: org.apache.commons.io.HexDump */
/* loaded from: classes4.dex */
public class HexDump {
    public static final String EOL = System.getProperty("line.separator");
    public static final char[] _hexcodes = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final int[] _shifts = {28, 24, 20, 16, 12, 8, 4, 0};

    public static StringBuilder dump(StringBuilder sb, byte b) {
        for (int i = 0; i < 2; i++) {
            sb.append(_hexcodes[(b >> _shifts[i + 6]) & 15]);
        }
        return sb;
    }

    public static StringBuilder dump(StringBuilder sb, long j) {
        for (int i = 0; i < 8; i++) {
            sb.append(_hexcodes[((int) (j >> _shifts[i])) & 15]);
        }
        return sb;
    }

    public static void dump(byte[] bArr, long j, OutputStream outputStream, int i) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (i < 0 || i >= bArr.length) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("illegal index: ", i, " into array of length ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(bArr.length);
            throw new ArrayIndexOutOfBoundsException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        } else if (outputStream == null) {
            throw new IllegalArgumentException("cannot write to nullstream");
        } else {
            long j2 = j + i;
            StringBuilder sb = new StringBuilder(74);
            while (i < bArr.length) {
                int length = bArr.length - i;
                if (length > 16) {
                    length = 16;
                }
                dump(sb, j2).append(TokenParser.f4579SP);
                for (int i2 = 0; i2 < 16; i2++) {
                    if (i2 < length) {
                        dump(sb, bArr[i2 + i]);
                    } else {
                        sb.append("  ");
                    }
                    sb.append(TokenParser.f4579SP);
                }
                for (int i3 = 0; i3 < length; i3++) {
                    int i4 = i3 + i;
                    sb.append((bArr[i4] < 32 || bArr[i4] >= Byte.MAX_VALUE) ? '.' : (char) bArr[i4]);
                }
                sb.append(EOL);
                outputStream.write(sb.toString().getBytes(Charset.defaultCharset()));
                outputStream.flush();
                sb.setLength(0);
                j2 += length;
                i += 16;
            }
        }
    }
}
