package me.tvspark;

import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/* loaded from: classes4.dex */
public final class h20 extends v00<Date> {
    public static final w00 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final DateFormat Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new SimpleDateFormat("MMM d, yyyy");

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements w00 {
        @Override // me.tvspark.w00
        public <T> v00<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k00 k00Var, t20<T> t20Var) {
            if (t20Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == Date.class) {
                return new h20();
            }
            return null;
        }
    }

    @Override // me.tvspark.v00
    public synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(JsonWriter jsonWriter, Date date) throws IOException {
        jsonWriter.value(date == null ? null : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.format((java.util.Date) date));
    }
}
