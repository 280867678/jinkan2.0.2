package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class JavaBeanSerializer implements ObjectSerializer {
    public int features;
    public final FieldSerializer[] getters;
    public final FieldSerializer[] sortedGetters;
    public final String typeKey;
    public final String typeName;
    public static final char[] true_chars = {'t', 'r', 'u', 'e'};
    public static final char[] false_chars = {'f', 'a', 'l', 's', 'e'};

    public JavaBeanSerializer(Class<?> cls) {
        this(cls, (PropertyNamingStrategy) null);
    }

    public JavaBeanSerializer(Class<?> cls, int i, Map<String, String> map, boolean z, boolean z2, boolean z3, boolean z4, PropertyNamingStrategy propertyNamingStrategy) {
        PropertyNamingStrategy propertyNamingStrategy2;
        String str;
        String str2;
        PropertyNamingStrategy naming;
        this.features = 0;
        String[] strArr = null;
        JSONType jSONType = z2 ? (JSONType) cls.getAnnotation(JSONType.class) : null;
        if (jSONType != null) {
            this.features = SerializerFeature.m4193of(jSONType.serialzeFeatures());
            str = jSONType.typeName();
            if (str.length() == 0) {
                str = null;
                str2 = null;
            } else {
                str2 = null;
                for (Class<? super Object> superclass = cls.getSuperclass(); superclass != null && superclass != Object.class; superclass = superclass.getSuperclass()) {
                    JSONType jSONType2 = (JSONType) superclass.getAnnotation(JSONType.class);
                    if (jSONType2 == null) {
                        break;
                    }
                    str2 = jSONType2.typeKey();
                    if (str2.length() != 0) {
                        break;
                    }
                }
                for (Class<?> cls2 : cls.getInterfaces()) {
                    JSONType jSONType3 = (JSONType) cls2.getAnnotation(JSONType.class);
                    if (jSONType3 != null) {
                        str2 = jSONType3.typeKey();
                        if (str2.length() != 0) {
                            break;
                        }
                    }
                }
                if (str2 != null && str2.length() == 0) {
                    str2 = null;
                }
            }
            propertyNamingStrategy2 = (propertyNamingStrategy != null || (naming = jSONType.naming()) == PropertyNamingStrategy.CamelCase) ? propertyNamingStrategy : naming;
        } else {
            propertyNamingStrategy2 = propertyNamingStrategy;
            str = null;
            str2 = null;
        }
        this.typeName = str;
        this.typeKey = str2;
        List<FieldInfo> computeGetters = TypeUtils.computeGetters(cls, i, z, jSONType, map, false, z3, z4, propertyNamingStrategy2);
        ArrayList arrayList = new ArrayList();
        for (FieldInfo fieldInfo : computeGetters) {
            arrayList.add(new FieldSerializer(fieldInfo));
        }
        this.getters = (FieldSerializer[]) arrayList.toArray(new FieldSerializer[arrayList.size()]);
        strArr = jSONType != null ? jSONType.orders() : strArr;
        if (strArr != null && strArr.length != 0) {
            List<FieldInfo> computeGetters2 = TypeUtils.computeGetters(cls, i, z, jSONType, map, true, z3, z4, propertyNamingStrategy2);
            ArrayList arrayList2 = new ArrayList();
            for (FieldInfo fieldInfo2 : computeGetters2) {
                arrayList2.add(new FieldSerializer(fieldInfo2));
            }
            this.sortedGetters = (FieldSerializer[]) arrayList2.toArray(new FieldSerializer[arrayList2.size()]);
            return;
        }
        FieldSerializer[] fieldSerializerArr = this.getters;
        FieldSerializer[] fieldSerializerArr2 = new FieldSerializer[fieldSerializerArr.length];
        System.arraycopy(fieldSerializerArr, 0, fieldSerializerArr2, 0, fieldSerializerArr.length);
        Arrays.sort(fieldSerializerArr2);
        if (Arrays.equals(fieldSerializerArr2, this.getters)) {
            this.sortedGetters = this.getters;
        } else {
            this.sortedGetters = fieldSerializerArr2;
        }
    }

    public JavaBeanSerializer(Class<?> cls, PropertyNamingStrategy propertyNamingStrategy) {
        this(cls, cls.getModifiers(), null, false, true, true, true, propertyNamingStrategy);
    }

    public JavaBeanSerializer(Class<?> cls, String... strArr) {
        this(cls, cls.getModifiers(), map(strArr), false, true, true, true, null);
    }

    public static Map<String, String> map(String... strArr) {
        HashMap hashMap = new HashMap();
        for (String str : strArr) {
            hashMap.put(str, str);
        }
        return hashMap;
    }

    public Map<String, Object> getFieldValuesMap(Object obj) throws Exception {
        FieldSerializer[] fieldSerializerArr;
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            linkedHashMap.put(fieldSerializer.fieldInfo.name, fieldSerializer.getPropertyValue(obj));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:126:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0258 A[Catch: all -> 0x05cc, Exception -> 0x05d2, TryCatch #6 {Exception -> 0x05d2, all -> 0x05cc, blocks: (B:93:0x017a, B:95:0x0195, B:97:0x0199, B:106:0x019e, B:108:0x01a2, B:112:0x01ad, B:113:0x01b1, B:115:0x01b7, B:120:0x01d4, B:122:0x01db, B:124:0x01df, B:127:0x022b, B:129:0x0231, B:131:0x024e, B:132:0x0252, B:134:0x0258, B:144:0x0280, B:146:0x0284, B:148:0x028b, B:150:0x028f, B:151:0x0294, B:153:0x0298, B:154:0x029d, B:155:0x02a4, B:157:0x02aa, B:162:0x02c4, B:164:0x02c8, B:166:0x02cf, B:168:0x02d3, B:169:0x02d8, B:171:0x02dc, B:172:0x02e1, B:173:0x02e8, B:175:0x02ee, B:183:0x0310, B:185:0x031e, B:187:0x0329, B:189:0x032d, B:192:0x0338, B:194:0x033c, B:202:0x03f7, B:204:0x03fb, B:206:0x03ff, B:208:0x0403, B:210:0x0407, B:212:0x040b, B:214:0x041d, B:216:0x0421, B:218:0x0425, B:220:0x040f, B:222:0x0413, B:226:0x0435, B:228:0x043e, B:230:0x0442, B:231:0x0446, B:232:0x044a, B:234:0x045d, B:237:0x0467, B:238:0x046b, B:244:0x0475, B:247:0x047d, B:249:0x0488, B:251:0x048c, B:253:0x0491, B:257:0x04b1, B:259:0x04bb, B:262:0x04c2, B:266:0x04cc, B:270:0x04d8, B:274:0x04e2, B:275:0x04e4, B:277:0x04ec, B:279:0x04f0, B:280:0x04f4, B:282:0x0503, B:285:0x050d, B:287:0x0511, B:288:0x051a, B:291:0x0520, B:292:0x052d, B:295:0x053e, B:297:0x0545, B:299:0x054e, B:302:0x0556, B:303:0x055b, B:304:0x0562, B:306:0x0566, B:307:0x056b, B:308:0x0572, B:311:0x057a, B:313:0x0583, B:317:0x0597, B:318:0x059c, B:320:0x05a1, B:321:0x05ac, B:322:0x05b1, B:324:0x0345, B:328:0x0356, B:330:0x0361, B:332:0x0365, B:335:0x0370, B:337:0x0373, B:342:0x037c, B:344:0x0386, B:346:0x0391, B:348:0x0395, B:351:0x039c, B:353:0x039f, B:355:0x03a4, B:356:0x03ab, B:358:0x03b3, B:360:0x03be, B:362:0x03c2, B:365:0x03c9, B:367:0x03cc, B:369:0x03d1, B:371:0x03d8, B:373:0x03dc, B:381:0x0238, B:383:0x023c, B:384:0x0241, B:386:0x0245, B:390:0x01ef, B:392:0x01f3, B:394:0x01ff, B:396:0x0203, B:397:0x0213, B:399:0x021a, B:423:0x05e7, B:424:0x05ed, B:426:0x05f3, B:432:0x0605, B:434:0x060e, B:437:0x061d, B:439:0x0621, B:440:0x0625), top: B:92:0x017a }] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0435 A[Catch: all -> 0x05cc, Exception -> 0x05d2, TryCatch #6 {Exception -> 0x05d2, all -> 0x05cc, blocks: (B:93:0x017a, B:95:0x0195, B:97:0x0199, B:106:0x019e, B:108:0x01a2, B:112:0x01ad, B:113:0x01b1, B:115:0x01b7, B:120:0x01d4, B:122:0x01db, B:124:0x01df, B:127:0x022b, B:129:0x0231, B:131:0x024e, B:132:0x0252, B:134:0x0258, B:144:0x0280, B:146:0x0284, B:148:0x028b, B:150:0x028f, B:151:0x0294, B:153:0x0298, B:154:0x029d, B:155:0x02a4, B:157:0x02aa, B:162:0x02c4, B:164:0x02c8, B:166:0x02cf, B:168:0x02d3, B:169:0x02d8, B:171:0x02dc, B:172:0x02e1, B:173:0x02e8, B:175:0x02ee, B:183:0x0310, B:185:0x031e, B:187:0x0329, B:189:0x032d, B:192:0x0338, B:194:0x033c, B:202:0x03f7, B:204:0x03fb, B:206:0x03ff, B:208:0x0403, B:210:0x0407, B:212:0x040b, B:214:0x041d, B:216:0x0421, B:218:0x0425, B:220:0x040f, B:222:0x0413, B:226:0x0435, B:228:0x043e, B:230:0x0442, B:231:0x0446, B:232:0x044a, B:234:0x045d, B:237:0x0467, B:238:0x046b, B:244:0x0475, B:247:0x047d, B:249:0x0488, B:251:0x048c, B:253:0x0491, B:257:0x04b1, B:259:0x04bb, B:262:0x04c2, B:266:0x04cc, B:270:0x04d8, B:274:0x04e2, B:275:0x04e4, B:277:0x04ec, B:279:0x04f0, B:280:0x04f4, B:282:0x0503, B:285:0x050d, B:287:0x0511, B:288:0x051a, B:291:0x0520, B:292:0x052d, B:295:0x053e, B:297:0x0545, B:299:0x054e, B:302:0x0556, B:303:0x055b, B:304:0x0562, B:306:0x0566, B:307:0x056b, B:308:0x0572, B:311:0x057a, B:313:0x0583, B:317:0x0597, B:318:0x059c, B:320:0x05a1, B:321:0x05ac, B:322:0x05b1, B:324:0x0345, B:328:0x0356, B:330:0x0361, B:332:0x0365, B:335:0x0370, B:337:0x0373, B:342:0x037c, B:344:0x0386, B:346:0x0391, B:348:0x0395, B:351:0x039c, B:353:0x039f, B:355:0x03a4, B:356:0x03ab, B:358:0x03b3, B:360:0x03be, B:362:0x03c2, B:365:0x03c9, B:367:0x03cc, B:369:0x03d1, B:371:0x03d8, B:373:0x03dc, B:381:0x0238, B:383:0x023c, B:384:0x0241, B:386:0x0245, B:390:0x01ef, B:392:0x01f3, B:394:0x01ff, B:396:0x0203, B:397:0x0213, B:399:0x021a, B:423:0x05e7, B:424:0x05ed, B:426:0x05f3, B:432:0x0605, B:434:0x060e, B:437:0x061d, B:439:0x0621, B:440:0x0625), top: B:92:0x017a }] */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0465  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0471  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0503 A[Catch: all -> 0x05cc, Exception -> 0x05d2, TryCatch #6 {Exception -> 0x05d2, all -> 0x05cc, blocks: (B:93:0x017a, B:95:0x0195, B:97:0x0199, B:106:0x019e, B:108:0x01a2, B:112:0x01ad, B:113:0x01b1, B:115:0x01b7, B:120:0x01d4, B:122:0x01db, B:124:0x01df, B:127:0x022b, B:129:0x0231, B:131:0x024e, B:132:0x0252, B:134:0x0258, B:144:0x0280, B:146:0x0284, B:148:0x028b, B:150:0x028f, B:151:0x0294, B:153:0x0298, B:154:0x029d, B:155:0x02a4, B:157:0x02aa, B:162:0x02c4, B:164:0x02c8, B:166:0x02cf, B:168:0x02d3, B:169:0x02d8, B:171:0x02dc, B:172:0x02e1, B:173:0x02e8, B:175:0x02ee, B:183:0x0310, B:185:0x031e, B:187:0x0329, B:189:0x032d, B:192:0x0338, B:194:0x033c, B:202:0x03f7, B:204:0x03fb, B:206:0x03ff, B:208:0x0403, B:210:0x0407, B:212:0x040b, B:214:0x041d, B:216:0x0421, B:218:0x0425, B:220:0x040f, B:222:0x0413, B:226:0x0435, B:228:0x043e, B:230:0x0442, B:231:0x0446, B:232:0x044a, B:234:0x045d, B:237:0x0467, B:238:0x046b, B:244:0x0475, B:247:0x047d, B:249:0x0488, B:251:0x048c, B:253:0x0491, B:257:0x04b1, B:259:0x04bb, B:262:0x04c2, B:266:0x04cc, B:270:0x04d8, B:274:0x04e2, B:275:0x04e4, B:277:0x04ec, B:279:0x04f0, B:280:0x04f4, B:282:0x0503, B:285:0x050d, B:287:0x0511, B:288:0x051a, B:291:0x0520, B:292:0x052d, B:295:0x053e, B:297:0x0545, B:299:0x054e, B:302:0x0556, B:303:0x055b, B:304:0x0562, B:306:0x0566, B:307:0x056b, B:308:0x0572, B:311:0x057a, B:313:0x0583, B:317:0x0597, B:318:0x059c, B:320:0x05a1, B:321:0x05ac, B:322:0x05b1, B:324:0x0345, B:328:0x0356, B:330:0x0361, B:332:0x0365, B:335:0x0370, B:337:0x0373, B:342:0x037c, B:344:0x0386, B:346:0x0391, B:348:0x0395, B:351:0x039c, B:353:0x039f, B:355:0x03a4, B:356:0x03ab, B:358:0x03b3, B:360:0x03be, B:362:0x03c2, B:365:0x03c9, B:367:0x03cc, B:369:0x03d1, B:371:0x03d8, B:373:0x03dc, B:381:0x0238, B:383:0x023c, B:384:0x0241, B:386:0x0245, B:390:0x01ef, B:392:0x01f3, B:394:0x01ff, B:396:0x0203, B:397:0x0213, B:399:0x021a, B:423:0x05e7, B:424:0x05ed, B:426:0x05f3, B:432:0x0605, B:434:0x060e, B:437:0x061d, B:439:0x0621, B:440:0x0625), top: B:92:0x017a }] */
    /* JADX WARN: Removed duplicated region for block: B:323:0x0461  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:413:0x064d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:421:0x05e1  */
    /* JADX WARN: Removed duplicated region for block: B:432:0x0605 A[Catch: all -> 0x05cc, Exception -> 0x05d2, TRY_ENTER, TryCatch #6 {Exception -> 0x05d2, all -> 0x05cc, blocks: (B:93:0x017a, B:95:0x0195, B:97:0x0199, B:106:0x019e, B:108:0x01a2, B:112:0x01ad, B:113:0x01b1, B:115:0x01b7, B:120:0x01d4, B:122:0x01db, B:124:0x01df, B:127:0x022b, B:129:0x0231, B:131:0x024e, B:132:0x0252, B:134:0x0258, B:144:0x0280, B:146:0x0284, B:148:0x028b, B:150:0x028f, B:151:0x0294, B:153:0x0298, B:154:0x029d, B:155:0x02a4, B:157:0x02aa, B:162:0x02c4, B:164:0x02c8, B:166:0x02cf, B:168:0x02d3, B:169:0x02d8, B:171:0x02dc, B:172:0x02e1, B:173:0x02e8, B:175:0x02ee, B:183:0x0310, B:185:0x031e, B:187:0x0329, B:189:0x032d, B:192:0x0338, B:194:0x033c, B:202:0x03f7, B:204:0x03fb, B:206:0x03ff, B:208:0x0403, B:210:0x0407, B:212:0x040b, B:214:0x041d, B:216:0x0421, B:218:0x0425, B:220:0x040f, B:222:0x0413, B:226:0x0435, B:228:0x043e, B:230:0x0442, B:231:0x0446, B:232:0x044a, B:234:0x045d, B:237:0x0467, B:238:0x046b, B:244:0x0475, B:247:0x047d, B:249:0x0488, B:251:0x048c, B:253:0x0491, B:257:0x04b1, B:259:0x04bb, B:262:0x04c2, B:266:0x04cc, B:270:0x04d8, B:274:0x04e2, B:275:0x04e4, B:277:0x04ec, B:279:0x04f0, B:280:0x04f4, B:282:0x0503, B:285:0x050d, B:287:0x0511, B:288:0x051a, B:291:0x0520, B:292:0x052d, B:295:0x053e, B:297:0x0545, B:299:0x054e, B:302:0x0556, B:303:0x055b, B:304:0x0562, B:306:0x0566, B:307:0x056b, B:308:0x0572, B:311:0x057a, B:313:0x0583, B:317:0x0597, B:318:0x059c, B:320:0x05a1, B:321:0x05ac, B:322:0x05b1, B:324:0x0345, B:328:0x0356, B:330:0x0361, B:332:0x0365, B:335:0x0370, B:337:0x0373, B:342:0x037c, B:344:0x0386, B:346:0x0391, B:348:0x0395, B:351:0x039c, B:353:0x039f, B:355:0x03a4, B:356:0x03ab, B:358:0x03b3, B:360:0x03be, B:362:0x03c2, B:365:0x03c9, B:367:0x03cc, B:369:0x03d1, B:371:0x03d8, B:373:0x03dc, B:381:0x0238, B:383:0x023c, B:384:0x0241, B:386:0x0245, B:390:0x01ef, B:392:0x01f3, B:394:0x01ff, B:396:0x0203, B:397:0x0213, B:399:0x021a, B:423:0x05e7, B:424:0x05ed, B:426:0x05f3, B:432:0x0605, B:434:0x060e, B:437:0x061d, B:439:0x0621, B:440:0x0625), top: B:92:0x017a }] */
    /* JADX WARN: Removed duplicated region for block: B:437:0x061d A[Catch: all -> 0x05cc, Exception -> 0x05d2, TRY_ENTER, TryCatch #6 {Exception -> 0x05d2, all -> 0x05cc, blocks: (B:93:0x017a, B:95:0x0195, B:97:0x0199, B:106:0x019e, B:108:0x01a2, B:112:0x01ad, B:113:0x01b1, B:115:0x01b7, B:120:0x01d4, B:122:0x01db, B:124:0x01df, B:127:0x022b, B:129:0x0231, B:131:0x024e, B:132:0x0252, B:134:0x0258, B:144:0x0280, B:146:0x0284, B:148:0x028b, B:150:0x028f, B:151:0x0294, B:153:0x0298, B:154:0x029d, B:155:0x02a4, B:157:0x02aa, B:162:0x02c4, B:164:0x02c8, B:166:0x02cf, B:168:0x02d3, B:169:0x02d8, B:171:0x02dc, B:172:0x02e1, B:173:0x02e8, B:175:0x02ee, B:183:0x0310, B:185:0x031e, B:187:0x0329, B:189:0x032d, B:192:0x0338, B:194:0x033c, B:202:0x03f7, B:204:0x03fb, B:206:0x03ff, B:208:0x0403, B:210:0x0407, B:212:0x040b, B:214:0x041d, B:216:0x0421, B:218:0x0425, B:220:0x040f, B:222:0x0413, B:226:0x0435, B:228:0x043e, B:230:0x0442, B:231:0x0446, B:232:0x044a, B:234:0x045d, B:237:0x0467, B:238:0x046b, B:244:0x0475, B:247:0x047d, B:249:0x0488, B:251:0x048c, B:253:0x0491, B:257:0x04b1, B:259:0x04bb, B:262:0x04c2, B:266:0x04cc, B:270:0x04d8, B:274:0x04e2, B:275:0x04e4, B:277:0x04ec, B:279:0x04f0, B:280:0x04f4, B:282:0x0503, B:285:0x050d, B:287:0x0511, B:288:0x051a, B:291:0x0520, B:292:0x052d, B:295:0x053e, B:297:0x0545, B:299:0x054e, B:302:0x0556, B:303:0x055b, B:304:0x0562, B:306:0x0566, B:307:0x056b, B:308:0x0572, B:311:0x057a, B:313:0x0583, B:317:0x0597, B:318:0x059c, B:320:0x05a1, B:321:0x05ac, B:322:0x05b1, B:324:0x0345, B:328:0x0356, B:330:0x0361, B:332:0x0365, B:335:0x0370, B:337:0x0373, B:342:0x037c, B:344:0x0386, B:346:0x0391, B:348:0x0395, B:351:0x039c, B:353:0x039f, B:355:0x03a4, B:356:0x03ab, B:358:0x03b3, B:360:0x03be, B:362:0x03c2, B:365:0x03c9, B:367:0x03cc, B:369:0x03d1, B:371:0x03d8, B:373:0x03dc, B:381:0x0238, B:383:0x023c, B:384:0x0241, B:386:0x0245, B:390:0x01ef, B:392:0x01f3, B:394:0x01ff, B:396:0x0203, B:397:0x0213, B:399:0x021a, B:423:0x05e7, B:424:0x05ed, B:426:0x05f3, B:432:0x0605, B:434:0x060e, B:437:0x061d, B:439:0x0621, B:440:0x0625), top: B:92:0x017a }] */
    /* JADX WARN: Removed duplicated region for block: B:453:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:454:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:461:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:462:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x011d A[Catch: all -> 0x0099, Exception -> 0x009e, TRY_ENTER, TryCatch #8 {Exception -> 0x009e, all -> 0x0099, blocks: (B:467:0x008c, B:469:0x0090, B:470:0x0094, B:33:0x00ae, B:35:0x00b7, B:39:0x00c6, B:42:0x00d1, B:44:0x00da, B:46:0x00de, B:51:0x00ea, B:53:0x00f0, B:55:0x00f4, B:56:0x00fb, B:58:0x0103, B:59:0x010b, B:66:0x011d, B:67:0x0123, B:69:0x0129, B:76:0x0142, B:463:0x00f7), top: B:466:0x008c }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0142 A[Catch: all -> 0x0099, Exception -> 0x009e, TRY_ENTER, TRY_LEAVE, TryCatch #8 {Exception -> 0x009e, all -> 0x0099, blocks: (B:467:0x008c, B:469:0x0090, B:470:0x0094, B:33:0x00ae, B:35:0x00b7, B:39:0x00c6, B:42:0x00d1, B:44:0x00da, B:46:0x00de, B:51:0x00ea, B:53:0x00f0, B:55:0x00f4, B:56:0x00fb, B:58:0x0103, B:59:0x010b, B:66:0x011d, B:67:0x0123, B:69:0x0129, B:76:0x0142, B:463:0x00f7), top: B:466:0x008c }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x017a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) throws IOException {
        IdentityHashMap<Object, SerialContext> identityHashMap;
        SerialContext serialContext;
        Exception exc;
        Throwable th;
        boolean z;
        boolean z2;
        boolean z3;
        int i;
        FieldSerializer[] fieldSerializerArr;
        int i2;
        int i3;
        boolean z4;
        long j;
        boolean z5;
        boolean z6;
        int i4;
        boolean z7;
        List<PropertyPreFilter> list;
        boolean z8;
        List<NameFilter> list2;
        String str;
        List<ValueFilter> list3;
        Object obj3;
        Object obj4;
        FieldInfo fieldInfo;
        List<PropertyFilter> list4;
        Class<String> cls;
        String str2;
        Object obj5;
        int i5;
        boolean z9;
        int i6;
        Object obj6;
        Object obj7 = obj;
        Class<String> cls2 = String.class;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj7 == null) {
            serializeWriter.writeNull();
            return;
        }
        SerialContext serialContext2 = jSONSerializer.context;
        if ((serialContext2 == null || (serialContext2.features & SerializerFeature.DisableCircularReferenceDetect.mask) == 0) && (identityHashMap = jSONSerializer.references) != null && identityHashMap.containsKey(obj7)) {
            jSONSerializer.writeReference(obj);
            return;
        }
        FieldSerializer[] fieldSerializerArr2 = (serializeWriter.features & SerializerFeature.SortField.mask) != 0 ? this.sortedGetters : this.getters;
        SerialContext serialContext3 = jSONSerializer.context;
        if ((serializeWriter.features & SerializerFeature.DisableCircularReferenceDetect.mask) == 0) {
            jSONSerializer.context = new SerialContext(serialContext3, obj7, obj2, this.features);
            if (jSONSerializer.references == null) {
                jSONSerializer.references = new IdentityHashMap<>();
            }
            jSONSerializer.references.put(obj7, jSONSerializer.context);
        }
        int i7 = this.features;
        int i8 = SerializerFeature.BeanToArray.mask;
        boolean z10 = ((i7 & i8) == 0 && (serializeWriter.features & i8) == 0) ? false : true;
        char c = z10 ? '[' : '{';
        char c2 = z10 ? ']' : '}';
        try {
            int i9 = serializeWriter.count + 1;
            if (i9 > serializeWriter.buf.length) {
                try {
                    if (serializeWriter.writer == null) {
                        serializeWriter.expandCapacity(i9);
                    } else {
                        serializeWriter.flush();
                        i9 = 1;
                    }
                } catch (Exception e) {
                    exc = e;
                    serialContext = serialContext3;
                    String str3 = "write javaBean error, fastjson version 1.1.72";
                    if (obj2 != null) {
                        try {
                            str3 = str3 + ", fieldName : " + obj2;
                        } catch (Throwable th2) {
                            th = th2;
                            th = th;
                            jSONSerializer.context = serialContext;
                            throw th;
                        }
                    }
                    throw new JSONException(str3, exc);
                } catch (Throwable th3) {
                    th = th3;
                    serialContext = serialContext3;
                    jSONSerializer.context = serialContext;
                    throw th;
                }
            }
            serializeWriter.buf[serializeWriter.count] = c;
            serializeWriter.count = i9;
            if (fieldSerializerArr2.length > 0 && (serializeWriter.features & SerializerFeature.PrettyFormat.mask) != 0) {
                jSONSerializer.incrementIndent();
                jSONSerializer.println();
            }
        } catch (Exception e2) {
            e = e2;
            serialContext = serialContext3;
        } catch (Throwable th4) {
            th = th4;
            serialContext = serialContext3;
        }
        try {
            if ((this.features & SerializerFeature.WriteClassName.mask) == 0 && ((serializeWriter.features & SerializerFeature.WriteClassName.mask) == 0 || (type == null && (serializeWriter.features & SerializerFeature.NotWriteRootClassName.mask) != 0 && (jSONSerializer.context == null || jSONSerializer.context.parent == null)))) {
                z = false;
                if (z || obj.getClass() == type) {
                    z2 = false;
                } else {
                    serializeWriter.writeFieldName(this.typeKey != null ? this.typeKey : jSONSerializer.config.typeKey, false);
                    String str4 = this.typeName;
                    if (str4 == null) {
                        str4 = obj.getClass().getName();
                    }
                    jSONSerializer.write(str4);
                    z2 = true;
                }
                char c3 = !z2 ? ',' : (char) 0;
                if (jSONSerializer.beforeFilters != null) {
                    for (BeforeFilter beforeFilter : jSONSerializer.beforeFilters) {
                        c3 = beforeFilter.writeBefore(jSONSerializer, obj7, c3);
                    }
                }
                boolean z11 = c3 != ',';
                if ((serializeWriter.features & SerializerFeature.QuoteFieldNames.mask) != 0) {
                    if ((serializeWriter.features & SerializerFeature.UseSingleQuotes.mask) == 0) {
                        z3 = true;
                        boolean z12 = (serializeWriter.features & SerializerFeature.UseSingleQuotes.mask) != 0;
                        boolean z13 = (SerializerFeature.NotWriteDefaultValue.mask & serializeWriter.features) != 0;
                        List<PropertyFilter> list5 = jSONSerializer.propertyFilters;
                        boolean z14 = z11;
                        List<NameFilter> list6 = jSONSerializer.nameFilters;
                        List<ValueFilter> list7 = jSONSerializer.valueFilters;
                        List<PropertyPreFilter> list8 = jSONSerializer.propertyPreFilters;
                        boolean z15 = z12;
                        char c4 = c2;
                        i = 0;
                        while (i < fieldSerializerArr2.length) {
                            try {
                                FieldSerializer fieldSerializer = fieldSerializerArr2[i];
                                FieldSerializer[] fieldSerializerArr3 = fieldSerializerArr2;
                                FieldInfo fieldInfo2 = fieldSerializer.fieldInfo;
                                int i10 = i;
                                Class<?> cls3 = fieldInfo2.fieldClass;
                                boolean z16 = z3;
                                String str5 = fieldInfo2.name;
                                boolean z17 = z13;
                                Class<String> cls4 = cls2;
                                if (((SerializerFeature.SkipTransientField.mask & serializeWriter.features) == 0 || fieldInfo2.field == null || !fieldInfo2.fieldTransient) && (this.typeKey == null || !this.typeKey.equals(str5))) {
                                    if (list8 != null) {
                                        for (PropertyPreFilter propertyPreFilter : list8) {
                                            if (!propertyPreFilter.apply(jSONSerializer, obj7, str5)) {
                                                z4 = false;
                                                break;
                                            }
                                        }
                                    }
                                    z4 = true;
                                    if (z4) {
                                        Object obj8 = null;
                                        if (fieldInfo2.fieldAccess) {
                                            if (cls3 == Integer.TYPE) {
                                                j = 0;
                                                z6 = false;
                                                z7 = false;
                                                i4 = fieldInfo2.field.getInt(obj7);
                                                z5 = true;
                                            } else if (cls3 == Long.TYPE) {
                                                j = fieldInfo2.field.getLong(obj7);
                                                z5 = true;
                                                z6 = false;
                                                i4 = 0;
                                                z7 = false;
                                            } else if (cls3 == Boolean.TYPE) {
                                                z7 = fieldInfo2.field.getBoolean(obj7);
                                                j = 0;
                                                z5 = true;
                                                z6 = false;
                                                i4 = 0;
                                            } else {
                                                obj8 = fieldInfo2.field.get(obj7);
                                            }
                                            if (list5 != null) {
                                                if (z5) {
                                                    obj6 = obj8;
                                                    if (cls3 == Integer.TYPE) {
                                                        obj8 = Integer.valueOf(i4);
                                                    } else if (cls3 == Long.TYPE) {
                                                        obj8 = Long.valueOf(j);
                                                    } else if (cls3 == Boolean.TYPE) {
                                                        obj8 = Boolean.valueOf(z7);
                                                    }
                                                    z6 = true;
                                                    for (PropertyFilter propertyFilter : list5) {
                                                        list = list8;
                                                        if (!propertyFilter.apply(obj7, str5, obj8)) {
                                                            z8 = false;
                                                            break;
                                                        }
                                                        list8 = list;
                                                    }
                                                } else {
                                                    obj6 = obj8;
                                                }
                                                obj8 = obj6;
                                                while (r30.hasNext()) {
                                                }
                                            }
                                            list = list8;
                                            z8 = true;
                                            if (z8) {
                                                list3 = list7;
                                                list2 = list6;
                                                list4 = list5;
                                                cls = cls4;
                                                i = i10 + 1;
                                                cls2 = cls;
                                                fieldSerializerArr2 = fieldSerializerArr3;
                                                z3 = z16;
                                                z13 = z17;
                                                list6 = list2;
                                                list7 = list3;
                                                list8 = list;
                                                list5 = list4;
                                                obj7 = obj;
                                            } else {
                                                if (list6 != null) {
                                                    if (z5 && !z6) {
                                                        if (cls3 == Integer.TYPE) {
                                                            obj8 = Integer.valueOf(i4);
                                                        } else if (cls3 == Long.TYPE) {
                                                            obj8 = Long.valueOf(j);
                                                        } else if (cls3 == Boolean.TYPE) {
                                                            obj8 = Boolean.valueOf(z7);
                                                        }
                                                        z6 = true;
                                                    }
                                                    list2 = list6;
                                                    str = str5;
                                                    for (Iterator<NameFilter> it = list6.iterator(); it.hasNext(); it = it) {
                                                        str = it.next().process(obj7, str, obj8);
                                                    }
                                                } else {
                                                    list2 = list6;
                                                    str = str5;
                                                }
                                                if (list7 != null) {
                                                    if (z5 && !z6) {
                                                        if (cls3 == Integer.TYPE) {
                                                            obj8 = Integer.valueOf(i4);
                                                        } else if (cls3 == Long.TYPE) {
                                                            obj8 = Long.valueOf(j);
                                                        } else if (cls3 == Boolean.TYPE) {
                                                            obj8 = Boolean.valueOf(z7);
                                                        }
                                                        z6 = true;
                                                    }
                                                    list3 = list7;
                                                    Object obj9 = obj8;
                                                    for (ValueFilter valueFilter : list7) {
                                                        Object obj10 = obj8;
                                                        obj9 = valueFilter.process(obj7, str5, obj9);
                                                        obj8 = obj10;
                                                    }
                                                    Object obj11 = obj8;
                                                    obj8 = obj9;
                                                    obj3 = obj11;
                                                } else {
                                                    list3 = list7;
                                                    obj3 = obj8;
                                                }
                                                if (!z6 || obj8 != null) {
                                                    obj4 = obj8;
                                                    fieldInfo = fieldInfo2;
                                                    list4 = list5;
                                                    cls = cls4;
                                                    str2 = "";
                                                } else {
                                                    obj4 = obj8;
                                                    list4 = list5;
                                                    int i11 = fieldInfo2.serialzeFeatures | this.features | serializeWriter.features;
                                                    if (cls3 == Boolean.class) {
                                                        int i12 = SerializerFeature.WriteNullBooleanAsFalse.mask;
                                                        int i13 = SerializerFeature.WriteMapNullValue.mask | i12;
                                                        if (z10 || (i11 & i13) != 0) {
                                                            fieldInfo = fieldInfo2;
                                                        } else {
                                                            fieldInfo = fieldInfo2;
                                                            if ((i13 & serializeWriter.features) == 0) {
                                                                cls = cls4;
                                                                i = i10 + 1;
                                                                cls2 = cls;
                                                                fieldSerializerArr2 = fieldSerializerArr3;
                                                                z3 = z16;
                                                                z13 = z17;
                                                                list6 = list2;
                                                                list7 = list3;
                                                                list8 = list;
                                                                list5 = list4;
                                                                obj7 = obj;
                                                            }
                                                        }
                                                        if ((i11 & i12) == 0 && (serializeWriter.features & i12) == 0) {
                                                            obj5 = obj4;
                                                            cls = cls4;
                                                            str2 = "";
                                                        }
                                                        obj5 = false;
                                                        cls = cls4;
                                                        str2 = "";
                                                    } else {
                                                        fieldInfo = fieldInfo2;
                                                        cls = cls4;
                                                        if (cls3 == cls) {
                                                            int i14 = SerializerFeature.WriteNullStringAsEmpty.mask;
                                                            int i15 = SerializerFeature.WriteMapNullValue.mask | i14;
                                                            if (z10 || (i11 & i15) != 0) {
                                                                str2 = "";
                                                            } else {
                                                                str2 = "";
                                                                if ((serializeWriter.features & i15) == 0) {
                                                                    i = i10 + 1;
                                                                    cls2 = cls;
                                                                    fieldSerializerArr2 = fieldSerializerArr3;
                                                                    z3 = z16;
                                                                    z13 = z17;
                                                                    list6 = list2;
                                                                    list7 = list3;
                                                                    list8 = list;
                                                                    list5 = list4;
                                                                    obj7 = obj;
                                                                }
                                                            }
                                                            if ((i11 & i14) != 0 || (serializeWriter.features & i14) != 0) {
                                                                obj5 = str2;
                                                            }
                                                        } else {
                                                            str2 = "";
                                                            if (Number.class.isAssignableFrom(cls3)) {
                                                                int i16 = SerializerFeature.WriteNullNumberAsZero.mask;
                                                                int i17 = SerializerFeature.WriteMapNullValue.mask | i16;
                                                                if (!z10 && (i11 & i17) == 0 && (i17 & serializeWriter.features) == 0) {
                                                                    i = i10 + 1;
                                                                    cls2 = cls;
                                                                    fieldSerializerArr2 = fieldSerializerArr3;
                                                                    z3 = z16;
                                                                    z13 = z17;
                                                                    list6 = list2;
                                                                    list7 = list3;
                                                                    list8 = list;
                                                                    list5 = list4;
                                                                    obj7 = obj;
                                                                } else if ((i11 & i16) != 0 || (serializeWriter.features & i16) != 0) {
                                                                    obj5 = 0;
                                                                }
                                                            } else if (Collection.class.isAssignableFrom(cls3)) {
                                                                int i18 = SerializerFeature.WriteNullListAsEmpty.mask;
                                                                int i19 = SerializerFeature.WriteMapNullValue.mask | i18;
                                                                if (!z10 && (i11 & i19) == 0 && (i19 & serializeWriter.features) == 0) {
                                                                    i = i10 + 1;
                                                                    cls2 = cls;
                                                                    fieldSerializerArr2 = fieldSerializerArr3;
                                                                    z3 = z16;
                                                                    z13 = z17;
                                                                    list6 = list2;
                                                                    list7 = list3;
                                                                    list8 = list;
                                                                    list5 = list4;
                                                                    obj7 = obj;
                                                                } else if ((i11 & i18) != 0 || (serializeWriter.features & i18) != 0) {
                                                                    obj5 = Collections.emptyList();
                                                                }
                                                            } else if (!z10 && !fieldSerializer.writeNull && !serializeWriter.isEnabled(SerializerFeature.WriteMapNullValue)) {
                                                                i = i10 + 1;
                                                                cls2 = cls;
                                                                fieldSerializerArr2 = fieldSerializerArr3;
                                                                z3 = z16;
                                                                z13 = z17;
                                                                list6 = list2;
                                                                list7 = list3;
                                                                list8 = list;
                                                                list5 = list4;
                                                                obj7 = obj;
                                                            }
                                                        }
                                                    }
                                                    if (z6 || obj5 == null || !z17 || (((cls3 != Byte.TYPE && cls3 != Short.TYPE && cls3 != Integer.TYPE && cls3 != Long.TYPE && cls3 != Float.TYPE && cls3 != Double.TYPE) || !(obj5 instanceof Number) || ((Number) obj5).byteValue() != 0) && (cls3 != Boolean.TYPE || !(obj5 instanceof Boolean) || ((Boolean) obj5).booleanValue()))) {
                                                        if (z14) {
                                                            int i20 = serializeWriter.count + 1;
                                                            if (i20 > serializeWriter.buf.length) {
                                                                if (serializeWriter.writer == null) {
                                                                    serializeWriter.expandCapacity(i20);
                                                                } else {
                                                                    serializeWriter.flush();
                                                                    i20 = 1;
                                                                }
                                                            }
                                                            serializeWriter.buf[serializeWriter.count] = ',';
                                                            serializeWriter.count = i20;
                                                            if ((serializeWriter.features & SerializerFeature.PrettyFormat.mask) != 0) {
                                                                jSONSerializer.println();
                                                            }
                                                        }
                                                        if (str == str5) {
                                                            if (!z10) {
                                                                serializeWriter.writeFieldName(str, true);
                                                            }
                                                        } else if (obj3 == obj5) {
                                                            if (!z10) {
                                                                if (z16) {
                                                                    char[] cArr = fieldSerializer.name_chars;
                                                                    int length = cArr.length;
                                                                    int i21 = serializeWriter.count + length;
                                                                    if (i21 > serializeWriter.buf.length) {
                                                                        if (serializeWriter.writer == null) {
                                                                            serializeWriter.expandCapacity(i21);
                                                                        } else {
                                                                            int i22 = 0;
                                                                            do {
                                                                                int length2 = serializeWriter.buf.length - serializeWriter.count;
                                                                                System.arraycopy(cArr, i22, serializeWriter.buf, serializeWriter.count, length2);
                                                                                serializeWriter.count = serializeWriter.buf.length;
                                                                                serializeWriter.flush();
                                                                                length -= length2;
                                                                                i22 += length2;
                                                                            } while (length > serializeWriter.buf.length);
                                                                            i6 = i22;
                                                                            i21 = length;
                                                                            System.arraycopy(cArr, i6, serializeWriter.buf, serializeWriter.count, length);
                                                                            serializeWriter.count = i21;
                                                                        }
                                                                    }
                                                                    i6 = 0;
                                                                    System.arraycopy(cArr, i6, serializeWriter.buf, serializeWriter.count, length);
                                                                    serializeWriter.count = i21;
                                                                } else {
                                                                    fieldSerializer.writePrefix(jSONSerializer);
                                                                }
                                                            }
                                                            if (!z5 || z6) {
                                                                if (!z10) {
                                                                    if (cls3 == cls) {
                                                                        int i23 = fieldSerializer.features | this.features;
                                                                        if (obj5 == null) {
                                                                            if ((serializeWriter.features & SerializerFeature.WriteNullStringAsEmpty.mask) == 0 && (i23 & SerializerFeature.WriteNullStringAsEmpty.mask) == 0) {
                                                                                serializeWriter.writeNull();
                                                                            }
                                                                            serializeWriter.writeString(str2);
                                                                        } else {
                                                                            String str6 = (String) obj5;
                                                                            if (z15) {
                                                                                serializeWriter.writeStringWithSingleQuote(str6);
                                                                            } else {
                                                                                serializeWriter.writeStringWithDoubleQuote(str6, (char) 0, true);
                                                                            }
                                                                        }
                                                                    } else if (fieldInfo.isEnum) {
                                                                        if (obj5 == null) {
                                                                            serializeWriter.writeNull();
                                                                        } else if ((serializeWriter.features & SerializerFeature.WriteEnumUsingToString.mask) != 0) {
                                                                            String str7 = ((Enum) obj5).toString();
                                                                            if ((serializeWriter.features & SerializerFeature.UseSingleQuotes.mask) != 0) {
                                                                                serializeWriter.writeStringWithSingleQuote(str7);
                                                                            } else {
                                                                                serializeWriter.writeStringWithDoubleQuote(str7, (char) 0, false);
                                                                            }
                                                                        } else {
                                                                            serializeWriter.writeInt(((Enum) obj5).ordinal());
                                                                        }
                                                                        z14 = true;
                                                                        i = i10 + 1;
                                                                        cls2 = cls;
                                                                        fieldSerializerArr2 = fieldSerializerArr3;
                                                                        z3 = z16;
                                                                        z13 = z17;
                                                                        list6 = list2;
                                                                        list7 = list3;
                                                                        list8 = list;
                                                                        list5 = list4;
                                                                        obj7 = obj;
                                                                    }
                                                                }
                                                                fieldSerializer.writeValue(jSONSerializer, obj5);
                                                                z14 = true;
                                                                i = i10 + 1;
                                                                cls2 = cls;
                                                                fieldSerializerArr2 = fieldSerializerArr3;
                                                                z3 = z16;
                                                                z13 = z17;
                                                                list6 = list2;
                                                                list7 = list3;
                                                                list8 = list;
                                                                list5 = list4;
                                                                obj7 = obj;
                                                            } else if (cls3 == Integer.TYPE) {
                                                                int i24 = i4;
                                                                if (i24 == Integer.MIN_VALUE) {
                                                                    serializeWriter.write("-2147483648");
                                                                } else {
                                                                    int i25 = i24 < 0 ? -i24 : i24;
                                                                    int i26 = 0;
                                                                    do {
                                                                        i5 = SerializeWriter.sizeTable[i26];
                                                                        i26++;
                                                                    } while (i25 > i5);
                                                                    if (i24 < 0) {
                                                                        i26++;
                                                                    }
                                                                    int i27 = serializeWriter.count + i26;
                                                                    if (i27 > serializeWriter.buf.length) {
                                                                        if (serializeWriter.writer == null) {
                                                                            serializeWriter.expandCapacity(i27);
                                                                        } else {
                                                                            char[] cArr2 = new char[i26];
                                                                            SerializeWriter.getChars(i24, i26, cArr2);
                                                                            serializeWriter.write(cArr2, 0, i26);
                                                                            z9 = true;
                                                                            if (!z9) {
                                                                                SerializeWriter.getChars(i24, i27, serializeWriter.buf);
                                                                                serializeWriter.count = i27;
                                                                            }
                                                                        }
                                                                    }
                                                                    z9 = false;
                                                                    if (!z9) {
                                                                    }
                                                                }
                                                            } else if (cls3 == Long.TYPE) {
                                                                jSONSerializer.out.writeLong(j);
                                                            } else if (cls3 == Boolean.TYPE) {
                                                                if (z7) {
                                                                    jSONSerializer.out.write(true_chars, 0, true_chars.length);
                                                                } else {
                                                                    jSONSerializer.out.write(false_chars, 0, false_chars.length);
                                                                }
                                                            }
                                                            z14 = true;
                                                            i = i10 + 1;
                                                            cls2 = cls;
                                                            fieldSerializerArr2 = fieldSerializerArr3;
                                                            z3 = z16;
                                                            z13 = z17;
                                                            list6 = list2;
                                                            list7 = list3;
                                                            list8 = list;
                                                            list5 = list4;
                                                            obj7 = obj;
                                                        } else if (!z10) {
                                                            fieldSerializer.writePrefix(jSONSerializer);
                                                        }
                                                        jSONSerializer.write(obj5);
                                                        z14 = true;
                                                        i = i10 + 1;
                                                        cls2 = cls;
                                                        fieldSerializerArr2 = fieldSerializerArr3;
                                                        z3 = z16;
                                                        z13 = z17;
                                                        list6 = list2;
                                                        list7 = list3;
                                                        list8 = list;
                                                        list5 = list4;
                                                        obj7 = obj;
                                                    }
                                                    i = i10 + 1;
                                                    cls2 = cls;
                                                    fieldSerializerArr2 = fieldSerializerArr3;
                                                    z3 = z16;
                                                    z13 = z17;
                                                    list6 = list2;
                                                    list7 = list3;
                                                    list8 = list;
                                                    list5 = list4;
                                                    obj7 = obj;
                                                }
                                                obj5 = obj4;
                                                if (z6) {
                                                }
                                                if (z14) {
                                                }
                                                if (str == str5) {
                                                }
                                                jSONSerializer.write(obj5);
                                                z14 = true;
                                                i = i10 + 1;
                                                cls2 = cls;
                                                fieldSerializerArr2 = fieldSerializerArr3;
                                                z3 = z16;
                                                z13 = z17;
                                                list6 = list2;
                                                list7 = list3;
                                                list8 = list;
                                                list5 = list4;
                                                obj7 = obj;
                                            }
                                        } else {
                                            obj8 = fieldSerializer.getPropertyValue(obj7);
                                        }
                                        j = 0;
                                        z5 = false;
                                        z6 = true;
                                        i4 = 0;
                                        z7 = false;
                                        if (list5 != null) {
                                        }
                                        list = list8;
                                        z8 = true;
                                        if (z8) {
                                        }
                                    }
                                }
                                list3 = list7;
                                list2 = list6;
                                list = list8;
                                list4 = list5;
                                cls = cls4;
                                i = i10 + 1;
                                cls2 = cls;
                                fieldSerializerArr2 = fieldSerializerArr3;
                                z3 = z16;
                                z13 = z17;
                                list6 = list2;
                                list7 = list3;
                                list8 = list;
                                list5 = list4;
                                obj7 = obj;
                            } catch (Exception e3) {
                                exc = e3;
                                serialContext = serialContext3;
                                String str32 = "write javaBean error, fastjson version 1.1.72";
                                if (obj2 != null) {
                                }
                                throw new JSONException(str32, exc);
                            } catch (Throwable th5) {
                                th = th5;
                                serialContext = serialContext3;
                                jSONSerializer.context = serialContext;
                                throw th;
                            }
                        }
                        fieldSerializerArr = fieldSerializerArr2;
                        if (jSONSerializer.afterFilters != null) {
                            char c5 = z14 ? ',' : (char) 0;
                            for (AfterFilter afterFilter : jSONSerializer.afterFilters) {
                                c5 = afterFilter.writeAfter(jSONSerializer, obj, c5);
                            }
                        }
                        if (fieldSerializerArr.length > 0 && (serializeWriter.features & SerializerFeature.PrettyFormat.mask) != 0) {
                            jSONSerializer.decrementIdent();
                            jSONSerializer.println();
                        }
                        i2 = serializeWriter.count + 1;
                        if (i2 > serializeWriter.buf.length) {
                            if (serializeWriter.writer != null) {
                                serializeWriter.flush();
                                i3 = 1;
                                serializeWriter.buf[serializeWriter.count] = c4;
                                serializeWriter.count = i3;
                                jSONSerializer.context = serialContext3;
                                return;
                            }
                            serializeWriter.expandCapacity(i2);
                        }
                        i3 = i2;
                        serializeWriter.buf[serializeWriter.count] = c4;
                        serializeWriter.count = i3;
                        jSONSerializer.context = serialContext3;
                        return;
                    }
                }
                z3 = false;
                if ((serializeWriter.features & SerializerFeature.UseSingleQuotes.mask) != 0) {
                }
                if ((SerializerFeature.NotWriteDefaultValue.mask & serializeWriter.features) != 0) {
                }
                List<PropertyFilter> list52 = jSONSerializer.propertyFilters;
                boolean z142 = z11;
                List<NameFilter> list62 = jSONSerializer.nameFilters;
                List<ValueFilter> list72 = jSONSerializer.valueFilters;
                List<PropertyPreFilter> list82 = jSONSerializer.propertyPreFilters;
                boolean z152 = z12;
                char c42 = c2;
                i = 0;
                while (i < fieldSerializerArr2.length) {
                }
                fieldSerializerArr = fieldSerializerArr2;
                if (jSONSerializer.afterFilters != null) {
                }
                if (fieldSerializerArr.length > 0) {
                    jSONSerializer.decrementIdent();
                    jSONSerializer.println();
                }
                i2 = serializeWriter.count + 1;
                if (i2 > serializeWriter.buf.length) {
                }
                i3 = i2;
                serializeWriter.buf[serializeWriter.count] = c42;
                serializeWriter.count = i3;
                jSONSerializer.context = serialContext3;
                return;
            }
            List<PropertyPreFilter> list822 = jSONSerializer.propertyPreFilters;
            boolean z1522 = z12;
            char c422 = c2;
            i = 0;
            while (i < fieldSerializerArr2.length) {
            }
            fieldSerializerArr = fieldSerializerArr2;
            if (jSONSerializer.afterFilters != null) {
            }
            if (fieldSerializerArr.length > 0) {
            }
            i2 = serializeWriter.count + 1;
            if (i2 > serializeWriter.buf.length) {
            }
            i3 = i2;
            serializeWriter.buf[serializeWriter.count] = c422;
            serializeWriter.count = i3;
            jSONSerializer.context = serialContext3;
            return;
        } catch (Exception e4) {
            e = e4;
            serialContext = serialContext3;
            exc = e;
            String str322 = "write javaBean error, fastjson version 1.1.72";
            if (obj2 != null) {
            }
            throw new JSONException(str322, exc);
        } catch (Throwable th6) {
            th = th6;
            serialContext = serialContext3;
            th = th;
            jSONSerializer.context = serialContext;
            throw th;
        }
        z = true;
        if (z) {
        }
        z2 = false;
        if (!z2) {
        }
        if (jSONSerializer.beforeFilters != null) {
        }
        if (c3 != ',') {
        }
        if ((serializeWriter.features & SerializerFeature.QuoteFieldNames.mask) != 0) {
        }
        z3 = false;
        if ((serializeWriter.features & SerializerFeature.UseSingleQuotes.mask) != 0) {
        }
        if ((SerializerFeature.NotWriteDefaultValue.mask & serializeWriter.features) != 0) {
        }
        List<PropertyFilter> list522 = jSONSerializer.propertyFilters;
        boolean z1422 = z11;
        List<NameFilter> list622 = jSONSerializer.nameFilters;
        List<ValueFilter> list722 = jSONSerializer.valueFilters;
    }
}
