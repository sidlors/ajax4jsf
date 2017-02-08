package com.sidlors.managed.beans;

import java.util.TimeZone;

import org.apache.log4j.Logger;


public abstract class BaseBean {
	
	/* Global mappings  */
	protected static String SUCCESS = "success";
	protected static String FAILURE = "failure";
	private Logger log = Logger.getLogger(BaseBean.class);
	public static String USER_APP = "#{userBean}";
	public static String USER_APP_PF = "#{userBeanPF}";
	
	
	
	/**
	 * Recupera la cadena con la especificaci?n de la zona horaria del host.
	 * 
	 * @author jfragoso
	 * 
	 * @return cadena que especifica la zona horaria actual.
	 */
	public String getTimeZone() {
		return TimeZone.getDefault().getID();
	}
	
	

}

