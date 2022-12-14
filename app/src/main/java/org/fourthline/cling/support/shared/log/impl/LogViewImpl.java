package org.fourthline.cling.support.shared.log.impl;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Singleton;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.fourthline.cling.support.shared.CenterWindow;
import org.fourthline.cling.support.shared.log.LogView;
import org.seamless.swing.Application;
import org.seamless.swing.logging.LogCategorySelector;
import org.seamless.swing.logging.LogController;
import org.seamless.swing.logging.LogMessage;
import org.seamless.swing.logging.LogTableCellRenderer;
import org.seamless.swing.logging.LogTableModel;

@Singleton
/* loaded from: classes5.dex */
public class LogViewImpl extends JPanel implements LogView {
    @Inject
    public Event<CenterWindow> centerWindowEvent;
    @Inject
    public LogView.LogCategories logCategories;
    public LogCategorySelector logCategorySelector;
    public JTable logTable;
    public LogTableModel logTableModel;
    public LogView.Presenter presenter;
    public final JToolBar toolBar = new JToolBar();
    public final JButton configureButton = new JButton("Options...", Application.createImageIcon(LogController.class, "img/configure.png"));
    public final JButton clearButton = new JButton("Clear Log", Application.createImageIcon(LogController.class, "img/removetext.png"));
    public final JButton copyButton = new JButton("Copy", Application.createImageIcon(LogController.class, "img/copyclipboard.png"));
    public final JButton expandButton = new JButton("Expand", Application.createImageIcon(LogController.class, "img/viewtext.png"));
    public final JButton pauseButton = new JButton("Pause/Continue Log", Application.createImageIcon(LogController.class, "img/pause.png"));
    public final JLabel pauseLabel = new JLabel(" (Active)");
    public final JComboBox expirationComboBox = new JComboBox(LogController.Expiration.values());

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
        this.logTable.getColumnModel().getColumn(2).setMinWidth(110);
        this.logTable.getColumnModel().getColumn(2).setMaxWidth(250);
        this.logTable.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.logTable.getColumnModel().getColumn(3).setMaxWidth(400);
        this.logTable.getColumnModel().getColumn(4).setPreferredWidth(600);
    }

    @Override // org.fourthline.cling.support.shared.View
    public Component asUIComponent() {
        return this;
    }

    @Override // org.fourthline.cling.support.shared.log.LogView
    public void dispose() {
        this.logCategorySelector.dispose();
    }

    public ImageIcon getDebugIcon() {
        return Application.createImageIcon(LogController.class, "img/debug.png");
    }

    public LogController.Expiration getDefaultExpiration() {
        return LogController.Expiration.SIXTY_SECONDS;
    }

    public int getExpandMessageCharacterLimit() {
        return 100;
    }

    public ImageIcon getInfoIcon() {
        return Application.createImageIcon(LogController.class, "img/info.png");
    }

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

    @PostConstruct
    public void init() {
        setLayout(new BorderLayout());
        LogController.Expiration defaultExpiration = getDefaultExpiration();
        this.logCategorySelector = new LogCategorySelector(this.logCategories);
        this.logTableModel = new LogTableModel(defaultExpiration.getSeconds());
        JTable jTable = new JTable(this.logTableModel);
        this.logTable = jTable;
        jTable.setDefaultRenderer(LogMessage.class, new LogTableCellRenderer() { // from class: org.fourthline.cling.support.shared.log.impl.LogViewImpl.1
            @Override // org.seamless.swing.logging.LogTableCellRenderer
            public ImageIcon getDebugIcon() {
                return LogViewImpl.this.getDebugIcon();
            }

            @Override // org.seamless.swing.logging.LogTableCellRenderer
            public ImageIcon getInfoIcon() {
                return LogViewImpl.this.getInfoIcon();
            }

            @Override // org.seamless.swing.logging.LogTableCellRenderer
            public ImageIcon getTraceIcon() {
                return LogViewImpl.this.getTraceIcon();
            }

            @Override // org.seamless.swing.logging.LogTableCellRenderer
            public ImageIcon getWarnErrorIcon() {
                return LogViewImpl.this.getWarnErrorIcon();
            }
        });
        this.logTable.setCellSelectionEnabled(false);
        this.logTable.setRowSelectionAllowed(true);
        this.logTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() { // from class: org.fourthline.cling.support.shared.log.impl.LogViewImpl.2
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                if (!listSelectionEvent.getValueIsAdjusting() && listSelectionEvent.getSource() == LogViewImpl.this.logTable.getSelectionModel()) {
                    int[] selectedRows = LogViewImpl.this.logTable.getSelectedRows();
                    if (selectedRows == null || selectedRows.length == 0) {
                        LogViewImpl.this.copyButton.setEnabled(false);
                    } else if (selectedRows.length == 1) {
                        LogViewImpl.this.copyButton.setEnabled(true);
                        if (((LogMessage) LogViewImpl.this.logTableModel.getValueAt(selectedRows[0], 0)).getMessage().length() > LogViewImpl.this.getExpandMessageCharacterLimit()) {
                            LogViewImpl.this.expandButton.setEnabled(true);
                            return;
                        }
                    } else {
                        LogViewImpl.this.copyButton.setEnabled(true);
                    }
                    LogViewImpl.this.expandButton.setEnabled(false);
                }
            }
        });
        adjustTableUI();
        initializeToolBar(defaultExpiration);
        setPreferredSize(new Dimension(250, 100));
        setMinimumSize(new Dimension(250, 50));
        add(new JScrollPane(this.logTable), "Center");
        add(this.toolBar, "South");
    }

    public void initializeToolBar(LogController.Expiration expiration) {
        this.configureButton.setFocusable(false);
        this.configureButton.addActionListener(new ActionListener() { // from class: org.fourthline.cling.support.shared.log.impl.LogViewImpl.3
            public void actionPerformed(ActionEvent actionEvent) {
                LogViewImpl logViewImpl = LogViewImpl.this;
                logViewImpl.centerWindowEvent.fire(new CenterWindow(logViewImpl.logCategorySelector));
                LogCategorySelector logCategorySelector = LogViewImpl.this.logCategorySelector;
                logCategorySelector.setVisible(!logCategorySelector.isVisible());
            }
        });
        this.clearButton.setFocusable(false);
        this.clearButton.addActionListener(new ActionListener() { // from class: org.fourthline.cling.support.shared.log.impl.LogViewImpl.4
            public void actionPerformed(ActionEvent actionEvent) {
                LogViewImpl.this.logTableModel.clearMessages();
            }
        });
        this.copyButton.setFocusable(false);
        this.copyButton.setEnabled(false);
        this.copyButton.addActionListener(new ActionListener() { // from class: org.fourthline.cling.support.shared.log.impl.LogViewImpl.5
            public void actionPerformed(ActionEvent actionEvent) {
                StringBuilder sb = new StringBuilder();
                for (LogMessage logMessage : LogViewImpl.this.getSelectedMessages()) {
                    sb.append(logMessage.toString());
                    sb.append("\n");
                }
                Application.copyToClipboard(sb.toString());
            }
        });
        this.expandButton.setFocusable(false);
        this.expandButton.setEnabled(false);
        this.expandButton.addActionListener(new ActionListener() { // from class: org.fourthline.cling.support.shared.log.impl.LogViewImpl.6
            public void actionPerformed(ActionEvent actionEvent) {
                List<LogMessage> selectedMessages = LogViewImpl.this.getSelectedMessages();
                if (selectedMessages.size() != 1) {
                    return;
                }
                LogViewImpl.this.presenter.onExpand(selectedMessages.get(0));
            }
        });
        this.pauseButton.setFocusable(false);
        this.pauseButton.addActionListener(new ActionListener() { // from class: org.fourthline.cling.support.shared.log.impl.LogViewImpl.7
            public void actionPerformed(ActionEvent actionEvent) {
                JLabel jLabel;
                String str;
                LogTableModel logTableModel = LogViewImpl.this.logTableModel;
                logTableModel.setPaused(!logTableModel.isPaused());
                if (LogViewImpl.this.logTableModel.isPaused()) {
                    jLabel = LogViewImpl.this.pauseLabel;
                    str = " (Paused)";
                } else {
                    jLabel = LogViewImpl.this.pauseLabel;
                    str = " (Active)";
                }
                jLabel.setText(str);
            }
        });
        this.expirationComboBox.setSelectedItem(expiration);
        this.expirationComboBox.setMaximumSize(new Dimension(100, 32));
        this.expirationComboBox.addActionListener(new ActionListener() { // from class: org.fourthline.cling.support.shared.log.impl.LogViewImpl.8
            public void actionPerformed(ActionEvent actionEvent) {
                LogViewImpl.this.logTableModel.setMaxAgeSeconds(((LogController.Expiration) ((JComboBox) actionEvent.getSource()).getSelectedItem()).getSeconds());
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

    @Override // org.fourthline.cling.support.shared.log.LogView
    public void pushMessage(LogMessage logMessage) {
        this.logTableModel.pushMessage(logMessage);
        if (!this.logTableModel.isPaused()) {
            JTable jTable = this.logTable;
            jTable.scrollRectToVisible(jTable.getCellRect(this.logTableModel.getRowCount() - 1, 0, true));
        }
    }

    @Override // org.fourthline.cling.support.shared.View
    public void setPresenter(LogView.Presenter presenter) {
        this.presenter = presenter;
    }
}
