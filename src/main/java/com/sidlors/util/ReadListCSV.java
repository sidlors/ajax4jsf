package com.sidlors.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.sidlors.model.ResultModel;

import net.sf.jsefa.Serializer;
import net.sf.jsefa.csv.CsvIOFactoryImpl;
import net.sf.jsefa.csv.config.CsvConfiguration;

public class ReadListCSV {
	private ReadListCSV() {

	}
	
	

	public static File serializeModel(Class<ResultModel> clazz, List<ResultModel> list, File file) throws IOException {

		CsvConfiguration cof=new CsvConfiguration();
		cof.setFieldDelimiter(',');
		Serializer serializer = CsvIOFactoryImpl.createFactory(cof,clazz).createSerializer();
		FileWriter writer=new FileWriter(file);
		for (ResultModel resultModel : list) {
			writer.write(resultModel.getFieldchanges());
		}

		serializer.open(writer);
		
		serializer.close(true);
		
		return file;
		
	}
	
}
