package org.monitoree.monitoree.impl;

import org.monitoree.monitoree.api.JmsBean;

public class JmsImpl implements JmsBean {

    @Override
    public Class<JmsBean> getManageableInterface() {
        return JmsBean.class;
    }

    @Override
    public org.monitoree.monitoree.api.Manageable.Type getType() {
        return Type.SYSTEM;
    }

}
