package org.simpleframework.xml.transform;

/* loaded from: classes5.dex */
public class DefaultMatcher implements Matcher {
    public Matcher matcher;
    public Matcher primitive = new PrimitiveMatcher();
    public Matcher stock = new PackageMatcher();
    public Matcher array = new ArrayMatcher(this);

    public DefaultMatcher(Matcher matcher) {
        this.matcher = matcher;
    }

    private Transform matchType(Class cls) throws Exception {
        return (cls.isArray() ? this.array : cls.isPrimitive() ? this.primitive : this.stock).match(cls);
    }

    @Override // org.simpleframework.xml.transform.Matcher
    public Transform match(Class cls) throws Exception {
        Transform match = this.matcher.match(cls);
        return match != null ? match : matchType(cls);
    }
}
