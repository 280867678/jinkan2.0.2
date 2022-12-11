package com.umeng.commonsdk.debug;

import android.os.Bundle;
import android.text.TextUtils;
import com.umeng.commonsdk.UMConfigure;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class UMLog {

    /* renamed from: AQ */
    public static final String f3863AQ = "├───────────────────解决方案─────────────────────────────────────────────────────────────────────────────";
    public static final String BOTTOM_BORDER = "└────────────────────────────────────────────────────────────────────────────────────────────────────────────────";
    public static final char BOTTOM_LEFT_CORNER = 9492;
    public static final String DOUBLE_DIVIDER = "────────────────────────────────────────────────────────";
    public static final String DOUBLE_DIVIDER_AQ = "───────────────────问题─────────────────────";
    public static final char HORIZONTAL_LINE = 9474;
    public static final String INDENT = "     ";
    public static final int JSON_INDENT = 2;
    public static final int KEYLENGTH = 10;
    public static final String MIDDLE_BORDER = "├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄";
    public static final char MIDDLE_CORNER = 9500;
    public static final String SINGLE_DIVIDER = "┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄";
    public static final String SINGLE_DIVIDER_AQ = "───────────────────解决方案─────────────────────";
    public static final String TAG = "UMLog";
    public static final String TOP_BORDER = "┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────";
    public static final String TOP_BORDER_AQ = "┌───────────────────问题─────────────────────────────────────────────────────────────────────────────";
    public static final char TOP_LEFT_CORNER = 9484;

    /* renamed from: aq */
    public static void m774aq(int i, String str, String str2) {
        try {
            if (!UMConfigure.isDebugLog()) {
                return;
            }
            UInterface logger = getLogger(i);
            logger.log(TAG, TOP_BORDER_AQ);
            logger.log(TAG, "│     " + str);
            logger.log(TAG, f3863AQ);
            logger.log(TAG, "│     " + str2);
            logger.log(TAG, BOTTOM_BORDER);
        } catch (Exception unused) {
        }
    }

    /* renamed from: aq */
    public static void m773aq(String str, int i, String str2) {
        m770aq((String) null, str, i, str2);
    }

    /* renamed from: aq */
    public static void m772aq(String str, int i, String str2, String str3) {
        try {
            if (!UMConfigure.isDebugLog()) {
                return;
            }
            UInterface logger = getLogger(i);
            String str4 = "UMLog_" + str;
            logger.log(str4, TOP_BORDER_AQ);
            logger.log(str4, "│     " + str2);
            logger.log(str4, f3863AQ);
            logger.log(str4, "│     " + str3);
            logger.log(str4, BOTTOM_BORDER);
        } catch (Exception unused) {
        }
    }

    /* renamed from: aq */
    public static void m771aq(String str, int i, String str2, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4) {
        m769aq(null, str, i, str2, strArr, strArr2, strArr3, strArr4);
    }

    /* renamed from: aq */
    public static void m770aq(String str, String str2, int i, String str3) {
        m769aq(str, str2, i, str3, null, null, null, null);
    }

    /* renamed from: aq */
    public static void m769aq(String str, String str2, int i, String str3, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4) {
        String[] split;
        try {
            if (!UMConfigure.isDebugLog()) {
                return;
            }
            String str4 = TextUtils.isEmpty(str) ? TAG : "UMLog_" + str;
            if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || (split = str2.split(str3)) == null || split.length < 2) {
                return;
            }
            if (strArr != null && strArr.length > 0 && strArr2 != null && strArr2.length > 0) {
                for (int i2 = 0; i2 < strArr.length && i2 < strArr2.length; i2++) {
                    split[0] = split[0].replace(strArr[i2], strArr2[i2]);
                }
            }
            if (strArr3 != null && strArr3.length > 0 && strArr4 != null && strArr4.length > 0) {
                for (int i3 = 0; i3 < strArr3.length && i3 < strArr4.length; i3++) {
                    split[1] = split[1].replace(strArr3[i3], strArr4[i3]);
                }
            }
            UInterface logger = getLogger(i);
            logger.log(str4, TOP_BORDER_AQ);
            logger.log(str4, "│     " + split[0]);
            logger.log(str4, f3863AQ);
            logger.log(str4, "│     " + split[1]);
            logger.log(str4, BOTTOM_BORDER);
        } catch (Exception unused) {
        }
    }

    public static void bundle(int i, Bundle bundle) {
        bundle(null, i, bundle);
    }

    public static void bundle(String str, int i, Bundle bundle) {
        try {
            if (!UMConfigure.isDebugLog()) {
                return;
            }
            String str2 = TextUtils.isEmpty(str) ? TAG : "UMLog_" + str;
            if (bundle == null) {
                return;
            }
            UInterface logger = getLogger(i);
            logger.log(str2, TOP_BORDER);
            logger.log(str2, "│key│value");
            logger.log(str2, MIDDLE_BORDER);
            for (String str3 : bundle.keySet()) {
                if (!TextUtils.isEmpty(str3) && bundle.get(str3) != null) {
                    logger.log(str2, HORIZONTAL_LINE + str3 + HORIZONTAL_LINE + bundle.get(str3).toString());
                    logger.log(str2, MIDDLE_BORDER);
                }
            }
            logger.log(str2, BOTTOM_BORDER);
        } catch (Exception unused) {
        }
    }

    public static UInterface getLogger(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? new C1713D() : new C1713D() : new C1715I() : new C1716W() : new C1714E();
    }

    public static void jsonArry(String str, JSONArray jSONArray) {
        try {
            if (!UMConfigure.isDebugLog()) {
                return;
            }
            jSONArray.toString(2);
        } catch (Exception unused) {
        }
    }

    public static void jsonArry(JSONArray jSONArray) {
        try {
            if (!UMConfigure.isDebugLog()) {
                return;
            }
            jSONArray.toString(2);
        } catch (Exception unused) {
        }
    }

    public static void jsonObject(String str, JSONObject jSONObject) {
        try {
            if (!UMConfigure.isDebugLog()) {
                return;
            }
            jSONObject.toString(2);
        } catch (Exception unused) {
        }
    }

    public static void jsonObject(JSONObject jSONObject) {
        try {
            if (!UMConfigure.isDebugLog()) {
                return;
            }
            jSONObject.toString(2);
        } catch (Exception unused) {
        }
    }

    public static void mutlInfo(int i, String... strArr) {
        String str;
        try {
            if (!UMConfigure.isDebugLog()) {
                return;
            }
            int length = strArr.length;
            UInterface logger = getLogger(i);
            if (length == 1) {
                str = strArr[0];
            } else if (length < 2) {
                return;
            } else {
                logger.log(TAG, TOP_BORDER);
                for (int i2 = 0; i2 < length; i2++) {
                    logger.log(TAG, "│     " + strArr[i2]);
                    if (i2 != length - 1) {
                        logger.log(TAG, MIDDLE_BORDER);
                    }
                }
                str = BOTTOM_BORDER;
            }
            logger.log(TAG, str);
        } catch (Exception unused) {
        }
    }

    public static void mutlInfo(String str, int i, String str2) {
        mutlInfo(null, str, i, str2);
    }

    public static void mutlInfo(String str, int i, String str2, String[] strArr, String[] strArr2) {
        mutlInfo(null, str, i, str2, strArr, strArr2);
    }

    public static void mutlInfo(String str, int i, String... strArr) {
        String str2;
        try {
            if (!UMConfigure.isDebugLog()) {
                return;
            }
            int length = strArr.length;
            UInterface logger = getLogger(i);
            String str3 = "UMLog_" + str;
            if (length == 1) {
                str2 = strArr[0];
            } else if (length < 2) {
                return;
            } else {
                logger.log(str3, TOP_BORDER);
                for (int i2 = 0; i2 < length; i2++) {
                    logger.log(str3, "│     " + strArr[i2]);
                    if (i2 != length - 1) {
                        logger.log(str3, MIDDLE_BORDER);
                    }
                }
                str2 = BOTTOM_BORDER;
            }
            logger.log(str3, str2);
        } catch (Exception unused) {
        }
    }

    public static void mutlInfo(String str, String str2, int i, String str3) {
        mutlInfo(str, str2, i, str3, null, null);
    }

    public static void mutlInfo(String str, String str2, int i, String str3, String[] strArr, String[] strArr2) {
        try {
            if (!UMConfigure.isDebugLog()) {
                return;
            }
            String str4 = TextUtils.isEmpty(str) ? TAG : "UMLog_" + str;
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            if (strArr != null && strArr.length > 0 && strArr2 != null && strArr2.length > 0) {
                for (int i2 = 0; i2 < strArr.length && i2 < strArr2.length; i2++) {
                    str2 = str2.replace(strArr[i2], strArr2[i2]);
                }
            }
            UInterface logger = getLogger(i);
            if (!TextUtils.isEmpty(str3)) {
                String[] split = str2.split(str3);
                if (split == null) {
                    return;
                }
                logger.log(str4, TOP_BORDER);
                for (int i3 = 0; i3 < split.length; i3++) {
                    logger.log(str4, "│     " + split[i3]);
                    if (i3 != split.length - 1) {
                        logger.log(str4, MIDDLE_BORDER);
                    }
                }
                str2 = BOTTOM_BORDER;
            }
            logger.log(str4, str2);
        } catch (Exception unused) {
        }
    }
}
