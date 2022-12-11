package com.google.common.hash;

import java.util.zip.Adler32;
import java.util.zip.CRC32;
import java.util.zip.Checksum;
import me.tvspark.AbstractC2461oy;
import me.tvspark.AbstractC2541qy;

/* loaded from: classes3.dex */
public final class Hashing {
    public static final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (int) System.currentTimeMillis();

    /* loaded from: classes3.dex */
    public enum ChecksumType implements AbstractC2541qy<Checksum> {
        CRC_32("Hashing.crc32()") { // from class: com.google.common.hash.Hashing.ChecksumType.1
            @Override // me.tvspark.AbstractC2684ut
            /* renamed from: get  reason: collision with other method in class */
            public Checksum mo4804get() {
                return new CRC32();
            }
        },
        ADLER_32("Hashing.adler32()") { // from class: com.google.common.hash.Hashing.ChecksumType.2
            @Override // me.tvspark.AbstractC2684ut
            /* renamed from: get  reason: collision with other method in class */
            public Checksum mo4804get() {
                return new Adler32();
            }
        };
        
        public final AbstractC2461oy hashFunction;

        ChecksumType(String str) {
            this.hashFunction = new ChecksumHashFunction(this, 32, str);
        }
    }

    public static AbstractC2461oy Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return Murmur3_128HashFunction.MURMUR3_128;
    }
}
