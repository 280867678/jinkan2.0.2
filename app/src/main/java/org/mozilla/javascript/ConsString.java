package org.mozilla.javascript;

import java.io.Serializable;
import java.util.ArrayDeque;

/* loaded from: classes5.dex */
public class ConsString implements CharSequence, Serializable {
    public static final long serialVersionUID = -8432806714471372570L;
    public boolean isFlat = false;
    public CharSequence left;
    public final int length;
    public CharSequence right;

    public ConsString(CharSequence charSequence, CharSequence charSequence2) {
        this.left = charSequence;
        this.right = charSequence2;
        this.length = this.right.length() + charSequence.length();
    }

    private synchronized String flatten() {
        if (!this.isFlat) {
            char[] cArr = new char[this.length];
            int i = this.length;
            ArrayDeque arrayDeque = new ArrayDeque();
            arrayDeque.addFirst(this.left);
            CharSequence charSequence = this.right;
            do {
                if (charSequence instanceof ConsString) {
                    ConsString consString = (ConsString) charSequence;
                    if (consString.isFlat) {
                        charSequence = consString.left;
                    } else {
                        arrayDeque.addFirst(consString.left);
                        charSequence = consString.right;
                        continue;
                    }
                }
                String str = (String) charSequence;
                i -= str.length();
                str.getChars(0, str.length(), cArr, i);
                if (arrayDeque.isEmpty()) {
                    charSequence = null;
                    continue;
                } else {
                    charSequence = (CharSequence) arrayDeque.removeFirst();
                    continue;
                }
            } while (charSequence != null);
            this.left = new String(cArr);
            this.right = "";
            this.isFlat = true;
        }
        return (String) this.left;
    }

    private Object writeReplace() {
        return toString();
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return (this.isFlat ? (String) this.left : flatten()).charAt(i);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.length;
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return (this.isFlat ? (String) this.left : flatten()).substring(i, i2);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.isFlat ? (String) this.left : flatten();
    }
}
