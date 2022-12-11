package me.tvspark;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;
import sun.misc.ServiceConfigurationError;

/* loaded from: classes4.dex */
public class x81 implements Iterator {
    public ClassLoader Wwwwwwwwwwwwwwwwwwwwwww;
    public Class Wwwwwwwwwwwwwwwwwwwwwwww;
    public Enumeration Wwwwwwwwwwwwwwwwwwwwww = null;
    public Iterator Wwwwwwwwwwwwwwwwwwwww = null;
    public Set Wwwwwwwwwwwwwwwwwwww = new TreeSet();
    public String Wwwwwwwwwwwwwwwwwww = null;

    public /* synthetic */ x81(Class cls, ClassLoader classLoader, w81 w81Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = cls;
        this.Wwwwwwwwwwwwwwwwwwwwwww = classLoader;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00eb A[Catch: IOException -> 0x00e7, TRY_LEAVE, TryCatch #4 {IOException -> 0x00e7, blocks: (B:60:0x00e3, B:52:0x00eb), top: B:59:0x00e3 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.util.Iterator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean hasNext() throws ServiceConfigurationError {
        InputStream inputStream;
        BufferedReader bufferedReader;
        if (this.Wwwwwwwwwwwwwwwwwww != null) {
            return true;
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwww == null) {
            try {
                String str = "META-INF/services/" + this.Wwwwwwwwwwwwwwwwwwwwwwww.getName();
                this.Wwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww == null ? ClassLoader.getSystemResources(str) : this.Wwwwwwwwwwwwwwwwwwwwwww.getResources(str);
            } catch (IOException e) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, ": " + e);
                throw null;
            }
        }
        while (true) {
            Iterator it = this.Wwwwwwwwwwwwwwwwwwwww;
            if (it != null && it.hasNext()) {
                this.Wwwwwwwwwwwwwwwwwww = (String) this.Wwwwwwwwwwwwwwwwwwwww.next();
                return true;
            } else if (!this.Wwwwwwwwwwwwwwwwwwwwww.hasMoreElements()) {
                return false;
            } else {
                Class cls = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                URL url = (URL) this.Wwwwwwwwwwwwwwwwwwwwww.nextElement();
                Set set = this.Wwwwwwwwwwwwwwwwwwww;
                ArrayList arrayList = new ArrayList();
                try {
                    inputStream = url.openStream();
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
                        int i = 1;
                        do {
                            try {
                                try {
                                    i = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls, url, bufferedReader, i, arrayList, set);
                                } catch (Throwable th) {
                                    th = th;
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (IOException e2) {
                                            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls, ": " + e2);
                                            throw null;
                                        }
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    throw th;
                                }
                            } catch (IOException e3) {
                                e = e3;
                                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls, ": " + e);
                                throw null;
                            }
                        } while (i >= 0);
                        try {
                            bufferedReader.close();
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            this.Wwwwwwwwwwwwwwwwwwwww = arrayList.iterator();
                        } catch (IOException e4) {
                            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls, ": " + e4);
                            throw null;
                        }
                    } catch (IOException e5) {
                        e = e5;
                        bufferedReader = null;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = null;
                        if (bufferedReader != null) {
                        }
                        if (inputStream != null) {
                        }
                        throw th;
                    }
                } catch (IOException e6) {
                    e = e6;
                    inputStream = null;
                    bufferedReader = null;
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = null;
                    bufferedReader = null;
                }
            }
        }
    }

    @Override // java.util.Iterator
    public Object next() throws ServiceConfigurationError {
        if (hasNext()) {
            String str = this.Wwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwww = null;
            try {
                Class<?> cls = Class.forName(str, false, this.Wwwwwwwwwwwwwwwwwwwwwww);
                if (this.Wwwwwwwwwwwwwwwwwwwwwwww.isAssignableFrom(cls)) {
                    try {
                        return this.Wwwwwwwwwwwwwwwwwwwwwwww.cast(cls.newInstance());
                    } catch (Throwable th) {
                        Class cls2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                        ServiceConfigurationError serviceConfigurationError = new ServiceConfigurationError(cls2.getName() + ": " + ("Provider " + str + " could not be instantiated: " + th));
                        serviceConfigurationError.initCause(th);
                        throw serviceConfigurationError;
                    }
                }
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, "Provider " + str + " not a subtype");
                throw null;
            } catch (ClassNotFoundException unused) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, "Provider " + str + " not found");
                throw null;
            }
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
