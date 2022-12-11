package com.google.common.base;

import org.apache.commons.lang3.SystemUtils;
import org.slf4j.LoggerFactory;

/* loaded from: classes3.dex */
public enum StandardSystemProperty {
    JAVA_VERSION("java.version"),
    JAVA_VENDOR("java.vendor"),
    JAVA_VENDOR_URL(LoggerFactory.JAVA_VENDOR_PROPERTY),
    JAVA_HOME(SystemUtils.JAVA_HOME_KEY),
    JAVA_VM_SPECIFICATION_VERSION("java.vm.specification.version"),
    JAVA_VM_SPECIFICATION_VENDOR("java.vm.specification.vendor"),
    JAVA_VM_SPECIFICATION_NAME("java.vm.specification.name"),
    JAVA_VM_VERSION("java.vm.version"),
    JAVA_VM_VENDOR("java.vm.vendor"),
    JAVA_VM_NAME("java.vm.name"),
    JAVA_SPECIFICATION_VERSION("java.specification.version"),
    JAVA_SPECIFICATION_VENDOR("java.specification.vendor"),
    JAVA_SPECIFICATION_NAME("java.specification.name"),
    JAVA_CLASS_VERSION("java.class.version"),
    JAVA_CLASS_PATH("java.class.path"),
    JAVA_LIBRARY_PATH("java.library.path"),
    JAVA_IO_TMPDIR(SystemUtils.JAVA_IO_TMPDIR_KEY),
    JAVA_COMPILER("java.compiler"),
    JAVA_EXT_DIRS("java.ext.dirs"),
    OS_NAME("os.name"),
    OS_ARCH("os.arch"),
    OS_VERSION("os.version"),
    FILE_SEPARATOR("file.separator"),
    PATH_SEPARATOR("path.separator"),
    LINE_SEPARATOR("line.separator"),
    USER_NAME("user.name"),
    USER_HOME(SystemUtils.USER_HOME_KEY),
    USER_DIR(SystemUtils.USER_DIR_KEY);
    
    public final String key;

    StandardSystemProperty(String str) {
        this.key = str;
    }

    public String key() {
        return this.key;
    }

    @Override // java.lang.Enum
    public String toString() {
        return key() + "=" + value();
    }

    public String value() {
        return System.getProperty(this.key);
    }
}
