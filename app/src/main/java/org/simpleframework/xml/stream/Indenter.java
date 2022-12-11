package org.simpleframework.xml.stream;

import org.apache.http.message.TokenParser;

/* loaded from: classes5.dex */
public class Indenter {
    public Cache cache;
    public int count;
    public int indent;
    public int index;

    /* loaded from: classes5.dex */
    public static class Cache {
        public int count;
        public String[] list;

        public Cache(int i) {
            this.list = new String[i];
        }

        private void resize(int i) {
            String[] strArr = new String[i];
            int i2 = 0;
            while (true) {
                String[] strArr2 = this.list;
                if (i2 >= strArr2.length) {
                    this.list = strArr;
                    return;
                } else {
                    strArr[i2] = strArr2[i2];
                    i2++;
                }
            }
        }

        public String get(int i) {
            String[] strArr = this.list;
            if (i < strArr.length) {
                return strArr[i];
            }
            return null;
        }

        public void set(int i, String str) {
            if (i >= this.list.length) {
                resize(i * 2);
            }
            if (i > this.count) {
                this.count = i;
            }
            this.list[i] = str;
        }

        public int size() {
            return this.count;
        }
    }

    public Indenter() {
        this(new Format());
    }

    public Indenter(Format format) {
        this(format, 16);
    }

    public Indenter(Format format, int i) {
        this.indent = format.getIndent();
        this.cache = new Cache(i);
    }

    private String create() {
        int i = this.count;
        char[] cArr = new char[i + 1];
        if (i > 0) {
            cArr[0] = '\n';
            for (int i2 = 1; i2 <= this.count; i2++) {
                cArr[i2] = TokenParser.f4579SP;
            }
            return new String(cArr);
        }
        return "\n";
    }

    private String indent(int i) {
        if (this.indent > 0) {
            String str = this.cache.get(i);
            if (str == null) {
                str = create();
                this.cache.set(i, str);
            }
            return this.cache.size() > 0 ? str : "";
        }
        return "";
    }

    public String pop() {
        int i = this.index - 1;
        this.index = i;
        String indent = indent(i);
        int i2 = this.indent;
        if (i2 > 0) {
            this.count -= i2;
        }
        return indent;
    }

    public String push() {
        int i = this.index;
        this.index = i + 1;
        String indent = indent(i);
        int i2 = this.indent;
        if (i2 > 0) {
            this.count += i2;
        }
        return indent;
    }

    public String top() {
        return indent(this.index);
    }
}
