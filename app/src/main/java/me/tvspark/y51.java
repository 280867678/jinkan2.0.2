package me.tvspark;

import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.p038qq.p039e.comm.p040pi.ACTD;

/* loaded from: classes4.dex */
public final class y51 extends Handler {
    public y51(Looper looper) {
        super(looper);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0073 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // android.os.Handler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleMessage(Message message) {
        String str;
        Uri parse;
        Cursor query;
        StringBuilder sb;
        String str2;
        if (message.what == 11) {
            int i = message.getData().getInt("type");
            String string = message.getData().getString(ACTD.APPID_KEY);
            x51 x51Var = z51.Wwwwwwwwwwwwwwwwwwwwwwwww;
            String str3 = null;
            if (x51Var != null) {
                if (i != 0) {
                    if (i == 1) {
                        sb = new StringBuilder();
                        str2 = "content://com.vivo.vms.IdProvider/IdentifierId/VAID_";
                    } else if (i == 2) {
                        sb = new StringBuilder();
                        str2 = "content://com.vivo.vms.IdProvider/IdentifierId/AAID_";
                    } else if (i != 4) {
                        parse = null;
                        query = x51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getContentResolver().query(parse, null, null, null, null);
                        if (query != null) {
                            if (query.moveToNext()) {
                                str3 = query.getString(query.getColumnIndex("value"));
                            }
                            query.close();
                        }
                        z51.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = str3;
                        synchronized (z51.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                            z51.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.notify();
                        }
                        return;
                    } else {
                        str = "content://com.vivo.vms.IdProvider/IdentifierId/OAIDSTATUS";
                    }
                    str = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, str2, string);
                } else {
                    str = "content://com.vivo.vms.IdProvider/IdentifierId/OAID";
                }
                parse = Uri.parse(str);
                query = x51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getContentResolver().query(parse, null, null, null, null);
                if (query != null) {
                }
                z51.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = str3;
                synchronized (z51.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                }
            } else {
                throw null;
            }
        }
    }
}
