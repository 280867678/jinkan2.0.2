package javax.servlet.http;

import me.tvspark.ee0;

/* loaded from: classes4.dex */
public class HttpSessionBindingEvent extends HttpSessionEvent {
    public String name;
    public Object value;

    public HttpSessionBindingEvent(ee0 ee0Var, String str) {
        super(ee0Var);
        this.name = str;
    }

    public HttpSessionBindingEvent(ee0 ee0Var, String str, Object obj) {
        super(ee0Var);
        this.name = str;
        this.value = obj;
    }

    public String getName() {
        return this.name;
    }

    @Override // javax.servlet.http.HttpSessionEvent
    public ee0 getSession() {
        return super.getSession();
    }

    public Object getValue() {
        return this.value;
    }
}
