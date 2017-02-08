package com.sidlors.async.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.sidlors.model.ResultModel;



public class SynchronousQueueService implements ISynchronousQueueService {

	private ExecutorService pool;


	public SynchronousQueueService() {
		final SynchronousQueue<Runnable> blockingQueue = new SynchronousQueue<Runnable>();
		RejectedExecutionHandler rejectHandler = new RejectedExecutionHandler() {
			@Override
			public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
				try {
					blockingQueue.put(r);
				} catch (InterruptedException e) {
					throw new RejectedExecutionException(e);
				}
			}
		};
		this.setPool(new ThreadPoolExecutor(8, 8, 60, TimeUnit.SECONDS, blockingQueue, rejectHandler));
	}

	@Override
	public void doService(String cmd, int request, int limit,int watchrequestid,int criterionid){
		
		List<ResultModel> list = new ArrayList<ResultModel>();
		List<Runnable> workers = new ArrayList<Runnable>(request);

		for (int i = 0; i < request; i++) {
			workers.add(i, new WorkerThread("worker-" + i, limit * i, limit, cmd,watchrequestid, criterionid));
			getPool().execute(workers.get(i));

		}
		
		getPool().shutdown();
		while (!getPool().isTerminated()) {

		}
		

	

	}

	public ExecutorService getPool() {
		return pool;
	}

	public void setPool(ExecutorService pool) {
		this.pool = pool;
	}
	
	


}
