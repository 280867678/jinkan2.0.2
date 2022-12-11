package org.eclipse.jetty.server;

import com.tencent.bugly.BuglyStrategy;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import org.eclipse.jetty.p059io.ByteArrayBuffer;
import org.eclipse.jetty.p059io.ByteArrayEndPoint;
import org.eclipse.jetty.p059io.Connection;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes4.dex */
public class LocalConnector extends AbstractConnector {
    public static final Logger LOG = Log.getLogger(LocalConnector.class);
    public final BlockingQueue<Request> _requests = new LinkedBlockingQueue();

    /* loaded from: classes4.dex */
    public class Request implements Runnable {
        public final boolean _keepOpen;
        public final CountDownLatch _latch;
        public final ByteArrayBuffer _requestsBuffer;
        public volatile ByteArrayBuffer _responsesBuffer;

        public Request(ByteArrayBuffer byteArrayBuffer, boolean z, CountDownLatch countDownLatch) {
            this._requestsBuffer = byteArrayBuffer;
            this._keepOpen = z;
            this._latch = countDownLatch;
        }

        public ByteArrayBuffer getResponsesBuffer() {
            return this._responsesBuffer;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0042 A[Catch: all -> 0x0054, Exception -> 0x0056, IOException -> 0x0068, LOOP:1: B:8:0x0038->B:10:0x0042, LOOP_END, TRY_LEAVE, TryCatch #1 {IOException -> 0x0068, blocks: (B:4:0x0028, B:6:0x0032, B:8:0x0038, B:10:0x0042), top: B:3:0x0028, outer: #0 }] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0046 A[ADDED_TO_REGION, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:6:0x0032 A[Catch: all -> 0x0054, Exception -> 0x0056, IOException -> 0x0068, TryCatch #1 {IOException -> 0x0068, blocks: (B:4:0x0028, B:6:0x0032, B:8:0x0038, B:10:0x0042), top: B:3:0x0028, outer: #0 }] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            ByteArrayBuffer out;
            Connection connection;
            Connection handle;
            try {
                ByteArrayEndPoint byteArrayEndPoint = new ByteArrayEndPoint(this._requestsBuffer.asArray(), 1024) { // from class: org.eclipse.jetty.server.LocalConnector.Request.1
                    @Override // org.eclipse.jetty.p059io.ByteArrayEndPoint, org.eclipse.jetty.p059io.ConnectedEndPoint
                    public void setConnection(Connection connection2) {
                        if (getConnection() != null && connection2 != getConnection()) {
                            LocalConnector.this.connectionUpgraded(getConnection(), connection2);
                        }
                        super.setConnection(connection2);
                    }
                };
                byteArrayEndPoint.setGrowOutput(true);
                BlockingHttpConnection blockingHttpConnection = new BlockingHttpConnection(LocalConnector.this, byteArrayEndPoint, LocalConnector.this.getServer());
                byteArrayEndPoint.setConnection(blockingHttpConnection);
                LocalConnector.this.connectionOpened(blockingHttpConnection);
                boolean z = this._keepOpen;
                while (byteArrayEndPoint.getIn().length() <= 0 && byteArrayEndPoint.isOpen()) {
                    try {
                        try {
                            while (true) {
                                connection = byteArrayEndPoint.getConnection();
                                handle = connection.handle();
                                if (handle != connection) {
                                    byteArrayEndPoint.setConnection(handle);
                                }
                            }
                            if (byteArrayEndPoint.getIn().length() <= 0) {
                                while (true) {
                                    connection = byteArrayEndPoint.getConnection();
                                    handle = connection.handle();
                                    if (handle != connection) {
                                    }
                                    byteArrayEndPoint.setConnection(handle);
                                }
                                if (byteArrayEndPoint.getIn().length() <= 0) {
                                }
                            }
                        } catch (IOException e) {
                            LocalConnector.LOG.debug(e);
                            LocalConnector.this.connectionClosed(blockingHttpConnection);
                            out = byteArrayEndPoint.getOut();
                        }
                    } catch (Exception e2) {
                        LocalConnector.LOG.warn(e2);
                        LocalConnector.this.connectionClosed(blockingHttpConnection);
                        out = byteArrayEndPoint.getOut();
                    }
                }
                if (!z) {
                    LocalConnector.this.connectionClosed(blockingHttpConnection);
                }
                out = byteArrayEndPoint.getOut();
                this._responsesBuffer = out;
            } finally {
                CountDownLatch countDownLatch = this._latch;
                if (countDownLatch != null) {
                    countDownLatch.countDown();
                }
            }
        }
    }

    public LocalConnector() {
        setMaxIdleTime(BuglyStrategy.C1080a.MAX_USERDATA_VALUE_LENGTH);
    }

    @Override // org.eclipse.jetty.server.AbstractConnector
    public void accept(int i) throws IOException, InterruptedException {
        getThreadPool().dispatch(this._requests.take());
    }

    @Override // org.eclipse.jetty.server.Connector
    public void close() throws IOException {
    }

    public void executeRequest(String str) throws IOException {
        this._requests.add(new Request(new ByteArrayBuffer(str, "UTF-8"), true, null));
    }

    @Override // org.eclipse.jetty.server.Connector
    public Object getConnection() {
        return this;
    }

    @Override // org.eclipse.jetty.server.Connector
    public int getLocalPort() {
        return -1;
    }

    public String getResponses(String str) throws Exception {
        return getResponses(str, false);
    }

    public String getResponses(String str, boolean z) throws Exception {
        ByteArrayBuffer responses = getResponses(new ByteArrayBuffer(str, "ISO-8859-1"), z);
        if (responses == null) {
            return null;
        }
        return responses.toString("ISO-8859-1");
    }

    public ByteArrayBuffer getResponses(ByteArrayBuffer byteArrayBuffer, boolean z) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Request request = new Request(byteArrayBuffer, z, countDownLatch);
        this._requests.add(request);
        countDownLatch.await(getMaxIdleTime(), TimeUnit.MILLISECONDS);
        return request.getResponsesBuffer();
    }

    @Override // org.eclipse.jetty.server.Connector
    public void open() throws IOException {
    }
}
