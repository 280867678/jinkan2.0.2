package me.tvspark;

import com.jayway.jsonpath.InvalidPathException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class j40 {
    public static final Pattern Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Pattern.compile("\\s*,\\s*");
    public final List<Integer> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public j40(List<Integer> list) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Collections.unmodifiableList(list);
    }

    public static j40 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (!Character.isDigit(charAt) && charAt != ',' && charAt != ' ' && charAt != '-') {
                throw new InvalidPathException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Failed to parse ArrayIndexOperation: ", str));
            }
        }
        String[] split = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.split(str, -1);
        ArrayList arrayList = new ArrayList(split.length);
        for (String str2 : split) {
            try {
                arrayList.add(Integer.valueOf(Integer.parseInt(str2)));
            } catch (Exception e) {
                throw new InvalidPathException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Failed to parse token in ArrayIndexOperation: ", str2), e);
            }
        }
        return new j40(arrayList);
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(",", (Iterable<? extends Object>) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("]");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
