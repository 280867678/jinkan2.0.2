package com.arialyy.aria.http.upload;

import android.text.TextUtils;
import com.arialyy.aria.core.common.SubThreadConfig;
import com.arialyy.aria.core.upload.UploadEntity;
import com.arialyy.aria.exception.AriaHTTPException;
import com.arialyy.aria.http.BaseHttpThreadTaskAdapter;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.BandwidthLimiter;
import com.arialyy.aria.util.CommonUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.UUID;
import me.tvspark.outline;
import org.eclipse.jetty.util.MultiPartWriter;

/* loaded from: classes3.dex */
public final class HttpUThreadTaskAdapter extends BaseHttpThreadTaskAdapter {
    public HttpURLConnection mHttpConn;
    public OutputStream mOutputStream;
    public final String BOUNDARY = UUID.randomUUID().toString();
    public final String PREFIX = MultiPartWriter.__DASHDASH;
    public final String LINE_END = "\r\n";

    public HttpUThreadTaskAdapter(SubThreadConfig subThreadConfig) {
        super(subThreadConfig);
    }

    private void addFormField(PrintWriter printWriter, String str, String str2) {
        printWriter.append(MultiPartWriter.__DASHDASH).append((CharSequence) this.BOUNDARY).append("\r\n");
        printWriter.append("Content-Disposition: form-data; name=\"").append((CharSequence) str).append("\"").append("\r\n");
        printWriter.append("Content-Type: text/plain; charset=").append((CharSequence) this.mTaskOption.getCharSet()).append("\r\n");
        printWriter.append("\r\n");
        printWriter.append((CharSequence) str2).append("\r\n");
        printWriter.flush();
    }

    private void fail(AriaHTTPException ariaHTTPException) {
        try {
            fail(ariaHTTPException, false);
            if (this.mOutputStream == null) {
                return;
            }
            this.mOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String finish(PrintWriter printWriter) throws IOException {
        String readLine;
        StringBuilder sb = new StringBuilder();
        printWriter.append("\r\n").flush();
        printWriter.append(MultiPartWriter.__DASHDASH).append((CharSequence) this.BOUNDARY).append(MultiPartWriter.__DASHDASH).append("\r\n");
        printWriter.flush();
        int responseCode = this.mHttpConn.getResponseCode();
        if (responseCode == 200) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.mHttpConn.getInputStream()));
            while (getThreadTask().isLive() && (readLine = bufferedReader.readLine()) != null) {
                sb.append(readLine);
            }
            bufferedReader.close();
            this.mHttpConn.disconnect();
            complete();
        } else {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("response msg: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mHttpConn.getResponseMessage());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("，code: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(responseCode);
            String sb2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            ALog.m4191e(this.TAG, sb2);
            fail(new AriaHTTPException(this.TAG, sb2), false);
        }
        printWriter.flush();
        printWriter.close();
        this.mOutputStream.close();
        return sb.toString();
    }

    private String getContentType() {
        return (this.mTaskOption.getHeaders() == null || TextUtils.isEmpty(this.mTaskOption.getHeaders().get("Content-Type"))) ? "multipart/form-data" : this.mTaskOption.getHeaders().get("Content-Type");
    }

    private String getUserAgent() {
        return (this.mTaskOption.getHeaders() == null || TextUtils.isEmpty(this.mTaskOption.getHeaders().get("User-Agent"))) ? "Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.6)" : this.mTaskOption.getHeaders().get("User-Agent");
    }

    private void uploadFile(PrintWriter printWriter, String str, File file) throws IOException {
        printWriter.append(MultiPartWriter.__DASHDASH).append((CharSequence) this.BOUNDARY).append("\r\n");
        printWriter.append("Content-Disposition: form-data; name=\"").append((CharSequence) str).append("\"; filename=\"").append((CharSequence) mo4443getEntity().getFileName()).append("\"").append("\r\n");
        printWriter.append("Content-Type: ").append((CharSequence) URLConnection.guessContentTypeFromName(mo4443getEntity().getFileName())).append("\r\n");
        printWriter.append("Content-Transfer-Encoding: binary").append("\r\n");
        printWriter.append("\r\n");
        printWriter.flush();
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[4096];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read == -1) {
                break;
            }
            progress(read);
            this.mOutputStream.write(bArr, 0, read);
            if (getThreadTask().isBreak()) {
                break;
            }
            BandwidthLimiter bandwidthLimiter = this.mSpeedBandUtil;
            if (bandwidthLimiter != null) {
                bandwidthLimiter.limitNextBytes(read);
            }
        }
        this.mOutputStream.flush();
        fileInputStream.close();
        printWriter.append("\r\n");
        printWriter.flush();
    }

    @Override // com.arialyy.aria.http.BaseHttpThreadTaskAdapter
    /* renamed from: getEntity  reason: collision with other method in class */
    public UploadEntity mo4443getEntity() {
        return (UploadEntity) super.mo4443getEntity();
    }

    @Override // com.arialyy.aria.core.task.AbsThreadTaskAdapter
    public void handlerThreadTask() {
        File file = new File(mo4443getEntity().getFilePath());
        if (!file.exists()) {
            fail(new AriaHTTPException(this.TAG, String.format("上传失败，文件不存在；filePath: %s, url: %s", mo4443getEntity().getFilePath(), mo4443getEntity().getUrl())));
            return;
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(CommonUtil.convertUrl(getThreadConfig().url)).openConnection();
            this.mHttpConn = httpURLConnection;
            httpURLConnection.setRequestMethod(this.mTaskOption.getRequestEnum().name);
            this.mHttpConn.setUseCaches(false);
            this.mHttpConn.setDoOutput(true);
            this.mHttpConn.setDoInput(true);
            this.mHttpConn.setRequestProperty("Connection", "Keep-Alive");
            HttpURLConnection httpURLConnection2 = this.mHttpConn;
            httpURLConnection2.setRequestProperty("Content-Type", getContentType() + "; boundary=" + this.BOUNDARY);
            this.mHttpConn.setRequestProperty("User-Agent", getUserAgent());
            this.mHttpConn.setConnectTimeout(getTaskConfig().getConnectTimeOut());
            this.mHttpConn.setReadTimeout(getTaskConfig().getIOTimeOut());
            this.mHttpConn.setChunkedStreamingMode(getTaskConfig().getBuffSize());
            for (String str : this.mTaskOption.getHeaders().keySet()) {
                this.mHttpConn.setRequestProperty(str, this.mTaskOption.getHeaders().get(str));
            }
            this.mOutputStream = this.mHttpConn.getOutputStream();
            PrintWriter printWriter = new PrintWriter((Writer) new OutputStreamWriter(this.mOutputStream, this.mTaskOption.getCharSet()), true);
            Map<String, String> params = this.mTaskOption.getParams();
            if (params != null && !params.isEmpty()) {
                for (String str2 : params.keySet()) {
                    addFormField(printWriter, str2, params.get(str2));
                }
            }
            for (String str3 : this.mTaskOption.getFormFields().keySet()) {
                addFormField(printWriter, str3, this.mTaskOption.getFormFields().get(str3));
            }
            uploadFile(printWriter, this.mTaskOption.getAttachment(), file);
            mo4443getEntity().setResponseStr(finish(printWriter));
        } catch (Exception e) {
            e.printStackTrace();
            fail(new AriaHTTPException(this.TAG, String.format("上传失败，filePath: %s, url: %s", mo4443getEntity().getFilePath(), mo4443getEntity().getUrl()), e));
        }
    }
}
