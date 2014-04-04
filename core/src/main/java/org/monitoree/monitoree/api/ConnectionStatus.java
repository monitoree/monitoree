package org.monitoree.monitoree.api;

import java.io.Serializable;

/**
 * Represents connection test result.
 */
public class ConnectionStatus implements Serializable {

    private static final long serialVersionUID = 1L;

    public static ConnectionStatus SUCCESS(long responseTime) {
        return new ConnectionStatus(true, responseTime, null);
    }

    public static ConnectionStatus FAILURE(long responseTime, String errorDescription) {
        return new ConnectionStatus(false, responseTime, errorDescription);
    }

    private final boolean status;
    private final long responseTime;
    private final String errorText;

    public ConnectionStatus() {
        this(false, 0, null);
    }

    public ConnectionStatus(boolean status, long responseTime, String errorText) {
        this.status = status;
        this.responseTime = responseTime;
        this.errorText = errorText;
    }

    public boolean isStatus() {
        return status;
    }

    public long getResponseTime() {
        return responseTime;
    }

    public String getErrorText() {
        return errorText;
    }

    @Override
    public String toString() {
        return "Status [status=" + status + ", tat=" + responseTime + ", errorText=" + errorText + "]";
    }

}
