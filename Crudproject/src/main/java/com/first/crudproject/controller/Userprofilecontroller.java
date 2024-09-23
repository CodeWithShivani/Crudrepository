package com.first.crudproject.controller;

import java.io.IOException;
import java.io.InputStream;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.first.crudproject.Repsitory.ImageRepository;
import com.first.crudproject.Repsitory.UserRepository;
import com.first.crudproject.entities.FileResponse;
import com.first.crudproject.entities.ImageModel;
import com.first.crudproject.entities.User;
import com.first.crudproject.services.ImageService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("api/user")
public class Userprofilecontroller {
	@Value("${file.upload-dir}")
	private String path;
	
	@Autowired
	ImageRepository userrepository;
	
	@Autowired
	ImageService imageService;

	@PostMapping("/upload")
	public ResponseEntity<String> uploaduserprofile(@RequestParam("username") String username,
			@RequestParam("pimage") MultipartFile file)
	{
		try {
//			ImageModel user =new ImageModel(username,file.getBytes());
			ImageModel image = imageService.saveImage(username,file);
//			userrepository.save(user);
			return new ResponseEntity<>("Successfully saved!!",HttpStatus.OK);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>("Something went wrong!!",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/list")
	
	public java.util.List<ImageModel> getAllProfiles()
	{
		return userrepository.findAll();	}
	
	
	//method to serve files
	
	@GetMapping(value="/images/{imageName}", produces=MediaType.IMAGE_JPEG_VALUE)
	public void downloadimage(@PathVariable("imageName") String imageName,
			HttpServletResponse response )
	{
		InputStream resource =this.imageService.getResouces(path, imageName);
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		try {
			StreamUtils.copy(resource, response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
	}

}
