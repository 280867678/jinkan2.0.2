package org.apache.http.message;

import me.tvspark.outline;

/* loaded from: classes4.dex */
public class ParserCursor {
    public final int lowerBound;
    public int pos;
    public final int upperBound;

    public ParserCursor(int i, int i2) {
        if (i >= 0) {
            if (i > i2) {
                throw new IndexOutOfBoundsException("Lower bound cannot be greater then upper bound");
            }
            this.lowerBound = i;
            this.upperBound = i2;
            this.pos = i;
            return;
        }
        throw new IndexOutOfBoundsException("Lower bound cannot be negative");
    }

    public boolean atEnd() {
        return this.pos >= this.upperBound;
    }

    public int getLowerBound() {
        return this.lowerBound;
    }

    public int getPos() {
        return this.pos;
    }

    public int getUpperBound() {
        return this.upperBound;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww('[');
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Integer.toString(this.lowerBound));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append('>');
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Integer.toString(this.pos));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append('>');
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Integer.toString(this.upperBound));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(']');
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    public void updatePos(int i) {
        if (i < this.lowerBound) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("pos: ", i, " < lowerBound: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.lowerBound);
            throw new IndexOutOfBoundsException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        } else if (i <= this.upperBound) {
            this.pos = i;
        } else {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("pos: ", i, " > upperBound: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.upperBound);
            throw new IndexOutOfBoundsException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        }
    }
}
