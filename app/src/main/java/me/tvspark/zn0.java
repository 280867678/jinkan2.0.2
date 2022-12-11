package me.tvspark;

import android.text.TextUtils;
import com.arialyy.aria.util.FileUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.litepal.crud.LitePalSupport;

/* loaded from: classes4.dex */
public class zn0 implements sk0 {
    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2) {
        StringBuilder sb;
        String str3 = "";
        if (str2.startsWith("/")) {
            if (TextUtils.isEmpty(str3)) {
                str3 = co0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
            }
            sb = new StringBuilder();
        } else if (str2.startsWith("http")) {
            return str2;
        } else {
            if (TextUtils.isEmpty(str3)) {
                str3 = str.substring(0, str.lastIndexOf("/") + 1);
            }
            sb = new StringBuilder();
        }
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, str3, str2);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2) {
        try {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            File file2 = new File(str2);
            if (!file2.exists()) {
                return;
            }
            file2.delete();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(str));
        byte[] bArr = new byte[fileInputStream.available()];
        fileInputStream.read(bArr);
        fileInputStream.close();
        return bArr;
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            FileReader fileReader = new FileReader(str);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer stringBuffer = new StringBuffer("");
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (readLine.startsWith("#EXT-X-KEY")) {
                    readLine = bufferedReader.readLine();
                }
                stringBuffer.append(readLine + "\n");
            }
            bufferedReader.close();
            fileReader.close();
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            FileUtil.createFile(file.getPath());
            PrintWriter printWriter = new PrintWriter(new FileOutputStream(file.getAbsolutePath()));
            printWriter.write(stringBuffer.toString());
            printWriter.close();
            return str;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2) {
        if (str2.startsWith("/")) {
            return co0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str) + str2;
        } else if (str2.startsWith("http")) {
            return str2;
        } else {
            int lastIndexOf = str.lastIndexOf("/");
            return str.substring(0, lastIndexOf + 1) + str2;
        }
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, str2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str3));
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, str2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str3));
            }
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                return "";
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(str3));
                fileOutputStream.write(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                fileOutputStream.flush();
                fileOutputStream.close();
                return str3;
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, String str3, int i) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || i <= 0) {
            return "";
        }
        try {
            FileReader fileReader = new FileReader(str2);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer stringBuffer = new StringBuffer("");
            int i2 = 0;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (readLine.startsWith("#EXT-X-KEY")) {
                    readLine = readLine.replaceAll("\".*\"", "\"file:/" + str3 + "\"");
                } else if (readLine.startsWith("#EXTINF")) {
                    stringBuffer.append(readLine + "\n");
                    readLine = "file:/" + str + "/" + i2 + ".ts";
                    i2++;
                    bufferedReader.readLine();
                }
                stringBuffer.append(readLine + "\n");
            }
            bufferedReader.close();
            fileReader.close();
            File file = new File(str2);
            if (file.exists()) {
                file.delete();
            }
            FileUtil.createFile(file.getPath());
            PrintWriter printWriter = new PrintWriter(new FileOutputStream(file.getAbsolutePath()));
            printWriter.write(stringBuffer.toString());
            printWriter.close();
            return str2;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static List<String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, List<String> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        try {
            String str3 = new String(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str));
            for (String str4 : list) {
                String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str3, str2, str4);
                if (!TextUtils.isEmpty(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                    arrayList.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                } else if (z) {
                    FileUtil.deleteFile(str4);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static List<String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, List<String> list) {
        StringBuilder sb;
        ArrayList arrayList = new ArrayList();
        String str2 = "";
        String str3 = str2;
        for (String str4 : list) {
            if (str4.startsWith("/")) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = co0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
                }
                sb = new StringBuilder();
                sb.append(str2);
            } else if (!str4.startsWith("http")) {
                if (TextUtils.isEmpty(str3)) {
                    str3 = str.substring(0, str.lastIndexOf("/") + 1);
                }
                sb = new StringBuilder();
                sb.append(str3);
            } else {
                arrayList.add(str4);
            }
            sb.append(str4);
            str4 = sb.toString();
            arrayList.add(str4);
        }
        return arrayList;
    }

    public static byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, byte[] bArr) {
        IvParameterSpec ivParameterSpec;
        byte[] bArr2;
        if (str == null) {
            return bArr;
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), LitePalSupport.AES);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            if (TextUtils.isEmpty(str2)) {
                ivParameterSpec = new IvParameterSpec(new byte[16]);
            } else if (str2.startsWith("0x")) {
                String replace = str2.replace("0x", "");
                if (replace != null && !replace.trim().equals("")) {
                    bArr2 = new byte[replace.length() / 2];
                    for (int i = 0; i < replace.length() / 2; i++) {
                        int i2 = i * 2;
                        bArr2[i] = (byte) Integer.parseInt(replace.substring(i2, i2 + 2), 16);
                    }
                    ivParameterSpec = new IvParameterSpec(bArr2);
                }
                bArr2 = new byte[0];
                ivParameterSpec = new IvParameterSpec(bArr2);
            } else {
                ivParameterSpec = new IvParameterSpec(str2.getBytes());
            }
            cipher.init(2, secretKeySpec, ivParameterSpec);
            return cipher.doFinal(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
