package com.google.common.hash;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

/* loaded from: classes3.dex */
public enum LittleEndianByteArray$UnsafeByteArray {
    UNSAFE_LITTLE_ENDIAN { // from class: com.google.common.hash.LittleEndianByteArray$UnsafeByteArray.1
        public long getLongLittleEndian(byte[] bArr, int i) {
            return LittleEndianByteArray$UnsafeByteArray.theUnsafe.getLong(bArr, i + LittleEndianByteArray$UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET);
        }

        public void putLongLittleEndian(byte[] bArr, int i, long j) {
            LittleEndianByteArray$UnsafeByteArray.theUnsafe.putLong(bArr, i + LittleEndianByteArray$UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET, j);
        }
    },
    UNSAFE_BIG_ENDIAN { // from class: com.google.common.hash.LittleEndianByteArray$UnsafeByteArray.2
        public long getLongLittleEndian(byte[] bArr, int i) {
            return Long.reverseBytes(LittleEndianByteArray$UnsafeByteArray.theUnsafe.getLong(bArr, i + LittleEndianByteArray$UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET));
        }

        public void putLongLittleEndian(byte[] bArr, int i, long j) {
            LittleEndianByteArray$UnsafeByteArray.theUnsafe.putLong(bArr, i + LittleEndianByteArray$UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET, Long.reverseBytes(j));
        }
    };
    
    public static final int BYTE_ARRAY_BASE_OFFSET;
    public static final Unsafe theUnsafe;

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements PrivilegedExceptionAction<Unsafe> {
        @Override // java.security.PrivilegedExceptionAction
        public Unsafe run() throws Exception {
            Field[] declaredFields;
            for (Field field : Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            throw new NoSuchFieldError("the Unsafe");
        }
    }

    static {
        Unsafe unsafe = getUnsafe();
        theUnsafe = unsafe;
        BYTE_ARRAY_BASE_OFFSET = unsafe.arrayBaseOffset(byte[].class);
        if (theUnsafe.arrayIndexScale(byte[].class) == 1) {
            return;
        }
        throw new AssertionError();
    }

    public static Unsafe getUnsafe() {
        try {
            try {
                return Unsafe.getUnsafe();
            } catch (PrivilegedActionException e) {
                throw new RuntimeException("Could not initialize intrinsics", e.getCause());
            }
        } catch (SecurityException unused) {
            return (Unsafe) AccessController.doPrivileged(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }
    }
}
