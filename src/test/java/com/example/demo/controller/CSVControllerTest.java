package com.example.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.CSVService;

import org.springframework.mock.web.MockMultipartFile;


public class CSVControllerTest {
	
	CSVController csvController;
	
	@Before
	public void Setup() {
		csvController = new CSVController(new CSVService());
	}
	
	@Test
	public void testUploadCSV() throws Exception {
		MultipartFile file = new MockMultipartFile("test.csv", new FileInputStream(new File("src/test/java/com/example/demo/service/test.csv")));
		ResponseEntity<?> response = csvController.uploadCSV(file);
		assertEquals(response.getStatusCode(),HttpStatus.OK);
	}

}
