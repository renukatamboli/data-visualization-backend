package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.CSVService;

@RestController
@RequestMapping("/")

public class CSVController {
	
	@Autowired
	CSVService csvService;
	


	public CSVController(CSVService csvService) {
		this.csvService = csvService;
	}
	
	
	@CrossOrigin
	@PostMapping("api/csv/upload")
	public ResponseEntity<?> uploadCSV(@RequestParam("file") MultipartFile file) {
		return new ResponseEntity<>(csvService.getCSVFileContent(file),HttpStatus.OK);
	}


}

