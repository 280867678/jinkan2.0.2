package fi.iki.elonen;

import androidx.core.view.PointerIconCompat;
import com.tencent.bugly.beta.tinker.TinkerReport;
import fi.iki.elonen.NanoHTTPD;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.tvspark.outline;
import org.eclipse.jetty.util.B64Code;

/* loaded from: classes4.dex */
public abstract class NanoWSD extends NanoHTTPD {
    public static final String HEADER_CONNECTION = "connection";
    public static final String HEADER_CONNECTION_VALUE = "Upgrade";
    public static final String HEADER_UPGRADE = "upgrade";
    public static final String HEADER_UPGRADE_VALUE = "websocket";
    public static final String HEADER_WEBSOCKET_ACCEPT = "sec-websocket-accept";
    public static final String HEADER_WEBSOCKET_KEY = "sec-websocket-key";
    public static final String HEADER_WEBSOCKET_PROTOCOL = "sec-websocket-protocol";
    public static final String HEADER_WEBSOCKET_VERSION = "sec-websocket-version";
    public static final String HEADER_WEBSOCKET_VERSION_VALUE = "13";
    public static final String WEBSOCKET_KEY_MAGIC = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    public static final Logger LOG = Logger.getLogger(NanoWSD.class.getName());
    public static final char[] ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();

    /* loaded from: classes4.dex */
    public enum State {
        UNCONNECTED,
        CONNECTING,
        OPEN,
        CLOSING,
        CLOSED
    }

    /* loaded from: classes4.dex */
    public static abstract class WebSocket {
        public final NanoHTTPD.IHTTPSession handshakeRequest;

        /* renamed from: in */
        public final InputStream f4349in;
        public OutputStream out;
        public WebSocketFrame.OpCode continuousOpCode = null;
        public final List<WebSocketFrame> continuousFrames = new LinkedList();
        public State state = State.UNCONNECTED;
        public final NanoHTTPD.Response handshakeResponse = new NanoHTTPD.Response(NanoHTTPD.Response.Status.SWITCH_PROTOCOL, null, null, 0) { // from class: fi.iki.elonen.NanoWSD.WebSocket.1
            @Override // fi.iki.elonen.NanoHTTPD.Response
            public void send(OutputStream outputStream) {
                WebSocket.this.out = outputStream;
                WebSocket.this.state = State.CONNECTING;
                super.send(outputStream);
                WebSocket.this.state = State.OPEN;
                WebSocket.this.onOpen();
                WebSocket.this.readWebsocket();
            }
        };

        public WebSocket(NanoHTTPD.IHTTPSession iHTTPSession) {
            this.handshakeRequest = iHTTPSession;
            this.f4349in = iHTTPSession.getInputStream();
            this.handshakeResponse.addHeader("upgrade", NanoWSD.HEADER_UPGRADE_VALUE);
            this.handshakeResponse.addHeader("connection", "Upgrade");
        }

        private void doClose(WebSocketFrame.CloseCode closeCode, String str, boolean z) {
            if (this.state == State.CLOSED) {
                return;
            }
            InputStream inputStream = this.f4349in;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    NanoWSD.LOG.log(Level.FINE, "close failed", (Throwable) e);
                }
            }
            OutputStream outputStream = this.out;
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e2) {
                    NanoWSD.LOG.log(Level.FINE, "close failed", (Throwable) e2);
                }
            }
            this.state = State.CLOSED;
            onClose(closeCode, str, z);
        }

        private void handleCloseFrame(WebSocketFrame webSocketFrame) throws IOException {
            String str;
            WebSocketFrame.CloseCode closeCode = WebSocketFrame.CloseCode.NormalClosure;
            if (webSocketFrame instanceof WebSocketFrame.CloseFrame) {
                WebSocketFrame.CloseFrame closeFrame = (WebSocketFrame.CloseFrame) webSocketFrame;
                closeCode = closeFrame.getCloseCode();
                str = closeFrame.getCloseReason();
            } else {
                str = "";
            }
            if (this.state == State.CLOSING) {
                doClose(closeCode, str, false);
            } else {
                close(closeCode, str, true);
            }
        }

        private void handleFrameFragment(WebSocketFrame webSocketFrame) throws IOException {
            if (webSocketFrame.getOpCode() != WebSocketFrame.OpCode.Continuation) {
                if (this.continuousOpCode != null) {
                    throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Previous continuous frame sequence not completed.");
                }
                this.continuousOpCode = webSocketFrame.getOpCode();
                this.continuousFrames.clear();
            } else if (webSocketFrame.isFin()) {
                if (this.continuousOpCode == null) {
                    throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Continuous frame sequence was not started.");
                }
                this.continuousFrames.add(webSocketFrame);
                onMessage(new WebSocketFrame(this.continuousOpCode, this.continuousFrames));
                this.continuousOpCode = null;
                this.continuousFrames.clear();
                return;
            } else if (this.continuousOpCode == null) {
                throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Continuous frame sequence was not started.");
            }
            this.continuousFrames.add(webSocketFrame);
        }

        private void handleWebsocketFrame(WebSocketFrame webSocketFrame) throws IOException {
            debugFrameReceived(webSocketFrame);
            if (webSocketFrame.getOpCode() == WebSocketFrame.OpCode.Close) {
                handleCloseFrame(webSocketFrame);
            } else if (webSocketFrame.getOpCode() == WebSocketFrame.OpCode.Ping) {
                sendFrame(new WebSocketFrame(WebSocketFrame.OpCode.Pong, true, webSocketFrame.getBinaryPayload()));
            } else if (webSocketFrame.getOpCode() == WebSocketFrame.OpCode.Pong) {
                onPong(webSocketFrame);
            } else if (!webSocketFrame.isFin() || webSocketFrame.getOpCode() == WebSocketFrame.OpCode.Continuation) {
                handleFrameFragment(webSocketFrame);
            } else if (this.continuousOpCode != null) {
                throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Continuous frame sequence not completed.");
            } else {
                if (webSocketFrame.getOpCode() != WebSocketFrame.OpCode.Text && webSocketFrame.getOpCode() != WebSocketFrame.OpCode.Binary) {
                    throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Non control or continuous frame expected.");
                }
                onMessage(webSocketFrame);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void readWebsocket() {
            WebSocketFrame.CloseCode code;
            String reason;
            while (true) {
                try {
                    try {
                        if (this.state != State.OPEN) {
                            break;
                        }
                        handleWebsocketFrame(WebSocketFrame.read(this.f4349in));
                    } catch (CharacterCodingException e) {
                        onException(e);
                        code = WebSocketFrame.CloseCode.InvalidFramePayloadData;
                        reason = e.toString();
                        doClose(code, reason, false);
                    } catch (IOException e2) {
                        onException(e2);
                        if (e2 instanceof WebSocketException) {
                            code = ((WebSocketException) e2).getCode();
                            reason = ((WebSocketException) e2).getReason();
                            doClose(code, reason, false);
                        }
                    }
                } finally {
                    doClose(WebSocketFrame.CloseCode.InternalServerError, "Handler terminated without closing the connection.", false);
                }
            }
        }

        public void close(WebSocketFrame.CloseCode closeCode, String str, boolean z) throws IOException {
            State state = this.state;
            this.state = State.CLOSING;
            if (state == State.OPEN) {
                sendFrame(new WebSocketFrame.CloseFrame(closeCode, str));
            } else {
                doClose(closeCode, str, z);
            }
        }

        public void debugFrameReceived(WebSocketFrame webSocketFrame) {
        }

        public void debugFrameSent(WebSocketFrame webSocketFrame) {
        }

        public NanoHTTPD.IHTTPSession getHandshakeRequest() {
            return this.handshakeRequest;
        }

        public NanoHTTPD.Response getHandshakeResponse() {
            return this.handshakeResponse;
        }

        public boolean isOpen() {
            return this.state == State.OPEN;
        }

        public abstract void onClose(WebSocketFrame.CloseCode closeCode, String str, boolean z);

        public abstract void onException(IOException iOException);

        public abstract void onMessage(WebSocketFrame webSocketFrame);

        public abstract void onOpen();

        public abstract void onPong(WebSocketFrame webSocketFrame);

        public void ping(byte[] bArr) throws IOException {
            sendFrame(new WebSocketFrame(WebSocketFrame.OpCode.Ping, true, bArr));
        }

        public void send(String str) throws IOException {
            sendFrame(new WebSocketFrame(WebSocketFrame.OpCode.Text, true, str));
        }

        public void send(byte[] bArr) throws IOException {
            sendFrame(new WebSocketFrame(WebSocketFrame.OpCode.Binary, true, bArr));
        }

        public synchronized void sendFrame(WebSocketFrame webSocketFrame) throws IOException {
            debugFrameSent(webSocketFrame);
            webSocketFrame.write(this.out);
        }
    }

    /* loaded from: classes4.dex */
    public static class WebSocketException extends IOException {
        public static final long serialVersionUID = 1;
        public final WebSocketFrame.CloseCode code;
        public final String reason;

        public WebSocketException(WebSocketFrame.CloseCode closeCode, String str) {
            this(closeCode, str, null);
        }

        public WebSocketException(WebSocketFrame.CloseCode closeCode, String str, Exception exc) {
            super(closeCode + ": " + str, exc);
            this.code = closeCode;
            this.reason = str;
        }

        public WebSocketException(Exception exc) {
            this(WebSocketFrame.CloseCode.InternalServerError, exc.toString(), exc);
        }

        public WebSocketFrame.CloseCode getCode() {
            return this.code;
        }

        public String getReason() {
            return this.reason;
        }
    }

    /* loaded from: classes4.dex */
    public static class WebSocketFrame {
        public static final Charset TEXT_CHARSET = Charset.forName("UTF-8");
        public transient int _payloadLength;
        public transient String _payloadString;
        public boolean fin;
        public byte[] maskingKey;
        public OpCode opCode;
        public byte[] payload;

        /* loaded from: classes4.dex */
        public enum CloseCode {
            NormalClosure(1000),
            GoingAway(1001),
            ProtocolError(1002),
            UnsupportedData(1003),
            NoStatusRcvd(1005),
            AbnormalClosure(PointerIconCompat.TYPE_CELL),
            InvalidFramePayloadData(PointerIconCompat.TYPE_CROSSHAIR),
            PolicyViolation(PointerIconCompat.TYPE_TEXT),
            MessageTooBig(PointerIconCompat.TYPE_VERTICAL_TEXT),
            MandatoryExt(PointerIconCompat.TYPE_ALIAS),
            InternalServerError(PointerIconCompat.TYPE_COPY),
            TLSHandshake(PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW);
            
            public final int code;

            CloseCode(int i) {
                this.code = i;
            }

            public static CloseCode find(int i) {
                CloseCode[] values;
                for (CloseCode closeCode : values()) {
                    if (closeCode.getValue() == i) {
                        return closeCode;
                    }
                }
                return null;
            }

            public int getValue() {
                return this.code;
            }
        }

        /* loaded from: classes4.dex */
        public static class CloseFrame extends WebSocketFrame {
            public static final /* synthetic */ boolean $assertionsDisabled = false;
            public CloseCode _closeCode;
            public String _closeReason;

            public CloseFrame(CloseCode closeCode, String str) throws CharacterCodingException {
                super(OpCode.Close, true, generatePayload(closeCode, str));
            }

            public CloseFrame(WebSocketFrame webSocketFrame) throws CharacterCodingException {
                super(webSocketFrame);
                if (webSocketFrame.getBinaryPayload().length >= 2) {
                    this._closeCode = CloseCode.find((webSocketFrame.getBinaryPayload()[1] & 255) | ((webSocketFrame.getBinaryPayload()[0] & 255) << 8));
                    this._closeReason = WebSocketFrame.binary2Text(getBinaryPayload(), 2, getBinaryPayload().length - 2);
                }
            }

            public static byte[] generatePayload(CloseCode closeCode, String str) throws CharacterCodingException {
                if (closeCode != null) {
                    byte[] text2Binary = WebSocketFrame.text2Binary(str);
                    byte[] bArr = new byte[text2Binary.length + 2];
                    bArr[0] = (byte) ((closeCode.getValue() >> 8) & 255);
                    bArr[1] = (byte) (closeCode.getValue() & 255);
                    System.arraycopy(text2Binary, 0, bArr, 2, text2Binary.length);
                    return bArr;
                }
                return new byte[0];
            }

            public CloseCode getCloseCode() {
                return this._closeCode;
            }

            public String getCloseReason() {
                return this._closeReason;
            }
        }

        /* loaded from: classes4.dex */
        public enum OpCode {
            Continuation(0),
            Text(1),
            Binary(2),
            Close(8),
            Ping(9),
            Pong(10);
            
            public final byte code;

            OpCode(int i) {
                this.code = (byte) i;
            }

            public static OpCode find(byte b) {
                OpCode[] values;
                for (OpCode opCode : values()) {
                    if (opCode.getValue() == b) {
                        return opCode;
                    }
                }
                return null;
            }

            public byte getValue() {
                return this.code;
            }

            public boolean isControlFrame() {
                return this == Close || this == Ping || this == Pong;
            }
        }

        public WebSocketFrame(OpCode opCode, List<WebSocketFrame> list) throws WebSocketException {
            Iterator<WebSocketFrame> it;
            setOpCode(opCode);
            setFin(true);
            long j = 0;
            while (list.iterator().hasNext()) {
                j += it.next().getBinaryPayload().length;
            }
            if (j < 0 || j > 2147483647L) {
                throw new WebSocketException(CloseCode.MessageTooBig, "Max frame length has been exceeded.");
            }
            int i = (int) j;
            this._payloadLength = i;
            byte[] bArr = new byte[i];
            int i2 = 0;
            for (WebSocketFrame webSocketFrame : list) {
                System.arraycopy(webSocketFrame.getBinaryPayload(), 0, bArr, i2, webSocketFrame.getBinaryPayload().length);
                i2 += webSocketFrame.getBinaryPayload().length;
            }
            setBinaryPayload(bArr);
        }

        public WebSocketFrame(OpCode opCode, boolean z) {
            setOpCode(opCode);
            setFin(z);
        }

        public WebSocketFrame(OpCode opCode, boolean z, String str) throws CharacterCodingException {
            this(opCode, z, str, (byte[]) null);
        }

        public WebSocketFrame(OpCode opCode, boolean z, String str, byte[] bArr) throws CharacterCodingException {
            this(opCode, z);
            setMaskingKey(bArr);
            setTextPayload(str);
        }

        public WebSocketFrame(OpCode opCode, boolean z, byte[] bArr) {
            this(opCode, z, bArr, (byte[]) null);
        }

        public WebSocketFrame(OpCode opCode, boolean z, byte[] bArr, byte[] bArr2) {
            this(opCode, z);
            setMaskingKey(bArr2);
            setBinaryPayload(bArr);
        }

        public WebSocketFrame(WebSocketFrame webSocketFrame) {
            setOpCode(webSocketFrame.getOpCode());
            setFin(webSocketFrame.isFin());
            setBinaryPayload(webSocketFrame.getBinaryPayload());
            setMaskingKey(webSocketFrame.getMaskingKey());
        }

        public static String binary2Text(byte[] bArr) throws CharacterCodingException {
            return new String(bArr, TEXT_CHARSET);
        }

        public static String binary2Text(byte[] bArr, int i, int i2) throws CharacterCodingException {
            return new String(bArr, i, i2, TEXT_CHARSET);
        }

        public static int checkedRead(int i) throws IOException {
            if (i >= 0) {
                return i;
            }
            throw new EOFException();
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x005e, code lost:
            if (r6.payload.length > 50) goto L10;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private String payloadToString() {
            if (this.payload == null) {
                return "null";
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('[');
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.payload.length);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("b] ");
            if (getOpCode() == OpCode.Text) {
                String textPayload = getTextPayload();
                if (textPayload.length() <= 100) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(textPayload);
                    return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(textPayload.substring(0, 100));
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("...");
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("0x");
            for (int i = 0; i < Math.min(this.payload.length, 50); i++) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Integer.toHexString(this.payload[i] & 255));
            }
        }

        public static WebSocketFrame read(InputStream inputStream) throws IOException {
            byte checkedRead = (byte) checkedRead(inputStream.read());
            boolean z = (checkedRead & 128) != 0;
            int i = checkedRead & 15;
            OpCode find = OpCode.find((byte) i);
            int i2 = checkedRead & 112;
            if (i2 != 0) {
                CloseCode closeCode = CloseCode.ProtocolError;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("The reserved bits (");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Integer.toBinaryString(i2));
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(") must be 0.");
                throw new WebSocketException(closeCode, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            } else if (find == null) {
                throw new WebSocketException(CloseCode.ProtocolError, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Received frame with reserved/unknown opcode ", i, "."));
            } else {
                if (find.isControlFrame() && !z) {
                    throw new WebSocketException(CloseCode.ProtocolError, "Fragmented control frame.");
                }
                WebSocketFrame webSocketFrame = new WebSocketFrame(find, z);
                webSocketFrame.readPayloadInfo(inputStream);
                webSocketFrame.readPayload(inputStream);
                return webSocketFrame.getOpCode() == OpCode.Close ? new CloseFrame() : webSocketFrame;
            }
        }

        private void readPayload(InputStream inputStream) throws IOException {
            this.payload = new byte[this._payloadLength];
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = this._payloadLength;
                if (i2 >= i3) {
                    break;
                }
                i2 += checkedRead(inputStream.read(this.payload, i2, i3 - i2));
            }
            if (isMasked()) {
                while (true) {
                    byte[] bArr = this.payload;
                    if (i >= bArr.length) {
                        break;
                    }
                    bArr[i] = (byte) (bArr[i] ^ this.maskingKey[i % 4]);
                    i++;
                }
            }
            if (getOpCode() == OpCode.Text) {
                this._payloadString = binary2Text(getBinaryPayload());
            }
        }

        private void readPayloadInfo(InputStream inputStream) throws IOException {
            byte checkedRead = (byte) checkedRead(inputStream.read());
            int i = 0;
            boolean z = (checkedRead & 128) != 0;
            byte b = (byte) (checkedRead & Byte.MAX_VALUE);
            this._payloadLength = b;
            if (b == 126) {
                int checkedRead2 = ((checkedRead(inputStream.read()) << 8) | checkedRead(inputStream.read())) & 65535;
                this._payloadLength = checkedRead2;
                if (checkedRead2 < 126) {
                    throw new WebSocketException(CloseCode.ProtocolError, "Invalid data frame 2byte length. (not using minimal length encoding)");
                }
            } else if (b == Byte.MAX_VALUE) {
                long checkedRead3 = (checkedRead(inputStream.read()) << 56) | (checkedRead(inputStream.read()) << 48) | (checkedRead(inputStream.read()) << 40) | (checkedRead(inputStream.read()) << 32) | (checkedRead(inputStream.read()) << 24) | (checkedRead(inputStream.read()) << 16) | (checkedRead(inputStream.read()) << 8) | checkedRead(inputStream.read());
                if (checkedRead3 < 65536) {
                    throw new WebSocketException(CloseCode.ProtocolError, "Invalid data frame 4byte length. (not using minimal length encoding)");
                }
                if (checkedRead3 < 0 || checkedRead3 > 2147483647L) {
                    throw new WebSocketException(CloseCode.MessageTooBig, "Max frame length has been exceeded.");
                }
                this._payloadLength = (int) checkedRead3;
            }
            if (this.opCode.isControlFrame()) {
                int i2 = this._payloadLength;
                if (i2 > 125) {
                    throw new WebSocketException(CloseCode.ProtocolError, "Control frame with payload length > 125 bytes.");
                }
                if (this.opCode == OpCode.Close && i2 == 1) {
                    throw new WebSocketException(CloseCode.ProtocolError, "Received close frame with payload len 1.");
                }
            }
            if (z) {
                this.maskingKey = new byte[4];
                while (true) {
                    byte[] bArr = this.maskingKey;
                    if (i >= bArr.length) {
                        return;
                    }
                    i += checkedRead(inputStream.read(bArr, i, bArr.length - i));
                }
            }
        }

        public static byte[] text2Binary(String str) throws CharacterCodingException {
            return str.getBytes(TEXT_CHARSET);
        }

        public byte[] getBinaryPayload() {
            return this.payload;
        }

        public byte[] getMaskingKey() {
            return this.maskingKey;
        }

        public OpCode getOpCode() {
            return this.opCode;
        }

        public String getTextPayload() {
            if (this._payloadString == null) {
                try {
                    this._payloadString = binary2Text(getBinaryPayload());
                } catch (CharacterCodingException e) {
                    throw new RuntimeException("Undetected CharacterCodingException", e);
                }
            }
            return this._payloadString;
        }

        public boolean isFin() {
            return this.fin;
        }

        public boolean isMasked() {
            byte[] bArr = this.maskingKey;
            return bArr != null && bArr.length == 4;
        }

        public void setBinaryPayload(byte[] bArr) {
            this.payload = bArr;
            this._payloadLength = bArr.length;
            this._payloadString = null;
        }

        public void setFin(boolean z) {
            this.fin = z;
        }

        public void setMaskingKey(byte[] bArr) {
            if (bArr == null || bArr.length == 4) {
                this.maskingKey = bArr;
                return;
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("MaskingKey ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Arrays.toString(bArr));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" hasn't length 4");
            throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }

        public void setOpCode(OpCode opCode) {
            this.opCode = opCode;
        }

        public void setTextPayload(String str) throws CharacterCodingException {
            this.payload = text2Binary(str);
            this._payloadLength = str.length();
            this._payloadString = str;
        }

        public void setUnmasked() {
            setMaskingKey(null);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("WS[");
            sb.append(getOpCode());
            sb.append(", ");
            sb.append(isFin() ? "fin" : "inter");
            sb.append(", ");
            sb.append(isMasked() ? "masked" : "unmasked");
            sb.append(", ");
            sb.append(payloadToString());
            sb.append(']');
            return sb.toString();
        }

        public void write(OutputStream outputStream) throws IOException {
            int i;
            int i2;
            outputStream.write((byte) ((this.fin ? (byte) 128 : (byte) 0) | (this.opCode.getValue() & 15)));
            int length = getBinaryPayload().length;
            this._payloadLength = length;
            if (length <= 125) {
                i2 = isMasked() ? ((byte) this._payloadLength) | 128 : (byte) this._payloadLength;
            } else {
                if (length <= 65535) {
                    i = isMasked() ? TinkerReport.KEY_LOADED_EXCEPTION_RESOURCE : 126;
                } else {
                    outputStream.write(isMasked() ? 255 : 127);
                    outputStream.write((this._payloadLength >>> 56) & 0);
                    outputStream.write((this._payloadLength >>> 48) & 0);
                    outputStream.write((this._payloadLength >>> 40) & 0);
                    outputStream.write((this._payloadLength >>> 32) & 0);
                    outputStream.write(this._payloadLength >>> 24);
                    i = this._payloadLength >>> 16;
                }
                outputStream.write(i);
                outputStream.write(this._payloadLength >>> 8);
                i2 = this._payloadLength;
            }
            outputStream.write(i2);
            if (isMasked()) {
                outputStream.write(this.maskingKey);
                for (int i3 = 0; i3 < this._payloadLength; i3++) {
                    outputStream.write(getBinaryPayload()[i3] ^ this.maskingKey[i3 % 4]);
                }
            } else {
                outputStream.write(getBinaryPayload());
            }
            outputStream.flush();
        }
    }

    public NanoWSD(int i) {
        super(i);
    }

    public NanoWSD(String str, int i) {
        super(str, i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0062, code lost:
        if (r0 != 2) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String encodeBase64(byte[] bArr) {
        int i;
        byte b;
        byte b2;
        int length = bArr.length;
        char[] cArr = new char[((length + 2) / 3) * 4];
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = i2 + 1;
            byte b3 = bArr[i2];
            if (i4 < length) {
                i = i4 + 1;
                b = bArr[i4];
            } else {
                i = i4;
                b = 0;
            }
            if (i < length) {
                b2 = bArr[i];
                i++;
            } else {
                b2 = 0;
            }
            int i5 = i3 + 1;
            char[] cArr2 = ALPHABET;
            cArr[i3] = cArr2[(b3 >> 2) & 63];
            int i6 = i5 + 1;
            cArr[i5] = cArr2[((b3 << 4) | ((b & 255) >> 4)) & 63];
            int i7 = i6 + 1;
            cArr[i6] = cArr2[((b << 2) | ((b2 & 255) >> 6)) & 63];
            i3 = i7 + 1;
            cArr[i7] = cArr2[b2 & 63];
            i2 = i;
        }
        int i8 = length % 3;
        if (i8 == 1) {
            i3--;
            cArr[i3] = B64Code.__pad;
        }
        cArr[i3 - 1] = B64Code.__pad;
        return new String(cArr);
    }

    private boolean isWebSocketConnectionHeader(Map<String, String> map) {
        String str = map.get("connection");
        return str != null && str.toLowerCase().contains("Upgrade".toLowerCase());
    }

    public static String makeAcceptKey(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "258EAFA5-E914-47DA-95CA-C5AB0DC85B11");
        messageDigest.update(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getBytes(), 0, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length());
        return encodeBase64(messageDigest.digest());
    }

    public boolean isWebsocketRequested(NanoHTTPD.IHTTPSession iHTTPSession) {
        Map<String, String> headers = iHTTPSession.getHeaders();
        return HEADER_UPGRADE_VALUE.equalsIgnoreCase(headers.get("upgrade")) && isWebSocketConnectionHeader(headers);
    }

    public abstract WebSocket openWebSocket(NanoHTTPD.IHTTPSession iHTTPSession);

    @Override // fi.iki.elonen.NanoHTTPD
    public NanoHTTPD.Response serve(NanoHTTPD.IHTTPSession iHTTPSession) {
        NanoHTTPD.Response.Status status;
        String str;
        Map<String, String> headers = iHTTPSession.getHeaders();
        if (isWebsocketRequested(iHTTPSession)) {
            if (!HEADER_WEBSOCKET_VERSION_VALUE.equalsIgnoreCase(headers.get(HEADER_WEBSOCKET_VERSION))) {
                status = NanoHTTPD.Response.Status.BAD_REQUEST;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid Websocket-Version ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(headers.get(HEADER_WEBSOCKET_VERSION));
                str = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            } else if (!headers.containsKey(HEADER_WEBSOCKET_KEY)) {
                status = NanoHTTPD.Response.Status.BAD_REQUEST;
                str = "Missing Websocket-Key";
            } else {
                NanoHTTPD.Response handshakeResponse = openWebSocket(iHTTPSession).getHandshakeResponse();
                try {
                    handshakeResponse.addHeader(HEADER_WEBSOCKET_ACCEPT, makeAcceptKey(headers.get(HEADER_WEBSOCKET_KEY)));
                    if (headers.containsKey(HEADER_WEBSOCKET_PROTOCOL)) {
                        handshakeResponse.addHeader(HEADER_WEBSOCKET_PROTOCOL, headers.get(HEADER_WEBSOCKET_PROTOCOL).split(",")[0]);
                    }
                    return handshakeResponse;
                } catch (NoSuchAlgorithmException unused) {
                    status = NanoHTTPD.Response.Status.INTERNAL_ERROR;
                    str = "The SHA-1 Algorithm required for websockets is not available on the server.";
                }
            }
            return NanoHTTPD.newFixedLengthResponse(status, "text/plain", str);
        }
        return serveHttp(iHTTPSession);
    }

    public NanoHTTPD.Response serveHttp(NanoHTTPD.IHTTPSession iHTTPSession) {
        return super.serve(iHTTPSession);
    }

    @Override // fi.iki.elonen.NanoHTTPD
    public boolean useGzipWhenAccepted(NanoHTTPD.Response response) {
        return false;
    }
}
