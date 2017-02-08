package com.sidlors.async.service;



public class BatchReportClient {

	private String request;
	private int limit;
	private int watchrequestid;
	private int criterionid;
	private ISynchronousQueueService service;

	public void doService(String cmd , int limit ,int watchrequestid,int criterionid) {
		service.doService(cmd, Integer.parseInt(request), limit,watchrequestid,criterionid);
	}



	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public ISynchronousQueueService getService() {
		return service;
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



	public String getRequest() {
		return request;
	}



	public void setRequest(String request) {
		this.request = request;
	}



	public void setService(ISynchronousQueueService service) {
		this.service = service;
	}
	
	
	
	
}
