package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;
import com.stub.StubApp;
import com.tencent.smtt.export.external.DexLoader;

/* renamed from: com.tencent.smtt.sdk.u */
/* loaded from: classes4.dex */
public class C1400u extends FrameLayout implements MediaPlayer.OnErrorListener {

    /* renamed from: a */
    public Object f2239a;

    /* renamed from: b */
    public C1415w f2240b;

    /* renamed from: c */
    public VideoView f2241c;

    /* renamed from: d */
    public Context f2242d;

    /* renamed from: e */
    public String f2243e;

    public C1400u(Context context) {
        super(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        this.f2242d = null;
        this.f2242d = context;
    }

    /* renamed from: b */
    private void m2367b(Bundle bundle, Object obj) {
        boolean z;
        m2372a();
        if (m2368b()) {
            bundle.putInt("callMode", bundle.getInt("callMode"));
            z = this.f2240b.m2295a(this.f2239a, bundle, this, obj);
        } else {
            z = false;
        }
        if (!z) {
            VideoView videoView = this.f2241c;
            if (videoView != null) {
                videoView.stopPlayback();
            }
            if (this.f2241c == null) {
                this.f2241c = new VideoView(getContext());
            }
            String string = bundle.getString("videoUrl");
            this.f2243e = string;
            this.f2241c.setVideoURI(Uri.parse(string));
            this.f2241c.setOnErrorListener(this);
            Intent intent = new Intent("com.tencent.smtt.tbs.video.PLAY");
            intent.addFlags(268435456);
            Context origApplicationContext = StubApp.getOrigApplicationContext(getContext().getApplicationContext());
            intent.setPackage(origApplicationContext.getPackageName());
            origApplicationContext.startActivity(intent);
        }
    }

    /* renamed from: a */
    public void m2372a() {
        setBackgroundColor(-16777216);
        if (this.f2240b == null) {
            C1363g.m2597a(true).m2599a(StubApp.getOrigApplicationContext(getContext().getApplicationContext()), false, false);
            C1414v m2601a = C1363g.m2597a(true).m2601a();
            DexLoader dexLoader = null;
            if (m2601a != null) {
                dexLoader = m2601a.m2302b();
            }
            if (dexLoader != null && QbSdk.canLoadVideo(getContext())) {
                this.f2240b = new C1415w(dexLoader);
            }
        }
        C1415w c1415w = this.f2240b;
        if (c1415w == null || this.f2239a != null) {
            return;
        }
        this.f2239a = c1415w.m2298a(StubApp.getOrigApplicationContext(getContext().getApplicationContext()));
    }

    /* renamed from: a */
    public void m2371a(Activity activity) {
        VideoView videoView;
        if (!m2368b() && (videoView = this.f2241c) != null) {
            if (videoView.getParent() == null) {
                Window window = activity.getWindow();
                FrameLayout frameLayout = (FrameLayout) window.getDecorView();
                window.addFlags(1024);
                window.addFlags(128);
                frameLayout.setBackgroundColor(-16777216);
                MediaController mediaController = new MediaController(activity);
                mediaController.setMediaPlayer(this.f2241c);
                this.f2241c.setMediaController(mediaController);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                layoutParams.gravity = 17;
                frameLayout.addView(this.f2241c, layoutParams);
            }
            this.f2241c.start();
        }
    }

    /* renamed from: a */
    public void m2370a(Activity activity, int i) {
        VideoView videoView;
        VideoView videoView2;
        if (i == 3 && !m2368b() && (videoView2 = this.f2241c) != null) {
            videoView2.pause();
        }
        if (i == 4) {
            this.f2242d = null;
            if (!m2368b() && (videoView = this.f2241c) != null) {
                videoView.stopPlayback();
                this.f2241c = null;
            }
        }
        if (i == 2 && !m2368b()) {
            this.f2242d = activity;
            m2371a(activity);
        }
        if (m2368b()) {
            this.f2240b.m2296a(this.f2239a, activity, i);
        }
    }

    /* renamed from: a */
    public void m2369a(Bundle bundle, Object obj) {
        m2367b(bundle, obj);
    }

    /* renamed from: b */
    public boolean m2368b() {
        return (this.f2240b == null || this.f2239a == null) ? false : true;
    }

    /* renamed from: c */
    public void m2366c() {
        if (m2368b()) {
            this.f2240b.m2297a(this.f2239a);
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        try {
            if (this.f2242d instanceof Activity) {
                Activity activity = (Activity) this.f2242d;
                if (!activity.isFinishing()) {
                    activity.finish();
                }
            }
            Context context = getContext();
            if (context != null) {
                Toast.makeText(context, "播放失败，请选择其它播放器播放", 1).show();
                Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(268435456);
                intent.setDataAndType(Uri.parse(this.f2243e), "video/*");
                origApplicationContext.startActivity(intent);
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
