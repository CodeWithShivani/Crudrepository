package com.first.crudproject.services;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.first.crudproject.Repsitory.ImageRepository;
import com.first.crudproject.entities.ImageModel;

import jakarta.persistence.criteria.Path;

@Service
public class ImageService {
	
	@Value("${file.upload-dir}")
	private String uploadDir; 
	private final ImageRepository imagerespository;
	
	public ImageService(ImageRepository imagerespository)
	{
		this.imagerespository=imagerespository;
	}
	
	public ImageModel saveImage(String name,MultipartFile file) throws IOException{
		String filename=System.currentTimeMillis()+"-" +file.getOriginalFilename();
		java.nio.file.Path path= Paths.get(uploadDir+File.separator+filename);

		Files.createDirectories(path.getParent()); // Ensure directory exists
        Files.write(path, file.getBytes());
        
        System.out.println("Image saved at: " + path.toAbsolutePath());
		 
		 
		 ImageModel image = new ImageModel();
	        image.setPath(filename);
	        image.setName(name);
	        return imagerespository.save(image);
		
	}
	
	
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
