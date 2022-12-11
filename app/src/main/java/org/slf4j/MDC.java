package org.slf4j;

import java.io.Closeable;
import java.util.Map;
import org.slf4j.helpers.NOPMDCAdapter;
import org.slf4j.helpers.Util;
import org.slf4j.impl.StaticMDCBinder;
import org.slf4j.spi.MDCAdapter;

/* loaded from: classes5.dex */
public class MDC {
    public static final String NO_STATIC_MDC_BINDER_URL = "http://www.slf4j.org/codes.html#no_static_mdc_binder";
    public static final String NULL_MDCA_URL = "http://www.slf4j.org/codes.html#null_MDCA";
    public static MDCAdapter mdcAdapter;

    /* loaded from: classes5.dex */
    public static class MDCCloseable implements Closeable {
        public final String key;

        public MDCCloseable(String str) {
            this.key = str;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            MDC.remove(this.key);
        }
    }

    static {
        try {
            mdcAdapter = bwCompatibleGetMDCAdapterFromBinder();
        } catch (Exception e) {
            Util.report("MDC binding unsuccessful.", e);
        } catch (NoClassDefFoundError e2) {
            mdcAdapter = new NOPMDCAdapter();
            String message = e2.getMessage();
            if (message == null || !message.contains("StaticMDCBinder")) {
                throw e2;
            }
            Util.report("Failed to load class \"org.slf4j.impl.StaticMDCBinder\".");
            Util.report("Defaulting to no-operation MDCAdapter implementation.");
            Util.report("See http://www.slf4j.org/codes.html#no_static_mdc_binder for further details.");
        }
    }

    public static MDCAdapter bwCompatibleGetMDCAdapterFromBinder() throws NoClassDefFoundError {
        try {
            return StaticMDCBinder.getSingleton().getMDCA();
        } catch (NoSuchMethodError unused) {
            return StaticMDCBinder.SINGLETON.getMDCA();
        }
    }

    public static void clear() {
        MDCAdapter mDCAdapter = mdcAdapter;
        if (mDCAdapter != null) {
            mDCAdapter.clear();
            return;
        }
        throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
    }

    public static String get(String str) throws IllegalArgumentException {
        if (str != null) {
            MDCAdapter mDCAdapter = mdcAdapter;
            if (mDCAdapter == null) {
                throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
            }
            return mDCAdapter.get(str);
        }
        throw new IllegalArgumentException("key parameter cannot be null");
    }

    public static Map<String, String> getCopyOfContextMap() {
        MDCAdapter mDCAdapter = mdcAdapter;
        if (mDCAdapter != null) {
            return mDCAdapter.getCopyOfContextMap();
        }
        throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
    }

    public static MDCAdapter getMDCAdapter() {
        return mdcAdapter;
    }

    public static void put(String str, String str2) throws IllegalArgumentException {
        if (str != null) {
            MDCAdapter mDCAdapter = mdcAdapter;
            if (mDCAdapter == null) {
                throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
            }
            mDCAdapter.put(str, str2);
            return;
        }
        throw new IllegalArgumentException("key parameter cannot be null");
    }

    public static MDCCloseable putCloseable(String str, String str2) throws IllegalArgumentException {
        put(str, str2);
        return new MDCCloseable(str);
    }

    public static void remove(String str) throws IllegalArgumentException {
        if (str != null) {
            MDCAdapter mDCAdapter = mdcAdapter;
            if (mDCAdapter == null) {
                throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
            }
            mDCAdapter.remove(str);
            return;
        }
        throw new IllegalArgumentException("key parameter cannot be null");
    }

    public static void setContextMap(Map<String, String> map) {
        MDCAdapter mDCAdapter = mdcAdapter;
        if (mDCAdapter != null) {
            mDCAdapter.setContextMap(map);
            return;
        }
        throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
    }
}
