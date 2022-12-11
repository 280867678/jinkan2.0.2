package com.umeng.analytics.process;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.C1520c;
import com.umeng.analytics.pro.C1615d;
import com.umeng.analytics.pro.C1648o;
import com.umeng.analytics.pro.C1656r;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.noise.ABTest;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class UMProcessDBDatasSender implements UMLogDataProtocol {
    public static final int UM_PROCESS_CONSTRUCTMESSAGE = 36946;
    public static final int UM_PROCESS_EVENT_KEY = 36945;
    public static ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
    public static UMProcessDBDatasSender mInstance;
    public Context mContext;
    public List<Integer> mGeneralBodyIds;
    public FileLockUtil mLockUtil = new FileLockUtil();
    public C1648o.C1652c mPolicySelector;

    /* loaded from: classes4.dex */
    public class ConstructMessageCallback implements FileLockCallback {
        public ConstructMessageCallback() {
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(File file, int i) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str) {
            JSONObject buildEnvelopeWithExtHeader;
            UMProcessDBDatasSender uMProcessDBDatasSender = UMProcessDBDatasSender.this;
            JSONObject jSONObject = uMProcessDBDatasSender.setupReportData(UMEnvelopeBuild.maxDataSpace(uMProcessDBDatasSender.mContext));
            if (jSONObject != null && jSONObject.length() >= 1) {
                JSONObject jSONObject2 = (JSONObject) jSONObject.opt("header");
                JSONObject jSONObject3 = (JSONObject) jSONObject.opt("content");
                if (UMProcessDBDatasSender.this.mContext != null && jSONObject2 != null && jSONObject3 != null && (buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(UMProcessDBDatasSender.this.mContext, jSONObject2, jSONObject3)) != null) {
                    UMProcessDBDatasSender.this.removeCacheData(buildEnvelopeWithExtHeader);
                }
            }
            return true;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str, Object obj) {
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class ReplaceCallback implements FileLockCallback {
        public ReplaceCallback() {
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(File file, int i) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (str.startsWith(AbstractC1677a.f3686c)) {
                str = str.replaceFirst(AbstractC1677a.f3686c, "");
            }
            UMProcessDBHelper.getInstance(UMProcessDBDatasSender.this.mContext).deleteEventDatas(str.replace(".db", ""), null, null);
            return true;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str, Object obj) {
            return false;
        }
    }

    private void constructMessage() {
        if (defconProcesserHandler() != 0) {
            return;
        }
        this.mLockUtil.doFileOperateion(C1679b.m844b(this.mContext, ""), new ConstructMessageCallback());
    }

    private int defconProcesserHandler() {
        int m922a = C1656r.m923a().m922a(this.mContext);
        if (m922a != 0) {
            try {
                DBFileTraversalUtil.traverseDBFiles(C1679b.m847a(this.mContext), new ReplaceCallback(), null);
            } catch (Exception unused) {
            }
            UMProcessDBHelper.getInstance(this.mContext).deleteEventDatas(AbstractC1677a.f3691h, null, null);
        }
        return m922a;
    }

    private JSONObject generalBody() {
        JSONObject jSONObject = null;
        try {
            if (this.mGeneralBodyIds == null) {
                this.mGeneralBodyIds = new ArrayList();
            }
            jSONObject = UMProcessDBHelper.getInstance(this.mContext).readMainEvents(UMEnvelopeBuild.maxDataSpace(this.mContext) - 2000, this.mGeneralBodyIds);
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(this.mContext);
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString("userlevel", "");
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put("userlevel", string);
                }
            }
            String[] m1415a = C1520c.m1415a(this.mContext);
            if (m1415a != null && !TextUtils.isEmpty(m1415a[0]) && !TextUtils.isEmpty(m1415a[1])) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(C1615d.f3287M, m1415a[0]);
                jSONObject2.put(C1615d.f3288N, m1415a[1]);
                if (jSONObject2.length() > 0) {
                    jSONObject.put(C1615d.f3286L, jSONObject2);
                }
            }
            if (ABTest.getService(this.mContext).isInTest()) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(ABTest.getService(this.mContext).getTestName(), ABTest.getService(this.mContext).getGroupInfo());
                jSONObject.put(C1615d.f3285K, jSONObject3);
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private JSONObject generalHeader() {
        String str;
        JSONObject readVersionInfoFromColumId;
        JSONObject jSONObject = new JSONObject();
        try {
            if (AnalyticsConfig.mWrapperType != null && AnalyticsConfig.mWrapperVersion != null) {
                jSONObject.put("wrapper_version", AnalyticsConfig.mWrapperVersion);
                jSONObject.put("wrapper_type", AnalyticsConfig.mWrapperType);
            }
            jSONObject.put(C1615d.f3343i, AnalyticsConfig.getVerticalType(this.mContext));
            String str2 = "9.4.4";
            if (AnalyticsConfig.getVerticalType(this.mContext) == 1) {
                String gameSdkVersion = AnalyticsConfig.getGameSdkVersion(this.mContext);
                if (!TextUtils.isEmpty(gameSdkVersion)) {
                    str2 = gameSdkVersion;
                }
            }
            jSONObject.put("sdk_version", str2);
            String str3 = "";
            if (this.mGeneralBodyIds.size() <= 0 || (readVersionInfoFromColumId = UMProcessDBHelper.getInstance(this.mContext).readVersionInfoFromColumId(this.mGeneralBodyIds.get(0))) == null) {
                str = str3;
            } else {
                str3 = readVersionInfoFromColumId.optString("__av");
                str = readVersionInfoFromColumId.optString("__vc");
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = UMUtils.getAppVersionName(this.mContext);
            }
            jSONObject.put("app_version", str3);
            if (TextUtils.isEmpty(str)) {
                str = UMUtils.getAppVersionCode(this.mContext);
            }
            jSONObject.put("version_code", str);
            String MD5 = HelperUtils.MD5(AnalyticsConfig.getSecretKey(this.mContext));
            if (!TextUtils.isEmpty(MD5)) {
                jSONObject.put("secret", MD5);
            }
            String imprintProperty = UMEnvelopeBuild.imprintProperty(this.mContext, "pr_ve", null);
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(this.mContext);
            jSONObject.put(C1615d.f3346l, UMEnvelopeBuild.imprintProperty(this.mContext, "pr_ve", null));
            jSONObject.put(C1615d.f3347m, UMEnvelopeBuild.imprintProperty(this.mContext, "ud_da", null));
            jSONObject.put(C1615d.f3317ah, "1.0.0");
            if (TextUtils.isEmpty(imprintProperty)) {
                jSONObject.put(C1615d.f3346l, sharedPreferences.getString("vers_pre_version", "0"));
                jSONObject.put(C1615d.f3347m, sharedPreferences.getString("vers_date", new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()))));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public static UMProcessDBDatasSender getInstance(Context context) {
        if (mInstance == null) {
            synchronized (UMProcessDBDatasSender.class) {
                if (mInstance == null) {
                    mInstance = new UMProcessDBDatasSender();
                }
            }
        }
        UMProcessDBDatasSender uMProcessDBDatasSender = mInstance;
        uMProcessDBDatasSender.mContext = context;
        return uMProcessDBDatasSender;
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void removeCacheData(Object obj) {
        List<Integer> list;
        JSONObject optJSONObject;
        if (obj == null || (list = this.mGeneralBodyIds) == null || list.size() == 0) {
            return;
        }
        JSONObject jSONObject = (JSONObject) obj;
        if (!jSONObject.has("analytics") || (optJSONObject = jSONObject.optJSONObject("analytics")) == null || optJSONObject.length() <= 0 || !optJSONObject.has("ekv")) {
            return;
        }
        UMProcessDBHelper.getInstance(this.mContext).deleteMainProcessEventDatasByIds(this.mGeneralBodyIds);
        this.mGeneralBodyIds.clear();
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public JSONObject setupReportData(long j) {
        int m922a = C1656r.m923a().m922a(this.mContext);
        JSONObject generalBody = generalBody();
        if (generalBody.length() <= 0) {
            return null;
        }
        JSONObject generalHeader = generalHeader();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (m922a == 3) {
                jSONObject2.put("analytics", new JSONObject());
            } else if (generalBody.length() > 0) {
                jSONObject2.put("analytics", generalBody);
            }
            if (generalHeader != null && generalHeader.length() > 0) {
                jSONObject.put("header", generalHeader);
            }
            if (jSONObject2.length() > 0) {
                if (jSONObject2.has("analytics")) {
                    JSONObject optJSONObject = jSONObject2.optJSONObject("analytics");
                    if (optJSONObject.length() == 1 && (optJSONObject.optJSONObject(C1615d.f3286L) != null || !TextUtils.isEmpty(optJSONObject.optString("userlevel")))) {
                        return null;
                    }
                    if (optJSONObject.length() == 2 && optJSONObject.optJSONObject(C1615d.f3286L) != null && !TextUtils.isEmpty(optJSONObject.optString("userlevel"))) {
                        return null;
                    }
                }
                jSONObject.put("content", jSONObject2);
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void workEvent(Object obj, int i) {
        if (!UMUtils.isMainProgress(this.mContext)) {
            return;
        }
        switch (i) {
            case 36945:
                executor.schedule(new Runnable() { // from class: com.umeng.analytics.process.UMProcessDBDatasSender.1
                    @Override // java.lang.Runnable
                    public void run() {
                        UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> call processDBToMain start.");
                        UMProcessDBHelper.getInstance(UMProcessDBDatasSender.this.mContext).processDBToMain();
                    }
                }, 5L, TimeUnit.SECONDS);
                return;
            case UM_PROCESS_CONSTRUCTMESSAGE /* 36946 */:
                UMRTLog.m766i(UMRTLog.RTLOG_TAG, "--->>> recv UM_PROCESS_CONSTRUCTMESSAGE msg.");
                constructMessage();
                return;
            default:
                return;
        }
    }
}
