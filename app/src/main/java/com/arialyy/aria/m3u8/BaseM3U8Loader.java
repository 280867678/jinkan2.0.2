package com.arialyy.aria.m3u8;

import android.text.TextUtils;
import com.arialyy.aria.core.download.DTaskWrapper;
import com.arialyy.aria.core.download.DownloadEntity;
import com.arialyy.aria.core.download.M3U8Entity;
import com.arialyy.aria.core.listener.IEventListener;
import com.arialyy.aria.core.loader.AbsNormalLoader;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.FileUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/* loaded from: classes3.dex */
public abstract class BaseM3U8Loader extends AbsNormalLoader<DTaskWrapper> {
    public M3U8TaskOption mM3U8Option;

    public BaseM3U8Loader(DTaskWrapper dTaskWrapper, IEventListener iEventListener) {
        super(dTaskWrapper, iEventListener);
        this.mM3U8Option = (M3U8TaskOption) dTaskWrapper.getM3u8Option();
        this.mTempFile = new File(dTaskWrapper.mo4442getEntity().getFilePath());
    }

    public static String getTsFilePath(String str, int i) {
        return String.format("%s/%s.ts", str, Integer.valueOf(i));
    }

    @Override // com.arialyy.aria.core.loader.AbsNormalLoader
    public long delayTimer() {
        return 1000L;
    }

    public boolean generateIndexFile(boolean z) {
        FileOutputStream fileOutputStream;
        String concat;
        Charset forName;
        byte[] bytes;
        File file = new File(String.format(M3U8InfoTask.M3U8_INDEX_FORMAT, getEntity().getFilePath()));
        if (!file.exists()) {
            ALog.m4191e(this.TAG, "源索引文件不存在");
            return false;
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                try {
                    String cacheDir = getCacheDir();
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        fileOutputStream = new FileOutputStream(getEntity().getFilePath());
                        try {
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream2));
                            int i = 0;
                            while (true) {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                if (readLine.startsWith("#EXTINF")) {
                                    fileOutputStream.write(readLine.concat("\r\n").getBytes(Charset.forName("UTF-8")));
                                    bytes = getTsFilePath(cacheDir, this.mRecord.threadRecords.get(i).threadId).concat("\r\n").getBytes(Charset.forName("UTF-8"));
                                    bufferedReader.readLine();
                                    i++;
                                } else {
                                    if (readLine.startsWith("#EXT-X-KEY")) {
                                        M3U8Entity m3U8Entity = getEntity().getM3U8Entity();
                                        concat = String.format("#EXT-X-KEY:METHOD=%s,URI=%s,IV=%s\r\n", m3U8Entity.method, m3U8Entity.keyPath, m3U8Entity.f163iv);
                                        forName = Charset.forName("UTF-8");
                                    } else {
                                        concat = readLine.concat("\r\n");
                                        forName = Charset.forName("UTF-8");
                                    }
                                    bytes = concat.getBytes(forName);
                                }
                                fileOutputStream.write(bytes, 0, bytes.length);
                            }
                            if (z) {
                                fileOutputStream.write("#EXT-X-ENDLIST".concat("\r\n").getBytes(Charset.forName("UTF-8")));
                            }
                            fileOutputStream.flush();
                            try {
                                fileInputStream2.close();
                                fileOutputStream.close();
                                if (file.exists()) {
                                    FileUtil.deleteFile(file);
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            return true;
                        } catch (FileNotFoundException e2) {
                            e = e2;
                            fileInputStream = fileInputStream2;
                            e.printStackTrace();
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            if (file.exists()) {
                                FileUtil.deleteFile(file);
                            }
                            return false;
                        } catch (IOException e3) {
                            e = e3;
                            fileInputStream = fileInputStream2;
                            e.printStackTrace();
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            if (file.exists()) {
                                FileUtil.deleteFile(file);
                            }
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                    throw th;
                                }
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            if (file.exists()) {
                                FileUtil.deleteFile(file);
                            }
                            throw th;
                        }
                    } catch (FileNotFoundException e5) {
                        e = e5;
                        fileOutputStream = null;
                    } catch (IOException e6) {
                        e = e6;
                        fileOutputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (FileNotFoundException e7) {
                e = e7;
                fileOutputStream = null;
            } catch (IOException e8) {
                e = e8;
                fileOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
            }
        } catch (IOException e9) {
            e9.printStackTrace();
        }
    }

    public String getCacheDir() {
        String cacheDir = this.mM3U8Option.getCacheDir();
        if (TextUtils.isEmpty(cacheDir)) {
            cacheDir = FileUtil.getTsCacheDir(getEntity().getFilePath(), this.mM3U8Option.getBandWidth());
        }
        if (!new File(cacheDir).exists()) {
            FileUtil.createDir(cacheDir);
        }
        return cacheDir;
    }

    @Override // com.arialyy.aria.core.loader.ILoader
    public long getCurrentProgress() {
        return isRunning() ? mo4448getStateManager().getCurrentProgress() : getEntity().getCurrentProgress();
    }

    public DownloadEntity getEntity() {
        return ((DTaskWrapper) this.mTaskWrapper).mo4442getEntity();
    }
}
