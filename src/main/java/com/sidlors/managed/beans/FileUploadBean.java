package com.sidlors.managed.beans;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputTextarea;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import org.apache.log4j.Logger;
import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

public class FileUploadBean implements Serializable {
	
	private static final long serialVersionUID = 8566168864254652768L;
	private static final Logger logger = Logger.getLogger(FileUploadBean.class);
	private ArrayList<FileCuenta> files = new ArrayList<FileCuenta>();
	private int uploadsAvailable = 2;
	private boolean autoUpload = false;
	private boolean useFlash = false;



	public FileUploadBean() {

	}

	public int getSize() {
		if (getFiles().size() > 0) {
			return getFiles().size();
		} else {
			return 0;
		}
	}

	public void listener(UploadEvent event) throws Exception {

		UploadItem item = event.getUploadItem();
		if (item.getFile() != null && item.getFileName() != null) {
			String nameFileUploaded = event.getUploadItem().getFileName();
			FileCuenta file = new FileCuenta();
			file.setLength(item.getFile().getTotalSpace());
			file.setName(item.getFileName());
			file.setData(item.getData());
			file.setFile(item.getFile());
			file.setNombreLote("Lote Prueba");
			files.add(file);
			uploadsAvailable--;
			FileUtil.copyFileUsingChannel(file.getFile(), new File("C:\\workarea\\workarea_watch\\files\\" + nameFileUploaded));
		}

	}
	
	
	
	public void validator(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		logger.debug("Component" + component);
		HtmlInputTextarea textArea = (HtmlInputTextarea) component;
		String submitted = textArea.getSubmittedValue().toString(); 
		if (submitted.length() > 255)
		{
			textArea.setSubmittedValue(submitted.substring(0, 254));
			FacesMessage msg = new FacesMessage("Solo se permiten 255 caracteres como maximo. Se trunca la entrada a dicha longitud.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
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

	public ArrayList<FileCuenta> getFiles() {
		return files;
	}

	public void setFiles(ArrayList<FileCuenta> files) {
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


}