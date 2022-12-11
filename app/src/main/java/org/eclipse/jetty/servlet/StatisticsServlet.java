package org.eclipse.jetty.servlet;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import me.tvspark.ae0;
import me.tvspark.ce0;
import me.tvspark.outline;
import org.eclipse.jetty.http.MimeTypes;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.StatisticsHandler;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.simpleframework.xml.stream.DocumentReader;

/* loaded from: classes5.dex */
public class StatisticsServlet extends HttpServlet {
    public static final Logger LOG = Log.getLogger(StatisticsServlet.class);
    public Connector[] _connectors;
    public MemoryMXBean _memoryBean;
    public boolean _restrictToLocalhost = true;
    public StatisticsHandler _statsHandler;

    private boolean isLoopbackAddress(String str) {
        try {
            return InetAddress.getByName(str).isLoopbackAddress();
        } catch (UnknownHostException e) {
            Logger logger = LOG;
            logger.warn("Warning: attempt to access statistics servlet from " + str, e);
            return false;
        }
    }

    private void sendTextResponse(ce0 ce0Var) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(this._statsHandler.toStatsHTML());
        sb.append("<h2>Connections:</h2>\n");
        Connector[] connectorArr = this._connectors;
        int length = connectorArr.length;
        int i = 0;
        while (true) {
            String str = "<br />\n";
            if (i >= length) {
                sb.append("<h2>Memory:</h2>\n");
                sb.append("Heap memory usage: ");
                sb.append(this._memoryBean.getHeapMemoryUsage().getUsed());
                sb.append(" bytes");
                sb.append(str);
                sb.append("Non-heap memory usage: ");
                sb.append(this._memoryBean.getNonHeapMemoryUsage().getUsed());
                sb.append(" bytes");
                sb.append(str);
                ce0Var.setContentType("text/html");
                ce0Var.getWriter().write(sb.toString());
                return;
            }
            Connector connector = connectorArr[i];
            sb.append("<h3>");
            sb.append(connector.getName());
            sb.append("</h3>");
            if (connector.getStatsOn()) {
                sb.append("Statistics gathering started ");
                sb.append(connector.getStatsOnMs());
                sb.append("ms ago");
                sb.append(str);
                sb.append("Total connections: ");
                sb.append(connector.getConnections());
                sb.append(str);
                sb.append("Current connections open: ");
                sb.append(connector.getConnectionsOpen());
                sb.append(str);
                sb.append("Max concurrent connections open: ");
                sb.append(connector.getConnectionsOpenMax());
                sb.append(str);
                sb.append("Total connections duration: ");
                sb.append(connector.getConnectionsDurationTotal());
                sb.append(str);
                sb.append("Mean connection duration: ");
                sb.append(connector.getConnectionsDurationMean());
                sb.append(str);
                sb.append("Max connection duration: ");
                sb.append(connector.getConnectionsDurationMax());
                sb.append(str);
                sb.append("Connection duration standard deviation: ");
                sb.append(connector.getConnectionsDurationStdDev());
                sb.append(str);
                sb.append("Total requests: ");
                sb.append(connector.getRequests());
                sb.append(str);
                sb.append("Mean requests per connection: ");
                sb.append(connector.getConnectionsRequestsMean());
                sb.append(str);
                sb.append("Max requests per connection: ");
                sb.append(connector.getConnectionsRequestsMax());
                sb.append(str);
                sb.append("Requests per connection standard deviation: ");
                sb.append(connector.getConnectionsRequestsStdDev());
            } else {
                str = "Statistics gathering off.\n";
            }
            sb.append(str);
            i++;
        }
    }

    private void sendXmlResponse(ce0 ce0Var) throws IOException {
        Connector[] connectorArr;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("<statistics>\n", "  <requests>\n", "    <statsOnMs>");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._statsHandler.getStatsOnMs());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("</statsOnMs>\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("    <requests>");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._statsHandler.getRequests());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("</requests>\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("    <requestsActive>");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._statsHandler.getRequestsActive());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("</requestsActive>\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("    <requestsActiveMax>");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._statsHandler.getRequestsActiveMax());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("</requestsActiveMax>\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("    <requestsTimeTotal>");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._statsHandler.getRequestTimeTotal());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("</requestsTimeTotal>\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("    <requestsTimeMean>");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._statsHandler.getRequestTimeMean());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("</requestsTimeMean>\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("    <requestsTimeMax>");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._statsHandler.getRequestTimeMax());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("</requestsTimeMax>\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("    <requestsTimeStdDev>");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._statsHandler.getRequestTimeStdDev());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("</requestsTimeStdDev>\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("    <dispatched>");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._statsHandler.getDispatched());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("</dispatched>\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("    <dispatchedActive>");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._statsHandler.getDispatchedActive());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("</dispatchedActive>\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("    <dispatchedActiveMax>");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._statsHandler.getDispatchedActiveMax());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("</dispatchedActiveMax>\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("    <dispatchedTimeTotal>");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._statsHandler.getDispatchedTimeTotal());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("</dispatchedTimeTotal>\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("    <dispatchedTimeMean>");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._statsHandler.getDispatchedTimeMean());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("</dispatchedTimeMean>\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("    <dispatchedTimeMax>");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._statsHandler.getDispatchedTimeMax());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("</dispatchedTimeMax>\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("    <dispatchedTimeStdDev>");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._statsHandler.getDispatchedTimeStdDev());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("</dispatchedTimeStdDev>\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("    <requestsSuspended>");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._statsHandler.getSuspends());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("</requestsSuspended>\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("    <requestsExpired>");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._statsHandler.getExpires());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("</requestsExpired>\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("    <requestsResumed>");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._statsHandler.getResumes());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("</requestsResumed>\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("  </requests>\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("  <responses>\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("    <responses1xx>");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._statsHandler.getResponses1xx());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("</responses1xx>\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("    <responses2xx>");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._statsHandler.getResponses2xx());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("</responses2xx>\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("    <responses3xx>");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._statsHandler.getResponses3xx());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("</responses3xx>\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("    <responses4xx>");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._statsHandler.getResponses4xx());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("</responses4xx>\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("    <responses5xx>");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._statsHandler.getResponses5xx());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("</responses5xx>\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("    <responsesBytesTotal>");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._statsHandler.getResponsesBytesTotal());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("</responsesBytesTotal>\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("  </responses>\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("  <connections>\n");
        for (Connector connector : this._connectors) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("    <connector>\n");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("      <name>");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(connector.getName());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("</name>\n");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("      <statsOn>");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(connector.getStatsOn());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("</statsOn>\n");
            if (connector.getStatsOn()) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("    <statsOnMs>");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(connector.getStatsOnMs());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("</statsOnMs>\n");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("    <connections>");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(connector.getConnections());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("</connections>\n");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("    <connectionsOpen>");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(connector.getConnectionsOpen());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("</connectionsOpen>\n");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("    <connectionsOpenMax>");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(connector.getConnectionsOpenMax());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("</connectionsOpenMax>\n");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("    <connectionsDurationTotal>");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(connector.getConnectionsDurationTotal());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("</connectionsDurationTotal>\n");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("    <connectionsDurationMean>");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(connector.getConnectionsDurationMean());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("</connectionsDurationMean>\n");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("    <connectionsDurationMax>");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(connector.getConnectionsDurationMax());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("</connectionsDurationMax>\n");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("    <connectionsDurationStdDev>");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(connector.getConnectionsDurationStdDev());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("</connectionsDurationStdDev>\n");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("    <requests>");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(connector.getRequests());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("</requests>\n");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("    <connectionsRequestsMean>");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(connector.getConnectionsRequestsMean());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("</connectionsRequestsMean>\n");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("    <connectionsRequestsMax>");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(connector.getConnectionsRequestsMax());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("</connectionsRequestsMax>\n");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("    <connectionsRequestsStdDev>");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(connector.getConnectionsRequestsStdDev());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("</connectionsRequestsStdDev>\n");
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("    </connector>\n");
        }
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "  </connections>\n", "  <memory>\n", "    <heapMemoryUsage>");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._memoryBean.getHeapMemoryUsage().getUsed());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("</heapMemoryUsage>\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("    <nonHeapMemoryUsage>");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._memoryBean.getNonHeapMemoryUsage().getUsed());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("</nonHeapMemoryUsage>\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("  </memory>\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("</statistics>\n");
        ce0Var.setContentType(MimeTypes.TEXT_XML);
        ce0Var.getWriter().write(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    @Override // javax.servlet.http.HttpServlet
    public void doGet(ae0 ae0Var, ce0 ce0Var) throws ServletException, IOException {
        if (this._statsHandler == null) {
            LOG.warn("Statistics Handler not installed!", new Object[0]);
            ce0Var.sendError(503);
        } else if (this._restrictToLocalhost && !isLoopbackAddress(ae0Var.getRemoteAddr())) {
            ce0Var.sendError(503);
        } else {
            String parameter = ae0Var.getParameter(DocumentReader.RESERVED);
            if (parameter == null) {
                parameter = ae0Var.getParameter("XML");
            }
            if (parameter == null || !"true".equalsIgnoreCase(parameter)) {
                sendTextResponse(ce0Var);
            } else {
                sendXmlResponse(ce0Var);
            }
        }
    }

    @Override // javax.servlet.http.HttpServlet
    public void doPost(ae0 ae0Var, ce0 ce0Var) throws ServletException, IOException {
        doGet(ae0Var, ce0Var);
    }

    @Override // javax.servlet.GenericServlet
    public void init() throws ServletException {
        Server server = ((ContextHandler.Context) getServletContext()).getContextHandler().getServer();
        Handler childHandlerByClass = server.getChildHandlerByClass(StatisticsHandler.class);
        if (childHandlerByClass == null) {
            LOG.warn("Statistics Handler not installed!", new Object[0]);
            return;
        }
        this._statsHandler = (StatisticsHandler) childHandlerByClass;
        this._memoryBean = ManagementFactory.getMemoryMXBean();
        this._connectors = server.getConnectors();
        if (getInitParameter("restrictToLocalhost") == null) {
            return;
        }
        this._restrictToLocalhost = "true".equals(getInitParameter("restrictToLocalhost"));
    }
}
