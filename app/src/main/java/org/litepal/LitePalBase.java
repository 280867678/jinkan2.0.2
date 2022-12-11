package org.litepal;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import me.tvspark.outline;
import org.litepal.annotation.Column;
import org.litepal.crud.LitePalSupport;
import org.litepal.crud.model.AssociationsInfo;
import org.litepal.exceptions.DatabaseGenerateException;
import org.litepal.parser.LitePalAttr;
import org.litepal.tablemanager.model.AssociationsModel;
import org.litepal.tablemanager.model.ColumnModel;
import org.litepal.tablemanager.model.GenericModel;
import org.litepal.tablemanager.model.TableModel;
import org.litepal.tablemanager.typechange.BlobOrm;
import org.litepal.tablemanager.typechange.BooleanOrm;
import org.litepal.tablemanager.typechange.DateOrm;
import org.litepal.tablemanager.typechange.DecimalOrm;
import org.litepal.tablemanager.typechange.NumericOrm;
import org.litepal.tablemanager.typechange.OrmChange;
import org.litepal.tablemanager.typechange.TextOrm;
import org.litepal.util.BaseUtility;
import org.litepal.util.DBUtility;

/* loaded from: classes5.dex */
public abstract class LitePalBase {
    public static final int GET_ASSOCIATIONS_ACTION = 1;
    public static final int GET_ASSOCIATION_INFO_ACTION = 2;
    public static final String TAG = "LitePalBase";
    public Collection<AssociationsInfo> mAssociationInfos;
    public Collection<AssociationsModel> mAssociationModels;
    public Collection<GenericModel> mGenericModels;
    public OrmChange[] typeChangeRules = {new NumericOrm(), new TextOrm(), new BooleanOrm(), new DecimalOrm(), new DateOrm(), new BlobOrm()};
    public Map<String, List<Field>> classFieldsMap = new HashMap();
    public Map<String, List<Field>> classGenericFieldsMap = new HashMap();

    private void addIntoAssociationInfoCollection(String str, String str2, String str3, Field field, Field field2, int i) {
        AssociationsInfo associationsInfo = new AssociationsInfo();
        associationsInfo.setSelfClassName(str);
        associationsInfo.setAssociatedClassName(str2);
        associationsInfo.setClassHoldsForeignKey(str3);
        associationsInfo.setAssociateOtherModelFromSelf(field);
        associationsInfo.setAssociateSelfFromOtherModel(field2);
        associationsInfo.setAssociationType(i);
        this.mAssociationInfos.add(associationsInfo);
    }

    private void addIntoAssociationModelCollection(String str, String str2, String str3, int i) {
        AssociationsModel associationsModel = new AssociationsModel();
        associationsModel.setTableName(DBUtility.getTableNameByClassName(str));
        associationsModel.setAssociatedTableName(DBUtility.getTableNameByClassName(str2));
        associationsModel.setTableHoldsForeignKey(DBUtility.getTableNameByClassName(str3));
        associationsModel.setAssociationType(i);
        this.mAssociationModels.add(associationsModel);
    }

    private void analyzeClassFields(String str, int i) {
        Field[] declaredFields;
        Column column;
        try {
            for (Field field : Class.forName(str).getDeclaredFields()) {
                if (isNonPrimitive(field) && ((column = (Column) field.getAnnotation(Column.class)) == null || !column.ignore())) {
                    oneToAnyConditions(str, field, i);
                    manyToAnyConditions(str, field, i);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new DatabaseGenerateException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DatabaseGenerateException.CLASS_NOT_FOUND, str));
        }
    }

    private ColumnModel convertFieldToColumnModel(Field field) {
        boolean z;
        boolean z2;
        String str;
        String columnType = getColumnType(field.getType().getName());
        Column column = (Column) field.getAnnotation(Column.class);
        if (column != null) {
            z = column.nullable();
            z2 = column.unique();
            str = column.defaultValue();
        } else {
            z = true;
            z2 = false;
            str = "";
        }
        ColumnModel columnModel = new ColumnModel();
        columnModel.setColumnName(DBUtility.convertToValidColumnName(field.getName()));
        columnModel.setColumnType(columnType);
        columnModel.setNullable(z);
        columnModel.setUnique(z2);
        columnModel.setDefaultValue(str);
        return columnModel;
    }

    private boolean isNonPrimitive(Field field) {
        return !field.getType().isPrimitive();
    }

    private boolean isPrivate(Field field) {
        return Modifier.isPrivate(field.getModifiers());
    }

    private void manyToAnyConditions(String str, Field field, int i) throws ClassNotFoundException {
        Field[] declaredFields;
        String str2;
        int i2;
        LitePalBase litePalBase;
        String str3;
        String str4;
        if (isCollection(field.getType())) {
            String genericTypeName = getGenericTypeName(field);
            if (!LitePalAttr.getInstance().getClassNames().contains(genericTypeName)) {
                if (!BaseUtility.isGenericTypeSupported(genericTypeName) || i != 1) {
                    return;
                }
                GenericModel genericModel = new GenericModel();
                genericModel.setTableName(DBUtility.getGenericTableName(str, field.getName()));
                genericModel.setValueColumnName(DBUtility.convertToValidColumnName(field.getName()));
                genericModel.setValueColumnType(getColumnType(genericTypeName));
                genericModel.setValueIdColumnName(DBUtility.getGenericValueIdColumnName(str));
                this.mGenericModels.add(genericModel);
                return;
            }
            boolean z = false;
            for (Field field2 : Class.forName(genericTypeName).getDeclaredFields()) {
                if (!Modifier.isStatic(field2.getModifiers())) {
                    Class<?> type = field2.getType();
                    if (str.equals(type.getName())) {
                        if (i == 1) {
                            addIntoAssociationModelCollection(str, genericTypeName, genericTypeName, 2);
                        } else if (i == 2) {
                            i2 = 2;
                            litePalBase = this;
                            str3 = str;
                            str4 = genericTypeName;
                            str2 = genericTypeName;
                            litePalBase.addIntoAssociationInfoCollection(str3, str4, str2, field, field2, i2);
                        }
                        z = true;
                    } else if (isCollection(type) && str.equals(getGenericTypeName(field2))) {
                        if (i == 1) {
                            if (str.equalsIgnoreCase(genericTypeName)) {
                                GenericModel genericModel2 = new GenericModel();
                                genericModel2.setTableName(DBUtility.getGenericTableName(str, field.getName()));
                                genericModel2.setValueColumnName(DBUtility.getM2MSelfRefColumnName(field));
                                genericModel2.setValueColumnType("integer");
                                genericModel2.setValueIdColumnName(DBUtility.getGenericValueIdColumnName(str));
                                this.mGenericModels.add(genericModel2);
                            } else {
                                addIntoAssociationModelCollection(str, genericTypeName, null, 3);
                            }
                        } else if (i == 2 && !str.equalsIgnoreCase(genericTypeName)) {
                            str2 = null;
                            i2 = 3;
                            litePalBase = this;
                            str3 = str;
                            str4 = genericTypeName;
                            litePalBase.addIntoAssociationInfoCollection(str3, str4, str2, field, field2, i2);
                        }
                        z = true;
                    }
                }
            }
            if (z) {
                return;
            }
            if (i == 1) {
                addIntoAssociationModelCollection(str, genericTypeName, genericTypeName, 2);
            } else if (i == 2) {
                addIntoAssociationInfoCollection(str, genericTypeName, genericTypeName, field, null, 2);
            }
        }
    }

    private void oneToAnyConditions(String str, Field field, int i) throws ClassNotFoundException {
        Field[] declaredFields;
        String name;
        int i2;
        LitePalBase litePalBase;
        String str2;
        String str3;
        Class<?> type = field.getType();
        if (LitePalAttr.getInstance().getClassNames().contains(type.getName())) {
            boolean z = false;
            for (Field field2 : Class.forName(type.getName()).getDeclaredFields()) {
                if (!Modifier.isStatic(field2.getModifiers())) {
                    Class<?> type2 = field2.getType();
                    if (str.equals(type2.getName())) {
                        if (i == 1) {
                            addIntoAssociationModelCollection(str, type.getName(), type.getName(), 1);
                        } else if (i == 2) {
                            name = type.getName();
                            str3 = type.getName();
                            i2 = 1;
                            litePalBase = this;
                            str2 = str;
                            litePalBase.addIntoAssociationInfoCollection(str2, name, str3, field, field2, i2);
                        }
                        z = true;
                    } else if (isCollection(type2) && str.equals(getGenericTypeName(field2))) {
                        if (i == 1) {
                            addIntoAssociationModelCollection(str, type.getName(), str, 2);
                        } else if (i == 2) {
                            name = type.getName();
                            i2 = 2;
                            litePalBase = this;
                            str2 = str;
                            str3 = str;
                            litePalBase.addIntoAssociationInfoCollection(str2, name, str3, field, field2, i2);
                        }
                        z = true;
                    }
                }
            }
            if (z) {
                return;
            }
            if (i == 1) {
                addIntoAssociationModelCollection(str, type.getName(), type.getName(), 1);
            } else if (i == 2) {
                addIntoAssociationInfoCollection(str, type.getName(), type.getName(), field, null, 1);
            }
        }
    }

    private void recursiveSupportedFields(Class<?> cls, List<Field> list) {
        if (cls == LitePalSupport.class || cls == Object.class) {
            return;
        }
        Field[] declaredFields = cls.getDeclaredFields();
        if (declaredFields != null && declaredFields.length > 0) {
            for (Field field : declaredFields) {
                Column column = (Column) field.getAnnotation(Column.class);
                if ((column == null || !column.ignore()) && !Modifier.isStatic(field.getModifiers()) && BaseUtility.isFieldTypeSupported(field.getType().getName())) {
                    list.add(field);
                }
            }
        }
        recursiveSupportedFields(cls.getSuperclass(), list);
    }

    private void recursiveSupportedGenericFields(Class<?> cls, List<Field> list) {
        if (cls == LitePalSupport.class || cls == Object.class) {
            return;
        }
        Field[] declaredFields = cls.getDeclaredFields();
        if (declaredFields != null && declaredFields.length > 0) {
            for (Field field : declaredFields) {
                Column column = (Column) field.getAnnotation(Column.class);
                if ((column == null || !column.ignore()) && !Modifier.isStatic(field.getModifiers()) && isCollection(field.getType())) {
                    String genericTypeName = getGenericTypeName(field);
                    if (BaseUtility.isGenericTypeSupported(genericTypeName) || cls.getName().equalsIgnoreCase(genericTypeName)) {
                        list.add(field);
                    }
                }
            }
        }
        recursiveSupportedGenericFields(cls.getSuperclass(), list);
    }

    public Collection<AssociationsInfo> getAssociationInfo(String str) {
        if (this.mAssociationInfos == null) {
            this.mAssociationInfos = new HashSet();
        }
        this.mAssociationInfos.clear();
        analyzeClassFields(str, 2);
        return this.mAssociationInfos;
    }

    public Collection<AssociationsModel> getAssociations(List<String> list) {
        if (this.mAssociationModels == null) {
            this.mAssociationModels = new HashSet();
        }
        if (this.mGenericModels == null) {
            this.mGenericModels = new HashSet();
        }
        this.mAssociationModels.clear();
        this.mGenericModels.clear();
        for (String str : list) {
            analyzeClassFields(str, 1);
        }
        return this.mAssociationModels;
    }

    public String getColumnType(String str) {
        for (OrmChange ormChange : this.typeChangeRules) {
            String object2Relation = ormChange.object2Relation(str);
            if (object2Relation != null) {
                return object2Relation;
            }
        }
        return null;
    }

    public String getForeignKeyColumnName(String str) {
        return BaseUtility.changeCase(str + "_id");
    }

    public Collection<GenericModel> getGenericModels() {
        return this.mGenericModels;
    }

    public Class<?> getGenericTypeClass(Field field) {
        Type genericType = field.getGenericType();
        if (genericType == null || !(genericType instanceof ParameterizedType)) {
            return null;
        }
        return (Class) ((ParameterizedType) genericType).getActualTypeArguments()[0];
    }

    public String getGenericTypeName(Field field) {
        Class<?> genericTypeClass = getGenericTypeClass(field);
        if (genericTypeClass != null) {
            return genericTypeClass.getName();
        }
        return null;
    }

    public List<Field> getSupportedFields(String str) {
        List<Field> list = this.classFieldsMap.get(str);
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            try {
                recursiveSupportedFields(Class.forName(str), arrayList);
                this.classFieldsMap.put(str, arrayList);
                return arrayList;
            } catch (ClassNotFoundException unused) {
                throw new DatabaseGenerateException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DatabaseGenerateException.CLASS_NOT_FOUND, str));
            }
        }
        return list;
    }

    public List<Field> getSupportedGenericFields(String str) {
        List<Field> list = this.classGenericFieldsMap.get(str);
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            try {
                recursiveSupportedGenericFields(Class.forName(str), arrayList);
                this.classGenericFieldsMap.put(str, arrayList);
                return arrayList;
            } catch (ClassNotFoundException unused) {
                throw new DatabaseGenerateException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DatabaseGenerateException.CLASS_NOT_FOUND, str));
            }
        }
        return list;
    }

    public TableModel getTableModel(String str) {
        String tableNameByClassName = DBUtility.getTableNameByClassName(str);
        TableModel tableModel = new TableModel();
        tableModel.setTableName(tableNameByClassName);
        tableModel.setClassName(str);
        for (Field field : getSupportedFields(str)) {
            tableModel.addColumnModel(convertFieldToColumnModel(field));
        }
        return tableModel;
    }

    public boolean isCollection(Class<?> cls) {
        return isList(cls) || isSet(cls);
    }

    public boolean isIdColumn(String str) {
        return "_id".equalsIgnoreCase(str) || "id".equalsIgnoreCase(str);
    }

    public boolean isList(Class<?> cls) {
        return List.class.isAssignableFrom(cls);
    }

    public boolean isSet(Class<?> cls) {
        return Set.class.isAssignableFrom(cls);
    }
}
