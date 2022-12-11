package javax.servlet.http;

import java.util.EventObject;
import me.tvspark.ee0;

/* loaded from: classes4.dex */
public class HttpSessionEvent extends EventObject {
    public HttpSessionEvent(ee0 ee0Var) {
        super(ee0Var);
    }

    public ee0 getSession() {
        return (ee0) super.getSource();
    }
}
