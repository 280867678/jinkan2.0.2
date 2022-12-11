package my.base64.language.p051bm;

/* renamed from: my.base64.language.bm.NameType */
/* loaded from: classes4.dex */
public enum NameType {
    ASHKENAZI("ash"),
    GENERIC("gen"),
    SEPHARDIC("sep");
    
    public final String name;

    NameType(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}
