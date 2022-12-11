package com.arialyy.aria.core.command;

import com.arialyy.aria.core.event.Event;
import com.arialyy.aria.core.event.EventMsgUtil;
import com.arialyy.aria.util.CommonUtil;

/* loaded from: classes3.dex */
public class CommandManager {
    public static CommandManager instance;

    public CommandManager() {
        EventMsgUtil.getDefault().register(this);
    }

    public static void init() {
        if (instance == null) {
            synchronized (CommandManager.class) {
                if (instance == null) {
                    instance = new CommandManager();
                }
            }
        }
    }

    @Event
    public void add(AddCmd addCmd) {
        if (CommonUtil.isFastDoubleClick()) {
            return;
        }
        addCmd.executeCmd();
    }

    @Event
    public void cancel(CancelCmd cancelCmd) {
        cancelCmd.executeCmd();
    }

    @Event
    public void cancelAll(CancelAllCmd cancelAllCmd) {
        if (CommonUtil.isFastDoubleClick()) {
            return;
        }
        cancelAllCmd.executeCmd();
    }

    @Event
    public void highestPriority(HighestPriorityCmd highestPriorityCmd) {
        if (CommonUtil.isFastDoubleClick()) {
            return;
        }
        highestPriorityCmd.executeCmd();
    }

    @Event
    public void reStart(ReStartCmd reStartCmd) {
        if (CommonUtil.isFastDoubleClick()) {
            return;
        }
        reStartCmd.executeCmd();
    }

    @Event
    public void resumeAll(ResumeAllCmd resumeAllCmd) {
        if (CommonUtil.isFastDoubleClick()) {
            return;
        }
        resumeAllCmd.executeCmd();
    }

    @Event
    public void start(StartCmd startCmd) {
        startCmd.executeCmd();
    }

    @Event
    public void stop(StopCmd stopCmd) {
        stopCmd.executeCmd();
    }

    @Event
    public void stopAll(StopAllCmd stopAllCmd) {
        if (CommonUtil.isFastDoubleClick()) {
            return;
        }
        stopAllCmd.executeCmd();
    }

    @Event
    public void subStart(DGSubStartCmd dGSubStartCmd) {
        if (CommonUtil.isFastDoubleClick()) {
            return;
        }
        dGSubStartCmd.executeCmd();
    }

    @Event
    public void subStop(DGSubStopCmd dGSubStopCmd) {
        dGSubStopCmd.executeCmd();
    }
}
