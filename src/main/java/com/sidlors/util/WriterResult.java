package com.sidlors.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import com.sidlors.model.ResultModel;

public class WriterResult {

	private WriterResult() {
	}

	public static void writeFile(List<ResultModel> resultados, String file) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(file + ".csv", true));
//		for (Method metodo : resultados.get(0).getClass().getDeclaredMethods()) {
//			bw.write(metodo.getName().replace("get", "") + ",");
//		}
//		bw.write("\n");
		for (ResultModel result : resultados) {
			bw.write(result.toString());
		}
		bw.close();
	}

}
