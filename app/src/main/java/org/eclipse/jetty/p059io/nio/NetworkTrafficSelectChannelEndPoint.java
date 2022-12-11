package org.eclipse.jetty.p059io.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.List;
import org.eclipse.jetty.p059io.Buffer;
import org.eclipse.jetty.p059io.NetworkTrafficListener;
import org.eclipse.jetty.p059io.nio.SelectorManager;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* renamed from: org.eclipse.jetty.io.nio.NetworkTrafficSelectChannelEndPoint */
/* loaded from: classes4.dex */
public class NetworkTrafficSelectChannelEndPoint extends SelectChannelEndPoint {
    public static final Logger LOG = Log.getLogger(NetworkTrafficSelectChannelEndPoint.class);
    public final List<NetworkTrafficListener> listeners;

    public NetworkTrafficSelectChannelEndPoint(SocketChannel socketChannel, SelectorManager.SelectSet selectSet, SelectionKey selectionKey, int i, List<NetworkTrafficListener> list) throws IOException {
        super(socketChannel, selectSet, selectionKey, i);
        this.listeners = list;
    }

    @Override // org.eclipse.jetty.p059io.nio.SelectChannelEndPoint, org.eclipse.jetty.p059io.nio.ChannelEndPoint, org.eclipse.jetty.p059io.EndPoint
    public int fill(Buffer buffer) throws IOException {
        int fill = super.fill(buffer);
        notifyIncoming(buffer, fill);
        return fill;
    }

    @Override // org.eclipse.jetty.p059io.nio.SelectChannelEndPoint, org.eclipse.jetty.p059io.nio.ChannelEndPoint, org.eclipse.jetty.p059io.EndPoint
    public int flush(Buffer buffer) throws IOException {
        int index = buffer.getIndex();
        int flush = super.flush(buffer);
        notifyOutgoing(buffer, index, flush);
        return flush;
    }

    @Override // org.eclipse.jetty.p059io.nio.ChannelEndPoint
    public int gatheringFlush(Buffer buffer, ByteBuffer byteBuffer, Buffer buffer2, ByteBuffer byteBuffer2) throws IOException {
        int index = buffer.getIndex();
        int length = buffer.length();
        int index2 = buffer2.getIndex();
        int gatheringFlush = super.gatheringFlush(buffer, byteBuffer, buffer2, byteBuffer2);
        notifyOutgoing(buffer, index, gatheringFlush > length ? length : gatheringFlush);
        notifyOutgoing(buffer2, index2, gatheringFlush > length ? gatheringFlush - length : 0);
        return gatheringFlush;
    }

    public void notifyClosed() {
        List<NetworkTrafficListener> list = this.listeners;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (NetworkTrafficListener networkTrafficListener : this.listeners) {
            try {
                networkTrafficListener.closed(this._socket);
            } catch (Exception e) {
                LOG.warn(e);
            }
        }
    }

    public void notifyIncoming(Buffer buffer, int i) {
        List<NetworkTrafficListener> list = this.listeners;
        if (list == null || list.isEmpty() || i <= 0) {
            return;
        }
        for (NetworkTrafficListener networkTrafficListener : this.listeners) {
            try {
                networkTrafficListener.incoming(this._socket, buffer.asReadOnlyBuffer());
            } catch (Exception e) {
                LOG.warn(e);
            }
        }
    }

    public void notifyOpened() {
        List<NetworkTrafficListener> list = this.listeners;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (NetworkTrafficListener networkTrafficListener : this.listeners) {
            try {
                networkTrafficListener.opened(this._socket);
            } catch (Exception e) {
                LOG.warn(e);
            }
        }
    }

    public void notifyOutgoing(Buffer buffer, int i, int i2) {
        List<NetworkTrafficListener> list = this.listeners;
        if (list == null || list.isEmpty() || i2 <= 0) {
            return;
        }
        for (NetworkTrafficListener networkTrafficListener : this.listeners) {
            try {
                Buffer asReadOnlyBuffer = buffer.asReadOnlyBuffer();
                asReadOnlyBuffer.setGetIndex(i);
                asReadOnlyBuffer.setPutIndex(i + i2);
                networkTrafficListener.outgoing(this._socket, asReadOnlyBuffer);
            } catch (Exception e) {
                LOG.warn(e);
            }
        }
    }
}
