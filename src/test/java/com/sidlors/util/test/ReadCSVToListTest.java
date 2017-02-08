package com.sidlors.util.test;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.sidlors.util.ReadCSVToList;

public class ReadCSVToListTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		ArrayList<String> list=ReadCSVToList.crunchifyCSVtoArrayList(new File("fileName.txt"));
		
		for (String string : list) {
			System.out.println(string);
		}
	}

}
