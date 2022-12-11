package com.tencent.bugly.beta.tinker;

import com.tencent.tinker.lib.util.TinkerLog;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import me.tvspark.outline;
import org.eclipse.jetty.server.AsyncContinuation;

/* loaded from: classes3.dex */
public class TinkerReport {
    public static final int KEY_APPLIED = 5;
    public static final int KEY_APPLIED_DEXOPT_EXIST = 122;
    public static final int KEY_APPLIED_DEXOPT_FORMAT = 123;
    public static final int KEY_APPLIED_DEXOPT_OTHER = 121;
    public static final int KEY_APPLIED_DEX_EXTRACT = 182;
    public static final int KEY_APPLIED_EXCEPTION = 120;
    public static final int KEY_APPLIED_FAIL_COST_10S_LESS = 206;
    public static final int KEY_APPLIED_FAIL_COST_30S_LESS = 207;
    public static final int KEY_APPLIED_FAIL_COST_5S_LESS = 205;
    public static final int KEY_APPLIED_FAIL_COST_60S_LESS = 208;
    public static final int KEY_APPLIED_FAIL_COST_OTHER = 209;
    public static final int KEY_APPLIED_INFO_CORRUPTED = 124;
    public static final int KEY_APPLIED_LIB_EXTRACT = 183;
    public static final int KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND = 153;
    public static final int KEY_APPLIED_PACKAGE_CHECK_DEX_META = 151;
    public static final int KEY_APPLIED_PACKAGE_CHECK_LIB_META = 152;
    public static final int KEY_APPLIED_PACKAGE_CHECK_META_NOT_FOUND = 155;
    public static final int KEY_APPLIED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND = 154;
    public static final int KEY_APPLIED_PACKAGE_CHECK_RES_META = 157;
    public static final int KEY_APPLIED_PACKAGE_CHECK_SIGNATURE = 150;
    public static final int KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT = 158;
    public static final int KEY_APPLIED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL = 156;
    public static final int KEY_APPLIED_PATCH_FILE_EXTRACT = 181;
    public static final int KEY_APPLIED_RESOURCE_EXTRACT = 184;
    public static final int KEY_APPLIED_START = 4;
    public static final int KEY_APPLIED_SUCC_COST_10S_LESS = 201;
    public static final int KEY_APPLIED_SUCC_COST_30S_LESS = 202;
    public static final int KEY_APPLIED_SUCC_COST_5S_LESS = 200;
    public static final int KEY_APPLIED_SUCC_COST_60S_LESS = 203;
    public static final int KEY_APPLIED_SUCC_COST_OTHER = 204;
    public static final int KEY_APPLIED_UPGRADE = 100;
    public static final int KEY_APPLIED_UPGRADE_FAIL = 101;
    public static final int KEY_APPLIED_VERSION_CHECK = 180;
    public static final int KEY_APPLY_WITH_RETRY = 10;
    public static final int KEY_CRASH_CAUSE_XPOSED_ART = 9;
    public static final int KEY_CRASH_CAUSE_XPOSED_DALVIK = 8;
    public static final int KEY_CRASH_FAST_PROTECT = 7;
    public static final int KEY_DOWNLOAD = 1;
    public static final int KEY_LOADED = 6;
    public static final int KEY_LOADED_EXCEPTION_DEX = 252;
    public static final int KEY_LOADED_EXCEPTION_DEX_CHECK = 253;
    public static final int KEY_LOADED_EXCEPTION_RESOURCE = 254;
    public static final int KEY_LOADED_EXCEPTION_RESOURCE_CHECK = 255;
    public static final int KEY_LOADED_INFO_CORRUPTED = 309;
    public static final int KEY_LOADED_INTERPRET_GET_INSTRUCTION_SET_ERROR = 450;
    public static final int KEY_LOADED_INTERPRET_INTERPRET_COMMAND_ERROR = 451;
    public static final int KEY_LOADED_INTERPRET_TYPE_INTERPRET_OK = 452;
    public static final int KEY_LOADED_MISMATCH_DEX = 300;
    public static final int KEY_LOADED_MISMATCH_LIB = 301;
    public static final int KEY_LOADED_MISMATCH_RESOURCE = 302;
    public static final int KEY_LOADED_MISSING_DEX = 303;
    public static final int KEY_LOADED_MISSING_DEX_OPT = 307;
    public static final int KEY_LOADED_MISSING_LIB = 304;
    public static final int KEY_LOADED_MISSING_PATCH_FILE = 305;
    public static final int KEY_LOADED_MISSING_PATCH_INFO = 306;
    public static final int KEY_LOADED_MISSING_RES = 308;
    public static final int KEY_LOADED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND = 353;
    public static final int KEY_LOADED_PACKAGE_CHECK_DEX_META = 351;
    public static final int KEY_LOADED_PACKAGE_CHECK_LIB_META = 352;
    public static final int KEY_LOADED_PACKAGE_CHECK_PACKAGE_META_NOT_FOUND = 356;
    public static final int KEY_LOADED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND = 354;
    public static final int KEY_LOADED_PACKAGE_CHECK_RES_META = 357;
    public static final int KEY_LOADED_PACKAGE_CHECK_SIGNATURE = 350;
    public static final int KEY_LOADED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT = 358;
    public static final int KEY_LOADED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL = 355;
    public static final int KEY_LOADED_SUCC_COST_1000_LESS = 401;
    public static final int KEY_LOADED_SUCC_COST_3000_LESS = 402;
    public static final int KEY_LOADED_SUCC_COST_5000_LESS = 403;
    public static final int KEY_LOADED_SUCC_COST_500_LESS = 400;
    public static final int KEY_LOADED_SUCC_COST_OTHER = 404;
    public static final int KEY_LOADED_UNCAUGHT_EXCEPTION = 251;
    public static final int KEY_LOADED_UNKNOWN_EXCEPTION = 250;
    public static final int KEY_REQUEST = 0;
    public static final int KEY_TRY_APPLY = 2;
    public static final int KEY_TRY_APPLY_ALREADY_APPLY = 77;
    public static final int KEY_TRY_APPLY_CONDITION_NOT_SATISFIED = 80;
    public static final int KEY_TRY_APPLY_CRASH_LIMIT = 79;
    public static final int KEY_TRY_APPLY_DISABLE = 71;
    public static final int KEY_TRY_APPLY_GOOGLEPLAY = 75;
    public static final int KEY_TRY_APPLY_INSERVICE = 73;
    public static final int KEY_TRY_APPLY_JIT = 81;
    public static final int KEY_TRY_APPLY_MEMORY_LIMIT = 78;
    public static final int KEY_TRY_APPLY_NOT_EXIST = 74;
    public static final int KEY_TRY_APPLY_ROM_SPACE = 76;
    public static final int KEY_TRY_APPLY_RUNNING = 72;
    public static final int KEY_TRY_APPLY_SUCCESS = 3;
    public static final int KEY_TRY_APPLY_UPGRADE = 70;
    public static final String TAG = "Tinker.TinkerReport";
    public static Reporter reporter;

    /* loaded from: classes3.dex */
    public interface Reporter {
        void onReport(int i);

        void onReport(String str);
    }

    public static void onApplied(long j, boolean z) {
        Reporter reporter2;
        int i;
        Reporter reporter3 = reporter;
        if (reporter3 == null) {
            return;
        }
        if (z) {
            reporter3.onReport(5);
        }
        reporter.onReport(z ? 100 : 101);
        TinkerLog.i(TAG, "hp_report report apply cost = %d", new Object[]{Long.valueOf(j)});
        if (j < 0) {
            TinkerLog.e(TAG, "hp_report report apply cost failed, invalid cost", new Object[0]);
            return;
        }
        if (j <= 5000) {
            reporter2 = reporter;
            i = z ? 200 : 205;
        } else if (j <= 10000) {
            reporter2 = reporter;
            i = z ? 201 : 206;
        } else if (j <= AsyncContinuation.DEFAULT_TIMEOUT) {
            reporter2 = reporter;
            i = z ? 202 : 207;
        } else {
            int i2 = (j > 60000L ? 1 : (j == 60000L ? 0 : -1));
            reporter2 = reporter;
            i = i2 <= 0 ? z ? 203 : 208 : z ? 204 : 209;
        }
        reporter2.onReport(i);
    }

    public static void onApplyCrash(Throwable th) {
        Reporter reporter2 = reporter;
        if (reporter2 == null) {
            return;
        }
        reporter2.onReport(120);
        Reporter reporter3 = reporter;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Tinker Exception:apply tinker occur exception ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(TinkerUtils.getExceptionCauseString(th));
        reporter3.onReport(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    public static void onApplyDexOptFail(Throwable th) {
        Reporter reporter2;
        int i;
        if (reporter == null) {
            return;
        }
        if (th.getMessage().contains("checkDexOptExist failed")) {
            reporter2 = reporter;
            i = 122;
        } else if (!th.getMessage().contains("checkDexOptFormat failed")) {
            reporter.onReport(121);
            Reporter reporter3 = reporter;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Tinker Exception:apply tinker occur exception ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(TinkerUtils.getExceptionCauseString(th));
            reporter3.onReport(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            return;
        } else {
            reporter2 = reporter;
            i = 123;
        }
        reporter2.onReport(i);
    }

    public static void onApplyExtractFail(int i) {
        int i2;
        Reporter reporter2 = reporter;
        if (reporter2 == null) {
            return;
        }
        if (i == 1) {
            i2 = 181;
        } else if (i == 3) {
            i2 = 182;
        } else if (i == 5) {
            i2 = 183;
        } else if (i != 6) {
            return;
        } else {
            i2 = 184;
        }
        reporter2.onReport(i2);
    }

    public static void onApplyInfoCorrupted() {
        Reporter reporter2 = reporter;
        if (reporter2 == null) {
            return;
        }
        reporter2.onReport(124);
    }

    public static void onApplyPackageCheckFail(int i) {
        Reporter reporter2;
        int i2;
        if (reporter == null) {
            return;
        }
        TinkerLog.i(TAG, "hp_report package check failed, error = %d", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case -9:
                reporter2 = reporter;
                i2 = 158;
                break;
            case -8:
                reporter2 = reporter;
                i2 = 157;
                break;
            case -7:
                reporter2 = reporter;
                i2 = 156;
                break;
            case -6:
                reporter2 = reporter;
                i2 = 154;
                break;
            case -5:
                reporter2 = reporter;
                i2 = 153;
                break;
            case -4:
                reporter2 = reporter;
                i2 = 152;
                break;
            case -3:
                reporter2 = reporter;
                i2 = 151;
                break;
            case -2:
                reporter2 = reporter;
                i2 = 155;
                break;
            case -1:
                reporter2 = reporter;
                i2 = 150;
                break;
            default:
                return;
        }
        reporter2.onReport(i2);
    }

    public static void onApplyPatchServiceStart() {
        Reporter reporter2 = reporter;
        if (reporter2 == null) {
            return;
        }
        reporter2.onReport(4);
    }

    public static void onApplyVersionCheckFail() {
        Reporter reporter2 = reporter;
        if (reporter2 == null) {
            return;
        }
        reporter2.onReport(180);
    }

    public static void onFastCrashProtect() {
        Reporter reporter2 = reporter;
        if (reporter2 == null) {
            return;
        }
        reporter2.onReport(7);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void onLoadException(Throwable th, int i) {
        int i2;
        Reporter reporter2 = reporter;
        if (reporter2 == null) {
            return;
        }
        boolean z = true;
        if (i == -4) {
            i2 = KEY_LOADED_UNCAUGHT_EXCEPTION;
        } else if (i != -3) {
            if (i != -2) {
                if (i == -1) {
                    i2 = 250;
                }
            } else if (th.getMessage().contains("checkDexInstall failed")) {
                reporter.onReport(KEY_LOADED_EXCEPTION_DEX_CHECK);
                TinkerLog.e(TAG, "tinker dex check fail:" + th.getMessage(), new Object[0]);
                if (z) {
                    return;
                }
                Reporter reporter3 = reporter;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Tinker Exception:load tinker occur exception ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(TinkerUtils.getExceptionCauseString(th));
                reporter3.onReport(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                return;
            } else {
                reporter.onReport(KEY_LOADED_EXCEPTION_DEX);
                TinkerLog.e(TAG, "tinker dex reflect fail:" + th.getMessage(), new Object[0]);
            }
            z = false;
            if (z) {
            }
        } else if (th.getMessage().contains("checkResInstall failed")) {
            reporter.onReport(255);
            TinkerLog.e(TAG, "tinker res check fail:" + th.getMessage(), new Object[0]);
            if (z) {
            }
        } else {
            reporter.onReport(KEY_LOADED_EXCEPTION_RESOURCE);
            TinkerLog.e(TAG, "tinker res reflect fail:" + th.getMessage(), new Object[0]);
            z = false;
            if (z) {
            }
        }
        reporter2.onReport(i2);
        z = false;
        if (z) {
        }
    }

    public static void onLoadFileMisMatch(int i) {
        int i2;
        Reporter reporter2 = reporter;
        if (reporter2 == null) {
            return;
        }
        if (i == 3) {
            i2 = 300;
        } else if (i == 5) {
            i2 = 301;
        } else if (i != 6) {
            return;
        } else {
            i2 = 302;
        }
        reporter2.onReport(i2);
    }

    public static void onLoadFileNotFound(int i) {
        int i2;
        Reporter reporter2 = reporter;
        if (reporter2 == null) {
            return;
        }
        switch (i) {
            case 1:
                i2 = 305;
                break;
            case 2:
                i2 = 306;
                break;
            case 3:
                i2 = 303;
                break;
            case 4:
                i2 = 307;
                break;
            case 5:
                i2 = 304;
                break;
            case 6:
                i2 = 308;
                break;
            default:
                return;
        }
        reporter2.onReport(i2);
    }

    public static void onLoadInfoCorrupted() {
        Reporter reporter2 = reporter;
        if (reporter2 == null) {
            return;
        }
        reporter2.onReport(KEY_LOADED_INFO_CORRUPTED);
    }

    public static void onLoadInterpretReport(int i, Throwable th) {
        Reporter reporter2;
        StringBuilder sb;
        Reporter reporter3 = reporter;
        if (reporter3 == null) {
            return;
        }
        if (i == 0) {
            reporter3.onReport(KEY_LOADED_INTERPRET_TYPE_INTERPRET_OK);
            return;
        }
        if (i == 1) {
            reporter3.onReport(450);
            reporter2 = reporter;
            sb = new StringBuilder();
        } else if (i != 2) {
            return;
        } else {
            reporter3.onReport(KEY_LOADED_INTERPRET_INTERPRET_COMMAND_ERROR);
            reporter2 = reporter;
            sb = new StringBuilder();
        }
        sb.append("Tinker Exception:interpret occur exception ");
        sb.append(TinkerUtils.getExceptionCauseString(th));
        reporter2.onReport(sb.toString());
    }

    public static void onLoadPackageCheckFail(int i) {
        int i2;
        Reporter reporter2 = reporter;
        if (reporter2 == null) {
            return;
        }
        switch (i) {
            case -9:
                i2 = KEY_LOADED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT;
                break;
            case -8:
                i2 = KEY_LOADED_PACKAGE_CHECK_RES_META;
                break;
            case -7:
                i2 = KEY_LOADED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL;
                break;
            case -6:
                i2 = KEY_LOADED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND;
                break;
            case -5:
                i2 = KEY_LOADED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND;
                break;
            case -4:
                i2 = KEY_LOADED_PACKAGE_CHECK_LIB_META;
                break;
            case -3:
                i2 = KEY_LOADED_PACKAGE_CHECK_DEX_META;
                break;
            case -2:
                i2 = KEY_LOADED_PACKAGE_CHECK_PACKAGE_META_NOT_FOUND;
                break;
            case -1:
                i2 = KEY_LOADED_PACKAGE_CHECK_SIGNATURE;
                break;
            default:
                return;
        }
        reporter2.onReport(i2);
    }

    public static void onLoaded(long j) {
        Reporter reporter2;
        int i;
        Reporter reporter3 = reporter;
        if (reporter3 == null) {
            return;
        }
        reporter3.onReport(6);
        if (j < 0) {
            TinkerLog.e(TAG, "hp_report report load cost failed, invalid cost", new Object[0]);
            return;
        }
        if (j <= 500) {
            reporter2 = reporter;
            i = 400;
        } else if (j <= 1000) {
            reporter2 = reporter;
            i = 401;
        } else if (j <= 3000) {
            reporter2 = reporter;
            i = 402;
        } else {
            int i2 = (j > 5000L ? 1 : (j == 5000L ? 0 : -1));
            reporter2 = reporter;
            i = i2 <= 0 ? 403 : 404;
        }
        reporter2.onReport(i);
    }

    public static void onReportRetryPatch() {
        Reporter reporter2 = reporter;
        if (reporter2 == null) {
            return;
        }
        reporter2.onReport(10);
    }

    public static void onTryApply(boolean z) {
        Reporter reporter2 = reporter;
        if (reporter2 == null) {
            return;
        }
        reporter2.onReport(2);
        reporter.onReport(70);
        if (!z) {
            return;
        }
        reporter.onReport(3);
    }

    public static void onTryApplyFail(int i) {
        int i2;
        Reporter reporter2 = reporter;
        if (reporter2 == null) {
            return;
        }
        switch (i) {
            case -24:
                i2 = 80;
                break;
            case -23:
                i2 = 79;
                break;
            case -22:
                i2 = 78;
                break;
            case -21:
                i2 = 76;
                break;
            case -20:
                i2 = 75;
                break;
            default:
                switch (i) {
                    case -6:
                        i2 = 77;
                        break;
                    case -5:
                        i2 = 81;
                        break;
                    case -4:
                        i2 = 73;
                        break;
                    case -3:
                        i2 = 72;
                        break;
                    case -2:
                        i2 = 74;
                        break;
                    case -1:
                        i2 = 71;
                        break;
                    default:
                        return;
                }
        }
        reporter2.onReport(i2);
    }

    public static void onXposedCrash() {
        Reporter reporter2;
        int i;
        if (reporter == null) {
            return;
        }
        if (ShareTinkerInternals.isVmArt()) {
            reporter2 = reporter;
            i = 9;
        } else {
            reporter2 = reporter;
            i = 8;
        }
        reporter2.onReport(i);
    }

    public void setReporter(Reporter reporter2) {
        reporter = reporter2;
    }
}
