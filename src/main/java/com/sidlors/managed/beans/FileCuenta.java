package com.sidlors.managed.beans;

import java.io.File;

public class FileCuenta {

	private String Name;
	private String mime;
	private long length;
	private byte[] data;
	private File file;
	private String nombreLote;

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
		int extDot = name.lastIndexOf('.');
		if (extDot > 0) {
			String extension = name.substring(extDot + 1);
			if ("txt".equals(extension)) {
				mime = "text/plain";
			} else if ("iso".equals(extension)) {
				mime = "image/jpeg";
			} else{
				mime = "image/unknown";
			}
		}
	}

	public long getLength() {
		return length;
	}

	public void setLength(long length) {
		this.length = length;
	}

	public String getMime() {
		return mime;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getNombreLote() {
		return nombreLote;
	}

	public void setNombreLote(String nombreLote) {
		this.nombreLote = nombreLote;
	}
	
	
	

}
