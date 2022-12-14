package okhttp3.internal.p054ws;

import androidx.core.app.Person;
import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.outline;
import me.tvspark.uw0;
import okio.ByteString;

@ef0
/* renamed from: okhttp3.internal.ws.WebSocketProtocol */
/* loaded from: classes4.dex */
public final class WebSocketProtocol {
    public static final String ACCEPT_MAGIC = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    public static final int B0_FLAG_FIN = 128;
    public static final int B0_FLAG_RSV1 = 64;
    public static final int B0_FLAG_RSV2 = 32;
    public static final int B0_FLAG_RSV3 = 16;
    public static final int B0_MASK_OPCODE = 15;
    public static final int B1_FLAG_MASK = 128;
    public static final int B1_MASK_LENGTH = 127;
    public static final int CLOSE_CLIENT_GOING_AWAY = 1001;
    public static final long CLOSE_MESSAGE_MAX = 123;
    public static final int CLOSE_NO_STATUS_CODE = 1005;
    public static final WebSocketProtocol INSTANCE = new WebSocketProtocol();
    public static final int OPCODE_BINARY = 2;
    public static final int OPCODE_CONTINUATION = 0;
    public static final int OPCODE_CONTROL_CLOSE = 8;
    public static final int OPCODE_CONTROL_PING = 9;
    public static final int OPCODE_CONTROL_PONG = 10;
    public static final int OPCODE_FLAG_CONTROL = 8;
    public static final int OPCODE_TEXT = 1;
    public static final long PAYLOAD_BYTE_MAX = 125;
    public static final int PAYLOAD_LONG = 127;
    public static final int PAYLOAD_SHORT = 126;
    public static final long PAYLOAD_SHORT_MAX = 65535;

    public final String acceptHeader(String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, Person.KEY_KEY);
        ByteString.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ByteString.Companion;
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").sha1().base64();
    }

    public final String closeCodeExceptionMessage(int i) {
        StringBuilder sb;
        if (i < 1000 || i >= 5000) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Code must be in range [1000,5000): ");
            sb2.append(i);
            sb = sb2;
        } else if ((1004 > i || 1006 < i) && (1015 > i || 2999 < i)) {
            return null;
        } else {
            sb = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Code ", i, " is reserved and may not be used.");
        }
        return sb.toString();
    }

    public final void toggleMask(uw0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, byte[] bArr) {
        long j;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "cursor");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, Person.KEY_KEY);
        int length = bArr.length;
        int i = 0;
        do {
            byte[] bArr2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww;
            int i2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww;
            int i3 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww;
            boolean z = true;
            if (bArr2 != null) {
                while (i2 < i3) {
                    int i4 = i % length;
                    bArr2[i2] = (byte) (bArr2[i2] ^ bArr[i4]);
                    i2++;
                    i = i4 + 1;
                }
            }
            long j2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww;
            uw0 uw0Var = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (uw0Var == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            if (j2 == uw0Var.Wwwwwwwwwwwwwwwwwwwwwww) {
                z = false;
            }
            if (!z) {
                throw new IllegalStateException("no more bytes".toString());
            }
            j = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww;
        } while (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j == -1 ? 0L : j + (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww - wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww)) != -1);
    }

    public final void validateCloseCode(int i) {
        String closeCodeExceptionMessage = closeCodeExceptionMessage(i);
        if (!(closeCodeExceptionMessage == null)) {
            if (closeCodeExceptionMessage != null) {
                throw new IllegalArgumentException(closeCodeExceptionMessage.toString());
            }
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
    }
}
