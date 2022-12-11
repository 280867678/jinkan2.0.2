package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.outline;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;

@ef0
/* loaded from: classes4.dex */
public final class Address {
    public final CertificatePinner certificatePinner;
    public final List<ConnectionSpec> connectionSpecs;
    public final Dns dns;
    public final HostnameVerifier hostnameVerifier;
    public final List<Protocol> protocols;
    public final Proxy proxy;
    public final Authenticator proxyAuthenticator;
    public final ProxySelector proxySelector;
    public final SocketFactory socketFactory;
    public final SSLSocketFactory sslSocketFactory;
    public final HttpUrl url;

    public Address(String str, int i, Dns dns, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, CertificatePinner certificatePinner, Authenticator authenticator, Proxy proxy, List<? extends Protocol> list, List<ConnectionSpec> list2, ProxySelector proxySelector) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "uriHost");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dns, "dns");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(socketFactory, "socketFactory");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(authenticator, "proxyAuthenticator");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "protocols");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list2, "connectionSpecs");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(proxySelector, "proxySelector");
        this.dns = dns;
        this.socketFactory = socketFactory;
        this.sslSocketFactory = sSLSocketFactory;
        this.hostnameVerifier = hostnameVerifier;
        this.certificatePinner = certificatePinner;
        this.proxyAuthenticator = authenticator;
        this.proxy = proxy;
        this.proxySelector = proxySelector;
        this.url = new HttpUrl.Builder().scheme(this.sslSocketFactory != null ? "https" : "http").host(str).port(i).build();
        this.protocols = Util.toImmutableList(list);
        this.connectionSpecs = Util.toImmutableList(list2);
    }

    /* renamed from: -deprecated_certificatePinner  reason: not valid java name */
    public final CertificatePinner m4976deprecated_certificatePinner() {
        return this.certificatePinner;
    }

    /* renamed from: -deprecated_connectionSpecs  reason: not valid java name */
    public final List<ConnectionSpec> m4977deprecated_connectionSpecs() {
        return this.connectionSpecs;
    }

    /* renamed from: -deprecated_dns  reason: not valid java name */
    public final Dns m4978deprecated_dns() {
        return this.dns;
    }

    /* renamed from: -deprecated_hostnameVerifier  reason: not valid java name */
    public final HostnameVerifier m4979deprecated_hostnameVerifier() {
        return this.hostnameVerifier;
    }

    /* renamed from: -deprecated_protocols  reason: not valid java name */
    public final List<Protocol> m4980deprecated_protocols() {
        return this.protocols;
    }

    /* renamed from: -deprecated_proxy  reason: not valid java name */
    public final Proxy m4981deprecated_proxy() {
        return this.proxy;
    }

    /* renamed from: -deprecated_proxyAuthenticator  reason: not valid java name */
    public final Authenticator m4982deprecated_proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    /* renamed from: -deprecated_proxySelector  reason: not valid java name */
    public final ProxySelector m4983deprecated_proxySelector() {
        return this.proxySelector;
    }

    /* renamed from: -deprecated_socketFactory  reason: not valid java name */
    public final SocketFactory m4984deprecated_socketFactory() {
        return this.socketFactory;
    }

    /* renamed from: -deprecated_sslSocketFactory  reason: not valid java name */
    public final SSLSocketFactory m4985deprecated_sslSocketFactory() {
        return this.sslSocketFactory;
    }

    /* renamed from: -deprecated_url  reason: not valid java name */
    public final HttpUrl m4986deprecated_url() {
        return this.url;
    }

    public final CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }

    public final List<ConnectionSpec> connectionSpecs() {
        return this.connectionSpecs;
    }

    public final Dns dns() {
        return this.dns;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Address) {
            Address address = (Address) obj;
            if (ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.url, address.url) && equalsNonHost$okhttp(address)) {
                return true;
            }
        }
        return false;
    }

    public final boolean equalsNonHost$okhttp(Address address) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(address, "that");
        return ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.dns, address.dns) && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.proxyAuthenticator, address.proxyAuthenticator) && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.protocols, address.protocols) && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.connectionSpecs, address.connectionSpecs) && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.proxySelector, address.proxySelector) && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.proxy, address.proxy) && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.sslSocketFactory, address.sslSocketFactory) && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.hostnameVerifier, address.hostnameVerifier) && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.certificatePinner, address.certificatePinner) && this.url.port() == address.url.port();
    }

    public int hashCode() {
        int hashCode = this.dns.hashCode();
        int hashCode2 = this.proxyAuthenticator.hashCode();
        int hashCode3 = this.protocols.hashCode();
        int hashCode4 = this.connectionSpecs.hashCode();
        int hashCode5 = this.proxySelector.hashCode();
        int hashCode6 = Objects.hashCode(this.proxy);
        int hashCode7 = Objects.hashCode(this.sslSocketFactory);
        int hashCode8 = Objects.hashCode(this.hostnameVerifier);
        return Objects.hashCode(this.certificatePinner) + ((hashCode8 + ((hashCode7 + ((hashCode6 + ((hashCode5 + ((hashCode4 + ((hashCode3 + ((hashCode2 + ((hashCode + ((this.url.hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    public final List<Protocol> protocols() {
        return this.protocols;
    }

    public final Proxy proxy() {
        return this.proxy;
    }

    public final Authenticator proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    public final ProxySelector proxySelector() {
        return this.proxySelector;
    }

    public final SocketFactory socketFactory() {
        return this.socketFactory;
    }

    public final SSLSocketFactory sslSocketFactory() {
        return this.sslSocketFactory;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Object obj;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Address{");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.url.host());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(':');
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.url.port());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(", ");
        if (this.proxy != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("proxy=");
            obj = this.proxy;
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("proxySelector=");
            obj = this.proxySelector;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(obj);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append("}");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
    }

    public final HttpUrl url() {
        return this.url;
    }
}
