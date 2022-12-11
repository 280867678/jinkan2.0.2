package org.fourthline.cling.support.model;

import org.fourthline.cling.model.types.UnsignedIntegerFourBytes;
import org.fourthline.cling.support.lastchange.LastChange;

/* loaded from: classes5.dex */
public class AVTransport {
    public DeviceCapabilities deviceCapabilities;
    public final UnsignedIntegerFourBytes instanceID;
    public final LastChange lastChange;
    public MediaInfo mediaInfo;
    public PositionInfo positionInfo;
    public TransportInfo transportInfo;
    public TransportSettings transportSettings;

    public AVTransport(UnsignedIntegerFourBytes unsignedIntegerFourBytes, LastChange lastChange, StorageMedium storageMedium) {
        this(unsignedIntegerFourBytes, lastChange, new StorageMedium[]{storageMedium});
    }

    public AVTransport(UnsignedIntegerFourBytes unsignedIntegerFourBytes, LastChange lastChange, StorageMedium[] storageMediumArr) {
        this.instanceID = unsignedIntegerFourBytes;
        this.lastChange = lastChange;
        setDeviceCapabilities(new DeviceCapabilities(storageMediumArr));
        setMediaInfo(new MediaInfo());
        setTransportInfo(new TransportInfo());
        setPositionInfo(new PositionInfo());
        setTransportSettings(new TransportSettings());
    }

    public DeviceCapabilities getDeviceCapabilities() {
        return this.deviceCapabilities;
    }

    public UnsignedIntegerFourBytes getInstanceId() {
        return this.instanceID;
    }

    public LastChange getLastChange() {
        return this.lastChange;
    }

    public MediaInfo getMediaInfo() {
        return this.mediaInfo;
    }

    public PositionInfo getPositionInfo() {
        return this.positionInfo;
    }

    public TransportInfo getTransportInfo() {
        return this.transportInfo;
    }

    public TransportSettings getTransportSettings() {
        return this.transportSettings;
    }

    public void setDeviceCapabilities(DeviceCapabilities deviceCapabilities) {
        this.deviceCapabilities = deviceCapabilities;
    }

    public void setMediaInfo(MediaInfo mediaInfo) {
        this.mediaInfo = mediaInfo;
    }

    public void setPositionInfo(PositionInfo positionInfo) {
        this.positionInfo = positionInfo;
    }

    public void setTransportInfo(TransportInfo transportInfo) {
        this.transportInfo = transportInfo;
    }

    public void setTransportSettings(TransportSettings transportSettings) {
        this.transportSettings = transportSettings;
    }
}
