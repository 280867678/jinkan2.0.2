package org.simpleframework.xml.stream;

/* loaded from: classes5.dex */
public class HyphenStyle implements Style {
    public final Builder builder;
    public final Style style;

    public HyphenStyle() {
        HyphenBuilder hyphenBuilder = new HyphenBuilder();
        this.style = hyphenBuilder;
        this.builder = new Builder(hyphenBuilder);
    }

    @Override // org.simpleframework.xml.stream.Style
    public String getAttribute(String str) {
        return this.builder.getAttribute(str);
    }

    @Override // org.simpleframework.xml.stream.Style
    public String getElement(String str) {
        return this.builder.getElement(str);
    }

    public void setAttribute(String str, String str2) {
        this.builder.setAttribute(str, str2);
    }

    public void setElement(String str, String str2) {
        this.builder.setElement(str, str2);
    }
}
