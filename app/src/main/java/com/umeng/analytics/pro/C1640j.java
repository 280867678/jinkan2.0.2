package com.umeng.analytics.pro;

import me.tvspark.outline;

/* renamed from: com.umeng.analytics.pro.j */
/* loaded from: classes4.dex */
public class C1640j {

    /* renamed from: A */
    public static final String f3456A = "MobclickAgent.setSecret方法参数secretkey不能为null，也不能为空字符串。|secretkey参数必须是非空 字符串。";

    /* renamed from: B */
    public static final String f3457B = "统计SDK常见问题索引贴 详见链接 http://developer.umeng.com/docs/66650/cate/66650";

    /* renamed from: H */
    public static final String f3463H = "检测到进入页面生命周期时尚未完成SDK初始化，请检查是否未在Application.onCreate函数中执行SDK初始化函数。";

    /* renamed from: N */
    public static final String f3469N = "MobclickAgent.onDeepLinkReceived方法Context参数不能为null。|参数Context需要指定ApplicationContext值。";

    /* renamed from: O */
    public static final String f3470O = "MobclickAgent.onDeepLinkReceived方法link参数不能为null，也不能为空字符串。|参数link必须为非空字符串。";

    /* renamed from: P */
    public static final String f3471P = "MobclickAgent.onDeepLinkReceived方法link参数长度超过限制。|参数link长度不能超过1024字符。";

    /* renamed from: ar */
    public static final String f3500ar = "请在Application.onCreate函数中使用UMConfigure.preInit函数初始化友盟sdk";

    /* renamed from: z */
    public static final String f3525z = "MobclickAgent.setSecret方法参数context不能为null|参数Context需要指定ApplicationContext值。";

    /* renamed from: a */
    public static final String f3482a = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("66946", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("事件属性集合参数为空|onEvent接口必须传入非空的属性集合。详见问题链接 "));

    /* renamed from: b */
    public static final String f3501b = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("66946", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("事件ID和保留字冲突|onEvent接口传入的事件ID不能和保留字冲突。详见问题链接 "));

    /* renamed from: c */
    public static final String f3502c = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("66946", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("事件ID为null或者为空字符串|onEvent接口传入的事件ID不能为null，也不能为空字符串。详见问题链接 "));

    /* renamed from: d */
    public static final String f3503d = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("66946", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("事件属性集合map没有加入K-V值|事件属性集合参数map必须添加K-V值。详见问题链接 "));

    /* renamed from: e */
    public static final String f3504e = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("66946", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("事件属性集合map中key值和保留字冲突|事件属性集合map中key值不能和保留字冲突。详见问题链接 "));

    /* renamed from: f */
    public static final String f3505f = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("66946", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("事件ID为null或者长度超过限制|事件ID不能为null、空串，且长度不能超过128个字符。详见问题链接 "));

    /* renamed from: g */
    public static final String f3506g = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("66946", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("事件属性集合参数为空或者事件属性集合map没有加入K-V值|事件属性集合参数map必须添加K-V值。详见问题链接 "));

    /* renamed from: h */
    public static final String f3507h = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("66946", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("事件属性集合map中key非法|事件属性集合参数map中key不能为非法的。详见问题链接 "));

    /* renamed from: i */
    public static final String f3508i = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("66946", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("事件属性集合map中value为null|事件属性集合参数map中value不能为null。详见问题链接 "));

    /* renamed from: j */
    public static final String f3509j = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("66946", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("事件属性集合map中value长度超过限制|事件属性集合参数map中value如果为字符串时，其长度不能超过256个字符。详见问题链接 "));

    /* renamed from: k */
    public static final String f3510k = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("66946", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("事件标签为null或者为空字符串|onEvent接口传入的事件标签不能为null，也不能为空字符串。详见问题链接 "));

    /* renamed from: l */
    public static final String f3511l = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("66946", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("事件ID为null或者长度超过限制，或事件标签长度超过限制|事件ID不能为null、空串，且长度不能超过128个字符。事件标签长度不能超过256个字符。详见问题链接 "));

    /* renamed from: m */
    public static final String f3512m = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("66946", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("事件ID和保留字冲突|onEvent接口传入的事件ID不能和保留字冲突。详见问题链接 "));

    /* renamed from: n */
    public static final String f3513n = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("66948", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("MobclickAgent.onResume接口参数不能为null|MobclickAgent.onResume接口参数应该传入当前Activity的上下文。详见问题链接 "));

    /* renamed from: o */
    public static final String f3514o = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("66948", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("MobclickAgent.onResume接口参数不是Activity的上下文|MobclickAgent.onResume接口参数应该传入当前Activity的上下文。详见问题链接 "));

    /* renamed from: p */
    public static final String f3515p = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("66948", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("MobclickAgent.onPause接口参数不能为null|MobclickAgent.onPause接口参数应该传入当前Activity的上下文。详见问题链接 "));

    /* renamed from: q */
    public static final String f3516q = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("66948", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("MobclickAgent.onPause接口参数不是Activity的上下文|MobclickAgent.onPause接口参数应该传入当前Activity的上下文。详见问题链接 "));

    /* renamed from: r */
    public static final String f3517r = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("66948", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("@ 遗漏了Mobclick.onResume函数调用|每个Activity的onResume中都必须调用MobclickAgent.onResume。详见问题链接 "));

    /* renamed from: s */
    public static final String f3518s = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("66948", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("@ 遗漏了Mobclick.onPaused函数调用|每个Activity的onPaused中都必须调用MobclickAgent.onPaused。详见问题链接 "));

    /* renamed from: t */
    public static final String f3519t = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("66951", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("MobclickAgent.onProfileSignIn接口参数 账号ID 不能为null|账号ID不能为空。详见问题链接 "));

    /* renamed from: u */
    public static final String f3520u = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("66951", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("MobclickAgent.onProfileSignIn接口参数 账号ID 长度超过限制|账号ID 长度不能超过64个字符。详见问题链接 "));

    /* renamed from: v */
    public static final String f3521v = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("66951", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("MobclickAgent.onProfileSignIn接口参数 账号来源 长度超过限制|账号来源 长度不能超过32个字符。详见问题链接 "));

    /* renamed from: w */
    public static final String f3522w = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("66971", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("MobclickAgent.reportError方法参数context不能为null|参数Context需要指定ApplicationContext值。详见问题链接 "));

    /* renamed from: x */
    public static final String f3523x = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("66971", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("MobclickAgent.reportError方法参数error不能为null，也不能为空字符串。|error参数必须是非空字符串。详见问题链接 "));

    /* renamed from: y */
    public static final String f3524y = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("66971", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("MobclickAgent.reportError方法 Context和Throwable参数都不能为空。|参数Context需要指定ApplicationContext值，Throwable参数传入捕获到的异常对象。详见问题链接 "));

    /* renamed from: C */
    public static final String f3458C = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("66975", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("MobclickAgent.onPageStart方法参数不能为null，也不能为空字符串。|参数viewName必须为非空字符串。详见链接 "));

    /* renamed from: D */
    public static final String f3459D = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("66975", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("MobclickAgent.onPageEnd方法参数不能为null，也不能为空字符串。|参数viewName必须为非空 字符串。详见链接 "));

    /* renamed from: E */
    public static final String f3460E = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("66975", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("对于页面@，onPageStart和onPageEnd调用对的参数不一致。|对于同一个页面，请先调用onPageStart，再调用onPageEnd。详见链接 "));

    /* renamed from: F */
    public static final String f3461F = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("66975", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("对于页面@，请确保先依序成对调用onPageStart，onPageEnd接口，再调用onPageStart接口对其它页面进行统计。|对于任意一个页面，必须依序成对调用onPageStart以及onPageEnd，不能有遗漏。详见链接 "));

    /* renamed from: G */
    public static final String f3462G = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("66975", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("对于页面@，请检查是否遗漏onPageStart接口调用。|对于任意一个页面，必须依序成对调用onPageStart以及onPageEnd，不能有遗漏。详见链接 "));

    /* renamed from: I */
    public static final String f3464I = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("66976", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("当前发送策略为：启动时发送。详见链接 "));

    /* renamed from: J */
    public static final String f3465J = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("66976", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("当前发送策略为: 间隔发送。间隔时间为：@秒。详见链接 "));

    /* renamed from: K */
    public static final String f3466K = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("66976", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("当前发送策略为: 集成测试。但是SDK未切换到调试模式，所以后台设置未生效。|如想切换到集成测试发送策略，请调用UMConfigure.setLogEnabled(true)将SDK切换到调试模式。详见链接 "));

    /* renamed from: L */
    public static final String f3467L = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("66976", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("当前发送策略为：集成测试。详见链接 "));

    /* renamed from: M */
    public static final String f3468M = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("66976", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("当前发送策略为: 准实时发送。间隔时间为：@秒。详见链接 "));

    /* renamed from: Q */
    public static final String f3472Q = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("66978", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("发送数据时发生java.net.UnknownHostException异常|友盟后端对设备端证书验证失败。请确保设备端没有运行抓包代理类程序。详见链接 "));

    /* renamed from: R */
    public static final String f3473R = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("66978", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("发送数据时发生javax.net.sslHandshakeException异常|导致友盟后端域名解析失败。请检查系统DNS服务器配置是否正确。详见链接 "));

    /* renamed from: S */
    public static final String f3474S = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("67310", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("track接口调用非法。|当前处于非DPLUS场景中，不能使用DPLUS相关接口，详见问题连接："));

    /* renamed from: T */
    public static final String f3475T = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("67310", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("registerSuperProperty接口调用非法。|当前处于非DPLUS场景中，不能使用DPLUS相关接口，详见问题连接："));

    /* renamed from: U */
    public static final String f3476U = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("67310", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("unregisterSuperProperty接口调用非法。|当前处于非DPLUS场景中，不能使用DPLUS相关接口，详见问题连接："));

    /* renamed from: V */
    public static final String f3477V = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("67310", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("getSuperProperty接口调用非法。|当前处于非DPLUS场景中，不能使用DPLUS相关接口，详见问题连接: "));

    /* renamed from: W */
    public static final String f3478W = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("67310", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("getSuperProperties接口调用非法。|当前处于非DPLUS场景中，不能使用DPLUS相关接口，详见问题连接："));

    /* renamed from: X */
    public static final String f3479X = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("67310", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("clearSuperProperties接口调用非法。|当前处于非DPLUS场景中，不能使用DPLUS相关接口，详见问题连接："));

    /* renamed from: Y */
    public static final String f3480Y = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("67310", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("setFirstLaunchEvent接口调用非法。|当前处于非DPLUS场景中，不能使用DPLUS相关接口，详见问题连接："));

    /* renamed from: Z */
    public static final String f3481Z = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("67310", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("registerPreProperties接口调用非法。|当前处于非DPLUS场景中，不能使用DPLUS相关接口，详见问题连接："));

    /* renamed from: aa */
    public static final String f3483aa = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("67310", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("unregisterPreProperty接口调用非法。|当前处于非DPLUS场景中，不能使用DPLUS相关接口，详见问题连接："));

    /* renamed from: ab */
    public static final String f3484ab = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("67310", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("clearPreProperties接口调用非法。|当前处于非DPLUS场景中，不能使用DPLUS相关接口，详见问题连接："));

    /* renamed from: ac */
    public static final String f3485ac = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("67310", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("getPreProperties接口调用非法。|当前处于非DPLUS场景中，不能使用DPLUS相关接口，详见问题连接："));

    /* renamed from: ad */
    public static final String f3486ad = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("67311", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("eventName为空，请检查|eventName参数不能为空，详见问题连接："));

    /* renamed from: ae */
    public static final String f3487ae = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("67311", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("请注意：map为空|track接口的参数说明，详见问题连接："));

    /* renamed from: af */
    public static final String f3488af = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("67312", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("context参数为空｜context参数不能为空，详见问题连接："));

    /* renamed from: ag */
    public static final String f3489ag = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("67312", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("propertyName参数或propertyValue参数为空｜propertyName、propertyValue参数不能为空，详见问题连接："));

    /* renamed from: ah */
    public static final String f3490ah = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("67313", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("context参数为空|context参数不能为空，详见问题连接："));

    /* renamed from: ai */
    public static final String f3491ai = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("67316", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("context参数为空|context参数不能为空，详见问题连接："));

    /* renamed from: aj */
    public static final String f3492aj = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("67318", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("context参数为空|context参数不能为空，详见问题连接："));

    /* renamed from: ak */
    public static final String f3493ak = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("67318", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("trackID参数为空|trackID参数不能为空，详见问题连接："));

    /* renamed from: al */
    public static final String f3494al = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("67319", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("context参数为空|context参数不能为空，详见问题连接："));

    /* renamed from: am */
    public static final String f3495am = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("67319", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("propertics参数为空|propertics参数不能为空，详见问题连接："));

    /* renamed from: an */
    public static final String f3496an = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("67320", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("context参数为空|context参数不能为空，详见问题连接："));

    /* renamed from: ao */
    public static final String f3497ao = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("67320", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("未匹配到您传入的property参数|property参数不能匹配，"));

    /* renamed from: ap */
    public static final String f3498ap = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("67321", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("context参数为空|context参数不能为空，详见问题连接："));

    /* renamed from: aq */
    public static final String f3499aq = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("67322", outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("context参数为空|context参数不能为空，详见问题连接："));
}
