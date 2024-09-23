package com.first.crudproject.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service

public class FileServiceImple implements FilServices{

	@Override
	public String uploadFile(String path, MultipartFile file) throws IOException {
		// TODO Auto-generated method stub
		
		//filename
		
		String filename=file.getOriginalFilename();
		
		//fullPath
		
		String filepath=path+File.separator+filename;
		
		//Craete folder if it is not craete
		
		File file1=new File(path);
		if(!file1.exists())
		{
			file1.mkdir();
		}
		
		//file copy
		Files.copy(file.getInputStream(), Paths.get(filepath));
		return filename;
		
	}

	@Override
	public InputStream getResouces(String path, String filename) {
		// TODO Auto-generated method stub
		String fullpath= path+File.separator+filename;
		InputStream inputstream = null;
		try {
			inputstream = new FileInputStream(fullpath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return inputstream;
	}

}
