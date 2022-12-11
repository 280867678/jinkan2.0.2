package org.apache.http.message;

import java.util.NoSuchElementException;
import me.tvspark.outline;
import org.apache.http.HeaderIterator;
import org.apache.http.ParseException;
import org.apache.http.TokenIterator;
import org.apache.http.util.Args;

/* loaded from: classes4.dex */
public class BasicTokenIterator implements TokenIterator {
    public static final String HTTP_SEPARATORS = " ,;=()<>@:\\\"/[]?{}\t";
    public String currentHeader;
    public String currentToken;
    public final HeaderIterator headerIt;
    public int searchPos = findNext(-1);

    public BasicTokenIterator(HeaderIterator headerIterator) {
        this.headerIt = (HeaderIterator) Args.notNull(headerIterator, "Header iterator");
    }

    public String createToken(String str, int i, int i2) {
        return str.substring(i, i2);
    }

    public int findNext(int i) throws ParseException {
        int findTokenSeparator;
        String createToken;
        int i2 = -1;
        if (i >= 0) {
            findTokenSeparator = findTokenSeparator(i);
        } else if (!this.headerIt.hasNext()) {
            return -1;
        } else {
            this.currentHeader = this.headerIt.nextHeader().getValue();
            findTokenSeparator = 0;
        }
        int findTokenStart = findTokenStart(findTokenSeparator);
        if (findTokenStart < 0) {
            createToken = null;
        } else {
            i2 = findTokenEnd(findTokenStart);
            createToken = createToken(this.currentHeader, findTokenStart, i2);
        }
        this.currentToken = createToken;
        return i2;
    }

    public int findTokenEnd(int i) {
        Args.notNegative(i, "Search position");
        int length = this.currentHeader.length();
        do {
            i++;
            if (i >= length) {
                break;
            }
        } while (isTokenChar(this.currentHeader.charAt(i)));
        return i;
    }

    public int findTokenSeparator(int i) {
        int notNegative = Args.notNegative(i, "Search position");
        int length = this.currentHeader.length();
        boolean z = false;
        while (!z && notNegative < length) {
            char charAt = this.currentHeader.charAt(notNegative);
            if (isTokenSeparator(charAt)) {
                z = true;
            } else if (!isWhitespace(charAt)) {
                if (isTokenChar(charAt)) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Tokens without separator (pos ", notNegative, "): ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.currentHeader);
                    throw new ParseException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                }
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid character after token (pos ", notNegative, "): ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.currentHeader);
                throw new ParseException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
            } else {
                notNegative++;
            }
        }
        return notNegative;
    }

    public int findTokenStart(int i) {
        int notNegative = Args.notNegative(i, "Search position");
        boolean z = false;
        while (!z) {
            String str = this.currentHeader;
            if (str == null) {
                break;
            }
            int length = str.length();
            while (!z && notNegative < length) {
                char charAt = this.currentHeader.charAt(notNegative);
                if (isTokenSeparator(charAt) || isWhitespace(charAt)) {
                    notNegative++;
                } else if (!isTokenChar(this.currentHeader.charAt(notNegative))) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Invalid character before token (pos ", notNegative, "): ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.currentHeader);
                    throw new ParseException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                } else {
                    z = true;
                }
            }
            if (!z) {
                if (this.headerIt.hasNext()) {
                    this.currentHeader = this.headerIt.nextHeader().getValue();
                    notNegative = 0;
                } else {
                    this.currentHeader = null;
                }
            }
        }
        if (z) {
            return notNegative;
        }
        return -1;
    }

    @Override // org.apache.http.TokenIterator, java.util.Iterator
    public boolean hasNext() {
        return this.currentToken != null;
    }

    public boolean isHttpSeparator(char c) {
        return HTTP_SEPARATORS.indexOf(c) >= 0;
    }

    public boolean isTokenChar(char c) {
        if (Character.isLetterOrDigit(c)) {
            return true;
        }
        return !Character.isISOControl(c) && !isHttpSeparator(c);
    }

    public boolean isTokenSeparator(char c) {
        return c == ',';
    }

    public boolean isWhitespace(char c) {
        return c == '\t' || Character.isSpaceChar(c);
    }

    @Override // java.util.Iterator
    public final Object next() throws NoSuchElementException, ParseException {
        return nextToken();
    }

    @Override // org.apache.http.TokenIterator
    public String nextToken() throws NoSuchElementException, ParseException {
        String str = this.currentToken;
        if (str != null) {
            this.searchPos = findNext(this.searchPos);
            return str;
        }
        throw new NoSuchElementException("Iteration already finished.");
    }

    @Override // java.util.Iterator
    public final void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Removing tokens is not supported.");
    }
}
