package org.litepal.tablemanager;

import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;
import org.litepal.parser.LitePalAttr;
import org.litepal.tablemanager.model.AssociationsModel;
import org.litepal.tablemanager.model.ColumnModel;
import org.litepal.tablemanager.model.GenericModel;
import org.litepal.tablemanager.model.TableModel;
import org.litepal.util.BaseUtility;
import org.litepal.util.Const;
import org.litepal.util.DBUtility;
import org.litepal.util.LitePalLog;

/* loaded from: classes5.dex */
public abstract class AssociationUpdater extends Creator {
    public static final String TAG = "AssociationUpdater";
    public Collection<AssociationsModel> mAssociationModels;
    public SQLiteDatabase mDb;

    private List<String> findForeignKeyToRemove(TableModel tableModel) {
        ArrayList arrayList = new ArrayList();
        List<String> foreignKeyColumns = getForeignKeyColumns(tableModel);
        String tableName = tableModel.getTableName();
        for (String str : foreignKeyColumns) {
            if (shouldDropForeignKey(tableName, DBUtility.getTableNameByForeignColumn(str))) {
                arrayList.add(str);
            }
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("findForeignKeyToRemove >> ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(tableModel.getTableName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(StringUtils.SPACE);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(arrayList);
        LitePalLog.m30d(TAG, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        return arrayList;
    }

    private List<String> findGenericTablesToDrop() {
        ArrayList arrayList = new ArrayList();
        for (String str : DBUtility.findAllTableNames(this.mDb)) {
            if (DBUtility.isGenericTable(str, this.mDb)) {
                boolean z = true;
                for (GenericModel genericModel : getGenericModels()) {
                    if (str.equalsIgnoreCase(genericModel.getTableName())) {
                        z = false;
                    }
                }
                if (z) {
                    arrayList.add(str);
                }
            }
        }
        return arrayList;
    }

    private List<String> findIntermediateTablesToDrop() {
        ArrayList arrayList = new ArrayList();
        for (String str : DBUtility.findAllTableNames(this.mDb)) {
            if (DBUtility.isIntermediateTable(str, this.mDb)) {
                boolean z = true;
                for (AssociationsModel associationsModel : this.mAssociationModels) {
                    if (associationsModel.getAssociationType() == 3 && str.equalsIgnoreCase(DBUtility.getIntermediateTableName(associationsModel.getTableName(), associationsModel.getAssociatedTableName()))) {
                        z = false;
                    }
                }
                if (z) {
                    arrayList.add(str);
                }
            }
        }
        LitePalLog.m30d(TAG, "findIntermediateTablesToDrop >> " + arrayList);
        return arrayList;
    }

    private String generateCreateNewTableSQL(Collection<String> collection, TableModel tableModel) {
        for (String str : collection) {
            tableModel.removeColumnModelByName(str);
        }
        return generateCreateTableSQL(tableModel);
    }

    private List<String> getRemoveColumnSQLs(Collection<String> collection, String str) {
        TableModel tableModelFromDB = getTableModelFromDB(str);
        String generateAlterToTempTableSQL = generateAlterToTempTableSQL(str);
        LitePalLog.m30d(TAG, "generateRemoveColumnSQL >> " + generateAlterToTempTableSQL);
        String generateCreateNewTableSQL = generateCreateNewTableSQL(collection, tableModelFromDB);
        LitePalLog.m30d(TAG, "generateRemoveColumnSQL >> " + generateCreateNewTableSQL);
        String generateDataMigrationSQL = generateDataMigrationSQL(tableModelFromDB);
        LitePalLog.m30d(TAG, "generateRemoveColumnSQL >> " + generateDataMigrationSQL);
        String generateDropTempTableSQL = generateDropTempTableSQL(str);
        LitePalLog.m30d(TAG, "generateRemoveColumnSQL >> " + generateDropTempTableSQL);
        ArrayList arrayList = new ArrayList();
        arrayList.add(generateAlterToTempTableSQL);
        arrayList.add(generateCreateNewTableSQL);
        arrayList.add(generateDataMigrationSQL);
        arrayList.add(generateDropTempTableSQL);
        return arrayList;
    }

    private boolean isRelationCorrect(AssociationsModel associationsModel, String str, String str2) {
        return associationsModel.getTableName().equalsIgnoreCase(str) && associationsModel.getAssociatedTableName().equalsIgnoreCase(str2);
    }

    private void removeAssociations() {
        removeForeignKeyColumns();
        removeIntermediateTables();
        removeGenericTables();
    }

    private void removeForeignKeyColumns() {
        for (String str : LitePalAttr.getInstance().getClassNames()) {
            TableModel tableModel = getTableModel(str);
            removeColumns(findForeignKeyToRemove(tableModel), tableModel.getTableName());
        }
    }

    private void removeGenericTables() {
        List<String> findGenericTablesToDrop = findGenericTablesToDrop();
        dropTables(findGenericTablesToDrop, this.mDb);
        clearCopyInTableSchema(findGenericTablesToDrop);
    }

    private void removeIntermediateTables() {
        List<String> findIntermediateTablesToDrop = findIntermediateTablesToDrop();
        dropTables(findIntermediateTablesToDrop, this.mDb);
        clearCopyInTableSchema(findIntermediateTablesToDrop);
    }

    private boolean shouldDropForeignKey(String str, String str2) {
        for (AssociationsModel associationsModel : this.mAssociationModels) {
            if (associationsModel.getAssociationType() == 1) {
                if (!str.equalsIgnoreCase(associationsModel.getTableHoldsForeignKey())) {
                    continue;
                } else if (associationsModel.getTableName().equalsIgnoreCase(str)) {
                    if (isRelationCorrect(associationsModel, str, str2)) {
                        return false;
                    }
                } else if (associationsModel.getAssociatedTableName().equalsIgnoreCase(str) && isRelationCorrect(associationsModel, str2, str)) {
                    return false;
                }
            } else if (associationsModel.getAssociationType() == 2 && isRelationCorrect(associationsModel, str2, str)) {
                return false;
            }
        }
        return true;
    }

    @Override // org.litepal.tablemanager.AssociationCreator, org.litepal.tablemanager.Generator
    public void addOrUpdateAssociation(SQLiteDatabase sQLiteDatabase, boolean z) {
        this.mAssociationModels = getAllAssociations();
        this.mDb = sQLiteDatabase;
        removeAssociations();
    }

    public void clearCopyInTableSchema(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder("delete from ");
        sb.append(Const.TableSchema.TABLE_NAME);
        sb.append(" where");
        boolean z = false;
        for (String str : list) {
            if (z) {
                sb.append(" or ");
            }
            z = true;
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, " lower(", "name", ") ", "=");
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, " lower('", str, "')");
        }
        LitePalLog.m30d(TAG, "clear table schema value sql is " + ((Object) sb));
        ArrayList arrayList = new ArrayList();
        arrayList.add(sb.toString());
        execute(arrayList, this.mDb);
    }

    @Override // org.litepal.tablemanager.Creator, org.litepal.tablemanager.AssociationCreator, org.litepal.tablemanager.Generator
    public abstract void createOrUpgradeTable(SQLiteDatabase sQLiteDatabase, boolean z);

    public void dropTables(List<String> list, SQLiteDatabase sQLiteDatabase) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(generateDropTableSQL(list.get(i)));
        }
        execute(arrayList, sQLiteDatabase);
    }

    public String generateAlterToTempTableSQL(String str) {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("alter table ", str, " rename to ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getTempTableName(str));
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    public String generateDataMigrationSQL(TableModel tableModel) {
        String tableName = tableModel.getTableName();
        List<ColumnModel> columnModels = tableModel.getColumnModels();
        if (!columnModels.isEmpty()) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("insert into ", tableName, "(");
            boolean z = false;
            boolean z2 = false;
            for (ColumnModel columnModel : columnModels) {
                if (z2) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", ");
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(columnModel.getColumnName());
                z2 = true;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(") ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("select ");
            for (ColumnModel columnModel2 : columnModels) {
                if (z) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", ");
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(columnModel2.getColumnName());
                z = true;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" from ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getTempTableName(tableName));
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        return null;
    }

    public String generateDropTempTableSQL(String str) {
        return generateDropTableSQL(getTempTableName(str));
    }

    public List<String> getForeignKeyColumns(TableModel tableModel) {
        ArrayList arrayList = new ArrayList();
        for (ColumnModel columnModel : getTableModelFromDB(tableModel.getTableName()).getColumnModels()) {
            String columnName = columnModel.getColumnName();
            if (isForeignKeyColumnFormat(columnModel.getColumnName()) && !tableModel.containsColumn(columnName)) {
                LitePalLog.m30d(TAG, "getForeignKeyColumnNames >> foreign key column is " + columnName);
                arrayList.add(columnName);
            }
        }
        return arrayList;
    }

    public TableModel getTableModelFromDB(String str) {
        return DBUtility.findPragmaTableInfo(str, this.mDb);
    }

    public String getTempTableName(String str) {
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "_temp");
    }

    public boolean isForeignKeyColumn(TableModel tableModel, String str) {
        return BaseUtility.containsIgnoreCases(getForeignKeyColumns(tableModel), str);
    }

    public void removeColumns(Collection<String> collection, String str) {
        if (collection == null || collection.isEmpty()) {
            return;
        }
        execute(getRemoveColumnSQLs(collection, str), this.mDb);
    }
}
