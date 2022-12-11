package me.tvspark;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.stub.StubApp;
import java.io.IOException;
import java.util.List;

/* loaded from: classes4.dex */
public class Mmmmm implements Illlllllllllllllllllllll<Uri, Drawable> {
    public final Context Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public Mmmmm(Context context) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0034  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AbstractC1886O0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Uri uri) {
        Context createPackageContext;
        List<String> pathSegments;
        int parseInt;
        Drawable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        String authority = uri.getAuthority();
        if (!authority.equals(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getPackageName())) {
            try {
                createPackageContext = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.createPackageContext(authority, 0);
            } catch (PackageManager.NameNotFoundException e) {
                if (!authority.contains(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getPackageName())) {
                    throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Failed to obtain context or unrecognized Uri format for: ", uri), e);
                }
            }
            pathSegments = uri.getPathSegments();
            if (pathSegments.size() != 2) {
                List<String> pathSegments2 = uri.getPathSegments();
                String authority2 = uri.getAuthority();
                String str = pathSegments2.get(0);
                String str2 = pathSegments2.get(1);
                parseInt = createPackageContext.getResources().getIdentifier(str2, str, authority2);
                if (parseInt == 0) {
                    parseInt = Resources.getSystem().getIdentifier(str2, str, "android");
                }
                if (parseInt == 0) {
                    throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Failed to find resource id for: ", uri));
                }
            } else if (pathSegments.size() == 1) {
                try {
                    parseInt = Integer.parseInt(uri.getPathSegments().get(0));
                } catch (NumberFormatException e2) {
                    throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unrecognized Uri format: ", uri), e2);
                }
            } else {
                throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unrecognized Uri format: ", uri));
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Mmmmmmmm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, createPackageContext, parseInt, null);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                return null;
            }
            return new Mmmmmm(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        createPackageContext = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        pathSegments = uri.getPathSegments();
        if (pathSegments.size() != 2) {
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Mmmmmmmm.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, createPackageContext, parseInt, null);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
        }
    }

    @Override // me.tvspark.Illlllllllllllllllllllll
    @Nullable
    public /* bridge */ /* synthetic */ AbstractC1886O0<Drawable> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Uri uri, int i, int i2, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) throws IOException {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uri);
    }

    @Override // me.tvspark.Illlllllllllllllllllllll
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Uri uri, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) throws IOException {
        return uri.getScheme().equals("android.resource");
    }
}
