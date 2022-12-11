package javax.servlet;

/* loaded from: classes4.dex */
public class ServletContextAttributeEvent extends ServletContextEvent {
    public String name;
    public Object value;

    public ServletContextAttributeEvent(ServletContext servletContext, String str, Object obj) {
        super(servletContext);
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
