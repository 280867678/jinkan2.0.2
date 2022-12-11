package org.eclipse.jetty.util;

import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public abstract class PatternMatcher {
    public void match(Pattern pattern, URI[] uriArr, boolean z) throws Exception {
        if (uriArr != null) {
            String[] split = pattern == null ? null : pattern.pattern().split(",");
            ArrayList arrayList = new ArrayList();
            for (int i = 0; split != null && i < split.length; i++) {
                arrayList.add(Pattern.compile(split[i]));
            }
            if (arrayList.isEmpty()) {
                arrayList.add(pattern);
            }
            if (arrayList.isEmpty()) {
                matchPatterns(null, uriArr, z);
                return;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                matchPatterns((Pattern) it.next(), uriArr, z);
            }
        }
    }

    public void matchPatterns(Pattern pattern, URI[] uriArr, boolean z) throws Exception {
        for (int i = 0; i < uriArr.length; i++) {
            String uri = uriArr[i].toString();
            if ((pattern == null && z) || (pattern != null && pattern.matcher(uri).matches())) {
                matched(uriArr[i]);
            }
        }
    }

    public abstract void matched(URI uri) throws Exception;
}
