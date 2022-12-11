package org.apache.commons.lang3;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
public final class CharRange implements Iterable<Character>, Serializable {
    public static final long serialVersionUID = 8270183163158333422L;
    public final char end;
    public transient String iToString;
    public final boolean negated;
    public final char start;

    /* loaded from: classes4.dex */
    public static class CharacterIterator implements Iterator<Character> {
        public char current;
        public boolean hasNext;
        public final CharRange range;

        public CharacterIterator(CharRange charRange) {
            char c;
            this.range = charRange;
            this.hasNext = true;
            if (!charRange.negated) {
                c = this.range.start;
            } else if (this.range.start != 0) {
                this.current = (char) 0;
                return;
            } else if (this.range.end == 65535) {
                this.hasNext = false;
                return;
            } else {
                c = (char) (this.range.end + 1);
            }
            this.current = c;
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0033, code lost:
            if (r4.current < r4.range.end) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void prepareNext() {
            char c;
            if (this.range.negated) {
                char c2 = this.current;
                if (c2 != 65535) {
                    if (c2 + 1 == this.range.start) {
                        if (this.range.end != 65535) {
                            c = this.range.end;
                        }
                    }
                    c = this.current;
                }
                this.hasNext = false;
                return;
            }
            this.current = (char) (c + 1);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.hasNext;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        /* renamed from: next */
        public Character mo5124next() {
            if (this.hasNext) {
                char c = this.current;
                prepareNext();
                return Character.valueOf(c);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public CharRange(char c, char c2, boolean z) {
        if (c > c2) {
            c2 = c;
            c = c2;
        }
        this.start = c;
        this.end = c2;
        this.negated = z;
    }

    /* renamed from: is */
    public static CharRange m46is(char c) {
        return new CharRange(c, c, false);
    }

    public static CharRange isIn(char c, char c2) {
        return new CharRange(c, c2, false);
    }

    public static CharRange isNot(char c) {
        return new CharRange(c, c, true);
    }

    public static CharRange isNotIn(char c, char c2) {
        return new CharRange(c, c2, true);
    }

    public boolean contains(char c) {
        return (c >= this.start && c <= this.end) != this.negated;
    }

    public boolean contains(CharRange charRange) {
        if (charRange != null) {
            return this.negated ? charRange.negated ? this.start >= charRange.start && this.end <= charRange.end : charRange.end < this.start || charRange.start > this.end : charRange.negated ? this.start == 0 && this.end == 65535 : this.start <= charRange.start && this.end >= charRange.end;
        }
        throw new IllegalArgumentException("The Range must not be null");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CharRange)) {
            return false;
        }
        CharRange charRange = (CharRange) obj;
        return this.start == charRange.start && this.end == charRange.end && this.negated == charRange.negated;
    }

    public char getEnd() {
        return this.end;
    }

    public char getStart() {
        return this.start;
    }

    public int hashCode() {
        return (this.end * 7) + this.start + 'S' + (this.negated ? 1 : 0);
    }

    public boolean isNegated() {
        return this.negated;
    }

    @Override // java.lang.Iterable
    public Iterator<Character> iterator() {
        return new CharacterIterator();
    }

    public String toString() {
        if (this.iToString == null) {
            StringBuilder sb = new StringBuilder(4);
            if (isNegated()) {
                sb.append('^');
            }
            sb.append(this.start);
            if (this.start != this.end) {
                sb.append('-');
                sb.append(this.end);
            }
            this.iToString = sb.toString();
        }
        return this.iToString;
    }
}
