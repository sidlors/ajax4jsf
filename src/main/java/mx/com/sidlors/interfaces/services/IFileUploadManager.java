package mx.com.sidlors.interfaces.services;

import java.io.File;
import java.util.List;

public interface IFileUploadManager {

	abstract void moveUploadedFiles(List<File> files);

}
