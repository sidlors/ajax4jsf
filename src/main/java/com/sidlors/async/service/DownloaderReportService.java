package com.sidlors.async.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import com.sidlors.model.ResultModel;
import com.sidlors.util.ReadCSVToList;

public class DownloaderReportService implements IDownloaderReportService {

	@Override
	public List<ResultModel> getListModel(File file) throws IOException{
		List<ResultModel> deserializacion = ReadCSVToList.deserializacion(ResultModel.class,file);
		return deserializacion;
	}


}
