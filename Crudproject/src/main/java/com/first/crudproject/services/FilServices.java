package com.first.crudproject.services;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


public interface FilServices {
	String  uploadFile(String path, MultipartFile file) throws IOException;
	
	InputStream getResouces(String path, String filename);

}
