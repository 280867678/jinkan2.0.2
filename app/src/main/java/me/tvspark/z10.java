package me.tvspark;

import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes4.dex */
public final class z10 extends v00<Date> {
    public static final w00 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final List<DateFormat> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements w00 {
        @Override // me.tvspark.w00
        public <T> v00<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k00 k00Var, t20<T> t20Var) {
            if (t20Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == Date.class) {
                return new z10();
            }
            return null;
        }
    }

    public z10() {
        ArrayList arrayList = new ArrayList();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = arrayList;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (p10.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 9) {
            List<DateFormat> list = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            list.add(new SimpleDateFormat("MMM d, yyyy" + StringUtils.SPACE + "h:mm:ss a", Locale.US));
        }
    }

    @Override // me.tvspark.v00
    public synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(JsonWriter jsonWriter, Date date) throws IOException {
        if (date == null) {
            jsonWriter.nullValue();
        } else {
            jsonWriter.value(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(0).format(date));
        }
    }
}
