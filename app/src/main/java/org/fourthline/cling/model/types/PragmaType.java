package org.fourthline.cling.model.types;

import me.tvspark.outline;

/* loaded from: classes5.dex */
public class PragmaType {
    public boolean quote;
    public String token;
    public String value;

    public PragmaType(String str) {
        this.token = null;
        this.value = str;
    }

    public PragmaType(String str, String str2) {
        this.token = str;
        this.value = str2;
    }

    public PragmaType(String str, String str2, boolean z) {
        this.token = str;
        this.value = str2;
        this.quote = z;
    }

    public static PragmaType valueOf(String str) throws InvalidValueException {
        if (str.length() != 0) {
            String str2 = null;
            String[] split = str.split("=");
            boolean z = false;
            if (split.length > 1) {
                str2 = split[0];
                str = split[1];
                if (str.startsWith("\"") && str.endsWith("\"")) {
                    str = str.substring(1, str.length() - 1);
                    z = true;
                }
            }
            return new PragmaType(str2, str, z);
        }
        throw new InvalidValueException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Can't parse Bytes Range: ", str));
    }

    public String getString() {
        String str = "";
        if (this.token != null) {
            str = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str), this.token, "=");
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.quote ? outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("\""), this.value, "\"") : this.value);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    public String getToken() {
        return this.token;
    }

    public String getValue() {
        return this.value;
    }
}
