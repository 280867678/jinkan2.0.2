package org.apache.commons.p056io.serialization;

import org.apache.commons.p056io.FilenameUtils;

/* renamed from: org.apache.commons.io.serialization.WildcardClassNameMatcher */
/* loaded from: classes4.dex */
public final class WildcardClassNameMatcher implements ClassNameMatcher {
    public final String pattern;

    public WildcardClassNameMatcher(String str) {
        this.pattern = str;
    }

    @Override // org.apache.commons.p056io.serialization.ClassNameMatcher
    public boolean matches(String str) {
        return FilenameUtils.wildcardMatch(str, this.pattern);
    }
}
