package com.thegrizzlylabs.sardineandroid.model;

import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Namespace(prefix = "D", reference = "DAV:")
@Root
/* loaded from: classes4.dex */
public class SearchRequest {
    public String language;
    public String query;

    public SearchRequest() {
        this.language = "davbasic";
        this.query = "";
    }

    public SearchRequest(String str, String str2) {
        this.language = str;
        this.query = str2;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final String getQuery() {
        return this.query;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setQuery(String str) {
        this.query = str;
    }
}
