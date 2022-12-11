package org.apache.http;

/* loaded from: classes4.dex */
public interface Header extends NameValuePair {
    HeaderElement[] getElements() throws ParseException;
}
