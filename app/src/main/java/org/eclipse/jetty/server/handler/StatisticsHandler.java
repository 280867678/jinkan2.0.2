package org.eclipse.jetty.server.handler;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import javax.servlet.ServletException;
import me.tvspark.ae0;
import me.tvspark.ce0;
import me.tvspark.outline;
import org.eclipse.jetty.continuation.Continuation;
import org.eclipse.jetty.continuation.ContinuationListener;
import org.eclipse.jetty.server.AsyncContinuation;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Response;
import org.eclipse.jetty.util.statistic.CounterStatistic;
import org.eclipse.jetty.util.statistic.SampleStatistic;

/* loaded from: classes4.dex */
public class StatisticsHandler extends HandlerWrapper {
    public final AtomicLong _statsStartedAt = new AtomicLong();
    public final CounterStatistic _requestStats = new CounterStatistic();
    public final SampleStatistic _requestTimeStats = new SampleStatistic();
    public final CounterStatistic _dispatchedStats = new CounterStatistic();
    public final SampleStatistic _dispatchedTimeStats = new SampleStatistic();
    public final CounterStatistic _suspendStats = new CounterStatistic();
    public final AtomicInteger _resumes = new AtomicInteger();
    public final AtomicInteger _expires = new AtomicInteger();
    public final AtomicInteger _responses1xx = new AtomicInteger();
    public final AtomicInteger _responses2xx = new AtomicInteger();
    public final AtomicInteger _responses3xx = new AtomicInteger();
    public final AtomicInteger _responses4xx = new AtomicInteger();
    public final AtomicInteger _responses5xx = new AtomicInteger();
    public final AtomicLong _responsesTotalBytes = new AtomicLong();
    public final ContinuationListener _onCompletion = new ContinuationListener() { // from class: org.eclipse.jetty.server.handler.StatisticsHandler.1
        @Override // org.eclipse.jetty.continuation.ContinuationListener
        public void onComplete(Continuation continuation) {
            Request baseRequest = ((AsyncContinuation) continuation).getBaseRequest();
            long currentTimeMillis = System.currentTimeMillis() - baseRequest.getTimeStamp();
            StatisticsHandler.this._requestStats.decrement();
            StatisticsHandler.this._requestTimeStats.set(currentTimeMillis);
            StatisticsHandler.this.updateResponse(baseRequest);
            if (!continuation.isResumed()) {
                StatisticsHandler.this._suspendStats.decrement();
            }
        }

        @Override // org.eclipse.jetty.continuation.ContinuationListener
        public void onTimeout(Continuation continuation) {
            StatisticsHandler.this._expires.incrementAndGet();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void updateResponse(Request request) {
        AtomicInteger atomicInteger;
        Response response = request.getResponse();
        int status = response.getStatus() / 100;
        if (status == 1) {
            atomicInteger = this._responses1xx;
        } else if (status == 2) {
            atomicInteger = this._responses2xx;
        } else if (status == 3) {
            atomicInteger = this._responses3xx;
        } else if (status != 4) {
            if (status == 5) {
                atomicInteger = this._responses5xx;
            }
            this._responsesTotalBytes.addAndGet(response.getContentCount());
        } else {
            atomicInteger = this._responses4xx;
        }
        atomicInteger.incrementAndGet();
        this._responsesTotalBytes.addAndGet(response.getContentCount());
    }

    @Override // org.eclipse.jetty.server.handler.HandlerWrapper, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.AggregateLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        super.doStart();
        statsReset();
    }

    public int getDispatched() {
        return (int) this._dispatchedStats.getTotal();
    }

    public int getDispatchedActive() {
        return (int) this._dispatchedStats.getCurrent();
    }

    public int getDispatchedActiveMax() {
        return (int) this._dispatchedStats.getMax();
    }

    public long getDispatchedTimeMax() {
        return this._dispatchedTimeStats.getMax();
    }

    public double getDispatchedTimeMean() {
        return this._dispatchedTimeStats.getMean();
    }

    public double getDispatchedTimeStdDev() {
        return this._dispatchedTimeStats.getStdDev();
    }

    public long getDispatchedTimeTotal() {
        return this._dispatchedTimeStats.getTotal();
    }

    public int getExpires() {
        return this._expires.get();
    }

    public long getRequestTimeMax() {
        return this._requestTimeStats.getMax();
    }

    public double getRequestTimeMean() {
        return this._requestTimeStats.getMean();
    }

    public double getRequestTimeStdDev() {
        return this._requestTimeStats.getStdDev();
    }

    public long getRequestTimeTotal() {
        return this._requestTimeStats.getTotal();
    }

    public int getRequests() {
        return (int) this._requestStats.getTotal();
    }

    public int getRequestsActive() {
        return (int) this._requestStats.getCurrent();
    }

    public int getRequestsActiveMax() {
        return (int) this._requestStats.getMax();
    }

    public int getResponses1xx() {
        return this._responses1xx.get();
    }

    public int getResponses2xx() {
        return this._responses2xx.get();
    }

    public int getResponses3xx() {
        return this._responses3xx.get();
    }

    public int getResponses4xx() {
        return this._responses4xx.get();
    }

    public int getResponses5xx() {
        return this._responses5xx.get();
    }

    public long getResponsesBytesTotal() {
        return this._responsesTotalBytes.get();
    }

    public int getResumes() {
        return this._resumes.get();
    }

    public long getStatsOnMs() {
        return System.currentTimeMillis() - this._statsStartedAt.get();
    }

    public int getSuspends() {
        return (int) this._suspendStats.getTotal();
    }

    public int getSuspendsActive() {
        return (int) this._suspendStats.getCurrent();
    }

    public int getSuspendsActiveMax() {
        return (int) this._suspendStats.getMax();
    }

    @Override // org.eclipse.jetty.server.handler.HandlerWrapper, org.eclipse.jetty.server.Handler
    public void handle(String str, Request request, ae0 ae0Var, ce0 ce0Var) throws IOException, ServletException {
        long currentTimeMillis;
        this._dispatchedStats.increment();
        AsyncContinuation asyncContinuation = request.getAsyncContinuation();
        if (asyncContinuation.isInitial()) {
            this._requestStats.increment();
            currentTimeMillis = request.getTimeStamp();
        } else {
            currentTimeMillis = System.currentTimeMillis();
            this._suspendStats.decrement();
            if (asyncContinuation.isResumed()) {
                this._resumes.incrementAndGet();
            }
        }
        try {
            super.handle(str, request, ae0Var, ce0Var);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            this._dispatchedStats.decrement();
            this._dispatchedTimeStats.set(currentTimeMillis2);
            if (asyncContinuation.isSuspended()) {
                if (asyncContinuation.isInitial()) {
                    asyncContinuation.addContinuationListener(this._onCompletion);
                }
                this._suspendStats.increment();
            } else if (!asyncContinuation.isInitial()) {
            } else {
                this._requestStats.decrement();
                this._requestTimeStats.set(currentTimeMillis2);
                updateResponse(request);
            }
        } catch (Throwable th) {
            long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
            this._dispatchedStats.decrement();
            this._dispatchedTimeStats.set(currentTimeMillis3);
            if (asyncContinuation.isSuspended()) {
                if (asyncContinuation.isInitial()) {
                    asyncContinuation.addContinuationListener(this._onCompletion);
                }
                this._suspendStats.increment();
            } else if (asyncContinuation.isInitial()) {
                this._requestStats.decrement();
                this._requestTimeStats.set(currentTimeMillis3);
                updateResponse(request);
            }
            throw th;
        }
    }

    public void statsReset() {
        this._statsStartedAt.set(System.currentTimeMillis());
        this._requestStats.reset();
        this._requestTimeStats.reset();
        this._dispatchedStats.reset();
        this._dispatchedTimeStats.reset();
        this._suspendStats.reset();
        this._resumes.set(0);
        this._expires.set(0);
        this._responses1xx.set(0);
        this._responses2xx.set(0);
        this._responses3xx.set(0);
        this._responses4xx.set(0);
        this._responses5xx.set(0);
        this._responsesTotalBytes.set(0L);
    }

    public String toStatsHTML() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("<h1>Statistics:</h1>\n", "Statistics gathering started ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getStatsOnMs());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("ms ago");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("<br />\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("<h2>Requests:</h2>\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("Total requests: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getRequests());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("<br />\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("Active requests: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getRequestsActive());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("<br />\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("Max active requests: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getRequestsActiveMax());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("<br />\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("Total requests time: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getRequestTimeTotal());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("<br />\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("Mean request time: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getRequestTimeMean());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("<br />\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("Max request time: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getRequestTimeMax());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("<br />\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("Request time standard deviation: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getRequestTimeStdDev());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("<br />\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("<h2>Dispatches:</h2>\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("Total dispatched: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getDispatched());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("<br />\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("Active dispatched: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getDispatchedActive());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("<br />\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("Max active dispatched: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getDispatchedActiveMax());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("<br />\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("Total dispatched time: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getDispatchedTimeTotal());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("<br />\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("Mean dispatched time: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getDispatchedTimeMean());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("<br />\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("Max dispatched time: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getDispatchedTimeMax());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("<br />\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("Dispatched time standard deviation: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getDispatchedTimeStdDev());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("<br />\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("Total requests suspended: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getSuspends());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("<br />\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("Total requests expired: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getExpires());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("<br />\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("Total requests resumed: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getResumes());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("<br />\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("<h2>Responses:</h2>\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("1xx responses: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getResponses1xx());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("<br />\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("2xx responses: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getResponses2xx());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("<br />\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("3xx responses: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getResponses3xx());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("<br />\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("4xx responses: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getResponses4xx());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("<br />\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("5xx responses: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getResponses5xx());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("<br />\n");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("Bytes sent total: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getResponsesBytesTotal());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("<br />\n");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
