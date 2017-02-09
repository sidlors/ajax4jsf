package com.sidlors.managed.beans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSessionContext;

import com.sidlors.async.service.IDownloaderReportService;
import com.sidlors.model.ResultModel;
import com.sidlors.util.Constant;
import com.sidlors.util.ReadListCSV;

public class DownloaderReport implements Serializable {

	private IDownloaderReportService downloaderReportService;

	private static final long serialVersionUID = -3898521873297798192L;

	public void download() {
		List<ResultModel> listModel = null;
		try {
			listModel = downloaderReportService.getListModel(new File(Constant.WORKAREA_FILES_PATH + "fileName.csv"));
			processReport(listModel);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	private void processReport(List<ResultModel> listModel) throws IOException {
		File file = new File(Constant.WORKAREA_FILES_PATH +"Reporte.csv");
		String fileName = file.getName();
		//FileUtil.copyFileUsingChannel(new File(file.getPath()), new File(Constant.WORKAREA_FILES_PATH+"output.csv"));
		
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse) fc.getExternalContext().getResponse();
		
		int contentLength = (int) file.length();
		response.reset();
		//response.setContentType(contentType);
		response.setContentLength(contentLength);
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
		OutputStream output = response.getOutputStream();
		ReadListCSV.serializeModel(ResultModel.class,listModel, file);
		byte[] bytesArray = new byte[(int) file.length()];
		
		output.write(bytesArray);
		fc.responseComplete();

	}

	public void setDownloaderReportService(IDownloaderReportService downloaderReportService) {
		this.downloaderReportService = downloaderReportService;
	}

}
