package me.tvspark;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class ao0 {
    public static final Pattern Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Pattern.compile("^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$");

    static {
        Pattern.compile("@Header:\\{.+?\\}", 2);
    }

    public static InetAddress Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Enumeration<NetworkInterface> enumeration;
        try {
            enumeration = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            e.printStackTrace();
            enumeration = null;
        }
        if (enumeration != null) {
            while (enumeration.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = enumeration.nextElement().getInetAddresses();
                if (inetAddresses != null) {
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress()) {
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.matcher(nextElement.getHostAddress()).matches()) {
                                return nextElement;
                            }
                        }
                    }
                    continue;
                }
            }
        }
        return null;
    }
}
