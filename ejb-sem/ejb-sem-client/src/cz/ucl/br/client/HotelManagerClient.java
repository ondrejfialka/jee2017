package cz.ucl.br.client;

import java.util.ArrayList;
import java.util.List;

import cz.ucl.jee.dto.HotelDTO;
import cz.ucl.jee.dto.RoomDTO;
import cz.ucl.jee.ejb.HotelManager;
import cz.ucl.jee.ejb.ReservationManager;

public class HotelManagerClient extends CommandLineClient {
	private BlueResortsLocator serviceLocator = new BlueResortsLocator();
	private HotelManager hotelManager;

	private void doMenu() throws Exception {

		hotelManager = serviceLocator.getHotelManager();

		ReservationManager reservationManager = serviceLocator
				.getReservationManager();
		String cityName = getInput("Enter a city to search for hotels");
		List<HotelDTO> hotelsInCity = reservationManager.findHotels(cityName);
		int chosenHotelIndex = getChoice("Select a hotel", hotelsInCity) - 1;
		hotelManager.selectHotel(hotelsInCity
				.get(chosenHotelIndex).getId());


		List<String> choices = new ArrayList<String>();
		choices.add("Create a new room");
		choices.add("Select a room");
		choices.add("Exit");

		while (true) {
			switch (getChoice("Select an option: ", choices)) {
			case 1:
				doAddRoom();
				break;
			case 2:
			//	doSelectRoom(hotel);
				break;
			case 3:				
				// transaction.rollback();
		//		transaction.commit();
				doExit();
				break;
			}
		}
	}

	/*private void doSelectRoom(Hotel hotel) {
		List<Room> allRooms = new ArrayList<Room>(hotel.getRooms());
		int chosenRoomIndex = getChoice("Select a room: ", allRooms) - 1;
		Room chosenRoom = allRooms.get(chosenRoomIndex);

		List<String> choices = new ArrayList<String>();
		choices.add("Change a room");
		choices.add("Remove a room");
		choices.add("Exit");

		switch (getChoice("Select an option: ", choices)) {
		case 1:
			doChangeRoom(chosenRoom);
			break;
		case 2:
			hotelManager.removeRoom(chosenRoom);
			hotel.getRooms().remove(chosenRoom);
			break;
		case 3:
			break;
		}

	}*/

	/*private void doChangeRoom(Room room) {
		room.setBeds(Integer
				.parseInt(getInput("Enter room capacity (bed count) [was "
						+ room.getBeds() + "]")));
		room.setDescription(getInput("Enter room description [was '"
				+ room.getDescription() + "']"));
		room.setFloor(Integer.parseInt(getInput("Enter floor [was "
				+ room.getFloor() + "]")));
		room.setNumber(getInput("Enter room number [was " + room.getNumber()
				+ "]"));
		hotelManager.changeRoom(room);

	}*/

	private void doExit() {
		hotelManager.closeHotel();
		System.exit(0);
	}

	private void doAddRoom() {
		RoomDTO room = new RoomDTO();
		room.setBeds(Integer
				.parseInt(getInput("Enter room capacity (bed count)")));
		room.setDescription(getInput("Enter room description"));
		room.setFloor(Integer.parseInt(getInput("Enter floor")));
		room.setNumber(getInput("Enter room number"));
		hotelManager.addRoom(room);

	}

	/**
	 * @param args
	 * @throws SystemException
	 * @throws NotSupportedException
	 * @throws HeuristicRollbackException
	 * @throws HeuristicMixedException
	 * @throws RollbackException
	 * @throws IllegalStateException
	 * @throws SecurityException
	 */
	public static void main(String[] args) throws Exception {
			
		(new HotelManagerClient()).doMenu();

	}

}
