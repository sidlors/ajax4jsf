package mx.com.sidlors.services;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import mx.com.sidlors.interfaces.services.IFileUploadManager;

public class FileUploadManager implements IFileUploadManager {
	
	
	private String repository;

	@Override
	public void uploadFile(List<FileItem> items, File repository) {
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(repository);

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		Iterator<FileItem> iter = items.iterator();

		while (iter.hasNext()) {
			FileItem item = iter.next();

			if (item.isFormField()) {
				processFormField(item);
			} else {
				processUploadedFile(item);
			}
		}

	}
	
	@Override
	public void uploadFile(File file) {
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(new File(repository));
		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
//		Iterator<FileItem> iter = items.iterator();
//
//		while (iter.hasNext()) {
//			FileItem item = iter.next();
//
//			if (item.isFormField()) {
//				processFormField(item);
//			} else {
//				processUploadedFile(item);
//			}
//		}
		
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
	
	



}
