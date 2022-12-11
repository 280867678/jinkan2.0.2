package com.arialyy.aria.orm;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.Person;
import com.arialyy.aria.core.TaskRecord;
import com.arialyy.aria.core.ThreadRecord;
import com.arialyy.aria.core.download.DownloadEntity;
import com.arialyy.aria.core.download.M3U8Entity;
import com.arialyy.aria.core.upload.UploadEntity;
import com.arialyy.aria.util.ALog;
import com.stub.StubApp;
import com.tencent.smtt.sdk.TbsReaderView;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class SqlHelper extends SQLiteOpenHelper {
    public static volatile SqlHelper INSTANCE = null;
    public static final String TAG = "SqlHelper";
    public static boolean mainTmpDirSet;
    public Context mContext;

    public SqlHelper(Context context) {
        super(context, DBConfig.DB_NAME, (SQLiteDatabase.CursorFactory) null, DBConfig.VERSION);
        this.mContext = context;
    }

    private void addTaskRecordType(SQLiteDatabase sQLiteDatabase) {
        int i;
        try {
            SqlUtil.checkOrCreateTable(sQLiteDatabase, ThreadRecord.class);
            SqlUtil.checkOrCreateTable(sQLiteDatabase, TaskRecord.class);
            SqlUtil.checkOrCreateTable(sQLiteDatabase, UploadEntity.class);
            SqlUtil.checkOrCreateTable(sQLiteDatabase, DownloadEntity.class);
            sQLiteDatabase.beginTransaction();
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT downloadPath, url FROM DownloadEntity", null);
            while (true) {
                int i2 = 3;
                if (!rawQuery.moveToNext()) {
                    break;
                }
                String string = rawQuery.getString(0);
                String string2 = rawQuery.getString(1);
                if (!string2.startsWith("ftp") && !string2.startsWith("sftp")) {
                    if (SqlUtil.tableExists(sQLiteDatabase, M3U8Entity.class)) {
                        Cursor rawQuery2 = sQLiteDatabase.rawQuery("SELECT isLive FROM M3U8Entity WHERE filePath=\"" + SqlUtil.encodeStr(string) + "\"", null);
                        if (rawQuery2.moveToNext()) {
                            String string3 = rawQuery2.getString(0);
                            if (!TextUtils.isEmpty(string3) && Boolean.valueOf(string3).booleanValue()) {
                                i2 = 8;
                            }
                            i2 = 7;
                        } else {
                            i2 = 1;
                        }
                        rawQuery2.close();
                    } else {
                        i2 = 1;
                    }
                }
                sQLiteDatabase.execSQL("UPDATE DownloadEntity SET taskType=? WHERE downloadPath=?", new Object[]{Integer.valueOf(i2), string});
                sQLiteDatabase.execSQL("UPDATE TaskRecord SET taskType=? WHERE filePath=?", new Object[]{Integer.valueOf(i2), string});
                sQLiteDatabase.execSQL("UPDATE ThreadRecord SET threadType=? WHERE taskKey=?", new Object[]{Integer.valueOf(i2), string});
            }
            rawQuery.close();
            Cursor rawQuery3 = sQLiteDatabase.rawQuery("SELECT filePath, url FROM UploadEntity", null);
            while (rawQuery3.moveToNext()) {
                String string4 = rawQuery3.getString(rawQuery3.getColumnIndex(TbsReaderView.KEY_FILE_PATH));
                String string5 = rawQuery3.getString(rawQuery3.getColumnIndex("url"));
                if (!string5.startsWith("ftp") && !string5.startsWith("sftp")) {
                    i = 1;
                    sQLiteDatabase.execSQL("UPDATE UploadEntity SET taskType=? WHERE filePath=?", new Object[]{Integer.valueOf(i), string4});
                    sQLiteDatabase.execSQL("UPDATE TaskRecord SET taskType=? WHERE filePath=?", new Object[]{Integer.valueOf(i), string4});
                    sQLiteDatabase.execSQL("UPDATE ThreadRecord SET threadType=? WHERE taskKey=?", new Object[]{Integer.valueOf(i), string4});
                }
                i = 3;
                sQLiteDatabase.execSQL("UPDATE UploadEntity SET taskType=? WHERE filePath=?", new Object[]{Integer.valueOf(i), string4});
                sQLiteDatabase.execSQL("UPDATE TaskRecord SET taskType=? WHERE filePath=?", new Object[]{Integer.valueOf(i), string4});
                sQLiteDatabase.execSQL("UPDATE ThreadRecord SET threadType=? WHERE taskKey=?", new Object[]{Integer.valueOf(i), string4});
            }
            rawQuery3.close();
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    private void createDbCacheDir() {
        String str = this.mContext.getCacheDir().getPath() + "/AriaDbCacheDir";
        ALog.m4192d(TAG, new File(str).mkdir() + "");
        super.getReadableDatabase().execSQL("PRAGMA temp_store_directory = '" + str + "'");
        mainTmpDirSet = true;
    }

    private void delRepeatThreadRecord(SQLiteDatabase sQLiteDatabase) {
        SqlUtil.checkOrCreateTable(sQLiteDatabase, ThreadRecord.class);
        ALog.m4192d(TAG, "DELETE FROM ThreadRecord WHERE (rowid) IN (SELECT rowid FROM ThreadRecord GROUP BY taskKey, threadId, endLocation HAVING COUNT(*) > 1) AND rowid NOT IN (SELECT MIN(rowid) FROM ThreadRecord GROUP BY taskKey, threadId, endLocation HAVING COUNT(*)> 1)");
        sQLiteDatabase.execSQL("DELETE FROM ThreadRecord WHERE (rowid) IN (SELECT rowid FROM ThreadRecord GROUP BY taskKey, threadId, endLocation HAVING COUNT(*) > 1) AND rowid NOT IN (SELECT MIN(rowid) FROM ThreadRecord GROUP BY taskKey, threadId, endLocation HAVING COUNT(*)> 1)");
    }

    private List<String> getDiffColumn(List<String> list, List<String> list2) {
        ArrayList arrayList = new ArrayList(list2);
        arrayList.removeAll(list);
        return arrayList;
    }

    public static SqlHelper getInstance() {
        return INSTANCE;
    }

    private List<String> getNewColumn(List<String> list, List<String> list2) {
        ArrayList arrayList = new ArrayList(list);
        arrayList.removeAll(list2);
        return arrayList;
    }

    private void handle360AriaUpdate(SQLiteDatabase sQLiteDatabase) {
        String[] strArr = {"UploadTaskEntity", "DownloadTaskEntity", "DownloadGroupTaskEntity"};
        for (int i = 0; i < 3; i++) {
            String str = strArr[i];
            if (SqlUtil.tableExists(sQLiteDatabase, str)) {
                SqlUtil.dropTable(sQLiteDatabase, str);
            }
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put("groupName", "groupHash");
        hashMap.put("DownloadEntity", hashMap2);
        hashMap.put("DownloadGroupEntity", hashMap2);
        HashMap hashMap3 = new HashMap();
        hashMap3.put("dGroupName", "dGroupHash");
        hashMap.put("TaskRecord", hashMap3);
        HashMap hashMap4 = new HashMap();
        hashMap4.put(Person.KEY_KEY, "taskKey");
        hashMap.put("ThreadRecord", hashMap4);
        handleDbUpdate(sQLiteDatabase, hashMap);
        delRepeatThreadRecord(sQLiteDatabase);
    }

    private void handle365Update(SQLiteDatabase sQLiteDatabase) {
        SqlUtil.checkOrCreateTable(sQLiteDatabase, ThreadRecord.class);
        sQLiteDatabase.execSQL("UPDATE ThreadRecord SET threadId=0 WHERE threadId=-1");
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put(Person.KEY_KEY, "taskKey");
        hashMap.put("ThreadRecord", hashMap2);
        handleDbUpdate(sQLiteDatabase, hashMap);
        delRepeatThreadRecord(sQLiteDatabase);
    }

    private void handle366Update(SQLiteDatabase sQLiteDatabase) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put(Person.KEY_KEY, "taskKey");
        hashMap.put("ThreadRecord", hashMap2);
        handleDbUpdate(sQLiteDatabase, hashMap);
        delRepeatThreadRecord(sQLiteDatabase);
    }

    private void handleDbUpdate(SQLiteDatabase sQLiteDatabase, Map<String, Map<String, String>> map) {
        Map<String, String> map2;
        String str;
        String str2;
        if (sQLiteDatabase == null) {
            str2 = "db 为 null";
        } else if (sQLiteDatabase.isOpen()) {
            try {
                try {
                    sQLiteDatabase.beginTransaction();
                    for (String str3 : DBConfig.mapping.keySet()) {
                        Class<? extends DbEntity> cls = DBConfig.mapping.get(str3);
                        if (SqlUtil.tableExists(sQLiteDatabase, cls)) {
                            Cursor rawQuery = sQLiteDatabase.rawQuery(String.format("PRAGMA table_info(%s)", str3), null);
                            List<String> columns = SqlUtil.getColumns(cls);
                            ArrayList arrayList = new ArrayList();
                            while (rawQuery.moveToNext()) {
                                arrayList.add(rawQuery.getString(rawQuery.getColumnIndex("name")));
                            }
                            rawQuery.close();
                            List<String> newColumn = getNewColumn(columns, arrayList);
                            if (map != null) {
                                map2 = map.get(str3);
                                if (map2 != null) {
                                    Iterator<String> it = newColumn.iterator();
                                    while (it.hasNext()) {
                                        if (map2.get(it.next()) != null) {
                                            it.remove();
                                        }
                                    }
                                }
                            } else {
                                map2 = null;
                            }
                            int i = 3;
                            if (newColumn.size() > 0) {
                                for (String str4 : newColumn) {
                                    Object[] objArr = new Object[i];
                                    objArr[0] = str3;
                                    objArr[1] = str4;
                                    objArr[2] = SqlUtil.getColumnTypeByFieldName(cls, str4);
                                    String format = String.format("ALTER TABLE %s ADD COLUMN %s %s", objArr);
                                    ALog.m4192d(TAG, "添加表字段的sql：" + format);
                                    sQLiteDatabase.execSQL(format);
                                    i = 3;
                                }
                            }
                            sQLiteDatabase.execSQL(String.format("ALTER TABLE %s RENAME TO %s_temp", str3, str3));
                            SqlUtil.createTable(sQLiteDatabase, cls);
                            Cursor rawQuery2 = sQLiteDatabase.rawQuery(String.format("SELECT COUNT(*) FROM %s_temp", str3), null);
                            rawQuery2.moveToFirst();
                            long j = rawQuery2.getLong(0);
                            rawQuery2.close();
                            if (j > 0) {
                                List<String> diffColumn = getDiffColumn(columns, arrayList);
                                StringBuilder sb = new StringBuilder();
                                if (map != null) {
                                    map2 = map.get(str3);
                                }
                                Iterator it2 = arrayList.iterator();
                                while (it2.hasNext()) {
                                    String str5 = (String) it2.next();
                                    if (diffColumn.isEmpty() || !diffColumn.contains(str5) || (map2 != null && map2.containsKey(str5))) {
                                        sb.append(str5);
                                        sb.append(",");
                                    }
                                }
                                String sb2 = sb.toString();
                                String substring = sb2.substring(0, sb2.length() - 1);
                                if (map2 == null || map2.isEmpty()) {
                                    str = substring;
                                } else {
                                    str = substring;
                                    for (String str6 : map2.keySet()) {
                                        if (str.contains(str6)) {
                                            str = str.replace(str6, map2.get(str6));
                                        }
                                    }
                                }
                                String format2 = String.format("INSERT INTO %s (%s) SELECT %s FROM %s_temp", str3, str, substring, str3);
                                ALog.m4192d(TAG, "恢复数据的sql：" + format2);
                                sQLiteDatabase.execSQL(format2);
                            }
                            SqlUtil.dropTable(sQLiteDatabase, str3 + "_temp");
                        } else {
                            SqlUtil.createTable(sQLiteDatabase, cls);
                        }
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return;
            } finally {
                sQLiteDatabase.endTransaction();
            }
        } else {
            str2 = "db已关闭";
        }
        ALog.m4191e(TAG, str2);
    }

    private void handleLowAriaUpdate(SQLiteDatabase sQLiteDatabase) {
        String[] strArr = {"UploadTaskEntity", "DownloadTaskEntity", "DownloadGroupTaskEntity"};
        for (int i = 0; i < 3; i++) {
            String str = strArr[i];
            if (SqlUtil.tableExists(sQLiteDatabase, str)) {
                SqlUtil.dropTable(sQLiteDatabase, str);
            }
        }
        String[] strArr2 = {"DownloadEntity", "DownloadGroupEntity"};
        String[] strArr3 = {"downloadPath", "groupName"};
        int i2 = 0;
        for (int i3 = 0; i3 < 2; i3++) {
            String str2 = strArr2[i3];
            if (SqlUtil.tableExists(sQLiteDatabase, str2)) {
                String str3 = strArr3[i2];
                String format = String.format("DELETE FROM %s WHERE %s='' OR %s IS NULL", str2, str3, str3);
                ALog.m4192d(TAG, format);
                sQLiteDatabase.execSQL(format);
                String format2 = String.format("DELETE FROM %s WHERE %s IN(SELECT %s FROM %s GROUP BY %s HAVING COUNT(%s) > 1)", str2, str3, str3, str2, str3, str3);
                ALog.m4192d(TAG, format2);
                sQLiteDatabase.execSQL(format2);
                i2++;
            }
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put("groupName", "groupHash");
        hashMap2.put("downloadUrl", "url");
        hashMap2.put("isDownloadComplete", "isComplete");
        hashMap.put("DownloadEntity", hashMap2);
        HashMap hashMap3 = new HashMap();
        hashMap3.put("groupName", "groupHash");
        hashMap.put("DownloadGroupEntity", hashMap3);
        handleDbUpdate(sQLiteDatabase, hashMap);
    }

    public static synchronized SqlHelper init(Context context) {
        SqlHelper sqlHelper;
        synchronized (SqlHelper.class) {
            if (INSTANCE == null) {
                synchronized (SqlHelper.class) {
                    INSTANCE = new SqlHelper(StubApp.getOrigApplicationContext(context.getApplicationContext()));
                }
            }
            sqlHelper = INSTANCE;
        }
        return sqlHelper;
    }

    public SQLiteDatabase getDb() {
        SQLiteDatabase openDatabase;
        if (Build.VERSION.SDK_INT >= 28) {
            setOpenParams(new SQLiteDatabase.OpenParams.Builder().setOpenFlags(268435472).build());
        } else {
            File databasePath = this.mContext.getDatabasePath(DBConfig.DB_NAME);
            if (databasePath.exists()) {
                getReadableDatabase().close();
                openDatabase = SQLiteDatabase.openDatabase(databasePath.getPath(), null, 268435472);
                openDatabase.enableWriteAheadLogging();
                return openDatabase;
            }
        }
        openDatabase = getWritableDatabase();
        openDatabase.enableWriteAheadLogging();
        return openDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getReadableDatabase() {
        if (!mainTmpDirSet) {
            createDbCacheDir();
            return super.getReadableDatabase();
        }
        return super.getReadableDatabase();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getWritableDatabase() {
        if (!mainTmpDirSet) {
            createDbCacheDir();
            return super.getWritableDatabase();
        }
        return super.getWritableDatabase();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        super.onConfigure(sQLiteDatabase);
        sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        for (String str : DBConfig.mapping.keySet()) {
            Class<? extends DbEntity> cls = DBConfig.mapping.get(str);
            if (!SqlUtil.tableExists(sQLiteDatabase, cls)) {
                SqlUtil.createTable(sQLiteDatabase, cls);
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i > i2) {
            handleDbUpdate(sQLiteDatabase, null);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i < i2) {
            if (i < 31) {
                handleLowAriaUpdate(sQLiteDatabase);
            } else if (i < 45) {
                handle360AriaUpdate(sQLiteDatabase);
            } else if (i < 51) {
                handle365Update(sQLiteDatabase);
            } else if (i < 53) {
                handle366Update(sQLiteDatabase);
            } else {
                handleDbUpdate(sQLiteDatabase, null);
            }
            if (i2 != 57) {
                return;
            }
            addTaskRecordType(sQLiteDatabase);
        }
    }
}
