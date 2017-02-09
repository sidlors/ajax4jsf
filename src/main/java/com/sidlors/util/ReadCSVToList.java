package com.sidlors.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;

import com.sidlors.model.ResultModel;

import net.sf.jsefa.Deserializer;
import net.sf.jsefa.csv.CsvIOFactoryImpl;
import net.sf.jsefa.csv.config.CsvConfiguration;

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
	
	public static List<ResultModel> deserializacion(File file) throws FileNotFoundException{
		CsvConfiguration cof=new CsvConfiguration();
		cof.setFieldDelimiter(',');
		Deserializer deserializer = CsvIOFactoryImpl.createFactory(cof,ResultModel.class).createDeserializer();
		List<ResultModel> lista=new ArrayList<ResultModel>();
		Reader reader = createFileReader(file);
		deserializer.open(reader);
		while (deserializer.hasNext()) {
			lista.add((ResultModel)deserializer.next());
		}
		deserializer.close(true);
		return lista;
	}
	
	
	private static Reader createFileReader(File file) throws FileNotFoundException {
		if(!file.exists())
			throw new FileNotFoundException();
		
        return new FileReader(file);
    }

	public static List<ResultModel>  deserializacion(Class<ResultModel> class1, File file) throws FileNotFoundException {
		CsvConfiguration cof=new CsvConfiguration();
		cof.setFieldDelimiter(',');
		Deserializer deserializer = CsvIOFactoryImpl.createFactory(cof,class1).createDeserializer();
		List<ResultModel> lista=new ArrayList<ResultModel>();
		Reader reader = createFileReader(file);
		deserializer.open(reader);
		while (deserializer.hasNext()) {
			lista.add((ResultModel)deserializer.next());
		}
		deserializer.close(true);
		return lista;
	}

}
