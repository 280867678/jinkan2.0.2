package org.fourthline.cling.support.model;

import me.tvspark.outline;
import org.fourthline.cling.model.ServiceReference;

/* loaded from: classes5.dex */
public class ConnectionInfo {
    public final int avTransportID;
    public final int connectionID;
    public Status connectionStatus;
    public final Direction direction;
    public final int peerConnectionID;
    public final ServiceReference peerConnectionManager;
    public final ProtocolInfo protocolInfo;
    public final int rcsID;

    /* loaded from: classes5.dex */
    public enum Direction {
        Output,
        Input;

        public Direction getOpposite() {
            return equals(Output) ? Input : Output;
        }
    }

    /* loaded from: classes5.dex */
    public enum Status {
        OK,
        ContentFormatMismatch,
        InsufficientBandwidth,
        UnreliableChannel,
        Unknown
    }

    public ConnectionInfo() {
        this(0, 0, 0, null, null, -1, Direction.Input, Status.Unknown);
    }

    public ConnectionInfo(int i, int i2, int i3, ProtocolInfo protocolInfo, ServiceReference serviceReference, int i4, Direction direction, Status status) {
        this.connectionStatus = Status.Unknown;
        this.connectionID = i;
        this.rcsID = i2;
        this.avTransportID = i3;
        this.protocolInfo = protocolInfo;
        this.peerConnectionManager = serviceReference;
        this.peerConnectionID = i4;
        this.direction = direction;
        this.connectionStatus = status;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ConnectionInfo.class != obj.getClass()) {
            return false;
        }
        ConnectionInfo connectionInfo = (ConnectionInfo) obj;
        if (this.avTransportID != connectionInfo.avTransportID || this.connectionID != connectionInfo.connectionID || this.peerConnectionID != connectionInfo.peerConnectionID || this.rcsID != connectionInfo.rcsID || this.connectionStatus != connectionInfo.connectionStatus || this.direction != connectionInfo.direction) {
            return false;
        }
        ServiceReference serviceReference = this.peerConnectionManager;
        if (serviceReference == null ? connectionInfo.peerConnectionManager != null : !serviceReference.equals(connectionInfo.peerConnectionManager)) {
            return false;
        }
        ProtocolInfo protocolInfo = this.protocolInfo;
        ProtocolInfo protocolInfo2 = connectionInfo.protocolInfo;
        return protocolInfo == null ? protocolInfo2 == null : protocolInfo.equals(protocolInfo2);
    }

    public int getAvTransportID() {
        return this.avTransportID;
    }

    public int getConnectionID() {
        return this.connectionID;
    }

    public synchronized Status getConnectionStatus() {
        return this.connectionStatus;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public int getPeerConnectionID() {
        return this.peerConnectionID;
    }

    public ServiceReference getPeerConnectionManager() {
        return this.peerConnectionManager;
    }

    public ProtocolInfo getProtocolInfo() {
        return this.protocolInfo;
    }

    public int getRcsID() {
        return this.rcsID;
    }

    public int hashCode() {
        int i = ((((this.connectionID * 31) + this.rcsID) * 31) + this.avTransportID) * 31;
        ProtocolInfo protocolInfo = this.protocolInfo;
        int i2 = 0;
        int hashCode = (i + (protocolInfo != null ? protocolInfo.hashCode() : 0)) * 31;
        ServiceReference serviceReference = this.peerConnectionManager;
        if (serviceReference != null) {
            i2 = serviceReference.hashCode();
        }
        return this.connectionStatus.hashCode() + ((this.direction.hashCode() + ((((hashCode + i2) * 31) + this.peerConnectionID) * 31)) * 31);
    }

    public synchronized void setConnectionStatus(Status status) {
        this.connectionStatus = status;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(ConnectionInfo.class.getSimpleName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(") ID: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getConnectionID());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", Status: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getConnectionStatus());
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
