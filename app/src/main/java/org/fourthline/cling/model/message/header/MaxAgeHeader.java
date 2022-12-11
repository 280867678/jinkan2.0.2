package org.fourthline.cling.model.message.header;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.tvspark.outline;

/* loaded from: classes5.dex */
public class MaxAgeHeader extends UpnpHeader<Integer> {
    public static final Pattern MAX_AGE_REGEX = Pattern.compile(".*max-age\\s*=\\s*([0-9]+).*");

    public MaxAgeHeader() {
        setValue(1800);
    }

    public MaxAgeHeader(Integer num) {
        setValue(num);
    }

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public String getString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("max-age=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getValue().toString());
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    @Override // org.fourthline.cling.model.message.header.UpnpHeader
    public void setString(String str) throws InvalidHeaderException {
        Matcher matcher = MAX_AGE_REGEX.matcher(str.toLowerCase(Locale.ROOT));
        if (matcher.matches()) {
            setValue(Integer.valueOf(Integer.parseInt(matcher.group(1))));
            return;
        }
        throw new InvalidHeaderException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid cache-control value, can't parse max-age seconds: ", str));
    }
}
