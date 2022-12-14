package org.fourthline.cling.support.contentdirectory.p060ui;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import me.tvspark.outline;
import org.fourthline.cling.model.action.ActionException;
import org.fourthline.cling.model.action.ActionInvocation;
import org.fourthline.cling.model.message.UpnpResponse;
import org.fourthline.cling.model.meta.Service;
import org.fourthline.cling.model.types.ErrorCode;
import org.fourthline.cling.support.contentdirectory.callback.Browse;
import org.fourthline.cling.support.model.BrowseFlag;
import org.fourthline.cling.support.model.DIDLContent;
import org.fourthline.cling.support.model.SortCriterion;
import org.fourthline.cling.support.model.container.Container;
import org.fourthline.cling.support.model.item.Item;

/* renamed from: org.fourthline.cling.support.contentdirectory.ui.ContentBrowseActionCallback */
/* loaded from: classes5.dex */
public abstract class ContentBrowseActionCallback extends Browse {
    public static Logger log = Logger.getLogger(ContentBrowseActionCallback.class.getName());
    public final DefaultTreeModel treeModel;
    public final DefaultMutableTreeNode treeNode;

    public ContentBrowseActionCallback(Service service, DefaultTreeModel defaultTreeModel, DefaultMutableTreeNode defaultMutableTreeNode) {
        super(service, ((Container) defaultMutableTreeNode.getUserObject()).getId(), BrowseFlag.DIRECT_CHILDREN, "*", 0L, null, new SortCriterion(true, "dc:title"));
        this.treeModel = defaultTreeModel;
        this.treeNode = defaultMutableTreeNode;
    }

    public ContentBrowseActionCallback(Service service, DefaultTreeModel defaultTreeModel, DefaultMutableTreeNode defaultMutableTreeNode, String str, long j, long j2, SortCriterion... sortCriterionArr) {
        super(service, ((Container) defaultMutableTreeNode.getUserObject()).getId(), BrowseFlag.DIRECT_CHILDREN, str, j, Long.valueOf(j2), sortCriterionArr);
        this.treeModel = defaultTreeModel;
        this.treeNode = defaultMutableTreeNode;
    }

    @Override // org.fourthline.cling.controlpoint.ActionCallback
    public void failure(ActionInvocation actionInvocation, UpnpResponse upnpResponse, final String str) {
        SwingUtilities.invokeLater(new Runnable() { // from class: org.fourthline.cling.support.contentdirectory.ui.ContentBrowseActionCallback.5
            @Override // java.lang.Runnable
            public void run() {
                ContentBrowseActionCallback.this.failureUI(str);
            }
        });
    }

    public abstract void failureUI(String str);

    public DefaultTreeModel getTreeModel() {
        return this.treeModel;
    }

    public DefaultMutableTreeNode getTreeNode() {
        return this.treeNode;
    }

    public void insertChild(MutableTreeNode mutableTreeNode) {
        this.treeModel.insertNodeInto(mutableTreeNode, this.treeNode, this.treeNode.getChildCount() <= 0 ? 0 : this.treeNode.getChildCount());
    }

    @Override // org.fourthline.cling.support.contentdirectory.callback.Browse
    public void received(ActionInvocation actionInvocation, DIDLContent dIDLContent) {
        log.fine("Received browse action DIDL descriptor, creating tree nodes");
        final ArrayList arrayList = new ArrayList();
        try {
            for (Container container : dIDLContent.getContainers()) {
                arrayList.add(new DefaultMutableTreeNode(container) { // from class: org.fourthline.cling.support.contentdirectory.ui.ContentBrowseActionCallback.1
                    public boolean isLeaf() {
                        return false;
                    }
                });
            }
            for (Item item : dIDLContent.getItems()) {
                arrayList.add(new DefaultMutableTreeNode(item) { // from class: org.fourthline.cling.support.contentdirectory.ui.ContentBrowseActionCallback.2
                    public boolean isLeaf() {
                        return true;
                    }
                });
            }
        } catch (Exception e) {
            Logger logger = log;
            logger.fine("Creating DIDL tree nodes failed: " + e);
            actionInvocation.setFailure(new ActionException(ErrorCode.ACTION_FAILED, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Can't create tree child nodes: ", e), e));
            failure(actionInvocation, null);
        }
        SwingUtilities.invokeLater(new Runnable() { // from class: org.fourthline.cling.support.contentdirectory.ui.ContentBrowseActionCallback.3
            @Override // java.lang.Runnable
            public void run() {
                ContentBrowseActionCallback.this.updateTreeModel(arrayList);
            }
        });
    }

    public void removeChildren() {
        this.treeNode.removeAllChildren();
        this.treeModel.nodeStructureChanged(this.treeNode);
    }

    @Override // org.fourthline.cling.support.contentdirectory.callback.Browse
    public void updateStatus(final Browse.Status status) {
        SwingUtilities.invokeLater(new Runnable() { // from class: org.fourthline.cling.support.contentdirectory.ui.ContentBrowseActionCallback.4
            @Override // java.lang.Runnable
            public void run() {
                ContentBrowseActionCallback contentBrowseActionCallback = ContentBrowseActionCallback.this;
                contentBrowseActionCallback.updateStatusUI(status, contentBrowseActionCallback.treeNode, contentBrowseActionCallback.treeModel);
            }
        });
    }

    public abstract void updateStatusUI(Browse.Status status, DefaultMutableTreeNode defaultMutableTreeNode, DefaultTreeModel defaultTreeModel);

    public void updateTreeModel(List<DefaultMutableTreeNode> list) {
        Logger logger = log;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Adding nodes to tree: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(list.size());
        logger.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        removeChildren();
        for (DefaultMutableTreeNode defaultMutableTreeNode : list) {
            insertChild(defaultMutableTreeNode);
        }
    }
}
