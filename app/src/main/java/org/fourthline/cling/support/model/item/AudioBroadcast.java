package org.fourthline.cling.support.model.item;

import org.fourthline.cling.support.model.DIDLObject;
import org.fourthline.cling.support.model.Res;

/* loaded from: classes5.dex */
public class AudioBroadcast extends AudioItem {
    public static final DIDLObject.Class CLASS = new DIDLObject.Class("object.item.audioItem.audioBroadcast");

    public AudioBroadcast() {
        setClazz(CLASS);
    }

    public AudioBroadcast(String str, String str2, String str3, String str4, Res... resArr) {
        super(str, str2, str3, str4, resArr);
        setClazz(CLASS);
    }

    public AudioBroadcast(Item item) {
        super(item);
    }

    public Integer getChannelNr() {
        return (Integer) getFirstPropertyValue(DIDLObject.Property.UPNP.CHANNEL_NR.class);
    }

    public String getRadioBand() {
        return (String) getFirstPropertyValue(DIDLObject.Property.UPNP.RADIO_BAND.class);
    }

    public String getRadioCallSign() {
        return (String) getFirstPropertyValue(DIDLObject.Property.UPNP.RADIO_CALL_SIGN.class);
    }

    public String getRadioStationID() {
        return (String) getFirstPropertyValue(DIDLObject.Property.UPNP.RADIO_STATION_ID.class);
    }

    public String getRegion() {
        return (String) getFirstPropertyValue(DIDLObject.Property.UPNP.REGION.class);
    }

    public AudioBroadcast setChannelNr(Integer num) {
        replaceFirstProperty(new DIDLObject.Property.UPNP.CHANNEL_NR(num));
        return this;
    }

    public AudioBroadcast setRadioBand(String str) {
        replaceFirstProperty(new DIDLObject.Property.UPNP.RADIO_BAND(str));
        return this;
    }

    public AudioBroadcast setRadioCallSign(String str) {
        replaceFirstProperty(new DIDLObject.Property.UPNP.RADIO_CALL_SIGN(str));
        return this;
    }

    public AudioBroadcast setRadioStationID(String str) {
        replaceFirstProperty(new DIDLObject.Property.UPNP.RADIO_STATION_ID(str));
        return this;
    }

    public AudioBroadcast setRegion(String str) {
        replaceFirstProperty(new DIDLObject.Property.UPNP.REGION(str));
        return this;
    }
}
