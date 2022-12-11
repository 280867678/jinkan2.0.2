package com.umeng.analytics;

import java.util.Locale;

/* loaded from: classes4.dex */
public enum Gender {
    Male(1) { // from class: com.umeng.analytics.Gender.1
        @Override // java.lang.Enum
        public String toString() {
            return String.format(Locale.US, "Male:%d", Integer.valueOf(this.value));
        }
    },
    Female(2) { // from class: com.umeng.analytics.Gender.2
        @Override // java.lang.Enum
        public String toString() {
            return String.format(Locale.US, "Female:%d", Integer.valueOf(this.value));
        }
    },
    Unknown(0) { // from class: com.umeng.analytics.Gender.3
        @Override // java.lang.Enum
        public String toString() {
            return String.format(Locale.US, "Unknown:%d", Integer.valueOf(this.value));
        }
    };
    
    public int value;

    /* renamed from: com.umeng.analytics.Gender$4 */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class C15154 {

        /* renamed from: a */
        public static final /* synthetic */ int[] f2848a;

        static {
            int[] iArr = new int[Gender.values().length];
            f2848a = iArr;
            try {
                Gender gender = Gender.Male;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = f2848a;
                Gender gender2 = Gender.Female;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = f2848a;
                Gender gender3 = Gender.Unknown;
                iArr3[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    Gender(int i) {
        this.value = i;
    }

    public static Gender getGender(int i) {
        return i != 1 ? i != 2 ? Unknown : Female : Male;
    }

    public static com.umeng.commonsdk.statistics.proto.Gender transGender(Gender gender) {
        int i = C15154.f2848a[gender.ordinal()];
        return i != 1 ? i != 2 ? com.umeng.commonsdk.statistics.proto.Gender.UNKNOWN : com.umeng.commonsdk.statistics.proto.Gender.FEMALE : com.umeng.commonsdk.statistics.proto.Gender.MALE;
    }

    public int value() {
        return this.value;
    }
}
