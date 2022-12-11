package org.simpleframework.xml.stream;

/* loaded from: classes5.dex */
public class Format {
    public final int indent;
    public final String prolog;
    public final Style style;
    public final Verbosity verbosity;

    public Format() {
        this(3);
    }

    public Format(int i) {
        this(i, (String) null, new IdentityStyle());
    }

    public Format(int i, String str) {
        this(i, str, new IdentityStyle());
    }

    public Format(int i, String str, Style style) {
        this(i, str, style, Verbosity.HIGH);
    }

    public Format(int i, String str, Style style, Verbosity verbosity) {
        this.verbosity = verbosity;
        this.prolog = str;
        this.indent = i;
        this.style = style;
    }

    public Format(int i, Style style) {
        this(i, (String) null, style);
    }

    public Format(int i, Style style, Verbosity verbosity) {
        this(i, null, style, verbosity);
    }

    public Format(int i, Verbosity verbosity) {
        this(i, new IdentityStyle(), verbosity);
    }

    public Format(String str) {
        this(3, str);
    }

    public Format(Style style) {
        this(3, style);
    }

    public Format(Style style, Verbosity verbosity) {
        this(3, style, verbosity);
    }

    public Format(Verbosity verbosity) {
        this(3, verbosity);
    }

    public int getIndent() {
        return this.indent;
    }

    public String getProlog() {
        return this.prolog;
    }

    public Style getStyle() {
        return this.style;
    }

    public Verbosity getVerbosity() {
        return this.verbosity;
    }
}
