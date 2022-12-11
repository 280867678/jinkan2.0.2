package com.arialyy.aria.orm;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.arialyy.aria.orm.annotation.Primary;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CommonUtil;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.FormattableUtils;

/* loaded from: classes3.dex */
public class DelegateUpdate extends AbsDelegate {
    private ContentValues createValues(DbEntity dbEntity) {
        List<Field> allFields = CommonUtil.getAllFields(dbEntity.getClass());
        if (allFields.size() > 0) {
            ContentValues contentValues = new ContentValues();
            try {
                for (Field field : allFields) {
                    field.setAccessible(true);
                    if (!isIgnore(dbEntity, field)) {
                        Class<?> type = field.getType();
                        contentValues.put(field.getName(), SqlUtil.encodeStr((type != Map.class || !SqlUtil.checkMap(field)) ? (type != List.class || !SqlUtil.checkList(field)) ? field.get(dbEntity) != null ? field.get(dbEntity).toString() : null : SqlUtil.list2Str(dbEntity, field) : SqlUtil.map2Str((Map) field.get(dbEntity))));
                    }
                }
                return contentValues;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private boolean isIgnore(Object obj, Field field) throws IllegalAccessException {
        Object obj2;
        if (!SqlUtil.isIgnore(field) && (obj2 = field.get(obj)) != null) {
            if ((obj2 instanceof String) && TextUtils.isEmpty(String.valueOf(obj2))) {
                return true;
            }
            if ((obj2 instanceof List) && ((List) obj2).size() == 0) {
                return true;
            }
            if ((obj2 instanceof Map) && ((Map) obj2).size() == 0) {
                return true;
            }
            if (!SqlUtil.isPrimary(field)) {
                return false;
            }
            return ((Primary) field.getAnnotation(Primary.class)).autoincrement();
        }
        return true;
    }

    public synchronized <T extends DbEntity> void delData(SQLiteDatabase sQLiteDatabase, Class<T> cls, String... strArr) {
        SqlUtil.checkOrCreateTable(sQLiteDatabase, cls);
        SQLiteDatabase checkDb = checkDb(sQLiteDatabase);
        if (!CommonUtil.checkSqlExpression(strArr)) {
            return;
        }
        String replace = ("DELETE FROM " + CommonUtil.getClassName((Class) cls) + " WHERE " + strArr[0] + StringUtils.SPACE).replace("?", FormattableUtils.SIMPLEST_FORMAT);
        int length = strArr.length - 1;
        String[] strArr2 = new String[length];
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            strArr2[i] = String.format("'%s'", SqlUtil.encodeStr(strArr[i2]));
            i = i2;
        }
        checkDb.execSQL(String.format(replace, strArr2));
    }

    public synchronized void insertData(SQLiteDatabase sQLiteDatabase, DbEntity dbEntity) {
        SqlUtil.checkOrCreateTable(sQLiteDatabase, dbEntity.getClass());
        SQLiteDatabase checkDb = checkDb(sQLiteDatabase);
        ContentValues createValues = createValues(dbEntity);
        if (createValues != null) {
            dbEntity.rowID = checkDb.insert(CommonUtil.getClassName(dbEntity), null, createValues);
        } else {
            ALog.m4191e(AbsDelegate.TAG, "保存记录失败，记录没有属性字段");
        }
    }

    public synchronized <T extends DbEntity> void insertManyData(SQLiteDatabase sQLiteDatabase, List<T> list) {
        SQLiteDatabase checkDb = checkDb(sQLiteDatabase);
        checkDb.beginTransaction();
        try {
            Class<?> cls = null;
            String str = null;
            for (T t : list) {
                if (cls == null || cls != t.getClass() || str == null) {
                    cls = t.getClass();
                    str = CommonUtil.getClassName((Class) cls);
                    SqlUtil.checkOrCreateTable(checkDb, cls);
                }
                ContentValues createValues = createValues(t);
                if (createValues == null) {
                    ALog.m4191e(AbsDelegate.TAG, "保存记录失败，记录没有属性字段");
                } else {
                    t.rowID = checkDb.insert(str, null, createValues);
                }
            }
            checkDb.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        }
        checkDb.endTransaction();
    }

    public synchronized void updateData(SQLiteDatabase sQLiteDatabase, DbEntity dbEntity) {
        SqlUtil.checkOrCreateTable(sQLiteDatabase, dbEntity.getClass());
        SQLiteDatabase checkDb = checkDb(sQLiteDatabase);
        ContentValues createValues = createValues(dbEntity);
        if (createValues != null) {
            checkDb.update(CommonUtil.getClassName(dbEntity), createValues, "rowid=?", new String[]{String.valueOf(dbEntity.rowID)});
        } else {
            ALog.m4191e(AbsDelegate.TAG, "更新记录失败，记录没有属性字段");
        }
    }

    public synchronized <T extends DbEntity> void updateManyData(SQLiteDatabase sQLiteDatabase, List<T> list) {
        SQLiteDatabase checkDb = checkDb(sQLiteDatabase);
        checkDb.beginTransaction();
        try {
            Class<?> cls = null;
            String str = null;
            for (T t : list) {
                if (cls == null || cls != t.getClass() || str == null) {
                    cls = t.getClass();
                    str = CommonUtil.getClassName((Class) cls);
                }
                ContentValues createValues = createValues(t);
                if (createValues == null) {
                    ALog.m4191e(AbsDelegate.TAG, "更新记录失败，记录没有属性字段");
                } else {
                    checkDb.update(str, createValues, "rowid=?", new String[]{String.valueOf(t.rowID)});
                }
            }
            checkDb.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        }
        checkDb.endTransaction();
    }
}
