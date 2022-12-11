package com.arialyy.aria.util;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import androidx.cardview.widget.RoundRectDrawableWithShadow;
import androidx.core.util.TimeUtils;
import com.arialyy.aria.core.AriaConfig;
import com.arialyy.aria.core.FtpUrlEntity;
import com.stub.StubApp;
import dalvik.system.DexFile;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.message.TokenParser;
import org.litepal.crud.LitePalSupport;

/* loaded from: classes3.dex */
public class CommonUtil {
    public static final String SERVER_CHARSET = "ISO-8859-1";
    public static final String TAG = "CommonUtil";
    public static long lastClickTime;

    public static String bytesToHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder("0x");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        char[] cArr = new char[2];
        for (byte b : bArr) {
            cArr[0] = Character.forDigit((b >>> 4) & 15, 16);
            cArr[1] = Character.forDigit(b & 15, 16);
            sb.append(cArr);
        }
        return sb.toString();
    }

    public static boolean checkMD5(String str, File file) {
        String str2;
        if (TextUtils.isEmpty(str) || file == null) {
            str2 = "MD5 string empty or updateFile null";
        } else {
            String fileMD5 = getFileMD5(file);
            if (fileMD5 != null) {
                return fileMD5.equalsIgnoreCase(str);
            }
            str2 = "calculatedDigest null";
        }
        ALog.m4191e(TAG, str2);
        return false;
    }

    public static boolean checkMD5(String str, InputStream inputStream) {
        String str2;
        if (TextUtils.isEmpty(str) || inputStream == null) {
            str2 = "MD5 string empty or updateFile null";
        } else {
            String fileMD5 = getFileMD5(inputStream);
            if (fileMD5 != null) {
                return fileMD5.equalsIgnoreCase(str);
            }
            str2 = "calculatedDigest null";
        }
        ALog.m4191e(TAG, str2);
        return false;
    }

    public static boolean checkSqlExpression(String... strArr) {
        String format;
        if (strArr.length == 0) {
            format = "sql语句表达式不能为null";
        } else {
            int i = 0;
            while (Pattern.compile("\\?").matcher(strArr[0]).find()) {
                i++;
            }
            if (i < strArr.length - 1) {
                format = String.format("条件语句的?个数不能小于参数个数，参数信息：%s", Arrays.toString(strArr));
            } else if (i <= strArr.length - 1) {
                return true;
            } else {
                format = String.format("条件语句的?个数不能大于参数个数， 参数信息：%s", Arrays.toString(strArr));
            }
        }
        ALog.m4191e(TAG, format);
        return false;
    }

    public static String convertFtpChar(String str, String str2) throws UnsupportedEncodingException {
        return new String(str2.getBytes(str), "ISO-8859-1");
    }

    public static String convertSFtpChar(String str, String str2) throws UnsupportedEncodingException {
        return new String(str2.getBytes(), str);
    }

    public static String convertUrl(String str) {
        String uri = Uri.parse(str).toString();
        if (hasDoubleCharacter(uri)) {
            uri = uri.replaceAll(StringUtils.SPACE, "%20");
            Matcher matcher = Pattern.compile(Regular.REG_DOUBLE_CHAR_AND_SPACE).matcher(uri);
            HashSet hashSet = new HashSet();
            while (matcher.find()) {
                hashSet.add(matcher.group());
            }
            try {
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    uri = uri.replaceAll(str2, URLEncoder.encode(str2, "UTF-8"));
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return uri;
    }

    public static Intent createIntent(String str, String str2) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(str);
        Uri build = builder.build();
        Intent intent = new Intent(str2);
        intent.setData(build);
        return intent;
    }

    public static String decryptBASE64(String str) {
        return new String(Base64.decode(str.getBytes(), 0));
    }

    public static String encryptBASE64(String str) {
        return Base64.encodeToString(str.getBytes(), 0);
    }

    public static String formatFileSize(double d) {
        if (d < RoundRectDrawableWithShadow.COS_45) {
            return "0kb";
        }
        double d2 = d / 1024.0d;
        if (d2 < 1.0d) {
            return d + "b";
        }
        double d3 = d2 / 1024.0d;
        if (d3 < 1.0d) {
            BigDecimal bigDecimal = new BigDecimal(Double.toString(d2));
            return bigDecimal.setScale(2, 4).toPlainString() + "kb";
        }
        double d4 = d3 / 1024.0d;
        if (d4 < 1.0d) {
            BigDecimal bigDecimal2 = new BigDecimal(Double.toString(d3));
            return bigDecimal2.setScale(2, 4).toPlainString() + "mb";
        }
        double d5 = d4 / 1024.0d;
        if (d5 < 1.0d) {
            BigDecimal bigDecimal3 = new BigDecimal(Double.toString(d4));
            return bigDecimal3.setScale(2, 4).toPlainString() + "gb";
        }
        BigDecimal bigDecimal4 = new BigDecimal(d5);
        return bigDecimal4.setScale(2, 4).toPlainString() + "tb";
    }

    public static String formatTime(int i) {
        return i <= 0 ? "00:00" : i < 60 ? String.format(Locale.getDefault(), "00:%02d", Integer.valueOf(i % 60)) : i < 3600 ? String.format(Locale.getDefault(), "%02d:%02d", Integer.valueOf(i / 60), Integer.valueOf(i % 60)) : i < 86400 ? String.format(Locale.getDefault(), "%02d:%02d:%02d", Integer.valueOf(i / TimeUtils.SECONDS_PER_HOUR), Integer.valueOf((i % TimeUtils.SECONDS_PER_HOUR) / 60), Integer.valueOf(i % 60)) : i < 604800 ? String.format(Locale.getDefault(), "%dd %02d:%02d", Integer.valueOf(i / TimeUtils.SECONDS_PER_DAY), Integer.valueOf((i % TimeUtils.SECONDS_PER_DAY) / TimeUtils.SECONDS_PER_HOUR), Integer.valueOf(i % TimeUtils.SECONDS_PER_HOUR)) : "∞";
    }

    public static List<Field> getAllFields(Class cls) {
        ArrayList arrayList = new ArrayList();
        Class superclass = cls.getSuperclass();
        if (superclass != null) {
            Class superclass2 = superclass.getSuperclass();
            if (superclass2 != null) {
                Collections.addAll(arrayList, superclass2.getDeclaredFields());
            }
            Collections.addAll(arrayList, superclass.getDeclaredFields());
        }
        Collections.addAll(arrayList, cls.getDeclaredFields());
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Field field = (Field) it.next();
            if (field.getName().equals(AriaConfig.IGNORE_CLASS_KLASS) || field.getName().equals(AriaConfig.IGNORE_CLASS_MONITOR)) {
                arrayList2.add(field);
            }
        }
        if (!arrayList2.isEmpty()) {
            arrayList.removeAll(arrayList2);
        }
        return arrayList;
    }

    public static String getAppPath(Context context) {
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            return null;
        }
        File externalFilesDir = context.getExternalFilesDir(null);
        if (externalFilesDir != null) {
            return externalFilesDir.getPath() + "/";
        }
        return Environment.getExternalStorageDirectory().getPath() + "/Android/data/" + context.getPackageName() + "/files/";
    }

    public static String getClassName(Class cls) {
        String[] split = cls.getName().split("\\.");
        return split[split.length - 1];
    }

    public static String getClassName(Object obj) {
        String[] split = obj.getClass().getName().split("\\.");
        return split[split.length - 1];
    }

    public static int getCoresNum() {
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new FileFilter() { // from class: com.arialyy.aria.util.CommonUtil.1CpuFilter
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return Pattern.matches("cpu[0-9]", file.getName());
                }
            });
            ALog.m4192d(TAG, "CPU Count: " + listFiles.length);
            return listFiles.length;
        } catch (Exception e) {
            ALog.m4192d(TAG, "CPU Count: Failed.");
            e.printStackTrace();
            return 1;
        }
    }

    public static Field getField(Class cls, String str) {
        Field field;
        try {
            try {
                field = cls.getDeclaredField(str);
            } catch (NoSuchFieldException unused) {
                if (cls.getSuperclass() == null) {
                    return null;
                }
                field = getField(cls.getSuperclass(), str);
            }
        } catch (NoSuchFieldException unused2) {
            field = cls.getField(str);
        }
        if (field != null) {
            field.setAccessible(true);
        }
        return field;
    }

    public static Field[] getFields(Class cls) {
        Class superclass;
        Field[] declaredFields = cls.getDeclaredFields();
        return (declaredFields.length != 0 || (superclass = cls.getSuperclass()) == null) ? declaredFields : getFields(superclass);
    }

    public static String getFileConfigPath(boolean z, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(AriaConfig.getInstance().getAPP().getFilesDir().getPath());
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, z ? AriaConfig.DOWNLOAD_TEMP_DIR : AriaConfig.UPLOAD_TEMP_DIR, str, ".properties");
    }

    public static String getFileMD5(File file) {
        try {
            return getFileMD5(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getFileMD5(InputStream inputStream) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(LitePalSupport.MD5);
            byte[] bArr = new byte[8192];
            while (true) {
                try {
                    try {
                        int read = inputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                    } catch (Throwable th) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        throw th;
                    }
                } catch (IOException e2) {
                    throw new RuntimeException("Unable to process file for MD5", e2);
                }
            }
            String replace = String.format("%32s", new BigInteger(1, messageDigest.digest()).toString(16)).replace(TokenParser.f4579SP, '0');
            try {
                inputStream.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            return replace;
        } catch (NoSuchAlgorithmException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static FtpUrlEntity getFtpUrlInfo(String str) {
        Uri parse = Uri.parse(str);
        String userInfo = parse.getUserInfo();
        String path = parse.getPath();
        ALog.m4192d(TAG, String.format("scheme = %s, user = %s, host = %s, port = %s, path = %s", parse.getScheme(), userInfo, parse.getHost(), Integer.valueOf(parse.getPort()), path));
        FtpUrlEntity ftpUrlEntity = new FtpUrlEntity();
        ftpUrlEntity.url = str;
        ftpUrlEntity.hostName = parse.getHost();
        ftpUrlEntity.port = parse.getPort() == -1 ? "21" : String.valueOf(parse.getPort());
        if (!TextUtils.isEmpty(userInfo)) {
            String[] split = userInfo.split(":");
            if (split.length == 2) {
                ftpUrlEntity.user = split[0];
                ftpUrlEntity.password = split[1];
            } else {
                ftpUrlEntity.user = userInfo;
            }
        }
        ftpUrlEntity.scheme = parse.getScheme();
        if (TextUtils.isEmpty(path)) {
            path = "/";
        }
        ftpUrlEntity.remotePath = path;
        return ftpUrlEntity;
    }

    public static Class getListParamType(Field field) {
        String str;
        if (!field.getType().isAssignableFrom(List.class)) {
            str = "字段类型不是List";
        } else {
            Type genericType = field.getGenericType();
            if (genericType != null) {
                if (!(genericType instanceof ParameterizedType)) {
                    return null;
                }
                return (Class) ((ParameterizedType) genericType).getActualTypeArguments()[0];
            }
            str = "该字段没有泛型参数";
        }
        ALog.m4192d(TAG, str);
        return null;
    }

    public static Class[] getMapParamType(Field field) {
        String str;
        if (!field.getType().isAssignableFrom(Map.class)) {
            str = "字段类型不是Map";
        } else {
            Type genericType = field.getGenericType();
            if (genericType != null) {
                if (!(genericType instanceof ParameterizedType)) {
                    return null;
                }
                Type[] actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments();
                return new Class[]{(Class) actualTypeArguments[0], (Class) actualTypeArguments[1]};
            }
            str = "该字段没有泛型参数";
        }
        ALog.m4192d(TAG, str);
        return null;
    }

    public static String getMd5Code(List<String> list) {
        if (list == null || list.size() < 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str);
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(LitePalSupport.MD5);
            messageDigest.update(sb.toString().getBytes());
            return new BigInteger(1, messageDigest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            ALog.m4191e(TAG, e.getMessage());
            return "";
        }
    }

    public static List<String> getPkgClassName(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        try {
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!new File(str).exists()) {
            ALog.m4185w(TAG, String.format("路径【%s】下的Dex文件不存在", str));
            return arrayList;
        }
        DexFile dexFile = new DexFile(str);
        Enumeration<String> interface12 = StubApp.interface12(dexFile);
        while (interface12.hasMoreElements()) {
            String nextElement = interface12.nextElement();
            if (nextElement.contains(str2) && nextElement.contains(str2)) {
                arrayList.add(nextElement);
            }
        }
        dexFile.close();
        return arrayList;
    }

    public static List<String> getPkgClassNames(Context context, String str) {
        ArrayList arrayList = new ArrayList();
        String packageCodePath = context.getPackageCodePath();
        File parentFile = new File(packageCodePath).getParentFile();
        if (parentFile.list() == null) {
            arrayList.addAll(getPkgClassName(packageCodePath, str));
        } else {
            String path = parentFile.getPath();
            for (String str2 : parentFile.list()) {
                String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(path, "/", str2);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.endsWith(".apk")) {
                    arrayList.addAll(getPkgClassName(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, str));
                }
            }
        }
        return arrayList;
    }

    public static String getStrMd5(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(LitePalSupport.MD5);
            messageDigest.update(str.getBytes());
            return new BigInteger(1, messageDigest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getString(String str, Context context, String str2) {
        return context.getSharedPreferences(str, 0).getString(str2, "");
    }

    public static String getThreadName(String str, int i) {
        return getStrMd5(str.concat(String.valueOf(i)));
    }

    public static String getWindowReplaceUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            ALog.m4191e(TAG, "拦截数据为null");
            return null;
        }
        Matcher matcher = Pattern.compile(Regular.REG_WINLOD_REPLACE).matcher(str);
        if (!matcher.find()) {
            return null;
        }
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(matcher.group(), -2, 9);
    }

    public static boolean hasDoubleCharacter(String str) {
        char[] charArray;
        for (char c : str.toCharArray()) {
            if ((c >= 913 && c <= 65509) || c == '\r' || c == '\n' || c == ' ') {
                return true;
            }
        }
        return false;
    }

    public static boolean isFastDoubleClick() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - lastClickTime;
        if (0 >= j || j >= 500) {
            lastClickTime = currentTimeMillis;
            return false;
        }
        ALog.m4189i(TAG, "操作太频繁了，缓一下吧～");
        return true;
    }

    public static int keyToHashCode(String str) {
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt == '-') {
                charAt = 28;
            }
            if (charAt == '\'') {
                charAt = 29;
            }
            i = (i * 33) + (charAt & 31);
        }
        return i;
    }

    public static String keyToHashKey(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(LitePalSupport.MD5);
            messageDigest.update(str.getBytes());
            return bytesToHexString(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            return String.valueOf(str.hashCode());
        }
    }

    public static Boolean putString(String str, Context context, String str2, String str3) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putString(str2, str3);
        return Boolean.valueOf(edit.commit());
    }

    public static String strCharSetConvert(String str, String str2) {
        try {
            return new String(str.getBytes(), str2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
