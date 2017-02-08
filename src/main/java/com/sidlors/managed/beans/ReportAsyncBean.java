package com.sidlors.managed.beans;

import java.io.Serializable;

import com.sidlors.async.service.BatchReportClient;
import com.sidlors.util.Constant;

public class ReportAsyncBean implements Serializable{

	private static final long serialVersionUID = -6528631715573779078L;
	private BatchReportClient batchReportClient;
	private String cmd;
	private int watchrequestid;
	private int criterionid;
	
	public void doService( ){
		
		cmd=Constant.QUERY;
		
		batchReportClient.doService(cmd,1700,watchrequestid,criterionid);
	}

	public BatchReportClient getBatchReportClient() {
		return batchReportClient;
	}

	public void setBatchReportClient(BatchReportClient batchReportClient) {
		this.batchReportClient = batchReportClient;
	}

	public int getWatchrequestid() {
		return watchrequestid;
	}

	public void setWatchrequestid(int watchrequestid) {
		this.watchrequestid = watchrequestid;
	}

	public int getCriterionid() {
		return criterionid;
	}

	public void setCriterionid(int criterionid) {
		this.criterionid = criterionid;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	

	

}
