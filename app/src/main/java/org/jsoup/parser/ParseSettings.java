package org.jsoup.parser;

import org.jsoup.internal.Normalizer;
import org.jsoup.nodes.Attributes;

/* loaded from: classes5.dex */
public class ParseSettings {
    public static final ParseSettings htmlDefault = new ParseSettings(false, false);
    public static final ParseSettings preserveCase = new ParseSettings(true, true);
    public final boolean preserveAttributeCase;
    public final boolean preserveTagCase;

    public ParseSettings(boolean z, boolean z2) {
        this.preserveTagCase = z;
        this.preserveAttributeCase = z2;
    }

    public String normalizeAttribute(String str) {
        String trim = str.trim();
        return !this.preserveAttributeCase ? Normalizer.lowerCase(trim) : trim;
    }

    public Attributes normalizeAttributes(Attributes attributes) {
        if (attributes != null && !this.preserveAttributeCase) {
            attributes.normalize();
        }
        return attributes;
    }

    public String normalizeTag(String str) {
        String trim = str.trim();
        return !this.preserveTagCase ? Normalizer.lowerCase(trim) : trim;
    }

    public boolean preserveAttributeCase() {
        return this.preserveAttributeCase;
    }

    public boolean preserveTagCase() {
        return this.preserveTagCase;
    }
}
