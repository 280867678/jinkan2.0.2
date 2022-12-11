package okhttp3;

import com.arialyy.aria.core.inf.IOptionConstant;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.collections.EmptyList;
import me.tvspark.ef0;
import me.tvspark.fj0;
import me.tvspark.gi0;
import me.tvspark.ii0;
import me.tvspark.mi0;
import me.tvspark.nk0;
import me.tvspark.outline;
import me.tvspark.pi0;
import me.tvspark.r40;
import me.tvspark.zi0;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;

@ef0
/* loaded from: classes4.dex */
public final class Headers implements Iterable<Pair<? extends String, ? extends String>>, pi0 {
    public static final Companion Companion = new Companion(null);
    public final String[] namesAndValues;

    @ef0
    /* loaded from: classes4.dex */
    public static final class Builder {
        public final List<String> namesAndValues = new ArrayList(20);

        public final Builder add(String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "line");
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) str, ':', 0, false, 6);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != -1) {
                String substring = str.substring(0, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String obj = nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(substring).toString();
                String substring2 = str.substring(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1);
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) substring2, "(this as java.lang.String).substring(startIndex)");
                add(obj, substring2);
                return this;
            }
            throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unexpected header: ", str).toString());
        }

        public final Builder add(String str, String str2) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "name");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, "value");
            Headers.Companion.checkName(str);
            Headers.Companion.checkValue(str2, str);
            addLenient$okhttp(str, str2);
            return this;
        }

        public final Builder add(String str, Instant instant) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "name");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(instant, "value");
            add(str, new Date(instant.toEpochMilli()));
            return this;
        }

        public final Builder add(String str, Date date) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "name");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(date, "value");
            add(str, DatesKt.toHttpDateString(date));
            return this;
        }

        public final Builder addAll(Headers headers) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(headers, IOptionConstant.headers);
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                addLenient$okhttp(headers.name(i), headers.value(i));
            }
            return this;
        }

        public final Builder addLenient$okhttp(String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "line");
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) str, ':', 1, false, 4);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != -1) {
                String substring = str.substring(0, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String substring2 = str.substring(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1);
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) substring2, "(this as java.lang.String).substring(startIndex)");
                addLenient$okhttp(substring, substring2);
            } else {
                if (str.charAt(0) == ':') {
                    str = str.substring(1);
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str, "(this as java.lang.String).substring(startIndex)");
                }
                addLenient$okhttp("", str);
            }
            return this;
        }

        public final Builder addLenient$okhttp(String str, String str2) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "name");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, "value");
            this.namesAndValues.add(str);
            this.namesAndValues.add(nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2).toString());
            return this;
        }

        public final Builder addUnsafeNonAscii(String str, String str2) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "name");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, "value");
            Headers.Companion.checkName(str);
            addLenient$okhttp(str, str2);
            return this;
        }

        public final Headers build() {
            List<String> list = this.namesAndValues;
            if (list != null) {
                Object[] array = list.toArray(new String[0]);
                if (array == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                return new Headers((String[]) array, null);
            }
            throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
        }

        public final String get(String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "name");
            zi0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = fj0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fj0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.namesAndValues.size() - 2, 0), 2);
            int i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
            int i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
            int i3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww;
            if (i3 >= 0) {
                if (i > i2) {
                    return null;
                }
            } else if (i < i2) {
                return null;
            }
            while (!nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, this.namesAndValues.get(i), true)) {
                if (i == i2) {
                    return null;
                }
                i += i3;
            }
            return this.namesAndValues.get(i + 1);
        }

        public final List<String> getNamesAndValues$okhttp() {
            return this.namesAndValues;
        }

        public final Builder removeAll(String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "name");
            int i = 0;
            while (i < this.namesAndValues.size()) {
                if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, this.namesAndValues.get(i), true)) {
                    this.namesAndValues.remove(i);
                    this.namesAndValues.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        public final Builder set(String str, String str2) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "name");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, "value");
            Headers.Companion.checkName(str);
            Headers.Companion.checkValue(str2, str);
            removeAll(str);
            addLenient$okhttp(str, str2);
            return this;
        }

        public final Builder set(String str, Instant instant) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "name");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(instant, "value");
            return set(str, new Date(instant.toEpochMilli()));
        }

        public final Builder set(String str, Date date) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "name");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(date, "value");
            set(str, DatesKt.toHttpDateString(date));
            return this;
        }
    }

    @ef0
    /* loaded from: classes4.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(gi0 gi0Var) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void checkName(String str) {
            if (str.length() > 0) {
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    char charAt = str.charAt(i);
                    if (!('!' <= charAt && '~' >= charAt)) {
                        throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str).toString());
                    }
                }
                return;
            }
            throw new IllegalArgumentException("name is empty".toString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void checkValue(String str, String str2) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (!(charAt == '\t' || (' ' <= charAt && '~' >= charAt))) {
                    throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt), Integer.valueOf(i), str2, str).toString());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String get(String[] strArr, String str) {
            zi0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = fj0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fj0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(strArr.length - 2, 0), 2);
            int i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
            int i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
            int i3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww;
            if (i3 >= 0) {
                if (i > i2) {
                    return null;
                }
            } else if (i < i2) {
                return null;
            }
            while (!nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, strArr[i], true)) {
                if (i == i2) {
                    return null;
                }
                i += i3;
            }
            return strArr[i + 1];
        }

        /* renamed from: -deprecated_of  reason: not valid java name */
        public final Headers m5025deprecated_of(Map<String, String> map) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(map, IOptionConstant.headers);
            return m54of(map);
        }

        /* renamed from: -deprecated_of  reason: not valid java name */
        public final Headers m5026deprecated_of(String... strArr) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(strArr, "namesAndValues");
            return m53of((String[]) Arrays.copyOf(strArr, strArr.length));
        }

        /* renamed from: of */
        public final Headers m54of(Map<String, String> map) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(map, "$this$toHeaders");
            String[] strArr = new String[map.size() * 2];
            int i = 0;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (key == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                String obj = nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(key).toString();
                if (value == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                String obj2 = nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(value).toString();
                checkName(obj);
                checkValue(obj2, obj);
                strArr[i] = obj;
                strArr[i + 1] = obj2;
                i += 2;
            }
            return new Headers(strArr, null);
        }

        /* renamed from: of */
        public final Headers m53of(String... strArr) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(strArr, "namesAndValues");
            if (strArr.length % 2 == 0) {
                Object clone = strArr.clone();
                if (clone == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                }
                String[] strArr2 = (String[]) clone;
                int length = strArr2.length;
                for (int i = 0; i < length; i++) {
                    if (!(strArr2[i] != null)) {
                        throw new IllegalArgumentException("Headers cannot be null".toString());
                    }
                    String str = strArr2[i];
                    if (str == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                    strArr2[i] = nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str).toString();
                }
                zi0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = fj0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fj0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, strArr2.length), 2);
                int i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
                int i3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww;
                int i4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww;
                if (i4 < 0 ? i2 >= i3 : i2 <= i3) {
                    while (true) {
                        String str2 = strArr2[i2];
                        String str3 = strArr2[i2 + 1];
                        checkName(str2);
                        checkValue(str3, str2);
                        if (i2 == i3) {
                            break;
                        }
                        i2 += i4;
                    }
                }
                return new Headers(strArr2, null);
            }
            throw new IllegalArgumentException("Expected alternating header names and values".toString());
        }
    }

    public Headers(String[] strArr) {
        this.namesAndValues = strArr;
    }

    public /* synthetic */ Headers(String[] strArr, gi0 gi0Var) {
        this(strArr);
    }

    /* renamed from: of */
    public static final Headers m56of(Map<String, String> map) {
        return Companion.m54of(map);
    }

    /* renamed from: of */
    public static final Headers m55of(String... strArr) {
        return Companion.m53of(strArr);
    }

    /* renamed from: -deprecated_size  reason: not valid java name */
    public final int m5024deprecated_size() {
        return size();
    }

    public final long byteCount() {
        String[] strArr = this.namesAndValues;
        long length = strArr.length * 2;
        for (int i = 0; i < strArr.length; i++) {
            length += this.namesAndValues[i].length();
        }
        return length;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Headers) && Arrays.equals(this.namesAndValues, ((Headers) obj).namesAndValues);
    }

    public final String get(String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "name");
        return Companion.get(this.namesAndValues, str);
    }

    public final Date getDate(String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "name");
        String str2 = get(str);
        if (str2 != null) {
            return DatesKt.toHttpDateOrNull(str2);
        }
        return null;
    }

    public final Instant getInstant(String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "name");
        Date date = getDate(str);
        if (date != null) {
            return date.toInstant();
        }
        return null;
    }

    public int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    @Override // java.lang.Iterable
    public Iterator<Pair<? extends String, ? extends String>> iterator() {
        int size = size();
        Pair[] pairArr = new Pair[size];
        for (int i = 0; i < size; i++) {
            pairArr[i] = new Pair(name(i), value(i));
        }
        return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object[]) pairArr);
    }

    public final String name(int i) {
        return this.namesAndValues[i * 2];
    }

    public final Set<String> names() {
        TreeSet treeSet = new TreeSet(nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mi0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        int size = size();
        for (int i = 0; i < size; i++) {
            treeSet.add(name(i));
        }
        Set<String> unmodifiableSet = Collections.unmodifiableSet(treeSet);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) unmodifiableSet, "Collections.unmodifiableSet(result)");
        return unmodifiableSet;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        List<String> namesAndValues$okhttp = builder.getNamesAndValues$okhttp();
        String[] strArr = this.namesAndValues;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(namesAndValues$okhttp, "$this$addAll");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(strArr, "elements");
        namesAndValues$okhttp.addAll(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object[]) strArr));
        return builder;
    }

    public final int size() {
        return this.namesAndValues.length / 2;
    }

    public final Map<String, List<String>> toMultimap() {
        TreeMap treeMap = new TreeMap(nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mi0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        int size = size();
        for (int i = 0; i < size; i++) {
            String name = name(i);
            Locale locale = Locale.US;
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) locale, "Locale.US");
            if (name == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = name.toLowerCase(locale);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            List list = (List) treeMap.get(lowerCase);
            if (list == null) {
                list = new ArrayList(2);
                treeMap.put(lowerCase, list);
            }
            list.add(value(i));
        }
        return treeMap;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        for (int i = 0; i < size; i++) {
            sb.append(name(i));
            sb.append(": ");
            sb.append(value(i));
            sb.append("\n");
        }
        String sb2 = sb.toString();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final String value(int i) {
        return this.namesAndValues[(i * 2) + 1];
    }

    public final List<String> values(String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "name");
        int size = size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, name(i), true)) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(value(i));
            }
        }
        if (arrayList != null) {
            List<String> unmodifiableList = Collections.unmodifiableList(arrayList);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) unmodifiableList, "Collections.unmodifiableList(result)");
            return unmodifiableList;
        }
        return EmptyList.INSTANCE;
    }
}
