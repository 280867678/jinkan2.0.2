package me.tvspark;

import android.text.TextUtils;
import com.jayway.jsonpath.Option;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes4.dex */
public class kl0 {
    public static final Pattern Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Pattern.compile("(?<=\\{)\\$\\..+?(?=\\})");
    public c30 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public List<String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        String[] split;
        String str2;
        Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        if (str.contains("&&")) {
            split = str.split("&&");
            str2 = "&";
        } else if (str.contains("%%")) {
            split = str.split("%%");
            str2 = "%";
        } else {
            split = str.split("\\|\\|");
            str2 = "|";
        }
        if (split.length == 1) {
            if (str.contains("{$.")) {
                Matcher matcher = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.matcher(str);
                while (matcher.find()) {
                    for (String str3 : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(matcher.group())) {
                        arrayList.add(str.replace(String.format("{%s}", matcher.group()), str3));
                    }
                }
                return arrayList;
            }
            try {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ((j30) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, new f30[0]);
            } catch (Exception unused) {
            }
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                return arrayList;
            }
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof List) {
                for (Object obj : (List) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    arrayList.add(String.valueOf(obj));
                }
            } else {
                arrayList.add(String.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
            }
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        for (String str4 : split) {
            List<String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str4);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null && !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
                arrayList2.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() > 0 && str2.equals("|")) {
                    break;
                }
            }
        }
        if (arrayList2.size() > 0) {
            if ("%".equals(str2)) {
                for (int i = 0; i < ((List) arrayList2.get(0)).size(); i++) {
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        List list = (List) it.next();
                        if (i < list.size()) {
                            arrayList.add(list.get(i));
                        }
                    }
                }
            } else {
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    arrayList.addAll((List) it2.next());
                }
            }
        }
        return arrayList;
    }

    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        String[] split;
        String str2;
        String valueOf;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.contains("{$.")) {
            Matcher matcher = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.matcher(str);
            while (matcher.find()) {
                str = str.replace(String.format("{%s}", matcher.group()), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(matcher.group().trim()));
            }
            return str;
        }
        if (str.contains("&&")) {
            split = str.split("&&");
            str2 = "&";
        } else {
            split = str.split("\\|\\|");
            str2 = "|";
        }
        if (split.length != 1) {
            ArrayList arrayList = new ArrayList();
            for (String str3 : split) {
                String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str3);
                if (!TextUtils.isEmpty(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2)) {
                    arrayList.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                    if (str2.equals("|")) {
                        break;
                    }
                }
            }
            return TextUtils.join(StringUtils.SPACE, arrayList).trim();
        }
        try {
            Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ((j30) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, new f30[0]);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof List) {
                StringBuilder sb = new StringBuilder();
                for (Object obj : (List) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    sb.append(obj);
                    sb.append("\n");
                }
                valueOf = sb.toString().replaceAll("\\n$", "");
            } else {
                valueOf = String.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            return valueOf;
        } catch (Exception unused) {
            return !str.startsWith("$.") ? str : "";
        }
    }

    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        String[] split;
        String str2;
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        if (str.contains("&&")) {
            split = str.split("&&");
            str2 = "&";
        } else if (str.contains("%%")) {
            split = str.split("%%");
            str2 = "%";
        } else {
            split = str.split("\\|\\|");
            str2 = "|";
        }
        if (split.length == 1) {
            try {
                return ((j30) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(split[0], new f30[0]);
            } catch (Exception unused) {
                return null;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (String str3 : split) {
            Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str3);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null && (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof List)) {
                List list = (List) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (!list.isEmpty()) {
                    arrayList2.add(list);
                    if (list.size() > 0 && str2.equals("|")) {
                        break;
                    }
                } else {
                    continue;
                }
            }
        }
        if (arrayList2.size() > 0) {
            if ("%".equals(str2)) {
                for (int i = 0; i < ((List) arrayList2.get(0)).size(); i++) {
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        List list2 = (List) it.next();
                        if (i < list2.size()) {
                            arrayList.add(list2.get(i));
                        }
                    }
                }
            } else {
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    arrayList.addAll((List) it2.next());
                }
            }
        }
        return arrayList;
    }

    public kl0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
        j30 j30Var;
        if (obj instanceof String) {
            String str = (String) obj;
            h30 h30Var = h30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            EnumSet noneOf = EnumSet.noneOf(Option.class);
            ArrayList arrayList = new ArrayList();
            if (h30Var != null) {
                c50 c50Var = new c50();
                noneOf.addAll(EnumSet.noneOf(Option.class));
                b30 b30Var = new b30(c50Var, h30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, noneOf, arrayList, null);
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "json string can not be null or empty", new Object[0]);
                j30Var = new j30(((c50) b30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str), b30Var);
            } else {
                throw null;
            }
        } else {
            h30 h30Var2 = h30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            EnumSet noneOf2 = EnumSet.noneOf(Option.class);
            ArrayList arrayList2 = new ArrayList();
            if (h30Var2 != null) {
                c50 c50Var2 = new c50();
                noneOf2.addAll(EnumSet.noneOf(Option.class));
                b30 b30Var2 = new b30(c50Var2, h30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, noneOf2, arrayList2, null);
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, "json object can not be null", new Object[0]);
                j30Var = new j30(obj, b30Var2);
            } else {
                throw null;
            }
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j30Var;
        return this;
    }
}
