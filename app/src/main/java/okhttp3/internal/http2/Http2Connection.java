package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;
import me.tvspark.outline;
import me.tvspark.pf0;
import me.tvspark.r40;
import me.tvspark.uw0;
import me.tvspark.vw0;
import me.tvspark.ww0;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Http2Reader;
import okhttp3.internal.platform.Platform;
import okio.ByteString;

@ef0
/* loaded from: classes4.dex */
public final class Http2Connection implements Closeable {
    public static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
    public boolean awaitingPong;
    public long bytesLeftInWriteWindow;
    public final boolean client;
    public final String connectionName;
    public final Set<Integer> currentPushRequests;
    public boolean isShutdown;
    public int lastGoodStreamId;
    public final Listener listener;
    public int nextStreamId;
    public final Settings okHttpSettings;
    public final Settings peerSettings;
    public final ThreadPoolExecutor pushExecutor;
    public final PushObserver pushObserver;
    public final ReaderRunnable readerRunnable;
    public boolean receivedInitialPeerSettings;
    public final Socket socket;
    public final Map<Integer, Http2Stream> streams = new LinkedHashMap();
    public long unacknowledgedBytesRead;
    public final Http2Writer writer;
    public final ScheduledThreadPoolExecutor writerExecutor;
    public static final Companion Companion = new Companion(null);
    public static final ThreadPoolExecutor listenerExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Http2Connection", true));

    @ef0
    /* loaded from: classes4.dex */
    public static final class Builder {
        public boolean client;
        public String connectionName;
        public int pingIntervalMillis;
        public vw0 sink;
        public Socket socket;
        public ww0 source;
        public Listener listener = Listener.REFUSE_INCOMING_STREAMS;
        public PushObserver pushObserver = PushObserver.CANCEL;

        public Builder(boolean z) {
            this.client = z;
        }

        public static /* synthetic */ Builder socket$default(Builder builder, Socket socket, String str, ww0 ww0Var, vw0 vw0Var, int i, Object obj) throws IOException {
            if ((i & 2) != 0) {
                str = Util.connectionName(socket);
            }
            if ((i & 4) != 0) {
                ww0Var = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(socket));
            }
            if ((i & 8) != 0) {
                vw0Var = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(socket));
            }
            return builder.socket(socket, str, ww0Var, vw0Var);
        }

        public final Http2Connection build() {
            return new Http2Connection(this);
        }

        public final boolean getClient$okhttp() {
            return this.client;
        }

        public final String getConnectionName$okhttp() {
            String str = this.connectionName;
            if (str != null) {
                return str;
            }
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("connectionName");
            throw null;
        }

        public final Listener getListener$okhttp() {
            return this.listener;
        }

        public final int getPingIntervalMillis$okhttp() {
            return this.pingIntervalMillis;
        }

        public final PushObserver getPushObserver$okhttp() {
            return this.pushObserver;
        }

        public final vw0 getSink$okhttp() {
            vw0 vw0Var = this.sink;
            if (vw0Var != null) {
                return vw0Var;
            }
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("sink");
            throw null;
        }

        public final Socket getSocket$okhttp() {
            Socket socket = this.socket;
            if (socket != null) {
                return socket;
            }
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("socket");
            throw null;
        }

        public final ww0 getSource$okhttp() {
            ww0 ww0Var = this.source;
            if (ww0Var != null) {
                return ww0Var;
            }
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("source");
            throw null;
        }

        public final Builder listener(Listener listener) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(listener, "listener");
            this.listener = listener;
            return this;
        }

        public final Builder pingIntervalMillis(int i) {
            this.pingIntervalMillis = i;
            return this;
        }

        public final Builder pushObserver(PushObserver pushObserver) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(pushObserver, "pushObserver");
            this.pushObserver = pushObserver;
            return this;
        }

        public final void setClient$okhttp(boolean z) {
            this.client = z;
        }

        public final void setConnectionName$okhttp(String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "<set-?>");
            this.connectionName = str;
        }

        public final void setListener$okhttp(Listener listener) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(listener, "<set-?>");
            this.listener = listener;
        }

        public final void setPingIntervalMillis$okhttp(int i) {
            this.pingIntervalMillis = i;
        }

        public final void setPushObserver$okhttp(PushObserver pushObserver) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(pushObserver, "<set-?>");
            this.pushObserver = pushObserver;
        }

        public final void setSink$okhttp(vw0 vw0Var) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(vw0Var, "<set-?>");
            this.sink = vw0Var;
        }

        public final void setSocket$okhttp(Socket socket) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(socket, "<set-?>");
            this.socket = socket;
        }

        public final void setSource$okhttp(ww0 ww0Var) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ww0Var, "<set-?>");
            this.source = ww0Var;
        }

        public final Builder socket(Socket socket) throws IOException {
            return socket$default(this, socket, null, null, null, 14, null);
        }

        public final Builder socket(Socket socket, String str) throws IOException {
            return socket$default(this, socket, str, null, null, 12, null);
        }

        public final Builder socket(Socket socket, String str, ww0 ww0Var) throws IOException {
            return socket$default(this, socket, str, ww0Var, null, 8, null);
        }

        public final Builder socket(Socket socket, String str, ww0 ww0Var, vw0 vw0Var) throws IOException {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(socket, "socket");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "connectionName");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ww0Var, "source");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(vw0Var, "sink");
            this.socket = socket;
            this.connectionName = str;
            this.source = ww0Var;
            this.sink = vw0Var;
            return this;
        }
    }

    @ef0
    /* loaded from: classes4.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(gi0 gi0Var) {
            this();
        }
    }

    @ef0
    /* loaded from: classes4.dex */
    public static abstract class Listener {
        public static final Companion Companion = new Companion(null);
        public static final Listener REFUSE_INCOMING_STREAMS = new Listener() { // from class: okhttp3.internal.http2.Http2Connection$Listener$Companion$REFUSE_INCOMING_STREAMS$1
            @Override // okhttp3.internal.http2.Http2Connection.Listener
            public void onStream(Http2Stream http2Stream) throws IOException {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(http2Stream, "stream");
                http2Stream.close(ErrorCode.REFUSED_STREAM, null);
            }
        };

        @ef0
        /* loaded from: classes4.dex */
        public static final class Companion {
            public Companion() {
            }

            public /* synthetic */ Companion(gi0 gi0Var) {
                this();
            }
        }

        public void onSettings(Http2Connection http2Connection) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(http2Connection, "connection");
        }

        public abstract void onStream(Http2Stream http2Stream) throws IOException;
    }

    @ef0
    /* loaded from: classes4.dex */
    public final class ReaderRunnable implements Runnable, Http2Reader.Handler {
        public final Http2Reader reader;
        public final /* synthetic */ Http2Connection this$0;

        public ReaderRunnable(Http2Connection http2Connection, Http2Reader http2Reader) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(http2Reader, "reader");
            this.this$0 = http2Connection;
            this.reader = http2Reader;
        }

        private final void applyAndAckSettings(final Settings settings) {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.this$0.writerExecutor;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("OkHttp ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.this$0.getConnectionName$okhttp());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" ACK Settings");
            final String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            try {
                scheduledThreadPoolExecutor.execute(new Runnable() { // from class: okhttp3.internal.http2.Http2Connection$ReaderRunnable$applyAndAckSettings$$inlined$tryExecute$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        String str = sb;
                        Thread currentThread = Thread.currentThread();
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) currentThread, "currentThread");
                        String name = currentThread.getName();
                        currentThread.setName(str);
                        try {
                            try {
                                this.this$0.getWriter().applyAndAckSettings(settings);
                            } catch (IOException e) {
                                this.this$0.failConnection(e);
                            }
                        } finally {
                            currentThread.setName(name);
                        }
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ackSettings() {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void alternateService(int i, String str, ByteString byteString, String str2, int i2, long j) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "origin");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "protocol");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, Http2ExchangeCodec.HOST);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void data(boolean z, int i, ww0 ww0Var, int i2) throws IOException {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ww0Var, "source");
            if (this.this$0.pushedStream$okhttp(i)) {
                this.this$0.pushDataLater$okhttp(i, ww0Var, i2, z);
                return;
            }
            Http2Stream stream = this.this$0.getStream(i);
            if (stream == null) {
                this.this$0.writeSynResetLater$okhttp(i, ErrorCode.PROTOCOL_ERROR);
                long j = i2;
                this.this$0.updateConnectionFlowControl$okhttp(j);
                ww0Var.skip(j);
                return;
            }
            stream.receiveData(ww0Var, i2);
            if (!z) {
                return;
            }
            stream.receiveHeaders(Util.EMPTY_HEADERS, true);
        }

        public final Http2Reader getReader$okhttp() {
            return this.reader;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void goAway(int i, ErrorCode errorCode, ByteString byteString) {
            int i2;
            Http2Stream[] http2StreamArr;
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(errorCode, "errorCode");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteString, "debugData");
            byteString.size();
            synchronized (this.this$0) {
                Collection<Http2Stream> values = this.this$0.getStreams$okhttp().values();
                if (values == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
                }
                Object[] array = values.toArray(new Http2Stream[0]);
                if (array == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                http2StreamArr = (Http2Stream[]) array;
                this.this$0.setShutdown$okhttp(true);
            }
            for (Http2Stream http2Stream : http2StreamArr) {
                if (http2Stream.getId() > i && http2Stream.isLocallyInitiated()) {
                    http2Stream.receiveRstStream(ErrorCode.REFUSED_STREAM);
                    this.this$0.removeStream$okhttp(http2Stream.getId());
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void headers(final boolean z, final int i, int i2, final List<Header> list) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "headerBlock");
            if (this.this$0.pushedStream$okhttp(i)) {
                this.this$0.pushHeadersLater$okhttp(i, list, z);
                return;
            }
            synchronized (this.this$0) {
                final Http2Stream stream = this.this$0.getStream(i);
                if (stream != null) {
                    stream.receiveHeaders(Util.toHeaders(list), z);
                } else if (this.this$0.isShutdown()) {
                } else {
                    if (i <= this.this$0.getLastGoodStreamId$okhttp()) {
                        return;
                    }
                    if (i % 2 == this.this$0.getNextStreamId$okhttp() % 2) {
                        return;
                    }
                    final Http2Stream http2Stream = new Http2Stream(i, this.this$0, false, z, Util.toHeaders(list));
                    this.this$0.setLastGoodStreamId$okhttp(i);
                    this.this$0.getStreams$okhttp().put(Integer.valueOf(i), http2Stream);
                    final String str = "OkHttp " + this.this$0.getConnectionName$okhttp() + " stream " + i;
                    Http2Connection.listenerExecutor.execute(new Runnable() { // from class: okhttp3.internal.http2.Http2Connection$ReaderRunnable$headers$$inlined$synchronized$lambda$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            String str2 = str;
                            Thread currentThread = Thread.currentThread();
                            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) currentThread, "currentThread");
                            String name = currentThread.getName();
                            currentThread.setName(str2);
                            try {
                                try {
                                    this.this$0.getListener$okhttp().onStream(http2Stream);
                                } catch (IOException e) {
                                    Platform platform = Platform.Companion.get();
                                    platform.log(4, "Http2Connection.Listener failure for " + this.this$0.getConnectionName$okhttp(), e);
                                    try {
                                        http2Stream.close(ErrorCode.PROTOCOL_ERROR, e);
                                    } catch (IOException unused) {
                                    }
                                }
                            } finally {
                                currentThread.setName(name);
                            }
                        }
                    });
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ping(boolean z, final int i, final int i2) {
            if (z) {
                synchronized (this.this$0) {
                    this.this$0.awaitingPong = false;
                    Http2Connection http2Connection = this.this$0;
                    if (http2Connection == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
                    }
                    http2Connection.notifyAll();
                }
                return;
            }
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.this$0.writerExecutor;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("OkHttp ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.this$0.getConnectionName$okhttp());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" ping");
            final String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            try {
                scheduledThreadPoolExecutor.execute(new Runnable() { // from class: okhttp3.internal.http2.Http2Connection$ReaderRunnable$ping$$inlined$tryExecute$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        String str = sb;
                        Thread currentThread = Thread.currentThread();
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) currentThread, "currentThread");
                        String name = currentThread.getName();
                        currentThread.setName(str);
                        try {
                            this.this$0.writePing(true, i, i2);
                        } finally {
                            currentThread.setName(name);
                        }
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void priority(int i, int i2, int i3, boolean z) {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void pushPromise(int i, int i2, List<Header> list) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "requestHeaders");
            this.this$0.pushRequestLater$okhttp(i2, list);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void rstStream(int i, ErrorCode errorCode) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(errorCode, "errorCode");
            if (this.this$0.pushedStream$okhttp(i)) {
                this.this$0.pushResetLater$okhttp(i, errorCode);
                return;
            }
            Http2Stream removeStream$okhttp = this.this$0.removeStream$okhttp(i);
            if (removeStream$okhttp == null) {
                return;
            }
            removeStream$okhttp.receiveRstStream(errorCode);
        }

        @Override // java.lang.Runnable
        public void run() {
            ErrorCode errorCode;
            ErrorCode errorCode2;
            ErrorCode errorCode3 = ErrorCode.INTERNAL_ERROR;
            IOException e = null;
            try {
                this.reader.readConnectionPreface(this);
                while (this.reader.nextFrame(false, this)) {
                }
                errorCode = ErrorCode.NO_ERROR;
                try {
                    try {
                        errorCode2 = ErrorCode.CANCEL;
                    } catch (IOException e2) {
                        e = e2;
                        errorCode = ErrorCode.PROTOCOL_ERROR;
                        errorCode2 = ErrorCode.PROTOCOL_ERROR;
                        this.this$0.close$okhttp(errorCode, errorCode2, e);
                        Util.closeQuietly(this.reader);
                    }
                } catch (Throwable th) {
                    th = th;
                    this.this$0.close$okhttp(errorCode, errorCode3, e);
                    Util.closeQuietly(this.reader);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
            } catch (Throwable th2) {
                th = th2;
                errorCode = errorCode3;
                this.this$0.close$okhttp(errorCode, errorCode3, e);
                Util.closeQuietly(this.reader);
                throw th;
            }
            this.this$0.close$okhttp(errorCode, errorCode2, e);
            Util.closeQuietly(this.reader);
        }

        /* JADX WARN: Type inference failed for: r1v23, types: [T, okhttp3.internal.http2.Http2Stream[]] */
        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void settings(final boolean z, final Settings settings) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(settings, "settings");
            final Ref$LongRef ref$LongRef = new Ref$LongRef();
            ref$LongRef.element = 0L;
            final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            synchronized (this.this$0) {
                int initialWindowSize = this.this$0.getPeerSettings().getInitialWindowSize();
                if (z) {
                    this.this$0.getPeerSettings().clear();
                }
                this.this$0.getPeerSettings().merge(settings);
                applyAndAckSettings(settings);
                int initialWindowSize2 = this.this$0.getPeerSettings().getInitialWindowSize();
                if (initialWindowSize2 != -1 && initialWindowSize2 != initialWindowSize) {
                    ref$LongRef.element = initialWindowSize2 - initialWindowSize;
                    if (!this.this$0.getReceivedInitialPeerSettings$okhttp()) {
                        this.this$0.setReceivedInitialPeerSettings$okhttp(true);
                    }
                    if (!this.this$0.getStreams$okhttp().isEmpty()) {
                        Collection<Http2Stream> values = this.this$0.getStreams$okhttp().values();
                        if (values == null) {
                            throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
                        }
                        Object[] array = values.toArray(new Http2Stream[0]);
                        if (array == null) {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                        ref$ObjectRef.element = (Http2Stream[]) array;
                    }
                }
                final String str = "OkHttp " + this.this$0.getConnectionName$okhttp() + " settings";
                Http2Connection.listenerExecutor.execute(new Runnable() { // from class: okhttp3.internal.http2.Http2Connection$ReaderRunnable$settings$$inlined$synchronized$lambda$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        String str2 = str;
                        Thread currentThread = Thread.currentThread();
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) currentThread, "currentThread");
                        String name = currentThread.getName();
                        currentThread.setName(str2);
                        try {
                            this.this$0.getListener$okhttp().onSettings(this.this$0);
                        } finally {
                            currentThread.setName(name);
                        }
                    }
                });
            }
            T t = ref$ObjectRef.element;
            if (((Http2Stream[]) t) == null || ref$LongRef.element == 0) {
                return;
            }
            Http2Stream[] http2StreamArr = (Http2Stream[]) t;
            if (http2StreamArr == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            for (Http2Stream http2Stream : http2StreamArr) {
                synchronized (http2Stream) {
                    http2Stream.addBytesToWriteWindow(ref$LongRef.element);
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void windowUpdate(int i, long j) {
            Object obj;
            if (i == 0) {
                Object obj2 = this.this$0;
                synchronized (obj2) {
                    Http2Connection http2Connection = this.this$0;
                    http2Connection.setBytesLeftInWriteWindow$okhttp(http2Connection.getBytesLeftInWriteWindow() + j);
                    Http2Connection http2Connection2 = this.this$0;
                    if (http2Connection2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
                    }
                    http2Connection2.notifyAll();
                    obj = obj2;
                }
            } else {
                Http2Stream stream = this.this$0.getStream(i);
                if (stream == null) {
                    return;
                }
                synchronized (stream) {
                    stream.addBytesToWriteWindow(j);
                    obj = stream;
                }
            }
        }
    }

    public Http2Connection(Builder builder) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(builder, "builder");
        this.client = builder.getClient$okhttp();
        this.listener = builder.getListener$okhttp();
        this.connectionName = builder.getConnectionName$okhttp();
        this.nextStreamId = builder.getClient$okhttp() ? 3 : 2;
        this.writerExecutor = new ScheduledThreadPoolExecutor(1, Util.threadFactory(Util.format("OkHttp %s Writer", this.connectionName), false));
        this.pushExecutor = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory(Util.format("OkHttp %s Push Observer", this.connectionName), true));
        this.pushObserver = builder.getPushObserver$okhttp();
        Settings settings = new Settings();
        if (builder.getClient$okhttp()) {
            settings.set(7, 16777216);
        }
        this.okHttpSettings = settings;
        Settings settings2 = new Settings();
        settings2.set(7, 65535);
        settings2.set(5, 16384);
        this.peerSettings = settings2;
        this.bytesLeftInWriteWindow = settings2.getInitialWindowSize();
        this.socket = builder.getSocket$okhttp();
        this.writer = new Http2Writer(builder.getSink$okhttp(), this.client);
        this.readerRunnable = new ReaderRunnable(this, new Http2Reader(builder.getSource$okhttp(), this.client));
        this.currentPushRequests = new LinkedHashSet();
        if (builder.getPingIntervalMillis$okhttp() != 0) {
            this.writerExecutor.scheduleAtFixedRate(new Runnable() { // from class: okhttp3.internal.http2.Http2Connection.1
                {
                    Http2Connection.this = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("OkHttp ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Http2Connection.this.getConnectionName$okhttp());
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" ping");
                    String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
                    Thread currentThread = Thread.currentThread();
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) currentThread, "currentThread");
                    String name = currentThread.getName();
                    currentThread.setName(sb);
                    try {
                        Http2Connection.this.writePing(false, 0, 0);
                    } finally {
                        currentThread.setName(name);
                    }
                }
            }, builder.getPingIntervalMillis$okhttp(), builder.getPingIntervalMillis$okhttp(), TimeUnit.MILLISECONDS);
        }
    }

    public final void failConnection(IOException iOException) {
        ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
        close$okhttp(errorCode, errorCode, iOException);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0046 A[Catch: all -> 0x007d, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0006, B:21:0x004f, B:23:0x0052, B:29:0x0058, B:31:0x005d, B:32:0x006b, B:33:0x0076, B:5:0x0007, B:7:0x000e, B:8:0x0013, B:10:0x0017, B:12:0x002c, B:14:0x0034, B:18:0x0040, B:20:0x0046, B:35:0x0077, B:36:0x007c), top: B:3:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Http2Stream newStream(int i, List<Header> list, boolean z) throws IOException {
        int i2;
        Http2Stream http2Stream;
        boolean z2;
        boolean z3 = !z;
        synchronized (this.writer) {
            synchronized (this) {
                if (this.nextStreamId > 1073741823) {
                    shutdown(ErrorCode.REFUSED_STREAM);
                }
                if (this.isShutdown) {
                    throw new ConnectionShutdownException();
                }
                i2 = this.nextStreamId;
                this.nextStreamId += 2;
                http2Stream = new Http2Stream(i2, this, z3, false, null);
                if (z && this.bytesLeftInWriteWindow != 0 && http2Stream.getBytesLeftInWriteWindow() != 0) {
                    z2 = false;
                    if (http2Stream.isOpen()) {
                        this.streams.put(Integer.valueOf(i2), http2Stream);
                    }
                }
                z2 = true;
                if (http2Stream.isOpen()) {
                }
            }
            if (i == 0) {
                this.writer.headers(z3, i2, list);
            } else if (!(true ^ this.client)) {
                throw new IllegalArgumentException("client streams shouldn't have associated stream IDs".toString());
            } else {
                this.writer.pushPromise(i, i2, list);
            }
        }
        if (z2) {
            this.writer.flush();
        }
        return http2Stream;
    }

    public static /* synthetic */ void start$default(Http2Connection http2Connection, boolean z, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            z = true;
        }
        http2Connection.start(z);
    }

    public final synchronized void awaitPong() throws InterruptedException {
        while (this.awaitingPong) {
            wait();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        close$okhttp(ErrorCode.NO_ERROR, ErrorCode.CANCEL, null);
    }

    public final void close$okhttp(ErrorCode errorCode, ErrorCode errorCode2, IOException iOException) {
        int i;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(errorCode, "connectionCode");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(errorCode2, "streamCode");
        boolean z = !Thread.holdsLock(this);
        if (!pf0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || z) {
            try {
                shutdown(errorCode);
            } catch (IOException unused) {
            }
            Http2Stream[] http2StreamArr = null;
            synchronized (this) {
                if (!this.streams.isEmpty()) {
                    Collection<Http2Stream> values = this.streams.values();
                    if (values == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
                    }
                    Object[] array = values.toArray(new Http2Stream[0]);
                    if (array == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                    http2StreamArr = (Http2Stream[]) array;
                    this.streams.clear();
                }
            }
            if (http2StreamArr != null) {
                for (Http2Stream http2Stream : http2StreamArr) {
                    try {
                        http2Stream.close(errorCode2, iOException);
                    } catch (IOException unused2) {
                    }
                }
            }
            try {
                this.writer.close();
            } catch (IOException unused3) {
            }
            try {
                this.socket.close();
            } catch (IOException unused4) {
            }
            this.writerExecutor.shutdown();
            this.pushExecutor.shutdown();
            return;
        }
        throw new AssertionError("Assertion failed");
    }

    public final void flush() throws IOException {
        this.writer.flush();
    }

    public final long getBytesLeftInWriteWindow() {
        return this.bytesLeftInWriteWindow;
    }

    public final boolean getClient$okhttp() {
        return this.client;
    }

    public final String getConnectionName$okhttp() {
        return this.connectionName;
    }

    public final int getLastGoodStreamId$okhttp() {
        return this.lastGoodStreamId;
    }

    public final Listener getListener$okhttp() {
        return this.listener;
    }

    public final int getNextStreamId$okhttp() {
        return this.nextStreamId;
    }

    public final Settings getOkHttpSettings() {
        return this.okHttpSettings;
    }

    public final Settings getPeerSettings() {
        return this.peerSettings;
    }

    public final ReaderRunnable getReaderRunnable() {
        return this.readerRunnable;
    }

    public final boolean getReceivedInitialPeerSettings$okhttp() {
        return this.receivedInitialPeerSettings;
    }

    public final Socket getSocket$okhttp() {
        return this.socket;
    }

    public final synchronized Http2Stream getStream(int i) {
        return this.streams.get(Integer.valueOf(i));
    }

    public final Map<Integer, Http2Stream> getStreams$okhttp() {
        return this.streams;
    }

    public final long getUnacknowledgedBytesRead() {
        return this.unacknowledgedBytesRead;
    }

    public final Http2Writer getWriter() {
        return this.writer;
    }

    public final synchronized boolean isShutdown() {
        return this.isShutdown;
    }

    public final synchronized int maxConcurrentStreams() {
        return this.peerSettings.getMaxConcurrentStreams(Integer.MAX_VALUE);
    }

    public final Http2Stream newStream(List<Header> list, boolean z) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "requestHeaders");
        return newStream(0, list, z);
    }

    public final synchronized int openStreamCount() {
        return this.streams.size();
    }

    public final void pushDataLater$okhttp(final int i, ww0 ww0Var, final int i2, final boolean z) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ww0Var, "source");
        final uw0 uw0Var = new uw0();
        long j = i2;
        ww0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
        ww0Var.read(uw0Var, j);
        if (!this.isShutdown) {
            ThreadPoolExecutor threadPoolExecutor = this.pushExecutor;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("OkHttp ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.connectionName);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" Push Data[");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(i);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(']');
            final String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            threadPoolExecutor.execute(new Runnable() { // from class: okhttp3.internal.http2.Http2Connection$pushDataLater$$inlined$execute$1
                @Override // java.lang.Runnable
                public final void run() {
                    PushObserver pushObserver;
                    Set set;
                    String str = sb;
                    Thread currentThread = Thread.currentThread();
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) currentThread, "currentThread");
                    String name = currentThread.getName();
                    currentThread.setName(str);
                    try {
                        pushObserver = this.pushObserver;
                        boolean onData = pushObserver.onData(i, uw0Var, i2, z);
                        if (onData) {
                            this.getWriter().rstStream(i, ErrorCode.CANCEL);
                        }
                        if (onData || z) {
                            synchronized (this) {
                                set = this.currentPushRequests;
                                set.remove(Integer.valueOf(i));
                            }
                        }
                    } catch (IOException unused) {
                    } catch (Throwable th) {
                        currentThread.setName(name);
                        throw th;
                    }
                    currentThread.setName(name);
                }
            });
        }
    }

    public final void pushHeadersLater$okhttp(final int i, final List<Header> list, final boolean z) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "requestHeaders");
        if (!this.isShutdown) {
            ThreadPoolExecutor threadPoolExecutor = this.pushExecutor;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("OkHttp ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.connectionName);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" Push Headers[");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(i);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(']');
            final String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            try {
                threadPoolExecutor.execute(new Runnable() { // from class: okhttp3.internal.http2.Http2Connection$pushHeadersLater$$inlined$tryExecute$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        PushObserver pushObserver;
                        Set set;
                        String str = sb;
                        Thread currentThread = Thread.currentThread();
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) currentThread, "currentThread");
                        String name = currentThread.getName();
                        currentThread.setName(str);
                        try {
                            pushObserver = this.pushObserver;
                            boolean onHeaders = pushObserver.onHeaders(i, list, z);
                            if (onHeaders) {
                                try {
                                    this.getWriter().rstStream(i, ErrorCode.CANCEL);
                                } catch (IOException unused) {
                                }
                            }
                            if (onHeaders || z) {
                                synchronized (this) {
                                    set = this.currentPushRequests;
                                    set.remove(Integer.valueOf(i));
                                }
                            }
                        } finally {
                            currentThread.setName(name);
                        }
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    public final void pushRequestLater$okhttp(final int i, final List<Header> list) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "requestHeaders");
        synchronized (this) {
            if (this.currentPushRequests.contains(Integer.valueOf(i))) {
                writeSynResetLater$okhttp(i, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.currentPushRequests.add(Integer.valueOf(i));
            if (this.isShutdown) {
                return;
            }
            ThreadPoolExecutor threadPoolExecutor = this.pushExecutor;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("OkHttp ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.connectionName);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" Push Request[");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(i);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(']');
            final String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            try {
                threadPoolExecutor.execute(new Runnable() { // from class: okhttp3.internal.http2.Http2Connection$pushRequestLater$$inlined$tryExecute$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        PushObserver pushObserver;
                        Set set;
                        String str = sb;
                        Thread currentThread = Thread.currentThread();
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) currentThread, "currentThread");
                        String name = currentThread.getName();
                        currentThread.setName(str);
                        try {
                            pushObserver = this.pushObserver;
                            if (pushObserver.onRequest(i, list)) {
                                try {
                                    this.getWriter().rstStream(i, ErrorCode.CANCEL);
                                    synchronized (this) {
                                        set = this.currentPushRequests;
                                        set.remove(Integer.valueOf(i));
                                    }
                                } catch (IOException unused) {
                                }
                            }
                        } finally {
                            currentThread.setName(name);
                        }
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    public final void pushResetLater$okhttp(final int i, final ErrorCode errorCode) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(errorCode, "errorCode");
        if (!this.isShutdown) {
            ThreadPoolExecutor threadPoolExecutor = this.pushExecutor;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("OkHttp ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.connectionName);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" Push Reset[");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(i);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(']');
            final String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            threadPoolExecutor.execute(new Runnable() { // from class: okhttp3.internal.http2.Http2Connection$pushResetLater$$inlined$execute$1
                @Override // java.lang.Runnable
                public final void run() {
                    PushObserver pushObserver;
                    Set set;
                    String str = sb;
                    Thread currentThread = Thread.currentThread();
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) currentThread, "currentThread");
                    String name = currentThread.getName();
                    currentThread.setName(str);
                    try {
                        pushObserver = this.pushObserver;
                        pushObserver.onReset(i, errorCode);
                        synchronized (this) {
                            set = this.currentPushRequests;
                            set.remove(Integer.valueOf(i));
                        }
                    } finally {
                        currentThread.setName(name);
                    }
                }
            });
        }
    }

    public final Http2Stream pushStream(int i, List<Header> list, boolean z) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "requestHeaders");
        if (!this.client) {
            return newStream(i, list, z);
        }
        throw new IllegalStateException("Client cannot push requests.".toString());
    }

    public final boolean pushedStream$okhttp(int i) {
        return i != 0 && (i & 1) == 0;
    }

    public final synchronized Http2Stream removeStream$okhttp(int i) {
        Http2Stream remove;
        remove = this.streams.remove(Integer.valueOf(i));
        notifyAll();
        return remove;
    }

    public final void setBytesLeftInWriteWindow$okhttp(long j) {
        this.bytesLeftInWriteWindow = j;
    }

    public final void setLastGoodStreamId$okhttp(int i) {
        this.lastGoodStreamId = i;
    }

    public final void setNextStreamId$okhttp(int i) {
        this.nextStreamId = i;
    }

    public final void setReceivedInitialPeerSettings$okhttp(boolean z) {
        this.receivedInitialPeerSettings = z;
    }

    public final void setSettings(Settings settings) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(settings, "settings");
        synchronized (this.writer) {
            synchronized (this) {
                if (this.isShutdown) {
                    throw new ConnectionShutdownException();
                }
                this.okHttpSettings.merge(settings);
            }
            this.writer.settings(settings);
        }
    }

    public final void setShutdown$okhttp(boolean z) {
        this.isShutdown = z;
    }

    public final void shutdown(ErrorCode errorCode) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(errorCode, "statusCode");
        synchronized (this.writer) {
            synchronized (this) {
                if (this.isShutdown) {
                    return;
                }
                this.isShutdown = true;
                this.writer.goAway(this.lastGoodStreamId, errorCode, Util.EMPTY_BYTE_ARRAY);
            }
        }
    }

    public final void start() throws IOException {
        start$default(this, false, 1, null);
    }

    public final void start(boolean z) throws IOException {
        if (z) {
            this.writer.connectionPreface();
            this.writer.settings(this.okHttpSettings);
            int initialWindowSize = this.okHttpSettings.getInitialWindowSize();
            if (initialWindowSize != 65535) {
                this.writer.windowUpdate(0, initialWindowSize - 65535);
            }
        }
        ReaderRunnable readerRunnable = this.readerRunnable;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("OkHttp ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.connectionName);
        new Thread(readerRunnable, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString()).start();
    }

    public final synchronized void updateConnectionFlowControl$okhttp(long j) {
        long j2 = this.unacknowledgedBytesRead + j;
        this.unacknowledgedBytesRead = j2;
        if (j2 >= this.okHttpSettings.getInitialWindowSize() / 2) {
            writeWindowUpdateLater$okhttp(0, this.unacknowledgedBytesRead);
            this.unacknowledgedBytesRead = 0L;
        }
    }

    public final void writeData(int i, boolean z, uw0 uw0Var, long j) throws IOException {
        int min;
        if (j == 0) {
            this.writer.data(z, i, uw0Var, 0);
            return;
        }
        while (j > 0) {
            Ref$IntRef ref$IntRef = new Ref$IntRef();
            synchronized (this) {
                while (this.bytesLeftInWriteWindow <= 0) {
                    try {
                        if (!this.streams.containsKey(Integer.valueOf(i))) {
                            throw new IOException("stream closed");
                        }
                        wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                }
                int min2 = (int) Math.min(j, this.bytesLeftInWriteWindow);
                ref$IntRef.element = min2;
                min = Math.min(min2, this.writer.maxDataLength());
                ref$IntRef.element = min;
                this.bytesLeftInWriteWindow -= min;
            }
            j -= min;
            this.writer.data(z && j == 0, i, uw0Var, ref$IntRef.element);
        }
    }

    public final void writeHeaders$okhttp(int i, boolean z, List<Header> list) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "alternating");
        this.writer.headers(z, i, list);
    }

    public final void writePing(boolean z, int i, int i2) {
        boolean z2;
        if (!z) {
            synchronized (this) {
                z2 = this.awaitingPong;
                this.awaitingPong = true;
            }
            if (z2) {
                failConnection(null);
                return;
            }
        }
        try {
            this.writer.ping(z, i, i2);
        } catch (IOException e) {
            failConnection(e);
        }
    }

    public final void writePingAndAwaitPong() throws InterruptedException {
        writePing(false, 1330343787, -257978967);
        awaitPong();
    }

    public final void writeSynReset$okhttp(int i, ErrorCode errorCode) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(errorCode, "statusCode");
        this.writer.rstStream(i, errorCode);
    }

    public final void writeSynResetLater$okhttp(final int i, final ErrorCode errorCode) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(errorCode, "errorCode");
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.writerExecutor;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("OkHttp ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.connectionName);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" stream ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(i);
        final String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        try {
            scheduledThreadPoolExecutor.execute(new Runnable() { // from class: okhttp3.internal.http2.Http2Connection$writeSynResetLater$$inlined$tryExecute$1
                @Override // java.lang.Runnable
                public final void run() {
                    String str = sb;
                    Thread currentThread = Thread.currentThread();
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) currentThread, "currentThread");
                    String name = currentThread.getName();
                    currentThread.setName(str);
                    try {
                        try {
                            this.writeSynReset$okhttp(i, errorCode);
                        } catch (IOException e) {
                            this.failConnection(e);
                        }
                    } finally {
                        currentThread.setName(name);
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    public final void writeWindowUpdateLater$okhttp(final int i, final long j) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.writerExecutor;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("OkHttp Window Update ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.connectionName);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" stream ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(i);
        final String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        try {
            scheduledThreadPoolExecutor.execute(new Runnable() { // from class: okhttp3.internal.http2.Http2Connection$writeWindowUpdateLater$$inlined$tryExecute$1
                @Override // java.lang.Runnable
                public final void run() {
                    String str = sb;
                    Thread currentThread = Thread.currentThread();
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) currentThread, "currentThread");
                    String name = currentThread.getName();
                    currentThread.setName(str);
                    try {
                        try {
                            this.getWriter().windowUpdate(i, j);
                        } catch (IOException e) {
                            this.failConnection(e);
                        }
                    } finally {
                        currentThread.setName(name);
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }
}
