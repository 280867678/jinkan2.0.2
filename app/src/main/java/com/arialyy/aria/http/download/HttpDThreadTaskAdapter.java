package com.arialyy.aria.http.download;

import com.arialyy.aria.core.common.RequestEnum;
import com.arialyy.aria.core.common.SubThreadConfig;
import com.arialyy.aria.core.download.DTaskWrapper;
import com.arialyy.aria.exception.AriaHTTPException;
import com.arialyy.aria.http.BaseHttpThreadTaskAdapter;
import com.arialyy.aria.http.ConnectionHelp;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.BandwidthLimiter;
import com.arialyy.aria.util.BufferedRandomAccessFile;
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

/* loaded from: classes3.dex */
public final class HttpDThreadTaskAdapter extends BaseHttpThreadTaskAdapter {
    public final String TAG = "HttpDThreadTaskAdapter";
    public DTaskWrapper mTaskWrapper;

    public HttpDThreadTaskAdapter(SubThreadConfig subThreadConfig) {
        super(subThreadConfig);
    }

    private void handleComplete() {
        if (!getThreadTask().isBreak() && getThreadTask().checkBlock()) {
            complete();
        }
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
                fail(new AriaHTTPException("HttpDThreadTaskAdapter", String.format("文件下载失败，savePath: %s, url: %s", mo4443getEntity().getFilePath(), getThreadConfig().url), e), true);
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

    /* JADX WARN: Removed duplicated region for block: B:54:0x00fe A[Catch: IOException -> 0x00fa, TryCatch #1 {IOException -> 0x00fa, blocks: (B:63:0x00f3, B:54:0x00fe, B:56:0x0103), top: B:62:0x00f3 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0103 A[Catch: IOException -> 0x00fa, TRY_LEAVE, TryCatch #1 {IOException -> 0x00fa, blocks: (B:63:0x00f3, B:54:0x00fe, B:56:0x0103), top: B:62:0x00f3 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void readDynamicFile(InputStream inputStream) {
        ReadableByteChannel readableByteChannel;
        FileChannel fileChannel;
        FileOutputStream fileOutputStream;
        int read;
        FileOutputStream fileOutputStream2 = null;
        r2 = null;
        ReadableByteChannel readableByteChannel2 = null;
        fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(getThreadConfig().tempFile, true);
                try {
                    fileChannel = fileOutputStream.getChannel();
                } catch (IOException e) {
                    e = e;
                    fileChannel = null;
                    fileOutputStream2 = fileOutputStream;
                    readableByteChannel = null;
                } catch (Throwable th) {
                    th = th;
                    fileChannel = null;
                    fileOutputStream2 = fileOutputStream;
                    readableByteChannel = null;
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                return;
            }
        } catch (IOException e3) {
            e = e3;
            readableByteChannel = null;
            fileChannel = null;
        } catch (Throwable th2) {
            th = th2;
            readableByteChannel = null;
            fileChannel = null;
        }
        try {
            readableByteChannel2 = Channels.newChannel(inputStream);
            ByteBuffer allocate = ByteBuffer.allocate(getTaskConfig().getBuffSize());
            while (true) {
                if (!getThreadTask().isLive() || (read = readableByteChannel2.read(allocate)) == -1 || getThreadTask().isBreak()) {
                    break;
                }
                if (this.mSpeedBandUtil != null) {
                    this.mSpeedBandUtil.limitNextBytes(read);
                }
                long j = read;
                if (getRangeProgress() + j >= getThreadRecord().endLocation) {
                    int rangeProgress = (int) (getThreadRecord().endLocation - getRangeProgress());
                    allocate.flip();
                    fileOutputStream.write(allocate.array(), 0, rangeProgress);
                    allocate.compact();
                    progress(rangeProgress);
                    break;
                }
                allocate.flip();
                fileChannel.write(allocate);
                allocate.compact();
                progress(j);
            }
            handleComplete();
            fileOutputStream.flush();
            fileOutputStream.close();
            if (fileChannel != null) {
                fileChannel.close();
            }
            if (readableByteChannel2 == null) {
                return;
            }
            readableByteChannel2.close();
        } catch (IOException e4) {
            e = e4;
            readableByteChannel = readableByteChannel2;
            fileOutputStream2 = fileOutputStream;
            try {
                fail(new AriaHTTPException("HttpDThreadTaskAdapter", String.format("文件下载失败，savePath: %s, url: %s", mo4443getEntity().getFilePath(), getThreadConfig().url), e), true);
                if (fileOutputStream2 != null) {
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                }
                if (fileChannel != null) {
                    fileChannel.close();
                }
                if (readableByteChannel == null) {
                    return;
                }
                readableByteChannel.close();
            } catch (Throwable th3) {
                th = th3;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
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
        } catch (Throwable th4) {
            th = th4;
            readableByteChannel = readableByteChannel2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
            }
            if (fileChannel != null) {
            }
            if (readableByteChannel != null) {
            }
            throw th;
        }
    }

    private void readNormal(InputStream inputStream, BufferedRandomAccessFile bufferedRandomAccessFile) throws IOException {
        int read;
        byte[] bArr = new byte[getTaskConfig().getBuffSize()];
        while (getThreadTask().isLive() && (read = inputStream.read(bArr)) != -1 && !getThreadTask().isBreak()) {
            BandwidthLimiter bandwidthLimiter = this.mSpeedBandUtil;
            if (bandwidthLimiter != null) {
                bandwidthLimiter.limitNextBytes(read);
            }
            bufferedRandomAccessFile.write(bArr, 0, read);
            progress(read);
        }
    }

    @Override // com.arialyy.aria.core.task.AbsThreadTaskAdapter
    public void handlerThreadTask() {
        Throwable th;
        HttpURLConnection httpURLConnection;
        BufferedInputStream bufferedInputStream;
        Exception exc;
        IOException iOException;
        MalformedURLException malformedURLException;
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException;
        Map<String, String> params;
        this.mTaskWrapper = (DTaskWrapper) getTaskWrapper();
        if (getThreadRecord().isComplete) {
            handleComplete();
            return;
        }
        BufferedRandomAccessFile bufferedRandomAccessFile = null;
        try {
            try {
                try {
                    httpURLConnection = ConnectionHelp.handleConnection(ConnectionHelp.handleUrl(getThreadConfig().url, this.mTaskOption), this.mTaskOption);
                    try {
                        if (this.mTaskWrapper.isSupportBP()) {
                            ALog.m4192d("HttpDThreadTaskAdapter", String.format("任务【%s】线程__%s__开始下载【开始位置 : %s，结束位置：%s】", getFileName(), Integer.valueOf(getThreadRecord().threadId), Long.valueOf(getThreadRecord().startLocation), Long.valueOf(getThreadRecord().endLocation)));
                            httpURLConnection.setRequestProperty("Range", String.format("bytes=%s-%s", Long.valueOf(getThreadRecord().startLocation), Long.valueOf(getThreadRecord().endLocation - 1)));
                        } else {
                            ALog.m4185w("HttpDThreadTaskAdapter", "该下载不支持断点");
                        }
                        ConnectionHelp.setConnectParam(this.mTaskOption, httpURLConnection);
                        httpURLConnection.setConnectTimeout(getTaskConfig().getConnectTimeOut());
                        httpURLConnection.setReadTimeout(getTaskConfig().getIOTimeOut());
                        if (this.mTaskOption.isChunked()) {
                            httpURLConnection.setDoInput(true);
                            httpURLConnection.setChunkedStreamingMode(0);
                        }
                        httpURLConnection.connect();
                        if (this.mTaskOption.getRequestEnum() == RequestEnum.POST && (params = this.mTaskOption.getParams()) != null) {
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
                        bufferedInputStream = new BufferedInputStream(ConnectionHelp.convertInputStream(httpURLConnection));
                        try {
                            if (this.mTaskOption.isChunked()) {
                                readChunked(bufferedInputStream);
                            } else if (getThreadConfig().isBlock) {
                                readDynamicFile(bufferedInputStream);
                            } else {
                                BufferedRandomAccessFile bufferedRandomAccessFile2 = new BufferedRandomAccessFile(getThreadConfig().tempFile, "rwd", getTaskConfig().getBuffSize());
                                try {
                                    if (getThreadRecord().startLocation > 0) {
                                        bufferedRandomAccessFile2.seek(getThreadRecord().startLocation);
                                    }
                                    readNormal(bufferedInputStream, bufferedRandomAccessFile2);
                                    handleComplete();
                                    bufferedRandomAccessFile = bufferedRandomAccessFile2;
                                } catch (IOException e) {
                                    e = e;
                                    bufferedRandomAccessFile = bufferedRandomAccessFile2;
                                    iOException = e;
                                    fail(new AriaHTTPException("HttpDThreadTaskAdapter", String.format("任务【%s】下载失败，filePath: %s, url: %s", getFileName(), mo4443getEntity().getFilePath(), mo4443getEntity().getUrl()), iOException), true);
                                    if (bufferedRandomAccessFile != null) {
                                        bufferedRandomAccessFile.close();
                                    }
                                    if (bufferedInputStream != null) {
                                        bufferedInputStream.close();
                                    }
                                    if (httpURLConnection == null) {
                                        return;
                                    }
                                    httpURLConnection.getInputStream().close();
                                    httpURLConnection.disconnect();
                                    return;
                                } catch (ArrayIndexOutOfBoundsException e2) {
                                    e = e2;
                                    bufferedRandomAccessFile = bufferedRandomAccessFile2;
                                    arrayIndexOutOfBoundsException = e;
                                    fail(new AriaHTTPException("HttpDThreadTaskAdapter", String.format("任务【%s】下载失败，filePath: %s, url: %s", getFileName(), mo4443getEntity().getFilePath(), mo4443getEntity().getUrl()), arrayIndexOutOfBoundsException), false);
                                    if (bufferedRandomAccessFile != null) {
                                        bufferedRandomAccessFile.close();
                                    }
                                    if (bufferedInputStream != null) {
                                        bufferedInputStream.close();
                                    }
                                    if (httpURLConnection == null) {
                                        return;
                                    }
                                    httpURLConnection.getInputStream().close();
                                    httpURLConnection.disconnect();
                                    return;
                                } catch (MalformedURLException e3) {
                                    e = e3;
                                    bufferedRandomAccessFile = bufferedRandomAccessFile2;
                                    malformedURLException = e;
                                    fail(new AriaHTTPException("HttpDThreadTaskAdapter", String.format("任务【%s】下载失败，filePath: %s, url: %s", getFileName(), mo4443getEntity().getFilePath(), mo4443getEntity().getUrl()), malformedURLException), false);
                                    if (bufferedRandomAccessFile != null) {
                                        bufferedRandomAccessFile.close();
                                    }
                                    if (bufferedInputStream != null) {
                                        bufferedInputStream.close();
                                    }
                                    if (httpURLConnection == null) {
                                        return;
                                    }
                                    httpURLConnection.getInputStream().close();
                                    httpURLConnection.disconnect();
                                    return;
                                } catch (Exception e4) {
                                    e = e4;
                                    bufferedRandomAccessFile = bufferedRandomAccessFile2;
                                    exc = e;
                                    fail(new AriaHTTPException("HttpDThreadTaskAdapter", String.format("任务【%s】下载失败，filePath: %s, url: %s", getFileName(), mo4443getEntity().getFilePath(), mo4443getEntity().getUrl()), exc), false);
                                    if (bufferedRandomAccessFile != null) {
                                        bufferedRandomAccessFile.close();
                                    }
                                    if (bufferedInputStream != null) {
                                        bufferedInputStream.close();
                                    }
                                    if (httpURLConnection == null) {
                                        return;
                                    }
                                    httpURLConnection.getInputStream().close();
                                    httpURLConnection.disconnect();
                                    return;
                                } catch (Throwable th2) {
                                    th = th2;
                                    bufferedRandomAccessFile = bufferedRandomAccessFile2;
                                    if (bufferedRandomAccessFile != null) {
                                        try {
                                            bufferedRandomAccessFile.close();
                                        } catch (IOException e5) {
                                            e5.printStackTrace();
                                            throw th;
                                        }
                                    }
                                    if (bufferedInputStream != null) {
                                        bufferedInputStream.close();
                                    }
                                    if (httpURLConnection != null) {
                                        httpURLConnection.getInputStream().close();
                                        httpURLConnection.disconnect();
                                    }
                                    throw th;
                                }
                            }
                            if (bufferedRandomAccessFile != null) {
                                bufferedRandomAccessFile.close();
                            }
                            bufferedInputStream.close();
                            httpURLConnection.getInputStream().close();
                            httpURLConnection.disconnect();
                        } catch (MalformedURLException e6) {
                            e = e6;
                        } catch (IOException e7) {
                            e = e7;
                        } catch (ArrayIndexOutOfBoundsException e8) {
                            e = e8;
                        } catch (Exception e9) {
                            e = e9;
                        }
                    } catch (IOException e10) {
                        iOException = e10;
                        bufferedInputStream = null;
                    } catch (ArrayIndexOutOfBoundsException e11) {
                        arrayIndexOutOfBoundsException = e11;
                        bufferedInputStream = null;
                    } catch (MalformedURLException e12) {
                        malformedURLException = e12;
                        bufferedInputStream = null;
                    } catch (Exception e13) {
                        exc = e13;
                        bufferedInputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedInputStream = null;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (ArrayIndexOutOfBoundsException e14) {
                arrayIndexOutOfBoundsException = e14;
                httpURLConnection = null;
                bufferedInputStream = null;
            } catch (MalformedURLException e15) {
                malformedURLException = e15;
                httpURLConnection = null;
                bufferedInputStream = null;
            } catch (IOException e16) {
                iOException = e16;
                httpURLConnection = null;
                bufferedInputStream = null;
            } catch (Exception e17) {
                exc = e17;
                httpURLConnection = null;
                bufferedInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                httpURLConnection = null;
                bufferedInputStream = null;
            }
        } catch (IOException e18) {
            e18.printStackTrace();
        }
    }
}
