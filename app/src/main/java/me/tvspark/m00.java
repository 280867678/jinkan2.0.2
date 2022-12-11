package me.tvspark;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public final class m00 extends AbstractC3508o00 implements Iterable<AbstractC3508o00> {
    public final List<AbstractC3508o00> Wwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof m00) && ((m00) obj).Wwwwwwwwwwwwwwwwwwwwwwww.equals(this.Wwwwwwwwwwwwwwwwwwwwwwww));
    }

    public int hashCode() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<AbstractC3508o00> iterator() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.iterator();
    }
}
