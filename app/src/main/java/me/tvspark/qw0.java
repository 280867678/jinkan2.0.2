package me.tvspark;

import java.io.IOException;
import net.minidev.json.parser.ParseException;

/* loaded from: classes4.dex */
public abstract class qw0<T> {
    public final pw0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public qw0(pw0 pw0Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = pw0Var;
    }

    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        throw new RuntimeException(String.valueOf("Invalid or non Implemented status") + " createObject() in " + getClass());
    }

    public qw0<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) throws ParseException, IOException {
        throw new RuntimeException(String.valueOf("Invalid or non Implemented status") + " startObject(String key) in " + getClass() + " key=" + str);
    }

    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        throw new RuntimeException(String.valueOf("Invalid or non Implemented status") + " createArray() in " + getClass());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
        return obj;
    }

    public qw0<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) throws ParseException, IOException {
        throw new RuntimeException(String.valueOf("Invalid or non Implemented status") + " startArray in " + getClass() + " key=" + str);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, Object obj2) throws ParseException, IOException {
        throw new RuntimeException(String.valueOf("Invalid or non Implemented status") + " addValue(Object current, Object value) in " + getClass());
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, String str, Object obj2) throws ParseException, IOException {
        throw new RuntimeException(String.valueOf("Invalid or non Implemented status") + " setValue in " + getClass() + " key=" + str);
    }
}
