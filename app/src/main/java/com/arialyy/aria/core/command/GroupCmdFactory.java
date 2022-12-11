package com.arialyy.aria.core.command;

import com.arialyy.aria.core.download.AbsGroupTaskWrapper;

/* loaded from: classes3.dex */
public class GroupCmdFactory {
    public static volatile GroupCmdFactory INSTANCE = null;
    public static final int SUB_TASK_START = 161;
    public static final int SUB_TASK_STOP = 162;

    public static GroupCmdFactory getInstance() {
        if (INSTANCE == null) {
            synchronized (GroupCmdFactory.class) {
                INSTANCE = new GroupCmdFactory();
            }
        }
        return INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AbsGroupCmd createCmd(AbsGroupTaskWrapper absGroupTaskWrapper, int i, String str) {
        AbsGroupCmd dGSubStartCmd;
        AbsGroupCmd absGroupCmd;
        if (i == 161) {
            dGSubStartCmd = new DGSubStartCmd(absGroupTaskWrapper);
        } else if (i != 162) {
            absGroupCmd = null;
            if (absGroupCmd != null) {
                absGroupCmd.childUrl = str;
            }
            return absGroupCmd;
        } else {
            dGSubStartCmd = new DGSubStopCmd(absGroupTaskWrapper);
        }
        absGroupCmd = dGSubStartCmd;
        if (absGroupCmd != null) {
        }
        return absGroupCmd;
    }
}
