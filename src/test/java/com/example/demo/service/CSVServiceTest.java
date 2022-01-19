package com.example.demo.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.controller.CSVController;

public class CSVServiceTest {
	
	List expectedContent; 
	CSVService csvService;
	
	@Before
	public void Setup() {
		csvService = new CSVService();
		expectedContent = new ArrayList();
		Map data1 = new HashMap();
		data1.put("colB", "293");
		data1.put("colA", "2");
		Map data2 = new HashMap();
		data2.put("colB", "293");
		data2.put("colA", "3");
		expectedContent.add(data1);
		expectedContent.add(data2);
	}
	@Test
	public void testGetCSVFileContent() throws FileNotFoundException, IOException {
		MultipartFile file = new MockMultipartFile("test.csv", new FileInputStream(new File("src/test/java/com/example/demo/service/test.csv")));
		List<Map> actualContent = csvService.getCSVFileContent(file);
		assertEquals(expectedContent,actualContent);
	}

	@Test(expected = IOException.class)
	public void testExceptionthrow() throws FileNotFoundException, IOException{
		MultipartFile file = new MockMultipartFile("test.csv", new FileInputStream(new File("src/test/java/com/example/demo/service/test2.csv")));
		csvService.getCSVFileContent(file);
	}
}
