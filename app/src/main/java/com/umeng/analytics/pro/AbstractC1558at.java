package com.umeng.analytics.pro;

import com.umeng.analytics.pro.AbstractC1558at;
import com.umeng.analytics.pro.AbstractC1570ba;
import java.io.Serializable;

/* renamed from: com.umeng.analytics.pro.at */
/* loaded from: classes4.dex */
public interface AbstractC1558at<T extends AbstractC1558at<?, ?>, F extends AbstractC1570ba> extends Serializable {
    void clear();

    AbstractC1558at<T, F> deepCopy();

    F fieldForId(int i);

    void read(AbstractC1596bs abstractC1596bs) throws C1566az;

    void write(AbstractC1596bs abstractC1596bs) throws C1566az;
}
