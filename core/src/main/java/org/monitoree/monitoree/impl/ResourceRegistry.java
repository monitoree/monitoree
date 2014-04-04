package org.monitoree.monitoree.impl;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;

import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import javax.management.StandardMBean;

import org.monitoree.monitoree.api.Manageable;


/**
 * Provides API for registering new components.
 */
public class ResourceRegistry {

    // TODO replace with configuration from a file
    /**
     * Prefix for all applications.
     */
    private static final String MBEAN_PATH_PREFIX = "org.monitoree.monitoring.";
    private final static MBeanServer server = ManagementFactory.getPlatformMBeanServer();
    private String applicationName;
    private List<ObjectName> resources = new ArrayList<ObjectName>();

    private ResourceRegistry(final String applicationName) {
        this.applicationName = applicationName;
    }

    /**
     * Creates and returns a new resource registry for this application.
     * @param applicationName name of the application.
     * @return resource registry.
     */
    public static ResourceRegistry getResourceRegistry(final String applicationName) {
        return new ResourceRegistry(applicationName);
    }

    /**
     * Adds a manageable resource.
     * @param manageable resource to add.
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public <T extends Manageable> ObjectName addResource(final T manageable) {

        final Class<T> interfaze = manageable.getManageableInterface();
        try {
            final ObjectName mbeanName = new ObjectName(MBEAN_PATH_PREFIX + this.applicationName + ":type=" + interfaze.getSimpleName());
            final StandardMBean mbean = new StandardMBean(manageable, interfaze);

            // unregister
            removeResource(mbeanName);

            server.registerMBean(mbean, mbeanName);
            resources.add(mbeanName);
            return mbeanName;
        } catch (MalformedObjectNameException e) {
            e.printStackTrace();
        } catch (NotCompliantMBeanException e) {
            e.printStackTrace();
        } catch (InstanceAlreadyExistsException e) {
            e.printStackTrace();
        } catch (MBeanRegistrationException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Removes a manageable resource.
     * @param resourceName name of the resource.
     */
    public void removeResource(final ObjectName resourceName) {
        try {
            server.unregisterMBean(resourceName);
        } catch (MBeanRegistrationException e) {
            e.printStackTrace();
        } catch (InstanceNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Unregisters all resources.
     */
    public void removeAll() {
        for (ObjectName resourceName : resources) {
            removeResource(resourceName);
        }
    }
}
