package com.google.common.net;

import java.io.Serializable;
import java.util.Arrays;
import me.tvspark.C2536qt;
import me.tvspark.Illllllllllllllllllllllllllll;
import me.tvspark.outline;
import org.slf4j.Marker;

/* loaded from: classes3.dex */
public final class HostAndPort implements Serializable {
    public static final int NO_PORT = -1;
    public static final long serialVersionUID = 0;
    public final boolean hasBracketlessColons;
    public final String host;
    public final int port;

    public HostAndPort(String str, int i, boolean z) {
        this.host = str;
        this.port = i;
        this.hasBracketlessColons = z;
    }

    public static HostAndPort fromHost(String str) {
        HostAndPort fromString = fromString(str);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!fromString.hasPort(), "Host has a port: %s", str);
        return fromString;
    }

    public static HostAndPort fromParts(String str, int i) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(isValidPort(i), "Port out of range: %s", i);
        HostAndPort fromString = fromString(str);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!fromString.hasPort(), "Host has a port: %s", str);
        return new HostAndPort(fromString.host, i, fromString.hasBracketlessColons);
    }

    public static HostAndPort fromString(String str) {
        String str2;
        String str3 = null;
        if (str != null) {
            int i = -1;
            boolean z = false;
            if (str.startsWith("[")) {
                String[] hostAndPortFromBracketedHost = getHostAndPortFromBracketedHost(str);
                str2 = hostAndPortFromBracketedHost[0];
                str3 = hostAndPortFromBracketedHost[1];
            } else {
                int indexOf = str.indexOf(58);
                if (indexOf >= 0) {
                    int i2 = indexOf + 1;
                    if (str.indexOf(58, i2) == -1) {
                        str2 = str.substring(0, indexOf);
                        str3 = str.substring(i2);
                    }
                }
                if (indexOf >= 0) {
                    z = true;
                }
                str2 = str;
            }
            if (!C2536qt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str3)) {
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!str3.startsWith(Marker.ANY_NON_NULL_MARKER), "Unparseable port number: %s", str);
                try {
                    i = Integer.parseInt(str3);
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(isValidPort(i), "Port number out of range: %s", str);
                } catch (NumberFormatException unused) {
                    throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unparseable port number: ", str));
                }
            }
            return new HostAndPort(str2, i, z);
        }
        throw null;
    }

    public static String[] getHostAndPortFromBracketedHost(String str) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str.charAt(0) == '[', "Bracketed host-port string must start with a bracket: %s", str);
        int indexOf = str.indexOf(58);
        int lastIndexOf = str.lastIndexOf(93);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(indexOf > -1 && lastIndexOf > indexOf, "Invalid bracketed host/port: %s", str);
        String substring = str.substring(1, lastIndexOf);
        int i = lastIndexOf + 1;
        if (i == str.length()) {
            return new String[]{substring, ""};
        }
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str.charAt(i) == ':', "Only a colon may follow a close bracket: %s", str);
        int i2 = lastIndexOf + 2;
        for (int i3 = i2; i3 < str.length(); i3++) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Character.isDigit(str.charAt(i3)), "Port must be numeric: %s", str);
        }
        return new String[]{substring, str.substring(i2)};
    }

    public static boolean isValidPort(int i) {
        return i >= 0 && i <= 65535;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HostAndPort)) {
            return false;
        }
        HostAndPort hostAndPort = (HostAndPort) obj;
        return Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.host, hostAndPort.host) && this.port == hostAndPort.port;
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(hasPort());
        return this.port;
    }

    public int getPortOrDefault(int i) {
        return hasPort() ? this.port : i;
    }

    public boolean hasPort() {
        return this.port >= 0;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.host, Integer.valueOf(this.port)});
    }

    public HostAndPort requireBracketsForIPv6() {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!this.hasBracketlessColons, "Possible bracketless IPv6 literal: %s", this.host);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.host.length() + 8);
        if (this.host.indexOf(58) >= 0) {
            sb.append('[');
            sb.append(this.host);
            sb.append(']');
        } else {
            sb.append(this.host);
        }
        if (hasPort()) {
            sb.append(':');
            sb.append(this.port);
        }
        return sb.toString();
    }

    public HostAndPort withDefaultPort(int i) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(isValidPort(i));
        return hasPort() ? this : new HostAndPort(this.host, i, this.hasBracketlessColons);
    }
}
