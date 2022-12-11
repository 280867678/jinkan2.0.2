package com.arialyy.aria.http.download;

import android.net.TrafficStats;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import com.arialyy.aria.core.AriaConfig;
import com.arialyy.aria.core.common.CompleteInfo;
import com.arialyy.aria.core.common.RequestEnum;
import com.arialyy.aria.core.download.DTaskWrapper;
import com.arialyy.aria.core.download.DownloadEntity;
import com.arialyy.aria.core.loader.IInfoTask;
import com.arialyy.aria.core.loader.ILoaderVisitor;
import com.arialyy.aria.core.processor.IHttpFileLenAdapter;
import com.arialyy.aria.exception.AriaHTTPException;
import com.arialyy.aria.http.ConnectionHelp;
import com.arialyy.aria.http.HttpTaskOption;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CheckUtil;
import com.arialyy.aria.util.CommonUtil;
import com.arialyy.aria.util.FileUtil;
import com.arialyy.aria.util.RecordUtil;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.eclipse.jetty.http.HttpHeaders;

/* loaded from: classes3.dex */
public final class HttpDFileInfoTask implements IInfoTask, Runnable {
    public static final String TAG = "HttpDFileInfoTask";
    public IInfoTask.Callback callback;
    public int mConnectTimeOut = AriaConfig.getInstance().getDConfig().getConnectTimeOut();
    public DownloadEntity mEntity;
    public DTaskWrapper mTaskWrapper;
    public HttpTaskOption taskOption;

    /* loaded from: classes3.dex */
    public static class FileLenAdapter implements IHttpFileLenAdapter {
        public FileLenAdapter() {
        }

        @Override // com.arialyy.aria.core.processor.IHttpFileLenAdapter
        public long handleFileLen(Map<String, List<String>> map) {
            if (map == null || map.isEmpty()) {
                ALog.m4191e(HttpDFileInfoTask.TAG, "header为空，获取文件长度失败");
                return -1L;
            }
            List<String> list = map.get("Content-Length");
            if (list == null || list.isEmpty()) {
                return -1L;
            }
            String str = list.get(0);
            long parseLong = TextUtils.isEmpty(str) ? -1L : Long.parseLong(str);
            if (parseLong >= 0) {
                return parseLong;
            }
            List<String> list2 = map.get("Content-Range");
            if (list2 != null && !list2.isEmpty()) {
                return Long.parseLong(str.substring(str.indexOf("/") + 1));
            }
            return -1L;
        }
    }

    public HttpDFileInfoTask(DTaskWrapper dTaskWrapper) {
        this.mTaskWrapper = dTaskWrapper;
        this.mEntity = dTaskWrapper.mo4442getEntity();
        this.taskOption = (HttpTaskOption) dTaskWrapper.getTaskOption();
    }

    private boolean checkLen(long j) {
        if (j != this.mEntity.getFileSize()) {
            ALog.m4192d(TAG, "长度不一致，任务为新任务");
            this.mTaskWrapper.setNewTask(true);
        }
        return true;
    }

    private void failDownload(AriaHTTPException ariaHTTPException, boolean z) {
        IInfoTask.Callback callback = this.callback;
        if (callback != null) {
            callback.onFail(this.mEntity, ariaHTTPException, z);
        }
    }

    private void handleConnect(HttpURLConnection httpURLConnection) throws IOException {
        Map<String, String> params;
        boolean z = true;
        if (this.taskOption.getRequestEnum() == RequestEnum.POST && (params = this.taskOption.getParams()) != null) {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream());
            Set<String> keySet = params.keySet();
            StringBuilder sb = new StringBuilder();
            for (String str : keySet) {
                sb.append(str);
                sb.append("=");
                sb.append(URLEncoder.encode(params.get(str)));
                sb.append("&");
            }
            String sb2 = sb.toString();
            outputStreamWriter.write(sb2.substring(0, sb2.length() - 1));
            outputStreamWriter.flush();
            outputStreamWriter.close();
        }
        IHttpFileLenAdapter fileLenAdapter = this.taskOption.getFileLenAdapter();
        if (fileLenAdapter == null) {
            fileLenAdapter = new FileLenAdapter();
        } else {
            ALog.m4192d(TAG, "使用自定义adapter");
        }
        long handleFileLen = fileLenAdapter.handleFileLen(httpURLConnection.getHeaderFields());
        if (!FileUtil.checkMemorySpace(this.mEntity.getFilePath(), handleFileLen)) {
            failDownload(new AriaHTTPException(TAG, String.format("下载失败，内存空间不足；filePath: %s, url: %s", this.mEntity.getFilePath(), this.mEntity.getUrl())), false);
            return;
        }
        int responseCode = httpURLConnection.getResponseCode();
        if (TextUtils.isEmpty(this.mEntity.getMd5Code())) {
            this.mEntity.setMd5Code(httpURLConnection.getHeaderField("Content-MD5"));
        }
        String headerField = httpURLConnection.getHeaderField("Transfer-Encoding");
        boolean z2 = !TextUtils.isEmpty(headerField) && headerField.equals("chunked");
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        String headerField2 = httpURLConnection.getHeaderField("Content-Disposition");
        if (this.taskOption.isUseServerFileName()) {
            if (!TextUtils.isEmpty(headerField2)) {
                this.mEntity.setDisposition(CommonUtil.encryptBASE64(headerField2));
                handleContentDisposition(headerField2);
            } else if (this.taskOption.getFileNameAdapter() != null) {
                String handleFileName = this.taskOption.getFileNameAdapter().handleFileName(headerFields, this.mEntity.getKey());
                this.mEntity.setServerFileName(handleFileName);
                renameFile(handleFileName);
            }
        }
        CookieManager cookieManager = new CookieManager();
        List<String> list = headerFields.get(HttpHeaders.SET_COOKIE);
        if (list != null) {
            for (String str2 : list) {
                cookieManager.getCookieStore().add(null, HttpCookie.parse(str2).get(0));
            }
            this.taskOption.setCookieManager(cookieManager);
        }
        this.mTaskWrapper.setCode(responseCode);
        if (responseCode == 206) {
            if (!checkLen(handleFileLen) && !z2) {
                if (handleFileLen >= 0) {
                    return;
                }
                failDownload(new AriaHTTPException(TAG, String.format("任务下载失败，文件长度小于0， url: %s", this.mEntity.getUrl())), false);
                return;
            }
            this.mEntity.setFileSize(handleFileLen);
            this.mTaskWrapper.setSupportBP(true);
        } else if (responseCode == 200) {
            String headerField3 = httpURLConnection.getHeaderField("Content-Type");
            if (TextUtils.isEmpty(headerField3)) {
                return;
            }
            if (headerField3.equals("text/html")) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(ConnectionHelp.convertInputStream(httpURLConnection)));
                StringBuilder sb3 = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        bufferedReader.close();
                        handleUrlReTurn(httpURLConnection, CommonUtil.getWindowReplaceUrl(sb3.toString()));
                        return;
                    }
                    sb3.append(readLine);
                }
            } else if (!checkLen(handleFileLen) && !z2) {
                if (handleFileLen < 0) {
                    failDownload(new AriaHTTPException(TAG, String.format("任务下载失败，文件长度小于0， url: %s", this.mEntity.getUrl())), false);
                }
                ALog.m4192d(TAG, "len < 0");
                return;
            } else {
                this.mEntity.setFileSize(handleFileLen);
                this.mTaskWrapper.setNewTask(true);
                this.mTaskWrapper.setSupportBP(false);
            }
        } else {
            if (responseCode == 302 || responseCode == 301 || responseCode == 303 || responseCode == 201 || responseCode == 307) {
                handleUrlReTurn(httpURLConnection, httpURLConnection.getHeaderField("Location"));
            } else if (responseCode >= 400) {
                failDownload(new AriaHTTPException(TAG, String.format("任务下载失败，errorCode：%s, url: %s", Integer.valueOf(responseCode), this.mEntity.getUrl())), false);
            } else {
                failDownload(new AriaHTTPException(TAG, String.format("任务下载失败，errorCode：%s, errorMsg: %s, url: %s", Integer.valueOf(responseCode), httpURLConnection.getResponseMessage(), this.mEntity.getUrl())), !CheckUtil.httpIsBadRequest(responseCode));
            }
            z = false;
        }
        if (!z) {
            return;
        }
        this.taskOption.setChunked(z2);
        if (this.callback != null) {
            this.callback.onSucceed(this.mEntity.getUrl(), new CompleteInfo(responseCode, this.mTaskWrapper));
        }
        this.mEntity.update();
    }

    private void handleContentDisposition(String str) throws UnsupportedEncodingException {
        String str2;
        if (str.contains(";")) {
            String[] split = str.split(";");
            if (split[0].equals("attachment")) {
                for (String str3 : split) {
                    if (str3.startsWith(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_FILENAME) && str3.contains("=")) {
                        String[] split2 = str3.split("=");
                        if (split2.length > 1) {
                            str2 = split2[1];
                        }
                    }
                }
                return;
            } else if (!split[0].equals("form-data") || split.length <= 2) {
                ALog.m4185w(TAG, "不识别的Content-Disposition参数");
                return;
            } else {
                String[] split3 = split[2].split("=");
                if (split3.length <= 1) {
                    return;
                }
                str2 = split3[1];
            }
            String replaceAll = URLDecoder.decode(str2, "utf-8").replaceAll("\"", "");
            this.mEntity.setServerFileName(replaceAll);
            renameFile(replaceAll);
        }
    }

    private void handleUrlReTurn(HttpURLConnection httpURLConnection, String str) throws IOException {
        ALog.m4192d(TAG, "30x跳转，新url为【" + str + "】");
        if (TextUtils.isEmpty(str) || str.equalsIgnoreCase("null")) {
            IInfoTask.Callback callback = this.callback;
            if (callback == null) {
                return;
            }
            callback.onFail(this.mEntity, new AriaHTTPException(TAG, "获取重定向链接失败"), false);
            return;
        }
        if (str.startsWith("/")) {
            Uri parse = Uri.parse(this.mEntity.getUrl());
            str = parse.getHost() + str;
        }
        if (!CheckUtil.checkUrl(str)) {
            failDownload(new AriaHTTPException(TAG, "下载失败，重定向url错误"), false);
            return;
        }
        this.taskOption.setRedirectUrl(str);
        this.mEntity.setRedirect(true);
        this.mEntity.setRedirectUrl(str);
        String headerField = httpURLConnection.getHeaderField(HttpHeaders.SET_COOKIE);
        httpURLConnection.disconnect();
        HttpURLConnection handleConnection = ConnectionHelp.handleConnection(ConnectionHelp.handleUrl(str, this.taskOption), this.taskOption);
        ConnectionHelp.setConnectParam(this.taskOption, handleConnection);
        handleConnection.setRequestProperty(HttpHeaders.COOKIE, headerField);
        handleConnection.setRequestProperty("Range", "bytes=0-");
        handleConnection.setConnectTimeout(this.mConnectTimeOut);
        handleConnection.connect();
        handleConnect(handleConnection);
        handleConnection.disconnect();
    }

    private void renameFile(String str) {
        if (TextUtils.isEmpty(str)) {
            ALog.m4185w(TAG, "重命名失败【服务器返回的文件名为空】");
            return;
        }
        ALog.m4192d(TAG, String.format("文件重命名为：%s", str));
        File file = new File(this.mEntity.getFilePath());
        String str2 = file.getParent() + "/" + str;
        if (!CheckUtil.checkDPathConflicts(false, str2, this.mTaskWrapper.getRequestType())) {
            ALog.m4191e(TAG, "文件重命名失败");
            return;
        }
        if (file.exists()) {
            Object[] objArr = new Object[1];
            objArr[0] = file.renameTo(new File(str2)) ? "成功" : "失败";
            ALog.m4192d(TAG, String.format("文件重命名%s", objArr));
        }
        this.mEntity.setFileName(str);
        this.mEntity.setFilePath(str2);
        RecordUtil.modifyTaskRecord(file.getPath(), str2, this.mEntity.getTaskType());
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
                httpURLConnection = ConnectionHelp.handleConnection(ConnectionHelp.handleUrl(this.mEntity.getUrl(), this.taskOption), this.taskOption);
                ConnectionHelp.setConnectParam(this.taskOption, httpURLConnection);
                httpURLConnection.setRequestProperty("Range", "bytes=0-");
                httpURLConnection.setConnectTimeout(this.mConnectTimeOut);
                httpURLConnection.connect();
                handleConnect(httpURLConnection);
                try {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (IOException e) {
                    e = e;
                    e.printStackTrace();
                    httpURLConnection.disconnect();
                }
            } catch (Throwable th) {
                if (httpURLConnection != null) {
                    try {
                        InputStream inputStream2 = httpURLConnection.getInputStream();
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (IOException e3) {
            failDownload(new AriaHTTPException(TAG, String.format("下载失败，filePath: %s, url: %s", this.mEntity.getFilePath(), this.mEntity.getUrl()), e3), true);
            if (httpURLConnection == null) {
                return;
            }
            try {
                InputStream inputStream3 = httpURLConnection.getInputStream();
                if (inputStream3 != null) {
                    inputStream3.close();
                }
            } catch (IOException e4) {
                e = e4;
                e.printStackTrace();
                httpURLConnection.disconnect();
            }
        }
        httpURLConnection.disconnect();
    }

    @Override // com.arialyy.aria.core.loader.IInfoTask
    public void setCallback(IInfoTask.Callback callback) {
        this.callback = callback;
    }
}
