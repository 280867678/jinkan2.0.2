package org.apache.http.message;

import java.util.NoSuchElementException;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.util.Args;

/* loaded from: classes4.dex */
public class BasicHeaderIterator implements HeaderIterator {
    public final Header[] allHeaders;
    public int currentIndex = findNext(-1);
    public String headerName;

    public BasicHeaderIterator(Header[] headerArr, String str) {
        this.allHeaders = (Header[]) Args.notNull(headerArr, "Header array");
        this.headerName = str;
    }

    public boolean filterHeader(int i) {
        String str = this.headerName;
        return str == null || str.equalsIgnoreCase(this.allHeaders[i].getName());
    }

    public int findNext(int i) {
        if (i < -1) {
            return -1;
        }
        int length = this.allHeaders.length - 1;
        boolean z = false;
        while (!z && i < length) {
            i++;
            z = filterHeader(i);
        }
        if (!z) {
            return -1;
        }
        return i;
    }

    @Override // org.apache.http.HeaderIterator, java.util.Iterator
    public boolean hasNext() {
        return this.currentIndex >= 0;
    }

    @Override // java.util.Iterator
    public final Object next() throws NoSuchElementException {
        return nextHeader();
    }

    @Override // org.apache.http.HeaderIterator
    public Header nextHeader() throws NoSuchElementException {
        int i = this.currentIndex;
        if (i >= 0) {
            this.currentIndex = findNext(i);
            return this.allHeaders[i];
        }
        throw new NoSuchElementException("Iteration already finished.");
    }

    @Override // java.util.Iterator
    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Removing headers is not supported.");
    }
}
