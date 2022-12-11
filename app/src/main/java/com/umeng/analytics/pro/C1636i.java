package com.umeng.analytics.pro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.stub.StubApp;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.C1616e;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.C1847b;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.umeng.analytics.pro.i */
/* loaded from: classes4.dex */
public class C1636i {

    /* renamed from: a */
    public static final int f3436a = 2049;

    /* renamed from: b */
    public static final int f3437b = 2050;

    /* renamed from: c */
    public static final int f3438c = 1000;

    /* renamed from: d */
    public static Context f3439d = null;

    /* renamed from: e */
    public static String f3440e = null;

    /* renamed from: f */
    public static final String f3441f = "umeng+";

    /* renamed from: g */
    public static final String f3442g = "ek__id";

    /* renamed from: h */
    public static final String f3443h = "ek_key";

    /* renamed from: i */
    public List<String> f3444i;

    /* renamed from: j */
    public List<Integer> f3445j;

    /* renamed from: k */
    public String f3446k;

    /* renamed from: l */
    public List<String> f3447l;

    /* renamed from: com.umeng.analytics.pro.i$a */
    /* loaded from: classes4.dex */
    public enum EnumC1638a {
        AUTOPAGE,
        PAGE,
        BEGIN,
        END,
        NEWSESSION,
        INSTANTSESSIONBEGIN
    }

    /* renamed from: com.umeng.analytics.pro.i$b */
    /* loaded from: classes4.dex */
    public static class C1639b {

        /* renamed from: a */
        public static final C1636i f3455a = new C1636i();
    }

    public C1636i() {
        this.f3444i = new ArrayList();
        this.f3445j = new ArrayList();
        this.f3446k = null;
        this.f3447l = new ArrayList();
    }

    /* renamed from: a */
    private Cursor m1054a(String str, SQLiteDatabase sQLiteDatabase, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        if (sQLiteDatabase != null) {
            try {
                if (!sQLiteDatabase.isOpen()) {
                    return null;
                }
                return sQLiteDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static C1636i m1056a(Context context) {
        C1636i c1636i = C1639b.f3455a;
        if (f3439d == null && context != null) {
            f3439d = StubApp.getOrigApplicationContext(context.getApplicationContext());
            c1636i.m1024k();
        }
        return c1636i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x022a, code lost:
        if (r12 == null) goto L14;
     */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x023f: IF  (r12 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:131:0x0244, block:B:130:0x023f */
    /* JADX WARN: Not initialized variable reg: 14, insn: 0x023a: IF  (r14 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:130:0x023f, block:B:128:0x023a */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0218 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0153 A[Catch: all -> 0x0106, SQLiteDatabaseCorruptException -> 0x010b, TryCatch #17 {SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106, blocks: (B:47:0x011b, B:95:0x0121, B:49:0x012f, B:52:0x0137, B:55:0x013f, B:57:0x0153, B:58:0x0157, B:59:0x015c, B:61:0x0162, B:62:0x0170, B:64:0x0176, B:65:0x0184, B:67:0x018a, B:68:0x0198, B:70:0x019e, B:71:0x01ac, B:73:0x01b2, B:107:0x00ef, B:46:0x0100, B:45:0x010f), top: B:94:0x0121 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0162 A[Catch: all -> 0x0106, SQLiteDatabaseCorruptException -> 0x010b, TryCatch #17 {SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106, blocks: (B:47:0x011b, B:95:0x0121, B:49:0x012f, B:52:0x0137, B:55:0x013f, B:57:0x0153, B:58:0x0157, B:59:0x015c, B:61:0x0162, B:62:0x0170, B:64:0x0176, B:65:0x0184, B:67:0x018a, B:68:0x0198, B:70:0x019e, B:71:0x01ac, B:73:0x01b2, B:107:0x00ef, B:46:0x0100, B:45:0x010f), top: B:94:0x0121 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0176 A[Catch: all -> 0x0106, SQLiteDatabaseCorruptException -> 0x010b, TryCatch #17 {SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106, blocks: (B:47:0x011b, B:95:0x0121, B:49:0x012f, B:52:0x0137, B:55:0x013f, B:57:0x0153, B:58:0x0157, B:59:0x015c, B:61:0x0162, B:62:0x0170, B:64:0x0176, B:65:0x0184, B:67:0x018a, B:68:0x0198, B:70:0x019e, B:71:0x01ac, B:73:0x01b2, B:107:0x00ef, B:46:0x0100, B:45:0x010f), top: B:94:0x0121 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x018a A[Catch: all -> 0x0106, SQLiteDatabaseCorruptException -> 0x010b, TryCatch #17 {SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106, blocks: (B:47:0x011b, B:95:0x0121, B:49:0x012f, B:52:0x0137, B:55:0x013f, B:57:0x0153, B:58:0x0157, B:59:0x015c, B:61:0x0162, B:62:0x0170, B:64:0x0176, B:65:0x0184, B:67:0x018a, B:68:0x0198, B:70:0x019e, B:71:0x01ac, B:73:0x01b2, B:107:0x00ef, B:46:0x0100, B:45:0x010f), top: B:94:0x0121 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x019e A[Catch: all -> 0x0106, SQLiteDatabaseCorruptException -> 0x010b, TryCatch #17 {SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106, blocks: (B:47:0x011b, B:95:0x0121, B:49:0x012f, B:52:0x0137, B:55:0x013f, B:57:0x0153, B:58:0x0157, B:59:0x015c, B:61:0x0162, B:62:0x0170, B:64:0x0176, B:65:0x0184, B:67:0x018a, B:68:0x0198, B:70:0x019e, B:71:0x01ac, B:73:0x01b2, B:107:0x00ef, B:46:0x0100, B:45:0x010f), top: B:94:0x0121 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01b2 A[Catch: all -> 0x0106, SQLiteDatabaseCorruptException -> 0x010b, TRY_LEAVE, TryCatch #17 {SQLiteDatabaseCorruptException -> 0x010b, all -> 0x0106, blocks: (B:47:0x011b, B:95:0x0121, B:49:0x012f, B:52:0x0137, B:55:0x013f, B:57:0x0153, B:58:0x0157, B:59:0x015c, B:61:0x0162, B:62:0x0170, B:64:0x0176, B:65:0x0184, B:67:0x018a, B:68:0x0198, B:70:0x019e, B:71:0x01ac, B:73:0x01b2, B:107:0x00ef, B:46:0x0100, B:45:0x010f), top: B:94:0x0121 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0121 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String m1047a(JSONObject jSONObject, boolean z) {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        Cursor cursor2;
        SQLiteDatabase sQLiteDatabase2;
        JSONArray jSONArray;
        String str;
        JSONArray jSONArray2;
        long parseLong;
        long parseLong2;
        JSONArray jSONArray3;
        String str2 = null;
        try {
            try {
                sQLiteDatabase = C1632g.m1069a(f3439d).m1070a();
                try {
                    sQLiteDatabase.beginTransaction();
                    Cursor m1054a = m1054a(C1616e.C1626d.f3403a, sQLiteDatabase, null, null, null, null, null, null, null);
                    if (m1054a != null) {
                        try {
                            JSONArray jSONArray4 = new JSONArray();
                            while (true) {
                                if (!m1054a.moveToNext()) {
                                    cursor = m1054a;
                                    jSONArray = jSONArray4;
                                    break;
                                }
                                JSONObject jSONObject2 = new JSONObject();
                                String string = m1054a.getString(m1054a.getColumnIndex(C1616e.C1626d.C1627a.f3410g));
                                String string2 = m1054a.getString(m1054a.getColumnIndex("__e"));
                                String string3 = m1054a.getString(m1054a.getColumnIndex(C1616e.C1626d.C1627a.f3411h));
                                str2 = m1054a.getString(m1054a.getColumnIndex("__ii"));
                                try {
                                    if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
                                        str = str2;
                                        cursor = m1054a;
                                        jSONArray = jSONArray4;
                                    } else {
                                        if (Long.parseLong(string) - Long.parseLong(string2) > 0) {
                                            String string4 = m1054a.getString(m1054a.getColumnIndex("__a"));
                                            String string5 = m1054a.getString(m1054a.getColumnIndex(C1616e.C1626d.C1627a.f3406c));
                                            String string6 = m1054a.getString(m1054a.getColumnIndex(C1616e.C1626d.C1627a.f3407d));
                                            String string7 = m1054a.getString(m1054a.getColumnIndex(C1616e.C1626d.C1627a.f3408e));
                                            this.f3444i.add(str2);
                                            String string8 = m1054a.getString(m1054a.getColumnIndex("__sp"));
                                            String string9 = m1054a.getString(m1054a.getColumnIndex("__pp"));
                                            jSONObject2.put("id", str2);
                                            jSONObject2.put(C1615d.f3350p, string2);
                                            jSONObject2.put(C1615d.f3351q, string);
                                            str = str2;
                                            String str3 = "duration";
                                            if (FieldManager.allow(C1847b.f4254E)) {
                                                try {
                                                    if (Long.parseLong(string3) <= 0) {
                                                        jSONObject2.put(str3, Long.parseLong(string) - Long.parseLong(string2));
                                                        cursor = m1054a;
                                                        jSONArray2 = jSONArray4;
                                                        if (!TextUtils.isEmpty(string4)) {
                                                            try {
                                                                jSONObject2.put("pages", new JSONArray(m1031d(string4)));
                                                            } catch (SQLiteDatabaseCorruptException unused) {
                                                                str2 = str;
                                                                C1635h.m1066a(f3439d);
                                                                if (cursor != null) {
                                                                }
                                                            } catch (Throwable unused2) {
                                                                str2 = str;
                                                                C1635h.m1066a(f3439d);
                                                            }
                                                        }
                                                        boolean z2 = false;
                                                        if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
                                                            z2 = true;
                                                        }
                                                        if (!TextUtils.isEmpty(string5) && z2) {
                                                            jSONArray3 = new JSONArray(m1031d(string5));
                                                            JSONArray jSONArray5 = new JSONArray();
                                                            if (jSONArray3.length() > 0) {
                                                                jSONArray5 = m1040b(jSONArray3);
                                                            }
                                                            jSONObject2.put(C1615d.f3355u, jSONArray5);
                                                        }
                                                        if (!TextUtils.isEmpty(string6)) {
                                                            jSONObject2.put(C1615d.f3280F, new JSONObject(m1031d(string6)));
                                                        }
                                                        if (!TextUtils.isEmpty(string7)) {
                                                            jSONObject2.put(C1615d.f3276B, new JSONArray(m1031d(string7)));
                                                        }
                                                        if (!TextUtils.isEmpty(string8)) {
                                                            jSONObject2.put(C1615d.f3330au, new JSONObject(m1031d(string8)));
                                                        }
                                                        if (!TextUtils.isEmpty(string9)) {
                                                            jSONObject2.put(C1615d.f3331av, new JSONObject(m1031d(string9)));
                                                        }
                                                        if (jSONObject2.length() <= 0) {
                                                            jSONArray = jSONArray2;
                                                            jSONArray.put(jSONObject2);
                                                        } else {
                                                            jSONArray = jSONArray2;
                                                        }
                                                    } else {
                                                        cursor = m1054a;
                                                        jSONArray2 = jSONArray4;
                                                        jSONObject2.put(str3, Long.parseLong(string3));
                                                        str3 = C1615d.f3353s;
                                                        parseLong = Long.parseLong(string);
                                                        parseLong2 = Long.parseLong(string2);
                                                    }
                                                } catch (SQLiteDatabaseCorruptException unused3) {
                                                    cursor = m1054a;
                                                    str2 = str;
                                                    C1635h.m1066a(f3439d);
                                                    if (cursor != null) {
                                                        cursor.close();
                                                    }
                                                } catch (Throwable unused4) {
                                                    cursor = m1054a;
                                                    str2 = str;
                                                    C1635h.m1066a(f3439d);
                                                }
                                            } else {
                                                cursor = m1054a;
                                                jSONArray2 = jSONArray4;
                                                parseLong = Long.parseLong(string);
                                                parseLong2 = Long.parseLong(string2);
                                            }
                                            jSONObject2.put(str3, parseLong - parseLong2);
                                            if (!TextUtils.isEmpty(string4)) {
                                            }
                                            boolean z22 = false;
                                            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
                                            }
                                            if (!TextUtils.isEmpty(string5)) {
                                                jSONArray3 = new JSONArray(m1031d(string5));
                                                JSONArray jSONArray52 = new JSONArray();
                                                if (jSONArray3.length() > 0) {
                                                }
                                                jSONObject2.put(C1615d.f3355u, jSONArray52);
                                            }
                                            if (!TextUtils.isEmpty(string6)) {
                                            }
                                            if (!TextUtils.isEmpty(string7)) {
                                            }
                                            if (!TextUtils.isEmpty(string8)) {
                                            }
                                            if (!TextUtils.isEmpty(string9)) {
                                            }
                                            if (jSONObject2.length() <= 0) {
                                            }
                                        } else {
                                            str = str2;
                                            cursor = m1054a;
                                            jSONArray = jSONArray4;
                                        }
                                        if (z) {
                                            str2 = str;
                                            break;
                                        }
                                    }
                                    jSONArray4 = jSONArray;
                                    m1054a = cursor;
                                    str2 = str;
                                } catch (SQLiteDatabaseCorruptException unused5) {
                                    cursor = m1054a;
                                    C1635h.m1066a(f3439d);
                                    if (cursor != null) {
                                    }
                                } catch (Throwable unused6) {
                                    cursor = m1054a;
                                    C1635h.m1066a(f3439d);
                                }
                            }
                            try {
                                if (this.f3444i.size() < 1) {
                                    cursor.close();
                                    try {
                                        sQLiteDatabase.endTransaction();
                                    } catch (Throwable unused7) {
                                    }
                                    C1632g.m1069a(f3439d).m1068b();
                                    return str2;
                                } else if (jSONArray.length() > 0) {
                                    jSONObject.put(C1615d.f3348n, jSONArray);
                                }
                            } catch (SQLiteDatabaseCorruptException unused8) {
                                C1635h.m1066a(f3439d);
                                if (cursor != null) {
                                }
                            } catch (Throwable unused9) {
                                C1635h.m1066a(f3439d);
                            }
                        } catch (SQLiteDatabaseCorruptException unused10) {
                        } catch (Throwable unused11) {
                        }
                    } else {
                        cursor = m1054a;
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (SQLiteDatabaseCorruptException unused12) {
                    cursor = null;
                } catch (Throwable unused13) {
                    cursor = null;
                }
            } finally {
                if (cursor2 != null) {
                    cursor2.close();
                }
                if (sQLiteDatabase2 != null) {
                    try {
                        sQLiteDatabase2.endTransaction();
                    } catch (Throwable unused14) {
                    }
                }
                C1632g.m1069a(f3439d).m1068b();
            }
        } catch (SQLiteDatabaseCorruptException unused15) {
            sQLiteDatabase = null;
            cursor = null;
        } catch (Throwable unused16) {
            sQLiteDatabase = null;
            cursor = null;
        }
        return str2;
    }

    /* renamed from: a */
    private void m1052a(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        try {
            long longValue = ((Long) jSONObject.opt(C1616e.C1626d.C1627a.f3410g)).longValue();
            long j = 0;
            Object opt = jSONObject.opt(C1616e.C1626d.C1627a.f3411h);
            if (opt != null && (opt instanceof Long)) {
                j = ((Long) opt).longValue();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("__sp");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("__pp");
            String str2 = "";
            String m1034c = (optJSONObject == null || optJSONObject.length() <= 0) ? str2 : m1034c(optJSONObject.toString());
            if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                str2 = m1034c(optJSONObject2.toString());
            }
            sQLiteDatabase.execSQL("update __sd set __f=\"" + longValue + "\", " + C1616e.C1626d.C1627a.f3411h + "=\"" + j + "\", __sp=\"" + m1034c + "\", __pp=\"" + str2 + "\" where __ii=\"" + str + "\"");
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0077 A[Catch: all -> 0x0069, TryCatch #2 {all -> 0x0069, blocks: (B:52:0x0056, B:54:0x005c, B:15:0x006c, B:17:0x0077, B:18:0x007c, B:26:0x008b, B:29:0x0091, B:31:0x0097, B:38:0x009d, B:40:0x00ab, B:33:0x009a), top: B:51:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0056 A[EXC_TOP_SPLITTER, LOOP:1: B:51:0x0056->B:54:0x005c, LOOP_START, PHI: r14 
      PHI: (r14v2 java.lang.String) = (r14v7 java.lang.String), (r14v3 java.lang.String) binds: [B:14:0x0054, B:54:0x005c] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m1051a(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase, String str2) throws JSONException {
        JSONArray jSONArray;
        JSONArray optJSONArray;
        Cursor m1054a;
        JSONArray jSONArray2;
        Cursor cursor = null;
        r14 = null;
        String str3 = null;
        try {
            if ("__a".equals(str2)) {
                optJSONArray = jSONObject.optJSONArray("__a");
                if (optJSONArray == null) {
                    return;
                }
                if (optJSONArray.length() <= 0) {
                    return;
                }
            } else if (!C1616e.C1626d.C1627a.f3406c.equals(str2)) {
                jSONArray = null;
                m1054a = m1054a(C1616e.C1626d.f3403a, sQLiteDatabase, new String[]{str2}, "__ii=? ", new String[]{str}, null, null, null, null);
                if (m1054a != null) {
                    while (m1054a.moveToNext()) {
                        try {
                            str3 = m1031d(m1054a.getString(m1054a.getColumnIndex(str2)));
                        } catch (Throwable unused) {
                            cursor = m1054a;
                            if (cursor == null) {
                                return;
                            }
                            cursor.close();
                            return;
                        }
                    }
                }
                jSONArray2 = new JSONArray();
                if (!TextUtils.isEmpty(str3)) {
                    jSONArray2 = new JSONArray(str3);
                }
                if (jSONArray2.length() <= 1000) {
                    if (m1054a == null) {
                        return;
                    }
                    m1054a.close();
                    return;
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            jSONArray2.put(jSONObject2);
                        }
                    } catch (JSONException unused2) {
                    }
                }
                String m1034c = m1034c(jSONArray2.toString());
                if (!TextUtils.isEmpty(m1034c)) {
                    sQLiteDatabase.execSQL("update __sd set " + str2 + "=\"" + m1034c + "\" where __ii=\"" + str + "\"");
                }
                if (m1054a == null) {
                    return;
                }
                m1054a.close();
                return;
            } else {
                optJSONArray = jSONObject.optJSONArray(C1616e.C1626d.C1627a.f3406c);
                if (optJSONArray == null || optJSONArray.length() <= 0) {
                    return;
                }
            }
            jSONArray = optJSONArray;
            m1054a = m1054a(C1616e.C1626d.f3403a, sQLiteDatabase, new String[]{str2}, "__ii=? ", new String[]{str}, null, null, null, null);
            if (m1054a != null) {
            }
            jSONArray2 = new JSONArray();
            if (!TextUtils.isEmpty(str3)) {
            }
            if (jSONArray2.length() <= 1000) {
            }
        } catch (Throwable unused3) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x018e, code lost:
        if (r1 != null) goto L91;
     */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x01a3: IF  (r1 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:114:0x01a8, block:B:113:0x01a3 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m1048a(JSONObject jSONObject, String str) {
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase sQLiteDatabase2;
        Cursor cursor = null;
        try {
            try {
                sQLiteDatabase = C1632g.m1069a(f3439d).m1070a();
            } finally {
                if (0 != 0) {
                    cursor.close();
                }
                if (sQLiteDatabase2 != null) {
                    try {
                        sQLiteDatabase2.endTransaction();
                    } catch (Throwable unused) {
                    }
                }
                C1632g.m1069a(f3439d).m1068b();
            }
        } catch (SQLiteDatabaseCorruptException unused2) {
            sQLiteDatabase = null;
        } catch (Throwable unused3) {
            sQLiteDatabase = null;
        }
        try {
            sQLiteDatabase.beginTransaction();
            cursor = !TextUtils.isEmpty(str) ? m1054a(C1616e.C1620b.f3377a, sQLiteDatabase, null, "__i=? ", new String[]{str}, null, null, null, null) : m1054a(C1616e.C1620b.f3377a, sQLiteDatabase, null, null, null, null, null, null, null);
            if (cursor != null) {
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                String m892b = C1663u.m899a().m892b();
                while (cursor.moveToNext()) {
                    int i = cursor.getInt(cursor.getColumnIndex("__t"));
                    String string = cursor.getString(cursor.getColumnIndex("__i"));
                    String string2 = cursor.getString(cursor.getColumnIndex("__s"));
                    if (TextUtils.isEmpty(string) || "-1".equals(string)) {
                        if (!TextUtils.isEmpty(m892b)) {
                            string = m892b;
                        }
                    }
                    this.f3445j.add(Integer.valueOf(cursor.getInt(0)));
                    if (i != 2049) {
                        if (i == 2050 && !TextUtils.isEmpty(string2)) {
                            JSONObject jSONObject4 = new JSONObject(m1031d(string2));
                            JSONArray optJSONArray = jSONObject3.has(string) ? jSONObject3.optJSONArray(string) : new JSONArray();
                            optJSONArray.put(jSONObject4);
                            jSONObject3.put(string, optJSONArray);
                        }
                    } else if (!TextUtils.isEmpty(string2)) {
                        JSONObject jSONObject5 = new JSONObject(m1031d(string2));
                        JSONArray optJSONArray2 = jSONObject2.has(string) ? jSONObject2.optJSONArray(string) : new JSONArray();
                        optJSONArray2.put(jSONObject5);
                        jSONObject2.put(string, optJSONArray2);
                    }
                }
                if (jSONObject2.length() > 0) {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        JSONObject jSONObject6 = new JSONObject();
                        String next = keys.next();
                        jSONObject6.put(next, new JSONArray(jSONObject2.optString(next)));
                        if (jSONObject6.length() > 0) {
                            jSONArray.put(jSONObject6);
                        }
                    }
                    if (jSONArray.length() > 0) {
                        jSONObject.put("ekv", jSONArray);
                    }
                }
                if (jSONObject3.length() > 0) {
                    JSONArray jSONArray2 = new JSONArray();
                    Iterator<String> keys2 = jSONObject3.keys();
                    while (keys2.hasNext()) {
                        JSONObject jSONObject7 = new JSONObject();
                        String next2 = keys2.next();
                        jSONObject7.put(next2, new JSONArray(jSONObject3.optString(next2)));
                        if (jSONObject7.length() > 0) {
                            jSONArray2.put(jSONObject7);
                        }
                    }
                    if (jSONArray2.length() > 0) {
                        jSONObject.put(C1615d.f3294T, jSONArray2);
                    }
                }
            }
            sQLiteDatabase.setTransactionSuccessful();
            if (cursor != null) {
                cursor.close();
            }
        } catch (SQLiteDatabaseCorruptException unused4) {
            C1635h.m1066a(f3439d);
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable unused5) {
            C1635h.m1066a(f3439d);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00e4, code lost:
        if (r1 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00e6, code lost:
        r1.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00d5, code lost:
        if (r1 != null) goto L27;
     */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r13v0, types: [org.json.JSONObject] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String m1038b(JSONObject jSONObject, boolean z) {
        Object obj;
        SQLiteDatabase sQLiteDatabase;
        ?? r0 = 0;
        String str = null;
        r0 = 0;
        r0 = 0;
        r0 = 0;
        r0 = null;
        r0 = null;
        Cursor cursor = null;
        Cursor cursor2 = null;
        try {
            try {
                sQLiteDatabase = C1632g.m1069a(f3439d).m1070a();
                try {
                    sQLiteDatabase.beginTransaction();
                    Cursor m1054a = m1054a(C1616e.C1623c.f3390a, sQLiteDatabase, null, null, null, null, null, null, null);
                    if (m1054a != null) {
                        try {
                            JSONArray jSONArray = new JSONArray();
                            while (m1054a.moveToNext()) {
                                JSONObject jSONObject2 = new JSONObject();
                                String string = m1054a.getString(m1054a.getColumnIndex("__e"));
                                str = m1054a.getString(m1054a.getColumnIndex("__ii"));
                                this.f3447l.add(str);
                                String string2 = m1054a.getString(m1054a.getColumnIndex("__sp"));
                                String string3 = m1054a.getString(m1054a.getColumnIndex("__pp"));
                                if (!TextUtils.isEmpty(string2)) {
                                    jSONObject2.put(C1615d.f3330au, new JSONObject(m1031d(string2)));
                                }
                                if (!TextUtils.isEmpty(string3)) {
                                    jSONObject2.put(C1615d.f3331av, new JSONObject(m1031d(string3)));
                                }
                                if (!TextUtils.isEmpty(string)) {
                                    jSONObject2.put("id", str);
                                    jSONObject2.put(C1615d.f3350p, string);
                                    if (jSONObject2.length() > 0) {
                                        jSONArray.put(jSONObject2);
                                    }
                                    if (z) {
                                        break;
                                    }
                                }
                            }
                            r0 = str;
                            if (jSONArray.length() > 0) {
                                jSONObject.put(C1615d.f3348n, jSONArray);
                                r0 = str;
                            }
                        } catch (SQLiteDatabaseCorruptException unused) {
                            obj = r0;
                            cursor = m1054a;
                            C1635h.m1066a(f3439d);
                            if (cursor != null) {
                                cursor.close();
                            }
                        } catch (Throwable unused2) {
                            obj = r0;
                            cursor2 = m1054a;
                            C1635h.m1066a(f3439d);
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                        }
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    if (m1054a != null) {
                        m1054a.close();
                    }
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused3) {
                    }
                    C1632g.m1069a(f3439d).m1068b();
                } catch (SQLiteDatabaseCorruptException unused4) {
                    obj = null;
                } catch (Throwable unused5) {
                    obj = null;
                }
            } catch (Throwable th) {
                if (r0 != 0) {
                    r0.close();
                }
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused6) {
                    }
                }
                C1632g.m1069a(f3439d).m1068b();
                throw th;
            }
        } catch (SQLiteDatabaseCorruptException unused7) {
            obj = null;
            sQLiteDatabase = null;
        } catch (Throwable unused8) {
            obj = null;
            sQLiteDatabase = null;
        }
        return r0;
        C1632g.m1069a(f3439d).m1068b();
        r0 = obj;
        return r0;
    }

    /* renamed from: b */
    private JSONArray m1040b(JSONArray jSONArray) {
        JSONArray jSONArray2 = new JSONArray();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null && optJSONObject.optLong("duration") > 0) {
                jSONArray2.put(optJSONObject);
            }
        }
        return jSONArray2;
    }

    /* renamed from: b */
    private void m1041b(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        try {
            long longValue = ((Long) jSONObject.get("__e")).longValue();
            JSONObject optJSONObject = jSONObject.optJSONObject("__sp");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("__pp");
            String str2 = "";
            String m1034c = (optJSONObject == null || optJSONObject.length() <= 0) ? str2 : m1034c(optJSONObject.toString());
            if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                str2 = m1034c(optJSONObject2.toString());
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("__ii", str);
            contentValues.put("__e", String.valueOf(longValue));
            contentValues.put("__sp", m1034c);
            contentValues.put("__pp", str2);
            contentValues.put("__av", UMGlobalContext.getInstance(f3439d).getAppVersion());
            contentValues.put("__vc", UMUtils.getAppVersionCode(f3439d));
            sQLiteDatabase.insert(C1616e.C1623c.f3390a, null, contentValues);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0091, code lost:
        if (r1 != null) goto L27;
     */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x00a6: IF  (r1 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:51:0x00ab, block:B:50:0x00a6 */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m1039b(JSONObject jSONObject, String str) {
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase sQLiteDatabase2;
        Cursor cursor = null;
        try {
            try {
                sQLiteDatabase = C1632g.m1069a(f3439d).m1070a();
                try {
                    sQLiteDatabase.beginTransaction();
                    cursor = !TextUtils.isEmpty(str) ? m1054a(C1616e.C1617a.f3366a, sQLiteDatabase, null, "__i=? ", new String[]{str}, null, null, null, null) : m1054a(C1616e.C1617a.f3366a, sQLiteDatabase, null, null, null, null, null, null, null);
                    if (cursor != null) {
                        JSONArray jSONArray = new JSONArray();
                        while (cursor.moveToNext()) {
                            String string = cursor.getString(cursor.getColumnIndex("__a"));
                            if (!TextUtils.isEmpty(string)) {
                                jSONArray.put(new JSONObject(m1031d(string)));
                            }
                        }
                        if (jSONArray.length() > 0) {
                            jSONObject.put("error", jSONArray);
                        }
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (SQLiteDatabaseCorruptException unused) {
                    C1635h.m1066a(f3439d);
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable unused2) {
                    C1635h.m1066a(f3439d);
                }
            } finally {
                if (0 != 0) {
                    cursor.close();
                }
                if (sQLiteDatabase2 != null) {
                    try {
                        sQLiteDatabase2.endTransaction();
                    } catch (Throwable unused3) {
                    }
                }
                C1632g.m1069a(f3439d).m1068b();
            }
        } catch (SQLiteDatabaseCorruptException unused4) {
            sQLiteDatabase = null;
        } catch (Throwable unused5) {
            sQLiteDatabase = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m1033c(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        JSONObject jSONObject2;
        String str2;
        Cursor cursor2;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject(C1616e.C1626d.C1627a.f3408e);
            if (optJSONObject != null) {
                jSONObject2 = optJSONObject;
                Cursor m1054a = m1054a(C1616e.C1626d.f3403a, sQLiteDatabase, new String[]{C1616e.C1626d.C1627a.f3408e}, "__ii=? ", new String[]{str}, null, null, null, null);
                if (m1054a != null) {
                    String str3 = null;
                    while (m1054a.moveToNext()) {
                        try {
                            str3 = m1031d(m1054a.getString(m1054a.getColumnIndex(C1616e.C1626d.C1627a.f3408e)));
                        } catch (Throwable unused) {
                            cursor = m1054a;
                            if (cursor != null) {
                            }
                        }
                    }
                    String str4 = str3;
                    cursor2 = m1054a;
                    str2 = str4;
                } else {
                    cursor2 = m1054a;
                    str2 = null;
                }
            } else {
                jSONObject2 = optJSONObject;
                str2 = null;
                cursor2 = null;
            }
            if (jSONObject2 != null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    if (!TextUtils.isEmpty(str2)) {
                        jSONArray = new JSONArray(str2);
                    }
                    jSONArray.put(jSONObject2);
                    String m1034c = m1034c(jSONArray.toString());
                    if (!TextUtils.isEmpty(m1034c)) {
                        sQLiteDatabase.execSQL("update  __sd set __d=\"" + m1034c + "\" where __ii=\"" + str + "\"");
                    }
                } catch (Throwable unused2) {
                    cursor = cursor2;
                    if (cursor != null) {
                        return;
                    }
                    cursor.close();
                    return;
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject(C1616e.C1626d.C1627a.f3407d);
            if (optJSONObject2 != null) {
                String m1034c2 = m1034c(optJSONObject2.toString());
                if (!TextUtils.isEmpty(m1034c2)) {
                    sQLiteDatabase.execSQL("update  __sd set __c=\"" + m1034c2 + "\" where __ii=\"" + str + "\"");
                }
            }
            long optLong = jSONObject.optLong(C1616e.C1626d.C1627a.f3410g);
            sQLiteDatabase.execSQL("update  __sd set __f=\"" + String.valueOf(optLong) + "\" where __ii=\"" + str + "\"");
            if (cursor2 == null) {
                return;
            }
            cursor2.close();
        } catch (Throwable unused3) {
            cursor = null;
        }
    }

    /* renamed from: k */
    private void m1024k() {
        synchronized (this) {
            m1023l();
            this.f3444i.clear();
            this.f3447l.clear();
            this.f3445j.clear();
        }
    }

    /* renamed from: l */
    private void m1023l() {
        try {
            if (!TextUtils.isEmpty(f3440e)) {
                return;
            }
            String multiProcessSP = UMUtils.getMultiProcessSP(f3439d, "ek__id");
            if (TextUtils.isEmpty(multiProcessSP)) {
                multiProcessSP = PreferenceWrapper.getDefault(f3439d).getString("ek__id", null);
                if (TextUtils.isEmpty(multiProcessSP)) {
                    multiProcessSP = UMUtils.genId();
                }
                if (!TextUtils.isEmpty(multiProcessSP)) {
                    UMUtils.setMultiProcessSP(f3439d, "ek__id", multiProcessSP);
                }
            }
            if (!TextUtils.isEmpty(multiProcessSP)) {
                String substring = multiProcessSP.substring(1, 9);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < substring.length(); i++) {
                    char charAt = substring.charAt(i);
                    if (!Character.isDigit(charAt)) {
                        sb.append(charAt);
                    } else if (Integer.parseInt(Character.toString(charAt)) == 0) {
                        sb.append(0);
                    } else {
                        sb.append(10 - Integer.parseInt(Character.toString(charAt)));
                    }
                }
                f3440e = sb.toString();
            }
            if (TextUtils.isEmpty(f3440e)) {
                return;
            }
            f3440e += new StringBuilder(f3440e).reverse().toString();
            String multiProcessSP2 = UMUtils.getMultiProcessSP(f3439d, "ek_key");
            if (TextUtils.isEmpty(multiProcessSP2)) {
                UMUtils.setMultiProcessSP(f3439d, "ek_key", m1034c("umeng+"));
            } else if (!"umeng+".equals(m1031d(multiProcessSP2))) {
                m1036b(true, false);
                m1044a(true, false);
                m1027h();
                m1026i();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x005b, code lost:
        if (r4 != null) goto L11;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long m1055a(String str) {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor = null;
        long j = 0;
        try {
            try {
                sQLiteDatabase = C1632g.m1069a(f3439d).m1070a();
                try {
                    sQLiteDatabase.beginTransaction();
                    cursor = m1054a(C1616e.C1626d.f3403a, sQLiteDatabase, new String[]{C1616e.C1626d.C1627a.f3410g}, "__ii=? ", new String[]{str}, null, null, null, null);
                    if (cursor != null) {
                        cursor.moveToFirst();
                        j = cursor.getLong(cursor.getColumnIndex(C1616e.C1626d.C1627a.f3410g));
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Exception unused) {
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception unused2) {
                            C1632g.m1069a(f3439d).m1068b();
                            throw th;
                        }
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.endTransaction();
                    }
                    C1632g.m1069a(f3439d).m1068b();
                    throw th;
                }
            } catch (Exception unused3) {
            }
        } catch (Exception unused4) {
            sQLiteDatabase = null;
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase = null;
        }
        sQLiteDatabase.endTransaction();
        C1632g.m1069a(f3439d).m1068b();
        return j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0022, code lost:
        if (android.text.TextUtils.isEmpty(r3) == false) goto L4;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject m1046a(boolean z) {
        String m1047a;
        m1057a();
        this.f3445j.clear();
        JSONObject jSONObject = new JSONObject();
        if (!z) {
            m1047a(jSONObject, z);
            m1047a = null;
        } else {
            m1047a = m1047a(jSONObject, z);
        }
        m1039b(jSONObject, m1047a);
        m1048a(jSONObject, m1047a);
        return jSONObject;
    }

    /* renamed from: a */
    public void m1057a() {
        this.f3444i.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ac, code lost:
        if (r2 == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x009a, code lost:
        r2.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0098, code lost:
        if (r2 == null) goto L26;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m1049a(JSONArray jSONArray) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                SQLiteDatabase m1070a = C1632g.m1069a(f3439d).m1070a();
                try {
                    try {
                        m1070a.beginTransaction();
                        for (int i = 0; i < jSONArray.length(); i++) {
                            try {
                                JSONObject jSONObject = jSONArray.getJSONObject(i);
                                ContentValues contentValues = new ContentValues();
                                String optString = jSONObject.optString("__i");
                                if (TextUtils.isEmpty(optString) || "-1".equals(optString)) {
                                    optString = C1663u.m899a().m892b();
                                    if (TextUtils.isEmpty(optString)) {
                                        optString = "-1";
                                    }
                                }
                                contentValues.put("__i", optString);
                                contentValues.put("__e", jSONObject.optString("id"));
                                contentValues.put("__t", Integer.valueOf(jSONObject.optInt("__t")));
                                contentValues.put("__av", UMUtils.getAppVersionName(f3439d));
                                contentValues.put("__vc", UMUtils.getAppVersionCode(f3439d));
                                jSONObject.remove("__i");
                                jSONObject.remove("__t");
                                contentValues.put("__s", m1034c(jSONObject.toString()));
                                m1070a.insert(C1616e.C1620b.f3377a, null, contentValues);
                            } catch (Exception unused) {
                            }
                        }
                        m1070a.setTransactionSuccessful();
                        m1070a.endTransaction();
                    } catch (SQLiteDatabaseCorruptException unused2) {
                        sQLiteDatabase = m1070a;
                        try {
                            C1635h.m1066a(f3439d);
                        } catch (Throwable th) {
                            if (sQLiteDatabase != null) {
                                try {
                                    sQLiteDatabase.endTransaction();
                                } catch (Throwable unused3) {
                                }
                            }
                            C1632g.m1069a(f3439d).m1068b();
                            throw th;
                        }
                    }
                } catch (Throwable unused4) {
                    sQLiteDatabase = m1070a;
                }
            } catch (Throwable unused5) {
            }
        } catch (SQLiteDatabaseCorruptException unused6) {
        } catch (Throwable unused7) {
        }
        C1632g.m1069a(f3439d).m1068b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0078, code lost:
        if (r0 == null) goto L9;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m1045a(boolean z, String str) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = C1632g.m1069a(f3439d).m1070a();
                sQLiteDatabase.beginTransaction();
                if (!TextUtils.isEmpty(str)) {
                    sQLiteDatabase.execSQL("delete from __er where __i=\"" + str + "\"");
                    sQLiteDatabase.execSQL("delete from __et where __i=\"" + str + "\"");
                    this.f3445j.clear();
                    sQLiteDatabase.execSQL("delete from __sd where __ii=\"" + str + "\"");
                }
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused) {
                    }
                }
                C1632g.m1069a(f3439d).m1068b();
            }
        } catch (SQLiteDatabaseCorruptException unused2) {
            C1635h.m1066a(f3439d);
        } catch (Throwable unused3) {
        }
    }

    /* renamed from: a */
    public void m1044a(boolean z, boolean z2) {
        String str;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = C1632g.m1069a(f3439d).m1070a();
                sQLiteDatabase.beginTransaction();
            } catch (SQLiteDatabaseCorruptException unused) {
                C1635h.m1066a(f3439d);
            }
            if (z2) {
                if (z) {
                    str = "delete from __is";
                    sQLiteDatabase.execSQL(str);
                }
                sQLiteDatabase.setTransactionSuccessful();
                return;
            }
            int size = this.f3447l.size();
            int i = 0;
            if (size > 0) {
                int i2 = 0;
                while (i < size) {
                    String str2 = this.f3447l.get(i);
                    if (str2 == null) {
                        i2 = 1;
                    }
                    sQLiteDatabase.execSQL("delete from __is where __ii=\"" + str2 + "\"");
                    i++;
                }
                i = i2;
            }
            if (i != 0) {
                str = "delete from __is where __ii is null";
                sQLiteDatabase.execSQL(str);
            }
            sQLiteDatabase.setTransactionSuccessful();
            return;
            C1635h.m1066a(f3439d);
        } finally {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable unused2) {
                }
            }
            C1632g.m1069a(f3439d).m1068b();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x006a, code lost:
        if (r0 == null) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0058, code lost:
        r0.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
        if (r0 == null) goto L11;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean m1053a(String str, String str2, int i) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                SQLiteDatabase m1070a = C1632g.m1069a(f3439d).m1070a();
                try {
                    m1070a.beginTransaction();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("__i", str);
                    String m1034c = m1034c(str2);
                    if (!TextUtils.isEmpty(m1034c)) {
                        contentValues.put("__a", m1034c);
                        contentValues.put("__t", Integer.valueOf(i));
                        contentValues.put("__av", UMUtils.getAppVersionName(f3439d));
                        contentValues.put("__vc", UMUtils.getAppVersionCode(f3439d));
                        m1070a.insert(C1616e.C1617a.f3366a, null, contentValues);
                    }
                    m1070a.setTransactionSuccessful();
                    m1070a.endTransaction();
                } catch (SQLiteDatabaseCorruptException unused) {
                    sQLiteDatabase = m1070a;
                    try {
                        C1635h.m1066a(f3439d);
                    } catch (Throwable th) {
                        if (sQLiteDatabase != null) {
                            try {
                                sQLiteDatabase.endTransaction();
                            } catch (Throwable unused2) {
                            }
                        }
                        C1632g.m1069a(f3439d).m1068b();
                        throw th;
                    }
                } catch (Throwable unused3) {
                    sQLiteDatabase = m1070a;
                }
            } catch (Throwable unused4) {
            }
        } catch (SQLiteDatabaseCorruptException unused5) {
        } catch (Throwable unused6) {
        }
        C1632g.m1069a(f3439d).m1068b();
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0096, code lost:
        if (r2 == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0084, code lost:
        r2.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0082, code lost:
        if (r2 == null) goto L16;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean m1050a(String str, JSONObject jSONObject, EnumC1638a enumC1638a) {
        SQLiteDatabase m1070a;
        String str2;
        if (jSONObject == null) {
            return false;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                m1070a = C1632g.m1069a(f3439d).m1070a();
            } catch (Throwable unused) {
            }
        } catch (SQLiteDatabaseCorruptException unused2) {
        } catch (Throwable unused3) {
        }
        try {
            m1070a.beginTransaction();
            if (enumC1638a == EnumC1638a.BEGIN) {
                long longValue = ((Long) jSONObject.opt("__e")).longValue();
                ContentValues contentValues = new ContentValues();
                contentValues.put("__ii", str);
                contentValues.put("__e", String.valueOf(longValue));
                contentValues.put("__av", UMUtils.getAppVersionName(f3439d));
                contentValues.put("__vc", UMUtils.getAppVersionCode(f3439d));
                m1070a.insert(C1616e.C1626d.f3403a, null, contentValues);
            } else if (enumC1638a == EnumC1638a.INSTANTSESSIONBEGIN) {
                m1041b(str, jSONObject, m1070a);
            } else if (enumC1638a == EnumC1638a.END) {
                m1052a(str, jSONObject, m1070a);
            } else {
                if (enumC1638a == EnumC1638a.PAGE) {
                    str2 = "__a";
                } else if (enumC1638a == EnumC1638a.AUTOPAGE) {
                    str2 = C1616e.C1626d.C1627a.f3406c;
                } else if (enumC1638a == EnumC1638a.NEWSESSION) {
                    m1033c(str, jSONObject, m1070a);
                }
                m1051a(str, jSONObject, m1070a, str2);
            }
            m1070a.setTransactionSuccessful();
            m1070a.endTransaction();
        } catch (SQLiteDatabaseCorruptException unused4) {
            sQLiteDatabase = m1070a;
            try {
                C1635h.m1066a(f3439d);
            } catch (Throwable th) {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused5) {
                    }
                }
                C1632g.m1069a(f3439d).m1068b();
                throw th;
            }
        } catch (Throwable unused6) {
            sQLiteDatabase = m1070a;
        }
        C1632g.m1069a(f3439d).m1068b();
        return false;
    }

    /* renamed from: b */
    public JSONObject m1037b(boolean z) {
        JSONObject jSONObject = new JSONObject();
        m1038b(jSONObject, z);
        return jSONObject;
    }

    /* renamed from: b */
    public void m1043b() {
        this.f3447l.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0045, code lost:
        if (r0 == null) goto L9;
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m1042b(String str) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = C1632g.m1069a(f3439d).m1070a();
                sQLiteDatabase.beginTransaction();
                if (!TextUtils.isEmpty(str)) {
                    sQLiteDatabase.execSQL("delete from __is where __ii=\"" + str + "\"");
                }
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused) {
                    }
                }
                C1632g.m1069a(f3439d).m1068b();
            }
        } catch (SQLiteDatabaseCorruptException unused2) {
            C1635h.m1066a(f3439d);
        } catch (Throwable unused3) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0065, code lost:
        if (r0 == null) goto L10;
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m1036b(boolean z, boolean z2) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = C1632g.m1069a(f3439d).m1070a();
                sQLiteDatabase.beginTransaction();
                if (z2) {
                    if (z) {
                        sQLiteDatabase.execSQL("delete from __sd");
                    }
                } else if (this.f3444i.size() > 0) {
                    for (int i = 0; i < this.f3444i.size(); i++) {
                        sQLiteDatabase.execSQL("delete from __sd where __ii=\"" + this.f3444i.get(i) + "\"");
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused) {
                    }
                }
                C1632g.m1069a(f3439d).m1068b();
            }
        } catch (SQLiteDatabaseCorruptException unused2) {
            C1635h.m1066a(f3439d);
        } catch (Throwable unused3) {
        }
    }

    /* renamed from: c */
    public String m1034c(String str) {
        try {
            return TextUtils.isEmpty(f3440e) ? str : Base64.encodeToString(DataHelper.encrypt(str.getBytes(), f3440e.getBytes()), 0);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: c */
    public boolean m1035c() {
        return this.f3447l.isEmpty();
    }

    /* renamed from: d */
    public String m1031d(String str) {
        try {
            return TextUtils.isEmpty(f3440e) ? str : new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f3440e.getBytes()));
        } catch (Exception unused) {
            if (Build.VERSION.SDK_INT >= 29 && !TextUtils.isEmpty(str)) {
                try {
                    new JSONObject(str);
                    UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> UMStoreManager decrypt failed, return origin data.");
                    return str;
                } catch (Throwable unused2) {
                    return null;
                }
            }
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x007d, code lost:
        if (r0 == null) goto L13;
     */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m1032d() {
        String m887c;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = C1632g.m1069a(f3439d).m1070a();
                sQLiteDatabase.beginTransaction();
                m887c = C1663u.m899a().m887c();
            } finally {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused) {
                    }
                }
                C1632g.m1069a(f3439d).m1068b();
            }
        } catch (SQLiteDatabaseCorruptException unused2) {
            C1635h.m1066a(f3439d);
        } catch (Throwable unused3) {
        }
        if (TextUtils.isEmpty(m887c)) {
            try {
                sQLiteDatabase.endTransaction();
            } catch (Throwable unused4) {
            }
            C1632g.m1069a(f3439d).m1068b();
            return;
        }
        String[] strArr = {"", "-1"};
        for (int i = 0; i < 2; i++) {
            sQLiteDatabase.execSQL("update __et set __i=\"" + m887c + "\" where __i=\"" + strArr[i] + "\"");
        }
        sQLiteDatabase.setTransactionSuccessful();
    }

    /* renamed from: e */
    public boolean m1030e() {
        return this.f3444i.isEmpty();
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x009f, code lost:
        if (r2 != null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0085, code lost:
        r2.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0083, code lost:
        if (r2 != null) goto L29;
     */
    /* JADX WARN: Finally extract failed */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject m1029f() {
        SQLiteDatabase sQLiteDatabase;
        JSONObject jSONObject;
        Cursor cursor = null;
        r3 = null;
        r3 = null;
        r3 = null;
        JSONObject jSONObject2 = null;
        r3 = null;
        cursor = null;
        Cursor cursor2 = null;
        if (this.f3447l.isEmpty()) {
            return null;
        }
        try {
            sQLiteDatabase = C1632g.m1069a(f3439d).m1070a();
            try {
                sQLiteDatabase.beginTransaction();
                Cursor m1054a = m1054a(C1616e.C1623c.f3390a, sQLiteDatabase, null, "__ii=? ", new String[]{this.f3447l.get(0)}, null, null, null, null);
                if (m1054a != null) {
                    try {
                        if (m1054a.moveToNext()) {
                            jSONObject = new JSONObject();
                            try {
                                String string = m1054a.getString(m1054a.getColumnIndex("__av"));
                                String string2 = m1054a.getString(m1054a.getColumnIndex("__vc"));
                                jSONObject.put("__av", string);
                                jSONObject.put("__vc", string2);
                                jSONObject2 = jSONObject;
                            } catch (SQLiteDatabaseCorruptException unused) {
                                cursor2 = m1054a;
                                try {
                                    C1635h.m1066a(f3439d);
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                } catch (Throwable th) {
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    if (sQLiteDatabase != null) {
                                        try {
                                            sQLiteDatabase.endTransaction();
                                        } catch (Throwable unused2) {
                                        }
                                    }
                                    C1632g.m1069a(f3439d).m1068b();
                                    throw th;
                                }
                            } catch (Throwable unused3) {
                                cursor = m1054a;
                                if (cursor != null) {
                                    cursor.close();
                                }
                            }
                        }
                    } catch (SQLiteDatabaseCorruptException unused4) {
                        jSONObject = jSONObject2;
                    } catch (Throwable unused5) {
                        jSONObject = jSONObject2;
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
                if (m1054a != null) {
                    m1054a.close();
                }
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable unused6) {
                }
                C1632g.m1069a(f3439d).m1068b();
                return jSONObject2;
            } catch (SQLiteDatabaseCorruptException unused7) {
                jSONObject = null;
            } catch (Throwable unused8) {
                jSONObject = null;
            }
        } catch (SQLiteDatabaseCorruptException unused9) {
            sQLiteDatabase = null;
            jSONObject = null;
        } catch (Throwable unused10) {
            sQLiteDatabase = null;
            jSONObject = null;
        }
        C1632g.m1069a(f3439d).m1068b();
        return jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x009f, code lost:
        if (r2 != null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0085, code lost:
        r2.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0083, code lost:
        if (r2 != null) goto L29;
     */
    /* JADX WARN: Finally extract failed */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject m1028g() {
        SQLiteDatabase sQLiteDatabase;
        JSONObject jSONObject;
        Cursor cursor = null;
        r3 = null;
        r3 = null;
        r3 = null;
        JSONObject jSONObject2 = null;
        r3 = null;
        cursor = null;
        Cursor cursor2 = null;
        if (this.f3444i.isEmpty()) {
            return null;
        }
        try {
            sQLiteDatabase = C1632g.m1069a(f3439d).m1070a();
            try {
                sQLiteDatabase.beginTransaction();
                Cursor m1054a = m1054a(C1616e.C1626d.f3403a, sQLiteDatabase, null, "__ii=? ", new String[]{this.f3444i.get(0)}, null, null, null, null);
                if (m1054a != null) {
                    try {
                        if (m1054a.moveToNext()) {
                            jSONObject = new JSONObject();
                            try {
                                String string = m1054a.getString(m1054a.getColumnIndex("__av"));
                                String string2 = m1054a.getString(m1054a.getColumnIndex("__vc"));
                                jSONObject.put("__av", string);
                                jSONObject.put("__vc", string2);
                                jSONObject2 = jSONObject;
                            } catch (SQLiteDatabaseCorruptException unused) {
                                cursor2 = m1054a;
                                try {
                                    C1635h.m1066a(f3439d);
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                } catch (Throwable th) {
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    if (sQLiteDatabase != null) {
                                        try {
                                            sQLiteDatabase.endTransaction();
                                        } catch (Throwable unused2) {
                                        }
                                    }
                                    C1632g.m1069a(f3439d).m1068b();
                                    throw th;
                                }
                            } catch (Throwable unused3) {
                                cursor = m1054a;
                                if (cursor != null) {
                                    cursor.close();
                                }
                            }
                        }
                    } catch (SQLiteDatabaseCorruptException unused4) {
                        jSONObject = jSONObject2;
                    } catch (Throwable unused5) {
                        jSONObject = jSONObject2;
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
                if (m1054a != null) {
                    m1054a.close();
                }
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable unused6) {
                }
                C1632g.m1069a(f3439d).m1068b();
                return jSONObject2;
            } catch (SQLiteDatabaseCorruptException unused7) {
                jSONObject = null;
            } catch (Throwable unused8) {
                jSONObject = null;
            }
        } catch (SQLiteDatabaseCorruptException unused9) {
            sQLiteDatabase = null;
            jSONObject = null;
        } catch (Throwable unused10) {
            sQLiteDatabase = null;
            jSONObject = null;
        }
        C1632g.m1069a(f3439d).m1068b();
        return jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0059, code lost:
        if (r0 == null) goto L13;
     */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m1027h() {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = C1632g.m1069a(f3439d).m1070a();
                sQLiteDatabase.beginTransaction();
                if (this.f3445j.size() > 0) {
                    for (int i = 0; i < this.f3445j.size(); i++) {
                        sQLiteDatabase.execSQL("delete from __et where rowid=" + this.f3445j.get(i));
                    }
                }
                this.f3445j.clear();
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused) {
                    }
                }
                C1632g.m1069a(f3439d).m1068b();
            }
        } catch (SQLiteDatabaseCorruptException unused2) {
            C1635h.m1066a(f3439d);
        } catch (Throwable unused3) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
        if (r0 == null) goto L6;
     */
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m1026i() {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = C1632g.m1069a(f3439d).m1070a();
                sQLiteDatabase.beginTransaction();
                sQLiteDatabase.execSQL("delete from __er");
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused) {
                    }
                }
                C1632g.m1069a(f3439d).m1068b();
            }
        } catch (SQLiteDatabaseCorruptException unused2) {
            C1635h.m1066a(f3439d);
        } catch (Throwable unused3) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0064, code lost:
        if (r1 == null) goto L12;
     */
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m1025j() {
        SQLiteDatabase sQLiteDatabase;
        if (!TextUtils.isEmpty(this.f3446k)) {
            try {
                sQLiteDatabase = C1632g.m1069a(f3439d).m1070a();
                try {
                    sQLiteDatabase.beginTransaction();
                    sQLiteDatabase.execSQL("delete from __er where __i=\"" + this.f3446k + "\"");
                    sQLiteDatabase.execSQL("delete from __et where __i=\"" + this.f3446k + "\"");
                    sQLiteDatabase.setTransactionSuccessful();
                } catch (SQLiteDatabaseCorruptException unused) {
                    try {
                        C1635h.m1066a(f3439d);
                    } finally {
                        if (sQLiteDatabase != null) {
                            try {
                                sQLiteDatabase.endTransaction();
                            } catch (Throwable unused2) {
                            }
                        }
                        C1632g.m1069a(f3439d).m1068b();
                    }
                } catch (Throwable unused3) {
                }
            } catch (SQLiteDatabaseCorruptException unused4) {
                sQLiteDatabase = null;
            } catch (Throwable unused5) {
                sQLiteDatabase = null;
            }
        }
        this.f3446k = null;
    }
}
