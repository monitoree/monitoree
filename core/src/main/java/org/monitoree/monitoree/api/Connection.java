package org.monitoree.monitoree.api;

/**
 * Represents connection-based resource.
 * @author Simon Zambrovski, Holisticon AG
 */
public interface Connection {

    /**
     * Test method for execution of a representative database access.
     * @return result of the test.
     */
    ConnectionStatus testConnection();

    /**
     * Estimated expected time required for the execution of a request turn-around (tat) in milliseconds.
     * @return tat attribute.
     */
    long getExpectedResponseTime();

}
