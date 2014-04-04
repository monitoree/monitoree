package org.monitoree.monitoree.impl;

import org.monitoree.monitoree.api.OtherResource;

public class OtherImpl implements OtherResource {

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<OtherResource> getManageableInterface() {
        return OtherResource.class;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getResourceName() {
        return "A resource";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getResourceType() {
        return "Power adapter";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean test() {
        return true;
    }

    @Override
    public org.monitoree.monitoree.api.Manageable.Type getType() {
        return Type.SYSTEM;
    }

}
