package me.tvspark;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import me.tvspark.u51;

/* loaded from: classes4.dex */
public class v51 {
    public u51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
    public final Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Object();
    public ServiceConnection Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public static final v51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new v51();
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements ServiceConnection {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            v51.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = u51.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iBinder);
            synchronized (v51.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                v51.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.notify();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            v51.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        }
    }

    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, String str) {
        Signature[] signatureArr;
        String str2;
        MessageDigest messageDigest;
        if (TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = context.getPackageName();
        }
        if (TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
            try {
                signatureArr = context.getPackageManager().getPackageInfo(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 64).signatures;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                signatureArr = null;
            }
            if (signatureArr != null && signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    messageDigest = MessageDigest.getInstance("SHA1");
                } catch (NoSuchAlgorithmException e2) {
                    e2.printStackTrace();
                }
                if (messageDigest != null) {
                    byte[] digest = messageDigest.digest(byteArray);
                    StringBuilder sb = new StringBuilder();
                    for (byte b : digest) {
                        sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
                    }
                    str2 = sb.toString();
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str2;
                }
            }
            str2 = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str2;
        }
        u51 u51Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        String str3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        String str4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        u51.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.C3492Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww c3492Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (u51.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.C3492Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) u51Var;
        if (c3492Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                obtain.writeString(str3);
                obtain.writeString(str4);
                obtain.writeString(str);
                c3492Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                String readString = obtain2.readString();
                obtain2.recycle();
                obtain.recycle();
                return TextUtils.isEmpty(readString) ? "" : readString;
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
                throw th;
            }
        }
        throw null;
    }

    public synchronized String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, String str) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                try {
                    return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, str);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return "";
                }
            }
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
            if (context.bindService(intent, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 1)) {
                synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    try {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.wait(3000L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                return "";
            }
            try {
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, str);
            } catch (RemoteException e3) {
                e3.printStackTrace();
                return "";
            }
        }
        throw new IllegalStateException("Cannot run on MainThread");
    }
}
