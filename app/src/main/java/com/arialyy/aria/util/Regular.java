package com.arialyy.aria.util;

/* loaded from: classes3.dex */
public interface Regular {
    public static final String BANDWIDTH = "[0-9]{3,}";
    public static final String REG_DOUBLE_CHAR_AND_SPACE = "[^\\x00-\\xff]|[\\s\\p{Zs}]";
    public static final String REG_FILE_NAME = "[/|\\\\|//]";
    public static final String REG_IP_V4 = "(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])";
    public static final String REG_WINLOD_REPLACE = "replace\\(\".*\"\\)";
}
