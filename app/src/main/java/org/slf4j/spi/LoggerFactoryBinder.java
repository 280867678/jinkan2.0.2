package org.slf4j.spi;

import org.slf4j.ILoggerFactory;

/* loaded from: classes5.dex */
public interface LoggerFactoryBinder {
    ILoggerFactory getLoggerFactory();

    String getLoggerFactoryClassStr();
}
