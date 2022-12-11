package org.seamless.swing;

import com.tencent.bugly.beta.tinker.TinkerReport;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import me.tvspark.outline;

/* loaded from: classes5.dex */
public class Application {
    public static Window center(Window window) {
        Dimension size = window.getSize();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int i = (screenSize.width - size.width) / 2;
        int i2 = (screenSize.height - size.height) / 2;
        if (i < 0) {
            i = 0;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        window.setLocation(i, i2);
        return window;
    }

    public static Window center(Window window, Window window2) {
        window.setLocation((int) (((window2.getSize().getWidth() / 2.0d) + window2.getX()) - (window.getSize().getWidth() / 2.0d)), (int) (((window2.getSize().getHeight() / 2.0d) + window2.getY()) - (window.getSize().getHeight() / 2.0d)));
        return window;
    }

    public static void copyToClipboard(String str) {
        Clipboard systemClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection stringSelection = new StringSelection(str);
        systemClipboard.setContents(stringSelection, stringSelection);
    }

    public static ImageIcon createImageIcon(Class cls, String str) {
        return createImageIcon(cls, str, null);
    }

    public static ImageIcon createImageIcon(Class cls, String str, String str2) {
        URL resource = cls.getResource(str);
        if (resource != null) {
            return new ImageIcon(resource, str2);
        }
        throw new RuntimeException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Couldn't find image icon on path: ", str));
    }

    public static void decreaseFontSize(JComponent jComponent) {
        jComponent.setFont(new Font(jComponent.getFont().getFontName(), jComponent.getFont().getStyle(), jComponent.getFont().getSize() - 2));
    }

    public static void increaseFontSize(JComponent jComponent) {
        jComponent.setFont(new Font(jComponent.getFont().getFontName(), jComponent.getFont().getStyle(), jComponent.getFont().getSize() + 2));
    }

    public static Window maximize(Window window) {
        window.getSize();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        window.setBounds(0, 0, screenSize.width, screenSize.height);
        return window;
    }

    public static void showError(Component component, Throwable th) {
        JTextArea jTextArea = new JTextArea();
        jTextArea.setFont(new Font("Sans-Serif", 0, 10));
        jTextArea.setEditable(false);
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        jTextArea.setText(stringWriter.toString());
        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        jScrollPane.setPreferredSize(new Dimension((int) TinkerReport.KEY_LOADED_PACKAGE_CHECK_SIGNATURE, 150));
        JOptionPane.showMessageDialog(component, jScrollPane, "An Error Has Occurred", 0);
    }

    public static void showInfo(Component component, String... strArr) {
        JTextArea jTextArea = new JTextArea();
        jTextArea.setFont(new Font("Sans-Serif", 0, 10));
        jTextArea.setEditable(false);
        for (String str : strArr) {
            jTextArea.append(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "\n"));
        }
        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        jScrollPane.setPreferredSize(new Dimension((int) TinkerReport.KEY_LOADED_PACKAGE_CHECK_SIGNATURE, 150));
        JOptionPane.showMessageDialog(component, jScrollPane, "Info", 1);
    }

    public static void showWarning(Component component, String... strArr) {
        JTextArea jTextArea = new JTextArea();
        jTextArea.setFont(new Font("Sans-Serif", 0, 10));
        jTextArea.setEditable(false);
        for (String str : strArr) {
            jTextArea.append(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "\n"));
        }
        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        jScrollPane.setPreferredSize(new Dimension((int) TinkerReport.KEY_LOADED_PACKAGE_CHECK_SIGNATURE, 150));
        JOptionPane.showMessageDialog(component, jScrollPane, "Warning", 0);
    }
}
