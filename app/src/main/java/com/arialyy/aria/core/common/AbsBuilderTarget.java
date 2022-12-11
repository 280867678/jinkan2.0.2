package com.arialyy.aria.core.common;

import com.arialyy.aria.core.common.AbsBuilderTarget;
import com.arialyy.aria.core.common.controller.BuilderController;
import com.arialyy.aria.core.common.controller.IStartFeature;
import com.arialyy.aria.core.inf.AbsTarget;

/* loaded from: classes3.dex */
public abstract class AbsBuilderTarget<TARGET extends AbsBuilderTarget> extends AbsTarget<TARGET> implements IStartFeature {
    public BuilderController mStartController;

    private synchronized BuilderController getController() {
        if (this.mStartController == null) {
            this.mStartController = new BuilderController(getTaskWrapper());
        }
        return this.mStartController;
    }

    @Override // com.arialyy.aria.core.common.controller.IStartFeature
    public long add() {
        onPre();
        return getController().add();
    }

    @Override // com.arialyy.aria.core.common.controller.IStartFeature
    public long create() {
        onPre();
        return getController().create();
    }

    public TARGET ignoreCheckPermissions() {
        getController().ignoreCheckPermissions();
        return this;
    }

    public TARGET ignoreFilePathOccupy() {
        getController().ignoreFilePathOccupy();
        return this;
    }

    public void onPre() {
    }

    @Override // com.arialyy.aria.core.common.controller.IStartFeature
    public long setHighestPriority() {
        onPre();
        return getController().setHighestPriority();
    }
}
