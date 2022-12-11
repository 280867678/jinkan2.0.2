package org.litepal.crud;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.SparseArray;
import androidx.cardview.widget.RoundRectDrawableWithShadow;
import com.umeng.analytics.pro.C1543ak;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import me.tvspark.outline;
import org.apache.http.message.TokenParser;
import org.litepal.LitePalBase;
import org.litepal.Operator;
import org.litepal.annotation.Encrypt;
import org.litepal.crud.model.AssociationsInfo;
import org.litepal.exceptions.DatabaseGenerateException;
import org.litepal.exceptions.LitePalSupportException;
import org.litepal.tablemanager.model.GenericModel;
import org.litepal.util.BaseUtility;
import org.litepal.util.DBUtility;
import org.litepal.util.cipher.CipherUtil;
import org.simpleframework.xml.transform.ClassTransform;

/* loaded from: classes5.dex */
public abstract class DataHandler extends LitePalBase {
    public static final String TAG = "DataHandler";
    public List<AssociationsInfo> fkInCurrentModel;
    public List<AssociationsInfo> fkInOtherModel;
    public SQLiteDatabase mDatabase;
    public LitePalSupport tempEmptyModel;

    /* loaded from: classes5.dex */
    public class QueryInfoCache {
        public Field field;
        public String getMethodName;

        public QueryInfoCache() {
        }
    }

    private void analyzeAssociations(String str) {
        List<AssociationsInfo> list;
        Collection<AssociationsInfo> associationInfo = getAssociationInfo(str);
        List<AssociationsInfo> list2 = this.fkInCurrentModel;
        if (list2 == null) {
            this.fkInCurrentModel = new ArrayList();
        } else {
            list2.clear();
        }
        List<AssociationsInfo> list3 = this.fkInOtherModel;
        if (list3 == null) {
            this.fkInOtherModel = new ArrayList();
        } else {
            list3.clear();
        }
        for (AssociationsInfo associationsInfo : associationInfo) {
            if (associationsInfo.getAssociationType() == 2 || associationsInfo.getAssociationType() == 1) {
                if (associationsInfo.getClassHoldsForeignKey().equals(str)) {
                    list = this.fkInCurrentModel;
                    list.add(associationsInfo);
                }
            } else if (associationsInfo.getAssociationType() == 3) {
            }
            list = this.fkInOtherModel;
            list.add(associationsInfo);
        }
    }

    private String genGetColumnMethod(Class<?> cls) {
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("get", cls.isPrimitive() ? BaseUtility.capitalize(cls.getName()) : cls.getSimpleName());
        if (!"getBoolean".equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
            if ("getChar".equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) || "getCharacter".equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                return "getString";
            }
            if ("getDate".equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                return "getLong";
            }
            if (!"getInteger".equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                return "getbyte[]".equalsIgnoreCase(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) ? "getBlob" : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
        }
        return "getInt";
    }

    private String genGetColumnMethod(Field field) {
        return genGetColumnMethod(isCollection(field.getType()) ? getGenericTypeClass(field) : field.getType());
    }

    private String[] getCustomizedColumns(String[] strArr, List<Field> list, List<AssociationsInfo> list2) {
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        for (Field field : list) {
            arrayList2.add(field.getName());
        }
        boolean z = false;
        for (int i = 0; i < arrayList.size(); i++) {
            String str = (String) arrayList.get(i);
            if (BaseUtility.containsIgnoreCases(arrayList2, str)) {
                arrayList3.add(Integer.valueOf(i));
            } else if (isIdColumn(str)) {
                if ("_id".equalsIgnoreCase(str)) {
                    arrayList.set(i, BaseUtility.changeCase("id"));
                }
                z = true;
            }
        }
        for (int size = arrayList3.size() - 1; size >= 0; size--) {
            arrayList4.add((String) arrayList.remove(((Integer) arrayList3.get(size)).intValue()));
        }
        for (Field field2 : list) {
            if (BaseUtility.containsIgnoreCases(arrayList4, field2.getName())) {
                arrayList5.add(field2);
            }
        }
        list.clear();
        list.addAll(arrayList5);
        if (list2 != null && list2.size() > 0) {
            for (int i2 = 0; i2 < list2.size(); i2++) {
                arrayList.add(getForeignKeyColumnName(DBUtility.getTableNameByClassName(list2.get(i2).getAssociatedClassName())));
            }
        }
        if (!z) {
            arrayList.add(BaseUtility.changeCase("id"));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private Object getInitParamValue(Class<?> cls, Class<?> cls2) {
        String name = cls2.getName();
        if (ClassTransform.BOOLEAN.equals(name) || "java.lang.Boolean".equals(name)) {
            return false;
        }
        if (ClassTransform.FLOAT.equals(name) || "java.lang.Float".equals(name)) {
            return Float.valueOf(0.0f);
        }
        if (ClassTransform.DOUBLE.equals(name) || "java.lang.Double".equals(name)) {
            return Double.valueOf((double) RoundRectDrawableWithShadow.COS_45);
        }
        if (ClassTransform.INTEGER.equals(name) || "java.lang.Integer".equals(name)) {
            return 0;
        }
        if (ClassTransform.LONG.equals(name) || "java.lang.Long".equals(name)) {
            return 0L;
        }
        if (ClassTransform.SHORT.equals(name) || "java.lang.Short".equals(name)) {
            return 0;
        }
        if (ClassTransform.CHARACTER.equals(name) || "java.lang.Character".equals(name)) {
            return Character.valueOf(TokenParser.f4579SP);
        }
        if ("[B".equals(name) || "[Ljava.lang.Byte;".equals(name)) {
            return new byte[0];
        }
        if ("java.lang.String".equals(name)) {
            return "";
        }
        if (cls != cls2) {
            return createInstanceFromClass(cls2);
        }
        return null;
    }

    private Class<?> getObjectType(Class<?> cls) {
        if (cls == null || !cls.isPrimitive()) {
            return null;
        }
        String name = cls.getName();
        if (ClassTransform.INTEGER.equals(name)) {
            return Integer.class;
        }
        if (ClassTransform.SHORT.equals(name)) {
            return Short.class;
        }
        if (ClassTransform.LONG.equals(name)) {
            return Long.class;
        }
        if (ClassTransform.FLOAT.equals(name)) {
            return Float.class;
        }
        if (ClassTransform.DOUBLE.equals(name)) {
            return Double.class;
        }
        if (ClassTransform.BOOLEAN.equals(name)) {
            return Boolean.class;
        }
        if (!ClassTransform.CHARACTER.equals(name)) {
            return null;
        }
        return Character.class;
    }

    private boolean isCharType(Field field) {
        String name = field.getType().getName();
        return name.equals(ClassTransform.CHARACTER) || name.endsWith("Character");
    }

    private boolean isFieldWithDefaultValue(LitePalSupport litePalSupport, Field field) throws IllegalAccessException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        LitePalSupport emptyModel = getEmptyModel(litePalSupport);
        Object fieldValue = getFieldValue(litePalSupport, field);
        Object fieldValue2 = getFieldValue(emptyModel, field);
        return (fieldValue == null || fieldValue2 == null) ? fieldValue == fieldValue2 : fieldValue.toString().equals(fieldValue2.toString());
    }

    private boolean isPrimitiveBooleanType(Field field) {
        return ClassTransform.BOOLEAN.equals(field.getType().getName());
    }

    private boolean isSaving() {
        return SaveHandler.class.getName().equals(getClass().getName());
    }

    private boolean isUpdating() {
        return UpdateHandler.class.getName().equals(getClass().getName());
    }

    private String makeGetterMethodName(Field field) {
        String str;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        String name = field.getName();
        if (isPrimitiveBooleanType(field)) {
            if (name.matches("^is[A-Z]{1}.*$")) {
                name = name.substring(2);
            }
            str = C1543ak.f2994ae;
        } else {
            str = "get";
        }
        if (name.matches("^[a-z]{1}[A-Z]{1}.*")) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, name);
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(BaseUtility.capitalize(name));
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    private String makeSetterMethodName(Field field) {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        String capitalize;
        if (isPrimitiveBooleanType(field) && field.getName().matches("^is[A-Z]{1}.*$")) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("set");
            capitalize = field.getName().substring(2);
        } else if (field.getName().matches("^[a-z]{1}[A-Z]{1}.*")) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("set");
            capitalize = field.getName();
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("set");
            capitalize = BaseUtility.capitalize(field.getName());
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(capitalize);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    private void putFieldsValueDependsOnSaveOrUpdate(LitePalSupport litePalSupport, Field field, ContentValues contentValues) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (isUpdating()) {
            if (isFieldWithDefaultValue(litePalSupport, field)) {
                return;
            }
            putContentValuesForUpdate(litePalSupport, field, contentValues);
        } else if (!isSaving()) {
        } else {
            putContentValuesForSave(litePalSupport, field, contentValues);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x018d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x000d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0172 A[LOOP:1: B:28:0x00ef->B:40:0x0172, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x016b A[EDGE_INSN: B:41:0x016b->B:42:0x016b ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void setAssociatedModel(LitePalSupport litePalSupport) {
        Cursor cursor;
        Cursor query;
        Cursor cursor2;
        HashMap hashMap;
        List<AssociationsInfo> list = this.fkInOtherModel;
        if (list == null) {
            return;
        }
        for (AssociationsInfo associationsInfo : list) {
            String associatedClassName = associationsInfo.getAssociatedClassName();
            boolean z = associationsInfo.getAssociationType() == 3;
            try {
                List<Field> supportedFields = getSupportedFields(associatedClassName);
                List<Field> supportedGenericFields = getSupportedGenericFields(associatedClassName);
                if (z) {
                    String tableName = litePalSupport.getTableName();
                    String tableNameByClassName = DBUtility.getTableNameByClassName(associatedClassName);
                    String intermediateTableName = DBUtility.getIntermediateTableName(tableName, tableNameByClassName);
                    StringBuilder sb = new StringBuilder();
                    sb.append("select * from ");
                    sb.append(tableNameByClassName);
                    sb.append(" a inner join ");
                    sb.append(intermediateTableName);
                    sb.append(" b on a.id = b.");
                    sb.append(tableNameByClassName + "_id");
                    sb.append(" where b.");
                    sb.append(tableName);
                    sb.append("_id = ?");
                    query = Operator.findBySQL(BaseUtility.changeCase(sb.toString()), String.valueOf(litePalSupport.getBaseObjId()));
                } else {
                    String foreignKeyColumnName = getForeignKeyColumnName(DBUtility.getTableNameByClassName(associationsInfo.getSelfClassName()));
                    String tableNameByClassName2 = DBUtility.getTableNameByClassName(associatedClassName);
                    SQLiteDatabase sQLiteDatabase = this.mDatabase;
                    String changeCase = BaseUtility.changeCase(tableNameByClassName2);
                    query = sQLiteDatabase.query(changeCase, null, foreignKeyColumnName + "=?", new String[]{String.valueOf(litePalSupport.getBaseObjId())}, null, null, null, null);
                }
                Cursor cursor3 = query;
                if (cursor3 != null) {
                    try {
                        if (cursor3.moveToFirst()) {
                            SparseArray<QueryInfoCache> sparseArray = new SparseArray<>();
                            HashMap hashMap2 = new HashMap();
                            while (true) {
                                LitePalSupport litePalSupport2 = (LitePalSupport) createInstanceFromClass(Class.forName(associatedClassName));
                                giveBaseObjIdValue(litePalSupport2, cursor3.getLong(cursor3.getColumnIndexOrThrow("id")));
                                hashMap = hashMap2;
                                cursor2 = cursor3;
                                try {
                                    setValueToModel(litePalSupport2, supportedFields, null, cursor3, sparseArray);
                                    setGenericValueToModel(litePalSupport2, supportedGenericFields, hashMap);
                                    if (associationsInfo.getAssociationType() != 2 && !z) {
                                        if (associationsInfo.getAssociationType() == 1) {
                                            setFieldValue(litePalSupport, associationsInfo.getAssociateOtherModelFromSelf(), litePalSupport2);
                                        }
                                        if (cursor2.moveToNext()) {
                                            break;
                                        }
                                        hashMap2 = hashMap;
                                        cursor3 = cursor2;
                                    }
                                    Field associateOtherModelFromSelf = associationsInfo.getAssociateOtherModelFromSelf();
                                    Collection collection = (Collection) getFieldValue(litePalSupport, associateOtherModelFromSelf);
                                    if (collection == null) {
                                        collection = isList(associateOtherModelFromSelf.getType()) ? new ArrayList() : new HashSet();
                                        DynamicExecutor.setField(litePalSupport, associateOtherModelFromSelf.getName(), collection, litePalSupport.getClass());
                                    }
                                    collection.add(litePalSupport2);
                                    if (cursor2.moveToNext()) {
                                    }
                                } catch (Exception e) {
                                    e = e;
                                    cursor = cursor2;
                                    try {
                                        throw new LitePalSupportException(e.getMessage(), e);
                                    } catch (Throwable th) {
                                        th = th;
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    cursor = cursor2;
                                    if (cursor != null) {
                                    }
                                    throw th;
                                }
                            }
                            sparseArray.clear();
                            hashMap.clear();
                            if (cursor2 == null) {
                                cursor2.close();
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        cursor2 = cursor3;
                    } catch (Throwable th3) {
                        th = th3;
                        cursor2 = cursor3;
                    }
                }
                cursor2 = cursor3;
                if (cursor2 == null) {
                }
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th4) {
                th = th4;
                cursor = null;
            }
        }
    }

    private void setToModelByReflection(Object obj, Field field, int i, String str, Cursor cursor) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Object invoke = cursor.getClass().getMethod(str, Integer.TYPE).invoke(cursor, Integer.valueOf(i));
        if (field.getType() == Boolean.TYPE || field.getType() == Boolean.class) {
            if ("0".equals(String.valueOf(invoke))) {
                invoke = false;
            } else if ("1".equals(String.valueOf(invoke))) {
                invoke = true;
            }
        } else if (field.getType() == Character.TYPE || field.getType() == Character.class) {
            invoke = Character.valueOf(((String) invoke).charAt(0));
        } else if (field.getType() == Date.class) {
            long longValue = ((Long) invoke).longValue();
            invoke = longValue <= 0 ? null : new Date(longValue);
        }
        if (!isCollection(field.getType())) {
            Encrypt encrypt = (Encrypt) field.getAnnotation(Encrypt.class);
            if (encrypt != null && "java.lang.String".equals(field.getType().getName())) {
                invoke = decryptValue(encrypt.algorithm(), invoke);
            }
            DynamicExecutor.setField(obj, field.getName(), invoke, obj.getClass());
            return;
        }
        Collection collection = (Collection) DynamicExecutor.getField(obj, field.getName(), obj.getClass());
        if (collection == null) {
            collection = isList(field.getType()) ? new ArrayList() : new HashSet();
            DynamicExecutor.setField(obj, field.getName(), collection, obj.getClass());
        }
        String genericTypeName = getGenericTypeName(field);
        if ("java.lang.String".equals(genericTypeName)) {
            Encrypt encrypt2 = (Encrypt) field.getAnnotation(Encrypt.class);
            if (encrypt2 != null) {
                invoke = decryptValue(encrypt2.algorithm(), invoke);
            }
        } else if (obj.getClass().getName().equals(genericTypeName) && ((invoke instanceof Long) || (invoke instanceof Integer))) {
            invoke = Operator.find(obj.getClass(), ((Long) invoke).longValue());
        }
        collection.add(invoke);
    }

    public void analyzeAssociatedModels(LitePalSupport litePalSupport, Collection<AssociationsInfo> collection) {
        try {
            for (AssociationsInfo associationsInfo : collection) {
                if (associationsInfo.getAssociationType() == 2) {
                    new Many2OneAnalyzer().analyze(litePalSupport, associationsInfo);
                } else if (associationsInfo.getAssociationType() == 1) {
                    new One2OneAnalyzer().analyze(litePalSupport, associationsInfo);
                } else if (associationsInfo.getAssociationType() == 3) {
                    new Many2ManyAnalyzer().analyze(litePalSupport, associationsInfo);
                }
            }
        } catch (Exception e) {
            throw new LitePalSupportException(e.getMessage(), e);
        }
    }

    public Object createInstanceFromClass(Class<?> cls) {
        try {
            Constructor<?> findBestSuitConstructor = findBestSuitConstructor(cls);
            return findBestSuitConstructor.newInstance(getConstructorParams(cls, findBestSuitConstructor));
        } catch (Exception e) {
            throw new LitePalSupportException(e.getMessage(), e);
        }
    }

    public Object decryptValue(String str, Object obj) {
        return (str == null || obj == null || !LitePalSupport.AES.equalsIgnoreCase(str)) ? obj : CipherUtil.aesDecrypt((String) obj);
    }

    public Object encryptValue(String str, Object obj) {
        return (str == null || obj == null) ? obj : LitePalSupport.AES.equalsIgnoreCase(str) ? CipherUtil.aesEncrypt((String) obj) : LitePalSupport.MD5.equalsIgnoreCase(str) ? CipherUtil.md5Encrypt((String) obj) : obj;
    }

    public Constructor<?> findBestSuitConstructor(Class<?> cls) {
        Class<?>[] parameterTypes;
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        SparseArray sparseArray = new SparseArray();
        int i = Integer.MAX_VALUE;
        for (Constructor<?> constructor : declaredConstructors) {
            int length = constructor.getParameterTypes().length;
            for (Class<?> cls2 : constructor.getParameterTypes()) {
                if (cls2 == cls || (cls2.getName().startsWith("com.android") && cls2.getName().endsWith("InstantReloadException"))) {
                    length += 10000;
                }
            }
            if (sparseArray.get(length) == null) {
                sparseArray.put(length, constructor);
            }
            if (length < i) {
                i = length;
            }
        }
        Constructor<?> constructor2 = (Constructor) sparseArray.get(i);
        if (constructor2 != null) {
            constructor2.setAccessible(true);
        }
        return constructor2;
    }

    public LitePalSupport getAssociatedModel(LitePalSupport litePalSupport, AssociationsInfo associationsInfo) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return (LitePalSupport) getFieldValue(litePalSupport, associationsInfo.getAssociateOtherModelFromSelf());
    }

    public Collection<LitePalSupport> getAssociatedModels(LitePalSupport litePalSupport, AssociationsInfo associationsInfo) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return (Collection) getFieldValue(litePalSupport, associationsInfo.getAssociateOtherModelFromSelf());
    }

    public Object[] getConstructorParams(Class<?> cls, Constructor<?> constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        Object[] objArr = new Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            objArr[i] = getInitParamValue(cls, parameterTypes[i]);
        }
        return objArr;
    }

    public LitePalSupport getEmptyModel(LitePalSupport litePalSupport) {
        LitePalSupport litePalSupport2 = this.tempEmptyModel;
        if (litePalSupport2 != null) {
            return litePalSupport2;
        }
        String str = null;
        try {
            str = litePalSupport.getClassName();
            LitePalSupport litePalSupport3 = (LitePalSupport) Class.forName(str).newInstance();
            this.tempEmptyModel = litePalSupport3;
            return litePalSupport3;
        } catch (ClassNotFoundException unused) {
            throw new DatabaseGenerateException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DatabaseGenerateException.CLASS_NOT_FOUND, str));
        } catch (InstantiationException e) {
            throw new LitePalSupportException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, LitePalSupportException.INSTANTIATION_EXCEPTION), e);
        } catch (Exception e2) {
            throw new LitePalSupportException(e2.getMessage(), e2);
        }
    }

    public Object getFieldValue(LitePalSupport litePalSupport, Field field) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        if (shouldGetOrSet(litePalSupport, field)) {
            return DynamicExecutor.getField(litePalSupport, field.getName(), litePalSupport.getClass());
        }
        return null;
    }

    public List<AssociationsInfo> getForeignKeyAssociations(String str, boolean z) {
        if (z) {
            analyzeAssociations(str);
            return this.fkInCurrentModel;
        }
        return null;
    }

    public String getIntermediateTableName(LitePalSupport litePalSupport, String str) {
        return BaseUtility.changeCase(DBUtility.getIntermediateTableName(litePalSupport.getTableName(), str));
    }

    public Class<?>[] getParameterTypes(Field field, Object obj, Object[] objArr) {
        Class<?>[] clsArr;
        if (isCharType(field)) {
            objArr[1] = String.valueOf(obj);
            return new Class[]{String.class, String.class};
        }
        if (field.getType().isPrimitive()) {
            clsArr = new Class[]{String.class, getObjectType(field.getType())};
        } else if ("java.util.Date".equals(field.getType().getName())) {
            return new Class[]{String.class, Long.class};
        } else {
            clsArr = new Class[]{String.class, field.getType()};
        }
        return clsArr;
    }

    public String getTableName(Class<?> cls) {
        return BaseUtility.changeCase(DBUtility.getTableNameByClassName(cls.getName()));
    }

    public String[] getWhereArgs(String... strArr) {
        if (!isAffectAllLines(strArr) && strArr != null && strArr.length > 1) {
            String[] strArr2 = new String[strArr.length - 1];
            System.arraycopy(strArr, 1, strArr2, 0, strArr.length - 1);
            return strArr2;
        }
        return null;
    }

    public String getWhereClause(String... strArr) {
        if (!isAffectAllLines(strArr) && strArr != null && strArr.length > 0) {
            return strArr[0];
        }
        return null;
    }

    public String getWhereOfIdsWithOr(Collection<Long> collection) {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (Long l : collection) {
            long longValue = l.longValue();
            if (z) {
                sb.append(" or ");
            }
            z = true;
            sb.append("id = ");
            sb.append(longValue);
        }
        return BaseUtility.changeCase(sb.toString());
    }

    public String getWhereOfIdsWithOr(long... jArr) {
        StringBuilder sb = new StringBuilder();
        int length = jArr.length;
        int i = 0;
        boolean z = false;
        while (i < length) {
            long j = jArr[i];
            if (z) {
                sb.append(" or ");
            }
            sb.append("id = ");
            sb.append(j);
            i++;
            z = true;
        }
        return BaseUtility.changeCase(sb.toString());
    }

    public void giveBaseObjIdValue(LitePalSupport litePalSupport, long j) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        if (j > 0) {
            DynamicExecutor.set(litePalSupport, "baseObjId", Long.valueOf(j), LitePalSupport.class);
        }
    }

    public boolean isAffectAllLines(Object... objArr) {
        return objArr != null && objArr.length == 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public <T> T mathQuery(String str, String[] strArr, String[] strArr2, Class<T> cls) {
        Cursor query;
        BaseUtility.checkConditionsCorrect(strArr2);
        T t = null;
        try {
            try {
                query = this.mDatabase.query(str, strArr, getWhereClause(strArr2), getWhereArgs(strArr2), null, null, null);
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (query.moveToFirst()) {
                t = (T) query.getClass().getMethod(genGetColumnMethod((Class<?>) cls), Integer.TYPE).invoke(query, 0);
            }
            query.close();
            return t;
        } catch (Exception e2) {
            e = e2;
            t = (T) query;
            throw new LitePalSupportException(e.getMessage(), e);
        } catch (Throwable th2) {
            th = th2;
            t = query;
            if (t != 0) {
                t.close();
            }
            throw th;
        }
    }

    public void putContentValuesForSave(LitePalSupport litePalSupport, Field field, ContentValues contentValues) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object field2 = DynamicExecutor.getField(litePalSupport, field.getName(), litePalSupport.getClass());
        if (field2 != null) {
            if ("java.util.Date".equals(field.getType().getName())) {
                field2 = Long.valueOf(((Date) field2).getTime());
            }
            Encrypt encrypt = (Encrypt) field.getAnnotation(Encrypt.class);
            if (encrypt != null && "java.lang.String".equals(field.getType().getName())) {
                field2 = encryptValue(encrypt.algorithm(), field2);
            }
            Object[] objArr = {BaseUtility.changeCase(DBUtility.convertToValidColumnName(field.getName())), field2};
            DynamicExecutor.send(contentValues, "put", objArr, contentValues.getClass(), getParameterTypes(field, field2, objArr));
        }
    }

    public void putContentValuesForUpdate(LitePalSupport litePalSupport, Field field, ContentValues contentValues) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object fieldValue = getFieldValue(litePalSupport, field);
        if ("java.util.Date".equals(field.getType().getName()) && fieldValue != null) {
            fieldValue = Long.valueOf(((Date) fieldValue).getTime());
        }
        Encrypt encrypt = (Encrypt) field.getAnnotation(Encrypt.class);
        if (encrypt != null && "java.lang.String".equals(field.getType().getName())) {
            fieldValue = encryptValue(encrypt.algorithm(), fieldValue);
        }
        Object[] objArr = {BaseUtility.changeCase(DBUtility.convertToValidColumnName(field.getName())), fieldValue};
        DynamicExecutor.send(contentValues, "put", objArr, contentValues.getClass(), getParameterTypes(field, fieldValue, objArr));
    }

    public void putFieldsValue(LitePalSupport litePalSupport, List<Field> list, ContentValues contentValues) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        for (Field field : list) {
            if (!isIdColumn(field.getName())) {
                putFieldsValueDependsOnSaveOrUpdate(litePalSupport, field, contentValues);
            }
        }
    }

    public <T> List<T> query(Class<T> cls, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5, List<AssociationsInfo> list) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                List<Field> supportedFields = getSupportedFields(cls.getName());
                List<Field> supportedGenericFields = getSupportedGenericFields(cls.getName());
                String[] convertSelectClauseToValidNames = DBUtility.convertSelectClauseToValidNames(getCustomizedColumns(strArr, supportedGenericFields, list));
                cursor = this.mDatabase.query(getTableName(cls), convertSelectClauseToValidNames, str, strArr2, str2, str3, str4, str5);
                if (cursor.moveToFirst()) {
                    SparseArray<QueryInfoCache> sparseArray = new SparseArray<>();
                    HashMap hashMap = new HashMap();
                    do {
                        Object createInstanceFromClass = createInstanceFromClass(cls);
                        giveBaseObjIdValue((LitePalSupport) createInstanceFromClass, cursor.getLong(cursor.getColumnIndexOrThrow("id")));
                        setValueToModel(createInstanceFromClass, supportedFields, list, cursor, sparseArray);
                        setGenericValueToModel((LitePalSupport) createInstanceFromClass, supportedGenericFields, hashMap);
                        if (list != null) {
                            setAssociatedModel((LitePalSupport) createInstanceFromClass);
                        }
                        arrayList.add(createInstanceFromClass);
                    } while (cursor.moveToNext());
                    sparseArray.clear();
                    hashMap.clear();
                }
                cursor.close();
                return arrayList;
            } catch (Exception e) {
                throw new LitePalSupportException(e.getMessage(), e);
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public void setFieldValue(LitePalSupport litePalSupport, Field field, Object obj) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        if (shouldGetOrSet(litePalSupport, field)) {
            DynamicExecutor.setField(litePalSupport, field.getName(), obj, litePalSupport.getClass());
        }
    }

    public void setGenericValueToModel(LitePalSupport litePalSupport, List<Field> list, Map<Field, GenericModel> map) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        String tableName;
        String valueIdColumnName;
        String getMethodName;
        String str;
        String convertToValidColumnName;
        String genGetColumnMethod;
        for (Field field : list) {
            Cursor cursor = null;
            GenericModel genericModel = map.get(field);
            if (genericModel == null) {
                if (litePalSupport.getClassName().equals(getGenericTypeName(field))) {
                    convertToValidColumnName = DBUtility.getM2MSelfRefColumnName(field);
                    genGetColumnMethod = "getLong";
                } else {
                    convertToValidColumnName = DBUtility.convertToValidColumnName(field.getName());
                    genGetColumnMethod = genGetColumnMethod(field);
                }
                tableName = DBUtility.getGenericTableName(litePalSupport.getClassName(), field.getName());
                valueIdColumnName = DBUtility.getGenericValueIdColumnName(litePalSupport.getClassName());
                GenericModel genericModel2 = new GenericModel();
                genericModel2.setTableName(tableName);
                genericModel2.setValueColumnName(convertToValidColumnName);
                genericModel2.setValueIdColumnName(valueIdColumnName);
                genericModel2.setGetMethodName(genGetColumnMethod);
                map.put(field, genericModel2);
                str = convertToValidColumnName;
                getMethodName = genGetColumnMethod;
            } else {
                tableName = genericModel.getTableName();
                String valueColumnName = genericModel.getValueColumnName();
                valueIdColumnName = genericModel.getValueIdColumnName();
                getMethodName = genericModel.getGetMethodName();
                str = valueColumnName;
            }
            String str2 = tableName;
            try {
                SQLiteDatabase sQLiteDatabase = this.mDatabase;
                Cursor query = sQLiteDatabase.query(str2, null, valueIdColumnName + " = ?", new String[]{String.valueOf(litePalSupport.getBaseObjId())}, null, null, null);
                try {
                    if (query.moveToFirst()) {
                        do {
                            int columnIndex = query.getColumnIndex(BaseUtility.changeCase(str));
                            if (columnIndex != -1) {
                                setToModelByReflection(litePalSupport, field, columnIndex, getMethodName, query);
                            }
                        } while (query.moveToNext());
                    }
                    query.close();
                } catch (Throwable th) {
                    th = th;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public void setValueToModel(Object obj, List<Field> list, List<AssociationsInfo> list2, Cursor cursor, SparseArray<QueryInfoCache> sparseArray) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        int size = sparseArray.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                int keyAt = sparseArray.keyAt(i);
                QueryInfoCache queryInfoCache = sparseArray.get(keyAt);
                setToModelByReflection(obj, queryInfoCache.field, keyAt, queryInfoCache.getMethodName, cursor);
            }
        } else {
            for (Field field : list) {
                String genGetColumnMethod = genGetColumnMethod(field);
                int columnIndex = cursor.getColumnIndex(BaseUtility.changeCase(isIdColumn(field.getName()) ? "id" : DBUtility.convertToValidColumnName(field.getName())));
                if (columnIndex != -1) {
                    setToModelByReflection(obj, field, columnIndex, genGetColumnMethod, cursor);
                    QueryInfoCache queryInfoCache2 = new QueryInfoCache();
                    queryInfoCache2.getMethodName = genGetColumnMethod;
                    queryInfoCache2.field = field;
                    sparseArray.put(columnIndex, queryInfoCache2);
                }
            }
        }
        if (list2 != null) {
            for (AssociationsInfo associationsInfo : list2) {
                int columnIndex2 = cursor.getColumnIndex(getForeignKeyColumnName(DBUtility.getTableNameByClassName(associationsInfo.getAssociatedClassName())));
                if (columnIndex2 != -1) {
                    try {
                        LitePalSupport litePalSupport = (LitePalSupport) Operator.find(Class.forName(associationsInfo.getAssociatedClassName()), cursor.getLong(columnIndex2));
                        if (litePalSupport != null) {
                            setFieldValue((LitePalSupport) obj, associationsInfo.getAssociateOtherModelFromSelf(), litePalSupport);
                        }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public boolean shouldGetOrSet(LitePalSupport litePalSupport, Field field) {
        return (litePalSupport == null || field == null) ? false : true;
    }
}
