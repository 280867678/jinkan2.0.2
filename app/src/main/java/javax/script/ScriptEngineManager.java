package javax.script;

import java.io.PrintStream;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import me.tvspark.x81;
import sun.misc.ServiceConfigurationError;
import sun.reflect.Reflection;
import sun.security.util.SecurityConstants;

/* loaded from: classes4.dex */
public class ScriptEngineManager {
    public static final boolean DEBUG = false;
    public HashSet<ScriptEngineFactory> engineSpis;
    public HashMap<String, ScriptEngineFactory> extensionAssociations;
    public Bindings globalScope;
    public HashMap<String, ScriptEngineFactory> mimeTypeAssociations;
    public HashMap<String, ScriptEngineFactory> nameAssociations;

    public ScriptEngineManager() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        init(!canCallerAccessLoader(contextClassLoader) ? null : contextClassLoader);
    }

    public ScriptEngineManager(ClassLoader classLoader) {
        init(classLoader);
    }

    private boolean canCallerAccessLoader(ClassLoader classLoader) {
        ClassLoader callerClassLoader;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager == null || (callerClassLoader = getCallerClassLoader()) == null) {
            return true;
        }
        if (classLoader == callerClassLoader && isAncestor(classLoader, callerClassLoader)) {
            return true;
        }
        try {
            securityManager.checkPermission(SecurityConstants.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            return true;
        } catch (SecurityException unused) {
            return false;
        }
    }

    private ClassLoader getCallerClassLoader() {
        Class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Reflection.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            return null;
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getClassLoader();
    }

    private void init(final ClassLoader classLoader) {
        this.globalScope = new SimpleBindings();
        this.engineSpis = new HashSet<>();
        this.nameAssociations = new HashMap<>();
        this.extensionAssociations = new HashMap<>();
        this.mimeTypeAssociations = new HashMap<>();
        AccessController.doPrivileged(new PrivilegedAction() { // from class: javax.script.ScriptEngineManager.1
            @Override // java.security.PrivilegedAction
            public Object run() {
                ScriptEngineManager.this.initEngines(classLoader);
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initEngines(ClassLoader classLoader) {
        PrintStream printStream;
        StringBuilder sb;
        String str;
        x81 x81Var;
        try {
            if (classLoader != null) {
                x81Var = new x81(ScriptEngineFactory.class, classLoader, null);
            } else {
                ClassLoader classLoader2 = null;
                for (ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader(); systemClassLoader != null; systemClassLoader = systemClassLoader.getParent()) {
                    classLoader2 = systemClassLoader;
                }
                x81Var = new x81(ScriptEngineFactory.class, classLoader2, null);
            }
            while (x81Var.hasNext()) {
                try {
                    try {
                        this.engineSpis.add((ScriptEngineFactory) x81Var.next());
                    } catch (ServiceConfigurationError e) {
                        System.err.println("ScriptEngineManager providers.next(): " + e.getMessage());
                    }
                } catch (ServiceConfigurationError e2) {
                    e = e2;
                    printStream = System.err;
                    sb = new StringBuilder();
                    str = "ScriptEngineManager providers.hasNext(): ";
                    sb.append(str);
                    sb.append(e.getMessage());
                    printStream.println(sb.toString());
                    return;
                }
            }
        } catch (ServiceConfigurationError e3) {
            e = e3;
            printStream = System.err;
            sb = new StringBuilder();
            str = "Can't find ScriptEngineFactory providers: ";
        }
    }

    private boolean isAncestor(ClassLoader classLoader, ClassLoader classLoader2) {
        do {
            classLoader2 = classLoader2.getParent();
            if (classLoader == classLoader2) {
                return true;
            }
        } while (classLoader2 != null);
        return false;
    }

    public Object get(String str) {
        return this.globalScope.get(str);
    }

    public Bindings getBindings() {
        return this.globalScope;
    }

    public ScriptEngine getEngineByExtension(String str) {
        List<String> list;
        if (str != null) {
            ScriptEngineFactory scriptEngineFactory = this.extensionAssociations.get(str);
            if (scriptEngineFactory != null) {
                try {
                    ScriptEngine scriptEngine = scriptEngineFactory.getScriptEngine();
                    scriptEngine.setBindings(getBindings(), 200);
                    return scriptEngine;
                } catch (Exception unused) {
                }
            }
            Iterator<ScriptEngineFactory> it = this.engineSpis.iterator();
            while (it.hasNext()) {
                ScriptEngineFactory next = it.next();
                try {
                    list = next.getExtensions();
                } catch (Exception unused2) {
                    list = null;
                }
                if (list != null) {
                    for (String str2 : list) {
                        if (str.equals(str2)) {
                            try {
                                ScriptEngine scriptEngine2 = next.getScriptEngine();
                                scriptEngine2.setBindings(getBindings(), 200);
                                return scriptEngine2;
                            } catch (Exception unused3) {
                            }
                        }
                    }
                    continue;
                }
            }
            return null;
        }
        throw null;
    }

    public ScriptEngine getEngineByMimeType(String str) {
        List<String> list;
        if (str != null) {
            ScriptEngineFactory scriptEngineFactory = this.mimeTypeAssociations.get(str);
            if (scriptEngineFactory != null) {
                try {
                    ScriptEngine scriptEngine = scriptEngineFactory.getScriptEngine();
                    scriptEngine.setBindings(getBindings(), 200);
                    return scriptEngine;
                } catch (Exception unused) {
                }
            }
            Iterator<ScriptEngineFactory> it = this.engineSpis.iterator();
            while (it.hasNext()) {
                ScriptEngineFactory next = it.next();
                try {
                    list = next.getMimeTypes();
                } catch (Exception unused2) {
                    list = null;
                }
                if (list != null) {
                    for (String str2 : list) {
                        if (str.equals(str2)) {
                            try {
                                ScriptEngine scriptEngine2 = next.getScriptEngine();
                                scriptEngine2.setBindings(getBindings(), 200);
                                return scriptEngine2;
                            } catch (Exception unused3) {
                            }
                        }
                    }
                    continue;
                }
            }
            return null;
        }
        throw null;
    }

    public ScriptEngine getEngineByName(String str) {
        List<String> list;
        if (str != null) {
            ScriptEngineFactory scriptEngineFactory = this.nameAssociations.get(str);
            if (scriptEngineFactory != null) {
                try {
                    ScriptEngine scriptEngine = scriptEngineFactory.getScriptEngine();
                    scriptEngine.setBindings(getBindings(), 200);
                    return scriptEngine;
                } catch (Exception unused) {
                }
            }
            Iterator<ScriptEngineFactory> it = this.engineSpis.iterator();
            while (it.hasNext()) {
                ScriptEngineFactory next = it.next();
                try {
                    list = next.getNames();
                } catch (Exception unused2) {
                    list = null;
                }
                if (list != null) {
                    for (String str2 : list) {
                        if (str.equals(str2)) {
                            try {
                                ScriptEngine scriptEngine2 = next.getScriptEngine();
                                scriptEngine2.setBindings(getBindings(), 200);
                                return scriptEngine2;
                            } catch (Exception unused3) {
                            }
                        }
                    }
                    continue;
                }
            }
            return null;
        }
        throw null;
    }

    public List<ScriptEngineFactory> getEngineFactories() {
        ArrayList arrayList = new ArrayList(this.engineSpis.size());
        Iterator<ScriptEngineFactory> it = this.engineSpis.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public void put(String str, Object obj) {
        this.globalScope.put(str, obj);
    }

    public void registerEngineExtension(String str, ScriptEngineFactory scriptEngineFactory) {
        if (str == null || scriptEngineFactory == null) {
            throw null;
        }
        this.extensionAssociations.put(str, scriptEngineFactory);
    }

    public void registerEngineMimeType(String str, ScriptEngineFactory scriptEngineFactory) {
        if (str == null || scriptEngineFactory == null) {
            throw null;
        }
        this.mimeTypeAssociations.put(str, scriptEngineFactory);
    }

    public void registerEngineName(String str, ScriptEngineFactory scriptEngineFactory) {
        if (str == null || scriptEngineFactory == null) {
            throw null;
        }
        this.nameAssociations.put(str, scriptEngineFactory);
    }

    public void setBindings(Bindings bindings) {
        if (bindings != null) {
            this.globalScope = bindings;
            return;
        }
        throw new IllegalArgumentException("Global scope cannot be null.");
    }
}
