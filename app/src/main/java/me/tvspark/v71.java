package me.tvspark;

import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes4.dex */
public class v71 implements k61 {
    public static Pattern Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Pattern.compile("\\d*\\.?\\d+");

    @Override // me.tvspark.k61
    public m61 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(l61 l61Var) {
        Matcher matcher = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.matcher(StringUtils.join((List) z71.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("allText").Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(l61Var).Wwwwwwwwwwwwwwwwwwwwwwww, ""));
        return matcher.find() ? new m61(Double.valueOf(new BigDecimal(matcher.group()).doubleValue())) : new m61(null);
    }

    @Override // me.tvspark.k61
    public String name() {
        return "num";
    }
}
