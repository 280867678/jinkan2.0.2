package org.seamless.util.dbunit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import me.tvspark.outline;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ReplacementDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;

/* loaded from: classes5.dex */
public abstract class DBUnitOperations extends ArrayList<AbstractC3384Op> {
    public static final Logger log = Logger.getLogger(DBUnitOperations.class.getName());

    /* loaded from: classes5.dex */
    public static class ClasspathOp extends AbstractC3384Op {
        public ClasspathOp(String str) {
            super(str);
        }

        public ClasspathOp(String str, String str2) {
            super(str, str2);
        }

        public ClasspathOp(String str, String str2, DatabaseOperation databaseOperation) {
            super(str, str2, databaseOperation);
        }

        @Override // org.seamless.util.dbunit.DBUnitOperations.AbstractC3384Op
        public InputStream openStream(String str) {
            return Thread.currentThread().getContextClassLoader().getResourceAsStream(str);
        }
    }

    /* loaded from: classes5.dex */
    public class FileOp extends AbstractC3384Op {
        public FileOp(String str) {
            super(str);
        }

        public FileOp(String str, String str2) {
            super(str, str2);
        }

        public FileOp(String str, String str2, DatabaseOperation databaseOperation) {
            super(str, str2, databaseOperation);
        }

        @Override // org.seamless.util.dbunit.DBUnitOperations.AbstractC3384Op
        public InputStream openStream(String str) {
            try {
                return new FileInputStream(str);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* renamed from: org.seamless.util.dbunit.DBUnitOperations$Op */
    /* loaded from: classes5.dex */
    public static abstract class AbstractC3384Op {
        public ReplacementDataSet dataSet;
        public DatabaseOperation operation;

        public AbstractC3384Op(String str) {
            this(str, null, DatabaseOperation.CLEAN_INSERT);
        }

        public AbstractC3384Op(String str, String str2) {
            this(str, str2, DatabaseOperation.CLEAN_INSERT);
        }

        public AbstractC3384Op(String str, String str2, DatabaseOperation databaseOperation) {
            try {
                ReplacementDataSet replacementDataSet = str2 != null ? new ReplacementDataSet(new FlatXmlDataSet(openStream(str), openStream(str2))) : new ReplacementDataSet(new FlatXmlDataSet(openStream(str)));
                this.dataSet = replacementDataSet;
                replacementDataSet.addReplacementObject("[NULL]", (Object) null);
                this.operation = databaseOperation;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public void execute(IDatabaseConnection iDatabaseConnection) {
            try {
                this.operation.execute(iDatabaseConnection, this.dataSet);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public IDataSet getDataSet() {
            return this.dataSet;
        }

        public DatabaseOperation getOperation() {
            return this.operation;
        }

        public abstract InputStream openStream(String str);
    }

    public abstract void disableReferentialIntegrity(IDatabaseConnection iDatabaseConnection);

    public void editConfig(DatabaseConfig databaseConfig) {
    }

    public abstract void enableReferentialIntegrity(IDatabaseConnection iDatabaseConnection);

    public void execute() {
        IDatabaseConnection iDatabaseConnection;
        Logger logger = log;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Executing DBUnit operations: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(size());
        logger.info(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        try {
            iDatabaseConnection = getConnection();
            try {
                disableReferentialIntegrity(iDatabaseConnection);
                Iterator<AbstractC3384Op> it = iterator();
                while (it.hasNext()) {
                    it.next().execute(iDatabaseConnection);
                }
                enableReferentialIntegrity(iDatabaseConnection);
                if (iDatabaseConnection == null) {
                    return;
                }
                try {
                    iDatabaseConnection.close();
                } catch (Exception e) {
                    Logger logger2 = log;
                    Level level = Level.WARNING;
                    logger2.log(level, "Failed to close connection after DBUnit operation: " + e, (Throwable) e);
                }
            } catch (Throwable th) {
                th = th;
                if (iDatabaseConnection != null) {
                    try {
                        iDatabaseConnection.close();
                    } catch (Exception e2) {
                        Logger logger3 = log;
                        Level level2 = Level.WARNING;
                        logger3.log(level2, "Failed to close connection after DBUnit operation: " + e2, (Throwable) e2);
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            iDatabaseConnection = null;
        }
    }

    public IDatabaseConnection getConnection() {
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection(getDataSource().getConnection());
            editConfig(databaseConnection.getConfig());
            return databaseConnection;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public abstract DataSource getDataSource();
}
