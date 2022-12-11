package me.tvspark;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import org.apache.commons.lang3.time.FastDateFormat;
import org.seimicrawler.xpath.exception.XpathParserException;

/* loaded from: classes4.dex */
public class g71 implements j61 {
    @Override // me.tvspark.j61
    public m61 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(l61 l61Var, List<m61> list) {
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = list.get(0).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = list.get(1).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        try {
            if (list.size() > 2 && list.get(2) != null) {
                return new m61(new SimpleDateFormat(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, Locale.forLanguageTag(list.get(2).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww())).parse(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
            }
            return new m61(FastDateFormat.getInstance(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2).parse(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        } catch (ParseException e) {
            throw new XpathParserException("date format exception!", e);
        }
    }

    @Override // me.tvspark.j61
    public String name() {
        return "format-date";
    }
}
