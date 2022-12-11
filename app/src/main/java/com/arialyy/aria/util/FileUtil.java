package com.arialyy.aria.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.text.TextUtils;
import androidx.appcompat.widget.ActivityChooserModel;
import com.arialyy.aria.core.AriaConfig;
import com.umeng.analytics.pro.C1648o;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.Pattern;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;
import org.litepal.parser.LitePalParser;

/* loaded from: classes3.dex */
public class FileUtil {
    public static final Pattern DIR_SEPORATOR = Pattern.compile("/");
    public static final String EXTERNAL_STORAGE_PATH = Environment.getExternalStorageDirectory().getPath();
    public static final String TAG = "FileUtil";

    public static boolean canWrite(String str) {
        File file;
        boolean z = true;
        if (new File(str).canWrite()) {
            return true;
        }
        File file2 = null;
        try {
            try {
                try {
                    file = new File(str, "tw.txt");
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e) {
                e = e;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(1);
            fileWriter.close();
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e3) {
            e = e3;
            file2 = file;
            e.printStackTrace();
            z = false;
            if (file2 != null) {
                if (file2.exists()) {
                    file2.delete();
                }
            }
            return z;
        } catch (Throwable th2) {
            th = th2;
            file2 = file;
            if (file2 != null) {
                try {
                    if (file2.exists()) {
                        file2.delete();
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
        return z;
    }

    public static boolean checkMemorySpace(String str, long j) {
        File file = new File(str);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                createDir(file.getParentFile().getPath());
            }
            str = file.getParentFile().getPath();
        }
        StatFs statFs = new StatFs(str);
        return j <= ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }

    @Deprecated
    public static boolean checkSDMemorySpace(String str, long j) {
        List<String> sDPathList = getSDPathList(AriaConfig.getInstance().getAPP());
        if (sDPathList != null && !sDPathList.isEmpty()) {
            for (String str2 : sDPathList) {
                if (str.contains(str2) && j > 0 && j > getAvailableExternalMemorySize(str2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static List<String> compareMountsWithVold(List<String> list, List<String> list2) {
        for (int size = list.size() - 1; size >= 0; size--) {
            String str = list.get(size);
            File file = new File(str);
            if (!file.exists() || !file.isDirectory() || !file.canWrite() || (list2 != null && !list2.contains(str))) {
                list.remove(size);
            }
        }
        if (list2 != null) {
            list2.clear();
        }
        return list;
    }

    public static boolean createDir(String str) {
        File file = new File(str);
        if (!file.exists()) {
            if (file.mkdirs()) {
                return true;
            }
            ALog.m4192d(TAG, "创建失败，请检查路径和是否配置文件权限！");
            return false;
        }
        return false;
    }

    public static boolean createFile(File file) {
        if (file.getParentFile() == null || !file.getParentFile().exists()) {
            ALog.m4192d(TAG, "目标文件所在路径不存在，准备创建……");
            if (!createDir(file.getParent())) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("创建目录文件所在的目录失败！文件路径【");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(file.getPath());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("】");
                ALog.m4192d(TAG, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
        }
        deleteFile(file);
        try {
            return file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean createFile(String str) {
        if (TextUtils.isEmpty(str)) {
            ALog.m4191e(TAG, "文件路径不能为null");
            return false;
        }
        return createFile(new File(str));
    }

    public static void createFileFormInputStream(InputStream inputStream, String str) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    inputStream.close();
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    return;
                }
                fileOutputStream.write(bArr, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String createFileName(String str) {
        int indexOf = str.indexOf("?");
        String str2 = "";
        if (indexOf > 0) {
            String substring = str.substring(0, indexOf);
            int lastIndexOf = substring.lastIndexOf("/");
            if (lastIndexOf > 0) {
                str2 = substring.substring(lastIndexOf + 1);
            }
        } else {
            int lastIndexOf2 = str.lastIndexOf("/");
            if (lastIndexOf2 > 0) {
                str2 = str.substring(lastIndexOf2 + 1);
            }
        }
        return TextUtils.isEmpty(str2) ? CommonUtil.keyToHashKey(str) : str2;
    }

    public static boolean deleteDir(File file) {
        if (!file.exists()) {
            return false;
        }
        if (file.isFile()) {
            return file.delete();
        }
        for (File file2 : file.listFiles()) {
            deleteDir(file2);
        }
        return file.delete();
    }

    public static boolean deleteFile(File file) {
        if (file.exists()) {
            File file2 = new File(file.getAbsolutePath() + System.currentTimeMillis());
            return file.renameTo(file2) ? file2.delete() : file.delete();
        }
        return false;
    }

    public static boolean deleteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            ALog.m4191e(TAG, "删除文件失败，路径为空");
            return false;
        }
        return deleteFile(new File(str));
    }

    public static long getAvailMemory(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static long getAvailableExternalMemorySize(String str) {
        StatFs statFs = new StatFs(str);
        return statFs.getAvailableBlocks() * statFs.getBlockSize();
    }

    public static String getFileExtensionName(String str) {
        int lastIndexOf;
        if (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf(".")) > -1) {
            return str.substring(lastIndexOf + 1);
        }
        return null;
    }

    public static List<String> getSDPathList(Context context) {
        try {
            return getVolumeList(context);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
            return null;
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static List<String> getStorageDirectories() {
        String[] split;
        ArrayList arrayList = new ArrayList();
        String str = System.getenv("EXTERNAL_STORAGE");
        String str2 = System.getenv("SECONDARY_STORAGE");
        String str3 = System.getenv("EMULATED_STORAGE_TARGET");
        if (!TextUtils.isEmpty(str3)) {
            String str4 = DIR_SEPORATOR.split(Environment.getExternalStorageDirectory().getAbsolutePath())[split.length - 1];
            boolean z = false;
            if (!TextUtils.isEmpty(str4) && TextUtils.isDigitsOnly(str4)) {
                z = true;
            }
            if (!z) {
                str4 = "";
            }
            if (!TextUtils.isEmpty(str4)) {
                str = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str3), File.separator, str4);
            }
        } else if (TextUtils.isEmpty(str)) {
            str = "/storage/sdcard0";
        }
        arrayList.add(str);
        if (!TextUtils.isEmpty(str2)) {
            Collections.addAll(arrayList, str2.split(File.pathSeparator));
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            String str5 = (String) arrayList.get(size);
            File file = new File(str5);
            if (!file.exists() || !file.isDirectory() || !canWrite(str5)) {
                arrayList.remove(size);
            }
        }
        return arrayList;
    }

    public static long getTotalExternalMemorySize(String str) {
        StatFs statFs = new StatFs(str);
        return statFs.getBlockCount() * statFs.getBlockSize();
    }

    public static long getTotalMemory() {
        long j = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            j = Integer.valueOf(bufferedReader.readLine().split("\\s+")[1]).intValue() * 1024;
            bufferedReader.close();
            return j;
        } catch (IOException e) {
            e.printStackTrace();
            return j;
        }
    }

    public static String getTsCacheDir(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            return String.format("%s/.%s_%s", file.getParent(), file.getName(), Integer.valueOf(i));
        }
        throw new NullPointerException("m3u8文保存路径为空");
    }

    public static List<String> getVolumeList(Context context) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<String> arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 24) {
            List<StorageVolume> storageVolumes = ((StorageManager) context.getSystemService(LitePalParser.NODE_STORAGE)).getStorageVolumes();
            Method declaredMethod = StorageVolume.class.getDeclaredMethod("getPath", new Class[0]);
            declaredMethod.setAccessible(true);
            for (StorageVolume storageVolume : storageVolumes) {
                if (storageVolume.getState().equals("mounted")) {
                    arrayList.add((String) declaredMethod.invoke(storageVolume, new Object[0]));
                }
            }
        } else {
            arrayList.addAll(getStorageDirectories());
        }
        if (arrayList.isEmpty()) {
            arrayList = new ArrayList();
            arrayList.add(EXTERNAL_STORAGE_PATH);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : arrayList) {
            File file = new File(str);
            if (file.exists() && file.isDirectory() && canWrite(str)) {
                int hashCode = (file.getTotalSpace() + "-" + file.getUsableSpace()).hashCode();
                String str2 = (String) linkedHashMap.get(Integer.valueOf(hashCode));
                if (TextUtils.isEmpty(str2) || str2.length() >= str.length()) {
                    linkedHashMap.put(Integer.valueOf(hashCode), str);
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Integer num : linkedHashMap.keySet()) {
            arrayList2.add(linkedHashMap.get(num));
        }
        return arrayList2;
    }

    public static Properties loadConfig(File file) {
        FileInputStream fileInputStream;
        Properties properties = new Properties();
        if (!file.exists()) {
            createFile(file.getPath());
        }
        FileInputStream fileInputStream2 = null;
        try {
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e) {
                e = e;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        try {
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (Exception e3) {
            e = e3;
            fileInputStream2 = fileInputStream;
            e.printStackTrace();
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            return properties;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
        return properties;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0105 A[Catch: IOException -> 0x0101, TRY_LEAVE, TryCatch #0 {IOException -> 0x0101, blocks: (B:72:0x00fd, B:65:0x0105), top: B:71:0x00fd }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00fd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean mergeFile(String str, List<String> list) {
        Throwable th;
        ?? r1;
        FileOutputStream fileOutputStream;
        File file = new File(str);
        long currentTimeMillis = System.currentTimeMillis();
        FileChannel fileChannel = null;
        try {
            try {
                if (file.exists() && file.isDirectory()) {
                    ALog.m4185w(TAG, String.format("路径【%s】是文件夹，将删除该文件夹", str));
                    deleteDir(file);
                }
                if (!file.exists()) {
                    createFile(file);
                }
                fileOutputStream = new FileOutputStream(str);
                try {
                    FileChannel channel = fileOutputStream.getChannel();
                    LinkedList linkedList = new LinkedList();
                    long j = 0;
                    for (String str2 : list) {
                        File file2 = new File(str2);
                        if (!file2.exists()) {
                            ALog.m4192d(TAG, String.format("合并文件失败，文件【%s】不存在", str2));
                            Iterator it = linkedList.iterator();
                            while (it.hasNext()) {
                                ((FileInputStream) it.next()).close();
                            }
                            linkedList.clear();
                            if (channel != null) {
                                try {
                                    channel.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            fileOutputStream.close();
                            return false;
                        }
                        FileInputStream fileInputStream = new FileInputStream(str2);
                        channel.transferFrom(fileInputStream.getChannel(), j, file2.length());
                        j += file2.length();
                        fileInputStream.close();
                    }
                    ALog.m4192d(TAG, String.format("合并文件耗时：%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    fileOutputStream.close();
                    return true;
                } catch (IOException e3) {
                    e = e3;
                    e.printStackTrace();
                    if (0 != 0) {
                        try {
                            fileChannel.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            return false;
                        }
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return false;
                }
            } catch (Throwable th2) {
                th = th2;
                r1 = file;
                if (0 != 0) {
                    try {
                        fileChannel.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                        throw th;
                    }
                }
                if (r1 != 0) {
                    r1.close();
                }
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
            fileOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            r1 = 0;
            if (0 != 0) {
            }
            if (r1 != 0) {
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x011e A[Catch: IOException -> 0x011a, TRY_LEAVE, TryCatch #0 {IOException -> 0x011a, blocks: (B:78:0x0116, B:71:0x011e), top: B:77:0x0116 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0116 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.io.FileOutputStream, java.nio.channels.FileChannel] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean mergeSFtpFile(String str, List<String> list, long j) {
        Throwable th;
        FileOutputStream fileOutputStream;
        File file = new File(str);
        long currentTimeMillis = System.currentTimeMillis();
        ?? r4 = 0;
        try {
            try {
                if (file.exists() && file.isDirectory()) {
                    ALog.m4185w(TAG, String.format("路径【%s】是文件夹，将删除该文件夹", str));
                    deleteDir(file);
                }
                if (!file.exists()) {
                    createFile(file);
                }
                fileOutputStream = new FileOutputStream(str);
                try {
                    FileChannel channel = fileOutputStream.getChannel();
                    LinkedList linkedList = new LinkedList();
                    int size = list.size();
                    long j2 = j / size;
                    int i = 0;
                    for (String str2 : list) {
                        if (!new File(str2).exists()) {
                            ALog.m4192d(TAG, String.format("合并文件失败，文件【%s】不存在", str2));
                            Iterator it = linkedList.iterator();
                            while (it.hasNext()) {
                                ((FileInputStream) it.next()).close();
                            }
                            linkedList.clear();
                            if (channel != null) {
                                try {
                                    channel.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            fileOutputStream.close();
                            return false;
                        }
                        long j3 = i == size + (-1) ? j - (i * j2) : j2;
                        FileInputStream fileInputStream = new FileInputStream(str2);
                        channel.transferFrom(fileInputStream.getChannel(), i * j3, j3);
                        fileInputStream.close();
                        i++;
                    }
                    ALog.m4192d(TAG, String.format("合并文件耗时：%sms，合并后的文件长度：%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Long.valueOf(file.length())));
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    fileOutputStream.close();
                    return true;
                } catch (IOException e3) {
                    e = e3;
                    e.printStackTrace();
                    if (0 != 0) {
                        try {
                            r4.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            return false;
                        }
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return false;
                }
            } catch (Throwable th2) {
                th = th2;
                if (0 != 0) {
                    try {
                        r4.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                        throw th;
                    }
                }
                if (0 != 0) {
                    r4.close();
                }
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
            fileOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            if (0 != 0) {
            }
            if (0 != 0) {
            }
            throw th;
        }
    }

    public static List<String> readMountsFile() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(EXTERNAL_STORAGE_PATH);
        try {
            Scanner scanner = new Scanner(new File("/proc/mounts"));
            while (scanner.hasNext()) {
                String nextLine = scanner.nextLine();
                if (nextLine.startsWith("/dev/block/vold/") || nextLine.startsWith("/dev/block//vold/")) {
                    String str = nextLine.split(StringUtils.SPACE)[1];
                    if (!str.equals(EXTERNAL_STORAGE_PATH)) {
                        arrayList.add(str);
                    }
                }
            }
            scanner.close();
        } catch (Exception unused) {
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [boolean] */
    public static Object readObjFromFile(String str) {
        FileInputStream fileInputStream;
        String format;
        FileInputStream fileInputStream2 = null;
        if (TextUtils.isEmpty(str)) {
            format = "文件路径为空";
        } else {
            ?? exists = new File(str).exists();
            try {
                try {
                    if (exists == 0) {
                        format = String.format("文件【%s】不存在", str);
                    } else {
                        try {
                            fileInputStream = new FileInputStream(str);
                            try {
                                Object readObject = new ObjectInputStream(fileInputStream).readObject();
                                try {
                                    fileInputStream.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                return readObject;
                            } catch (FileNotFoundException e2) {
                                e = e2;
                                e.printStackTrace();
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                return null;
                            } catch (IOException e3) {
                                e = e3;
                                e.printStackTrace();
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                return null;
                            } catch (ClassNotFoundException e4) {
                                e = e4;
                                e.printStackTrace();
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                return null;
                            }
                        } catch (FileNotFoundException e5) {
                            e = e5;
                            fileInputStream = null;
                        } catch (IOException e6) {
                            e = e6;
                            fileInputStream = null;
                        } catch (ClassNotFoundException e7) {
                            e = e7;
                            fileInputStream = null;
                        } catch (Throwable th) {
                            th = th;
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e8) {
                                    e8.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                } catch (IOException e9) {
                    e9.printStackTrace();
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = exists;
            }
        }
        ALog.m4191e(TAG, format);
        return null;
    }

    public static List<String> readVoldFile() {
        Scanner scanner;
        ArrayList arrayList;
        ArrayList arrayList2 = null;
        try {
            try {
                scanner = new Scanner(new File("/system/etc/vold.fstab"));
            } catch (FileNotFoundException unused) {
                scanner = new Scanner(new File("/system/etc/vold.conf"));
            }
            arrayList = new ArrayList();
        } catch (Exception unused2) {
            return arrayList2;
        }
        try {
            String str = EXTERNAL_STORAGE_PATH;
            while (true) {
                arrayList.add(str);
                while (scanner.hasNext()) {
                    String nextLine = scanner.nextLine();
                    if (!TextUtils.isEmpty(nextLine)) {
                        String trim = nextLine.trim();
                        if (trim.startsWith("dev_mount")) {
                            String[] split = trim.split(StringUtils.SPACE);
                            if (split.length >= 3) {
                                str = split[2];
                                if (str.contains(":")) {
                                    str = str.substring(0, str.indexOf(":"));
                                }
                                if (!str.equals(EXTERNAL_STORAGE_PATH)) {
                                    break;
                                }
                            }
                        } else if (trim.startsWith("mount_point")) {
                            str = trim.replaceAll("mount_point", "").trim();
                            if (!str.equals(EXTERNAL_STORAGE_PATH)) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                }
                return arrayList;
            }
        } catch (Exception unused3) {
            arrayList2 = arrayList;
            return arrayList2;
        }
    }

    public static void saveConfig(File file, Properties properties) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(file, false);
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            if (fileOutputStream2 == null) {
                return;
            }
            fileOutputStream2.flush();
            fileOutputStream2.close();
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static void splitFile(String str, int i) {
        File file;
        long j;
        int i2 = i;
        try {
            File file2 = new File(str);
            long length = file2.length();
            FileInputStream fileInputStream = new FileInputStream(file2);
            FileChannel channel = fileInputStream.getChannel();
            long j2 = 0;
            long j3 = length / i2;
            int i3 = 0;
            while (i3 < i2) {
                int i4 = i2 - 1;
                if (i3 == i4) {
                    j3 = length - (j3 * i4);
                }
                ALog.m4192d(TAG, String.format("block = %s", Long.valueOf(j3)));
                File file3 = new File(file2.getPath() + "." + i3 + ".part");
                if (!file3.exists()) {
                    createFile(file3);
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file3);
                FileChannel channel2 = fileOutputStream.getChannel();
                ByteBuffer allocate = ByteBuffer.allocate(C1648o.C1650a.f3602s);
                while (true) {
                    int read = channel.read(allocate);
                    file = file2;
                    if (read == -1) {
                        j = length;
                        break;
                    }
                    allocate.flip();
                    channel2.write(allocate);
                    allocate.compact();
                    j = length;
                    j2 += read;
                    if (j2 >= (i3 + 1) * j3) {
                        break;
                    }
                    file2 = file;
                    length = j;
                }
                ALog.m4192d(TAG, String.format("len = %s", Long.valueOf(file3.length())));
                fileOutputStream.close();
                channel2.close();
                i3++;
                i2 = i;
                file2 = file;
                length = j;
            }
            fileInputStream.close();
            channel.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static void writeObjToFile(String str, Object obj) {
        if (!(obj instanceof Serializable)) {
            ALog.m4191e(TAG, "对象写入文件失败，data数据必须实现Serializable接口");
            return;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            } catch (FileNotFoundException e2) {
                e = e2;
            } catch (IOException e3) {
                e = e3;
            }
            if (!createFile(str)) {
                return;
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(str);
            try {
                new ObjectOutputStream(fileOutputStream2).writeObject(obj);
                fileOutputStream2.close();
            } catch (FileNotFoundException e4) {
                e = e4;
                fileOutputStream = fileOutputStream2;
                e.printStackTrace();
                if (fileOutputStream == null) {
                    return;
                }
                fileOutputStream.close();
            } catch (IOException e5) {
                e = e5;
                fileOutputStream = fileOutputStream2;
                e.printStackTrace();
                if (fileOutputStream == null) {
                    return;
                }
                fileOutputStream.close();
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
