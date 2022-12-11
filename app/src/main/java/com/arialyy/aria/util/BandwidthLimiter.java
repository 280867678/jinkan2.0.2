package com.arialyy.aria.util;

import org.apache.commons.lang3.time.StopWatch;

/* loaded from: classes3.dex */
public class BandwidthLimiter {
    public static int maxBandWith = 2048;
    public int bytesWillBeSentOrReceive = 0;
    public long lastPieceSentOrReceiveTick = System.nanoTime();
    public int maxRate = 1024;
    public long timeCostPerChunk = (CHUNK_LENGTH.longValue() * 1000000000) / (f166KB.longValue() * this.maxRate);

    /* renamed from: KB */
    public static Long f166KB = 1024L;
    public static Long CHUNK_LENGTH = 1024L;

    public BandwidthLimiter(int i, int i2) {
        setMaxRate(i2 > 1 ? i / i2 : i);
    }

    public synchronized void limitNextBytes() {
        limitNextBytes(1);
    }

    public synchronized void limitNextBytes(int i) {
        this.bytesWillBeSentOrReceive += i;
        while (!Thread.currentThread().isInterrupted() && this.bytesWillBeSentOrReceive > CHUNK_LENGTH.longValue()) {
            long nanoTime = System.nanoTime();
            long j = this.timeCostPerChunk - (nanoTime - this.lastPieceSentOrReceiveTick);
            int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i2 > 0) {
                try {
                    Thread.currentThread();
                    Thread.sleep(j / StopWatch.NANO_2_MILLIS, (int) (j % StopWatch.NANO_2_MILLIS));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.bytesWillBeSentOrReceive = (int) (this.bytesWillBeSentOrReceive - CHUNK_LENGTH.longValue());
            if (i2 <= 0) {
                j = 0;
            }
            this.lastPieceSentOrReceiveTick = nanoTime + j;
        }
    }

    public synchronized void setMaxRate(int i) throws IllegalArgumentException {
        if (i < 0) {
            throw new IllegalArgumentException("maxRate can not less than 0");
        }
        this.maxRate = i;
        if (i == 0) {
            this.timeCostPerChunk = 0L;
        } else {
            this.timeCostPerChunk = (CHUNK_LENGTH.longValue() * 1000000000) / (this.maxRate * f166KB.longValue());
        }
    }
}
