package com.google.common.util.concurrent;

/* renamed from: com.google.common.util.concurrent.FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator */
/* loaded from: classes3.dex */
public enum EnumC0916xc4eed485 {
    INSTANCE;
    
    public static final ClassValue<Boolean> isValidClass = new ClassValue<Boolean>() { // from class: com.google.common.util.concurrent.FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    };

    public void validateClass(Class<? extends Exception> cls) {
        isValidClass.get(cls);
    }
}
