package com.sidlors.managed.beans;

import java.io.File;
import java.util.ArrayList;

import javax.faces.context.FacesContext;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;
import mx.com.sidlors.interfaces.services.IFileUploadManager;

public class FileUploadBean {
	
	
	private static final Logger logger = Logger.getLogger(FileUploadBean.class);

	private ArrayList<File> files = new ArrayList<File>();
	private int uploadsAvailable = 2;
	private boolean autoUpload = false;
	private boolean useFlash = false;
	private IFileUploadManager fileUploadManager;

	

	public int getSize() {
		if (getFiles().size() > 0) {
			return getFiles().size();
		} else {
			return 0;
		}
	}

	public FileUploadBean() {
	}

	public void listener(UploadEvent event) throws Exception {
		UploadItem item = event.getUploadItem();

		File f = item.getFile();

		if (f != null && item.getFileName() != null) {
			UtilFileMoveDirectory.mueveDirectorio(f, new File("C:\\workarea\\temp\\" + item.getFileName()));
		}
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