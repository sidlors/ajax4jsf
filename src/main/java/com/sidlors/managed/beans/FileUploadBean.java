package com.sidlors.managed.beans;

import java.io.File ;
import java.util.ArrayList;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;
import mx.com.sidlors.interfaces.services.IFileUploadManager;

public class FileUploadBean {

	private ArrayList<File> files = new ArrayList<File>();
	private int uploadsAvailable = 2;
	private boolean autoUpload = false;
	private boolean useFlash = false;
	private IFileUploadManager fileUploadManager;

	private static final Logger logger = Logger.getLogger(FileUploadBean.class);

	public int getSize() {
		if (getFiles().size() > 0) {
			return getFiles().size();
		} else {
			return 0;
		}
	}

	public FileUploadBean() {
	}

//	public void paint(OutputStream stream, Object object) throws IOException {
//		stream.write(getFiles().get((Integer) object).getData());
//	}

	public void listener(UploadEvent event) throws Exception {
		UploadItem item = event.getUploadItem();
		if (validatorMultipart(item)) {
			fileUploadManager.uploadFile(item.getFile());
			//files.add(file);
			logger.setLevel(Level.INFO);
			logger.info("Paso");
			uploadsAvailable--;
		}
	}

	private boolean validatorMultipart(UploadItem item) {
		//ServletFileUpload.isMultipartContent(FacesContext.getCurrentInstance().getExternalContext().getRequest());
		//TODO Validar boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		return true;
	}

	public String clearUploadData() {
		files.clear();
		setUploadsAvailable(5);
		return null;
	}

	public long getTimeStamp() {
		return System.currentTimeMillis();
	}

	public ArrayList<File> getFiles() {
		return files;
	}

	public void setFiles(ArrayList<File> files) {
		this.files = files;
	}

	public int getUploadsAvailable() {
		return uploadsAvailable;
	}

	public void setUploadsAvailable(int uploadsAvailable) {
		this.uploadsAvailable = uploadsAvailable;
	}

	public boolean isAutoUpload() {
		return autoUpload;
	}

	public void setAutoUpload(boolean autoUpload) {
		this.autoUpload = autoUpload;
	}

	public boolean isUseFlash() {
		return useFlash;
	}

	public void setUseFlash(boolean useFlash) {
		this.useFlash = useFlash;
	}

	public void setFileUploadManager(IFileUploadManager fileUploadManager) {
		this.fileUploadManager = fileUploadManager;
	}

	public IFileUploadManager getFileUploadManager() {
		return fileUploadManager;
	}
	
	
	

}