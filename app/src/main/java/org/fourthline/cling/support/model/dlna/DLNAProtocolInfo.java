package org.fourthline.cling.support.model.dlna;

import java.util.EnumMap;
import java.util.Map;
import me.tvspark.outline;
import org.fourthline.cling.model.types.InvalidValueException;
import org.fourthline.cling.support.model.Protocol;
import org.fourthline.cling.support.model.ProtocolInfo;
import org.fourthline.cling.support.model.dlna.DLNAAttribute;
import org.seamless.util.MimeType;

/* loaded from: classes5.dex */
public class DLNAProtocolInfo extends ProtocolInfo {
    public final Map<DLNAAttribute.Type, DLNAAttribute> attributes;

    public DLNAProtocolInfo(String str) throws InvalidValueException {
        super(str);
        this.attributes = new EnumMap(DLNAAttribute.Type.class);
        parseAdditionalInfo();
    }

    public DLNAProtocolInfo(Protocol protocol, String str, String str2, String str3) {
        super(protocol, str, str2, str3);
        this.attributes = new EnumMap(DLNAAttribute.Type.class);
        parseAdditionalInfo();
    }

    public DLNAProtocolInfo(Protocol protocol, String str, String str2, EnumMap<DLNAAttribute.Type, DLNAAttribute> enumMap) {
        super(protocol, str, str2, "");
        EnumMap enumMap2 = new EnumMap(DLNAAttribute.Type.class);
        this.attributes = enumMap2;
        enumMap2.putAll(enumMap);
        this.additionalInfo = getAttributesString();
    }

    public DLNAProtocolInfo(ProtocolInfo protocolInfo) {
        this(protocolInfo.getProtocol(), protocolInfo.getNetwork(), protocolInfo.getContentFormat(), protocolInfo.getAdditionalInfo());
    }

    public DLNAProtocolInfo(DLNAProfiles dLNAProfiles) {
        super(MimeType.valueOf(dLNAProfiles.getContentFormat()));
        EnumMap enumMap = new EnumMap(DLNAAttribute.Type.class);
        this.attributes = enumMap;
        enumMap.put((EnumMap) DLNAAttribute.Type.DLNA_ORG_PN, (DLNAAttribute.Type) new DLNAProfileAttribute(dLNAProfiles));
        this.additionalInfo = getAttributesString();
    }

    public DLNAProtocolInfo(DLNAProfiles dLNAProfiles, EnumMap<DLNAAttribute.Type, DLNAAttribute> enumMap) {
        super(MimeType.valueOf(dLNAProfiles.getContentFormat()));
        EnumMap enumMap2 = new EnumMap(DLNAAttribute.Type.class);
        this.attributes = enumMap2;
        enumMap2.putAll(enumMap);
        this.attributes.put(DLNAAttribute.Type.DLNA_ORG_PN, new DLNAProfileAttribute(dLNAProfiles));
        this.additionalInfo = getAttributesString();
    }

    public DLNAProtocolInfo(MimeType mimeType) {
        super(mimeType);
        this.attributes = new EnumMap(DLNAAttribute.Type.class);
    }

    public boolean contains(DLNAAttribute.Type type) {
        return this.attributes.containsKey(type);
    }

    public DLNAAttribute getAttribute(DLNAAttribute.Type type) {
        return this.attributes.get(type);
    }

    public Map<DLNAAttribute.Type, DLNAAttribute> getAttributes() {
        return this.attributes;
    }

    public String getAttributesString() {
        DLNAAttribute.Type[] values;
        String str = "";
        for (DLNAAttribute.Type type : DLNAAttribute.Type.values()) {
            String string = this.attributes.containsKey(type) ? this.attributes.get(type).getString() : null;
            if (string != null && string.length() != 0) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str.length() == 0 ? "" : ";");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(type.getAttributeName());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("=");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(string);
                str = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            }
        }
        return str;
    }

    public void parseAdditionalInfo() {
        DLNAAttribute.Type valueOfAttributeName;
        String str = this.additionalInfo;
        if (str != null) {
            for (String str2 : str.split(";")) {
                String[] split = str2.split("=");
                if (split.length == 2 && (valueOfAttributeName = DLNAAttribute.Type.valueOfAttributeName(split[0])) != null) {
                    this.attributes.put(valueOfAttributeName, DLNAAttribute.newInstance(valueOfAttributeName, split[1], getContentFormat()));
                }
            }
        }
    }
}
