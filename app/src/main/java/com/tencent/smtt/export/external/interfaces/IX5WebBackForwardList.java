package com.tencent.smtt.export.external.interfaces;

/* loaded from: classes4.dex */
public interface IX5WebBackForwardList {
    int getCurrentIndex();

    IX5WebHistoryItem getCurrentItem();

    IX5WebHistoryItem getItemAtIndex(int i);

    int getSize();
}
