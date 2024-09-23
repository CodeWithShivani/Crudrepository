package com.first.crudproject.controller;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.first.crudproject.entities.FileResponse;
import com.first.crudproject.services.FilServices;

import jakarta.servlet.http.HttpSession;


@RestController
@RequestMapping("/files")
public class FileController {
	@Autowired
	private FilServices fileservices;
	
	@Value("${project.image}")
	private String path;
	@PostMapping("/uploads")
	public ResponseEntity<FileResponse> fileupload(@RequestParam ("images") MultipartFile image)
	{
		String filename;
		try {
			filename = this.fileservices.uploadFile(path, image);
			return new ResponseEntity<>(new FileResponse(filename,"Successfully saved!!"),HttpStatus.OK);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(new FileResponse(null,"Not Saved"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}

}
