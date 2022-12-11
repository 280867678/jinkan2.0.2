package com.umeng.analytics.process;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.umeng.analytics.pro.C1635h;
import java.io.File;
import me.tvspark.outline;

/* renamed from: com.umeng.analytics.process.b */
/* loaded from: classes4.dex */
public class C1679b extends SQLiteOpenHelper {
    public C1679b(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    /* renamed from: a */
    public static C1679b m846a(Context context, String str) {
        String m844b = m844b(context, str);
        AbstractC1677a.f3691h.equals(str);
        return new C1679b(context, m844b, null, 1);
    }

    /* renamed from: a */
    public static String m847a(Context context) {
        return C1635h.m1060b(context) + "subprocess/";
    }

    /* renamed from: a */
    private void m845a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("create table if not exists __et_p(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER, __pn TEXT, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    /* renamed from: b */
    public static String m844b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = AbstractC1677a.f3691h;
        }
        String str2 = C1635h.m1060b(context) + "subprocess/";
        if (AbstractC1677a.f3691h.equals(str)) {
            str2 = C1635h.m1060b(context);
        }
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return String.format(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, AbstractC1677a.f3688e), str);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        m845a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
