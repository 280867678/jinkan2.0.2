package okhttp3.internal.p054ws;

import androidx.core.app.NotificationCompat;
import fi.iki.elonen.NanoWSD;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;
import me.tvspark.nk0;
import me.tvspark.outline;
import me.tvspark.pf0;
import me.tvspark.r40;
import me.tvspark.vw0;
import me.tvspark.ww0;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.RealCall;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.p054ws.RealWebSocket;
import okhttp3.internal.p054ws.WebSocketReader;
import okio.ByteString;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.apache.http.message.TokenParser;
import org.eclipse.jetty.http.HttpHeaderValues;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

@ef0
/* renamed from: okhttp3.internal.ws.RealWebSocket */
/* loaded from: classes4.dex */
public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback {
    public static final long CANCEL_AFTER_CLOSE_MILLIS = 60000;
    public static final long MAX_QUEUE_SIZE = 16777216;
    public boolean awaitingPong;
    public Call call;
    public ScheduledFuture<?> cancelFuture;
    public boolean enqueuedClose;
    public ScheduledExecutorService executor;
    public boolean failed;
    public final String key;
    public final WebSocketListener listener;
    public final Request originalRequest;
    public final long pingIntervalMillis;
    public long queueSize;
    public final Random random;
    public WebSocketReader reader;
    public String receivedCloseReason;
    public int receivedPingCount;
    public int receivedPongCount;
    public int sentPingCount;
    public Streams streams;
    public WebSocketWriter writer;
    public final Runnable writerRunnable;
    public static final Companion Companion = new Companion(null);
    public static final List<Protocol> ONLY_HTTP1 = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Protocol.HTTP_1_1);
    public final ArrayDeque<ByteString> pongQueue = new ArrayDeque<>();
    public final ArrayDeque<Object> messageAndCloseQueue = new ArrayDeque<>();
    public int receivedCloseCode = -1;

    @ef0
    /* renamed from: okhttp3.internal.ws.RealWebSocket$CancelRunnable */
    /* loaded from: classes4.dex */
    public final class CancelRunnable implements Runnable {
        public CancelRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RealWebSocket.this.cancel();
        }
    }

    @ef0
    /* renamed from: okhttp3.internal.ws.RealWebSocket$Close */
    /* loaded from: classes4.dex */
    public static final class Close {
        public final long cancelAfterCloseMillis;
        public final int code;
        public final ByteString reason;

        public Close(int i, ByteString byteString, long j) {
            this.code = i;
            this.reason = byteString;
            this.cancelAfterCloseMillis = j;
        }

        public final long getCancelAfterCloseMillis() {
            return this.cancelAfterCloseMillis;
        }

        public final int getCode() {
            return this.code;
        }

        public final ByteString getReason() {
            return this.reason;
        }
    }

    @ef0
    /* renamed from: okhttp3.internal.ws.RealWebSocket$Companion */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(gi0 gi0Var) {
            this();
        }
    }

    @ef0
    /* renamed from: okhttp3.internal.ws.RealWebSocket$Message */
    /* loaded from: classes4.dex */
    public static final class Message {
        public final ByteString data;
        public final int formatOpcode;

        public Message(int i, ByteString byteString) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "data");
            this.formatOpcode = i;
            this.data = byteString;
        }

        public final ByteString getData() {
            return this.data;
        }

        public final int getFormatOpcode() {
            return this.formatOpcode;
        }
    }

    @ef0
    /* renamed from: okhttp3.internal.ws.RealWebSocket$PingRunnable */
    /* loaded from: classes4.dex */
    public final class PingRunnable implements Runnable {
        public PingRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RealWebSocket.this.writePingFrame$okhttp();
        }
    }

    @ef0
    /* renamed from: okhttp3.internal.ws.RealWebSocket$Streams */
    /* loaded from: classes4.dex */
    public static abstract class Streams implements Closeable {
        public final boolean client;
        public final vw0 sink;
        public final ww0 source;

        public Streams(boolean z, ww0 ww0Var, vw0 vw0Var) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ww0Var, "source");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(vw0Var, "sink");
            this.client = z;
            this.source = ww0Var;
            this.sink = vw0Var;
        }

        public final boolean getClient() {
            return this.client;
        }

        public final vw0 getSink() {
            return this.sink;
        }

        public final ww0 getSource() {
            return this.source;
        }
    }

    public RealWebSocket(Request request, WebSocketListener webSocketListener, Random random, long j) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(request, "originalRequest");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(webSocketListener, "listener");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(random, "random");
        this.originalRequest = request;
        this.listener = webSocketListener;
        this.random = random;
        this.pingIntervalMillis = j;
        if (!ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) "GET", (Object) this.originalRequest.method())) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Request must be GET: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.originalRequest.method());
            throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString().toString());
        }
        ByteString.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ByteString.Companion;
        byte[] bArr = new byte[16];
        this.random.nextBytes(bArr);
        this.key = ByteString.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr, 0, 0, 3).base64();
        this.writerRunnable = new Runnable() { // from class: okhttp3.internal.ws.RealWebSocket.3
            @Override // java.lang.Runnable
            public final void run() {
                do {
                    try {
                    } catch (IOException e) {
                        RealWebSocket.this.failWebSocket(e, null);
                        return;
                    }
                } while (RealWebSocket.this.writeOneFrame$okhttp());
            }
        };
    }

    private final void runWriter() {
        boolean holdsLock = Thread.holdsLock(this);
        if (!pf0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || holdsLock) {
            ScheduledExecutorService scheduledExecutorService = this.executor;
            if (scheduledExecutorService == null) {
                return;
            }
            scheduledExecutorService.execute(this.writerRunnable);
            return;
        }
        throw new AssertionError("Assertion failed");
    }

    private final synchronized boolean send(ByteString byteString, int i) {
        if (!this.failed && !this.enqueuedClose) {
            if (this.queueSize + byteString.size() > MAX_QUEUE_SIZE) {
                close(1001, null);
                return false;
            }
            this.queueSize += byteString.size();
            this.messageAndCloseQueue.add(new Message(i, byteString));
            runWriter();
            return true;
        }
        return false;
    }

    public final void awaitTermination(int i, TimeUnit timeUnit) throws InterruptedException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(timeUnit, "timeUnit");
        ScheduledExecutorService scheduledExecutorService = this.executor;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.awaitTermination(i, timeUnit);
        } else {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
    }

    @Override // okhttp3.WebSocket
    public void cancel() {
        Call call = this.call;
        if (call != null) {
            call.cancel();
        } else {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
    }

    public final void checkUpgradeSuccess$okhttp(Response response, Exchange exchange) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(response, "response");
        if (response.code() != 101) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Expected HTTP 101 response but was '");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(response.code());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(TokenParser.f4579SP);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(response.message());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(ExtendedMessageFormat.QUOTE);
            throw new ProtocolException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        String header$default = Response.header$default(response, "Connection", null, 2, null);
        if (!nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Upgrade", header$default, true)) {
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + header$default + ExtendedMessageFormat.QUOTE);
        }
        String header$default2 = Response.header$default(response, "Upgrade", null, 2, null);
        if (!nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(NanoWSD.HEADER_UPGRADE_VALUE, header$default2, true)) {
            throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + header$default2 + ExtendedMessageFormat.QUOTE);
        }
        String header$default3 = Response.header$default(response, "Sec-WebSocket-Accept", null, 2, null);
        ByteString.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ByteString.Companion;
        String base64 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.key + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").sha1().base64();
        if (!(!ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) base64, (Object) header$default3))) {
            if (exchange == null) {
                throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
            }
            return;
        }
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + base64 + "' but was '" + header$default3 + ExtendedMessageFormat.QUOTE);
    }

    @Override // okhttp3.WebSocket
    public boolean close(int i, String str) {
        return close(i, str, 60000L);
    }

    public final synchronized boolean close(int i, String str, long j) {
        WebSocketProtocol.INSTANCE.validateCloseCode(i);
        ByteString byteString = null;
        if (str != null) {
            byteString = ByteString.Companion.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
            if (!(((long) byteString.size()) <= 123)) {
                throw new IllegalArgumentException(("reason.size() > 123: " + str).toString());
            }
        }
        if (!this.failed && !this.enqueuedClose) {
            this.enqueuedClose = true;
            this.messageAndCloseQueue.add(new Close(i, byteString, j));
            runWriter();
            return true;
        }
        return false;
    }

    public final void connect(OkHttpClient okHttpClient) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(okHttpClient, "client");
        OkHttpClient build = okHttpClient.newBuilder().eventListener(EventListener.NONE).protocols(ONLY_HTTP1).build();
        final Request build2 = this.originalRequest.newBuilder().header("Upgrade", NanoWSD.HEADER_UPGRADE_VALUE).header("Connection", "Upgrade").header("Sec-WebSocket-Key", this.key).header("Sec-WebSocket-Version", NanoWSD.HEADER_WEBSOCKET_VERSION_VALUE).build();
        RealCall newRealCall = RealCall.Companion.newRealCall(build, build2, true);
        this.call = newRealCall;
        if (newRealCall != null) {
            newRealCall.enqueue(new Callback() { // from class: okhttp3.internal.ws.RealWebSocket$connect$1
                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, NotificationCompat.CATEGORY_CALL);
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iOException, "e");
                    RealWebSocket.this.failWebSocket(iOException, null);
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, NotificationCompat.CATEGORY_CALL);
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(response, "response");
                    Exchange exchange = response.exchange();
                    try {
                        RealWebSocket.this.checkUpgradeSuccess$okhttp(response, exchange);
                        RealWebSocket.Streams newWebSocketStreams = exchange.newWebSocketStreams();
                        try {
                            RealWebSocket.this.initReaderAndWriter("OkHttp WebSocket " + build2.url().redact(), newWebSocketStreams);
                            RealWebSocket.this.getListener$okhttp().onOpen(RealWebSocket.this, response);
                            RealWebSocket.this.loopReader();
                        } catch (Exception e) {
                            RealWebSocket.this.failWebSocket(e, null);
                        }
                    } catch (IOException e2) {
                        if (exchange != null) {
                            exchange.webSocketUpgradeFailed();
                        }
                        RealWebSocket.this.failWebSocket(e2, response);
                        Util.closeQuietly(response);
                    }
                }
            });
        } else {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
    }

    public final void failWebSocket(Exception exc, Response response) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(exc, "e");
        synchronized (this) {
            if (this.failed) {
                return;
            }
            this.failed = true;
            Streams streams = this.streams;
            this.streams = null;
            ScheduledFuture<?> scheduledFuture = this.cancelFuture;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            ScheduledExecutorService scheduledExecutorService = this.executor;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdown();
            }
            try {
                this.listener.onFailure(this, exc, response);
            } finally {
                if (streams != null) {
                    Util.closeQuietly(streams);
                }
            }
        }
    }

    public final WebSocketListener getListener$okhttp() {
        return this.listener;
    }

    public final void initReaderAndWriter(String str, Streams streams) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "name");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(streams, IjkMediaMeta.IJKM_KEY_STREAMS);
        synchronized (this) {
            this.streams = streams;
            this.writer = new WebSocketWriter(streams.getClient(), streams.getSink(), this.random);
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, Util.threadFactory(str, false));
            this.executor = scheduledThreadPoolExecutor;
            if (this.pingIntervalMillis != 0) {
                if (scheduledThreadPoolExecutor == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
                scheduledThreadPoolExecutor.scheduleAtFixedRate(new PingRunnable(), this.pingIntervalMillis, this.pingIntervalMillis, TimeUnit.MILLISECONDS);
            }
            if (!this.messageAndCloseQueue.isEmpty()) {
                runWriter();
            }
        }
        this.reader = new WebSocketReader(streams.getClient(), streams.getSource(), this);
    }

    public final void loopReader() throws IOException {
        while (this.receivedCloseCode == -1) {
            WebSocketReader webSocketReader = this.reader;
            if (webSocketReader == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            webSocketReader.processNextFrame();
        }
    }

    @Override // okhttp3.internal.p054ws.WebSocketReader.FrameCallback
    public void onReadClose(int i, String str) {
        Streams streams;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "reason");
        boolean z = true;
        if (i != -1) {
            synchronized (this) {
                if (this.receivedCloseCode != -1) {
                    z = false;
                }
                if (!z) {
                    throw new IllegalStateException("already closed".toString());
                }
                this.receivedCloseCode = i;
                this.receivedCloseReason = str;
                streams = null;
                if (this.enqueuedClose && this.messageAndCloseQueue.isEmpty()) {
                    Streams streams2 = this.streams;
                    this.streams = null;
                    if (this.cancelFuture != null) {
                        ScheduledFuture<?> scheduledFuture = this.cancelFuture;
                        if (scheduledFuture == null) {
                            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            throw null;
                        }
                        scheduledFuture.cancel(false);
                    }
                    ScheduledExecutorService scheduledExecutorService = this.executor;
                    if (scheduledExecutorService == null) {
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        throw null;
                    } else {
                        scheduledExecutorService.shutdown();
                        streams = streams2;
                    }
                }
            }
            try {
                this.listener.onClosing(this, i, str);
                if (streams != null) {
                    this.listener.onClosed(this, i, str);
                }
                if (streams == null) {
                    return;
                }
                return;
            } finally {
                if (streams != null) {
                    Util.closeQuietly(streams);
                }
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // okhttp3.internal.p054ws.WebSocketReader.FrameCallback
    public void onReadMessage(String str) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "text");
        this.listener.onMessage(this, str);
    }

    @Override // okhttp3.internal.p054ws.WebSocketReader.FrameCallback
    public void onReadMessage(ByteString byteString) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, HttpHeaderValues.BYTES);
        this.listener.onMessage(this, byteString);
    }

    @Override // okhttp3.internal.p054ws.WebSocketReader.FrameCallback
    public synchronized void onReadPing(ByteString byteString) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "payload");
        if (!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
            this.pongQueue.add(byteString);
            runWriter();
            this.receivedPingCount++;
        }
    }

    @Override // okhttp3.internal.p054ws.WebSocketReader.FrameCallback
    public synchronized void onReadPong(ByteString byteString) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "payload");
        this.receivedPongCount++;
        this.awaitingPong = false;
    }

    public final synchronized boolean pong(ByteString byteString) {
        boolean z;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "payload");
        if (!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
            this.pongQueue.add(byteString);
            runWriter();
            z = true;
        }
        z = false;
        return z;
    }

    public final boolean processNextFrame() throws IOException {
        try {
            WebSocketReader webSocketReader = this.reader;
            if (webSocketReader != null) {
                webSocketReader.processNextFrame();
                return this.receivedCloseCode == -1;
            }
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        } catch (Exception e) {
            failWebSocket(e, null);
            return false;
        }
    }

    @Override // okhttp3.WebSocket
    public synchronized long queueSize() {
        return this.queueSize;
    }

    public final synchronized int receivedPingCount() {
        return this.receivedPingCount;
    }

    public final synchronized int receivedPongCount() {
        return this.receivedPongCount;
    }

    @Override // okhttp3.WebSocket
    public Request request() {
        return this.originalRequest;
    }

    @Override // okhttp3.WebSocket
    public boolean send(String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "text");
        return send(ByteString.Companion.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str), 1);
    }

    @Override // okhttp3.WebSocket
    public boolean send(ByteString byteString) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, HttpHeaderValues.BYTES);
        return send(byteString, 2);
    }

    public final synchronized int sentPingCount() {
        return this.sentPingCount;
    }

    public final void tearDown() throws InterruptedException {
        ScheduledFuture<?> scheduledFuture = this.cancelFuture;
        if (scheduledFuture != null) {
            if (scheduledFuture == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            scheduledFuture.cancel(false);
        }
        ScheduledExecutorService scheduledExecutorService = this.executor;
        if (scheduledExecutorService == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        scheduledExecutorService.shutdown();
        ScheduledExecutorService scheduledExecutorService2 = this.executor;
        if (scheduledExecutorService2 != null) {
            scheduledExecutorService2.awaitTermination(10L, TimeUnit.SECONDS);
        } else {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ca A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006c A[Catch: all -> 0x00d8, TRY_ENTER, TryCatch #3 {all -> 0x00d8, blocks: (B:22:0x0064, B:27:0x0068, B:29:0x006c, B:31:0x0070, B:33:0x0079, B:34:0x0092, B:36:0x009d, B:38:0x00a2, B:40:0x00a6, B:42:0x00aa, B:44:0x00ae, B:46:0x00bb, B:48:0x00bf, B:49:0x00c3, B:51:0x00ce, B:53:0x00d2, B:54:0x00d7, B:35:0x0093), top: B:19:0x0060 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean writeOneFrame$okhttp() throws IOException {
        Streams streams;
        Object obj;
        String str;
        int i;
        synchronized (this) {
            if (this.failed) {
                return false;
            }
            WebSocketWriter webSocketWriter = this.writer;
            ByteString poll = this.pongQueue.poll();
            try {
                if (poll == null) {
                    obj = this.messageAndCloseQueue.poll();
                    if (obj instanceof Close) {
                        i = this.receivedCloseCode;
                        str = this.receivedCloseReason;
                        if (i != -1) {
                            streams = this.streams;
                            this.streams = null;
                            ScheduledExecutorService scheduledExecutorService = this.executor;
                            if (scheduledExecutorService == null) {
                                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                throw null;
                            }
                            scheduledExecutorService.shutdown();
                        } else {
                            ScheduledExecutorService scheduledExecutorService2 = this.executor;
                            if (scheduledExecutorService2 == null) {
                                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                throw null;
                            }
                            this.cancelFuture = scheduledExecutorService2.schedule(new CancelRunnable(), ((Close) obj).getCancelAfterCloseMillis(), TimeUnit.MILLISECONDS);
                            streams = null;
                        }
                        if (poll == null) {
                            if (webSocketWriter == null) {
                                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                throw null;
                            }
                            webSocketWriter.writePong(poll);
                        } else if (obj instanceof Message) {
                            ByteString data = ((Message) obj).getData();
                            if (webSocketWriter == null) {
                                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                throw null;
                            }
                            vw0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(webSocketWriter.newMessageSink(((Message) obj).getFormatOpcode(), data.size()));
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.mo4959Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(data);
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.close();
                            synchronized (this) {
                                this.queueSize -= data.size();
                            }
                        } else if (!(obj instanceof Close)) {
                            throw new AssertionError();
                        } else {
                            Close close = (Close) obj;
                            if (webSocketWriter == null) {
                                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                throw null;
                            }
                            webSocketWriter.writeClose(close.getCode(), close.getReason());
                            if (streams != null) {
                                WebSocketListener webSocketListener = this.listener;
                                if (str == null) {
                                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                    throw null;
                                }
                                webSocketListener.onClosed(this, i, str);
                            }
                        }
                        return true;
                    } else if (obj == null) {
                        return false;
                    } else {
                        streams = null;
                        str = null;
                    }
                } else {
                    streams = null;
                    obj = null;
                    str = null;
                }
                if (poll == null) {
                }
                return true;
            } finally {
                if (streams != null) {
                    Util.closeQuietly(streams);
                }
            }
            i = -1;
        }
    }

    public final void writePingFrame$okhttp() {
        synchronized (this) {
            if (this.failed) {
                return;
            }
            WebSocketWriter webSocketWriter = this.writer;
            int i = this.awaitingPong ? this.sentPingCount : -1;
            this.sentPingCount++;
            this.awaitingPong = true;
            if (i != -1) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("sent ping but didn't receive pong within ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.pingIntervalMillis);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("ms (after ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(i - 1);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" successful ping/pongs)");
                failWebSocket(new SocketTimeoutException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString()), null);
                return;
            }
            try {
                if (webSocketWriter != null) {
                    webSocketWriter.writePing(ByteString.EMPTY);
                } else {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
            } catch (IOException e) {
                failWebSocket(e, null);
            }
        }
    }
}
