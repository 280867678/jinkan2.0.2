package me.tvspark;

import android.os.Build;
import com.just.agentweb.DefaultWebClient;
import java.io.IOException;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.security.MessageDigest;
import java.util.Enumeration;
import java.util.UUID;
import org.fourthline.cling.model.ValidationException;
import org.fourthline.cling.model.meta.DeviceDetails;
import org.fourthline.cling.model.meta.DeviceIdentity;
import org.fourthline.cling.model.meta.Icon;
import org.fourthline.cling.model.meta.LocalDevice;
import org.fourthline.cling.model.meta.LocalService;
import org.fourthline.cling.model.meta.ManufacturerDetails;
import org.fourthline.cling.model.meta.ModelDetails;
import org.fourthline.cling.model.types.UDADeviceType;
import org.fourthline.cling.model.types.UDN;
import org.litepal.crud.LitePalSupport;

/* loaded from: classes4.dex */
public class lq0 {
    public static volatile String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public jq0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public LocalDevice Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public lq0() throws ValidationException, SocketException {
        UDADeviceType uDADeviceType = new UDADeviceType("MediaServer", 1);
        DeviceDetails deviceDetails = new DeviceDetails(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("DMS  ("), Build.MODEL, ")"), new ManufacturerDetails(Build.MANUFACTURER), new ModelDetails(Build.MODEL, "MSI MediaServer", "v1"));
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        String str = "";
        loop0: while (networkInterfaces.hasMoreElements()) {
            NetworkInterface nextElement = networkInterfaces.nextElement();
            if (nextElement.getName().toLowerCase().equals("eth0") || nextElement.getName().toLowerCase().equals("wlan0")) {
                Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement2 = inetAddresses.nextElement();
                    if (!nextElement2.isLoopbackAddress()) {
                        str = nextElement2.getHostAddress();
                        if (!str.contains("::")) {
                            break loop0;
                        }
                    }
                }
                continue;
            }
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
        String str2 = DefaultWebClient.HTTP_SCHEME + str + "/8299";
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, str2);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Build.MODEL);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Build.MANUFACTURER);
        try {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new LocalDevice(new DeviceIdentity(new UDN(new UUID(new BigInteger(-1, MessageDigest.getInstance(LitePalSupport.MD5).digest(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString().getBytes())).longValue(), -1224597488))), uDADeviceType, deviceDetails, (Icon) null, (LocalService) null);
            deviceDetails.getFriendlyName();
            deviceDetails.getManufacturerDetails().getManufacturer();
            deviceDetails.getModelDetails().getModelName();
            jq0 jq0Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (jq0Var != null) {
                if (jq0Var != null) {
                    try {
                        jq0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.close();
                        jq0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.join();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                } else {
                    throw null;
                }
            }
            try {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new jq0(8299);
            } catch (IOException e3) {
                String str3 = "Couldn't start server:\n" + e3;
                System.exit(-1);
            }
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }
}
