package com.first.crudproject.controller;

import java.net.http.HttpHeaders;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.first.crudproject.Repsitory.ImageRepository;
import com.first.crudproject.Repsitory.UserRepository;
import com.first.crudproject.entities.ImageModel;
import com.first.crudproject.entities.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("api/user")
public class ViewController {
	@Autowired
	private ImageRepository userrepository;
	
	@GetMapping("/view/{id}")
	public ResponseEntity<byte[]> viewuserprofile(@PathVariable Integer id)
	{
		Optional<ImageModel> useroptional=userrepository.findById(id);
		if(useroptional.isPresent())
		{
			ImageModel userprofilr=useroptional.get();
			return ResponseEntity.ok()
					.contentType(MediaType.IMAGE_JPEG)
					.header(org.springframework.http.HttpHeaders.CONTENT_DISPOSITION, 
							"inline; filename=\""+userprofilr.getName()+".jpg\"")
					.body(userprofilr.getImageData());
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
					
		}
	}
	

}
