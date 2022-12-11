package me.tvspark;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* renamed from: me.tvspark.m3 */
/* loaded from: classes4.dex */
public final class C2356m3 {
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2393n3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.m3$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        @Nullable
        public final Object Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        @Nullable
        public final Uri Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final List<Object> Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        @Nullable
        public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final List<C2820yd> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        @Nullable
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        @Nullable
        public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final Uri Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri uri, String str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, List list, String str2, List list2, Uri uri2, Object obj, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = uri;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = list;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = list2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = uri2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = obj;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                return false;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj;
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, (Object) wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, (Object) wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) && C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) && C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        public int hashCode() {
            int hashCode = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode() * 31;
            String str = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int hashCode3 = (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode() + ((hashCode2 + (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null ? 0 : wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode())) * 31)) * 31;
            String str2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int hashCode4 = (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode() + ((hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31)) * 31;
            Uri uri = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int hashCode5 = (hashCode4 + (uri == null ? 0 : uri.hashCode())) * 31;
            Object obj = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (obj != null) {
                i = obj.hashCode();
            }
            return hashCode5 + i;
        }
    }

    /* renamed from: me.tvspark.m3$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        @Nullable
        public final byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final List<Integer> Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final Map<String, String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        @Nullable
        public final Uri Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final UUID Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(UUID uuid, Uri uri, Map map, boolean z, boolean z2, boolean z3, List list, byte[] bArr, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = uuid;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = uri;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = map;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = z2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z3;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = list;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                return false;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj;
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) && Arrays.equals(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        public int hashCode() {
            int hashCode = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode() * 31;
            Uri uri = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int hashCode2 = uri != null ? uri.hashCode() : 0;
            int hashCode3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode();
            return Arrays.hashCode(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww) + ((this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode() + ((((((((hashCode3 + ((hashCode + hashCode2) * 31)) * 31) + (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ? 1 : 0)) * 31) + (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww ? 1 : 0)) * 31) + (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww ? 1 : 0)) * 31)) * 31);
        }
    }

    /* renamed from: me.tvspark.m3$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2, boolean z, boolean z2, boolean z3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z3;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                return false;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj;
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        public int hashCode() {
            return ((((((Long.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).hashCode() + (Long.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).hashCode() * 31)) * 31) + (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ? 1 : 0)) * 31) + (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww ? 1 : 0)) * 31) + (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww ? 1 : 0);
        }
    }

    /* renamed from: me.tvspark.m3$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        @Nullable
        public C2393n3 Wwwwwwwwwwwww;
        @Nullable
        public Object Wwwwwwwwwwwwww;
        @Nullable
        public Uri Wwwwwwwwwwwwwww;
        public List<Object> Wwwwwwwwwwwwwwww;
        @Nullable
        public String Wwwwwwwwwwwwwwwww;
        public List<C2820yd> Wwwwwwwwwwwwwwwwww;
        @Nullable
        public byte[] Wwwwwwwwwwwwwwwwwww;
        public List<Integer> Wwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwww;
        @Nullable
        public UUID Wwwwwwwwwwwwwwwwwwwwwwww;
        public Map<String, String> Wwwwwwwwwwwwwwwwwwwwwwwww;
        @Nullable
        public Uri Wwwwwwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        @Nullable
        public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        @Nullable
        public Uri Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        @Nullable
        public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Long.MIN_VALUE;
            this.Wwwwwwwwwwwwwwwwwwww = Collections.emptyList();
            this.Wwwwwwwwwwwwwwwwwwwwwwwww = Collections.emptyMap();
            this.Wwwwwwwwwwwwwwwwww = Collections.emptyList();
            this.Wwwwwwwwwwwwwwww = Collections.emptyList();
        }

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2356m3 c2356m3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2356m3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2356m3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwww = c2356m3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2356m3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                this.Wwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                    return;
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                byte[] bArr = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwww = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable List<C2820yd> list) {
            this.Wwwwwwwwwwwwwwwwww = (list == null || list.isEmpty()) ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(list));
            return this;
        }

        public C2356m3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwww == null || this.Wwwwwwwwwwwwwwwwwwwwwwww != null);
            Uri uri = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (uri != null) {
                String str = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                UUID uuid = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uri, str, uuid != null ? new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uuid, this.Wwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwww, null) : null, this.Wwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwww, this.Wwwwwwwwwwwwww, null);
                String str2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (str2 == null) {
                    str2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str2;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            } else {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            }
            String str3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str3);
            String str4 = str3;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwww, null);
            C2393n3 c2393n3 = this.Wwwwwwwwwwwww;
            if (c2393n3 == null) {
                c2393n3 = new C2393n3(null, null);
            }
            return new C2356m3(str4, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2393n3, null);
        }
    }

    public /* synthetic */ C2356m3(String str, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, C2393n3 c2393n3, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2393n3;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2356m3)) {
            return false;
        }
        C2356m3 c2356m3 = (C2356m3) obj;
        return C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, (Object) c2356m3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(c2356m3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2356m3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2356m3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public int hashCode() {
        int hashCode = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode() * 31;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int hashCode2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null ? wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode() : 0;
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode() + ((this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode() + ((hashCode + hashCode2) * 31)) * 31);
    }
}
