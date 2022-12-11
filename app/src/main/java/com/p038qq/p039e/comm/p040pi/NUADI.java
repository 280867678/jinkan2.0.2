package com.p038qq.p039e.comm.p040pi;

import com.p038qq.p039e.comm.constants.LoadAdParams;
import java.util.List;

/* renamed from: com.qq.e.comm.pi.NUADI */
/* loaded from: classes3.dex */
public interface NUADI extends ADI {
    String getAdNetWorkName();

    void loadData(int i);

    void loadData(int i, LoadAdParams loadAdParams);

    void setCategories(List<String> list);

    void setMaxVideoDuration(int i);

    void setMinVideoDuration(int i);

    void setVastClassName(String str);
}
