package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		 ApplicationContext context = (AnnotationConfigApplicationContext) SpringApplication.run(DemoApplication.class, args);
		UserService us = context.getBean(UserService.class);

		Scanner scan = new Scanner(System.in);
		boolean flag = true;


		do {
			System.out.println("1. Add New User");
			System.out.println("2. Delete User");
			System.out.println("3. Show All User");
			System.out.println("4. Exit");
			int option = scan.nextInt();
			scan.nextLine();

			switch (option) {
				case 1:
					System.out.println("Enter new user details...");
					System.out.print("Enter user name: ");
					User user = new User();
					user.setName(scan.nextLine());
					us.addUser(user);
					break;
				case 2:
					System.out.println("Delete user...");
					System.out.print("Enter User ID: ");
					us.deleteUser(scan.nextLong());
					break;
				case 3:
					System.out.println("All users...");
					List<User> users = us.findAll();
					for(User u:users) {
						System.out.println(u);
					}
					break;
				case 4:
					flag = false;
					break;
				default:
					System.out.println("Do you want to continue?(Y/N)");
					char ch = scan.nextLine().charAt(0);
					flag = (ch == 'Y' || ch == 'y');
			}
		} while(flag);

		System.out.println("Application closed!");

	}

}
