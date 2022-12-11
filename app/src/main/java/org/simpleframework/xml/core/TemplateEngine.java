package org.simpleframework.xml.core;

import org.simpleframework.xml.filter.Filter;

/* loaded from: classes5.dex */
public class TemplateEngine {
    public Filter filter;
    public int off;
    public Template source = new Template();
    public Template name = new Template();
    public Template text = new Template();

    public TemplateEngine(Filter filter) {
        this.filter = filter;
    }

    private void name() {
        while (true) {
            int i = this.off;
            Template template = this.source;
            if (i >= template.count) {
                break;
            }
            char[] cArr = template.buf;
            this.off = i + 1;
            char c = cArr[i];
            if (c == '}') {
                replace();
                break;
            }
            this.name.append(c);
        }
        if (this.name.length() > 0) {
            this.text.append("${");
            this.text.append(this.name);
        }
    }

    private void parse() {
        while (true) {
            int i = this.off;
            Template template = this.source;
            int i2 = template.count;
            if (i < i2) {
                char[] cArr = template.buf;
                int i3 = i + 1;
                this.off = i3;
                char c = cArr[i];
                if (c == '$' && i3 < i2) {
                    int i4 = i3 + 1;
                    this.off = i4;
                    if (cArr[i3] == '{') {
                        name();
                    } else {
                        this.off = i4 - 1;
                    }
                }
                this.text.append(c);
            } else {
                return;
            }
        }
    }

    private void replace() {
        if (this.name.length() > 0) {
            replace(this.name);
        }
        this.name.clear();
    }

    private void replace(String str) {
        Template template;
        String replace = this.filter.replace(str);
        if (replace == null) {
            this.text.append("${");
            this.text.append(str);
            template = this.text;
            replace = "}";
        } else {
            template = this.text;
        }
        template.append(replace);
    }

    private void replace(Template template) {
        replace(template.toString());
    }

    public void clear() {
        this.name.clear();
        this.text.clear();
        this.source.clear();
        this.off = 0;
    }

    public String process(String str) {
        if (str.indexOf(36) < 0) {
            return str;
        }
        try {
            this.source.append(str);
            parse();
            return this.text.toString();
        } finally {
            clear();
        }
    }
}
