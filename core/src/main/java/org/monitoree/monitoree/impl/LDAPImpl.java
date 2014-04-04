package org.monitoree.monitoree.impl;

import org.monitoree.monitoree.api.LDAPConnection;

public class LDAPImpl extends AbstractConnectionBean implements LDAPConnection {

    @Override
    public String serverName() {
        return "OpenLDAP	";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long getExpectedResponseTime() {
        return 4;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void executeConnectionTest() throws Exception {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void cleanUp() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<LDAPConnection> getManageableInterface() {
        return LDAPConnection.class;
    }

    @Override
    public org.monitoree.monitoree.api.Manageable.Type getType() {
        return Type.SYSTEM;
    }
}
