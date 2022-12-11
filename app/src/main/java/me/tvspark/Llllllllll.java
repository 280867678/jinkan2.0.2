package me.tvspark;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

/* loaded from: classes4.dex */
public final class Llllllllll implements Llllllllllll {
    public volatile Map<String, String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Map<String, List<Lllllllllll>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Lllllllllll {
        @NonNull
        public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull String str) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
        }

        @Override // me.tvspark.Lllllllllll
        public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            return false;
        }

        public int hashCode() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode();
        }

        public String toString() {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("StringHeaderFactory{value='");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(ExtendedMessageFormat.QUOTE);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append('}');
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
    }

    public Llllllllll(Map<String, List<Lllllllllll>> map) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Collections.unmodifiableMap(map);
    }

    public final Map<String, String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<Lllllllllll>> entry : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.entrySet()) {
            List<Lllllllllll> value = entry.getValue();
            StringBuilder sb = new StringBuilder();
            int size = value.size();
            for (int i = 0; i < size; i++) {
                String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = value.get(i).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                if (!TextUtils.isEmpty(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2)) {
                    sb.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                    if (i != value.size() - 1) {
                        sb.append(',');
                    }
                }
            }
            String sb2 = sb.toString();
            if (!TextUtils.isEmpty(sb2)) {
                hashMap.put(entry.getKey(), sb2);
            }
        }
        return hashMap;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Llllllllll) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(((Llllllllll) obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        return false;
    }

    @Override // me.tvspark.Llllllllllll
    public Map<String, String> getHeaders() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            synchronized (this) {
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Collections.unmodifiableMap(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                }
            }
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public int hashCode() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode();
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("LazyHeaders{headers=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append('}');
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public static final Map<String, List<Lllllllllll>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public static final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        public Map<String, List<Lllllllllll>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;

        static {
            String property = System.getProperty("http.agent");
            if (!TextUtils.isEmpty(property)) {
                int length = property.length();
                StringBuilder sb = new StringBuilder(property.length());
                for (int i = 0; i < length; i++) {
                    char charAt = property.charAt(i);
                    if ((charAt <= 31 && charAt != '\t') || charAt >= 127) {
                        charAt = '?';
                    }
                    sb.append(charAt);
                }
                property = sb.toString();
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = property;
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                hashMap.put("User-Agent", Collections.singletonList(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)));
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Collections.unmodifiableMap(hashMap);
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull String str, @NonNull String str2) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2);
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && "User-Agent".equalsIgnoreCase(str)) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                List<Lllllllllll> list = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(str, list);
                }
                list.clear();
                list.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && "User-Agent".equalsIgnoreCase(str)) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
                }
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                List<Lllllllllll> list2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(str);
                if (list2 == null) {
                    list2 = new ArrayList<>();
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(str, list2);
                }
                list2.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            return this;
        }

        public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
                HashMap hashMap = new HashMap(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size());
                for (Map.Entry<String, List<Lllllllllll>> entry : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.entrySet()) {
                    hashMap.put(entry.getKey(), new ArrayList(entry.getValue()));
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = hashMap;
            }
        }
    }
}
