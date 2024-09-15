package Hotel;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("serial")
public class Hotel implements Serializable {
	private String hotelName;
	private Address address;
	private int phoneNumber;
	private ListRoom listRooms;
	private ListGuest listGuest;
	private ListOrder listOrder;

	public Hotel() {
		this.listOrder = new ListOrder();
		this.listRooms = new ListRoom();
		this.listGuest = new ListGuest(listOrder);
	}

	public Hotel(String hotelName, Address address, int phoneNumber) {
		super();
		setHotelName(hotelName);
		setAddress(address);
		setAddress(address);
	}

	public int addOrder(Guest guest, int numDays) throws Exception {
		if (listGuest.searchById(guest.getPerson().getId()).get() != null)
			listGuest.addGuest(guest);
		Room r = null;
		if (guest instanceof BuissnesGuest g)
			r = listRooms.searchByLevel(level.HIGH_LEVEL).get();
		else if (guest.getPerson().getAge() > 60)
			r = listRooms.searchByFloor(1).get();
		else
			r = listRooms.returnTheFirstAvailableRoom().get();
		if (r == null)
			throw new Exception("All rooms are full.");
		Order order = new Order(guest, r, LocalDate.now(), numDays);
		listOrder.addOrder(order);
		return order.getNumOrder();

	}

	public boolean addOrder(Guest guest, int numDays, Room room) throws Exception {
		if (listGuest.searchById(guest.getPerson().getId()).get() != null)
			listGuest.addGuest(guest);
		Room r = room;
		return listOrder.addOrder(new Order(guest, r, LocalDate.now(), numDays));
	}

	public boolean deleteOrder(Guest guest) {
		return listOrder.deleteOrderByGuest(guest);
	}

	public List<Room> searchAllRooms() {
		return listRooms.searchAllRooms();
	}

	public List<Room> searchAllAvailibleRooms() {
		return listRooms.searchAllAvailibaleRooms();
	}

	public Optional<Room> searchRoom(level level) {
		return listRooms.searchByLevel(level);
	}

	public Optional<Room> searchRoom(int floor) {
		return listRooms.searchByFloor(floor);
	}

	@Override
	public String toString() {
		return "Hotel: " + hotelName + ", address: " + address + ", phone Number: " + phoneNumber;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public ListRoom getListRooms() {
		return listRooms;
	}

	public void setListRooms(ListRoom listRooms) {
		this.listRooms = listRooms;
	}

	public ListGuest getListGuest() {
		return listGuest;
	}

	public void setListGuest(ListGuest listGuest) {
		this.listGuest = listGuest;
	}

	public ListOrder getListOrder() {
		return listOrder;
	}

	public void setListOrder(ListOrder listOrder) {
		this.listOrder = listOrder;
	}
}
