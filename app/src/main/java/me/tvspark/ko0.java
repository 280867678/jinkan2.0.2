package me.tvspark;

import android.net.Uri;
import android.os.Debug;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class ko0 {
    public static Pattern Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Pattern.compile("\\s+");
    public Pattern Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public HashMap<String, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new HashMap<>();
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
    public StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new StringBuilder();
    public int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new int[50];

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public HashSet<String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public Pattern Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public ArrayList<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public ArrayList<String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public Pattern Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public ko0(File file) {
        String readLine;
        if (file == null) {
            return;
        }
        System.currentTimeMillis();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (!file2.getName().endsWith(".tmp")) {
                    file2.getName();
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new FileReader(file2));
                        while (true) {
                            readLine = bufferedReader.readLine();
                            if (readLine == null || !readLine.isEmpty()) {
                                break;
                            }
                        }
                        if (readLine != null) {
                            if (readLine.startsWith("[")) {
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bufferedReader);
                            } else {
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(readLine, bufferedReader);
                            }
                        }
                    } catch (IOException unused) {
                        file2.getName();
                    }
                }
            }
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length() > 0) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Pattern.compile(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.substring(1));
        }
        Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
        Debug.getMemoryInfo(memoryInfo);
        System.currentTimeMillis();
        Arrays.toString(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        memoryInfo.getTotalPss();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        boolean z;
        String str2;
        int length = str.length();
        if (str.endsWith("|")) {
            length--;
            z = true;
        } else {
            z = false;
        }
        StringBuilder sb = new StringBuilder(length + 32);
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt != '$' && charAt != '.' && charAt != '?') {
                switch (charAt) {
                    case '(':
                    case ')':
                    case '+':
                        break;
                    case '*':
                        str2 = ".*?";
                        sb.append(str2);
                        break;
                    default:
                        switch (charAt) {
                            case '[':
                            case '\\':
                            case ']':
                                break;
                            case '^':
                                str2 = "(?:[^\\w\\d_\\-.%]|$)";
                                sb.append(str2);
                                break;
                            default:
                                switch (charAt) {
                                }
                                sb.append(charAt);
                                break;
                        }
                }
            }
            sb.append('\\');
            sb.append(charAt);
        }
        if (z) {
            sb.append('$');
        }
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x012b, code lost:
        r13.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        r13.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0142, code lost:
        r15 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x014e, code lost:
        if (r15 != false) goto L60;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0153 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0154 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri uri, String str) {
        boolean z;
        boolean z2;
        String host;
        String sb;
        String host2 = uri.getHost();
        while (true) {
            int i = 46;
            int indexOf = host2.indexOf(46);
            boolean z3 = false;
            if (indexOf != -1) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(host2);
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    if (!wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null && wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                            z = false;
                        } else {
                            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size() == 1) {
                                    String str2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(0);
                                    if (str2.equals("/") || str2.equals("^")) {
                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                                    } else {
                                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("^");
                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2));
                                        sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
                                    }
                                } else {
                                    StringBuilder sb2 = new StringBuilder("^(?:");
                                    sb2.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(0)));
                                    for (int i2 = 1; i2 < wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size(); i2++) {
                                        sb2.append('|');
                                        sb2.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i2)));
                                    }
                                    sb2.append(')');
                                    sb = sb2.toString();
                                }
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Pattern.compile(sb);
                                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                            }
                            z = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.matcher(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uri)).find();
                        }
                        if (!z) {
                            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null && (host = Uri.parse(str).getHost()) != null && !str.isEmpty()) {
                                Iterator<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> it = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.iterator();
                                String str3 = null;
                                while (it.hasNext()) {
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww next = it.next();
                                    while (true) {
                                        int indexOf2 = host.indexOf(i);
                                        if (indexOf2 != -1) {
                                            boolean contains = next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.contains(host);
                                            z2 = next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                            if (contains != z2) {
                                                if (next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                                                    break;
                                                }
                                                if (next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                                                    if (next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals("/") || next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals("^")) {
                                                        break;
                                                    }
                                                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("^");
                                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                                                    next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Pattern.compile(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
                                                }
                                                if (str3 == null) {
                                                    str3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uri);
                                                }
                                                if (next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.matcher(str3).find()) {
                                                    break;
                                                }
                                            }
                                            host = host.substring(indexOf2 + 1);
                                            i = 46;
                                        }
                                    }
                                }
                            }
                            z2 = false;
                        }
                        z3 = true;
                        if (!z3) {
                            return true;
                        }
                    }
                    z = true;
                    if (!z) {
                    }
                    z3 = true;
                    if (!z3) {
                    }
                }
                host2 = host2.substring(indexOf + 1);
            } else {
                return false;
            }
        }
    }

    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri uri) {
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery == null) {
            return uri.getEncodedPath();
        }
        return uri.getEncodedPath() + "?" + encodedQuery;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00f0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0000 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(BufferedReader bufferedReader) throws IOException {
        boolean z;
        int indexOf;
        int indexOf2;
        String substring;
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                bufferedReader.close();
                return;
            }
            boolean z2 = true;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
            if (!readLine.isEmpty()) {
                if (readLine.startsWith("!")) {
                    int[] iArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    iArr[1] = iArr[1] + 1;
                } else if (readLine.contains("##") || readLine.contains("#@#") || readLine.contains("#?#")) {
                    int[] iArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    iArr2[2] = iArr2[2] + 1;
                } else if (readLine.startsWith("@@")) {
                    int[] iArr3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    iArr3[4] = iArr3[4] + 1;
                } else if (readLine.startsWith("||")) {
                    int[] iArr4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    iArr4[3] = iArr4[3] + 1;
                    int indexOf3 = readLine.indexOf(36);
                    HashSet<String> hashSet = null;
                    if (indexOf3 != -1) {
                        int i = indexOf3 + 1;
                        int indexOf4 = readLine.indexOf("domain=", i);
                        if (indexOf4 != -1) {
                            String[] split = readLine.substring(indexOf4 + 7).split("\\|");
                            z = split.length > 0 && split[0].startsWith("~");
                            HashSet<String> hashSet2 = new HashSet<>(split.length);
                            for (String str : split) {
                                if (str.startsWith("~")) {
                                    str = str.substring(1);
                                }
                                hashSet2.add(str);
                            }
                            hashSet = hashSet2;
                            String substring2 = indexOf3 != -1 ? readLine.substring(2) : readLine.substring(2, indexOf3);
                            indexOf = substring2.indexOf(94);
                            if (indexOf == -1) {
                                indexOf = substring2.length();
                            }
                            indexOf2 = substring2.indexOf(47);
                            if (indexOf2 == -1) {
                                indexOf2 = substring2.length();
                            }
                            substring = substring2.substring(0, Math.min(indexOf, indexOf2));
                            if (substring.indexOf(42) == -1) {
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(substring);
                                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(substring, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                }
                                String substring3 = substring2.substring(Math.min(indexOf, indexOf2));
                                if (hashSet == null) {
                                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList<>();
                                    }
                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(substring3);
                                } else {
                                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = substring3;
                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = hashSet;
                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
                                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList<>();
                                    }
                                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                }
                            }
                        } else if ("object".equals(readLine.substring(i))) {
                        }
                    }
                    z = false;
                    if (indexOf3 != -1) {
                    }
                    indexOf = substring2.indexOf(94);
                    if (indexOf == -1) {
                    }
                    indexOf2 = substring2.indexOf(47);
                    if (indexOf2 == -1) {
                    }
                    substring = substring2.substring(0, Math.min(indexOf, indexOf2));
                    if (substring.indexOf(42) == -1) {
                    }
                } else {
                    int[] iArr5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    iArr5[0] = iArr5[0] + 1;
                    if (readLine.indexOf(36) == -1) {
                        int[] iArr6 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        iArr6[6] = iArr6[6] + 1;
                        if (readLine.startsWith("|")) {
                            readLine = readLine.substring(1);
                        } else {
                            z2 = false;
                        }
                        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(readLine);
                        if (z2) {
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("^", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                        }
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append('|');
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                    }
                }
            }
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(str);
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(str, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList<>();
        }
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add("/");
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, BufferedReader bufferedReader) throws IOException {
        while (str != null) {
            if (!str.isEmpty() && !str.startsWith("#")) {
                String[] split = Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.split(str);
                if (split.length == 1) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(split[0]);
                } else {
                    for (int i = 1; i < split.length; i++) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(split[i]);
                    }
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
                int[] iArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                iArr[5] = iArr[5] + 1;
            }
            str = bufferedReader.readLine();
        }
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri uri, String str) {
        boolean z;
        try {
            if (!"http".equals(uri.getScheme()) && !"https".equals(uri.getScheme())) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uri, str);
            long currentTimeMillis2 = System.currentTimeMillis();
            long currentTimeMillis3 = System.currentTimeMillis();
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 && (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null || !this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.matcher(uri.toString()).find())) {
                z = false;
                long currentTimeMillis4 = System.currentTimeMillis();
                String str2 = "RES: " + z + "," + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 + "    MATCH TIME: " + (currentTimeMillis4 - currentTimeMillis3) + ", TIME2: " + (currentTimeMillis2 - currentTimeMillis) + ", url: " + uri;
                return z | Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            }
            z = true;
            long currentTimeMillis42 = System.currentTimeMillis();
            String str22 = "RES: " + z + "," + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 + "    MATCH TIME: " + (currentTimeMillis42 - currentTimeMillis3) + ", TIME2: " + (currentTimeMillis2 - currentTimeMillis) + ", url: " + uri;
            return z | Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
