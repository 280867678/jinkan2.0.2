package com.tencent.bugly.proguard;

import android.text.TextUtils;
import com.tencent.bugly.beta.download.BetaReceiver;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.global.RunnableC1092d;
import com.tencent.bugly.beta.p041ui.C1107f;
import com.tencent.bugly.beta.utils.C1125e;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import org.fourthline.cling.model.types.BytesRange;

/* renamed from: com.tencent.bugly.proguard.w */
/* loaded from: classes3.dex */
public class RunnableC1247w extends DownloadTask implements Runnable {

    /* renamed from: k */
    public File f1658k;

    /* renamed from: l */
    public long f1659l = 0;

    /* renamed from: m */
    public long f1660m = 0;

    public RunnableC1247w(String str, String str2, long j, long j2, String str3) {
        super(str, "", "", str3);
        File file = new File(str2);
        this.f1658k = file;
        this.f709b = file.getParent();
        this.f710c = this.f1658k.getName();
        this.f712e = j;
        this.f713f = j2;
        getStatus();
    }

    public RunnableC1247w(String str, String str2, String str3, String str4) {
        super(str, str2, str3, str4);
        getStatus();
    }

    /* renamed from: a */
    private String m2860a(HttpURLConnection httpURLConnection) {
        List<String> list;
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!TextUtils.isEmpty(this.f710c)) {
            return this.f710c;
        }
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        if (headerFields != null) {
            for (String str : headerFields.keySet()) {
                if (str != null && (list = headerFields.get(str)) != null) {
                    for (String str2 : list) {
                        if (str2 != null && "content-disposition".equals(str.toLowerCase())) {
                            Matcher matcher = Pattern.compile(".*filename=(.*)").matcher(str2.toLowerCase());
                            if (matcher.find()) {
                                return matcher.group(1);
                            }
                        }
                    }
                    continue;
                }
            }
        }
        String substring = getDownloadUrl().substring(getDownloadUrl().lastIndexOf(47) + 1);
        if (!TextUtils.isEmpty(substring)) {
            return substring;
        }
        return UUID.randomUUID() + ".apk";
    }

    /* renamed from: a */
    public void m2862a() {
        this.f716i = 1;
        m2859b();
        C1246v.f1655a.f1656b.remove(getDownloadUrl());
        BetaReceiver.netListeners.remove(getDownloadUrl());
        C1125e.m3490a(new RunnableC1092d(8, this.f711d, this));
    }

    /* renamed from: a */
    public void m2861a(int i, String str) {
        this.f716i = 5;
        C1107f.f819a.m3593a();
        C1246v.f1655a.f1656b.remove(getDownloadUrl());
        C1125e.m3490a(new RunnableC1092d(10, this.f711d, this, Integer.valueOf(i), str));
    }

    /* renamed from: b */
    public void m2859b() {
        this.f1659l = (System.currentTimeMillis() - this.f1660m) + this.f1659l;
        C1234p.f1572a.m2874b(this);
        this.f1660m = System.currentTimeMillis();
        C1107f.f819a.m3593a();
        C1125e.m3490a(new RunnableC1092d(9, this.f711d, this));
    }

    @Override // com.tencent.bugly.beta.download.DownloadTask
    public void delete(boolean z) {
        stop();
        if (z) {
            if (getSaveFile() != null && getSaveFile().exists() && !getSaveFile().isDirectory()) {
                getSaveFile().delete();
            }
            C1234p.f1572a.m2878a(this);
        }
        BetaReceiver.netListeners.remove(getDownloadUrl());
        this.f710c = null;
        this.f712e = 0L;
        this.f713f = 0L;
        this.f716i = 4;
    }

    @Override // com.tencent.bugly.beta.download.DownloadTask
    public void download() {
        if (getStatus() == 1) {
            m2862a();
        } else if (getStatus() == 2) {
        } else {
            if (getSaveFile() == null || !getSaveFile().exists()) {
                this.f712e = 0L;
                this.f713f = 0L;
                this.f1659l = 0L;
            } else {
                this.f712e = getSaveFile().length();
            }
            if (this.f714g) {
                C1107f.f819a.m3592a(this);
            }
            this.f1660m = System.currentTimeMillis();
            this.f716i = 2;
            C1246v.f1655a.f1656b.put(getDownloadUrl(), this);
            C1246v.f1655a.m2864a(this);
        }
    }

    @Override // com.tencent.bugly.beta.download.DownloadTask
    public long getCostTime() {
        return this.f1659l;
    }

    @Override // com.tencent.bugly.beta.download.DownloadTask
    public File getSaveFile() {
        return this.f1658k;
    }

    @Override // com.tencent.bugly.beta.download.DownloadTask
    public int getStatus() {
        if (getSaveFile() != null && getSaveFile().exists() && getSaveFile().length() == this.f713f && !C1246v.f1655a.f1656b.contains(this)) {
            this.f712e = this.f713f;
            this.f716i = 1;
        }
        if (getSaveFile() != null && getSaveFile().exists() && getSaveFile().length() > 0 && getSaveFile().length() < this.f713f && !C1246v.f1655a.f1656b.contains(this)) {
            this.f712e = getSaveFile().length();
            this.f716i = 3;
        }
        if ((getSaveFile() == null || !getSaveFile().exists()) && !C1246v.f1655a.f1656b.contains(this)) {
            this.f716i = 0;
        }
        return this.f716i;
    }

    /* JADX WARN: Removed duplicated region for block: B:132:0x015b A[Catch: Exception -> 0x0131, all -> 0x0172, TryCatch #11 {Exception -> 0x0131, blocks: (B:35:0x0097, B:80:0x00e0, B:66:0x011c, B:90:0x012c, B:132:0x015b, B:133:0x015e, B:113:0x0153, B:95:0x0166), top: B:112:0x0153, outer: #2 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        int i;
        Throwable th;
        byte[] bArr;
        RandomAccessFile randomAccessFile;
        try {
            URL url = new URL(getDownloadUrl());
            RandomAccessFile randomAccessFile2 = null;
            InputStream inputStream = null;
            int i2 = 0;
            while (true) {
                if (i2 >= 3) {
                    break;
                }
                i = i2 + 1;
                try {
                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
                    httpsURLConnection.setConnectTimeout(5000);
                    httpsURLConnection.setRequestMethod("GET");
                    httpsURLConnection.setRequestProperty("Referer", url.toString());
                    httpsURLConnection.setRequestProperty("Charset", "UTF-8");
                    StringBuilder sb = new StringBuilder();
                    sb.append(BytesRange.PREFIX);
                    sb.append(this.f712e);
                    sb.append("-");
                    httpsURLConnection.setRequestProperty("Range", sb.toString());
                    httpsURLConnection.setRequestProperty("Connection", "Keep-Alive");
                    httpsURLConnection.connect();
                    this.f710c = m2860a(httpsURLConnection);
                    File file = new File(this.f709b);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    this.f1658k = new File(file, this.f710c);
                    if (this.f713f == 0) {
                        long contentLength = httpsURLConnection.getContentLength();
                        this.f713f = contentLength;
                        if (contentLength <= 0) {
                            m2861a(2000, "tLen <= 0 ");
                            if (randomAccessFile2 != null) {
                                randomAccessFile2.close();
                            }
                            if (inputStream == null) {
                                return;
                            }
                            try {
                                inputStream.close();
                                return;
                            } catch (Exception e) {
                                e.printStackTrace();
                                return;
                            }
                        }
                    }
                    C1234p.f1572a.m2874b(this);
                    inputStream = httpsURLConnection.getInputStream();
                    bArr = new byte[307200];
                    randomAccessFile = new RandomAccessFile(this.f1658k, "rwd");
                } catch (IOException e2) {
                    e = e2;
                }
                try {
                    randomAccessFile.seek(this.f712e);
                    float f = 0.0f;
                    do {
                        int read = inputStream.read(bArr);
                        if (read != -1) {
                            long j = this.f712e + read;
                            this.f712e = j;
                            if (j > this.f713f) {
                                m2862a();
                                C1199X.m3081b("mSavedLength > mTotalLength,重新下载!", new Object[0]);
                                randomAccessFile.close();
                                try {
                                    inputStream.close();
                                    return;
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                    return;
                                }
                            }
                            float f2 = (((float) j) / ((float) this.f713f)) * 100.0f;
                            if (f2 - f >= 1.0d) {
                                m2859b();
                                f = f2;
                            }
                            randomAccessFile.write(bArr, 0, read);
                            if (getSaveFile() == null || !getSaveFile().exists()) {
                                break;
                            }
                        } else {
                            m2862a();
                            randomAccessFile.close();
                            i2 = i;
                        }
                    } while (getStatus() != 3);
                    randomAccessFile.close();
                    try {
                        inputStream.close();
                        return;
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        return;
                    }
                } catch (IOException e5) {
                    e = e5;
                    randomAccessFile2 = randomAccessFile;
                    try {
                        e.printStackTrace();
                        m2861a(2020, e.getMessage());
                        C1199X.m3085a(RunnableC1247w.class, "IOException,stop download!", new Object[0]);
                        if (randomAccessFile2 != null) {
                            try {
                                try {
                                    randomAccessFile2.close();
                                } catch (Throwable th2) {
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception e6) {
                                            e6.printStackTrace();
                                        }
                                    }
                                    throw th2;
                                }
                            } catch (Exception e7) {
                                m2861a(2000, e7.getMessage());
                                e7.printStackTrace();
                                if (inputStream == null) {
                                    return;
                                }
                            }
                        }
                        i2 = i;
                    } catch (Throwable th3) {
                        th = th3;
                        if (randomAccessFile2 != null) {
                            randomAccessFile2.close();
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    randomAccessFile2 = randomAccessFile;
                    if (randomAccessFile2 != null) {
                    }
                    throw th;
                }
                i2 = i;
            }
            if (i2 >= 3) {
                C1199X.m3085a(RunnableC1247w.class, "have retry %d times", 3);
            }
            if (inputStream == null) {
                return;
            }
            try {
                inputStream.close();
            } catch (Exception e8) {
                e8.printStackTrace();
            }
        } catch (MalformedURLException e9) {
            C1199X.m3078c(e9.getMessage(), new Object[0]);
            m2861a(2010, e9.getMessage());
        }
    }

    @Override // com.tencent.bugly.beta.download.DownloadTask
    public void stop() {
        if (this.f716i != 5) {
            this.f716i = 3;
        }
    }
}
