package org.litepal.tablemanager.model;

import android.text.TextUtils;
import me.tvspark.outline;

/* loaded from: classes5.dex */
public class ColumnModel {
    public String columnName;
    public String columnType;
    public boolean isNullable = true;
    public boolean isUnique = false;
    public String defaultValue = "";

    public String getColumnName() {
        return this.columnName;
    }

    public String getColumnType() {
        return this.columnType;
    }

    public String getDefaultValue() {
        return this.defaultValue;
    }

    public boolean isIdColumn() {
        return "_id".equalsIgnoreCase(this.columnName) || "id".equalsIgnoreCase(this.columnName);
    }

    public boolean isNullable() {
        return this.isNullable;
    }

    public boolean isUnique() {
        return this.isUnique;
    }

    public void setColumnName(String str) {
        this.columnName = str;
    }

    public void setColumnType(String str) {
        this.columnType = str;
    }

    public void setDefaultValue(String str) {
        if ("text".equalsIgnoreCase(this.columnType)) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            str = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("'", str, "'");
        }
        this.defaultValue = str;
    }

    public void setNullable(boolean z) {
        this.isNullable = z;
    }

    public void setUnique(boolean z) {
        this.isUnique = z;
    }
}
