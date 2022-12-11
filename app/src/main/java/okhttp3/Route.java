package okhttp3;

import com.arialyy.aria.core.inf.IOptionConstant;
import java.net.InetSocketAddress;
import java.net.Proxy;
import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.outline;

@ef0
/* loaded from: classes4.dex */
public final class Route {
    public final Address address;
    public final Proxy proxy;
    public final InetSocketAddress socketAddress;

    public Route(Address address, Proxy proxy, InetSocketAddress inetSocketAddress) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(address, "address");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(proxy, IOptionConstant.proxy);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(inetSocketAddress, "socketAddress");
        this.address = address;
        this.proxy = proxy;
        this.socketAddress = inetSocketAddress;
    }

    /* renamed from: -deprecated_address  reason: not valid java name */
    public final Address m5107deprecated_address() {
        return this.address;
    }

    /* renamed from: -deprecated_proxy  reason: not valid java name */
    public final Proxy m5108deprecated_proxy() {
        return this.proxy;
    }

    /* renamed from: -deprecated_socketAddress  reason: not valid java name */
    public final InetSocketAddress m5109deprecated_socketAddress() {
        return this.socketAddress;
    }

    public final Address address() {
        return this.address;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Route) {
            Route route = (Route) obj;
            if (ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(route.address, this.address) && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(route.proxy, this.proxy) && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(route.socketAddress, this.socketAddress)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.proxy.hashCode();
        return this.socketAddress.hashCode() + ((hashCode + ((this.address.hashCode() + 527) * 31)) * 31);
    }

    public final Proxy proxy() {
        return this.proxy;
    }

    public final boolean requiresTunnel() {
        return this.address.sslSocketFactory() != null && this.proxy.type() == Proxy.Type.HTTP;
    }

    public final InetSocketAddress socketAddress() {
        return this.socketAddress;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Route{");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.socketAddress);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append('}');
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
