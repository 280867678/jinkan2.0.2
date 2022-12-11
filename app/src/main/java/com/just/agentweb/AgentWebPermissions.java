package com.just.agentweb;

import com.umeng.commonsdk.utils.UMUtils;

/* loaded from: classes3.dex */
public class AgentWebPermissions {
    public static final String ACTION_CAMERA = "Camera";
    public static final String ACTION_LOCATION = "Location";
    public static final String ACTION_STORAGE = "Storage";
    public static final String[] CAMERA = {"android.permission.CAMERA"};
    public static final String[] LOCATION = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
    public static final String[] STORAGE = {"android.permission.READ_EXTERNAL_STORAGE", UMUtils.SD_PERMISSION};
}
