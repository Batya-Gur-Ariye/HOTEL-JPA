package Hotel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;

public class ListRoom {
	private HashMap<Integer, Room> listRooms;

	public ListRoom() {
		listRooms = new HashMap<Integer, Room>();
	}

	public boolean addRoom(Room room) {
		listRooms.put(room.getNumRoom(), room);
		return true;
	}

	public Optional<Room> searchByNumRoom(int numRoom) {
		for (Entry<Integer, Room> entry : listRooms.entrySet()) {
			Room val = entry.getValue();
			if (val.getNumRoom() == numRoom) {
				return Optional.of(val);
			}
		}
		return Optional.empty();
	}

	public Optional<Room> printByNumRoom(int numRoom) {
		return Optional.of(searchByNumRoom(numRoom).get());
	}

	public Optional<Room> returnTheFirstAvailableRoom() {
		for (int i = 0; i < listRooms.size(); i++) {
			if (listRooms.get(i).isActive())
				return Optional.of(listRooms.get(i));
		}
		return Optional.empty();
	}

	public List<Room> searchAllAvailibaleRooms() {
		List<Room> arrayRoom = new ArrayList<Room>();
		for (int i = 0; i < listRooms.size(); i++) {
			if (listRooms.get(i).isActive())
				arrayRoom.add(listRooms.get(i));
		}
		return arrayRoom;
	}

	public List<Room> searchAllRooms() {
		List<Room> arrayRoom = new ArrayList<Room>();
		for (int i = 0; i < listRooms.size(); i++) {
			arrayRoom.add(listRooms.get(i));
		}
		return arrayRoom;
	}

	public Optional<Room> searchByLevel(level level) {
		for (int i = 0; i < listRooms.size(); i++) {
			if (listRooms.get(i).getLevel().equals(level)) {
				return Optional.of(listRooms.get(i));
			}
		}
		return Optional.empty();
	}

	public Optional<Room> searchByFloor(int floor) {
		for (int i = 0; i < listRooms.size(); i++) {
			if (listRooms.get(i).getFloor() == floor) {
				return Optional.of(listRooms.get(i));
			}
		}
		return Optional.empty();
	}

	@Override
	public String toString() {
		String str = "";
		str += "List Rooms: \n";
		for (int i = 0; i < listRooms.size(); i++) {
			str += listRooms.get(i).toString() + "\n";
		}
		return str;

	}

	public void reportAvailableRooms() {
		String FilePath = "report Available Rooms";
		reportManager.writeToReport(FilePath, searchAllAvailibaleRooms());
	}

	public void reportNotAvailableRooms() {
		String FilePath = "report not Available Rooms";
		List<Room> arrayRoom = new ArrayList<Room>();
		for (int i = 0; i < listRooms.size(); i++) {
			if (!listRooms.get(i).isActive())
				arrayRoom.add(listRooms.get(i));
		}
		reportManager.writeToReport(FilePath, arrayRoom);
	}

}
