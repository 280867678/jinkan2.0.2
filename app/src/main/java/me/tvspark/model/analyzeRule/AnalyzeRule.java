package me.tvspark.model.analyzeRule;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.cardview.widget.RoundRectDrawableWithShadow;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import me.tvspark.ApplicationC1880C;
import me.tvspark.co0;
import me.tvspark.f30;
import me.tvspark.j30;
import me.tvspark.kl0;
import me.tvspark.ll0;
import me.tvspark.ml0;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Entities;

@Keep
/* loaded from: classes4.dex */
public class AnalyzeRule {
    public Object object;
    public Boolean isJSON = false;
    public ml0 analyzeByXPath = null;
    public ll0 analyzeByJSoup = null;
    public kl0 analyzeByJSonPath = null;
    public boolean objectChangedXP = false;
    public boolean objectChangedJS = false;
    public boolean objectChangedJP = false;

    /* loaded from: classes4.dex */
    public enum Mode {
        XPath,
        JSon,
        Default,
        Js
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public HashMap<String, String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new HashMap<>();
        public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public Mode Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        /* JADX WARN: Removed duplicated region for block: B:16:0x0080  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0092  */
        /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AnalyzeRule analyzeRule, String str, Mode mode) {
            Mode mode2;
            int i;
            String[] split;
            ArrayList arrayList;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = mode;
            if (mode == Mode.Js) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str.startsWith("<js>") ? str.substring(4, str.lastIndexOf("<")) : str.substring(4);
                return;
            }
            if (co0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "@XPath:")) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Mode.XPath;
                i = 7;
            } else {
                if (co0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "//")) {
                    mode2 = Mode.XPath;
                } else if (!co0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "@JSon:")) {
                    mode2 = str.startsWith("$.") ? Mode.JSon : mode2;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
                    split = str.trim().split("#");
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = split[0];
                    arrayList = new ArrayList();
                    if (split.length > 1) {
                        for (int i2 = 1; i2 < split.length; i2++) {
                            arrayList.add(split[i2]);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        return;
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        String[] split2 = ((String) it.next()).trim().split("\\^");
                        if (split2.length > 1) {
                            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(split2[0], split2[1]);
                        } else {
                            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(split2[0], "");
                        }
                    }
                    return;
                } else {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Mode.JSon;
                    i = 6;
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = mode2;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
                split = str.trim().split("#");
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = split[0];
                arrayList = new ArrayList();
                if (split.length > 1) {
                }
                if (arrayList.isEmpty()) {
                }
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str.substring(i);
            split = str.trim().split("#");
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = split[0];
            arrayList = new ArrayList();
            if (split.length > 1) {
            }
            if (arrayList.isEmpty()) {
            }
        }
    }

    private Object evalJS(String str, Object obj) {
        try {
            ApplicationC1880C.Wwwwww.put("result", obj);
            return ApplicationC1880C.Wwwwww.eval(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private kl0 getAnalyzeByJSonPath() {
        if (this.analyzeByJSonPath == null || this.objectChangedJP) {
            kl0 kl0Var = new kl0();
            this.analyzeByJSonPath = kl0Var;
            kl0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.object);
            this.objectChangedJP = false;
        }
        return this.analyzeByJSonPath;
    }

    private kl0 getAnalyzeByJSonPath(Object obj) {
        if (obj != this.object) {
            kl0 kl0Var = new kl0();
            kl0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
            return kl0Var;
        }
        return getAnalyzeByJSonPath();
    }

    private ll0 getAnalyzeByJSoup() {
        if (this.analyzeByJSoup == null || this.objectChangedJS) {
            ll0 ll0Var = new ll0();
            this.analyzeByJSoup = ll0Var;
            ll0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.object);
            this.objectChangedJS = false;
        }
        return this.analyzeByJSoup;
    }

    private ll0 getAnalyzeByJSoup(Object obj) {
        if (obj != this.object) {
            ll0 ll0Var = new ll0();
            ll0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
            return ll0Var;
        }
        return getAnalyzeByJSoup();
    }

    private ml0 getAnalyzeByXPath() {
        if (this.analyzeByXPath == null || this.objectChangedXP) {
            ml0 ml0Var = new ml0();
            this.analyzeByXPath = ml0Var;
            ml0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.object);
            this.objectChangedXP = false;
        }
        return this.analyzeByXPath;
    }

    private ml0 getAnalyzeByXPath(Object obj) {
        if (obj != this.object) {
            ml0 ml0Var = new ml0();
            ml0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
            return ml0Var;
        }
        return getAnalyzeByXPath();
    }

    @SuppressLint({"DefaultLocale"})
    private String replaceJs(String str) {
        try {
            if (!str.contains("{{") || !str.contains("}}")) {
                return str;
            }
            StringBuffer stringBuffer = new StringBuffer(str.length());
            Matcher matcher = ApplicationC1880C.Wwwwwww.matcher(str);
            while (matcher.find()) {
                Object evalJS = evalJS(matcher.group(1), this.object);
                if (evalJS instanceof String) {
                    matcher.appendReplacement(stringBuffer, (String) evalJS);
                } else {
                    matcher.appendReplacement(stringBuffer, (!(evalJS instanceof Double) || ((Double) evalJS).doubleValue() % 1.0d != RoundRectDrawableWithShadow.COS_45) ? String.valueOf(evalJS) : String.format("%.0f", (Double) evalJS));
                }
            }
            matcher.appendTail(stringBuffer);
            return stringBuffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    private String replaceRegex(String str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        if (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
            for (Map.Entry<String, String> entry : wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.entrySet()) {
                str = String.valueOf(str).replaceAll(entry.getKey(), entry.getValue());
            }
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> splitSourceRule(String str) {
        Mode mode;
        int i;
        String replaceJs;
        int i2;
        Matcher matcher;
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        if (co0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "@XPath:")) {
            mode = Mode.XPath;
            i = 7;
        } else if (!co0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "@JSon:")) {
            mode = this.isJSON.booleanValue() ? Mode.JSon : Mode.Default;
            replaceJs = replaceJs(str);
            i2 = 0;
            matcher = ApplicationC1880C.Wwwwwwww.matcher(replaceJs);
            while (matcher.find()) {
                if (matcher.start() > i2) {
                    String trim = replaceJs.substring(i2, matcher.start()).replaceAll("\n", "").trim();
                    if (!TextUtils.isEmpty(trim)) {
                        arrayList.add(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, trim, mode));
                    }
                }
                arrayList.add(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, matcher.group(), Mode.Js));
                i2 = matcher.end();
            }
            if (replaceJs.length() > i2) {
                String trim2 = replaceJs.substring(i2).replaceAll("\n", "").trim();
                if (!TextUtils.isEmpty(trim2)) {
                    arrayList.add(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, trim2, mode));
                }
            }
            return arrayList;
        } else {
            mode = Mode.JSon;
            i = 6;
        }
        str = str.substring(i);
        replaceJs = replaceJs(str);
        i2 = 0;
        matcher = ApplicationC1880C.Wwwwwwww.matcher(replaceJs);
        while (matcher.find()) {
        }
        if (replaceJs.length() > i2) {
        }
        return arrayList;
    }

    public Object getContent() {
        return this.object;
    }

    public Object getElement(String str) {
        List<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> splitSourceRule = splitSourceRule(str);
        Object obj = this.object;
        for (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : splitSourceRule) {
            int ordinal = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.ordinal();
            if (ordinal == 0) {
                obj = getAnalyzeByXPath(obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            } else if (ordinal == 1) {
                kl0 analyzeByJSonPath = getAnalyzeByJSonPath(obj);
                String str2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                obj = ((j30) analyzeByJSonPath.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, new f30[0]);
            } else if (ordinal != 3) {
                ll0 analyzeByJSoup = getAnalyzeByJSoup(obj);
                obj = analyzeByJSoup.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(analyzeByJSoup.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            } else {
                obj = evalJS(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, obj);
            }
            if (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty() && (obj instanceof String)) {
                obj = replaceRegex(String.valueOf(obj), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v0, types: [me.tvspark.model.analyzeRule.AnalyzeRule] */
    public List<Object> getElements(String str) {
        List<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> splitSourceRule = splitSourceRule(str);
        Object obj = !splitSourceRule.isEmpty() ? this.object : 0;
        for (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : splitSourceRule) {
            int ordinal = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.ordinal();
            if (ordinal == 0) {
                obj = getAnalyzeByXPath(obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            } else if (ordinal == 1) {
                obj = getAnalyzeByJSonPath(obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            } else if (ordinal != 3) {
                ll0 analyzeByJSoup = getAnalyzeByJSoup(obj);
                obj = analyzeByJSoup.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(analyzeByJSoup.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            } else {
                obj = evalJS(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, obj);
            }
            if (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty() && (obj instanceof String)) {
                obj = replaceRegex(String.valueOf((Object) obj), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }
        if (obj instanceof HashMap) {
            HashMap hashMap = obj;
            if (!hashMap.isEmpty()) {
                obj = new ArrayList();
                for (Map.Entry entry : hashMap.entrySet()) {
                    obj.add(((String) entry.getKey()) + "$" + ((String) entry.getValue()));
                }
            }
        }
        if (obj == 0) {
            return new ArrayList();
        }
        try {
            return (List) obj;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    public String getString(String str) {
        List<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> splitSourceRule = splitSourceRule(str);
        Object obj = !splitSourceRule.isEmpty() ? this.object : null;
        for (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : splitSourceRule) {
            if (!co0.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                int ordinal = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.ordinal();
                if (ordinal == 0) {
                    obj = getAnalyzeByXPath(obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                } else if (ordinal == 1) {
                    obj = getAnalyzeByJSonPath(obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                } else if (ordinal == 2) {
                    ll0 analyzeByJSoup = getAnalyzeByJSoup(obj);
                    String str2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (analyzeByJSoup == null) {
                        throw null;
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        List<String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = analyzeByJSoup.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2);
                        if (((ArrayList) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2).size() != 0) {
                            obj = TextUtils.join(StringUtils.SPACE, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2).trim();
                        }
                    }
                    obj = null;
                } else if (ordinal == 3) {
                    obj = evalJS(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, obj);
                }
            }
            if (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
                obj = replaceRegex(String.valueOf(obj), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }
        if (obj == null) {
            return "";
        }
        try {
            return Entities.unescape(String.valueOf(obj));
        } catch (Exception unused) {
            return String.valueOf(obj);
        }
    }

    public List<String> getStringList(List<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> list) {
        Object obj = !list.isEmpty() ? this.object : null;
        for (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : list) {
            if (!TextUtils.isEmpty(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                int ordinal = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.ordinal();
                obj = ordinal != 0 ? ordinal != 1 ? ordinal != 3 ? getAnalyzeByJSoup(obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) : evalJS(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, obj) : getAnalyzeByJSonPath(obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) : getAnalyzeByXPath(obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            if (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty() && (obj instanceof List)) {
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : (List) obj) {
                    arrayList.add(replaceRegex(String.valueOf(obj2), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                }
                obj = arrayList;
            } else if (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
                obj = replaceRegex(String.valueOf(obj), wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }
        if (obj == null) {
            return new ArrayList();
        }
        if (obj instanceof String) {
            obj = Arrays.asList(co0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((String) obj).split("\n"));
        }
        return (List) obj;
    }

    public AnalyzeRule setContent(Object obj) {
        if (obj != null) {
            this.isJSON = Boolean.valueOf(co0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(String.valueOf(obj)));
            this.object = obj;
            this.objectChangedXP = true;
            this.objectChangedJS = true;
            this.objectChangedJP = true;
            return this;
        }
        throw new AssertionError("Content cannot be null");
    }
}
