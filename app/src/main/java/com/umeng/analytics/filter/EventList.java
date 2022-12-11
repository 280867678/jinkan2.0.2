package com.umeng.analytics.filter;

import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import me.tvspark.outline;

/* loaded from: classes4.dex */
public class EventList extends C1523c implements FileLockCallback {
    public static final int DELETE_LIST_DATA = 2;
    public static final int LOAD_LIST_DATA = 1;
    public static final int SAVE_LIST_DATA = 0;
    public Context mAppContext;
    public String mEventList;
    public String mEventListKey;
    public String mEventListName;
    public String mEventListVersionKey;
    public FileLockUtil mFileLock = new FileLockUtil();

    public EventList(String str, String str2) {
        this.mEventListName = str;
        this.mEventListKey = str;
        this.mEventListVersionKey = str2;
    }

    private void deleteDataFile(File file) {
        if (this.mAppContext != null) {
            synchronized (this.mFileLock) {
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    private boolean loadEventListFromFile(Context context, File file) {
        Throwable th;
        boolean z;
        String sb;
        if (file.exists() && TextUtils.isEmpty(this.mEventList)) {
            try {
                try {
                    z = new BufferedReader(new FileReader(file));
                } catch (Throwable th2) {
                    UMCrashManager.reportCrash(context, th2);
                }
                try {
                    StringBuilder sb2 = new StringBuilder();
                    while (true) {
                        String readLine = z.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb2.append(readLine);
                    }
                    sb = sb2.toString();
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        UMCrashManager.reportCrash(context, th);
                        if (z != null) {
                            z.close();
                        }
                        return false;
                    } finally {
                        if (z != null) {
                            try {
                                z.close();
                            } catch (Throwable th4) {
                                UMCrashManager.reportCrash(context, th4);
                            }
                        }
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                z = null;
            }
            if (!TextUtils.isEmpty(sb)) {
                String md5 = HelperUtils.getMD5(sb);
                String imprintProperty = UMEnvelopeBuild.imprintProperty(context, this.mEventListVersionKey, "");
                this.mEventList = sb;
                eventListChange();
                UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> loadEventListFromFile: mEventList = " + this.mEventList);
                if (!UMUtils.isMainProgress(context)) {
                    z = md5.equalsIgnoreCase(imprintProperty);
                    if (!z) {
                        return false;
                    }
                    this.mEventList = sb;
                    eventListChange();
                    try {
                        z.close();
                    } catch (Throwable th6) {
                        UMCrashManager.reportCrash(context, th6);
                    }
                    return true;
                } else if (!md5.equalsIgnoreCase(imprintProperty)) {
                    setMD5ClearFlag(true);
                    try {
                        z.close();
                    } catch (Throwable th7) {
                        UMCrashManager.reportCrash(context, th7);
                    }
                    return false;
                } else {
                    this.mEventList = sb;
                    setMD5ClearFlag(false);
                    try {
                        z.close();
                    } catch (Throwable th8) {
                        UMCrashManager.reportCrash(context, th8);
                    }
                    return true;
                }
            }
            z.close();
        }
        return false;
    }

    private void saveEventListToFile(Context context, File file) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(this.mEventList.getBytes());
            fileOutputStream.close();
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    public boolean enabled() {
        synchronized (this) {
            return this.mEventList != null;
        }
    }

    public void eventListChange() {
    }

    public boolean matchHit(String str) {
        return false;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(File file, int i) {
        String str;
        String str2;
        if (i == 0) {
            synchronized (this) {
                saveEventListToFile(this.mAppContext, file);
            }
        } else if (i == 1) {
            synchronized (this) {
                if (loadEventListFromFile(this.mAppContext, file)) {
                    str = UMRTLog.RTLOG_TAG;
                    str2 = "--->>> find event list data file, load it.";
                } else {
                    str = UMRTLog.RTLOG_TAG;
                    str2 = "--->>> can't find event list file.";
                }
                UMRTLog.m766i(str, str2);
            }
        } else if (i == 2) {
            synchronized (this) {
                this.mEventList = null;
                deleteDataFile(file);
            }
        }
        return true;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(String str) {
        return false;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(String str, Object obj) {
        return false;
    }

    @Override // com.umeng.analytics.filter.C1523c, com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
    public void onImprintValueChanged(String str, String str2) {
        if ("ekv_bl_ver".equals(str) && str2 == null) {
            UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> disable black list for ekv.");
            this.mFileLock.doFileOperateion(new File(this.mAppContext.getFilesDir(), this.mEventListName), this, 2);
        }
        if (!"ekv_wl_ver".equals(str) || str2 != null) {
            return;
        }
        UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> disable white list for ekv.");
        this.mFileLock.doFileOperateion(new File(this.mAppContext.getFilesDir(), this.mEventListName), this, 2);
    }

    @Override // com.umeng.analytics.filter.C1523c, com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback
    public boolean onPreProcessImprintKey(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return true;
        }
        int length = str2.length();
        UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> onPreProcessImprintKey: key = " + str + "; len of value=" + length);
        StringBuilder sb = new StringBuilder();
        sb.append("--->>> onPreProcessImprintKey: value = ");
        sb.append(str2);
        UMRTLog.m766i(UMRTLog.RTLOG_TAG, sb.toString());
        this.mEventList = str2;
        eventListChange();
        File file = new File(this.mAppContext.getFilesDir(), this.mEventListName);
        if (!file.exists()) {
            try {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    UMCrashManager.reportCrash(this.mAppContext, e);
                }
            } catch (IOException unused) {
                file.createNewFile();
            }
        }
        this.mFileLock.doFileOperateion(file, this, 0);
        setMD5ClearFlag(false);
        return true;
    }

    public void register(Context context) {
        if (this.mAppContext == null) {
            this.mAppContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        File file = new File(this.mAppContext.getFilesDir(), this.mEventListName);
        if (!TextUtils.isEmpty(UMEnvelopeBuild.imprintProperty(this.mAppContext, this.mEventListVersionKey, ""))) {
            if (file.exists()) {
                this.mFileLock.doFileOperateion(file, this, 1);
            } else {
                setMD5ClearFlag(true);
            }
        }
        if (UMUtils.isMainProgress(this.mAppContext)) {
            ImprintHandler.getImprintService(this.mAppContext).registPreProcessCallback(this.mEventListKey, this);
            ImprintHandler.getImprintService(this.mAppContext).registImprintCallback(this.mEventListVersionKey, this);
        }
    }

    public void setMD5ClearFlag(boolean z) {
    }

    public String toString() {
        if (TextUtils.isEmpty(this.mEventListName) || TextUtils.isEmpty(this.mEventListKey)) {
            return "Uninitialized EventList.";
        }
        StringBuilder sb = new StringBuilder("[");
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("EventListName:");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.mEventListName);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(",");
        sb.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        sb.append("listKey:" + this.mEventListKey + ",");
        sb.append(!TextUtils.isEmpty(this.mEventList) ? outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("listKeyValue:"), this.mEventList, "]") : "listKeyValue:empty,");
        sb.append(!TextUtils.isEmpty(this.mEventListVersionKey) ? outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("listKeyVer:"), this.mEventListVersionKey, "]") : "listKeyVer:empty]");
        return sb.toString();
    }
}
