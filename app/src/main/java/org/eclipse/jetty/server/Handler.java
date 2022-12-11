package org.eclipse.jetty.server;

import java.io.IOException;
import javax.servlet.ServletException;
import me.tvspark.ae0;
import me.tvspark.ce0;
import org.eclipse.jetty.util.component.Destroyable;
import org.eclipse.jetty.util.component.LifeCycle;

/* loaded from: classes4.dex */
public interface Handler extends LifeCycle, Destroyable {
    @Override // org.eclipse.jetty.util.component.Destroyable
    void destroy();

    Server getServer();

    void handle(String str, Request request, ae0 ae0Var, ce0 ce0Var) throws IOException, ServletException;

    void setServer(Server server);
}
