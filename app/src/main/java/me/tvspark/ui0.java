package me.tvspark;

import java.util.Iterator;

/* loaded from: classes4.dex */
public class ui0 implements Iterable<Character>, pi0 {
    public final int Wwwwwwwwwwwwwwwwwwwwww;
    public final char Wwwwwwwwwwwwwwwwwwwwwww;
    public final char Wwwwwwwwwwwwwwwwwwwwwwww;

    public ui0(char c, char c2, int i) {
        if (i != 0) {
            if (i == Integer.MIN_VALUE) {
                throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwww = c;
            this.Wwwwwwwwwwwwwwwwwwwwwww = (char) r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) c, (int) c2, i);
            this.Wwwwwwwwwwwwwwwwwwwwww = i;
            return;
        }
        throw new IllegalArgumentException("Step must be non-zero.");
    }

    @Override // java.lang.Iterable
    public Iterator<Character> iterator() {
        return new vi0(this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww);
    }
}
