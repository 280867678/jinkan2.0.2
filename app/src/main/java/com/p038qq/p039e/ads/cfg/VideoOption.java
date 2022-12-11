package com.p038qq.p039e.ads.cfg;

import com.p038qq.p039e.comm.util.GDTLogger;
import me.tvspark.outline;
import org.json.JSONObject;

/* renamed from: com.qq.e.ads.cfg.VideoOption */
/* loaded from: classes3.dex */
public class VideoOption {
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: com.qq.e.ads.cfg.VideoOption$AutoPlayPolicy */
    /* loaded from: classes3.dex */
    public static final class AutoPlayPolicy {
        public static final int ALWAYS = 1;
        public static final int NEVER = 2;
        public static final int WIFI = 0;
    }

    /* renamed from: com.qq.e.ads.cfg.VideoOption$Builder */
    /* loaded from: classes3.dex */
    public static final class Builder {
        public int Wwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwww = false;

        public VideoOption build() {
            return new VideoOption(this, null);
        }

        public Builder setAutoPlayMuted(boolean z) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
            return this;
        }

        public Builder setAutoPlayPolicy(int i) {
            if (i < 0 || i > 2) {
                i = 1;
                GDTLogger.m3646e("setAutoPlayPolicy 设置失败，值只能为0到2之间的数值, 重置为 : 1");
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            return this;
        }

        public Builder setDetailPageMuted(boolean z) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
            return this;
        }

        public Builder setEnableDetailPage(boolean z) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
            return this;
        }

        public Builder setEnableUserControl(boolean z) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
            return this;
        }

        public Builder setMaxVideoDuration(int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            return this;
        }

        public Builder setMinVideoDuration(int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = i;
            return this;
        }

        public Builder setNeedCoverImage(boolean z) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
            return this;
        }

        public Builder setNeedProgressBar(boolean z) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
            return this;
        }
    }

    public /* synthetic */ VideoOption(Builder builder, C10481 c10481) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = builder.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = builder.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = builder.Wwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public boolean getAutoPlayMuted() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public int getAutoPlayPolicy() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public int getMaxVideoDuration() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public int getMinVideoDuration() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public JSONObject getOptions() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("autoPlayMuted", Boolean.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
            jSONObject.putOpt("autoPlayPolicy", Integer.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
            jSONObject.putOpt("detailPageMuted", Boolean.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww));
        } catch (Exception e) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Get video options error: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(e.getMessage());
            GDTLogger.m3647d(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        return jSONObject;
    }

    public boolean isDetailPageMuted() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public boolean isEnableDetailPage() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public boolean isEnableUserControl() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public boolean isNeedCoverImage() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public boolean isNeedProgressBar() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}
