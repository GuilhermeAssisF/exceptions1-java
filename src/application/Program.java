package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.US);

        System.out.print("Room number: ");
        int roomNumber = sc.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkInDate = sdf.parse(sc.next());
        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date checkOutDate = sdf.parse(sc.next());

        if (checkInDate.before(checkOutDate)) {
            Reservation res = new Reservation(roomNumber, checkInDate, checkOutDate);
            System.out.println("Reservation: " + res);

            System.out.println("\nEnter data to update the reservation: ");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkInDate = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOutDate = sdf.parse(sc.next());

            String error = res.updatesDates(checkInDate, checkOutDate);
            if (error != null) {
                System.out.println("Error in reservation: " + error);
            }
            System.out.println("Reservation: " + res);
        }
        sc.close();

    }
}