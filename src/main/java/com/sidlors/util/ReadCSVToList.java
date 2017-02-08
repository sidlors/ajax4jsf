package com.sidlors.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;

import com.sidlors.model.ResultModel;

import net.sf.jsefa.Deserializer;
import net.sf.jsefa.flr.FlrIOFactory;

public class ReadCSVToList {

	private ReadCSVToList() {

	}

	// Utility which converts CSV to ArrayList using Split Operation
	public static ArrayList<String> crunchifyCSVtoArrayList(File file) {

		BufferedReader crunchifyBuffer = null;
		ArrayList<String> crunchifyResult = new ArrayList<String>();

		try {
			String crunchifyLine;
			crunchifyBuffer = new BufferedReader(new FileReader(file));
			while ((crunchifyLine = crunchifyBuffer.readLine()) != null) {
				
				if (crunchifyLine != null) {
					String[] splitData = crunchifyLine.split("\\s*,\\s*");
					for (int i = 0; i < splitData.length; i++) {
						if (!(splitData[i] == null) || !(splitData[i].length() == 0)) {
							crunchifyResult.add(splitData[i].trim());
						}
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (crunchifyBuffer != null)
					crunchifyBuffer.close();
			} catch (IOException crunchifyException) {
				crunchifyException.printStackTrace();
			}
		}
		return crunchifyResult;

	}
	
	private void deserealizacion(){
		Deserializer deserializer = FlrIOFactory.createFactory(ResultModel.class).createDeserializer();
		StringWriter writer = new StringWriter();
		StringReader reader = new StringReader(writer.toString());
		deserializer.open(reader);
		while (deserializer.hasNext()) {
			ResultModel p = deserializer.next();
		  
		}
		deserializer.close(true);
	}

}
