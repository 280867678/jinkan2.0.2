package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.EmptyList;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;
import me.tvspark.outline;
import me.tvspark.r40;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Route;
import okhttp3.internal.Util;

@ef0
/* loaded from: classes4.dex */
public final class RouteSelector {
    public static final Companion Companion = new Companion(null);
    public final Address address;
    public final Call call;
    public final EventListener eventListener;
    public List<? extends InetSocketAddress> inetSocketAddresses;
    public int nextProxyIndex;
    public final List<Route> postponedRoutes = new ArrayList();
    public List<? extends Proxy> proxies;
    public final RouteDatabase routeDatabase;

    @ef0
    /* loaded from: classes4.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(gi0 gi0Var) {
            this();
        }

        public final String getSocketHost(InetSocketAddress inetSocketAddress) {
            String hostName;
            String str;
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(inetSocketAddress, "$this$socketHost");
            InetAddress address = inetSocketAddress.getAddress();
            if (address != null) {
                hostName = address.getHostAddress();
                str = "address.hostAddress";
            } else {
                hostName = inetSocketAddress.getHostName();
                str = "hostName";
            }
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) hostName, str);
            return hostName;
        }
    }

    @ef0
    /* loaded from: classes4.dex */
    public static final class Selection {
        public int nextRouteIndex;
        public final List<Route> routes;

        public Selection(List<Route> list) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "routes");
            this.routes = list;
        }

        public final List<Route> getRoutes() {
            return this.routes;
        }

        public final boolean hasNext() {
            return this.nextRouteIndex < this.routes.size();
        }

        public final Route next() {
            if (hasNext()) {
                List<Route> list = this.routes;
                int i = this.nextRouteIndex;
                this.nextRouteIndex = i + 1;
                return list.get(i);
            }
            throw new NoSuchElementException();
        }
    }

    public RouteSelector(Address address, RouteDatabase routeDatabase, Call call, EventListener eventListener) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(address, "address");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(routeDatabase, "routeDatabase");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, NotificationCompat.CATEGORY_CALL);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(eventListener, "eventListener");
        this.address = address;
        this.routeDatabase = routeDatabase;
        this.call = call;
        this.eventListener = eventListener;
        EmptyList emptyList = EmptyList.INSTANCE;
        this.proxies = emptyList;
        this.inetSocketAddresses = emptyList;
        resetNextProxy(this.address.url(), this.address.proxy());
    }

    private final boolean hasNextProxy() {
        return this.nextProxyIndex < this.proxies.size();
    }

    private final Proxy nextProxy() throws IOException {
        if (!hasNextProxy()) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("No route to ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.address.url().host());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("; exhausted proxy configurations: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.proxies);
            throw new SocketException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        List<? extends Proxy> list = this.proxies;
        int i = this.nextProxyIndex;
        this.nextProxyIndex = i + 1;
        Proxy proxy = list.get(i);
        resetNextInetSocketAddress(proxy);
        return proxy;
    }

    private final void resetNextInetSocketAddress(Proxy proxy) throws IOException {
        String host;
        int port;
        ArrayList arrayList = new ArrayList();
        this.inetSocketAddresses = arrayList;
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            host = this.address.url().host();
            port = this.address.url().port();
        } else {
            SocketAddress address = proxy.address();
            if (!(address instanceof InetSocketAddress)) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Proxy.address() is not an InetSocketAddress: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(address.getClass());
                throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString().toString());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
            host = Companion.getSocketHost(inetSocketAddress);
            port = inetSocketAddress.getPort();
        }
        if (1 > port || 65535 < port) {
            throw new SocketException("No route to " + host + ':' + port + "; port is out of range");
        } else if (proxy.type() != Proxy.Type.SOCKS) {
            this.eventListener.dnsStart(this.call, host);
            List<InetAddress> lookup = this.address.dns().lookup(host);
            if (!lookup.isEmpty()) {
                this.eventListener.dnsEnd(this.call, host, lookup);
                for (InetAddress inetAddress : lookup) {
                    arrayList.add(new InetSocketAddress(inetAddress, port));
                }
                return;
            }
            throw new UnknownHostException(this.address.dns() + " returned no addresses for " + host);
        } else {
            arrayList.add(InetSocketAddress.createUnresolved(host, port));
        }
    }

    private final void resetNextProxy(HttpUrl httpUrl, Proxy proxy) {
        List<Proxy> immutableListOf;
        this.eventListener.proxySelectStart(this.call, httpUrl);
        if (proxy != null) {
            immutableListOf = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(proxy);
        } else {
            List<Proxy> select = this.address.proxySelector().select(httpUrl.uri());
            immutableListOf = (select == null || !(select.isEmpty() ^ true)) ? Util.immutableListOf(Proxy.NO_PROXY) : Util.toImmutableList(select);
        }
        this.proxies = immutableListOf;
        this.nextProxyIndex = 0;
        this.eventListener.proxySelectEnd(this.call, httpUrl, immutableListOf);
    }

    public final boolean hasNext() {
        return hasNextProxy() || (this.postponedRoutes.isEmpty() ^ true);
    }

    public final Selection next() throws IOException {
        if (hasNext()) {
            ArrayList arrayList = new ArrayList();
            while (hasNextProxy()) {
                Proxy nextProxy = nextProxy();
                for (InetSocketAddress inetSocketAddress : this.inetSocketAddresses) {
                    Route route = new Route(this.address, nextProxy, inetSocketAddress);
                    if (this.routeDatabase.shouldPostpone(route)) {
                        this.postponedRoutes.add(route);
                    } else {
                        arrayList.add(route);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) arrayList, (Iterable) this.postponedRoutes);
                this.postponedRoutes.clear();
            }
            return new Selection(arrayList);
        }
        throw new NoSuchElementException();
    }
}
