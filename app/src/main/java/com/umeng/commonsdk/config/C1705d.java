package com.umeng.commonsdk.config;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.umeng.commonsdk.config.d */
/* loaded from: classes4.dex */
public class C1705d {

    /* renamed from: a */
    public static final long f3749a = 1000;

    /* renamed from: b */
    public static final String f3750b = "_LAST_FIELD";

    /* renamed from: c */
    public static final String f3751c = "3758096383";

    /* renamed from: d */
    public static final String f3752d = "2147483647";

    /* renamed from: e */
    public static final String f3753e = "262143";

    /* renamed from: f */
    public static final String f3754f = "2047";

    /* renamed from: g */
    public static final int f3755g = 64;

    /* renamed from: l */
    public static Map<String, String[]> f3760l = new HashMap();

    /* renamed from: h */
    public static String[] f3756h = new String[EnumC1706a.values().length];

    /* renamed from: i */
    public static String[] f3757i = new String[EnumC1707b.values().length];

    /* renamed from: j */
    public static String[] f3758j = new String[EnumC1708c.values().length];

    /* renamed from: k */
    public static String[] f3759k = new String[EnumC1709d.values().length];

    /* renamed from: com.umeng.commonsdk.config.d$a */
    /* loaded from: classes4.dex */
    public enum EnumC1706a {
        header_utoken,
        header_cpu,
        header_mccmnc,
        header_sub_os_name,
        header_sub_os_version,
        header_device_type,
        header_device_id_imei,
        header_device_id_mac,
        header_device_id_android_id,
        header_device_id_serialNo,
        header_bulid,
        header_os_version,
        header_resolution,
        header_mc,
        header_timezone,
        header_local_info,
        header_carrier,
        header_access,
        header_tracking_imei,
        header_tracking_android_id,
        header_tracking_utdid,
        header_tracking_idmd5,
        header_tracking_idfa,
        header_tracking_mac,
        header_tracking_serial,
        header_tracking_uuid,
        header_tracking_uop,
        header_tracking_oldumid,
        header_tracking_newumid,
        header_ekv_send_on_exit,
        header_device_oaid,
        header_local_ip,
        header_foreground_count,
        header_first_resume,
        _LAST_FIELD
    }

    /* renamed from: com.umeng.commonsdk.config.d$b */
    /* loaded from: classes4.dex */
    public enum EnumC1707b {
        inner_rs,
        inner_by,
        inner_gp,
        inner_to,
        inner_mo,
        inner_ca,
        inner_fl,
        inner_gdf_r,
        inner_thm_z,
        inner_dsk_s,
        inner_sd,
        inner_build,
        inner_sr,
        inner_scr,
        inner_sinfo,
        inner_winfo,
        inner_input,
        inner_bt,
        inner_mem,
        inner_cpu,
        inner_rom,
        inner_bstn,
        inner_cam,
        inner_appls,
        inner_lbs,
        internal_run_server,
        internal_imsi,
        internal_meid,
        tp_tp,
        inner_imei2,
        inner_iccid,
        _LAST_FIELD
    }

    /* renamed from: com.umeng.commonsdk.config.d$c */
    /* loaded from: classes4.dex */
    public enum EnumC1708c {
        push_cpu,
        push_imei,
        push_mac,
        push_android_id,
        push_serialNo,
        push_settings_android_id,
        push_network_access_mode,
        push_on_line,
        push_time_zone,
        push_locale_info,
        push_resolution,
        push_operator,
        push_utdid,
        push_service_work,
        push_service_name,
        push_intent_exist,
        push_data_data,
        push_notification_enabled,
        _LAST_FIELD
    }

    /* renamed from: com.umeng.commonsdk.config.d$d */
    /* loaded from: classes4.dex */
    public enum EnumC1709d {
        share_device_id,
        share_imsi,
        share_iccid,
        share_sn,
        share_net_accmode,
        share_android_id,
        share_wifi_mac,
        share_sd_size,
        share_ssid,
        share_resolution,
        share_conn_type,
        _LAST_FIELD
    }

    static {
        String[] strArr = f3756h;
        if (strArr != null && strArr.length > 0) {
            for (int i = 0; i < EnumC1706a.values().length; i++) {
                f3756h[i] = EnumC1706a.values()[i].toString();
            }
            Map<String, String[]> map = f3760l;
            if (map != null) {
                map.put(EnumC1706a.class.getName(), f3756h);
            }
        }
        String[] strArr2 = f3757i;
        if (strArr2 != null && strArr2.length > 0) {
            for (int i2 = 0; i2 < EnumC1707b.values().length; i2++) {
                f3757i[i2] = EnumC1707b.values()[i2].toString();
            }
            Map<String, String[]> map2 = f3760l;
            if (map2 != null) {
                map2.put(EnumC1707b.class.getName(), f3757i);
            }
        }
        String[] strArr3 = f3758j;
        if (strArr3 != null && strArr3.length > 0) {
            for (int i3 = 0; i3 < EnumC1708c.values().length; i3++) {
                f3758j[i3] = EnumC1708c.values()[i3].toString();
            }
            Map<String, String[]> map3 = f3760l;
            if (map3 != null) {
                map3.put(EnumC1708c.class.getName(), f3758j);
            }
        }
        String[] strArr4 = f3759k;
        if (strArr4 == null || strArr4.length <= 0) {
            return;
        }
        for (int i4 = 0; i4 < EnumC1709d.values().length; i4++) {
            f3759k[i4] = EnumC1709d.values()[i4].toString();
        }
        Map<String, String[]> map4 = f3760l;
        if (map4 == null) {
            return;
        }
        map4.put(EnumC1709d.class.getName(), f3759k);
    }

    /* renamed from: a */
    public static boolean m778a(String str) {
        return str != null && str.length() > 0 && !f3750b.equalsIgnoreCase(str);
    }

    /* renamed from: b */
    public static String[] m777b(String str) {
        if (str == null || str.length() <= 0 || !f3760l.containsKey(str)) {
            return null;
        }
        return f3760l.get(str);
    }
}
