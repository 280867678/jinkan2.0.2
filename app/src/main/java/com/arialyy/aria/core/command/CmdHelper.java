package com.arialyy.aria.core.command;

import com.arialyy.aria.core.download.AbsGroupTaskWrapper;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;

/* loaded from: classes3.dex */
public class CmdHelper {
    public static <T extends AbsGroupTaskWrapper> AbsGroupCmd createGroupCmd(T t, int i, String str) {
        return GroupCmdFactory.getInstance().createCmd(t, i, str);
    }

    public static <T extends AbsTaskWrapper> AbsNormalCmd createNormalCmd(T t, int i, int i2) {
        return NormalCmdFactory.getInstance().createCmd((AbsTaskWrapper) t, i, i2);
    }
}
