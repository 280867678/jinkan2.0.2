package com.arialyy.aria.orm;

import java.util.ArrayList;
import java.util.List;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public abstract class DbEntity {
    public static final Object LOCK = new Object();
    public long rowID = -1;

    public static boolean checkDataExist(Class cls, String... strArr) {
        return DelegateWrapper.getInstance().checkDataExist(cls, strArr);
    }

    public static <T extends DbEntity> void checkListData(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new NullPointerException("列表数据为空");
        }
    }

    public static <T extends DbEntity> void clean(Class<T> cls) {
        DelegateWrapper.getInstance().clean(cls);
    }

    public static <T extends DbEntity> void deleteData(Class<T> cls, String... strArr) {
        DelegateWrapper.getInstance().delData(cls, strArr);
    }

    public static void exeSql(String str) {
        DelegateWrapper.getInstance().exeSql(str);
    }

    public static <T extends DbEntity> List<T> findAllData(Class<T> cls) {
        return DelegateWrapper.getInstance().findAllData(cls);
    }

    public static <T extends DbEntity> List<T> findDataByFuzzy(Class<T> cls, int i, int i2, String str) {
        return DelegateWrapper.getInstance().findDataByFuzzy(cls, i, i2, str);
    }

    public static <T extends DbEntity> List<T> findDataByFuzzy(Class<T> cls, String str) {
        return DelegateWrapper.getInstance().findDataByFuzzy(cls, str);
    }

    public static <T extends DbEntity> List<T> findDatas(Class<T> cls, int i, int i2, String... strArr) {
        if (i < 1 || i2 < 1) {
            return null;
        }
        return DelegateWrapper.getInstance().findData(cls, i, i2, strArr);
    }

    public static <T extends DbEntity> List<T> findDatas(Class<T> cls, String... strArr) {
        return DelegateWrapper.getInstance().findData(cls, strArr);
    }

    public static <T extends DbEntity> T findFirst(Class<T> cls) {
        List findAllData = findAllData(cls);
        if (findAllData == null || findAllData.size() == 0) {
            return null;
        }
        return (T) findAllData.get(0);
    }

    public static <T extends DbEntity> T findFirst(Class<T> cls, String... strArr) {
        List<T> findData = DelegateWrapper.getInstance().findData(cls, strArr);
        if (findData != null && findData.size() > 0) {
            return findData.get(0);
        }
        return null;
    }

    public static <T extends AbsDbWrapper> List<T> findRelationData(Class<T> cls, int i, int i2, String... strArr) {
        if (i < 1 || i2 < 1) {
            return null;
        }
        return DelegateWrapper.getInstance().findRelationData(cls, i, i2, strArr);
    }

    public static <T extends AbsDbWrapper> List<T> findRelationData(Class<T> cls, String... strArr) {
        return DelegateWrapper.getInstance().findRelationData(cls, strArr);
    }

    public static <T extends DbEntity> void insertManyData(List<T> list) {
        checkListData(list);
        DelegateWrapper.getInstance().insertManyData(list);
    }

    public static <T extends DbEntity> void saveAll(List<T> list) {
        checkListData(list);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        DelegateWrapper delegateWrapper = DelegateWrapper.getInstance();
        for (T t : list) {
            if (t.rowID != -1 && delegateWrapper.isExist(t.getClass(), t.rowID)) {
                arrayList2.add(t);
            } else {
                arrayList.add(t);
            }
        }
        if (!arrayList.isEmpty()) {
            delegateWrapper.insertManyData(arrayList);
        }
        if (!arrayList2.isEmpty()) {
            delegateWrapper.updateManyData(arrayList2);
        }
    }

    public static boolean tableExists(Class<DbEntity> cls) {
        return DelegateWrapper.getInstance().tableExists(cls);
    }

    private boolean thisIsExist() {
        return this.rowID != -1 && DelegateWrapper.getInstance().isExist(getClass(), this.rowID);
    }

    public static <T extends DbEntity> void updateManyData(List<T> list) {
        checkListData(list);
        DelegateWrapper.getInstance().updateManyData(list);
    }

    public void deleteData() {
        deleteData(getClass(), "rowid=?", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new StringBuilder(), this.rowID, ""));
    }

    public long getRowID() {
        return this.rowID;
    }

    public void insert() {
        DelegateWrapper.getInstance().insertData(this);
    }

    public void save() {
        synchronized (LOCK) {
            if (thisIsExist()) {
                update();
            } else {
                insert();
            }
        }
    }

    public void update() {
        DelegateWrapper.getInstance().updateData(this);
    }
}
