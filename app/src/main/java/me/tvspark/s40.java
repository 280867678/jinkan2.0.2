package me.tvspark;

import java.util.HashMap;
import me.tvspark.f30;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: classes4.dex */
public class s40 implements f30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    public static final Logger Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = LoggerFactory.getLogger(s40.class);
    public final HashMap<k30, Object> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final b30 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public s40(Object obj, Object obj2, b30 b30Var, HashMap<k30, Object> hashMap) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = obj;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = obj2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = b30Var;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = hashMap;
    }

    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k30 k30Var) {
        l40 l40Var = (l40) k30Var;
        if (l40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.containsKey(k30Var)) {
                Object obj = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ((m40) l40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, obj, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(k30Var, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            Logger logger = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Using cached result for root path: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(k30Var.toString());
            logger.debug(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(k30Var);
        }
        return ((m40) l40Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }
}
