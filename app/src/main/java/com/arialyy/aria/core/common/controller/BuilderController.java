package com.arialyy.aria.core.common.controller;

import com.arialyy.aria.core.command.CmdHelper;
import com.arialyy.aria.core.event.EventMsgUtil;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;

/* loaded from: classes3.dex */
public final class BuilderController extends FeatureController implements IStartFeature {
    public BuilderController(AbsTaskWrapper absTaskWrapper) {
        super(absTaskWrapper);
    }

    @Override // com.arialyy.aria.core.common.controller.IStartFeature
    public long add() {
        setAction(5);
        if (checkConfig()) {
            EventMsgUtil.getDefault().post(CmdHelper.createNormalCmd(getTaskWrapper(), 177, checkTaskType()));
            return getEntity().getId();
        }
        return -1L;
    }

    @Override // com.arialyy.aria.core.common.controller.IStartFeature
    public long create() {
        setAction(1);
        if (checkConfig()) {
            EventMsgUtil.getDefault().post(CmdHelper.createNormalCmd(getTaskWrapper(), 178, checkTaskType()));
            return getEntity().getId();
        }
        return -1L;
    }

    @Override // com.arialyy.aria.core.common.controller.IStartFeature
    public long setHighestPriority() {
        setAction(6);
        if (checkConfig()) {
            EventMsgUtil.getDefault().post(CmdHelper.createNormalCmd(getTaskWrapper(), 182, checkTaskType()));
            return getEntity().getId();
        }
        return -1L;
    }
}
