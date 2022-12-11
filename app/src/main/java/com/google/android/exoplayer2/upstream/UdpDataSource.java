package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.just.agentweb.WebIndicator;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import me.tvspark.AbstractC2715vj;
import me.tvspark.C1949bk;

/* loaded from: classes3.dex */
public final class UdpDataSource extends AbstractC2715vj {
    public int Wwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public InetSocketAddress Wwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public InetAddress Wwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public MulticastSocket Wwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public DatagramSocket Wwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public Uri Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = WebIndicator.MAX_UNIFORM_SPEED_DURATION;
    public final byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new byte[2000];
    public final DatagramPacket Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new DatagramPacket(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, 2000);

    /* loaded from: classes3.dex */
    public static final class UdpDataSourceException extends IOException {
        public UdpDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public UdpDataSource() {
        super(true);
    }

    @Override // me.tvspark.AbstractC2863zj
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C1949bk c1949bk) throws UdpDataSourceException {
        DatagramSocket datagramSocket;
        Uri uri = c1949bk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = uri;
        String host = uri.getHost();
        int port = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.getPort();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c1949bk);
        try {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = InetAddress.getByName(host);
            this.Wwwwwwwwwwwwwwwwwwwwwww = new InetSocketAddress(this.Wwwwwwwwwwwwwwwwwwwwwwww, port);
            if (this.Wwwwwwwwwwwwwwwwwwwwwwww.isMulticastAddress()) {
                MulticastSocket multicastSocket = new MulticastSocket(this.Wwwwwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwwwwwwwwww = multicastSocket;
                multicastSocket.joinGroup(this.Wwwwwwwwwwwwwwwwwwwwwwww);
                datagramSocket = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
            } else {
                datagramSocket = new DatagramSocket(this.Wwwwwwwwwwwwwwwwwwwwwww);
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = datagramSocket;
            try {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwww.setSoTimeout(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwwwwwww = true;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c1949bk);
                return -1L;
            } catch (SocketException e) {
                throw new UdpDataSourceException(e);
            }
        } catch (IOException e2) {
            throw new UdpDataSourceException(e2);
        }
    }

    @Override // me.tvspark.AbstractC2863zj
    public void close() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        MulticastSocket multicastSocket = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
        if (multicastSocket != null) {
            try {
                multicastSocket.leaveGroup(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            } catch (IOException unused) {
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwww = null;
        }
        DatagramSocket datagramSocket = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = null;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwww = null;
        this.Wwwwwwwwwwwwwwwwwwwwwww = null;
        this.Wwwwwwwwwwwwwwwwwwwww = 0;
        if (this.Wwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwww = false;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    @Override // me.tvspark.AbstractC2863zj
    @Nullable
    public Uri getUri() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC2752wj
    public int read(byte[] bArr, int i, int i2) throws UdpDataSourceException {
        if (i2 == 0) {
            return 0;
        }
        if (this.Wwwwwwwwwwwwwwwwwwwww == 0) {
            try {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwww.receive(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
                int length = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.getLength();
                this.Wwwwwwwwwwwwwwwwwwwww = length;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(length);
            } catch (IOException e) {
                throw new UdpDataSourceException(e);
            }
        }
        int length2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.getLength();
        int i3 = this.Wwwwwwwwwwwwwwwwwwwww;
        int min = Math.min(i3, i2);
        System.arraycopy(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, length2 - i3, bArr, i, min);
        this.Wwwwwwwwwwwwwwwwwwwww -= min;
        return min;
    }
}
