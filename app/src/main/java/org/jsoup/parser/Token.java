package org.jsoup.parser;

import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.helper.Validate;
import org.jsoup.internal.Normalizer;
import org.jsoup.nodes.Attributes;
import org.seamless.xml.DOM;

/* loaded from: classes5.dex */
public abstract class Token {
    public TokenType type;

    /* loaded from: classes5.dex */
    public static final class CData extends Character {
        public CData(String str) {
            data(str);
        }

        @Override // org.jsoup.parser.Token.Character
        public String toString() {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DOM.CDATA_BEGIN);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getData());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(DOM.CDATA_END);
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
    }

    /* loaded from: classes5.dex */
    public static class Character extends Token {
        public String data;

        public Character() {
            super();
            this.type = TokenType.Character;
        }

        public Character data(String str) {
            this.data = str;
            return this;
        }

        public String getData() {
            return this.data;
        }

        @Override // org.jsoup.parser.Token
        /* renamed from: reset */
        public Token mo5272reset() {
            this.data = null;
            return this;
        }

        public String toString() {
            return getData();
        }
    }

    /* loaded from: classes5.dex */
    public static final class Comment extends Token {
        public String dataS;
        public final StringBuilder data = new StringBuilder();
        public boolean bogus = false;

        public Comment() {
            super();
            this.type = TokenType.Comment;
        }

        private void ensureData() {
            String str = this.dataS;
            if (str != null) {
                this.data.append(str);
                this.dataS = null;
            }
        }

        public final Comment append(char c) {
            ensureData();
            this.data.append(c);
            return this;
        }

        public final Comment append(String str) {
            ensureData();
            if (this.data.length() == 0) {
                this.dataS = str;
            } else {
                this.data.append(str);
            }
            return this;
        }

        public String getData() {
            String str = this.dataS;
            return str != null ? str : this.data.toString();
        }

        @Override // org.jsoup.parser.Token
        /* renamed from: reset */
        public Token mo5272reset() {
            Token.reset(this.data);
            this.dataS = null;
            this.bogus = false;
            return this;
        }

        public String toString() {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("<!--");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getData());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("-->");
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
    }

    /* loaded from: classes5.dex */
    public static final class Doctype extends Token {
        public final StringBuilder name = new StringBuilder();
        public String pubSysKey = null;
        public final StringBuilder publicIdentifier = new StringBuilder();
        public final StringBuilder systemIdentifier = new StringBuilder();
        public boolean forceQuirks = false;

        public Doctype() {
            super();
            this.type = TokenType.Doctype;
        }

        public String getName() {
            return this.name.toString();
        }

        public String getPubSysKey() {
            return this.pubSysKey;
        }

        public String getPublicIdentifier() {
            return this.publicIdentifier.toString();
        }

        public String getSystemIdentifier() {
            return this.systemIdentifier.toString();
        }

        public boolean isForceQuirks() {
            return this.forceQuirks;
        }

        @Override // org.jsoup.parser.Token
        /* renamed from: reset */
        public Token mo5272reset() {
            Token.reset(this.name);
            this.pubSysKey = null;
            Token.reset(this.publicIdentifier);
            Token.reset(this.systemIdentifier);
            this.forceQuirks = false;
            return this;
        }
    }

    /* loaded from: classes5.dex */
    public static final class EOF extends Token {
        public EOF() {
            super();
            this.type = TokenType.EOF;
        }

        @Override // org.jsoup.parser.Token
        /* renamed from: reset */
        public Token mo5272reset() {
            return this;
        }
    }

    /* loaded from: classes5.dex */
    public static final class EndTag extends Tag {
        public EndTag() {
            this.type = TokenType.EndTag;
        }

        public String toString() {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("</");
            String str = this.tagName;
            if (str == null) {
                str = "(unset)";
            }
            return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, str, ">");
        }
    }

    /* loaded from: classes5.dex */
    public static final class StartTag extends Tag {
        public StartTag() {
            this.type = TokenType.StartTag;
        }

        public StartTag nameAttr(String str, Attributes attributes) {
            this.tagName = str;
            this.attributes = attributes;
            this.normalName = Normalizer.lowerCase(str);
            return this;
        }

        @Override // org.jsoup.parser.Token.Tag, org.jsoup.parser.Token
        /* renamed from: reset */
        public Tag mo5272reset() {
            super.mo5272reset();
            this.attributes = null;
            return this;
        }

        public String toString() {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            String name;
            Attributes attributes = this.attributes;
            if (attributes == null || attributes.size() <= 0) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("<");
                name = name();
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("<");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(name());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(StringUtils.SPACE);
                name = this.attributes.toString();
            }
            return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, name, ">");
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class Tag extends Token {
        public Attributes attributes;
        public String normalName;
        public String pendingAttributeName;
        public String pendingAttributeValueS;
        public String tagName;
        public StringBuilder pendingAttributeValue = new StringBuilder();
        public boolean hasEmptyAttributeValue = false;
        public boolean hasPendingAttributeValue = false;
        public boolean selfClosing = false;

        public Tag() {
            super();
        }

        private void ensureAttributeValue() {
            this.hasPendingAttributeValue = true;
            String str = this.pendingAttributeValueS;
            if (str != null) {
                this.pendingAttributeValue.append(str);
                this.pendingAttributeValueS = null;
            }
        }

        public final void appendAttributeName(char c) {
            appendAttributeName(String.valueOf(c));
        }

        public final void appendAttributeName(String str) {
            String str2 = this.pendingAttributeName;
            if (str2 != null) {
                str = str2.concat(str);
            }
            this.pendingAttributeName = str;
        }

        public final void appendAttributeValue(char c) {
            ensureAttributeValue();
            this.pendingAttributeValue.append(c);
        }

        public final void appendAttributeValue(String str) {
            ensureAttributeValue();
            if (this.pendingAttributeValue.length() == 0) {
                this.pendingAttributeValueS = str;
            } else {
                this.pendingAttributeValue.append(str);
            }
        }

        public final void appendAttributeValue(char[] cArr) {
            ensureAttributeValue();
            this.pendingAttributeValue.append(cArr);
        }

        public final void appendAttributeValue(int[] iArr) {
            ensureAttributeValue();
            for (int i : iArr) {
                this.pendingAttributeValue.appendCodePoint(i);
            }
        }

        public final void appendTagName(char c) {
            appendTagName(String.valueOf(c));
        }

        public final void appendTagName(String str) {
            String str2 = this.tagName;
            if (str2 != null) {
                str = str2.concat(str);
            }
            this.tagName = str;
            this.normalName = Normalizer.lowerCase(str);
        }

        public final void finaliseTag() {
            if (this.pendingAttributeName != null) {
                newAttribute();
            }
        }

        public final Attributes getAttributes() {
            if (this.attributes == null) {
                this.attributes = new Attributes();
            }
            return this.attributes;
        }

        public final boolean isSelfClosing() {
            return this.selfClosing;
        }

        public final String name() {
            String str = this.tagName;
            Validate.isFalse(str == null || str.length() == 0);
            return this.tagName;
        }

        public final Tag name(String str) {
            this.tagName = str;
            this.normalName = Normalizer.lowerCase(str);
            return this;
        }

        public final void newAttribute() {
            if (this.attributes == null) {
                this.attributes = new Attributes();
            }
            String str = this.pendingAttributeName;
            if (str != null) {
                String trim = str.trim();
                this.pendingAttributeName = trim;
                if (trim.length() > 0) {
                    this.attributes.add(this.pendingAttributeName, this.hasPendingAttributeValue ? this.pendingAttributeValue.length() > 0 ? this.pendingAttributeValue.toString() : this.pendingAttributeValueS : this.hasEmptyAttributeValue ? "" : null);
                }
            }
            this.pendingAttributeName = null;
            this.hasEmptyAttributeValue = false;
            this.hasPendingAttributeValue = false;
            Token.reset(this.pendingAttributeValue);
            this.pendingAttributeValueS = null;
        }

        public final String normalName() {
            return this.normalName;
        }

        @Override // org.jsoup.parser.Token
        /* renamed from: reset */
        public Tag mo5272reset() {
            this.tagName = null;
            this.normalName = null;
            this.pendingAttributeName = null;
            Token.reset(this.pendingAttributeValue);
            this.pendingAttributeValueS = null;
            this.hasEmptyAttributeValue = false;
            this.hasPendingAttributeValue = false;
            this.selfClosing = false;
            this.attributes = null;
            return this;
        }

        public final void setEmptyAttributeValue() {
            this.hasEmptyAttributeValue = true;
        }
    }

    /* loaded from: classes5.dex */
    public enum TokenType {
        Doctype,
        StartTag,
        EndTag,
        Comment,
        Character,
        EOF
    }

    public Token() {
    }

    public static void reset(StringBuilder sb) {
        if (sb != null) {
            sb.delete(0, sb.length());
        }
    }

    public final Character asCharacter() {
        return (Character) this;
    }

    public final Comment asComment() {
        return (Comment) this;
    }

    public final Doctype asDoctype() {
        return (Doctype) this;
    }

    public final EndTag asEndTag() {
        return (EndTag) this;
    }

    public final StartTag asStartTag() {
        return (StartTag) this;
    }

    public final boolean isCData() {
        return this instanceof CData;
    }

    public final boolean isCharacter() {
        return this.type == TokenType.Character;
    }

    public final boolean isComment() {
        return this.type == TokenType.Comment;
    }

    public final boolean isDoctype() {
        return this.type == TokenType.Doctype;
    }

    public final boolean isEOF() {
        return this.type == TokenType.EOF;
    }

    public final boolean isEndTag() {
        return this.type == TokenType.EndTag;
    }

    public final boolean isStartTag() {
        return this.type == TokenType.StartTag;
    }

    /* renamed from: reset */
    public abstract Token mo5272reset();

    public String tokenType() {
        return getClass().getSimpleName();
    }
}
