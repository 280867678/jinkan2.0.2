package org.fourthline.cling.transport.impl;

import org.fourthline.cling.transport.spi.DatagramIOConfiguration;

/* loaded from: classes5.dex */
public class DatagramIOConfigurationImpl implements DatagramIOConfiguration {
    public int maxDatagramBytes;
    public int timeToLive;

    public DatagramIOConfigurationImpl() {
        this.timeToLive = 4;
        this.maxDatagramBytes = 640;
    }

    public DatagramIOConfigurationImpl(int i, int i2) {
        this.timeToLive = 4;
        this.maxDatagramBytes = 640;
        this.timeToLive = i;
        this.maxDatagramBytes = i2;
    }

    @Override // org.fourthline.cling.transport.spi.DatagramIOConfiguration
    public int getMaxDatagramBytes() {
        return this.maxDatagramBytes;
    }

    @Override // org.fourthline.cling.transport.spi.DatagramIOConfiguration
    public int getTimeToLive() {
        return this.timeToLive;
    }

    public void setMaxDatagramBytes(int i) {
        this.maxDatagramBytes = i;
    }

    public void setTimeToLive(int i) {
        this.timeToLive = i;
    }
}
