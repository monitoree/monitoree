package org.monitoree.monitoree.api;

/**
 * Basic interface as a root of manageable hierarchy.
 * @author Simon Zambrovski, Holisticon AG
 * @param <T> subtype.
 */
public interface Manageable<T extends Manageable<?>> {

    enum Type {
        SYSTEM,
        FUNCTIONAL;
    }

    /**
     * Retrieves the manageable interface.
     * @return interface defining management values and methods.
     */
    public Class<T> getManageableInterface();

    /**
     * Retrieves resource type.
     * @return system or functional.
     */
    public Type getType();
}
