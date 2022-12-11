package org.seamless.swing.logging;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/* loaded from: classes5.dex */
public class LogTableModel extends AbstractTableModel {
    public int maxAgeSeconds;
    public boolean paused = false;
    public List<LogMessage> messages = new ArrayList();

    public LogTableModel(int i) {
        this.maxAgeSeconds = i;
    }

    public void clearMessages() {
        this.messages.clear();
        fireTableDataChanged();
    }

    public Class<?> getColumnClass(int i) {
        return LogMessage.class;
    }

    public int getColumnCount() {
        return 5;
    }

    public String getColumnName(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? "Message" : "Source" : "Thread" : "Time" : "";
    }

    public int getMaxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    public int getRowCount() {
        return this.messages.size();
    }

    public Object getValueAt(int i, int i2) {
        return this.messages.get(i);
    }

    public boolean isPaused() {
        return this.paused;
    }

    public synchronized void pushMessage(LogMessage logMessage) {
        if (this.paused) {
            return;
        }
        if (this.maxAgeSeconds != Integer.MAX_VALUE) {
            Iterator<LogMessage> it = this.messages.iterator();
            long time = new Date().getTime();
            while (it.hasNext()) {
                if (it.next().getCreatedOn().longValue() + (this.maxAgeSeconds * 1000) < time) {
                    it.remove();
                }
            }
        }
        this.messages.add(logMessage);
        fireTableDataChanged();
    }

    public void setMaxAgeSeconds(int i) {
        this.maxAgeSeconds = i;
    }

    public void setPaused(boolean z) {
        this.paused = z;
    }
}
