package com.sidlors.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.sidlors.model.ResultModel;



public class WriterResult {
	
	private WriterResult() {
	}
	
	public static void writeFile(List<ResultModel> resultados, String file) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(file + ".txt",true));
		for (ResultModel result : resultados) {
			bw.write(result.toString());
		}
		bw.close();
	}

}
