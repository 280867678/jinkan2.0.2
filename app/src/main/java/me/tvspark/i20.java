package me.tvspark;

import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes4.dex */
public final class i20 extends v00<Time> {
    public static final w00 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final DateFormat Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new SimpleDateFormat("hh:mm:ss a");

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements w00 {
        @Override // me.tvspark.w00
        public <T> v00<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k00 k00Var, t20<T> t20Var) {
            if (t20Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == Time.class) {
                return new i20();
            }
            return null;
        }
    }

    @Override // me.tvspark.v00
    public synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(JsonWriter jsonWriter, Time time) throws IOException {
        jsonWriter.value(time == null ? null : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.format((Date) time));
    }
}
