package com.arialyy.aria.core.download.m3u8;

import android.text.TextUtils;
import com.arialyy.aria.core.common.BaseOption;
import com.arialyy.aria.core.download.m3u8.M3U8Option;
import com.arialyy.aria.core.processor.IBandWidthUrlConverter;
import com.arialyy.aria.core.processor.IKeyUrlConverter;
import com.arialyy.aria.core.processor.ITsMergeHandler;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CheckUtil;
import com.arialyy.aria.util.ComponentUtil;

/* loaded from: classes3.dex */
public class M3U8Option<OP extends M3U8Option> extends BaseOption {
    public int bandWidth;
    public IBandWidthUrlConverter bandWidthUrlConverter;
    public String keyPath;
    public IKeyUrlConverter keyUrlConverter;
    public ITsMergeHandler mergeHandler;
    public boolean generateIndexFile = false;
    public boolean mergeFile = true;
    public boolean ignoreFailureTs = false;

    public M3U8Option() {
        ComponentUtil.getInstance().checkComponentExist(3);
    }

    public OP generateIndexFile() {
        this.generateIndexFile = true;
        return this;
    }

    public OP ignoreFailureTs() {
        this.ignoreFailureTs = true;
        return this;
    }

    public OP merge(boolean z) {
        this.mergeFile = z;
        return this;
    }

    public OP setBandWidth(int i) {
        this.bandWidth = i;
        return this;
    }

    public OP setBandWidthUrlConverter(IBandWidthUrlConverter iBandWidthUrlConverter) {
        CheckUtil.checkMemberClass(iBandWidthUrlConverter.getClass());
        this.bandWidthUrlConverter = iBandWidthUrlConverter;
        return this;
    }

    public OP setKeyPath(String str) {
        if (TextUtils.isEmpty(str)) {
            ALog.m4191e(this.TAG, "密钥文件保存路径为空");
            return this;
        }
        this.keyPath = str;
        return this;
    }

    public OP setKeyUrlConverter(IKeyUrlConverter iKeyUrlConverter) {
        CheckUtil.checkMemberClass(iKeyUrlConverter.getClass());
        this.keyUrlConverter = iKeyUrlConverter;
        return this;
    }

    public OP setMergeHandler(ITsMergeHandler iTsMergeHandler) {
        CheckUtil.checkMemberClass(iTsMergeHandler.getClass());
        this.mergeHandler = iTsMergeHandler;
        return this;
    }
}
