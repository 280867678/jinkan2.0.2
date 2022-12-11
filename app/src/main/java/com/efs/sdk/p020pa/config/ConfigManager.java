package com.efs.sdk.p020pa.config;

import android.content.Context;
import android.content.SharedPreferences;
import com.efs.sdk.base.newsharedpreferences.SharedPreferencesUtils;
import com.efs.sdk.base.observer.IConfigCallback;
import java.util.Map;
import java.util.Random;

/* renamed from: com.efs.sdk.pa.config.ConfigManager */
/* loaded from: classes3.dex */
public class ConfigManager {
    public static final int A_DAY = 86400000;
    public static final String FLAG_PA_CHECK_IN_STATE = "8f2f54c08600aa25915617fa1371441b";
    public static final String FLAG_PA_FORE_CHECK_TIME = "03f870871950c148387b251894ed3e88";
    public static final int MAX_ANR_STATS_COUNT = 50;
    public static final int MAX_ANR_TRACE_RATE = 100;
    public static final String MODEL_SP = "paconfig";
    public static final String PA_LEVEL = "pa_level";
    public static final String STATS_ANR_LOG_COUNT = "apm_anr_count";
    public boolean mCheckIn;
    public int mCurrentRate;
    public IEfsReporter mEfsReporter;
    public int mLastRate;
    public PackageLevel mPackageLevel;
    public SharedPreferences mSharedPreferences;
    public final String TAG = "WpkPaConfig";
    public final String APM_PATRACE_SWITCH_RATE_LAST = "apm_patrace_switch_rate_last";
    public final String APM_PATRACE_SWITCH_RATE_CURRENT = "apm_patrace_switch_rate";
    public final int DEF_CLOSE_RATE = 0;

    public ConfigManager(Context context, PackageLevel packageLevel, IEfsReporter iEfsReporter, boolean z) {
        boolean z2 = false;
        this.mCheckIn = false;
        this.mPackageLevel = packageLevel;
        this.mEfsReporter = iEfsReporter;
        this.mSharedPreferences = SharedPreferencesUtils.getSharedPreferences(context, MODEL_SP);
        initRate();
        if (z) {
            resetUploadSmoothLogCnt();
            z2 = enableAnrTracer();
        } else if (isCountEnable() && enableAnrTracer()) {
            z2 = true;
        }
        this.mCheckIn = z2;
        resetRate();
    }

    private boolean checkIn(boolean z, Long l, boolean z2, int i) {
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        Long valueOf2 = Long.valueOf(valueOf.longValue() - l.longValue());
        boolean z3 = true;
        if (!z2 || valueOf2.longValue() >= 86400000 || z) {
            if (valueOf2.longValue() < 86400000 && !z) {
                return false;
            }
            if (!random(i)) {
                z3 = false;
            }
            putBooleanValue(FLAG_PA_CHECK_IN_STATE, z3);
            putLongValue(FLAG_PA_FORE_CHECK_TIME, valueOf.longValue());
            return z3;
        }
        return true;
    }

    private boolean enableAnrTracer() {
        long j = this.mSharedPreferences.getLong(FLAG_PA_FORE_CHECK_TIME, 0L);
        boolean z = false;
        boolean z2 = this.mSharedPreferences.getBoolean(FLAG_PA_CHECK_IN_STATE, false);
        int i = this.mCurrentRate;
        if (i != 0) {
            if (i != this.mLastRate) {
                z = true;
            }
            return checkIn(z, Long.valueOf(j), z2, this.mCurrentRate);
        }
        if (z2) {
            putBooleanValue(FLAG_PA_CHECK_IN_STATE, false);
        }
        if (j != 0) {
            putLongValue(FLAG_PA_FORE_CHECK_TIME, 0L);
        }
        return false;
    }

    private int getCurrentConfigRate() {
        int i = this.mSharedPreferences.getInt("apm_patrace_switch_rate", -1);
        this.mEfsReporter.getReporter().getAllSdkConfig(new String[]{"apm_patrace_switch_rate"}, new IConfigCallback() { // from class: com.efs.sdk.pa.config.ConfigManager.1
            @Override // com.efs.sdk.base.observer.IConfigCallback
            public final void onChange(Map<String, Object> map) {
                Object obj = map.get("apm_patrace_switch_rate");
                if (obj != null) {
                    try {
                        ConfigManager.this.putIntValue("apm_patrace_switch_rate", Integer.parseInt(obj.toString()));
                    } catch (Throwable unused) {
                    }
                }
            }
        });
        return i;
    }

    private void initRate() {
        this.mLastRate = this.mSharedPreferences.getInt("apm_patrace_switch_rate_last", 0);
        int currentConfigRate = getCurrentConfigRate();
        if (currentConfigRate != -1) {
            this.mCurrentRate = currentConfigRate;
        } else if (this.mPackageLevel == PackageLevel.TRIAL) {
            this.mCurrentRate = 100;
        } else {
            this.mCurrentRate = 0;
        }
    }

    private boolean isCountEnable() {
        return this.mSharedPreferences.getLong(STATS_ANR_LOG_COUNT, 0L) <= 50;
    }

    private void putBooleanValue(String str, boolean z) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void putIntValue(String str, int i) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putInt(str, i);
        edit.apply();
    }

    private void putLongValue(String str, long j) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putLong(str, j);
        edit.apply();
    }

    private boolean random(int i) {
        if (i == 0) {
            return false;
        }
        return i == 100 || new Random().nextInt(100) <= i;
    }

    private void resetRate() {
        putIntValue("apm_patrace_switch_rate_last", this.mCurrentRate);
    }

    private void resetUploadSmoothLogCnt() {
        putLongValue(STATS_ANR_LOG_COUNT, 0L);
    }

    public boolean enableTracer() {
        return this.mCheckIn;
    }

    public void increaseUploadSmoothLogCnt() {
        putLongValue(STATS_ANR_LOG_COUNT, this.mSharedPreferences.getLong(STATS_ANR_LOG_COUNT, 0L) + 1);
    }
}
