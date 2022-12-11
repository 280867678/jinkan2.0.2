package org.fourthline.cling.transport.spi;

import java.util.concurrent.ExecutorService;
import org.fourthline.cling.model.ServerClientTokens;

/* loaded from: classes5.dex */
public abstract class AbstractStreamClientConfiguration implements StreamClientConfiguration {
    public int logWarningSeconds;
    public ExecutorService requestExecutorService;
    public int timeoutSeconds;

    public AbstractStreamClientConfiguration(ExecutorService executorService) {
        this.timeoutSeconds = 60;
        this.logWarningSeconds = 5;
        this.requestExecutorService = executorService;
    }

    public AbstractStreamClientConfiguration(ExecutorService executorService, int i) {
        this.timeoutSeconds = 60;
        this.logWarningSeconds = 5;
        this.requestExecutorService = executorService;
        this.timeoutSeconds = i;
    }

    public AbstractStreamClientConfiguration(ExecutorService executorService, int i, int i2) {
        this.timeoutSeconds = 60;
        this.logWarningSeconds = 5;
        this.requestExecutorService = executorService;
        this.timeoutSeconds = i;
        this.logWarningSeconds = i2;
    }

    @Override // org.fourthline.cling.transport.spi.StreamClientConfiguration
    public int getLogWarningSeconds() {
        return this.logWarningSeconds;
    }

    @Override // org.fourthline.cling.transport.spi.StreamClientConfiguration
    public ExecutorService getRequestExecutorService() {
        return this.requestExecutorService;
    }

    @Override // org.fourthline.cling.transport.spi.StreamClientConfiguration
    public int getTimeoutSeconds() {
        return this.timeoutSeconds;
    }

    @Override // org.fourthline.cling.transport.spi.StreamClientConfiguration
    public String getUserAgentValue(int i, int i2) {
        return new ServerClientTokens(i, i2).toString();
    }

    public void setLogWarningSeconds(int i) {
        this.logWarningSeconds = i;
    }

    public void setRequestExecutorService(ExecutorService executorService) {
        this.requestExecutorService = executorService;
    }

    public void setTimeoutSeconds(int i) {
        this.timeoutSeconds = i;
    }
}
