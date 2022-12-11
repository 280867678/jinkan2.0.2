package me.tvspark;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes4.dex */
public interface u51 extends IInterface {

    /* loaded from: classes4.dex */
    public static abstract class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Binder implements u51 {

        /* renamed from: me.tvspark.u51$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C3492Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements u51 {
            public IBinder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

            public C3492Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(IBinder iBinder) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
        }

        public static u51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof u51)) ? new C3492Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iBinder) : (u51) queryLocalInterface;
        }
    }
}
