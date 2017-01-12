package mx.com.sidlors.services;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FileUtils;

import mx.com.sidlors.interfaces.services.IFileUploadManager;

public class FileUploadManager implements IFileUploadManager {

	private String repository;
	private String tempDirectory;
	private int maxMemorySize;

	@Override
	public void moveUploadedFiles(List<File> files) {

		if (files.size() > 0 || files != null) {
			try {
				FileUtils.copyDirectory(new File(files.get(0).getParent()), new File(repository));
				FileUtils.cleanDirectory(new File(files.get(0).getParent()));
			} catch (IOException ex) {

			}
		}

	}

	private void processUploadedFile(FileItem item) {
		// TODO Auto-generated method stub

	}

	private void processFormField(FileItem item) {
		// TODO Auto-generated method stub

	}

	public void setRepository(String repository) {
		this.repository = repository;
	}

	public void setTempDirectory(String tempDirectory) {
		this.tempDirectory = tempDirectory;
	}

	public void setMaxMemorySize(int maxMemorySize) {
		this.maxMemorySize = maxMemorySize;
	}
	
	

}
