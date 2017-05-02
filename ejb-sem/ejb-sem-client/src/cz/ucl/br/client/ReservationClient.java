package cz.ucl.br.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cz.ucl.jee.ejb.NoCancellationException;
import cz.ucl.jee.ejb.NoRoomAvailableException;
import cz.ucl.jee.ejb.ReservationManager;

public class ReservationClient extends CommandLineClient {
	private BlueResortsLocator serviceLocator = new BlueResortsLocator();

	private void doMenu() {
		List<String> choices = new ArrayList<String>();
		choices.add("Find hotels");
		choices.add("Create a reservation");
		choices.add("Cancel a reservation");
		choices.add("Exit");

		while (true) {
			switch (getChoice("Select an option: ", choices)) {
			case 1:
				doFindHotels();
				break;
			case 2:
				doCreateReservation();
				break;
			case 3:
				doCancelReservation();
				break;
			case 4:
				System.exit(0);
			}
		}

	}

	private void doFindHotels() {
		System.out.println("Find hotels");
		System.out.println("-----------");

		String cityName = getInput("Enter a city to search for hotels");

		ReservationManager manager = serviceLocator.getReservationManager();
//		List<Hotel> hotels = manager.findHotels(cityName);
//
//		System.out.println("Hotels in " + cityName + ": ");
//		for (Hotel h : hotels) {
//			System.out.println(" - " + h);
//		}
	}

	private void doCreateReservation() {
		System.out.println("Create a reservation");
		System.out.println("--------------------");

		ReservationManager manager = serviceLocator.getReservationManager();

		String hotelName = getInput("Enter hotel name");
		String customerName = getInput("Enter customer's name");
		int beds = Integer
				.parseInt(getInput("Enter the number of beds requested"));
		Date fromDay = getDateInput("Enter the arrival date");
		Date toDay = getDateInput("Enter the departure date");

		try {
			String reservationCode = manager.createReservation(hotelName,
					customerName, beds, fromDay, toDay);
			System.out.println("Reservation code: " + reservationCode);
		} catch (NoRoomAvailableException e) {
			System.out
					.println("ERROR: No rooms are available for selected period");
		}

	}

	private void doCancelReservation() {
		System.out.println("Cancel reservation");
		System.out.println("------------------");
		String reservationCode = getInput("Enter a reservation code");

		ReservationManager manager = serviceLocator.getReservationManager();
		try {
			manager.cancelReservation(reservationCode);
			System.out.println("Reservation cancelled successfully");
		} catch (NoCancellationException e) {
			System.out.println("Error while cancelling: " + e.getReason());
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		(new ReservationClient()).doMenu();
	}
}
