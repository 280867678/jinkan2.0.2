package com.arialyy.aria.core.common.controller;

import com.arialyy.aria.core.command.CancelCmd;
import com.arialyy.aria.core.command.CmdHelper;
import com.arialyy.aria.core.command.NormalCmdFactory;
import com.arialyy.aria.core.command.StartCmd;
import com.arialyy.aria.core.event.EventMsgUtil;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import com.arialyy.aria.util.ALog;

/* loaded from: classes3.dex */
public final class NormalController extends FeatureController implements INormalFeature {
    public String TAG = "NormalController";

    public NormalController(AbsTaskWrapper absTaskWrapper) {
        super(absTaskWrapper);
    }

    @Override // com.arialyy.aria.core.common.controller.INormalFeature
    public void cancel() {
        cancel(false);
    }

    @Override // com.arialyy.aria.core.common.controller.INormalFeature
    public void cancel(boolean z) {
        setAction(4);
        if (checkConfig()) {
            CancelCmd cancelCmd = (CancelCmd) CmdHelper.createNormalCmd(getTaskWrapper(), 180, checkTaskType());
            cancelCmd.removeFile = z;
            EventMsgUtil.getDefault().post(cancelCmd);
        }
    }

    @Override // com.arialyy.aria.core.common.controller.INormalFeature
    public long reStart() {
        setAction(8);
        if (checkConfig()) {
            EventMsgUtil.getDefault().post(CmdHelper.createNormalCmd(getTaskWrapper(), NormalCmdFactory.TASK_RESTART, checkTaskType()));
            return getEntity().getId();
        }
        return -1L;
    }

    @Override // com.arialyy.aria.core.common.controller.INormalFeature
    public void reTry() {
        setAction(7);
        if (checkConfig()) {
            int checkTaskType = checkTaskType();
            EventMsgUtil.getDefault().post(CmdHelper.createNormalCmd(getTaskWrapper(), 181, checkTaskType));
            EventMsgUtil.getDefault().post(CmdHelper.createNormalCmd(getTaskWrapper(), 178, checkTaskType));
        }
    }

    @Override // com.arialyy.aria.core.common.controller.INormalFeature
    public void resume() {
        resume(false);
    }

    @Override // com.arialyy.aria.core.common.controller.INormalFeature
    public void resume(boolean z) {
        setAction(2);
        if (checkConfig()) {
            StartCmd startCmd = (StartCmd) CmdHelper.createNormalCmd(getTaskWrapper(), 178, checkTaskType());
            startCmd.setNowStart(z);
            EventMsgUtil.getDefault().post(startCmd);
        }
    }

    @Override // com.arialyy.aria.core.common.controller.INormalFeature
    public void save() {
        setAction(9);
        if (!checkConfig()) {
            ALog.m4191e(this.TAG, "保存修改失败");
        } else {
            ALog.m4189i(this.TAG, "保存成功");
        }
    }

    @Override // com.arialyy.aria.core.common.controller.INormalFeature
    public void stop() {
        setAction(3);
        if (checkConfig()) {
            EventMsgUtil.getDefault().post(CmdHelper.createNormalCmd(getTaskWrapper(), 181, checkTaskType()));
        }
    }
}
