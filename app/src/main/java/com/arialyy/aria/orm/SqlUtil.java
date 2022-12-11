package com.arialyy.aria.orm;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.arialyy.aria.core.AriaConfig;
import com.arialyy.aria.orm.annotation.Default;
import com.arialyy.aria.orm.annotation.Foreign;
import com.arialyy.aria.orm.annotation.Ignore;
import com.arialyy.aria.orm.annotation.Many;
import com.arialyy.aria.orm.annotation.NoNull;
import com.arialyy.aria.orm.annotation.One;
import com.arialyy.aria.orm.annotation.Primary;
import com.arialyy.aria.orm.annotation.Unique;
import com.arialyy.aria.orm.annotation.Wrapper;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CommonUtil;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.FormattableUtils;
import org.simpleframework.xml.transform.ClassTransform;

/* loaded from: classes3.dex */
public final class SqlUtil {
    public static final String TAG = CommonUtil.getClassName("SqlUtil");

    public static Object checkData(String str, String str2) {
        if (str.equalsIgnoreCase("java.lang.String")) {
            return str2;
        }
        if (str.equalsIgnoreCase(ClassTransform.INTEGER) || str.equals("java.lang.Integer")) {
            return Integer.valueOf(Integer.parseInt(str2));
        }
        if (str.equalsIgnoreCase(ClassTransform.DOUBLE) || str.equals("java.lang.Double")) {
            return Double.valueOf(Double.parseDouble(str2));
        }
        if (!str.equalsIgnoreCase(ClassTransform.FLOAT) && !str.equals("java.lang.Float")) {
            return null;
        }
        return Float.valueOf(Float.parseFloat(str2));
    }

    public static boolean checkDataExist(SQLiteDatabase sQLiteDatabase, Class<? extends DbEntity> cls, String... strArr) {
        SQLiteDatabase checkDb = checkDb(sQLiteDatabase);
        boolean z = false;
        if (!CommonUtil.checkSqlExpression(strArr)) {
            return false;
        }
        String replace = String.format("SELECT rowid, * FROM %s WHERE %s ", CommonUtil.getClassName((Class) cls), strArr[0]).replace("?", FormattableUtils.SIMPLEST_FORMAT);
        int length = strArr.length - 1;
        String[] strArr2 = new String[length];
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            strArr2[i] = String.format("'%s'", encodeStr(strArr[i2]));
            i = i2;
        }
        Cursor rawQuery = checkDb.rawQuery(String.format(replace, strArr2), null);
        if (rawQuery.getCount() > 0) {
            z = true;
        }
        closeCursor(rawQuery);
        return z;
    }

    public static SQLiteDatabase checkDb(SQLiteDatabase sQLiteDatabase) {
        return (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) ? SqlHelper.getInstance().getDb() : sQLiteDatabase;
    }

    public static boolean checkList(Field field) {
        if (CommonUtil.getListParamType(field) == String.class) {
            return true;
        }
        ALog.m4192d(TAG, "map参数错误，支持List<String>的参数字段");
        return false;
    }

    public static boolean checkMap(Field field) {
        Class[] mapParamType = CommonUtil.getMapParamType(field);
        if (mapParamType == null || mapParamType[0] == null || mapParamType[1] == null || mapParamType[0] != String.class || mapParamType[1] != String.class) {
            ALog.m4192d(TAG, "map参数错误，支持Map<String,String>的参数字段");
            return false;
        }
        return true;
    }

    public static void checkOrCreateTable(SQLiteDatabase sQLiteDatabase, Class<? extends DbEntity> cls) {
        if (!tableExists(sQLiteDatabase, cls)) {
            createTable(sQLiteDatabase, cls);
        }
    }

    public static void clean(SQLiteDatabase sQLiteDatabase, Class<? extends DbEntity> cls) {
        SQLiteDatabase checkDb = checkDb(sQLiteDatabase);
        String className = CommonUtil.getClassName((Class) cls);
        if (tableExists(checkDb, cls)) {
            checkDb.execSQL("DELETE FROM " + className);
        }
    }

    public static void closeCursor(Cursor cursor) {
        synchronized (AbsDelegate.class) {
            if (cursor != null) {
                if (!cursor.isClosed()) {
                    try {
                        cursor.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void createTable(SQLiteDatabase sQLiteDatabase, Class<? extends DbEntity> cls) {
        Class<?> type;
        String columnType;
        SQLiteDatabase checkDb = checkDb(sQLiteDatabase);
        List<Field> allFields = CommonUtil.getAllFields(cls);
        if (allFields == null || allFields.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("CREATE TABLE IF NOT EXISTS ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(CommonUtil.getClassName((Class) cls));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" (");
        for (Field field : allFields) {
            field.setAccessible(true);
            if (!isIgnore(field) && (columnType = getColumnType((type = field.getType()))) != null) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(field.getName());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(StringUtils.SPACE);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(columnType);
                if (isPrimary(field)) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" PRIMARY KEY");
                    if (((Primary) field.getAnnotation(Primary.class)).autoincrement() && (type == Integer.TYPE || type == Integer.class)) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" AUTOINCREMENT");
                    }
                }
                if (isForeign(field)) {
                    arrayList.add(field);
                }
                if (isNoNull(field)) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" NOT NULL");
                }
                if (isDefault(field)) {
                    Default r4 = (Default) field.getAnnotation(Default.class);
                    if (!TextUtils.isEmpty(r4.value())) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" ERROR ");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("'");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(r4.value());
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("'");
                    }
                }
                if (isUnique(field)) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" UNIQUE");
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(",");
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Field field2 = (Field) it.next();
            Foreign foreign = (Foreign) field2.getAnnotation(Foreign.class);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("FOREIGN KEY (");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(field2.getName());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(") REFERENCES ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(CommonUtil.getClassName((Class) foreign.parent()));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("(");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(foreign.column());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
            ActionPolicy onUpdate = foreign.onUpdate();
            ActionPolicy onDelete = foreign.onDelete();
            if (onUpdate != ActionPolicy.NO_ACTION) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" ON UPDATE ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(onUpdate.function);
            }
            if (onDelete != ActionPolicy.NO_ACTION) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" ON DELETE ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(onUpdate.function);
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(",");
        }
        String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        String str = sb.substring(0, sb.length() - 1) + ");";
        ALog.m4192d(TAG, "创建表的sql：" + str);
        checkDb.execSQL(str);
    }

    public static void dropTable(SQLiteDatabase sQLiteDatabase, String str) {
        checkDb(sQLiteDatabase).execSQL(String.format("DROP TABLE IF EXISTS %s", str));
    }

    public static String encodeStr(String str) {
        return URLEncoder.encode(str.replaceAll("\\\\+", "%2B"));
    }

    public static List<Field> getAllNotIgnoreField(Class cls) {
        List<Field> allFields = CommonUtil.getAllFields(cls);
        ArrayList arrayList = new ArrayList();
        if (allFields == null || allFields.size() <= 0) {
            return null;
        }
        for (Field field : allFields) {
            field.setAccessible(true);
            if (!isIgnore(field)) {
                arrayList.add(field);
            }
        }
        return arrayList;
    }

    public static String getColumnType(Class cls) {
        if (cls == String.class || cls.isEnum()) {
            return "VARCHAR";
        }
        if (cls == Integer.TYPE || cls == Integer.class) {
            return "INTEGER";
        }
        if (cls == Float.TYPE || cls == Float.class) {
            return "FLOAT";
        }
        if (cls == Double.TYPE || cls == Double.class) {
            return "DOUBLE";
        }
        if (cls == Long.TYPE || cls == Long.class) {
            return "BIGINT";
        }
        if (cls == Boolean.TYPE || cls == Boolean.class) {
            return "BOOLEAN";
        }
        if (cls == Date.class || cls == java.sql.Date.class) {
            return "DATA";
        }
        if (cls == Byte.TYPE || cls == Byte.class) {
            return "BLOB";
        }
        if (cls != Map.class && cls != List.class) {
            return null;
        }
        return "TEXT";
    }

    public static String getColumnTypeByFieldName(Class cls, String str) {
        for (Field field : CommonUtil.getAllFields(cls)) {
            if (field.getName().equals(str)) {
                return getColumnType(field.getType());
            }
        }
        return null;
    }

    public static List<String> getColumns(Class<? extends DbEntity> cls) {
        ArrayList arrayList = new ArrayList();
        for (Field field : CommonUtil.getAllFields(cls)) {
            field.setAccessible(true);
            if (!isIgnore(field)) {
                arrayList.add(field.getName());
            }
        }
        return arrayList;
    }

    public static String getPrimaryName(Class<? extends DbEntity> cls) {
        List<Field> allFields = CommonUtil.getAllFields(cls);
        if (allFields == null || allFields.isEmpty()) {
            return null;
        }
        for (Field field : allFields) {
            field.setAccessible(true);
            if (isPrimary(field)) {
                return field.getName();
            }
        }
        return null;
    }

    public static boolean isDefault(Field field) {
        return ((Default) field.getAnnotation(Default.class)) != null;
    }

    public static boolean isForeign(Field field) {
        return ((Foreign) field.getAnnotation(Foreign.class)) != null;
    }

    public static boolean isIgnore(Field field) {
        Ignore ignore = (Ignore) field.getAnnotation(Ignore.class);
        int modifiers = field.getModifiers();
        String name = field.getName();
        return (ignore != null && ignore.value()) || name.equals("rowID") || name.equals(AriaConfig.IGNORE_CLASS_KLASS) || name.equals(AriaConfig.IGNORE_CLASS_MONITOR) || field.isSynthetic() || Modifier.isStatic(modifiers) || Modifier.isFinal(modifiers);
    }

    public static boolean isMany(Field field) {
        return ((Many) field.getAnnotation(Many.class)) != null;
    }

    public static boolean isNoNull(Field field) {
        return ((NoNull) field.getAnnotation(NoNull.class)) != null;
    }

    public static boolean isOne(Field field) {
        return ((One) field.getAnnotation(One.class)) != null;
    }

    public static boolean isPrimary(Field field) {
        return ((Primary) field.getAnnotation(Primary.class)) != null;
    }

    public static boolean isUnique(Field field) {
        return ((Unique) field.getAnnotation(Unique.class)) != null;
    }

    public static boolean isWrapper(Class<? extends AbsDbWrapper> cls) {
        return ((Wrapper) cls.getAnnotation(Wrapper.class)) != null;
    }

    public static String list2Str(DbEntity dbEntity, Field field) throws IllegalAccessException {
        List<Object> list = (List) field.get(dbEntity);
        if (list == null || list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : list) {
            sb.append(obj);
            sb.append("$$");
        }
        return sb.toString();
    }

    public static String map2Str(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (String str : map.keySet()) {
            sb.append(CommonUtil.encryptBASE64(str));
            sb.append("$");
            sb.append(CommonUtil.encryptBASE64(map.get(str)));
            sb.append(",");
        }
        String sb2 = sb.toString();
        if (!TextUtils.isEmpty(sb2)) {
            sb2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb2, -1, 0);
        }
        return map.size() != 0 ? outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb2, "_&_decode_&_") : sb2;
    }

    public static List str2List(String str, Field field) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("\\$\\$");
        ArrayList arrayList = new ArrayList();
        Class listParamType = CommonUtil.getListParamType(field);
        if (listParamType != null) {
            String name = listParamType.getName();
            for (String str2 : split) {
                arrayList.add(checkData(name, str2));
            }
        }
        return arrayList;
    }

    public static Map<String, String> str2Map(String str) {
        boolean z;
        String str2;
        String str3;
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        if (str.endsWith("_&_decode_&_")) {
            str = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, -12, 0);
            z = true;
        } else {
            z = false;
        }
        for (String str4 : str.split(",")) {
            String[] split = str4.split("\\$");
            if (z) {
                str2 = CommonUtil.decryptBASE64(split[0]);
                str3 = CommonUtil.decryptBASE64(split[1]);
            } else {
                str2 = split[0];
                str3 = split[1];
            }
            hashMap.put(str2, str3);
        }
        return hashMap;
    }

    public static boolean tableExists(SQLiteDatabase sQLiteDatabase, Class<? extends DbEntity> cls) {
        return tableExists(sQLiteDatabase, CommonUtil.getClassName((Class) cls));
    }

    public static boolean tableExists(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursor = null;
        try {
            try {
                cursor = checkDb(sQLiteDatabase).rawQuery(String.format("SELECT COUNT(*) FROM sqlite_master WHERE type='table' AND name='%s'", str), null);
                if (cursor != null && cursor.moveToNext()) {
                    if (cursor.getInt(0) > 0) {
                        return true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        } finally {
            closeCursor(cursor);
        }
    }
}
