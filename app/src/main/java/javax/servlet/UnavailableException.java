package javax.servlet;

/* loaded from: classes4.dex */
public class UnavailableException extends ServletException {
    public boolean permanent;
    public int seconds;
    public Servlet servlet;

    public UnavailableException(int i, Servlet servlet, String str) {
        super(str);
        this.servlet = servlet;
        this.seconds = i <= 0 ? -1 : i;
        this.permanent = false;
    }

    public UnavailableException(String str) {
        super(str);
        this.permanent = true;
    }

    public UnavailableException(String str, int i) {
        super(str);
        if (i <= 0) {
            this.seconds = -1;
        } else {
            this.seconds = i;
        }
        this.permanent = false;
    }

    public UnavailableException(Servlet servlet, String str) {
        super(str);
        this.servlet = servlet;
        this.permanent = true;
    }

    public Servlet getServlet() {
        return this.servlet;
    }

    public int getUnavailableSeconds() {
        if (this.permanent) {
            return -1;
        }
        return this.seconds;
    }

    public boolean isPermanent() {
        return this.permanent;
    }
}
