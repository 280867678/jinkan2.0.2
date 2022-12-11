package org.apache.http.config;

import me.tvspark.outline;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.util.Args;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes4.dex */
public class SocketConfig implements Cloneable {
    public static final SocketConfig DEFAULT = new Builder().build();
    public final int backlogSize;
    public final int rcvBufSize;
    public final int sndBufSize;
    public final boolean soKeepAlive;
    public final int soLinger;
    public final boolean soReuseAddress;
    public final int soTimeout;
    public final boolean tcpNoDelay;

    /* loaded from: classes4.dex */
    public static class Builder {
        public int backlogSize;
        public int rcvBufSize;
        public int sndBufSize;
        public boolean soKeepAlive;
        public boolean soReuseAddress;
        public int soTimeout;
        public int soLinger = -1;
        public boolean tcpNoDelay = true;

        public SocketConfig build() {
            return new SocketConfig(this.soTimeout, this.soReuseAddress, this.soLinger, this.soKeepAlive, this.tcpNoDelay, this.sndBufSize, this.rcvBufSize, this.backlogSize);
        }

        public Builder setBacklogSize(int i) {
            this.backlogSize = i;
            return this;
        }

        public Builder setRcvBufSize(int i) {
            this.rcvBufSize = i;
            return this;
        }

        public Builder setSndBufSize(int i) {
            this.sndBufSize = i;
            return this;
        }

        public Builder setSoKeepAlive(boolean z) {
            this.soKeepAlive = z;
            return this;
        }

        public Builder setSoLinger(int i) {
            this.soLinger = i;
            return this;
        }

        public Builder setSoReuseAddress(boolean z) {
            this.soReuseAddress = z;
            return this;
        }

        public Builder setSoTimeout(int i) {
            this.soTimeout = i;
            return this;
        }

        public Builder setTcpNoDelay(boolean z) {
            this.tcpNoDelay = z;
            return this;
        }
    }

    public SocketConfig(int i, boolean z, int i2, boolean z2, boolean z3, int i3, int i4, int i5) {
        this.soTimeout = i;
        this.soReuseAddress = z;
        this.soLinger = i2;
        this.soKeepAlive = z2;
        this.tcpNoDelay = z3;
        this.sndBufSize = i3;
        this.rcvBufSize = i4;
        this.backlogSize = i5;
    }

    public static Builder copy(SocketConfig socketConfig) {
        Args.notNull(socketConfig, "Socket config");
        return new Builder().setSoTimeout(socketConfig.getSoTimeout()).setSoReuseAddress(socketConfig.isSoReuseAddress()).setSoLinger(socketConfig.getSoLinger()).setSoKeepAlive(socketConfig.isSoKeepAlive()).setTcpNoDelay(socketConfig.isTcpNoDelay()).setSndBufSize(socketConfig.getSndBufSize()).setRcvBufSize(socketConfig.getRcvBufSize()).setBacklogSize(socketConfig.getBacklogSize());
    }

    public static Builder custom() {
        return new Builder();
    }

    public SocketConfig clone() throws CloneNotSupportedException {
        return (SocketConfig) super.clone();
    }

    public int getBacklogSize() {
        return this.backlogSize;
    }

    public int getRcvBufSize() {
        return this.rcvBufSize;
    }

    public int getSndBufSize() {
        return this.sndBufSize;
    }

    public int getSoLinger() {
        return this.soLinger;
    }

    public int getSoTimeout() {
        return this.soTimeout;
    }

    public boolean isSoKeepAlive() {
        return this.soKeepAlive;
    }

    public boolean isSoReuseAddress() {
        return this.soReuseAddress;
    }

    public boolean isTcpNoDelay() {
        return this.tcpNoDelay;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[soTimeout=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.soTimeout);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", soReuseAddress=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.soReuseAddress);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", soLinger=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.soLinger);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", soKeepAlive=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.soKeepAlive);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", tcpNoDelay=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.tcpNoDelay);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", sndBufSize=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.sndBufSize);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", rcvBufSize=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.rcvBufSize);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", backlogSize=");
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.backlogSize, "]");
    }
}
