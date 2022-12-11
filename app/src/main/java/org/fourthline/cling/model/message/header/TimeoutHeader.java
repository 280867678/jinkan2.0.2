package org.fourthline.cling.model.message.header;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.tvspark.outline;

/* loaded from: classes5.dex */
public class TimeoutHeader extends UpnpHeader<Integer> {
    public static final Integer INFINITE_VALUE = Integer.MAX_VALUE;
    public static final Pattern PATTERN = Pattern.compile("Second-(?:([0-9]+)|infinite)");

    public TimeoutHeader() {
        setValue(1800);
    }

    public TimeoutHeader(int i) {
        setValue(Integer.valueOf(i));
    }

    public TimeoutHeader(Integer num) {
        setValue(num);
    }

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public String getString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Second-");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getValue().equals(INFINITE_VALUE) ? "infinite" : getValue());
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public void setString(String str) throws InvalidHeaderException {
        Matcher matcher = PATTERN.matcher(str);
        if (matcher.matches()) {
            setValue(matcher.group(1) != null ? Integer.valueOf(Integer.parseInt(matcher.group(1))) : INFINITE_VALUE);
            return;
        }
        throw new InvalidHeaderException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Can't parse timeout seconds integer from: ", str));
    }
}
