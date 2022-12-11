package org.eclipse.jetty.servlet.listener;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import me.tvspark.outline;
import org.eclipse.jetty.util.Loader;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes5.dex */
public class ELContextCleaner implements ServletContextListener {
    public static final Logger LOG = Log.getLogger(ELContextCleaner.class);

    @Override // javax.servlet.ServletContextListener
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        try {
            purgeEntries(getField(Loader.loadClass(getClass(), "javax.el.BeanELResolver")));
            LOG.info("javax.el.BeanELResolver purged", new Object[0]);
        } catch (ClassNotFoundException unused) {
        } catch (IllegalAccessException e) {
            e = e;
            LOG.warn("Cannot purge classes from javax.el.BeanELResolver", e);
        } catch (IllegalArgumentException e2) {
            e = e2;
            LOG.warn("Cannot purge classes from javax.el.BeanELResolver", e);
        } catch (NoSuchFieldException unused2) {
            LOG.info("Not cleaning cached beans: no such field javax.el.BeanELResolver.properties", new Object[0]);
        } catch (SecurityException e3) {
            e = e3;
            LOG.warn("Cannot purge classes from javax.el.BeanELResolver", e);
        }
    }

    @Override // javax.servlet.ServletContextListener
    public void contextInitialized(ServletContextEvent servletContextEvent) {
    }

    public Field getField(Class cls) throws SecurityException, NoSuchFieldException {
        if (cls == null) {
            return null;
        }
        return cls.getDeclaredField("properties");
    }

    public void purgeEntries(Field field) throws IllegalArgumentException, IllegalAccessException {
        if (field == null) {
            return;
        }
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        Map map = (Map) field.get(null);
        if (map == null) {
            return;
        }
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            Class cls = (Class) it.next();
            Logger logger = LOG;
            logger.info("Clazz: " + cls + " loaded by " + cls.getClassLoader(), new Object[0]);
            if (Thread.currentThread().getContextClassLoader().equals(cls.getClassLoader())) {
                it.remove();
                LOG.info("removed", new Object[0]);
            } else {
                Logger logger2 = LOG;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("not removed: contextclassloader=");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(Thread.currentThread().getContextClassLoader());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("clazz's classloader=");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(cls.getClassLoader());
                logger2.info(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), new Object[0]);
            }
        }
    }
}
