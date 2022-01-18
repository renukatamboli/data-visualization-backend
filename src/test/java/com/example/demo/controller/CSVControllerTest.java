package com.example.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.io.File;
import java.io.FileInputStream;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.CSVService;

import org.springframework.mock.web.MockMultipartFile;

import java.nio.file.FileSystems;
import java.nio.file.Paths;

public class CSVControllerTest {

	@Autowired 
	CSVService csvService = new CSVService();
	
	@Autowired
	CSVController csvController = new CSVController(csvService);
	
	
	@Test
	public void testUploadCSV() throws Exception {
		MultipartFile file = new MockMultipartFile("test.csv", new FileInputStream(new File("D:/workspace/formcept/src/test/java/com/example/demo/controller/test.csv")));
		ResponseEntity<?> response = csvController.uploadCSV(file);
		assertEquals(response.getStatusCode(), 200);
	}

}
