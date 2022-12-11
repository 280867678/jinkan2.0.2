package org.simpleframework.xml.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.tvspark.outline;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.Style;
import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

/* loaded from: classes5.dex */
public class PathParser implements Expression {
    public boolean attribute;
    public String cache;
    public int count;
    public char[] data;
    public String location;
    public int off;
    public String path;
    public int start;
    public Style style;
    public Type type;
    public Cache<String> attributes = new ConcurrentCache();
    public Cache<String> elements = new ConcurrentCache();
    public List<Integer> indexes = new ArrayList();
    public List<String> prefixes = new ArrayList();
    public List<String> names = new ArrayList();
    public StringBuilder builder = new StringBuilder();

    /* loaded from: classes5.dex */
    public class PathSection implements Expression {
        public int begin;
        public List<String> cache = new ArrayList();
        public int end;
        public String path;
        public String section;

        public PathSection(int i, int i2) {
            this.begin = i;
            this.end = i2;
        }

        private String getCanonicalPath() {
            int i = 0;
            int i2 = 0;
            while (i < this.begin) {
                i2 = PathParser.this.location.indexOf(47, i2 + 1);
                i++;
            }
            int i3 = i2;
            while (i <= this.end) {
                i3 = PathParser.this.location.indexOf(47, i3 + 1);
                if (i3 == -1) {
                    i3 = PathParser.this.location.length();
                }
                i++;
            }
            return PathParser.this.location.substring(i2 + 1, i3);
        }

        private String getFragment() {
            int i = PathParser.this.start;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i2 > this.end) {
                    break;
                }
                PathParser pathParser = PathParser.this;
                if (i >= pathParser.count) {
                    i++;
                    break;
                }
                int i4 = i + 1;
                if (pathParser.data[i] == '/' && (i2 = i2 + 1) == this.begin) {
                    i = i4;
                    i3 = i;
                } else {
                    i = i4;
                }
            }
            return new String(PathParser.this.data, i3, (i - 1) - i3);
        }

        @Override // org.simpleframework.xml.core.Expression
        public String getAttribute(String str) {
            String path = getPath();
            return path != null ? PathParser.this.getAttributePath(path, str) : str;
        }

        @Override // org.simpleframework.xml.core.Expression
        public String getElement(String str) {
            String path = getPath();
            return path != null ? PathParser.this.getElementPath(path, str) : str;
        }

        @Override // org.simpleframework.xml.core.Expression
        public String getFirst() {
            return PathParser.this.names.get(this.begin);
        }

        @Override // org.simpleframework.xml.core.Expression
        public int getIndex() {
            return PathParser.this.indexes.get(this.begin).intValue();
        }

        @Override // org.simpleframework.xml.core.Expression
        public String getLast() {
            return PathParser.this.names.get(this.end);
        }

        @Override // org.simpleframework.xml.core.Expression
        public String getPath() {
            if (this.section == null) {
                this.section = getCanonicalPath();
            }
            return this.section;
        }

        @Override // org.simpleframework.xml.core.Expression
        public Expression getPath(int i) {
            return getPath(i, 0);
        }

        @Override // org.simpleframework.xml.core.Expression
        public Expression getPath(int i, int i2) {
            return new PathSection(this.begin + i, this.end - i2);
        }

        @Override // org.simpleframework.xml.core.Expression
        public String getPrefix() {
            return PathParser.this.prefixes.get(this.begin);
        }

        @Override // org.simpleframework.xml.core.Expression
        public boolean isAttribute() {
            PathParser pathParser = PathParser.this;
            return pathParser.attribute && this.end >= pathParser.names.size() - 1;
        }

        @Override // org.simpleframework.xml.core.Expression
        public boolean isEmpty() {
            return this.begin == this.end;
        }

        @Override // org.simpleframework.xml.core.Expression
        public boolean isPath() {
            return this.end - this.begin >= 1;
        }

        @Override // java.lang.Iterable
        public Iterator<String> iterator() {
            if (this.cache.isEmpty()) {
                for (int i = this.begin; i <= this.end; i++) {
                    String str = PathParser.this.names.get(i);
                    if (str != null) {
                        this.cache.add(str);
                    }
                }
            }
            return this.cache.iterator();
        }

        @Override // org.simpleframework.xml.core.Expression
        public String toString() {
            if (this.path == null) {
                this.path = getFragment();
            }
            return this.path;
        }
    }

    public PathParser(String str, Type type, Format format) throws Exception {
        this.style = format.getStyle();
        this.type = type;
        this.path = str;
        parse(str);
    }

    private void align() throws Exception {
        if (this.names.size() > this.indexes.size()) {
            this.indexes.add(1);
        }
    }

    private void attribute() throws Exception {
        char c;
        int i = this.off + 1;
        this.off = i;
        do {
            int i2 = this.off;
            if (i2 >= this.count) {
                if (i2 <= i) {
                    throw new PathException("Attribute reference in '%s' for %s is empty", this.path, this.type);
                }
                this.attribute = true;
                attribute(i, i2 - i);
                return;
            }
            char[] cArr = this.data;
            this.off = i2 + 1;
            c = cArr[i2];
        } while (isValid(c));
        throw new PathException("Illegal character '%s' in attribute for '%s' in %s", Character.valueOf(c), this.path, this.type);
    }

    private void attribute(int i, int i2) {
        String str = new String(this.data, i, i2);
        if (i2 > 0) {
            attribute(str);
        }
    }

    private void attribute(String str) {
        String attribute = this.style.getAttribute(str);
        this.prefixes.add(null);
        this.names.add(attribute);
    }

    private void build() {
        int size = this.names.size();
        int i = size - 1;
        for (int i2 = 0; i2 < size; i2++) {
            String str = this.prefixes.get(i2);
            String str2 = this.names.get(i2);
            int intValue = this.indexes.get(i2).intValue();
            if (i2 > 0) {
                this.builder.append('/');
            }
            if (!this.attribute || i2 != i) {
                if (str != null) {
                    this.builder.append(str);
                    this.builder.append(':');
                }
                this.builder.append(str2);
                this.builder.append('[');
                this.builder.append(intValue);
                this.builder.append(']');
            } else {
                this.builder.append('@');
                this.builder.append(str2);
            }
        }
        this.location = this.builder.toString();
    }

    private void element() throws Exception {
        int i = this.off;
        int i2 = 0;
        while (true) {
            int i3 = this.off;
            if (i3 >= this.count) {
                break;
            }
            char[] cArr = this.data;
            this.off = i3 + 1;
            char c = cArr[i3];
            if (isValid(c)) {
                i2++;
            } else if (c == '@') {
                this.off--;
            } else if (c == '[') {
                index();
            } else if (c != '/') {
                throw new PathException("Illegal character '%s' in element for '%s' in %s", Character.valueOf(c), this.path, this.type);
            }
        }
        element(i, i2);
    }

    private void element(int i, int i2) {
        String str = new String(this.data, i, i2);
        if (i2 > 0) {
            element(str);
        }
    }

    private void element(String str) {
        String str2;
        int indexOf = str.indexOf(58);
        if (indexOf > 0) {
            str2 = str.substring(0, indexOf);
            str = str.substring(indexOf + 1);
        } else {
            str2 = null;
        }
        String element = this.style.getElement(str);
        this.prefixes.add(str2);
        this.names.add(element);
    }

    private void index() throws Exception {
        int i;
        if (this.data[this.off - 1] == '[') {
            i = 0;
            while (true) {
                int i2 = this.off;
                if (i2 >= this.count) {
                    break;
                }
                char[] cArr = this.data;
                this.off = i2 + 1;
                char c = cArr[i2];
                if (!isDigit(c)) {
                    break;
                }
                i = ((i * 10) + c) - 48;
            }
        } else {
            i = 0;
        }
        char[] cArr2 = this.data;
        int i3 = this.off;
        this.off = i3 + 1;
        if (cArr2[i3 - 1] == ']') {
            this.indexes.add(Integer.valueOf(i));
            return;
        }
        throw new PathException("Invalid index for path '%s' in %s", this.path, this.type);
    }

    private boolean isDigit(char c) {
        return Character.isDigit(c);
    }

    private boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    private boolean isLetter(char c) {
        return Character.isLetterOrDigit(c);
    }

    private boolean isSpecial(char c) {
        return c == '_' || c == '-' || c == ':';
    }

    private boolean isValid(char c) {
        return isLetter(c) || isSpecial(c);
    }

    private void parse(String str) throws Exception {
        if (str != null) {
            int length = str.length();
            this.count = length;
            char[] cArr = new char[length];
            this.data = cArr;
            str.getChars(0, length, cArr, 0);
        }
        path();
    }

    private void path() throws Exception {
        char[] cArr = this.data;
        int i = this.off;
        if (cArr[i] != '/') {
            if (cArr[i] == '.') {
                skip();
            }
            while (this.off < this.count) {
                if (this.attribute) {
                    throw new PathException("Path '%s' in %s references an invalid attribute", this.path, this.type);
                }
                segment();
            }
            truncate();
            build();
            return;
        }
        throw new PathException("Path '%s' in %s references document root", this.path, this.type);
    }

    private void segment() throws Exception {
        char c = this.data[this.off];
        if (c != '/') {
            if (c == '@') {
                attribute();
            } else {
                element();
            }
            align();
            return;
        }
        throw new PathException("Invalid path expression '%s' in %s", this.path, this.type);
    }

    private void skip() throws Exception {
        char[] cArr = this.data;
        if (cArr.length > 1) {
            int i = this.off;
            if (cArr[i + 1] != '/') {
                throw new PathException("Path '%s' in %s has an illegal syntax", this.path, this.type);
            }
            this.off = i + 1;
        }
        int i2 = this.off + 1;
        this.off = i2;
        this.start = i2;
    }

    private void truncate() throws Exception {
        int i = this.off;
        int i2 = i - 1;
        char[] cArr = this.data;
        if (i2 < cArr.length && cArr[i - 1] != '/') {
            return;
        }
        this.off = i - 1;
    }

    @Override // org.simpleframework.xml.core.Expression
    public String getAttribute(String str) {
        if (!isEmpty(this.location)) {
            String fetch = this.attributes.fetch(str);
            if (fetch == null && (fetch = getAttributePath(this.location, str)) != null) {
                this.attributes.cache(str, fetch);
            }
            return fetch;
        }
        return this.style.getAttribute(str);
    }

    public String getAttributePath(String str, String str2) {
        String attribute = this.style.getAttribute(str2);
        return isEmpty(str) ? attribute : outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "/@", attribute);
    }

    @Override // org.simpleframework.xml.core.Expression
    public String getElement(String str) {
        if (!isEmpty(this.location)) {
            String fetch = this.elements.fetch(str);
            if (fetch == null && (fetch = getElementPath(this.location, str)) != null) {
                this.elements.cache(str, fetch);
            }
            return fetch;
        }
        return this.style.getElement(str);
    }

    public String getElementPath(String str, String str2) {
        String element = this.style.getElement(str2);
        if (isEmpty(element)) {
            return str;
        }
        if (isEmpty(str)) {
            return element;
        }
        return str + "/" + element + "[1]";
    }

    @Override // org.simpleframework.xml.core.Expression
    public String getFirst() {
        return this.names.get(0);
    }

    @Override // org.simpleframework.xml.core.Expression
    public int getIndex() {
        return this.indexes.get(0).intValue();
    }

    @Override // org.simpleframework.xml.core.Expression
    public String getLast() {
        return this.names.get(this.names.size() - 1);
    }

    @Override // org.simpleframework.xml.core.Expression
    public String getPath() {
        return this.location;
    }

    @Override // org.simpleframework.xml.core.Expression
    public Expression getPath(int i) {
        return getPath(i, 0);
    }

    @Override // org.simpleframework.xml.core.Expression
    public Expression getPath(int i, int i2) {
        int size = (this.names.size() - 1) - i2;
        return size >= i ? new PathSection(i, size) : new PathSection(i, i);
    }

    @Override // org.simpleframework.xml.core.Expression
    public String getPrefix() {
        return this.prefixes.get(0);
    }

    @Override // org.simpleframework.xml.core.Expression
    public boolean isAttribute() {
        return this.attribute;
    }

    @Override // org.simpleframework.xml.core.Expression
    public boolean isEmpty() {
        return isEmpty(this.location);
    }

    @Override // org.simpleframework.xml.core.Expression
    public boolean isPath() {
        return this.names.size() > 1;
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        return this.names.iterator();
    }

    @Override // org.simpleframework.xml.core.Expression
    public String toString() {
        int i = this.off - this.start;
        if (this.cache == null) {
            this.cache = new String(this.data, this.start, i);
        }
        return this.cache;
    }
}
