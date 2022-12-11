package me.tvspark;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* loaded from: classes4.dex */
public class ml0 {
    public c61 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public b61 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public final b61 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        if (str.endsWith("</td>")) {
            str = String.format("<tr>%s</tr>", str);
        }
        if (str.endsWith("</tr>") || str.endsWith("</tbody>")) {
            str = String.format("<table>%s</table>", str);
        }
        return new b61(Jsoup.parse(str).children());
    }

    public List<String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        String[] split;
        String str2;
        ArrayList arrayList = new ArrayList();
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
            c61 c61Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            for (c61 c61Var2 : c61Var != null ? c61Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str) : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str)) {
                arrayList.add(String.valueOf(c61Var2));
            }
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        for (String str3 : split) {
            List<String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str3);
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
        if (str.contains("&&")) {
            split = str.split("&&");
            str2 = "&";
        } else {
            split = str.split("\\|\\|");
            str2 = "|";
        }
        if (split.length == 1) {
            c61 c61Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            List<c61> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c61Var != null ? c61Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str) : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                return TextUtils.join(StringUtils.SPACE, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str3 : split) {
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str3);
            if (!TextUtils.isEmpty(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                arrayList.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                if (str2.equals("|")) {
                    break;
                }
            }
        }
        return TextUtils.join(StringUtils.SPACE, arrayList).trim();
    }

    public List<c61> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        String[] split;
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
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
            c61 c61Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            return c61Var != null ? c61Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(split[0]) : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(split[0]);
        }
        ArrayList arrayList2 = new ArrayList();
        for (String str3 : split) {
            List<c61> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str3);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null && !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
                arrayList2.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() > 0 && str2.equals("|")) {
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

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000d, code lost:
        if ((r0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof org.jsoup.nodes.Element) == false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ml0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
        b61 b61Var;
        b61 b61Var2;
        if (!(obj instanceof c61)) {
            if (obj instanceof Document) {
                b61Var = new b61(((Document) obj).children());
            } else if (obj instanceof Element) {
                b61Var2 = new b61(new Elements((Element) obj));
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = b61Var2;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                return this;
            } else if (obj instanceof Elements) {
                b61Var = new b61((Elements) obj);
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = b61Var;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            return this;
        }
        c61 c61Var = (c61) obj;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c61Var;
        b61Var2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj.toString());
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = b61Var2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        return this;
    }
}
