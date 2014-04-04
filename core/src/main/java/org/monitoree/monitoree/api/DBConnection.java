package org.monitoree.monitoree.api;

public interface DBConnection extends Connection, Manageable<DBConnection> {

    /**
     * Logical name of the Database pool.
     * @return name attribute
     */
    String getPoolName();
}
