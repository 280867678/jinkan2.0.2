package org.eclipse.jetty.p059io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SocketChannel;
import org.eclipse.jetty.p059io.Buffer;
import org.eclipse.jetty.p059io.EndPoint;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* renamed from: org.eclipse.jetty.io.nio.ChannelEndPoint */
/* loaded from: classes4.dex */
public class ChannelEndPoint implements EndPoint {
    public static final Logger LOG = Log.getLogger(ChannelEndPoint.class);
    public final ByteChannel _channel;
    public final ByteBuffer[] _gather2;
    public volatile boolean _ishut;
    public final InetSocketAddress _local;
    public volatile int _maxIdleTime;
    public volatile boolean _oshut;
    public final InetSocketAddress _remote;
    public final Socket _socket;

    public ChannelEndPoint(ByteChannel byteChannel) throws IOException {
        this._gather2 = new ByteBuffer[2];
        this._channel = byteChannel;
        Socket socket = byteChannel instanceof SocketChannel ? ((SocketChannel) byteChannel).socket() : null;
        this._socket = socket;
        if (socket == null) {
            this._remote = null;
            this._local = null;
            return;
        }
        this._local = (InetSocketAddress) socket.getLocalSocketAddress();
        this._remote = (InetSocketAddress) this._socket.getRemoteSocketAddress();
        this._maxIdleTime = this._socket.getSoTimeout();
    }

    public ChannelEndPoint(ByteChannel byteChannel, int i) throws IOException {
        this._gather2 = new ByteBuffer[2];
        this._channel = byteChannel;
        this._maxIdleTime = i;
        Socket socket = byteChannel instanceof SocketChannel ? ((SocketChannel) byteChannel).socket() : null;
        this._socket = socket;
        if (socket == null) {
            this._remote = null;
            this._local = null;
            return;
        }
        this._local = (InetSocketAddress) socket.getLocalSocketAddress();
        this._remote = (InetSocketAddress) this._socket.getRemoteSocketAddress();
        this._socket.setSoTimeout(this._maxIdleTime);
    }

    @Override // org.eclipse.jetty.p059io.EndPoint
    public boolean blockReadable(long j) throws IOException {
        return true;
    }

    @Override // org.eclipse.jetty.p059io.EndPoint
    public boolean blockWritable(long j) throws IOException {
        return true;
    }

    @Override // org.eclipse.jetty.p059io.EndPoint
    public void close() throws IOException {
        LOG.debug("close {}", this);
        this._channel.close();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002e, code lost:
        if (r3 >= 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0080, code lost:
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0034, code lost:
        if (isOpen() == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003a, code lost:
        if (isInputShutdown() != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003c, code lost:
        shutdownInput();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0043, code lost:
        if (isOutputShutdown() == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0045, code lost:
        r5._channel.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004b, code lost:
        r6 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004c, code lost:
        r2 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0063, code lost:
        org.eclipse.jetty.p059io.nio.ChannelEndPoint.LOG.debug("Exception while filling", r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0070, code lost:
        if (r5._channel.isOpen() != false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0072, code lost:
        r5._channel.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007e, code lost:
        if (r2 <= 0) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0081, code lost:
        throw r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:?, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0078, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0079, code lost:
        org.eclipse.jetty.p059io.nio.ChannelEndPoint.LOG.ignore(r0);
     */
    @Override // org.eclipse.jetty.p059io.EndPoint
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int fill(Buffer buffer) throws IOException {
        if (this._ishut) {
            return -1;
        }
        Buffer buffer2 = buffer.buffer();
        if (!(buffer2 instanceof NIOBuffer)) {
            throw new IOException("Not Implemented");
        }
        ByteBuffer byteBuffer = ((NIOBuffer) buffer2).getByteBuffer();
        int i = 0;
        try {
            synchronized (byteBuffer) {
                try {
                    byteBuffer.position(buffer.putIndex());
                    int read = this._channel.read(byteBuffer);
                    try {
                        buffer.setPutIndex(byteBuffer.position());
                        byteBuffer.position(0);
                    } catch (Throwable th) {
                        i = read;
                        throw th;
                    }
                }
            }
            throw th;
        } catch (IOException e) {
            e = e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0042, code lost:
        if (r0 > 0) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0061, code lost:
        if (r0 > 0) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0026, code lost:
        if (r0 > 0) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0028, code lost:
        r5.skip(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0064, code lost:
        return r0;
     */
    @Override // org.eclipse.jetty.p059io.EndPoint
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int flush(Buffer buffer) throws IOException {
        int write;
        Buffer buffer2 = buffer.buffer();
        if (buffer2 instanceof NIOBuffer) {
            ByteBuffer asReadOnlyBuffer = ((NIOBuffer) buffer2).getByteBuffer().asReadOnlyBuffer();
            asReadOnlyBuffer.position(buffer.getIndex());
            asReadOnlyBuffer.limit(buffer.putIndex());
            write = this._channel.write(asReadOnlyBuffer);
        } else if (buffer2 instanceof RandomAccessFileBuffer) {
            write = ((RandomAccessFileBuffer) buffer2).writeTo(this._channel, buffer.getIndex(), buffer.length());
        } else if (buffer.array() == null) {
            throw new IOException("Not Implemented");
        } else {
            write = this._channel.write(ByteBuffer.wrap(buffer.array(), buffer.getIndex(), buffer.length()));
        }
    }

    @Override // org.eclipse.jetty.p059io.EndPoint
    public int flush(Buffer buffer, Buffer buffer2, Buffer buffer3) throws IOException {
        Buffer buffer4 = null;
        Buffer buffer5 = buffer == null ? null : buffer.buffer();
        if (buffer2 != null) {
            buffer4 = buffer2.buffer();
        }
        if (!(this._channel instanceof GatheringByteChannel) || buffer == null || buffer.length() == 0 || !(buffer5 instanceof NIOBuffer) || buffer2 == null || buffer2.length() == 0 || !(buffer4 instanceof NIOBuffer)) {
            int flush = (buffer == null || buffer.length() <= 0) ? 0 : flush(buffer);
            if ((buffer == null || buffer.length() == 0) && buffer2 != null && buffer2.length() > 0) {
                flush = flush(buffer2) + flush;
            }
            return ((buffer == null || buffer.length() == 0) && (buffer2 == null || buffer2.length() == 0) && buffer3 != null && buffer3.length() > 0) ? flush(buffer3) + flush : flush;
        }
        return gatheringFlush(buffer, ((NIOBuffer) buffer5).getByteBuffer(), buffer2, ((NIOBuffer) buffer4).getByteBuffer());
    }

    @Override // org.eclipse.jetty.p059io.EndPoint
    public void flush() throws IOException {
    }

    public int gatheringFlush(Buffer buffer, ByteBuffer byteBuffer, Buffer buffer2, ByteBuffer byteBuffer2) throws IOException {
        int write;
        synchronized (this) {
            ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            asReadOnlyBuffer.position(buffer.getIndex());
            asReadOnlyBuffer.limit(buffer.putIndex());
            ByteBuffer asReadOnlyBuffer2 = byteBuffer2.asReadOnlyBuffer();
            asReadOnlyBuffer2.position(buffer2.getIndex());
            asReadOnlyBuffer2.limit(buffer2.putIndex());
            this._gather2[0] = asReadOnlyBuffer;
            this._gather2[1] = asReadOnlyBuffer2;
            write = (int) ((GatheringByteChannel) this._channel).write(this._gather2);
            int length = buffer.length();
            if (write > length) {
                buffer.clear();
                buffer2.skip(write - length);
            } else if (write > 0) {
                buffer.skip(write);
            }
        }
        return write;
    }

    public ByteChannel getChannel() {
        return this._channel;
    }

    @Override // org.eclipse.jetty.p059io.EndPoint
    public String getLocalAddr() {
        if (this._socket == null) {
            return null;
        }
        InetSocketAddress inetSocketAddress = this._local;
        return (inetSocketAddress == null || inetSocketAddress.getAddress() == null || this._local.getAddress().isAnyLocalAddress()) ? StringUtil.ALL_INTERFACES : this._local.getAddress().getHostAddress();
    }

    @Override // org.eclipse.jetty.p059io.EndPoint
    public String getLocalHost() {
        if (this._socket == null) {
            return null;
        }
        InetSocketAddress inetSocketAddress = this._local;
        return (inetSocketAddress == null || inetSocketAddress.getAddress() == null || this._local.getAddress().isAnyLocalAddress()) ? StringUtil.ALL_INTERFACES : this._local.getAddress().getCanonicalHostName();
    }

    @Override // org.eclipse.jetty.p059io.EndPoint
    public int getLocalPort() {
        if (this._socket == null) {
            return 0;
        }
        InetSocketAddress inetSocketAddress = this._local;
        if (inetSocketAddress != null) {
            return inetSocketAddress.getPort();
        }
        return -1;
    }

    @Override // org.eclipse.jetty.p059io.EndPoint
    public int getMaxIdleTime() {
        return this._maxIdleTime;
    }

    @Override // org.eclipse.jetty.p059io.EndPoint
    public String getRemoteAddr() {
        InetSocketAddress inetSocketAddress;
        if (this._socket == null || (inetSocketAddress = this._remote) == null) {
            return null;
        }
        return inetSocketAddress.getAddress().getHostAddress();
    }

    @Override // org.eclipse.jetty.p059io.EndPoint
    public String getRemoteHost() {
        InetSocketAddress inetSocketAddress;
        if (this._socket == null || (inetSocketAddress = this._remote) == null) {
            return null;
        }
        return inetSocketAddress.getAddress().getCanonicalHostName();
    }

    @Override // org.eclipse.jetty.p059io.EndPoint
    public int getRemotePort() {
        if (this._socket == null) {
            return 0;
        }
        InetSocketAddress inetSocketAddress = this._remote;
        if (inetSocketAddress != null) {
            return inetSocketAddress.getPort();
        }
        return -1;
    }

    @Override // org.eclipse.jetty.p059io.EndPoint
    public Object getTransport() {
        return this._channel;
    }

    @Override // org.eclipse.jetty.p059io.EndPoint
    public boolean isBlocking() {
        ByteChannel byteChannel = this._channel;
        return !(byteChannel instanceof SelectableChannel) || ((SelectableChannel) byteChannel).isBlocking();
    }

    @Override // org.eclipse.jetty.p059io.EndPoint
    public boolean isInputShutdown() {
        Socket socket;
        return this._ishut || !this._channel.isOpen() || ((socket = this._socket) != null && socket.isInputShutdown());
    }

    @Override // org.eclipse.jetty.p059io.EndPoint
    public boolean isOpen() {
        return this._channel.isOpen();
    }

    @Override // org.eclipse.jetty.p059io.EndPoint
    public boolean isOutputShutdown() {
        Socket socket;
        return this._oshut || !this._channel.isOpen() || ((socket = this._socket) != null && socket.isOutputShutdown());
    }

    @Override // org.eclipse.jetty.p059io.EndPoint
    public void setMaxIdleTime(int i) throws IOException {
        if (this._socket != null && i != this._maxIdleTime) {
            this._socket.setSoTimeout(i > 0 ? i : 0);
        }
        this._maxIdleTime = i;
    }

    public final void shutdownChannelInput() throws IOException {
        Socket socket;
        LOG.debug("ishut {}", this);
        this._ishut = true;
        if (!this._channel.isOpen() || (socket = this._socket) == null) {
            return;
        }
        try {
            try {
                if (!socket.isInputShutdown()) {
                    this._socket.shutdownInput();
                }
                if (!this._oshut) {
                    return;
                }
            } catch (SocketException e) {
                LOG.debug(e.toString(), new Object[0]);
                LOG.ignore(e);
                if (!this._oshut) {
                    return;
                }
            }
            close();
        } catch (Throwable th) {
            if (this._oshut) {
                close();
            }
            throw th;
        }
    }

    public final void shutdownChannelOutput() throws IOException {
        Socket socket;
        LOG.debug("oshut {}", this);
        this._oshut = true;
        if (!this._channel.isOpen() || (socket = this._socket) == null) {
            return;
        }
        try {
            try {
                if (!socket.isOutputShutdown()) {
                    this._socket.shutdownOutput();
                }
                if (!this._ishut) {
                    return;
                }
            } catch (SocketException e) {
                LOG.debug(e.toString(), new Object[0]);
                LOG.ignore(e);
                if (!this._ishut) {
                    return;
                }
            }
            close();
        } catch (Throwable th) {
            if (this._ishut) {
                close();
            }
            throw th;
        }
    }

    @Override // org.eclipse.jetty.p059io.EndPoint
    public void shutdownInput() throws IOException {
        shutdownChannelInput();
    }

    @Override // org.eclipse.jetty.p059io.EndPoint
    public void shutdownOutput() throws IOException {
        shutdownChannelOutput();
    }
}
