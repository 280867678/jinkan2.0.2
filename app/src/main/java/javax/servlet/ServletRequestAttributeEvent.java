package javax.servlet;

/* loaded from: classes4.dex */
public class ServletRequestAttributeEvent extends ServletRequestEvent {
    public String name;
    public Object value;

    public ServletRequestAttributeEvent(ServletContext servletContext, ServletRequest servletRequest, String str, Object obj) {
        super(servletContext, servletRequest);
        this.name = str;
        this.value = obj;
    }

    public String getName() {
        return this.name;
    }

    public Object getValue() {
        return this.value;
    }
}
