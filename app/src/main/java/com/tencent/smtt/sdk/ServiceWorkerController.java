package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Build;
import com.tencent.smtt.export.external.interfaces.IX5CoreServiceWorkerController;
import com.tencent.smtt.export.external.interfaces.ServiceWorkerClient;
import com.tencent.smtt.export.external.interfaces.ServiceWorkerWebSettings;

/* loaded from: classes4.dex */
public abstract class ServiceWorkerController {
    public static ServiceWorkerController getInstance(Context context) {
        C1416x m2294a = C1416x.m2294a();
        m2294a.m2293a(context);
        if (!m2294a.m2291b()) {
            if (Build.VERSION.SDK_INT < 24) {
                return null;
            }
            return new C1374l();
        }
        final IX5CoreServiceWorkerController m2229q = C1416x.m2294a().m2289c().m2229q();
        if (m2229q == null) {
            return null;
        }
        return new ServiceWorkerController() { // from class: com.tencent.smtt.sdk.ServiceWorkerController.1
            @Override // com.tencent.smtt.sdk.ServiceWorkerController
            public ServiceWorkerWebSettings getServiceWorkerWebSettings() {
                return IX5CoreServiceWorkerController.this.getServiceWorkerWebSettings();
            }

            @Override // com.tencent.smtt.sdk.ServiceWorkerController
            public void setServiceWorkerClient(ServiceWorkerClient serviceWorkerClient) {
                IX5CoreServiceWorkerController.this.setServiceWorkerClient(serviceWorkerClient);
            }
        };
    }

    public abstract ServiceWorkerWebSettings getServiceWorkerWebSettings();

    public abstract void setServiceWorkerClient(ServiceWorkerClient serviceWorkerClient);
}
