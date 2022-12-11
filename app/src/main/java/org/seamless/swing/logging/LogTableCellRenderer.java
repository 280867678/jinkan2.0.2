package org.seamless.swing.logging;

import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes5.dex */
public abstract class LogTableCellRenderer extends DefaultTableCellRenderer {
    public SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss:SSS");

    public abstract ImageIcon getDebugIcon();

    public abstract ImageIcon getInfoIcon();

    public Component getTableCellRendererComponent(JTable jTable, Object obj, boolean z, boolean z2, int i, int i2) {
        LogMessage logMessage = (LogMessage) obj;
        if (i2 == 0) {
            return (logMessage.getLevel().equals(Level.SEVERE) || logMessage.getLevel().equals(Level.WARNING)) ? new JLabel(getWarnErrorIcon()) : logMessage.getLevel().equals(Level.FINE) ? new JLabel(getDebugIcon()) : (logMessage.getLevel().equals(Level.FINER) || logMessage.getLevel().equals(Level.FINEST)) ? new JLabel(getTraceIcon()) : new JLabel(getInfoIcon());
        } else if (i2 != 1) {
            return i2 != 2 ? i2 != 3 ? super.getTableCellRendererComponent(jTable, logMessage.getMessage().replaceAll("\n", "<NL>").replaceAll(StringUtils.f4552CR, "<CR>"), z, z2, i, i2) : super.getTableCellRendererComponent(jTable, logMessage.getSource(), z, z2, i, i2) : super.getTableCellRendererComponent(jTable, logMessage.getThread(), z, z2, i, i2);
        } else {
            return super.getTableCellRendererComponent(jTable, this.dateFormat.format(new Date(logMessage.getCreatedOn().longValue())), z, z2, i, i2);
        }
    }

    public abstract ImageIcon getTraceIcon();

    public abstract ImageIcon getWarnErrorIcon();
}
