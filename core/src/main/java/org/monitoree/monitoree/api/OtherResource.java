package org.monitoree.monitoree.api;

public interface OtherResource extends Manageable<OtherResource> {

    String getResourceName();

    String getResourceType();

    boolean test();
}
