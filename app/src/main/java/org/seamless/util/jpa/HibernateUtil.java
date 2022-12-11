package org.seamless.util.jpa;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/* loaded from: classes5.dex */
public class HibernateUtil {
    public static final Configuration configuration;
    public static final SessionFactory sessionFactory;

    static {
        try {
            Configuration configure = new Configuration().configure();
            configuration = configure;
            sessionFactory = configure.buildSessionFactory();
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    public static Configuration getConfiguration() {
        return configuration;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
