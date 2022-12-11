package org.eclipse.jetty.p059io.nio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.Locale;
import me.tvspark.outline;
import org.apache.commons.p056io.input.Tailer;
import org.eclipse.jetty.p059io.AsyncEndPoint;
import org.eclipse.jetty.p059io.Buffer;
import org.eclipse.jetty.p059io.ConnectedEndPoint;
import org.eclipse.jetty.p059io.Connection;
import org.eclipse.jetty.p059io.EofException;
import org.eclipse.jetty.p059io.nio.SelectorManager;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.Timeout;

/* renamed from: org.eclipse.jetty.io.nio.SelectChannelEndPoint */
/* loaded from: classes4.dex */
public class SelectChannelEndPoint extends ChannelEndPoint implements AsyncEndPoint, ConnectedEndPoint {
    public static final Logger LOG = Log.getLogger("org.eclipse.jetty.io.nio");
    public static final int STATE_ASYNC = 2;
    public static final int STATE_DISPATCHED = 1;
    public static final int STATE_NEEDS_DISPATCH = -1;
    public static final int STATE_UNDISPATCHED = 0;
    public volatile boolean _checkIdle;
    public volatile AsyncConnection _connection;
    public volatile long _idleTimestamp;
    public int _interestOps;
    public boolean _interruptable;
    public boolean _ishut;
    public SelectionKey _key;
    public final SelectorManager _manager;
    public boolean _readBlocked;
    public final SelectorManager.SelectSet _selectSet;
    public boolean _writeBlocked;
    public final boolean WORK_AROUND_JVM_BUG_6346658 = System.getProperty("os.name").toLowerCase(Locale.ENGLISH).contains("win");
    public final Runnable _handler = new Runnable() { // from class: org.eclipse.jetty.io.nio.SelectChannelEndPoint.1
        @Override // java.lang.Runnable
        public void run() {
            SelectChannelEndPoint.this.handle();
        }
    };
    public volatile boolean _writable = true;
    public int _state = 0;
    public boolean _onIdle = false;
    public boolean _open = true;

    public SelectChannelEndPoint(SocketChannel socketChannel, SelectorManager.SelectSet selectSet, SelectionKey selectionKey, int i) throws IOException {
        super(socketChannel, i);
        this._manager = selectSet.getManager();
        this._selectSet = selectSet;
        this._key = selectionKey;
        setCheckForIdle(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x003a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0047 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0053 A[Catch: Exception -> 0x0063, all -> 0x007f, TryCatch #0 {Exception -> 0x0063, blocks: (B:31:0x004f, B:33:0x0053, B:35:0x005b), top: B:30:0x004f, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void updateKey() {
        boolean z;
        boolean z2;
        boolean z3;
        synchronized (this) {
            int i = -1;
            z = false;
            if (getChannel().isOpen()) {
                try {
                    if (!this._readBlocked && (this._state >= 1 || this._connection.isSuspended())) {
                        z2 = false;
                        if (!this._writeBlocked && (this._state >= 1 || this._writable)) {
                            z3 = false;
                            this._interestOps = ((!this._socket.isInputShutdown() || !z2) ? 0 : 1) | ((!this._socket.isOutputShutdown() || !z3) ? 0 : 4);
                            if (this._key != null && this._key.isValid()) {
                                i = this._key.interestOps();
                            }
                        }
                        z3 = true;
                        this._interestOps = ((!this._socket.isInputShutdown() || !z2) ? 0 : 1) | ((!this._socket.isOutputShutdown() || !z3) ? 0 : 4);
                        if (this._key != null) {
                            i = this._key.interestOps();
                        }
                    }
                    if (!this._writeBlocked) {
                        z3 = false;
                        this._interestOps = ((!this._socket.isInputShutdown() || !z2) ? 0 : 1) | ((!this._socket.isOutputShutdown() || !z3) ? 0 : 4);
                        if (this._key != null) {
                        }
                    }
                    if (this._key != null) {
                    }
                } catch (Exception e) {
                    this._key = null;
                    LOG.ignore(e);
                }
                z2 = true;
                z3 = true;
                this._interestOps = ((!this._socket.isInputShutdown() || !z2) ? 0 : 1) | ((!this._socket.isOutputShutdown() || !z3) ? 0 : 4);
            }
            if (this._interestOps != i) {
                z = true;
            }
        }
        if (z) {
            this._selectSet.addChange(this);
            this._selectSet.wakeup();
        }
    }

    @Override // org.eclipse.jetty.p059io.AsyncEndPoint
    public void asyncDispatch() {
        synchronized (this) {
            int i = this._state;
            if (i == -1 || i == 0) {
                dispatch();
            } else if (i == 1 || i == 2) {
                this._state = 2;
            }
        }
    }

    @Override // org.eclipse.jetty.p059io.nio.ChannelEndPoint, org.eclipse.jetty.p059io.EndPoint
    public boolean blockReadable(long j) throws IOException {
        SelectorManager.SelectSet selectSet;
        synchronized (this) {
            if (!isInputShutdown()) {
                long now = this._selectSet.getNow();
                long j2 = now + j;
                boolean isCheckForIdle = isCheckForIdle();
                setCheckForIdle(true);
                this._readBlocked = true;
                while (!isInputShutdown() && this._readBlocked) {
                    try {
                        updateKey();
                        wait(j > 0 ? j2 - now : 10000L);
                        selectSet = this._selectSet;
                    } catch (InterruptedException e) {
                        LOG.warn(e);
                        if (this._interruptable) {
                            throw new InterruptedIOException() { // from class: org.eclipse.jetty.io.nio.SelectChannelEndPoint.3
                                {
                                    initCause(e);
                                }
                            };
                        }
                        selectSet = this._selectSet;
                    }
                    now = selectSet.getNow();
                    if (this._readBlocked && j > 0 && now >= j2) {
                        this._readBlocked = false;
                        setCheckForIdle(isCheckForIdle);
                        return false;
                    }
                }
                this._readBlocked = false;
                setCheckForIdle(isCheckForIdle);
                return true;
            }
            throw new EofException();
        }
    }

    @Override // org.eclipse.jetty.p059io.nio.ChannelEndPoint, org.eclipse.jetty.p059io.EndPoint
    public boolean blockWritable(long j) throws IOException {
        SelectorManager.SelectSet selectSet;
        synchronized (this) {
            if (!isOutputShutdown()) {
                long now = this._selectSet.getNow();
                long j2 = now + j;
                boolean isCheckForIdle = isCheckForIdle();
                setCheckForIdle(true);
                this._writeBlocked = true;
                while (this._writeBlocked && !isOutputShutdown()) {
                    try {
                        updateKey();
                        wait(j > 0 ? j2 - now : 10000L);
                        selectSet = this._selectSet;
                    } catch (InterruptedException e) {
                        LOG.warn(e);
                        if (this._interruptable) {
                            throw new InterruptedIOException() { // from class: org.eclipse.jetty.io.nio.SelectChannelEndPoint.4
                                {
                                    initCause(e);
                                }
                            };
                        }
                        selectSet = this._selectSet;
                    }
                    now = selectSet.getNow();
                    if (this._writeBlocked && j > 0 && now >= j2) {
                        this._writeBlocked = false;
                        setCheckForIdle(isCheckForIdle);
                        return false;
                    }
                }
                this._writeBlocked = false;
                setCheckForIdle(isCheckForIdle);
                return true;
            }
            throw new EofException();
        }
    }

    @Override // org.eclipse.jetty.p059io.AsyncEndPoint
    public void cancelTimeout(Timeout.Task task) {
        getSelectSet().cancelTimeout(task);
    }

    public void checkIdleTimestamp(long j) {
        if (!isCheckForIdle() || this._maxIdleTime <= 0) {
            return;
        }
        final long j2 = j - this._idleTimestamp;
        if (j2 <= this._maxIdleTime) {
            return;
        }
        setCheckForIdle(false);
        this._manager.dispatch(new Runnable() { // from class: org.eclipse.jetty.io.nio.SelectChannelEndPoint.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SelectChannelEndPoint.this.onIdleExpired(j2);
                } finally {
                    SelectChannelEndPoint.this.setCheckForIdle(true);
                }
            }
        });
    }

    @Override // org.eclipse.jetty.p059io.nio.ChannelEndPoint, org.eclipse.jetty.p059io.EndPoint
    public void close() throws IOException {
        if (this.WORK_AROUND_JVM_BUG_6346658) {
            try {
                SelectionKey selectionKey = this._key;
                if (selectionKey != null) {
                    selectionKey.cancel();
                }
            } catch (Throwable th) {
                LOG.ignore(th);
            }
        }
        try {
            try {
                super.close();
            } finally {
                updateKey();
            }
        } catch (IOException e) {
            LOG.ignore(e);
        }
    }

    @Override // org.eclipse.jetty.p059io.AsyncEndPoint
    public void dispatch() {
        synchronized (this) {
            if (this._state <= 0) {
                if (this._onIdle) {
                    this._state = -1;
                } else {
                    this._state = 1;
                    if (!this._manager.dispatch(this._handler)) {
                        this._state = -1;
                        Logger logger = LOG;
                        logger.warn("Dispatched Failed! " + this + " to " + this._manager, new Object[0]);
                        updateKey();
                    }
                }
            }
        }
    }

    public void doUpdateKey() {
        SelectionKey selectionKey;
        synchronized (this) {
            int i = 0;
            if (getChannel().isOpen()) {
                if (this._interestOps > 0) {
                    if (this._key != null && this._key.isValid()) {
                        selectionKey = this._key;
                        i = this._interestOps;
                    }
                    if (((SelectableChannel) getChannel()).isRegistered()) {
                        updateKey();
                    } else {
                        try {
                            this._key = ((SelectableChannel) getChannel()).register(this._selectSet.getSelector(), this._interestOps, this);
                        } catch (Exception e) {
                            LOG.ignore(e);
                            if (this._key != null && this._key.isValid()) {
                                this._key.cancel();
                            }
                            if (this._open) {
                                this._selectSet.destroyEndPoint(this);
                            }
                            this._open = false;
                        }
                    }
                } else if (this._key != null && this._key.isValid()) {
                    selectionKey = this._key;
                }
                selectionKey.interestOps(i);
            } else {
                if (this._key != null && this._key.isValid()) {
                    this._key.cancel();
                }
                if (this._open) {
                    this._open = false;
                    this._selectSet.destroyEndPoint(this);
                }
            }
            this._key = null;
        }
    }

    @Override // org.eclipse.jetty.p059io.nio.ChannelEndPoint, org.eclipse.jetty.p059io.EndPoint
    public int fill(Buffer buffer) throws IOException {
        int fill = super.fill(buffer);
        if (fill > 0) {
            notIdle();
        }
        return fill;
    }

    @Override // org.eclipse.jetty.p059io.nio.ChannelEndPoint, org.eclipse.jetty.p059io.EndPoint
    public int flush(Buffer buffer) throws IOException {
        int flush = super.flush(buffer);
        if (flush == 0 && buffer.hasContent()) {
            synchronized (this) {
                this._writable = false;
                if (this._state < 1) {
                    updateKey();
                }
            }
        } else if (flush > 0) {
            this._writable = true;
            notIdle();
        }
        return flush;
    }

    @Override // org.eclipse.jetty.p059io.nio.ChannelEndPoint, org.eclipse.jetty.p059io.EndPoint
    public int flush(Buffer buffer, Buffer buffer2, Buffer buffer3) throws IOException {
        int flush = super.flush(buffer, buffer2, buffer3);
        if (flush == 0 && ((buffer != null && buffer.hasContent()) || ((buffer2 != null && buffer2.hasContent()) || (buffer3 != null && buffer3.hasContent())))) {
            synchronized (this) {
                this._writable = false;
                if (this._state < 1) {
                    updateKey();
                }
            }
        } else if (flush > 0) {
            this._writable = true;
            notIdle();
        }
        return flush;
    }

    @Override // org.eclipse.jetty.p059io.ConnectedEndPoint
    public Connection getConnection() {
        return this._connection;
    }

    public long getIdleTimestamp() {
        return this._idleTimestamp;
    }

    public SelectorManager getSelectManager() {
        return this._manager;
    }

    public SelectorManager.SelectSet getSelectSet() {
        return this._selectSet;
    }

    public SelectionKey getSelectionKey() {
        SelectionKey selectionKey;
        synchronized (this) {
            selectionKey = this._key;
        }
        return selectionKey;
    }

    public void handle() {
        boolean z = true;
        while (z) {
            while (true) {
                try {
                    try {
                        try {
                            AsyncConnection asyncConnection = (AsyncConnection) this._connection.handle();
                            if (asyncConnection == this._connection) {
                                try {
                                    break;
                                } catch (Throwable th) {
                                    if (z) {
                                        while (!undispatch()) {
                                            LOG.warn("SCEP.run() finally DISPATCHED", new Object[0]);
                                        }
                                    }
                                    throw th;
                                }
                            }
                            LOG.debug("{} replaced {}", asyncConnection, this._connection);
                            AsyncConnection asyncConnection2 = this._connection;
                            this._connection = asyncConnection;
                            this._manager.endPointUpgraded(this, asyncConnection2);
                        } catch (IOException e) {
                            LOG.warn(e.toString(), new Object[0]);
                            try {
                                close();
                            } catch (IOException e2) {
                                LOG.ignore(e2);
                            }
                            if (!this._ishut && isInputShutdown() && isOpen()) {
                                this._ishut = true;
                                this._connection.onInputShutdown();
                                updateKey();
                            }
                        }
                    } catch (ClosedChannelException e3) {
                        LOG.ignore(e3);
                        if (!this._ishut && isInputShutdown() && isOpen()) {
                            this._ishut = true;
                            this._connection.onInputShutdown();
                            updateKey();
                        }
                    }
                } catch (EofException e4) {
                    LOG.debug("EOF", e4);
                    try {
                        close();
                    } catch (IOException e5) {
                        LOG.ignore(e5);
                    }
                    if (!this._ishut && isInputShutdown() && isOpen()) {
                        this._ishut = true;
                        this._connection.onInputShutdown();
                        updateKey();
                    }
                } catch (Throwable th2) {
                    LOG.warn("handle failed", th2);
                    try {
                        close();
                    } catch (IOException e6) {
                        LOG.ignore(e6);
                    }
                    if (!this._ishut && isInputShutdown() && isOpen()) {
                        this._ishut = true;
                        this._connection.onInputShutdown();
                        updateKey();
                    }
                }
            }
            if (!this._ishut && isInputShutdown() && isOpen()) {
                this._ishut = true;
                this._connection.onInputShutdown();
                updateKey();
            }
            z = !undispatch();
        }
        if (z) {
            while (!undispatch()) {
                LOG.warn("SCEP.run() finally DISPATCHED", new Object[0]);
            }
        }
    }

    @Override // org.eclipse.jetty.p059io.AsyncEndPoint
    public boolean hasProgressed() {
        return false;
    }

    @Override // org.eclipse.jetty.p059io.AsyncEndPoint
    public boolean isCheckForIdle() {
        return this._checkIdle;
    }

    public boolean isInterruptable() {
        return this._interruptable;
    }

    @Override // org.eclipse.jetty.p059io.AsyncEndPoint
    public boolean isWritable() {
        return this._writable;
    }

    public void notIdle() {
        this._idleTimestamp = System.currentTimeMillis();
    }

    @Override // org.eclipse.jetty.p059io.AsyncEndPoint
    public void onIdleExpired(long j) {
        try {
            synchronized (this) {
                this._onIdle = true;
            }
            this._connection.onIdleExpired(j);
            synchronized (this) {
                this._onIdle = false;
                if (this._state == -1) {
                    dispatch();
                }
            }
        } catch (Throwable th) {
            synchronized (this) {
                this._onIdle = false;
                if (this._state == -1) {
                    dispatch();
                }
                throw th;
            }
        }
    }

    public void schedule() {
        SelectionKey selectionKey;
        synchronized (this) {
            if (this._key != null && this._key.isValid()) {
                if (!this._readBlocked && !this._writeBlocked) {
                    if ((this._key.readyOps() & 4) == 4 && (this._key.interestOps() & 4) == 4) {
                        int interestOps = this._key.interestOps() & (-5);
                        this._interestOps = interestOps;
                        this._key.interestOps(interestOps);
                        this._writable = true;
                    }
                    if (this._state < 1) {
                        dispatch();
                        if (this._state >= 1 && !this._selectSet.getManager().isDeferringInterestedOps0()) {
                            selectionKey = this._key;
                        }
                        return;
                    }
                    selectionKey = this._key;
                    selectionKey.interestOps(0);
                    return;
                }
                if (this._readBlocked && this._key.isReadable()) {
                    this._readBlocked = false;
                }
                if (this._writeBlocked && this._key.isWritable()) {
                    this._writeBlocked = false;
                }
                notifyAll();
                this._key.interestOps(0);
                if (this._state < 1) {
                    updateKey();
                }
                return;
            }
            this._readBlocked = false;
            this._writeBlocked = false;
            notifyAll();
        }
    }

    @Override // org.eclipse.jetty.p059io.AsyncEndPoint
    public void scheduleTimeout(Timeout.Task task, long j) {
        getSelectSet().scheduleTimeout(task, j);
    }

    @Override // org.eclipse.jetty.p059io.AsyncEndPoint
    public void scheduleWrite() {
        if (this._writable) {
            LOG.debug("Required scheduleWrite {}", this);
        }
        this._writable = false;
        updateKey();
    }

    @Override // org.eclipse.jetty.p059io.AsyncEndPoint
    public void setCheckForIdle(boolean z) {
        boolean z2;
        if (z) {
            this._idleTimestamp = System.currentTimeMillis();
            z2 = true;
        } else {
            z2 = false;
        }
        this._checkIdle = z2;
    }

    @Override // org.eclipse.jetty.p059io.ConnectedEndPoint
    public void setConnection(Connection connection) {
        AsyncConnection asyncConnection = this._connection;
        this._connection = (AsyncConnection) connection;
        if (asyncConnection == null || asyncConnection == this._connection) {
            return;
        }
        this._manager.endPointUpgraded(this, asyncConnection);
    }

    public void setInterruptable(boolean z) {
        synchronized (this) {
            this._interruptable = z;
        }
    }

    @Override // org.eclipse.jetty.p059io.nio.ChannelEndPoint, org.eclipse.jetty.p059io.EndPoint
    public void setMaxIdleTime(int i) throws IOException {
        this._maxIdleTime = i;
    }

    public String toString() {
        String str;
        SelectionKey selectionKey = this._key;
        if (selectionKey == null) {
            str = "-";
        } else if (selectionKey.isValid()) {
            str = selectionKey.isReadable() ? Tailer.RAF_MODE : "";
            if (selectionKey.isWritable()) {
                str = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "w");
            }
        } else {
            str = "!";
        }
        return String.format("SCEP@%x{l(%s)<->r(%s),s=%d,open=%b,ishut=%b,oshut=%b,rb=%b,wb=%b,w=%b,i=%d%s}-{%s}", Integer.valueOf(hashCode()), this._socket.getRemoteSocketAddress(), this._socket.getLocalSocketAddress(), Integer.valueOf(this._state), Boolean.valueOf(isOpen()), Boolean.valueOf(isInputShutdown()), Boolean.valueOf(isOutputShutdown()), Boolean.valueOf(this._readBlocked), Boolean.valueOf(this._writeBlocked), Boolean.valueOf(this._writable), Integer.valueOf(this._interestOps), str, this._connection);
    }

    public boolean undispatch() {
        synchronized (this) {
            if (this._state == 2) {
                this._state = 1;
                return false;
            }
            this._state = 0;
            updateKey();
            return true;
        }
    }
}
