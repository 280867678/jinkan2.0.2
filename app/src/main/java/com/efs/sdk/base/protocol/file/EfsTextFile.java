package com.efs.sdk.base.protocol.file;

import android.text.TextUtils;
import com.efs.sdk.base.Constants;
import com.efs.sdk.base.core.config.C0725a;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.protocol.file.section.AbsSection;
import com.efs.sdk.base.protocol.file.section.JSONSection;
import com.efs.sdk.base.protocol.file.section.KVSection;
import com.efs.sdk.base.protocol.file.section.TextSection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class EfsTextFile extends AbsFileLog {
    public static final String FILE_START = "*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***";
    public static final String SECTION_START = "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---";
    public List<AbsSection> sectionList = new ArrayList();
    public String mLinkKey = null;
    public String mLinkID = null;
    public boolean mHasInitLinkInfo = false;

    public EfsTextFile(String str) {
        super(str);
    }

    private String changeToStr() {
        StringBuilder sb = new StringBuilder(FILE_START);
        sb.append("\n");
        int i = 0;
        for (AbsSection absSection : this.sectionList) {
            if (i > 0) {
                sb.append("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n");
            }
            sb.append(absSection.changeToStr());
            i++;
        }
        return sb.toString();
    }

    private void initLinkInfo() {
        if ((TextUtils.isEmpty(this.mLinkID) || TextUtils.isEmpty(this.mLinkKey)) && !this.mHasInitLinkInfo) {
            for (AbsSection absSection : this.sectionList) {
                if (absSection instanceof KVSection) {
                    Map<String, Object> dataMap = ((KVSection) absSection).getDataMap();
                    if (TextUtils.isEmpty(this.mLinkID) && dataMap.containsKey(Constants.LOG_KEY_LINK_ID)) {
                        this.mLinkID = String.valueOf(dataMap.get(Constants.LOG_KEY_LINK_ID));
                    }
                    if (TextUtils.isEmpty(this.mLinkKey) && dataMap.containsKey(Constants.LOG_KEY_LINK_KEY)) {
                        this.mLinkKey = String.valueOf(dataMap.get(Constants.LOG_KEY_LINK_KEY));
                    }
                }
            }
            this.mHasInitLinkInfo = true;
        }
    }

    private void insertCustomInfoSection() {
        KVSection kVSection = new KVSection("custom_info");
        for (Map.Entry<String, String> entry : ControllerCenter.getGlobalEnvStruct().getPublicParamMap().entrySet()) {
            kVSection.put(entry.getKey(), entry.getValue());
        }
        this.sectionList.add(0, kVSection);
    }

    public JSONSection createAndAddJSONSection(String str) {
        JSONSection jSONSection = new JSONSection(str);
        this.sectionList.add(jSONSection);
        return jSONSection;
    }

    public KVSection createAndAddKVSection(String str) {
        KVSection kVSection = new KVSection(str);
        this.sectionList.add(kVSection);
        return kVSection;
    }

    public TextSection createAndAddTextSection(String str) {
        TextSection textSection = new TextSection(str);
        this.sectionList.add(textSection);
        return textSection;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public byte[] generate() {
        String changeToStr = changeToStr();
        if (ControllerCenter.getGlobalEnvStruct().isPrintLogDetail()) {
            Log.m4062i("efs.base", changeToStr);
        }
        return changeToStr.getBytes();
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public String generateString() {
        return changeToStr();
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public String getLinkId() {
        initLinkInfo();
        return this.mLinkID;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public String getLinkKey() {
        initLinkInfo();
        return this.mLinkKey;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public void insertGlobal(C0725a c0725a) {
        insertCustomInfoSection();
        this.sectionList.addAll(0, c0725a.m4134a(getLogType()));
    }
}
