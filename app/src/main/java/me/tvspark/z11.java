package me.tvspark;

import java.lang.reflect.Method;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes4.dex */
public class z11 {
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Class<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final ThreadMode Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Method Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public z11(Method method, Class<?> cls, ThreadMode threadMode, int i, boolean z) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = method;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = threadMode;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = cls;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
    }

    public final synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getName());
            sb.append('(');
            sb.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getName());
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = sb.toString();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof z11)) {
            return false;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        z11 z11Var = (z11) obj;
        z11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(z11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public int hashCode() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode();
    }
}
