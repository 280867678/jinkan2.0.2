package org.fourthline.cling.support.model;

import me.tvspark.outline;
import org.fourthline.cling.model.types.UnsignedIntegerFourBytes;

/* loaded from: classes5.dex */
public class Connection {

    /* loaded from: classes5.dex */
    public enum Error {
        ERROR_NONE,
        ERROR_COMMAND_ABORTED,
        ERROR_NOT_ENABLED_FOR_INTERNET,
        ERROR_USER_DISCONNECT,
        ERROR_ISP_DISCONNECT,
        ERROR_IDLE_DISCONNECT,
        ERROR_FORCED_DISCONNECT,
        ERROR_NO_CARRIER,
        ERROR_IP_CONFIGURATION,
        ERROR_UNKNOWN
    }

    /* loaded from: classes5.dex */
    public enum Status {
        Unconfigured,
        Connecting,
        Connected,
        PendingDisconnect,
        Disconnecting,
        Disconnected
    }

    /* loaded from: classes5.dex */
    public static class StatusInfo {
        public Error lastError;
        public Status status;
        public long uptimeSeconds;

        public StatusInfo(Status status, long j, Error error) {
            this.status = status;
            this.uptimeSeconds = j;
            this.lastError = error;
        }

        public StatusInfo(Status status, UnsignedIntegerFourBytes unsignedIntegerFourBytes, Error error) {
            this(status, unsignedIntegerFourBytes.getValue().longValue(), error);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || StatusInfo.class != obj.getClass()) {
                return false;
            }
            StatusInfo statusInfo = (StatusInfo) obj;
            return this.uptimeSeconds == statusInfo.uptimeSeconds && this.lastError == statusInfo.lastError && this.status == statusInfo.status;
        }

        public Error getLastError() {
            return this.lastError;
        }

        public Status getStatus() {
            return this.status;
        }

        public UnsignedIntegerFourBytes getUptime() {
            return new UnsignedIntegerFourBytes(getUptimeSeconds());
        }

        public long getUptimeSeconds() {
            return this.uptimeSeconds;
        }

        public int hashCode() {
            long j = this.uptimeSeconds;
            return this.lastError.hashCode() + (((this.status.hashCode() * 31) + ((int) (j ^ (j >>> 32)))) * 31);
        }

        public String toString() {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("(");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(StatusInfo.class.getSimpleName());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(") ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getStatus());
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
    }

    /* loaded from: classes5.dex */
    public enum Type {
        Unconfigured,
        IP_Routed,
        IP_Bridged
    }
}
