package com.arialyy.aria.m3u8;

import android.net.Uri;
import android.text.TextUtils;
import com.arialyy.aria.core.common.RequestEnum;
import com.arialyy.aria.core.common.SubThreadConfig;
import com.arialyy.aria.core.download.DownloadEntity;
import com.arialyy.aria.core.task.AbsThreadTaskAdapter;
import com.arialyy.aria.exception.AriaM3U8Exception;
import com.arialyy.aria.http.ConnectionHelp;
import com.arialyy.aria.http.HttpTaskOption;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CheckUtil;
import com.arialyy.aria.util.CommonUtil;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.Map;
import java.util.Set;
import org.eclipse.jetty.http.HttpHeaders;

/* loaded from: classes3.dex */
public final class M3U8ThreadTaskAdapter extends AbsThreadTaskAdapter {
    public final String TAG = CommonUtil.getClassName(this);

    /* renamed from: is */
    public BufferedInputStream f165is = null;
    public HttpTaskOption mHttpTaskOption = (HttpTaskOption) getTaskWrapper().getTaskOption();

    public M3U8ThreadTaskAdapter(SubThreadConfig subThreadConfig) {
        super(subThreadConfig);
    }

    private DownloadEntity getEntity() {
        return (DownloadEntity) getTaskWrapper().mo4442getEntity();
    }

    private void handleComplete() {
        if (getThreadTask().isBreak()) {
            return;
        }
        complete();
    }

    private void handleConn(HttpURLConnection httpURLConnection) throws IOException {
        ConnectionHelp.setConnectParam(this.mHttpTaskOption, httpURLConnection);
        httpURLConnection.setConnectTimeout(getTaskConfig().getConnectTimeOut());
        httpURLConnection.setReadTimeout(getTaskConfig().getIOTimeOut());
        httpURLConnection.connect();
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == 200) {
            this.f165is = new BufferedInputStream(ConnectionHelp.convertInputStream(httpURLConnection));
            if (this.mHttpTaskOption.isChunked()) {
                readChunked(this.f165is);
            } else if (getThreadConfig().isBlock) {
                readDynamicFile(this.f165is);
            }
        } else if (responseCode == 302 || responseCode == 301 || responseCode == 303 || responseCode == 201 || responseCode == 307) {
            handleUrlReTurn(httpURLConnection, httpURLConnection.getHeaderField("Location"));
        } else {
            fail(new AriaM3U8Exception(this.TAG, String.format("连接错误，http错误码：%s，url：%s", Integer.valueOf(responseCode), getThreadConfig().url)), false);
        }
        httpURLConnection.disconnect();
    }

    private void handleUrlReTurn(HttpURLConnection httpURLConnection, String str) throws IOException {
        AriaM3U8Exception ariaM3U8Exception;
        ALog.m4192d(this.TAG, "30x跳转，新url为【" + str + "】");
        if (TextUtils.isEmpty(str) || str.equalsIgnoreCase("null")) {
            ariaM3U8Exception = new AriaM3U8Exception(this.TAG, "下载失败，重定向url为空");
        } else {
            if (str.startsWith("/")) {
                Uri parse = Uri.parse(getThreadConfig().url);
                str = parse.getHost() + str;
            }
            if (CheckUtil.checkUrl(str)) {
                String headerField = httpURLConnection.getHeaderField(HttpHeaders.SET_COOKIE);
                httpURLConnection.disconnect();
                HttpURLConnection handleConnection = ConnectionHelp.handleConnection(ConnectionHelp.handleUrl(str, this.mHttpTaskOption), this.mHttpTaskOption);
                if (!TextUtils.isEmpty(headerField)) {
                    handleConnection.setRequestProperty(HttpHeaders.COOKIE, headerField);
                }
                if (this.mHttpTaskOption.isChunked()) {
                    handleConnection.setDoInput(true);
                    handleConnection.setChunkedStreamingMode(0);
                }
                handleConn(handleConnection);
                return;
            }
            ariaM3U8Exception = new AriaM3U8Exception(this.TAG, "下载失败，重定向url错误");
        }
        fail(ariaM3U8Exception, false);
    }

    private void readChunked(InputStream inputStream) {
        FileOutputStream fileOutputStream;
        int read;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(getThreadConfig().tempFile, true);
                } catch (IOException e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] bArr = new byte[getTaskConfig().getBuffSize()];
                while (getThreadTask().isLive() && (read = inputStream.read(bArr)) != -1 && !getThreadTask().isBreak()) {
                    if (this.mSpeedBandUtil != null) {
                        this.mSpeedBandUtil.limitNextBytes(read);
                    }
                    fileOutputStream.write(bArr, 0, read);
                    progress(read);
                }
                handleComplete();
                fileOutputStream.close();
            } catch (IOException e2) {
                e = e2;
                fileOutputStream2 = fileOutputStream;
                fail(new AriaM3U8Exception(this.TAG, String.format("文件下载失败，savePath: %s, url: %s", getThreadConfig().tempFile.getPath(), getThreadConfig().url), e), true);
                if (fileOutputStream2 == null) {
                    return;
                }
                fileOutputStream2.close();
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e4) {
            e4.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00d3 A[Catch: IOException -> 0x00cf, TryCatch #6 {IOException -> 0x00cf, blocks: (B:60:0x00c8, B:51:0x00d3, B:53:0x00d8), top: B:59:0x00c8 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d8 A[Catch: IOException -> 0x00cf, TRY_LEAVE, TryCatch #6 {IOException -> 0x00cf, blocks: (B:60:0x00c8, B:51:0x00d3, B:53:0x00d8), top: B:59:0x00c8 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void readDynamicFile(InputStream inputStream) {
        ReadableByteChannel readableByteChannel;
        FileChannel fileChannel;
        int read;
        FileOutputStream fileOutputStream = null;
        r1 = null;
        ReadableByteChannel readableByteChannel2 = null;
        fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(getThreadConfig().tempFile, true);
                try {
                    fileChannel = fileOutputStream2.getChannel();
                    try {
                        readableByteChannel2 = Channels.newChannel(inputStream);
                        ByteBuffer allocate = ByteBuffer.allocate(getTaskConfig().getBuffSize());
                        while (getThreadTask().isLive() && (read = readableByteChannel2.read(allocate)) != -1 && !getThreadTask().isBreak()) {
                            if (this.mSpeedBandUtil != null) {
                                this.mSpeedBandUtil.limitNextBytes(read);
                            }
                            allocate.flip();
                            fileChannel.write(allocate);
                            allocate.compact();
                            progress(read);
                        }
                        handleComplete();
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                        if (fileChannel != null) {
                            fileChannel.close();
                        }
                        if (readableByteChannel2 == null) {
                            return;
                        }
                        readableByteChannel2.close();
                    } catch (IOException e) {
                        e = e;
                        readableByteChannel = readableByteChannel2;
                        fileOutputStream = fileOutputStream2;
                        try {
                            fail(new AriaM3U8Exception(this.TAG, String.format("文件下载失败，savePath: %s, url: %s", getThreadConfig().tempFile.getPath(), getThreadConfig().url), e), true);
                            if (fileOutputStream != null) {
                                fileOutputStream.flush();
                                fileOutputStream.close();
                            }
                            if (fileChannel != null) {
                                fileChannel.close();
                            }
                            if (readableByteChannel == null) {
                                return;
                            }
                            readableByteChannel.close();
                        } catch (Throwable th) {
                            th = th;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.flush();
                                    fileOutputStream.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                    throw th;
                                }
                            }
                            if (fileChannel != null) {
                                fileChannel.close();
                            }
                            if (readableByteChannel != null) {
                                readableByteChannel.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        readableByteChannel = readableByteChannel2;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                        }
                        if (fileChannel != null) {
                        }
                        if (readableByteChannel != null) {
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                    fileChannel = null;
                    fileOutputStream = fileOutputStream2;
                    readableByteChannel = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileChannel = null;
                    fileOutputStream = fileOutputStream2;
                    readableByteChannel = null;
                }
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        } catch (IOException e5) {
            e = e5;
            readableByteChannel = null;
            fileChannel = null;
        } catch (Throwable th4) {
            th = th4;
            readableByteChannel = null;
            fileChannel = null;
        }
    }

    @Override // com.arialyy.aria.core.task.AbsThreadTaskAdapter
    public void handlerThreadTask() {
        Map<String, String> params;
        if (getThreadRecord().isComplete) {
            handleComplete();
            return;
        }
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                try {
                    try {
                        httpURLConnection = ConnectionHelp.handleConnection(ConnectionHelp.handleUrl(getThreadConfig().url, this.mHttpTaskOption), this.mHttpTaskOption);
                        ALog.m4192d(this.TAG, String.format("分片【%s】开始下载", Integer.valueOf(getThreadRecord().threadId)));
                        if (this.mHttpTaskOption.isChunked()) {
                            httpURLConnection.setDoInput(true);
                            httpURLConnection.setChunkedStreamingMode(0);
                        }
                        if (this.mHttpTaskOption.getRequestEnum() == RequestEnum.POST && (params = this.mHttpTaskOption.getParams()) != null) {
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
                        handleConn(httpURLConnection);
                        if (this.f165is != null) {
                            this.f165is.close();
                        }
                        httpURLConnection.disconnect();
                    } catch (Throwable th) {
                        try {
                            if (this.f165is != null) {
                                this.f165is.close();
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        throw th;
                    }
                } catch (Exception e2) {
                    fail(new AriaM3U8Exception(this.TAG, String.format("分片【%s】下载失败，filePath: %s, url: %s", Integer.valueOf(getThreadRecord().threadId), getThreadConfig().tempFile.getPath(), getEntity().getUrl()), e2), false);
                    if (this.f165is != null) {
                        this.f165is.close();
                    }
                    if (httpURLConnection == null) {
                        return;
                    }
                    httpURLConnection.disconnect();
                }
            } catch (MalformedURLException e3) {
                fail(new AriaM3U8Exception(this.TAG, String.format("分片【%s】下载失败，filePath: %s, url: %s", Integer.valueOf(getThreadRecord().threadId), getThreadConfig().tempFile.getPath(), getEntity().getUrl()), e3), false);
                if (this.f165is != null) {
                    this.f165is.close();
                }
                if (httpURLConnection == null) {
                    return;
                }
                httpURLConnection.disconnect();
            } catch (IOException e4) {
                fail(new AriaM3U8Exception(this.TAG, String.format("分片【%s】下载失败，filePath: %s, url: %s", Integer.valueOf(getThreadRecord().threadId), getThreadConfig().tempFile.getPath(), getEntity().getUrl()), e4), true);
                if (this.f165is != null) {
                    this.f165is.close();
                }
                if (httpURLConnection == null) {
                    return;
                }
                httpURLConnection.disconnect();
            }
        } catch (IOException e5) {
            e5.printStackTrace();
        }
    }
}
