package me.tvspark;

/* renamed from: me.tvspark.ft */
/* loaded from: classes4.dex */
public abstract class AbstractC2123ft implements AbstractC2573rt<Character> {

    /* renamed from: me.tvspark.ft$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final char Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(char c) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = c;
        }

        @Override // me.tvspark.AbstractC2123ft
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(char c) {
            return c == this.Wwwwwwwwwwwwwwwwwwwwwwww;
        }

        public String toString() {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("CharMatcher.is('");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(AbstractC2123ft.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("')");
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
    }

    /* renamed from: me.tvspark.ft$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final char Wwwwwwwwwwwwwwwwwwwwwww;
        public final char Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(char c, char c2) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2 >= c);
            this.Wwwwwwwwwwwwwwwwwwwwwwww = c;
            this.Wwwwwwwwwwwwwwwwwwwwwww = c2;
        }

        @Override // me.tvspark.AbstractC2123ft
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(char c) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww <= c && c <= this.Wwwwwwwwwwwwwwwwwwwwwww;
        }

        public String toString() {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("CharMatcher.inRange('");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(AbstractC2123ft.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("', '");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(AbstractC2123ft.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("')");
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
    }

    /* renamed from: me.tvspark.ft$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static abstract class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AbstractC2123ft {
        @Override // me.tvspark.AbstractC2573rt
        @Deprecated
        public boolean apply(Character ch) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ch.charValue());
        }
    }

    public static /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(char c) {
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        for (int i = 0; i < 4; i++) {
            cArr[5 - i] = "0123456789ABCDEF".charAt(c & 15);
            c = (char) (c >> 4);
        }
        return String.copyValueOf(cArr);
    }

    public abstract boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(char c);
}
