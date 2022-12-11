package com.tencent.bugly.beta.download;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.bugly.beta.global.C1089a;
import com.tencent.bugly.beta.global.C1093e;
import com.tencent.bugly.beta.p041ui.C1107f;
import com.tencent.bugly.beta.p041ui.C1114k;
import com.tencent.bugly.beta.p041ui.C1115l;
import com.tencent.bugly.beta.upgrade.C1118c;
import com.tencent.bugly.proguard.C1199X;
import com.tencent.bugly.proguard.C1208ca;
import java.io.File;
import org.litepal.crud.LitePalSupport;

/* renamed from: com.tencent.bugly.beta.download.b */
/* loaded from: classes3.dex */
public class RunnableC1086b implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ Intent f720a;

    /* renamed from: b */
    public final /* synthetic */ Context f721b;

    /* renamed from: c */
    public final /* synthetic */ BetaReceiver f722c;

    public RunnableC1086b(BetaReceiver betaReceiver, Intent intent, Context context) {
        this.f722c = betaReceiver;
        this.f720a = intent;
        this.f721b = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00ec A[Catch: Exception -> 0x00f6, TryCatch #0 {Exception -> 0x00f6, blocks: (B:2:0x0000, B:4:0x000e, B:5:0x0022, B:7:0x0028, B:11:0x0034, B:13:0x0044, B:15:0x0049, B:20:0x0055, B:22:0x0060, B:25:0x0067, B:36:0x00e6, B:38:0x00ec, B:40:0x00f0, B:44:0x007b, B:45:0x0088, B:46:0x0094, B:47:0x0098, B:49:0x009e, B:51:0x00a4, B:53:0x00aa, B:56:0x00b2, B:58:0x00c0, B:60:0x00ce, B:61:0x00db, B:62:0x00de, B:63:0x00e2), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Context context;
        File saveFile;
        String md5;
        try {
            if (this.f720a.getAction().equals(BetaReceiver.CONNECTIVITY_CHANGE)) {
                int i = BetaReceiver.netStatus;
                BetaReceiver.netStatus = C1089a.m3626a(this.f721b);
                for (C1088d c1088d : BetaReceiver.netListeners.values()) {
                    c1088d.m3629a(i, BetaReceiver.netStatus);
                }
            } else if (this.f720a.getAction().equals(C1107f.f819a.f824f)) {
                int intExtra = this.f720a.getIntExtra("request", -1);
                if (intExtra != 1) {
                    if (intExtra != 2) {
                        return;
                    }
                    C1114k.m3585a(C1107f.f819a.f829k, true, true, 0L);
                    return;
                }
                DownloadTask downloadTask = C1107f.f819a.f823e;
                if (downloadTask == null) {
                    return;
                }
                int status = downloadTask.getStatus();
                if (status != 0) {
                    if (status == 1) {
                        context = C1093e.f737b.f789v;
                        saveFile = downloadTask.getSaveFile();
                        md5 = downloadTask.getMD5();
                        C1089a.m3623a(context, saveFile, md5);
                        if (C1118c.f870a.f874e != null) {
                            return;
                        }
                        return;
                    }
                    if (status == 2) {
                        BetaReceiver.netListeners.remove(downloadTask.getDownloadUrl());
                        downloadTask.stop();
                    } else if (status != 3 && status != 4 && status != 5) {
                    }
                    if (C1118c.f870a.f874e != null || C1115l.f842n == null) {
                        return;
                    }
                    C1115l.f842n.m3582a(downloadTask);
                    return;
                }
                File saveFile2 = downloadTask.getSaveFile();
                if (saveFile2 == null || !saveFile2.exists() || !saveFile2.getName().endsWith(".apk")) {
                    BetaReceiver.addTask(downloadTask);
                } else {
                    String m3032a = C1208ca.m3032a(saveFile2, LitePalSupport.MD5);
                    if (TextUtils.isEmpty(downloadTask.getMD5()) || !TextUtils.equals(downloadTask.getMD5().toUpperCase(), m3032a)) {
                        BetaReceiver.addTask(downloadTask);
                    } else {
                        context = C1093e.f737b.f789v;
                        saveFile = downloadTask.getSaveFile();
                        md5 = downloadTask.getMD5();
                        C1089a.m3623a(context, saveFile, md5);
                        if (C1118c.f870a.f874e != null) {
                        }
                    }
                }
                downloadTask.download();
                if (C1118c.f870a.f874e != null) {
                }
            }
        } catch (Exception e) {
            if (C1199X.m3083a(e)) {
                return;
            }
            e.printStackTrace();
        }
    }
}
