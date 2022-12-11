package org.litepal.tablemanager;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.litepal.tablemanager.model.TableModel;
import org.litepal.util.BaseUtility;
import org.litepal.util.Const;
import org.litepal.util.LitePalLog;

/* loaded from: classes5.dex */
public class Dropper extends AssociationUpdater {
    public Collection<TableModel> mTableModels;

    private void dropTables() {
        List<String> findTablesToDrop = findTablesToDrop();
        dropTables(findTablesToDrop, this.mDb);
        clearCopyInTableSchema(findTablesToDrop);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x005a, code lost:
        if (r1 == null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<String> findTablesToDrop() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                cursor = this.mDb.query(Const.TableSchema.TABLE_NAME, null, null, null, null, null, null);
                if (cursor.moveToFirst()) {
                    do {
                        String string = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                        if (shouldDropThisTable(string, cursor.getInt(cursor.getColumnIndexOrThrow("type")))) {
                            LitePalLog.m30d(AssociationUpdater.TAG, "need to drop " + string);
                            arrayList.add(string);
                        }
                    } while (cursor.moveToNext());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            cursor.close();
            return arrayList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private List<String> pickTableNamesFromTableModels() {
        ArrayList arrayList = new ArrayList();
        for (TableModel tableModel : this.mTableModels) {
            arrayList.add(tableModel.getTableName());
        }
        return arrayList;
    }

    private boolean shouldDropThisTable(String str, int i) {
        return !BaseUtility.containsIgnoreCases(pickTableNamesFromTableModels(), str) && i == 0;
    }

    @Override // org.litepal.tablemanager.AssociationUpdater, org.litepal.tablemanager.Creator, org.litepal.tablemanager.AssociationCreator, org.litepal.tablemanager.Generator
    public void createOrUpgradeTable(SQLiteDatabase sQLiteDatabase, boolean z) {
        this.mTableModels = getAllTableModels();
        this.mDb = sQLiteDatabase;
        dropTables();
    }
}
