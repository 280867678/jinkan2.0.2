package org.seamless.swing.logging;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.seamless.swing.AbstractController;
import org.seamless.swing.Application;
import org.seamless.swing.Controller;

/* loaded from: classes5.dex */
public abstract class LogController extends AbstractController<JPanel> {
    public final JButton clearButton;
    public final JButton configureButton;
    public final JButton copyButton;
    public final JButton expandButton;
    public final JComboBox expirationComboBox;
    public final LogCategorySelector logCategorySelector;
    public final JTable logTable;
    public final LogTableModel logTableModel;
    public final JButton pauseButton;
    public final JLabel pauseLabel;
    public final JToolBar toolBar;

    /* loaded from: classes5.dex */
    public enum Expiration {
        TEN_SECONDS(10, "10 Seconds"),
        SIXTY_SECONDS(60, "60 Seconds"),
        FIVE_MINUTES(300, "5 Minutes"),
        NEVER(Integer.MAX_VALUE, "Never");
        
        public String label;
        public int seconds;

        Expiration(int i, String str) {
            this.seconds = i;
            this.label = str;
        }

        public String getLabel() {
            return this.label;
        }

        public int getSeconds() {
            return this.seconds;
        }

        @Override // java.lang.Enum
        public String toString() {
            return getLabel();
        }
    }

    public LogController(Controller controller, List<LogCategory> list) {
        this(controller, Expiration.SIXTY_SECONDS, list);
    }

    public LogController(Controller controller, Expiration expiration, List<LogCategory> list) {
        super(new JPanel(new BorderLayout()), controller);
        this.toolBar = new JToolBar();
        this.configureButton = createConfigureButton();
        this.clearButton = createClearButton();
        this.copyButton = createCopyButton();
        this.expandButton = createExpandButton();
        this.pauseButton = createPauseButton();
        this.pauseLabel = new JLabel(" (Active)");
        this.expirationComboBox = new JComboBox(Expiration.values());
        this.logCategorySelector = new LogCategorySelector(list);
        this.logTableModel = new LogTableModel(expiration.getSeconds());
        JTable jTable = new JTable(this.logTableModel);
        this.logTable = jTable;
        jTable.setDefaultRenderer(LogMessage.class, new LogTableCellRenderer() { // from class: org.seamless.swing.logging.LogController.1
            @Override // org.seamless.swing.logging.LogTableCellRenderer
            public ImageIcon getDebugIcon() {
                return LogController.this.getDebugIcon();
            }

            @Override // org.seamless.swing.logging.LogTableCellRenderer
            public ImageIcon getInfoIcon() {
                return LogController.this.getInfoIcon();
            }

            @Override // org.seamless.swing.logging.LogTableCellRenderer
            public ImageIcon getTraceIcon() {
                return LogController.this.getTraceIcon();
            }

            @Override // org.seamless.swing.logging.LogTableCellRenderer
            public ImageIcon getWarnErrorIcon() {
                return LogController.this.getWarnErrorIcon();
            }
        });
        this.logTable.setCellSelectionEnabled(false);
        this.logTable.setRowSelectionAllowed(true);
        this.logTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() { // from class: org.seamless.swing.logging.LogController.2
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                if (!listSelectionEvent.getValueIsAdjusting() && listSelectionEvent.getSource() == LogController.this.logTable.getSelectionModel()) {
                    int[] selectedRows = LogController.this.logTable.getSelectedRows();
                    if (selectedRows == null || selectedRows.length == 0) {
                        LogController.this.copyButton.setEnabled(false);
                    } else if (selectedRows.length == 1) {
                        LogController.this.copyButton.setEnabled(true);
                        if (((LogMessage) LogController.this.logTableModel.getValueAt(selectedRows[0], 0)).getMessage().length() > LogController.this.getExpandMessageCharacterLimit()) {
                            LogController.this.expandButton.setEnabled(true);
                            return;
                        }
                    } else {
                        LogController.this.copyButton.setEnabled(true);
                    }
                    LogController.this.expandButton.setEnabled(false);
                }
            }
        });
        adjustTableUI();
        initializeToolBar(expiration);
        getView().setPreferredSize(new Dimension(250, 100));
        getView().setMinimumSize(new Dimension(250, 50));
        getView().add(new JScrollPane(this.logTable), "Center");
        getView().add(this.toolBar, "South");
    }

    public void adjustTableUI() {
        this.logTable.setFocusable(false);
        this.logTable.setRowHeight(18);
        this.logTable.getTableHeader().setReorderingAllowed(false);
        this.logTable.setBorder(BorderFactory.createEmptyBorder());
        this.logTable.getColumnModel().getColumn(0).setMinWidth(30);
        this.logTable.getColumnModel().getColumn(0).setMaxWidth(30);
        this.logTable.getColumnModel().getColumn(0).setResizable(false);
        this.logTable.getColumnModel().getColumn(1).setMinWidth(90);
        this.logTable.getColumnModel().getColumn(1).setMaxWidth(90);
        this.logTable.getColumnModel().getColumn(1).setResizable(false);
        this.logTable.getColumnModel().getColumn(2).setMinWidth(100);
        this.logTable.getColumnModel().getColumn(2).setMaxWidth(250);
        this.logTable.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.logTable.getColumnModel().getColumn(3).setMaxWidth(400);
        this.logTable.getColumnModel().getColumn(4).setPreferredWidth(600);
    }

    public JButton createClearButton() {
        return new JButton("Clear Log", Application.createImageIcon(LogController.class, "img/removetext.png"));
    }

    public JButton createConfigureButton() {
        return new JButton("Options...", Application.createImageIcon(LogController.class, "img/configure.png"));
    }

    public JButton createCopyButton() {
        return new JButton("Copy", Application.createImageIcon(LogController.class, "img/copyclipboard.png"));
    }

    public JButton createExpandButton() {
        return new JButton("Expand", Application.createImageIcon(LogController.class, "img/viewtext.png"));
    }

    public JButton createPauseButton() {
        return new JButton("Pause/Continue Log", Application.createImageIcon(LogController.class, "img/pause.png"));
    }

    public abstract void expand(LogMessage logMessage);

    public ImageIcon getDebugIcon() {
        return Application.createImageIcon(LogController.class, "img/debug.png");
    }

    public int getExpandMessageCharacterLimit() {
        return 100;
    }

    public ImageIcon getInfoIcon() {
        return Application.createImageIcon(LogController.class, "img/info.png");
    }

    public LogTableModel getLogTableModel() {
        return this.logTableModel;
    }

    public abstract Frame getParentWindow();

    public List<LogMessage> getSelectedMessages() {
        ArrayList arrayList = new ArrayList();
        for (int i : this.logTable.getSelectedRows()) {
            arrayList.add((LogMessage) this.logTableModel.getValueAt(i, 0));
        }
        return arrayList;
    }

    public ImageIcon getTraceIcon() {
        return Application.createImageIcon(LogController.class, "img/trace.png");
    }

    public ImageIcon getWarnErrorIcon() {
        return Application.createImageIcon(LogController.class, "img/warn.png");
    }

    public void initializeToolBar(Expiration expiration) {
        this.configureButton.setFocusable(false);
        this.configureButton.addActionListener(new ActionListener() { // from class: org.seamless.swing.logging.LogController.4
            public void actionPerformed(ActionEvent actionEvent) {
                Application.center(LogController.this.logCategorySelector, LogController.this.getParentWindow());
                LogController.this.logCategorySelector.setVisible(!LogController.this.logCategorySelector.isVisible());
            }
        });
        this.clearButton.setFocusable(false);
        this.clearButton.addActionListener(new ActionListener() { // from class: org.seamless.swing.logging.LogController.5
            public void actionPerformed(ActionEvent actionEvent) {
                LogController.this.logTableModel.clearMessages();
            }
        });
        this.copyButton.setFocusable(false);
        this.copyButton.setEnabled(false);
        this.copyButton.addActionListener(new ActionListener() { // from class: org.seamless.swing.logging.LogController.6
            public void actionPerformed(ActionEvent actionEvent) {
                StringBuilder sb = new StringBuilder();
                for (LogMessage logMessage : LogController.this.getSelectedMessages()) {
                    sb.append(logMessage.toString());
                    sb.append("\n");
                }
                Application.copyToClipboard(sb.toString());
            }
        });
        this.expandButton.setFocusable(false);
        this.expandButton.setEnabled(false);
        this.expandButton.addActionListener(new ActionListener() { // from class: org.seamless.swing.logging.LogController.7
            public void actionPerformed(ActionEvent actionEvent) {
                List<LogMessage> selectedMessages = LogController.this.getSelectedMessages();
                if (selectedMessages.size() != 1) {
                    return;
                }
                LogController.this.expand(selectedMessages.get(0));
            }
        });
        this.pauseButton.setFocusable(false);
        this.pauseButton.addActionListener(new ActionListener() { // from class: org.seamless.swing.logging.LogController.8
            public void actionPerformed(ActionEvent actionEvent) {
                JLabel jLabel;
                String str;
                LogController.this.logTableModel.setPaused(!LogController.this.logTableModel.isPaused());
                if (LogController.this.logTableModel.isPaused()) {
                    jLabel = LogController.this.pauseLabel;
                    str = " (Paused)";
                } else {
                    jLabel = LogController.this.pauseLabel;
                    str = " (Active)";
                }
                jLabel.setText(str);
            }
        });
        this.expirationComboBox.setSelectedItem(expiration);
        this.expirationComboBox.setMaximumSize(new Dimension(100, 32));
        this.expirationComboBox.addActionListener(new ActionListener() { // from class: org.seamless.swing.logging.LogController.9
            public void actionPerformed(ActionEvent actionEvent) {
                LogController.this.logTableModel.setMaxAgeSeconds(((Expiration) ((JComboBox) actionEvent.getSource()).getSelectedItem()).getSeconds());
            }
        });
        this.toolBar.setFloatable(false);
        this.toolBar.add(this.copyButton);
        this.toolBar.add(this.expandButton);
        this.toolBar.add(Box.createHorizontalGlue());
        this.toolBar.add(this.configureButton);
        this.toolBar.add(this.clearButton);
        this.toolBar.add(this.pauseButton);
        this.toolBar.add(this.pauseLabel);
        this.toolBar.add(Box.createHorizontalGlue());
        this.toolBar.add(new JLabel("Clear after:"));
        this.toolBar.add(this.expirationComboBox);
    }

    public void pushMessage(final LogMessage logMessage) {
        SwingUtilities.invokeLater(new Runnable() { // from class: org.seamless.swing.logging.LogController.3
            @Override // java.lang.Runnable
            public void run() {
                LogController.this.logTableModel.pushMessage(logMessage);
                if (!LogController.this.logTableModel.isPaused()) {
                    LogController.this.logTable.scrollRectToVisible(LogController.this.logTable.getCellRect(LogController.this.logTableModel.getRowCount() - 1, 0, true));
                }
            }
        });
    }
}
