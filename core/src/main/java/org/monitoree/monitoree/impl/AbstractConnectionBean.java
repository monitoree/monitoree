package org.monitoree.monitoree.impl;

import org.monitoree.monitoree.api.Connection;
import org.monitoree.monitoree.api.ConnectionStatus;

/**
 * Abstract implementation for connection beans.
 * @author Simon Zambrovski, Holisticon AG
 */
public abstract class AbstractConnectionBean implements Connection {

    @Override
    public abstract long getExpectedResponseTime();

    /**
     * Executes connection test. <br />
     * Error description can be extracted from an error using {@link AbstractConnectionBean#extractDescription(Exception)} method.
     * @throws exception on any kind of connection error.
     */
    protected abstract void executeConnectionTest() throws Exception;

    /**
     * Performs a resource cleanup on errors.
     */
    public abstract void cleanUp();

    @Override
    public final ConnectionStatus testConnection() {
        final long start = System.currentTimeMillis();
        long stop = start;
        long responseTime = 0;
        String errorDescription = null;
        ConnectionStatus status = null;
        try {
            executeConnectionTest();
        } catch (Exception e) {
            errorDescription = extractDescription(e);
        } finally {
            stop = System.currentTimeMillis();
            responseTime = stop - start;
            cleanUp();
        }
        if (errorDescription != null) {
            status = ConnectionStatus.FAILURE(responseTime, errorDescription);
        } else {
            status = ConnectionStatus.SUCCESS(responseTime);
        }

        return status;
    }

    /**
     * Reads error message from exception.
     * @param e exception thrown,
     * @return description text.
     */
    protected String extractDescription(Exception e) {
        if (e == null) {
            return null;
        }
        return e.getMessage();
    }

    
}
