package okhttp3.internal.platform;

import com.arialyy.aria.core.inf.IOptionConstant;
import com.just.agentweb.JsCallJava;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.TypeCastException;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;
import okhttp3.Protocol;

@ef0
/* loaded from: classes4.dex */
public final class Jdk8WithJettyBootPlatform extends Platform {
    public static final Companion Companion = new Companion(null);
    public final Class<?> clientProviderClass;
    public final Method getMethod;
    public final Method putMethod;
    public final Method removeMethod;
    public final Class<?> serverProviderClass;

    @ef0
    /* loaded from: classes4.dex */
    public static final class AlpnProvider implements InvocationHandler {
        public final List<String> protocols;
        public String selected;
        public boolean unsupported;

        public AlpnProvider(List<String> list) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "protocols");
            this.protocols = list;
        }

        public final String getSelected$okhttp() {
            return this.selected;
        }

        public final boolean getUnsupported$okhttp() {
            return this.unsupported;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, IOptionConstant.proxy);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(method, JsCallJava.KEY_METHOD);
            if (objArr == null) {
                objArr = new Object[0];
            }
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (!ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) name, (Object) "supports") || !ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Boolean.TYPE, returnType)) {
                if (ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) name, (Object) "unsupported") && ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Void.TYPE, returnType)) {
                    this.unsupported = true;
                    return null;
                }
                if (ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) name, (Object) "protocols")) {
                    if (objArr.length == 0) {
                        return this.protocols;
                    }
                }
                if ((!ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) name, (Object) "selectProtocol") && !ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) name, (Object) "select")) || !ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String.class, returnType) || objArr.length != 1 || !(objArr[0] instanceof List)) {
                    if ((!ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) name, (Object) "protocolSelected") && !ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) name, (Object) "selected")) || objArr.length != 1) {
                        return method.invoke(this, Arrays.copyOf(objArr, objArr.length));
                    }
                    Object obj2 = objArr[0];
                    if (obj2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                    }
                    this.selected = (String) obj2;
                    return null;
                }
                Object obj3 = objArr[0];
                if (obj3 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<*>");
                }
                List list = (List) obj3;
                int size = list.size();
                if (size >= 0) {
                    int i = 0;
                    while (true) {
                        Object obj4 = list.get(i);
                        if (obj4 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                        }
                        String str = (String) obj4;
                        if (!this.protocols.contains(str)) {
                            if (i == size) {
                                break;
                            }
                            i++;
                        } else {
                            this.selected = str;
                            return str;
                        }
                    }
                }
                String str2 = this.protocols.get(0);
                this.selected = str2;
                return str2;
            }
            return true;
        }

        public final void setSelected$okhttp(String str) {
            this.selected = str;
        }

        public final void setUnsupported$okhttp(boolean z) {
            this.unsupported = z;
        }
    }

    @ef0
    /* loaded from: classes4.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(gi0 gi0Var) {
            this();
        }

        public final Platform buildIfSupported() {
            String property = System.getProperty("java.specification.version", "unknown");
            try {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) property, "jvmVersion");
                if (Integer.parseInt(property) >= 9) {
                    return null;
                }
            } catch (NumberFormatException unused) {
            }
            try {
                Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                Class<?> cls4 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                Method method = cls.getMethod("put", SSLSocket.class, cls2);
                Method method2 = cls.getMethod("get", SSLSocket.class);
                Method method3 = cls.getMethod("remove", SSLSocket.class);
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) method, "putMethod");
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) method2, "getMethod");
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) method3, "removeMethod");
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) cls3, "clientProviderClass");
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) cls4, "serverProviderClass");
                return new Jdk8WithJettyBootPlatform(method, method2, method3, cls3, cls4);
            } catch (ClassNotFoundException | NoSuchMethodException unused2) {
                return null;
            }
        }
    }

    public Jdk8WithJettyBootPlatform(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(method, "putMethod");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(method2, "getMethod");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(method3, "removeMethod");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls, "clientProviderClass");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls2, "serverProviderClass");
        this.putMethod = method;
        this.getMethod = method2;
        this.removeMethod = method3;
        this.clientProviderClass = cls;
        this.serverProviderClass = cls2;
    }

    @Override // okhttp3.internal.platform.Platform
    public void afterHandshake(SSLSocket sSLSocket) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sSLSocket, "sslSocket");
        try {
            this.removeMethod.invoke(null, sSLSocket);
        } catch (IllegalAccessException e) {
            throw new AssertionError("failed to remove ALPN", e);
        } catch (InvocationTargetException e2) {
            throw new AssertionError("failed to remove ALPN", e2);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<? extends Protocol> list) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sSLSocket, "sslSocket");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "protocols");
        try {
            this.putMethod.invoke(null, sSLSocket, Proxy.newProxyInstance(Platform.class.getClassLoader(), new Class[]{this.clientProviderClass, this.serverProviderClass}, new AlpnProvider(Platform.Companion.alpnProtocolNames(list))));
        } catch (IllegalAccessException e) {
            throw new AssertionError("failed to set ALPN", e);
        } catch (InvocationTargetException e2) {
            throw new AssertionError("failed to set ALPN", e2);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sSLSocket, "socket");
        try {
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(this.getMethod.invoke(null, sSLSocket));
            if (invocationHandler == null) {
                throw new TypeCastException("null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider");
            }
            AlpnProvider alpnProvider = (AlpnProvider) invocationHandler;
            if (!alpnProvider.getUnsupported$okhttp() && alpnProvider.getSelected$okhttp() == null) {
                Platform.Companion.get().log(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", null);
                return null;
            } else if (!alpnProvider.getUnsupported$okhttp()) {
                return alpnProvider.getSelected$okhttp();
            } else {
                return null;
            }
        } catch (IllegalAccessException e) {
            throw new AssertionError("failed to get ALPN selected protocol", e);
        } catch (InvocationTargetException e2) {
            throw new AssertionError("failed to get ALPN selected protocol", e2);
        }
    }
}
