package me.tvspark;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Collector;
import org.jsoup.select.Elements;
import org.jsoup.select.Evaluator;

/* loaded from: classes4.dex */
public class ll0 {
    public Element Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* JADX WARN: Code restructure failed: missing block: B:91:0x0182, code lost:
        if (r11 != false) goto L92;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Elements Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Element element, String str) {
        String[] strArr;
        char c;
        Elements children;
        String[] split;
        String[] split2;
        Object obj;
        int parseInt;
        int size;
        Element element2;
        char c2;
        Elements elements = new Elements();
        try {
            String[] split3 = str.trim().split("@");
            if (split3.length > 1) {
                elements.add(element);
                for (String str2 : split3) {
                    Elements elements2 = new Elements();
                    Iterator it = elements.iterator();
                    while (it.hasNext()) {
                        elements2.addAll(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Element) it.next(), str2));
                    }
                    elements.clear();
                    elements.addAll(elements2);
                }
            } else {
                String[] split4 = str.contains("~") ? str.split("~") : str.split("!");
                String[] split5 = split4[0].trim().split(">");
                String[] split6 = split5[0].trim().split("\\.");
                boolean z = split5.length > 1 && !TextUtils.isEmpty(split5[1].trim());
                if (z) {
                    strArr = split5[1].trim().split("\\.");
                    strArr[0] = strArr[0].trim();
                    List asList = Arrays.asList("class", "id", "tag", "text");
                    if (strArr.length >= 2 && asList.contains(strArr[0]) && !TextUtils.isEmpty(strArr[1].trim())) {
                        c2 = 1;
                        strArr[c2] = strArr[c2].trim();
                    }
                    c2 = 1;
                    z = false;
                    strArr[c2] = strArr[c2].trim();
                } else {
                    strArr = null;
                }
                String str3 = split6[0];
                switch (str3.hashCode()) {
                    case 3355:
                        if (str3.equals("id")) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    case 114586:
                        if (str3.equals("tag")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case 3556653:
                        if (str3.equals("text")) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    case 94742904:
                        if (str3.equals("class")) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1659526655:
                        if (str3.equals("children")) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                if (c == 0) {
                    children = element.children();
                    if (z) {
                        children = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(children, strArr);
                    }
                    elements.addAll(children);
                } else if (c == 1) {
                    children = element.getElementsByClass(split6[1]);
                    if (split6.length == 3) {
                        parseInt = Integer.parseInt(split6[2]);
                        if (parseInt < 0) {
                            size = children.size();
                            element2 = children.get(size + parseInt);
                            elements.add(element2);
                        }
                        element2 = children.get(parseInt);
                        elements.add(element2);
                    } else {
                        if (z) {
                            children = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(children, strArr);
                        }
                        elements.addAll(children);
                    }
                } else if (c == 2) {
                    children = element.getElementsByTag(split6[1]);
                    if (split6.length == 3) {
                        parseInt = Integer.parseInt(split6[2]);
                        if (parseInt < 0) {
                            size = children.size();
                            element2 = children.get(size + parseInt);
                            elements.add(element2);
                        }
                        element2 = children.get(parseInt);
                        elements.add(element2);
                    } else {
                        if (z) {
                            children = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(children, strArr);
                        }
                        elements.addAll(children);
                    }
                } else if (c != 3) {
                    if (c == 4) {
                        children = element.getElementsContainingOwnText(split6[1]);
                    } else if (split6.length == 3) {
                        elements.add(element.select("[" + split6[0] + "=" + split6[1] + "]").get(Integer.parseInt(split6[2])));
                    } else {
                        children = element.select("[" + split6[0] + "=" + split6[1] + "]");
                    }
                    elements.addAll(children);
                } else {
                    children = Collector.collect(new Evaluator.C3236Id(split6[1]), element);
                    if (split6.length == 3) {
                        parseInt = Integer.parseInt(split6[2]);
                        if (parseInt < 0) {
                            size = children.size();
                            element2 = children.get(size + parseInt);
                            elements.add(element2);
                        }
                        element2 = children.get(parseInt);
                        elements.add(element2);
                    } else {
                        if (z) {
                            children = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(children, strArr);
                        }
                        elements.addAll(children);
                    }
                }
                if (split4.length > 1) {
                    if (str.contains("~")) {
                        Elements elements3 = new Elements();
                        for (String str4 : split4[1].split(":")) {
                            int parseInt2 = Integer.parseInt(str4);
                            if (parseInt2 < 0 && elements.size() + parseInt2 >= 0) {
                                obj = elements.get(elements.size() + parseInt2);
                            } else if (Integer.parseInt(str4) < elements.size()) {
                                obj = elements.get(Integer.parseInt(str4));
                            }
                            elements3.add(obj);
                        }
                        elements.clear();
                        elements.addAll(elements3);
                    } else {
                        for (String str5 : split4[1].split(":")) {
                            int parseInt3 = Integer.parseInt(str5);
                            if (parseInt3 < 0 && elements.size() + parseInt3 >= 0) {
                                elements.set(elements.size() + parseInt3, null);
                            } else if (Integer.parseInt(str5) < elements.size()) {
                                elements.set(Integer.parseInt(str5), null);
                            }
                        }
                        Elements elements4 = new Elements();
                        elements4.add(null);
                        elements.removeAll(elements4);
                    }
                }
            }
        } catch (Exception unused) {
        }
        return elements;
    }

    public final List<String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Elements elements, String str) {
        String join;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        char c = 65535;
        try {
            switch (str.hashCode()) {
                case -1055246893:
                    if (str.equals("ownText")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1053421180:
                    if (str.equals("textNodes")) {
                        c = 1;
                        break;
                    }
                    break;
                case 96673:
                    if (str.equals("all")) {
                        c = 4;
                        break;
                    }
                    break;
                case 3213227:
                    if (str.equals("html")) {
                        c = 3;
                        break;
                    }
                    break;
                case 3556653:
                    if (str.equals("text")) {
                        c = 0;
                        break;
                    }
                    break;
            }
        } catch (Exception unused) {
        }
        if (c == 0) {
            Iterator<Element> it = elements.iterator();
            while (it.hasNext()) {
                arrayList2.add(it.next().text());
            }
        } else if (c == 1) {
            Iterator<Element> it2 = elements.iterator();
            while (it2.hasNext()) {
                List<TextNode> textNodes = it2.next().textNodes();
                for (int i = 0; i < textNodes.size(); i++) {
                    String trim = textNodes.get(i).text().trim();
                    if (!TextUtils.isEmpty(trim)) {
                        arrayList2.add(trim);
                    }
                }
            }
        } else if (c != 2) {
            if (c == 3) {
                elements.select("script, style").remove();
                join = elements.html();
            } else if (c != 4) {
                Iterator<Element> it3 = elements.iterator();
                while (it3.hasNext()) {
                    String attr = it3.next().attr(str);
                    if (!TextUtils.isEmpty(attr) && !arrayList.contains(attr)) {
                        arrayList.add(attr);
                    }
                }
                return arrayList;
            } else {
                join = elements.outerHtml();
            }
            arrayList.add(join);
            return arrayList;
        } else {
            Iterator<Element> it4 = elements.iterator();
            while (it4.hasNext()) {
                arrayList2.add(it4.next().ownText());
            }
        }
        join = TextUtils.join("\n", arrayList2);
        arrayList.add(join);
        return arrayList;
    }

    public final Elements Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Element element, String str) {
        String str2;
        boolean z;
        String[] split;
        Elements elements = new Elements();
        if (element != null && !TextUtils.isEmpty(str)) {
            new HashMap();
            if (co0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "@CSS:")) {
                str2 = str.substring(5).trim();
                z = true;
            } else {
                str2 = str.trim().split("#")[0];
                z = false;
            }
            String str3 = "&";
            if (str2.contains(str3)) {
                split = str2.split("&+");
            } else if (str2.contains("%")) {
                split = str2.split("%+");
                str3 = "%";
            } else {
                split = str2.split(z ? "\\|\\|" : "\\|+");
                str3 = "|";
            }
            ArrayList arrayList = new ArrayList();
            if (!z) {
                for (String str4 : split) {
                    Elements Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(element, str4);
                    arrayList.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() > 0 && str3.equals("|")) {
                        break;
                    }
                }
            } else {
                for (String str5 : split) {
                    Elements select = element.select(str5);
                    arrayList.add(select);
                    if (select.size() > 0 && str3.equals("|")) {
                        break;
                    }
                }
            }
            if (arrayList.size() > 0) {
                if ("%".equals(str3)) {
                    for (int i = 0; i < ((Elements) arrayList.get(0)).size(); i++) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            Elements elements2 = (Elements) it.next();
                            if (i < elements2.size()) {
                                elements.add(elements2.get(i));
                            }
                        }
                    }
                } else {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        elements.addAll((Elements) it2.next());
                    }
                }
            }
        }
        return elements;
    }

    public final Elements Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Elements elements, String[] strArr) {
        if (strArr == null || strArr.length < 2) {
            return elements;
        }
        Elements elements2 = new Elements();
        Iterator<Element> it = elements.iterator();
        while (it.hasNext()) {
            Element next = it.next();
            boolean z = false;
            String str = strArr[0];
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 3355) {
                if (hashCode != 114586) {
                    if (hashCode != 3556653) {
                        if (hashCode == 94742904 && str.equals("class")) {
                            c = 0;
                        }
                    } else if (str.equals("text")) {
                        c = 3;
                    }
                } else if (str.equals("tag")) {
                    c = 2;
                }
            } else if (str.equals("id")) {
                c = 1;
            }
            if (c == 0 ? next.getElementsByClass(strArr[1]).size() > 0 : !(c == 1 ? next.getElementById(strArr[1]) == null : c == 2 ? next.getElementsByTag(strArr[1]).size() <= 0 : c != 3 || next.getElementsContainingOwnText(strArr[1]).size() <= 0)) {
                z = true;
            }
            if (z) {
                elements2.add(next);
            }
        }
        return elements2;
    }

    public List<String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        String str2;
        boolean z;
        String[] split;
        String[] strArr;
        List<String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        HashMap hashMap = new HashMap();
        int i = 1;
        int i2 = 0;
        if (co0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "@CSS:")) {
            str2 = str.substring(5).trim();
            z = true;
        } else {
            str2 = str.trim().split("#")[0];
            z = false;
        }
        if (TextUtils.isEmpty(str2)) {
            arrayList.add(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.data());
        } else {
            String str3 = "&";
            if (str2.contains(str3)) {
                split = str2.split("&+");
            } else if (str2.contains("%%")) {
                split = str2.split("%%");
                str3 = "%";
            } else {
                split = str2.split(z ? "\\|\\|" : "\\|+");
                str3 = "|";
            }
            ArrayList arrayList2 = new ArrayList();
            int length = split.length;
            int i3 = 0;
            while (i3 < length) {
                String str4 = split[i3];
                if (z) {
                    int lastIndexOf = str4.lastIndexOf(64);
                    strArr = split;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.select(str4.substring(i2, lastIndexOf)), str4.substring(lastIndexOf + i));
                } else {
                    strArr = split;
                    if (!TextUtils.isEmpty(str4)) {
                        Elements elements = new Elements();
                        elements.add(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        String[] split2 = str4.split("@");
                        int i4 = 0;
                        while (i4 < split2.length - 1) {
                            Elements elements2 = new Elements();
                            Iterator<Element> it = elements.iterator();
                            while (it.hasNext()) {
                                elements2.addAll(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(it.next(), split2[i4]));
                            }
                            elements.clear();
                            i4++;
                            elements = elements2;
                        }
                        if (!elements.isEmpty()) {
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(elements, split2[split2.length - 1]);
                        }
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                }
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null && !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
                    arrayList2.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    if (!arrayList2.isEmpty() && str3.equals("|")) {
                        break;
                    }
                }
                i3++;
                split = strArr;
                i = 1;
                i2 = 0;
            }
            if (arrayList2.size() > 0) {
                if ("%".equals(str3)) {
                    for (int i5 = 0; i5 < ((List) arrayList2.get(0)).size(); i5++) {
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            List list = (List) it2.next();
                            if (i5 < list.size()) {
                                arrayList.add(list.get(i5));
                            }
                        }
                    }
                } else {
                    Iterator it3 = arrayList2.iterator();
                    while (it3.hasNext()) {
                        arrayList.addAll((List) it3.next());
                    }
                }
            }
        }
        if (!hashMap.isEmpty()) {
            ArrayList arrayList3 = new ArrayList(arrayList);
            arrayList.clear();
            Iterator it4 = arrayList3.iterator();
            while (it4.hasNext()) {
                String str5 = (String) it4.next();
                for (Map.Entry entry : hashMap.entrySet()) {
                    str5 = str5.replaceAll((String) entry.getKey(), (String) entry.getValue());
                }
                if (str5.length() > 0) {
                    arrayList.add(str5);
                }
            }
        }
        return arrayList;
    }

    public ll0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
        Element parse;
        if (obj instanceof Element) {
            parse = (Element) obj;
        } else {
            if (obj instanceof c61) {
                Object obj2 = ((c61) obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (obj2 instanceof Element) {
                    parse = (Element) obj2;
                } else if (obj2 instanceof Element) {
                    obj = (Element) obj2;
                } else if (obj2 instanceof Boolean) {
                    obj = (Boolean) obj2;
                } else if (obj2 instanceof Number) {
                    obj = (Double) obj2;
                } else if (obj2 instanceof Date) {
                    obj = (Date) obj2;
                } else {
                    obj = (String) obj2;
                }
            }
            parse = Jsoup.parse(obj.toString());
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = parse;
        return this;
    }
}
