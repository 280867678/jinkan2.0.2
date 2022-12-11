package com.umeng.commonsdk.internal.utils;

import android.os.Build;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/* renamed from: com.umeng.commonsdk.internal.utils.d */
/* loaded from: classes4.dex */
public class C1741d {

    /* renamed from: com.umeng.commonsdk.internal.utils.d$a */
    /* loaded from: classes4.dex */
    public enum EnumC1742a {
        check_su_binary(new String[]{"/system/xbin/which", "su"});
        

        /* renamed from: b */
        public String[] f3969b;

        EnumC1742a(String[] strArr) {
            this.f3969b = strArr;
        }
    }

    /* renamed from: a */
    public ArrayList m665a(EnumC1742a enumC1742a) {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT > 28) {
            return arrayList;
        }
        try {
            Process exec = Runtime.getRuntime().exec(enumC1742a.f3969b);
            new BufferedWriter(new OutputStreamWriter(exec.getOutputStream()));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    arrayList.add(readLine);
                } catch (Exception unused) {
                }
            }
            return arrayList;
        } catch (Exception unused2) {
            return null;
        }
    }
}
