package org.litepal.util;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.tvspark.outline;
import org.litepal.exceptions.DatabaseGenerateException;
import org.litepal.tablemanager.model.ColumnModel;
import org.litepal.tablemanager.model.TableModel;
import org.litepal.util.Const;

/* loaded from: classes5.dex */
public class DBUtility {
    public static final String KEYWORDS_COLUMN_SUFFIX = "_lpcolumn";
    public static final String REG_COLLECTION = "\\s+(not\\s+)?(in)\\s*\\(";
    public static final String REG_FUZZY = "\\s+(not\\s+)?(like|between)\\s+";
    public static final String REG_OPERATOR = "\\s*(=|!=|<>|<|>)";
    public static final String SQLITE_KEYWORDS = ",abort,add,after,all,alter,and,as,asc,autoincrement,before,begin,between,by,cascade,check,collate,column,commit,conflict,constraint,create,cross,database,deferrable,deferred,delete,desc,distinct,drop,each,end,escape,except,exclusive,exists,foreign,from,glob,group,having,in,index,inner,insert,intersect,into,is,isnull,join,like,limit,match,natural,not,notnull,null,of,offset,on,or,order,outer,plan,pragma,primary,query,raise,references,regexp,reindex,release,rename,replace,restrict,right,rollback,row,savepoint,select,set,table,temp,temporary,then,to,transaction,trigger,union,unique,update,using,vacuum,values,view,virtual,when,where,";
    public static final String TAG = "DBUtility";

    public static String convertOrderByClauseToValidName(String str) {
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.trim().toLowerCase(Locale.US);
            if (!lowerCase.contains(",")) {
                return convertOrderByItem(lowerCase);
            }
            String[] split = lowerCase.split(",");
            StringBuilder sb = new StringBuilder();
            int length = split.length;
            int i = 0;
            boolean z = false;
            while (i < length) {
                String str2 = split[i];
                if (z) {
                    sb.append(",");
                }
                sb.append(convertOrderByItem(str2));
                i++;
                z = true;
            }
            return sb.toString();
        }
        return null;
    }

    public static String convertOrderByItem(String str) {
        String str2 = "";
        if (str.endsWith("asc")) {
            str = str.replace("asc", str2).trim();
            str2 = " asc";
        } else if (str.endsWith("desc")) {
            str = str.replace("desc", str2).trim();
            str2 = " desc";
        }
        return convertToValidColumnName(str) + str2;
    }

    public static String[] convertSelectClauseToValidNames(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        String[] strArr2 = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr2[i] = convertToValidColumnName(strArr[i]);
        }
        return strArr2;
    }

    public static String convertToValidColumnName(String str) {
        return isFieldNameConflictWithSQLiteKeywords(str) ? outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, KEYWORDS_COLUMN_SUFFIX) : str;
    }

    public static String convertWhereClauseToColumnName(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                Matcher matcher = Pattern.compile("(\\w+\\s*(=|!=|<>|<|>)|\\w+\\s+(not\\s+)?(like|between)\\s+|\\w+\\s+(not\\s+)?(in)\\s*\\()").matcher(str);
                while (matcher.find()) {
                    String group = matcher.group();
                    String replaceAll = group.replaceAll("(\\s*(=|!=|<>|<|>)|\\s+(not\\s+)?(like|between)\\s+|\\s+(not\\s+)?(in)\\s*\\()", "");
                    String replace = group.replace(replaceAll, "");
                    String convertToValidColumnName = convertToValidColumnName(replaceAll);
                    matcher.appendReplacement(stringBuffer, convertToValidColumnName + replace);
                }
                matcher.appendTail(stringBuffer);
                return stringBuffer.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    public static List<String> findAllTableNames(SQLiteDatabase sQLiteDatabase) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                cursor = sQLiteDatabase.rawQuery("select * from sqlite_master where type = ?", new String[]{"table"});
                if (!cursor.moveToFirst()) {
                    cursor.close();
                    return arrayList;
                }
                do {
                    String string = cursor.getString(cursor.getColumnIndexOrThrow("tbl_name"));
                    if (!arrayList.contains(string)) {
                        arrayList.add(string);
                    }
                } while (cursor.moveToNext());
                cursor.close();
                return arrayList;
            } catch (Exception e) {
                e.printStackTrace();
                throw new DatabaseGenerateException(e.getMessage());
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public static TableModel findPragmaTableInfo(String str, SQLiteDatabase sQLiteDatabase) {
        if (isTableExists(str, sQLiteDatabase)) {
            List<String> findUniqueColumns = findUniqueColumns(str, sQLiteDatabase);
            TableModel tableModel = new TableModel();
            tableModel.setTableName(str);
            Cursor cursor = null;
            try {
                try {
                    cursor = sQLiteDatabase.rawQuery(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("pragma table_info(", str, ")"), null);
                    if (!cursor.moveToFirst()) {
                        cursor.close();
                        return tableModel;
                    }
                    do {
                        ColumnModel columnModel = new ColumnModel();
                        String string = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                        String string2 = cursor.getString(cursor.getColumnIndexOrThrow("type"));
                        boolean z = true;
                        if (cursor.getInt(cursor.getColumnIndexOrThrow("notnull")) == 1) {
                            z = false;
                        }
                        boolean contains = findUniqueColumns.contains(string);
                        String string3 = cursor.getString(cursor.getColumnIndexOrThrow("dflt_value"));
                        columnModel.setColumnName(string);
                        columnModel.setColumnType(string2);
                        columnModel.setNullable(z);
                        columnModel.setUnique(contains);
                        String str2 = "";
                        if (string3 != null) {
                            str2 = string3.replace("'", str2);
                        }
                        columnModel.setDefaultValue(str2);
                        tableModel.addColumnModel(columnModel);
                    } while (cursor.moveToNext());
                    cursor.close();
                    return tableModel;
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new DatabaseGenerateException(e.getMessage());
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
        throw new DatabaseGenerateException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DatabaseGenerateException.TABLE_DOES_NOT_EXIST_WHEN_EXECUTING, str));
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<String> findUniqueColumns(String str, SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        ArrayList arrayList = new ArrayList();
        Cursor cursor2 = null;
        try {
            Cursor rawQuery = sQLiteDatabase.rawQuery("pragma index_list(" + str + ")", null);
            try {
                if (rawQuery.moveToFirst()) {
                    cursor = null;
                    do {
                        try {
                            if (rawQuery.getInt(rawQuery.getColumnIndexOrThrow("unique")) == 1) {
                                cursor = sQLiteDatabase.rawQuery("pragma index_info(" + rawQuery.getString(rawQuery.getColumnIndexOrThrow("name")) + ")", null);
                                if (cursor.moveToFirst()) {
                                    arrayList.add(cursor.getString(cursor.getColumnIndexOrThrow("name")));
                                }
                            }
                        } catch (Exception e) {
                            e = e;
                            cursor2 = rawQuery;
                            try {
                                e.printStackTrace();
                                throw new DatabaseGenerateException(e.getMessage());
                            } catch (Throwable th) {
                                th = th;
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                if (cursor != null) {
                                    cursor.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            cursor2 = rawQuery;
                            if (cursor2 != null) {
                            }
                            if (cursor != null) {
                            }
                            throw th;
                        }
                    } while (rawQuery.moveToNext());
                    cursor2 = cursor;
                }
                rawQuery.close();
                if (cursor2 != null) {
                    cursor2.close();
                }
                return arrayList;
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
            }
        } catch (Exception e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th4) {
            th = th4;
            cursor = null;
        }
    }

    public static String getGenericTableName(String str, String str2) {
        String tableNameByClassName = getTableNameByClassName(str);
        return BaseUtility.changeCase(tableNameByClassName + "_" + str2);
    }

    public static String getGenericValueIdColumnName(String str) {
        return BaseUtility.changeCase(getTableNameByClassName(str) + "_id");
    }

    public static String getIntermediateTableName(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return (str.toLowerCase(Locale.US).compareTo(str2.toLowerCase(Locale.US)) <= 0 ? outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "_", str2) : outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, "_", str)).toString();
    }

    public static String getM2MSelfRefColumnName(Field field) {
        return BaseUtility.changeCase(field.getName() + "_id");
    }

    public static String getTableNameByClassName(String str) {
        if (TextUtils.isEmpty(str) || '.' == str.charAt(str.length() - 1)) {
            return null;
        }
        return str.substring(str.lastIndexOf(".") + 1);
    }

    public static String getTableNameByForeignColumn(String str) {
        if (TextUtils.isEmpty(str) || !str.toLowerCase(Locale.US).endsWith("_id")) {
            return null;
        }
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, -3, 0);
    }

    public static List<String> getTableNameListByClassNameList(List<String> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (String str : list) {
                arrayList.add(getTableNameByClassName(str));
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0051, code lost:
        if (r0 == null) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isColumnExists(String str, String str2, SQLiteDatabase sQLiteDatabase) {
        boolean z = false;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = sQLiteDatabase.rawQuery("pragma table_info(" + str2 + ")", null);
                if (cursor.moveToFirst()) {
                    while (true) {
                        if (!str.equalsIgnoreCase(cursor.getString(cursor.getColumnIndexOrThrow("name")))) {
                            if (!cursor.moveToNext()) {
                                break;
                            }
                        } else {
                            z = true;
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            cursor.close();
            return z;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public static boolean isFieldNameConflictWithSQLiteKeywords(String str) {
        if (!TextUtils.isEmpty(str)) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(",");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str.toLowerCase(Locale.US));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(",");
            return SQLITE_KEYWORDS.contains(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003d, code lost:
        if (r0.getInt(r0.getColumnIndexOrThrow("type")) != 2) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003f, code lost:
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0043, code lost:
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isGenericTable(String str, SQLiteDatabase sQLiteDatabase) {
        if (TextUtils.isEmpty(str) || !str.matches("[0-9a-zA-Z]+_[0-9a-zA-Z]+")) {
            return false;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = sQLiteDatabase.query(Const.TableSchema.TABLE_NAME, null, null, null, null, null, null);
                if (cursor.moveToFirst()) {
                    while (true) {
                        if (!str.equalsIgnoreCase(cursor.getString(cursor.getColumnIndexOrThrow("name")))) {
                            if (!cursor.moveToNext()) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (cursor == null) {
                    return false;
                }
            }
            cursor.close();
            return false;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003d, code lost:
        if (r0.getInt(r0.getColumnIndexOrThrow("type")) != 1) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003f, code lost:
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0042, code lost:
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isIntermediateTable(String str, SQLiteDatabase sQLiteDatabase) {
        if (TextUtils.isEmpty(str) || !str.matches("[0-9a-zA-Z]+_[0-9a-zA-Z]+")) {
            return false;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = sQLiteDatabase.query(Const.TableSchema.TABLE_NAME, null, null, null, null, null, null);
                if (cursor.moveToFirst()) {
                    while (true) {
                        if (!str.equalsIgnoreCase(cursor.getString(cursor.getColumnIndexOrThrow("name")))) {
                            if (!cursor.moveToNext()) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (cursor == null) {
                    return false;
                }
            }
            cursor.close();
            return false;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public static boolean isTableExists(String str, SQLiteDatabase sQLiteDatabase) {
        try {
            return BaseUtility.containsIgnoreCases(findAllTableNames(sQLiteDatabase), str);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
