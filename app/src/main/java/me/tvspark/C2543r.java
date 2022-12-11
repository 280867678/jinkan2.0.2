package me.tvspark;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import androidx.annotation.NonNull;
import com.stub.StubApp;
import me.tvspark.AbstractC2463p;
import me.tvspark.Kkkkkkkkkkkk;

/* renamed from: me.tvspark.r */
/* loaded from: classes4.dex */
public final class C2543r implements AbstractC2463p {
    public final BroadcastReceiver Wwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public boolean Wwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC2463p.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwww;
    public final Context Wwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.r$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends BroadcastReceiver {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@NonNull Context context, Intent intent) {
            C2543r c2543r = C2543r.this;
            boolean z = c2543r.Wwwwwwwwwwwwwwwwwwwwww;
            c2543r.Wwwwwwwwwwwwwwwwwwwwww = c2543r.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context);
            if (z != C2543r.this.Wwwwwwwwwwwwwwwwwwwwww) {
                if (Log.isLoggable("ConnectivityMonitor", 3)) {
                    boolean z2 = C2543r.this.Wwwwwwwwwwwwwwwwwwwwww;
                }
                C2543r c2543r2 = C2543r.this;
                ((Kkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) c2543r2.Wwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2543r2.Wwwwwwwwwwwwwwwwwwwwww);
            }
        }
    }

    public C2543r(@NonNull Context context, @NonNull AbstractC2463p.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @SuppressLint({"MissingPermission"})
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(connectivityManager, "Argument must not be null");
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (RuntimeException unused) {
            Log.isLoggable("ConnectivityMonitor", 5);
            return true;
        }
    }

    @Override // me.tvspark.AbstractC2692v
    public void onDestroy() {
    }

    @Override // me.tvspark.AbstractC2692v
    public void onStart() {
        if (this.Wwwwwwwwwwwwwwwwwwwww) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        try {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.registerReceiver(this.Wwwwwwwwwwwwwwwwwwww, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.Wwwwwwwwwwwwwwwwwwwww = true;
        } catch (SecurityException unused) {
            Log.isLoggable("ConnectivityMonitor", 5);
        }
    }

    @Override // me.tvspark.AbstractC2692v
    public void onStop() {
        if (!this.Wwwwwwwwwwwwwwwwwwwww) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwww.unregisterReceiver(this.Wwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwww = false;
    }
}
