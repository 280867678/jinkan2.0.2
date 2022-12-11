package org.eclipse.jetty.server;

import java.io.IOException;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.jetty.http.HttpException;
import org.eclipse.jetty.p059io.AsyncEndPoint;
import org.eclipse.jetty.p059io.Connection;
import org.eclipse.jetty.p059io.EndPoint;
import org.eclipse.jetty.p059io.nio.AsyncConnection;
import org.eclipse.jetty.p059io.nio.SelectChannelEndPoint;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes4.dex */
public class AsyncHttpConnection extends AbstractHttpConnection implements AsyncConnection {
    public final AsyncEndPoint _asyncEndp;
    public boolean _readInterested = true;
    public int _total_no_progress;
    public static final int NO_PROGRESS_INFO = Integer.getInteger("org.mortbay.jetty.NO_PROGRESS_INFO", 100).intValue();
    public static final int NO_PROGRESS_CLOSE = Integer.getInteger("org.mortbay.jetty.NO_PROGRESS_CLOSE", 200).intValue();
    public static final Logger LOG = Log.getLogger(AsyncHttpConnection.class);

    public AsyncHttpConnection(Connector connector, EndPoint endPoint, Server server) {
        super(connector, endPoint, server);
        this._asyncEndp = (AsyncEndPoint) endPoint;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:7|(2:8|9)|(10:(2:11|(1:13))(2:144|(15:148|15|16|(1:26)|27|(1:29)|30|31|32|(1:58)(1:35)|(1:(5:38|(1:42)|43|(1:47)|48)(1:49))|(2:53|54)|55|56|57))|31|32|(0)|58|(0)|(3:51|53|54)|55|56|57)|14|15|16|(5:18|20|22|24|26)|27|(0)|30) */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x0216, code lost:
        org.eclipse.jetty.server.AsyncHttpConnection.LOG.warn("Safety net oshut!!!  IF YOU SEE THIS, PLEASE RAISE BUGZILLA", new java.lang.Object[0]);
        r17._endp.shutdownOutput();
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0223, code lost:
        r17._readInterested = false;
        org.eclipse.jetty.server.AsyncHttpConnection.LOG.debug("Disabled read interest while writing response {}", r17._endp);
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x00ff, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x010e, code lost:
        if (org.eclipse.jetty.server.AsyncHttpConnection.LOG.isDebugEnabled() != false) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0110, code lost:
        r10 = org.eclipse.jetty.server.AsyncHttpConnection.LOG;
        r10.debug("uri=" + r17._uri, new java.lang.Object[0]);
        r10 = org.eclipse.jetty.server.AsyncHttpConnection.LOG;
        r10.debug("fields=" + r17._requestFields, new java.lang.Object[0]);
        org.eclipse.jetty.server.AsyncHttpConnection.LOG.debug(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0149, code lost:
        r17._generator.sendError(r0.getStatus(), r0.getReason(), null, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0158, code lost:
        r11 = r11 | true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x015a, code lost:
        r0 = r17._parser.isComplete();
        r10 = r17._generator.isComplete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0166, code lost:
        if (r0 == false) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x016a, code lost:
        r13 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x016d, code lost:
        if (r0 != false) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x016f, code lost:
        if (r10 != false) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0179, code lost:
        if (r17._response.getStatus() == 101) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0185, code lost:
        r12 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0186, code lost:
        reset();
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x018f, code lost:
        if (r17._generator.isPersistent() == false) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0199, code lost:
        org.eclipse.jetty.server.AsyncHttpConnection.LOG.warn("Safety net oshut!!!  IF YOU SEE THIS, PLEASE RAISE BUGZILLA", new java.lang.Object[0]);
        r17._endp.shutdownOutput();
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x01a6, code lost:
        r17._readInterested = false;
        org.eclipse.jetty.server.AsyncHttpConnection.LOG.debug("Disabled read interest while writing response {}", r17._endp);
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x01b4, code lost:
        if (r13 != false) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x01c2, code lost:
        org.eclipse.jetty.server.AsyncHttpConnection.LOG.debug("suspended {}", r17);
        r10 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x01cf, code lost:
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x016c, code lost:
        r13 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x01d4, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x01d5, code lost:
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01ea, code lost:
        r13 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01ef, code lost:
        if (r12 != false) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01f9, code lost:
        if (r17._response.getStatus() == 101) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01fb, code lost:
        r6 = (org.eclipse.jetty.p059io.Connection) r17._request.getAttribute("org.eclipse.jetty.io.Connection");
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0203, code lost:
        reset();
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x020c, code lost:
        if (r17._generator.isPersistent() == false) goto L98;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01ef  */
    /* JADX WARN: Type inference failed for: r0v43, types: [org.eclipse.jetty.io.Connection] */
    /* JADX WARN: Type inference failed for: r10v44, types: [org.eclipse.jetty.io.Connection] */
    @Override // org.eclipse.jetty.server.AbstractHttpConnection, org.eclipse.jetty.p059io.Connection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Connection handle() throws IOException {
        AbstractHttpConnection abstractHttpConnection;
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        boolean z2;
        boolean z3;
        boolean isComplete;
        boolean z4;
        ?? r10;
        int i5 = 1;
        try {
            AbstractHttpConnection.setCurrentConnection(this);
            this._asyncEndp.setCheckForIdle(false);
            boolean z5 = true;
            z = false;
            AsyncHttpConnection asyncHttpConnection = this;
            while (z5 && asyncHttpConnection == this) {
                try {
                } catch (HttpException e) {
                    e = e;
                } catch (Throwable th) {
                    th = th;
                    z2 = false;
                }
                try {
                    try {
                        if (this._request._async.isAsync()) {
                            if (this._request._async.isDispatchable()) {
                                handleRequest();
                            }
                        } else if (!this._parser.isComplete() && this._parser.parseAvailable()) {
                            z3 = true;
                            if (this._generator.isCommitted() && !this._generator.isComplete() && !this._endp.isOutputShutdown() && !this._request.getAsyncContinuation().isAsyncStarted() && this._generator.flushBuffer() > 0) {
                                z3 = true;
                            }
                            this._endp.flush();
                            if (this._asyncEndp.hasProgressed()) {
                                z3 = true;
                            }
                            z |= z3;
                            isComplete = this._parser.isComplete();
                            boolean isComplete2 = this._generator.isComplete();
                            z4 = !isComplete && isComplete2;
                            if (isComplete) {
                                if (isComplete2) {
                                    if (this._response.getStatus() == 101 && (r10 = (Connection) this._request.getAttribute("org.eclipse.jetty.io.Connection")) != 0) {
                                        asyncHttpConnection = r10;
                                    }
                                    reset();
                                    if (!this._generator.isPersistent() && !this._endp.isOutputShutdown()) {
                                        LOG.warn("Safety net oshut!!!  IF YOU SEE THIS, PLEASE RAISE BUGZILLA", new Object[0]);
                                        this._endp.shutdownOutput();
                                    }
                                    z3 = true;
                                } else {
                                    this._readInterested = false;
                                    Logger logger = LOG;
                                    Object[] objArr = new Object[i5];
                                    objArr[0] = this._endp;
                                    logger.debug("Disabled read interest while writing response {}", objArr);
                                }
                            }
                            if (!z4 && this._request.getAsyncContinuation().isAsyncStarted()) {
                                Logger logger2 = LOG;
                                Object[] objArr2 = new Object[i5];
                                objArr2[0] = this;
                                logger2.debug("suspended {}", objArr2);
                                z3 = false;
                            }
                            z5 = z3;
                            i5 = 1;
                        }
                        isComplete = this._parser.isComplete();
                        boolean isComplete22 = this._generator.isComplete();
                        if (!isComplete) {
                        }
                        if (isComplete) {
                        }
                        if (!z4) {
                            Logger logger22 = LOG;
                            Object[] objArr22 = new Object[i5];
                            objArr22[0] = this;
                            logger22.debug("suspended {}", objArr22);
                            z3 = false;
                        }
                        z5 = z3;
                        i5 = 1;
                    } catch (Throwable th2) {
                        th = th2;
                        abstractHttpConnection = null;
                        AbstractHttpConnection.setCurrentConnection(abstractHttpConnection);
                        if (!this._request.getAsyncContinuation().isAsyncStarted()) {
                            this._parser.returnBuffers();
                            this._generator.returnBuffers();
                            i = 1;
                            this._asyncEndp.setCheckForIdle(true);
                        } else {
                            i = 1;
                        }
                        if (!z) {
                            int i6 = this._total_no_progress + i;
                            this._total_no_progress = i6;
                            int i7 = NO_PROGRESS_INFO;
                            if (i7 > 0 && i6 % i7 == 0 && ((i2 = NO_PROGRESS_CLOSE) <= 0 || i6 < i2)) {
                                Logger logger3 = LOG;
                                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("EndPoint making no progress: ");
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._total_no_progress);
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(StringUtils.SPACE);
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._endp);
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(StringUtils.SPACE);
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this);
                                logger3.info(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), new Object[0]);
                            }
                            int i8 = NO_PROGRESS_CLOSE;
                            if (i8 > 0 && this._total_no_progress == i8) {
                                Logger logger4 = LOG;
                                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Closing EndPoint making no progress: ");
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this._total_no_progress);
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(StringUtils.SPACE);
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this._endp);
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(StringUtils.SPACE);
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this);
                                logger4.warn(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString(), new Object[0]);
                                EndPoint endPoint = this._endp;
                                if (endPoint instanceof SelectChannelEndPoint) {
                                    ((SelectChannelEndPoint) endPoint).getChannel().close();
                                }
                            }
                        } else {
                            this._total_no_progress = 0;
                        }
                        throw th;
                    }
                    if (this._generator.isCommitted()) {
                        z3 = true;
                    }
                    this._endp.flush();
                    if (this._asyncEndp.hasProgressed()) {
                    }
                    z |= z3;
                } catch (Throwable th3) {
                    th = th3;
                    z2 = z3;
                    z |= z2;
                    boolean isComplete3 = this._parser.isComplete();
                    boolean isComplete4 = this._generator.isComplete();
                    if (isComplete3) {
                    }
                    boolean z6 = false;
                    if (isComplete3) {
                    }
                    if (!z6) {
                        LOG.debug("suspended {}", this);
                    }
                    throw th;
                }
                z3 = false;
            }
            AbstractHttpConnection.setCurrentConnection(null);
            if (!this._request.getAsyncContinuation().isAsyncStarted()) {
                this._parser.returnBuffers();
                this._generator.returnBuffers();
                i3 = 1;
                this._asyncEndp.setCheckForIdle(true);
            } else {
                i3 = 1;
            }
            if (z) {
                this._total_no_progress = 0;
            } else {
                int i9 = this._total_no_progress + i3;
                this._total_no_progress = i9;
                int i10 = NO_PROGRESS_INFO;
                if (i10 > 0 && i9 % i10 == 0 && ((i4 = NO_PROGRESS_CLOSE) <= 0 || i9 < i4)) {
                    Logger logger5 = LOG;
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("EndPoint making no progress: ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(this._total_no_progress);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(StringUtils.SPACE);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(this._endp);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(StringUtils.SPACE);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(this);
                    logger5.info(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString(), new Object[0]);
                }
                int i11 = NO_PROGRESS_CLOSE;
                if (i11 > 0 && this._total_no_progress == i11) {
                    Logger logger6 = LOG;
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Closing EndPoint making no progress: ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(this._total_no_progress);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(StringUtils.SPACE);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(this._endp);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(StringUtils.SPACE);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(this);
                    logger6.warn(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.toString(), new Object[0]);
                    EndPoint endPoint2 = this._endp;
                    if (endPoint2 instanceof SelectChannelEndPoint) {
                        ((SelectChannelEndPoint) endPoint2).getChannel().close();
                    }
                }
            }
            return asyncHttpConnection;
        } catch (Throwable th4) {
            th = th4;
            abstractHttpConnection = null;
            z = false;
        }
    }

    @Override // org.eclipse.jetty.server.AbstractHttpConnection, org.eclipse.jetty.p059io.Connection
    public boolean isSuspended() {
        return !this._readInterested || super.isSuspended();
    }

    @Override // org.eclipse.jetty.p059io.nio.AsyncConnection
    public void onInputShutdown() throws IOException {
        if (this._generator.isIdle() && !this._request.getAsyncContinuation().isSuspended()) {
            this._endp.close();
        }
        if (this._parser.isIdle()) {
            this._parser.setPersistent(false);
        }
    }

    @Override // org.eclipse.jetty.server.AbstractHttpConnection
    public void reset() {
        this._readInterested = true;
        LOG.debug("Enabled read interest {}", this._endp);
        super.reset();
    }
}
