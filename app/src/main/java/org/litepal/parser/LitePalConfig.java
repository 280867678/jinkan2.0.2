package org.litepal.parser;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class LitePalConfig {
    public String cases;
    public List<String> classNames;
    public String dbName;
    public String storage;
    public int version;

    public void addClassName(String str) {
        getClassNames().add(str);
    }

    public String getCases() {
        return this.cases;
    }

    public List<String> getClassNames() {
        List list;
        List<String> list2 = this.classNames;
        if (list2 != null) {
            if (list2.isEmpty()) {
                list = this.classNames;
            }
            return this.classNames;
        }
        list = new ArrayList();
        this.classNames = list;
        list.add("org.litepal.model.Table_Schema");
        return this.classNames;
    }

    public String getDbName() {
        return this.dbName;
    }

    public String getStorage() {
        return this.storage;
    }

    public int getVersion() {
        return this.version;
    }

    public void setCases(String str) {
        this.cases = str;
    }

    public void setClassNames(List<String> list) {
        this.classNames = list;
    }

    public void setDbName(String str) {
        this.dbName = str;
    }

    public void setStorage(String str) {
        this.storage = str;
    }

    public void setVersion(int i) {
        this.version = i;
    }
}
