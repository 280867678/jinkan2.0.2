package org.apache.commons.p056io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.util.regex.Pattern;
import org.apache.commons.p056io.IOCase;

/* renamed from: org.apache.commons.io.filefilter.RegexFileFilter */
/* loaded from: classes4.dex */
public class RegexFileFilter extends AbstractFileFilter implements Serializable {
    public static final long serialVersionUID = 4269646126155225062L;
    public final Pattern pattern;

    public RegexFileFilter(String str) {
        if (str != null) {
            this.pattern = Pattern.compile(str);
            return;
        }
        throw new IllegalArgumentException("Pattern is missing");
    }

    public RegexFileFilter(String str, int i) {
        if (str != null) {
            this.pattern = Pattern.compile(str, i);
            return;
        }
        throw new IllegalArgumentException("Pattern is missing");
    }

    public RegexFileFilter(String str, IOCase iOCase) {
        if (str != null) {
            int i = 0;
            if (iOCase != null && !iOCase.isCaseSensitive()) {
                i = 2;
            }
            this.pattern = Pattern.compile(str, i);
            return;
        }
        throw new IllegalArgumentException("Pattern is missing");
    }

    public RegexFileFilter(Pattern pattern) {
        if (pattern != null) {
            this.pattern = pattern;
            return;
        }
        throw new IllegalArgumentException("Pattern is missing");
    }

    @Override // org.apache.commons.p056io.filefilter.AbstractFileFilter, org.apache.commons.p056io.filefilter.IOFileFilter, java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return this.pattern.matcher(str).matches();
    }
}
