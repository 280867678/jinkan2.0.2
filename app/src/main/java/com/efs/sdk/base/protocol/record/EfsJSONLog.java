package com.efs.sdk.base.protocol.record;

import com.efs.sdk.base.Constants;
import com.efs.sdk.base.core.config.C0725a;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class EfsJSONLog extends AbsRecordLog {
    public EfsJSONLog(String str) {
        super(str);
        put("type", str);
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public byte[] generate() {
        String generateString = generateString();
        if (ControllerCenter.getGlobalEnvStruct().isPrintLogDetail()) {
            Log.m4062i("efs.base", generateString);
        }
        return generateString.getBytes();
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public String generateString() {
        return new JSONObject(this.dataMap).toString();
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public String getLinkId() {
        if (this.dataMap.containsKey(Constants.LOG_KEY_LINK_ID)) {
            return String.valueOf(this.dataMap.get(Constants.LOG_KEY_LINK_ID));
        }
        return null;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public String getLinkKey() {
        if (this.dataMap.containsKey(Constants.LOG_KEY_LINK_KEY)) {
            return String.valueOf(this.dataMap.get(Constants.LOG_KEY_LINK_KEY));
        }
        return null;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public void insertGlobal(C0725a c0725a) {
        this.dataMap.putAll(c0725a.m4135a());
        this.dataMap.putAll(ControllerCenter.getGlobalEnvStruct().getPublicParamMap());
    }
}
