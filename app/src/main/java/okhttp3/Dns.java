package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;
import me.tvspark.outline;
import me.tvspark.r40;

@ef0
/* loaded from: classes4.dex */
public interface Dns {
    public static final Companion Companion = new Companion(null);
    public static final Dns SYSTEM = new Dns() { // from class: okhttp3.Dns$Companion$SYSTEM$1
        @Override // okhttp3.Dns
        public List<InetAddress> lookup(String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "hostname");
            try {
                InetAddress[] allByName = InetAddress.getAllByName(str);
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) allByName, "InetAddress.getAllByName(hostname)");
                return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(allByName);
            } catch (NullPointerException e) {
                UnknownHostException unknownHostException = new UnknownHostException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Broken system behaviour for dns lookup of ", str));
                unknownHostException.initCause(e);
                throw unknownHostException;
            }
        }
    };

    @ef0
    /* loaded from: classes4.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = null;

        public Companion() {
        }

        public /* synthetic */ Companion(gi0 gi0Var) {
            this();
        }
    }

    List<InetAddress> lookup(String str) throws UnknownHostException;
}
