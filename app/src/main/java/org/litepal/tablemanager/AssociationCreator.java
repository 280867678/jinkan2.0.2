package org.litepal.tablemanager;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.litepal.exceptions.DatabaseGenerateException;
import org.litepal.tablemanager.model.AssociationsModel;
import org.litepal.tablemanager.model.ColumnModel;
import org.litepal.tablemanager.model.GenericModel;
import org.litepal.util.BaseUtility;
import org.litepal.util.Const;
import org.litepal.util.DBUtility;
import org.litepal.util.LitePalLog;

/* loaded from: classes5.dex */
public abstract class AssociationCreator extends Generator {
    private void addAssociations(Collection<AssociationsModel> collection, SQLiteDatabase sQLiteDatabase, boolean z) {
        for (AssociationsModel associationsModel : collection) {
            if (2 == associationsModel.getAssociationType() || 1 == associationsModel.getAssociationType()) {
                addForeignKeyColumn(associationsModel.getTableName(), associationsModel.getAssociatedTableName(), associationsModel.getTableHoldsForeignKey(), sQLiteDatabase);
            } else if (3 == associationsModel.getAssociationType()) {
                createIntermediateTable(associationsModel.getTableName(), associationsModel.getAssociatedTableName(), sQLiteDatabase, z);
            }
        }
        for (GenericModel genericModel : getGenericModels()) {
            createGenericTable(genericModel, sQLiteDatabase, z);
        }
    }

    private void createGenericTable(GenericModel genericModel, SQLiteDatabase sQLiteDatabase, boolean z) {
        String tableName = genericModel.getTableName();
        String valueColumnName = genericModel.getValueColumnName();
        String valueColumnType = genericModel.getValueColumnType();
        String valueIdColumnName = genericModel.getValueIdColumnName();
        ArrayList arrayList = new ArrayList();
        ColumnModel columnModel = new ColumnModel();
        columnModel.setColumnName(valueColumnName);
        columnModel.setColumnType(valueColumnType);
        ColumnModel columnModel2 = new ColumnModel();
        columnModel2.setColumnName(valueIdColumnName);
        columnModel2.setColumnType("integer");
        arrayList.add(columnModel);
        arrayList.add(columnModel2);
        ArrayList arrayList2 = new ArrayList();
        if (DBUtility.isTableExists(tableName, sQLiteDatabase)) {
            if (z) {
                arrayList2.add(generateDropTableSQL(tableName));
            }
            execute(arrayList2, sQLiteDatabase);
            giveTableSchemaACopy(tableName, 2, sQLiteDatabase);
        }
        arrayList2.add(generateCreateTableSQL(tableName, arrayList, false));
        execute(arrayList2, sQLiteDatabase);
        giveTableSchemaACopy(tableName, 2, sQLiteDatabase);
    }

    private void createIntermediateTable(String str, String str2, SQLiteDatabase sQLiteDatabase, boolean z) {
        ArrayList arrayList = new ArrayList();
        ColumnModel columnModel = new ColumnModel();
        columnModel.setColumnName(str + "_id");
        columnModel.setColumnType("integer");
        ColumnModel columnModel2 = new ColumnModel();
        columnModel2.setColumnName(str2 + "_id");
        columnModel2.setColumnType("integer");
        arrayList.add(columnModel);
        arrayList.add(columnModel2);
        String intermediateTableName = DBUtility.getIntermediateTableName(str, str2);
        ArrayList arrayList2 = new ArrayList();
        if (DBUtility.isTableExists(intermediateTableName, sQLiteDatabase)) {
            if (z) {
                arrayList2.add(generateDropTableSQL(intermediateTableName));
            }
            execute(arrayList2, sQLiteDatabase);
            giveTableSchemaACopy(intermediateTableName, 1, sQLiteDatabase);
        }
        arrayList2.add(generateCreateTableSQL(intermediateTableName, arrayList, false));
        execute(arrayList2, sQLiteDatabase);
        giveTableSchemaACopy(intermediateTableName, 1, sQLiteDatabase);
    }

    private boolean isContainsOnlyIdField(List<ColumnModel> list) {
        return list.size() == 0 || (list.size() == 1 && isIdColumn(list.get(0).getColumnName())) || (list.size() == 2 && isIdColumn(list.get(0).getColumnName()) && isIdColumn(list.get(1).getColumnName()));
    }

    private boolean isNeedtoGiveACopy(Cursor cursor, String str) {
        return !isValueExists(cursor, str) && !isSpecialTable(str);
    }

    private boolean isSpecialTable(String str) {
        return Const.TableSchema.TABLE_NAME.equalsIgnoreCase(str);
    }

    private boolean isValueExists(Cursor cursor, String str) {
        if (cursor.moveToFirst()) {
            while (!cursor.getString(cursor.getColumnIndexOrThrow("name")).equalsIgnoreCase(str)) {
                if (!cursor.moveToNext()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public void addForeignKeyColumn(String str, String str2, String str3, SQLiteDatabase sQLiteDatabase) {
        if (DBUtility.isTableExists(str, sQLiteDatabase)) {
            if (!DBUtility.isTableExists(str2, sQLiteDatabase)) {
                throw new DatabaseGenerateException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DatabaseGenerateException.TABLE_DOES_NOT_EXIST, str2));
            }
            String str4 = null;
            if (str.equals(str3)) {
                str4 = getForeignKeyColumnName(str2);
            } else if (str2.equals(str3)) {
                str4 = getForeignKeyColumnName(str);
            }
            if (DBUtility.isColumnExists(str4, str3, sQLiteDatabase)) {
                LitePalLog.m30d(Generator.TAG, "column " + str4 + " is already exist, no need to add one");
                return;
            }
            ColumnModel columnModel = new ColumnModel();
            columnModel.setColumnName(str4);
            columnModel.setColumnType("integer");
            ArrayList arrayList = new ArrayList();
            arrayList.add(generateAddColumnSQL(str3, columnModel));
            execute(arrayList, sQLiteDatabase);
            return;
        }
        throw new DatabaseGenerateException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DatabaseGenerateException.TABLE_DOES_NOT_EXIST, str));
    }

    @Override // org.litepal.tablemanager.Generator
    public void addOrUpdateAssociation(SQLiteDatabase sQLiteDatabase, boolean z) {
        addAssociations(getAllAssociations(), sQLiteDatabase, z);
    }

    @Override // org.litepal.tablemanager.Generator
    public abstract void createOrUpgradeTable(SQLiteDatabase sQLiteDatabase, boolean z);

    public String generateAddColumnSQL(String str, ColumnModel columnModel) {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("alter table ", str, " add column ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(columnModel.getColumnName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(StringUtils.SPACE);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(columnModel.getColumnType());
        if (!columnModel.isNullable()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" not null");
        }
        if (columnModel.isUnique()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" unique");
        }
        String defaultValue = columnModel.getDefaultValue();
        if (TextUtils.isEmpty(defaultValue)) {
            if (!columnModel.isNullable()) {
                if ("integer".equalsIgnoreCase(columnModel.getColumnType())) {
                    defaultValue = "0";
                } else if ("text".equalsIgnoreCase(columnModel.getColumnType())) {
                    defaultValue = ExtendedMessageFormat.ESCAPED_QUOTE;
                } else if ("real".equalsIgnoreCase(columnModel.getColumnType())) {
                    defaultValue = "0.0";
                }
            }
            LitePalLog.m30d(Generator.TAG, "add column sql is >> " + ((Object) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" default ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(defaultValue);
        LitePalLog.m30d(Generator.TAG, "add column sql is >> " + ((Object) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    public String generateCreateTableSQL(String str, List<ColumnModel> list, boolean z) {
        StringBuilder sb = new StringBuilder("create table ");
        sb.append(str);
        sb.append(" (");
        if (z) {
            sb.append("id integer primary key autoincrement,");
        }
        if (isContainsOnlyIdField(list)) {
            sb.deleteCharAt(sb.length() - 1);
        }
        boolean z2 = false;
        for (ColumnModel columnModel : list) {
            if (!columnModel.isIdColumn()) {
                if (z2) {
                    sb.append(", ");
                }
                sb.append(columnModel.getColumnName());
                sb.append(StringUtils.SPACE);
                sb.append(columnModel.getColumnType());
                if (!columnModel.isNullable()) {
                    sb.append(" not null");
                }
                if (columnModel.isUnique()) {
                    sb.append(" unique");
                }
                String defaultValue = columnModel.getDefaultValue();
                if (!TextUtils.isEmpty(defaultValue)) {
                    sb.append(" default ");
                    sb.append(defaultValue);
                }
                z2 = true;
            }
        }
        sb.append(")");
        LitePalLog.m30d(Generator.TAG, "create table sql is >> " + ((Object) sb));
        return sb.toString();
    }

    public String generateDropTableSQL(String str) {
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("drop table if exists ", str);
    }

    public void giveTableSchemaACopy(String str, int i, SQLiteDatabase sQLiteDatabase) {
        Cursor rawQuery;
        StringBuilder sb = new StringBuilder("select * from ");
        sb.append(Const.TableSchema.TABLE_NAME);
        LitePalLog.m30d(Generator.TAG, "giveTableSchemaACopy SQL is >> " + ((Object) sb));
        Cursor cursor = null;
        try {
            try {
                rawQuery = sQLiteDatabase.rawQuery(sb.toString(), null);
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (isNeedtoGiveACopy(rawQuery, str)) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("name", BaseUtility.changeCase(str));
                contentValues.put("type", Integer.valueOf(i));
                sQLiteDatabase.insert(Const.TableSchema.TABLE_NAME, null, contentValues);
            }
            if (rawQuery == null) {
                return;
            }
            rawQuery.close();
        } catch (Exception e2) {
            e = e2;
            cursor = rawQuery;
            e.printStackTrace();
            if (cursor == null) {
                return;
            }
            cursor.close();
        } catch (Throwable th2) {
            th = th2;
            cursor = rawQuery;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public boolean isForeignKeyColumnFormat(String str) {
        return !TextUtils.isEmpty(str) && str.toLowerCase(Locale.US).endsWith("_id") && !str.equalsIgnoreCase("_id");
    }
}
