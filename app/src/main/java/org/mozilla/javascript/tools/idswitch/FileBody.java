package org.mozilla.javascript.tools.idswitch;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/* loaded from: classes5.dex */
public class FileBody {
    public char[] buffer = new char[16384];
    public int bufferEnd;
    public ReplaceItem firstReplace;
    public ReplaceItem lastReplace;
    public int lineBegin;
    public int lineEnd;
    public int lineNumber;
    public int nextLineStart;

    /* loaded from: classes5.dex */
    public static class ReplaceItem {
        public int begin;
        public int end;
        public ReplaceItem next;
        public String replacement;

        public ReplaceItem(int i, int i2, String str) {
            this.begin = i;
            this.end = i2;
            this.replacement = str;
        }
    }

    public static boolean equals(String str, char[] cArr, int i, int i2) {
        if (str.length() == i2 - i) {
            int i3 = 0;
            while (i != i2) {
                if (cArr[i] != str.charAt(i3)) {
                    return false;
                }
                i++;
                i3++;
            }
            return true;
        }
        return false;
    }

    public char[] getBuffer() {
        return this.buffer;
    }

    public int getLineBegin() {
        return this.lineBegin;
    }

    public int getLineEnd() {
        return this.lineEnd;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    public boolean nextLine() {
        int i;
        int i2 = this.nextLineStart;
        char c = 0;
        if (i2 == this.bufferEnd) {
            this.lineNumber = 0;
            return false;
        }
        while (i2 != this.bufferEnd && (c = this.buffer[i2]) != '\n' && c != '\r') {
            i2++;
        }
        this.lineBegin = this.nextLineStart;
        this.lineEnd = i2;
        int i3 = this.bufferEnd;
        if (i2 != i3) {
            i2 = (c == '\r' && (i = i2 + 1) != i3 && this.buffer[i] == '\n') ? i2 + 2 : i2 + 1;
        }
        this.nextLineStart = i2;
        this.lineNumber++;
        return true;
    }

    public void readData(Reader reader) throws IOException {
        int length = this.buffer.length;
        int i = 0;
        while (true) {
            int read = reader.read(this.buffer, i, length - i);
            if (read < 0) {
                this.bufferEnd = i;
                return;
            }
            i += read;
            if (length == i) {
                length *= 2;
                char[] cArr = new char[length];
                System.arraycopy(this.buffer, 0, cArr, 0, i);
                this.buffer = cArr;
            }
        }
    }

    public boolean setReplacement(int i, int i2, String str) {
        if (equals(str, this.buffer, i, i2)) {
            return false;
        }
        ReplaceItem replaceItem = new ReplaceItem(i, i2, str);
        ReplaceItem replaceItem2 = this.firstReplace;
        if (replaceItem2 == null) {
            this.lastReplace = replaceItem;
        } else if (i >= replaceItem2.begin) {
            while (true) {
                ReplaceItem replaceItem3 = replaceItem2;
                replaceItem2 = replaceItem2.next;
                if (replaceItem2 != null) {
                    if (i < replaceItem2.begin) {
                        replaceItem.next = replaceItem2;
                        replaceItem3.next = replaceItem;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (replaceItem2 != null) {
                return true;
            }
            this.lastReplace.next = replaceItem;
            return true;
        } else {
            replaceItem.next = replaceItem2;
        }
        this.firstReplace = replaceItem;
        return true;
    }

    public void startLineLoop() {
        this.lineNumber = 0;
        this.nextLineStart = 0;
        this.lineEnd = 0;
        this.lineBegin = 0;
    }

    public boolean wasModified() {
        return this.firstReplace != null;
    }

    public void writeData(Writer writer) throws IOException {
        int i = 0;
        for (ReplaceItem replaceItem = this.firstReplace; replaceItem != null; replaceItem = replaceItem.next) {
            int i2 = replaceItem.begin - i;
            if (i2 > 0) {
                writer.write(this.buffer, i, i2);
            }
            writer.write(replaceItem.replacement);
            i = replaceItem.end;
        }
        int i3 = this.bufferEnd - i;
        if (i3 != 0) {
            writer.write(this.buffer, i, i3);
        }
    }

    public void writeInitialData(Writer writer) throws IOException {
        writer.write(this.buffer, 0, this.bufferEnd);
    }
}
