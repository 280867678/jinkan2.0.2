package me.tvspark;

import com.jayway.jsonpath.InvalidPathException;
import org.apache.http.message.TokenParser;

/* loaded from: classes4.dex */
public class g30 {
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
    public final CharSequence Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public g30(CharSequence charSequence) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = charSequence;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = charSequence.length() - 1;
    }

    public char Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        do {
            i++;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i)) {
                break;
            }
        } while (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i) == ' ');
        return !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i) ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i) : TokenParser.f4579SP;
    }

    public g30 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        while (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(TokenParser.f4579SP)) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww--;
        }
        return this;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        while (true) {
            i--;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i) || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i) != ' ') {
                break;
            }
        }
        if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i)) {
            return i;
        }
        return -1;
    }

    public g30 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        while (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == ' ') {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        }
        return this;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(char c) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == c) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
            return;
        }
        throw new InvalidPathException(String.format("Expected character: %c", Character.valueOf(c)));
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, char c) {
        int i2 = i + 1;
        while (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2) && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2) == ' ') {
            i2++;
        }
        return !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2) && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2) == c;
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        return i2;
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, char c) {
        boolean z = false;
        for (int i2 = i + 1; !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2); i2++) {
            if (z) {
                z = false;
            } else if ('\\' == Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2)) {
                z = true;
            } else if (c == Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2) && !z) {
                return i2;
            }
        }
        return -1;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(char c) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.charAt(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) == c;
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(char c) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c);
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, char c) {
        while (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i)) {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i) == c) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return i >= 0 && i <= this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public char Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.charAt(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public char Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.charAt(i);
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, char c) {
        do {
            i++;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i)) {
                break;
            }
        } while (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i) == ' ');
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i) == c) {
            return i;
        }
        return -1;
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, char c, char c2, boolean z, boolean z2) {
        char Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.charAt(i) == c) {
            int i2 = 1;
            int i3 = i + 1;
            while (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3)) {
                if (z && ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3)) == '\'' || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == '\"')) {
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1) {
                        throw new InvalidPathException("Could not find matching close quote for " + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + " when parsing : " + ((Object) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                    }
                    i3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1;
                }
                if (z2 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3) == '/') {
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3, '/');
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == -1) {
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Could not find matching close for / when parsing regex in : ");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append((Object) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        throw new InvalidPathException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                    }
                    i3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 + 1;
                }
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3) == c) {
                    i2++;
                }
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3) == c2 && i2 - 1 == 0) {
                    return i3;
                }
                i3++;
            }
            return -1;
        }
        throw new InvalidPathException("Expected " + c + " but found " + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.charAt(i));
    }

    public CharSequence Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.subSequence(i, i2);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CharSequence charSequence) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((charSequence.length() + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) - 1)) {
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, charSequence.length() + i).equals(charSequence)) {
                throw new InvalidPathException(String.format("Expected: %s", charSequence));
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence.length());
            return;
        }
        throw new InvalidPathException(String.format("End of string reached while expecting: %s", charSequence));
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(char c) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.charAt(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) == c;
    }

    public String toString() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
