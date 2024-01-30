package com.example.JPAdemo;

import com.example.JPAdemo.entity.User;
import com.example.JPAdemo.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class JpAdemoApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(JpAdemoApplication.class, args);
		UserRepository userRepository= context.getBean(UserRepository.class);
/*Insert operation*/
//		User user=new User();
//		user.setName("Vaibhav");
//		user.setCity("Nagpur");
//		user.setStatus("I am java programmer");
//
//		User user1 = userRepository.save(user);
//
//		System.out.println(user1);
//
//		User user2=new User();
//		user2.setName("Chetan");
//		user2.setCity("Yavatmal");
//		user2.setStatus("I am c# .Net programmer");
//
//		User user3=new User();
//		user3.setName("Kuldeep");
//		user3.setCity("Kolharur");
//		user3.setStatus("I am Python programmer");
//
//		User user4=new User();
//		user4.setName("Omkar");
//		user4.setCity("Pune");
//		user4.setStatus("I am react programmer");
//
//		List<User> userList = new ArrayList<>();
//		userList.add(user2);
//		userList.add(user3);
//		userList.add(user4);
//
//		Iterable<User> result =userRepository.saveAll(userList);
//		result.forEach(u->{
//			System.out.println(u);
//		});
		/*Update operation*/
		Optional<User> optional = userRepository.findById(4);
		User user= optional.get();
		user.setName("Kuldeep");
		User result = userRepository.save(user);
		System.out.println(result);
		/*Delete operation*/
		//userRepository.deleteById(5);
	}

}