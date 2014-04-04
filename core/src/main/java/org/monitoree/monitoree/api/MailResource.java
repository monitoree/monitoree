package org.monitoree.monitoree.api;

public interface MailResource extends Manageable<MailResource> {

	String serverName();

	long connectionTime();

	boolean testConnection();

}