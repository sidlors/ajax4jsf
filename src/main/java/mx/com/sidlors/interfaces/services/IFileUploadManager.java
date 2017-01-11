package mx.com.sidlors.interfaces.services;

import java.io.File;
import java.util.List;

import org.apache.commons.fileupload.FileItem;

public interface IFileUploadManager {
	


	abstract void uploadFile(List<FileItem> items, File repository);

	abstract void uploadFile(File file);

}
