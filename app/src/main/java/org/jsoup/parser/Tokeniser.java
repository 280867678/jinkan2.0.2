package org.jsoup.parser;

import com.tencent.bugly.beta.tinker.TinkerReport;
import com.umeng.analytics.pro.C1648o;
import java.util.Arrays;
import org.apache.http.message.BasicHeaderValueParser;
import org.apache.http.message.TokenParser;
import org.eclipse.jetty.util.B64Code;
import org.jsoup.helper.Validate;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Entities;
import org.jsoup.parser.Token;

/* loaded from: classes5.dex */
public final class Tokeniser {
    public static final char[] notCharRefCharsSorted;
    public static final char replacementChar = 65533;
    public static final int[] win1252Extensions = {8364, 129, 8218, 402, 8222, 8230, 8224, 8225, 710, 8240, TinkerReport.KEY_LOADED_PACKAGE_CHECK_LIB_META, 8249, 338, 141, 381, 143, 144, 8216, 8217, 8220, 8221, 8226, C1648o.C1650a.f3579A, C1648o.C1650a.f3580B, 732, 8482, TinkerReport.KEY_LOADED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, 8250, 339, 157, 382, 376};
    public static final int win1252ExtensionsStart = 128;
    public Token emitPending;
    public final ParseErrorList errors;
    public String lastStartTag;
    public final CharacterReader reader;
    public Token.Tag tagPending;
    public TokeniserState state = TokeniserState.Data;
    public boolean isEmitPending = false;
    public String charsString = null;
    public StringBuilder charsBuilder = new StringBuilder(1024);
    public StringBuilder dataBuffer = new StringBuilder(1024);
    public Token.StartTag startPending = new Token.StartTag();
    public Token.EndTag endPending = new Token.EndTag();
    public Token.Character charPending = new Token.Character();
    public Token.Doctype doctypePending = new Token.Doctype();
    public Token.Comment commentPending = new Token.Comment();
    public final int[] codepointHolder = new int[1];
    public final int[] multipointHolder = new int[2];

    static {
        char[] cArr = {'\t', '\n', '\r', '\f', TokenParser.f4579SP, '<', '&'};
        notCharRefCharsSorted = cArr;
        Arrays.sort(cArr);
    }

    public Tokeniser(CharacterReader characterReader, ParseErrorList parseErrorList) {
        this.reader = characterReader;
        this.errors = parseErrorList;
    }

    private void characterReferenceError(String str) {
        if (this.errors.canAddError()) {
            this.errors.add(new ParseError(this.reader.pos(), "Invalid character reference: %s", str));
        }
    }

    public void advanceTransition(TokeniserState tokeniserState) {
        this.reader.advance();
        this.state = tokeniserState;
    }

    public String appropriateEndTagName() {
        return this.lastStartTag;
    }

    public int[] consumeCharacterReference(Character ch, boolean z) {
        int i;
        if (this.reader.isEmpty()) {
            return null;
        }
        if ((ch != null && ch.charValue() == this.reader.current()) || this.reader.matchesAnySorted(notCharRefCharsSorted)) {
            return null;
        }
        int[] iArr = this.codepointHolder;
        this.reader.mark();
        if (this.reader.matchConsume("#")) {
            boolean matchConsumeIgnoreCase = this.reader.matchConsumeIgnoreCase("X");
            CharacterReader characterReader = this.reader;
            String consumeHexSequence = matchConsumeIgnoreCase ? characterReader.consumeHexSequence() : characterReader.consumeDigitSequence();
            if (consumeHexSequence.length() != 0) {
                this.reader.unmark();
                if (!this.reader.matchConsume(";")) {
                    characterReferenceError("missing semicolon");
                }
                try {
                    i = Integer.valueOf(consumeHexSequence, matchConsumeIgnoreCase ? 16 : 10).intValue();
                } catch (NumberFormatException unused) {
                    i = -1;
                }
                if (i == -1 || ((i >= 55296 && i <= 57343) || i > 1114111)) {
                    characterReferenceError("character outside of valid range");
                    iArr[0] = 65533;
                    return iArr;
                }
                if (i >= 128 && i < win1252Extensions.length + 128) {
                    characterReferenceError("character is not a valid unicode code point");
                    i = win1252Extensions[i - 128];
                }
                iArr[0] = i;
                return iArr;
            }
            characterReferenceError("numeric reference with no numerals");
        } else {
            String consumeLetterThenDigitSequence = this.reader.consumeLetterThenDigitSequence();
            boolean matches = this.reader.matches(BasicHeaderValueParser.PARAM_DELIMITER);
            if (!(Entities.isBaseNamedEntity(consumeLetterThenDigitSequence) || (Entities.isNamedEntity(consumeLetterThenDigitSequence) && matches))) {
                this.reader.rewindToMark();
                if (matches) {
                    characterReferenceError("invalid named reference");
                }
                return null;
            } else if (!z || (!this.reader.matchesLetter() && !this.reader.matchesDigit() && !this.reader.matchesAny(B64Code.__pad, '-', '_'))) {
                this.reader.unmark();
                if (!this.reader.matchConsume(";")) {
                    characterReferenceError("missing semicolon");
                }
                int codepointsForName = Entities.codepointsForName(consumeLetterThenDigitSequence, this.multipointHolder);
                if (codepointsForName == 1) {
                    iArr[0] = this.multipointHolder[0];
                    return iArr;
                } else if (codepointsForName == 2) {
                    return this.multipointHolder;
                } else {
                    Validate.fail("Unexpected characters returned for " + consumeLetterThenDigitSequence);
                    return this.multipointHolder;
                }
            }
        }
        this.reader.rewindToMark();
        return null;
    }

    public void createBogusCommentPending() {
        this.commentPending.mo5272reset();
        this.commentPending.bogus = true;
    }

    public void createCommentPending() {
        this.commentPending.mo5272reset();
    }

    public void createDoctypePending() {
        this.doctypePending.mo5272reset();
    }

    public Token.Tag createTagPending(boolean z) {
        Token.Tag mo5272reset = z ? this.startPending.mo5272reset() : this.endPending.mo5272reset();
        this.tagPending = mo5272reset;
        return mo5272reset;
    }

    public void createTempBuffer() {
        Token.reset(this.dataBuffer);
    }

    public boolean currentNodeInHtmlNS() {
        return true;
    }

    public void emit(char c) {
        emit(String.valueOf(c));
    }

    public void emit(String str) {
        if (this.charsString == null) {
            this.charsString = str;
            return;
        }
        if (this.charsBuilder.length() == 0) {
            this.charsBuilder.append(this.charsString);
        }
        this.charsBuilder.append(str);
    }

    public void emit(Token token) {
        Validate.isFalse(this.isEmitPending);
        this.emitPending = token;
        this.isEmitPending = true;
        Token.TokenType tokenType = token.type;
        if (tokenType == Token.TokenType.StartTag) {
            this.lastStartTag = ((Token.StartTag) token).tagName;
        } else if (tokenType != Token.TokenType.EndTag || ((Token.EndTag) token).attributes == null) {
        } else {
            error("Attributes incorrectly present on end tag");
        }
    }

    public void emit(char[] cArr) {
        emit(String.valueOf(cArr));
    }

    public void emit(int[] iArr) {
        emit(new String(iArr, 0, iArr.length));
    }

    public void emitCommentPending() {
        emit(this.commentPending);
    }

    public void emitDoctypePending() {
        emit(this.doctypePending);
    }

    public void emitTagPending() {
        this.tagPending.finaliseTag();
        emit(this.tagPending);
    }

    public void eofError(TokeniserState tokeniserState) {
        if (this.errors.canAddError()) {
            this.errors.add(new ParseError(this.reader.pos(), "Unexpectedly reached end of file (EOF) in input state [%s]", tokeniserState));
        }
    }

    public void error(String str) {
        if (this.errors.canAddError()) {
            this.errors.add(new ParseError(this.reader.pos(), str));
        }
    }

    public void error(TokeniserState tokeniserState) {
        if (this.errors.canAddError()) {
            this.errors.add(new ParseError(this.reader.pos(), "Unexpected character '%s' in input state [%s]", Character.valueOf(this.reader.current()), tokeniserState));
        }
    }

    public TokeniserState getState() {
        return this.state;
    }

    public boolean isAppropriateEndTagToken() {
        return this.lastStartTag != null && this.tagPending.name().equalsIgnoreCase(this.lastStartTag);
    }

    public Token read() {
        while (!this.isEmitPending) {
            this.state.read(this, this.reader);
        }
        StringBuilder sb = this.charsBuilder;
        if (sb.length() != 0) {
            String sb2 = sb.toString();
            sb.delete(0, sb.length());
            this.charsString = null;
            return this.charPending.data(sb2);
        }
        String str = this.charsString;
        if (str == null) {
            this.isEmitPending = false;
            return this.emitPending;
        }
        Token.Character data = this.charPending.data(str);
        this.charsString = null;
        return data;
    }

    public void transition(TokeniserState tokeniserState) {
        this.state = tokeniserState;
    }

    public String unescapeEntities(boolean z) {
        StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        while (!this.reader.isEmpty()) {
            borrowBuilder.append(this.reader.consumeTo('&'));
            if (this.reader.matches('&')) {
                this.reader.consume();
                int[] consumeCharacterReference = consumeCharacterReference(null, z);
                if (consumeCharacterReference == null || consumeCharacterReference.length == 0) {
                    borrowBuilder.append('&');
                } else {
                    borrowBuilder.appendCodePoint(consumeCharacterReference[0]);
                    if (consumeCharacterReference.length == 2) {
                        borrowBuilder.appendCodePoint(consumeCharacterReference[1]);
                    }
                }
            }
        }
        return StringUtil.releaseBuilder(borrowBuilder);
    }
}
