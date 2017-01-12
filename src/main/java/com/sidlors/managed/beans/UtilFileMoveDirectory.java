package com.sidlors.managed.beans;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class UtilFileMoveDirectory {

	
	private UtilFileMoveDirectory() {

	}

	
	public static void mueveDirectorio(File srcFile, File destFile) {
		try {
			FileUtils.moveFile(srcFile, destFile);
		} catch (IOException ex) {
			System.err.println(ex.getMessage());
		}
		
	}
}