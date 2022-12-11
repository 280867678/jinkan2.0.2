package org.litepal.crud;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import me.tvspark.outline;
import org.litepal.annotation.Encrypt;
import org.litepal.crud.model.AssociationsInfo;
import org.litepal.exceptions.LitePalSupportException;
import org.litepal.util.BaseUtility;
import org.litepal.util.DBUtility;

/* loaded from: classes5.dex */
public class SaveHandler extends DataHandler {
    public ContentValues values = new ContentValues();

    public SaveHandler(SQLiteDatabase sQLiteDatabase) {
        this.mDatabase = sQLiteDatabase;
    }

    private void afterSave(LitePalSupport litePalSupport, List<Field> list, List<Field> list2, long j) throws IllegalAccessException, InvocationTargetException {
        throwIfSaveFailed(j);
        assignIdValue(litePalSupport, getIdField(list), j);
        updateGenericTables(litePalSupport, list2, j);
        updateAssociatedTableWithFK(litePalSupport);
        insertIntermediateJoinTableValue(litePalSupport, false);
    }

    private void afterUpdate(LitePalSupport litePalSupport, List<Field> list) throws InvocationTargetException, IllegalAccessException {
        updateGenericTables(litePalSupport, list, litePalSupport.getBaseObjId());
        updateAssociatedTableWithFK(litePalSupport);
        insertIntermediateJoinTableValue(litePalSupport, true);
        clearFKValueInAssociatedTable(litePalSupport);
    }

    private void assignIdValue(LitePalSupport litePalSupport, Field field, long j) {
        try {
            giveBaseObjIdValue(litePalSupport, j);
            if (field == null) {
                return;
            }
            giveModelIdValue(litePalSupport, field.getName(), field.getType(), j);
        } catch (Exception e) {
            throw new LitePalSupportException(e.getMessage(), e);
        }
    }

    private void beforeSave(LitePalSupport litePalSupport, List<Field> list, ContentValues contentValues) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        putFieldsValue(litePalSupport, list, contentValues);
        putForeignKeyValue(contentValues, litePalSupport);
    }

    private void beforeUpdate(LitePalSupport litePalSupport, List<Field> list, ContentValues contentValues) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        putFieldsValue(litePalSupport, list, contentValues);
        putForeignKeyValue(contentValues, litePalSupport);
        for (String str : litePalSupport.getListToClearSelfFK()) {
            contentValues.putNull(str);
        }
    }

    private void clearFKValueInAssociatedTable(LitePalSupport litePalSupport) {
        for (String str : litePalSupport.getListToClearAssociatedFK()) {
            String foreignKeyColumnName = getForeignKeyColumnName(litePalSupport.getTableName());
            ContentValues contentValues = new ContentValues();
            contentValues.putNull(foreignKeyColumnName);
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(foreignKeyColumnName, " = ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(litePalSupport.getBaseObjId());
            String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            this.mDatabase.update(str, contentValues, sb, null);
        }
    }

    private void doSaveAction(LitePalSupport litePalSupport, List<Field> list, List<Field> list2) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        this.values.clear();
        beforeSave(litePalSupport, list, this.values);
        afterSave(litePalSupport, list, list2, saving(litePalSupport, this.values));
    }

    private void doUpdateAction(LitePalSupport litePalSupport, List<Field> list, List<Field> list2) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        this.values.clear();
        beforeUpdate(litePalSupport, list, this.values);
        updating(litePalSupport, this.values);
        afterUpdate(litePalSupport, list2);
    }

    private Field getIdField(List<Field> list) {
        for (Field field : list) {
            if (isIdColumn(field.getName())) {
                return field;
            }
        }
        return null;
    }

    private String getWhereForJoinTableToDelete(LitePalSupport litePalSupport) {
        return getForeignKeyColumnName(litePalSupport.getTableName()) + " = ?";
    }

    private void giveModelIdValue(LitePalSupport litePalSupport, String str, Class<?> cls, long j) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Object valueOf;
        if (shouldGiveModelIdValue(str, cls, j)) {
            if (cls == Integer.TYPE || cls == Integer.class) {
                valueOf = Integer.valueOf((int) j);
            } else if (cls != Long.TYPE && cls != Long.class) {
                throw new LitePalSupportException(LitePalSupportException.ID_TYPE_INVALID_EXCEPTION);
            } else {
                valueOf = Long.valueOf(j);
            }
            DynamicExecutor.setField(litePalSupport, str, valueOf, litePalSupport.getClass());
        }
    }

    private void insertIntermediateJoinTableValue(LitePalSupport litePalSupport, boolean z) {
        Map<String, List<Long>> associatedModelsMapForJoinTable = litePalSupport.getAssociatedModelsMapForJoinTable();
        ContentValues contentValues = new ContentValues();
        for (String str : associatedModelsMapForJoinTable.keySet()) {
            String intermediateTableName = getIntermediateTableName(litePalSupport, str);
            if (z) {
                this.mDatabase.delete(intermediateTableName, getWhereForJoinTableToDelete(litePalSupport), new String[]{String.valueOf(litePalSupport.getBaseObjId())});
            }
            for (Long l : associatedModelsMapForJoinTable.get(str)) {
                long longValue = l.longValue();
                contentValues.clear();
                contentValues.put(getForeignKeyColumnName(litePalSupport.getTableName()), Long.valueOf(litePalSupport.getBaseObjId()));
                contentValues.put(getForeignKeyColumnName(str), Long.valueOf(longValue));
                this.mDatabase.insert(intermediateTableName, null, contentValues);
            }
        }
    }

    private void putForeignKeyValue(ContentValues contentValues, LitePalSupport litePalSupport) {
        Map<String, Long> associatedModelsMapWithoutFK = litePalSupport.getAssociatedModelsMapWithoutFK();
        for (String str : associatedModelsMapWithoutFK.keySet()) {
            contentValues.put(getForeignKeyColumnName(str), associatedModelsMapWithoutFK.get(str));
        }
    }

    private long saving(LitePalSupport litePalSupport, ContentValues contentValues) {
        if (contentValues.size() == 0) {
            contentValues.putNull("id");
        }
        return this.mDatabase.insert(litePalSupport.getTableName(), null, contentValues);
    }

    private boolean shouldGiveModelIdValue(String str, Class<?> cls, long j) {
        return (str == null || cls == null || j <= 0) ? false : true;
    }

    private void throwIfSaveFailed(long j) {
        if (j != -1) {
            return;
        }
        throw new LitePalSupportException(LitePalSupportException.SAVE_FAILED);
    }

    private void updateAssociatedTableWithFK(LitePalSupport litePalSupport) {
        Map<String, Set<Long>> associatedModelsMapWithFK = litePalSupport.getAssociatedModelsMapWithFK();
        ContentValues contentValues = new ContentValues();
        for (String str : associatedModelsMapWithFK.keySet()) {
            contentValues.clear();
            contentValues.put(getForeignKeyColumnName(litePalSupport.getTableName()), Long.valueOf(litePalSupport.getBaseObjId()));
            Set<Long> set = associatedModelsMapWithFK.get(str);
            if (set != null && !set.isEmpty()) {
                this.mDatabase.update(str, contentValues, getWhereOfIdsWithOr(set), null);
            }
        }
    }

    private void updateGenericTables(LitePalSupport litePalSupport, List<Field> list, long j) throws IllegalAccessException, InvocationTargetException {
        for (Field field : list) {
            Encrypt encrypt = (Encrypt) field.getAnnotation(Encrypt.class);
            String genericTypeName = getGenericTypeName(field);
            String algorithm = (encrypt == null || !"java.lang.String".equals(genericTypeName)) ? null : encrypt.algorithm();
            char c = 1;
            field.setAccessible(true);
            Collection collection = (Collection) field.get(litePalSupport);
            if (collection != null) {
                litePalSupport.getClassName();
                field.getName();
                String genericTableName = DBUtility.getGenericTableName(litePalSupport.getClassName(), field.getName());
                String genericValueIdColumnName = DBUtility.getGenericValueIdColumnName(litePalSupport.getClassName());
                this.mDatabase.delete(genericTableName, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(genericValueIdColumnName, " = ?"), new String[]{String.valueOf(j)});
                for (Object obj : collection) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(genericValueIdColumnName, Long.valueOf(j));
                    Object encryptValue = encryptValue(algorithm, obj);
                    if (litePalSupport.getClassName().equals(genericTypeName)) {
                        LitePalSupport litePalSupport2 = (LitePalSupport) encryptValue;
                        if (litePalSupport2 != null) {
                            long baseObjId = litePalSupport2.getBaseObjId();
                            if (baseObjId > 0) {
                                contentValues.put(DBUtility.getM2MSelfRefColumnName(field), Long.valueOf(baseObjId));
                            }
                        }
                    } else {
                        Object[] objArr = new Object[2];
                        objArr[0] = BaseUtility.changeCase(DBUtility.convertToValidColumnName(field.getName()));
                        objArr[c] = encryptValue;
                        Class[] clsArr = new Class[2];
                        clsArr[0] = String.class;
                        clsArr[c] = getGenericTypeClass(field);
                        DynamicExecutor.send(contentValues, "put", objArr, contentValues.getClass(), clsArr);
                    }
                    this.mDatabase.insert(genericTableName, null, contentValues);
                    c = 1;
                }
            }
        }
    }

    private void updating(LitePalSupport litePalSupport, ContentValues contentValues) {
        if (contentValues.size() > 0) {
            this.mDatabase.update(litePalSupport.getTableName(), contentValues, "id = ?", new String[]{String.valueOf(litePalSupport.getBaseObjId())});
        }
    }

    public void onSave(LitePalSupport litePalSupport) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        String className = litePalSupport.getClassName();
        List<Field> supportedFields = getSupportedFields(className);
        List<Field> supportedGenericFields = getSupportedGenericFields(className);
        Collection<AssociationsInfo> associationInfo = getAssociationInfo(className);
        boolean isSaved = litePalSupport.isSaved();
        analyzeAssociatedModels(litePalSupport, associationInfo);
        if (isSaved) {
            doUpdateAction(litePalSupport, supportedFields, supportedGenericFields);
            return;
        }
        doSaveAction(litePalSupport, supportedFields, supportedGenericFields);
        analyzeAssociatedModels(litePalSupport, associationInfo);
    }

    public <T extends LitePalSupport> void onSaveAll(Collection<T> collection) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (collection == null || collection.size() <= 0) {
            return;
        }
        LitePalSupport[] litePalSupportArr = (LitePalSupport[]) collection.toArray(new LitePalSupport[0]);
        String className = litePalSupportArr[0].getClassName();
        List<Field> supportedFields = getSupportedFields(className);
        List<Field> supportedGenericFields = getSupportedGenericFields(className);
        Collection<AssociationsInfo> associationInfo = getAssociationInfo(className);
        for (LitePalSupport litePalSupport : litePalSupportArr) {
            boolean isSaved = litePalSupport.isSaved();
            analyzeAssociatedModels(litePalSupport, associationInfo);
            if (!isSaved) {
                doSaveAction(litePalSupport, supportedFields, supportedGenericFields);
                analyzeAssociatedModels(litePalSupport, associationInfo);
            } else {
                doUpdateAction(litePalSupport, supportedFields, supportedGenericFields);
            }
            litePalSupport.clearAssociatedData();
        }
    }
}
