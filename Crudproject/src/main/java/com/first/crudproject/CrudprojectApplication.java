package com.first.crudproject;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.first.crudproject.Repsitory.UserRepository;
import com.first.crudproject.entities.User;




@SpringBootApplication
public class CrudprojectApplication {

	public static void main(String[] args) {
	ApplicationContext  context=  SpringApplication.run(CrudprojectApplication.class, args);
		
		
		UserRepository userreso= context.getBean(UserRepository.class);
		
		//Create user object
//		User user1=new User();
//		user1.setName("Vish");
//		user1.setCity("Noida");
//		user1.setStatus("HR");
//		
//		User user2=new User();
//		user2.setName("Sam");
//		user2.setCity("Delhi");
//		user2.setStatus("Admin");
//	
		
//		for Singal save
//		User user1=userreso.save(user);
		
//		for Multiple user save
//		List<User> users=List.of(user1,user2);
//		Iterable<User> resultuser=userreso.saveAll(users);
//		
//		resultuser.forEach(user->
//		{
//			System.out.println(user);
//		});
		
		
		//update the user
//		Optional<User> optional= userreso.findById(6);
//		User user=optional.get();
//		user.setName("sam Chaudhary");
//		User result=userreso.save(user);
//		System.out.println(result);
		
		
		//get the user
//		Iterable <User> itr =userreso.findAll();
//		itr.forEach(user->{
//			});
		
		
		//delete the singal user
//		userreso.deleteById(6);
		
		//delete the all user
//		Iterable <User> itr =userreso.findAll();
//		userreso.deleteAll(itr);
		

		
	}

}
