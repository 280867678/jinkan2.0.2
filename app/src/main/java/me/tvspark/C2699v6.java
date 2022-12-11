package me.tvspark;

import android.media.DeniedByServerException;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import android.media.UnsupportedSchemeException;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.SavedStateHandle;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.UnsupportedDrmException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import me.tvspark.AbstractC2624t6;
import me.tvspark.C2322l6;
import org.fourthline.cling.support.model.dlna.DLNAProfiles;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@RequiresApi(18)
/* renamed from: me.tvspark.v6 */
/* loaded from: classes4.dex */
public final class C2699v6 implements AbstractC2624t6 {
    public static final AbstractC2624t6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2248j6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final MediaDrm Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final UUID Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2699v6(UUID uuid) throws UnsupportedSchemeException {
        if (uuid != null) {
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(uuid), (Object) "Use C.CLEARKEY_UUID instead");
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = uuid;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new MediaDrm((C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 27 || !C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(uuid)) ? uuid : C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
            if (!C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(uuid) || !"ASUS_Z00AD".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setPropertyString("securityLevel", "L3");
            return;
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2624t6
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr) throws DeniedByServerException {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.provideProvisionResponse(bArr);
    }

    @Override // me.tvspark.AbstractC2624t6
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.closeSession(bArr);
    }

    @Override // me.tvspark.AbstractC2624t6
    public byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws MediaDrmException {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.openSession();
    }

    @Override // me.tvspark.AbstractC2624t6
    public AbstractC2587s6 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr) throws MediaCryptoException {
        boolean z = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 21 && C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && "L3".equals(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getPropertyString("securityLevel"));
        UUID uuid = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 27 && C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(uuid)) {
            uuid = C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return new C2661u6(uuid, bArr, z);
    }

    @Override // me.tvspark.AbstractC2624t6
    public AbstractC2624t6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        MediaDrm.ProvisionRequest provisionRequest = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getProvisionRequest();
        return new AbstractC2624t6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(provisionRequest.getData(), provisionRequest.getDefaultUrl());
    }

    @Override // me.tvspark.AbstractC2624t6
    public Class<C2661u6> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return C2661u6.class;
    }

    @Override // me.tvspark.AbstractC2624t6
    public Map<String, String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.queryKeyStatus(bArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00d5  */
    @Override // me.tvspark.AbstractC2624t6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AbstractC2624t6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, @Nullable List<C2322l6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> list, int i, @Nullable HashMap<String, String> hashMap) throws NotProvisionedException {
        byte[] bArr2;
        String str;
        C2322l6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        UUID uuid;
        byte[] bArr3;
        boolean z;
        C2322l6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = null;
        if (list != null) {
            if (C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 28 && list.size() > 1) {
                    C2322l6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = list.get(0);
                    int i2 = 0;
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        C2322l6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = list.get(i3);
                        byte[] bArr4 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwww;
                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr4);
                        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwww, (Object) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwww) && C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwww, (Object) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwww)) {
                            if (Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr4) != null) {
                                i2 += bArr4.length;
                            }
                        }
                        z = false;
                    }
                    z = true;
                    if (z) {
                        byte[] bArr5 = new byte[i2];
                        int i4 = 0;
                        for (int i5 = 0; i5 < list.size(); i5++) {
                            byte[] bArr6 = list.get(i5).Wwwwwwwwwwwwwwwwwwww;
                            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr6);
                            int length = bArr6.length;
                            System.arraycopy(bArr6, 0, bArr5, i4, length);
                            i4 += length;
                        }
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2322l6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwww, bArr5);
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        uuid = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        byte[] bArr7 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwww;
                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr7);
                        bArr3 = bArr7;
                        if (C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(uuid)) {
                            byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr3, uuid);
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                                bArr3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            }
                            UUID uuid2 = C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            C2078el c2078el = new C2078el(bArr3);
                            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            short Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            short Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww == 1 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 1) {
                                String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(), C2160gt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.contains("<LA_URL>")) {
                                    int indexOf = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.indexOf("</DATA>");
                                    String substring = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.substring(0, indexOf);
                                    String substring2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.substring(indexOf);
                                    StringBuilder sb = new StringBuilder(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(substring2, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(substring, 26)));
                                    sb.append(substring);
                                    sb.append("<LA_URL>https://x</LA_URL>");
                                    sb.append(substring2);
                                    String sb2 = sb.toString();
                                    int i6 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 52;
                                    ByteBuffer allocate = ByteBuffer.allocate(i6);
                                    allocate.order(ByteOrder.LITTLE_ENDIAN);
                                    allocate.putInt(i6);
                                    allocate.putShort(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                    allocate.putShort(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                                    allocate.putShort((short) (sb2.length() * 2));
                                    allocate.put(sb2.getBytes(C2160gt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                                    bArr3 = allocate.array();
                                }
                            }
                            bArr3 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uuid2, bArr3);
                        }
                        if (((C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 23 || !C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(uuid)) && (!C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(uuid) || !"Amazon".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) || (!"AFTB".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && !"AFTS".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && !"AFTM".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && !"AFTT".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)))) || (r1 = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr3, uuid)) == null) {
                            byte[] bArr8 = bArr3;
                        }
                        UUID uuid3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        String str2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwww;
                        bArr2 = bArr8;
                        str = (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 26 || !C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(uuid3) || (!DLNAProfiles.DLNAMimeTypes.MIME_VIDEO_MPEG_4.equals(str2) && !DLNAProfiles.DLNAMimeTypes.MIME_AUDIO_MPEG_4.equals(str2))) ? str2 : "cenc";
                    }
                }
                for (int i7 = 0; i7 < list.size(); i7++) {
                    C2322l6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = list.get(i7);
                    byte[] bArr9 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.Wwwwwwwwwwwwwwwwwwww;
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr9);
                    C2399n9 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr9);
                    int i8 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null ? -1 : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if ((C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 23 && i8 == 0) || (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 23 && i8 == 1)) {
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5;
                        break;
                    }
                }
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = list.get(0);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            uuid = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            byte[] bArr72 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwww;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr72);
            bArr3 = bArr72;
            if (C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(uuid)) {
            }
            if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 23) {
            }
            byte[] bArr82 = bArr3;
            UUID uuid32 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            String str22 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwww;
            bArr2 = bArr82;
            str = (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 26 || !C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(uuid32) || (!DLNAProfiles.DLNAMimeTypes.MIME_VIDEO_MPEG_4.equals(str22) && !DLNAProfiles.DLNAMimeTypes.MIME_AUDIO_MPEG_4.equals(str22))) ? str22 : "cenc";
        } else {
            bArr2 = null;
            str = null;
        }
        MediaDrm.KeyRequest keyRequest = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getKeyRequest(bArr, bArr2, str, i, hashMap);
        UUID uuid4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        byte[] data = keyRequest.getData();
        if (C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(uuid4) && C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 27) {
            data = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(data).replace('+', '-').replace('/', '_'));
        }
        String defaultUrl = keyRequest.getDefaultUrl();
        if ("https://x".equals(defaultUrl)) {
            defaultUrl = "";
        }
        if (TextUtils.isEmpty(defaultUrl) && wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null && !TextUtils.isEmpty(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwww)) {
            defaultUrl = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwww;
        }
        return new AbstractC2624t6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(data, defaultUrl);
    }

    @Override // me.tvspark.AbstractC2624t6
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable final AbstractC2624t6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnEventListener(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null ? null : new MediaDrm.OnEventListener() { // from class: me.tvspark.k6
            @Override // android.media.MediaDrm.OnEventListener
            public final void onEvent(MediaDrm mediaDrm, byte[] bArr, int i, int i2, byte[] bArr2) {
                C2699v6.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, mediaDrm, bArr, i, i2, bArr2);
            }
        });
    }

    @Override // me.tvspark.AbstractC2624t6
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, byte[] bArr2) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.restoreKeys(bArr, bArr2);
    }

    @Override // me.tvspark.AbstractC2624t6
    public synchronized void release() {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        if (i == 0) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.release();
        }
    }

    @Override // me.tvspark.AbstractC2624t6
    @Nullable
    public byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, byte[] bArr2) throws NotProvisionedException, DeniedByServerException {
        if (C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 27) {
            try {
                JSONObject jSONObject = new JSONObject(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr2));
                StringBuilder sb = new StringBuilder("{\"keys\":[");
                JSONArray jSONArray = jSONObject.getJSONArray(SavedStateHandle.KEYS);
                for (int i = 0; i < jSONArray.length(); i++) {
                    if (i != 0) {
                        sb.append(",");
                    }
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    sb.append("{\"k\":\"");
                    sb.append(jSONObject2.getString("k").replace('-', '+').replace('_', '/'));
                    sb.append("\",\"kid\":\"");
                    sb.append(jSONObject2.getString("kid").replace('-', '+').replace('_', '/'));
                    sb.append("\",\"kty\":\"");
                    sb.append(jSONObject2.getString("kty"));
                    sb.append("\"}");
                }
                sb.append("]}");
                bArr2 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb.toString());
            } catch (JSONException e) {
                String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr2);
                C2827yk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length() != 0 ? "Failed to adjust response data: ".concat(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) : new String("Failed to adjust response data: "), e);
            }
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.provideKeyResponse(bArr, bArr2);
    }

    public /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2624t6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, MediaDrm mediaDrm, byte[] bArr, int i, int i2, byte[] bArr2) {
        DefaultDrmSessionManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = DefaultDrmSessionManager.this.Wwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.obtainMessage(i, bArr).sendToTarget();
    }

    public static /* synthetic */ AbstractC2624t6 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(UUID uuid) {
        try {
            try {
                return new C2699v6(uuid);
            } catch (UnsupportedDrmException unused) {
                String.valueOf(uuid).length();
                return new C2513q6();
            }
        } catch (UnsupportedSchemeException e) {
            throw new UnsupportedDrmException(1, e);
        } catch (Exception e2) {
            throw new UnsupportedDrmException(2, e2);
        }
    }
}
