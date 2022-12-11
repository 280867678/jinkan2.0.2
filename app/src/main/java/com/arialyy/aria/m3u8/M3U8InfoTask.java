package com.arialyy.aria.m3u8;

import android.net.TrafficStats;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import com.arialyy.aria.core.AriaConfig;
import com.arialyy.aria.core.download.DTaskWrapper;
import com.arialyy.aria.core.download.DownloadEntity;
import com.arialyy.aria.core.download.M3U8Entity;
import com.arialyy.aria.core.loader.IInfoTask;
import com.arialyy.aria.core.loader.ILoaderVisitor;
import com.arialyy.aria.core.processor.IBandWidthUrlConverter;
import com.arialyy.aria.core.processor.IKeyUrlConverter;
import com.arialyy.aria.exception.AriaM3U8Exception;
import com.arialyy.aria.http.ConnectionHelp;
import com.arialyy.aria.http.HttpTaskOption;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CheckUtil;
import com.arialyy.aria.util.FileUtil;
import com.arialyy.aria.util.Regular;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.tvspark.outline;
import org.eclipse.jetty.http.HttpHeaders;

/* loaded from: classes3.dex */
public final class M3U8InfoTask implements IInfoTask {
    public static final String M3U8_INDEX_FORMAT = "%s.m3u8";
    public IInfoTask.Callback mCallback;
    public DownloadEntity mEntity;
    public HttpTaskOption mHttpOption;
    public M3U8TaskOption mM3U8Option;
    public DTaskWrapper mTaskWrapper;
    public OnGetLivePeerCallback onGetPeerCallback;
    public final String TAG = "M3U8InfoThread";
    public boolean isStop = false;
    public int mConnectTimeOut = AriaConfig.getInstance().getDConfig().getConnectTimeOut();

    /* loaded from: classes3.dex */
    public interface OnGetLivePeerCallback {
        void onGetPeer(String str, String str2);
    }

    public M3U8InfoTask(DTaskWrapper dTaskWrapper) {
        boolean z = false;
        this.mTaskWrapper = dTaskWrapper;
        this.mEntity = dTaskWrapper.mo4442getEntity();
        this.mHttpOption = (HttpTaskOption) dTaskWrapper.getTaskOption();
        this.mM3U8Option = (M3U8TaskOption) dTaskWrapper.getM3u8Option();
        this.mEntity.getM3U8Entity().setLive(this.mTaskWrapper.getRequestType() == 8 ? true : z);
    }

    private void addIndexInfo(boolean z, FileOutputStream fileOutputStream, String str) throws IOException {
        if (!z) {
            return;
        }
        fileOutputStream.write(str.concat("\r\n").getBytes(Charset.forName("UTF-8")));
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00a7 A[Catch: IOException -> 0x00a3, TRY_LEAVE, TryCatch #3 {IOException -> 0x00a3, blocks: (B:48:0x009f, B:41:0x00a7), top: B:47:0x009f }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void downloadKey(M3U8Entity m3U8Entity) {
        HttpURLConnection httpURLConnection;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = new File(m3U8Entity.keyPath);
                if (file.exists()) {
                    return;
                }
                ALog.m4192d("M3U8InfoThread", "密钥不存在，下载密钥");
                FileUtil.createFile(file);
                IKeyUrlConverter keyUrlConverter = this.mM3U8Option.getKeyUrlConverter();
                String str = m3U8Entity.keyUrl;
                if (keyUrlConverter != null) {
                    str = keyUrlConverter.convert(this.mEntity.getUrl(), str);
                }
                if (TextUtils.isEmpty(str)) {
                    ALog.m4191e("M3U8InfoThread", "m3u8密钥key url 为空");
                    return;
                }
                HttpURLConnection handleConnection = ConnectionHelp.handleConnection(ConnectionHelp.handleUrl(str, this.mHttpOption), this.mHttpOption);
                try {
                    ConnectionHelp.setConnectParam(this.mHttpOption, handleConnection);
                    handleConnection.setConnectTimeout(this.mConnectTimeOut);
                    handleConnection.connect();
                    InputStream inputStream = handleConnection.getInputStream();
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                fileOutputStream2.close();
                                handleConnection.disconnect();
                                return;
                            }
                            fileOutputStream2.write(bArr, 0, read);
                        }
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        Exception exc = e;
                        httpURLConnection = handleConnection;
                        e = exc;
                        try {
                            e.printStackTrace();
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            if (httpURLConnection == null) {
                                return;
                            }
                            httpURLConnection.disconnect();
                        } catch (Throwable th) {
                            th = th;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                    throw th;
                                }
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = fileOutputStream2;
                        Throwable th3 = th;
                        httpURLConnection = handleConnection;
                        th = th3;
                        if (fileOutputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        } catch (Exception e5) {
            e = e5;
            httpURLConnection = null;
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = null;
        }
    }

    private void failDownload(String str, boolean z) {
        this.mCallback.onFail(this.mEntity, new AriaM3U8Exception("M3U8InfoThread", str), z);
    }

    private int getBandWidth(String str) {
        Matcher matcher = Pattern.compile(Regular.BANDWIDTH).matcher(str);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group());
        }
        return 0;
    }

    private void getKeyInfo(String str) {
        String[] split = str.substring(str.indexOf(":") + 1).split(",");
        M3U8Entity m3U8Entity = this.mEntity.getM3U8Entity();
        for (String str2 : split) {
            if (str2.startsWith("METHOD")) {
                m3U8Entity.method = str2.split("=")[1];
            } else if (str2.startsWith("URI")) {
                m3U8Entity.keyUrl = str2.split("=")[1].replaceAll("\"", "");
                m3U8Entity.keyPath = ((M3U8TaskOption) this.mTaskWrapper.getM3u8Option()).getKeyPath() == null ? new File(this.mEntity.getFilePath()).getParent() + "/" + this.mEntity.getFileName() + ".key" : ((M3U8TaskOption) this.mTaskWrapper.getM3u8Option()).getKeyPath();
            } else if (str2.startsWith("IV")) {
                m3U8Entity.f163iv = str2.split("=")[1];
            } else if (str2.startsWith("KEYFORMAT")) {
                m3U8Entity.keyFormat = str2.split("=")[1];
            } else if (str2.startsWith("KEYFORMATVERSIONS")) {
                m3U8Entity.keyFormatVersion = str2.split("=")[1];
            }
        }
        downloadKey(m3U8Entity);
    }

    private void handleBandWidth(HttpURLConnection httpURLConnection, String str) throws IOException {
        IBandWidthUrlConverter bandWidthUrlConverter = this.mM3U8Option.getBandWidthUrlConverter();
        if (bandWidthUrlConverter != null) {
            str = bandWidthUrlConverter.convert(str);
            if (!str.startsWith("http")) {
                failDownload(String.format("码率转换器转换后的url地址无效，转换后的url：%s", str), false);
                return;
            }
        } else {
            ALog.m4192d("M3U8InfoThread", "没有设置码率转换器");
        }
        this.mM3U8Option.setBandWidthUrl(str);
        ALog.m4192d("M3U8InfoThread", String.format("新码率url：%s", str));
        String headerField = httpURLConnection.getHeaderField(HttpHeaders.SET_COOKIE);
        httpURLConnection.disconnect();
        HttpURLConnection handleConnection = ConnectionHelp.handleConnection(ConnectionHelp.handleUrl(str, this.mHttpOption), this.mHttpOption);
        ConnectionHelp.setConnectParam(this.mHttpOption, handleConnection);
        handleConnection.setRequestProperty(HttpHeaders.COOKIE, headerField);
        handleConnection.setConnectTimeout(this.mConnectTimeOut);
        handleConnection.connect();
        handleConnect(handleConnection);
        handleConnection.disconnect();
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x011d, code lost:
        if (r5 != false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0123, code lost:
        if (r4.isEmpty() == false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0125, code lost:
        r12 = java.lang.String.format("获取M3U8下载地址列表失败，url: %s", r11.mEntity.getUrl());
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0136, code lost:
        if (r5 != false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0142, code lost:
        if (r11.mEntity.getM3U8Entity().getPeerNum() != 0) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0144, code lost:
        r11.mEntity.getM3U8Entity().setPeerNum(r4.size());
        r11.mEntity.getM3U8Entity().update();
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x015a, code lost:
        r12 = new com.arialyy.aria.core.common.CompleteInfo();
        r12.obj = r4;
        r11.mCallback.onSucceed(r11.mEntity.getKey(), r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x016c, code lost:
        if (r7 == null) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x016e, code lost:
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleConnect(HttpURLConnection httpURLConnection) throws IOException {
        String str;
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode != 200) {
            if (responseCode == 302 || responseCode == 301 || responseCode == 303 || responseCode == 201 || responseCode == 307) {
                handleUrlReTurn(httpURLConnection, httpURLConnection.getHeaderField("Location"));
                return;
            } else if (responseCode >= 400) {
                failDownload(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("下载失败错误，错误码：", responseCode), false);
                return;
            } else {
                failDownload(String.format("不支持的响应，code: %s", Integer.valueOf(responseCode)), true);
                return;
            }
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        String readLine = bufferedReader.readLine();
        if (!TextUtils.isEmpty(readLine) && readLine.equalsIgnoreCase("#EXTM3U")) {
            ArrayList arrayList = new ArrayList();
            boolean z = this.mTaskWrapper.getRequestType() == 8;
            boolean isGenerateIndexFile = ((M3U8TaskOption) this.mTaskWrapper.getM3u8Option()).isGenerateIndexFile();
            FileOutputStream fileOutputStream = null;
            if (isGenerateIndexFile) {
                String format = String.format(M3U8_INDEX_FORMAT, this.mEntity.getFilePath());
                File file = new File(format);
                if (file.exists()) {
                    FileUtil.deleteFile(format);
                }
                FileUtil.createFile(format);
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                ALog.m4192d("M3U8InfoThread", readLine);
                addIndexInfo(isGenerateIndexFile, fileOutputStream2, readLine);
                this.mEntity.getM3U8Entity().setLocalM3u8Path(format);
                fileOutputStream = fileOutputStream2;
            }
            while (true) {
                String readLine2 = bufferedReader.readLine();
                if (readLine2 == null || this.isStop) {
                    break;
                }
                ALog.m4192d("M3U8InfoThread", readLine2);
                if (readLine2.startsWith("#EXT-X-ENDLIST")) {
                    addIndexInfo(isGenerateIndexFile && !z, fileOutputStream, readLine2);
                } else if (readLine2.startsWith("#EXTINF")) {
                    String readLine3 = bufferedReader.readLine();
                    if (z) {
                        OnGetLivePeerCallback onGetLivePeerCallback = this.onGetPeerCallback;
                        if (onGetLivePeerCallback != null) {
                            onGetLivePeerCallback.onGetPeer(readLine3, readLine2);
                        }
                    } else {
                        arrayList.add(readLine3);
                    }
                    ALog.m4192d("M3U8InfoThread", readLine3);
                    addIndexInfo(isGenerateIndexFile && !z, fileOutputStream, readLine2);
                    addIndexInfo(isGenerateIndexFile && !z, fileOutputStream, readLine3);
                } else if (readLine2.startsWith("#EXT-X-STREAM-INF")) {
                    addIndexInfo(isGenerateIndexFile, fileOutputStream, readLine2);
                    int bandWidth = this.mM3U8Option.getBandWidth();
                    int bandWidth2 = getBandWidth(readLine2);
                    if (bandWidth == 0 || bandWidth2 == bandWidth) {
                        handleBandWidth(httpURLConnection, bufferedReader.readLine());
                        return;
                    } else {
                        failDownload(String.format("【%s】码率不存在", Integer.valueOf(bandWidth)), false);
                        return;
                    }
                } else {
                    boolean startsWith = readLine2.startsWith("#EXT-X-KEY");
                    addIndexInfo(isGenerateIndexFile, fileOutputStream, readLine2);
                    if (startsWith) {
                        getKeyInfo(readLine2);
                    }
                }
            }
        } else {
            str = "读取M3U8信息失败，读取不到#EXTM3U标签";
        }
        failDownload(str, false);
    }

    private void handleUrlReTurn(HttpURLConnection httpURLConnection, String str) throws IOException {
        ALog.m4192d("M3U8InfoThread", "30x跳转，新url为【" + str + "】");
        if (TextUtils.isEmpty(str) || str.equalsIgnoreCase("null")) {
            IInfoTask.Callback callback = this.mCallback;
            if (callback == null) {
                return;
            }
            callback.onFail(this.mEntity, new AriaM3U8Exception("M3U8InfoThread", "获取重定向链接失败"), false);
            return;
        }
        if (str.startsWith("/")) {
            Uri parse = Uri.parse(this.mEntity.getUrl());
            str = parse.getHost() + str;
        }
        if (!CheckUtil.checkUrl(str)) {
            failDownload("下载失败，重定向url错误", false);
            return;
        }
        this.mHttpOption.setRedirectUrl(str);
        this.mEntity.setRedirect(true);
        this.mEntity.setRedirectUrl(str);
        String headerField = httpURLConnection.getHeaderField(HttpHeaders.SET_COOKIE);
        httpURLConnection.disconnect();
        HttpURLConnection handleConnection = ConnectionHelp.handleConnection(ConnectionHelp.handleUrl(str, this.mHttpOption), this.mHttpOption);
        ConnectionHelp.setConnectParam(this.mHttpOption, handleConnection);
        handleConnection.setRequestProperty(HttpHeaders.COOKIE, headerField);
        handleConnection.setConnectTimeout(this.mConnectTimeOut);
        handleConnection.connect();
        handleConnect(handleConnection);
        handleConnection.disconnect();
    }

    @Override // com.arialyy.aria.core.loader.ILoaderComponent
    public void accept(ILoaderVisitor iLoaderVisitor) {
        iLoaderVisitor.addComponent(this);
    }

    @Override // com.arialyy.aria.core.loader.IInfoTask, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        TrafficStats.setThreadStatsTag(UUID.randomUUID().toString().hashCode());
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                httpURLConnection = ConnectionHelp.handleConnection(ConnectionHelp.handleUrl(this.mEntity.getUrl(), this.mHttpOption), this.mHttpOption);
                ConnectionHelp.setConnectParam(this.mHttpOption, httpURLConnection);
                httpURLConnection.setConnectTimeout(this.mConnectTimeOut);
                httpURLConnection.connect();
                handleConnect(httpURLConnection);
            } catch (IOException e) {
                failDownload(e.getMessage(), false);
                if (httpURLConnection == null) {
                    return;
                }
            }
            httpURLConnection.disconnect();
        } catch (Throwable th) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    @Override // com.arialyy.aria.core.loader.IInfoTask
    public void setCallback(IInfoTask.Callback callback) {
        this.mCallback = callback;
    }

    public void setOnGetPeerCallback(OnGetLivePeerCallback onGetLivePeerCallback) {
        this.onGetPeerCallback = onGetLivePeerCallback;
    }

    public void setStop(boolean z) {
        this.isStop = z;
    }
}
