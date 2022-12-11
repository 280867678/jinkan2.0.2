package com.bumptech.glide.load.resource.bitmap;

import me.tvspark.Illlllllllllllllllllllllll;

/* loaded from: classes3.dex */
public abstract class DownsampleStrategy {
    public static final Illlllllllllllllllllllllll<DownsampleStrategy> Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final DownsampleStrategy Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final DownsampleStrategy Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public static final DownsampleStrategy Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public static final DownsampleStrategy Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public static final DownsampleStrategy Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public static final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwww = true;

    /* loaded from: classes3.dex */
    public enum SampleSizeRounding {
        MEMORY,
        QUALITY
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DownsampleStrategy {
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3, int i4) {
            return 1.0f;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.QUALITY;
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DownsampleStrategy {
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3, int i4) {
            if (DownsampleStrategy.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                return Math.min(i3 / i, i4 / i2);
            }
            int max = Math.max(i2 / i4, i / i3);
            if (max != 0) {
                return 1.0f / Integer.highestOneBit(max);
            }
            return 1.0f;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3, int i4) {
            return DownsampleStrategy.Wwwwwwwwwwwwwwwwwwwwwwwwwwww ? SampleSizeRounding.QUALITY : SampleSizeRounding.MEMORY;
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DownsampleStrategy {
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3, int i4) {
            return Math.max(i3 / i, i4 / i2);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.QUALITY;
        }
    }

    /* loaded from: classes3.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DownsampleStrategy {
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3, int i4) {
            return Math.min(1.0f, DownsampleStrategy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2, i3, i4));
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3, int i4) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2, i3, i4) == 1.0f ? SampleSizeRounding.QUALITY : DownsampleStrategy.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2, i3, i4);
        }
    }

    static {
        DownsampleStrategy downsampleStrategy = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = downsampleStrategy;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illlllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", downsampleStrategy);
    }

    public abstract float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3, int i4);

    public abstract SampleSizeRounding Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3, int i4);
}
