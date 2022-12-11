package org.simpleframework.xml.transform;

import java.util.regex.Pattern;
import org.apache.http.message.TokenParser;

/* loaded from: classes5.dex */
public class StringArrayTransform implements Transform<String[]> {
    public final Pattern pattern;
    public final String token;

    public StringArrayTransform() {
        this(",");
    }

    public StringArrayTransform(String str) {
        this.pattern = Pattern.compile(str);
        this.token = str;
    }

    private String[] read(String str, String str2) {
        String[] split = this.pattern.split(str);
        for (int i = 0; i < split.length; i++) {
            String str3 = split[i];
            if (str3 != null) {
                split[i] = str3.trim();
            }
        }
        return split;
    }

    private String write(String[] strArr, String str) {
        StringBuilder sb = new StringBuilder();
        for (String str2 : strArr) {
            if (str2 != null) {
                if (sb.length() > 0) {
                    sb.append(str);
                    sb.append(TokenParser.f4579SP);
                }
                sb.append(str2);
            }
        }
        return sb.toString();
    }

    @Override // org.simpleframework.xml.transform.Transform
    /* renamed from: read  reason: collision with other method in class */
    public String[] mo5334read(String str) {
        return read(str, this.token);
    }

    @Override // org.simpleframework.xml.transform.Transform
    public String write(String[] strArr) {
        return write(strArr, this.token);
    }
}
