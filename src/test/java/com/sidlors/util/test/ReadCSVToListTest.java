package com.sidlors.util.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.sidlors.model.ResultModel;
import com.sidlors.util.ReadCSVToList;

public class ReadCSVToListTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() throws FileNotFoundException {
		List<ResultModel> list= ReadCSVToList.deserializacion(new File("fileName.csv"));
		System.out.println(list.size());
		for (ResultModel model : list) {
			System.out.println(model.getFid()+","
					+model.getRfc()+","
					+model.getAccountnumber()+","
					+model.getCompanyname()+","
					+model.getHitdate());
		}
	}

}
