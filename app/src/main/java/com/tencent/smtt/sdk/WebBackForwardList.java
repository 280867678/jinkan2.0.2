package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.interfaces.IX5WebBackForwardList;

/* loaded from: classes4.dex */
public class WebBackForwardList {

    /* renamed from: a */
    public IX5WebBackForwardList f1979a = null;

    /* renamed from: b */
    public android.webkit.WebBackForwardList f1980b = null;

    /* renamed from: a */
    public static WebBackForwardList m2714a(android.webkit.WebBackForwardList webBackForwardList) {
        if (webBackForwardList == null) {
            return null;
        }
        WebBackForwardList webBackForwardList2 = new WebBackForwardList();
        webBackForwardList2.f1980b = webBackForwardList;
        return webBackForwardList2;
    }

    /* renamed from: a */
    public static WebBackForwardList m2713a(IX5WebBackForwardList iX5WebBackForwardList) {
        if (iX5WebBackForwardList == null) {
            return null;
        }
        WebBackForwardList webBackForwardList = new WebBackForwardList();
        webBackForwardList.f1979a = iX5WebBackForwardList;
        return webBackForwardList;
    }

    public int getCurrentIndex() {
        IX5WebBackForwardList iX5WebBackForwardList = this.f1979a;
        return iX5WebBackForwardList != null ? iX5WebBackForwardList.getCurrentIndex() : this.f1980b.getCurrentIndex();
    }

    public WebHistoryItem getCurrentItem() {
        IX5WebBackForwardList iX5WebBackForwardList = this.f1979a;
        return iX5WebBackForwardList != null ? WebHistoryItem.m2711a(iX5WebBackForwardList.getCurrentItem()) : WebHistoryItem.m2712a(this.f1980b.getCurrentItem());
    }

    public WebHistoryItem getItemAtIndex(int i) {
        IX5WebBackForwardList iX5WebBackForwardList = this.f1979a;
        return iX5WebBackForwardList != null ? WebHistoryItem.m2711a(iX5WebBackForwardList.getItemAtIndex(i)) : WebHistoryItem.m2712a(this.f1980b.getItemAtIndex(i));
    }

    public int getSize() {
        IX5WebBackForwardList iX5WebBackForwardList = this.f1979a;
        return iX5WebBackForwardList != null ? iX5WebBackForwardList.getSize() : this.f1980b.getSize();
    }
}
