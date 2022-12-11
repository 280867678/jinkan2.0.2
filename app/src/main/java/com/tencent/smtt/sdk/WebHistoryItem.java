package com.tencent.smtt.sdk;

import android.graphics.Bitmap;
import com.tencent.smtt.export.external.interfaces.IX5WebHistoryItem;

/* loaded from: classes4.dex */
public class WebHistoryItem {

    /* renamed from: a */
    public IX5WebHistoryItem f1981a = null;

    /* renamed from: b */
    public android.webkit.WebHistoryItem f1982b = null;

    /* renamed from: a */
    public static WebHistoryItem m2712a(android.webkit.WebHistoryItem webHistoryItem) {
        if (webHistoryItem == null) {
            return null;
        }
        WebHistoryItem webHistoryItem2 = new WebHistoryItem();
        webHistoryItem2.f1982b = webHistoryItem;
        return webHistoryItem2;
    }

    /* renamed from: a */
    public static WebHistoryItem m2711a(IX5WebHistoryItem iX5WebHistoryItem) {
        if (iX5WebHistoryItem == null) {
            return null;
        }
        WebHistoryItem webHistoryItem = new WebHistoryItem();
        webHistoryItem.f1981a = iX5WebHistoryItem;
        return webHistoryItem;
    }

    public Bitmap getFavicon() {
        IX5WebHistoryItem iX5WebHistoryItem = this.f1981a;
        return iX5WebHistoryItem != null ? iX5WebHistoryItem.getFavicon() : this.f1982b.getFavicon();
    }

    public String getOriginalUrl() {
        IX5WebHistoryItem iX5WebHistoryItem = this.f1981a;
        return iX5WebHistoryItem != null ? iX5WebHistoryItem.getOriginalUrl() : this.f1982b.getOriginalUrl();
    }

    public String getTitle() {
        IX5WebHistoryItem iX5WebHistoryItem = this.f1981a;
        return iX5WebHistoryItem != null ? iX5WebHistoryItem.getTitle() : this.f1982b.getTitle();
    }

    public String getUrl() {
        IX5WebHistoryItem iX5WebHistoryItem = this.f1981a;
        return iX5WebHistoryItem != null ? iX5WebHistoryItem.getUrl() : this.f1982b.getUrl();
    }
}
