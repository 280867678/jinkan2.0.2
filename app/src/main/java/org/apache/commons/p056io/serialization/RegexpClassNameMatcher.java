package org.apache.commons.p056io.serialization;

import java.util.regex.Pattern;

/* renamed from: org.apache.commons.io.serialization.RegexpClassNameMatcher */
/* loaded from: classes4.dex */
public final class RegexpClassNameMatcher implements ClassNameMatcher {
    public final Pattern pattern;

    public RegexpClassNameMatcher(String str) {
        this(Pattern.compile(str));
    }

    public RegexpClassNameMatcher(Pattern pattern) {
        if (pattern != null) {
            this.pattern = pattern;
            return;
        }
        throw new IllegalArgumentException("Null pattern");
    }

    @Override // org.apache.commons.p056io.serialization.ClassNameMatcher
    public boolean matches(String str) {
        return this.pattern.matcher(str).matches();
    }
}
