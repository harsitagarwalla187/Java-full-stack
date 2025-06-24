package com.example.Hotel;

import com.example.Hotel.entity.HotelBooking;
import com.example.Hotel.service.HotelBookingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class HotelRoomBookingManagementSystemApplication {

	public static void main(String[] args) {

		ApplicationContext context = (AnnotationConfigApplicationContext) SpringApplication.run(HotelRoomBookingManagementSystemApplication.class, args);
		HotelBookingService service = context.getBean(HotelBookingService.class);

		Scanner scan = new Scanner(System.in);
		boolean flag = true;

		System.out.println("Application started.");

		do {
			System.out.println("1. Add a new service room booking.");
			System.out.println("2. View all service room bookings.");
			System.out.println("3. Find all bookings by room type.");
			System.out.println("4. Find bookings by customer name.");
			System.out.println("5. Find bookings where customer name starts with a specific letter.");
			System.out.println("6. Count bookings made in a specific city.");
			System.out.println("7. Delete a booking by ID.");
			System.out.println("8. Exit the application.");
			int option = scan.nextInt();
			scan.nextLine();

			switch (option) {
				case 1:
					HotelBooking room = new HotelBooking();
					System.out.print("Enter Customer Name: ");
					room.setName(scan.nextLine());
					System.out.print("Enter Room Type: ");
					room.setType(scan.nextLine());
					System.out.print("Enter Hotel City: ");
					room.setCity(scan.nextLine());
					service.bookRoom(room);
					break;

				case 2:
					System.out.println("All bookings:");
					List<HotelBooking> allBookings = service.allBooking();
					for (HotelBooking booking : allBookings) {
						System.out.println(booking);
					}
					break;

				case 3:
					System.out.print("Enter Room Type to search: ");
					String type = scan.nextLine();
					List<HotelBooking> bookingsByType = service.findByType(type);
					for (HotelBooking booking : bookingsByType) {
						System.out.println(booking);
					}
					break;

				case 4:
					System.out.print("Enter Customer Name: ");
					String name = scan.nextLine();
					HotelBooking found = service.findByName(name);
					if (found != null) {
						System.out.println(found);
					} else {
						System.out.println("No booking found for this customer.");
					}
					break;

				case 5:
					System.out.print("Enter the starting letter(s) of customer name: ");
					char prefix = scan.nextLine().charAt(0);
					List<HotelBooking> startsWithList = service.findByNameStartsWith(prefix);
					if (!startsWithList.isEmpty()) {
						for (HotelBooking booking : startsWithList) {
							System.out.println(booking);
						}
					} else {
						System.out.println("No bookings found starting with " + prefix);
					}
					break;

				case 6:
					System.out.print("Enter the city name: ");
					String city = scan.nextLine();
					long count = service.countByCity(city);
					System.out.println("Total bookings in " + city + ": " + count);
					break;

				case 7:
					System.out.print("Enter the Booking ID to delete: ");
					Long id = scan.nextLong();
					scan.nextLine();
					service.deleteBookingById(id);
					System.out.println("Booking with ID " + id + " deleted (if it existed).");
					break;

				case 8:
					flag = false;
					break;

				default:
					System.out.println("Invalid option. Do you want to continue? (Y/N)");
					char ch = scan.nextLine().charAt(0);
					flag = (ch == 'Y' || ch == 'y');
			}
		} while(flag);

		System.out.println("Application closed.");
	}

}
