package com.pratham.springBootDatabase;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.pratham.springBootDatabase.model.Student;

@SpringBootApplication
public class SpringBootDatabaseApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringBootDatabaseApplication.class, args);

		StudentRepo studentRepo = context.getBean(StudentRepo.class);

		System.out.println("\033[H\033[2J");

		// Simple crud operations

		System.out.println("\n" + studentRepo.addStudent(new Student(103, 22, "Vivek")) + " Record Added");
		System.out.println("\n-- Added Record:-\n" + studentRepo.getStudentById(103).toString());
		System.out.println("\n-- Initial Records:-\n" + studentRepo.getStudents().toString());

		System.out.println("\n" + studentRepo.updateStudent(new Student(99, 99, "abc")) + " Record Updated");
		System.out.println("\n-- Initial Records:-\n" + studentRepo.getStudents().toString());

		System.out.println("\n" + studentRepo.deleteStudent(99) + " Record Deleted");
		System.out.println("\n-- Initial Records:-\n" + studentRepo.getStudents().toString());

		System.out.println("\n\nClick Any Key To Continue");

		// Console based menu driven

		try {
			Scanner in = new Scanner(System.in);
			in.nextLine();

			int choice = 99;

			while (choice > 0) {

				System.out.println("\033[H\033[2J");
				System.out.println("---------------------------------------");
				System.out.println("Menu Driven Program");
				System.out.println("---------------------------------------");
				System.out.println("1. Read");
				System.out.println("2. Add");
				System.out.println("3. Update");
				System.out.println("4. Delete");
				System.out.println("Press 0 to exit");
				System.out.println("---------------------------------------");
				System.out.println("Please Enter Your Choice: ");

				try {
					choice = in.nextInt();
				} catch (Exception e) {
					choice = 99;
				}

				System.out.println("\033[H\033[2J");

				switch (choice) {

					case 1:
						System.out.println("\n-- Initial Records:-\n" + studentRepo.getStudents().toString());
						in.nextLine();
						break;

					case 2:
						try {
							System.out.print("Enter Id: ");
							int id = in.nextInt();
							System.out.print("Enter Name: ");
							String name = in.next();
							System.out.print("Enter Age: ");
							int age = in.nextInt();
							System.out.println("\n" + studentRepo.addStudent(
									new Student(id, age, name)) + " Record Added");
							in.nextLine();
						} catch (Exception e) {
							System.out.println("\nNO Record Added \nPlease Enter correct details");
							in.nextLine();
						}
						break;

					case 3:
						try {
							System.out.print("Enter id you wish to update: ");
							int id = in.nextInt();
							System.out.print("Enter Name: ");
							String name = in.next();
							System.out.print("Enter Age: ");
							int age = in.nextInt();
							System.out.println(
									"\n" + studentRepo.updateStudent(new Student(id, age, name)) + " Record Updated");
							in.nextLine();
						} catch (Exception e) {
							System.out.println("\nNO Record Added \nPlease Enter correct details");
							in.nextLine();
						}
						break;

					case 4:
						try {
							System.out.print("Enter id you wish to delete: ");
							int id = in.nextInt();
							System.out.println("\n" + studentRepo.deleteStudent(id) + " Record Deleted");
							in.nextLine();
						} catch (Exception e) {
							System.out.println("\nNO Record Added \nPlease Enter correct details");
							in.nextLine();
						}
						break;

					case 0:
						choice = 0;
						break;

					default:
						System.out.println("Enter Correct Choice");
						choice = 99;
						in.nextLine();

				}

				in.nextLine();
			}

			in.close();

		} catch (Exception e) {
			System.out.println("Exception occured: " + e);
		}
	}

}
