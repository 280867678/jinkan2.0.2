package org.seamless.swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JTabbedPane;
import javax.swing.JViewport;
import javax.swing.SwingUtilities;
import javax.swing.event.EventListenerList;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import javax.swing.plaf.metal.MetalTabbedPaneUI;
import javax.swing.text.View;

/* loaded from: classes5.dex */
public class ClosableTabbedPane extends JTabbedPane implements MouseListener, MouseMotionListener {
    public EventListenerList listenerList = null;
    public JViewport headerViewport = null;
    public Icon normalCloseIcon = null;
    public Icon hooverCloseIcon = null;
    public Icon pressedCloseIcon = null;

    /* loaded from: classes5.dex */
    public class CloseTabIcon implements Icon {
        public Icon fileIcon;
        public int x_pos;
        public int y_pos;
        public boolean mouseover = false;
        public boolean mousepressed = false;
        public int width = 16;
        public int height = 16;

        public CloseTabIcon(Icon icon) {
            this.fileIcon = icon;
        }

        public Rectangle getBounds() {
            return new Rectangle(this.x_pos, this.y_pos, this.width, this.height);
        }

        public int getIconHeight() {
            return this.height;
        }

        public int getIconWidth() {
            int i = this.width;
            Icon icon = this.fileIcon;
            return i + (icon != null ? icon.getIconWidth() : 0);
        }

        /* JADX WARN: Removed duplicated region for block: B:39:0x00d9 A[ORIG_RETURN, RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0024  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void paintIcon(Component component, Graphics graphics, int i, int i2) {
            boolean z;
            Icon icon;
            Object clientProperty;
            try {
                JTabbedPane jTabbedPane = (JTabbedPane) component;
                clientProperty = jTabbedPane.getComponentAt(jTabbedPane.getUI().tabForCoordinate(jTabbedPane, i, i2)).getClientProperty("isClosable");
            } catch (Exception unused) {
            }
            if (clientProperty != null) {
                z = ((Boolean) clientProperty).booleanValue();
                if (z) {
                    return;
                }
                this.x_pos = i;
                this.y_pos = i2;
                int i3 = i2 + 1;
                if (ClosableTabbedPane.this.normalCloseIcon != null && !this.mouseover) {
                    icon = ClosableTabbedPane.this.normalCloseIcon;
                } else if (ClosableTabbedPane.this.hooverCloseIcon != null && this.mouseover && !this.mousepressed) {
                    icon = ClosableTabbedPane.this.hooverCloseIcon;
                } else if (ClosableTabbedPane.this.pressedCloseIcon == null || !this.mousepressed) {
                    i3++;
                    Color color = graphics.getColor();
                    if (this.mousepressed && this.mouseover) {
                        graphics.setColor(Color.WHITE);
                        graphics.fillRect(i + 1, i3, 12, 13);
                    }
                    graphics.setColor(Color.black);
                    int i4 = i + 1;
                    int i5 = i + 12;
                    graphics.drawLine(i4, i3, i5, i3);
                    int i6 = i3 + 13;
                    graphics.drawLine(i4, i6, i5, i6);
                    int i7 = i3 + 1;
                    int i8 = i3 + 12;
                    graphics.drawLine(i, i7, i, i8);
                    int i9 = i + 13;
                    graphics.drawLine(i9, i7, i9, i8);
                    int i10 = i + 3;
                    int i11 = i3 + 3;
                    int i12 = i + 10;
                    int i13 = i3 + 10;
                    graphics.drawLine(i10, i11, i12, i13);
                    if (this.mouseover) {
                        graphics.setColor(Color.GRAY);
                    }
                    int i14 = i3 + 4;
                    int i15 = i + 9;
                    graphics.drawLine(i10, i14, i15, i13);
                    int i16 = i + 4;
                    int i17 = i3 + 9;
                    graphics.drawLine(i16, i11, i12, i17);
                    graphics.drawLine(i12, i11, i10, i13);
                    graphics.drawLine(i12, i14, i16, i13);
                    graphics.drawLine(i15, i11, i10, i17);
                    graphics.setColor(color);
                    icon = this.fileIcon;
                    if (icon == null) {
                        return;
                    }
                    i += this.width;
                } else {
                    icon = ClosableTabbedPane.this.pressedCloseIcon;
                }
                icon.paintIcon(component, graphics, i, i3);
                return;
            }
            z = true;
            if (z) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class CloseableMetalTabbedPaneUI extends MetalTabbedPaneUI {
        public int horizontalTextPosition;

        public CloseableMetalTabbedPaneUI() {
            this.horizontalTextPosition = 2;
        }

        public CloseableMetalTabbedPaneUI(int i) {
            this.horizontalTextPosition = 2;
            this.horizontalTextPosition = i;
        }

        public void layoutLabel(int i, FontMetrics fontMetrics, int i2, String str, Icon icon, Rectangle rectangle, Rectangle rectangle2, Rectangle rectangle3, boolean z) {
            rectangle2.y = 0;
            rectangle2.x = 0;
            rectangle3.y = 0;
            rectangle3.x = 0;
            View textViewForTab = getTextViewForTab(i2);
            if (textViewForTab != null) {
                this.tabPane.putClientProperty("html", textViewForTab);
            }
            SwingUtilities.layoutCompoundLabel(this.tabPane, fontMetrics, str, icon, 0, 0, 0, this.horizontalTextPosition, rectangle, rectangle2, rectangle3, this.textIconGap + 2);
            this.tabPane.putClientProperty("html", (Object) null);
            int tabLabelShiftX = getTabLabelShiftX(i, i2, z);
            int tabLabelShiftY = getTabLabelShiftY(i, i2, z);
            rectangle2.x += tabLabelShiftX;
            rectangle2.y += tabLabelShiftY;
            rectangle3.x += tabLabelShiftX;
            rectangle3.y += tabLabelShiftY;
        }
    }

    /* loaded from: classes5.dex */
    public class CloseableTabbedPaneUI extends BasicTabbedPaneUI {
        public int horizontalTextPosition;

        public CloseableTabbedPaneUI() {
            this.horizontalTextPosition = 2;
        }

        public CloseableTabbedPaneUI(int i) {
            this.horizontalTextPosition = 2;
            this.horizontalTextPosition = i;
        }

        public void layoutLabel(int i, FontMetrics fontMetrics, int i2, String str, Icon icon, Rectangle rectangle, Rectangle rectangle2, Rectangle rectangle3, boolean z) {
            rectangle2.y = 0;
            rectangle2.x = 0;
            rectangle3.y = 0;
            rectangle3.x = 0;
            View textViewForTab = getTextViewForTab(i2);
            if (textViewForTab != null) {
                this.tabPane.putClientProperty("html", textViewForTab);
            }
            SwingUtilities.layoutCompoundLabel(this.tabPane, fontMetrics, str, icon, 0, 0, 0, this.horizontalTextPosition, rectangle, rectangle2, rectangle3, this.textIconGap + 2);
            this.tabPane.putClientProperty("html", (Object) null);
            int tabLabelShiftX = getTabLabelShiftX(i, i2, z);
            int tabLabelShiftY = getTabLabelShiftY(i, i2, z);
            rectangle2.x += tabLabelShiftX;
            rectangle2.y += tabLabelShiftY;
            rectangle3.x += tabLabelShiftX;
            rectangle3.y += tabLabelShiftY;
        }
    }

    public ClosableTabbedPane() {
        init(2);
    }

    public ClosableTabbedPane(int i) {
        init(i);
    }

    private void init(int i) {
        this.listenerList = new EventListenerList();
        addMouseListener(this);
        addMouseMotionListener(this);
        setUI(getUI() instanceof MetalTabbedPaneUI ? new CloseableMetalTabbedPaneUI(i) : new CloseableTabbedPaneUI(i));
    }

    private void processMouseEvents(MouseEvent mouseEvent) {
        CloseTabIcon closeTabIcon;
        int tabForCoordinate = getUI().tabForCoordinate(this, mouseEvent.getX(), mouseEvent.getY());
        if (tabForCoordinate >= 0 && (closeTabIcon = (CloseTabIcon) getIconAt(tabForCoordinate)) != null) {
            Rectangle bounds = closeTabIcon.getBounds();
            JViewport jViewport = this.headerViewport;
            Point point = jViewport == null ? new Point() : jViewport.getViewPosition();
            Rectangle rectangle = new Rectangle(bounds.x - point.x, bounds.y - point.y, bounds.width, bounds.height);
            boolean z = true;
            if (mouseEvent.getID() != 501) {
                if (mouseEvent.getID() != 503 && mouseEvent.getID() != 506 && mouseEvent.getID() != 500) {
                    return;
                }
                point.x += mouseEvent.getX();
                point.y += mouseEvent.getY();
                if (!bounds.contains(point)) {
                    closeTabIcon.mouseover = false;
                } else if (mouseEvent.getID() == 500) {
                    int selectedIndex = getSelectedIndex();
                    if (fireCloseTab(selectedIndex)) {
                        if (selectedIndex > 0) {
                            Rectangle tabBounds = getUI().getTabBounds(this, selectedIndex - 1);
                            dispatchEvent(new MouseEvent((Component) mouseEvent.getSource(), mouseEvent.getID() + 1, System.currentTimeMillis(), mouseEvent.getModifiers(), tabBounds.x, tabBounds.y, mouseEvent.getClickCount(), mouseEvent.isPopupTrigger(), mouseEvent.getButton()));
                        }
                        remove(selectedIndex);
                    } else {
                        closeTabIcon.mouseover = false;
                        closeTabIcon.mousepressed = false;
                        repaint(rectangle);
                    }
                } else {
                    closeTabIcon.mouseover = true;
                    if (mouseEvent.getModifiers() != 16) {
                        z = false;
                    }
                }
                repaint(rectangle);
            } else if (mouseEvent.getModifiers() != 16) {
                z = false;
            }
            closeTabIcon.mousepressed = z;
            repaint(rectangle);
        }
    }

    public void addCloseableTabbedPaneListener(ClosableTabbedPaneListener closableTabbedPaneListener) {
        this.listenerList.add(ClosableTabbedPaneListener.class, closableTabbedPaneListener);
    }

    public void addTab(String str, Component component) {
        addTab(str, component, null);
    }

    public void addTab(String str, Component component, Icon icon) {
        JViewport[] components;
        boolean z = true;
        try {
            Object clientProperty = ((JComponent) component).getClientProperty("isClosable");
            if (clientProperty != null) {
                z = ((Boolean) clientProperty).booleanValue();
            }
        } catch (Exception unused) {
        }
        super.addTab(str, z ? new CloseTabIcon(icon) : null, component);
        if (this.headerViewport == null) {
            for (JViewport jViewport : getComponents()) {
                if ("TabbedPane.scrollableViewport".equals(jViewport.getName())) {
                    this.headerViewport = jViewport;
                }
            }
        }
    }

    public boolean fireCloseTab(int i) {
        Object[] listenerList;
        for (Object obj : this.listenerList.getListenerList()) {
            if ((obj instanceof ClosableTabbedPaneListener) && !((ClosableTabbedPaneListener) obj).closeTab(i)) {
                return false;
            }
        }
        return true;
    }

    public ClosableTabbedPaneListener[] getCloseableTabbedPaneListener() {
        return (ClosableTabbedPaneListener[]) this.listenerList.getListeners(ClosableTabbedPaneListener.class);
    }

    public void mouseClicked(MouseEvent mouseEvent) {
        processMouseEvents(mouseEvent);
    }

    public void mouseDragged(MouseEvent mouseEvent) {
        processMouseEvents(mouseEvent);
    }

    public void mouseEntered(MouseEvent mouseEvent) {
    }

    public void mouseExited(MouseEvent mouseEvent) {
        for (int i = 0; i < getTabCount(); i++) {
            CloseTabIcon closeTabIcon = (CloseTabIcon) getIconAt(i);
            if (closeTabIcon != null) {
                closeTabIcon.mouseover = false;
            }
        }
        repaint();
    }

    public void mouseMoved(MouseEvent mouseEvent) {
        processMouseEvents(mouseEvent);
    }

    public void mousePressed(MouseEvent mouseEvent) {
        processMouseEvents(mouseEvent);
    }

    public void mouseReleased(MouseEvent mouseEvent) {
    }

    public void removeCloseableTabbedPaneListener(ClosableTabbedPaneListener closableTabbedPaneListener) {
        this.listenerList.remove(ClosableTabbedPaneListener.class, closableTabbedPaneListener);
    }

    public void setCloseIcons(Icon icon, Icon icon2, Icon icon3) {
        this.normalCloseIcon = icon;
        this.hooverCloseIcon = icon2;
        this.pressedCloseIcon = icon3;
    }
}
