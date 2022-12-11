package org.seamless.swing;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/* loaded from: classes5.dex */
public class BeanTableModel<T> extends AbstractTableModel {
    public Class<T> beanClass;
    public List<PropertyDescriptor> properties = new ArrayList();
    public List<T> rows;

    public BeanTableModel(Class<T> cls, Collection<T> collection) {
        this.beanClass = cls;
        this.rows = new ArrayList(collection);
    }

    public void addColumn(String str, String str2) {
        try {
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(str2, this.beanClass, str2, (String) null);
            propertyDescriptor.setDisplayName(str);
            this.properties.add(propertyDescriptor);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void addRow(T t) {
        this.rows.add(t);
        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    }

    public int getColumnCount() {
        return this.properties.size();
    }

    public String getColumnName(int i) {
        return this.properties.get(i).getDisplayName();
    }

    public int getRowCount() {
        return this.rows.size();
    }

    public List<T> getRows() {
        return this.rows;
    }

    public Object getValueAt(int i, int i2) {
        T t = this.rows.get(i);
        if (t != null) {
            try {
                return this.properties.get(i2).getReadMethod().invoke(t, new Object[0]);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    public void removeRow(int i) {
        if (this.rows.size() <= i || i == -1) {
            return;
        }
        this.rows.remove(i);
        fireTableRowsDeleted(i, i);
    }

    public void resetColumns() {
        this.properties = new ArrayList();
    }

    public void setRow(int i, T t) {
        this.rows.remove(i);
        this.rows.add(i, t);
        fireTableDataChanged();
    }

    public void setRows(Collection<T> collection) {
        this.rows = new ArrayList(collection);
        fireTableDataChanged();
    }
}
