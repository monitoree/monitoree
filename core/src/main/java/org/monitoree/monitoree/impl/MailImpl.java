package org.monitoree.monitoree.impl;

import org.monitoree.monitoree.api.MailResource;

public class MailImpl implements MailResource {

    @Override
    public String serverName() {
        return "Mysql";
    }

    @Override
    public long connectionTime() {
        return 5;
    }

    @Override
    public boolean testConnection() {
        return true;
    }

    @Override
    public Class<MailResource> getManageableInterface() {
        return null;
    }

    @Override
    public org.monitoree.monitoree.api.Manageable.Type getType() {
        return Type.SYSTEM;
    }

}
