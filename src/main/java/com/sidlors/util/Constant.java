package com.sidlors.util;

public class Constant {
	
	public static final String QUERY=" SELECT "
			+ " SKIP %s LIMIT %s h.sourcetable, h.fieldchanges, "
			+ " h.hitdate ,e.accountnumber, e.fid , e.first , "
			+ " e.paternal , e.maternal ,e.rfc,e.parent_id , "
			+ " e.companyname,r.type "
			+ " FROM watch_hit h	JOIN watch_request r  ON r.id = h.watchrequestid "
			+ "	JOIN watch_entity e ON e.id = h.entityid "
			+ " WHERE e.batch_id = r.batch_id  "
			+ " and h.watchrequestid = ?"
			+ " and h.criterionid = ? ";
	public static final String DB_DRIVER = "com.informix.jdbc.IfxDriver";
	public static final String DB_CONNECTION = "jdbc:informix-sqli://192.168.253.153:1559/watch:INFORMIXSERVER=watch_bc_11";
	public static final String DB_USER = "watprod";
	public static final String DB_PASSWORD = "l1N#wAtP";
	public static final String WORKAREA_PATH="C:\\workarea\\workarea_watch\\";
	public static final String WORKAREA_REPOSITORY_PATH="C:\\workarea\\workarea_watch\\repositorio\\";
	public static final String WORKAREA_FILES_PATH="C:\\workarea\\workarea_watch\\files\\";
	
}

