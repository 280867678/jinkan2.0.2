package me.tvspark;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import androidx.annotation.NonNull;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes4.dex */
public class Illllll extends Illlllllll<InputStream> {
    public static final UriMatcher Wwwwwwwwwwwwwwwwwwwww;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        Wwwwwwwwwwwwwwwwwwwww = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        Wwwwwwwwwwwwwwwwwwwww.addURI("com.android.contacts", "contacts/lookup/*", 1);
        Wwwwwwwwwwwwwwwwwwwww.addURI("com.android.contacts", "contacts/#/photo", 2);
        Wwwwwwwwwwwwwwwwwwwww.addURI("com.android.contacts", "contacts/#", 3);
        Wwwwwwwwwwwwwwwwwwwww.addURI("com.android.contacts", "contacts/#/display_photo", 4);
        Wwwwwwwwwwwwwwwwwwwww.addURI("com.android.contacts", "phone_lookup/*", 5);
    }

    public Illllll(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    @Override // me.tvspark.Illlllllllllllllll
    @NonNull
    public Class<InputStream> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return InputStream.class;
    }

    @Override // me.tvspark.Illlllllll
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025 A[RETURN] */
    @Override // me.tvspark.Illlllllll
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public InputStream Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        InputStream openContactPhotoInputStream;
        int match = Wwwwwwwwwwwwwwwwwwwww.match(uri);
        if (match != 1) {
            if (match == 3) {
                openContactPhotoInputStream = ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
            } else if (match != 5) {
                openContactPhotoInputStream = contentResolver.openInputStream(uri);
            }
            if (openContactPhotoInputStream != null) {
                throw new FileNotFoundException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("InputStream is null for ", uri));
            }
            return openContactPhotoInputStream;
        }
        Uri lookupContact = ContactsContract.Contacts.lookupContact(contentResolver, uri);
        if (lookupContact != null) {
            openContactPhotoInputStream = ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, lookupContact, true);
            if (openContactPhotoInputStream != null) {
            }
        } else {
            throw new FileNotFoundException("Contact cannot be found");
        }
    }
}
