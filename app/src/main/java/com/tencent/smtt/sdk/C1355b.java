package com.tencent.smtt.sdk;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import com.tencent.smtt.sdk.stat.MttLoader;

/* renamed from: com.tencent.smtt.sdk.b */
/* loaded from: classes4.dex */
public class C1355b implements com.tencent.smtt.export.external.interfaces.DownloadListener {

    /* renamed from: a */
    public DownloadListener f2082a;

    /* renamed from: b */
    public WebView f2083b;

    public C1355b(WebView webView, DownloadListener downloadListener, boolean z) {
        this.f2082a = downloadListener;
        this.f2083b = webView;
    }

    @Override // com.tencent.smtt.export.external.interfaces.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        onDownloadStart(str, null, null, str2, str3, str4, j, null, null);
    }

    @Override // com.tencent.smtt.export.external.interfaces.DownloadListener
    public void onDownloadStart(String str, String str2, byte[] bArr, String str3, String str4, String str5, long j, String str6, String str7) {
        DownloadListener downloadListener = this.f2082a;
        if (downloadListener != null) {
            downloadListener.onDownloadStart(str, str3, str4, str5, j);
        } else if (!QbSdk.canOpenMimeFileType(this.f2083b.getContext(), str5)) {
            ApplicationInfo applicationInfo = this.f2083b.getContext().getApplicationInfo();
            if (applicationInfo != null && TbsConfig.APP_WX.equals(applicationInfo.packageName)) {
                return;
            }
            MttLoader.loadUrl(this.f2083b.getContext(), str, null, null);
        } else {
            Intent intent = new Intent("com.tencent.QQBrowser.action.sdk.document");
            intent.setFlags(268435456);
            intent.putExtra("key_reader_sdk_url", str);
            intent.putExtra("key_reader_sdk_type", 1);
            intent.setData(Uri.parse(str));
            this.f2083b.getContext().startActivity(intent);
        }
    }

    @Override // com.tencent.smtt.export.external.interfaces.DownloadListener
    public void onDownloadVideo(String str, long j, int i) {
    }
}
