package me.tvspark;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;

/* loaded from: classes4.dex */
public abstract class IIll {
    public static final IIll Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public static final IIll Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public static final IIll Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends IIll {
        @Override // me.tvspark.IIll
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return true;
        }

        @Override // me.tvspark.IIll
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return true;
        }

        @Override // me.tvspark.IIll
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DataSource dataSource) {
            return dataSource == DataSource.REMOTE;
        }

        @Override // me.tvspark.IIll
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return ((z && dataSource == DataSource.DATA_DISK_CACHE) || dataSource == DataSource.LOCAL) && encodeStrategy == EncodeStrategy.TRANSFORMED;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends IIll {
        @Override // me.tvspark.IIll
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return false;
        }

        @Override // me.tvspark.IIll
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return true;
        }

        @Override // me.tvspark.IIll
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DataSource dataSource) {
            return (dataSource == DataSource.DATA_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }

        @Override // me.tvspark.IIll
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends IIll {
        @Override // me.tvspark.IIll
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return false;
        }

        @Override // me.tvspark.IIll
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return false;
        }

        @Override // me.tvspark.IIll
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DataSource dataSource) {
            return false;
        }

        @Override // me.tvspark.IIll
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }
    }

    public abstract boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    public abstract boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    public abstract boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DataSource dataSource);

    public abstract boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy);
}
