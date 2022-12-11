package org.fourthline.cling.support.contentdirectory.p060ui;

import javax.swing.JTree;
import javax.swing.event.TreeWillExpandListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import me.tvspark.outline;
import org.fourthline.cling.controlpoint.ActionCallback;
import org.fourthline.cling.controlpoint.ControlPoint;
import org.fourthline.cling.model.meta.Service;
import org.fourthline.cling.support.contentdirectory.callback.Browse;
import org.fourthline.cling.support.model.container.Container;

/* renamed from: org.fourthline.cling.support.contentdirectory.ui.ContentTree */
/* loaded from: classes5.dex */
public abstract class ContentTree extends JTree implements ContentBrowseActionCallbackCreator {
    public Container rootContainer;
    public DefaultMutableTreeNode rootNode;

    /* renamed from: org.fourthline.cling.support.contentdirectory.ui.ContentTree$3 */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class C30893 {

        /* renamed from: $SwitchMap$org$fourthline$cling$support$contentdirectory$callback$Browse$Status */
        public static final /* synthetic */ int[] f4632x9cfa5fa7;

        static {
            int[] iArr = new int[Browse.Status.values().length];
            f4632x9cfa5fa7 = iArr;
            try {
                Browse.Status status = Browse.Status.LOADING;
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = f4632x9cfa5fa7;
                Browse.Status status2 = Browse.Status.NO_CONTENT;
                iArr2[0] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public ContentTree() {
    }

    public ContentTree(ControlPoint controlPoint, Service service) {
        init(controlPoint, service);
    }

    public DefaultTreeCellRenderer createContainerTreeCellRenderer() {
        return new ContentTreeCellRenderer();
    }

    public TreeWillExpandListener createContainerTreeExpandListener(ControlPoint controlPoint, Service service, DefaultTreeModel defaultTreeModel) {
        return new ContentTreeExpandListener(controlPoint, service, defaultTreeModel, this);
    }

    @Override // org.fourthline.cling.support.contentdirectory.p060ui.ContentBrowseActionCallbackCreator
    public ActionCallback createContentBrowseActionCallback(Service service, DefaultTreeModel defaultTreeModel, DefaultMutableTreeNode defaultMutableTreeNode) {
        return new ContentBrowseActionCallback(service, defaultTreeModel, defaultMutableTreeNode) { // from class: org.fourthline.cling.support.contentdirectory.ui.ContentTree.2
            @Override // org.fourthline.cling.support.contentdirectory.p060ui.ContentBrowseActionCallback
            public void failureUI(String str) {
                ContentTree.this.failure(str);
            }

            @Override // org.fourthline.cling.support.contentdirectory.p060ui.ContentBrowseActionCallback
            public void updateStatusUI(Browse.Status status, DefaultMutableTreeNode defaultMutableTreeNode2, DefaultTreeModel defaultTreeModel2) {
                ContentTree.this.updateStatus(status, defaultMutableTreeNode2, defaultTreeModel2);
            }
        };
    }

    public Container createRootContainer(Service service) {
        Container container = new Container();
        container.setId("0");
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Content Directory on ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(service.getDevice().getDisplayString());
        container.setTitle(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        return container;
    }

    public abstract void failure(String str);

    public Container getRootContainer() {
        return this.rootContainer;
    }

    public DefaultMutableTreeNode getRootNode() {
        return this.rootNode;
    }

    public DefaultMutableTreeNode getSelectedNode() {
        return (DefaultMutableTreeNode) getLastSelectedPathComponent();
    }

    public void init(ControlPoint controlPoint, Service service) {
        this.rootContainer = createRootContainer(service);
        this.rootNode = new DefaultMutableTreeNode(this.rootContainer) { // from class: org.fourthline.cling.support.contentdirectory.ui.ContentTree.1
            public boolean isLeaf() {
                return false;
            }
        };
        DefaultTreeModel defaultTreeModel = new DefaultTreeModel(this.rootNode);
        setModel(defaultTreeModel);
        getSelectionModel().setSelectionMode(1);
        addTreeWillExpandListener(createContainerTreeExpandListener(controlPoint, service, defaultTreeModel));
        setCellRenderer(createContainerTreeCellRenderer());
        controlPoint.execute(createContentBrowseActionCallback(service, defaultTreeModel, getRootNode()));
    }

    public void updateStatus(Browse.Status status, DefaultMutableTreeNode defaultMutableTreeNode, DefaultTreeModel defaultTreeModel) {
        int ordinal = status.ordinal();
        if (ordinal == 0 || ordinal == 1) {
            defaultMutableTreeNode.removeAllChildren();
            defaultTreeModel.insertNodeInto(new DefaultMutableTreeNode(status.getDefaultMessage()), defaultMutableTreeNode, defaultMutableTreeNode.getChildCount() <= 0 ? 0 : defaultMutableTreeNode.getChildCount());
            defaultTreeModel.nodeStructureChanged(defaultMutableTreeNode);
        }
    }
}
