package com.umeng.commonsdk.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* loaded from: classes4.dex */
public class FileLockUtil {
    public final Object lockObject = new Object();

    /* JADX WARN: Removed duplicated region for block: B:14:0x0022 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static FileLock getFileLock(String str) {
        FileChannel fileChannel;
        try {
        } catch (FileNotFoundException e) {
            e = e;
            fileChannel = null;
        } catch (IOException e2) {
            e = e2;
            fileChannel = null;
        }
        try {
            return new RandomAccessFile(str, "rw").getChannel().lock();
        } catch (FileNotFoundException e3) {
            e = e3;
            e.printStackTrace();
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            return null;
        } catch (IOException e5) {
            e = e5;
            e.printStackTrace();
            if (fileChannel != null) {
            }
            return null;
        }
    }

    public void doFileOperateion(File file, FileLockCallback fileLockCallback) {
        if (!file.exists()) {
            return;
        }
        synchronized (this.lockObject) {
            FileLock fileLock = getFileLock(file.getAbsolutePath());
            if (fileLock != null) {
                try {
                    fileLockCallback.onFileLock(file.getName());
                } catch (Exception e) {
                    e.printStackTrace();
                    try {
                        fileLock.release();
                        fileLock.channel().close();
                    } catch (IOException e2) {
                        e = e2;
                        e.printStackTrace();
                    }
                }
                try {
                    fileLock.release();
                    fileLock.channel().close();
                } catch (IOException e3) {
                    e = e3;
                    e.printStackTrace();
                }
            }
        }
    }

    public void doFileOperateion(File file, FileLockCallback fileLockCallback, int i) {
        if (!file.exists()) {
            return;
        }
        synchronized (this.lockObject) {
            FileLock fileLock = getFileLock(file.getAbsolutePath());
            if (fileLock != null) {
                try {
                    fileLockCallback.onFileLock(file, i);
                    try {
                        fileLock.release();
                        fileLock.channel().close();
                    } catch (Throwable th) {
                        th = th;
                        th.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    try {
                        fileLock.release();
                        fileLock.channel().close();
                    } catch (Throwable th2) {
                        th = th2;
                        th.printStackTrace();
                    }
                }
            }
        }
    }

    public void doFileOperateion(File file, FileLockCallback fileLockCallback, Object obj) {
        if (!file.exists()) {
            return;
        }
        synchronized (this.lockObject) {
            FileLock fileLock = getFileLock(file.getAbsolutePath());
            if (fileLock != null) {
                try {
                    fileLockCallback.onFileLock(file.getName(), obj);
                } catch (Exception e) {
                    e.printStackTrace();
                    try {
                        fileLock.release();
                        fileLock.channel().close();
                    } catch (IOException e2) {
                        e = e2;
                        e.printStackTrace();
                    }
                }
                try {
                    fileLock.release();
                    fileLock.channel().close();
                } catch (IOException e3) {
                    e = e3;
                    e.printStackTrace();
                }
            }
        }
    }

    public void doFileOperateion(String str, FileLockCallback fileLockCallback) {
        File file = new File(str);
        if (!file.exists()) {
            return;
        }
        synchronized (this.lockObject) {
            FileLock fileLock = getFileLock(str);
            if (fileLock != null) {
                try {
                    fileLockCallback.onFileLock(file.getName());
                    try {
                        fileLock.release();
                        fileLock.channel().close();
                    } catch (IOException e) {
                        e = e;
                        e.printStackTrace();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    try {
                        fileLock.release();
                        fileLock.channel().close();
                    } catch (IOException e3) {
                        e = e3;
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
