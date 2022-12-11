package org.eclipse.jetty.server.session;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import me.tvspark.ae0;
import me.tvspark.ee0;
import me.tvspark.outline;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.SessionManager;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.session.JDBCSessionManager;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes4.dex */
public class JDBCSessionIdManager extends AbstractSessionIdManager {
    public static final Logger LOG = SessionHandler.LOG;
    public String _blobType;
    public String _connectionUrl;
    public String _createSessionIdTable;
    public String _createSessionTable;
    public DataSource _datasource;
    public DatabaseAdaptor _dbAdaptor;
    public String _deleteId;
    public String _deleteOldExpiredSessions;
    public String _deleteSession;
    public Driver _driver;
    public String _driverClassName;
    public String _insertId;
    public String _insertSession;
    public String _jndiName;
    public long _lastScavengeTime;
    public String _longType;
    public String _queryId;
    public String _selectBoundedExpiredSessions;
    public String _selectExpiredSessions;
    public Server _server;
    public TimerTask _task;
    public Timer _timer;
    public String _updateSession;
    public String _updateSessionAccessTime;
    public String _updateSessionNode;
    public final HashSet<String> _sessionIds = new HashSet<>();
    public String _sessionIdTable = "JettySessionIds";
    public String _sessionTable = "JettySessions";
    public String _sessionTableRowId = "rowId";
    public long _scavengeIntervalMs = 600000;

    /* loaded from: classes4.dex */
    public class DatabaseAdaptor {
        public String _dbName;
        public boolean _isLower;
        public boolean _isUpper;

        public DatabaseAdaptor(DatabaseMetaData databaseMetaData) throws SQLException {
            String lowerCase = databaseMetaData.getDatabaseProductName().toLowerCase(Locale.ENGLISH);
            this._dbName = lowerCase;
            JDBCSessionIdManager.LOG.debug("Using database {}", lowerCase);
            this._isLower = databaseMetaData.storesLowerCaseIdentifiers();
            this._isUpper = databaseMetaData.storesUpperCaseIdentifiers();
        }

        public String convertIdentifier(String str) {
            return this._isLower ? str.toLowerCase(Locale.ENGLISH) : this._isUpper ? str.toUpperCase(Locale.ENGLISH) : str;
        }

        public InputStream getBlobInputStream(ResultSet resultSet, String str) throws SQLException {
            return this._dbName.startsWith("postgres") ? new ByteArrayInputStream(resultSet.getBytes(str)) : resultSet.getBlob(str).getBinaryStream();
        }

        public String getBlobType() {
            String str = JDBCSessionIdManager.this._blobType;
            return str != null ? str : this._dbName.startsWith("postgres") ? "bytea" : "blob";
        }

        public String getDBName() {
            return this._dbName;
        }

        public PreparedStatement getLoadStatement(Connection connection, String str, String str2, String str3) throws SQLException {
            if ((str2 == null || "".equals(str2)) && isEmptyStringNull()) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("select * from ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(JDBCSessionIdManager.this._sessionTable);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" where sessionId = ? and contextPath is null and virtualHost = ?");
                PreparedStatement prepareStatement = connection.prepareStatement(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                prepareStatement.setString(1, str);
                prepareStatement.setString(2, str3);
                return prepareStatement;
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("select * from ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(JDBCSessionIdManager.this._sessionTable);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" where sessionId = ? and contextPath = ? and virtualHost = ?");
            PreparedStatement prepareStatement2 = connection.prepareStatement(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
            prepareStatement2.setString(1, str);
            prepareStatement2.setString(2, str2);
            prepareStatement2.setString(3, str3);
            return prepareStatement2;
        }

        public String getLongType() {
            String str = JDBCSessionIdManager.this._longType;
            return str != null ? str : this._dbName.startsWith("oracle") ? "number(20)" : "bigint";
        }

        public String getRowIdColumnName() {
            String str = this._dbName;
            return (str == null || !str.startsWith("oracle")) ? "rowId" : "srowId";
        }

        public boolean isEmptyStringNull() {
            return this._dbName.startsWith("oracle");
        }
    }

    public JDBCSessionIdManager(Server server) {
        this._server = server;
    }

    public JDBCSessionIdManager(Server server, Random random) {
        super(random);
        this._server = server;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x012c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0120 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0175 A[Catch: SQLException -> 0x0179, TRY_ENTER, TRY_LEAVE, TryCatch #10 {SQLException -> 0x0179, blocks: (B:40:0x00da, B:61:0x0175), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0169 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x015d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0151 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0144 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0138 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:120:0x017a -> B:36:0x017f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void cleanExpiredSessions() {
        Connection connection;
        Statement statement;
        Statement statement2;
        PreparedStatement preparedStatement;
        ArrayList arrayList = new ArrayList();
        Connection connection2 = null;
        r1 = null;
        r1 = null;
        r1 = null;
        r1 = null;
        Statement statement3 = null;
        try {
            try {
                connection = getConnection();
                try {
                    connection.setTransactionIsolation(2);
                    connection.setAutoCommit(false);
                    preparedStatement = connection.prepareStatement(this._selectExpiredSessions);
                    try {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (LOG.isDebugEnabled()) {
                            LOG.debug("Searching for sessions expired before {}", Long.valueOf(currentTimeMillis));
                        }
                        preparedStatement.setLong(1, currentTimeMillis);
                        ResultSet executeQuery = preparedStatement.executeQuery();
                        while (executeQuery.next()) {
                            String string = executeQuery.getString("sessionId");
                            arrayList.add(string);
                            if (LOG.isDebugEnabled()) {
                                LOG.debug("Found expired sessionId={}", string);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            statement = connection.createStatement();
                            try {
                                statement.executeUpdate(createCleanExpiredSessionsSql("delete from " + this._sessionTable + " where sessionId in ", arrayList));
                                statement3 = connection.createStatement();
                                statement3.executeUpdate(createCleanExpiredSessionsSql("delete from " + this._sessionIdTable + " where id in ", arrayList));
                            } catch (Exception e) {
                                e = e;
                                statement2 = statement3;
                                connection2 = connection;
                                statement = statement;
                                if (connection2 != null) {
                                    try {
                                        try {
                                            LOG.warn("Rolling back clean of expired sessions", e);
                                            connection2.rollback();
                                        } catch (Exception e2) {
                                            LOG.warn("Rollback of expired sessions failed", e2);
                                            if (statement2 != null) {
                                                try {
                                                    statement2.close();
                                                } catch (Exception e3) {
                                                    LOG.warn(e3);
                                                }
                                            }
                                            if (statement != null) {
                                                try {
                                                    statement.close();
                                                } catch (Exception e4) {
                                                    LOG.warn(e4);
                                                }
                                            }
                                            if (preparedStatement != null) {
                                                try {
                                                    preparedStatement.close();
                                                } catch (Exception e5) {
                                                    LOG.warn(e5);
                                                }
                                            }
                                            if (connection2 != null) {
                                                return;
                                            }
                                            connection2.close();
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        Statement statement4 = statement2;
                                        connection = connection2;
                                        statement3 = statement4;
                                        if (statement3 != null) {
                                            try {
                                                statement3.close();
                                            } catch (Exception e6) {
                                                LOG.warn(e6);
                                            }
                                        }
                                        if (statement != null) {
                                            try {
                                                statement.close();
                                            } catch (Exception e7) {
                                                LOG.warn(e7);
                                            }
                                        }
                                        if (preparedStatement != null) {
                                            try {
                                                preparedStatement.close();
                                            } catch (Exception e8) {
                                                LOG.warn(e8);
                                            }
                                        }
                                        if (connection != null) {
                                            try {
                                                connection.close();
                                            } catch (SQLException e9) {
                                                LOG.warn(e9);
                                            }
                                        }
                                        throw th;
                                    }
                                }
                                if (statement2 != null) {
                                }
                                if (statement != null) {
                                }
                                if (preparedStatement != null) {
                                }
                                if (connection2 != null) {
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                if (statement3 != null) {
                                }
                                if (statement != null) {
                                }
                                if (preparedStatement != null) {
                                }
                                if (connection != null) {
                                }
                                throw th;
                            }
                        } else {
                            statement = null;
                        }
                        connection.commit();
                        synchronized (this._sessionIds) {
                            this._sessionIds.removeAll(arrayList);
                        }
                        if (statement3 != null) {
                            try {
                                statement3.close();
                            } catch (Exception e10) {
                                LOG.warn(e10);
                            }
                        }
                        if (statement != null) {
                            try {
                                statement.close();
                            } catch (Exception e11) {
                                LOG.warn(e11);
                            }
                        }
                        try {
                            preparedStatement.close();
                        } catch (Exception e12) {
                            LOG.warn(e12);
                        }
                        connection.close();
                    } catch (Exception e13) {
                        e = e13;
                        statement = null;
                        connection2 = connection;
                        statement2 = null;
                    } catch (Throwable th3) {
                        th = th3;
                        statement = null;
                    }
                } catch (Exception e14) {
                    e = e14;
                    statement = null;
                    preparedStatement = null;
                    connection2 = connection;
                    statement2 = null;
                } catch (Throwable th4) {
                    th = th4;
                    statement = null;
                    preparedStatement = statement;
                    if (statement3 != null) {
                    }
                    if (statement != null) {
                    }
                    if (preparedStatement != null) {
                    }
                    if (connection != null) {
                    }
                    throw th;
                }
            } catch (SQLException e15) {
                LOG.warn(e15);
            }
        } catch (Exception e16) {
            e = e16;
            statement2 = null;
            statement = null;
            preparedStatement = null;
        } catch (Throwable th5) {
            th = th5;
            connection = null;
            statement = null;
        }
    }

    private String createCleanExpiredSessionsSql(String str, Collection<String> collection) throws Exception {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append("(");
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("'");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(it.next());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("'");
            stringBuffer.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            if (it.hasNext()) {
                stringBuffer.append(",");
            }
        }
        stringBuffer.append(")");
        if (LOG.isDebugEnabled()) {
            LOG.debug("Cleaning expired sessions with: {}", stringBuffer);
        }
        return stringBuffer.toString();
    }

    private void delete(String str) throws SQLException {
        Connection connection;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            try {
                connection.setAutoCommit(true);
                preparedStatement = connection.prepareStatement(this._deleteId);
                preparedStatement.setString(1, str);
                preparedStatement.executeUpdate();
                try {
                    preparedStatement.close();
                } catch (Exception e) {
                    LOG.warn(e);
                }
                connection.close();
            } catch (Throwable th) {
                th = th;
                if (preparedStatement != null) {
                    try {
                        preparedStatement.close();
                    } catch (Exception e2) {
                        LOG.warn(e2);
                    }
                }
                if (connection != null) {
                    connection.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            connection = null;
        }
    }

    private boolean exists(String str) throws SQLException {
        Connection connection;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            try {
                connection.setAutoCommit(true);
                preparedStatement = connection.prepareStatement(this._queryId);
                preparedStatement.setString(1, str);
                boolean next = preparedStatement.executeQuery().next();
                try {
                    preparedStatement.close();
                } catch (Exception e) {
                    LOG.warn(e);
                }
                connection.close();
                return next;
            } catch (Throwable th) {
                th = th;
                if (preparedStatement != null) {
                    try {
                        preparedStatement.close();
                    } catch (Exception e2) {
                        LOG.warn(e2);
                    }
                }
                if (connection != null) {
                    connection.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            connection = null;
        }
    }

    private void initializeDatabase() throws Exception {
        if (this._datasource != null) {
            return;
        }
        if (this._jndiName != null) {
            this._datasource = (DataSource) new InitialContext().lookup(this._jndiName);
            return;
        }
        Driver driver = this._driver;
        if (driver != null && this._connectionUrl != null) {
            DriverManager.registerDriver(driver);
            return;
        }
        String str = this._driverClassName;
        if (str == null || this._connectionUrl == null) {
            throw new IllegalStateException("No database configured for sessions");
        }
        Class.forName(str);
    }

    private void insert(String str) throws SQLException {
        PreparedStatement preparedStatement;
        Connection connection;
        PreparedStatement preparedStatement2 = null;
        try {
            Connection connection2 = getConnection();
            try {
                connection2.setAutoCommit(true);
                PreparedStatement prepareStatement = connection2.prepareStatement(this._queryId);
                try {
                    prepareStatement.setString(1, str);
                    if (!prepareStatement.executeQuery().next()) {
                        preparedStatement2 = connection2.prepareStatement(this._insertId);
                        preparedStatement2.setString(1, str);
                        preparedStatement2.executeUpdate();
                    }
                    try {
                        prepareStatement.close();
                    } catch (Exception e) {
                        LOG.warn(e);
                    }
                    if (preparedStatement2 != null) {
                        try {
                            preparedStatement2.close();
                        } catch (Exception e2) {
                            LOG.warn(e2);
                        }
                    }
                    connection2.close();
                } catch (Throwable th) {
                    th = th;
                    connection = connection2;
                    preparedStatement = preparedStatement2;
                    preparedStatement2 = prepareStatement;
                    if (preparedStatement2 != null) {
                        try {
                            preparedStatement2.close();
                        } catch (Exception e3) {
                            LOG.warn(e3);
                        }
                    }
                    if (preparedStatement != null) {
                        try {
                            preparedStatement.close();
                        } catch (Exception e4) {
                            LOG.warn(e4);
                        }
                    }
                    if (connection != null) {
                        connection.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                connection = connection2;
                preparedStatement = null;
            }
        } catch (Throwable th3) {
            th = th3;
            preparedStatement = null;
            connection = null;
        }
    }

    private void prepareTables() throws SQLException {
        Connection connection;
        this._createSessionIdTable = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("create table "), this._sessionIdTable, " (id varchar(120), primary key(id))");
        this._selectBoundedExpiredSessions = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("select * from "), this._sessionTable, " where expiryTime >= ? and expiryTime <= ?");
        this._selectExpiredSessions = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("select * from "), this._sessionTable, " where expiryTime >0 and expiryTime <= ?");
        this._deleteOldExpiredSessions = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("delete from "), this._sessionTable, " where expiryTime >0 and expiryTime <= ?");
        this._insertId = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("insert into "), this._sessionIdTable, " (id)  values (?)");
        this._deleteId = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("delete from "), this._sessionIdTable, " where id = ?");
        this._queryId = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("select * from "), this._sessionIdTable, " where id = ?");
        Connection connection2 = null;
        try {
            connection = getConnection();
        } catch (Throwable th) {
            th = th;
        }
        try {
            connection.setAutoCommit(true);
            DatabaseMetaData metaData = connection.getMetaData();
            DatabaseAdaptor databaseAdaptor = new DatabaseAdaptor(metaData);
            this._dbAdaptor = databaseAdaptor;
            this._sessionTableRowId = databaseAdaptor.getRowIdColumnName();
            if (!metaData.getTables(null, null, this._dbAdaptor.convertIdentifier(this._sessionIdTable), null).next()) {
                connection.createStatement().executeUpdate(this._createSessionIdTable);
            }
            String convertIdentifier = this._dbAdaptor.convertIdentifier(this._sessionTable);
            if (!metaData.getTables(null, null, convertIdentifier, null).next()) {
                String blobType = this._dbAdaptor.getBlobType();
                String longType = this._dbAdaptor.getLongType();
                this._createSessionTable = "create table " + this._sessionTable + " (" + this._sessionTableRowId + " varchar(120), sessionId varchar(120),  contextPath varchar(60), virtualHost varchar(60), lastNode varchar(60), accessTime " + longType + ",  lastAccessTime " + longType + ", createTime " + longType + ", cookieTime " + longType + ",  lastSavedTime " + longType + ", expiryTime " + longType + ", map " + blobType + ", primary key(" + this._sessionTableRowId + "))";
                connection.createStatement().executeUpdate(this._createSessionTable);
            }
            String str = "idx_" + this._sessionTable + "_expiry";
            String str2 = "idx_" + this._sessionTable + "_session";
            ResultSet indexInfo = metaData.getIndexInfo(null, null, convertIdentifier, false, false);
            boolean z = false;
            boolean z2 = false;
            while (indexInfo.next()) {
                String string = indexInfo.getString("INDEX_NAME");
                if (str.equalsIgnoreCase(string)) {
                    z = true;
                } else if (str2.equalsIgnoreCase(string)) {
                    z2 = true;
                }
            }
            if (!z || !z2) {
                Statement createStatement = connection.createStatement();
                if (!z) {
                    createStatement.executeUpdate("create index " + str + " on " + this._sessionTable + " (expiryTime)");
                }
                if (!z2) {
                    createStatement.executeUpdate("create index " + str2 + " on " + this._sessionTable + " (sessionId, contextPath)");
                }
                if (createStatement != null) {
                    try {
                        createStatement.close();
                    } catch (Exception e) {
                        LOG.warn(e);
                    }
                }
            }
            this._insertSession = "insert into " + this._sessionTable + " (" + this._sessionTableRowId + ", sessionId, contextPath, virtualHost, lastNode, accessTime, lastAccessTime, createTime, cookieTime, lastSavedTime, expiryTime, map)  values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            StringBuilder sb = new StringBuilder();
            sb.append("delete from ");
            sb.append(this._sessionTable);
            sb.append(" where ");
            sb.append(this._sessionTableRowId);
            sb.append(" = ?");
            this._deleteSession = sb.toString();
            this._updateSession = "update " + this._sessionTable + " set lastNode = ?, accessTime = ?, lastAccessTime = ?, lastSavedTime = ?, expiryTime = ?, map = ? where " + this._sessionTableRowId + " = ?";
            this._updateSessionNode = "update " + this._sessionTable + " set lastNode = ? where " + this._sessionTableRowId + " = ?";
            this._updateSessionAccessTime = "update " + this._sessionTable + " set lastNode = ?, accessTime = ?, lastAccessTime = ?, lastSavedTime = ?, expiryTime = ? where " + this._sessionTableRowId + " = ?";
            connection.close();
        } catch (Throwable th2) {
            th = th2;
            connection2 = connection;
            if (connection2 != null) {
                connection2.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scavenge() {
        SessionManager sessionManager;
        ArrayList arrayList = new ArrayList();
        Connection connection = null;
        try {
            try {
                if (LOG.isDebugEnabled()) {
                    Logger logger = LOG;
                    logger.debug("Scavenge sweep started at " + System.currentTimeMillis(), new Object[0]);
                }
                if (this._lastScavengeTime > 0) {
                    connection = getConnection();
                    connection.setAutoCommit(true);
                    boolean prepareStatement = connection.prepareStatement(this._selectBoundedExpiredSessions);
                    long j = this._lastScavengeTime - this._scavengeIntervalMs;
                    long j2 = this._lastScavengeTime;
                    if (LOG.isDebugEnabled()) {
                        Logger logger2 = LOG;
                        logger2.debug(" Searching for sessions expired between " + j + " and " + j2, new Object[0]);
                    }
                    prepareStatement.setLong(1, j);
                    prepareStatement.setLong(2, j2);
                    ResultSet executeQuery = prepareStatement.executeQuery();
                    while (executeQuery.next()) {
                        String string = executeQuery.getString("sessionId");
                        arrayList.add(string);
                        if (LOG.isDebugEnabled()) {
                            Logger logger3 = LOG;
                            logger3.debug(" Found expired sessionId=" + string, new Object[0]);
                        }
                    }
                    Handler[] childHandlersByClass = this._server.getChildHandlersByClass(ContextHandler.class);
                    for (int i = 0; childHandlersByClass != null && i < childHandlersByClass.length; i++) {
                        SessionHandler sessionHandler = (SessionHandler) ((ContextHandler) childHandlersByClass[i]).getChildHandlerByClass(SessionHandler.class);
                        if (sessionHandler != null && (sessionManager = sessionHandler.getSessionManager()) != null && (sessionManager instanceof JDBCSessionManager)) {
                            ((JDBCSessionManager) sessionManager).expire(arrayList);
                        }
                    }
                    long j3 = this._lastScavengeTime;
                    long j4 = this._scavengeIntervalMs;
                    Long.signum(j4);
                    long j5 = j3 - (j4 * 2);
                    if (j5 > 0) {
                        if (LOG.isDebugEnabled()) {
                            Logger logger4 = LOG;
                            logger4.debug("Deleting old expired sessions expired before " + j5, new Object[0]);
                        }
                        try {
                            prepareStatement = connection.prepareStatement(this._deleteOldExpiredSessions);
                            prepareStatement.setLong(1, j5);
                            int executeUpdate = prepareStatement.executeUpdate();
                            prepareStatement = LOG.isDebugEnabled();
                            if (prepareStatement) {
                                Logger logger5 = LOG;
                                logger5.debug("Deleted " + executeUpdate + " rows of old sessions expired before " + j5, new Object[0]);
                            }
                        } finally {
                            if (prepareStatement != null) {
                                try {
                                    prepareStatement.close();
                                } catch (Exception e) {
                                    LOG.warn(e);
                                }
                            }
                        }
                    }
                }
                this._lastScavengeTime = System.currentTimeMillis();
                if (LOG.isDebugEnabled()) {
                    Logger logger6 = LOG;
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Scavenge sweep ended at ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._lastScavengeTime);
                    logger6.debug(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), new Object[0]);
                }
                if (connection == null) {
                    return;
                }
            } catch (Throwable th) {
                this._lastScavengeTime = System.currentTimeMillis();
                if (LOG.isDebugEnabled()) {
                    Logger logger7 = LOG;
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Scavenge sweep ended at ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this._lastScavengeTime);
                    logger7.debug(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString(), new Object[0]);
                }
                if (0 != 0) {
                    try {
                        connection.close();
                    } catch (SQLException e2) {
                        LOG.warn(e2);
                    }
                }
                throw th;
            }
        } catch (Exception e3) {
            if (isRunning()) {
                LOG.warn("Problem selecting expired sessions", e3);
            } else {
                LOG.ignore(e3);
            }
            this._lastScavengeTime = System.currentTimeMillis();
            if (LOG.isDebugEnabled()) {
                Logger logger8 = LOG;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Scavenge sweep ended at ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(this._lastScavengeTime);
                logger8.debug(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString(), new Object[0]);
            }
            if (0 == 0) {
                return;
            }
        }
        try {
            connection.close();
        } catch (SQLException e4) {
            LOG.warn(e4);
        }
    }

    @Override // org.eclipse.jetty.server.SessionIdManager
    public void addSession(ee0 ee0Var) {
        if (ee0Var == null) {
            return;
        }
        synchronized (this._sessionIds) {
            String clusterId = ((JDBCSessionManager.Session) ee0Var).getClusterId();
            try {
                insert(clusterId);
                this._sessionIds.add(clusterId);
            } catch (Exception e) {
                Logger logger = LOG;
                logger.warn("Problem storing session id=" + clusterId, e);
            }
        }
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionIdManager, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        initializeDatabase();
        prepareTables();
        cleanExpiredSessions();
        super.doStart();
        if (LOG.isDebugEnabled()) {
            Logger logger = LOG;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Scavenging interval = ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getScavengeInterval());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" sec");
            logger.debug(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), new Object[0]);
        }
        this._timer = new Timer("JDBCSessionScavenger", true);
        setScavengeInterval(getScavengeInterval());
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionIdManager, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        synchronized (this) {
            if (this._task != null) {
                this._task.cancel();
            }
            if (this._timer != null) {
                this._timer.cancel();
            }
            this._timer = null;
        }
        this._sessionIds.clear();
        super.doStop();
    }

    public String getBlobType() {
        return this._blobType;
    }

    @Override // org.eclipse.jetty.server.SessionIdManager
    public String getClusterId(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf > 0 ? str.substring(0, lastIndexOf) : str;
    }

    public Connection getConnection() throws SQLException {
        DataSource dataSource = this._datasource;
        return dataSource != null ? dataSource.getConnection() : DriverManager.getConnection(this._connectionUrl);
    }

    public String getConnectionUrl() {
        return this._connectionUrl;
    }

    public DataSource getDataSource() {
        return this._datasource;
    }

    public String getDatasourceName() {
        return this._jndiName;
    }

    public String getDriverClassName() {
        return this._driverClassName;
    }

    public String getLongType() {
        return this._longType;
    }

    @Override // org.eclipse.jetty.server.SessionIdManager
    public String getNodeId(String str, ae0 ae0Var) {
        if (this._workerName != null) {
            return str + '.' + this._workerName;
        }
        return str;
    }

    public long getScavengeInterval() {
        return this._scavengeIntervalMs / 1000;
    }

    @Override // org.eclipse.jetty.server.SessionIdManager
    public boolean idInUse(String str) {
        boolean contains;
        if (str == null) {
            return false;
        }
        String clusterId = getClusterId(str);
        synchronized (this._sessionIds) {
            contains = this._sessionIds.contains(clusterId);
        }
        if (contains) {
            return true;
        }
        try {
            return exists(clusterId);
        } catch (Exception e) {
            Logger logger = LOG;
            logger.warn("Problem checking inUse for id=" + clusterId, e);
            return false;
        }
    }

    @Override // org.eclipse.jetty.server.SessionIdManager
    public void invalidateAll(String str) {
        SessionManager sessionManager;
        removeSession(str);
        synchronized (this._sessionIds) {
            Handler[] childHandlersByClass = this._server.getChildHandlersByClass(ContextHandler.class);
            for (int i = 0; childHandlersByClass != null && i < childHandlersByClass.length; i++) {
                SessionHandler sessionHandler = (SessionHandler) ((ContextHandler) childHandlersByClass[i]).getChildHandlerByClass(SessionHandler.class);
                if (sessionHandler != null && (sessionManager = sessionHandler.getSessionManager()) != null && (sessionManager instanceof JDBCSessionManager)) {
                    ((JDBCSessionManager) sessionManager).invalidateSession(str);
                }
            }
        }
    }

    public void removeSession(String str) {
        if (str == null) {
            return;
        }
        synchronized (this._sessionIds) {
            if (LOG.isDebugEnabled()) {
                Logger logger = LOG;
                logger.debug("Removing session id=" + str, new Object[0]);
            }
            try {
                this._sessionIds.remove(str);
                delete(str);
            } catch (Exception e) {
                Logger logger2 = LOG;
                logger2.warn("Problem removing session id=" + str, e);
            }
        }
    }

    @Override // org.eclipse.jetty.server.SessionIdManager
    public void removeSession(ee0 ee0Var) {
        if (ee0Var == null) {
            return;
        }
        removeSession(((JDBCSessionManager.Session) ee0Var).getClusterId());
    }

    public void setBlobType(String str) {
        this._blobType = str;
    }

    public void setDatasource(DataSource dataSource) {
        this._datasource = dataSource;
    }

    public void setDatasourceName(String str) {
        this._jndiName = str;
    }

    public void setDriverInfo(String str, String str2) {
        this._driverClassName = str;
        this._connectionUrl = str2;
    }

    public void setDriverInfo(Driver driver, String str) {
        this._driver = driver;
        this._connectionUrl = str;
    }

    public void setLongType(String str) {
        this._longType = str;
    }

    public void setScavengeInterval(long j) {
        if (j <= 0) {
            j = 60;
        }
        long j2 = this._scavengeIntervalMs;
        long j3 = j * 1000;
        this._scavengeIntervalMs = j3;
        long j4 = j3 / 10;
        if (System.currentTimeMillis() % 2 == 0) {
            this._scavengeIntervalMs += j4;
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Scavenging every "), this._scavengeIntervalMs, " ms"), new Object[0]);
        }
        if (this._timer != null) {
            if (j3 == j2 && this._task != null) {
                return;
            }
            synchronized (this) {
                if (this._task != null) {
                    this._task.cancel();
                }
                TimerTask timerTask = new TimerTask() { // from class: org.eclipse.jetty.server.session.JDBCSessionIdManager.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        JDBCSessionIdManager.this.scavenge();
                    }
                };
                this._task = timerTask;
                this._timer.schedule(timerTask, this._scavengeIntervalMs, this._scavengeIntervalMs);
            }
        }
    }
}
