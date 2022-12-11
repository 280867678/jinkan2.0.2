package com.umeng.analytics.process;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.umeng.analytics.pro.C1655q;
import com.umeng.analytics.process.AbstractC1677a;
import com.umeng.analytics.process.DBFileTraversalUtil;
import com.umeng.common.C1686a;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class UMProcessDBHelper {
    public static UMProcessDBHelper mInstance;
    public Context mContext;
    public FileLockUtil mFileLock = new FileLockUtil();
    public InsertEventCallback ekvCallBack = new InsertEventCallback();

    /* loaded from: classes4.dex */
    public class InsertEventCallback implements FileLockCallback {
        public InsertEventCallback() {
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(File file, int i) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str, Object obj) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (str.startsWith(AbstractC1677a.f3686c)) {
                str = str.replaceFirst(AbstractC1677a.f3686c, "");
            }
            UMProcessDBHelper.this.insertEvents(str.replace(".db", ""), (JSONArray) obj);
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class ProcessToMainCallback implements FileLockCallback {
        public ProcessToMainCallback() {
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
            UMProcessDBHelper.this.processToMain(str.replace(".db", ""));
            return true;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str, Object obj) {
            return false;
        }
    }

    /* renamed from: com.umeng.analytics.process.UMProcessDBHelper$a */
    /* loaded from: classes4.dex */
    public class C1676a implements Serializable {

        /* renamed from: a */
        public int f3675a;

        /* renamed from: b */
        public String f3676b;

        /* renamed from: c */
        public String f3677c;

        /* renamed from: d */
        public String f3678d;

        /* renamed from: e */
        public int f3679e;

        /* renamed from: f */
        public String f3680f;

        /* renamed from: g */
        public String f3681g;

        /* renamed from: h */
        public String f3682h;

        public C1676a() {
        }
    }

    public UMProcessDBHelper() {
    }

    public UMProcessDBHelper(Context context) {
        C1686a.m825a().m824a(context);
    }

    private List<C1676a> datasAdapter(String str, JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                C1676a c1676a = new C1676a();
                c1676a.f3677c = jSONObject.optString("id");
                c1676a.f3681g = UMUtils.getAppVersionName(this.mContext);
                c1676a.f3682h = UMUtils.getAppVersionCode(this.mContext);
                c1676a.f3676b = jSONObject.optString("__i");
                c1676a.f3679e = jSONObject.optInt("__t");
                c1676a.f3680f = str;
                if (jSONObject.has("ds")) {
                    jSONObject.remove("ds");
                }
                jSONObject.put("ds", getDataSource());
                jSONObject.remove("__i");
                jSONObject.remove("__t");
                c1676a.f3678d = C1686a.m825a().m823a(jSONObject.toString());
                jSONObject.remove("ds");
                arrayList.add(c1676a);
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    private boolean dbIsExists(String str) {
        try {
            return new File(C1679b.m844b(this.mContext, str)).exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    private int getDataSource() {
        return 0;
    }

    public static UMProcessDBHelper getInstance(Context context) {
        if (mInstance == null) {
            synchronized (UMProcessDBHelper.class) {
                if (mInstance == null) {
                    mInstance = new UMProcessDBHelper(context);
                }
            }
        }
        UMProcessDBHelper uMProcessDBHelper = mInstance;
        uMProcessDBHelper.mContext = context;
        return uMProcessDBHelper;
    }

    private boolean insertEvents_(String str, List<C1676a> list) {
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return true;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase m842a = C1680c.m843a(this.mContext).m842a(str);
            try {
                try {
                    m842a.beginTransaction();
                    for (C1676a c1676a : list) {
                        try {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("__i", c1676a.f3676b);
                            contentValues.put("__e", c1676a.f3677c);
                            contentValues.put("__t", Integer.valueOf(c1676a.f3679e));
                            contentValues.put(AbstractC1677a.AbstractC1678a.f3697f, c1676a.f3680f);
                            contentValues.put("__av", c1676a.f3681g);
                            contentValues.put("__vc", c1676a.f3682h);
                            contentValues.put("__s", c1676a.f3678d);
                            m842a.insert(AbstractC1677a.AbstractC1678a.f3692a, null, contentValues);
                        } catch (Exception unused) {
                        }
                    }
                    m842a.setTransactionSuccessful();
                    try {
                        m842a.endTransaction();
                    } catch (Throwable unused2) {
                    }
                    C1680c.m843a(this.mContext).m841b(str);
                    return true;
                } catch (Exception unused3) {
                    sQLiteDatabase = m842a;
                    if (sQLiteDatabase != null) {
                        try {
                            sQLiteDatabase.endTransaction();
                        } catch (Throwable unused4) {
                        }
                    }
                    C1680c.m843a(this.mContext).m841b(str);
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                sQLiteDatabase = m842a;
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused5) {
                    }
                }
                C1680c.m843a(this.mContext).m841b(str);
                throw th;
            }
        } catch (Exception unused6) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private boolean processIsService(Context context) {
        return context.getPackageManager().getServiceInfo(new ComponentName(context, this.mContext.getClass()), 0) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processToMain(String str) {
        if (!dbIsExists(str)) {
            return;
        }
        List<C1676a> readEventByProcess = readEventByProcess(str);
        if (readEventByProcess.isEmpty() || !insertEvents_(AbstractC1677a.f3691h, readEventByProcess)) {
            return;
        }
        deleteEventDatas(str, null, readEventByProcess);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00aa, code lost:
        if (r2 != null) goto L10;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c2 A[Catch: Exception -> 0x00c5, TRY_LEAVE, TryCatch #6 {Exception -> 0x00c5, blocks: (B:37:0x00bd, B:31:0x00c2), top: B:36:0x00bd }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<C1676a> readEventByProcess(String str) {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        Exception e;
        ArrayList arrayList = new ArrayList();
        Cursor cursor2 = null;
        try {
            try {
                sQLiteDatabase = C1680c.m843a(this.mContext).m842a(str);
            } catch (Exception unused) {
            }
        } catch (Exception e2) {
            cursor = null;
            e = e2;
            sQLiteDatabase = null;
        } catch (Throwable th) {
            th = th;
            sQLiteDatabase = null;
        }
        try {
            sQLiteDatabase.beginTransaction();
            cursor = sQLiteDatabase.query(AbstractC1677a.AbstractC1678a.f3692a, null, null, null, null, null, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    try {
                        try {
                            C1676a c1676a = new C1676a();
                            c1676a.f3675a = cursor.getInt(0);
                            c1676a.f3676b = cursor.getString(cursor.getColumnIndex("__i"));
                            c1676a.f3677c = cursor.getString(cursor.getColumnIndex("__e"));
                            c1676a.f3678d = cursor.getString(cursor.getColumnIndex("__s"));
                            c1676a.f3679e = cursor.getInt(cursor.getColumnIndex("__t"));
                            c1676a.f3680f = cursor.getString(cursor.getColumnIndex(AbstractC1677a.AbstractC1678a.f3697f));
                            c1676a.f3681g = cursor.getString(cursor.getColumnIndex("__av"));
                            c1676a.f3682h = cursor.getString(cursor.getColumnIndex("__vc"));
                            arrayList.add(c1676a);
                        } catch (Exception e3) {
                            e = e3;
                            e.printStackTrace();
                            if (cursor != null) {
                                cursor.close();
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                            try {
                                cursor2.close();
                            } catch (Exception unused2) {
                                C1680c.m843a(this.mContext).m841b(str);
                                throw th;
                            }
                        }
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.endTransaction();
                        }
                        C1680c.m843a(this.mContext).m841b(str);
                        throw th;
                    }
                }
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e4) {
            cursor = null;
            e = e4;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
            }
            if (sQLiteDatabase != null) {
            }
            C1680c.m843a(this.mContext).m841b(str);
            throw th;
        }
        sQLiteDatabase.endTransaction();
        C1680c.m843a(this.mContext).m841b(str);
        return arrayList;
    }

    public void createDBByProcess(String str) {
        try {
            C1680c.m843a(this.mContext).m842a(str);
            C1680c.m843a(this.mContext).m841b(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteEventDatas(String str, String str2, List<C1676a> list) {
        SQLiteDatabase sQLiteDatabase;
        Throwable th;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SQLiteDatabase sQLiteDatabase2 = null;
        try {
            sQLiteDatabase = C1680c.m843a(this.mContext).m842a(str);
        } catch (Exception unused) {
        } catch (Throwable th2) {
            sQLiteDatabase = null;
            th = th2;
        }
        try {
            sQLiteDatabase.beginTransaction();
            int size = list.size();
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    sQLiteDatabase.execSQL("delete from __et_p where rowid=" + list.get(i).f3675a);
                }
            } else {
                sQLiteDatabase.delete(AbstractC1677a.AbstractC1678a.f3692a, null, null);
            }
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
        } catch (Exception unused2) {
            sQLiteDatabase2 = sQLiteDatabase;
            if (sQLiteDatabase2 != null) {
                sQLiteDatabase2.endTransaction();
            }
            C1680c.m843a(this.mContext).m841b(str);
        } catch (Throwable th3) {
            th = th3;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            C1680c.m843a(this.mContext).m841b(str);
            throw th;
        }
        C1680c.m843a(this.mContext).m841b(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0047, code lost:
        if (r1 == null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void deleteMainProcessEventDatasByIds(List<Integer> list) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = C1680c.m843a(this.mContext).m842a(AbstractC1677a.f3691h);
            sQLiteDatabase.beginTransaction();
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                sQLiteDatabase.delete(AbstractC1677a.AbstractC1678a.f3692a, "id=?", new String[]{String.valueOf(it.next())});
            }
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Exception unused) {
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            C1680c.m843a(this.mContext).m841b(AbstractC1677a.f3691h);
            throw th;
        }
        sQLiteDatabase.endTransaction();
        C1680c.m843a(this.mContext).m841b(AbstractC1677a.f3691h);
    }

    public void insertEvents(String str, JSONArray jSONArray) {
        if (AnalyticsConstants.SUB_PROCESS_EVENT && !TextUtils.isEmpty(str)) {
            insertEvents_(str, datasAdapter(str, jSONArray));
        }
    }

    public void insertEventsInSubProcess(String str, JSONArray jSONArray) {
        if (AnalyticsConstants.SUB_PROCESS_EVENT && !TextUtils.isEmpty(str)) {
            File file = new File(C1679b.m844b(this.mContext, str));
            if (file.exists()) {
                this.mFileLock.doFileOperateion(file, this.ekvCallBack, jSONArray);
            } else {
                insertEvents(str, jSONArray);
            }
        }
    }

    public void processDBToMain() {
        try {
            DBFileTraversalUtil.traverseDBFiles(C1679b.m847a(this.mContext), new ProcessToMainCallback(), new DBFileTraversalUtil.AbstractC1673a() { // from class: com.umeng.analytics.process.UMProcessDBHelper.1
                @Override // com.umeng.analytics.process.DBFileTraversalUtil.AbstractC1673a
                /* renamed from: a */
                public void mo848a() {
                    if (AnalyticsConstants.SUB_PROCESS_EVENT) {
                        UMWorkDispatch.sendEvent(UMProcessDBHelper.this.mContext, UMProcessDBDatasSender.UM_PROCESS_CONSTRUCTMESSAGE, UMProcessDBDatasSender.getInstance(UMProcessDBHelper.this.mContext), null);
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:86:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0187 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject readMainEvents(long j, List<Integer> list) {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        JSONObject jSONObject = new JSONObject();
        Cursor cursor2 = null;
        cursor2 = null;
        cursor2 = null;
        SQLiteDatabase sQLiteDatabase2 = null;
        try {
            try {
                sQLiteDatabase = C1680c.m843a(this.mContext).m842a(AbstractC1677a.f3691h);
            } catch (Throwable unused) {
                C1680c.m843a(this.mContext).m841b(AbstractC1677a.f3691h);
                return jSONObject;
            }
            try {
                sQLiteDatabase.beginTransaction();
                cursor2 = sQLiteDatabase.query(AbstractC1677a.AbstractC1678a.f3692a, null, null, null, null, null, null);
                if (cursor2 != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    String str = "";
                    while (cursor2.moveToNext()) {
                        int i = cursor2.getInt(cursor2.getColumnIndex("id"));
                        int i2 = cursor2.getInt(cursor2.getColumnIndex("__t"));
                        String string = cursor2.getString(cursor2.getColumnIndex("__i"));
                        String string2 = cursor2.getString(cursor2.getColumnIndex("__s"));
                        String string3 = cursor2.getString(cursor2.getColumnIndex(AbstractC1677a.AbstractC1678a.f3697f));
                        String string4 = cursor2.getString(cursor2.getColumnIndex("__av"));
                        if (!TextUtils.isEmpty(string)) {
                            if (TextUtils.isEmpty(str)) {
                                str = string4;
                            }
                            if (!TextUtils.isEmpty(string2) && i2 == 2049) {
                                JSONObject jSONObject3 = new JSONObject(C1686a.m825a().m822b(string2));
                                String optString = jSONObject3.optString("pn");
                                if (TextUtils.isEmpty(optString) || "unknown".equals(optString)) {
                                    jSONObject3.put("pn", this.mContext.getPackageName() + ":" + string3);
                                }
                                JSONArray optJSONArray = jSONObject2.has(string) ? jSONObject2.optJSONArray(string) : new JSONArray();
                                if (C1655q.m924a(jSONObject3) + C1655q.m925a(optJSONArray) <= j && str.equalsIgnoreCase(string4)) {
                                    list.add(Integer.valueOf(i));
                                    optJSONArray.put(jSONObject3);
                                    jSONObject2.put(string, optJSONArray);
                                }
                            }
                        }
                    }
                    if (jSONObject2.length() > 0) {
                        JSONArray jSONArray = new JSONArray();
                        Iterator<String> keys = jSONObject2.keys();
                        while (keys.hasNext()) {
                            JSONObject jSONObject4 = new JSONObject();
                            String next = keys.next();
                            jSONObject4.put(next, new JSONArray(jSONObject2.optString(next)));
                            if (jSONObject4.length() > 0) {
                                jSONArray.put(jSONObject4);
                            }
                        }
                        if (jSONArray.length() > 0) {
                            jSONObject.put("ekv", jSONArray);
                        }
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
                if (cursor2 != null) {
                    cursor2.close();
                }
                sQLiteDatabase.endTransaction();
            } catch (Exception unused2) {
                cursor = cursor2;
                sQLiteDatabase2 = sQLiteDatabase;
                try {
                    UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> 构建子进程事件数据异常，清除数据库数据。");
                    sQLiteDatabase2.execSQL("delete from __et_p");
                    sQLiteDatabase2.setTransactionSuccessful();
                    if (cursor != null) {
                        cursor.close();
                    }
                    sQLiteDatabase2.endTransaction();
                    C1680c.m843a(this.mContext).m841b(AbstractC1677a.f3691h);
                    return jSONObject;
                } catch (Throwable th) {
                    th = th;
                    Cursor cursor3 = cursor;
                    sQLiteDatabase = sQLiteDatabase2;
                    cursor2 = cursor3;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    if (sQLiteDatabase != null) {
                        try {
                            sQLiteDatabase.endTransaction();
                        } catch (Throwable unused3) {
                        }
                    }
                    C1680c.m843a(this.mContext).m841b(AbstractC1677a.f3691h);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                if (cursor2 != null) {
                }
                if (sQLiteDatabase != null) {
                }
                C1680c.m843a(this.mContext).m841b(AbstractC1677a.f3691h);
                throw th;
            }
        } catch (Exception unused4) {
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            sQLiteDatabase = null;
        }
    }

    public JSONObject readVersionInfoFromColumId(Integer num) {
        SQLiteDatabase sQLiteDatabase;
        JSONObject jSONObject;
        Cursor cursor = null;
        r3 = null;
        JSONObject jSONObject2 = null;
        cursor = null;
        cursor = null;
        cursor = null;
        try {
            sQLiteDatabase = C1680c.m843a(this.mContext).m842a(AbstractC1677a.f3691h);
            try {
                try {
                    sQLiteDatabase.beginTransaction();
                    Cursor query = sQLiteDatabase.query(AbstractC1677a.AbstractC1678a.f3692a, null, "rowid=?", new String[]{String.valueOf(num)}, null, null, null);
                    if (query != null) {
                        try {
                            try {
                                if (query.moveToNext()) {
                                    jSONObject = new JSONObject();
                                    try {
                                        String string = query.getString(query.getColumnIndex("__av"));
                                        String string2 = query.getString(query.getColumnIndex("__vc"));
                                        if (!TextUtils.isEmpty(string)) {
                                            jSONObject.put("__av", string);
                                        }
                                        if (!TextUtils.isEmpty(string2)) {
                                            jSONObject.put("__vc", string2);
                                        }
                                        jSONObject2 = jSONObject;
                                    } catch (Exception e) {
                                        e = e;
                                        cursor = query;
                                        e.printStackTrace();
                                        if (cursor != null) {
                                            try {
                                                cursor.close();
                                            } catch (Exception unused) {
                                                C1680c.m843a(this.mContext).m841b(AbstractC1677a.f3691h);
                                                return jSONObject;
                                            }
                                        }
                                        if (sQLiteDatabase != null) {
                                            sQLiteDatabase.endTransaction();
                                        }
                                        C1680c.m843a(this.mContext).m841b(AbstractC1677a.f3691h);
                                        return jSONObject;
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                cursor = query;
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception unused2) {
                                        C1680c.m843a(this.mContext).m841b(AbstractC1677a.f3691h);
                                        throw th;
                                    }
                                }
                                if (sQLiteDatabase != null) {
                                    sQLiteDatabase.endTransaction();
                                }
                                C1680c.m843a(this.mContext).m841b(AbstractC1677a.f3691h);
                                throw th;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            jSONObject = null;
                        }
                    }
                    if (query != null) {
                        try {
                            query.close();
                        } catch (Exception unused3) {
                        }
                    }
                    sQLiteDatabase.endTransaction();
                    C1680c.m843a(this.mContext).m841b(AbstractC1677a.f3691h);
                    return jSONObject2;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e3) {
                e = e3;
                jSONObject = null;
            }
        } catch (Exception e4) {
            e = e4;
            sQLiteDatabase = null;
            jSONObject = null;
        } catch (Throwable th3) {
            th = th3;
            sQLiteDatabase = null;
        }
    }
}
