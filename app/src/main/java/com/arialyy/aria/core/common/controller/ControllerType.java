package com.arialyy.aria.core.common.controller;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes3.dex */
public @interface ControllerType {
    public static final Class<BuilderController> CREATE_CONTROLLER = BuilderController.class;
    public static final Class<NormalController> TASK_CONTROLLER = NormalController.class;
}
