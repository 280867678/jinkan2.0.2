package org.litepal.tablemanager;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import me.tvspark.outline;
import org.litepal.LitePalBase;
import org.litepal.exceptions.DatabaseGenerateException;
import org.litepal.parser.LitePalAttr;
import org.litepal.tablemanager.model.AssociationsModel;
import org.litepal.tablemanager.model.TableModel;
import org.litepal.util.BaseUtility;

/* loaded from: classes5.dex */
public abstract class Generator extends LitePalBase {
    public static final String TAG = "Generator";
    public Collection<AssociationsModel> mAllRelationModels;
    public Collection<TableModel> mTableModels;

    public static void addAssociation(SQLiteDatabase sQLiteDatabase, boolean z) {
        new Creator().addOrUpdateAssociation(sQLiteDatabase, z);
    }

    private boolean canUseCache() {
        Collection<TableModel> collection = this.mTableModels;
        return collection != null && collection.size() == LitePalAttr.getInstance().getClassNames().size();
    }

    public static void create(SQLiteDatabase sQLiteDatabase) {
        create(sQLiteDatabase, true);
        addAssociation(sQLiteDatabase, true);
    }

    public static void create(SQLiteDatabase sQLiteDatabase, boolean z) {
        new Creator().createOrUpgradeTable(sQLiteDatabase, z);
    }

    public static void drop(SQLiteDatabase sQLiteDatabase) {
        new Dropper().createOrUpgradeTable(sQLiteDatabase, false);
    }

    public static void updateAssociations(SQLiteDatabase sQLiteDatabase) {
        new Upgrader().addOrUpdateAssociation(sQLiteDatabase, false);
    }

    public static void upgrade(SQLiteDatabase sQLiteDatabase) {
        drop(sQLiteDatabase);
        create(sQLiteDatabase, false);
        updateAssociations(sQLiteDatabase);
        upgradeTables(sQLiteDatabase);
        addAssociation(sQLiteDatabase, false);
    }

    public static void upgradeTables(SQLiteDatabase sQLiteDatabase) {
        new Upgrader().createOrUpgradeTable(sQLiteDatabase, false);
    }

    public abstract void addOrUpdateAssociation(SQLiteDatabase sQLiteDatabase, boolean z);

    public abstract void createOrUpgradeTable(SQLiteDatabase sQLiteDatabase, boolean z);

    public void execute(List<String> list, SQLiteDatabase sQLiteDatabase) {
        String str = "";
        if (list != null) {
            try {
                if (list.isEmpty()) {
                    return;
                }
                for (String str2 : list) {
                    if (!TextUtils.isEmpty(str2)) {
                        str = BaseUtility.changeCase(str2);
                        sQLiteDatabase.execSQL(str);
                    }
                }
            } catch (SQLException unused) {
                throw new DatabaseGenerateException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DatabaseGenerateException.SQL_ERROR, str));
            }
        }
    }

    public Collection<AssociationsModel> getAllAssociations() {
        Collection<AssociationsModel> collection = this.mAllRelationModels;
        if (collection == null || collection.isEmpty()) {
            this.mAllRelationModels = getAssociations(LitePalAttr.getInstance().getClassNames());
        }
        return this.mAllRelationModels;
    }

    public Collection<TableModel> getAllTableModels() {
        if (this.mTableModels == null) {
            this.mTableModels = new ArrayList();
        }
        if (!canUseCache()) {
            this.mTableModels.clear();
            for (String str : LitePalAttr.getInstance().getClassNames()) {
                this.mTableModels.add(getTableModel(str));
            }
        }
        return this.mTableModels;
    }
}
