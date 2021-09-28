package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservations;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("ROOM NUMBER: ");
		Integer roomNumber = sc.nextInt();
		System.out.println("CHECK-IN DATE (dd/MM/yyyy): ");
		Date checkInDate = sdf.parse(sc.next());
		System.out.println("CHECK-OUT DATE (dd/MM/yyyy): ");
		Date checkOutDate = sdf.parse(sc.next());
		
		if(!checkOutDate.after(checkInDate)) {
			System.out.println("ERROR: Check-out date must be after Check-in date");
		}
		else {
			Reservations reservation = new Reservations(roomNumber.toString(), checkInDate, checkOutDate);
			System.out.println(reservation + "\n");
			
			System.out.println("Do you need to change the reservation dates?(Y/N)");
			char choice = sc.next().charAt(0);
			
			if(choice == 'Y') {
				System.out.println();
				System.out.println("ENTER THE NEW DATES");
				System.out.println("CHECK-IN DATE (dd/MM/yyyy): ");
				checkInDate = sdf.parse(sc.next());
				System.out.println("CHECK-OUT DATE (dd/MM/yyyy): ");
				checkOutDate = sdf.parse(sc.next());
				
			
					String error = reservation.updateDates(checkInDate, checkOutDate);
					if(error != null) {
						System.out.println(error);
					}
					else {
						System.out.println(reservation + "\n");
						System.out.println("OK your check-in date is in : " + (reservation.daysToTrip()) 
						+ " days, See ya!!!");
					}
			}
			else {
				System.out.println("OK your check-in date is in : " + reservation.daysToTrip() 
				+ " days, See ya!!!");
			}
		}
				
		sc.close();
	}

}
