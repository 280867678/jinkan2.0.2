package org.litepal.tablemanager.model;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class TableModel {
    public String className;
    public List<ColumnModel> columnModels = new ArrayList();
    public String tableName;

    public void addColumnModel(ColumnModel columnModel) {
        this.columnModels.add(columnModel);
    }

    public boolean containsColumn(String str) {
        for (int i = 0; i < this.columnModels.size(); i++) {
            if (str.equalsIgnoreCase(this.columnModels.get(i).getColumnName())) {
                return true;
            }
        }
        return false;
    }

    public String getClassName() {
        return this.className;
    }

    public ColumnModel getColumnModelByName(String str) {
        for (ColumnModel columnModel : this.columnModels) {
            if (columnModel.getColumnName().equalsIgnoreCase(str)) {
                return columnModel;
            }
        }
        return null;
    }

    public List<ColumnModel> getColumnModels() {
        return this.columnModels;
    }

    public String getTableName() {
        return this.tableName;
    }

    public void removeColumnModelByName(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int i = 0;
        while (true) {
            if (i >= this.columnModels.size()) {
                i = -1;
                break;
            } else if (str.equalsIgnoreCase(this.columnModels.get(i).getColumnName())) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            return;
        }
        this.columnModels.remove(i);
    }

    public void setClassName(String str) {
        this.className = str;
    }

    public void setTableName(String str) {
        this.tableName = str;
    }
}
