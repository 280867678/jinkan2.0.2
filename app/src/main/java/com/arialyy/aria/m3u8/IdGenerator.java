package com.arialyy.aria.m3u8;

import me.tvspark.outline;

/* loaded from: classes3.dex */
public final class IdGenerator {
    public static volatile IdGenerator INSTANCE = null;
    public static final long beginTs = 1483200000000L;
    public long processId;
    public long lastTs = 0;
    public int processIdBits = 10;
    public long sequence = 0;
    public int sequenceBits = 12;

    public IdGenerator() {
    }

    public IdGenerator(long j) {
        if (j <= (1 << 10) - 1) {
            this.processId = j;
            return;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("进程ID超出范围，设置位数");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.processIdBits);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("，最大");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append((1 << this.processIdBits) - 1);
        throw new RuntimeException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    public static synchronized IdGenerator getInstance() {
        IdGenerator idGenerator;
        synchronized (IdGenerator.class) {
            if (INSTANCE == null) {
                INSTANCE = new IdGenerator();
            }
            idGenerator = INSTANCE;
        }
        return idGenerator;
    }

    private long nextTs(long j) {
        long timeGen;
        do {
            timeGen = timeGen();
        } while (timeGen <= j);
        return timeGen;
    }

    private long timeGen() {
        return System.currentTimeMillis();
    }

    public synchronized long nextId() {
        long timeGen;
        timeGen = timeGen();
        if (timeGen < this.lastTs) {
            timeGen = nextTs(this.lastTs);
        }
        if (timeGen == this.lastTs) {
            long j = (this.sequence + 1) & ((1 << this.sequenceBits) - 1);
            this.sequence = j;
            if (j == 0) {
                timeGen = nextTs(this.lastTs);
            }
        } else {
            this.sequence = 0L;
        }
        this.lastTs = timeGen;
        return ((timeGen - beginTs) << (this.processIdBits + this.sequenceBits)) | (this.processId << this.sequenceBits) | this.sequence;
    }
}
