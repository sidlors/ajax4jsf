package com.sidlors.async.service;

public interface ISynchronousQueueService {

	public abstract void doService(String cmd, int request, int limit,int watchrequestid,int criterionid);
}
