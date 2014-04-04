package org.monitoree.monitoree.api;

public interface LDAPConnection extends Connection, Manageable<LDAPConnection> {

    String serverName();

}
