package org.eclipse.jetty.p059io.nio;

import java.io.IOException;
import java.nio.channels.ByteChannel;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.ClosedSelectorException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import me.tvspark.outline;
import org.eclipse.jetty.p059io.AsyncEndPoint;
import org.eclipse.jetty.p059io.ConnectedEndPoint;
import org.eclipse.jetty.p059io.Connection;
import org.eclipse.jetty.p059io.EndPoint;
import org.eclipse.jetty.util.TypeUtil;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.component.AggregateLifeCycle;
import org.eclipse.jetty.util.component.Dumpable;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.Timeout;
import org.mozilla.javascript.v8dtoa.FastDtoa;

/* renamed from: org.eclipse.jetty.io.nio.SelectorManager */
/* loaded from: classes4.dex */
public abstract class SelectorManager extends AbstractLifeCycle implements Dumpable {
    public long _lowResourcesConnections;
    public int _lowResourcesMaxIdleTime;
    public int _maxIdleTime;
    public SelectSet[] _selectSet;
    public static final Logger LOG = Log.getLogger("org.eclipse.jetty.io.nio");
    public static final int __MONITOR_PERIOD = Integer.getInteger("org.eclipse.jetty.io.nio.MONITOR_PERIOD", 1000).intValue();
    public static final int __MAX_SELECTS = Integer.getInteger("org.eclipse.jetty.io.nio.MAX_SELECTS", (int) FastDtoa.kTen5).intValue();
    public static final int __BUSY_PAUSE = Integer.getInteger("org.eclipse.jetty.io.nio.BUSY_PAUSE", 50).intValue();
    public static final int __IDLE_TICK = Integer.getInteger("org.eclipse.jetty.io.nio.IDLE_TICK", 400).intValue();
    public int _selectSets = 1;
    public volatile int _set = 0;
    public boolean _deferringInterestedOps0 = true;
    public int _selectorPriorityDelta = 0;

    /* renamed from: org.eclipse.jetty.io.nio.SelectorManager$ChangeTask */
    /* loaded from: classes4.dex */
    public interface ChangeTask extends Runnable {
    }

    /* renamed from: org.eclipse.jetty.io.nio.SelectorManager$ChannelAndAttachment */
    /* loaded from: classes4.dex */
    public static class ChannelAndAttachment {
        public final Object _attachment;
        public final SelectableChannel _channel;

        public ChannelAndAttachment(SelectableChannel selectableChannel, Object obj) {
            this._channel = selectableChannel;
            this._attachment = obj;
        }
    }

    /* renamed from: org.eclipse.jetty.io.nio.SelectorManager$SelectSet */
    /* loaded from: classes4.dex */
    public class SelectSet implements Dumpable {
        public int _busySelects;
        public boolean _paused;
        public boolean _pausing;
        public volatile Thread _selecting;
        public final int _setID;
        public final Timeout _timeout;
        public final ConcurrentLinkedQueue<Object> _changes = new ConcurrentLinkedQueue<>();
        public ConcurrentMap<SelectChannelEndPoint, Object> _endPoints = new ConcurrentHashMap();
        public volatile long _idleTick = System.currentTimeMillis();
        public volatile Selector _selector = Selector.open();
        public long _monitorNext = System.currentTimeMillis() + SelectorManager.__MONITOR_PERIOD;

        public SelectSet(int i) throws Exception {
            this._setID = i;
            Timeout timeout = new Timeout(this);
            this._timeout = timeout;
            timeout.setDuration(0L);
        }

        private SelectChannelEndPoint createEndPoint(SocketChannel socketChannel, SelectionKey selectionKey) throws IOException {
            SelectChannelEndPoint newEndPoint = SelectorManager.this.newEndPoint(socketChannel, this, selectionKey);
            SelectorManager.LOG.debug("created {}", newEndPoint);
            SelectorManager.this.endPointOpened(newEndPoint);
            this._endPoints.put(newEndPoint, this);
            return newEndPoint;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void renewSelector() {
            try {
                synchronized (this) {
                    Selector selector = this._selector;
                    if (selector == null) {
                        return;
                    }
                    Selector open = Selector.open();
                    for (SelectionKey selectionKey : selector.keys()) {
                        if (selectionKey.isValid() && selectionKey.interestOps() != 0) {
                            SelectableChannel channel = selectionKey.channel();
                            Object attachment = selectionKey.attachment();
                            if (attachment == null) {
                                addChange(channel);
                            } else {
                                addChange(channel, attachment);
                            }
                        }
                    }
                    this._selector.close();
                    this._selector = open;
                }
            } catch (IOException e) {
                throw new RuntimeException("recreating selector", e);
            }
        }

        public void addChange(Object obj) {
            this._changes.add(obj);
        }

        public void addChange(SelectableChannel selectableChannel, Object obj) {
            if (obj == null) {
                addChange(selectableChannel);
            } else if (obj instanceof EndPoint) {
                addChange(obj);
            } else {
                addChange(new ChannelAndAttachment(selectableChannel, obj));
            }
        }

        public void cancelTimeout(Timeout.Task task) {
            task.cancel();
        }

        public void destroyEndPoint(SelectChannelEndPoint selectChannelEndPoint) {
            SelectorManager.LOG.debug("destroyEndPoint {}", selectChannelEndPoint);
            this._endPoints.remove(selectChannelEndPoint);
            SelectorManager.this.endPointClosed(selectChannelEndPoint);
        }

        /* JADX WARN: Code restructure failed: missing block: B:112:0x00ed, code lost:
            java.lang.Thread.sleep(org.eclipse.jetty.p059io.nio.SelectorManager.__BUSY_PAUSE);
         */
        /* JADX WARN: Code restructure failed: missing block: B:115:0x00f6, code lost:
            r2 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:116:0x00f7, code lost:
            org.eclipse.jetty.p059io.nio.SelectorManager.LOG.ignore(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:82:0x00d2, code lost:
            r2 = r1.selectNow();
            r5 = java.lang.System.currentTimeMillis();
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:0x00dd, code lost:
            if (r2 != 0) goto L117;
         */
        /* JADX WARN: Code restructure failed: missing block: B:85:0x00e7, code lost:
            if (r1.selectedKeys().isEmpty() == false) goto L117;
         */
        /* JADX WARN: Code restructure failed: missing block: B:87:0x00eb, code lost:
            if (r14._pausing == false) goto L88;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:125:0x017d A[Catch: all -> 0x02cb, CancelledKeyException -> 0x02cd, ClosedSelectorException -> 0x02d6, TRY_LEAVE, TryCatch #16 {CancelledKeyException -> 0x02cd, ClosedSelectorException -> 0x02d6, blocks: (B:3:0x0001, B:8:0x000e, B:9:0x0014, B:11:0x0019, B:23:0x00a9, B:25:0x00b1, B:28:0x00be, B:32:0x00c3, B:35:0x00b7, B:77:0x00ca, B:82:0x00d2, B:84:0x00df, B:86:0x00e9, B:112:0x00ed, B:113:0x00fc, B:88:0x0100, B:90:0x0113, B:100:0x012c, B:102:0x013e, B:104:0x0145, B:106:0x0150, B:108:0x0156, B:116:0x00f7, B:117:0x0163, B:119:0x0167, B:122:0x016f, B:123:0x0177, B:125:0x017d, B:143:0x0205, B:145:0x020d, B:162:0x021a, B:149:0x0226, B:152:0x022e, B:155:0x0234, B:165:0x021f, B:166:0x0213, B:209:0x023a, B:214:0x0241, B:215:0x0253, B:217:0x0259, B:219:0x025d, B:221:0x0264, B:224:0x0267, B:226:0x0274, B:228:0x0280, B:230:0x0293, B:231:0x02a5, B:233:0x02af, B:235:0x02b5, B:237:0x02bb), top: B:2:0x0001, outer: #6 }] */
        /* JADX WARN: Removed duplicated region for block: B:217:0x0259 A[Catch: all -> 0x02cb, CancelledKeyException -> 0x02cd, ClosedSelectorException -> 0x02d6, TryCatch #16 {CancelledKeyException -> 0x02cd, ClosedSelectorException -> 0x02d6, blocks: (B:3:0x0001, B:8:0x000e, B:9:0x0014, B:11:0x0019, B:23:0x00a9, B:25:0x00b1, B:28:0x00be, B:32:0x00c3, B:35:0x00b7, B:77:0x00ca, B:82:0x00d2, B:84:0x00df, B:86:0x00e9, B:112:0x00ed, B:113:0x00fc, B:88:0x0100, B:90:0x0113, B:100:0x012c, B:102:0x013e, B:104:0x0145, B:106:0x0150, B:108:0x0156, B:116:0x00f7, B:117:0x0163, B:119:0x0167, B:122:0x016f, B:123:0x0177, B:125:0x017d, B:143:0x0205, B:145:0x020d, B:162:0x021a, B:149:0x0226, B:152:0x022e, B:155:0x0234, B:165:0x021f, B:166:0x0213, B:209:0x023a, B:214:0x0241, B:215:0x0253, B:217:0x0259, B:219:0x025d, B:221:0x0264, B:224:0x0267, B:226:0x0274, B:228:0x0280, B:230:0x0293, B:231:0x02a5, B:233:0x02af, B:235:0x02b5, B:237:0x02bb), top: B:2:0x0001, outer: #6 }] */
        /* JADX WARN: Removed duplicated region for block: B:223:0x0267 A[EDGE_INSN: B:223:0x0267->B:224:0x0267 ?: BREAK  , SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:226:0x0274 A[Catch: all -> 0x02cb, CancelledKeyException -> 0x02cd, ClosedSelectorException -> 0x02d6, TryCatch #16 {CancelledKeyException -> 0x02cd, ClosedSelectorException -> 0x02d6, blocks: (B:3:0x0001, B:8:0x000e, B:9:0x0014, B:11:0x0019, B:23:0x00a9, B:25:0x00b1, B:28:0x00be, B:32:0x00c3, B:35:0x00b7, B:77:0x00ca, B:82:0x00d2, B:84:0x00df, B:86:0x00e9, B:112:0x00ed, B:113:0x00fc, B:88:0x0100, B:90:0x0113, B:100:0x012c, B:102:0x013e, B:104:0x0145, B:106:0x0150, B:108:0x0156, B:116:0x00f7, B:117:0x0163, B:119:0x0167, B:122:0x016f, B:123:0x0177, B:125:0x017d, B:143:0x0205, B:145:0x020d, B:162:0x021a, B:149:0x0226, B:152:0x022e, B:155:0x0234, B:165:0x021f, B:166:0x0213, B:209:0x023a, B:214:0x0241, B:215:0x0253, B:217:0x0259, B:219:0x025d, B:221:0x0264, B:224:0x0267, B:226:0x0274, B:228:0x0280, B:230:0x0293, B:231:0x02a5, B:233:0x02af, B:235:0x02b5, B:237:0x02bb), top: B:2:0x0001, outer: #6 }] */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00b1 A[Catch: all -> 0x02cb, CancelledKeyException -> 0x02cd, ClosedSelectorException -> 0x02d6, TryCatch #16 {CancelledKeyException -> 0x02cd, ClosedSelectorException -> 0x02d6, blocks: (B:3:0x0001, B:8:0x000e, B:9:0x0014, B:11:0x0019, B:23:0x00a9, B:25:0x00b1, B:28:0x00be, B:32:0x00c3, B:35:0x00b7, B:77:0x00ca, B:82:0x00d2, B:84:0x00df, B:86:0x00e9, B:112:0x00ed, B:113:0x00fc, B:88:0x0100, B:90:0x0113, B:100:0x012c, B:102:0x013e, B:104:0x0145, B:106:0x0150, B:108:0x0156, B:116:0x00f7, B:117:0x0163, B:119:0x0167, B:122:0x016f, B:123:0x0177, B:125:0x017d, B:143:0x0205, B:145:0x020d, B:162:0x021a, B:149:0x0226, B:152:0x022e, B:155:0x0234, B:165:0x021f, B:166:0x0213, B:209:0x023a, B:214:0x0241, B:215:0x0253, B:217:0x0259, B:219:0x025d, B:221:0x0264, B:224:0x0267, B:226:0x0274, B:228:0x0280, B:230:0x0293, B:231:0x02a5, B:233:0x02af, B:235:0x02b5, B:237:0x02bb), top: B:2:0x0001, outer: #6 }] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00be A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00cf A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00b7 A[Catch: all -> 0x02cb, CancelledKeyException -> 0x02cd, ClosedSelectorException -> 0x02d6, TRY_LEAVE, TryCatch #16 {CancelledKeyException -> 0x02cd, ClosedSelectorException -> 0x02d6, blocks: (B:3:0x0001, B:8:0x000e, B:9:0x0014, B:11:0x0019, B:23:0x00a9, B:25:0x00b1, B:28:0x00be, B:32:0x00c3, B:35:0x00b7, B:77:0x00ca, B:82:0x00d2, B:84:0x00df, B:86:0x00e9, B:112:0x00ed, B:113:0x00fc, B:88:0x0100, B:90:0x0113, B:100:0x012c, B:102:0x013e, B:104:0x0145, B:106:0x0150, B:108:0x0156, B:116:0x00f7, B:117:0x0163, B:119:0x0167, B:122:0x016f, B:123:0x0177, B:125:0x017d, B:143:0x0205, B:145:0x020d, B:162:0x021a, B:149:0x0226, B:152:0x022e, B:155:0x0234, B:165:0x021f, B:166:0x0213, B:209:0x023a, B:214:0x0241, B:215:0x0253, B:217:0x0259, B:219:0x025d, B:221:0x0264, B:224:0x0267, B:226:0x0274, B:228:0x0280, B:230:0x0293, B:231:0x02a5, B:233:0x02af, B:235:0x02b5, B:237:0x02bb), top: B:2:0x0001, outer: #6 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void doSelect() throws IOException {
            Logger logger;
            Selector selector;
            long currentTimeMillis;
            Timeout timeout;
            Timeout.Task expired;
            SocketChannel socketChannel;
            SelectChannelEndPoint createEndPoint;
            Object poll;
            ByteChannel byteChannel;
            try {
                try {
                    this._selecting = Thread.currentThread();
                    selector = this._selector;
                    if (selector == null) {
                        return;
                    }
                    int size = this._changes.size();
                    while (true) {
                        int i = size - 1;
                        if (size <= 0 || (poll = this._changes.poll()) == null) {
                            break;
                        }
                        try {
                            try {
                            } catch (CancelledKeyException e) {
                                SelectorManager.LOG.ignore(e);
                            }
                        } catch (Throwable th) {
                            th = th;
                            byteChannel = null;
                        }
                        if (poll instanceof EndPoint) {
                            SelectChannelEndPoint selectChannelEndPoint = (SelectChannelEndPoint) poll;
                            byteChannel = selectChannelEndPoint.getChannel();
                            try {
                                selectChannelEndPoint.doUpdateKey();
                            } catch (Throwable th2) {
                                th = th2;
                                if (SelectorManager.this.isRunning()) {
                                }
                                if (byteChannel != null) {
                                }
                                size = i;
                            }
                            size = i;
                        } else if (poll instanceof ChannelAndAttachment) {
                            ChannelAndAttachment channelAndAttachment = (ChannelAndAttachment) poll;
                            SelectableChannel selectableChannel = channelAndAttachment._channel;
                            try {
                                Object obj = channelAndAttachment._attachment;
                                if ((selectableChannel instanceof SocketChannel) && ((SocketChannel) selectableChannel).isConnected()) {
                                    SelectionKey register = selectableChannel.register(selector, 1, obj);
                                    SelectChannelEndPoint createEndPoint2 = createEndPoint((SocketChannel) selectableChannel, register);
                                    register.attach(createEndPoint2);
                                    createEndPoint2.schedule();
                                } else if (selectableChannel.isOpen()) {
                                    selectableChannel.register(selector, 8, obj);
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                byteChannel = selectableChannel;
                                if (SelectorManager.this.isRunning()) {
                                }
                                if (byteChannel != null) {
                                }
                                size = i;
                            }
                            size = i;
                        } else {
                            if (poll instanceof SocketChannel) {
                                SocketChannel socketChannel2 = (SocketChannel) poll;
                                try {
                                    SelectionKey register2 = socketChannel2.register(selector, 1, null);
                                    SelectChannelEndPoint createEndPoint3 = createEndPoint(socketChannel2, register2);
                                    register2.attach(createEndPoint3);
                                    createEndPoint3.schedule();
                                } catch (Throwable th4) {
                                    byteChannel = socketChannel2;
                                    th = th4;
                                    if (SelectorManager.this.isRunning()) {
                                        SelectorManager.LOG.warn(th);
                                    } else {
                                        SelectorManager.LOG.debug(th);
                                    }
                                    if (byteChannel != null) {
                                        try {
                                            byteChannel.close();
                                        } catch (IOException e2) {
                                            SelectorManager.LOG.debug(e2);
                                        }
                                    }
                                    size = i;
                                }
                            } else if (!(poll instanceof ChangeTask)) {
                                if (!(poll instanceof Runnable)) {
                                    throw new IllegalArgumentException(poll.toString());
                                    break;
                                }
                                SelectorManager.this.dispatch((Runnable) poll);
                            } else {
                                ((Runnable) poll).run();
                            }
                            size = i;
                        }
                    }
                } finally {
                    this._selecting = null;
                }
            } catch (CancelledKeyException e3) {
                e = e3;
                logger = SelectorManager.LOG;
                logger.ignore(e);
            } catch (ClosedSelectorException e4) {
                e = e4;
                if (SelectorManager.this.isRunning()) {
                    SelectorManager.LOG.warn(e);
                } else {
                    logger = SelectorManager.LOG;
                    logger.ignore(e);
                }
            }
            socketChannel.close();
            for (SelectionKey selectionKey : selector.selectedKeys()) {
                try {
                    try {
                        if (!selectionKey.isValid()) {
                            selectionKey.cancel();
                            SelectChannelEndPoint selectChannelEndPoint2 = (SelectChannelEndPoint) selectionKey.attachment();
                            if (selectChannelEndPoint2 != null) {
                                selectChannelEndPoint2.doUpdateKey();
                            }
                        } else {
                            Object attachment = selectionKey.attachment();
                            if (!(attachment instanceof SelectChannelEndPoint)) {
                                if (selectionKey.isConnectable()) {
                                    socketChannel = (SocketChannel) selectionKey.channel();
                                    try {
                                        try {
                                        } catch (Exception e5) {
                                            SelectorManager.this.connectionFailed(socketChannel, e5, attachment);
                                            selectionKey.cancel();
                                        }
                                        if (socketChannel.finishConnect()) {
                                            try {
                                                selectionKey.interestOps(1);
                                                createEndPoint = createEndPoint(socketChannel, selectionKey);
                                                selectionKey.attach(createEndPoint);
                                            } catch (Exception e6) {
                                                e = e6;
                                                if (SelectorManager.this.isRunning()) {
                                                    SelectorManager.LOG.warn(e);
                                                } else {
                                                    SelectorManager.LOG.ignore(e);
                                                }
                                                if (socketChannel != null) {
                                                    try {
                                                        socketChannel.close();
                                                    } catch (IOException e7) {
                                                        SelectorManager.LOG.debug(e7);
                                                    }
                                                }
                                                if (selectionKey != null && !(selectionKey.channel() instanceof ServerSocketChannel) && selectionKey.isValid()) {
                                                    selectionKey.cancel();
                                                }
                                            }
                                        } else {
                                            selectionKey.cancel();
                                            socketChannel.close();
                                        }
                                    } catch (Throwable th5) {
                                        selectionKey.cancel();
                                        socketChannel.close();
                                        throw th5;
                                        break;
                                    }
                                } else {
                                    socketChannel = (SocketChannel) selectionKey.channel();
                                    createEndPoint = createEndPoint(socketChannel, selectionKey);
                                    selectionKey.attach(createEndPoint);
                                    if (selectionKey.isReadable()) {
                                    }
                                }
                                createEndPoint.schedule();
                            } else if (selectionKey.isReadable() || selectionKey.isWritable()) {
                                ((SelectChannelEndPoint) attachment).schedule();
                            }
                        }
                    } catch (CancelledKeyException e8) {
                        SelectorManager.LOG.ignore(e8);
                    }
                } catch (Exception e9) {
                    e = e9;
                    socketChannel = null;
                }
            }
            selector.selectedKeys().clear();
            currentTimeMillis = System.currentTimeMillis();
            this._timeout.setNow(currentTimeMillis);
            timeout = this._timeout;
            while (true) {
                expired = timeout.expired();
                if (expired != null) {
                    break;
                }
                if (expired instanceof Runnable) {
                    SelectorManager.this.dispatch((Runnable) expired);
                }
                timeout = this._timeout;
            }
            if (currentTimeMillis - this._idleTick > SelectorManager.__IDLE_TICK) {
                this._idleTick = currentTimeMillis;
                final long j = (SelectorManager.this._lowResourcesConnections <= 0 || ((long) selector.keys().size()) <= SelectorManager.this._lowResourcesConnections) ? currentTimeMillis : (SelectorManager.this._maxIdleTime + currentTimeMillis) - SelectorManager.this._lowResourcesMaxIdleTime;
                SelectorManager.this.dispatch(new Runnable() { // from class: org.eclipse.jetty.io.nio.SelectorManager.SelectSet.1
                    @Override // java.lang.Runnable
                    public void run() {
                        for (SelectChannelEndPoint selectChannelEndPoint3 : SelectSet.this._endPoints.keySet()) {
                            selectChannelEndPoint3.checkIdleTimestamp(j);
                        }
                    }

                    public String toString() {
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Idle-");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(super.toString());
                        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
                    }
                });
            }
            if (SelectorManager.__MONITOR_PERIOD > 0 && currentTimeMillis > this._monitorNext) {
                this._busySelects = 0;
                this._pausing = false;
                this._monitorNext = currentTimeMillis + SelectorManager.__MONITOR_PERIOD;
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            this._timeout.setNow(currentTimeMillis2);
            long timeToNext = this._timeout.getTimeToNext();
            long j2 = this._changes.size() == 0 ? SelectorManager.__IDLE_TICK : 0L;
            if (j2 <= 0 || timeToNext < 0 || j2 <= timeToNext) {
                timeToNext = j2;
            }
            if (timeToNext > 0) {
                selector.select(timeToNext);
                long currentTimeMillis3 = System.currentTimeMillis();
                this._timeout.setNow(currentTimeMillis3);
                if (SelectorManager.__MONITOR_PERIOD > 0 && currentTimeMillis3 - currentTimeMillis2 <= 1) {
                    int i2 = this._busySelects + 1;
                    this._busySelects = i2;
                    if (i2 > SelectorManager.__MAX_SELECTS) {
                        this._pausing = true;
                        if (!this._paused) {
                            this._paused = true;
                            SelectorManager.LOG.warn("Selector {} is too busy, pausing!", this);
                        }
                    }
                }
            }
            if (this._selector != null && selector.isOpen()) {
                while (r2.hasNext()) {
                }
                selector.selectedKeys().clear();
                currentTimeMillis = System.currentTimeMillis();
                this._timeout.setNow(currentTimeMillis);
                timeout = this._timeout;
                while (true) {
                    expired = timeout.expired();
                    if (expired != null) {
                    }
                    timeout = this._timeout;
                }
                if (currentTimeMillis - this._idleTick > SelectorManager.__IDLE_TICK) {
                }
                if (SelectorManager.__MONITOR_PERIOD > 0) {
                    this._busySelects = 0;
                    this._pausing = false;
                    this._monitorNext = currentTimeMillis + SelectorManager.__MONITOR_PERIOD;
                }
            }
        }

        @Override // org.eclipse.jetty.util.component.Dumpable
        public String dump() {
            return AggregateLifeCycle.dump(this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.StackTraceElement] */
        @Override // org.eclipse.jetty.util.component.Dumpable
        public void dump(Appendable appendable, String str) throws IOException {
            ?? r4;
            appendable.append(String.valueOf(this)).append(" id=").append(String.valueOf(this._setID)).append("\n");
            Thread thread = this._selecting;
            StackTraceElement[] stackTrace = thread == null ? null : thread.getStackTrace();
            if (stackTrace != null) {
                int length = stackTrace.length;
                for (int i = 0; i < length; i++) {
                    r4 = stackTrace[i];
                    if (r4.getClassName().startsWith("org.eclipse.jetty.")) {
                        break;
                    }
                }
            }
            r4 = "not selecting";
            Selector selector = this._selector;
            if (selector != null) {
                final ArrayList arrayList = new ArrayList(selector.keys().size() * 2);
                arrayList.add(r4);
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                addChange(new ChangeTask() { // from class: org.eclipse.jetty.io.nio.SelectorManager.SelectSet.3
                    @Override // java.lang.Runnable
                    public void run() {
                        SelectSet.this.dumpKeyState(arrayList);
                        countDownLatch.countDown();
                    }
                });
                try {
                    countDownLatch.await(5L, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    SelectorManager.LOG.ignore(e);
                }
                AggregateLifeCycle.dump(appendable, str, arrayList);
            }
        }

        public void dumpKeyState(List<Object> list) {
            StringBuilder sb;
            Selector selector = this._selector;
            Set<SelectionKey> keys = selector.keys();
            list.add(selector + " keys=" + keys.size());
            for (SelectionKey selectionKey : keys) {
                if (selectionKey.isValid()) {
                    sb = new StringBuilder();
                    sb.append(selectionKey.attachment());
                    sb.append(" iOps=");
                    sb.append(selectionKey.interestOps());
                    sb.append(" rOps=");
                    sb.append(selectionKey.readyOps());
                } else {
                    sb = new StringBuilder();
                    sb.append(selectionKey.attachment());
                    sb.append(" iOps=-1 rOps=-1");
                }
                list.add(sb.toString());
            }
        }

        public SelectorManager getManager() {
            return SelectorManager.this;
        }

        public long getNow() {
            return this._timeout.getNow();
        }

        public Selector getSelector() {
            return this._selector;
        }

        public void scheduleTimeout(Timeout.Task task, long j) {
            if (task instanceof Runnable) {
                this._timeout.schedule(task, j);
                return;
            }
            throw new IllegalArgumentException("!Runnable");
        }

        public void stop() throws Exception {
            for (int i = 0; i < 100; i++) {
                try {
                    if (this._selecting == null) {
                        break;
                    }
                    wakeup();
                    Thread.sleep(10L);
                } catch (Exception e) {
                    SelectorManager.LOG.ignore(e);
                }
            }
            synchronized (this) {
                for (SelectionKey selectionKey : this._selector.keys()) {
                    if (selectionKey != null) {
                        Object attachment = selectionKey.attachment();
                        if (attachment instanceof EndPoint) {
                            try {
                                ((EndPoint) attachment).close();
                            } catch (IOException e2) {
                                SelectorManager.LOG.ignore(e2);
                            }
                        }
                    }
                }
                this._timeout.cancelAll();
                try {
                    Selector selector = this._selector;
                    if (selector != null) {
                        selector.close();
                    }
                } catch (IOException e3) {
                    SelectorManager.LOG.ignore(e3);
                }
                this._selector = null;
            }
        }

        public String toString() {
            Selector selector = this._selector;
            Object[] objArr = new Object[3];
            objArr[0] = super.toString();
            int i = -1;
            objArr[1] = Integer.valueOf((selector == null || !selector.isOpen()) ? -1 : selector.keys().size());
            if (selector != null && selector.isOpen()) {
                i = selector.selectedKeys().size();
            }
            objArr[2] = Integer.valueOf(i);
            return String.format("%s keys=%d selected=%d", objArr);
        }

        public void wakeup() {
            try {
                Selector selector = this._selector;
                if (selector == null) {
                    return;
                }
                selector.wakeup();
            } catch (Exception unused) {
                addChange(new ChangeTask() { // from class: org.eclipse.jetty.io.nio.SelectorManager.SelectSet.2
                    @Override // java.lang.Runnable
                    public void run() {
                        SelectSet.this.renewSelector();
                    }
                });
                renewSelector();
            }
        }
    }

    public void connectionFailed(SocketChannel socketChannel, Throwable th, Object obj) {
        Logger logger = LOG;
        logger.warn(th + "," + socketChannel + "," + obj, new Object[0]);
        LOG.debug(th);
    }

    public abstract boolean dispatch(Runnable runnable);

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        this._selectSet = new SelectSet[this._selectSets];
        int i = 0;
        while (true) {
            SelectSet[] selectSetArr = this._selectSet;
            if (i >= selectSetArr.length) {
                break;
            }
            selectSetArr[i] = new SelectSet(i);
            i++;
        }
        super.doStart();
        for (final int i2 = 0; i2 < getSelectSets(); i2++) {
            if (!dispatch(new Runnable() { // from class: org.eclipse.jetty.io.nio.SelectorManager.1
                @Override // java.lang.Runnable
                public void run() {
                    String name = Thread.currentThread().getName();
                    int priority = Thread.currentThread().getPriority();
                    try {
                        SelectSet[] selectSetArr2 = SelectorManager.this._selectSet;
                        if (selectSetArr2 == null) {
                            SelectorManager.LOG.debug("Stopped {} on {}", Thread.currentThread(), this);
                            Thread.currentThread().setName(name);
                            if (SelectorManager.this.getSelectorPriorityDelta() == 0) {
                                return;
                            }
                            Thread.currentThread().setPriority(priority);
                            return;
                        }
                        SelectSet selectSet = selectSetArr2[i2];
                        Thread currentThread = Thread.currentThread();
                        currentThread.setName(name + " Selector" + i2);
                        if (SelectorManager.this.getSelectorPriorityDelta() != 0) {
                            Thread.currentThread().setPriority(Thread.currentThread().getPriority() + SelectorManager.this.getSelectorPriorityDelta());
                        }
                        SelectorManager.LOG.debug("Starting {} on {}", Thread.currentThread(), this);
                        while (SelectorManager.this.isRunning()) {
                            try {
                                selectSet.doSelect();
                            } catch (IOException e) {
                                SelectorManager.LOG.ignore(e);
                            } catch (Exception e2) {
                                SelectorManager.LOG.warn(e2);
                            }
                        }
                        SelectorManager.LOG.debug("Stopped {} on {}", Thread.currentThread(), this);
                        Thread.currentThread().setName(name);
                        if (SelectorManager.this.getSelectorPriorityDelta() == 0) {
                            return;
                        }
                        Thread.currentThread().setPriority(priority);
                    } catch (Throwable th) {
                        SelectorManager.LOG.debug("Stopped {} on {}", Thread.currentThread(), this);
                        Thread.currentThread().setName(name);
                        if (SelectorManager.this.getSelectorPriorityDelta() != 0) {
                            Thread.currentThread().setPriority(priority);
                        }
                        throw th;
                    }
                }
            })) {
                throw new IllegalStateException("!Selecting");
            }
        }
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        SelectSet[] selectSetArr = this._selectSet;
        this._selectSet = null;
        if (selectSetArr != null) {
            for (SelectSet selectSet : selectSetArr) {
                if (selectSet != null) {
                    selectSet.stop();
                }
            }
        }
        super.doStop();
    }

    @Override // org.eclipse.jetty.util.component.Dumpable
    public String dump() {
        return AggregateLifeCycle.dump(this);
    }

    @Override // org.eclipse.jetty.util.component.Dumpable
    public void dump(Appendable appendable, String str) throws IOException {
        AggregateLifeCycle.dumpObject(appendable, this);
        AggregateLifeCycle.dump(appendable, str, TypeUtil.asList(this._selectSet));
    }

    public abstract void endPointClosed(SelectChannelEndPoint selectChannelEndPoint);

    public abstract void endPointOpened(SelectChannelEndPoint selectChannelEndPoint);

    public abstract void endPointUpgraded(ConnectedEndPoint connectedEndPoint, Connection connection);

    public long getLowResourcesConnections() {
        return this._lowResourcesConnections * this._selectSets;
    }

    public long getLowResourcesMaxIdleTime() {
        return this._lowResourcesMaxIdleTime;
    }

    public long getMaxIdleTime() {
        return this._maxIdleTime;
    }

    public SelectSet getSelectSet(int i) {
        return this._selectSet[i];
    }

    public int getSelectSets() {
        return this._selectSets;
    }

    public int getSelectorPriorityDelta() {
        return this._selectorPriorityDelta;
    }

    public boolean isDeferringInterestedOps0() {
        return this._deferringInterestedOps0;
    }

    public abstract AsyncConnection newConnection(SocketChannel socketChannel, AsyncEndPoint asyncEndPoint, Object obj);

    public abstract SelectChannelEndPoint newEndPoint(SocketChannel socketChannel, SelectSet selectSet, SelectionKey selectionKey) throws IOException;

    public void register(ServerSocketChannel serverSocketChannel) {
        int i = this._set;
        this._set = i + 1;
        if (i < 0) {
            i = -i;
        }
        SelectSet selectSet = this._selectSet[i % this._selectSets];
        selectSet.addChange(serverSocketChannel);
        selectSet.wakeup();
    }

    public void register(SocketChannel socketChannel) {
        int i = this._set;
        this._set = i + 1;
        if (i < 0) {
            i = -i;
        }
        int i2 = i % this._selectSets;
        SelectSet[] selectSetArr = this._selectSet;
        if (selectSetArr != null) {
            SelectSet selectSet = selectSetArr[i2];
            selectSet.addChange(socketChannel);
            selectSet.wakeup();
        }
    }

    public void register(SocketChannel socketChannel, Object obj) {
        int i = this._set;
        this._set = i + 1;
        if (i < 0) {
            i = -i;
        }
        int i2 = i % this._selectSets;
        SelectSet[] selectSetArr = this._selectSet;
        if (selectSetArr != null) {
            SelectSet selectSet = selectSetArr[i2];
            selectSet.addChange(socketChannel, obj);
            selectSet.wakeup();
        }
    }

    public void setDeferringInterestedOps0(boolean z) {
        this._deferringInterestedOps0 = z;
    }

    public void setLowResourcesConnections(long j) {
        int i = this._selectSets;
        this._lowResourcesConnections = ((j + i) - 1) / i;
    }

    public void setLowResourcesMaxIdleTime(long j) {
        this._lowResourcesMaxIdleTime = (int) j;
    }

    public void setMaxIdleTime(long j) {
        this._maxIdleTime = (int) j;
    }

    public void setSelectSets(int i) {
        this._selectSets = i;
        this._lowResourcesConnections = (this._lowResourcesConnections * this._selectSets) / i;
    }

    public void setSelectorPriorityDelta(int i) {
        this._selectorPriorityDelta = i;
    }
}
