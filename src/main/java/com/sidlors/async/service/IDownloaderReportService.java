package com.sidlors.async.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.sidlors.model.ResultModel;

public interface IDownloaderReportService {



	public abstract List<ResultModel> getListModel(File file)throws IOException;
}