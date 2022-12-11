package com.p024jg.ids.p035k;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.p024jg.ids.AbstractC0932a;
import com.p024jg.ids.IdsHelper;
import com.p038qq.p039e.comm.p040pi.ACTD;

/* JADX WARN: Classes with same name are omitted:
  classes.dex
 */
/* renamed from: com.jg.ids.k.a */
/* loaded from: classes6.dex */
public final class C0980a extends AbstractC0932a {

    /* renamed from: b */
    private String f635b;

    /* renamed from: c */
    private ContentObserver f636c;

    /* renamed from: d */
    private ContentObserver f637d;

    /* renamed from: e */
    private ContentObserver f638e;

    public C0980a(Context context, String str) {
        super(context, "vivo_thread");
        this.f636c = null;
        this.f637d = null;
        this.f638e = null;
        this.f635b = str;
        try {
            this.f636c = new C0981b(this, null, str, 0);
            this.f637d = new C0981b(this, null, str, 1);
            this.f638e = new C0981b(this, null, str, 2);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, this.f636c);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str), true, this.f637d);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str), true, this.f638e);
        } catch (Throwable th) {
        }
    }

    @Override // com.p024jg.ids.AbstractC0954f, com.p024jg.ids.AbstractC0969i
    /* renamed from: a */
    public final String mo3723a(Context context) {
        String a = super.a(context);
        if (TextUtils.isEmpty(a)) {
            m3724b(1, this.f635b);
        }
        return a;
    }

    @Override // com.p024jg.ids.AbstractC0954f, com.p024jg.ids.AbstractC0969i
    /* renamed from: b */
    public final String mo3721b(Context context) {
        String str;
        try {
            Cursor query = context.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            if (query == null) {
                return "";
            }
            if (!query.moveToNext()) {
                str = "";
            } else {
                str = query.getString(query.getColumnIndex("value"));
            }
            try {
                query.close();
                return str;
            } catch (Throwable th) {
                return str;
            }
        } catch (Throwable th2) {
            return "";
        }
    }

    @Override // com.p024jg.ids.AbstractC0954f, com.p024jg.ids.AbstractC0969i
    /* renamed from: c */
    public final String mo3720c(Context context) {
        String c = super.c(context);
        if (TextUtils.isEmpty(c)) {
            m3724b(2, this.f635b);
        }
        return c;
    }

    @Override // com.p024jg.ids.AbstractC0932a
    /* renamed from: b */
    protected final void mo3708b() {
        m3724b(1, this.f635b);
        m3724b(2, this.f635b);
        m3724b(0, this.f635b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.p024jg.ids.AbstractC0932a
    /* renamed from: a */
    public final void mo3709a(Message message) {
        if (message != null) {
            try {
                if (message.what == 0) {
                    int i = message.getData().getInt("type", -1);
                    a(i, m3726a(IdsHelper.CONTEXT, i, message.getData().getString(ACTD.APPID_KEY, "")));
                }
            } catch (Throwable th) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m3724b(int i, String str) {
        try {
            Message a = a();
            a.what = 0;
            Bundle bundle = new Bundle();
            bundle.putInt("type", i);
            bundle.putString(ACTD.APPID_KEY, str);
            a.setData(bundle);
            b(a);
        } catch (Throwable th) {
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:40)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:203)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:46)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:40)
        */
    /* renamed from: a */
    private static java.lang.String m3726a(android.content.Context r8, int r9, java.lang.String r10) {
        /*
            r7 = 0
            java.lang.String r6 = ""
            switch(r9) {
                case 0: goto Lc;
                case 1: goto L13;
                case 2: goto L27;
                default: goto L6;
            }
        L6:
            r1 = r7
        L7:
            if (r1 != 0) goto L3b
            java.lang.String r0 = ""
        Lb:
            return r0
        Lc:
            java.lang.String r0 = "content://com.vivo.vms.IdProvider/IdentifierId/OAID"
            android.net.Uri r1 = android.net.Uri.parse(r0)     // Catch: java.lang.Throwable -> L60
            goto L7
        L13:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L60
            java.lang.String r1 = "content://com.vivo.vms.IdProvider/IdentifierId/VAID_"
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L60
            java.lang.StringBuilder r0 = r0.append(r10)     // Catch: java.lang.Throwable -> L60
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L60
            android.net.Uri r1 = android.net.Uri.parse(r0)     // Catch: java.lang.Throwable -> L60
            goto L7
        L27:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L60
            java.lang.String r1 = "content://com.vivo.vms.IdProvider/IdentifierId/AAID_"
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L60
            java.lang.StringBuilder r0 = r0.append(r10)     // Catch: java.lang.Throwable -> L60
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L60
            android.net.Uri r1 = android.net.Uri.parse(r0)     // Catch: java.lang.Throwable -> L60
            goto L7
        L3b:
            android.content.ContentResolver r0 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L60
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L60
            if (r1 == 0) goto L78
            boolean r0 = r1.moveToNext()     // Catch: java.lang.Throwable -> L73
            if (r0 == 0) goto L78
            java.lang.String r0 = "value"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L73
            java.lang.String r6 = r1.getString(r0)     // Catch: java.lang.Throwable -> L73
            r0 = r6
        L5a:
            if (r1 == 0) goto Lb
            r1.close()
            goto Lb
        L60:
            r0 = move-exception
            r0 = r7
        L62:
            if (r0 == 0) goto L76
            r0.close()
            r0 = r6
            goto Lb
        L69:
            r0 = move-exception
        L6a:
            if (r7 == 0) goto L6f
            r7.close()
        L6f:
            throw r0
        L70:
            r0 = move-exception
            r7 = r1
            goto L6a
        L73:
            r0 = move-exception
            r0 = r1
            goto L62
        L76:
            r0 = r6
            goto Lb
        L78:
            r0 = r6
            goto L5a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p024jg.ids.p035k.C0980a.m3726a(android.content.Context, int, java.lang.String):java.lang.String");
    }
}
