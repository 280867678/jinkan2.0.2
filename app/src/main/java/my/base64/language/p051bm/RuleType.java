package my.base64.language.p051bm;

/* renamed from: my.base64.language.bm.RuleType */
/* loaded from: classes4.dex */
public enum RuleType {
    APPROX("approx"),
    EXACT("exact"),
    RULES("rules");
    
    public final String name;

    RuleType(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}
