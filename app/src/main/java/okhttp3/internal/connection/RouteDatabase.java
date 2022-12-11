package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import me.tvspark.ef0;
import me.tvspark.ii0;
import okhttp3.Route;

@ef0
/* loaded from: classes4.dex */
public final class RouteDatabase {
    public final Set<Route> failedRoutes = new LinkedHashSet();

    public final synchronized void connected(Route route) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(route, "route");
        this.failedRoutes.remove(route);
    }

    public final synchronized void failed(Route route) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(route, "failedRoute");
        this.failedRoutes.add(route);
    }

    public final synchronized boolean shouldPostpone(Route route) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(route, "route");
        return this.failedRoutes.contains(route);
    }
}
