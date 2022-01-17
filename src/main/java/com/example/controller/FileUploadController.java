package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class FileUploadController {
	
	@GetMapping("fileupload")
	public String extractFile() {
		System.out.print("hi");
		return "hi";
	}


}
