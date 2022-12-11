package com.arialyy.aria.util;

import android.os.Handler;
import com.arialyy.aria.core.TaskOptionParams;
import com.arialyy.aria.core.inf.IEventHandler;
import com.arialyy.aria.core.inf.ITaskOption;
import com.arialyy.aria.core.inf.IUtil;
import com.arialyy.aria.core.listener.IEventListener;
import com.arialyy.aria.core.task.AbsTask;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import java.lang.ref.SoftReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* loaded from: classes3.dex */
public class ComponentUtil {
    public static final int COMPONENT_TYPE_FTP = 2;
    public static final int COMPONENT_TYPE_HTTP = 1;
    public static final int COMPONENT_TYPE_M3U8 = 3;
    public static final int COMPONENT_TYPE_SFTP = 4;
    public static volatile ComponentUtil INSTANCE;
    public String TAG = CommonUtil.getClassName(ComponentUtil.class);

    public static ComponentUtil getInstance() {
        if (INSTANCE == null) {
            synchronized (ComponentUtil.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ComponentUtil();
                }
            }
        }
        return INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0022 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020 A[DONT_GENERATE] */
    /* JADX WARN: Type inference failed for: r8v12, types: [com.arialyy.aria.core.listener.IEventListener] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized <T extends IEventListener> T buildListener(int i, AbsTask absTask, Handler handler) {
        String str;
        String str2 = "请添加FTP插件";
        T t = null;
        if (i != 12) {
            if (i != 13) {
                switch (i) {
                    case 1:
                    case 3:
                        break;
                    case 2:
                    case 4:
                        str = "com.arialyy.aria.core.listener.DownloadGroupListener";
                        break;
                    case 5:
                    case 6:
                        break;
                    case 7:
                    case 8:
                        str = "com.arialyy.aria.m3u8.M3U8Listener";
                        str2 = "请添加m3u8插件";
                        break;
                    default:
                        str = null;
                        break;
                }
                if (str == null) {
                    return null;
                }
                try {
                    try {
                        try {
                            t = (IEventListener) getClass().getClassLoader().loadClass(str).getConstructor(AbsTask.class, Handler.class).newInstance(absTask, handler);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    } catch (ClassNotFoundException unused) {
                        throw new IllegalArgumentException(str2);
                    } catch (NoSuchMethodException e2) {
                        e2.printStackTrace();
                    }
                } catch (InstantiationException e3) {
                    e3.printStackTrace();
                } catch (InvocationTargetException e4) {
                    e4.printStackTrace();
                }
                return t;
            }
            str = "com.arialyy.aria.core.listener.BaseUListener";
            if (str == null) {
            }
        }
        str = "com.arialyy.aria.core.listener.BaseDListener";
        if (str == null) {
        }
    }

    public synchronized <T extends ITaskOption> T buildTaskOption(Class<T> cls, TaskOptionParams taskOptionParams) {
        T t;
        List<Field> allFields = CommonUtil.getAllFields(cls);
        T t2 = null;
        try {
            t = cls.newInstance();
            try {
                for (Field field : allFields) {
                    field.setAccessible(true);
                    Class<?> type = field.getType();
                    String name = field.getName();
                    if (type != SoftReference.class) {
                        Object obj = taskOptionParams.getParams().get(name);
                        if (obj != null) {
                            field.set(t, obj);
                        }
                    } else {
                        IEventHandler iEventHandler = taskOptionParams.getHandler().get(name);
                        if (iEventHandler != null) {
                            field.set(t, new SoftReference(iEventHandler));
                        }
                    }
                }
            } catch (IllegalAccessException e) {
                e = e;
                t2 = t;
                e.printStackTrace();
                t = t2;
                return t;
            } catch (InstantiationException e2) {
                e = e2;
                t2 = t;
                e.printStackTrace();
                t = t2;
                return t;
            }
        } catch (IllegalAccessException e3) {
            e = e3;
        } catch (InstantiationException e4) {
            e = e4;
        }
        return t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v9, types: [com.arialyy.aria.core.inf.IUtil] */
    public synchronized <T extends IUtil> T buildUtil(AbsTaskWrapper absTaskWrapper, IEventListener iEventListener) {
        String str;
        int requestType = absTaskWrapper.getRequestType();
        T t = null;
        if (requestType == 12) {
            str = "com.arialyy.aria.sftp.download.SFtpDLoaderUtil";
        } else if (requestType != 13) {
            switch (requestType) {
                case 1:
                    str = "com.arialyy.aria.http.download.HttpDLoaderUtil";
                    break;
                case 2:
                    str = "com.arialyy.aria.http.download.HttpDGLoaderUtil";
                    break;
                case 3:
                    str = "com.arialyy.aria.ftp.download.FtpDLoaderUtil";
                    break;
                case 4:
                    str = "com.arialyy.aria.ftp.download.FtpDGLoaderUtil";
                    break;
                case 5:
                    str = "com.arialyy.aria.http.upload.HttpULoaderUtil";
                    break;
                case 6:
                    str = "com.arialyy.aria.ftp.upload.FtpULoaderUtil";
                    break;
                case 7:
                    str = "com.arialyy.aria.m3u8.vod.M3U8VodUtil";
                    break;
                case 8:
                    str = "com.arialyy.aria.m3u8.live.M3U8LiveUtil";
                    break;
                default:
                    str = null;
                    break;
            }
        } else {
            str = "com.arialyy.aria.sftp.upload.SFtpULoaderUtil";
        }
        if (str == null) {
            ALog.m4191e(this.TAG, "不识别的类名：" + str);
            return null;
        }
        try {
            try {
                t = (IUtil) getClass().getClassLoader().loadClass(str).getConstructor(AbsTaskWrapper.class, IEventListener.class).newInstance(absTaskWrapper, iEventListener);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
            }
        } catch (ClassNotFoundException e3) {
            e3.printStackTrace();
        } catch (InstantiationException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        }
        return t;
    }

    public boolean checkComponentExist(int i) {
        String str;
        String str2;
        if (i == 1) {
            str = "com.arialyy.aria.http.HttpTaskOption";
            str2 = "http插件不存在，请添加http插件";
        } else if (i == 2) {
            str = "com.arialyy.aria.ftp.FtpTaskOption";
            str2 = "ftp插件不存在，请添加ftp插件";
        } else if (i == 3) {
            str = "com.arialyy.aria.m3u8.M3U8TaskOption";
            str2 = "m3u8插件不存在，请添加m3u8插件";
        } else if (i != 4) {
            str2 = "";
            str = null;
        } else {
            str = "com.arialyy.aria.sftp.SFtpTaskOption";
            str2 = "sftp插件不存在，请添加sftp插件";
        }
        try {
            getClass().getClassLoader().loadClass(str);
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalArgumentException(str2);
        }
    }
}
