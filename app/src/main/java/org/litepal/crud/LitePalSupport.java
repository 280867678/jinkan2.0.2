package org.litepal.crud;

import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.litepal.Operator;
import org.litepal.crud.async.SaveExecutor;
import org.litepal.crud.async.UpdateOrDeleteExecutor;
import org.litepal.exceptions.LitePalSupportException;
import org.litepal.tablemanager.Connector;
import org.litepal.util.BaseUtility;
import org.litepal.util.DBUtility;

/* loaded from: classes5.dex */
public class LitePalSupport {
    public static final String AES = "AES";
    public static final String MD5 = "MD5";
    public Map<String, List<Long>> associatedModelsMapForJoinTable;
    public Map<String, Set<Long>> associatedModelsMapWithFK;
    public Map<String, Long> associatedModelsMapWithoutFK;
    public long baseObjId;
    public List<String> fieldsToSetToDefault;
    public List<String> listToClearAssociatedFK;
    public List<String> listToClearSelfFK;

    private void clearFKNameList() {
        getListToClearSelfFK().clear();
        getListToClearAssociatedFK().clear();
    }

    private void clearIdOfModelForJoinTable() {
        for (String str : getAssociatedModelsMapForJoinTable().keySet()) {
            this.associatedModelsMapForJoinTable.get(str).clear();
        }
        this.associatedModelsMapForJoinTable.clear();
    }

    private void clearIdOfModelWithFK() {
        for (String str : getAssociatedModelsMapWithFK().keySet()) {
            this.associatedModelsMapWithFK.get(str).clear();
        }
        this.associatedModelsMapWithFK.clear();
    }

    private void clearIdOfModelWithoutFK() {
        getAssociatedModelsMapWithoutFK().clear();
    }

    public void addAssociatedModelForJoinTable(String str, long j) {
        List<Long> list = getAssociatedModelsMapForJoinTable().get(str);
        if (list != null) {
            list.add(Long.valueOf(j));
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Long.valueOf(j));
        this.associatedModelsMapForJoinTable.put(str, arrayList);
    }

    public void addAssociatedModelWithFK(String str, long j) {
        Set<Long> set = getAssociatedModelsMapWithFK().get(str);
        if (set != null) {
            set.add(Long.valueOf(j));
            return;
        }
        HashSet hashSet = new HashSet();
        hashSet.add(Long.valueOf(j));
        this.associatedModelsMapWithFK.put(str, hashSet);
    }

    public void addAssociatedModelWithoutFK(String str, long j) {
        getAssociatedModelsMapWithoutFK().put(str, Long.valueOf(j));
    }

    public void addAssociatedTableNameToClearFK(String str) {
        List<String> listToClearAssociatedFK = getListToClearAssociatedFK();
        if (!listToClearAssociatedFK.contains(str)) {
            listToClearAssociatedFK.add(str);
        }
    }

    public void addEmptyModelForJoinTable(String str) {
        if (getAssociatedModelsMapForJoinTable().get(str) == null) {
            this.associatedModelsMapForJoinTable.put(str, new ArrayList());
        }
    }

    public void addFKNameToClearSelf(String str) {
        List<String> listToClearSelfFK = getListToClearSelfFK();
        if (!listToClearSelfFK.contains(str)) {
            listToClearSelfFK.add(str);
        }
    }

    public void assignBaseObjId(int i) {
        this.baseObjId = i;
    }

    public void clearAssociatedData() {
        clearIdOfModelWithFK();
        clearIdOfModelWithoutFK();
        clearIdOfModelForJoinTable();
        clearFKNameList();
    }

    public void clearSavedState() {
        this.baseObjId = 0L;
    }

    public int delete() {
        int onDelete;
        synchronized (LitePalSupport.class) {
            SQLiteDatabase database = Connector.getDatabase();
            database.beginTransaction();
            onDelete = new DeleteHandler(database).onDelete(this);
            this.baseObjId = 0L;
            database.setTransactionSuccessful();
            database.endTransaction();
        }
        return onDelete;
    }

    public UpdateOrDeleteExecutor deleteAsync() {
        final UpdateOrDeleteExecutor updateOrDeleteExecutor = new UpdateOrDeleteExecutor();
        updateOrDeleteExecutor.submit(new Runnable() { // from class: org.litepal.crud.LitePalSupport.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (LitePalSupport.class) {
                    final int delete = LitePalSupport.this.delete();
                    if (updateOrDeleteExecutor.getListener() != null) {
                        Operator.getHandler().post(new Runnable() { // from class: org.litepal.crud.LitePalSupport.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                updateOrDeleteExecutor.getListener().onFinish(delete);
                            }
                        });
                    }
                }
            }
        });
        return updateOrDeleteExecutor;
    }

    public Map<String, List<Long>> getAssociatedModelsMapForJoinTable() {
        if (this.associatedModelsMapForJoinTable == null) {
            this.associatedModelsMapForJoinTable = new HashMap();
        }
        return this.associatedModelsMapForJoinTable;
    }

    public Map<String, Set<Long>> getAssociatedModelsMapWithFK() {
        if (this.associatedModelsMapWithFK == null) {
            this.associatedModelsMapWithFK = new HashMap();
        }
        return this.associatedModelsMapWithFK;
    }

    public Map<String, Long> getAssociatedModelsMapWithoutFK() {
        if (this.associatedModelsMapWithoutFK == null) {
            this.associatedModelsMapWithoutFK = new HashMap();
        }
        return this.associatedModelsMapWithoutFK;
    }

    public long getBaseObjId() {
        return this.baseObjId;
    }

    public String getClassName() {
        return getClass().getName();
    }

    public List<String> getFieldsToSetToDefault() {
        if (this.fieldsToSetToDefault == null) {
            this.fieldsToSetToDefault = new ArrayList();
        }
        return this.fieldsToSetToDefault;
    }

    public List<String> getListToClearAssociatedFK() {
        if (this.listToClearAssociatedFK == null) {
            this.listToClearAssociatedFK = new ArrayList();
        }
        return this.listToClearAssociatedFK;
    }

    public List<String> getListToClearSelfFK() {
        if (this.listToClearSelfFK == null) {
            this.listToClearSelfFK = new ArrayList();
        }
        return this.listToClearSelfFK;
    }

    public String getTableName() {
        return BaseUtility.changeCase(DBUtility.getTableNameByClassName(getClassName()));
    }

    public boolean isSaved() {
        return this.baseObjId > 0;
    }

    public boolean save() {
        try {
            saveThrows();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public SaveExecutor saveAsync() {
        final SaveExecutor saveExecutor = new SaveExecutor();
        saveExecutor.submit(new Runnable() { // from class: org.litepal.crud.LitePalSupport.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (LitePalSupport.class) {
                    final boolean save = LitePalSupport.this.save();
                    if (saveExecutor.getListener() != null) {
                        Operator.getHandler().post(new Runnable() { // from class: org.litepal.crud.LitePalSupport.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                saveExecutor.getListener().onFinish(save);
                            }
                        });
                    }
                }
            }
        });
        return saveExecutor;
    }

    @Deprecated
    public boolean saveIfNotExist(String... strArr) {
        if (!Operator.isExist(getClass(), strArr)) {
            return save();
        }
        return false;
    }

    public boolean saveOrUpdate(String... strArr) {
        synchronized (LitePalSupport.class) {
            if (strArr == null) {
                return save();
            }
            List<LitePalSupport> find = Operator.where(strArr).find(getClass());
            if (find.isEmpty()) {
                return save();
            }
            SQLiteDatabase database = Connector.getDatabase();
            database.beginTransaction();
            try {
                for (LitePalSupport litePalSupport : find) {
                    this.baseObjId = litePalSupport.getBaseObjId();
                    new SaveHandler(database).onSave(this);
                    clearAssociatedData();
                }
                database.setTransactionSuccessful();
                database.endTransaction();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                database.endTransaction();
                return false;
            }
        }
    }

    public SaveExecutor saveOrUpdateAsync(final String... strArr) {
        final SaveExecutor saveExecutor = new SaveExecutor();
        saveExecutor.submit(new Runnable() { // from class: org.litepal.crud.LitePalSupport.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (LitePalSupport.class) {
                    final boolean saveOrUpdate = LitePalSupport.this.saveOrUpdate(strArr);
                    if (saveExecutor.getListener() != null) {
                        Operator.getHandler().post(new Runnable() { // from class: org.litepal.crud.LitePalSupport.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                saveExecutor.getListener().onFinish(saveOrUpdate);
                            }
                        });
                    }
                }
            }
        });
        return saveExecutor;
    }

    public void saveThrows() {
        synchronized (LitePalSupport.class) {
            SQLiteDatabase database = Connector.getDatabase();
            database.beginTransaction();
            try {
                new SaveHandler(database).onSave(this);
                clearAssociatedData();
                database.setTransactionSuccessful();
                database.endTransaction();
            } catch (Exception e) {
                throw new LitePalSupportException(e.getMessage(), e);
            }
        }
    }

    public void setToDefault(String str) {
        getFieldsToSetToDefault().add(str);
    }

    public int update(long j) {
        int onUpdate;
        synchronized (LitePalSupport.class) {
            try {
                try {
                    onUpdate = new UpdateHandler(Connector.getDatabase()).onUpdate(this, j);
                    getFieldsToSetToDefault().clear();
                } catch (Exception e) {
                    throw new LitePalSupportException(e.getMessage(), e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return onUpdate;
    }

    public int updateAll(String... strArr) {
        int onUpdateAll;
        synchronized (LitePalSupport.class) {
            try {
                try {
                    onUpdateAll = new UpdateHandler(Connector.getDatabase()).onUpdateAll(this, strArr);
                    getFieldsToSetToDefault().clear();
                } catch (Exception e) {
                    throw new LitePalSupportException(e.getMessage(), e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return onUpdateAll;
    }

    public UpdateOrDeleteExecutor updateAllAsync(final String... strArr) {
        final UpdateOrDeleteExecutor updateOrDeleteExecutor = new UpdateOrDeleteExecutor();
        updateOrDeleteExecutor.submit(new Runnable() { // from class: org.litepal.crud.LitePalSupport.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (LitePalSupport.class) {
                    final int updateAll = LitePalSupport.this.updateAll(strArr);
                    if (updateOrDeleteExecutor.getListener() != null) {
                        Operator.getHandler().post(new Runnable() { // from class: org.litepal.crud.LitePalSupport.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                updateOrDeleteExecutor.getListener().onFinish(updateAll);
                            }
                        });
                    }
                }
            }
        });
        return updateOrDeleteExecutor;
    }

    public UpdateOrDeleteExecutor updateAsync(final long j) {
        final UpdateOrDeleteExecutor updateOrDeleteExecutor = new UpdateOrDeleteExecutor();
        updateOrDeleteExecutor.submit(new Runnable() { // from class: org.litepal.crud.LitePalSupport.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (LitePalSupport.class) {
                    final int update = LitePalSupport.this.update(j);
                    if (updateOrDeleteExecutor.getListener() != null) {
                        Operator.getHandler().post(new Runnable() { // from class: org.litepal.crud.LitePalSupport.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                updateOrDeleteExecutor.getListener().onFinish(update);
                            }
                        });
                    }
                }
            }
        });
        return updateOrDeleteExecutor;
    }
}
