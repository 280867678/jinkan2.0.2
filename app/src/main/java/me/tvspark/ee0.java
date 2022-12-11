package me.tvspark;

import java.util.Enumeration;

/* loaded from: classes4.dex */
public interface ee0 {
    Object getAttribute(String str);

    Enumeration<String> getAttributeNames();

    String getId();

    void invalidate();

    void removeAttribute(String str);

    void setAttribute(String str, Object obj);
}
