package com.arialyy.aria.core.download.m3u8;

import com.arialyy.aria.core.processor.ILiveTsUrlConverter;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CheckUtil;

/* loaded from: classes3.dex */
public class M3U8LiveOption extends M3U8Option<M3U8LiveOption> {
    public ILiveTsUrlConverter liveTsUrlConverter;
    public long liveUpdateInterval;

    public M3U8LiveOption setLiveTsUrlConvert(ILiveTsUrlConverter iLiveTsUrlConverter) {
        CheckUtil.checkMemberClass(iLiveTsUrlConverter.getClass());
        this.liveTsUrlConverter = iLiveTsUrlConverter;
        return this;
    }

    public M3U8LiveOption setM3U8FileUpdateInterval(long j) {
        if (j <= 1) {
            ALog.m4191e(this.TAG, "间隔时间错误");
            return this;
        }
        this.liveUpdateInterval = j;
        return this;
    }
}
