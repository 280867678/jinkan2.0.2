package com.tencent.bugly.beta;

import com.tencent.bugly.proguard.C1177B;
import com.tencent.bugly.proguard.C1248x;
import com.tencent.bugly.proguard.C1249y;

/* loaded from: classes3.dex */
public class UpgradeInfo {
    public String apkMd5;
    public String apkUrl;
    public long fileSize;

    /* renamed from: id */
    public String f707id;
    public String imageUrl;
    public String newFeature;
    public long popInterval;
    public int popTimes;
    public long publishTime;
    public int publishType;
    public String title;
    public int updateType;
    public int upgradeType;
    public int versionCode;
    public String versionName;

    public UpgradeInfo(C1177B c1177b) {
        this.f707id = "";
        this.title = "";
        this.newFeature = "";
        this.publishTime = 0L;
        this.publishType = 0;
        this.upgradeType = 1;
        this.popTimes = 0;
        this.popInterval = 0L;
        this.versionName = "";
        if (c1177b != null) {
            this.f707id = c1177b.f1340r;
            this.title = c1177b.f1328f;
            this.newFeature = c1177b.f1329g;
            this.publishTime = c1177b.f1330h;
            this.publishType = c1177b.f1331i;
            this.upgradeType = c1177b.f1334l;
            this.popTimes = c1177b.f1335m;
            this.popInterval = c1177b.f1336n;
            C1249y c1249y = c1177b.f1332j;
            this.versionCode = c1249y.f1670d;
            this.versionName = c1249y.f1671e;
            this.apkMd5 = c1249y.f1676j;
            C1248x c1248x = c1177b.f1333k;
            this.apkUrl = c1248x.f1663c;
            this.fileSize = c1248x.f1665e;
            this.imageUrl = c1177b.f1339q.get("IMG_title");
            this.updateType = c1177b.f1343u;
        }
    }
}
