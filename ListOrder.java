package Hotel;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;

public class ListOrder {
	private HashSet<Order> listOrder;

	public ListOrder() {
		listOrder = new HashSet<>();
	}

	public boolean addOrder(Order o) {
		boolean flag = listOrder.add(o);
		return flag;
	}

	public Optional<Order> searchOrderByGuestName(String guestName) {
		return listOrder.stream().filter(o -> o.getGuest().getPerson().getFirstName().equals(guestName)).findFirst();
	}

	public Optional<Order> searchOrderByGuest(Guest guest) {
		return listOrder.stream().filter(o -> o.getGuest().equals(guest)).findAny();
	}

	public Optional<Order> searchOrderByRoomNumber(int numRoom) {
		return listOrder.stream().filter(o -> o.getRoom().getNumRoom() == numRoom).findAny();
	}

	public Optional<Order> searchOrderByRoom(Room room) {
		return listOrder.stream().filter(o -> o.getRoom().equals(room)).findAny();
	}

	public boolean deleteOrderByGuest(Guest guest) {
		Optional<Order> i = listOrder.stream().filter(o -> o.getGuest().equals(guest)).findAny();
		Room x = i.get().getRoom();
		x.setActive(true);
		return listOrder.remove(i.get());
	}

	public void deleteOrderByIDGuest(int id) {
		Optional<Order> i = listOrder.stream().filter(o -> o.getGuest().getPerson().getId() == id).findAny();
		Room x = i.get().getRoom();
		listOrder.remove(i.get());
		x.setActive(true);
	}

	public void printOrdersByGuest(Guest guest) {
		System.out.println(searchOrderByGuest(guest).get().toString());

	}

	public void printOrdersByRoom(Room room) {
		System.out.println(searchOrderByRoom(room).get());
	}

	public void printAll() {
//		System.out.println(listOrder.toString());
		listOrder.stream().forEach(System.out::println);
	}

	@Override
	public String toString() {
		String str = "";
		for (Order order : listOrder) {
			str += order.toString() + "\n";
		}
		return str;
	}

	public void reportOrdersByNumDays(int numDays) {
		String FilePath = "report orders by sum days";
		reportManager.writeToReport(FilePath, listOrder.stream().filter(o -> o.getNumDays() == numDays).toList());
	}

	public void reportOrdersByDate(LocalDate date) {
		String FilePath = "report orders by date";
		reportManager.writeToReport(FilePath, listOrder.stream().filter(o -> o.getOrderDate().equals(date)).toList());
	}
}
