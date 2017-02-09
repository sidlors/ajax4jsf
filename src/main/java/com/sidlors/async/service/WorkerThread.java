package com.sidlors.async.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sidlors.model.ResultModel;
import com.sidlors.util.Constant;
import com.sidlors.util.DBInformation;
import com.sidlors.util.WriterResult;


public class WorkerThread implements Runnable {
	private String command;
	private String query;
	private int watchrequestid;
	private int criterionid;
	private int skip;
	private int limit;
	private List<ResultModel> elements;

	final static Logger logger = LoggerFactory.getLogger(WorkerThread.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bc.services.impl.IWorkerThread#run()
	 */

	public WorkerThread(String command, int skip, int limit, String query,int watchrequestid,int criterionid) {


		this.command = command;
		this.query=query;
		this.watchrequestid=watchrequestid;
		this.criterionid=criterionid;
		this.skip = skip;
		this.limit = limit;
	}

	@Override
	public void run() {
		logger.info("Command = " + command + " Start");
		processCommand();
	
	}

	private void processCommand() {
		Connection dbConnection = null;
		PreparedStatement statement=null;
		try {
			String selectTableSQL = String.format(query, skip, limit);
			dbConnection = DBInformation.getDBConnection();
			//statement = dbConnection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			statement=dbConnection.prepareStatement(selectTableSQL,ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			statement.setInt(1, watchrequestid);
			statement.setInt(2, criterionid);
			long start = System.currentTimeMillis();
			logger.info(selectTableSQL);
			ResultSet rs = statement.executeQuery();
			long result = System.currentTimeMillis();
			elements = new ArrayList<ResultModel>();
			ResultModel modelo;

			while (rs.next()) {
				modelo = new ResultModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10), rs.getString(11), rs.getString(12));
				elements.add(modelo);
			}
			long iniWr = System.currentTimeMillis();
			WriterResult.writeFile(elements, Constant.WORKAREA_FILES_PATH+"fileName");
			long fniWr = System.currentTimeMillis();
			long fin = System.currentTimeMillis();
			logger.info("Command = " + command + " == Query Results: " + (result - start) / 1000
					+ " == Process Results: " + (iniWr - result) / 1000 + " == Process WritterFile: "
					+ (fniWr - iniWr) / 1000 + " == Total : " + (fin - start) / 1000);
		} catch (IOException io) {
			logger.error(io.getMessage());
		} catch (SQLException sql) {
			logger.error(sql.getMessage());
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bc.services.impl.IWorkerThread#toString()
	 */
	@Override
	public String toString() {
		return this.command;
	}

	public List<ResultModel> getElements() {
		return elements;
	}

}