package com.p038qq.p039e.comm.constants;

import android.text.TextUtils;
import com.p038qq.p039e.ads.ADActivity;
import com.p038qq.p039e.ads.LandscapeADActivity;
import com.p038qq.p039e.ads.PortraitADActivity;
import com.p038qq.p039e.ads.RewardvideoLandscapeADActivity;
import com.p038qq.p039e.ads.RewardvideoPortraitADActivity;
import com.p038qq.p039e.comm.DownloadService;
import com.p038qq.p039e.comm.managers.setting.GlobalSetting;

/* renamed from: com.qq.e.comm.constants.CustomPkgConstants */
/* loaded from: classes3.dex */
public class CustomPkgConstants {
    public static final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = DownloadService.class.getName();
    public static final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ADActivity.class.getName();
    public static final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = PortraitADActivity.class.getName();
    public static final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = RewardvideoPortraitADActivity.class.getName();
    public static final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = LandscapeADActivity.class.getName();
    public static final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = RewardvideoLandscapeADActivity.class.getName();

    public static String getADActivityName() {
        String customADActivityClassName = GlobalSetting.getCustomADActivityClassName();
        return !TextUtils.isEmpty(customADActivityClassName) ? customADActivityClassName : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public static String getAssetPluginXorKey() {
        return "";
    }

    public static String getDownLoadServiceName() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public static String getLandscapeADActivityName() {
        String customLandscapeActivityClassName = GlobalSetting.getCustomLandscapeActivityClassName();
        return !TextUtils.isEmpty(customLandscapeActivityClassName) ? customLandscapeActivityClassName : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public static String getPortraitADActivityName() {
        String customPortraitActivityClassName = GlobalSetting.getCustomPortraitActivityClassName();
        return !TextUtils.isEmpty(customPortraitActivityClassName) ? customPortraitActivityClassName : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public static String getRewardvideoLandscapeADActivityName() {
        String customRewardvideoLandscapeActivityClassName = GlobalSetting.getCustomRewardvideoLandscapeActivityClassName();
        return !TextUtils.isEmpty(customRewardvideoLandscapeActivityClassName) ? customRewardvideoLandscapeActivityClassName : Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public static String getRewardvideoPortraitADActivityName() {
        String customRewardvideoPortraitActivityClassName = GlobalSetting.getCustomRewardvideoPortraitActivityClassName();
        return !TextUtils.isEmpty(customRewardvideoPortraitActivityClassName) ? customRewardvideoPortraitActivityClassName : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}
