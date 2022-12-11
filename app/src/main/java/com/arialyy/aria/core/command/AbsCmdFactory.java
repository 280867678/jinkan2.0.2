package com.arialyy.aria.core.command;

import com.arialyy.aria.core.command.AbsCmd;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;

/* loaded from: classes3.dex */
public abstract class AbsCmdFactory<TASK_ENTITY extends AbsTaskWrapper, CMD extends AbsCmd> {
    public abstract CMD createCmd(TASK_ENTITY task_entity, int i, int i2);
}
