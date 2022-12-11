package org.apache.commons.p056io.serialization;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: org.apache.commons.io.serialization.FullClassNameMatcher */
/* loaded from: classes4.dex */
public final class FullClassNameMatcher implements ClassNameMatcher {
    public final Set<String> classesSet;

    public FullClassNameMatcher(String... strArr) {
        this.classesSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(strArr)));
    }

    @Override // org.apache.commons.p056io.serialization.ClassNameMatcher
    public boolean matches(String str) {
        return this.classesSet.contains(str);
    }
}
